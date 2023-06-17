/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class kd
extends nh {
    public kd() {
        this.g = true;
    }

    public void a(DataInputStream dataInputStream) {
        super.a(dataInputStream);
        this.b = dataInputStream.readByte();
        this.c = dataInputStream.readByte();
        this.d = dataInputStream.readByte();
        this.e = dataInputStream.readByte();
        this.f = dataInputStream.readByte();
    }

    public void a(DataOutputStream dataOutputStream) {
        super.a(dataOutputStream);
        dataOutputStream.writeByte(this.b);
        dataOutputStream.writeByte(this.c);
        dataOutputStream.writeByte(this.d);
        dataOutputStream.writeByte(this.e);
        dataOutputStream.writeByte(this.f);
    }

    public int a() {
        return 9;
    }
}

