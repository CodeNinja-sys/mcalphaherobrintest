/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class id
extends gk {
    public int a;
    public int b;
    public int c;
    public int d;
    public byte e;
    public byte f;
    public byte g;
    public int h;
    public int i;

    public id() {
    }

    public id(eo eo2) {
        this.a = eo2.an;
        this.h = eo2.a.c;
        this.i = eo2.a.a;
        this.b = fi.b(eo2.aw * 32.0);
        this.c = fi.b(eo2.ax * 32.0);
        this.d = fi.b(eo2.ay * 32.0);
        this.e = (byte)(eo2.az * 128.0);
        this.f = (byte)(eo2.aA * 128.0);
        this.g = (byte)(eo2.aB * 128.0);
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.h = dataInputStream.readShort();
        this.i = dataInputStream.readByte();
        this.b = dataInputStream.readInt();
        this.c = dataInputStream.readInt();
        this.d = dataInputStream.readInt();
        this.e = dataInputStream.readByte();
        this.f = dataInputStream.readByte();
        this.g = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeShort(this.h);
        dataOutputStream.writeByte(this.i);
        dataOutputStream.writeInt(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.writeInt(this.d);
        dataOutputStream.writeByte(this.e);
        dataOutputStream.writeByte(this.f);
        dataOutputStream.writeByte(this.g);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 22;
    }
}

