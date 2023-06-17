/*
 * Decompiled with CFR 0.150.
 */
public class bt {
    private final b[] b;
    public final int a;
    private int c;

    public bt(b[] arrb) {
        this.b = arrb;
        this.a = arrb.length;
    }

    public void a() {
        ++this.c;
    }

    public boolean b() {
        return this.c >= this.b.length;
    }

    public ao a(lw lw2) {
        double d2 = (double)this.b[this.c].a + (double)((int)(lw2.aP + 1.0f)) * 0.5;
        double d3 = this.b[this.c].b;
        double d4 = (double)this.b[this.c].c + (double)((int)(lw2.aP + 1.0f)) * 0.5;
        return ao.b(d2, d3, d4);
    }
}

