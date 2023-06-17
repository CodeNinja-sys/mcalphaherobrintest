/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVFence {
    public static final int GL_ALL_COMPLETED_NV = 34034;
    public static final int GL_FENCE_STATUS_NV = 34035;
    public static final int GL_FENCE_CONDITION_NV = 34036;

    private NVFence() {
    }

    public static void glGenFencesNV(IntBuffer piFences) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_fence_glGenFencesNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(piFences);
        NVFence.nglGenFencesNV(piFences.remaining(), piFences, piFences.position(), function_pointer);
    }

    private static native void nglGenFencesNV(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteFencesNV(IntBuffer piFences) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_fence_glDeleteFencesNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(piFences);
        NVFence.nglDeleteFencesNV(piFences.remaining(), piFences, piFences.position(), function_pointer);
    }

    private static native void nglDeleteFencesNV(int var0, IntBuffer var1, int var2, long var3);

    public static void glSetFenceNV(int fence, int condition) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_fence_glSetFenceNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVFence.nglSetFenceNV(fence, condition, function_pointer);
    }

    private static native void nglSetFenceNV(int var0, int var1, long var2);

    public static boolean glTestFenceNV(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_fence_glTestFenceNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = NVFence.nglTestFenceNV(fence, function_pointer);
        return __result;
    }

    private static native boolean nglTestFenceNV(int var0, long var1);

    public static void glFinishFenceNV(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_fence_glFinishFenceNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVFence.nglFinishFenceNV(fence, function_pointer);
    }

    private static native void nglFinishFenceNV(int var0, long var1);

    public static boolean glIsFenceNV(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_fence_glIsFenceNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = NVFence.nglIsFenceNV(fence, function_pointer);
        return __result;
    }

    private static native boolean nglIsFenceNV(int var0, long var1);

    public static void glGetFenceivNV(int fence, int pname, IntBuffer piParams) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_fence_glGetFenceivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(piParams, 4);
        NVFence.nglGetFenceivNV(fence, pname, piParams, piParams.position(), function_pointer);
    }

    private static native void nglGetFenceivNV(int var0, int var1, IntBuffer var2, int var3, long var4);
}

