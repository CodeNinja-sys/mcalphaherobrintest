/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class nz
extends fa {
    public nz() {
        this.i = true;
    }

    public nz(float f2, float f3, boolean bl2) {
        this.e = f2;
        this.f = f3;
        this.g = bl2;
        this.i = true;
    }

    public void a(DataInputStream dataInputStream) {
        this.e = dataInputStream.readFloat();
        this.f = dataInputStream.readFloat();
        super.a(dataInputStream);
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeFloat(this.e);
        dataOutputStream.writeFloat(this.f);
        super.a(dataOutputStream);
    }

    public int a() {
        return 9;
    }
}

