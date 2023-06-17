/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBTransposeMatrix {
    public static final int GL_TRANSPOSE_MODELVIEW_MATRIX_ARB = 34019;
    public static final int GL_TRANSPOSE_PROJECTION_MATRIX_ARB = 34020;
    public static final int GL_TRANSPOSE_TEXTURE_MATRIX_ARB = 34021;
    public static final int GL_TRANSPOSE_COLOR_MATRIX_ARB = 34022;

    private ARBTransposeMatrix() {
    }

    public static void glLoadTransposeMatrixARB(FloatBuffer pfMtx) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transpose_matrix_glLoadTransposeMatrixfARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(pfMtx, 16);
        ARBTransposeMatrix.nglLoadTransposeMatrixfARB(pfMtx, pfMtx.position(), function_pointer);
    }

    private static native void nglLoadTransposeMatrixfARB(FloatBuffer var0, int var1, long var2);

    public static void glMultTransposeMatrixARB(FloatBuffer pfMtx) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transpose_matrix_glMultTransposeMatrixfARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(pfMtx, 16);
        ARBTransposeMatrix.nglMultTransposeMatrixfARB(pfMtx, pfMtx.position(), function_pointer);
    }

    private static native void nglMultTransposeMatrixfARB(FloatBuffer var0, int var1, long var2);
}

