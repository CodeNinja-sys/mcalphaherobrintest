/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBSamplerObjects {
    public static final int GL_SAMPLER_BINDING = 35097;

    private ARBSamplerObjects() {
    }

    public static void glGenSamplers(IntBuffer samplers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glGenSamplers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(samplers);
        ARBSamplerObjects.nglGenSamplers(samplers.remaining(), samplers, samplers.position(), function_pointer);
    }

    private static native void nglGenSamplers(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenSamplers() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glGenSamplers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer samplers = APIUtils.getBufferInt();
        ARBSamplerObjects.nglGenSamplers(1, samplers, samplers.position(), function_pointer);
        return samplers.get(0);
    }

    public static void glDeleteSamplers(IntBuffer samplers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glDeleteSamplers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(samplers);
        ARBSamplerObjects.nglDeleteSamplers(samplers.remaining(), samplers, samplers.position(), function_pointer);
    }

    private static native void nglDeleteSamplers(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteSamplers(int sampler) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glDeleteSamplers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBSamplerObjects.nglDeleteSamplers(1, APIUtils.getBufferInt().put(0, sampler), 0, function_pointer);
    }

    public static boolean glIsSampler(int sampler) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glIsSampler_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = ARBSamplerObjects.nglIsSampler(sampler, function_pointer);
        return __result;
    }

    private static native boolean nglIsSampler(int var0, long var1);

    public static void glBindSampler(int unit, int sampler) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glBindSampler_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBSamplerObjects.nglBindSampler(unit, sampler, function_pointer);
    }

    private static native void nglBindSampler(int var0, int var1, long var2);

    public static void glSamplerParameteri(int sampler, int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glSamplerParameteri_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBSamplerObjects.nglSamplerParameteri(sampler, pname, param, function_pointer);
    }

    private static native void nglSamplerParameteri(int var0, int var1, int var2, long var3);

    public static void glSamplerParameterf(int sampler, int pname, float param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glSamplerParameterf_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBSamplerObjects.nglSamplerParameterf(sampler, pname, param, function_pointer);
    }

    private static native void nglSamplerParameterf(int var0, int var1, float var2, long var3);

    public static void glSamplerParameter(int sampler, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glSamplerParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBSamplerObjects.nglSamplerParameteriv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglSamplerParameteriv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glSamplerParameter(int sampler, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glSamplerParameterfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBSamplerObjects.nglSamplerParameterfv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglSamplerParameterfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glSamplerParameterI(int sampler, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glSamplerParameterIiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBSamplerObjects.nglSamplerParameterIiv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglSamplerParameterIiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glSamplerParameterIu(int sampler, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glSamplerParameterIuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBSamplerObjects.nglSamplerParameterIuiv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglSamplerParameterIuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetSamplerParameter(int sampler, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glGetSamplerParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBSamplerObjects.nglGetSamplerParameteriv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetSamplerParameteriv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetSamplerParameteri(int sampler, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glGetSamplerParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBSamplerObjects.nglGetSamplerParameteriv(sampler, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetSamplerParameter(int sampler, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glGetSamplerParameterfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBSamplerObjects.nglGetSamplerParameterfv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetSamplerParameterfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static float glGetSamplerParameterf(int sampler, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glGetSamplerParameterfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        FloatBuffer params = APIUtils.getBufferFloat();
        ARBSamplerObjects.nglGetSamplerParameterfv(sampler, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetSamplerParameterI(int sampler, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glGetSamplerParameterIiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBSamplerObjects.nglGetSamplerParameterIiv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetSamplerParameterIiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetSamplerParameterIi(int sampler, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glGetSamplerParameterIiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBSamplerObjects.nglGetSamplerParameterIiv(sampler, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetSamplerParameterIu(int sampler, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glGetSamplerParameterIuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBSamplerObjects.nglGetSamplerParameterIuiv(sampler, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetSamplerParameterIuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetSamplerParameterIui(int sampler, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sampler_objects_glGetSamplerParameterIuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBSamplerObjects.nglGetSamplerParameterIuiv(sampler, pname, params, params.position(), function_pointer);
        return params.get(0);
    }
}

