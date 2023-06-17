/*
 * Decompiled with CFR 0.150.
 */
import java.util.Random;

public class jn
extends nq {
    protected jn(int n2, int n3) {
        super(n2, n3, hb.n);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
    }

    public co d(cy cy2, int n2, int n3, int n4) {
        return null;
    }

    public boolean a() {
        return false;
    }

    public nx a(cy cy2, int n2, int n3, int n4, ao ao2, ao ao3) {
        this.a((pk)cy2, n2, n3, n4);
        return super.a(cy2, n2, n3, n4, ao2, ao3);
    }

    public void a(pk pk2, int n2, int n3, int n4) {
        int n5 = pk2.e(n2, n3, n4);
        if (n5 >= 2 && n5 <= 5) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.625f, 1.0f);
        } else {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        }
    }

    public int a(int n2, int n3) {
        if (n3 >= 6) {
            return this.bg - 16;
        }
        return this.bg;
    }

    public boolean b() {
        return false;
    }

    public int g() {
        return 9;
    }

    public int a(Random random) {
        return 1;
    }

    public boolean a(cy cy2, int n2, int n3, int n4) {
        return cy2.g(n2, n3 - 1, n4);
    }

    public void e(cy cy2, int n2, int n3, int n4) {
        if (!cy2.z) {
            cy2.b(n2, n3, n4, 15);
            this.h(cy2, n2, n3, n4);
        }
    }

    public void a(cy cy2, int n2, int n3, int n4, int n5) {
        if (cy2.z) {
            return;
        }
        int n6 = cy2.e(n2, n3, n4);
        boolean bl2 = false;
        if (!cy2.g(n2, n3 - 1, n4)) {
            bl2 = true;
        }
        if (n6 == 2 && !cy2.g(n2 + 1, n3, n4)) {
            bl2 = true;
        }
        if (n6 == 3 && !cy2.g(n2 - 1, n3, n4)) {
            bl2 = true;
        }
        if (n6 == 4 && !cy2.g(n2, n3, n4 - 1)) {
            bl2 = true;
        }
        if (n6 == 5 && !cy2.g(n2, n3, n4 + 1)) {
            bl2 = true;
        }
        if (bl2) {
            this.b_(cy2, n2, n3, n4, cy2.e(n2, n3, n4));
            cy2.d(n2, n3, n4, 0);
        } else if (n5 > 0 && nq.m[n5].e() && oc.a(new oc(this, cy2, n2, n3, n4)) == 3) {
            this.h(cy2, n2, n3, n4);
        }
    }

    private void h(cy cy2, int n2, int n3, int n4) {
        if (cy2.z) {
            return;
        }
        new oc(this, cy2, n2, n3, n4).a(cy2.o(n2, n3, n4));
    }
}

