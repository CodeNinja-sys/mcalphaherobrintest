/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class lz
extends gk {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.e = dataInputStream.readByte();
        this.b = dataInputStream.readInt();
        this.c = dataInputStream.readInt();
        this.d = dataInputStream.readInt();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeByte(this.e);
        dataOutputStream.writeInt(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.writeInt(this.d);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 17;
    }
}

