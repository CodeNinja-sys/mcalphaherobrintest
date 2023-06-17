/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class dv
extends gk {
    public int a;
    public int b;
    public int c;
    public int d;

    public dv() {
    }

    public dv(lw lw2) {
        this(lw2.an, lw2.az, lw2.aA, lw2.aB);
    }

    public dv(int n2, double d2, double d3, double d4) {
        this.a = n2;
        double d5 = 3.9;
        if (d2 < -d5) {
            d2 = -d5;
        }
        if (d3 < -d5) {
            d3 = -d5;
        }
        if (d4 < -d5) {
            d4 = -d5;
        }
        if (d2 > d5) {
            d2 = d5;
        }
        if (d3 > d5) {
            d3 = d5;
        }
        if (d4 > d5) {
            d4 = d5;
        }
        this.b = (int)(d2 * 8000.0);
        this.c = (int)(d3 * 8000.0);
        this.d = (int)(d4 * 8000.0);
    }

    public void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readInt();
        this.b = dataInputStream.readShort();
        this.c = dataInputStream.readShort();
        this.d = dataInputStream.readShort();
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.a);
        dataOutputStream.writeShort(this.b);
        dataOutputStream.writeShort(this.c);
        dataOutputStream.writeShort(this.d);
    }

    public void a(mo mo2) {
        mo2.a(this);
    }

    public int a() {
        return 10;
    }
}

