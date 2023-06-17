/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class p
extends gk {
    public int a;
    public fp[] b;

    public p() {
    }

    public p(int n2, fp[] arrfp) {
        this.a = n2;
        this.b = new fp[arrfp.length];
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            this.b[i2] = arrfp[i2] == null ? null : arrfp[i2].e();
        }
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        int n2 = dataInputStream.readShort();
        this.b = new fp[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            short s2 = dataInputStream.readShort();
            if (s2 < 0) continue;
            byte by2 = dataInputStream.readByte();
            short s3 = dataInputStream.readShort();
            this.b[i2] = new fp(s2, by2, s3);
        }
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeShort(this.b.length);
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            if (this.b[i2] == null) {
                dataOutputStream.writeShort(-1);
                continue;
            }
            dataOutputStream.writeShort((short)this.b[i2].c);
            dataOutputStream.writeByte((byte)this.b[i2].a);
            dataOutputStream.writeShort((short)this.b[i2].d);
        }
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 6 + this.b.length * 5;
    }
}

