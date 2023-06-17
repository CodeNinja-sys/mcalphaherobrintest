/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

public class MathHelper {
    private static float[] SIN_TABLE = new float[65536];

    static {
        for (int i2 = 0; i2 < 65536; ++i2) {
            MathHelper.SIN_TABLE[i2] = (float)Math.sin((double)i2 * Math.PI * 2.0 / 65536.0);
        }
    }

    public static final float sin(float f2) {
        return SIN_TABLE[(int)(f2 * 10430.38f) & 0xFFFF];
    }

    public static final float cos(float f2) {
        return SIN_TABLE[(int)(f2 * 10430.38f + 16384.0f) & 0xFFFF];
    }

    public static final float sqrt_float(float f2) {
        return (float)Math.sqrt(f2);
    }

    public static final float sqrt_double(double d2) {
        return (float)Math.sqrt(d2);
    }

    public static int floor_float(float f2) {
        int i2 = (int)f2;
        return f2 >= (float)i2 ? i2 : i2 - 1;
    }

    public static int floor_double(double d2) {
        int i2 = (int)d2;
        return d2 >= (double)i2 ? i2 : i2 - 1;
    }

    public static float abs(float f2) {
        return f2 < 0.0f ? -f2 : f2;
    }

    public static double abs_max(double d2, double d1) {
        if (d2 < 0.0) {
            d2 = -d2;
        }
        if (d1 < 0.0) {
            d1 = -d1;
        }
        return d2 <= d1 ? d1 : d2;
    }

    public static int bucketInt(int i2, int j2) {
        if (i2 < 0) {
            return -((-i2 - 1) / j2) - 1;
        }
        return i2 / j2;
    }
}

