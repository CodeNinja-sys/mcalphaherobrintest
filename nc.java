/*
 * Decompiled with CFR 0.150.
 */
public class nc {
    public ew[] a;
    public int b = 0;
    private boolean c = false;

    public nc(ew[] arrew) {
        this.a = arrew;
        this.b = arrew.length;
    }

    public nc(ew[] arrew, int n2, int n3, int n4, int n5) {
        this(arrew);
        float f2 = 0.0015625f;
        float f3 = 0.003125f;
        arrew[0] = arrew[0].a((float)n4 / 64.0f - f2, (float)n3 / 32.0f + f3);
        arrew[1] = arrew[1].a((float)n2 / 64.0f + f2, (float)n3 / 32.0f + f3);
        arrew[2] = arrew[2].a((float)n2 / 64.0f + f2, (float)n5 / 32.0f - f3);
        arrew[3] = arrew[3].a((float)n4 / 64.0f - f2, (float)n5 / 32.0f - f3);
    }

    public void a() {
        ew[] arrew = new ew[this.a.length];
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            arrew[i2] = this.a[this.a.length - i2 - 1];
        }
        this.a = arrew;
    }

    public void a(is is2, float f2) {
        ao ao2 = this.a[1].a.a(this.a[0].a);
        ao ao3 = this.a[1].a.a(this.a[2].a);
        ao ao4 = ao3.b(ao2).b();
        is2.b();
        if (this.c) {
            is2.b(-((float)ao4.a), -((float)ao4.b), -((float)ao4.c));
        } else {
            is2.b((float)ao4.a, (float)ao4.b, (float)ao4.c);
        }
        for (int i2 = 0; i2 < 4; ++i2) {
            ew ew2 = this.a[i2];
            is2.a((float)ew2.a.a * f2, (float)ew2.a.b * f2, (float)ew2.a.c * f2, ew2.b, ew2.c);
        }
        is2.a();
    }
}

