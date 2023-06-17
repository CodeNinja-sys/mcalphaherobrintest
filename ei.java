/*
 * Decompiled with CFR 0.150.
 */
import java.util.Arrays;

public class ei
extends po {
    private gg e;
    private double f;
    private double g;

    public ei(gg gg2, double d2, double d3) {
        this.e = gg2;
        this.f = d2;
        this.g = d3;
    }

    public gg a(qm qm2) {
        return this.e;
    }

    public gg a(int n2, int n3) {
        return this.e;
    }

    public double b(int n2, int n3) {
        return this.f;
    }

    public gg[] a(int n2, int n3, int n4, int n5) {
        this.d = this.a(this.d, n2, n3, n4, n5);
        return this.d;
    }

    public double[] a(double[] arrd, int n2, int n3, int n4, int n5) {
        if (arrd == null || arrd.length < n4 * n5) {
            arrd = new double[n4 * n5];
        }
        Arrays.fill(arrd, 0, n4 * n5, this.f);
        return arrd;
    }

    public gg[] a(gg[] arrgg, int n2, int n3, int n4, int n5) {
        if (arrgg == null || arrgg.length < n4 * n5) {
            arrgg = new gg[n4 * n5];
            this.a = new double[n4 * n5];
            this.b = new double[n4 * n5];
        }
        Arrays.fill(arrgg, 0, n4 * n5, this.e);
        Arrays.fill(this.b, 0, n4 * n5, this.g);
        Arrays.fill(this.a, 0, n4 * n5, this.f);
        return arrgg;
    }
}

