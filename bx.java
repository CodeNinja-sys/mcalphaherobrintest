/*
 * Decompiled with CFR 0.150.
 */
public class bx
extends ak {
    public boolean a = false;

    public bx(cy cy2) {
        super(cy2);
        this.z = "/mob/sheep.png";
        this.a(0.9f, 1.3f);
    }

    public boolean a(lw lw2, int n2) {
        if (!this.as.z && !this.a && lw2 instanceof hf) {
            this.a = true;
            int n3 = 1 + this.bd.nextInt(3);
            for (int i2 = 0; i2 < n3; ++i2) {
                eo eo2 = this.a(nq.ab.bh, 1, 1.0f);
                eo2.aA += (double)(this.bd.nextFloat() * 0.05f);
                eo2.az += (double)((this.bd.nextFloat() - this.bd.nextFloat()) * 0.1f);
                eo2.aB += (double)((this.bd.nextFloat() - this.bd.nextFloat()) * 0.1f);
            }
        }
        return super.a(lw2, n2);
    }

    public void a(iq iq2) {
        super.a(iq2);
        iq2.a("Sheared", this.a);
    }

    public void b(iq iq2) {
        super.b(iq2);
        this.a = iq2.m("Sheared");
    }

    protected String d() {
        return "mob.sheep";
    }

    protected String f_() {
        return "mob.sheep";
    }

    protected String f() {
        return "mob.sheep";
    }
}

