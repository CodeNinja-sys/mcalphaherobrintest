/*
 * Decompiled with CFR 0.150.
 */
public class q
extends ax {
    public hx a;
    public hi b = new oq();

    public q(fp[] arrfp) {
        this.a = new hx(this, arrfp);
        this.a(this.a);
    }

    public void a(hi hi2) {
        int[] arrn = new int[9];
        for (int i2 = 0; i2 < 3; ++i2) {
            for (int i3 = 0; i3 < 3; ++i3) {
                fp fp2;
                int n2 = -1;
                if (i2 < 2 && i3 < 2 && (fp2 = this.a.c(i2 + i3 * 2)) != null) {
                    n2 = fp2.c;
                }
                arrn[i2 + i3 * 3] = n2;
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

