/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;

public class ly
extends fd {
    private List a = new ArrayList();
    private byte b;

    void a(DataOutput dataOutput) {
        this.b = this.a.size() > 0 ? ((fd)this.a.get(0)).a() : (byte)1;
        dataOutput.writeByte(this.b);
        dataOutput.writeInt(this.a.size());
        for (int i2 = 0; i2 < this.a.size(); ++i2) {
            ((fd)this.a.get(i2)).a(dataOutput);
        }
    }

    void a(DataInput dataInput) {
        this.b = dataInput.readByte();
        int n2 = dataInput.readInt();
        this.a = new ArrayList();
        for (int i2 = 0; i2 < n2; ++i2) {
            fd fd2 = fd.a(this.b);
            fd2.a(dataInput);
            this.a.add(fd2);
        }
    }

    public byte a() {
        return 9;
    }

    public String toString() {
        return "" + this.a.size() + " entries of type " + fd.b(this.b);
    }

    public void a(fd fd2) {
        this.b = fd2.a();
        this.a.add(fd2);
    }

    public fd a(int n2) {
        return (fd)this.a.get(n2);
    }

    public int c() {
        return this.a.size();
    }
}

