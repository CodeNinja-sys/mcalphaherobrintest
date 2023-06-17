/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVVertexArrayRange {
    public static final int GL_VERTEX_ARRAY_RANGE_NV = 34077;
    public static final int GL_VERTEX_ARRAY_RANGE_LENGTH_NV = 34078;
    public static final int GL_VERTEX_ARRAY_RANGE_VALID_NV = 34079;
    public static final int GL_MAX_VERTEX_ARRAY_RANGE_ELEMENT_NV = 34080;
    public static final int GL_VERTEX_ARRAY_RANGE_POINTER_NV = 34081;

    private NVVertexArrayRange() {
    }

    public static void glVertexArrayRangeNV(ByteBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_array_range_glVertexArrayRangeNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        NVVertexArrayRange.nglVertexArrayRangeNV(pPointer.remaining(), pPointer, pPointer.position(), function_pointer);
    }

    public static void glVertexArrayRangeNV(DoubleBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_array_range_glVertexArrayRangeNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        NVVertexArrayRange.nglVertexArrayRangeNV(pPointer.remaining() << 3, pPointer, pPointer.position() << 3, function_pointer);
    }

    public static void glVertexArrayRangeNV(FloatBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_array_range_glVertexArrayRangeNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        NVVertexArrayRange.nglVertexArrayRangeNV(pPointer.remaining() << 2, pPointer, pPointer.position() << 2, function_pointer);
    }

    public static void glVertexArrayRangeNV(IntBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_array_range_glVertexArrayRangeNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        NVVertexArrayRange.nglVertexArrayRangeNV(pPointer.remaining() << 2, pPointer, pPointer.position() << 2, function_pointer);
    }

    public static void glVertexArrayRangeNV(ShortBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_array_range_glVertexArrayRangeNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        NVVertexArrayRange.nglVertexArrayRangeNV(pPointer.remaining() << 1, pPointer, pPointer.position() << 1, function_pointer);
    }

    private static native void nglVertexArrayRangeNV(int var0, Buffer var1, int var2, long var3);

    public static void glFlushVertexArrayRangeNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_array_range_glFlushVertexArrayRangeNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexArrayRange.nglFlushVertexArrayRangeNV(function_pointer);
    }

    private static native void nglFlushVertexArrayRangeNV(long var0);

    public static ByteBuffer glAllocateMemoryNV(int size, float readFrequency, float writeFrequency, float priority) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_array_range_glAllocateMemoryNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ByteBuffer __result = NVVertexArrayRange.nglAllocateMemoryNV(size, readFrequency, writeFrequency, priority, size, function_pointer);
        return __result;
    }

    private static native ByteBuffer nglAllocateMemoryNV(int var0, float var1, float var2, float var3, long var4, long var6);

    public static void glFreeMemoryNV(ByteBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_array_range_glFreeMemoryNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pointer);
        NVVertexArrayRange.nglFreeMemoryNV(pointer, pointer.position(), function_pointer);
    }

    private static native void nglFreeMemoryNV(Buffer var0, int var1, long var2);
}

