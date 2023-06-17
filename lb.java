/*
 * Decompiled with CFR 0.150.
 */
public class lb
extends dx {
    public int a;

    public lb(int n2, int n3) {
        super(n2);
        this.aX = 1;
        this.a = n3;
    }

    public boolean a(fp fp2, eb eb2, cy cy2, int n2, int n3, int n4, int n5) {
        int n6 = cy2.a(n2, n3, n4);
        if (n6 == nq.aG.bh) {
            if (!cy2.z) {
                cy2.a(new qd(cy2, (float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, this.a));
            }
            --fp2.a;
            return true;
        }
        return false;
    }
}

