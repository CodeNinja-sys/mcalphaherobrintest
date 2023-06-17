/*
 * Decompiled with CFR 0.150.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ab {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static iq a(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(inputStream));
        try {
            iq iq2 = ab.a(dataInputStream);
            return iq2;
        }
        finally {
            dataInputStream.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void a(iq iq2, OutputStream outputStream) {
        DataOutputStream dataOutputStream = new DataOutputStream(new GZIPOutputStream(outputStream));
        try {
            ab.a(iq2, dataOutputStream);
        }
        finally {
            dataOutputStream.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static iq a(byte[] arrby) {
        DataInputStream dataInputStream = new DataInputStream(new GZIPInputStream(new ByteArrayInputStream(arrby)));
        try {
            iq iq2 = ab.a(dataInputStream);
            return iq2;
        }
        finally {
            dataInputStream.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static byte[] a(iq iq2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream));
        try {
            ab.a(iq2, dataOutputStream);
        }
        finally {
            dataOutputStream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static iq a(DataInput dataInput) {
        fd fd2 = fd.b(dataInput);
        if (fd2 instanceof iq) {
            return (iq)fd2;
        }
        throw new IOException("Root tag must be a named compound tag");
    }

    public static void a(iq iq2, DataOutput dataOutput) {
        fd.a(iq2, dataOutput);
    }
}

