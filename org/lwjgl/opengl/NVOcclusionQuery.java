/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVOcclusionQuery {
    public static final int GL_OCCLUSION_TEST_HP = 33125;
    public static final int GL_OCCLUSION_TEST_RESULT_HP = 33126;
    public static final int GL_PIXEL_COUNTER_BITS_NV = 34916;
    public static final int GL_CURRENT_OCCLUSION_QUERY_ID_NV = 34917;
    public static final int GL_PIXEL_COUNT_NV = 34918;
    public static final int GL_PIXEL_COUNT_AVAILABLE_NV = 34919;

    private NVOcclusionQuery() {
    }

    public static void glGenOcclusionQueriesNV(IntBuffer piIDs) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_occlusion_query_glGenOcclusionQueriesNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(piIDs);
        NVOcclusionQuery.nglGenOcclusionQueriesNV(piIDs.remaining(), piIDs, piIDs.position(), function_pointer);
    }

    private static native void nglGenOcclusionQueriesNV(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenOcclusionQueriesNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_occlusion_query_glGenOcclusionQueriesNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer piIDs = APIUtils.getBufferInt();
        NVOcclusionQuery.nglGenOcclusionQueriesNV(1, piIDs, piIDs.position(), function_pointer);
        return piIDs.get(0);
    }

    public static void glDeleteOcclusionQueriesNV(IntBuffer piIDs) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_occlusion_query_glDeleteOcclusionQueriesNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(piIDs);
        NVOcclusionQuery.nglDeleteOcclusionQueriesNV(piIDs.remaining(), piIDs, piIDs.position(), function_pointer);
    }

    private static native void nglDeleteOcclusionQueriesNV(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteOcclusionQueriesNV(int piID) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_occlusion_query_glDeleteOcclusionQueriesNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVOcclusionQuery.nglDeleteOcclusionQueriesNV(1, APIUtils.getBufferInt().put(0, piID), 0, function_pointer);
    }

    public static boolean glIsOcclusionQueryNV(int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_occlusion_query_glIsOcclusionQueryNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = NVOcclusionQuery.nglIsOcclusionQueryNV(id2, function_pointer);
        return __result;
    }

    private static native boolean nglIsOcclusionQueryNV(int var0, long var1);

    public static void glBeginOcclusionQueryNV(int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_occlusion_query_glBeginOcclusionQueryNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVOcclusionQuery.nglBeginOcclusionQueryNV(id2, function_pointer);
    }

    private static native void nglBeginOcclusionQueryNV(int var0, long var1);

    public static void glEndOcclusionQueryNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_occlusion_query_glEndOcclusionQueryNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVOcclusionQuery.nglEndOcclusionQueryNV(function_pointer);
    }

    private static native void nglEndOcclusionQueryNV(long var0);

    public static void glGetOcclusionQueryuNV(int id2, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_occlusion_query_glGetOcclusionQueryuivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        NVOcclusionQuery.nglGetOcclusionQueryuivNV(id2, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetOcclusionQueryuivNV(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetOcclusionQueryuiNV(int id2, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_occlusion_query_glGetOcclusionQueryuivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        NVOcclusionQuery.nglGetOcclusionQueryuivNV(id2, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetOcclusionQueryNV(int id2, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_occlusion_query_glGetOcclusionQueryivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        NVOcclusionQuery.nglGetOcclusionQueryivNV(id2, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetOcclusionQueryivNV(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetOcclusionQueryiNV(int id2, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_occlusion_query_glGetOcclusionQueryivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        NVOcclusionQuery.nglGetOcclusionQueryivNV(id2, pname, params, params.position(), function_pointer);
        return params.get(0);
    }
}

