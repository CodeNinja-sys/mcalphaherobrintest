/*
 * Decompiled with CFR 0.150.
 */
public class be
extends ef {
    public be(cy cy2) {
        super(cy2);
        this.z = "/mob/spider.png";
        this.a(1.4f, 0.9f);
        this.am = 0.8f;
    }

    public double j() {
        return (double)this.aQ * 0.75 - 0.5;
    }

    protected lw c_() {
        float f2 = this.a(1.0f);
        if (f2 < 0.5f) {
            double d2 = 16.0;
            return this.as.a((lw)this, d2);
        }
        return null;
    }

    protected String d() {
        return "mob.spider";
    }

    protected String f_() {
        return "mob.spider";
    }

    protected String f() {
        return "mob.spiderdeath";
    }

    protected void a(lw lw2, float f2) {
        float f3 = this.a(1.0f);
        if (f3 > 0.5f && this.bd.nextInt(100) == 0) {
            this.g = null;
            return;
        }
        if (f2 > 2.0f && f2 < 6.0f && this.bd.nextInt(10) == 0) {
            if (this.aH) {
                double d2 = lw2.aw - this.aw;
                double d3 = lw2.ay - this.ay;
                float f4 = fi.a((double)(d2 * d2 + d3 * d3));
                this.az = d2 / (double)f4 * 0.5 * (double)0.8f + this.az * (double)0.2f;
                this.aB = d3 / (double)f4 * 0.5 * (double)0.8f + this.aB * (double)0.2f;
                this.aA = 0.4f;
            }
        } else {
            super.a(lw2, f2);
        }
    }

    public void a(iq iq2) {
        super.a(iq2);
    }

    public void b(iq iq2) {
        super.b(iq2);
    }

    protected int g_() {
        return dx.I.aW;
    }
}

