/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class py
extends gk {
    public int a;
    public int b;
    public int c;
    public byte[] d;
    public iq e;

    public py() {
        this.j = true;
    }

    public py(int n2, int n3, int n4, ji ji2) {
        this.j = true;
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.e = new iq();
        ji2.b(this.e);
        try {
            this.d = ab.a(this.e);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readShort();
        this.c = dataInputStream.readInt();
        int n2 = dataInputStream.readShort() & 0xFFFF;
        this.d = new byte[n2];
        dataInputStream.readFully(this.d);
        this.e = ab.a(this.d);
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeShort(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.writeShort((short)this.d.length);
        dataOutputStream.write(this.d);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return this.d.length + 2 + 10;
    }
}

