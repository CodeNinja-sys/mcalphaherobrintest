/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.HashMap;
import java.util.Map;

public class iq
extends fd {
    private Map a = new HashMap();

    void a(DataOutput dataOutput) {
        for (fd fd2 : this.a.values()) {
            fd.a(fd2, dataOutput);
        }
        dataOutput.writeByte(0);
    }

    void a(DataInput dataInput) {
        fd fd2;
        this.a.clear();
        while ((fd2 = fd.b(dataInput)).a() != 0) {
            this.a.put(fd2.b(), fd2);
        }
    }

    public byte a() {
        return 10;
    }

    public void a(String string, fd fd2) {
        this.a.put(string, fd2.a(string));
    }

    public void a(String string, byte by2) {
        this.a.put(string, new kk(by2).a(string));
    }

    public void a(String string, short s2) {
        this.a.put(string, new nj(s2).a(string));
    }

    public void a(String string, int n2) {
        this.a.put(string, new jy(n2).a(string));
    }

    public void a(String string, long l2) {
        this.a.put(string, new hq(l2).a(string));
    }

    public void a(String string, float f2) {
        this.a.put(string, new h(f2).a(string));
    }

    public void a(String string, double d2) {
        this.a.put(string, new mh(d2).a(string));
    }

    public void a(String string, String string2) {
        this.a.put(string, new pb(string2).a(string));
    }

    public void a(String string, byte[] arrby) {
        this.a.put(string, new ep(arrby).a(string));
    }

    public void a(String string, iq iq2) {
        this.a.put(string, iq2.a(string));
    }

    public void a(String string, boolean bl2) {
        this.a(string, bl2 ? (byte)1 : 0);
    }

    public boolean b(String string) {
        return this.a.containsKey(string);
    }

    public byte c(String string) {
        if (!this.a.containsKey(string)) {
            return 0;
        }
        return ((kk)this.a.get((Object)string)).a;
    }

    public short d(String string) {
        if (!this.a.containsKey(string)) {
            return 0;
        }
        return ((nj)this.a.get((Object)string)).a;
    }

    public int e(String string) {
        if (!this.a.containsKey(string)) {
            return 0;
        }
        return ((jy)this.a.get((Object)string)).a;
    }

    public long f(String string) {
        if (!this.a.containsKey(string)) {
            return 0L;
        }
        return ((hq)this.a.get((Object)string)).a;
    }

    public float g(String string) {
        if (!this.a.containsKey(string)) {
            return 0.0f;
        }
        return ((h)this.a.get((Object)string)).a;
    }

    public double h(String string) {
        if (!this.a.containsKey(string)) {
            return 0.0;
        }
        return ((mh)this.a.get((Object)string)).a;
    }

    public String i(String string) {
        if (!this.a.containsKey(string)) {
            return "";
        }
        return ((pb)this.a.get((Object)string)).a;
    }

    public byte[] j(String string) {
        if (!this.a.containsKey(string)) {
            return new byte[0];
        }
        return ((ep)this.a.get((Object)string)).a;
    }

    public iq k(String string) {
        if (!this.a.containsKey(string)) {
            return new iq();
        }
        return (iq)this.a.get(string);
    }

    public ly l(String string) {
        if (!this.a.containsKey(string)) {
            return new ly();
        }
        return (ly)this.a.get(string);
    }

    public boolean m(String string) {
        return this.c(string) != 0;
    }

    public String toString() {
        return "" + this.a.size() + " entries";
    }
}

