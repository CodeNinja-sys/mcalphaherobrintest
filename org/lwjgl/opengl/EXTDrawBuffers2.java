/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class EXTDrawBuffers2 {
    private EXTDrawBuffers2() {
    }

    public static void glColorMaskIndexedEXT(int buf, boolean r2, boolean g2, boolean b2, boolean a2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_draw_buffers2_glColorMaskIndexedEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTDrawBuffers2.nglColorMaskIndexedEXT(buf, r2, g2, b2, a2, function_pointer);
    }

    private static native void nglColorMaskIndexedEXT(int var0, boolean var1, boolean var2, boolean var3, boolean var4, long var5);

    public static void glGetBooleanIndexedEXT(int value, int index, ByteBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_draw_buffers2_glGetBooleanIndexedvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, 4);
        EXTDrawBuffers2.nglGetBooleanIndexedvEXT(value, index, data, data.position(), function_pointer);
    }

    private static native void nglGetBooleanIndexedvEXT(int var0, int var1, ByteBuffer var2, int var3, long var4);

    public static boolean glGetBooleanIndexedEXT(int value, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_draw_buffers2_glGetBooleanIndexedvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ByteBuffer data = APIUtils.getBufferByte(1);
        EXTDrawBuffers2.nglGetBooleanIndexedvEXT(value, index, data, data.position(), function_pointer);
        return data.get(0) == 1;
    }

    public static void glGetIntegerIndexedEXT(int value, int index, IntBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_draw_buffers2_glGetIntegerIndexedvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, 4);
        EXTDrawBuffers2.nglGetIntegerIndexedvEXT(value, index, data, data.position(), function_pointer);
    }

    private static native void nglGetIntegerIndexedvEXT(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetIntegerIndexedEXT(int value, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_draw_buffers2_glGetIntegerIndexedvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer data = APIUtils.getBufferInt();
        EXTDrawBuffers2.nglGetIntegerIndexedvEXT(value, index, data, data.position(), function_pointer);
        return data.get(0);
    }

    public static void glEnableIndexedEXT(int target, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_draw_buffers2_glEnableIndexedEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTDrawBuffers2.nglEnableIndexedEXT(target, index, function_pointer);
    }

    private static native void nglEnableIndexedEXT(int var0, int var1, long var2);

    public static void glDisableIndexedEXT(int target, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_draw_buffers2_glDisableIndexedEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTDrawBuffers2.nglDisableIndexedEXT(target, index, function_pointer);
    }

    private static native void nglDisableIndexedEXT(int var0, int var1, long var2);

    public static boolean glIsEnabledIndexedEXT(int target, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_draw_buffers2_glIsEnabledIndexedEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = EXTDrawBuffers2.nglIsEnabledIndexedEXT(target, index, function_pointer);
        return __result;
    }

    private static native boolean nglIsEnabledIndexedEXT(int var0, int var1, long var2);
}

