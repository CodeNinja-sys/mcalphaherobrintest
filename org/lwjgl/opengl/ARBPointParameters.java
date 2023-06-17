/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBPointParameters {
    public static final int GL_POINT_SIZE_MIN_ARB = 33062;
    public static final int GL_POINT_SIZE_MAX_ARB = 33063;
    public static final int GL_POINT_FADE_THRESHOLD_SIZE_ARB = 33064;
    public static final int GL_POINT_DISTANCE_ATTENUATION_ARB = 33065;

    private ARBPointParameters() {
    }

    public static void glPointParameterfARB(int pname, float param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_point_parameters_glPointParameterfARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBPointParameters.nglPointParameterfARB(pname, param, function_pointer);
    }

    private static native void nglPointParameterfARB(int var0, float var1, long var2);

    public static void glPointParameterARB(int pname, FloatBuffer pfParams) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_point_parameters_glPointParameterfvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(pfParams, 4);
        ARBPointParameters.nglPointParameterfvARB(pname, pfParams, pfParams.position(), function_pointer);
    }

    private static native void nglPointParameterfvARB(int var0, FloatBuffer var1, int var2, long var3);
}

