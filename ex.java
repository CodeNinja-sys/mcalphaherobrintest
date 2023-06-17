/*
 * Decompiled with CFR 0.150.
 */
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public abstract class ex
extends bp {
    private static af j = new af();
    protected int a = 176;
    protected int h = 166;
    protected List i = new ArrayList();

    public void a(int n2, int n3, float f2) {
        this.i();
        int n4 = (this.c - this.a) / 2;
        int n5 = (this.d - this.h) / 2;
        this.a(f2);
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        l.b();
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(n4, n5, 0.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(32826);
        for (int i2 = 0; i2 < this.i.size(); ++i2) {
            of of2 = (of)this.i.get(i2);
            this.a(of2);
            if (!of2.a(n2, n3)) continue;
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            int n6 = of2.e;
            int n7 = of2.f;
            this.a(n6, n7, n6 + 16, n7 + 16, -2130706433, -2130706433);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
        }
        fo fo2 = this.b.g.e;
        if (fo2.e != null) {
            GL11.glTranslatef(0.0f, 0.0f, 32.0f);
            j.a(this.g, this.b.n, fo2.e, n2 - n4 - 8, n3 - n5 - 8);
            j.b(this.g, this.b.n, fo2.e, n2 - n4 - 8, n3 - n5 - 8);
        }
        GL11.glDisable(32826);
        l.a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        this.j();
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        GL11.glPopMatrix();
    }

    protected void j() {
    }

    protected abstract void a(float var1);

    private void a(of of2) {
        int n2;
        hi hi2 = of2.b;
        int n3 = of2.a;
        int n4 = of2.e;
        int n5 = of2.f;
        fp fp2 = hi2.c(n3);
        if (fp2 == null && (n2 = of2.c()) >= 0) {
            GL11.glDisable(2896);
            this.b.n.b(this.b.n.a("/gui/items.png"));
            this.b(n4, n5, n2 % 16 * 16, n2 / 16 * 16, 16, 16);
            GL11.glEnable(2896);
            return;
        }
        j.a(this.g, this.b.n, fp2, n4, n5);
        j.b(this.g, this.b.n, fp2, n4, n5);
    }

    private dz a(int n2, int n3) {
        for (int i2 = 0; i2 < this.i.size(); ++i2) {
            of of2 = (of)this.i.get(i2);
            if (!of2.a(n2, n3)) continue;
            return of2;
        }
        return null;
    }

    protected void a(int n2, int n3, int n4) {
        if (n4 == 0 || n4 == 1) {
            dz dz2 = this.a(n2, n3);
            fo fo2 = this.b.g.e;
            if (dz2 != null) {
                fp fp2 = dz2.b();
                if (fp2 != null || fo2.e != null) {
                    if (fp2 != null && fo2.e == null) {
                        int n5 = n4 == 0 ? fp2.a : (fp2.a + 1) / 2;
                        fo2.e = dz2.b.a(dz2.a, n5);
                        if (fp2.a == 0) {
                            dz2.b(null);
                        }
                        dz2.a();
                    } else if (fp2 == null && fo2.e != null && dz2.a(fo2.e)) {
                        int n6;
                        int n7 = n6 = n4 == 0 ? fo2.e.a : 1;
                        if (n6 > dz2.e()) {
                            n6 = dz2.e();
                        }
                        dz2.b(fo2.e.a(n6));
                        if (fo2.e.a == 0) {
                            fo2.e = null;
                        }
                    } else if (fp2 != null && fo2.e != null) {
                        int n8;
                        if (dz2.a(fo2.e)) {
                            if (fp2.c != fo2.e.c) {
                                if (fo2.e.a <= dz2.e()) {
                                    fp fp3 = fp2;
                                    dz2.b(fo2.e);
                                    fo2.e = fp3;
                                }
                            } else if (fp2.c == fo2.e.c) {
                                if (n4 == 0) {
                                    int n9 = fo2.e.a;
                                    if (n9 > dz2.e() - fp2.a) {
                                        n9 = dz2.e() - fp2.a;
                                    }
                                    if (n9 > fo2.e.c() - fp2.a) {
                                        n9 = fo2.e.c() - fp2.a;
                                    }
                                    fo2.e.a(n9);
                                    if (fo2.e.a == 0) {
                                        fo2.e = null;
                                    }
                                    fp2.a += n9;
                                } else if (n4 == 1) {
                                    int n10 = 1;
                                    if (n10 > dz2.e() - fp2.a) {
                                        n10 = dz2.e() - fp2.a;
                                    }
                                    if (n10 > fo2.e.c() - fp2.a) {
                                        n10 = fo2.e.c() - fp2.a;
                                    }
                                    fo2.e.a(n10);
                                    if (fo2.e.a == 0) {
                                        fo2.e = null;
                                    }
                                    fp2.a += n10;
                                }
                            }
                        } else if (fp2.c == fo2.e.c && fo2.e.c() > 1 && (n8 = fp2.a) > 0 && n8 + fo2.e.a <= fo2.e.c()) {
                            fo2.e.a += n8;
                            fp2.a(n8);
                            if (fp2.a == 0) {
                                dz2.b(null);
                            }
                            dz2.a();
                        }
                    }
                }
                dz2.d();
            } else if (fo2.e != null) {
                int n11 = (this.c - this.a) / 2;
                int n12 = (this.d - this.h) / 2;
                if (n2 < n11 || n3 < n12 || n2 >= n11 + this.a || n3 >= n12 + this.a) {
                    bq bq2 = this.b.g;
                    if (n4 == 0) {
                        bq2.a(fo2.e);
                        fo2.e = null;
                    }
                    if (n4 == 1) {
                        bq2.a(fo2.e.a(1));
                        if (fo2.e.a == 0) {
                            fo2.e = null;
                        }
                    }
                }
            }
        }
    }

    protected void b(int n2, int n3, int n4) {
        if (n4 == 0) {
            // empty if block
        }
    }

    protected void a(char c2, int n2) {
        if (n2 == 1 || n2 == this.b.y.p.b) {
            this.b.a(null);
        }
    }

    public void h() {
        if (this.b.g == null) {
            return;
        }
        fo fo2 = this.b.g.e;
        if (fo2.e != null) {
            this.b.g.a(fo2.e);
            fo2.e = null;
        }
    }

    public boolean b() {
        return false;
    }
}

