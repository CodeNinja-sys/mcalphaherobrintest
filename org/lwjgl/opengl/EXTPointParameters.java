/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class EXTPointParameters {
    public static final int GL_POINT_SIZE_MIN_EXT = 33062;
    public static final int GL_POINT_SIZE_MAX_EXT = 33063;
    public static final int GL_POINT_FADE_THRESHOLD_SIZE_EXT = 33064;
    public static final int GL_DISTANCE_ATTENUATION_EXT = 33065;

    private EXTPointParameters() {
    }

    public static void glPointParameterfEXT(int pname, float param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_point_parameters_glPointParameterfEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTPointParameters.nglPointParameterfEXT(pname, param, function_pointer);
    }

    private static native void nglPointParameterfEXT(int var0, float var1, long var2);

    public static void glPointParameterEXT(int pname, FloatBuffer pfParams) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_point_parameters_glPointParameterfvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(pfParams, 4);
        EXTPointParameters.nglPointParameterfvEXT(pname, pfParams, pfParams.position(), function_pointer);
    }

    private static native void nglPointParameterfvEXT(int var0, FloatBuffer var1, int var2, long var3);
}

