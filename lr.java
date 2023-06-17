/*
 * Decompiled with CFR 0.150.
 */
class lr {
    public double a;
    public double b;
    public double c;
    final /* synthetic */ dj d;

    public lr(dj dj2, int n2, int n3) {
        this.d = dj2;
        this.a = this.b = (double)(10 + n3) + dj.j().nextDouble() * 32.0 + (double)n2;
    }

    public void a() {
        this.b = this.a;
        if (this.a > 0.0) {
            this.c -= 0.6;
        }
        this.a += this.c;
        this.c *= 0.9;
        if (this.a < 0.0) {
            this.a = 0.0;
            this.c = 0.0;
        }
    }
}

