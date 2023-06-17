/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.GameSettings;
import net.minecraft.src.ImageBuffer;
import net.minecraft.src.TextureFX;
import net.minecraft.src.TexturePackBase;
import net.minecraft.src.TexturePackList;
import net.minecraft.src.ThreadDownloadImageData;
import org.lwjgl.opengl.GL11;

public class RenderEngine {
    public static boolean useMipmaps = false;
    private HashMap textureMap = new HashMap();
    private HashMap textureNameToImageMap = new HashMap();
    private IntBuffer singleIntBuffer = GLAllocation.createDirectIntBuffer(1);
    private ByteBuffer imageData = GLAllocation.createDirectByteBuffer(0x100000);
    private List field_1604_f = new ArrayList();
    private Map urlToImageDataMap = new HashMap();
    private GameSettings options;
    private boolean clampTexture = false;
    private boolean blurTexture = false;
    private TexturePackList field_6527_k;

    public RenderEngine(TexturePackList texturepacklist, GameSettings gamesettings) {
        this.field_6527_k = texturepacklist;
        this.options = gamesettings;
    }

    public int getTexture(String s2) {
        TexturePackBase texturepackbase = this.field_6527_k.selectedTexturePack;
        Integer integer = (Integer)this.textureMap.get(s2);
        if (integer != null) {
            return integer;
        }
        try {
            this.singleIntBuffer.clear();
            GLAllocation.generateTextureNames(this.singleIntBuffer);
            int i2 = this.singleIntBuffer.get(0);
            if (s2.startsWith("##")) {
                this.setupTexture(this.unwrapImageByColumns(this.readTextureImage(texturepackbase.func_6481_a(s2.substring(2)))), i2);
            } else if (s2.startsWith("%clamp%")) {
                this.clampTexture = true;
                this.setupTexture(this.readTextureImage(texturepackbase.func_6481_a(s2.substring(7))), i2);
                this.clampTexture = false;
            } else if (s2.startsWith("%blur%")) {
                this.blurTexture = true;
                this.setupTexture(this.readTextureImage(texturepackbase.func_6481_a(s2.substring(6))), i2);
                this.blurTexture = false;
            } else {
                this.setupTexture(this.readTextureImage(texturepackbase.func_6481_a(s2)), i2);
            }
            this.textureMap.put(s2, i2);
            return i2;
        }
        catch (IOException ioexception) {
            throw new RuntimeException("!!");
        }
    }

    private BufferedImage unwrapImageByColumns(BufferedImage bufferedimage) {
        int i2 = bufferedimage.getWidth() / 16;
        BufferedImage bufferedimage1 = new BufferedImage(16, bufferedimage.getHeight() * i2, 2);
        Graphics g2 = bufferedimage1.getGraphics();
        for (int j2 = 0; j2 < i2; ++j2) {
            g2.drawImage(bufferedimage, -j2 * 16, j2 * bufferedimage.getHeight(), null);
        }
        g2.dispose();
        return bufferedimage1;
    }

    public int allocateAndSetupTexture(BufferedImage bufferedimage) {
        this.singleIntBuffer.clear();
        GLAllocation.generateTextureNames(this.singleIntBuffer);
        int i2 = this.singleIntBuffer.get(0);
        this.setupTexture(bufferedimage, i2);
        this.textureNameToImageMap.put(i2, bufferedimage);
        return i2;
    }

    public void setupTexture(BufferedImage bufferedimage, int i2) {
        GL11.glBindTexture(3553, i2);
        if (useMipmaps) {
            GL11.glTexParameteri(3553, 10241, 9987);
            GL11.glTexParameteri(3553, 10240, 9729);
        } else {
            GL11.glTexParameteri(3553, 10241, 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
        }
        if (this.blurTexture) {
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
        }
        if (this.clampTexture) {
            GL11.glTexParameteri(3553, 10242, 10496);
            GL11.glTexParameteri(3553, 10243, 10496);
        } else {
            GL11.glTexParameteri(3553, 10242, 10497);
            GL11.glTexParameteri(3553, 10243, 10497);
        }
        int j2 = bufferedimage.getWidth();
        int k2 = bufferedimage.getHeight();
        int[] ai2 = new int[j2 * k2];
        byte[] abyte0 = new byte[j2 * k2 * 4];
        bufferedimage.getRGB(0, 0, j2, k2, ai2, 0, j2);
        for (int l2 = 0; l2 < ai2.length; ++l2) {
            int j1 = ai2[l2] >> 24 & 0xFF;
            int l1 = ai2[l2] >> 16 & 0xFF;
            int j22 = ai2[l2] >> 8 & 0xFF;
            int l22 = ai2[l2] & 0xFF;
            if (this.options != null && this.options.anaglyph) {
                int j3 = (l1 * 30 + j22 * 59 + l22 * 11) / 100;
                int l3 = (l1 * 30 + j22 * 70) / 100;
                int j4 = (l1 * 30 + l22 * 70) / 100;
                l1 = j3;
                j22 = l3;
                l22 = j4;
            }
            abyte0[l2 * 4 + 0] = (byte)l1;
            abyte0[l2 * 4 + 1] = (byte)j22;
            abyte0[l2 * 4 + 2] = (byte)l22;
            abyte0[l2 * 4 + 3] = (byte)j1;
        }
        this.imageData.clear();
        this.imageData.put(abyte0);
        this.imageData.position(0).limit(abyte0.length);
        GL11.glTexImage2D(3553, 0, 6408, j2, k2, 0, 6408, 5121, this.imageData);
        if (useMipmaps) {
            for (int i1 = 1; i1 <= 4; ++i1) {
                int k1 = j2 >> i1 - 1;
                int i22 = j2 >> i1;
                int k22 = k2 >> i1;
                for (int i3 = 0; i3 < i22; ++i3) {
                    for (int k3 = 0; k3 < k22; ++k3) {
                        int i4 = this.imageData.getInt((i3 * 2 + 0 + (k3 * 2 + 0) * k1) * 4);
                        int k4 = this.imageData.getInt((i3 * 2 + 1 + (k3 * 2 + 0) * k1) * 4);
                        int l4 = this.imageData.getInt((i3 * 2 + 1 + (k3 * 2 + 1) * k1) * 4);
                        int i5 = this.imageData.getInt((i3 * 2 + 0 + (k3 * 2 + 1) * k1) * 4);
                        int j5 = this.weightedAverageColor(this.weightedAverageColor(i4, k4), this.weightedAverageColor(l4, i5));
                        this.imageData.putInt((i3 + k3 * i22) * 4, j5);
                    }
                }
                GL11.glTexImage2D(3553, i1, 6408, i22, k22, 0, 6408, 5121, this.imageData);
            }
        }
    }

    public void deleteTexture(int i2) {
        this.textureNameToImageMap.remove(i2);
        this.singleIntBuffer.clear();
        this.singleIntBuffer.put(i2);
        this.singleIntBuffer.flip();
        GL11.glDeleteTextures(this.singleIntBuffer);
    }

    public int getTextureForDownloadableImage(String s2, String s1) {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)this.urlToImageDataMap.get(s2);
        if (threaddownloadimagedata != null && threaddownloadimagedata.image != null && !threaddownloadimagedata.textureSetupComplete) {
            if (threaddownloadimagedata.textureName < 0) {
                threaddownloadimagedata.textureName = this.allocateAndSetupTexture(threaddownloadimagedata.image);
            } else {
                this.setupTexture(threaddownloadimagedata.image, threaddownloadimagedata.textureName);
            }
            threaddownloadimagedata.textureSetupComplete = true;
        }
        if (threaddownloadimagedata == null || threaddownloadimagedata.textureName < 0) {
            return this.getTexture(s1);
        }
        return threaddownloadimagedata.textureName;
    }

    public ThreadDownloadImageData obtainImageData(String s2, ImageBuffer imagebuffer) {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)this.urlToImageDataMap.get(s2);
        if (threaddownloadimagedata == null) {
            this.urlToImageDataMap.put(s2, new ThreadDownloadImageData(s2, imagebuffer));
        } else {
            ++threaddownloadimagedata.referenceCount;
        }
        return threaddownloadimagedata;
    }

    public void releaseImageData(String s2) {
        ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)this.urlToImageDataMap.get(s2);
        if (threaddownloadimagedata != null) {
            --threaddownloadimagedata.referenceCount;
            if (threaddownloadimagedata.referenceCount == 0) {
                if (threaddownloadimagedata.textureName >= 0) {
                    this.deleteTexture(threaddownloadimagedata.textureName);
                }
                this.urlToImageDataMap.remove(s2);
            }
        }
    }

    public void registerTextureFX(TextureFX texturefx) {
        this.field_1604_f.add(texturefx);
        texturefx.func_783_a();
    }

    public void func_1067_a() {
        for (int i2 = 0; i2 < this.field_1604_f.size(); ++i2) {
            TextureFX texturefx = (TextureFX)this.field_1604_f.get(i2);
            texturefx.field_1131_c = this.options.anaglyph;
            texturefx.func_783_a();
            this.imageData.clear();
            this.imageData.put(texturefx.field_1127_a);
            this.imageData.position(0).limit(texturefx.field_1127_a.length);
            texturefx.func_782_a(this);
            for (int k2 = 0; k2 < texturefx.field_1129_e; ++k2) {
                for (int i1 = 0; i1 < texturefx.field_1129_e; ++i1) {
                    GL11.glTexSubImage2D(3553, 0, texturefx.field_1126_b % 16 * 16 + k2 * 16, texturefx.field_1126_b / 16 * 16 + i1 * 16, 16, 16, 6408, 5121, this.imageData);
                    if (!useMipmaps) continue;
                    for (int k1 = 1; k1 <= 4; ++k1) {
                        int i22 = 16 >> k1 - 1;
                        int k22 = 16 >> k1;
                        for (int i3 = 0; i3 < k22; ++i3) {
                            for (int k3 = 0; k3 < k22; ++k3) {
                                int i4 = this.imageData.getInt((i3 * 2 + 0 + (k3 * 2 + 0) * i22) * 4);
                                int k4 = this.imageData.getInt((i3 * 2 + 1 + (k3 * 2 + 0) * i22) * 4);
                                int i5 = this.imageData.getInt((i3 * 2 + 1 + (k3 * 2 + 1) * i22) * 4);
                                int k5 = this.imageData.getInt((i3 * 2 + 0 + (k3 * 2 + 1) * i22) * 4);
                                int l5 = this.averageColor(this.averageColor(i4, k4), this.averageColor(i5, k5));
                                this.imageData.putInt((i3 + k3 * k22) * 4, l5);
                            }
                        }
                        GL11.glTexSubImage2D(3553, k1, texturefx.field_1126_b % 16 * k22, texturefx.field_1126_b / 16 * k22, k22, k22, 6408, 5121, this.imageData);
                    }
                }
            }
        }
        for (int j2 = 0; j2 < this.field_1604_f.size(); ++j2) {
            TextureFX texturefx1 = (TextureFX)this.field_1604_f.get(j2);
            if (texturefx1.field_1130_d <= 0) continue;
            this.imageData.clear();
            this.imageData.put(texturefx1.field_1127_a);
            this.imageData.position(0).limit(texturefx1.field_1127_a.length);
            GL11.glBindTexture(3553, texturefx1.field_1130_d);
            GL11.glTexSubImage2D(3553, 0, 0, 0, 16, 16, 6408, 5121, this.imageData);
            if (!useMipmaps) continue;
            for (int l2 = 1; l2 <= 4; ++l2) {
                int j1 = 16 >> l2 - 1;
                int l1 = 16 >> l2;
                for (int j22 = 0; j22 < l1; ++j22) {
                    for (int l22 = 0; l22 < l1; ++l22) {
                        int j3 = this.imageData.getInt((j22 * 2 + 0 + (l22 * 2 + 0) * j1) * 4);
                        int l3 = this.imageData.getInt((j22 * 2 + 1 + (l22 * 2 + 0) * j1) * 4);
                        int j4 = this.imageData.getInt((j22 * 2 + 1 + (l22 * 2 + 1) * j1) * 4);
                        int l4 = this.imageData.getInt((j22 * 2 + 0 + (l22 * 2 + 1) * j1) * 4);
                        int j5 = this.averageColor(this.averageColor(j3, l3), this.averageColor(j4, l4));
                        this.imageData.putInt((j22 + l22 * l1) * 4, j5);
                    }
                }
                GL11.glTexSubImage2D(3553, l2, 0, 0, l1, l1, 6408, 5121, this.imageData);
            }
        }
    }

    private int averageColor(int i2, int j2) {
        int k2 = (i2 & 0xFF000000) >> 24 & 0xFF;
        int l2 = (j2 & 0xFF000000) >> 24 & 0xFF;
        return (k2 + l2 >> 1 << 24) + ((i2 & 0xFEFEFE) + (j2 & 0xFEFEFE) >> 1);
    }

    private int weightedAverageColor(int i2, int j2) {
        int k2 = (i2 & 0xFF000000) >> 24 & 0xFF;
        int l2 = (j2 & 0xFF000000) >> 24 & 0xFF;
        int c2 = 255;
        if (k2 + l2 == 0) {
            k2 = 1;
            l2 = 1;
            c2 = 0;
        }
        int i1 = (i2 >> 16 & 0xFF) * k2;
        int j1 = (i2 >> 8 & 0xFF) * k2;
        int k1 = (i2 & 0xFF) * k2;
        int l1 = (j2 >> 16 & 0xFF) * l2;
        int i22 = (j2 >> 8 & 0xFF) * l2;
        int j22 = (j2 & 0xFF) * l2;
        int k22 = (i1 + l1) / (k2 + l2);
        int l22 = (j1 + i22) / (k2 + l2);
        int i3 = (k1 + j22) / (k2 + l2);
        return c2 << 24 | k22 << 16 | l22 << 8 | i3;
    }

    public void refreshTextures() {
        TexturePackBase texturepackbase = this.field_6527_k.selectedTexturePack;
        Iterator iterator = this.textureNameToImageMap.keySet().iterator();
        while (iterator.hasNext()) {
            int i2 = (Integer)iterator.next();
            BufferedImage bufferedimage = (BufferedImage)this.textureNameToImageMap.get(i2);
            this.setupTexture(bufferedimage, i2);
        }
        for (ThreadDownloadImageData threaddownloadimagedata : this.urlToImageDataMap.values()) {
            threaddownloadimagedata.textureSetupComplete = false;
        }
        for (String s2 : this.textureMap.keySet()) {
            try {
                BufferedImage bufferedimage1;
                if (s2.startsWith("##")) {
                    bufferedimage1 = this.unwrapImageByColumns(this.readTextureImage(texturepackbase.func_6481_a(s2.substring(2))));
                } else if (s2.startsWith("%clamp%")) {
                    this.clampTexture = true;
                    bufferedimage1 = this.readTextureImage(texturepackbase.func_6481_a(s2.substring(7)));
                } else if (s2.startsWith("%blur%")) {
                    this.blurTexture = true;
                    bufferedimage1 = this.readTextureImage(texturepackbase.func_6481_a(s2.substring(6)));
                } else {
                    bufferedimage1 = this.readTextureImage(texturepackbase.func_6481_a(s2));
                }
                int j2 = (Integer)this.textureMap.get(s2);
                this.setupTexture(bufferedimage1, j2);
                this.blurTexture = false;
                this.clampTexture = false;
            }
            catch (IOException ioexception) {
                ioexception.printStackTrace();
            }
        }
    }

    private BufferedImage readTextureImage(InputStream inputstream) throws IOException {
        BufferedImage bufferedimage = ImageIO.read(inputstream);
        inputstream.close();
        return bufferedimage;
    }

    public void bindTexture(int i2) {
        if (i2 < 0) {
            return;
        }
        GL11.glBindTexture(3553, i2);
    }
}

