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
import org.lwjgl.opengl.ARBProgram;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;

public final class ARBVertexProgram
extends ARBProgram {
    public static final int GL_VERTEX_PROGRAM_ARB = 34336;
    public static final int GL_VERTEX_PROGRAM_POINT_SIZE_ARB = 34370;
    public static final int GL_VERTEX_PROGRAM_TWO_SIDE_ARB = 34371;
    public static final int GL_COLOR_SUM_ARB = 33880;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB = 34338;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB = 34339;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB = 34340;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE_ARB = 34341;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB = 34922;
    public static final int GL_CURRENT_VERTEX_ATTRIB_ARB = 34342;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER_ARB = 34373;
    public static final int GL_PROGRAM_ADDRESS_REGISTERS_ARB = 34992;
    public static final int GL_MAX_PROGRAM_ADDRESS_REGISTERS_ARB = 34993;
    public static final int GL_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB = 34994;
    public static final int GL_MAX_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB = 34995;
    public static final int GL_MAX_VERTEX_ATTRIBS_ARB = 34921;

    private ARBVertexProgram() {
    }

    public static void glVertexAttrib1sARB(int index, short x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttrib1sARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglVertexAttrib1sARB(index, x2, function_pointer);
    }

    private static native void nglVertexAttrib1sARB(int var0, short var1, long var2);

    public static void glVertexAttrib1fARB(int index, float x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttrib1fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglVertexAttrib1fARB(index, x2, function_pointer);
    }

    private static native void nglVertexAttrib1fARB(int var0, float var1, long var2);

    public static void glVertexAttrib1dARB(int index, double x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttrib1dARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglVertexAttrib1dARB(index, x2, function_pointer);
    }

    private static native void nglVertexAttrib1dARB(int var0, double var1, long var3);

    public static void glVertexAttrib2sARB(int index, short x2, short y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttrib2sARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglVertexAttrib2sARB(index, x2, y2, function_pointer);
    }

    private static native void nglVertexAttrib2sARB(int var0, short var1, short var2, long var3);

    public static void glVertexAttrib2fARB(int index, float x2, float y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttrib2fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglVertexAttrib2fARB(index, x2, y2, function_pointer);
    }

    private static native void nglVertexAttrib2fARB(int var0, float var1, float var2, long var3);

    public static void glVertexAttrib2dARB(int index, double x2, double y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttrib2dARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglVertexAttrib2dARB(index, x2, y2, function_pointer);
    }

    private static native void nglVertexAttrib2dARB(int var0, double var1, double var3, long var5);

    public static void glVertexAttrib3sARB(int index, short x2, short y2, short z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttrib3sARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglVertexAttrib3sARB(index, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexAttrib3sARB(int var0, short var1, short var2, short var3, long var4);

    public static void glVertexAttrib3fARB(int index, float x2, float y2, float z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttrib3fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglVertexAttrib3fARB(index, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexAttrib3fARB(int var0, float var1, float var2, float var3, long var4);

    public static void glVertexAttrib3dARB(int index, double x2, double y2, double z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttrib3dARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglVertexAttrib3dARB(index, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexAttrib3dARB(int var0, double var1, double var3, double var5, long var7);

    public static void glVertexAttrib4sARB(int index, short x2, short y2, short z2, short w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttrib4sARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglVertexAttrib4sARB(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttrib4sARB(int var0, short var1, short var2, short var3, short var4, long var5);

    public static void glVertexAttrib4fARB(int index, float x2, float y2, float z2, float w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttrib4fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglVertexAttrib4fARB(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttrib4fARB(int var0, float var1, float var2, float var3, float var4, long var5);

    public static void glVertexAttrib4dARB(int index, double x2, double y2, double z2, double w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttrib4dARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglVertexAttrib4dARB(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttrib4dARB(int var0, double var1, double var3, double var5, double var7, long var9);

    public static void glVertexAttrib4NubARB(int index, byte x2, byte y2, byte z2, byte w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttrib4NubARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglVertexAttrib4NubARB(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttrib4NubARB(int var0, byte var1, byte var2, byte var3, byte var4, long var5);

    public static void glVertexAttribPointerARB(int index, int size, boolean normalized, int stride, DoubleBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttribPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        ARBVertexProgram.nglVertexAttribPointerARB(index, size, 5130, normalized, stride, buffer, buffer.position() << 3, function_pointer);
    }

    public static void glVertexAttribPointerARB(int index, int size, boolean normalized, int stride, FloatBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttribPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        ARBVertexProgram.nglVertexAttribPointerARB(index, size, 5126, normalized, stride, buffer, buffer.position() << 2, function_pointer);
    }

    public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, ByteBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttribPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        ARBVertexProgram.nglVertexAttribPointerARB(index, size, unsigned ? 5121 : 5120, normalized, stride, buffer, buffer.position(), function_pointer);
    }

    public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, IntBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttribPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        ARBVertexProgram.nglVertexAttribPointerARB(index, size, unsigned ? 5125 : 5124, normalized, stride, buffer, buffer.position() << 2, function_pointer);
    }

    public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, ShortBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttribPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        ARBVertexProgram.nglVertexAttribPointerARB(index, size, unsigned ? 5123 : 5122, normalized, stride, buffer, buffer.position() << 1, function_pointer);
    }

    private static native void nglVertexAttribPointerARB(int var0, int var1, int var2, boolean var3, int var4, Buffer var5, int var6, long var7);

    public static void glVertexAttribPointerARB(int index, int size, int type, boolean normalized, int stride, long buffer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glVertexAttribPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        ARBVertexProgram.nglVertexAttribPointerARBBO(index, size, type, normalized, stride, buffer_buffer_offset, function_pointer);
    }

    private static native void nglVertexAttribPointerARBBO(int var0, int var1, int var2, boolean var3, int var4, long var5, long var7);

    public static void glEnableVertexAttribArrayARB(int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glEnableVertexAttribArrayARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglEnableVertexAttribArrayARB(index, function_pointer);
    }

    private static native void nglEnableVertexAttribArrayARB(int var0, long var1);

    public static void glDisableVertexAttribArrayARB(int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glDisableVertexAttribArrayARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexProgram.nglDisableVertexAttribArrayARB(index, function_pointer);
    }

    private static native void nglDisableVertexAttribArrayARB(int var0, long var1);

    public static void glGetVertexAttribARB(int index, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glGetVertexAttribfvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBVertexProgram.nglGetVertexAttribfvARB(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribfvARB(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glGetVertexAttribARB(int index, int pname, DoubleBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glGetVertexAttribdvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBVertexProgram.nglGetVertexAttribdvARB(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribdvARB(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glGetVertexAttribARB(int index, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glGetVertexAttribivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBVertexProgram.nglGetVertexAttribivARB(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribivARB(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static ByteBuffer glGetVertexAttribPointerARB(int index, int pname, long result_size) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_program_glGetVertexAttribPointervARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ByteBuffer __result = ARBVertexProgram.nglGetVertexAttribPointervARB(index, pname, result_size, function_pointer);
        return __result;
    }

    private static native ByteBuffer nglGetVertexAttribPointervARB(int var0, int var1, long var2, long var4);
}

