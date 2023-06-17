/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBGpuShaderFp64 {
    public static final int GL_DOUBLE = 5130;
    public static final int GL_DOUBLE_VEC2 = 36860;
    public static final int GL_DOUBLE_VEC3 = 36861;
    public static final int GL_DOUBLE_VEC4 = 36862;
    public static final int GL_DOUBLE_MAT2 = 36678;
    public static final int GL_DOUBLE_MAT3 = 36679;
    public static final int GL_DOUBLE_MAT4 = 36680;
    public static final int GL_DOUBLE_MAT2x3 = 36681;
    public static final int GL_DOUBLE_MAT2x4 = 36682;
    public static final int GL_DOUBLE_MAT3x2 = 36683;
    public static final int GL_DOUBLE_MAT3x4 = 36684;
    public static final int GL_DOUBLE_MAT4x2 = 36685;
    public static final int GL_DOUBLE_MAT4x3 = 36686;

    private ARBGpuShaderFp64() {
    }

    public static void glUniform1d(int location, double x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniform1d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBGpuShaderFp64.nglUniform1d(location, x2, function_pointer);
    }

    private static native void nglUniform1d(int var0, double var1, long var3);

    public static void glUniform2d(int location, double x2, double y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniform2d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBGpuShaderFp64.nglUniform2d(location, x2, y2, function_pointer);
    }

    private static native void nglUniform2d(int var0, double var1, double var3, long var5);

    public static void glUniform3d(int location, double x2, double y2, double z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniform3d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBGpuShaderFp64.nglUniform3d(location, x2, y2, z2, function_pointer);
    }

    private static native void nglUniform3d(int var0, double var1, double var3, double var5, long var7);

    public static void glUniform4d(int location, double x2, double y2, double z2, double w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniform4d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBGpuShaderFp64.nglUniform4d(location, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglUniform4d(int var0, double var1, double var3, double var5, double var7, long var9);

    public static void glUniform1(int location, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniform1dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglUniform1dv(location, value.remaining(), value, value.position(), function_pointer);
    }

    private static native void nglUniform1dv(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glUniform2(int location, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniform2dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglUniform2dv(location, value.remaining() >> 1, value, value.position(), function_pointer);
    }

    private static native void nglUniform2dv(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glUniform3(int location, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniform3dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglUniform3dv(location, value.remaining() / 3, value, value.position(), function_pointer);
    }

    private static native void nglUniform3dv(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glUniform4(int location, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniform4dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglUniform4dv(location, value.remaining() >> 2, value, value.position(), function_pointer);
    }

    private static native void nglUniform4dv(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glUniformMatrix2(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniformMatrix2dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglUniformMatrix2dv(location, value.remaining() >> 2, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix2dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix3(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniformMatrix3dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglUniformMatrix3dv(location, value.remaining() / 9, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix3dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix4(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniformMatrix4dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglUniformMatrix4dv(location, value.remaining() >> 4, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix4dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix2x3(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniformMatrix2x3dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglUniformMatrix2x3dv(location, value.remaining() / 6, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix2x3dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix2x4(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniformMatrix2x4dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglUniformMatrix2x4dv(location, value.remaining() >> 3, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix2x4dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix3x2(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniformMatrix3x2dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglUniformMatrix3x2dv(location, value.remaining() / 6, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix3x2dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix3x4(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniformMatrix3x4dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglUniformMatrix3x4dv(location, value.remaining() / 12, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix3x4dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix4x2(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniformMatrix4x2dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglUniformMatrix4x2dv(location, value.remaining() >> 3, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix4x2dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix4x3(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glUniformMatrix4x3dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglUniformMatrix4x3dv(location, value.remaining() / 12, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix4x3dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glGetUniform(int program, int location, DoubleBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glGetUniformdv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        ARBGpuShaderFp64.nglGetUniformdv(program, location, params, params.position(), function_pointer);
    }

    private static native void nglGetUniformdv(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glProgramUniform1dEXT(int program, int location, double x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniform1dEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBGpuShaderFp64.nglProgramUniform1dEXT(program, location, x2, function_pointer);
    }

    private static native void nglProgramUniform1dEXT(int var0, int var1, double var2, long var4);

    public static void glProgramUniform2dEXT(int program, int location, double x2, double y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniform2dEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBGpuShaderFp64.nglProgramUniform2dEXT(program, location, x2, y2, function_pointer);
    }

    private static native void nglProgramUniform2dEXT(int var0, int var1, double var2, double var4, long var6);

    public static void glProgramUniform3dEXT(int program, int location, double x2, double y2, double z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniform3dEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBGpuShaderFp64.nglProgramUniform3dEXT(program, location, x2, y2, z2, function_pointer);
    }

    private static native void nglProgramUniform3dEXT(int var0, int var1, double var2, double var4, double var6, long var8);

    public static void glProgramUniform4dEXT(int program, int location, double x2, double y2, double z2, double w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniform4dEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBGpuShaderFp64.nglProgramUniform4dEXT(program, location, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglProgramUniform4dEXT(int var0, int var1, double var2, double var4, double var6, double var8, long var10);

    public static void glProgramUniform1EXT(int program, int location, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniform1dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglProgramUniform1dvEXT(program, location, value.remaining(), value, value.position(), function_pointer);
    }

    private static native void nglProgramUniform1dvEXT(int var0, int var1, int var2, DoubleBuffer var3, int var4, long var5);

    public static void glProgramUniform2EXT(int program, int location, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniform2dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglProgramUniform2dvEXT(program, location, value.remaining() >> 1, value, value.position(), function_pointer);
    }

    private static native void nglProgramUniform2dvEXT(int var0, int var1, int var2, DoubleBuffer var3, int var4, long var5);

    public static void glProgramUniform3EXT(int program, int location, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniform3dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglProgramUniform3dvEXT(program, location, value.remaining() / 3, value, value.position(), function_pointer);
    }

    private static native void nglProgramUniform3dvEXT(int var0, int var1, int var2, DoubleBuffer var3, int var4, long var5);

    public static void glProgramUniform4EXT(int program, int location, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniform4dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglProgramUniform4dvEXT(program, location, value.remaining() >> 2, value, value.position(), function_pointer);
    }

    private static native void nglProgramUniform4dvEXT(int var0, int var1, int var2, DoubleBuffer var3, int var4, long var5);

    public static void glProgramUniformMatrix2EXT(int program, int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniformMatrix2dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglProgramUniformMatrix2dvEXT(program, location, value.remaining() >> 2, transpose, value, value.position(), function_pointer);
    }

    private static native void nglProgramUniformMatrix2dvEXT(int var0, int var1, int var2, boolean var3, DoubleBuffer var4, int var5, long var6);

    public static void glProgramUniformMatrix3EXT(int program, int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniformMatrix3dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglProgramUniformMatrix3dvEXT(program, location, value.remaining() / 9, transpose, value, value.position(), function_pointer);
    }

    private static native void nglProgramUniformMatrix3dvEXT(int var0, int var1, int var2, boolean var3, DoubleBuffer var4, int var5, long var6);

    public static void glProgramUniformMatrix4EXT(int program, int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniformMatrix4dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglProgramUniformMatrix4dvEXT(program, location, value.remaining() >> 4, transpose, value, value.position(), function_pointer);
    }

    private static native void nglProgramUniformMatrix4dvEXT(int var0, int var1, int var2, boolean var3, DoubleBuffer var4, int var5, long var6);

    public static void glProgramUniformMatrix2x3EXT(int program, int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniformMatrix2x3dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglProgramUniformMatrix2x3dvEXT(program, location, value.remaining() / 6, transpose, value, value.position(), function_pointer);
    }

    private static native void nglProgramUniformMatrix2x3dvEXT(int var0, int var1, int var2, boolean var3, DoubleBuffer var4, int var5, long var6);

    public static void glProgramUniformMatrix2x4EXT(int program, int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniformMatrix2x4dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglProgramUniformMatrix2x4dvEXT(program, location, value.remaining() >> 3, transpose, value, value.position(), function_pointer);
    }

    private static native void nglProgramUniformMatrix2x4dvEXT(int var0, int var1, int var2, boolean var3, DoubleBuffer var4, int var5, long var6);

    public static void glProgramUniformMatrix3x2EXT(int program, int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniformMatrix3x2dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglProgramUniformMatrix3x2dvEXT(program, location, value.remaining() / 6, transpose, value, value.position(), function_pointer);
    }

    private static native void nglProgramUniformMatrix3x2dvEXT(int var0, int var1, int var2, boolean var3, DoubleBuffer var4, int var5, long var6);

    public static void glProgramUniformMatrix3x4EXT(int program, int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniformMatrix3x4dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglProgramUniformMatrix3x4dvEXT(program, location, value.remaining() / 12, transpose, value, value.position(), function_pointer);
    }

    private static native void nglProgramUniformMatrix3x4dvEXT(int var0, int var1, int var2, boolean var3, DoubleBuffer var4, int var5, long var6);

    public static void glProgramUniformMatrix4x2EXT(int program, int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniformMatrix4x2dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglProgramUniformMatrix4x2dvEXT(program, location, value.remaining() >> 3, transpose, value, value.position(), function_pointer);
    }

    private static native void nglProgramUniformMatrix4x2dvEXT(int var0, int var1, int var2, boolean var3, DoubleBuffer var4, int var5, long var6);

    public static void glProgramUniformMatrix4x3EXT(int program, int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_gpu_shader_fp64_glProgramUniformMatrix4x3dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        ARBGpuShaderFp64.nglProgramUniformMatrix4x3dvEXT(program, location, value.remaining() / 12, transpose, value, value.position(), function_pointer);
    }

    private static native void nglProgramUniformMatrix4x3dvEXT(int var0, int var1, int var2, boolean var3, DoubleBuffer var4, int var5, long var6);
}

