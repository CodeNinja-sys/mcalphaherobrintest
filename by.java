/*
 * Decompiled with CFR 0.150.
 */
public class by
extends dx {
    public by(int n2) {
        super(n2);
        this.aX = 16;
    }

    public fp a(fp fp2, cy cy2, eb eb2) {
        --fp2.a;
        cy2.a((lw)eb2, "random.bow", 0.5f, 0.4f / (b.nextFloat() * 0.4f + 0.8f));
        if (!cy2.z) {
            cy2.a(new at(cy2, eb2));
        }
        return fp2;
    }
}

