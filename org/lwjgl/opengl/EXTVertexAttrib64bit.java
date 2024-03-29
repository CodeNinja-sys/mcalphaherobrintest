/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;

public final class EXTVertexAttrib64bit {
    public static final int GL_DOUBLE_VEC2_EXT = 36860;
    public static final int GL_DOUBLE_VEC3_EXT = 36861;
    public static final int GL_DOUBLE_VEC4_EXT = 36862;
    public static final int GL_DOUBLE_MAT2_EXT = 36678;
    public static final int GL_DOUBLE_MAT3_EXT = 36679;
    public static final int GL_DOUBLE_MAT4_EXT = 36680;
    public static final int GL_DOUBLE_MAT2x3_EXT = 36681;
    public static final int GL_DOUBLE_MAT2x4_EXT = 36682;
    public static final int GL_DOUBLE_MAT3x2_EXT = 36683;
    public static final int GL_DOUBLE_MAT3x4_EXT = 36684;
    public static final int GL_DOUBLE_MAT4x2_EXT = 36685;
    public static final int GL_DOUBLE_MAT4x3_EXT = 36686;

    private EXTVertexAttrib64bit() {
    }

    public static void glVertexAttribL1dEXT(int index, double x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_vertex_attrib_64bit_glVertexAttribL1dEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTVertexAttrib64bit.nglVertexAttribL1dEXT(index, x2, function_pointer);
    }

    private static native void nglVertexAttribL1dEXT(int var0, double var1, long var3);

    public static void glVertexAttribL2dEXT(int index, double x2, double y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_vertex_attrib_64bit_glVertexAttribL2dEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTVertexAttrib64bit.nglVertexAttribL2dEXT(index, x2, y2, function_pointer);
    }

    private static native void nglVertexAttribL2dEXT(int var0, double var1, double var3, long var5);

    public static void glVertexAttribL3dEXT(int index, double x2, double y2, double z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_vertex_attrib_64bit_glVertexAttribL3dEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTVertexAttrib64bit.nglVertexAttribL3dEXT(index, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexAttribL3dEXT(int var0, double var1, double var3, double var5, long var7);

    public static void glVertexAttribL4dEXT(int index, double x2, double y2, double z2, double w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_vertex_attrib_64bit_glVertexAttribL4dEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTVertexAttrib64bit.nglVertexAttribL4dEXT(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttribL4dEXT(int var0, double var1, double var3, double var5, double var7, long var9);

    public static void glVertexAttribL1EXT(int index, DoubleBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_vertex_attrib_64bit_glVertexAttribL1dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 1);
        EXTVertexAttrib64bit.nglVertexAttribL1dvEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribL1dvEXT(int var0, DoubleBuffer var1, int var2, long var3);

    public static void glVertexAttribL2EXT(int index, DoubleBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_vertex_attrib_64bit_glVertexAttribL2dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 2);
        EXTVertexAttrib64bit.nglVertexAttribL2dvEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribL2dvEXT(int var0, DoubleBuffer var1, int var2, long var3);

    public static void glVertexAttribL3EXT(int index, DoubleBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_vertex_attrib_64bit_glVertexAttribL3dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 3);
        EXTVertexAttrib64bit.nglVertexAttribL3dvEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribL3dvEXT(int var0, DoubleBuffer var1, int var2, long var3);

    public static void glVertexAttribL4EXT(int index, DoubleBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_vertex_attrib_64bit_glVertexAttribL4dvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        EXTVertexAttrib64bit.nglVertexAttribL4dvEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribL4dvEXT(int var0, DoubleBuffer var1, int var2, long var3);

    public static void glVertexAttribLPointerEXT(int index, int size, int stride, DoubleBuffer pointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_vertex_attrib_64bit_glVertexAttribLPointerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pointer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = pointer;
        EXTVertexAttrib64bit.nglVertexAttribLPointerEXT(index, size, 5130, stride, pointer, pointer.position() << 3, function_pointer);
    }

    private static native void nglVertexAttribLPointerEXT(int var0, int var1, int var2, int var3, Buffer var4, int var5, long var6);

    public static void glVertexAttribLPointerEXT(int index, int size, int stride, long pointer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_vertex_attrib_64bit_glVertexAttribLPointerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        EXTVertexAttrib64bit.nglVertexAttribLPointerEXTBO(index, size, 5130, stride, pointer_buffer_offset, function_pointer);
    }

    private static native void nglVertexAttribLPointerEXTBO(int var0, int var1, int var2, int var3, long var4, long var6);

    public static void glGetVertexAttribLEXT(int index, int pname, DoubleBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_vertex_attrib_64bit_glGetVertexAttribLdvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        EXTVertexAttrib64bit.nglGetVertexAttribLdvEXT(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribLdvEXT(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glVertexArrayVertexAttribLOffsetEXT(int vaobj, int buffer, int index, int size, int type, int stride, long offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_vertex_attrib_64bit_glVertexArrayVertexAttribLOffsetEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTVertexAttrib64bit.nglVertexArrayVertexAttribLOffsetEXT(vaobj, buffer, index, size, type, stride, offset, function_pointer);
    }

    private static native void nglVertexArrayVertexAttribLOffsetEXT(int var0, int var1, int var2, int var3, int var4, int var5, long var6, long var8);
}

