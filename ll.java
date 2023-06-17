/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ll
extends nh {
    public ll() {
        this.g = true;
    }

    public void a(DataInputStream dataInputStream) {
        super.a(dataInputStream);
        this.e = dataInputStream.readByte();
        this.f = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) {
        super.a(dataOutputStream);
        dataOutputStream.writeByte(this.e);
        dataOutputStream.writeByte(this.f);
    }

    public int a() {
        return 6;
    }
}

