/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class GL33 {
    public static final int GL_SRC1_COLOR = 35065;
    public static final int GL_SRC1_ALPHA = 34185;
    public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
    public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067;
    public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068;
    public static final int GL_ANY_SAMPLES_PASSED = 35887;
    public static final int GL_SAMPLER_BINDING = 35097;
    public static final int GL_RGB10_A2UI = 36975;
    public static final int GL_TEXTURE_SWIZZLE_R = 36418;
    public static final int GL_TEXTURE_SWIZZLE_G = 36419;
    public static final int GL_TEXTURE_SWIZZLE_B = 36420;
    public static final int GL_TEXTURE_SWIZZLE_A = 36421;
    public static final int GL_TEXTURE_SWIZZLE_RGBA = 36422;
    public static final int GL_TIME_ELAPSED = 35007;
    public static final int GL_TIMESTAMP = 36392;
    public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR = 35070;
    public static final int GL_INT_2_10_10_10_REV = 36255;

    private GL33() {
    }

    public static void glBindFragDataLocationIndexed(int program, int colorNumber, int index, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glBindFragDataLocationIndexed_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        GL33.nglBindFragDataLocationIndexed(program, colorNumber, index, name, name.position(), function_pointer);
    }

    private static native void nglBindFragDataLocationIndexed(int var0, int var1, int var2, ByteBuffer var3, int var4, long var5);

    public static void glBindFragDataLocationIndexed(int program, int colorNumber, int index, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glBindFragDataLocationIndexed_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglBindFragDataLocationIndexed(program, colorNumber, index, APIUtils.getBufferNT(name), 0, function_pointer);
    }

    public static int glGetFragDataIndex(int program, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGetFragDataIndex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        int __result = GL33.nglGetFragDataIndex(program, name, name.position(), function_pointer);
        return __result;
    }

    private static native int nglGetFragDataIndex(int var0, ByteBuffer var1, int var2, long var3);

    public static int glGetFragDataIndex(int program, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGetFragDataIndex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = GL33.nglGetFragDataIndex(program, APIUtils.getBufferNT(name), 0, function_pointer);
        return __result;
    }

    public static void glGenSamplers(IntBuffer samplers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGenSamplers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(samplers);
        GL33.nglGenSamplers(samplers.remaining(), samplers, samplers.position(), function_pointer);
    }

    private static native void nglGenSamplers(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenSamplers() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGenSamplers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer samplers = APIUtils.getBufferInt();
        GL33.nglGenSamplers(1, samplers, samplers.position(), function_pointer);
        return samplers.get(0);
    }

    public static void glDeleteSamplers(IntBuffer samplers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glDeleteSamplers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(samplers);
        GL33.nglDeleteSamplers(samplers.remaining(), samplers, samplers.position(), function_pointer);
    }

    private static native void nglDeleteSamplers(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteSamplers(int sampler) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glDeleteSamplers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglDeleteSamplers(1, APIUtils.getBufferInt().put(0, sampler), 0, function_pointer);
    }

    public static boolean glIsSampler(int sampler) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glIsSampler_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = GL33.nglIsSampler(sampler, function_pointer);
        return __result;
    }

    private static native boolean nglIsSampler(int var0, long var1);

    public static void glBindSampler(int unit, int sampler) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glBindSampler_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglBindSampler(unit, sampler, function_pointer);
    }

    private static native void nglBindSampler(int var0, int var1, long var2);

    public static void glSamplerParameteri(int sampler, int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glSamplerParameteri_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglSamplerParameteri(sampler, pname, param, function_pointer);
    }

    private static native void nglSamplerParameteri(int var0, int var1, int var2, long var3);

    public static void glSamplerParameterf(int sampler, int pname, float param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glSamplerParameterf_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglSamplerParameterf(sampler, pname, param, function_pointer);
    }

    private static native void nglSamplerParameterf(int var0, int var1, float var2, long var3);

    public static void glSamplerParameter(int sampler, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glSamplerParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL33.nglSamplerParameteriv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglSamplerParameteriv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glSamplerParameter(int sampler, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glSamplerParameterfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL33.nglSamplerParameterfv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglSamplerParameterfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glSamplerParameterI(int sampler, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glSamplerParameterIiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL33.nglSamplerParameterIiv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglSamplerParameterIiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glSamplerParameterIu(int sampler, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glSamplerParameterIuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL33.nglSamplerParameterIuiv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglSamplerParameterIuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetSamplerParameter(int sampler, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGetSamplerParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL33.nglGetSamplerParameteriv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetSamplerParameteriv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetSamplerParameteri(int sampler, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGetSamplerParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL33.nglGetSamplerParameteriv(sampler, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetSamplerParameter(int sampler, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGetSamplerParameterfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL33.nglGetSamplerParameterfv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetSamplerParameterfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static float glGetSamplerParameterf(int sampler, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGetSamplerParameterfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        FloatBuffer params = APIUtils.getBufferFloat();
        GL33.nglGetSamplerParameterfv(sampler, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetSamplerParameterI(int sampler, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGetSamplerParameterIiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL33.nglGetSamplerParameterIiv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetSamplerParameterIiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetSamplerParameterIi(int sampler, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGetSamplerParameterIiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL33.nglGetSamplerParameterIiv(sampler, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetSamplerParameterIu(int sampler, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGetSamplerParameterIuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL33.nglGetSamplerParameterIuiv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetSamplerParameterIuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetSamplerParameterIui(int sampler, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGetSamplerParameterIuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL33.nglGetSamplerParameterIuiv(sampler, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glQueryCounter(int id2, int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glQueryCounter_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglQueryCounter(id2, target, function_pointer);
    }

    private static native void nglQueryCounter(int var0, int var1, long var2);

    public static void glGetQueryObject(int id2, int pname, LongBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGetQueryObjecti64v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        GL33.nglGetQueryObjecti64v(id2, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetQueryObjecti64v(int var0, int var1, LongBuffer var2, int var3, long var4);

    public static long glGetQueryObject(int id2, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGetQueryObjecti64v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        LongBuffer params = APIUtils.getBufferLong();
        GL33.nglGetQueryObjecti64v(id2, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetQueryObjectu(int id2, int pname, LongBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGetQueryObjectui64v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        GL33.nglGetQueryObjectui64v(id2, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetQueryObjectui64v(int var0, int var1, LongBuffer var2, int var3, long var4);

    public static long glGetQueryObjectu(int id2, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glGetQueryObjectui64v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        LongBuffer params = APIUtils.getBufferLong();
        GL33.nglGetQueryObjectui64v(id2, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glVertexAttribDivisor(int index, int divisor) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexAttribDivisor_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglVertexAttribDivisor(index, divisor, function_pointer);
    }

    private static native void nglVertexAttribDivisor(int var0, int var1, long var2);

    public static void glVertexP2ui(int type, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexP2ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglVertexP2ui(type, value, function_pointer);
    }

    private static native void nglVertexP2ui(int var0, int var1, long var2);

    public static void glVertexP3ui(int type, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexP3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglVertexP3ui(type, value, function_pointer);
    }

    private static native void nglVertexP3ui(int var0, int var1, long var2);

    public static void glVertexP4ui(int type, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexP4ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglVertexP4ui(type, value, function_pointer);
    }

    private static native void nglVertexP4ui(int var0, int var1, long var2);

    public static void glVertexP2u(int type, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexP2uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 2);
        GL33.nglVertexP2uiv(type, value, value.position(), function_pointer);
    }

    private static native void nglVertexP2uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexP3u(int type, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexP3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 3);
        GL33.nglVertexP3uiv(type, value, value.position(), function_pointer);
    }

    private static native void nglVertexP3uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexP4u(int type, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexP4uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 4);
        GL33.nglVertexP4uiv(type, value, value.position(), function_pointer);
    }

    private static native void nglVertexP4uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glTexCoordP1ui(int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glTexCoordP1ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglTexCoordP1ui(type, coords, function_pointer);
    }

    private static native void nglTexCoordP1ui(int var0, int var1, long var2);

    public static void glTexCoordP2ui(int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glTexCoordP2ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglTexCoordP2ui(type, coords, function_pointer);
    }

    private static native void nglTexCoordP2ui(int var0, int var1, long var2);

    public static void glTexCoordP3ui(int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glTexCoordP3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglTexCoordP3ui(type, coords, function_pointer);
    }

    private static native void nglTexCoordP3ui(int var0, int var1, long var2);

    public static void glTexCoordP4ui(int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glTexCoordP4ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglTexCoordP4ui(type, coords, function_pointer);
    }

    private static native void nglTexCoordP4ui(int var0, int var1, long var2);

    public static void glTexCoordP1u(int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glTexCoordP1uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 1);
        GL33.nglTexCoordP1uiv(type, coords, coords.position(), function_pointer);
    }

    private static native void nglTexCoordP1uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glTexCoordP2u(int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glTexCoordP2uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 2);
        GL33.nglTexCoordP2uiv(type, coords, coords.position(), function_pointer);
    }

    private static native void nglTexCoordP2uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glTexCoordP3u(int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glTexCoordP3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 3);
        GL33.nglTexCoordP3uiv(type, coords, coords.position(), function_pointer);
    }

    private static native void nglTexCoordP3uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glTexCoordP4u(int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glTexCoordP4uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 4);
        GL33.nglTexCoordP4uiv(type, coords, coords.position(), function_pointer);
    }

    private static native void nglTexCoordP4uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glMultiTexCoordP1ui(int texture, int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glMultiTexCoordP1ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglMultiTexCoordP1ui(texture, type, coords, function_pointer);
    }

    private static native void nglMultiTexCoordP1ui(int var0, int var1, int var2, long var3);

    public static void glMultiTexCoordP2ui(int texture, int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glMultiTexCoordP2ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglMultiTexCoordP2ui(texture, type, coords, function_pointer);
    }

    private static native void nglMultiTexCoordP2ui(int var0, int var1, int var2, long var3);

    public static void glMultiTexCoordP3ui(int texture, int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glMultiTexCoordP3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglMultiTexCoordP3ui(texture, type, coords, function_pointer);
    }

    private static native void nglMultiTexCoordP3ui(int var0, int var1, int var2, long var3);

    public static void glMultiTexCoordP4ui(int texture, int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glMultiTexCoordP4ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglMultiTexCoordP4ui(texture, type, coords, function_pointer);
    }

    private static native void nglMultiTexCoordP4ui(int var0, int var1, int var2, long var3);

    public static void glMultiTexCoordP1u(int texture, int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glMultiTexCoordP1uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 1);
        GL33.nglMultiTexCoordP1uiv(texture, type, coords, coords.position(), function_pointer);
    }

    private static native void nglMultiTexCoordP1uiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glMultiTexCoordP2u(int texture, int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glMultiTexCoordP2uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 2);
        GL33.nglMultiTexCoordP2uiv(texture, type, coords, coords.position(), function_pointer);
    }

    private static native void nglMultiTexCoordP2uiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glMultiTexCoordP3u(int texture, int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glMultiTexCoordP3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 3);
        GL33.nglMultiTexCoordP3uiv(texture, type, coords, coords.position(), function_pointer);
    }

    private static native void nglMultiTexCoordP3uiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glMultiTexCoordP4u(int texture, int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glMultiTexCoordP4uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 4);
        GL33.nglMultiTexCoordP4uiv(texture, type, coords, coords.position(), function_pointer);
    }

    private static native void nglMultiTexCoordP4uiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glNormalP3ui(int type, int coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glNormalP3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglNormalP3ui(type, coords, function_pointer);
    }

    private static native void nglNormalP3ui(int var0, int var1, long var2);

    public static void glNormalP3u(int type, IntBuffer coords) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glNormalP3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(coords, 3);
        GL33.nglNormalP3uiv(type, coords, coords.position(), function_pointer);
    }

    private static native void nglNormalP3uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glColorP3ui(int type, int color) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glColorP3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglColorP3ui(type, color, function_pointer);
    }

    private static native void nglColorP3ui(int var0, int var1, long var2);

    public static void glColorP4ui(int type, int color) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glColorP4ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglColorP4ui(type, color, function_pointer);
    }

    private static native void nglColorP4ui(int var0, int var1, long var2);

    public static void glColorP3u(int type, IntBuffer color) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glColorP3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(color, 3);
        GL33.nglColorP3uiv(type, color, color.position(), function_pointer);
    }

    private static native void nglColorP3uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glColorP4u(int type, IntBuffer color) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glColorP4uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(color, 4);
        GL33.nglColorP4uiv(type, color, color.position(), function_pointer);
    }

    private static native void nglColorP4uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glSecondaryColorP3ui(int type, int color) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glSecondaryColorP3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglSecondaryColorP3ui(type, color, function_pointer);
    }

    private static native void nglSecondaryColorP3ui(int var0, int var1, long var2);

    public static void glSecondaryColorP3u(int type, IntBuffer color) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glSecondaryColorP3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(color, 3);
        GL33.nglSecondaryColorP3uiv(type, color, color.position(), function_pointer);
    }

    private static native void nglSecondaryColorP3uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribP1ui(int index, int type, boolean normalized, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexAttribP1ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglVertexAttribP1ui(index, type, normalized, value, function_pointer);
    }

    private static native void nglVertexAttribP1ui(int var0, int var1, boolean var2, int var3, long var4);

    public static void glVertexAttribP2ui(int index, int type, boolean normalized, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexAttribP2ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglVertexAttribP2ui(index, type, normalized, value, function_pointer);
    }

    private static native void nglVertexAttribP2ui(int var0, int var1, boolean var2, int var3, long var4);

    public static void glVertexAttribP3ui(int index, int type, boolean normalized, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexAttribP3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglVertexAttribP3ui(index, type, normalized, value, function_pointer);
    }

    private static native void nglVertexAttribP3ui(int var0, int var1, boolean var2, int var3, long var4);

    public static void glVertexAttribP4ui(int index, int type, boolean normalized, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexAttribP4ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL33.nglVertexAttribP4ui(index, type, normalized, value, function_pointer);
    }

    private static native void nglVertexAttribP4ui(int var0, int var1, boolean var2, int var3, long var4);

    public static void glVertexAttribP1u(int index, int type, boolean normalized, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexAttribP1uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 1);
        GL33.nglVertexAttribP1uiv(index, type, normalized, value, value.position(), function_pointer);
    }

    private static native void nglVertexAttribP1uiv(int var0, int var1, boolean var2, IntBuffer var3, int var4, long var5);

    public static void glVertexAttribP2u(int index, int type, boolean normalized, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexAttribP2uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 2);
        GL33.nglVertexAttribP2uiv(index, type, normalized, value, value.position(), function_pointer);
    }

    private static native void nglVertexAttribP2uiv(int var0, int var1, boolean var2, IntBuffer var3, int var4, long var5);

    public static void glVertexAttribP3u(int index, int type, boolean normalized, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexAttribP3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 3);
        GL33.nglVertexAttribP3uiv(index, type, normalized, value, value.position(), function_pointer);
    }

    private static native void nglVertexAttribP3uiv(int var0, int var1, boolean var2, IntBuffer var3, int var4, long var5);

    public static void glVertexAttribP4u(int index, int type, boolean normalized, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL33_glVertexAttribP4uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 4);
        GL33.nglVertexAttribP4uiv(index, type, normalized, value, value.position(), function_pointer);
    }

    private static native void nglVertexAttribP4uiv(int var0, int var1, boolean var2, IntBuffer var3, int var4, long var5);
}

