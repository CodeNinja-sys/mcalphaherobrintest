/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class fa
extends gk {
    public double a;
    public double b;
    public double c;
    public double d;
    public float e;
    public float f;
    public boolean g;
    public boolean h;
    public boolean i;

    public fa() {
    }

    public fa(boolean bl2) {
        this.g = bl2;
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public void a(DataInputStream dataInputStream) {
        this.g = dataInputStream.read() != 0;
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.write(this.g ? 1 : 0);
    }

    public int a() {
        return 1;
    }
}

