/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class fv
extends gk {
    public int a;
    public byte b;
    public int c;
    public int d;
    public int e;
    public byte f;
    public byte g;

    public fv() {
    }

    public fv(hf hf2) {
        this.a = hf2.an;
        this.b = (byte)fq.a(hf2);
        this.c = fi.b(hf2.aw * 32.0);
        this.d = fi.b(hf2.ax * 32.0);
        this.e = fi.b(hf2.ay * 32.0);
        this.f = (byte)(hf2.aC * 256.0f / 360.0f);
        this.g = (byte)(hf2.aD * 256.0f / 360.0f);
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readByte();
        this.c = dataInputStream.readInt();
        this.d = dataInputStream.readInt();
        this.e = dataInputStream.readInt();
        this.f = dataInputStream.readByte();
        this.g = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeByte(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.writeInt(this.d);
        dataOutputStream.writeInt(this.e);
        dataOutputStream.writeByte(this.f);
        dataOutputStream.writeByte(this.g);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 19;
    }
}

