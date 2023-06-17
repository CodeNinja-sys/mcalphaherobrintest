/*
 * Decompiled with CFR 0.150.
 */
public class op
extends ak {
    public boolean a = false;

    public op(cy cy2) {
        super(cy2);
        this.z = "/mob/pig.png";
        this.a(0.9f, 0.9f);
        this.a = false;
    }

    public void a(iq iq2) {
        super.a(iq2);
        iq2.a("Saddle", this.a);
    }

    public void b(iq iq2) {
        super.b(iq2);
        this.a = iq2.m("Saddle");
    }

    protected String d() {
        return "mob.pig";
    }

    protected String f_() {
        return "mob.pig";
    }

    protected String f() {
        return "mob.pigdeath";
    }

    public boolean a(eb eb2) {
        if (this.a) {
            eb2.h(this);
            return true;
        }
        return false;
    }

    protected int g_() {
        return dx.ao.aW;
    }
}

