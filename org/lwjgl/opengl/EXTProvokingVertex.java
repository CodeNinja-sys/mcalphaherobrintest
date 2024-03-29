/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class EXTProvokingVertex {
    public static final int GL_FIRST_VERTEX_CONVENTION_EXT = 36429;
    public static final int GL_LAST_VERTEX_CONVENTION_EXT = 36430;
    public static final int GL_PROVOKING_VERTEX_EXT = 36431;
    public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION_EXT = 36428;

    private EXTProvokingVertex() {
    }

    public static void glProvokingVertexEXT(int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_provoking_vertex_glProvokingVertexEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTProvokingVertex.nglProvokingVertexEXT(mode, function_pointer);
    }

    private static native void nglProvokingVertexEXT(int var0, long var1);
}

