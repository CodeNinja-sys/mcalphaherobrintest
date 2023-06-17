/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBProvokingVertex {
    public static final int GL_FIRST_VERTEX_CONVENTION = 36429;
    public static final int GL_LAST_VERTEX_CONVENTION = 36430;
    public static final int GL_PROVOKING_VERTEX = 36431;
    public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION = 36428;

    private ARBProvokingVertex() {
    }

    public static void glProvokingVertex(int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_provoking_vertex_glProvokingVertex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBProvokingVertex.nglProvokingVertex(mode, function_pointer);
    }

    private static native void nglProvokingVertex(int var0, long var1);
}

