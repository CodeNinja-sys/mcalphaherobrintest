/*
 * Decompiled with CFR 0.150.
 */
public class pa {
    private String[][] a = new String[][]{{"X", "X", "#"}};
    private Object[][] b = new Object[][]{{nq.x, nq.w, dx.m, dx.l, dx.n}, {dx.p, dx.t, dx.o, dx.x, dx.E}};

    public void a(en en2) {
        for (int i2 = 0; i2 < this.b[0].length; ++i2) {
            Object object = this.b[0][i2];
            for (int i3 = 0; i3 < this.b.length - 1; ++i3) {
                dx dx2 = (dx)this.b[i3 + 1][i2];
                en2.a(new fp(dx2), this.a[i3], Character.valueOf('#'), dx.B, Character.valueOf('X'), object);
            }
        }
        en2.a(new fp(dx.i, 1), " #X", "# X", " #X", Character.valueOf('X'), dx.I, Character.valueOf('#'), dx.B);
        en2.a(new fp(dx.j, 4), "X", "#", "Y", Character.valueOf('Y'), dx.J, Character.valueOf('X'), dx.an, Character.valueOf('#'), dx.B);
    }
}

