/*
 * Decompiled with CFR 0.150.
 */
import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL11;

public class l {
    private static FloatBuffer a = ds.d(16);

    public static void a() {
        GL11.glDisable(2896);
        GL11.glDisable(16384);
        GL11.glDisable(16385);
        GL11.glDisable(2903);
    }

    public static void b() {
        GL11.glEnable(2896);
        GL11.glEnable(16384);
        GL11.glEnable(16385);
        GL11.glEnable(2903);
        GL11.glColorMaterial(1032, 5634);
        float f2 = 0.4f;
        float f3 = 0.6f;
        float f4 = 0.0f;
        ao ao2 = ao.b(0.2f, 1.0, -0.7f).b();
        GL11.glLight(16384, 4611, l.a(ao2.a, ao2.b, ao2.c, 0.0));
        GL11.glLight(16384, 4609, l.a(f3, f3, f3, 1.0f));
        GL11.glLight(16384, 4608, l.a(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glLight(16384, 4610, l.a(f4, f4, f4, 1.0f));
        ao2 = ao.b(-0.2f, 1.0, 0.7f).b();
        GL11.glLight(16385, 4611, l.a(ao2.a, ao2.b, ao2.c, 0.0));
        GL11.glLight(16385, 4609, l.a(f3, f3, f3, 1.0f));
        GL11.glLight(16385, 4608, l.a(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glLight(16385, 4610, l.a(f4, f4, f4, 1.0f));
        GL11.glShadeModel(7424);
        GL11.glLightModel(2899, l.a(f2, f2, f2, 1.0f));
    }

    private static FloatBuffer a(double d2, double d3, double d4, double d5) {
        return l.a((float)d2, (float)d3, (float)d4, (float)d5);
    }

    private static FloatBuffer a(float f2, float f3, float f4, float f5) {
        a.clear();
        a.put(f2).put(f3).put(f4).put(f5);
        a.flip();
        return a;
    }
}

