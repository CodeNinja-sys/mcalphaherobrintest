/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVDepthBufferFloat {
    public static final int GL_DEPTH_COMPONENT32F_NV = 36267;
    public static final int GL_DEPTH32F_STENCIL8_NV = 36268;
    public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV_NV = 36269;
    public static final int GL_DEPTH_BUFFER_FLOAT_MODE_NV = 36271;

    private NVDepthBufferFloat() {
    }

    public static void glDepthRangedNV(double n2, double f2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_depth_buffer_float_glDepthRangedNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVDepthBufferFloat.nglDepthRangedNV(n2, f2, function_pointer);
    }

    private static native void nglDepthRangedNV(double var0, double var2, long var4);

    public static void glClearDepthdNV(double d2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_depth_buffer_float_glClearDepthdNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVDepthBufferFloat.nglClearDepthdNV(d2, function_pointer);
    }

    private static native void nglClearDepthdNV(double var0, long var2);

    public static void glDepthBoundsdNV(double zmin, double zmax) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_depth_buffer_float_glDepthBoundsdNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVDepthBufferFloat.nglDepthBoundsdNV(zmin, zmax, function_pointer);
    }

    private static native void nglDepthBoundsdNV(double var0, double var2, long var4);
}

