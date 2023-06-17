/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ii
extends gk {
    public int a;
    public int b;

    public ii() {
    }

    public ii(lw lw2, int n2) {
        this.a = lw2.an;
        this.b = n2;
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeByte(this.b);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 5;
    }
}

