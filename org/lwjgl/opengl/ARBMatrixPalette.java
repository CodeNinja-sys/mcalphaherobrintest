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
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;

public final class ARBMatrixPalette {
    public static final int GL_MATRIX_PALETTE_ARB = 34880;
    public static final int GL_MAX_MATRIX_PALETTE_STACK_DEPTH_ARB = 34881;
    public static final int GL_MAX_PALETTE_MATRICES_ARB = 34882;
    public static final int GL_CURRENT_PALETTE_MATRIX_ARB = 34883;
    public static final int GL_MATRIX_INDEX_ARRAY_ARB = 34884;
    public static final int GL_CURRENT_MATRIX_INDEX_ARB = 34885;
    public static final int GL_MATRIX_INDEX_ARRAY_SIZE_ARB = 34886;
    public static final int GL_MATRIX_INDEX_ARRAY_TYPE_ARB = 34887;
    public static final int GL_MATRIX_INDEX_ARRAY_STRIDE_ARB = 34888;
    public static final int GL_MATRIX_INDEX_ARRAY_POINTER_ARB = 34889;

    private ARBMatrixPalette() {
    }

    public static void glCurrentPaletteMatrixARB(int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_matrix_palette_glCurrentPaletteMatrixARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMatrixPalette.nglCurrentPaletteMatrixARB(index, function_pointer);
    }

    private static native void nglCurrentPaletteMatrixARB(int var0, long var1);

    public static void glMatrixIndexPointerARB(int size, int stride, ByteBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_matrix_palette_glMatrixIndexPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pPointer);
        GLChecks.getReferences((ContextCapabilities)caps).ARB_matrix_palette_glMatrixIndexPointerARB_pPointer = pPointer;
        ARBMatrixPalette.nglMatrixIndexPointerARB(size, 5121, stride, pPointer, pPointer.position(), function_pointer);
    }

    public static void glMatrixIndexPointerARB(int size, int stride, IntBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_matrix_palette_glMatrixIndexPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pPointer);
        GLChecks.getReferences((ContextCapabilities)caps).ARB_matrix_palette_glMatrixIndexPointerARB_pPointer = pPointer;
        ARBMatrixPalette.nglMatrixIndexPointerARB(size, 5125, stride, pPointer, pPointer.position() << 2, function_pointer);
    }

    public static void glMatrixIndexPointerARB(int size, int stride, ShortBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_matrix_palette_glMatrixIndexPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pPointer);
        GLChecks.getReferences((ContextCapabilities)caps).ARB_matrix_palette_glMatrixIndexPointerARB_pPointer = pPointer;
        ARBMatrixPalette.nglMatrixIndexPointerARB(size, 5123, stride, pPointer, pPointer.position() << 1, function_pointer);
    }

    private static native void nglMatrixIndexPointerARB(int var0, int var1, int var2, Buffer var3, int var4, long var5);

    public static void glMatrixIndexPointerARB(int size, int type, int stride, long pPointer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_matrix_palette_glMatrixIndexPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        ARBMatrixPalette.nglMatrixIndexPointerARBBO(size, type, stride, pPointer_buffer_offset, function_pointer);
    }

    private static native void nglMatrixIndexPointerARBBO(int var0, int var1, int var2, long var3, long var5);

    public static void glMatrixIndexuARB(ByteBuffer pIndices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_matrix_palette_glMatrixIndexubvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pIndices);
        ARBMatrixPalette.nglMatrixIndexubvARB(pIndices.remaining(), pIndices, pIndices.position(), function_pointer);
    }

    private static native void nglMatrixIndexubvARB(int var0, ByteBuffer var1, int var2, long var3);

    public static void glMatrixIndexuARB(ShortBuffer pIndices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_matrix_palette_glMatrixIndexusvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pIndices);
        ARBMatrixPalette.nglMatrixIndexusvARB(pIndices.remaining(), pIndices, pIndices.position(), function_pointer);
    }

    private static native void nglMatrixIndexusvARB(int var0, ShortBuffer var1, int var2, long var3);

    public static void glMatrixIndexuARB(IntBuffer pIndices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_matrix_palette_glMatrixIndexuivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pIndices);
        ARBMatrixPalette.nglMatrixIndexuivARB(pIndices.remaining(), pIndices, pIndices.position(), function_pointer);
    }

    private static native void nglMatrixIndexuivARB(int var0, IntBuffer var1, int var2, long var3);
}

