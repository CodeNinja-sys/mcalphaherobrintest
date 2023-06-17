/*
 * Decompiled with CFR 0.150.
 */
import org.lwjgl.opengl.GL11;

public class cm
extends pp {
    private lw a;
    private lw o;
    private int p = 0;
    private int q = 0;
    private float r;

    public cm(cy cy2, lw lw2, lw lw3, float f2) {
        super(cy2, lw2.aw, lw2.ax, lw2.ay, lw2.az, lw2.aA, lw2.aB);
        this.a = lw2;
        this.o = lw3;
        this.q = 3;
        this.r = f2;
    }

    public void a(is is2, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = ((float)this.p + f2) / (float)this.q;
        f8 *= f8;
        double d2 = this.a.aw;
        double d3 = this.a.ax;
        double d4 = this.a.ay;
        double d5 = this.o.aV + (this.o.aw - this.o.aV) * (double)f2;
        double d6 = this.o.aW + (this.o.ax - this.o.aW) * (double)f2 + (double)this.r;
        double d7 = this.o.aX + (this.o.ay - this.o.aX) * (double)f2;
        double d8 = d2 + (d5 - d2) * (double)f8;
        double d9 = d3 + (d6 - d3) * (double)f8;
        double d10 = d4 + (d7 - d4) * (double)f8;
        int n2 = fi.b(d8);
        int n3 = fi.b(d9 + (double)(this.aO / 2.0f));
        int n4 = fi.b(d10);
        float f9 = this.as.c(n2, n3, n4);
        GL11.glColor4f(f9, f9, f9, 1.0f);
        mn.a.a(this.a, (float)(d8 -= l), (float)(d9 -= m), (float)(d10 -= n), this.a.aC, f2);
    }

    public void e_() {
        ++this.p;
        if (this.p == this.q) {
            this.J();
        }
    }

    public int l_() {
        return 3;
    }
}

