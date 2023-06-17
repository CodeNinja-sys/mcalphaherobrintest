/*
 * Decompiled with CFR 0.150.
 */
final class if {
    public final int a;
    public final int b;

    public if(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    public boolean equals(Object object) {
        if (object instanceof if) {
            if if_ = (if)object;
            return this.a == if_.a && this.b == if_.b;
        }
        return false;
    }

    public int hashCode() {
        return this.a << 16 ^ this.b;
    }
}

