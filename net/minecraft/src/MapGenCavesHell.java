/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.MapGenBase;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class MapGenCavesHell
extends MapGenBase {
    protected void func_4129_a(int i2, int j2, byte[] abyte0, double d2, double d1, double d22) {
        this.func_4128_a(i2, j2, abyte0, d2, d1, d22, 1.0f + this.field_1305_b.nextFloat() * 6.0f, 0.0f, 0.0f, -1, -1, 0.5);
    }

    protected void func_4128_a(int i2, int j2, byte[] abyte0, double d2, double d1, double d22, float f2, float f1, float f22, int k2, int l2, double d3) {
        double d4 = i2 * 16 + 8;
        double d5 = j2 * 16 + 8;
        float f3 = 0.0f;
        float f4 = 0.0f;
        Random random = new Random(this.field_1305_b.nextLong());
        if (l2 <= 0) {
            int i1 = this.field_1306_a * 16 - 16;
            l2 = i1 - random.nextInt(i1 / 4);
        }
        boolean flag = false;
        if (k2 == -1) {
            k2 = l2 / 2;
            flag = true;
        }
        int j1 = random.nextInt(l2 / 2) + l2 / 4;
        boolean flag1 = random.nextInt(6) == 0;
        while (k2 < l2) {
            double d6 = 1.5 + (double)(MathHelper.sin((float)k2 * 3.141593f / (float)l2) * f2 * 1.0f);
            double d7 = d6 * d3;
            float f5 = MathHelper.cos(f22);
            float f6 = MathHelper.sin(f22);
            d2 += (double)(MathHelper.cos(f1) * f5);
            d1 += (double)f6;
            d22 += (double)(MathHelper.sin(f1) * f5);
            f22 = flag1 ? (f22 *= 0.92f) : (f22 *= 0.7f);
            f22 += f4 * 0.1f;
            f1 += f3 * 0.1f;
            f4 *= 0.9f;
            f3 *= 0.75f;
            f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0f;
            f3 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0f;
            if (!flag && k2 == j1 && f2 > 1.0f) {
                this.func_4128_a(i2, j2, abyte0, d2, d1, d22, random.nextFloat() * 0.5f + 0.5f, f1 - 1.570796f, f22 / 3.0f, k2, l2, 1.0);
                this.func_4128_a(i2, j2, abyte0, d2, d1, d22, random.nextFloat() * 0.5f + 0.5f, f1 + 1.570796f, f22 / 3.0f, k2, l2, 1.0);
                return;
            }
            if (flag || random.nextInt(4) != 0) {
                double d8 = d2 - d4;
                double d9 = d22 - d5;
                double d10 = l2 - k2;
                double d11 = f2 + 2.0f + 16.0f;
                if (d8 * d8 + d9 * d9 - d10 * d10 > d11 * d11) {
                    return;
                }
                if (!(d2 < d4 - 16.0 - d6 * 2.0 || d22 < d5 - 16.0 - d6 * 2.0 || d2 > d4 + 16.0 + d6 * 2.0 || d22 > d5 + 16.0 + d6 * 2.0)) {
                    d8 = MathHelper.floor_double(d2 - d6) - i2 * 16 - 1;
                    int k1 = MathHelper.floor_double(d2 + d6) - i2 * 16 + 1;
                    d9 = MathHelper.floor_double(d1 - d7) - 1;
                    int l1 = MathHelper.floor_double(d1 + d7) + 1;
                    d10 = MathHelper.floor_double(d22 - d6) - j2 * 16 - 1;
                    int i22 = MathHelper.floor_double(d22 + d6) - j2 * 16 + 1;
                    if (d8 < 0.0) {
                        d8 = 0.0;
                    }
                    if (k1 > 16) {
                        k1 = 16;
                    }
                    if (d9 < 1.0) {
                        d9 = 1.0;
                    }
                    if (l1 > 120) {
                        l1 = 120;
                    }
                    if (d10 < 0.0) {
                        d10 = 0.0;
                    }
                    if (i22 > 16) {
                        i22 = 16;
                    }
                    boolean flag2 = false;
                    for (int j22 = (int)d8; !flag2 && j22 < k1; ++j22) {
                        for (int l22 = (int)d10; !flag2 && l22 < i22; ++l22) {
                            int i3 = l1 + 1;
                            while (!flag2 && (double)i3 >= d9 - 1.0) {
                                int j3 = (j22 * 16 + l22) * 128 + i3;
                                if (i3 >= 0 && i3 < 128) {
                                    if (abyte0[j3] == Block.lavaStill.blockID || abyte0[j3] == Block.lavaMoving.blockID) {
                                        flag2 = true;
                                    }
                                    if ((double)i3 != d9 - 1.0 && (double)j22 != d8 && j22 != k1 - 1 && (double)l22 != d10 && l22 != i22 - 1) {
                                        i3 = (int)d9;
                                    }
                                }
                                --i3;
                            }
                        }
                    }
                    if (!flag2) {
                        for (int k22 = (int)d8; k22 < k1; ++k22) {
                            double d12 = ((double)(k22 + i2 * 16) + 0.5 - d2) / d6;
                            for (int k3 = (int)d10; k3 < i22; ++k3) {
                                double d13 = ((double)(k3 + j2 * 16) + 0.5 - d22) / d6;
                                int l3 = (k22 * 16 + k3) * 128 + l1;
                                int i4 = l1 - 1;
                                while ((double)i4 >= d9) {
                                    byte byte0;
                                    double d14 = ((double)i4 + 0.5 - d1) / d7;
                                    if (d14 > -0.7 && d12 * d12 + d14 * d14 + d13 * d13 < 1.0 && ((byte0 = abyte0[l3]) == Block.bloodStone.blockID || byte0 == Block.dirt.blockID || byte0 == Block.grass.blockID)) {
                                        abyte0[l3] = 0;
                                    }
                                    --l3;
                                    --i4;
                                }
                            }
                        }
                        if (flag) break;
                    }
                }
            }
            ++k2;
        }
    }

    @Override
    protected void func_868_a(World world, int i2, int j2, int k2, int l2, byte[] abyte0) {
        int i1 = this.field_1305_b.nextInt(this.field_1305_b.nextInt(this.field_1305_b.nextInt(10) + 1) + 1);
        if (this.field_1305_b.nextInt(5) != 0) {
            i1 = 0;
        }
        for (int j1 = 0; j1 < i1; ++j1) {
            double d2 = i2 * 16 + this.field_1305_b.nextInt(16);
            double d1 = this.field_1305_b.nextInt(128);
            double d22 = j2 * 16 + this.field_1305_b.nextInt(16);
            int k1 = 1;
            if (this.field_1305_b.nextInt(4) == 0) {
                this.func_4129_a(k2, l2, abyte0, d2, d1, d22);
                k1 += this.field_1305_b.nextInt(4);
            }
            for (int l1 = 0; l1 < k1; ++l1) {
                float f2 = this.field_1305_b.nextFloat() * 3.141593f * 2.0f;
                float f1 = (this.field_1305_b.nextFloat() - 0.5f) * 2.0f / 8.0f;
                float f22 = this.field_1305_b.nextFloat() * 2.0f + this.field_1305_b.nextFloat();
                this.func_4128_a(k2, l2, abyte0, d2, d1, d22, f22 * 2.0f, f2, f1, 0, 0, 0.5);
            }
        }
    }
}

