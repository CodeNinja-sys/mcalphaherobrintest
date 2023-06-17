/*
 * Decompiled with CFR 0.150.
 */
public class hh
extends dx {
    private int a;

    public hh(int n2, nq nq2) {
        super(n2);
        this.a = nq2.bh;
    }

    public boolean a(fp fp2, eb eb2, cy cy2, int n2, int n3, int n4, int n5) {
        if (cy2.a(n2, n3, n4) == nq.aS.bh) {
            n5 = 0;
        } else {
            if (n5 == 0) {
                --n3;
            }
            if (n5 == 1) {
                ++n3;
            }
            if (n5 == 2) {
                --n4;
            }
            if (n5 == 3) {
                ++n4;
            }
            if (n5 == 4) {
                --n2;
            }
            if (n5 == 5) {
                ++n2;
            }
        }
        if (fp2.a == 0) {
            return false;
        }
        if (cy2.a(this.a, n2, n3, n4, false)) {
            nq nq2 = nq.m[this.a];
            if (cy2.d(n2, n3, n4, this.a)) {
                nq.m[this.a].d(cy2, n2, n3, n4, n5);
                cy2.a((float)n2 + 0.5f, (double)((float)n3 + 0.5f), (double)((float)n4 + 0.5f), nq2.bq.d(), (nq2.bq.b() + 1.0f) / 2.0f, nq2.bq.c() * 0.8f);
                --fp2.a;
            }
        }
        return true;
    }
}

