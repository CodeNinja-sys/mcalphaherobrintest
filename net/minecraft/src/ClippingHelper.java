/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

public class ClippingHelper {
    public float[][] field_1688_a = new float[16][16];
    public float[] field_1687_b = new float[16];
    public float[] field_1690_c = new float[16];
    public float[] field_1689_d = new float[16];

    public boolean func_1152_a(double d2, double d1, double d22, double d3, double d4, double d5) {
        for (int i2 = 0; i2 < 6; ++i2) {
            if (!((double)this.field_1688_a[i2][0] * d2 + (double)this.field_1688_a[i2][1] * d1 + (double)this.field_1688_a[i2][2] * d22 + (double)this.field_1688_a[i2][3] <= 0.0) || !((double)this.field_1688_a[i2][0] * d3 + (double)this.field_1688_a[i2][1] * d1 + (double)this.field_1688_a[i2][2] * d22 + (double)this.field_1688_a[i2][3] <= 0.0) || !((double)this.field_1688_a[i2][0] * d2 + (double)this.field_1688_a[i2][1] * d4 + (double)this.field_1688_a[i2][2] * d22 + (double)this.field_1688_a[i2][3] <= 0.0) || !((double)this.field_1688_a[i2][0] * d3 + (double)this.field_1688_a[i2][1] * d4 + (double)this.field_1688_a[i2][2] * d22 + (double)this.field_1688_a[i2][3] <= 0.0) || !((double)this.field_1688_a[i2][0] * d2 + (double)this.field_1688_a[i2][1] * d1 + (double)this.field_1688_a[i2][2] * d5 + (double)this.field_1688_a[i2][3] <= 0.0) || !((double)this.field_1688_a[i2][0] * d3 + (double)this.field_1688_a[i2][1] * d1 + (double)this.field_1688_a[i2][2] * d5 + (double)this.field_1688_a[i2][3] <= 0.0) || !((double)this.field_1688_a[i2][0] * d2 + (double)this.field_1688_a[i2][1] * d4 + (double)this.field_1688_a[i2][2] * d5 + (double)this.field_1688_a[i2][3] <= 0.0) || !((double)this.field_1688_a[i2][0] * d3 + (double)this.field_1688_a[i2][1] * d4 + (double)this.field_1688_a[i2][2] * d5 + (double)this.field_1688_a[i2][3] <= 0.0)) continue;
            return false;
        }
        return true;
    }
}

