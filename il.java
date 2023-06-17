/*
 * Decompiled with CFR 0.150.
 */
public class il
extends nq {
    protected boolean a;

    protected il(int n2, int n3, hb hb2, boolean bl2) {
        super(n2, n3, hb2);
        this.a = bl2;
    }

    public boolean a() {
        return false;
    }

    public boolean b(pk pk2, int n2, int n3, int n4, int n5) {
        int n6 = pk2.a(n2, n3, n4);
        if (!this.a && n6 == this.bh) {
            return false;
        }
        return super.b(pk2, n2, n3, n4, n5);
    }
}

