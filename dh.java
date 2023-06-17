/*
 * Decompiled with CFR 0.150.
 */
public class dh
extends ef {
    private static final fp a = new fp(dx.i, 1);

    public dh(cy cy2) {
        super(cy2);
        this.z = "/mob/skeleton.png";
    }

    protected String d() {
        return "mob.skeleton";
    }

    protected String f_() {
        return "mob.skeletonhurt";
    }

    protected String f() {
        return "mob.skeletonhurt";
    }

    public void k() {
        float f2;
        if (this.as.d() && (f2 = this.a(1.0f)) > 0.5f && this.as.i(fi.b(this.aw), fi.b(this.ax), fi.b(this.ay)) && this.bd.nextFloat() * 30.0f < (f2 - 0.4f) * 2.0f) {
            this.bg = 300;
        }
        super.k();
    }

    protected void a(lw lw2, float f2) {
        if (f2 < 10.0f) {
            double d2 = lw2.aw - this.aw;
            double d3 = lw2.ay - this.ay;
            if (this.P == 0) {
                lv lv2 = new lv(this.as, this);
                lv2.ax += (double)1.4f;
                double d4 = lw2.ax - (double)0.2f - lv2.ax;
                float f3 = fi.a((double)(d2 * d2 + d3 * d3)) * 0.2f;
                this.as.a(this, "random.bow", 1.0f, 1.0f / (this.bd.nextFloat() * 0.4f + 0.8f));
                this.as.a(lv2);
                lv2.a(d2, d4 + (double)f3, d3, 0.6f, 12.0f);
                this.P = 30;
            }
            this.aC = (float)(Math.atan2(d3, d2) * 180.0 / 3.1415927410125732) - 90.0f;
            this.h = true;
        }
    }

    public void a(iq iq2) {
        super.a(iq2);
    }

    public void b(iq iq2) {
        super.b(iq2);
    }

    protected int g_() {
        return dx.j.aW;
    }

    public fp l() {
        return a;
    }
}

