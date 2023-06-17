/*
 * Decompiled with CFR 0.150.
 */
class na
extends of {
    final /* synthetic */ int c;
    final /* synthetic */ ne d;

    na(ne ne2, ex ex2, hi hi2, int n2, int n3, int n4, int n5) {
        this.d = ne2;
        this.c = n5;
        super(ex2, hi2, n2, n3, n4);
    }

    public int e() {
        return 1;
    }

    public boolean a(fp fp2) {
        if (fp2.a() instanceof oj) {
            return ((oj)fp2.a()).bb == this.c;
        }
        System.out.println(fp2.a().aW + ", " + this.c);
        if (fp2.a().aW == nq.ba.bh) {
            return this.c == 0;
        }
        return false;
    }

    public int c() {
        return 15 + this.c * 16;
    }
}

