/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVVertexAttribInteger64bit {
    public static final int GL_INT64_NV = 5134;
    public static final int GL_UNSIGNED_INT64_NV = 5135;

    private NVVertexAttribInteger64bit() {
    }

    public static void glVertexAttribL1i64NV(int index, long x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL1i64NV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexAttribInteger64bit.nglVertexAttribL1i64NV(index, x2, function_pointer);
    }

    private static native void nglVertexAttribL1i64NV(int var0, long var1, long var3);

    public static void glVertexAttribL2i64NV(int index, long x2, long y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL2i64NV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexAttribInteger64bit.nglVertexAttribL2i64NV(index, x2, y2, function_pointer);
    }

    private static native void nglVertexAttribL2i64NV(int var0, long var1, long var3, long var5);

    public static void glVertexAttribL3i64NV(int index, long x2, long y2, long z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL3i64NV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexAttribInteger64bit.nglVertexAttribL3i64NV(index, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexAttribL3i64NV(int var0, long var1, long var3, long var5, long var7);

    public static void glVertexAttribL4i64NV(int index, long x2, long y2, long z2, long w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL4i64NV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexAttribInteger64bit.nglVertexAttribL4i64NV(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttribL4i64NV(int var0, long var1, long var3, long var5, long var7, long var9);

    public static void glVertexAttribL1NV(int index, LongBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL1i64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 1);
        NVVertexAttribInteger64bit.nglVertexAttribL1i64vNV(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribL1i64vNV(int var0, LongBuffer var1, int var2, long var3);

    public static void glVertexAttribL2NV(int index, LongBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL2i64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 2);
        NVVertexAttribInteger64bit.nglVertexAttribL2i64vNV(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribL2i64vNV(int var0, LongBuffer var1, int var2, long var3);

    public static void glVertexAttribL3NV(int index, LongBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL3i64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 3);
        NVVertexAttribInteger64bit.nglVertexAttribL3i64vNV(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribL3i64vNV(int var0, LongBuffer var1, int var2, long var3);

    public static void glVertexAttribL4NV(int index, LongBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL4i64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        NVVertexAttribInteger64bit.nglVertexAttribL4i64vNV(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribL4i64vNV(int var0, LongBuffer var1, int var2, long var3);

    public static void glVertexAttribL1ui64NV(int index, long x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL1ui64NV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexAttribInteger64bit.nglVertexAttribL1ui64NV(index, x2, function_pointer);
    }

    private static native void nglVertexAttribL1ui64NV(int var0, long var1, long var3);

    public static void glVertexAttribL2ui64NV(int index, long x2, long y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL2ui64NV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexAttribInteger64bit.nglVertexAttribL2ui64NV(index, x2, y2, function_pointer);
    }

    private static native void nglVertexAttribL2ui64NV(int var0, long var1, long var3, long var5);

    public static void glVertexAttribL3ui64NV(int index, long x2, long y2, long z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL3ui64NV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexAttribInteger64bit.nglVertexAttribL3ui64NV(index, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexAttribL3ui64NV(int var0, long var1, long var3, long var5, long var7);

    public static void glVertexAttribL4ui64NV(int index, long x2, long y2, long z2, long w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL4ui64NV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexAttribInteger64bit.nglVertexAttribL4ui64NV(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttribL4ui64NV(int var0, long var1, long var3, long var5, long var7, long var9);

    public static void glVertexAttribL1uNV(int index, LongBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL1ui64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 1);
        NVVertexAttribInteger64bit.nglVertexAttribL1ui64vNV(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribL1ui64vNV(int var0, LongBuffer var1, int var2, long var3);

    public static void glVertexAttribL2uNV(int index, LongBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL2ui64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 2);
        NVVertexAttribInteger64bit.nglVertexAttribL2ui64vNV(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribL2ui64vNV(int var0, LongBuffer var1, int var2, long var3);

    public static void glVertexAttribL3uNV(int index, LongBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL3ui64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 3);
        NVVertexAttribInteger64bit.nglVertexAttribL3ui64vNV(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribL3ui64vNV(int var0, LongBuffer var1, int var2, long var3);

    public static void glVertexAttribL4uNV(int index, LongBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribL4ui64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        NVVertexAttribInteger64bit.nglVertexAttribL4ui64vNV(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribL4ui64vNV(int var0, LongBuffer var1, int var2, long var3);

    public static void glGetVertexAttribLNV(int index, int pname, LongBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glGetVertexAttribLi64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        NVVertexAttribInteger64bit.nglGetVertexAttribLi64vNV(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribLi64vNV(int var0, int var1, LongBuffer var2, int var3, long var4);

    public static void glGetVertexAttribLuNV(int index, int pname, LongBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glGetVertexAttribLui64vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        NVVertexAttribInteger64bit.nglGetVertexAttribLui64vNV(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribLui64vNV(int var0, int var1, LongBuffer var2, int var3, long var4);

    public static void glVertexAttribLFormatNV(int index, int size, int type, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_attrib_integer_64bit_glVertexAttribLFormatNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexAttribInteger64bit.nglVertexAttribLFormatNV(index, size, type, stride, function_pointer);
    }

    private static native void nglVertexAttribLFormatNV(int var0, int var1, int var2, int var3, long var4);
}

