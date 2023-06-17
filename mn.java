/*
 * Decompiled with CFR 0.150.
 */
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.GL11;

public class mn {
    private Map o = new HashMap();
    public static mn a = new mn();
    private ls p;
    public static double b;
    public static double c;
    public static double d;
    public fu e;
    public ku f;
    public cy g;
    public eb h;
    public float i;
    public float j;
    public gq k;
    public double l;
    public double m;
    public double n;

    private mn() {
        this.o.put(be.class, new ql());
        this.o.put(op.class, new hp(new cj(), new cj(0.5f), 0.7f));
        this.o.put(bx.class, new pr(new ia(), new cg(), 0.7f));
        this.o.put(as.class, new nu(new el(), 0.7f));
        this.o.put(ou.class, new fk(new mk(), 0.3f));
        this.o.put(dq.class, new g());
        this.o.put(dh.class, new m(new gu(), 0.5f));
        this.o.put(nt.class, new m(new ck(), 0.5f));
        this.o.put(ns.class, new ht(new ik(16), new ik(0), 0.25f));
        this.o.put(eb.class, new ce());
        this.o.put(ip.class, new pz(new ck(), 0.5f, 6.0f));
        this.o.put(am.class, new jz());
        this.o.put(hf.class, new ec(new dc(), 0.5f));
        this.o.put(lw.class, new hm());
        this.o.put(kp.class, new cf());
        this.o.put(lv.class, new hn());
        this.o.put(at.class, new fb());
        this.o.put(az.class, new gl());
        this.o.put(eo.class, new af());
        this.o.put(kr.class, new jb());
        this.o.put(gb.class, new dy());
        this.o.put(qd.class, new mi());
        this.o.put(dp.class, new da());
        this.o.put(hj.class, new jw());
        for (aq aq2 : this.o.values()) {
            aq2.a(this);
        }
    }

    public aq a(Class class_) {
        aq aq2 = (aq)this.o.get(class_);
        if (aq2 == null && class_ != lw.class) {
            aq2 = this.a(class_.getSuperclass());
            this.o.put(class_, aq2);
        }
        return aq2;
    }

    public aq a(lw lw2) {
        return this.a(lw2.getClass());
    }

    public void a(cy cy2, fu fu2, ls ls2, eb eb2, gq gq2, float f2) {
        this.g = cy2;
        this.e = fu2;
        this.k = gq2;
        this.h = eb2;
        this.p = ls2;
        this.i = eb2.aE + (eb2.aC - eb2.aE) * f2;
        this.j = eb2.aF + (eb2.aD - eb2.aF) * f2;
        this.l = eb2.aV + (eb2.aw - eb2.aV) * (double)f2;
        this.m = eb2.aW + (eb2.ax - eb2.aW) * (double)f2;
        this.n = eb2.aX + (eb2.ay - eb2.aX) * (double)f2;
    }

    public void a(lw lw2, float f2) {
        double d2 = lw2.aV + (lw2.aw - lw2.aV) * (double)f2;
        double d3 = lw2.aW + (lw2.ax - lw2.aW) * (double)f2;
        double d4 = lw2.aX + (lw2.ay - lw2.aX) * (double)f2;
        float f3 = lw2.aE + (lw2.aC - lw2.aE) * f2;
        float f4 = lw2.a(f2);
        GL11.glColor3f(f4, f4, f4);
        this.a(lw2, d2 - b, d3 - c, d4 - d, f3, f2);
    }

    public void a(lw lw2, double d2, double d3, double d4, float f2, float f3) {
        aq aq2 = this.a(lw2);
        if (aq2 != null) {
            aq2.a(lw2, d2, d3, d4, f2, f3);
            aq2.b(lw2, d2, d3, d4, f2, f3);
        }
    }

    public void a(cy cy2) {
        this.g = cy2;
    }

    public double a(double d2, double d3, double d4) {
        double d5 = d2 - this.l;
        double d6 = d3 - this.m;
        double d7 = d4 - this.n;
        return d5 * d5 + d6 * d6 + d7 * d7;
    }

    public ls a() {
        return this.p;
    }
}

