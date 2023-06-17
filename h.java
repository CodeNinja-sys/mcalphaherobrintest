/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class h
extends fd {
    public float a;

    public h() {
    }

    public h(float f2) {
        this.a = f2;
    }

    void a(DataOutput dataOutput) {
        dataOutput.writeFloat(this.a);
    }

    void a(DataInput dataInput) {
        this.a = dataInput.readFloat();
    }

    public byte a() {
        return 5;
    }

    public String toString() {
        return "" + this.a;
    }
}

