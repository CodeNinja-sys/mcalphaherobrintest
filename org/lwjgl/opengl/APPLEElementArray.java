/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class APPLEElementArray {
    public static final int GL_ELEMENT_ARRAY_APPLE = 34664;
    public static final int GL_ELEMENT_ARRAY_TYPE_APPLE = 34665;
    public static final int GL_ELEMENT_ARRAY_POINTER_APPLE = 34666;

    private APPLEElementArray() {
    }

    public static void glElementPointerAPPLE(ByteBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_element_array_glElementPointerAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pointer);
        APPLEElementArray.nglElementPointerAPPLE(5121, pointer, pointer.position(), function_pointer);
    }

    public static void glElementPointerAPPLE(IntBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_element_array_glElementPointerAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pointer);
        APPLEElementArray.nglElementPointerAPPLE(5125, pointer, pointer.position() << 2, function_pointer);
    }

    public static void glElementPointerAPPLE(ShortBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_element_array_glElementPointerAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pointer);
        APPLEElementArray.nglElementPointerAPPLE(5123, pointer, pointer.position() << 1, function_pointer);
    }

    private static native void nglElementPointerAPPLE(int var0, Buffer var1, int var2, long var3);

    public static void glDrawElementArrayAPPLE(int mode, int first, int count) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_element_array_glDrawElementArrayAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        APPLEElementArray.nglDrawElementArrayAPPLE(mode, first, count, function_pointer);
    }

    private static native void nglDrawElementArrayAPPLE(int var0, int var1, int var2, long var3);

    public static void glDrawRangeElementArrayAPPLE(int mode, int start, int end, int first, int count) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_element_array_glDrawRangeElementArrayAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        APPLEElementArray.nglDrawRangeElementArrayAPPLE(mode, start, end, first, count, function_pointer);
    }

    private static native void nglDrawRangeElementArrayAPPLE(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glMultiDrawElementArrayAPPLE(int mode, IntBuffer first, IntBuffer count) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_element_array_glMultiDrawElementArrayAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(first);
        BufferChecks.checkBuffer(count, first.remaining());
        APPLEElementArray.nglMultiDrawElementArrayAPPLE(mode, first, first.position(), count, count.position(), first.remaining(), function_pointer);
    }

    private static native void nglMultiDrawElementArrayAPPLE(int var0, IntBuffer var1, int var2, IntBuffer var3, int var4, int var5, long var6);

    public static void glMultiDrawRangeElementArrayAPPLE(int mode, int start, int end, IntBuffer first, IntBuffer count) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_element_array_glMultiDrawRangeElementArrayAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(first);
        BufferChecks.checkBuffer(count, first.remaining());
        APPLEElementArray.nglMultiDrawRangeElementArrayAPPLE(mode, start, end, first, first.position(), count, count.position(), first.remaining(), function_pointer);
    }

    private static native void nglMultiDrawRangeElementArrayAPPLE(int var0, int var1, int var2, IntBuffer var3, int var4, IntBuffer var5, int var6, int var7, long var8);
}

