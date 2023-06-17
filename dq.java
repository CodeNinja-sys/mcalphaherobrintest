/*
 * Decompiled with CFR 0.150.
 */
public class dq
extends ef {
    int a;
    int b;
    int c = 30;
    int d = -1;
    int e = -1;

    public dq(cy cy2) {
        super(cy2);
        this.z = "/mob/creeper.png";
    }

    public void a(iq iq2) {
        super.a(iq2);
    }

    public void b(iq iq2) {
        super.b(iq2);
    }

    public void a(byte by2) {
        super.a(by2);
        if (by2 == 4) {
            if (this.a == 0) {
                this.as.a(this, "random.fuse", 1.0f, 0.5f);
            }
            this.d = 1;
        }
        if (by2 == 5) {
            this.d = -1;
        }
    }

    public void e_() {
        this.b = this.a;
        if (this.as.z) {
            this.a += this.d;
            if (this.a < 0) {
                this.a = 0;
            }
            if (this.a >= this.c) {
                this.a = this.c;
            }
        }
        super.e_();
    }

    protected void b_() {
        if (this.e != this.d) {
            this.e = this.d;
            if (this.d > 0) {
                this.as.a((lw)this, (byte)4);
            } else {
                this.as.a((lw)this, (byte)5);
            }
        }
        this.b = this.a;
        if (this.as.z) {
            super.b_();
        } else {
            if (this.a > 0 && this.d < 0) {
                --this.a;
            }
            if (this.d >= 0) {
                this.d = 2;
            }
            super.b_();
            if (this.d != 1) {
                this.d = -1;
            }
        }
    }

    protected String f_() {
        return "mob.creeper";
    }

    protected String f() {
        return "mob.creeperdeath";
    }

    public void b(lw lw2) {
        super.b(lw2);
        if (lw2 instanceof dh) {
            this.b(dx.aU.aW + this.bd.nextInt(2), 1);
        }
    }

    protected void a(lw lw2, float f2) {
        if (this.d <= 0 && f2 < 3.0f || this.d > 0 && f2 < 7.0f) {
            if (this.a == 0) {
                this.as.a(this, "random.fuse", 1.0f, 0.5f);
            }
            this.d = 1;
            ++this.a;
            if (this.a == this.c) {
                this.as.a((lw)this, this.aw, this.ax, this.ay, 3.0f);
                this.J();
            }
            this.h = true;
        }
    }

    public float b(float f2) {
        return ((float)this.b + (float)(this.a - this.b) * f2) / (float)(this.c - 2);
    }

    protected int g_() {
        return dx.K.aW;
    }
}

