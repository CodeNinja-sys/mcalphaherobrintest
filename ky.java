/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ky
extends gk {
    public int a;
    public int b;
    public int c;
    public int d;
    public byte e;
    public byte f;

    public ky() {
    }

    public ky(lw lw2) {
        this.a = lw2.an;
        this.b = fi.b(lw2.aw * 32.0);
        this.c = fi.b(lw2.ax * 32.0);
        this.d = fi.b(lw2.ay * 32.0);
        this.e = (byte)(lw2.aC * 256.0f / 360.0f);
        this.f = (byte)(lw2.aD * 256.0f / 360.0f);
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readInt();
        this.c = dataInputStream.readInt();
        this.d = dataInputStream.readInt();
        this.e = (byte)dataInputStream.read();
        this.f = (byte)dataInputStream.read();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeInt(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.writeInt(this.d);
        dataOutputStream.write(this.e);
        dataOutputStream.write(this.f);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 34;
    }
}

