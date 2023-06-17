/*
 * Decompiled with CFR 0.150.
 */
import org.lwjgl.opengl.GLContext;

public class bm {
    private static boolean a = false;

    public boolean a() {
        return a && GLContext.getCapabilities().GL_ARB_occlusion_query;
    }
}

