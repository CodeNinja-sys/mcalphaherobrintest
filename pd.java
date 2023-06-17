/*
 * Decompiled with CFR 0.150.
 */
public class pd
extends nq {
    protected pd(int n2) {
        super(n2, hb.j);
        this.bg = 48;
    }

    public void e(cy cy2, int n2, int n3, int n4) {
        int n5 = 2;
        for (int i2 = n2 - n5; i2 <= n2 + n5; ++i2) {
            for (int i3 = n3 - n5; i3 <= n3 + n5; ++i3) {
                for (int i4 = n4 - n5; i4 <= n4 + n5; ++i4) {
                    if (cy2.f(i2, i3, i4) != hb.f) continue;
                }
            }
        }
    }

    public void b(cy cy2, int n2, int n3, int n4) {
        int n5 = 2;
        for (int i2 = n2 - n5; i2 <= n2 + n5; ++i2) {
            for (int i3 = n3 - n5; i3 <= n3 + n5; ++i3) {
                for (int i4 = n4 - n5; i4 <= n4 + n5; ++i4) {
                    cy2.g(i2, i3, i4, cy2.a(i2, i3, i4));
                }
            }
        }
    }
}

