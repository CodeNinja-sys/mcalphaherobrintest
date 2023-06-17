/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.GLSync;

public final class ARBSync {
    public static final int GL_MAX_SERVER_WAIT_TIMEOUT = 37137;
    public static final int GL_OBJECT_TYPE = 37138;
    public static final int GL_SYNC_CONDITION = 37139;
    public static final int GL_SYNC_STATUS = 37140;
    public static final int GL_SYNC_FLAGS = 37141;
    public static final int GL_SYNC_FENCE = 37142;
    public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 37143;
    public static final int GL_UNSIGNALED = 37144;
    public static final int GL_SIGNALED = 37145;
    public static final int GL_SYNC_FLUSH_COMMANDS_BIT = 1;
    public static final long GL_TIMEOUT_IGNORED = -1L;
    public static final int GL_ALREADY_SIGNALED = 37146;
    public static final int GL_TIMEOUT_EXPIRED = 37147;
    public static final int GL_CONDITION_SATISFIED = 37148;
    public static final int GL_WAIT_FAILED = 37149;

    private ARBSync() {
    }

    public static GLSync glFenceSync(int condition, int flags) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sync_glFenceSync_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLSync __result = new GLSync(ARBSync.nglFenceSync(condition, flags, function_pointer));
        return __result;
    }

    private static native long nglFenceSync(int var0, int var1, long var2);

    public static boolean glIsSync(GLSync sync) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sync_glIsSync_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = ARBSync.nglIsSync(sync.getPointer(), function_pointer);
        return __result;
    }

    private static native boolean nglIsSync(long var0, long var2);

    public static void glDeleteSync(GLSync sync) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sync_glDeleteSync_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBSync.nglDeleteSync(sync.getPointer(), function_pointer);
    }

    private static native void nglDeleteSync(long var0, long var2);

    public static int glClientWaitSync(GLSync sync, int flags, long timeout) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sync_glClientWaitSync_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = ARBSync.nglClientWaitSync(sync.getPointer(), flags, timeout, function_pointer);
        return __result;
    }

    private static native int nglClientWaitSync(long var0, int var2, long var3, long var5);

    public static void glWaitSync(GLSync sync, int flags, long timeout) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sync_glWaitSync_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBSync.nglWaitSync(sync.getPointer(), flags, timeout, function_pointer);
    }

    private static native void nglWaitSync(long var0, int var2, long var3, long var5);

    public static void glGetInteger(int pname, LongBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sync_glGetInteger64v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        ARBSync.nglGetInteger64v(pname, params, params.position(), function_pointer);
    }

    private static native void nglGetInteger64v(int var0, LongBuffer var1, int var2, long var3);

    public static long glGetInteger(int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sync_glGetInteger64v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        LongBuffer params = APIUtils.getBufferLong();
        ARBSync.nglGetInteger64v(pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetSync(GLSync sync, int pname, IntBuffer length, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sync_glGetSynciv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(values);
        ARBSync.nglGetSynciv(sync.getPointer(), pname, values.remaining(), length, length != null ? length.position() : 0, values, values.position(), function_pointer);
    }

    private static native void nglGetSynciv(long var0, int var2, int var3, IntBuffer var4, int var5, IntBuffer var6, int var7, long var8);

    public static int glGetSync(GLSync sync, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_sync_glGetSynciv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer values = APIUtils.getBufferInt();
        ARBSync.nglGetSynciv(sync.getPointer(), pname, 1, null, 0, values, values.position(), function_pointer);
        return values.get(0);
    }
}

