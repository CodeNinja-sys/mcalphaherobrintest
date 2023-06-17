/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class jy
extends fd {
    public int a;

    public jy() {
    }

    public jy(int n2) {
        this.a = n2;
    }

    void a(DataOutput dataOutput) {
        dataOutput.writeInt(this.a);
    }

    void a(DataInput dataInput) {
        this.a = dataInput.readInt();
    }

    public byte a() {
        return 3;
    }

    public String toString() {
        return "" + this.a;
    }
}

