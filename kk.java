/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class kk
extends fd {
    public byte a;

    public kk() {
    }

    public kk(byte by2) {
        this.a = by2;
    }

    void a(DataOutput dataOutput) {
        dataOutput.writeByte(this.a);
    }

    void a(DataInput dataInput) {
        this.a = dataInput.readByte();
    }

    public byte a() {
        return 1;
    }

    public String toString() {
        return "" + this.a;
    }
}

