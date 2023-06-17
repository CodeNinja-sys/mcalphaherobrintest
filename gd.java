/*
 * Decompiled with CFR 0.150.
 */
import java.util.ArrayList;

public class gd
extends nq {
    public gd(int n2, int n3) {
        super(n2, n3, hb.c);
    }

    public void a(cy cy2, int n2, int n3, int n4, co co2, ArrayList arrayList) {
        arrayList.add(co.b(n2, n3, n4, n2 + 1, (double)n3 + 1.5, n4 + 1));
    }

    public boolean a(cy cy2, int n2, int n3, int n4) {
        if (cy2.a(n2, n3 - 1, n4) == this.bh) {
            return false;
        }
        if (!cy2.f(n2, n3 - 1, n4).a()) {
            return false;
        }
        return super.a(cy2, n2, n3, n4);
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public int g() {
        return 11;
    }
}

