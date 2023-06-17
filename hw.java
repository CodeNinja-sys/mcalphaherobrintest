/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class hw
extends gk {
    public String a;

    public hw() {
    }

    public hw(String string) {
        this.a = string;
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readUTF();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeUTF(this.a);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 4 + this.a.length() + 4;
    }
}

