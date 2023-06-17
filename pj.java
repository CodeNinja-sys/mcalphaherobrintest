/*
 * Decompiled with CFR 0.150.
 */
import java.util.Random;

public class pj
extends js {
    private int a;

    public pj(int n2) {
        this.a = n2;
    }

    public boolean a(cy cy2, Random random, int n2, int n3, int n4) {
        if (cy2.a(n2, n3 + 1, n4) != nq.t.bh) {
            return false;
        }
        if (cy2.a(n2, n3 - 1, n4) != nq.t.bh) {
            return false;
        }
        if (cy2.a(n2, n3, n4) != 0 && cy2.a(n2, n3, n4) != nq.t.bh) {
            return false;
        }
        int n5 = 0;
        if (cy2.a(n2 - 1, n3, n4) == nq.t.bh) {
            ++n5;
        }
        if (cy2.a(n2 + 1, n3, n4) == nq.t.bh) {
            ++n5;
        }
        if (cy2.a(n2, n3, n4 - 1) == nq.t.bh) {
            ++n5;
        }
        if (cy2.a(n2, n3, n4 + 1) == nq.t.bh) {
            ++n5;
        }
        int n6 = 0;
        if (cy2.a(n2 - 1, n3, n4) == 0) {
            ++n6;
        }
        if (cy2.a(n2 + 1, n3, n4) == 0) {
            ++n6;
        }
        if (cy2.a(n2, n3, n4 - 1) == 0) {
            ++n6;
        }
        if (cy2.a(n2, n3, n4 + 1) == 0) {
            ++n6;
        }
        if (n5 == 3 && n6 == 1) {
            cy2.d(n2, n3, n4, this.a);
            cy2.a = true;
            nq.m[this.a].a(cy2, n2, n3, n4, random);
            cy2.a = false;
        }
        return true;
    }
}

