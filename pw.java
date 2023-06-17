/*
 * Decompiled with CFR 0.150.
 */
public class pw
extends dx {
    public pw(int n2) {
        super(n2);
        this.aX = 1;
        this.aY = 64;
    }

    public boolean a(fp fp2, eb eb2, cy cy2, int n2, int n3, int n4, int n5) {
        int n6;
        if (n5 == 0) {
            --n3;
        }
        if (n5 == 1) {
            ++n3;
        }
        if (n5 == 2) {
            --n4;
        }
        if (n5 == 3) {
            ++n4;
        }
        if (n5 == 4) {
            --n2;
        }
        if (n5 == 5) {
            ++n2;
        }
        if ((n6 = cy2.a(n2, n3, n4)) == 0) {
            cy2.a((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "fire.ignite", 1.0f, b.nextFloat() * 0.4f + 0.8f);
            cy2.d(n2, n3, n4, nq.ar.bh);
        }
        fp2.b(1);
        return true;
    }
}

