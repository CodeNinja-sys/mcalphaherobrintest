/*
 * Decompiled with CFR 0.150.
 */
public class ag
extends dx {
    private int a;

    public ag(int n2, int n3) {
        super(n2);
        this.aX = 1;
        this.aY = 64;
        this.a = n3;
    }

    public fp a(fp fp2, cy cy2, eb eb2) {
        float f2;
        float f3;
        float f4;
        double d2;
        float f5;
        float f6 = 1.0f;
        float f7 = eb2.aF + (eb2.aD - eb2.aF) * f6;
        float f8 = eb2.aE + (eb2.aC - eb2.aE) * f6;
        double d3 = eb2.at + (eb2.aw - eb2.at) * (double)f6;
        double d4 = eb2.au + (eb2.ax - eb2.au) * (double)f6 + 1.62 - (double)eb2.aO;
        double d5 = eb2.av + (eb2.ay - eb2.av) * (double)f6;
        ao ao2 = ao.b(d3, d4, d5);
        float f9 = fi.b((float)(-f8 * ((float)Math.PI / 180) - (float)Math.PI));
        float f10 = fi.a((float)(-f8 * ((float)Math.PI / 180) - (float)Math.PI));
        float f11 = f10 * (f5 = -fi.b((float)(-f7 * ((float)Math.PI / 180))));
        ao ao3 = ao2.c((double)f11 * (d2 = 5.0), (double)(f4 = (f3 = fi.a((float)(-f7 * ((float)Math.PI / 180))))) * d2, (double)(f2 = f9 * f5) * d2);
        nx nx2 = cy2.a(ao2, ao3, this.a == 0);
        if (nx2 == null) {
            return fp2;
        }
        if (nx2.a == 0) {
            int n2 = nx2.b;
            int n3 = nx2.c;
            int n4 = nx2.d;
            if (!cy2.a(eb2, n2, n3, n4)) {
                return fp2;
            }
            if (this.a == 0) {
                if (cy2.f(n2, n3, n4) == hb.f && cy2.e(n2, n3, n4) == 0) {
                    cy2.d(n2, n3, n4, 0);
                    return new fp(dx.av);
                }
                if (cy2.f(n2, n3, n4) == hb.g && cy2.e(n2, n3, n4) == 0) {
                    cy2.d(n2, n3, n4, 0);
                    return new fp(dx.aw);
                }
            } else {
                if (this.a < 0) {
                    return new fp(dx.au);
                }
                if (nx2.e == 0) {
                    --n3;
                }
                if (nx2.e == 1) {
                    ++n3;
                }
                if (nx2.e == 2) {
                    --n4;
                }
                if (nx2.e == 3) {
                    ++n4;
                }
                if (nx2.e == 4) {
                    --n2;
                }
                if (nx2.e == 5) {
                    ++n2;
                }
                if (cy2.a(n2, n3, n4) == 0 || !cy2.f(n2, n3, n4).a()) {
                    if (cy2.q.d && this.a == nq.A.bh) {
                        cy2.a(d3 + 0.5, d4 + 0.5, d5 + 0.5, "random.fizz", 0.5f, 2.6f + (cy2.l.nextFloat() - cy2.l.nextFloat()) * 0.8f);
                        for (int i2 = 0; i2 < 8; ++i2) {
                            cy2.a("largesmoke", (double)n2 + Math.random(), (double)n3 + Math.random(), (double)n4 + Math.random(), 0.0, 0.0, 0.0);
                        }
                    } else {
                        cy2.b(n2, n3, n4, this.a, 0);
                    }
                    return new fp(dx.au);
                }
            }
        } else if (this.a == 0 && nx2.g instanceof as) {
            return new fp(dx.aE);
        }
        return fp2;
    }
}

