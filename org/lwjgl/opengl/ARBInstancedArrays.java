/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBInstancedArrays {
    public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR_ARB = 35070;

    private ARBInstancedArrays() {
    }

    public static void glVertexAttribDivisorARB(int index, int divisor) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_instanced_arrays_glVertexAttribDivisorARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBInstancedArrays.nglVertexAttribDivisorARB(index, divisor, function_pointer);
    }

    private static native void nglVertexAttribDivisorARB(int var0, int var1, long var2);
}

