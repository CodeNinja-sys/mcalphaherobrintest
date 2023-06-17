/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class GREMEDYStringMarker {
    private GREMEDYStringMarker() {
    }

    public static void glStringMarkerGREMEDY(ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GREMEDY_string_marker_glStringMarkerGREMEDY_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(string);
        GREMEDYStringMarker.nglStringMarkerGREMEDY(string.remaining(), string, string.position(), function_pointer);
    }

    private static native void nglStringMarkerGREMEDY(int var0, ByteBuffer var1, int var2, long var3);

    public static void glStringMarkerGREMEDY(CharSequence string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GREMEDY_string_marker_glStringMarkerGREMEDY_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GREMEDYStringMarker.nglStringMarkerGREMEDY(string.length(), APIUtils.getBuffer(string), 0, function_pointer);
    }
}

