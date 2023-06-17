/*
 * Decompiled with CFR 0.150.
 */
public class ou
extends ak {
    public boolean a = false;
    public float b = 0.0f;
    public float c = 0.0f;
    public float d;
    public float e;
    public float f = 1.0f;
    public int i;

    public ou(cy cy2) {
        super(cy2);
        this.z = "/mob/chicken.png";
        this.a(0.3f, 0.4f);
        this.J = 4;
        this.i = this.bd.nextInt(6000) + 6000;
    }

    public void k() {
        super.k();
        this.e = this.b;
        this.d = this.c;
        this.c = (float)((double)this.c + (double)(this.aH ? -1 : 4) * 0.3);
        if (this.c < 0.0f) {
            this.c = 0.0f;
        }
        if (this.c > 1.0f) {
            this.c = 1.0f;
        }
        if (!this.aH && this.f < 1.0f) {
            this.f = 1.0f;
        }
        this.f = (float)((double)this.f * 0.9);
        if (!this.aH && this.aA < 0.0) {
            this.aA *= 0.6;
        }
        this.b += this.f * 2.0f;
        if (!this.as.z && --this.i <= 0) {
            this.as.a(this, "mob.chickenplop", 1.0f, (this.bd.nextFloat() - this.bd.nextFloat()) * 0.2f + 1.0f);
            this.b(dx.aN.aW, 1);
            this.i = this.bd.nextInt(6000) + 6000;
        }
    }

    protected void c(float f2) {
    }

    public void a(iq iq2) {
        super.a(iq2);
    }

    public void b(iq iq2) {
        super.b(iq2);
    }

    protected String d() {
        return "mob.chicken";
    }

    protected String f_() {
        return "mob.chickenhurt";
    }

    protected String f() {
        return "mob.chickenhurt";
    }

    protected int g_() {
        return dx.J.aW;
    }
}

