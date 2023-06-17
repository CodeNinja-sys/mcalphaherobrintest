/*
 * Decompiled with CFR 0.150.
 */
public class bj
extends dx {
    public bj(int n2) {
        super(n2);
        this.aY = 64;
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return true;
    }

    public fp a(fp fp2, cy cy2, eb eb2) {
        if (eb2.n != null) {
            int n2 = eb2.n.k();
            fp2.b(n2);
            eb2.z();
        } else {
            cy2.a((lw)eb2, "random.bow", 0.5f, 0.4f / (b.nextFloat() * 0.4f + 0.8f));
            if (!cy2.z) {
                cy2.a(new hj(cy2, eb2));
            }
            eb2.z();
        }
        return fp2;
    }
}

