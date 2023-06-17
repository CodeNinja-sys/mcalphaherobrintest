/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class APPLEVertexProgramEvaluators {
    public static final int GL_VERTEX_ATTRIB_MAP1_APPLE = 35328;
    public static final int GL_VERTEX_ATTRIB_MAP2_APPLE = 35329;
    public static final int GL_VERTEX_ATTRIB_MAP1_SIZE_APPLE = 35330;
    public static final int GL_VERTEX_ATTRIB_MAP1_COEFF_APPLE = 35331;
    public static final int GL_VERTEX_ATTRIB_MAP1_ORDER_APPLE = 35332;
    public static final int GL_VERTEX_ATTRIB_MAP1_DOMAIN_APPLE = 35333;
    public static final int GL_VERTEX_ATTRIB_MAP2_SIZE_APPLE = 35334;
    public static final int GL_VERTEX_ATTRIB_MAP2_COEFF_APPLE = 35335;
    public static final int GL_VERTEX_ATTRIB_MAP2_ORDER_APPLE = 35336;
    public static final int GL_VERTEX_ATTRIB_MAP2_DOMAIN_APPLE = 35337;

    private APPLEVertexProgramEvaluators() {
    }

    public static void glEnableVertexAttribAPPLE(int index, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_vertex_program_evaluators_glEnableVertexAttribAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        APPLEVertexProgramEvaluators.nglEnableVertexAttribAPPLE(index, pname, function_pointer);
    }

    private static native void nglEnableVertexAttribAPPLE(int var0, int var1, long var2);

    public static void glDisableVertexAttribAPPLE(int index, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_vertex_program_evaluators_glDisableVertexAttribAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        APPLEVertexProgramEvaluators.nglDisableVertexAttribAPPLE(index, pname, function_pointer);
    }

    private static native void nglDisableVertexAttribAPPLE(int var0, int var1, long var2);

    public static boolean glIsVertexAttribEnabledAPPLE(int index, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_vertex_program_evaluators_glIsVertexAttribEnabledAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = APPLEVertexProgramEvaluators.nglIsVertexAttribEnabledAPPLE(index, pname, function_pointer);
        return __result;
    }

    private static native boolean nglIsVertexAttribEnabledAPPLE(int var0, int var1, long var2);

    public static void glMapVertexAttrib1dAPPLE(int index, int size, double u1, double u2, int stride, int order, DoubleBuffer points) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_vertex_program_evaluators_glMapVertexAttrib1dAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(points);
        APPLEVertexProgramEvaluators.nglMapVertexAttrib1dAPPLE(index, size, u1, u2, stride, order, points, points.position(), function_pointer);
    }

    private static native void nglMapVertexAttrib1dAPPLE(int var0, int var1, double var2, double var4, int var6, int var7, DoubleBuffer var8, int var9, long var10);

    public static void glMapVertexAttrib1fAPPLE(int index, int size, float u1, float u2, int stride, int order, FloatBuffer points) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_vertex_program_evaluators_glMapVertexAttrib1fAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(points);
        APPLEVertexProgramEvaluators.nglMapVertexAttrib1fAPPLE(index, size, u1, u2, stride, order, points, points.position(), function_pointer);
    }

    private static native void nglMapVertexAttrib1fAPPLE(int var0, int var1, float var2, float var3, int var4, int var5, FloatBuffer var6, int var7, long var8);

    public static void glMapVertexAttrib2dAPPLE(int index, int size, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, DoubleBuffer points) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_vertex_program_evaluators_glMapVertexAttrib2dAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(points);
        APPLEVertexProgramEvaluators.nglMapVertexAttrib2dAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, points.position(), function_pointer);
    }

    private static native void nglMapVertexAttrib2dAPPLE(int var0, int var1, double var2, double var4, int var6, int var7, double var8, double var10, int var12, int var13, DoubleBuffer var14, int var15, long var16);

    public static void glMapVertexAttrib2fAPPLE(int index, int size, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, FloatBuffer points) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_vertex_program_evaluators_glMapVertexAttrib2fAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(points);
        APPLEVertexProgramEvaluators.nglMapVertexAttrib2fAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points, points.position(), function_pointer);
    }

    private static native void nglMapVertexAttrib2fAPPLE(int var0, int var1, float var2, float var3, int var4, int var5, float var6, float var7, int var8, int var9, FloatBuffer var10, int var11, long var12);
}

