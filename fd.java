/*
 * Decompiled with CFR 0.150.
 */
import java.io.DataInput;
import java.io.DataOutput;

public abstract class fd {
    private String a = null;

    abstract void a(DataOutput var1);

    abstract void a(DataInput var1);

    public abstract byte a();

    public String b() {
        if (this.a == null) {
            return "";
        }
        return this.a;
    }

    public fd a(String string) {
        this.a = string;
        return this;
    }

    public static fd b(DataInput dataInput) {
        byte by2 = dataInput.readByte();
        if (by2 == 0) {
            return new gx();
        }
        fd fd2 = fd.a(by2);
        fd2.a = dataInput.readUTF();
        fd2.a(dataInput);
        return fd2;
    }

    public static void a(fd fd2, DataOutput dataOutput) {
        dataOutput.writeByte(fd2.a());
        if (fd2.a() == 0) {
            return;
        }
        dataOutput.writeUTF(fd2.b());
        fd2.a(dataOutput);
    }

    public static fd a(byte by2) {
        switch (by2) {
            case 0: {
                return new gx();
            }
            case 1: {
                return new kk();
            }
            case 2: {
                return new nj();
            }
            case 3: {
                return new jy();
            }
            case 4: {
                return new hq();
            }
            case 5: {
                return new h();
            }
            case 6: {
                return new mh();
            }
            case 7: {
                return new ep();
            }
            case 8: {
                return new pb();
            }
            case 9: {
                return new ly();
            }
            case 10: {
                return new iq();
            }
        }
        return null;
    }

    public static String b(byte by2) {
        switch (by2) {
            case 0: {
                return "TAG_End";
            }
            case 1: {
                return "TAG_Byte";
            }
            case 2: {
                return "TAG_Short";
            }
            case 3: {
                return "TAG_Int";
            }
            case 4: {
                return "TAG_Long";
            }
            case 5: {
                return "TAG_Float";
            }
            case 6: {
                return "TAG_Double";
            }
            case 7: {
                return "TAG_Byte_Array";
            }
            case 8: {
                return "TAG_String";
            }
            case 9: {
                return "TAG_List";
            }
            case 10: {
                return "TAG_Compound";
            }
        }
        return "UNKNOWN";
    }
}

