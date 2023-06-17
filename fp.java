/*
 * Decompiled with CFR 0.150.
 */
public final class fp {
    public int a = 0;
    public int b;
    public int c;
    public int d;

    public fp(nq nq2) {
        this(nq2, 1);
    }

    public fp(nq nq2, int n2) {
        this(nq2.bh, n2);
    }

    public fp(dx dx2) {
        this(dx2, 1);
    }

    public fp(dx dx2, int n2) {
        this(dx2.aW, n2);
    }

    public fp(int n2) {
        this(n2, 1);
    }

    public fp(int n2, int n3) {
        this.c = n2;
        this.a = n3;
    }

    public fp(int n2, int n3, int n4) {
        this.c = n2;
        this.a = n3;
        this.d = n4;
    }

    public fp(iq iq2) {
        this.b(iq2);
    }

    public fp a(int n2) {
        this.a -= n2;
        return new fp(this.c, n2, this.d);
    }

    public dx a() {
        return dx.c[this.c];
    }

    public int b() {
        return this.a().a(this);
    }

    public boolean a(eb eb2, cy cy2, int n2, int n3, int n4, int n5) {
        return this.a().a(this, eb2, cy2, n2, n3, n4, n5);
    }

    public float a(nq nq2) {
        return this.a().a(this, nq2);
    }

    public fp a(cy cy2, eb eb2) {
        return this.a().a(this, cy2, eb2);
    }

    public iq a(iq iq2) {
        iq2.a("id", (short)this.c);
        iq2.a("Count", (byte)this.a);
        iq2.a("Damage", (short)this.d);
        return iq2;
    }

    public void b(iq iq2) {
        this.c = iq2.d("id");
        this.a = iq2.c("Count");
        this.d = iq2.d("Damage");
    }

    public int c() {
        return this.a().c();
    }

    public int d() {
        return dx.c[this.c].d();
    }

    public void b(int n2) {
        this.d += n2;
        if (this.d > this.d()) {
            --this.a;
            if (this.a < 0) {
                this.a = 0;
            }
            this.d = 0;
        }
    }

    public void a(hf hf2) {
        dx.c[this.c].a(this, hf2);
    }

    public void a(int n2, int n3, int n4, int n5) {
        dx.c[this.c].a(this, n2, n3, n4, n5);
    }

    public int a(lw lw2) {
        return dx.c[this.c].a(lw2);
    }

    public boolean b(nq nq2) {
        return dx.c[this.c].a(nq2);
    }

    public void a(eb eb2) {
    }

    public void b(hf hf2) {
        dx.c[this.c].b(this, hf2);
    }

    public fp e() {
        return new fp(this.c, this.a, this.d);
    }
}

