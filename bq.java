/*
 * Decompiled with CFR 0.150.
 */
import net.minecraft.client.Minecraft;

public class bq
extends eb {
    public nn a;
    private Minecraft bx;
    public int b = 20;
    private boolean by = false;
    public float c;
    public float d;

    public bq(Minecraft minecraft, cy cy2, ea ea2, int n2) {
        super(cy2);
        this.bx = minecraft;
        this.m = n2;
        if (ea2 != null && ea2.b != null && ea2.b.length() > 0) {
            this.bl = "http://www.minecraft.net/skin/" + ea2.b + ".png";
            System.out.println("Loading texture " + this.bl);
        }
        this.l = ea2.b;
    }

    public void b_() {
        super.b_();
        this.ah = this.a.a;
        this.ai = this.a.b;
        this.ak = this.a.d;
    }

    public void k() {
        this.d = this.c;
        if (this.by) {
            if (this.c == 0.0f) {
                this.bx.A.a("portal.trigger", 1.0f, this.bd.nextFloat() * 0.4f + 0.8f);
            }
            this.c += 0.0125f;
            if (this.c >= 1.0f) {
                this.c = 1.0f;
                this.b = 10;
                this.bx.A.a("portal.travel", 1.0f, this.bd.nextFloat() * 0.4f + 0.8f);
                this.bx.k();
            }
            this.by = false;
        } else {
            if (this.c > 0.0f) {
                this.c -= 0.05f;
            }
            if (this.c < 0.0f) {
                this.c = 0.0f;
            }
        }
        if (this.b > 0) {
            --this.b;
        }
        this.a.a(this);
        if (this.a.e && this.aY < 0.2f) {
            this.aY = 0.2f;
        }
        super.k();
    }

    public void m_() {
        this.a.a();
    }

    public void a(int n2, boolean bl2) {
        this.a.a(n2, bl2);
    }

    public void a(iq iq2) {
        super.a(iq2);
        iq2.a("Score", this.g);
    }

    public void b(iq iq2) {
        super.b(iq2);
        this.g = iq2.e("Score");
    }

    public void a(hi hi2) {
        this.bx.a(new er(this.e, hi2));
    }

    public void a(qc qc2) {
        this.bx.a(new pv(qc2));
    }

    public void m() {
        this.bx.a(new jc(this.e));
    }

    public void a(lt lt2) {
        this.bx.a(new jj(this.e, lt2));
    }

    public void b(lw lw2, int n2) {
        this.bx.h.a(new cm(this.bx.e, lw2, this, -0.5f));
    }

    public int n() {
        return this.e.f();
    }

    public void a_(lw lw2) {
        if (lw2.a(this)) {
            return;
        }
        fp fp2 = this.w();
        if (fp2 != null && lw2 instanceof hf) {
            fp2.b((hf)lw2);
            if (fp2.a <= 0) {
                fp2.a(this);
                this.x();
            }
        }
    }

    public void a(String string) {
    }

    public void o() {
    }

    public boolean p() {
        return this.a.e;
    }

    public void q() {
        if (this.b > 0) {
            this.b = 10;
            return;
        }
        this.by = true;
    }

    public void a_(int n2) {
        int n3 = this.J - n2;
        if (n3 <= 0) {
            this.J = n2;
        } else {
            this.af = n3;
            this.K = this.J;
            this.bj = this.o;
            this.b(n3);
            this.M = 10;
            this.L = 10;
        }
    }

    public void r() {
        this.bx.p();
    }
}

