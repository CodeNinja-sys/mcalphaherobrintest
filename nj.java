/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class nj
extends fd {
    public short a;

    public nj() {
    }

    public nj(short s2) {
        this.a = s2;
    }

    void a(DataOutput dataOutput) {
        dataOutput.writeShort(this.a);
    }

    void a(DataInput dataInput) {
        this.a = dataInput.readShort();
    }

    public byte a() {
        return 2;
    }

    public String toString() {
        return "" + this.a;
    }
}

