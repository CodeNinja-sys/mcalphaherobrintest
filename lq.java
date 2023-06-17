/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class lq
extends gk {
    public int a;
    public int b;
    public boolean c;

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readInt();
        this.c = dataInputStream.read() != 0;
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeInt(this.b);
        dataOutputStream.write(this.c ? 1 : 0);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 9;
    }
}

