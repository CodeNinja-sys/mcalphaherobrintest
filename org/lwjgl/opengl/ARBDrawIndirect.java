/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;

public final class ARBDrawIndirect {
    public static final int GL_DRAW_INDIRECT_BUFFER = 36671;
    public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675;

    private ARBDrawIndirect() {
    }

    public static void glDrawArraysIndirect(int mode, IntBuffer indirect) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_indirect_glDrawArraysIndirect_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOdisabled(caps);
        BufferChecks.checkBuffer(indirect, 4);
        BufferChecks.checkNullTerminated(indirect);
        ARBDrawIndirect.nglDrawArraysIndirect(mode, indirect, indirect.position(), function_pointer);
    }

    private static native void nglDrawArraysIndirect(int var0, IntBuffer var1, int var2, long var3);

    public static void glDrawArraysIndirect(int mode, long indirect_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_indirect_glDrawArraysIndirect_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOenabled(caps);
        ARBDrawIndirect.nglDrawArraysIndirectBO(mode, indirect_buffer_offset, function_pointer);
    }

    private static native void nglDrawArraysIndirectBO(int var0, long var1, long var3);

    public static void glDrawElementsIndirect(int mode, int type, IntBuffer indirect) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_indirect_glDrawElementsIndirect_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOdisabled(caps);
        BufferChecks.checkBuffer(indirect, 5);
        BufferChecks.checkNullTerminated(indirect);
        ARBDrawIndirect.nglDrawElementsIndirect(mode, type, indirect, indirect.position(), function_pointer);
    }

    private static native void nglDrawElementsIndirect(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glDrawElementsIndirect(int mode, int type, long indirect_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_indirect_glDrawElementsIndirect_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOenabled(caps);
        ARBDrawIndirect.nglDrawElementsIndirectBO(mode, type, indirect_buffer_offset, function_pointer);
    }

    private static native void nglDrawElementsIndirectBO(int var0, int var1, long var2, long var4);
}

