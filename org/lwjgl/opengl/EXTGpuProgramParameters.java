/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class EXTGpuProgramParameters {
    private EXTGpuProgramParameters() {
    }

    public static void glProgramEnvParameters4EXT(int target, int index, int count, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_program_parameters_glProgramEnvParameters4fvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, count << 2);
        EXTGpuProgramParameters.nglProgramEnvParameters4fvEXT(target, index, count, params, params.position(), function_pointer);
    }

    private static native void nglProgramEnvParameters4fvEXT(int var0, int var1, int var2, FloatBuffer var3, int var4, long var5);

    public static void glProgramLocalParameters4EXT(int target, int index, int count, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_program_parameters_glProgramLocalParameters4fvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, count << 2);
        EXTGpuProgramParameters.nglProgramLocalParameters4fvEXT(target, index, count, params, params.position(), function_pointer);
    }

    private static native void nglProgramLocalParameters4fvEXT(int var0, int var1, int var2, FloatBuffer var3, int var4, long var5);
}

