/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class hq
extends fd {
    public long a;

    public hq() {
    }

    public hq(long l2) {
        this.a = l2;
    }

    void a(DataOutput dataOutput) {
        dataOutput.writeLong(this.a);
    }

    void a(DataInput dataInput) {
        this.a = dataInput.readLong();
    }

    public byte a() {
        return 4;
    }

    public String toString() {
        return "" + this.a;
    }
}

