/*
 * Decompiled with CFR 0.150.
 */
import java.util.Comparator;

public class fx
implements Comparator {
    private lw a;

    public fx(lw lw2) {
        this.a = lw2;
    }

    public int a(bw bw2, bw bw3) {
        return bw2.a(this.a) < bw3.a(this.a) ? -1 : 1;
    }
}

