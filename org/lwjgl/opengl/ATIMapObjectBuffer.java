/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;

public final class ATIMapObjectBuffer {
    private ATIMapObjectBuffer() {
    }

    public static ByteBuffer glMapObjectBufferATI(int buffer, ByteBuffer old_buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_map_object_buffer_glMapObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (old_buffer != null) {
            BufferChecks.checkDirect(old_buffer);
        }
        ByteBuffer __result = ATIMapObjectBuffer.nglMapObjectBufferATI(buffer, GLChecks.getBufferObjectSizeATI(caps, buffer), old_buffer, function_pointer);
        return __result;
    }

    public static ByteBuffer glMapObjectBufferATI(int buffer, long length, ByteBuffer old_buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_map_object_buffer_glMapObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (old_buffer != null) {
            BufferChecks.checkDirect(old_buffer);
        }
        ByteBuffer __result = ATIMapObjectBuffer.nglMapObjectBufferATI(buffer, length, old_buffer, function_pointer);
        return __result;
    }

    private static native ByteBuffer nglMapObjectBufferATI(int var0, long var1, ByteBuffer var3, long var4);

    public static void glUnmapObjectBufferATI(int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_map_object_buffer_glUnmapObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIMapObjectBuffer.nglUnmapObjectBufferATI(buffer, function_pointer);
    }

    private static native void nglUnmapObjectBufferATI(int var0, long var1);
}

