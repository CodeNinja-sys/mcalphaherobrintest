/*
 * Decompiled with CFR 0.150.
 */
public class ey
extends dx {
    public ey(int n2) {
        super(n2);
    }

    public boolean a(fp fp2, eb eb2, cy cy2, int n2, int n3, int n4, int n5) {
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
        if (cy2.a(n2, n3, n4) != 0) {
            return false;
        }
        if (nq.av.a(cy2, n2, n3, n4)) {
            --fp2.a;
            cy2.d(n2, n3, n4, nq.av.bh);
        }
        return true;
    }
}

