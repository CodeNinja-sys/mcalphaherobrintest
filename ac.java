/*
 * Decompiled with CFR 0.150.
 */
public class ac
extends cb {
    private static nq[] bb = new nq[]{nq.w, nq.aj, nq.ak, nq.t, nq.ao, nq.H, nq.ai, nq.I, nq.ah, nq.G, nq.aw, nq.ax, nq.aT, nq.bb};
    private int bc;

    public ac(int n2, int n3) {
        super(n2, 2, n3, bb);
        this.bc = n3;
    }

    public boolean a(nq nq2) {
        if (nq2 == nq.ap) {
            return this.bc == 3;
        }
        if (nq2 == nq.ax || nq2 == nq.aw) {
            return this.bc >= 2;
        }
        if (nq2 == nq.ah || nq2 == nq.G) {
            return this.bc >= 2;
        }
        if (nq2 == nq.ai || nq2 == nq.H) {
            return this.bc >= 1;
        }
        if (nq2 == nq.aN || nq2 == nq.aO) {
            return this.bc >= 2;
        }
        if (nq2.bs == hb.d) {
            return true;
        }
        return nq2.bs == hb.e;
    }
}

