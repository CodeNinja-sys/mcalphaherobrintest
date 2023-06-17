/*
 * Decompiled with CFR 0.150.
 */
public class qe
extends dx {
    public qe(int n2) {
        super(n2);
        this.aY = 64;
    }

    public boolean a(fp fp2, eb eb2, cy cy2, int n2, int n3, int n4, int n5) {
        kp kp2;
        if (n5 == 0) {
            return false;
        }
        if (n5 == 1) {
            return false;
        }
        int n6 = 0;
        if (n5 == 4) {
            n6 = 1;
        }
        if (n5 == 3) {
            n6 = 2;
        }
        if (n5 == 5) {
            n6 = 3;
        }
        if ((kp2 = new kp(cy2, n2, n3, n4, n6)).k()) {
            cy2.a(kp2);
            --fp2.a;
        }
        return true;
    }
}

