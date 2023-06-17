/*
 * Decompiled with CFR 0.150.
 */
public class nt
extends ef {
    public nt(cy cy2) {
        super(cy2);
        this.z = "/mob/zombie.png";
        this.am = 0.5f;
        this.f = 5;
    }

    public void k() {
        float f2;
        if (this.as.d() && (f2 = this.a(1.0f)) > 0.5f && this.as.i(fi.b(this.aw), fi.b(this.ax), fi.b(this.ay)) && this.bd.nextFloat() * 30.0f < (f2 - 0.4f) * 2.0f) {
            this.bg = 300;
        }
        super.k();
    }

    protected String d() {
        return "mob.zombie";
    }

    protected String f_() {
        return "mob.zombiehurt";
    }

    protected String f() {
        return "mob.zombiedeath";
    }

    protected int g_() {
        return dx.J.aW;
    }
}

