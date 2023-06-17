/*
 * Decompiled with CFR 0.150.
 */
import java.util.Random;

public class je
extends nq {
    protected je(int n2, int n3) {
        super(n2, n3, hb.u);
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

    public co d(cy cy2, int n2, int n3, int n4) {
        float f2 = 0.0625f;
        return co.b((float)n2 + f2, n3, (float)n4 + f2, (float)(n2 + 1) - f2, (float)(n3 + 1) - f2, (float)(n4 + 1) - f2);
    }

    public co f(cy cy2, int n2, int n3, int n4) {
        float f2 = 0.0625f;
        return co.b((float)n2 + f2, n3, (float)n4 + f2, (float)(n2 + 1) - f2, n3 + 1, (float)(n4 + 1) - f2);
    }

    public int a(int n2) {
        if (n2 == 1) {
            return this.bg - 1;
        }
        if (n2 == 0) {
            return this.bg + 1;
        }
        return this.bg;
    }

    public boolean b() {
        return false;
    }

    public boolean a() {
        return false;
    }

    public int g() {
        return 13;
    }

    public boolean a(cy cy2, int n2, int n3, int n4) {
        if (!super.a(cy2, n2, n3, n4)) {
            return false;
        }
        return this.g(cy2, n2, n3, n4);
    }

    public void a(cy cy2, int n2, int n3, int n4, int n5) {
        if (!this.g(cy2, n2, n3, n4)) {
            this.b_(cy2, n2, n3, n4, cy2.e(n2, n3, n4));
            cy2.d(n2, n3, n4, 0);
        }
    }

    public boolean g(cy cy2, int n2, int n3, int n4) {
        if (cy2.f(n2 - 1, n3, n4).a()) {
            return false;
        }
        if (cy2.f(n2 + 1, n3, n4).a()) {
            return false;
        }
        if (cy2.f(n2, n3, n4 - 1).a()) {
            return false;
        }
        if (cy2.f(n2, n3, n4 + 1).a()) {
            return false;
        }
        int n5 = cy2.a(n2, n3 - 1, n4);
        return n5 == nq.aV.bh || n5 == nq.E.bh;
    }

    public void a(cy cy2, int n2, int n3, int n4, lw lw2) {
        lw2.a(null, 1);
    }
}

