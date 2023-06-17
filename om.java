/*
 * Decompiled with CFR 0.150.
 */
import java.io.File;

public class om
extends oz {
    public void a() {
        this.b = new ei(gg.l, 1.0, 0.0);
        this.c = true;
        this.d = true;
        this.e = true;
        this.g = -1;
    }

    public ao a(float f2, float f3) {
        return ao.b(0.2f, 0.03f, 0.03f);
    }

    protected void b() {
        float f2 = 0.1f;
        for (int i2 = 0; i2 <= 15; ++i2) {
            float f3 = 1.0f - (float)i2 / 15.0f;
            this.f[i2] = (1.0f - f3) / (f3 * 3.0f + 1.0f) * (1.0f - f2) + f2;
        }
    }

    public bd c() {
        return new kj(this.a, this.a.u);
    }

    public ai a(File file) {
        File file2 = new File(file, "DIM-1");
        file2.mkdirs();
        return new mu(file2, true);
    }

    public boolean a(int n2, int n3) {
        int n4 = this.a.a(n2, n3);
        if (n4 == nq.z.bh) {
            return false;
        }
        if (n4 == 0) {
            return false;
        }
        return nq.o[n4];
    }

    public float a(long l2, float f2) {
        return 0.5f;
    }

    public boolean d() {
        return false;
    }
}

