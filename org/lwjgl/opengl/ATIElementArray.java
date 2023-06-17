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

public final class ATIElementArray {
    public static final int GL_ELEMENT_ARRAY_ATI = 34664;
    public static final int GL_ELEMENT_ARRAY_TYPE_ATI = 34665;
    public static final int GL_ELEMENT_ARRAY_POINTER_ATI = 34666;

    private ATIElementArray() {
    }

    public static void glElementPointerATI(ByteBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_element_array_glElementPointerATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        ATIElementArray.nglElementPointerATI(5121, pPointer, pPointer.position(), function_pointer);
    }

    public static void glElementPointerATI(IntBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_element_array_glElementPointerATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        ATIElementArray.nglElementPointerATI(5125, pPointer, pPointer.position() << 2, function_pointer);
    }

    public static void glElementPointerATI(ShortBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_element_array_glElementPointerATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        ATIElementArray.nglElementPointerATI(5123, pPointer, pPointer.position() << 1, function_pointer);
    }

    private static native void nglElementPointerATI(int var0, Buffer var1, int var2, long var3);

    public static void glDrawElementArrayATI(int mode, int count) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_element_array_glDrawElementArrayATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIElementArray.nglDrawElementArrayATI(mode, count, function_pointer);
    }

    private static native void nglDrawElementArrayATI(int var0, int var1, long var2);

    public static void glDrawRangeElementArrayATI(int mode, int start, int end, int count) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_element_array_glDrawRangeElementArrayATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIElementArray.nglDrawRangeElementArrayATI(mode, start, end, count, function_pointer);
    }

    private static native void nglDrawRangeElementArrayATI(int var0, int var1, int var2, int var3, long var4);
}

