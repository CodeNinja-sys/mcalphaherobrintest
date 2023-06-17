/*
 * Decompiled with CFR 0.150.
 */
public class jo
extends pp {
    public jo(cy cy2, double d2, double d3, double d4, dx dx2) {
        super(cy2, d2, d3, d4, 0.0, 0.0, 0.0);
        this.b = dx2.a((fp)null);
        this.k = 1.0f;
        this.j = 1.0f;
        this.i = 1.0f;
        this.h = nq.aU.br;
        this.g /= 2.0f;
    }

    public int l_() {
        return 2;
    }

    public void a(is is2, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = ((float)(this.b % 16) + this.c / 4.0f) / 16.0f;
        float f9 = f8 + 0.015609375f;
        float f10 = ((float)(this.b / 16) + this.d / 4.0f) / 16.0f;
        float f11 = f10 + 0.015609375f;
        float f12 = 0.1f * this.g;
        float f13 = (float)(this.at + (this.aw - this.at) * (double)f2 - l);
        float f14 = (float)(this.au + (this.ax - this.au) * (double)f2 - m);
        float f15 = (float)(this.av + (this.ay - this.av) * (double)f2 - n);
        float f16 = this.a(f2);
        is2.a(f16 * this.i, f16 * this.j, f16 * this.k);
        is2.a(f13 - f3 * f12 - f6 * f12, f14 - f4 * f12, f15 - f5 * f12 - f7 * f12, f8, f11);
        is2.a(f13 - f3 * f12 + f6 * f12, f14 + f4 * f12, f15 - f5 * f12 + f7 * f12, f8, f10);
        is2.a(f13 + f3 * f12 + f6 * f12, f14 + f4 * f12, f15 + f5 * f12 + f7 * f12, f9, f10);
        is2.a(f13 + f3 * f12 - f6 * f12, f14 - f4 * f12, f15 + f5 * f12 - f7 * f12, f9, f11);
    }
}

