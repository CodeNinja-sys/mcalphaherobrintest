/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class hs
extends gk {
    public int a;
    public String b;
    public int c;
    public int d;
    public int e;
    public byte f;
    public byte g;
    public int h;

    public hs() {
    }

    public hs(eb eb2) {
        this.a = eb2.an;
        this.b = eb2.l;
        this.c = fi.b(eb2.aw * 32.0);
        this.d = fi.b(eb2.ax * 32.0);
        this.e = fi.b(eb2.ay * 32.0);
        this.f = (byte)(eb2.aC * 256.0f / 360.0f);
        this.g = (byte)(eb2.aD * 256.0f / 360.0f);
        fp fp2 = eb2.e.a();
        this.h = fp2 == null ? 0 : fp2.c;
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readUTF();
        this.c = dataInputStream.readInt();
        this.d = dataInputStream.readInt();
        this.e = dataInputStream.readInt();
        this.f = dataInputStream.readByte();
        this.g = dataInputStream.readByte();
        this.h = dataInputStream.readShort();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeUTF(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.writeInt(this.d);
        dataOutputStream.writeInt(this.e);
        dataOutputStream.writeByte(this.f);
        dataOutputStream.writeByte(this.g);
        dataOutputStream.writeShort(this.h);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 28;
    }
}

