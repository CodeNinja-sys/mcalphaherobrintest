/*
 * Decompiled with CFR 0.150.
 */
public class oq
implements hi {
    private fp[] a = new fp[1];

    public int c() {
        return 1;
    }

    public fp c(int n2) {
        return this.a[n2];
    }

    public String d() {
        return "Result";
    }

    public fp a(int n2, int n3) {
        if (this.a[n2] != null) {
            fp fp2 = this.a[n2];
            this.a[n2] = null;
            return fp2;
        }
        return null;
    }

    public void a(int n2, fp fp2) {
        this.a[n2] = fp2;
    }

    public int o_() {
        return 64;
    }

    public void h() {
    }
}

