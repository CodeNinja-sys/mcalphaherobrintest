/*
 * Decompiled with CFR 0.150.
 */
public class dg
extends nq {
    protected dg(int n2, int n3) {
        super(n2, n3, hb.c);
    }

    public int a(int n2) {
        return this.bg + (n2 == 1 ? 1 : 0);
    }

    public boolean a(cy cy2, int n2, int n3, int n4, eb eb2) {
        int n5 = cy2.e(n2, n3, n4);
        if (n5 > 0) {
            this.e(cy2, n2, n3, n4, n5);
            return true;
        }
        return false;
    }

    public void e(cy cy2, int n2, int n3, int n4, int n5) {
        cy2.a((String)null, n2, n3, n4);
        cy2.b(n2, n3, n4, 0);
        int n6 = dx.aU.aW + n5 - 1;
        float f2 = 0.7f;
        double d2 = (double)(cy2.l.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
        double d3 = (double)(cy2.l.nextFloat() * f2) + (double)(1.0f - f2) * 0.2 + 0.6;
        double d4 = (double)(cy2.l.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
        eo eo2 = new eo(cy2, (double)n2 + d2, (double)n3 + d3, (double)n4 + d4, new fp(n6));
        eo2.c = 10;
        cy2.a(eo2);
    }

    public void a(cy cy2, int n2, int n3, int n4, int n5, float f2) {
        if (cy2.z) {
            return;
        }
        if (n5 > 0) {
            this.e(cy2, n2, n3, n4, n5);
        }
        super.a(cy2, n2, n3, n4, n5, f2);
    }
}

