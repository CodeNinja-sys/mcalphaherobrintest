/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class gc
extends gk {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;

    public gc() {
    }

    public gc(int n2, int n3, int n4, int n5, int n6) {
        this.e = n2;
        this.a = n3;
        this.b = n4;
        this.c = n5;
        this.d = n6;
    }

    public void a(DataInputStream dataInputStream) {
        this.e = dataInputStream.read();
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.read();
        this.c = dataInputStream.readInt();
        this.d = dataInputStream.read();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.write(this.e);
        dataOutputStream.writeInt(this.a);
        dataOutputStream.write(this.b);
        dataOutputStream.writeInt(this.c);
        dataOutputStream.write(this.d);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 11;
    }
}

