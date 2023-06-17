/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class APPLEFence {
    public static final int GL_DRAW_PIXELS_APPLE = 35338;
    public static final int GL_FENCE_APPLE = 35339;

    private APPLEFence() {
    }

    public static void glGenFencesAPPLE(IntBuffer fences) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_fence_glGenFencesAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(fences);
        APPLEFence.nglGenFencesAPPLE(fences.remaining(), fences, fences.position(), function_pointer);
    }

    private static native void nglGenFencesAPPLE(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenFencesAPPLE() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_fence_glGenFencesAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer fences = APIUtils.getBufferInt();
        APPLEFence.nglGenFencesAPPLE(1, fences, fences.position(), function_pointer);
        return fences.get(0);
    }

    public static void glDeleteFencesAPPLE(IntBuffer fences) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_fence_glDeleteFencesAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(fences);
        APPLEFence.nglDeleteFencesAPPLE(fences.remaining(), fences, fences.position(), function_pointer);
    }

    private static native void nglDeleteFencesAPPLE(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteFencesAPPLE(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_fence_glDeleteFencesAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        APPLEFence.nglDeleteFencesAPPLE(1, APIUtils.getBufferInt().put(0, fence), 0, function_pointer);
    }

    public static void glSetFenceAPPLE(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_fence_glSetFenceAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        APPLEFence.nglSetFenceAPPLE(fence, function_pointer);
    }

    private static native void nglSetFenceAPPLE(int var0, long var1);

    public static boolean glIsFenceAPPLE(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_fence_glIsFenceAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = APPLEFence.nglIsFenceAPPLE(fence, function_pointer);
        return __result;
    }

    private static native boolean nglIsFenceAPPLE(int var0, long var1);

    public static boolean glTestFenceAPPLE(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_fence_glTestFenceAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = APPLEFence.nglTestFenceAPPLE(fence, function_pointer);
        return __result;
    }

    private static native boolean nglTestFenceAPPLE(int var0, long var1);

    public static void glFinishFenceAPPLE(int fence) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_fence_glFinishFenceAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        APPLEFence.nglFinishFenceAPPLE(fence, function_pointer);
    }

    private static native void nglFinishFenceAPPLE(int var0, long var1);

    public static boolean glTestObjectAPPLE(int object, int name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_fence_glTestObjectAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = APPLEFence.nglTestObjectAPPLE(object, name, function_pointer);
        return __result;
    }

    private static native boolean nglTestObjectAPPLE(int var0, int var1, long var2);

    public static void glFinishObjectAPPLE(int object, int name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_fence_glFinishObjectAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        APPLEFence.nglFinishObjectAPPLE(object, name, function_pointer);
    }

    private static native void nglFinishObjectAPPLE(int var0, int var1, long var2);
}

