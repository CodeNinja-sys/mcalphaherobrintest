/*
 * Decompiled with CFR 0.150.
 */
public class gt
extends dx {
    public gt(int n2, int n3) {
        super(n2);
        this.aX = 1;
        this.aY = 32 << n3;
    }

    public boolean a(fp fp2, eb eb2, cy cy2, int n2, int n3, int n4, int n5) {
        int n6 = cy2.a(n2, n3, n4);
        hb hb2 = cy2.f(n2, n3 + 1, n4);
        if (!hb2.a() && n6 == nq.u.bh || n6 == nq.v.bh) {
            nq nq2 = nq.aA;
            cy2.a((float)n2 + 0.5f, (double)((float)n3 + 0.5f), (double)((float)n4 + 0.5f), nq2.bq.d(), (nq2.bq.b() + 1.0f) / 2.0f, nq2.bq.c() * 0.8f);
            if (cy2.z) {
                return true;
            }
            cy2.d(n2, n3, n4, nq2.bh);
            fp2.b(1);
            if (cy2.l.nextInt(8) == 0 && n6 == nq.u.bh) {
                int n7 = 1;
                for (int i2 = 0; i2 < n7; ++i2) {
                    float f2 = 0.7f;
                    float f3 = cy2.l.nextFloat() * f2 + (1.0f - f2) * 0.5f;
                    float f4 = 1.2f;
                    float f5 = cy2.l.nextFloat() * f2 + (1.0f - f2) * 0.5f;
                    eo eo2 = new eo(cy2, (float)n2 + f3, (float)n3 + f4, (float)n4 + f5, new fp(dx.Q));
                    eo2.c = 10;
                    cy2.a(eo2);
                }
            }
            return true;
        }
        return false;
    }

    public boolean a() {
        return true;
    }
}

