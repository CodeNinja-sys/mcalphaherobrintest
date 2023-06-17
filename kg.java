/*
 * Decompiled with CFR 0.150.
 */
public class kg
extends dx {
    private int a;

    public kg(int n2, int n3) {
        super(n2);
        this.aX = 1;
        this.aY = 32 << n3;
        if (n3 == 3) {
            this.aY *= 4;
        }
        this.a = 4 + n3 * 2;
    }

    public float a(fp fp2, nq nq2) {
        return 1.5f;
    }

    public void a(fp fp2, hf hf2) {
        fp2.b(1);
    }

    public void a(fp fp2, int n2, int n3, int n4, int n5) {
        fp2.b(2);
    }

    public int a(lw lw2) {
        return this.a;
    }

    public boolean a() {
        return true;
    }
}

