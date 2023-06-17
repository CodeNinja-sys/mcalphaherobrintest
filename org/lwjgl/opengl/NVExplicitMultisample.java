/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVExplicitMultisample {
    public static final int GL_SAMPLE_POSITION_NV = 36432;
    public static final int GL_SAMPLE_MASK_NV = 36433;
    public static final int GL_SAMPLE_MASK_VALUE_NV = 36434;
    public static final int GL_TEXTURE_BINDING_RENDERBUFFER_NV = 36435;
    public static final int GL_TEXTURE_RENDERBUFFER_DATA_STORE_BINDING_NV = 36436;
    public static final int GL_MAX_SAMPLE_MASK_WORDS_NV = 36441;
    public static final int GL_TEXTURE_RENDERBUFFER_NV = 36437;
    public static final int GL_SAMPLER_RENDERBUFFER_NV = 36438;
    public static final int GL_INT_SAMPLER_RENDERBUFFER_NV = 36439;
    public static final int GL_UNSIGNED_INT_SAMPLER_RENDERBUFFER_NV = 36440;

    private NVExplicitMultisample() {
    }

    public static void glGetBooleanIndexedEXT(int pname, int index, ByteBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_explicit_multisample_glGetBooleanIndexedvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, 16);
        NVExplicitMultisample.nglGetBooleanIndexedvEXT(pname, index, data, data.position(), function_pointer);
    }

    private static native void nglGetBooleanIndexedvEXT(int var0, int var1, ByteBuffer var2, int var3, long var4);

    public static boolean glGetBooleanIndexedEXT(int pname, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_explicit_multisample_glGetBooleanIndexedvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ByteBuffer data = APIUtils.getBufferByte(1);
        NVExplicitMultisample.nglGetBooleanIndexedvEXT(pname, index, data, data.position(), function_pointer);
        return data.get(0) == 1;
    }

    public static void glGetIntegerIndexedEXT(int pname, int index, IntBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_explicit_multisample_glGetIntegerIndexedvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, 16);
        NVExplicitMultisample.nglGetIntegerIndexedvEXT(pname, index, data, data.position(), function_pointer);
    }

    private static native void nglGetIntegerIndexedvEXT(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetIntegerIndexedEXT(int pname, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_explicit_multisample_glGetIntegerIndexedvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer data = APIUtils.getBufferInt();
        NVExplicitMultisample.nglGetIntegerIndexedvEXT(pname, index, data, data.position(), function_pointer);
        return data.get(0);
    }

    public static void glGetMultisampleNV(int pname, int index, FloatBuffer val) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_explicit_multisample_glGetMultisamplefvNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(val, 2);
        NVExplicitMultisample.nglGetMultisamplefvNV(pname, index, val, val.position(), function_pointer);
    }

    private static native void nglGetMultisamplefvNV(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glSampleMaskIndexedNV(int index, int mask) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_explicit_multisample_glSampleMaskIndexedNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVExplicitMultisample.nglSampleMaskIndexedNV(index, mask, function_pointer);
    }

    private static native void nglSampleMaskIndexedNV(int var0, int var1, long var2);

    public static void glTexRenderbufferNV(int target, int renderbuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_explicit_multisample_glTexRenderbufferNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVExplicitMultisample.nglTexRenderbufferNV(target, renderbuffer, function_pointer);
    }

    private static native void nglTexRenderbufferNV(int var0, int var1, long var2);
}

