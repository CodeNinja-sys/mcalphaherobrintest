/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBMapBufferRange {
    public static final int GL_MAP_READ_BIT = 1;
    public static final int GL_MAP_WRITE_BIT = 2;
    public static final int GL_MAP_INVALIDATE_RANGE_BIT = 4;
    public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 8;
    public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 16;
    public static final int GL_MAP_UNSYNCHRONIZED_BIT = 32;

    private ARBMapBufferRange() {
    }

    public static ByteBuffer glMapBufferRange(int target, long offset, long length, int access, ByteBuffer old_buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_map_buffer_range_glMapBufferRange_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (old_buffer != null) {
            BufferChecks.checkDirect(old_buffer);
        }
        ByteBuffer __result = ARBMapBufferRange.nglMapBufferRange(target, offset, length, access, old_buffer, function_pointer);
        return __result;
    }

    private static native ByteBuffer nglMapBufferRange(int var0, long var1, long var3, int var5, ByteBuffer var6, long var7);

    public static void glFlushMappedBufferRange(int target, long offset, long length) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_map_buffer_range_glFlushMappedBufferRange_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBMapBufferRange.nglFlushMappedBufferRange(target, offset, length, function_pointer);
    }

    private static native void nglFlushMappedBufferRange(int var0, long var1, long var3, long var5);
}

