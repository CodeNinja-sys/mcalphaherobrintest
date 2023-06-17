/*
 * Decompiled with CFR 0.150.
 */
import java.util.List;

public class hj
extends lw {
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private int g = 0;
    private boolean h = false;
    public int a = 0;
    public eb b;
    private int i;
    private int j = 0;
    private int k = 0;
    public lw c = null;
    private int l;
    private double m;
    private double n;
    private double o;
    private double p;
    private double q;
    private double r;
    private double s;
    private double t;

    public hj(cy cy2) {
        super(cy2);
        this.a(0.25f, 0.25f);
    }

    public boolean a(double d2) {
        double d3 = this.aG.b() * 4.0;
        return d2 < (d3 *= 64.0) * d3;
    }

    public hj(cy cy2, double d2, double d3, double d4) {
        this(cy2);
        this.b(d2, d3, d4);
    }

    public hj(cy cy2, eb eb2) {
        super(cy2);
        this.b = eb2;
        this.b.n = this;
        this.a(0.25f, 0.25f);
        this.c(eb2.aw, eb2.ax + 1.62 - (double)eb2.aO, eb2.ay, eb2.aC, eb2.aD);
        this.aw -= (double)(fi.b((float)(this.aC / 180.0f * (float)Math.PI)) * 0.16f);
        this.ax -= (double)0.1f;
        this.ay -= (double)(fi.a((float)(this.aC / 180.0f * (float)Math.PI)) * 0.16f);
        this.b(this.aw, this.ax, this.ay);
        this.aO = 0.0f;
        float f2 = 0.4f;
        this.az = -fi.a((float)(this.aC / 180.0f * (float)Math.PI)) * fi.b((float)(this.aD / 180.0f * (float)Math.PI)) * f2;
        this.aB = fi.b((float)(this.aC / 180.0f * (float)Math.PI)) * fi.b((float)(this.aD / 180.0f * (float)Math.PI)) * f2;
        this.aA = -fi.a((float)(this.aD / 180.0f * (float)Math.PI)) * f2;
        this.a(this.az, this.aA, this.aB, 1.5f, 1.0f);
    }

    public void a(double d2, double d3, double d4, float f2, float f3) {
        float f4 = fi.a((double)(d2 * d2 + d3 * d3 + d4 * d4));
        d2 /= (double)f4;
        d3 /= (double)f4;
        d4 /= (double)f4;
        d2 += this.bd.nextGaussian() * (double)0.0075f * (double)f3;
        d3 += this.bd.nextGaussian() * (double)0.0075f * (double)f3;
        d4 += this.bd.nextGaussian() * (double)0.0075f * (double)f3;
        this.az = d2 *= (double)f2;
        this.aA = d3 *= (double)f2;
        this.aB = d4 *= (double)f2;
        float f5 = fi.a((double)(d2 * d2 + d4 * d4));
        this.aE = this.aC = (float)(Math.atan2(d2, d4) * 180.0 / 3.1415927410125732);
        this.aF = this.aD = (float)(Math.atan2(d3, f5) * 180.0 / 3.1415927410125732);
        this.i = 0;
    }

    public void a(double d2, double d3, double d4, float f2, float f3, int n2) {
        this.m = d2;
        this.n = d3;
        this.o = d4;
        this.p = f2;
        this.q = f3;
        this.l = n2;
        this.az = this.r;
        this.aA = this.s;
        this.aB = this.t;
    }

    public void a(double d2, double d3, double d4) {
        this.r = this.az = d2;
        this.s = this.aA = d3;
        this.t = this.aB = d4;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void e_() {
        super.e_();
        if (this.l > 0) {
            double d2;
            double d3 = this.aw + (this.m - this.aw) / (double)this.l;
            double d4 = this.ax + (this.n - this.ax) / (double)this.l;
            double d5 = this.ay + (this.o - this.ay) / (double)this.l;
            for (d2 = this.p - (double)this.aC; d2 < -180.0; d2 += 360.0) {
            }
            while (true) {
                if (!(d2 >= 180.0)) {
                    this.aC = (float)((double)this.aC + d2 / (double)this.l);
                    this.aD = (float)((double)this.aD + (this.q - (double)this.aD) / (double)this.l);
                    --this.l;
                    this.b(d3, d4, d5);
                    this.c(this.aC, this.aD);
                    return;
                }
                d2 -= 360.0;
            }
        }
        if (!this.as.z) {
            fp fp2 = this.b.w();
            if (this.b.aN || !this.b.E() || fp2 == null || fp2.a() != dx.aP || this.f(this.b) > 1024.0) {
                this.J();
                this.b.n = null;
                return;
            }
            if (this.c != null) {
                if (!this.c.aN) {
                    this.aw = this.c.aw;
                    this.ax = this.c.aG.b + (double)this.c.aQ * 0.8;
                    this.ay = this.c.ay;
                    return;
                }
                this.c = null;
            }
        }
        if (this.a > 0) {
            --this.a;
        }
        if (this.h) {
            int n2 = this.as.a(this.d, this.e, this.f);
            if (n2 == this.g) {
                ++this.i;
                if (this.i != 1200) return;
                this.J();
                return;
            }
            this.h = false;
            this.az *= (double)(this.bd.nextFloat() * 0.2f);
            this.aA *= (double)(this.bd.nextFloat() * 0.2f);
            this.aB *= (double)(this.bd.nextFloat() * 0.2f);
            this.i = 0;
            this.j = 0;
        } else {
            ++this.j;
        }
        ao ao2 = ao.b(this.aw, this.ax, this.ay);
        ao ao3 = ao.b(this.aw + this.az, this.ax + this.aA, this.ay + this.aB);
        nx nx2 = this.as.a(ao2, ao3);
        ao2 = ao.b(this.aw, this.ax, this.ay);
        ao3 = ao.b(this.aw + this.az, this.ax + this.aA, this.ay + this.aB);
        if (nx2 != null) {
            ao3 = ao.b(nx2.f.a, nx2.f.b, nx2.f.c);
        }
        lw lw2 = null;
        List list = this.as.b(this, this.aG.a(this.az, this.aA, this.aB).b(1.0, 1.0, 1.0));
        double d6 = 0.0;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            double d7;
            float f2;
            co co2;
            nx nx3;
            lw lw3 = (lw)list.get(i2);
            if (!lw3.n_() || lw3 == this.b && this.j < 5 || (nx3 = (co2 = lw3.aG.b(f2 = 0.3f, f2, f2)).a(ao2, ao3)) == null || !((d7 = ao2.c(nx3.f)) < d6) && d6 != 0.0) continue;
            lw2 = lw3;
            d6 = d7;
        }
        if (lw2 != null) {
            nx2 = new nx(lw2);
        }
        if (nx2 != null) {
            if (nx2.g != null) {
                if (nx2.g.a(this.b, 0)) {
                    this.c = nx2.g;
                }
            } else {
                this.h = true;
            }
        }
        if (this.h) {
            return;
        }
        this.d(this.az, this.aA, this.aB);
        float f3 = fi.a((double)(this.az * this.az + this.aB * this.aB));
        this.aC = (float)(Math.atan2(this.az, this.aB) * 180.0 / 3.1415927410125732);
        this.aD = (float)(Math.atan2(this.aA, f3) * 180.0 / 3.1415927410125732);
        while (this.aD - this.aF < -180.0f) {
            this.aF -= 360.0f;
        }
        while (this.aD - this.aF >= 180.0f) {
            this.aF += 360.0f;
        }
        while (this.aC - this.aE < -180.0f) {
            this.aE -= 360.0f;
        }
        while (this.aC - this.aE >= 180.0f) {
            this.aE += 360.0f;
        }
        this.aD = this.aF + (this.aD - this.aF) * 0.2f;
        this.aC = this.aE + (this.aC - this.aE) * 0.2f;
        float f4 = 0.92f;
        if (this.aH || this.aI) {
            f4 = 0.5f;
        }
        int n3 = 5;
        double d8 = 0.0;
        for (int i3 = 0; i3 < n3; ++i3) {
            double d9 = this.aG.b + (this.aG.e - this.aG.b) * (double)(i3 + 0) / (double)n3 - 0.125 + 0.125;
            double d10 = this.aG.b + (this.aG.e - this.aG.b) * (double)(i3 + 1) / (double)n3 - 0.125 + 0.125;
            co co3 = co.b(this.aG.a, d9, this.aG.c, this.aG.d, d10, this.aG.f);
            if (!this.as.b(co3, hb.f)) continue;
            d8 += 1.0 / (double)n3;
        }
        if (d8 > 0.0) {
            if (this.k > 0) {
                --this.k;
            } else if (this.bd.nextInt(500) == 0) {
                float f5;
                this.k = this.bd.nextInt(30) + 10;
                this.aA -= (double)0.2f;
                this.as.a(this, "random.splash", 0.25f, 1.0f + (this.bd.nextFloat() - this.bd.nextFloat()) * 0.4f);
                float f6 = fi.b(this.aG.b);
                int n4 = 0;
                while ((float)n4 < 1.0f + this.aP * 20.0f) {
                    f5 = (this.bd.nextFloat() * 2.0f - 1.0f) * this.aP;
                    float f7 = (this.bd.nextFloat() * 2.0f - 1.0f) * this.aP;
                    this.as.a("bubble", this.aw + (double)f5, f6 + 1.0f, this.ay + (double)f7, this.az, this.aA - (double)(this.bd.nextFloat() * 0.2f), this.aB);
                    ++n4;
                }
                n4 = 0;
                while ((float)n4 < 1.0f + this.aP * 20.0f) {
                    f5 = (this.bd.nextFloat() * 2.0f - 1.0f) * this.aP;
                    float f8 = (this.bd.nextFloat() * 2.0f - 1.0f) * this.aP;
                    this.as.a("splash", this.aw + (double)f5, f6 + 1.0f, this.ay + (double)f8, this.az, this.aA, this.aB);
                    ++n4;
                }
            }
        }
        if (this.k > 0) {
            this.aA -= (double)(this.bd.nextFloat() * this.bd.nextFloat() * this.bd.nextFloat()) * 0.2;
        }
        double d11 = d8 * 2.0 - 1.0;
        this.aA += (double)0.04f * d11;
        if (d8 > 0.0) {
            f4 = (float)((double)f4 * 0.9);
            this.aA *= 0.8;
        }
        this.az *= (double)f4;
        this.aA *= (double)f4;
        this.aB *= (double)f4;
        this.b(this.aw, this.ax, this.ay);
    }

    public void a(iq iq2) {
        iq2.a("xTile", (short)this.d);
        iq2.a("yTile", (short)this.e);
        iq2.a("zTile", (short)this.f);
        iq2.a("inTile", (byte)this.g);
        iq2.a("shake", (byte)this.a);
        iq2.a("inGround", (byte)(this.h ? 1 : 0));
    }

    public void b(iq iq2) {
        this.d = iq2.d("xTile");
        this.e = iq2.d("yTile");
        this.f = iq2.d("zTile");
        this.g = iq2.c("inTile") & 0xFF;
        this.a = iq2.c("shake") & 0xFF;
        this.h = iq2.c("inGround") == 1;
    }

    public float i_() {
        return 0.0f;
    }

    public int k() {
        int n2 = 0;
        if (this.c != null) {
            double d2 = this.b.aw - this.aw;
            double d3 = this.b.ax - this.ax;
            double d4 = this.b.ay - this.ay;
            double d5 = fi.a((double)(d2 * d2 + d3 * d3 + d4 * d4));
            double d6 = 0.1;
            this.c.az += d2 * d6;
            this.c.aA += d3 * d6 + (double)fi.a((double)d5) * 0.08;
            this.c.aB += d4 * d6;
            n2 = 3;
        } else if (this.k > 0) {
            eo eo2 = new eo(this.as, this.aw, this.ax, this.ay, new fp(dx.aS.aW));
            double d7 = this.b.aw - this.aw;
            double d8 = this.b.ax - this.ax;
            double d9 = this.b.ay - this.ay;
            double d10 = fi.a((double)(d7 * d7 + d8 * d8 + d9 * d9));
            double d11 = 0.1;
            eo2.az = d7 * d11;
            eo2.aA = d8 * d11 + (double)fi.a((double)d10) * 0.08;
            eo2.aB = d9 * d11;
            this.as.a(eo2);
            n2 = 1;
        }
        if (this.h) {
            n2 = 2;
        }
        this.J();
        this.b.n = null;
        return n2;
    }
}

