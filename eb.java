/*
 * Decompiled with CFR 0.150.
 */
import java.util.List;

public class eb
extends hf {
    public fo e = new fo(this);
    public byte f = 0;
    public int g = 0;
    public float h;
    public float i;
    public boolean j = false;
    public int k = 0;
    public String l;
    public int m;
    private int a = 0;
    public hj n = null;

    public eb(cy cy2) {
        super(cy2);
        this.aO = 1.62f;
        this.c((double)cy2.m + 0.5, cy2.n + 1, (double)cy2.o + 0.5, 0.0f, 0.0f);
        this.J = 20;
        this.C = "humanoid";
        this.B = 180.0f;
        this.bf = 20;
        this.z = "/mob/char.png";
    }

    public void s() {
        super.s();
        this.h = this.i;
        this.i = 0.0f;
    }

    public void t() {
        this.aO = 1.62f;
        this.a(0.6f, 1.8f);
        super.t();
        this.J = 20;
        this.O = 0;
    }

    protected void b_() {
        if (this.j) {
            ++this.k;
            if (this.k == 8) {
                this.k = 0;
                this.j = false;
            }
        } else {
            this.k = 0;
        }
        this.I = (float)this.k / 8.0f;
    }

    public void k() {
        List list;
        if (this.as.k == 0 && this.J < 20 && this.be % 20 * 4 == 0) {
            this.c(1);
        }
        this.e.b();
        this.h = this.i;
        super.k();
        float f2 = fi.a((double)(this.az * this.az + this.aB * this.aB));
        float f3 = (float)Math.atan(-this.aA * (double)0.2f) * 15.0f;
        if (f2 > 0.1f) {
            f2 = 0.1f;
        }
        if (!this.aH || this.J <= 0) {
            f2 = 0.0f;
        }
        if (this.aH || this.J <= 0) {
            f3 = 0.0f;
        }
        this.i += (f2 - this.i) * 0.4f;
        this.R += (f3 - this.R) * 0.8f;
        if (this.J > 0 && (list = this.as.b(this, this.aG.b(1.0, 0.0, 1.0))) != null) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                this.i((lw)list.get(i2));
            }
        }
    }

    private void i(lw lw2) {
        lw2.b(this);
    }

    public int u() {
        return this.g;
    }

    public void b(lw lw2) {
        super.b(lw2);
        this.a(0.2f, 0.2f);
        this.b(this.aw, this.ax, this.ay);
        this.aA = 0.1f;
        if (this.l.equals("Notch")) {
            this.a(new fp(dx.h, 1), true);
        }
        this.e.g();
        if (lw2 != null) {
            this.az = -fi.b((float)((this.N + this.aC) * (float)Math.PI / 180.0f)) * 0.1f;
            this.aB = -fi.a((float)((this.N + this.aC) * (float)Math.PI / 180.0f)) * 0.1f;
        } else {
            this.aB = 0.0;
            this.az = 0.0;
        }
        this.aO = 0.1f;
    }

    public void c(lw lw2, int n2) {
        this.g += n2;
    }

    public void a(fp fp2) {
        this.a(fp2, false);
    }

    public void a(fp fp2, boolean bl2) {
        if (fp2 == null) {
            return;
        }
        eo eo2 = new eo(this.as, this.aw, this.ax - (double)0.3f + (double)this.v(), this.ay, fp2);
        eo2.c = 40;
        float f2 = 0.1f;
        if (bl2) {
            float f3 = this.bd.nextFloat() * 0.5f;
            float f4 = this.bd.nextFloat() * (float)Math.PI * 2.0f;
            eo2.az = -fi.a((float)f4) * f3;
            eo2.aB = fi.b((float)f4) * f3;
            eo2.aA = 0.2f;
        } else {
            f2 = 0.3f;
            eo2.az = -fi.a((float)(this.aC / 180.0f * (float)Math.PI)) * fi.b((float)(this.aD / 180.0f * (float)Math.PI)) * f2;
            eo2.aB = fi.b((float)(this.aC / 180.0f * (float)Math.PI)) * fi.b((float)(this.aD / 180.0f * (float)Math.PI)) * f2;
            eo2.aA = -fi.a((float)(this.aD / 180.0f * (float)Math.PI)) * f2 + 0.1f;
            f2 = 0.02f;
            float f5 = this.bd.nextFloat() * (float)Math.PI * 2.0f;
            eo2.az += Math.cos(f5) * (double)(f2 *= this.bd.nextFloat());
            eo2.aA += (double)((this.bd.nextFloat() - this.bd.nextFloat()) * 0.1f);
            eo2.aB += Math.sin(f5) * (double)f2;
        }
        this.a(eo2);
    }

    protected void a(eo eo2) {
        this.as.a(eo2);
    }

    public float a(nq nq2) {
        float f2 = this.e.a(nq2);
        if (this.a(hb.f)) {
            f2 /= 5.0f;
        }
        if (!this.aH) {
            f2 /= 5.0f;
        }
        return f2;
    }

    public boolean b(nq nq2) {
        return this.e.b(nq2);
    }

    public void b(iq iq2) {
        super.b(iq2);
        ly ly2 = iq2.l("Inventory");
        this.e.b(ly2);
        this.m = iq2.e("Dimension");
    }

    public void a(iq iq2) {
        super.a(iq2);
        iq2.a("Inventory", this.e.a(new ly()));
        iq2.a("Dimension", this.m);
    }

    public void a(hi hi2) {
    }

    public void m() {
    }

    public void b(lw lw2, int n2) {
    }

    public float v() {
        return 0.12f;
    }

    public boolean a(lw lw2, int n2) {
        this.ag = 0;
        if (this.J <= 0) {
            return false;
        }
        if (lw2 instanceof ef || lw2 instanceof lv) {
            if (this.as.k == 0) {
                n2 = 0;
            }
            if (this.as.k == 1) {
                n2 = n2 / 3 + 1;
            }
            if (this.as.k == 3) {
                n2 = n2 * 3 / 2;
            }
        }
        if (n2 == 0) {
            return false;
        }
        return super.a(lw2, n2);
    }

    protected void b(int n2) {
        int n3 = 25 - this.e.f();
        int n4 = n2 * n3 + this.a;
        this.e.e(n2);
        n2 = n4 / 25;
        this.a = n4 % 25;
        super.b(n2);
    }

    public void a(lt lt2) {
    }

    public void a(qc qc2) {
    }

    public void a_(lw lw2) {
        lw2.a(this);
    }

    public fp w() {
        return this.e.a();
    }

    public void x() {
        this.e.a(this.e.d, null);
    }

    public double y() {
        return this.aO - 0.5f;
    }

    public void z() {
        this.k = -1;
        this.j = true;
    }

    public void c(lw lw2) {
        int n2 = this.e.a(lw2);
        if (n2 > 0) {
            lw2.a(this, n2);
            fp fp2 = this.w();
            if (fp2 != null && lw2 instanceof hf) {
                fp2.a((hf)lw2);
                if (fp2.a <= 0) {
                    fp2.a(this);
                    this.x();
                }
            }
        }
    }

    public void r() {
    }
}

