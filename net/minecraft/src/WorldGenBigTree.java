/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenBigTree
extends WorldGenerator {
    static final byte[] field_882_a;
    Random field_881_b;
    World worldObj;
    int[] field_879_d = new int[3];
    int field_878_e = 0;
    int field_877_f;
    double field_876_g = 0.618;
    double field_875_h = 1.0;
    double field_874_i = 0.381;
    double field_873_j = 1.0;
    double field_872_k = 1.0;
    int field_871_l = 1;
    int field_870_m = 12;
    int field_869_n = 4;
    int[][] field_868_o;

    static {
        byte[] arrby = new byte[6];
        arrby[0] = 2;
        arrby[3] = 1;
        arrby[4] = 2;
        arrby[5] = 1;
        field_882_a = arrby;
    }

    public WorldGenBigTree() {
        this.field_881_b = new Random();
    }

    void func_521_a() {
        int i2;
        this.field_877_f = (int)((double)this.field_878_e * this.field_876_g);
        if (this.field_877_f >= this.field_878_e) {
            this.field_877_f = this.field_878_e - 1;
        }
        if ((i2 = (int)(1.382 + Math.pow(this.field_872_k * (double)this.field_878_e / 13.0, 2.0))) < 1) {
            i2 = 1;
        }
        int[][] ai2 = new int[i2 * this.field_878_e][4];
        int j2 = this.field_879_d[1] + this.field_878_e - this.field_869_n;
        int k2 = 1;
        int l2 = this.field_879_d[1] + this.field_877_f;
        int i1 = j2 - this.field_879_d[1];
        ai2[0][0] = this.field_879_d[0];
        ai2[0][1] = j2--;
        ai2[0][2] = this.field_879_d[2];
        ai2[0][3] = l2;
        while (i1 >= 0) {
            float f2 = this.func_528_a(i1);
            if (f2 < 0.0f) {
                --j2;
                --i1;
                continue;
            }
            double d2 = 0.5;
            for (int j1 = 0; j1 < i2; ++j1) {
                double d1 = this.field_873_j * ((double)f2 * ((double)this.field_881_b.nextFloat() + 0.328));
                double d22 = (double)this.field_881_b.nextFloat() * 2.0 * 3.14159;
                int k1 = (int)(d1 * Math.sin(d22) + (double)this.field_879_d[0] + d2);
                int l1 = (int)(d1 * Math.cos(d22) + (double)this.field_879_d[2] + d2);
                int[] ai1 = new int[]{k1, j2, l1};
                int[] ai22 = new int[]{k1, j2 + this.field_869_n, l1};
                if (this.func_524_a(ai1, ai22) != -1) continue;
                int[] ai3 = new int[]{this.field_879_d[0], this.field_879_d[1], this.field_879_d[2]};
                double d3 = Math.sqrt(Math.pow(Math.abs(this.field_879_d[0] - ai1[0]), 2.0) + Math.pow(Math.abs(this.field_879_d[2] - ai1[2]), 2.0));
                double d4 = d3 * this.field_874_i;
                ai3[1] = (double)ai1[1] - d4 > (double)l2 ? l2 : (int)((double)ai1[1] - d4);
                if (this.func_524_a(ai3, ai1) != -1) continue;
                ai2[k2][0] = k1;
                ai2[k2][1] = j2;
                ai2[k2][2] = l1;
                ai2[k2][3] = ai3[1];
                ++k2;
            }
            --j2;
            --i1;
        }
        this.field_868_o = new int[k2][4];
        System.arraycopy(ai2, 0, this.field_868_o, 0, k2);
    }

    void func_523_a(int i2, int j2, int k2, float f2, byte byte0, int l2) {
        int i1 = (int)((double)f2 + 0.618);
        byte byte1 = field_882_a[byte0];
        byte byte2 = field_882_a[byte0 + 3];
        int[] ai2 = new int[]{i2, j2, k2};
        int[] ai1 = new int[3];
        int k1 = -i1;
        ai1[byte0] = ai2[byte0];
        for (int j1 = -i1; j1 <= i1; ++j1) {
            ai1[byte1] = ai2[byte1] + j1;
            int l1 = -i1;
            while (l1 <= i1) {
                double d2 = Math.sqrt(Math.pow((double)Math.abs(j1) + 0.5, 2.0) + Math.pow((double)Math.abs(l1) + 0.5, 2.0));
                if (d2 > (double)f2) {
                    ++l1;
                    continue;
                }
                ai1[byte2] = ai2[byte2] + l1;
                int i22 = this.worldObj.getBlockId(ai1[0], ai1[1], ai1[2]);
                if (i22 != 0 && i22 != 18) {
                    ++l1;
                    continue;
                }
                this.worldObj.setBlock(ai1[0], ai1[1], ai1[2], l2);
                ++l1;
            }
        }
    }

    float func_528_a(int i2) {
        if ((double)i2 < (double)this.field_878_e * 0.3) {
            return -1.618f;
        }
        float f2 = (float)this.field_878_e / 2.0f;
        float f1 = (float)this.field_878_e / 2.0f - (float)i2;
        float f22 = f1 == 0.0f ? f2 : (Math.abs(f1) >= f2 ? 0.0f : (float)Math.sqrt(Math.pow(Math.abs(f2), 2.0) - Math.pow(Math.abs(f1), 2.0)));
        return f22 *= 0.5f;
    }

    float func_526_b(int i2) {
        if (i2 < 0 || i2 >= this.field_869_n) {
            return -1.0f;
        }
        return i2 != 0 && i2 != this.field_869_n - 1 ? 3.0f : 2.0f;
    }

    void func_520_a(int i2, int j2, int k2) {
        int i1 = j2 + this.field_869_n;
        for (int l2 = j2; l2 < i1; ++l2) {
            float f2 = this.func_526_b(l2 - j2);
            this.func_523_a(i2, l2, k2, f2, (byte)1, 18);
        }
    }

    void func_522_a(int[] ai2, int[] ai1, int i2) {
        int[] ai22 = new int[3];
        int j2 = 0;
        for (int byte0 = 0; byte0 < 3; byte0 = (int)((byte)(byte0 + 1))) {
            ai22[byte0] = ai1[byte0] - ai2[byte0];
            if (Math.abs(ai22[byte0]) <= Math.abs(ai22[j2])) continue;
            j2 = byte0;
        }
        if (ai22[j2] == 0) {
            return;
        }
        byte byte1 = field_882_a[j2];
        byte byte2 = field_882_a[j2 + 3];
        int byte3 = ai22[j2] > 0 ? 1 : -1;
        double d2 = (double)ai22[byte1] / (double)ai22[j2];
        double d1 = (double)ai22[byte2] / (double)ai22[j2];
        int[] ai3 = new int[3];
        int l2 = ai22[j2] + byte3;
        for (int k2 = 0; k2 != l2; k2 += byte3) {
            ai3[j2] = MathHelper.floor_double((double)(ai2[j2] + k2) + 0.5);
            ai3[byte1] = MathHelper.floor_double((double)ai2[byte1] + (double)k2 * d2 + 0.5);
            ai3[byte2] = MathHelper.floor_double((double)ai2[byte2] + (double)k2 * d1 + 0.5);
            this.worldObj.setBlock(ai3[0], ai3[1], ai3[2], i2);
        }
    }

    void func_518_b() {
        int j2 = this.field_868_o.length;
        for (int i2 = 0; i2 < j2; ++i2) {
            int k2 = this.field_868_o[i2][0];
            int l2 = this.field_868_o[i2][1];
            int i1 = this.field_868_o[i2][2];
            this.func_520_a(k2, l2, i1);
        }
    }

    boolean func_527_c(int i2) {
        return (double)i2 >= (double)this.field_878_e * 0.2;
    }

    void func_529_c() {
        int i2 = this.field_879_d[0];
        int j2 = this.field_879_d[1];
        int k2 = this.field_879_d[1] + this.field_877_f;
        int l2 = this.field_879_d[2];
        int[] ai2 = new int[]{i2, j2, l2};
        int[] ai1 = new int[]{i2, k2, l2};
        this.func_522_a(ai2, ai1, 17);
        if (this.field_871_l == 2) {
            ai2[0] = ai2[0] + 1;
            ai1[0] = ai1[0] + 1;
            this.func_522_a(ai2, ai1, 17);
            ai2[2] = ai2[2] + 1;
            ai1[2] = ai1[2] + 1;
            this.func_522_a(ai2, ai1, 17);
            ai2[0] = ai2[0] - 1;
            ai1[0] = ai1[0] - 1;
            this.func_522_a(ai2, ai1, 17);
        }
    }

    void func_525_d() {
        int j2 = this.field_868_o.length;
        int[] ai2 = new int[]{this.field_879_d[0], this.field_879_d[1], this.field_879_d[2]};
        for (int i2 = 0; i2 < j2; ++i2) {
            int[] ai1 = this.field_868_o[i2];
            int[] ai22 = new int[]{ai1[0], ai1[1], ai1[2]};
            ai2[1] = ai1[3];
            int k2 = ai2[1] - this.field_879_d[1];
            if (!this.func_527_c(k2)) continue;
            this.func_522_a(ai2, ai22, 17);
        }
    }

    int func_524_a(int[] ai2, int[] ai1) {
        int j2;
        int[] ai22 = new int[3];
        int i2 = 0;
        for (int byte0 = 0; byte0 < 3; byte0 = (int)((byte)(byte0 + 1))) {
            ai22[byte0] = ai1[byte0] - ai2[byte0];
            if (Math.abs(ai22[byte0]) <= Math.abs(ai22[i2])) continue;
            i2 = byte0;
        }
        if (ai22[i2] == 0) {
            return -1;
        }
        byte byte1 = field_882_a[i2];
        byte byte2 = field_882_a[i2 + 3];
        int byte3 = ai22[i2] > 0 ? 1 : -1;
        double d2 = (double)ai22[byte1] / (double)ai22[i2];
        double d1 = (double)ai22[byte2] / (double)ai22[i2];
        int[] ai3 = new int[3];
        int k2 = ai22[i2] + byte3;
        for (j2 = 0; j2 != k2; j2 += byte3) {
            ai3[i2] = ai2[i2] + j2;
            ai3[byte1] = (int)((double)ai2[byte1] + (double)j2 * d2);
            ai3[byte2] = (int)((double)ai2[byte2] + (double)j2 * d1);
            int l2 = this.worldObj.getBlockId(ai3[0], ai3[1], ai3[2]);
            if (l2 != 0 && l2 != 18) break;
        }
        if (j2 == k2) {
            return -1;
        }
        return Math.abs(j2);
    }

    boolean func_519_e() {
        int[] ai2 = new int[]{this.field_879_d[0], this.field_879_d[1], this.field_879_d[2]};
        int[] ai1 = new int[]{this.field_879_d[0], this.field_879_d[1] + this.field_878_e - 1, this.field_879_d[2]};
        int i2 = this.worldObj.getBlockId(this.field_879_d[0], this.field_879_d[1] - 1, this.field_879_d[2]);
        if (i2 != 2 && i2 != 3) {
            return false;
        }
        int j2 = this.func_524_a(ai2, ai1);
        if (j2 == -1) {
            return true;
        }
        if (j2 < 6) {
            return false;
        }
        this.field_878_e = j2;
        return true;
    }

    @Override
    public void func_517_a(double d2, double d1, double d22) {
        this.field_870_m = (int)(d2 * 12.0);
        if (d2 > 0.5) {
            this.field_869_n = 5;
        }
        this.field_873_j = d1;
        this.field_872_k = d22;
    }

    @Override
    public boolean generate(World world, Random random, int i2, int j2, int k2) {
        this.worldObj = world;
        long l2 = random.nextLong();
        this.field_881_b.setSeed(l2);
        this.field_879_d[0] = i2;
        this.field_879_d[1] = j2;
        this.field_879_d[2] = k2;
        if (this.field_878_e == 0) {
            this.field_878_e = 5 + this.field_881_b.nextInt(this.field_870_m);
        }
        if (!this.func_519_e()) {
            return false;
        }
        this.func_521_a();
        this.func_518_b();
        this.func_529_c();
        this.func_525_d();
        return true;
    }
}

