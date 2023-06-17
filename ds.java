/*
 * Decompiled with CFR 0.150.
 */
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class ds {
    private static List a = new ArrayList();
    private static List b = new ArrayList();

    public static synchronized int a(int n2) {
        int n3 = GL11.glGenLists(n2);
        a.add(n3);
        a.add(n2);
        return n3;
    }

    public static synchronized void a(IntBuffer intBuffer) {
        GL11.glGenTextures(intBuffer);
        for (int i2 = intBuffer.position(); i2 < intBuffer.limit(); ++i2) {
            b.add(intBuffer.get(i2));
        }
    }

    public static synchronized void a() {
        for (int i2 = 0; i2 < a.size(); i2 += 2) {
            GL11.glDeleteLists((Integer)a.get(i2), (Integer)a.get(i2 + 1));
        }
        IntBuffer intBuffer = ds.c(b.size());
        intBuffer.flip();
        GL11.glDeleteTextures(intBuffer);
        for (int i3 = 0; i3 < b.size(); ++i3) {
            intBuffer.put((Integer)b.get(i3));
        }
        intBuffer.flip();
        GL11.glDeleteTextures(intBuffer);
        a.clear();
        b.clear();
    }

    public static synchronized ByteBuffer b(int n2) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n2).order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    public static IntBuffer c(int n2) {
        return ds.b(n2 << 2).asIntBuffer();
    }

    public static FloatBuffer d(int n2) {
        return ds.b(n2 << 2).asFloatBuffer();
    }
}

