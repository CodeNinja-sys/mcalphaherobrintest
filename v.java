/*
 * Decompiled with CFR 0.150.
 */
import java.util.Random;

public class v
extends nq {
    public v(int n2, int n3) {
        super(n2, n3, hb.p);
    }

    public int a(int n2) {
        if (n2 == 0) {
            return this.bg + 2;
        }
        if (n2 == 1) {
            return this.bg + 1;
        }
        return this.bg;
    }

    public void a(cy cy2, int n2, int n3, int n4, int n5) {
        if (n5 > 0 && nq.m[n5].e() && cy2.o(n2, n3, n4)) {
            this.b(cy2, n2, n3, n4, 0);
            cy2.d(n2, n3, n4, 0);
        }
    }

    public int a(Random random) {
        return 0;
    }

    public void c(cy cy2, int n2, int n3, int n4) {
        kr kr2 = new kr(cy2, (float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f);
        kr2.a = cy2.l.nextInt(kr2.a / 4) + kr2.a / 8;
        cy2.a(kr2);
    }

    public void b(cy cy2, int n2, int n3, int n4, int n5) {
        if (cy2.z) {
            return;
        }
        kr kr2 = new kr(cy2, (float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f);
        cy2.a(kr2);
        cy2.a(kr2, "random.fuse", 1.0f, 1.0f);
    }
}

