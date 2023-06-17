/*
 * Decompiled with CFR 0.150.
 */
public abstract class lh
extends nq {
    protected lh(int n2, hb hb2) {
        super(n2, hb2);
        lh.p[n2] = true;
    }

    protected lh(int n2, int n3, hb hb2) {
        super(n2, n3, hb2);
    }

    public void e(cy cy2, int n2, int n3, int n4) {
        super.e(cy2, n2, n3, n4);
        cy2.a(n2, n3, n4, this.a_());
    }

    public void b(cy cy2, int n2, int n3, int n4) {
        super.b(cy2, n2, n3, n4);
        cy2.l(n2, n3, n4);
    }

    protected abstract ji a_();
}

