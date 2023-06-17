/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ATIEnvmapBumpmap {
    public static final int GL_BUMP_ROT_MATRIX_ATI = 34677;
    public static final int GL_BUMP_ROT_MATRIX_SIZE_ATI = 34678;
    public static final int GL_BUMP_NUM_TEX_UNITS_ATI = 34679;
    public static final int GL_BUMP_TEX_UNITS_ATI = 34680;
    public static final int GL_DUDV_ATI = 34681;
    public static final int GL_DU8DV8_ATI = 34682;
    public static final int GL_BUMP_ENVMAP_ATI = 34683;
    public static final int GL_BUMP_TARGET_ATI = 34684;

    private ATIEnvmapBumpmap() {
    }

    public static void glTexBumpParameterATI(int pname, FloatBuffer param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_envmap_bumpmap_glTexBumpParameterfvATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(param, 4);
        ATIEnvmapBumpmap.nglTexBumpParameterfvATI(pname, param, param.position(), function_pointer);
    }

    private static native void nglTexBumpParameterfvATI(int var0, FloatBuffer var1, int var2, long var3);

    public static void glTexBumpParameterATI(int pname, IntBuffer param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_envmap_bumpmap_glTexBumpParameterivATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(param, 4);
        ATIEnvmapBumpmap.nglTexBumpParameterivATI(pname, param, param.position(), function_pointer);
    }

    private static native void nglTexBumpParameterivATI(int var0, IntBuffer var1, int var2, long var3);

    public static void glGetTexBumpParameterATI(int pname, FloatBuffer param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_envmap_bumpmap_glGetTexBumpParameterfvATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(param, 4);
        ATIEnvmapBumpmap.nglGetTexBumpParameterfvATI(pname, param, param.position(), function_pointer);
    }

    private static native void nglGetTexBumpParameterfvATI(int var0, FloatBuffer var1, int var2, long var3);

    public static void glGetTexBumpParameterATI(int pname, IntBuffer param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_envmap_bumpmap_glGetTexBumpParameterivATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(param, 4);
        ATIEnvmapBumpmap.nglGetTexBumpParameterivATI(pname, param, param.position(), function_pointer);
    }

    private static native void nglGetTexBumpParameterivATI(int var0, IntBuffer var1, int var2, long var3);
}

