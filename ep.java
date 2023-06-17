/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class ep
extends fd {
    public byte[] a;

    public ep() {
    }

    public ep(byte[] arrby) {
        this.a = arrby;
    }

    void a(DataOutput dataOutput) {
        dataOutput.writeInt(this.a.length);
        dataOutput.write(this.a);
    }

    void a(DataInput dataInput) {
        int n2 = dataInput.readInt();
        this.a = new byte[n2];
        dataInput.readFully(this.a);
    }

    public byte a() {
        return 7;
    }

    public String toString() {
        return "[" + this.a.length + " bytes]";
    }
}

