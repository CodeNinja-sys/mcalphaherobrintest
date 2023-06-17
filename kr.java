/*
 * Decompiled with CFR 0.150.
 */
public class kr
extends lw {
    public int a = 0;

    public kr(cy cy2) {
        super(cy2);
        this.ap = true;
        this.a(0.98f, 0.98f);
        this.aO = this.aQ / 2.0f;
    }

    public kr(cy cy2, double d2, double d3, double d4) {
        this(cy2);
        this.b(d2, d3, d4);
        float f2 = (float)(Math.random() * 3.1415927410125732 * 2.0);
        this.az = -fi.a((float)(f2 * (float)Math.PI / 180.0f)) * 0.02f;
        this.aA = 0.2f;
        this.aB = -fi.b((float)(f2 * (float)Math.PI / 180.0f)) * 0.02f;
        this.aT = false;
        this.a = 80;
        this.at = d2;
        this.au = d3;
        this.av = d4;
    }

    public boolean n_() {
        return !this.aN;
    }

    public void e_() {
        this.at = this.aw;
        this.au = this.ax;
        this.av = this.ay;
        this.aA -= (double)0.04f;
        this.d(this.az, this.aA, this.aB);
        this.az *= (double)0.98f;
        this.aA *= (double)0.98f;
        this.aB *= (double)0.98f;
        if (this.aH) {
            this.az *= (double)0.7f;
            this.aB *= (double)0.7f;
            this.aA *= -0.5;
        }
        if (this.a-- <= 0) {
            this.J();
            this.k();
        } else {
            this.as.a("smoke", this.aw, this.ax + 0.5, this.ay, 0.0, 0.0, 0.0);
        }
    }

    private void k() {
        float f2 = 4.0f;
        this.as.a(null, this.aw, this.ax, this.ay, f2);
    }

    protected void a(iq iq2) {
        iq2.a("Fuse", (byte)this.a);
    }

    protected void b(iq iq2) {
        this.a = iq2.c("Fuse");
    }

    public float i_() {
        return 0.0f;
    }
}

