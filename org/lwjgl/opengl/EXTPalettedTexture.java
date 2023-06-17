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
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;

public final class EXTPalettedTexture {
    public static final int GL_COLOR_INDEX1_EXT = 32994;
    public static final int GL_COLOR_INDEX2_EXT = 32995;
    public static final int GL_COLOR_INDEX4_EXT = 32996;
    public static final int GL_COLOR_INDEX8_EXT = 32997;
    public static final int GL_COLOR_INDEX12_EXT = 32998;
    public static final int GL_COLOR_INDEX16_EXT = 32999;
    public static final int GL_COLOR_TABLE_FORMAT_EXT = 32984;
    public static final int GL_COLOR_TABLE_WIDTH_EXT = 32985;
    public static final int GL_COLOR_TABLE_RED_SIZE_EXT = 32986;
    public static final int GL_COLOR_TABLE_GREEN_SIZE_EXT = 32987;
    public static final int GL_COLOR_TABLE_BLUE_SIZE_EXT = 32988;
    public static final int GL_COLOR_TABLE_ALPHA_SIZE_EXT = 32989;
    public static final int GL_COLOR_TABLE_LUMINANCE_SIZE_EXT = 32990;
    public static final int GL_COLOR_TABLE_INTENSITY_SIZE_EXT = 32991;
    public static final int GL_TEXTURE_INDEX_SIZE_EXT = 33005;

    private EXTPalettedTexture() {
    }

    public static void glColorTableEXT(int target, int internalFormat, int width, int format, int type, ByteBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glColorTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, GLChecks.calculateImageStorage(data, format, type, width, 1, 1));
        EXTPalettedTexture.nglColorTableEXT(target, internalFormat, width, format, type, data, data.position(), function_pointer);
    }

    public static void glColorTableEXT(int target, int internalFormat, int width, int format, int type, DoubleBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glColorTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, GLChecks.calculateImageStorage(data, format, type, width, 1, 1));
        EXTPalettedTexture.nglColorTableEXT(target, internalFormat, width, format, type, data, data.position() << 3, function_pointer);
    }

    public static void glColorTableEXT(int target, int internalFormat, int width, int format, int type, FloatBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glColorTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, GLChecks.calculateImageStorage(data, format, type, width, 1, 1));
        EXTPalettedTexture.nglColorTableEXT(target, internalFormat, width, format, type, data, data.position() << 2, function_pointer);
    }

    public static void glColorTableEXT(int target, int internalFormat, int width, int format, int type, IntBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glColorTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, GLChecks.calculateImageStorage(data, format, type, width, 1, 1));
        EXTPalettedTexture.nglColorTableEXT(target, internalFormat, width, format, type, data, data.position() << 2, function_pointer);
    }

    public static void glColorTableEXT(int target, int internalFormat, int width, int format, int type, ShortBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glColorTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, GLChecks.calculateImageStorage(data, format, type, width, 1, 1));
        EXTPalettedTexture.nglColorTableEXT(target, internalFormat, width, format, type, data, data.position() << 1, function_pointer);
    }

    private static native void nglColorTableEXT(int var0, int var1, int var2, int var3, int var4, Buffer var5, int var6, long var7);

    public static void glColorSubTableEXT(int target, int start, int count, int format, int type, ByteBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glColorSubTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, GLChecks.calculateImageStorage(data, format, type, count, 1, 1));
        EXTPalettedTexture.nglColorSubTableEXT(target, start, count, format, type, data, data.position(), function_pointer);
    }

    public static void glColorSubTableEXT(int target, int start, int count, int format, int type, DoubleBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glColorSubTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, GLChecks.calculateImageStorage(data, format, type, count, 1, 1));
        EXTPalettedTexture.nglColorSubTableEXT(target, start, count, format, type, data, data.position() << 3, function_pointer);
    }

    public static void glColorSubTableEXT(int target, int start, int count, int format, int type, FloatBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glColorSubTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, GLChecks.calculateImageStorage(data, format, type, count, 1, 1));
        EXTPalettedTexture.nglColorSubTableEXT(target, start, count, format, type, data, data.position() << 2, function_pointer);
    }

    public static void glColorSubTableEXT(int target, int start, int count, int format, int type, IntBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glColorSubTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, GLChecks.calculateImageStorage(data, format, type, count, 1, 1));
        EXTPalettedTexture.nglColorSubTableEXT(target, start, count, format, type, data, data.position() << 2, function_pointer);
    }

    public static void glColorSubTableEXT(int target, int start, int count, int format, int type, ShortBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glColorSubTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, GLChecks.calculateImageStorage(data, format, type, count, 1, 1));
        EXTPalettedTexture.nglColorSubTableEXT(target, start, count, format, type, data, data.position() << 1, function_pointer);
    }

    private static native void nglColorSubTableEXT(int var0, int var1, int var2, int var3, int var4, Buffer var5, int var6, long var7);

    public static void glGetColorTableEXT(int target, int format, int type, ByteBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glGetColorTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        EXTPalettedTexture.nglGetColorTableEXT(target, format, type, data, data.position(), function_pointer);
    }

    public static void glGetColorTableEXT(int target, int format, int type, DoubleBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glGetColorTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        EXTPalettedTexture.nglGetColorTableEXT(target, format, type, data, data.position() << 3, function_pointer);
    }

    public static void glGetColorTableEXT(int target, int format, int type, FloatBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glGetColorTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        EXTPalettedTexture.nglGetColorTableEXT(target, format, type, data, data.position() << 2, function_pointer);
    }

    public static void glGetColorTableEXT(int target, int format, int type, IntBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glGetColorTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        EXTPalettedTexture.nglGetColorTableEXT(target, format, type, data, data.position() << 2, function_pointer);
    }

    public static void glGetColorTableEXT(int target, int format, int type, ShortBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glGetColorTableEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        EXTPalettedTexture.nglGetColorTableEXT(target, format, type, data, data.position() << 1, function_pointer);
    }

    private static native void nglGetColorTableEXT(int var0, int var1, int var2, Buffer var3, int var4, long var5);

    public static void glGetColorTableParameterEXT(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glGetColorTableParameterivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        EXTPalettedTexture.nglGetColorTableParameterivEXT(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetColorTableParameterivEXT(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetColorTableParameterEXT(int target, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_paletted_texture_glGetColorTableParameterfvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        EXTPalettedTexture.nglGetColorTableParameterfvEXT(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetColorTableParameterfvEXT(int var0, int var1, FloatBuffer var2, int var3, long var4);
}

