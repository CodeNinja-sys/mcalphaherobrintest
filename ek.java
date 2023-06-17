/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ek
extends gk {
    public long a;

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readLong();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeLong(this.a);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 8;
    }
}

