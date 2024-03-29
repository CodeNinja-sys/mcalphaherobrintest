/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVConditionalRender {
    public static final int GL_QUERY_WAIT_NV = 36371;
    public static final int GL_QUERY_NO_WAIT_NV = 36372;
    public static final int GL_QUERY_BY_REGION_WAIT_NV = 36373;
    public static final int GL_QUERY_BY_REGION_NO_WAIT_NV = 36374;

    private NVConditionalRender() {
    }

    public static void glBeginConditionalRenderNV(int id2, int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_conditional_render_glBeginConditionalRenderNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVConditionalRender.nglBeginConditionalRenderNV(id2, mode, function_pointer);
    }

    private static native void nglBeginConditionalRenderNV(int var0, int var1, long var2);

    public static void glEndConditionalRenderNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_conditional_render_glEndConditionalRenderNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVConditionalRender.nglEndConditionalRenderNV(function_pointer);
    }

    private static native void nglEndConditionalRenderNV(long var0);
}

