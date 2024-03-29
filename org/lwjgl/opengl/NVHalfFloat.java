/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVHalfFloat {
    public static final int GL_HALF_FLOAT_NV = 5131;

    private NVHalfFloat() {
    }

    public static void glVertex2hNV(short x2, short y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glVertex2hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglVertex2hNV(x2, y2, function_pointer);
    }

    private static native void nglVertex2hNV(short var0, short var1, long var2);

    public static void glVertex3hNV(short x2, short y2, short z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glVertex3hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglVertex3hNV(x2, y2, z2, function_pointer);
    }

    private static native void nglVertex3hNV(short var0, short var1, short var2, long var3);

    public static void glVertex4hNV(short x2, short y2, short z2, short w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glVertex4hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglVertex4hNV(x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertex4hNV(short var0, short var1, short var2, short var3, long var4);

    public static void glNormal3hNV(short nx2, short ny2, short nz2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glNormal3hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglNormal3hNV(nx2, ny2, nz2, function_pointer);
    }

    private static native void nglNormal3hNV(short var0, short var1, short var2, long var3);

    public static void glColor3hNV(short red, short green, short blue) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glColor3hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglColor3hNV(red, green, blue, function_pointer);
    }

    private static native void nglColor3hNV(short var0, short var1, short var2, long var3);

    public static void glColor4hNV(short red, short green, short blue, short alpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glColor4hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglColor4hNV(red, green, blue, alpha, function_pointer);
    }

    private static native void nglColor4hNV(short var0, short var1, short var2, short var3, long var4);

    public static void glTexCoord1hNV(short s2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glTexCoord1hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglTexCoord1hNV(s2, function_pointer);
    }

    private static native void nglTexCoord1hNV(short var0, long var1);

    public static void glTexCoord2hNV(short s2, short t2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glTexCoord2hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglTexCoord2hNV(s2, t2, function_pointer);
    }

    private static native void nglTexCoord2hNV(short var0, short var1, long var2);

    public static void glTexCoord3hNV(short s2, short t2, short r2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glTexCoord3hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglTexCoord3hNV(s2, t2, r2, function_pointer);
    }

    private static native void nglTexCoord3hNV(short var0, short var1, short var2, long var3);

    public static void glTexCoord4hNV(short s2, short t2, short r2, short q2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glTexCoord4hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglTexCoord4hNV(s2, t2, r2, q2, function_pointer);
    }

    private static native void nglTexCoord4hNV(short var0, short var1, short var2, short var3, long var4);

    public static void glMultiTexCoord1hNV(int target, short s2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glMultiTexCoord1hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglMultiTexCoord1hNV(target, s2, function_pointer);
    }

    private static native void nglMultiTexCoord1hNV(int var0, short var1, long var2);

    public static void glMultiTexCoord2hNV(int target, short s2, short t2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glMultiTexCoord2hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglMultiTexCoord2hNV(target, s2, t2, function_pointer);
    }

    private static native void nglMultiTexCoord2hNV(int var0, short var1, short var2, long var3);

    public static void glMultiTexCoord3hNV(int target, short s2, short t2, short r2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glMultiTexCoord3hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglMultiTexCoord3hNV(target, s2, t2, r2, function_pointer);
    }

    private static native void nglMultiTexCoord3hNV(int var0, short var1, short var2, short var3, long var4);

    public static void glMultiTexCoord4hNV(int target, short s2, short t2, short r2, short q2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glMultiTexCoord4hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglMultiTexCoord4hNV(target, s2, t2, r2, q2, function_pointer);
    }

    private static native void nglMultiTexCoord4hNV(int var0, short var1, short var2, short var3, short var4, long var5);

    public static void glFogCoordhNV(short fog) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glFogCoordhNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglFogCoordhNV(fog, function_pointer);
    }

    private static native void nglFogCoordhNV(short var0, long var1);

    public static void glSecondaryColor3hNV(short red, short green, short blue) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glSecondaryColor3hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglSecondaryColor3hNV(red, green, blue, function_pointer);
    }

    private static native void nglSecondaryColor3hNV(short var0, short var1, short var2, long var3);

    public static void glVertexWeighthNV(short weight) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glVertexWeighthNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglVertexWeighthNV(weight, function_pointer);
    }

    private static native void nglVertexWeighthNV(short var0, long var1);

    public static void glVertexAttrib1hNV(int index, short x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glVertexAttrib1hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglVertexAttrib1hNV(index, x2, function_pointer);
    }

    private static native void nglVertexAttrib1hNV(int var0, short var1, long var2);

    public static void glVertexAttrib2hNV(int index, short x2, short y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glVertexAttrib2hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglVertexAttrib2hNV(index, x2, y2, function_pointer);
    }

    private static native void nglVertexAttrib2hNV(int var0, short var1, short var2, long var3);

    public static void glVertexAttrib3hNV(int index, short x2, short y2, short z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glVertexAttrib3hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglVertexAttrib3hNV(index, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexAttrib3hNV(int var0, short var1, short var2, short var3, long var4);

    public static void glVertexAttrib4hNV(int index, short x2, short y2, short z2, short w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glVertexAttrib4hNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVHalfFloat.nglVertexAttrib4hNV(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttrib4hNV(int var0, short var1, short var2, short var3, short var4, long var5);

    public static void glVertexAttribs1NV(int index, ShortBuffer attribs) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glVertexAttribs1hvNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(attribs);
        NVHalfFloat.nglVertexAttribs1hvNV(index, attribs.remaining(), attribs, attribs.position(), function_pointer);
    }

    private static native void nglVertexAttribs1hvNV(int var0, int var1, ShortBuffer var2, int var3, long var4);

    public static void glVertexAttribs2NV(int index, ShortBuffer attribs) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glVertexAttribs2hvNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(attribs);
        NVHalfFloat.nglVertexAttribs2hvNV(index, attribs.remaining() >> 1, attribs, attribs.position(), function_pointer);
    }

    private static native void nglVertexAttribs2hvNV(int var0, int var1, ShortBuffer var2, int var3, long var4);

    public static void glVertexAttribs3NV(int index, ShortBuffer attribs) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glVertexAttribs3hvNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(attribs);
        NVHalfFloat.nglVertexAttribs3hvNV(index, attribs.remaining() / 3, attribs, attribs.position(), function_pointer);
    }

    private static native void nglVertexAttribs3hvNV(int var0, int var1, ShortBuffer var2, int var3, long var4);

    public static void glVertexAttribs4NV(int index, ShortBuffer attribs) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_half_float_glVertexAttribs4hvNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(attribs);
        NVHalfFloat.nglVertexAttribs4hvNV(index, attribs.remaining() >> 2, attribs, attribs.position(), function_pointer);
    }

    private static native void nglVertexAttribs4hvNV(int var0, int var1, ShortBuffer var2, int var3, long var4);
}

