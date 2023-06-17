/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class iu
extends gk {
    public int a;
    public String b;
    public String c;
    public long d;
    public byte e;

    public iu() {
    }

    public iu(String string, String string2, int n2) {
        this.b = string;
        this.c = string2;
        this.a = n2;
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readUTF();
        this.c = dataInputStream.readUTF();
        this.d = dataInputStream.readLong();
        this.e = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeUTF(this.b);
        dataOutputStream.writeUTF(this.c);
        dataOutputStream.writeLong(this.d);
        dataOutputStream.writeByte(this.e);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 4 + this.b.length() + this.c.length() + 4 + 5;
    }
}

