/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.NoiseGenerator;

public class NoiseGeneratorPerlin
extends NoiseGenerator {
    private int[] permutations = new int[512];
    public double xCoord;
    public double yCoord;
    public double zCoord;

    public NoiseGeneratorPerlin() {
        this(new Random());
    }

    public NoiseGeneratorPerlin(Random random) {
        this.xCoord = random.nextDouble() * 256.0;
        this.yCoord = random.nextDouble() * 256.0;
        this.zCoord = random.nextDouble() * 256.0;
        for (int i2 = 0; i2 < 256; ++i2) {
            this.permutations[i2] = i2;
        }
        for (int j2 = 0; j2 < 256; ++j2) {
            int k2 = random.nextInt(256 - j2) + j2;
            int l2 = this.permutations[j2];
            this.permutations[j2] = this.permutations[k2];
            this.permutations[k2] = l2;
            this.permutations[j2 + 256] = this.permutations[j2];
        }
    }

    public double generateNoise(double d2, double d1, double d22) {
        double d3 = d2 + this.xCoord;
        double d4 = d1 + this.yCoord;
        double d5 = d22 + this.zCoord;
        int i2 = (int)d3;
        int j2 = (int)d4;
        int k2 = (int)d5;
        if (d3 < (double)i2) {
            --i2;
        }
        if (d4 < (double)j2) {
            --j2;
        }
        if (d5 < (double)k2) {
            --k2;
        }
        int l2 = i2 & 0xFF;
        int i1 = j2 & 0xFF;
        int j1 = k2 & 0xFF;
        double d6 = (d3 -= (double)i2) * d3 * d3 * (d3 * (d3 * 6.0 - 15.0) + 10.0);
        double d7 = (d4 -= (double)j2) * d4 * d4 * (d4 * (d4 * 6.0 - 15.0) + 10.0);
        double d8 = (d5 -= (double)k2) * d5 * d5 * (d5 * (d5 * 6.0 - 15.0) + 10.0);
        int k1 = this.permutations[l2] + i1;
        int l1 = this.permutations[k1] + j1;
        int i22 = this.permutations[k1 + 1] + j1;
        int j22 = this.permutations[l2 + 1] + i1;
        int k22 = this.permutations[j22] + j1;
        int l22 = this.permutations[j22 + 1] + j1;
        return this.lerp(d8, this.lerp(d7, this.lerp(d6, this.grad(this.permutations[l1], d3, d4, d5), this.grad(this.permutations[k22], d3 - 1.0, d4, d5)), this.lerp(d6, this.grad(this.permutations[i22], d3, d4 - 1.0, d5), this.grad(this.permutations[l22], d3 - 1.0, d4 - 1.0, d5))), this.lerp(d7, this.lerp(d6, this.grad(this.permutations[l1 + 1], d3, d4, d5 - 1.0), this.grad(this.permutations[k22 + 1], d3 - 1.0, d4, d5 - 1.0)), this.lerp(d6, this.grad(this.permutations[i22 + 1], d3, d4 - 1.0, d5 - 1.0), this.grad(this.permutations[l22 + 1], d3 - 1.0, d4 - 1.0, d5 - 1.0))));
    }

    public final double lerp(double d2, double d1, double d22) {
        return d1 + d2 * (d22 - d1);
    }

    public final double func_4110_a(int i2, double d2, double d1) {
        int j2 = i2 & 0xF;
        double d22 = (double)(1 - ((j2 & 8) >> 3)) * d2;
        double d3 = j2 >= 4 ? (j2 != 12 && j2 != 14 ? d1 : d2) : 0.0;
        return ((j2 & 1) != 0 ? -d22 : d22) + ((j2 & 2) != 0 ? -d3 : d3);
    }

    public final double grad(int i2, double d2, double d1, double d22) {
        double d3;
        int j2 = i2 & 0xF;
        double d4 = d3 = j2 >= 8 ? d1 : d2;
        double d42 = j2 >= 4 ? (j2 != 12 && j2 != 14 ? d22 : d2) : d1;
        return ((j2 & 1) != 0 ? -d3 : d3) + ((j2 & 2) != 0 ? -d42 : d42);
    }

    public double func_801_a(double d2, double d1) {
        return this.generateNoise(d2, d1, 0.0);
    }

    public void func_805_a(double[] ad2, double d2, double d1, double d22, int i2, int j2, int k2, double d3, double d4, double d5, double d6) {
        if (j2 == 1) {
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            double d8 = 0.0;
            double d10 = 0.0;
            int j3 = 0;
            double d12 = 1.0 / d6;
            for (int i4 = 0; i4 < i2; ++i4) {
                double d14 = (d2 + (double)i4) * d3 + this.xCoord;
                int j4 = (int)d14;
                if (d14 < (double)j4) {
                    --j4;
                }
                int k4 = j4 & 0xFF;
                double d17 = (d14 -= (double)j4) * d14 * d14 * (d14 * (d14 * 6.0 - 15.0) + 10.0);
                for (int l4 = 0; l4 < k2; ++l4) {
                    double d19 = (d22 + (double)l4) * d5 + this.zCoord;
                    int j5 = (int)d19;
                    if (d19 < (double)j5) {
                        --j5;
                    }
                    int l5 = j5 & 0xFF;
                    double d21 = (d19 -= (double)j5) * d19 * d19 * (d19 * (d19 * 6.0 - 15.0) + 10.0);
                    int l2 = this.permutations[k4] + 0;
                    int j1 = this.permutations[l2] + l5;
                    int k1 = this.permutations[k4 + 1] + 0;
                    int l1 = this.permutations[k1] + l5;
                    double d9 = this.lerp(d17, this.func_4110_a(this.permutations[j1], d14, d19), this.grad(this.permutations[l1], d14 - 1.0, 0.0, d19));
                    double d11 = this.lerp(d17, this.grad(this.permutations[j1 + 1], d14, 0.0, d19 - 1.0), this.grad(this.permutations[l1 + 1], d14 - 1.0, 0.0, d19 - 1.0));
                    double d23 = this.lerp(d21, d9, d11);
                    int n2 = j3++;
                    ad2[n2] = ad2[n2] + d23 * d12;
                }
            }
            return;
        }
        int i1 = 0;
        double d7 = 1.0 / d6;
        int i22 = -1;
        boolean flag4 = false;
        boolean flag5 = false;
        boolean flag6 = false;
        boolean flag7 = false;
        boolean flag8 = false;
        boolean flag9 = false;
        double d13 = 0.0;
        double d15 = 0.0;
        double d16 = 0.0;
        double d18 = 0.0;
        for (int i5 = 0; i5 < i2; ++i5) {
            double d20 = (d2 + (double)i5) * d3 + this.xCoord;
            int k5 = (int)d20;
            if (d20 < (double)k5) {
                --k5;
            }
            int i6 = k5 & 0xFF;
            double d222 = (d20 -= (double)k5) * d20 * d20 * (d20 * (d20 * 6.0 - 15.0) + 10.0);
            for (int j6 = 0; j6 < k2; ++j6) {
                double d24 = (d22 + (double)j6) * d5 + this.zCoord;
                int k6 = (int)d24;
                if (d24 < (double)k6) {
                    --k6;
                }
                int l6 = k6 & 0xFF;
                double d25 = (d24 -= (double)k6) * d24 * d24 * (d24 * (d24 * 6.0 - 15.0) + 10.0);
                for (int i7 = 0; i7 < j2; ++i7) {
                    double d26 = (d1 + (double)i7) * d4 + this.yCoord;
                    int j7 = (int)d26;
                    if (d26 < (double)j7) {
                        --j7;
                    }
                    int k7 = j7 & 0xFF;
                    double d27 = (d26 -= (double)j7) * d26 * d26 * (d26 * (d26 * 6.0 - 15.0) + 10.0);
                    if (i7 == 0 || k7 != i22) {
                        i22 = k7;
                        int j22 = this.permutations[i6] + k7;
                        int k22 = this.permutations[j22] + l6;
                        int l2 = this.permutations[j22 + 1] + l6;
                        int i3 = this.permutations[i6 + 1] + k7;
                        int k3 = this.permutations[i3] + l6;
                        int l3 = this.permutations[i3 + 1] + l6;
                        d13 = this.lerp(d222, this.grad(this.permutations[k22], d20, d26, d24), this.grad(this.permutations[k3], d20 - 1.0, d26, d24));
                        d15 = this.lerp(d222, this.grad(this.permutations[l2], d20, d26 - 1.0, d24), this.grad(this.permutations[l3], d20 - 1.0, d26 - 1.0, d24));
                        d16 = this.lerp(d222, this.grad(this.permutations[k22 + 1], d20, d26, d24 - 1.0), this.grad(this.permutations[k3 + 1], d20 - 1.0, d26, d24 - 1.0));
                        d18 = this.lerp(d222, this.grad(this.permutations[l2 + 1], d20, d26 - 1.0, d24 - 1.0), this.grad(this.permutations[l3 + 1], d20 - 1.0, d26 - 1.0, d24 - 1.0));
                    }
                    double d28 = this.lerp(d27, d13, d15);
                    double d29 = this.lerp(d27, d16, d18);
                    double d30 = this.lerp(d25, d28, d29);
                    int n3 = i1++;
                    ad2[n3] = ad2[n3] + d30 * d7;
                }
            }
        }
    }
}

