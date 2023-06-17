/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import net.minecraft.src.Block;
import net.minecraft.src.Chunk;
import net.minecraft.src.IsoImageBuffer;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class TerrainTextureManager {
    private float[] field_1181_a = new float[768];
    private int[] field_1180_b = new int[5120];
    private int[] field_1186_c = new int[5120];
    private int[] field_1185_d = new int[5120];
    private int[] field_1184_e = new int[5120];
    private int[] field_1183_f = new int[34];
    private int[] field_1182_g = new int[768];

    public TerrainTextureManager() {
        try {
            BufferedImage bufferedimage = ImageIO.read(TerrainTextureManager.class.getResource("/terrain.png"));
            int[] ai2 = new int[65536];
            bufferedimage.getRGB(0, 0, 256, 256, ai2, 0, 256);
            for (int j2 = 0; j2 < 256; ++j2) {
                int k2 = 0;
                int l2 = 0;
                int i1 = 0;
                int j1 = j2 % 16 * 16;
                int k1 = j2 / 16 * 16;
                int l1 = 0;
                for (int i2 = 0; i2 < 16; ++i2) {
                    for (int j22 = 0; j22 < 16; ++j22) {
                        int k22 = ai2[j22 + j1 + (i2 + k1) * 256];
                        int l22 = k22 >> 24 & 0xFF;
                        if (l22 <= 128) continue;
                        k2 += k22 >> 16 & 0xFF;
                        l2 += k22 >> 8 & 0xFF;
                        i1 += k22 & 0xFF;
                        ++l1;
                    }
                    if (l1 == 0) {
                        ++l1;
                    }
                    this.field_1181_a[j2 * 3 + 0] = k2 / l1;
                    this.field_1181_a[j2 * 3 + 1] = l2 / l1;
                    this.field_1181_a[j2 * 3 + 2] = i1 / l1;
                }
            }
        }
        catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
        for (int i2 = 0; i2 < 256; ++i2) {
            if (Block.blocksList[i2] == null) continue;
            this.field_1182_g[i2 * 3 + 0] = Block.blocksList[i2].getBlockTextureFromSide(1);
            this.field_1182_g[i2 * 3 + 1] = Block.blocksList[i2].getBlockTextureFromSide(2);
            this.field_1182_g[i2 * 3 + 2] = Block.blocksList[i2].getBlockTextureFromSide(3);
        }
    }

    public void func_799_a(IsoImageBuffer isoimagebuffer) {
        World world = isoimagebuffer.worldObj;
        if (world == null) {
            isoimagebuffer.field_1351_f = true;
            isoimagebuffer.field_1352_e = true;
            return;
        }
        int i2 = isoimagebuffer.field_1354_c * 16;
        int j2 = isoimagebuffer.field_1353_d * 16;
        int k2 = i2 + 16;
        int l2 = j2 + 16;
        Chunk chunk = world.getChunkFromChunkCoords(isoimagebuffer.field_1354_c, isoimagebuffer.field_1353_d);
        if (chunk.field_1524_q) {
            isoimagebuffer.field_1351_f = true;
            isoimagebuffer.field_1352_e = true;
            return;
        }
        isoimagebuffer.field_1351_f = false;
        Arrays.fill(this.field_1186_c, 0);
        Arrays.fill(this.field_1185_d, 0);
        Arrays.fill(this.field_1183_f, 160);
        for (int i1 = l2 - 1; i1 >= j2; --i1) {
            for (int j1 = k2 - 1; j1 >= i2; --j1) {
                int k1 = j1 - i2;
                int l1 = i1 - j2;
                int i22 = k1 + l1;
                boolean flag = true;
                for (int j22 = 0; j22 < 128; ++j22) {
                    int k22 = l1 - k1 - j22 + 160 - 16;
                    if (k22 >= this.field_1183_f[i22] && k22 >= this.field_1183_f[i22 + 1]) continue;
                    Block block = Block.blocksList[world.getBlockId(j1, j22, i1)];
                    if (block == null) {
                        flag = false;
                        continue;
                    }
                    if (block.blockMaterial == Material.water) {
                        int l22 = world.getBlockId(j1, j22 + 1, i1);
                        if (l22 != 0 && Block.blocksList[l22].blockMaterial == Material.water) continue;
                        float f1 = (float)j22 / 127.0f * 0.6f + 0.4f;
                        float f2 = world.getLightBrightness(j1, j22 + 1, i1) * f1;
                        if (k22 < 0 || k22 >= 160) continue;
                        int i4 = i22 + k22 * 32;
                        if (i22 >= 0 && i22 <= 32 && this.field_1185_d[i4] <= j22) {
                            this.field_1185_d[i4] = j22;
                            this.field_1184_e[i4] = (int)(f2 * 127.0f);
                        }
                        if (i22 >= -1 && i22 <= 31 && this.field_1185_d[i4 + 1] <= j22) {
                            this.field_1185_d[i4 + 1] = j22;
                            this.field_1184_e[i4 + 1] = (int)(f2 * 127.0f);
                        }
                        flag = false;
                        continue;
                    }
                    if (flag) {
                        if (k22 < this.field_1183_f[i22]) {
                            this.field_1183_f[i22] = k22;
                        }
                        if (k22 < this.field_1183_f[i22 + 1]) {
                            this.field_1183_f[i22 + 1] = k22;
                        }
                    }
                    float f2 = (float)j22 / 127.0f * 0.6f + 0.4f;
                    if (k22 >= 0 && k22 < 160) {
                        int i3 = i22 + k22 * 32;
                        int k3 = this.field_1182_g[block.blockID * 3 + 0];
                        float f3 = (world.getLightBrightness(j1, j22 + 1, i1) * 0.8f + 0.2f) * f2;
                        int j4 = k3;
                        if (i22 >= 0) {
                            float f5 = f3;
                            if (this.field_1186_c[i3] <= j22) {
                                this.field_1186_c[i3] = j22;
                                this.field_1180_b[i3] = 0xFF000000 | (int)(this.field_1181_a[j4 * 3 + 0] * f5) << 16 | (int)(this.field_1181_a[j4 * 3 + 1] * f5) << 8 | (int)(this.field_1181_a[j4 * 3 + 2] * f5);
                            }
                        }
                        if (i22 < 31) {
                            float f6 = f3 * 0.9f;
                            if (this.field_1186_c[i3 + 1] <= j22) {
                                this.field_1186_c[i3 + 1] = j22;
                                this.field_1180_b[i3 + 1] = 0xFF000000 | (int)(this.field_1181_a[j4 * 3 + 0] * f6) << 16 | (int)(this.field_1181_a[j4 * 3 + 1] * f6) << 8 | (int)(this.field_1181_a[j4 * 3 + 2] * f6);
                            }
                        }
                    }
                    if (k22 < -1 || k22 >= 159) continue;
                    int j3 = i22 + (k22 + 1) * 32;
                    int l3 = this.field_1182_g[block.blockID * 3 + 1];
                    float f4 = world.getLightBrightness(j1 - 1, j22, i1) * 0.8f + 0.2f;
                    int k4 = this.field_1182_g[block.blockID * 3 + 2];
                    float f7 = world.getLightBrightness(j1, j22, i1 + 1) * 0.8f + 0.2f;
                    if (i22 >= 0) {
                        float f8 = f4 * f2 * 0.6f;
                        if (this.field_1186_c[j3] <= j22 - 1) {
                            this.field_1186_c[j3] = j22 - 1;
                            this.field_1180_b[j3] = 0xFF000000 | (int)(this.field_1181_a[l3 * 3 + 0] * f8) << 16 | (int)(this.field_1181_a[l3 * 3 + 1] * f8) << 8 | (int)(this.field_1181_a[l3 * 3 + 2] * f8);
                        }
                    }
                    if (i22 >= 31) continue;
                    float f9 = f7 * 0.9f * f2 * 0.4f;
                    if (this.field_1186_c[j3 + 1] > j22 - 1) continue;
                    this.field_1186_c[j3 + 1] = j22 - 1;
                    this.field_1180_b[j3 + 1] = 0xFF000000 | (int)(this.field_1181_a[k4 * 3 + 0] * f9) << 16 | (int)(this.field_1181_a[k4 * 3 + 1] * f9) << 8 | (int)(this.field_1181_a[k4 * 3 + 2] * f9);
                }
            }
        }
        this.func_800_a();
        if (isoimagebuffer.field_1348_a == null) {
            isoimagebuffer.field_1348_a = new BufferedImage(32, 160, 2);
        }
        isoimagebuffer.field_1348_a.setRGB(0, 0, 32, 160, this.field_1180_b, 0, 32);
        isoimagebuffer.field_1352_e = true;
    }

    private void func_800_a() {
        for (int i2 = 0; i2 < 32; ++i2) {
            for (int j2 = 0; j2 < 160; ++j2) {
                int k2 = i2 + j2 * 32;
                if (this.field_1186_c[k2] == 0) {
                    this.field_1180_b[k2] = 0;
                }
                if (this.field_1185_d[k2] <= this.field_1186_c[k2]) continue;
                int l2 = this.field_1180_b[k2] >> 24 & 0xFF;
                this.field_1180_b[k2] = ((this.field_1180_b[k2] & 0xFEFEFE) >> 1) + this.field_1184_e[k2];
                if (l2 < 128) {
                    this.field_1180_b[k2] = Integer.MIN_VALUE + this.field_1184_e[k2] * 2;
                    continue;
                }
                int n2 = k2;
                this.field_1180_b[n2] = this.field_1180_b[n2] | 0xFF000000;
            }
        }
    }
}

