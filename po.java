/*
 * Decompiled with CFR 0.150.
 */
import java.util.Random;

public class po {
    private ng e;
    private ng f;
    private ng g;
    public double[] a;
    public double[] b;
    public double[] c;
    public gg[] d;

    protected po() {
    }

    public po(cy cy2) {
        this.e = new ng(new Random(cy2.u * 9871L), 4);
        this.f = new ng(new Random(cy2.u * 39811L), 4);
        this.g = new ng(new Random(cy2.u * 543321L), 2);
    }

    public gg a(qm qm2) {
        return this.a(qm2.a, qm2.b);
    }

    public gg a(int n2, int n3) {
        return this.a(n2, n3, 1, 1)[0];
    }

    public double b(int n2, int n3) {
        this.a = this.e.a(this.a, n2, n3, 1, 1, 0.025f, 0.025f, 0.5);
        return this.a[0];
    }

    public gg[] a(int n2, int n3, int n4, int n5) {
        this.d = this.a(this.d, n2, n3, n4, n5);
        return this.d;
    }

    public double[] a(double[] arrd, int n2, int n3, int n4, int n5) {
        if (arrd == null || arrd.length < n4 * n5) {
            arrd = new double[n4 * n5];
        }
        arrd = this.e.a(arrd, n2, n3, n4, n4, 0.025f, 0.025f, 0.25);
        this.c = this.g.a(this.c, n2, n3, n4, n4, 0.25, 0.25, 0.5882352941176471);
        int n6 = 0;
        for (int i2 = 0; i2 < n4; ++i2) {
            for (int i3 = 0; i3 < n5; ++i3) {
                double d2 = this.c[n6] * 1.1 + 0.5;
                double d3 = 0.01;
                double d4 = 1.0 - d3;
                double d5 = (arrd[n6] * 0.15 + 0.7) * d4 + d2 * d3;
                if ((d5 = 1.0 - (1.0 - d5) * (1.0 - d5)) < 0.0) {
                    d5 = 0.0;
                }
                if (d5 > 1.0) {
                    d5 = 1.0;
                }
                arrd[n6] = d5;
                ++n6;
            }
        }
        return arrd;
    }

    public gg[] a(gg[] arrgg, int n2, int n3, int n4, int n5) {
        if (arrgg == null || arrgg.length < n4 * n5) {
            arrgg = new gg[n4 * n5];
        }
        this.a = this.e.a(this.a, n2, n3, n4, n4, 0.025f, 0.025f, 0.25);
        this.b = this.f.a(this.b, n2, n3, n4, n4, 0.05f, 0.05f, 0.3333333333333333);
        this.c = this.g.a(this.c, n2, n3, n4, n4, 0.25, 0.25, 0.5882352941176471);
        int n6 = 0;
        for (int i2 = 0; i2 < n4; ++i2) {
            for (int i3 = 0; i3 < n5; ++i3) {
                double d2 = this.c[n6] * 1.1 + 0.5;
                double d3 = 0.01;
                double d4 = 1.0 - d3;
                double d5 = (this.a[n6] * 0.15 + 0.7) * d4 + d2 * d3;
                d3 = 0.002;
                d4 = 1.0 - d3;
                double d6 = (this.b[n6] * 0.15 + 0.5) * d4 + d2 * d3;
                if ((d5 = 1.0 - (1.0 - d5) * (1.0 - d5)) < 0.0) {
                    d5 = 0.0;
                }
                if (d6 < 0.0) {
                    d6 = 0.0;
                }
                if (d5 > 1.0) {
                    d5 = 1.0;
                }
                if (d6 > 1.0) {
                    d6 = 1.0;
                }
                this.a[n6] = d5;
                this.b[n6] = d6;
                arrgg[n6++] = gg.a(d5, d6);
            }
        }
        return arrgg;
    }
}

