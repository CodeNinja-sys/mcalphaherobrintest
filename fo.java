/*
 * Decompiled with CFR 0.150.
 */
public class fo
implements hi {
    public fp[] a = new fp[37];
    public fp[] b = new fp[4];
    public fp[] c = new fp[4];
    public int d = 0;
    private eb g;
    public fp e;
    public boolean f = false;

    public fo(eb eb2) {
        this.g = eb2;
    }

    public fp a() {
        return this.a[this.d];
    }

    private int f(int n2) {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            if (this.a[i2] == null || this.a[i2].c != n2) continue;
            return i2;
        }
        return -1;
    }

    private int g(int n2) {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            if (this.a[i2] == null || this.a[i2].c != n2 || this.a[i2].a >= this.a[i2].c() || this.a[i2].a >= this.o_()) continue;
            return i2;
        }
        return -1;
    }

    private int j() {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            if (this.a[i2] != null) continue;
            return i2;
        }
        return -1;
    }

    public void a(int n2, boolean bl2) {
        int n3 = this.f(n2);
        if (n3 >= 0 && n3 < 9) {
            this.d = n3;
            return;
        }
    }

    public void a(int n2) {
        if (n2 > 0) {
            n2 = 1;
        }
        if (n2 < 0) {
            n2 = -1;
        }
        this.d -= n2;
        while (this.d < 0) {
            this.d += 9;
        }
        while (this.d >= 9) {
            this.d -= 9;
        }
    }

    private int b(int n2, int n3) {
        int n4;
        int n5 = this.g(n2);
        if (n5 < 0) {
            n5 = this.j();
        }
        if (n5 < 0) {
            return n3;
        }
        if (this.a[n5] == null) {
            this.a[n5] = new fp(n2, 0);
        }
        if ((n4 = n3) > this.a[n5].c() - this.a[n5].a) {
            n4 = this.a[n5].c() - this.a[n5].a;
        }
        if (n4 > this.o_() - this.a[n5].a) {
            n4 = this.o_() - this.a[n5].a;
        }
        if (n4 == 0) {
            return n3;
        }
        this.a[n5].a += n4;
        this.a[n5].b = 5;
        return n3 -= n4;
    }

    public void b() {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            if (this.a[i2] == null || this.a[i2].b <= 0) continue;
            --this.a[i2].b;
        }
    }

    public boolean b(int n2) {
        int n3 = this.f(n2);
        if (n3 < 0) {
            return false;
        }
        if (--this.a[n3].a <= 0) {
            this.a[n3] = null;
        }
        return true;
    }

    public boolean a(fp fp2) {
        int n2;
        if (fp2.d == 0) {
            fp2.a = this.b(fp2.c, fp2.a);
            if (fp2.a == 0) {
                return true;
            }
        }
        if ((n2 = this.j()) >= 0) {
            this.a[n2] = fp2;
            this.a[n2].b = 5;
            return true;
        }
        return false;
    }

    public fp a(int n2, int n3) {
        fp[] arrfp = this.a;
        if (n2 >= this.a.length) {
            arrfp = this.b;
            n2 -= this.a.length;
        }
        if (arrfp[n2] != null) {
            if (arrfp[n2].a <= n3) {
                fp fp2 = arrfp[n2];
                arrfp[n2] = null;
                return fp2;
            }
            fp fp3 = arrfp[n2].a(n3);
            if (arrfp[n2].a == 0) {
                arrfp[n2] = null;
            }
            return fp3;
        }
        return null;
    }

    public void a(int n2, fp fp2) {
        fp[] arrfp = this.a;
        if (n2 >= arrfp.length) {
            n2 -= arrfp.length;
            arrfp = this.b;
        }
        if (n2 >= arrfp.length) {
            n2 -= arrfp.length;
            arrfp = this.c;
        }
        arrfp[n2] = fp2;
    }

    public float a(nq nq2) {
        float f2 = 1.0f;
        if (this.a[this.d] != null) {
            f2 *= this.a[this.d].a(nq2);
        }
        return f2;
    }

    public ly a(ly ly2) {
        iq iq2;
        int n2;
        for (n2 = 0; n2 < this.a.length; ++n2) {
            if (this.a[n2] == null) continue;
            iq2 = new iq();
            iq2.a("Slot", (byte)n2);
            this.a[n2].a(iq2);
            ly2.a(iq2);
        }
        for (n2 = 0; n2 < this.b.length; ++n2) {
            if (this.b[n2] == null) continue;
            iq2 = new iq();
            iq2.a("Slot", (byte)(n2 + 100));
            this.b[n2].a(iq2);
            ly2.a(iq2);
        }
        for (n2 = 0; n2 < this.c.length; ++n2) {
            if (this.c[n2] == null) continue;
            iq2 = new iq();
            iq2.a("Slot", (byte)(n2 + 80));
            this.c[n2].a(iq2);
            ly2.a(iq2);
        }
        return ly2;
    }

    public void b(ly ly2) {
        this.a = new fp[36];
        this.b = new fp[4];
        this.c = new fp[4];
        for (int i2 = 0; i2 < ly2.c(); ++i2) {
            iq iq2 = (iq)ly2.a(i2);
            int n2 = iq2.c("Slot") & 0xFF;
            if (n2 >= 0 && n2 < this.a.length) {
                this.a[n2] = new fp(iq2);
            }
            if (n2 >= 80 && n2 < this.c.length + 80) {
                this.c[n2 - 80] = new fp(iq2);
            }
            if (n2 < 100 || n2 >= this.b.length + 100) continue;
            this.b[n2 - 100] = new fp(iq2);
        }
    }

    public int c() {
        return this.a.length + 4;
    }

    public fp c(int n2) {
        fp[] arrfp = this.a;
        if (n2 >= arrfp.length) {
            n2 -= arrfp.length;
            arrfp = this.b;
        }
        if (n2 >= arrfp.length) {
            n2 -= arrfp.length;
            arrfp = this.c;
        }
        return arrfp[n2];
    }

    public String d() {
        return "Inventory";
    }

    public int o_() {
        return 64;
    }

    public int a(lw lw2) {
        fp fp2 = this.c(this.d);
        if (fp2 != null) {
            return fp2.a(lw2);
        }
        return 1;
    }

    public boolean b(nq nq2) {
        if (nq2.bs != hb.d && nq2.bs != hb.e && nq2.bs != hb.t && nq2.bs != hb.s) {
            return true;
        }
        fp fp2 = this.c(this.d);
        if (fp2 != null) {
            return fp2.b(nq2);
        }
        return false;
    }

    public fp d(int n2) {
        return this.b[n2];
    }

    public int f() {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            if (this.b[i2] == null || !(this.b[i2].a() instanceof oj)) continue;
            int n5 = this.b[i2].d();
            int n6 = this.b[i2].d;
            int n7 = n5 - n6;
            n3 += n7;
            n4 += n5;
            int n8 = ((oj)this.b[i2].a()).bc;
            n2 += n8;
        }
        if (n4 == 0) {
            return 0;
        }
        return (n2 - 1) * n3 / n4 + 1;
    }

    public void e(int n2) {
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            if (this.b[i2] == null || !(this.b[i2].a() instanceof oj)) continue;
            this.b[i2].b(n2);
            if (this.b[i2].a != 0) continue;
            this.b[i2].a(this.g);
            this.b[i2] = null;
        }
    }

    public void g() {
        int n2;
        for (n2 = 0; n2 < this.a.length; ++n2) {
            if (this.a[n2] == null) continue;
            this.g.a(this.a[n2], true);
            this.a[n2] = null;
        }
        for (n2 = 0; n2 < this.b.length; ++n2) {
            if (this.b[n2] == null) continue;
            this.g.a(this.b[n2], true);
            this.b[n2] = null;
        }
    }

    public void h() {
        this.f = true;
    }

    public boolean a(fo fo2) {
        int n2;
        for (n2 = 0; n2 < this.a.length; ++n2) {
            if (this.a(fo2.a[n2], this.a[n2])) continue;
            return false;
        }
        for (n2 = 0; n2 < this.b.length; ++n2) {
            if (this.a(fo2.b[n2], this.b[n2])) continue;
            return false;
        }
        for (n2 = 0; n2 < this.c.length; ++n2) {
            if (this.a(fo2.c[n2], this.c[n2])) continue;
            return false;
        }
        return true;
    }

    private boolean a(fp fp2, fp fp3) {
        if (fp2 == null && fp3 == null) {
            return true;
        }
        if (fp2 == null || fp3 == null) {
            return false;
        }
        return fp2.c == fp3.c && fp2.a == fp3.a && fp2.d == fp3.d;
    }

    public fo i() {
        int n2;
        fo fo2 = new fo(null);
        for (n2 = 0; n2 < this.a.length; ++n2) {
            fo2.a[n2] = this.a[n2] != null ? this.a[n2].e() : null;
        }
        for (n2 = 0; n2 < this.b.length; ++n2) {
            fo2.b[n2] = this.b[n2] != null ? this.b[n2].e() : null;
        }
        for (n2 = 0; n2 < this.c.length; ++n2) {
            fo2.c[n2] = this.c[n2] != null ? this.c[n2].e() : null;
        }
        return fo2;
    }
}

