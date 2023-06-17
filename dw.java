/*
 * Decompiled with CFR 0.150.
 */
import java.util.Random;

public class dw
extends nq {
    public static boolean a = false;

    public dw(int n2, int n3) {
        super(n2, n3, hb.m);
    }

    public void e(cy cy2, int n2, int n3, int n4) {
        cy2.h(n2, n3, n4, this.bh);
    }

    public void a(cy cy2, int n2, int n3, int n4, int n5) {
        cy2.h(n2, n3, n4, this.bh);
    }

    public void a(cy cy2, int n2, int n3, int n4, Random random) {
        this.h(cy2, n2, n3, n4);
    }

    private void h(cy cy2, int n2, int n3, int n4) {
        int n5 = n2;
        int n6 = n3;
        int n7 = n4;
        if (dw.b_(cy2, n5, n6 - 1, n7) && n6 >= 0) {
            gb gb2 = new gb(cy2, (float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, this.bh);
            if (a) {
                while (!gb2.aN) {
                    gb2.e_();
                }
            } else {
                cy2.a(gb2);
            }
        }
    }

    public int d() {
        return 3;
    }

    public static boolean b_(cy cy2, int n2, int n3, int n4) {
        int n5 = cy2.a(n2, n3, n4);
        if (n5 == 0) {
            return true;
        }
        if (n5 == nq.ar.bh) {
            return true;
        }
        hb hb2 = nq.m[n5].bs;
        if (hb2 == hb.f) {
            return true;
        }
        return hb2 == hb.g;
    }
}

