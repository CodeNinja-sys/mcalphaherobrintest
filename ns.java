/*
 * Decompiled with CFR 0.150.
 */
public class ns
extends hf
implements cz {
    public float a;
    public float b;
    private int d = 0;
    public int c = 1;

    public ns(cy cy2) {
        super(cy2);
        this.z = "/mob/slime.png";
        this.c = 1 << this.bd.nextInt(3);
        this.aO = 0.0f;
        this.d = this.bd.nextInt(20) + 10;
        this.d(this.c);
    }

    public void d(int n2) {
        this.c = n2;
        this.a(0.6f * (float)n2, 0.6f * (float)n2);
        this.J = n2 * n2;
        this.b(this.aw, this.ax, this.ay);
    }

    public void a(iq iq2) {
        super.a(iq2);
        iq2.a("Size", this.c - 1);
    }

    public void b(iq iq2) {
        super.b(iq2);
        this.c = iq2.e("Size") + 1;
    }

    public void e_() {
        this.b = this.a;
        boolean bl2 = this.aH;
        super.e_();
        if (this.aH && !bl2) {
            for (int i2 = 0; i2 < this.c * 8; ++i2) {
                float f2 = this.bd.nextFloat() * (float)Math.PI * 2.0f;
                float f3 = this.bd.nextFloat() * 0.5f + 0.5f;
                float f4 = fi.a((float)f2) * (float)this.c * 0.5f * f3;
                float f5 = fi.b((float)f2) * (float)this.c * 0.5f * f3;
                this.as.a("slime", this.aw + (double)f4, this.aG.b, this.ay + (double)f5, 0.0, 0.0, 0.0);
            }
            if (this.c > 2) {
                this.as.a(this, "mob.slime", this.h(), ((this.bd.nextFloat() - this.bd.nextFloat()) * 0.2f + 1.0f) / 0.8f);
            }
            this.a = -0.5f;
        }
        this.a *= 0.6f;
    }

    protected void b_() {
        eb eb2 = this.as.a((lw)this, 16.0);
        if (eb2 != null) {
            this.b(eb2, 10.0f);
        }
        if (this.aH && this.d-- <= 0) {
            this.d = this.bd.nextInt(20) + 10;
            if (eb2 != null) {
                this.d /= 3;
            }
            this.ak = true;
            if (this.c > 1) {
                this.as.a(this, "mob.slime", this.h(), ((this.bd.nextFloat() - this.bd.nextFloat()) * 0.2f + 1.0f) * 0.8f);
            }
            this.a = 1.0f;
            this.ah = 1.0f - this.bd.nextFloat() * 2.0f;
            this.ai = 1 * this.c;
        } else {
            this.ak = false;
            if (this.aH) {
                this.ai = 0.0f;
                this.ah = 0.0f;
            }
        }
    }

    public void J() {
        if (this.c > 1 && this.J == 0) {
            for (int i2 = 0; i2 < 4; ++i2) {
                float f2 = ((float)(i2 % 2) - 0.5f) * (float)this.c / 4.0f;
                float f3 = ((float)(i2 / 2) - 0.5f) * (float)this.c / 4.0f;
                ns ns2 = new ns(this.as);
                ns2.d(this.c / 2);
                ns2.c(this.aw + (double)f2, this.ax + 0.5, this.ay + (double)f3, this.bd.nextFloat() * 360.0f, 0.0f);
                this.as.a(ns2);
            }
        }
        super.J();
    }

    public void b(eb eb2) {
        if (this.c > 1 && this.d(eb2) && (double)this.e(eb2) < 0.6 * (double)this.c && eb2.a(this, this.c)) {
            this.as.a(this, "mob.slimeattack", 1.0f, (this.bd.nextFloat() - this.bd.nextFloat()) * 0.2f + 1.0f);
        }
    }

    protected String f_() {
        return "mob.slime";
    }

    protected String f() {
        return "mob.slime";
    }

    protected int g_() {
        if (this.c == 1) {
            return dx.aK.aW;
        }
        return 0;
    }

    public boolean a() {
        ha ha2 = this.as.b(fi.b(this.aw), fi.b(this.ay));
        return (this.c == 1 || this.as.k > 0) && this.bd.nextInt(10) == 0 && ha2.a(987234911L).nextInt(10) == 0 && this.ax < 16.0;
    }

    protected float h() {
        return 0.6f;
    }
}

