/*
 * Decompiled with CFR 0.150.
 */
import java.util.ArrayList;
import java.util.Random;

public class mb
extends nq {
    private nq a;

    protected mb(int n2, nq nq2) {
        super(n2, nq2.bg, nq2.bs);
        this.a = nq2;
        this.c(nq2.bi);
        this.b(nq2.bj / 3.0f);
        this.a(nq2.bq);
    }

    public void a(pk pk2, int n2, int n3, int n4) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    public co d(cy cy2, int n2, int n3, int n4) {
        return super.d(cy2, n2, n3, n4);
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public int g() {
        return 10;
    }

    public boolean b(pk pk2, int n2, int n3, int n4, int n5) {
        return super.b(pk2, n2, n3, n4, n5);
    }

    public void a(cy cy2, int n2, int n3, int n4, co co2, ArrayList arrayList) {
        int n5 = cy2.e(n2, n3, n4);
        if (n5 == 0) {
            this.a(0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 1.0f);
            super.a(cy2, n2, n3, n4, co2, arrayList);
            this.a(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            super.a(cy2, n2, n3, n4, co2, arrayList);
        } else if (n5 == 1) {
            this.a(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
            super.a(cy2, n2, n3, n4, co2, arrayList);
            this.a(0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
            super.a(cy2, n2, n3, n4, co2, arrayList);
        } else if (n5 == 2) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.5f);
            super.a(cy2, n2, n3, n4, co2, arrayList);
            this.a(0.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
            super.a(cy2, n2, n3, n4, co2, arrayList);
        } else if (n5 == 3) {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
            super.a(cy2, n2, n3, n4, co2, arrayList);
            this.a(0.0f, 0.0f, 0.5f, 1.0f, 0.5f, 1.0f);
            super.a(cy2, n2, n3, n4, co2, arrayList);
        }
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    public void b(cy cy2, int n2, int n3, int n4, Random random) {
        this.a.b(cy2, n2, n3, n4, random);
    }

    public void b(cy cy2, int n2, int n3, int n4, eb eb2) {
        this.a.b(cy2, n2, n3, n4, eb2);
    }

    public void b(cy cy2, int n2, int n3, int n4, int n5) {
        this.a.b(cy2, n2, n3, n4, n5);
    }

    public float d(pk pk2, int n2, int n3, int n4) {
        return this.a.d(pk2, n2, n3, n4);
    }

    public float a(lw lw2) {
        return this.a.a(lw2);
    }

    public int c() {
        return this.a.c();
    }

    public int a(int n2, Random random) {
        return this.a.a(n2, random);
    }

    public int a(Random random) {
        return this.a.a(random);
    }

    public int a(int n2, int n3) {
        return this.a.a(n2, n3);
    }

    public int a(int n2) {
        return this.a.a(n2);
    }

    public int a(pk pk2, int n2, int n3, int n4, int n5) {
        return this.a.a(pk2, n2, n3, n4, n5);
    }

    public int d() {
        return this.a.d();
    }

    public co f(cy cy2, int n2, int n3, int n4) {
        return this.a.f(cy2, n2, n3, n4);
    }

    public void a(cy cy2, int n2, int n3, int n4, lw lw2, ao ao2) {
        this.a.a(cy2, n2, n3, n4, lw2, ao2);
    }

    public boolean h() {
        return this.a.h();
    }

    public boolean a(int n2, boolean bl2) {
        return this.a.a(n2, bl2);
    }

    public boolean a(cy cy2, int n2, int n3, int n4) {
        return this.a.a(cy2, n2, n3, n4);
    }

    public void e(cy cy2, int n2, int n3, int n4) {
        this.a(cy2, n2, n3, n4, 0);
        this.a.e(cy2, n2, n3, n4);
    }

    public void b(cy cy2, int n2, int n3, int n4) {
        this.a.b(cy2, n2, n3, n4);
    }

    public void a(cy cy2, int n2, int n3, int n4, int n5, float f2) {
        this.a.a(cy2, n2, n3, n4, n5, f2);
    }

    public void b_(cy cy2, int n2, int n3, int n4, int n5) {
        this.a.b_(cy2, n2, n3, n4, n5);
    }

    public void b(cy cy2, int n2, int n3, int n4, lw lw2) {
        this.a.b(cy2, n2, n3, n4, lw2);
    }

    public void a(cy cy2, int n2, int n3, int n4, Random random) {
        this.a.a(cy2, n2, n3, n4, random);
    }

    public boolean a(cy cy2, int n2, int n3, int n4, eb eb2) {
        return this.a.a(cy2, n2, n3, n4, eb2);
    }

    public void c(cy cy2, int n2, int n3, int n4) {
        this.a.c(cy2, n2, n3, n4);
    }

    public void a(cy cy2, int n2, int n3, int n4, hf hf2) {
        int n5 = fi.b((double)(hf2.aC * 4.0f / 360.0f) + 0.5) & 3;
        if (n5 == 0) {
            cy2.b(n2, n3, n4, 2);
        }
        if (n5 == 1) {
            cy2.b(n2, n3, n4, 1);
        }
        if (n5 == 2) {
            cy2.b(n2, n3, n4, 3);
        }
        if (n5 == 3) {
            cy2.b(n2, n3, n4, 0);
        }
    }
}

