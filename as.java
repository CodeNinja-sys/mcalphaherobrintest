/*
 * Decompiled with CFR 0.150.
 */
public class as
extends ak {
    public boolean a = false;

    public as(cy cy2) {
        super(cy2);
        this.z = "/mob/cow.png";
        this.a(0.9f, 1.3f);
    }

    public void a(iq iq2) {
        super.a(iq2);
    }

    public void b(iq iq2) {
        super.b(iq2);
    }

    protected String d() {
        return "mob.cow";
    }

    protected String f_() {
        return "mob.cowhurt";
    }

    protected String f() {
        return "mob.cowhurt";
    }

    protected float h() {
        return 0.4f;
    }

    protected int g_() {
        return dx.aD.aW;
    }

    public boolean a(eb eb2) {
        fp fp2 = eb2.e.a();
        if (fp2 != null && fp2.c == dx.au.aW) {
            eb2.e.a(eb2.e.d, new fp(dx.aE));
            return true;
        }
        return false;
    }
}

