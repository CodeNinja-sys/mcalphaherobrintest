/*
 * Decompiled with CFR 0.150.
 */
public class mw
extends dx {
    private String a;

    protected mw(int n2, String string) {
        super(n2);
        this.a = string;
        this.aX = 1;
    }

    public boolean a(fp fp2, eb eb2, cy cy2, int n2, int n3, int n4, int n5) {
        if (cy2.a(n2, n3, n4) == nq.aY.bh && cy2.e(n2, n3, n4) == 0) {
            cy2.b(n2, n3, n4, this.aW - dx.aU.aW + 1);
            cy2.a(this.a, n2, n3, n4);
            --fp2.a;
            return true;
        }
        return false;
    }
}

