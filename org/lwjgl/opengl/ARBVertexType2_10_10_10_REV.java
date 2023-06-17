/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBVertexType2_10_10_10_REV {
    public static final int GL_UNSIGNED_INT_2_10_10_10_REV = 33640;
    public static final int GL_INT_2_10_10_10_REV = 36255;

    private ARBVertexType2_10_10_10_REV() {
    }

    public static void glVertexP2ui(int type, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glVertexP2ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglVertexP2ui(type, value, function_pointer);
    }

    private static native void nglVertexP2ui(int var0, int var1, long var2);

    public static void glVertexP3ui(int type, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glVertexP3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglVertexP3ui(type, value, function_pointer);
    }

    private static native void nglVertexP3ui(int var0, int var1, long var2);

    public static void glVertexP4ui(int type, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glVertexP4ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglVertexP4ui(type, value, function_pointer);
    }

    private static native void nglVertexP4ui(int var0, int var1, long var2);

    public static void glVertexP2u(int type, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glVertexP2uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 2);
        ARBVertexType2_10_10_10_REV.nglVertexP2uiv(type, value, value.position(), function_pointer);
    }

    private static native void nglVertexP2uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexP3u(int type, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glVertexP3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 3);
        ARBVertexType2_10_10_10_REV.nglVertexP3uiv(type, value, value.position(), function_pointer);
    }

    private static native void nglVertexP3uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexP4u(int type, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glVertexP4uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 4);
        ARBVertexType2_10_10_10_REV.nglVertexP4uiv(type, value, value.position(), function_pointer);
    }

    private static native void nglVertexP4uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glTexCoordP1ui(int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glTexCoordP1ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglTexCoordP1ui(type, coords, function_pointer);
    }

    private static native void nglTexCoordP1ui(int var0, int var1, long var2);

    public static void glTexCoordP2ui(int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glTexCoordP2ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglTexCoordP2ui(type, coords, function_pointer);
    }

    private static native void nglTexCoordP2ui(int var0, int var1, long var2);

    public static void glTexCoordP3ui(int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glTexCoordP3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglTexCoordP3ui(type, coords, function_pointer);
    }

    private static native void nglTexCoordP3ui(int var0, int var1, long var2);

    public static void glTexCoordP4ui(int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glTexCoordP4ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglTexCoordP4ui(type, coords, function_pointer);
    }

    private static native void nglTexCoordP4ui(int var0, int var1, long var2);

    public static void glTexCoordP1u(int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glTexCoordP1uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 1);
        ARBVertexType2_10_10_10_REV.nglTexCoordP1uiv(type, coords, coords.position(), function_pointer);
    }

    private static native void nglTexCoordP1uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glTexCoordP2u(int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glTexCoordP2uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 2);
        ARBVertexType2_10_10_10_REV.nglTexCoordP2uiv(type, coords, coords.position(), function_pointer);
    }

    private static native void nglTexCoordP2uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glTexCoordP3u(int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glTexCoordP3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 3);
        ARBVertexType2_10_10_10_REV.nglTexCoordP3uiv(type, coords, coords.position(), function_pointer);
    }

    private static native void nglTexCoordP3uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glTexCoordP4u(int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glTexCoordP4uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 4);
        ARBVertexType2_10_10_10_REV.nglTexCoordP4uiv(type, coords, coords.position(), function_pointer);
    }

    private static native void nglTexCoordP4uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glMultiTexCoordP1ui(int texture, int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP1ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglMultiTexCoordP1ui(texture, type, coords, function_pointer);
    }

    private static native void nglMultiTexCoordP1ui(int var0, int var1, int var2, long var3);

    public static void glMultiTexCoordP2ui(int texture, int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP2ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglMultiTexCoordP2ui(texture, type, coords, function_pointer);
    }

    private static native void nglMultiTexCoordP2ui(int var0, int var1, int var2, long var3);

    public static void glMultiTexCoordP3ui(int texture, int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglMultiTexCoordP3ui(texture, type, coords, function_pointer);
    }

    private static native void nglMultiTexCoordP3ui(int var0, int var1, int var2, long var3);

    public static void glMultiTexCoordP4ui(int texture, int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP4ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglMultiTexCoordP4ui(texture, type, coords, function_pointer);
    }

    private static native void nglMultiTexCoordP4ui(int var0, int var1, int var2, long var3);

    public static void glMultiTexCoordP1u(int texture, int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP1uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 1);
        ARBVertexType2_10_10_10_REV.nglMultiTexCoordP1uiv(texture, type, coords, coords.position(), function_pointer);
    }

    private static native void nglMultiTexCoordP1uiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glMultiTexCoordP2u(int texture, int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP2uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 2);
        ARBVertexType2_10_10_10_REV.nglMultiTexCoordP2uiv(texture, type, coords, coords.position(), function_pointer);
    }

    private static native void nglMultiTexCoordP2uiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glMultiTexCoordP3u(int texture, int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 3);
        ARBVertexType2_10_10_10_REV.nglMultiTexCoordP3uiv(texture, type, coords, coords.position(), function_pointer);
    }

    private static native void nglMultiTexCoordP3uiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glMultiTexCoordP4u(int texture, int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glMultiTexCoordP4uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 4);
        ARBVertexType2_10_10_10_REV.nglMultiTexCoordP4uiv(texture, type, coords, coords.position(), function_pointer);
    }

    private static native void nglMultiTexCoordP4uiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glNormalP3ui(int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glNormalP3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglNormalP3ui(type, coords, function_pointer);
    }

    private static native void nglNormalP3ui(int var0, int var1, long var2);

    public static void glNormalP3u(int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glNormalP3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 3);
        ARBVertexType2_10_10_10_REV.nglNormalP3uiv(type, coords, coords.position(), function_pointer);
    }

    private static native void nglNormalP3uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glColorP3ui(int type, int color) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glColorP3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglColorP3ui(type, color, function_pointer);
    }

    private static native void nglColorP3ui(int var0, int var1, long var2);

    public static void glColorP4ui(int type, int color) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glColorP4ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglColorP4ui(type, color, function_pointer);
    }

    private static native void nglColorP4ui(int var0, int var1, long var2);

    public static void glColorP3u(int type, IntBuffer color) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glColorP3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(color, 3);
        ARBVertexType2_10_10_10_REV.nglColorP3uiv(type, color, color.position(), function_pointer);
    }

    private static native void nglColorP3uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glColorP4u(int type, IntBuffer color) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glColorP4uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(color, 4);
        ARBVertexType2_10_10_10_REV.nglColorP4uiv(type, color, color.position(), function_pointer);
    }

    private static native void nglColorP4uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glSecondaryColorP3ui(int type, int color) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glSecondaryColorP3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglSecondaryColorP3ui(type, color, function_pointer);
    }

    private static native void nglSecondaryColorP3ui(int var0, int var1, long var2);

    public static void glSecondaryColorP3u(int type, IntBuffer color) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glSecondaryColorP3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(color, 3);
        ARBVertexType2_10_10_10_REV.nglSecondaryColorP3uiv(type, color, color.position(), function_pointer);
    }

    private static native void nglSecondaryColorP3uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribP1ui(int index, int type, boolean normalized, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP1ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglVertexAttribP1ui(index, type, normalized, value, function_pointer);
    }

    private static native void nglVertexAttribP1ui(int var0, int var1, boolean var2, int var3, long var4);

    public static void glVertexAttribP2ui(int index, int type, boolean normalized, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP2ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglVertexAttribP2ui(index, type, normalized, value, function_pointer);
    }

    private static native void nglVertexAttribP2ui(int var0, int var1, boolean var2, int var3, long var4);

    public static void glVertexAttribP3ui(int index, int type, boolean normalized, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglVertexAttribP3ui(index, type, normalized, value, function_pointer);
    }

    private static native void nglVertexAttribP3ui(int var0, int var1, boolean var2, int var3, long var4);

    public static void glVertexAttribP4ui(int index, int type, boolean normalized, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP4ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexType2_10_10_10_REV.nglVertexAttribP4ui(index, type, normalized, value, function_pointer);
    }

    private static native void nglVertexAttribP4ui(int var0, int var1, boolean var2, int var3, long var4);

    public static void glVertexAttribP1u(int index, int type, boolean normalized, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP1uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 1);
        ARBVertexType2_10_10_10_REV.nglVertexAttribP1uiv(index, type, normalized, value, value.position(), function_pointer);
    }

    private static native void nglVertexAttribP1uiv(int var0, int var1, boolean var2, IntBuffer var3, int var4, long var5);

    public static void glVertexAttribP2u(int index, int type, boolean normalized, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP2uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 2);
        ARBVertexType2_10_10_10_REV.nglVertexAttribP2uiv(index, type, normalized, value, value.position(), function_pointer);
    }

    private static native void nglVertexAttribP2uiv(int var0, int var1, boolean var2, IntBuffer var3, int var4, long var5);

    public static void glVertexAttribP3u(int index, int type, boolean normalized, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 3);
        ARBVertexType2_10_10_10_REV.nglVertexAttribP3uiv(index, type, normalized, value, value.position(), function_pointer);
    }

    private static native void nglVertexAttribP3uiv(int var0, int var1, boolean var2, IntBuffer var3, int var4, long var5);

    public static void glVertexAttribP4u(int index, int type, boolean normalized, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_type_2_10_10_10_rev_glVertexAttribP4uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 4);
        ARBVertexType2_10_10_10_REV.nglVertexAttribP4uiv(index, type, normalized, value, value.position(), function_pointer);
    }

    private static native void nglVertexAttribP4uiv(int var0, int var1, boolean var2, IntBuffer var3, int var4, long var5);
}

