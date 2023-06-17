/*
 * Decompiled with CFR 0.150.
 */
import java.util.ArrayList;
import java.util.List;

public class kp
extends lw {
    private int c = 0;
    public int a = 0;
    private int d;
    private int e;
    private int f;
    public fl b;

    public kp(cy cy2) {
        super(cy2);
        this.aO = 0.0f;
        this.a(0.5f, 0.5f);
    }

    public kp(cy cy2, int n2, int n3, int n4, int n5) {
        this(cy2);
        this.d = n2;
        this.e = n3;
        this.f = n4;
        ArrayList<fl> arrayList = new ArrayList<fl>();
        fl[] arrfl = fl.values();
        int n6 = arrfl.length;
        for (int i2 = 0; i2 < n6; ++i2) {
            fl fl2;
            this.b = fl2 = arrfl[i2];
            this.b(n5);
            if (!this.k()) continue;
            arrayList.add(fl2);
        }
        if (arrayList.size() > 0) {
            this.b = (fl)((Object)arrayList.get(this.bd.nextInt(arrayList.size())));
        }
        this.b(n5);
    }

    public void b(int n2) {
        this.a = n2;
        this.aE = this.aC = (float)(n2 * 90);
        float f2 = this.b.z;
        float f3 = this.b.A;
        float f4 = this.b.z;
        if (n2 == 0 || n2 == 2) {
            f4 = 0.5f;
        } else {
            f2 = 0.5f;
        }
        f2 /= 32.0f;
        f3 /= 32.0f;
        f4 /= 32.0f;
        float f5 = (float)this.d + 0.5f;
        float f6 = (float)this.e + 0.5f;
        float f7 = (float)this.f + 0.5f;
        float f8 = 0.5625f;
        if (n2 == 0) {
            f7 -= f8;
        }
        if (n2 == 1) {
            f5 -= f8;
        }
        if (n2 == 2) {
            f7 += f8;
        }
        if (n2 == 3) {
            f5 += f8;
        }
        if (n2 == 0) {
            f5 -= this.c(this.b.z);
        }
        if (n2 == 1) {
            f7 += this.c(this.b.z);
        }
        if (n2 == 2) {
            f5 += this.c(this.b.z);
        }
        if (n2 == 3) {
            f7 -= this.c(this.b.z);
        }
        this.b(f5, f6 += this.c(this.b.A), f7);
        float f9 = -0.00625f;
        this.aG.c(f5 - f2 - f9, f6 - f3 - f9, f7 - f4 - f9, f5 + f2 + f9, f6 + f3 + f9, f7 + f4 + f9);
    }

    private float c(int n2) {
        if (n2 == 32) {
            return 0.5f;
        }
        if (n2 == 64) {
            return 0.5f;
        }
        return 0.0f;
    }

    public void e_() {
        if (this.c++ == 100 && !this.k()) {
            this.c = 0;
            this.J();
            this.as.a(new eo(this.as, this.aw, this.ax, this.ay, new fp(dx.aq)));
        }
    }

    public boolean k() {
        int n2;
        if (this.as.a((lw)this, this.aG).size() > 0) {
            return false;
        }
        int n3 = this.b.z / 16;
        int n4 = this.b.A / 16;
        int n5 = this.d;
        int n6 = this.e;
        int n7 = this.f;
        if (this.a == 0) {
            n5 = fi.b(this.aw - (double)((float)this.b.z / 32.0f));
        }
        if (this.a == 1) {
            n7 = fi.b(this.ay - (double)((float)this.b.z / 32.0f));
        }
        if (this.a == 2) {
            n5 = fi.b(this.aw - (double)((float)this.b.z / 32.0f));
        }
        if (this.a == 3) {
            n7 = fi.b(this.ay - (double)((float)this.b.z / 32.0f));
        }
        n6 = fi.b(this.ax - (double)((float)this.b.A / 32.0f));
        for (int i2 = 0; i2 < n3; ++i2) {
            for (n2 = 0; n2 < n4; ++n2) {
                hb hb2 = this.a == 0 || this.a == 2 ? this.as.f(n5 + i2, n6 + n2, this.f) : this.as.f(this.d, n6 + n2, n7 + i2);
                if (hb2.a()) continue;
                return false;
            }
        }
        List list = this.as.b(this, this.aG);
        for (n2 = 0; n2 < list.size(); ++n2) {
            if (!(list.get(n2) instanceof kp)) continue;
            return false;
        }
        return true;
    }

    public boolean n_() {
        return true;
    }

    public boolean a(lw lw2, int n2) {
        this.J();
        this.M();
        this.as.a(new eo(this.as, this.aw, this.ax, this.ay, new fp(dx.aq)));
        return true;
    }

    public void a(iq iq2) {
        iq2.a("Dir", (byte)this.a);
        iq2.a("Motive", this.b.y);
        iq2.a("TileX", this.d);
        iq2.a("TileY", this.e);
        iq2.a("TileZ", this.f);
    }

    public void b(iq iq2) {
        this.a = iq2.c("Dir");
        this.d = iq2.e("TileX");
        this.e = iq2.e("TileY");
        this.f = iq2.e("TileZ");
        String string = iq2.i("Motive");
        for (fl fl2 : fl.values()) {
            if (!fl2.y.equals(string)) continue;
            this.b = fl2;
        }
        if (this.b == null) {
            this.b = fl.a;
        }
        this.b(this.a);
    }
}

