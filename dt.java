/*
 * Decompiled with CFR 0.150.
 */
import java.util.Random;

public class dt
extends js {
    public boolean a(cy cy2, Random random, int n2, int n3, int n4) {
        if (cy2.a(n2, n3, n4) != 0) {
            return false;
        }
        if (cy2.a(n2, n3 + 1, n4) != nq.bb.bh) {
            return false;
        }
        cy2.d(n2, n3, n4, nq.bd.bh);
        for (int i2 = 0; i2 < 1500; ++i2) {
            int n5;
            int n6;
            int n7 = n2 + random.nextInt(8) - random.nextInt(8);
            if (cy2.a(n7, n6 = n3 - random.nextInt(12), n5 = n4 + random.nextInt(8) - random.nextInt(8)) != 0) continue;
            int n8 = 0;
            for (int i3 = 0; i3 < 6; ++i3) {
                int n9 = 0;
                if (i3 == 0) {
                    n9 = cy2.a(n7 - 1, n6, n5);
                }
                if (i3 == 1) {
                    n9 = cy2.a(n7 + 1, n6, n5);
                }
                if (i3 == 2) {
                    n9 = cy2.a(n7, n6 - 1, n5);
                }
                if (i3 == 3) {
                    n9 = cy2.a(n7, n6 + 1, n5);
                }
                if (i3 == 4) {
                    n9 = cy2.a(n7, n6, n5 - 1);
                }
                if (i3 == 5) {
                    n9 = cy2.a(n7, n6, n5 + 1);
                }
                if (n9 != nq.bd.bh) continue;
                ++n8;
            }
            if (n8 != true) continue;
            cy2.d(n7, n6, n5, nq.bd.bh);
        }
        return true;
    }
}

