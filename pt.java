/*
 * Decompiled with CFR 0.150.
 */
import java.util.List;

public class pt
extends nt {
    private int a = 0;
    private int b = 0;
    private static final fp c = new fp(dx.E, 1);

    public pt(cy cy2) {
        super(cy2);
        this.z = "/mob/pigzombie.png";
        this.am = 0.5f;
        this.f = 5;
        this.bm = true;
    }

    public void e_() {
        float f2 = this.am = this.g != null ? 0.95f : 0.5f;
        if (this.b > 0 && --this.b == 0) {
            this.as.a(this, "mob.zombiepig.zpigangry", this.h() * 2.0f, ((this.bd.nextFloat() - this.bd.nextFloat()) * 0.2f + 1.0f) * 1.8f);
        }
        super.e_();
    }

    public boolean a() {
        return this.as.k > 0 && this.as.a(this.aG) && this.as.a((lw)this, this.aG).size() == 0 && !this.as.b(this.aG);
    }

    public void a(iq iq2) {
        super.a(iq2);
        iq2.a("Anger", (short)this.a);
    }

    public void b(iq iq2) {
        super.b(iq2);
        this.a = iq2.d("Anger");
    }

    protected lw c_() {
        if (this.a == 0) {
            return null;
        }
        return super.c_();
    }

    public void k() {
        super.k();
    }

    public boolean a(lw lw2, int n2) {
        if (lw2 instanceof eb) {
            List list = this.as.b(this, this.aG.b(32.0, 32.0, 32.0));
            for (int i2 = 0; i2 < list.size(); ++i2) {
                lw lw3 = (lw)list.get(i2);
                if (!(lw3 instanceof pt)) continue;
                pt pt2 = (pt)lw3;
                pt2.c(lw2);
            }
            this.c(lw2);
        }
        return super.a(lw2, n2);
    }

    private void c(lw lw2) {
        this.g = lw2;
        this.a = 400 + this.bd.nextInt(400);
        this.b = this.bd.nextInt(40);
    }

    protected String d() {
        return "mob.zombiepig.zpig";
    }

    protected String f_() {
        return "mob.zombiepig.zpighurt";
    }

    protected String f() {
        return "mob.zombiepig.zpigdeath";
    }

    protected int g_() {
        return dx.ap.aW;
    }

    public fp l() {
        return c;
    }
}

