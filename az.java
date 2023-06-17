/*
 * Decompiled with CFR 0.150.
 */
import java.util.List;

public class az
extends lw {
    private int e = -1;
    private int f = -1;
    private int g = -1;
    private int h = 0;
    private boolean i = false;
    public int a = 0;
    private hf j;
    private int k;
    private int l = 0;
    public double b;
    public double c;
    public double d;

    public az(cy cy2) {
        super(cy2);
        this.a(1.0f, 1.0f);
    }

    public boolean a(double d2) {
        double d3 = this.aG.b() * 4.0;
        return d2 < (d3 *= 64.0) * d3;
    }

    public az(cy cy2, hf hf2, double d2, double d3, double d4) {
        super(cy2);
        this.j = hf2;
        this.a(1.0f, 1.0f);
        this.c(hf2.aw, hf2.ax, hf2.ay, hf2.aC, hf2.aD);
        this.b(this.aw, this.ax, this.ay);
        this.aO = 0.0f;
        this.aB = 0.0;
        this.aA = 0.0;
        this.az = 0.0;
        double d5 = fi.a((double)((d2 += this.bd.nextGaussian() * 0.4) * d2 + (d3 += this.bd.nextGaussian() * 0.4) * d3 + (d4 += this.bd.nextGaussian() * 0.4) * d4));
        this.b = d2 / d5 * 0.1;
        this.c = d3 / d5 * 0.1;
        this.d = d4 / d5 * 0.1;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void e_() {
        super.e_();
        this.bg = 10;
        if (this.a > 0) {
            --this.a;
        }
        if (this.i) {
            int n2 = this.as.a(this.e, this.f, this.g);
            if (n2 == this.h) {
                ++this.k;
                if (this.k != 1200) return;
                this.J();
                return;
            }
            this.i = false;
            this.az *= (double)(this.bd.nextFloat() * 0.2f);
            this.aA *= (double)(this.bd.nextFloat() * 0.2f);
            this.aB *= (double)(this.bd.nextFloat() * 0.2f);
            this.k = 0;
            this.l = 0;
        } else {
            ++this.l;
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
        double d2 = 0.0;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            double d3;
            float f2;
            co co2;
            nx nx3;
            lw lw3 = (lw)list.get(i2);
            if (!lw3.n_() || lw3 == this.j && this.l < 25 || (nx3 = (co2 = lw3.aG.b(f2 = 0.3f, f2, f2)).a(ao2, ao3)) == null || !((d3 = ao2.c(nx3.f)) < d2) && d2 != 0.0) continue;
            lw2 = lw3;
            d2 = d3;
        }
        if (lw2 != null) {
            nx2 = new nx(lw2);
        }
        if (nx2 != null) {
            if (nx2.g == null || nx2.g.a(this.j, 0)) {
                // empty if block
            }
            this.as.a(null, this.aw, this.ax, this.ay, 1.0f, true);
            this.J();
        }
        this.aw += this.az;
        this.ax += this.aA;
        this.ay += this.aB;
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
        float f4 = 0.95f;
        if (this.h_()) {
            for (int i3 = 0; i3 < 4; ++i3) {
                float f5 = 0.25f;
                this.as.a("bubble", this.aw - this.az * (double)f5, this.ax - this.aA * (double)f5, this.ay - this.aB * (double)f5, this.az, this.aA, this.aB);
            }
            f4 = 0.8f;
        }
        this.az += this.b;
        this.aA += this.c;
        this.aB += this.d;
        this.az *= (double)f4;
        this.aA *= (double)f4;
        this.aB *= (double)f4;
        this.as.a("smoke", this.aw, this.ax + 0.5, this.ay, 0.0, 0.0, 0.0);
        this.b(this.aw, this.ax, this.ay);
    }

    public void a(iq iq2) {
        iq2.a("xTile", (short)this.e);
        iq2.a("yTile", (short)this.f);
        iq2.a("zTile", (short)this.g);
        iq2.a("inTile", (byte)this.h);
        iq2.a("shake", (byte)this.a);
        iq2.a("inGround", (byte)(this.i ? 1 : 0));
    }

    public void b(iq iq2) {
        this.e = iq2.d("xTile");
        this.f = iq2.d("yTile");
        this.g = iq2.d("zTile");
        this.h = iq2.c("inTile") & 0xFF;
        this.a = iq2.c("shake") & 0xFF;
        this.i = iq2.c("inGround") == 1;
    }

    public boolean n_() {
        return true;
    }

    public float k_() {
        return 1.0f;
    }

    public boolean a(lw lw2, int n2) {
        this.M();
        if (lw2 != null) {
            ao ao2 = lw2.I();
            if (ao2 != null) {
                this.az = ao2.a;
                this.aA = ao2.b;
                this.aB = ao2.c;
                this.b = this.az * 0.1;
                this.c = this.aA * 0.1;
                this.d = this.aB * 0.1;
            }
            return true;
        }
        return false;
    }

    public float i_() {
        return 0.0f;
    }
}

