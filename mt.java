/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class mt
extends gk {
    public int a;
    public int b;
    public int c;

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readShort();
        this.b = dataInputStream.readByte();
        this.c = dataInputStream.readShort();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeShort(this.a);
        dataOutputStream.writeByte(this.b);
        dataOutputStream.writeShort(this.c);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 5;
    }
}

