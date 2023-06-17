/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.src.TexturePackBase;
import org.lwjgl.opengl.GL11;

public class TexturePackCustom
extends TexturePackBase {
    private ZipFile field_6496_e;
    private int texturePackName = -1;
    private BufferedImage field_6494_g;
    private File field_6493_h;

    public TexturePackCustom(File file) throws IOException {
        this.texturePackFileName = file.getName();
        this.field_6493_h = file;
    }

    private String func_6492_b(String s2) {
        if (s2 != null && s2.length() > 34) {
            s2 = s2.substring(0, 34);
        }
        return s2;
    }

    @Override
    public void func_6485_a(Minecraft minecraft) {
        ZipFile zipfile = null;
        InputStream inputstream = null;
        try {
            try {
                zipfile = new ZipFile(this.field_6493_h);
                try {
                    inputstream = zipfile.getInputStream(zipfile.getEntry("pack.txt"));
                    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
                    this.firstDescriptionLine = this.func_6492_b(bufferedreader.readLine());
                    this.secondDescriptionLine = this.func_6492_b(bufferedreader.readLine());
                    bufferedreader.close();
                    inputstream.close();
                }
                catch (Exception bufferedreader) {
                    // empty catch block
                }
                try {
                    inputstream = zipfile.getInputStream(zipfile.getEntry("pack.png"));
                    this.field_6494_g = ImageIO.read(inputstream);
                    inputstream.close();
                }
                catch (Exception bufferedreader) {
                    // empty catch block
                }
                zipfile.close();
            }
            catch (Exception exception2) {
                exception2.printStackTrace();
                try {
                    inputstream.close();
                }
                catch (Exception exception) {
                    // empty catch block
                }
                try {
                    zipfile.close();
                }
                catch (Exception exception) {}
            }
        }
        finally {
            try {
                inputstream.close();
            }
            catch (Exception exception) {}
            try {
                zipfile.close();
            }
            catch (Exception exception) {}
        }
    }

    @Override
    public void func_6484_b(Minecraft minecraft) {
        if (this.field_6494_g != null) {
            minecraft.renderEngine.deleteTexture(this.texturePackName);
        }
        this.closeTexturePackFile();
    }

    @Override
    public void func_6483_c(Minecraft minecraft) {
        if (this.field_6494_g != null && this.texturePackName < 0) {
            this.texturePackName = minecraft.renderEngine.allocateAndSetupTexture(this.field_6494_g);
        }
        if (this.field_6494_g != null) {
            minecraft.renderEngine.bindTexture(this.texturePackName);
        } else {
            GL11.glBindTexture(3553, minecraft.renderEngine.getTexture("/gui/unknown_pack.png"));
        }
    }

    @Override
    public void func_6482_a() {
        try {
            this.field_6496_e = new ZipFile(this.field_6493_h);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void closeTexturePackFile() {
        try {
            this.field_6496_e.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.field_6496_e = null;
    }

    @Override
    public InputStream func_6481_a(String s2) {
        try {
            ZipEntry zipentry = this.field_6496_e.getEntry(s2.substring(1));
            if (zipentry != null) {
                return this.field_6496_e.getInputStream(zipentry);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return TexturePackBase.class.getResourceAsStream(s2);
    }
}

