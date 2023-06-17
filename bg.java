/*
 * Decompiled with CFR 0.150.
 */
import java.util.HashSet;
import java.util.Set;

public final class bg {
    private static Set a = new HashSet();

    protected static on a(cy cy2, int n2, int n3) {
        int n4 = n2 + cy2.l.nextInt(16);
        int n5 = cy2.l.nextInt(128);
        int n6 = n3 + cy2.l.nextInt(16);
        return new on(n4, n5, n6);
    }

    public static final int a(cy cy2) {
        int n2;
        a.clear();
        for (n2 = 0; n2 < cy2.d.size(); ++n2) {
            eb eb2 = (eb)cy2.d.get(n2);
            int n3 = fi.b(eb2.aw / 16.0);
            int n4 = fi.b(eb2.ay / 16.0);
            int n5 = 8;
            for (int i2 = -n5; i2 <= n5; ++i2) {
                for (int i3 = -n5; i3 <= n5; ++i3) {
                    a.add(new qm(i2 + n3, i3 + n4));
                }
            }
        }
        n2 = 0;
        for (int i4 = 0; i4 < gy.values().length; ++i4) {
            gy gy2 = gy.values()[i4];
            if (cy2.b(gy2.c) > gy2.d * a.size() / 256) continue;
            block6: for (qm qm2 : a) {
                gg gg2;
                Class[] arrclass;
                if (cy2.l.nextInt(50) != 0 || (arrclass = (gg2 = cy2.a().a(qm2)).a(gy2)) == null || arrclass.length == 0) continue;
                int n6 = cy2.l.nextInt(arrclass.length);
                on on2 = bg.a(cy2, qm2.a * 16, qm2.b * 16);
                int n7 = on2.a;
                int n8 = on2.b;
                int n9 = on2.c;
                if (cy2.g(n7, n8, n9) || cy2.f(n7, n8, n9) != hb.a) continue;
                int n10 = 0;
                for (int i5 = 0; i5 < 3; ++i5) {
                    int n11 = n7;
                    int n12 = n8;
                    int n13 = n9;
                    int n14 = 6;
                    for (int i6 = 0; i6 < 4; ++i6) {
                        hf hf2;
                        float f2;
                        float f3;
                        float f4;
                        float f5;
                        float f6;
                        float f7;
                        float f8;
                        if (!cy2.g(n11 += cy2.l.nextInt(n14) - cy2.l.nextInt(n14), (n12 += cy2.l.nextInt(1) - cy2.l.nextInt(1)) - 1, n13 += cy2.l.nextInt(n14) - cy2.l.nextInt(n14)) || cy2.g(n11, n12, n13) || cy2.f(n11, n12, n13).d() || cy2.g(n11, n12 + 1, n13) || cy2.a(f8 = (float)n11 + 0.5f, f7 = (float)n12, (double)(f6 = (float)n13 + 0.5f), 24.0) != null || (f5 = (f4 = f8 - (float)cy2.m) * f4 + (f3 = f7 - (float)cy2.n) * f3 + (f2 = f6 - (float)cy2.o) * f2) < 576.0f) continue;
                        try {
                            hf2 = (hf)arrclass[n6].getConstructor(cy.class).newInstance(cy2);
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            return n2;
                        }
                        hf2.c(f8, f7, f6, cy2.l.nextFloat() * 360.0f, 0.0f);
                        if (hf2.a()) {
                            ++n10;
                            cy2.a(hf2);
                            if (hf2 instanceof be && cy2.l.nextInt(100) == 0) {
                                dh dh2 = new dh(cy2);
                                dh2.c(f8, f7, f6, hf2.aC, 0.0f);
                                cy2.a(dh2);
                                dh2.h(hf2);
                            }
                            if (n10 >= hf2.i()) continue block6;
                        }
                        n2 += n10;
                    }
                }
            }
        }
        return n2;
    }
}

