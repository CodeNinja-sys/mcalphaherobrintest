/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class cq
extends gk {
    public int a;

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(this.a);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 1;
    }
}

