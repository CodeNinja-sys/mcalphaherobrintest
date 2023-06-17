/*
 * Decompiled with CFR 0.150.
 */
import java.util.Random;

public class kz
extends nq {
    protected kz(int n2, int n3) {
        super(n2, hb.i);
        this.bg = n3;
        float f2 = 0.375f;
        this.a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, 1.0f, 0.5f + f2);
        this.b(true);
    }

    public void a(cy cy2, int n2, int n3, int n4, Random random) {
        if (cy2.a(n2, n3 + 1, n4) == 0) {
            int n5 = 1;
            while (cy2.a(n2, n3 - n5, n4) == this.bh) {
                ++n5;
            }
            if (n5 < 3) {
                int n6 = cy2.e(n2, n3, n4);
                if (n6 == 15) {
                    cy2.d(n2, n3 + 1, n4, this.bh);
                    cy2.b(n2, n3, n4, 0);
                } else {
                    cy2.b(n2, n3, n4, n6 + 1);
                }
            }
        }
    }

    public boolean a(cy cy2, int n2, int n3, int n4) {
        int n5 = cy2.a(n2, n3 - 1, n4);
        if (n5 == this.bh) {
            return true;
        }
        if (n5 != nq.u.bh && n5 != nq.v.bh) {
            return false;
        }
        if (cy2.f(n2 - 1, n3 - 1, n4) == hb.f) {
            return true;
        }
        if (cy2.f(n2 + 1, n3 - 1, n4) == hb.f) {
            return true;
        }
        if (cy2.f(n2, n3 - 1, n4 - 1) == hb.f) {
            return true;
        }
        return cy2.f(n2, n3 - 1, n4 + 1) == hb.f;
    }

    public void a(cy cy2, int n2, int n3, int n4, int n5) {
        this.h(cy2, n2, n3, n4);
    }

    protected final void h(cy cy2, int n2, int n3, int n4) {
        if (!this.g(cy2, n2, n3, n4)) {
            this.b_(cy2, n2, n3, n4, cy2.e(n2, n3, n4));
            cy2.d(n2, n3, n4, 0);
        }
    }

    public boolean g(cy cy2, int n2, int n3, int n4) {
        return this.a(cy2, n2, n3, n4);
    }

    public co d(cy cy2, int n2, int n3, int n4) {
        return null;
    }

    public int a(int n2, Random random) {
        return dx.aH.aW;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public int g() {
        return 1;
    }
}

