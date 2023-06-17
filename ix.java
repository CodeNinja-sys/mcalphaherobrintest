/*
 * Decompiled with CFR 0.150.
 */
public class ix
implements hi {
    private String a;
    private hi b;
    private hi c;

    public ix(String string, hi hi2, hi hi3) {
        this.a = string;
        this.b = hi2;
        this.c = hi3;
    }

    public int c() {
        return this.b.c() + this.c.c();
    }

    public String d() {
        return this.a;
    }

    public fp c(int n2) {
        if (n2 >= this.b.c()) {
            return this.c.c(n2 - this.b.c());
        }
        return this.b.c(n2);
    }

    public fp a(int n2, int n3) {
        if (n2 >= this.b.c()) {
            return this.c.a(n2 - this.b.c(), n3);
        }
        return this.b.a(n2, n3);
    }

    public void a(int n2, fp fp2) {
        if (n2 >= this.b.c()) {
            this.c.a(n2 - this.b.c(), fp2);
        } else {
            this.b.a(n2, fp2);
        }
    }

    public int o_() {
        return this.b.o_();
    }

    public void h() {
        this.b.h();
        this.c.h();
    }
}

