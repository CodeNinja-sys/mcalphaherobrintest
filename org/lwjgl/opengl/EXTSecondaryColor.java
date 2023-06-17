/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;

public final class EXTSecondaryColor {
    public static final int GL_COLOR_SUM_EXT = 33880;
    public static final int GL_CURRENT_SECONDARY_COLOR_EXT = 33881;
    public static final int GL_SECONDARY_COLOR_ARRAY_SIZE_EXT = 33882;
    public static final int GL_SECONDARY_COLOR_ARRAY_TYPE_EXT = 33883;
    public static final int GL_SECONDARY_COLOR_ARRAY_STRIDE_EXT = 33884;
    public static final int GL_SECONDARY_COLOR_ARRAY_POINTER_EXT = 33885;
    public static final int GL_SECONDARY_COLOR_ARRAY_EXT = 33886;

    private EXTSecondaryColor() {
    }

    public static void glSecondaryColor3bEXT(byte red, byte green, byte blue) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_secondary_color_glSecondaryColor3bEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTSecondaryColor.nglSecondaryColor3bEXT(red, green, blue, function_pointer);
    }

    private static native void nglSecondaryColor3bEXT(byte var0, byte var1, byte var2, long var3);

    public static void glSecondaryColor3fEXT(float red, float green, float blue) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_secondary_color_glSecondaryColor3fEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTSecondaryColor.nglSecondaryColor3fEXT(red, green, blue, function_pointer);
    }

    private static native void nglSecondaryColor3fEXT(float var0, float var1, float var2, long var3);

    public static void glSecondaryColor3dEXT(double red, double green, double blue) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_secondary_color_glSecondaryColor3dEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTSecondaryColor.nglSecondaryColor3dEXT(red, green, blue, function_pointer);
    }

    private static native void nglSecondaryColor3dEXT(double var0, double var2, double var4, long var6);

    public static void glSecondaryColor3ubEXT(byte red, byte green, byte blue) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_secondary_color_glSecondaryColor3ubEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTSecondaryColor.nglSecondaryColor3ubEXT(red, green, blue, function_pointer);
    }

    private static native void nglSecondaryColor3ubEXT(byte var0, byte var1, byte var2, long var3);

    public static void glSecondaryColorPointerEXT(int size, int stride, DoubleBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_secondary_color_glSecondaryColorPointerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pPointer);
        GLChecks.getReferences((ContextCapabilities)caps).EXT_secondary_color_glSecondaryColorPointerEXT_pPointer = pPointer;
        EXTSecondaryColor.nglSecondaryColorPointerEXT(size, 5130, stride, pPointer, pPointer.position() << 3, function_pointer);
    }

    public static void glSecondaryColorPointerEXT(int size, int stride, FloatBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_secondary_color_glSecondaryColorPointerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pPointer);
        GLChecks.getReferences((ContextCapabilities)caps).EXT_secondary_color_glSecondaryColorPointerEXT_pPointer = pPointer;
        EXTSecondaryColor.nglSecondaryColorPointerEXT(size, 5126, stride, pPointer, pPointer.position() << 2, function_pointer);
    }

    public static void glSecondaryColorPointerEXT(int size, boolean unsigned, int stride, ByteBuffer pPointer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_secondary_color_glSecondaryColorPointerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(pPointer);
        GLChecks.getReferences((ContextCapabilities)caps).EXT_secondary_color_glSecondaryColorPointerEXT_pPointer = pPointer;
        EXTSecondaryColor.nglSecondaryColorPointerEXT(size, unsigned ? 5121 : 5120, stride, pPointer, pPointer.position(), function_pointer);
    }

    private static native void nglSecondaryColorPointerEXT(int var0, int var1, int var2, Buffer var3, int var4, long var5);

    public static void glSecondaryColorPointerEXT(int size, int type, int stride, long pPointer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_secondary_color_glSecondaryColorPointerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        EXTSecondaryColor.nglSecondaryColorPointerEXTBO(size, type, stride, pPointer_buffer_offset, function_pointer);
    }

    private static native void nglSecondaryColorPointerEXTBO(int var0, int var1, int var2, long var3, long var5);
}

