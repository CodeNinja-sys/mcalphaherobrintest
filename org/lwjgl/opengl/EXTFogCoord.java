/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;

public final class EXTFogCoord {
    public static final int GL_FOG_COORDINATE_SOURCE_EXT = 33872;
    public static final int GL_FOG_COORDINATE_EXT = 33873;
    public static final int GL_FRAGMENT_DEPTH_EXT = 33874;
    public static final int GL_CURRENT_FOG_COORDINATE_EXT = 33875;
    public static final int GL_FOG_COORDINATE_ARRAY_TYPE_EXT = 33876;
    public static final int GL_FOG_COORDINATE_ARRAY_STRIDE_EXT = 33877;
    public static final int GL_FOG_COORDINATE_ARRAY_POINTER_EXT = 33878;
    public static final int GL_FOG_COORDINATE_ARRAY_EXT = 33879;

    private EXTFogCoord() {
    }

    public static void glFogCoordfEXT(float coord) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_fog_coord_glFogCoordfEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTFogCoord.nglFogCoordfEXT(coord, function_pointer);
    }

    private static native void nglFogCoordfEXT(float var0, long var1);

    public static void glFogCoorddEXT(double coord) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_fog_coord_glFogCoorddEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTFogCoord.nglFogCoorddEXT(coord, function_pointer);
    }

    private static native void nglFogCoorddEXT(double var0, long var2);

    public static void glFogCoordPointerEXT(int stride, DoubleBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_fog_coord_glFogCoordPointerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(data);
        GLChecks.getReferences((ContextCapabilities)caps).EXT_fog_coord_glFogCoordPointerEXT_data = data;
        EXTFogCoord.nglFogCoordPointerEXT(5130, stride, data, data.position() << 3, function_pointer);
    }

    public static void glFogCoordPointerEXT(int stride, FloatBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_fog_coord_glFogCoordPointerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(data);
        GLChecks.getReferences((ContextCapabilities)caps).EXT_fog_coord_glFogCoordPointerEXT_data = data;
        EXTFogCoord.nglFogCoordPointerEXT(5126, stride, data, data.position() << 2, function_pointer);
    }

    private static native void nglFogCoordPointerEXT(int var0, int var1, Buffer var2, int var3, long var4);

    public static void glFogCoordPointerEXT(int type, int stride, long data_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_fog_coord_glFogCoordPointerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        EXTFogCoord.nglFogCoordPointerEXTBO(type, stride, data_buffer_offset, function_pointer);
    }

    private static native void nglFogCoordPointerEXTBO(int var0, int var1, long var2, long var4);
}

