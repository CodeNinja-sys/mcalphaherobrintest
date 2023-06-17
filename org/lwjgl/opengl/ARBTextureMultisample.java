/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBTextureMultisample {
    public static final int GL_SAMPLE_POSITION = 36432;
    public static final int GL_SAMPLE_MASK = 36433;
    public static final int GL_SAMPLE_MASK_VALUE = 36434;
    public static final int GL_TEXTURE_2D_MULTISAMPLE = 37120;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE = 37121;
    public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 37122;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY = 37123;
    public static final int GL_MAX_SAMPLE_MASK_WORDS = 36441;
    public static final int GL_MAX_COLOR_TEXTURE_SAMPLES = 37134;
    public static final int GL_MAX_DEPTH_TEXTURE_SAMPLES = 37135;
    public static final int GL_MAX_INTEGER_SAMPLES = 37136;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 37124;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 37125;
    public static final int GL_TEXTURE_SAMPLES = 37126;
    public static final int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS = 37127;
    public static final int GL_SAMPLER_2D_MULTISAMPLE = 37128;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE = 37129;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = 37130;
    public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 37131;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37132;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37133;

    private ARBTextureMultisample() {
    }

    public static void glTexImage2DMultisample(int target, int samples, int internalformat, int width, int height, boolean fixedsamplelocations) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_texture_multisample_glTexImage2DMultisample_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBTextureMultisample.nglTexImage2DMultisample(target, samples, internalformat, width, height, fixedsamplelocations, function_pointer);
    }

    private static native void nglTexImage2DMultisample(int var0, int var1, int var2, int var3, int var4, boolean var5, long var6);

    public static void glTexImage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, boolean fixedsamplelocations) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_texture_multisample_glTexImage3DMultisample_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBTextureMultisample.nglTexImage3DMultisample(target, samples, internalformat, width, height, depth, fixedsamplelocations, function_pointer);
    }

    private static native void nglTexImage3DMultisample(int var0, int var1, int var2, int var3, int var4, int var5, boolean var6, long var7);

    public static void glGetMultisample(int pname, int index, FloatBuffer val) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_texture_multisample_glGetMultisamplefv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(val, 2);
        ARBTextureMultisample.nglGetMultisamplefv(pname, index, val, val.position(), function_pointer);
    }

    private static native void nglGetMultisamplefv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glSampleMaski(int index, int mask) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_texture_multisample_glSampleMaski_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBTextureMultisample.nglSampleMaski(index, mask, function_pointer);
    }

    private static native void nglSampleMaski(int var0, int var1, long var2);
}

