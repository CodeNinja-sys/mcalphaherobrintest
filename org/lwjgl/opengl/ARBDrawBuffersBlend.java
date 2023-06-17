/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBDrawBuffersBlend {
    private ARBDrawBuffersBlend() {
    }

    public static void glBlendEquationiARB(int buf, int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_buffers_blend_glBlendEquationiARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBDrawBuffersBlend.nglBlendEquationiARB(buf, mode, function_pointer);
    }

    private static native void nglBlendEquationiARB(int var0, int var1, long var2);

    public static void glBlendEquationSeparateiARB(int buf, int modeRGB, int modeAlpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_buffers_blend_glBlendEquationSeparateiARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBDrawBuffersBlend.nglBlendEquationSeparateiARB(buf, modeRGB, modeAlpha, function_pointer);
    }

    private static native void nglBlendEquationSeparateiARB(int var0, int var1, int var2, long var3);

    public static void glBlendFunciARB(int buf, int src, int dst) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_buffers_blend_glBlendFunciARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBDrawBuffersBlend.nglBlendFunciARB(buf, src, dst, function_pointer);
    }

    private static native void nglBlendFunciARB(int var0, int var1, int var2, long var3);

    public static void glBlendFuncSeparateiARB(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_buffers_blend_glBlendFuncSeparateiARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBDrawBuffersBlend.nglBlendFuncSeparateiARB(buf, srcRGB, dstRGB, srcAlpha, dstAlpha, function_pointer);
    }

    private static native void nglBlendFuncSeparateiARB(int var0, int var1, int var2, int var3, int var4, long var5);
}

