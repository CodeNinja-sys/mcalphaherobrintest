/*
 * Decompiled with CFR 0.150.
 */
public class mv {
    private Object[][] a = new Object[][]{{nq.ah, dx.n}, {nq.ai, dx.m}, {nq.ax, dx.l}};

    public void a(en en2) {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            nq nq2 = (nq)this.a[i2][0];
            dx dx2 = (dx)this.a[i2][1];
            en2.a(new fp(nq2), "###", "###", "###", Character.valueOf('#'), dx2);
            en2.a(new fp(dx2, 9), "#", Character.valueOf('#'), nq2);
        }
    }
}

