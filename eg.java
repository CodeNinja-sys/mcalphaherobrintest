/*
 * Decompiled with CFR 0.150.
 */
public class eg {
    private String[][] a = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
    private Object[][] b = new Object[][]{{nq.x, nq.w, dx.m, dx.l, dx.n}, {dx.r, dx.v, dx.e, dx.z, dx.G}, {dx.q, dx.u, dx.d, dx.y, dx.F}, {dx.s, dx.w, dx.f, dx.A, dx.H}, {dx.L, dx.M, dx.N, dx.O, dx.P}};

    public void a(en en2) {
        for (int i2 = 0; i2 < this.b[0].length; ++i2) {
            Object object = this.b[0][i2];
            for (int i3 = 0; i3 < this.b.length - 1; ++i3) {
                dx dx2 = (dx)this.b[i3 + 1][i2];
                en2.a(new fp(dx2), this.a[i3], Character.valueOf('#'), dx.B, Character.valueOf('X'), object);
            }
        }
    }
}

