/*
 * Decompiled with CFR 0.150.
 */
public class eo
extends lw {
    public fp a;
    private int e;
    public int b = 0;
    public int c;
    private int f = 5;
    public float d = (float)(Math.random() * Math.PI * 2.0);

    public eo(cy cy2, double d2, double d3, double d4, fp fp2) {
        super(cy2);
        this.a(0.25f, 0.25f);
        this.aO = this.aQ / 2.0f;
        this.b(d2, d3, d4);
        this.a = fp2;
        this.aC = (float)(Math.random() * 360.0);
        this.az = (float)(Math.random() * (double)0.2f - (double)0.1f);
        this.aA = 0.2f;
        this.aB = (float)(Math.random() * (double)0.2f - (double)0.1f);
        this.aT = false;
    }

    public eo(cy cy2) {
        super(cy2);
        this.a(0.25f, 0.25f);
        this.aO = this.aQ / 2.0f;
    }

    public void e_() {
        super.e_();
        if (this.c > 0) {
            --this.c;
        }
        this.at = this.aw;
        this.au = this.ax;
        this.av = this.ay;
        this.aA -= (double)0.04f;
        if (this.as.f(fi.b(this.aw), fi.b(this.ax), fi.b(this.ay)) == hb.g) {
            this.aA = 0.2f;
            this.az = (this.bd.nextFloat() - this.bd.nextFloat()) * 0.2f;
            this.aB = (this.bd.nextFloat() - this.bd.nextFloat()) * 0.2f;
            this.as.a(this, "random.fizz", 0.4f, 2.0f + this.bd.nextFloat() * 0.4f);
        }
        this.h(this.aw, this.ax, this.ay);
        this.h_();
        this.d(this.az, this.aA, this.aB);
        float f2 = 0.98f;
        if (this.aH) {
            f2 = 0.58800006f;
            int n2 = this.as.a(fi.b(this.aw), fi.b(this.aG.b) - 1, fi.b(this.ay));
            if (n2 > 0) {
                f2 = nq.m[n2].bt * 0.98f;
            }
        }
        this.az *= (double)f2;
        this.aA *= (double)0.98f;
        this.aB *= (double)f2;
        if (this.aH) {
            this.aA *= -0.5;
        }
        ++this.e;
        ++this.b;
        if (this.b >= 6000) {
            this.J();
        }
    }

    public boolean h_() {
        return this.as.a(this.aG, hb.f, this);
    }

    private boolean h(double d2, double d3, double d4) {
        int n2 = fi.b(d2);
        int n3 = fi.b(d3);
        int n4 = fi.b(d4);
        double d5 = d2 - (double)n2;
        double d6 = d3 - (double)n3;
        double d7 = d4 - (double)n4;
        if (nq.o[this.as.a(n2, n3, n4)]) {
            boolean bl2 = !nq.o[this.as.a(n2 - 1, n3, n4)];
            boolean bl3 = !nq.o[this.as.a(n2 + 1, n3, n4)];
            boolean bl4 = !nq.o[this.as.a(n2, n3 - 1, n4)];
            boolean bl5 = !nq.o[this.as.a(n2, n3 + 1, n4)];
            boolean bl6 = !nq.o[this.as.a(n2, n3, n4 - 1)];
            boolean bl7 = !nq.o[this.as.a(n2, n3, n4 + 1)];
            int n5 = -1;
            double d8 = 9999.0;
            if (bl2 && d5 < d8) {
                d8 = d5;
                n5 = 0;
            }
            if (bl3 && 1.0 - d5 < d8) {
                d8 = 1.0 - d5;
                n5 = 1;
            }
            if (bl4 && d6 < d8) {
                d8 = d6;
                n5 = 2;
            }
            if (bl5 && 1.0 - d6 < d8) {
                d8 = 1.0 - d6;
                n5 = 3;
            }
            if (bl6 && d7 < d8) {
                d8 = d7;
                n5 = 4;
            }
            if (bl7 && 1.0 - d7 < d8) {
                d8 = 1.0 - d7;
                n5 = 5;
            }
            float f2 = this.bd.nextFloat() * 0.2f + 0.1f;
            if (n5 == 0) {
                this.az = -f2;
            }
            if (n5 == 1) {
                this.az = f2;
            }
            if (n5 == 2) {
                this.aA = -f2;
            }
            if (n5 == 3) {
                this.aA = f2;
            }
            if (n5 == 4) {
                this.aB = -f2;
            }
            if (n5 == 5) {
                this.aB = f2;
            }
        }
        return false;
    }

    protected void a(int n2) {
        this.a(null, n2);
    }

    public boolean a(lw lw2, int n2) {
        this.M();
        this.f -= n2;
        if (this.f <= 0) {
            this.J();
        }
        return false;
    }

    public void a(iq iq2) {
        iq2.a("Health", (short)((byte)this.f));
        iq2.a("Age", (short)this.b);
        iq2.a("Item", this.a.a(new iq()));
    }

    public void b(iq iq2) {
        this.f = iq2.d("Health") & 0xFF;
        this.b = iq2.d("Age");
        iq iq3 = iq2.k("Item");
        this.a = new fp(iq3);
    }

    public void b(eb eb2) {
        if (this.as.z) {
            return;
        }
        int n2 = this.a.a;
        if (this.c == 0 && eb2.e.a(this.a)) {
            this.as.a(this, "random.pop", 0.2f, ((this.bd.nextFloat() - this.bd.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            eb2.b((lw)this, n2);
            this.J();
        }
    }
}

