/*
 * Decompiled with CFR 0.150.
 */
public class cb
extends dx {
    private nq[] bb;
    private float bc = 4.0f;
    private int bd;
    protected int a;

    public cb(int n2, int n3, int n4, nq[] arrnq) {
        super(n2);
        this.a = n4;
        this.bb = arrnq;
        this.aX = 1;
        this.aY = 32 << n4;
        if (n4 == 3) {
            this.aY *= 4;
        }
        this.bc = (n4 + 1) * 2;
        this.bd = n3 + n4;
    }

    public float a(fp fp2, nq nq2) {
        for (int i2 = 0; i2 < this.bb.length; ++i2) {
            if (this.bb[i2] != nq2) continue;
            return this.bc;
        }
        return 1.0f;
    }

    public void a(fp fp2, hf hf2) {
        fp2.b(2);
    }

    public void a(fp fp2, int n2, int n3, int n4, int n5) {
        fp2.b(1);
    }

    public int a(lw lw2) {
        return this.bd;
    }

    public boolean a() {
        return true;
    }
}

