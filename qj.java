/*
 * Decompiled with CFR 0.150.
 */
import java.util.Random;

public class qj
extends nq {
    private boolean a;

    public qj(int n2, boolean bl2) {
        super(n2, 6, hb.d);
        this.a = bl2;
        if (!bl2) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
        this.d(255);
    }

    public int a(int n2) {
        if (n2 <= 1) {
            return 6;
        }
        return 5;
    }

    public boolean a() {
        return this.a;
    }

    public void a(cy cy2, int n2, int n3, int n4, int n5) {
        if (this != nq.ak) {
            return;
        }
    }

    public void e(cy cy2, int n2, int n3, int n4) {
        int n5;
        if (this != nq.ak) {
            super.e(cy2, n2, n3, n4);
        }
        if ((n5 = cy2.a(n2, n3 - 1, n4)) == qj.ak.bh) {
            cy2.d(n2, n3, n4, 0);
            cy2.d(n2, n3 - 1, n4, nq.aj.bh);
        }
    }

    public int a(int n2, Random random) {
        return nq.ak.bh;
    }

    public boolean b() {
        return this.a;
    }

    public boolean b(pk pk2, int n2, int n3, int n4, int n5) {
        if (this != nq.ak) {
            super.b(pk2, n2, n3, n4, n5);
        }
        if (n5 == 1) {
            return true;
        }
        if (!super.b(pk2, n2, n3, n4, n5)) {
            return false;
        }
        if (n5 == 0) {
            return true;
        }
        return pk2.a(n2, n3, n4) != this.bh;
    }
}

