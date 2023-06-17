/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class qi
extends gk {
    public String a;

    public qi() {
    }

    public qi(String string) {
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
        return this.a.length();
    }
}

