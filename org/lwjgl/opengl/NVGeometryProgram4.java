/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVGeometryProgram4 {
    public static final int GL_GEOMETRY_PROGRAM_NV = 35878;
    public static final int GL_MAX_PROGRAM_OUTPUT_VERTICES_NV = 35879;
    public static final int GL_MAX_PROGRAM_TOTAL_OUTPUT_COMPONENTS_NV = 35880;

    private NVGeometryProgram4() {
    }

    public static void glProgramVertexLimitNV(int target, int limit) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_geometry_program4_glProgramVertexLimitNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVGeometryProgram4.nglProgramVertexLimitNV(target, limit, function_pointer);
    }

    private static native void nglProgramVertexLimitNV(int var0, int var1, long var2);

    public static void glFramebufferTextureEXT(int target, int attachment, int texture, int level) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_geometry_program4_glFramebufferTextureEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVGeometryProgram4.nglFramebufferTextureEXT(target, attachment, texture, level, function_pointer);
    }

    private static native void nglFramebufferTextureEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glFramebufferTextureLayerEXT(int target, int attachment, int texture, int level, int layer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_geometry_program4_glFramebufferTextureLayerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVGeometryProgram4.nglFramebufferTextureLayerEXT(target, attachment, texture, level, layer, function_pointer);
    }

    private static native void nglFramebufferTextureLayerEXT(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glFramebufferTextureFaceEXT(int target, int attachment, int texture, int level, int face) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_geometry_program4_glFramebufferTextureFaceEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVGeometryProgram4.nglFramebufferTextureFaceEXT(target, attachment, texture, level, face, function_pointer);
    }

    private static native void nglFramebufferTextureFaceEXT(int var0, int var1, int var2, int var3, int var4, long var5);
}

