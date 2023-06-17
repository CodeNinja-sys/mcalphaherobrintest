/*
 * Decompiled with CFR 0.150.
 */
public class fn
extends ax {
    public hx a = new hx(this, 3, 3);
    public hi b = new oq();

    public void a(hi hi2) {
        int[] arrn = new int[9];
        for (int i2 = 0; i2 < 3; ++i2) {
            for (int i3 = 0; i3 < 3; ++i3) {
                int n2 = i2 + i3 * 3;
                fp fp2 = this.a.c(n2);
                arrn[n2] = fp2 == null ? -1 : fp2.c;
            }
        }
        this.b.a(0, en.a().a(arrn));
    }

    public void a(eb eb2) {
        super.a(eb2);
        for (int i2 = 0; i2 < 9; ++i2) {
            fp fp2 = this.a.c(i2);
            if (fp2 == null) continue;
            eb2.a(fp2);
        }
    }
}

