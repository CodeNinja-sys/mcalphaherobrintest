/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class EXTMultiDrawArrays {
    private EXTMultiDrawArrays() {
    }

    public static void glMultiDrawArraysEXT(int mode, IntBuffer piFirst, IntBuffer piCount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_multi_draw_arrays_glMultiDrawArraysEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(piFirst);
        BufferChecks.checkBuffer(piCount, piFirst.remaining());
        EXTMultiDrawArrays.nglMultiDrawArraysEXT(mode, piFirst, piFirst.position(), piCount, piCount.position(), piFirst.remaining(), function_pointer);
    }

    private static native void nglMultiDrawArraysEXT(int var0, IntBuffer var1, int var2, IntBuffer var3, int var4, int var5, long var6);
}

