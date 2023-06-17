/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBCopyBuffer {
    public static final int GL_COPY_READ_BUFFER = 36662;
    public static final int GL_COPY_WRITE_BUFFER = 36663;

    private ARBCopyBuffer() {
    }

    public static void glCopyBufferSubData(int readTarget, int writeTarget, long readOffset, long writeOffset, long size) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_copy_buffer_glCopyBufferSubData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBCopyBuffer.nglCopyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size, function_pointer);
    }

    private static native void nglCopyBufferSubData(int var0, int var1, long var2, long var4, long var6, long var8);
}

