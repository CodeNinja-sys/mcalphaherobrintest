/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVGpuProgram4 {
    public static final int GL_PROGRAM_ATTRIB_COMPONENTS_NV = 35078;
    public static final int GL_PROGRAM_RESULT_COMPONENTS_NV = 35079;
    public static final int GL_MAX_PROGRAM_ATTRIB_COMPONENTS_NV = 35080;
    public static final int GL_MAX_PROGRAM_RESULT_COMPONENTS_NV = 35081;
    public static final int GL_MAX_PROGRAM_GENERIC_ATTRIBS_NV = 36261;
    public static final int GL_MAX_PROGRAM_GENERIC_RESULTS_NV = 36262;

    private NVGpuProgram4() {
    }

    public static void glProgramLocalParameterI4iNV(int target, int index, int x2, int y2, int z2, int w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glProgramLocalParameterI4iNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVGpuProgram4.nglProgramLocalParameterI4iNV(target, index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglProgramLocalParameterI4iNV(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glProgramLocalParameterI4NV(int target, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glProgramLocalParameterI4ivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        NVGpuProgram4.nglProgramLocalParameterI4ivNV(target, index, params, params.position(), function_pointer);
    }

    private static native void nglProgramLocalParameterI4ivNV(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glProgramLocalParametersI4NV(int target, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glProgramLocalParametersI4ivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        NVGpuProgram4.nglProgramLocalParametersI4ivNV(target, index, params.remaining() >> 2, params, params.position(), function_pointer);
    }

    private static native void nglProgramLocalParametersI4ivNV(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static void glProgramLocalParameterI4uiNV(int target, int index, int x2, int y2, int z2, int w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glProgramLocalParameterI4uiNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVGpuProgram4.nglProgramLocalParameterI4uiNV(target, index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglProgramLocalParameterI4uiNV(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glProgramLocalParameterI4uNV(int target, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glProgramLocalParameterI4uivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        NVGpuProgram4.nglProgramLocalParameterI4uivNV(target, index, params, params.position(), function_pointer);
    }

    private static native void nglProgramLocalParameterI4uivNV(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glProgramLocalParametersI4uNV(int target, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glProgramLocalParametersI4uivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        NVGpuProgram4.nglProgramLocalParametersI4uivNV(target, index, params.remaining() >> 2, params, params.position(), function_pointer);
    }

    private static native void nglProgramLocalParametersI4uivNV(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static void glProgramEnvParameterI4iNV(int target, int index, int x2, int y2, int z2, int w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glProgramEnvParameterI4iNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVGpuProgram4.nglProgramEnvParameterI4iNV(target, index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglProgramEnvParameterI4iNV(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glProgramEnvParameterI4NV(int target, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glProgramEnvParameterI4ivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        NVGpuProgram4.nglProgramEnvParameterI4ivNV(target, index, params, params.position(), function_pointer);
    }

    private static native void nglProgramEnvParameterI4ivNV(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glProgramEnvParametersI4NV(int target, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glProgramEnvParametersI4ivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        NVGpuProgram4.nglProgramEnvParametersI4ivNV(target, index, params.remaining() >> 2, params, params.position(), function_pointer);
    }

    private static native void nglProgramEnvParametersI4ivNV(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static void glProgramEnvParameterI4uiNV(int target, int index, int x2, int y2, int z2, int w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glProgramEnvParameterI4uiNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVGpuProgram4.nglProgramEnvParameterI4uiNV(target, index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglProgramEnvParameterI4uiNV(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glProgramEnvParameterI4uNV(int target, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glProgramEnvParameterI4uivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        NVGpuProgram4.nglProgramEnvParameterI4uivNV(target, index, params, params.position(), function_pointer);
    }

    private static native void nglProgramEnvParameterI4uivNV(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glProgramEnvParametersI4uNV(int target, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glProgramEnvParametersI4uivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        NVGpuProgram4.nglProgramEnvParametersI4uivNV(target, index, params.remaining() >> 2, params, params.position(), function_pointer);
    }

    private static native void nglProgramEnvParametersI4uivNV(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static void glGetProgramLocalParameterINV(int target, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glGetProgramLocalParameterIivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        NVGpuProgram4.nglGetProgramLocalParameterIivNV(target, index, params, params.position(), function_pointer);
    }

    private static native void nglGetProgramLocalParameterIivNV(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetProgramLocalParameterIuNV(int target, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glGetProgramLocalParameterIuivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        NVGpuProgram4.nglGetProgramLocalParameterIuivNV(target, index, params, params.position(), function_pointer);
    }

    private static native void nglGetProgramLocalParameterIuivNV(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetProgramEnvParameterINV(int target, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glGetProgramEnvParameterIivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        NVGpuProgram4.nglGetProgramEnvParameterIivNV(target, index, params, params.position(), function_pointer);
    }

    private static native void nglGetProgramEnvParameterIivNV(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetProgramEnvParameterIuNV(int target, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_gpu_program4_glGetProgramEnvParameterIuivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        NVGpuProgram4.nglGetProgramEnvParameterIuivNV(target, index, params, params.position(), function_pointer);
    }

    private static native void nglGetProgramEnvParameterIuivNV(int var0, int var1, IntBuffer var2, int var3, long var4);
}

