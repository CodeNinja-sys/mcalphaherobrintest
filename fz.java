/*
 * Decompiled with CFR 0.150.
 */
import java.util.Random;

public class fz
extends nq {
    protected fz(int n2, int n3) {
        super(n2, n3, hb.s);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        this.b(true);
    }

    public co d(cy cy2, int n2, int n3, int n4) {
        return null;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean a(cy cy2, int n2, int n3, int n4) {
        int n5 = cy2.a(n2, n3 - 1, n4);
        if (n5 == 0 || !nq.m[n5].a()) {
            return false;
        }
        return cy2.f(n2, n3 - 1, n4).c();
    }

    public void a(cy cy2, int n2, int n3, int n4, int n5) {
        this.h(cy2, n2, n3, n4);
    }

    private boolean h(cy cy2, int n2, int n3, int n4) {
        if (!this.a(cy2, n2, n3, n4)) {
            this.b_(cy2, n2, n3, n4, cy2.e(n2, n3, n4));
            cy2.d(n2, n3, n4, 0);
            return false;
        }
        return true;
    }

    public void a_(cy cy2, int n2, int n3, int n4, int n5) {
        int n6 = dx.aB.aW;
        float f2 = 0.7f;
        double d2 = (double)(cy2.l.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
        double d3 = (double)(cy2.l.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
        double d4 = (double)(cy2.l.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
        eo eo2 = new eo(cy2, (double)n2 + d2, (double)n3 + d3, (double)n4 + d4, new fp(n6));
        eo2.c = 10;
        cy2.a(eo2);
        cy2.d(n2, n3, n4, 0);
    }

    public int a(int n2, Random random) {
        return dx.aB.aW;
    }

    public int a(Random random) {
        return 0;
    }

    public void a(cy cy2, int n2, int n3, int n4, Random random) {
        if (cy2.a(ch.b, n2, n3, n4) > 11) {
            this.b_(cy2, n2, n3, n4, cy2.e(n2, n3, n4));
            cy2.d(n2, n3, n4, 0);
        }
    }

    public boolean b(pk pk2, int n2, int n3, int n4, int n5) {
        hb hb2 = pk2.f(n2, n3, n4);
        if (n5 == 1) {
            return true;
        }
        if (hb2 == this.bs) {
            return false;
        }
        return super.b(pk2, n2, n3, n4, n5);
    }
}

