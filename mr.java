/*
 * Decompiled with CFR 0.150.
 */
public class mr
extends ok {
    protected mr(int n2, int n3) {
        super(n2, n3);
        float f2 = 0.2f;
        this.a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, f2 * 2.0f, 0.5f + f2);
    }

    protected boolean b(int n2) {
        return nq.o[n2];
    }

    public boolean g(cy cy2, int n2, int n3, int n4) {
        return cy2.j(n2, n3, n4) <= 13 && this.b(cy2.a(n2, n3 - 1, n4));
    }
}

