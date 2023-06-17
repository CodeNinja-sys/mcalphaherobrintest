/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBTimerQuery {
    public static final int GL_TIME_ELAPSED = 35007;
    public static final int GL_TIMESTAMP = 36392;

    private ARBTimerQuery() {
    }

    public static void glQueryCounter(int id2, int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_timer_query_glQueryCounter_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBTimerQuery.nglQueryCounter(id2, target, function_pointer);
    }

    private static native void nglQueryCounter(int var0, int var1, long var2);

    public static void glGetQueryObject(int id2, int pname, LongBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_timer_query_glGetQueryObjecti64v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        ARBTimerQuery.nglGetQueryObjecti64v(id2, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetQueryObjecti64v(int var0, int var1, LongBuffer var2, int var3, long var4);

    public static long glGetQueryObject(int id2, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_timer_query_glGetQueryObjecti64v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        LongBuffer params = APIUtils.getBufferLong();
        ARBTimerQuery.nglGetQueryObjecti64v(id2, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetQueryObjectu(int id2, int pname, LongBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_timer_query_glGetQueryObjectui64v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        ARBTimerQuery.nglGetQueryObjectui64v(id2, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetQueryObjectui64v(int var0, int var1, LongBuffer var2, int var3, long var4);

    public static long glGetQueryObjectu(int id2, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_timer_query_glGetQueryObjectui64v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        LongBuffer params = APIUtils.getBufferLong();
        ARBTimerQuery.nglGetQueryObjectui64v(id2, pname, params, params.position(), function_pointer);
        return params.get(0);
    }
}

