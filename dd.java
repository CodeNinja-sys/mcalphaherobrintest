/*
 * Decompiled with CFR 0.150.
 */
public class dd
extends nq {
    protected dd(int n2) {
        super(n2, hb.c);
        this.bg = 59;
    }

    public int a(int n2) {
        if (n2 == 1) {
            return this.bg - 16;
        }
        if (n2 == 0) {
            return nq.x.a(0);
        }
        if (n2 == 2 || n2 == 4) {
            return this.bg + 1;
        }
        return this.bg;
    }

    public boolean a(cy cy2, int n2, int n3, int n4, eb eb2) {
        eb2.m();
        return true;
    }
}

