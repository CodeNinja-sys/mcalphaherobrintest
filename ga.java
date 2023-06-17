/*
 * Decompiled with CFR 0.150.
 */
public class ga
extends ji
implements hi {
    private fp[] a = new fp[36];

    public int c() {
        return 27;
    }

    public fp c(int n2) {
        return this.a[n2];
    }

    public fp a(int n2, int n3) {
        if (this.a[n2] != null) {
            if (this.a[n2].a <= n3) {
                fp fp2 = this.a[n2];
                this.a[n2] = null;
                this.h();
                return fp2;
            }
            fp fp3 = this.a[n2].a(n3);
            if (this.a[n2].a == 0) {
                this.a[n2] = null;
            }
            this.h();
            return fp3;
        }
        return null;
    }

    public void a(int n2, fp fp2) {
        this.a[n2] = fp2;
        if (fp2 != null && fp2.a > this.o_()) {
            fp2.a = this.o_();
        }
        this.h();
    }

    public String d() {
        return "Chest";
    }

    public void a(iq iq2) {
        super.a(iq2);
        ly ly2 = iq2.l("Items");
        this.a = new fp[this.c()];
        for (int i2 = 0; i2 < ly2.c(); ++i2) {
            iq iq3 = (iq)ly2.a(i2);
            int n2 = iq3.c("Slot") & 0xFF;
            if (n2 < 0 || n2 >= this.a.length) continue;
            this.a[n2] = new fp(iq3);
        }
    }

    public void b(iq iq2) {
        super.b(iq2);
        ly ly2 = new ly();
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            if (this.a[i2] == null) continue;
            iq iq3 = new iq();
            iq3.a("Slot", (byte)i2);
            this.a[i2].a(iq3);
            ly2.a(iq3);
        }
        iq2.a("Items", ly2);
    }

    public int o_() {
        return 64;
    }
}

