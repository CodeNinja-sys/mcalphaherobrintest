/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class EXTTimerQuery {
    public static final int GL_TIME_ELAPSED_EXT = 35007;

    private EXTTimerQuery() {
    }

    public static void glGetQueryObjectEXT(int id2, int pname, LongBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_timer_query_glGetQueryObjecti64vEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        EXTTimerQuery.nglGetQueryObjecti64vEXT(id2, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetQueryObjecti64vEXT(int var0, int var1, LongBuffer var2, int var3, long var4);

    public static long glGetQueryObjectEXT(int id2, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_timer_query_glGetQueryObjecti64vEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        LongBuffer params = APIUtils.getBufferLong();
        EXTTimerQuery.nglGetQueryObjecti64vEXT(id2, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetQueryObjectuEXT(int id2, int pname, LongBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_timer_query_glGetQueryObjectui64vEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        EXTTimerQuery.nglGetQueryObjectui64vEXT(id2, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetQueryObjectui64vEXT(int var0, int var1, LongBuffer var2, int var3, long var4);

    public static long glGetQueryObjectuEXT(int id2, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_timer_query_glGetQueryObjectui64vEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        LongBuffer params = APIUtils.getBufferLong();
        EXTTimerQuery.nglGetQueryObjectui64vEXT(id2, pname, params, params.position(), function_pointer);
        return params.get(0);
    }
}

