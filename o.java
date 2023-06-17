/*
 * Decompiled with CFR 0.150.
 */
public class o {
    private String[][] a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    private Object[][] b = new Object[][]{{dx.aD, nq.ar, dx.m, dx.l, dx.n}, {dx.T, dx.X, dx.ab, dx.af, dx.aj}, {dx.U, dx.Y, dx.ac, dx.ag, dx.ak}, {dx.V, dx.Z, dx.ad, dx.ah, dx.al}, {dx.W, dx.aa, dx.ae, dx.ai, dx.am}};

    public void a(en en2) {
        for (int i2 = 0; i2 < this.b[0].length; ++i2) {
            Object object = this.b[0][i2];
            for (int i3 = 0; i3 < this.b.length - 1; ++i3) {
                dx dx2 = (dx)this.b[i3 + 1][i2];
                en2.a(new fp(dx2), this.a[i3], Character.valueOf('X'), object);
            }
        }
    }
}

