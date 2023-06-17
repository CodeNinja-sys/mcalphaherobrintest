/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVRegisterCombiners2 {
    public static final int GL_PER_STAGE_CONSTANTS_NV = 34101;

    private NVRegisterCombiners2() {
    }

    public static void glCombinerStageParameterNV(int stage, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_register_combiners2_glCombinerStageParameterfvNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        NVRegisterCombiners2.nglCombinerStageParameterfvNV(stage, pname, params, params.position(), function_pointer);
    }

    private static native void nglCombinerStageParameterfvNV(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glGetCombinerStageParameterNV(int stage, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_register_combiners2_glGetCombinerStageParameterfvNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        NVRegisterCombiners2.nglGetCombinerStageParameterfvNV(stage, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetCombinerStageParameterfvNV(int var0, int var1, FloatBuffer var2, int var3, long var4);
}

