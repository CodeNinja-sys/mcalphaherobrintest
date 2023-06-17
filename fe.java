/*
 * Decompiled with CFR 0.150.
 */
import java.util.Random;

public class fe
extends js {
    static final byte[] a = new byte[]{2, 0, 0, 1, 2, 1};
    Random b = new Random();
    cy c;
    int[] d = new int[]{0, 0, 0};
    int e = 0;
    int f;
    double g = 0.618;
    double h = 1.0;
    double i = 0.381;
    double j = 1.0;
    double k = 1.0;
    int l = 1;
    int m = 12;
    int n = 4;
    int[][] o;

    void a() {
        int n2;
        this.f = (int)((double)this.e * this.g);
        if (this.f >= this.e) {
            this.f = this.e - 1;
        }
        if ((n2 = (int)(1.382 + Math.pow(this.k * (double)this.e / 13.0, 2.0))) < 1) {
            n2 = 1;
        }
        int[][] arrn = new int[n2 * this.e][4];
        int n3 = this.d[1] + this.e - this.n;
        int n4 = 1;
        int n5 = this.d[1] + this.f;
        int n6 = n3 - this.d[1];
        arrn[0][0] = this.d[0];
        arrn[0][1] = n3--;
        arrn[0][2] = this.d[2];
        arrn[0][3] = n5;
        while (n6 >= 0) {
            float f2 = this.a(n6);
            if (f2 < 0.0f) {
                --n3;
                --n6;
                continue;
            }
            double d2 = 0.5;
            for (int i2 = 0; i2 < n2; ++i2) {
                double d3 = this.j * ((double)f2 * ((double)this.b.nextFloat() + 0.328));
                double d4 = (double)this.b.nextFloat() * 2.0 * 3.14159;
                int n7 = (int)(d3 * Math.sin(d4) + (double)this.d[0] + d2);
                int n8 = (int)(d3 * Math.cos(d4) + (double)this.d[2] + d2);
                int[] arrn2 = new int[]{n7, n3, n8};
                int[] arrn3 = new int[]{n7, n3 + this.n, n8};
                if (this.a(arrn2, arrn3) != -1) continue;
                int[] arrn4 = new int[]{this.d[0], this.d[1], this.d[2]};
                double d5 = Math.sqrt(Math.pow(Math.abs(this.d[0] - arrn2[0]), 2.0) + Math.pow(Math.abs(this.d[2] - arrn2[2]), 2.0));
                double d6 = d5 * this.i;
                arrn4[1] = (double)arrn2[1] - d6 > (double)n5 ? n5 : (int)((double)arrn2[1] - d6);
                if (this.a(arrn4, arrn2) != -1) continue;
                arrn[n4][0] = n7;
                arrn[n4][1] = n3;
                arrn[n4][2] = n8;
                arrn[n4][3] = arrn4[1];
                ++n4;
            }
            --n3;
            --n6;
        }
        this.o = new int[n4][4];
        System.arraycopy(arrn, 0, this.o, 0, n4);
    }

    void a(int n2, int n3, int n4, float f2, byte by2, int n5) {
        int n6 = (int)((double)f2 + 0.618);
        byte by3 = a[by2];
        byte by4 = a[by2 + 3];
        int[] arrn = new int[]{n2, n3, n4};
        int[] arrn2 = new int[]{0, 0, 0};
        int n7 = -n6;
        arrn2[by2] = arrn[by2];
        for (int i2 = -n6; i2 <= n6; ++i2) {
            arrn2[by3] = arrn[by3] + i2;
            n7 = -n6;
            while (n7 <= n6) {
                double d2 = Math.sqrt(Math.pow((double)Math.abs(i2) + 0.5, 2.0) + Math.pow((double)Math.abs(n7) + 0.5, 2.0));
                if (d2 > (double)f2) {
                    ++n7;
                    continue;
                }
                arrn2[by4] = arrn[by4] + n7;
                int n8 = this.c.a(arrn2[0], arrn2[1], arrn2[2]);
                if (n8 != 0 && n8 != 18) {
                    ++n7;
                    continue;
                }
                this.c.a(arrn2[0], arrn2[1], arrn2[2], n5);
                ++n7;
            }
        }
    }

    float a(int n2) {
        if ((double)n2 < (double)this.e * 0.3) {
            return -1.618f;
        }
        float f2 = (float)this.e / 2.0f;
        float f3 = (float)this.e / 2.0f - (float)n2;
        float f4 = f3 == 0.0f ? f2 : (Math.abs(f3) >= f2 ? 0.0f : (float)Math.sqrt(Math.pow(Math.abs(f2), 2.0) - Math.pow(Math.abs(f3), 2.0)));
        return f4 *= 0.5f;
    }

    float b(int n2) {
        if (n2 < 0 || n2 >= this.n) {
            return -1.0f;
        }
        if (n2 == 0 || n2 == this.n - 1) {
            return 2.0f;
        }
        return 3.0f;
    }

    void a(int n2, int n3, int n4) {
        int n5 = n3 + this.n;
        for (int i2 = n3; i2 < n5; ++i2) {
            float f2 = this.b(i2 - n3);
            this.a(n2, i2, n4, f2, (byte)1, 18);
        }
    }

    void a(int[] arrn, int[] arrn2, int n2) {
        int[] arrn3 = new int[]{0, 0, 0};
        int n3 = 0;
        for (int n4 = 0; n4 < 3; n4 = (int)((byte)(n4 + 1))) {
            arrn3[n4] = arrn2[n4] - arrn[n4];
            if (Math.abs(arrn3[n4]) <= Math.abs(arrn3[n3])) continue;
            n3 = n4;
        }
        if (arrn3[n3] == 0) {
            return;
        }
        byte by2 = a[n3];
        byte by3 = a[n3 + 3];
        int n5 = arrn3[n3] > 0 ? 1 : -1;
        double d2 = (double)arrn3[by2] / (double)arrn3[n3];
        double d3 = (double)arrn3[by3] / (double)arrn3[n3];
        int[] arrn4 = new int[]{0, 0, 0};
        int n6 = arrn3[n3] + n5;
        for (int i2 = 0; i2 != n6; i2 += n5) {
            arrn4[n3] = fi.b((double)(arrn[n3] + i2) + 0.5);
            arrn4[by2] = fi.b((double)arrn[by2] + (double)i2 * d2 + 0.5);
            arrn4[by3] = fi.b((double)arrn[by3] + (double)i2 * d3 + 0.5);
            this.c.a(arrn4[0], arrn4[1], arrn4[2], n2);
        }
    }

    void b() {
        int n2 = this.o.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = this.o[i2][0];
            int n4 = this.o[i2][1];
            int n5 = this.o[i2][2];
            this.a(n3, n4, n5);
        }
    }

    boolean c(int n2) {
        return !((double)n2 < (double)this.e * 0.2);
    }

    void c() {
        int n2 = this.d[0];
        int n3 = this.d[1];
        int n4 = this.d[1] + this.f;
        int n5 = this.d[2];
        int[] arrn = new int[]{n2, n3, n5};
        int[] arrn2 = new int[]{n2, n4, n5};
        this.a(arrn, arrn2, 17);
        if (this.l == 2) {
            arrn[0] = arrn[0] + 1;
            arrn2[0] = arrn2[0] + 1;
            this.a(arrn, arrn2, 17);
            arrn[2] = arrn[2] + 1;
            arrn2[2] = arrn2[2] + 1;
            this.a(arrn, arrn2, 17);
            arrn[0] = arrn[0] + -1;
            arrn2[0] = arrn2[0] + -1;
            this.a(arrn, arrn2, 17);
        }
    }

    void d() {
        int n2 = this.o.length;
        int[] arrn = new int[]{this.d[0], this.d[1], this.d[2]};
        for (int i2 = 0; i2 < n2; ++i2) {
            int[] arrn2 = this.o[i2];
            int[] arrn3 = new int[]{arrn2[0], arrn2[1], arrn2[2]};
            arrn[1] = arrn2[3];
            int n3 = arrn[1] - this.d[1];
            if (!this.c(n3)) continue;
            this.a(arrn, arrn3, 17);
        }
    }

    int a(int[] arrn, int[] arrn2) {
        int n2;
        int[] arrn3 = new int[]{0, 0, 0};
        int n3 = 0;
        for (int n4 = 0; n4 < 3; n4 = (int)((byte)(n4 + 1))) {
            arrn3[n4] = arrn2[n4] - arrn[n4];
            if (Math.abs(arrn3[n4]) <= Math.abs(arrn3[n3])) continue;
            n3 = n4;
        }
        if (arrn3[n3] == 0) {
            return -1;
        }
        byte by2 = a[n3];
        byte by3 = a[n3 + 3];
        int n5 = arrn3[n3] > 0 ? 1 : -1;
        double d2 = (double)arrn3[by2] / (double)arrn3[n3];
        double d3 = (double)arrn3[by3] / (double)arrn3[n3];
        int[] arrn4 = new int[]{0, 0, 0};
        int n6 = arrn3[n3] + n5;
        for (n2 = 0; n2 != n6; n2 += n5) {
            arrn4[n3] = arrn[n3] + n2;
            arrn4[by2] = (int)((double)arrn[by2] + (double)n2 * d2);
            arrn4[by3] = (int)((double)arrn[by3] + (double)n2 * d3);
            int n7 = this.c.a(arrn4[0], arrn4[1], arrn4[2]);
            if (n7 != 0 && n7 != 18) break;
        }
        if (n2 == n6) {
            return -1;
        }
        return Math.abs(n2);
    }

    boolean e() {
        int[] arrn = new int[]{this.d[0], this.d[1], this.d[2]};
        int[] arrn2 = new int[]{this.d[0], this.d[1] + this.e - 1, this.d[2]};
        int n2 = this.c.a(this.d[0], this.d[1] - 1, this.d[2]);
        if (n2 != 2 && n2 != 3) {
            return false;
        }
        int n3 = this.a(arrn, arrn2);
        if (n3 == -1) {
            return true;
        }
        if (n3 < 6) {
            return false;
        }
        this.e = n3;
        return true;
    }

    public void a(double d2, double d3, double d4) {
        this.m = (int)(d2 * 12.0);
        if (d2 > 0.5) {
            this.n = 5;
        }
        this.j = d3;
        this.k = d4;
    }

    public boolean a(cy cy2, Random random, int n2, int n3, int n4) {
        this.c = cy2;
        long l2 = random.nextLong();
        this.b.setSeed(l2);
        this.d[0] = n2;
        this.d[1] = n3;
        this.d[2] = n4;
        if (this.e == 0) {
            this.e = 5 + this.b.nextInt(this.m);
        }
        if (!this.e()) {
            return false;
        }
        this.a();
        this.b();
        this.c();
        this.d();
        return true;
    }
}

