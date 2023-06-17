/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBMultitexture {
    public static final int GL_TEXTURE0_ARB = 33984;
    public static final int GL_TEXTURE1_ARB = 33985;
    public static final int GL_TEXTURE2_ARB = 33986;
    public static final int GL_TEXTURE3_ARB = 33987;
    public static final int GL_TEXTURE4_ARB = 33988;
    public static final int GL_TEXTURE5_ARB = 33989;
    public static final int GL_TEXTURE6_ARB = 33990;
    public static final int GL_TEXTURE7_ARB = 33991;
    public static final int GL_TEXTURE8_ARB = 33992;
    public static final int GL_TEXTURE9_ARB = 33993;
    public static final int GL_TEXTURE10_ARB = 33994;
    public static final int GL_TEXTURE11_ARB = 33995;
    public static final int GL_TEXTURE12_ARB = 33996;
    public static final int GL_TEXTURE13_ARB = 33997;
    public static final int GL_TEXTURE14_ARB = 33998;
    public static final int GL_TEXTURE15_ARB = 33999;
    public static final int GL_TEXTURE16_ARB = 34000;
    public static final int GL_TEXTURE17_ARB = 34001;
    public static final int GL_TEXTURE18_ARB = 34002;
    public static final int GL_TEXTURE19_ARB = 34003;
    public static final int GL_TEXTURE20_ARB = 34004;
    public static final int GL_TEXTURE21_ARB = 34005;
    public static final int GL_TEXTURE22_ARB = 34006;
    public static final int GL_TEXTURE23_ARB = 34007;
    public static final int GL_TEXTURE24_ARB = 34008;
    public static final int GL_TEXTURE25_ARB = 34009;
    public static final int GL_TEXTURE26_ARB = 34010;
    public static final int GL_TEXTURE27_ARB = 34011;
    public static final int GL_TEXTURE28_ARB = 34012;
    public static final int GL_TEXTURE29_ARB = 34013;
    public static final int GL_TEXTURE30_ARB = 34014;
    public static final int GL_TEXTURE31_ARB = 34015;
    public static final int GL_ACTIVE_TEXTURE_ARB = 34016;
    public static final int GL_CLIENT_ACTIVE_TEXTURE_ARB = 34017;
    public static final int GL_MAX_TEXTURE_UNITS_ARB = 34018;

    private ARBMultitexture() {
    }

    public static void glClientActiveTextureARB(int texture) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glClientActiveTextureARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglClientActiveTextureARB(texture, function_pointer);
    }

    private static native void nglClientActiveTextureARB(int var0, long var1);

    public static void glActiveTextureARB(int texture) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glActiveTextureARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglActiveTextureARB(texture, function_pointer);
    }

    private static native void nglActiveTextureARB(int var0, long var1);

    public static void glMultiTexCoord1fARB(int target, float s2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord1fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord1fARB(target, s2, function_pointer);
    }

    private static native void nglMultiTexCoord1fARB(int var0, float var1, long var2);

    public static void glMultiTexCoord1dARB(int target, double s2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord1dARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord1dARB(target, s2, function_pointer);
    }

    private static native void nglMultiTexCoord1dARB(int var0, double var1, long var3);

    public static void glMultiTexCoord1iARB(int target, int s2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord1iARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord1iARB(target, s2, function_pointer);
    }

    private static native void nglMultiTexCoord1iARB(int var0, int var1, long var2);

    public static void glMultiTexCoord1sARB(int target, short s2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord1sARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord1sARB(target, s2, function_pointer);
    }

    private static native void nglMultiTexCoord1sARB(int var0, short var1, long var2);

    public static void glMultiTexCoord2fARB(int target, float s2, float t2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord2fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord2fARB(target, s2, t2, function_pointer);
    }

    private static native void nglMultiTexCoord2fARB(int var0, float var1, float var2, long var3);

    public static void glMultiTexCoord2dARB(int target, double s2, double t2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord2dARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord2dARB(target, s2, t2, function_pointer);
    }

    private static native void nglMultiTexCoord2dARB(int var0, double var1, double var3, long var5);

    public static void glMultiTexCoord2iARB(int target, int s2, int t2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord2iARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord2iARB(target, s2, t2, function_pointer);
    }

    private static native void nglMultiTexCoord2iARB(int var0, int var1, int var2, long var3);

    public static void glMultiTexCoord2sARB(int target, short s2, short t2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord2sARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord2sARB(target, s2, t2, function_pointer);
    }

    private static native void nglMultiTexCoord2sARB(int var0, short var1, short var2, long var3);

    public static void glMultiTexCoord3fARB(int target, float s2, float t2, float r2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord3fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord3fARB(target, s2, t2, r2, function_pointer);
    }

    private static native void nglMultiTexCoord3fARB(int var0, float var1, float var2, float var3, long var4);

    public static void glMultiTexCoord3dARB(int target, double s2, double t2, double r2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord3dARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord3dARB(target, s2, t2, r2, function_pointer);
    }

    private static native void nglMultiTexCoord3dARB(int var0, double var1, double var3, double var5, long var7);

    public static void glMultiTexCoord3iARB(int target, int s2, int t2, int r2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord3iARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord3iARB(target, s2, t2, r2, function_pointer);
    }

    private static native void nglMultiTexCoord3iARB(int var0, int var1, int var2, int var3, long var4);

    public static void glMultiTexCoord3sARB(int target, short s2, short t2, short r2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord3sARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord3sARB(target, s2, t2, r2, function_pointer);
    }

    private static native void nglMultiTexCoord3sARB(int var0, short var1, short var2, short var3, long var4);

    public static void glMultiTexCoord4fARB(int target, float s2, float t2, float r2, float q2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord4fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord4fARB(target, s2, t2, r2, q2, function_pointer);
    }

    private static native void nglMultiTexCoord4fARB(int var0, float var1, float var2, float var3, float var4, long var5);

    public static void glMultiTexCoord4dARB(int target, double s2, double t2, double r2, double q2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord4dARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord4dARB(target, s2, t2, r2, q2, function_pointer);
    }

    private static native void nglMultiTexCoord4dARB(int var0, double var1, double var3, double var5, double var7, long var9);

    public static void glMultiTexCoord4iARB(int target, int s2, int t2, int r2, int q2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord4iARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord4iARB(target, s2, t2, r2, q2, function_pointer);
    }

    private static native void nglMultiTexCoord4iARB(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glMultiTexCoord4sARB(int target, short s2, short t2, short r2, short q2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_multitexture_glMultiTexCoord4sARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMultitexture.nglMultiTexCoord4sARB(target, s2, t2, r2, q2, function_pointer);
    }

    private static native void nglMultiTexCoord4sARB(int var0, short var1, short var2, short var3, short var4, long var5);
}
