/*
 * Decompiled with CFR 0.150.
 */
import java.util.Random;

public class ng
extends bs {
    private aw[] a;
    private int b;

    public ng(Random random, int n2) {
        this.b = n2;
        this.a = new aw[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a[i2] = new aw(random);
        }
    }

    public double[] a(double[] arrd, double d2, double d3, int n2, int n3, double d4, double d5, double d6) {
        return this.a(arrd, d2, d3, n2, n3, d4, d5, d6, 0.5);
    }

    public double[] a(double[] arrd, double d2, double d3, int n2, int n3, double d4, double d5, double d6, double d7) {
        d4 /= 1.5;
        d5 /= 1.5;
        if (arrd == null || arrd.length < n2 * n3) {
            arrd = new double[n2 * n3];
        } else {
            for (int i2 = 0; i2 < arrd.length; ++i2) {
                arrd[i2] = 0.0;
            }
        }
        double d8 = 1.0;
        double d9 = 1.0;
        for (int i3 = 0; i3 < this.b; ++i3) {
            this.a[i3].a(arrd, d2, d3, n2, n3, d4 * d9, d5 * d9, 0.55 / d8);
            d9 *= d6;
            d8 *= d7;
        }
        return arrd;
    }
}

