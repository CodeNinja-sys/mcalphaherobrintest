/*
 * Decompiled with CFR 0.150.
 */
public class nv
extends dx {
    public nv(int n2) {
        super(n2);
        this.aY = 64;
        this.aX = 1;
    }

    public boolean a(fp fp2, eb eb2, cy cy2, int n2, int n3, int n4, int n5) {
        if (n5 == 0) {
            return false;
        }
        if (!cy2.f(n2, n3, n4).a()) {
            return false;
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
        if (!nq.aD.a(cy2, n2, n3, n4)) {
            return false;
        }
        if (n5 == 1) {
            cy2.b(n2, n3, n4, nq.aD.bh, fi.b((double)((eb2.aC + 180.0f) * 16.0f / 360.0f) + 0.5) & 0xF);
        } else {
            cy2.b(n2, n3, n4, nq.aI.bh, n5);
        }
        --fp2.a;
        qc qc2 = (qc)cy2.b(n2, n3, n4);
        if (qc2 != null) {
            eb2.a(qc2);
        }
        return true;
    }
}

