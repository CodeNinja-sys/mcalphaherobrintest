/*
 * Decompiled with CFR 0.150.
 */
public class lt
extends ji
implements hi {
    private fp[] a = new fp[3];
    private int b = 0;
    private int c = 0;
    private int d = 0;

    public int c() {
        return this.a.length;
    }

    public fp c(int n2) {
        return this.a[n2];
    }

    public fp a(int n2, int n3) {
        if (this.a[n2] != null) {
            if (this.a[n2].a <= n3) {
                fp fp2 = this.a[n2];
                this.a[n2] = null;
                return fp2;
            }
            fp fp3 = this.a[n2].a(n3);
            if (this.a[n2].a == 0) {
                this.a[n2] = null;
            }
            return fp3;
        }
        return null;
    }

    public void a(int n2, fp fp2) {
        this.a[n2] = fp2;
        if (fp2 != null && fp2.a > this.o_()) {
            fp2.a = this.o_();
        }
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
            byte by2 = iq3.c("Slot");
            if (by2 < 0 || by2 >= this.a.length) continue;
            this.a[by2] = new fp(iq3);
        }
        this.b = iq2.d("BurnTime");
        this.d = iq2.d("CookTime");
        this.c = this.a(this.a[1]);
    }

    public void b(iq iq2) {
        super.b(iq2);
        iq2.a("BurnTime", (short)this.b);
        iq2.a("CookTime", (short)this.d);
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

    public int a(int n2) {
        return this.d * n2 / 200;
    }

    public int b(int n2) {
        if (this.c == 0) {
            this.c = 200;
        }
        return this.b * n2 / this.c;
    }

    public boolean a() {
        return this.b > 0;
    }

    public void b() {
        boolean bl2 = this.b > 0;
        boolean bl3 = false;
        if (this.b > 0) {
            --this.b;
        }
        if (!this.e.z) {
            if (this.b == 0 && this.j()) {
                this.c = this.b = this.a(this.a[1]);
                if (this.b > 0) {
                    bl3 = true;
                    if (this.a[1] != null) {
                        --this.a[1].a;
                        if (this.a[1].a == 0) {
                            this.a[1] = null;
                        }
                    }
                }
            }
            if (this.a() && this.j()) {
                ++this.d;
                if (this.d == 200) {
                    this.d = 0;
                    this.i();
                    bl3 = true;
                }
            } else {
                this.d = 0;
            }
            if (bl2 != this.b > 0) {
                bl3 = true;
                mj.a(this.b > 0, this.e, this.f, this.g, this.h);
            }
        }
        if (bl3) {
            this.h();
        }
    }

    private boolean j() {
        if (this.a[0] == null) {
            return false;
        }
        int n2 = this.d(this.a[0].a().aW);
        if (n2 < 0) {
            return false;
        }
        if (this.a[2] == null) {
            return true;
        }
        if (this.a[2].c != n2) {
            return false;
        }
        if (this.a[2].a < this.o_() && this.a[2].a < this.a[2].c()) {
            return true;
        }
        return this.a[2].a < dx.c[n2].c();
    }

    public void i() {
        if (!this.j()) {
            return;
        }
        int n2 = this.d(this.a[0].a().aW);
        if (this.a[2] == null) {
            this.a[2] = new fp(n2, 1);
        } else if (this.a[2].c == n2) {
            ++this.a[2].a;
        }
        --this.a[0].a;
        if (this.a[0].a <= 0) {
            this.a[0] = null;
        }
    }

    private int d(int n2) {
        if (n2 == nq.H.bh) {
            return dx.m.aW;
        }
        if (n2 == nq.G.bh) {
            return dx.n.aW;
        }
        if (n2 == nq.aw.bh) {
            return dx.l.aW;
        }
        if (n2 == nq.E.bh) {
            return nq.M.bh;
        }
        if (n2 == dx.ao.aW) {
            return dx.ap.aW;
        }
        if (n2 == dx.aS.aW) {
            return dx.aT.aW;
        }
        if (n2 == nq.w.bh) {
            return nq.t.bh;
        }
        if (n2 == dx.aG.aW) {
            return dx.aF.aW;
        }
        return -1;
    }

    private int a(fp fp2) {
        if (fp2 == null) {
            return 0;
        }
        int n2 = fp2.a().aW;
        if (n2 < 256 && nq.m[n2].bs == hb.c) {
            return 300;
        }
        if (n2 == dx.B.aW) {
            return 100;
        }
        if (n2 == dx.k.aW) {
            return 1600;
        }
        if (n2 == dx.aw.aW) {
            return 20000;
        }
        return 0;
    }
}

