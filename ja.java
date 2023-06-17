/*
 * Decompiled with CFR 0.150.
 */
import java.util.Random;

public class ja
extends ld {
    int a = 0;
    boolean[] b = new boolean[4];
    int[] c = new int[4];

    protected ja(int n2, hb hb2) {
        super(n2, hb2);
    }

    private void j(cy cy2, int n2, int n3, int n4) {
        int n5 = cy2.e(n2, n3, n4);
        cy2.a(n2, n3, n4, this.bh + 1, n5);
        cy2.b(n2, n3, n4, n2, n3, n4);
        cy2.h(n2, n3, n4);
    }

    public void a(cy cy2, int n2, int n3, int n4, Random random) {
        int n5;
        int n6 = this.h(cy2, n2, n3, n4);
        int n7 = 1;
        if (this.bs == hb.g && !cy2.q.d) {
            n7 = 2;
        }
        boolean bl2 = true;
        if (n6 > 0) {
            int n8 = -100;
            this.a = 0;
            n8 = this.f(cy2, n2 - 1, n3, n4, n8);
            n8 = this.f(cy2, n2 + 1, n3, n4, n8);
            n8 = this.f(cy2, n2, n3, n4 - 1, n8);
            n5 = (n8 = this.f(cy2, n2, n3, n4 + 1, n8)) + n7;
            if (n5 >= 8 || n8 < 0) {
                n5 = -1;
            }
            if (this.h(cy2, n2, n3 + 1, n4) >= 0) {
                int n9 = this.h(cy2, n2, n3 + 1, n4);
                n5 = n9 >= 8 ? n9 : n9 + 8;
            }
            if (this.a >= 2 && this.bs == hb.f) {
                if (cy2.g(n2, n3 - 1, n4)) {
                    n5 = 0;
                } else if (cy2.f(n2, n3 - 1, n4) == this.bs && cy2.e(n2, n3, n4) == 0) {
                    n5 = 0;
                }
            }
            if (this.bs == hb.g && n6 < 8 && n5 < 8 && n5 > n6 && random.nextInt(4) != 0) {
                n5 = n6;
                bl2 = false;
            }
            if (n5 != n6) {
                n6 = n5;
                if (n6 < 0) {
                    cy2.d(n2, n3, n4, 0);
                } else {
                    cy2.b(n2, n3, n4, n6);
                    cy2.h(n2, n3, n4, this.bh);
                    cy2.g(n2, n3, n4, this.bh);
                }
            } else if (bl2) {
                this.j(cy2, n2, n3, n4);
            }
        } else {
            this.j(cy2, n2, n3, n4);
        }
        if (this.m(cy2, n2, n3 - 1, n4)) {
            if (n6 >= 8) {
                cy2.b(n2, n3 - 1, n4, this.bh, n6);
            } else {
                cy2.b(n2, n3 - 1, n4, this.bh, n6 + 8);
            }
        } else if (n6 >= 0 && (n6 == 0 || this.l(cy2, n2, n3 - 1, n4))) {
            boolean[] arrbl = this.k(cy2, n2, n3, n4);
            n5 = n6 + n7;
            if (n6 >= 8) {
                n5 = 1;
            }
            if (n5 >= 8) {
                return;
            }
            if (arrbl[0]) {
                this.g(cy2, n2 - 1, n3, n4, n5);
            }
            if (arrbl[1]) {
                this.g(cy2, n2 + 1, n3, n4, n5);
            }
            if (arrbl[2]) {
                this.g(cy2, n2, n3, n4 - 1, n5);
            }
            if (arrbl[3]) {
                this.g(cy2, n2, n3, n4 + 1, n5);
            }
        }
    }

    private void g(cy cy2, int n2, int n3, int n4, int n5) {
        if (this.m(cy2, n2, n3, n4)) {
            int n6 = cy2.a(n2, n3, n4);
            if (n6 > 0) {
                if (this.bs == hb.g) {
                    this.i(cy2, n2, n3, n4);
                } else {
                    nq.m[n6].b_(cy2, n2, n3, n4, cy2.e(n2, n3, n4));
                }
            }
            cy2.b(n2, n3, n4, this.bh, n5);
        }
    }

    private int a(cy cy2, int n2, int n3, int n4, int n5, int n6) {
        int n7 = 1000;
        for (int i2 = 0; i2 < 4; ++i2) {
            int n8;
            if (i2 == 0 && n6 == 1 || i2 == 1 && n6 == 0 || i2 == 2 && n6 == 3 || i2 == 3 && n6 == 2) continue;
            int n9 = n2;
            int n10 = n3;
            int n11 = n4;
            if (i2 == 0) {
                --n9;
            }
            if (i2 == 1) {
                ++n9;
            }
            if (i2 == 2) {
                --n11;
            }
            if (i2 == 3) {
                ++n11;
            }
            if (this.l(cy2, n9, n10, n11) || cy2.f(n9, n10, n11) == this.bs && cy2.e(n9, n10, n11) == 0) continue;
            if (!this.l(cy2, n9, n10 - 1, n11)) {
                return n5;
            }
            if (n5 >= 4 || (n8 = this.a(cy2, n9, n10, n11, n5 + 1, i2)) >= n7) continue;
            n7 = n8;
        }
        return n7;
    }

    private boolean[] k(cy cy2, int n2, int n3, int n4) {
        int n5;
        int n6;
        for (n6 = 0; n6 < 4; ++n6) {
            this.c[n6] = 1000;
            n5 = n2;
            int n7 = n3;
            int n8 = n4;
            if (n6 == 0) {
                --n5;
            }
            if (n6 == 1) {
                ++n5;
            }
            if (n6 == 2) {
                --n8;
            }
            if (n6 == 3) {
                ++n8;
            }
            if (this.l(cy2, n5, n7, n8) || cy2.f(n5, n7, n8) == this.bs && cy2.e(n5, n7, n8) == 0) continue;
            this.c[n6] = !this.l(cy2, n5, n7 - 1, n8) ? 0 : this.a(cy2, n5, n7, n8, 1, n6);
        }
        n6 = this.c[0];
        for (n5 = 1; n5 < 4; ++n5) {
            if (this.c[n5] >= n6) continue;
            n6 = this.c[n5];
        }
        for (n5 = 0; n5 < 4; ++n5) {
            this.b[n5] = this.c[n5] == n6;
        }
        return this.b;
    }

    private boolean l(cy cy2, int n2, int n3, int n4) {
        int n5 = cy2.a(n2, n3, n4);
        if (n5 == nq.aE.bh || n5 == nq.aL.bh || n5 == nq.aD.bh || n5 == nq.aF.bh || n5 == nq.aX.bh) {
            return true;
        }
        if (n5 == 0) {
            return false;
        }
        hb hb2 = nq.m[n5].bs;
        return hb2.a();
    }

    protected int f(cy cy2, int n2, int n3, int n4, int n5) {
        int n6 = this.h(cy2, n2, n3, n4);
        if (n6 < 0) {
            return n5;
        }
        if (n6 == 0) {
            ++this.a;
        }
        if (n6 >= 8) {
            n6 = 0;
        }
        return n5 < 0 || n6 < n5 ? n6 : n5;
    }

    private boolean m(cy cy2, int n2, int n3, int n4) {
        hb hb2 = cy2.f(n2, n3, n4);
        if (hb2 == this.bs) {
            return false;
        }
        if (hb2 == hb.g) {
            return false;
        }
        return !this.l(cy2, n2, n3, n4);
    }

    public void e(cy cy2, int n2, int n3, int n4) {
        super.e(cy2, n2, n3, n4);
        if (cy2.a(n2, n3, n4) == this.bh) {
            cy2.h(n2, n3, n4, this.bh);
        }
    }
}

