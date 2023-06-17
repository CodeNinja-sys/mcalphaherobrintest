/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;

public class NoiseGenerator2 {
    private static int[][] field_4296_d;
    private int[] field_4295_e = new int[512];
    public double field_4292_a;
    public double field_4291_b;
    public double field_4297_c;
    private static final double field_4294_f;
    private static final double field_4293_g;

    static {
        int[][] arrarrn = new int[12][];
        int[] arrn = new int[3];
        arrn[0] = 1;
        arrn[1] = 1;
        arrarrn[0] = arrn;
        int[] arrn2 = new int[3];
        arrn2[0] = -1;
        arrn2[1] = 1;
        arrarrn[1] = arrn2;
        int[] arrn3 = new int[3];
        arrn3[0] = 1;
        arrn3[1] = -1;
        arrarrn[2] = arrn3;
        int[] arrn4 = new int[3];
        arrn4[0] = -1;
        arrn4[1] = -1;
        arrarrn[3] = arrn4;
        int[] arrn5 = new int[3];
        arrn5[0] = 1;
        arrn5[2] = 1;
        arrarrn[4] = arrn5;
        int[] arrn6 = new int[3];
        arrn6[0] = -1;
        arrn6[2] = 1;
        arrarrn[5] = arrn6;
        int[] arrn7 = new int[3];
        arrn7[0] = 1;
        arrn7[2] = -1;
        arrarrn[6] = arrn7;
        int[] arrn8 = new int[3];
        arrn8[0] = -1;
        arrn8[2] = -1;
        arrarrn[7] = arrn8;
        int[] arrn9 = new int[3];
        arrn9[1] = 1;
        arrn9[2] = 1;
        arrarrn[8] = arrn9;
        int[] arrn10 = new int[3];
        arrn10[1] = -1;
        arrn10[2] = 1;
        arrarrn[9] = arrn10;
        int[] arrn11 = new int[3];
        arrn11[1] = 1;
        arrn11[2] = -1;
        arrarrn[10] = arrn11;
        int[] arrn12 = new int[3];
        arrn12[1] = -1;
        arrn12[2] = -1;
        arrarrn[11] = arrn12;
        field_4296_d = arrarrn;
        field_4294_f = 0.5 * (Math.sqrt(3.0) - 1.0);
        field_4293_g = (3.0 - Math.sqrt(3.0)) / 6.0;
    }

    public NoiseGenerator2() {
        this(new Random());
    }

    public NoiseGenerator2(Random random) {
        this.field_4292_a = random.nextDouble() * 256.0;
        this.field_4291_b = random.nextDouble() * 256.0;
        this.field_4297_c = random.nextDouble() * 256.0;
        for (int i2 = 0; i2 < 256; ++i2) {
            this.field_4295_e[i2] = i2;
        }
        for (int j2 = 0; j2 < 256; ++j2) {
            int k2 = random.nextInt(256 - j2) + j2;
            int l2 = this.field_4295_e[j2];
            this.field_4295_e[j2] = this.field_4295_e[k2];
            this.field_4295_e[k2] = l2;
            this.field_4295_e[j2 + 256] = this.field_4295_e[j2];
        }
    }

    private static int func_4155_a(double d2) {
        return d2 <= 0.0 ? (int)d2 - 1 : (int)d2;
    }

    private static double func_4156_a(int[] ai2, double d2, double d1) {
        return (double)ai2[0] * d2 + (double)ai2[1] * d1;
    }

    public void func_4157_a(double[] ad2, double d2, double d1, int i2, int j2, double d22, double d3, double d4) {
        int k2 = 0;
        for (int l2 = 0; l2 < i2; ++l2) {
            double d5 = (d2 + (double)l2) * d22 + this.field_4292_a;
            for (int i1 = 0; i1 < j2; ++i1) {
                double d9;
                double d8;
                double d7;
                int i22;
                int l1;
                double d13;
                double d15;
                int k1;
                double d11;
                double d6 = (d1 + (double)i1) * d3 + this.field_4291_b;
                double d10 = (d5 + d6) * field_4294_f;
                int j1 = NoiseGenerator2.func_4155_a(d5 + d10);
                double d12 = (double)j1 - (d11 = (double)(j1 + (k1 = NoiseGenerator2.func_4155_a(d6 + d10))) * field_4293_g);
                double d14 = d5 - d12;
                if (d14 > (d15 = d6 - (d13 = (double)k1 - d11))) {
                    l1 = 1;
                    i22 = 0;
                } else {
                    l1 = 0;
                    i22 = 1;
                }
                double d16 = d14 - (double)l1 + field_4293_g;
                double d17 = d15 - (double)i22 + field_4293_g;
                double d18 = d14 - 1.0 + 2.0 * field_4293_g;
                double d19 = d15 - 1.0 + 2.0 * field_4293_g;
                int j22 = j1 & 0xFF;
                int k22 = k1 & 0xFF;
                int l22 = this.field_4295_e[j22 + this.field_4295_e[k22]] % 12;
                int i3 = this.field_4295_e[j22 + l1 + this.field_4295_e[k22 + i22]] % 12;
                int j3 = this.field_4295_e[j22 + 1 + this.field_4295_e[k22 + 1]] % 12;
                double d20 = 0.5 - d14 * d14 - d15 * d15;
                if (d20 < 0.0) {
                    d7 = 0.0;
                } else {
                    d20 *= d20;
                    d7 = d20 * d20 * NoiseGenerator2.func_4156_a(field_4296_d[l22], d14, d15);
                }
                double d21 = 0.5 - d16 * d16 - d17 * d17;
                if (d21 < 0.0) {
                    d8 = 0.0;
                } else {
                    d21 *= d21;
                    d8 = d21 * d21 * NoiseGenerator2.func_4156_a(field_4296_d[i3], d16, d17);
                }
                double d222 = 0.5 - d18 * d18 - d19 * d19;
                if (d222 < 0.0) {
                    d9 = 0.0;
                } else {
                    d222 *= d222;
                    d9 = d222 * d222 * NoiseGenerator2.func_4156_a(field_4296_d[j3], d18, d19);
                }
                int n2 = k2++;
                ad2[n2] = ad2[n2] + 70.0 * (d7 + d8 + d9) * d4;
            }
        }
    }
}

