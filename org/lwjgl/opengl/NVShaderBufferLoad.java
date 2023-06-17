/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVShaderBufferLoad {
    public static final int GL_BUFFER_GPU_ADDRESS_NV = 36637;
    public static final int GL_GPU_ADDRESS_NV = 36660;
    public static final int GL_MAX_SHADER_BUFFER_ADDRESS_NV = 36661;

    private NVShaderBufferLoad() {
    }

    public static void glMakeBufferResidentNV(int target, int access) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glMakeBufferResidentNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVShaderBufferLoad.nglMakeBufferResidentNV(target, access, function_pointer);
    }

    private static native void nglMakeBufferResidentNV(int var0, int var1, long var2);

    public static void glMakeBufferNonResidentNV(int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glMakeBufferNonResidentNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVShaderBufferLoad.nglMakeBufferNonResidentNV(target, function_pointer);
    }

    private static native void nglMakeBufferNonResidentNV(int var0, long var1);

    public static boolean glIsBufferResidentNV(int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glIsBufferResidentNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = NVShaderBufferLoad.nglIsBufferResidentNV(target, function_pointer);
        return __result;
    }

    private static native boolean nglIsBufferResidentNV(int var0, long var1);

    public static void glMakeNamedBufferResidentNV(int buffer, int access) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glMakeNamedBufferResidentNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVShaderBufferLoad.nglMakeNamedBufferResidentNV(buffer, access, function_pointer);
    }

    private static native void nglMakeNamedBufferResidentNV(int var0, int var1, long var2);

    public static void glMakeNamedBufferNonResidentNV(int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glMakeNamedBufferNonResidentNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVShaderBufferLoad.nglMakeNamedBufferNonResidentNV(buffer, function_pointer);
    }

    private static native void nglMakeNamedBufferNonResidentNV(int var0, long var1);

    public static boolean glIsNamedBufferResidentNV(int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glIsNamedBufferResidentNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = NVShaderBufferLoad.nglIsNamedBufferResidentNV(buffer, function_pointer);
        return __result;
    }

    private static native boolean nglIsNamedBufferResidentNV(int var0, long var1);

    public static void glGetBufferParameteruNV(int target, int pname, LongBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glGetBufferParameterui64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        NVShaderBufferLoad.nglGetBufferParameterui64vNV(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetBufferParameterui64vNV(int var0, int var1, LongBuffer var2, int var3, long var4);

    public static long glGetBufferParameteruNV(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glGetBufferParameterui64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        LongBuffer params = APIUtils.getBufferLong();
        NVShaderBufferLoad.nglGetBufferParameterui64vNV(target, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetNamedBufferParameteruNV(int buffer, int pname, LongBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glGetNamedBufferParameterui64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        NVShaderBufferLoad.nglGetNamedBufferParameterui64vNV(buffer, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetNamedBufferParameterui64vNV(int var0, int var1, LongBuffer var2, int var3, long var4);

    public static long glGetNamedBufferParameteruNV(int buffer, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glGetNamedBufferParameterui64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        LongBuffer params = APIUtils.getBufferLong();
        NVShaderBufferLoad.nglGetNamedBufferParameterui64vNV(buffer, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetIntegeruNV(int value, LongBuffer result) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glGetIntegerui64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(result, 1);
        NVShaderBufferLoad.nglGetIntegerui64vNV(value, result, result.position(), function_pointer);
    }

    private static native void nglGetIntegerui64vNV(int var0, LongBuffer var1, int var2, long var3);

    public static long glGetIntegeruNV(int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glGetIntegerui64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        LongBuffer result = APIUtils.getBufferLong();
        NVShaderBufferLoad.nglGetIntegerui64vNV(value, result, result.position(), function_pointer);
        return result.get(0);
    }

    public static void glUniformui64NV(int location, long value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glUniformui64NV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVShaderBufferLoad.nglUniformui64NV(location, value, function_pointer);
    }

    private static native void nglUniformui64NV(int var0, long var1, long var3);

    public static void glUniformuNV(int location, LongBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glUniformui64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        NVShaderBufferLoad.nglUniformui64vNV(location, value.remaining(), value, value.position(), function_pointer);
    }

    private static native void nglUniformui64vNV(int var0, int var1, LongBuffer var2, int var3, long var4);

    public static void glGetUniformuNV(int program, int location, LongBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glGetUniformui64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        NVShaderBufferLoad.nglGetUniformui64vNV(program, location, params, params.position(), function_pointer);
    }

    private static native void nglGetUniformui64vNV(int var0, int var1, LongBuffer var2, int var3, long var4);

    public static void glProgramUniformui64NV(int program, int location, long value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glProgramUniformui64NV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVShaderBufferLoad.nglProgramUniformui64NV(program, location, value, function_pointer);
    }

    private static native void nglProgramUniformui64NV(int var0, int var1, long var2, long var4);

    public static void glProgramUniformuNV(int program, int location, LongBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_shader_buffer_load_glProgramUniformui64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        NVShaderBufferLoad.nglProgramUniformui64vNV(program, location, value.remaining(), value, value.position(), function_pointer);
    }

    private static native void nglProgramUniformui64vNV(int var0, int var1, int var2, LongBuffer var3, int var4, long var5);
}

