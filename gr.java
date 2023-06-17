/*
 * Decompiled with CFR 0.150.
 */
import java.util.Comparator;

class gr
implements Comparator {
    final /* synthetic */ en a;

    gr(en en2) {
        this.a = en2;
    }

    public int a(cd cd2, cd cd3) {
        if (cd3.a() < cd2.a()) {
            return -1;
        }
        if (cd3.a() > cd2.a()) {
            return 1;
        }
        return 0;
    }
}

