/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class AMDDrawBuffersBlend {
    private AMDDrawBuffersBlend() {
    }

    public static void glBlendFuncIndexedAMD(int buf, int src, int dst) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_draw_buffers_blend_glBlendFuncIndexedAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        AMDDrawBuffersBlend.nglBlendFuncIndexedAMD(buf, src, dst, function_pointer);
    }

    private static native void nglBlendFuncIndexedAMD(int var0, int var1, int var2, long var3);

    public static void glBlendFuncSeparateIndexedAMD(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_draw_buffers_blend_glBlendFuncSeparateIndexedAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        AMDDrawBuffersBlend.nglBlendFuncSeparateIndexedAMD(buf, srcRGB, dstRGB, srcAlpha, dstAlpha, function_pointer);
    }

    private static native void nglBlendFuncSeparateIndexedAMD(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glBlendEquationIndexedAMD(int buf, int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_draw_buffers_blend_glBlendEquationIndexedAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        AMDDrawBuffersBlend.nglBlendEquationIndexedAMD(buf, mode, function_pointer);
    }

    private static native void nglBlendEquationIndexedAMD(int var0, int var1, long var2);

    public static void glBlendEquationSeparateIndexedAMD(int buf, int modeRGB, int modeAlpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_draw_buffers_blend_glBlendEquationSeparateIndexedAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        AMDDrawBuffersBlend.nglBlendEquationSeparateIndexedAMD(buf, modeRGB, modeAlpha, function_pointer);
    }

    private static native void nglBlendEquationSeparateIndexedAMD(int var0, int var1, int var2, long var3);
}

