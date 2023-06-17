/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBOcclusionQuery {
    public static final int GL_SAMPLES_PASSED_ARB = 35092;
    public static final int GL_QUERY_COUNTER_BITS_ARB = 34916;
    public static final int GL_CURRENT_QUERY_ARB = 34917;
    public static final int GL_QUERY_RESULT_ARB = 34918;
    public static final int GL_QUERY_RESULT_AVAILABLE_ARB = 34919;

    private ARBOcclusionQuery() {
    }

    public static void glGenQueriesARB(IntBuffer ids) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_occlusion_query_glGenQueriesARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(ids);
        ARBOcclusionQuery.nglGenQueriesARB(ids.remaining(), ids, ids.position(), function_pointer);
    }

    private static native void nglGenQueriesARB(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenQueriesARB() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_occlusion_query_glGenQueriesARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer ids = APIUtils.getBufferInt();
        ARBOcclusionQuery.nglGenQueriesARB(1, ids, ids.position(), function_pointer);
        return ids.get(0);
    }

    public static void glDeleteQueriesARB(IntBuffer ids) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_occlusion_query_glDeleteQueriesARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(ids);
        ARBOcclusionQuery.nglDeleteQueriesARB(ids.remaining(), ids, ids.position(), function_pointer);
    }

    private static native void nglDeleteQueriesARB(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteQueriesARB(int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_occlusion_query_glDeleteQueriesARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBOcclusionQuery.nglDeleteQueriesARB(1, APIUtils.getBufferInt().put(0, id2), 0, function_pointer);
    }

    public static boolean glIsQueryARB(int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_occlusion_query_glIsQueryARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = ARBOcclusionQuery.nglIsQueryARB(id2, function_pointer);
        return __result;
    }

    private static native boolean nglIsQueryARB(int var0, long var1);

    public static void glBeginQueryARB(int target, int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_occlusion_query_glBeginQueryARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBOcclusionQuery.nglBeginQueryARB(target, id2, function_pointer);
    }

    private static native void nglBeginQueryARB(int var0, int var1, long var2);

    public static void glEndQueryARB(int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_occlusion_query_glEndQueryARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBOcclusionQuery.nglEndQueryARB(target, function_pointer);
    }

    private static native void nglEndQueryARB(int var0, long var1);

    public static void glGetQueryARB(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_occlusion_query_glGetQueryivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        ARBOcclusionQuery.nglGetQueryivARB(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetQueryivARB(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetQueryARB(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_occlusion_query_glGetQueryivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBOcclusionQuery.nglGetQueryivARB(target, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetQueryObjectARB(int id2, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_occlusion_query_glGetQueryObjectivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        ARBOcclusionQuery.nglGetQueryObjectivARB(id2, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetQueryObjectivARB(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetQueryObjectiARB(int id2, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_occlusion_query_glGetQueryObjectivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBOcclusionQuery.nglGetQueryObjectivARB(id2, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetQueryObjectuARB(int id2, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_occlusion_query_glGetQueryObjectuivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        ARBOcclusionQuery.nglGetQueryObjectuivARB(id2, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetQueryObjectuivARB(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetQueryObjectuiARB(int id2, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_occlusion_query_glGetQueryObjectuivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBOcclusionQuery.nglGetQueryObjectuivARB(id2, pname, params, params.position(), function_pointer);
        return params.get(0);
    }
}

