/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBBlendFuncExtended {
    public static final int GL_SRC1_COLOR = 35065;
    public static final int GL_SRC1_ALPHA = 34185;
    public static final int GL_ONE_MINUS_SRC1_COLOR = 35066;
    public static final int GL_ONE_MINUS_SRC1_ALPHA = 35067;
    public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 35068;

    private ARBBlendFuncExtended() {
    }

    public static void glBindFragDataLocationIndexed(int program, int colorNumber, int index, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_blend_func_extended_glBindFragDataLocationIndexed_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        ARBBlendFuncExtended.nglBindFragDataLocationIndexed(program, colorNumber, index, name, name.position(), function_pointer);
    }

    private static native void nglBindFragDataLocationIndexed(int var0, int var1, int var2, ByteBuffer var3, int var4, long var5);

    public static void glBindFragDataLocationIndexed(int program, int colorNumber, int index, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_blend_func_extended_glBindFragDataLocationIndexed_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBBlendFuncExtended.nglBindFragDataLocationIndexed(program, colorNumber, index, APIUtils.getBufferNT(name), 0, function_pointer);
    }

    public static int glGetFragDataIndex(int program, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_blend_func_extended_glGetFragDataIndex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        int __result = ARBBlendFuncExtended.nglGetFragDataIndex(program, name, name.position(), function_pointer);
        return __result;
    }

    private static native int nglGetFragDataIndex(int var0, ByteBuffer var1, int var2, long var3);

    public static int glGetFragDataIndex(int program, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_blend_func_extended_glGetFragDataIndex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = ARBBlendFuncExtended.nglGetFragDataIndex(program, APIUtils.getBufferNT(name), 0, function_pointer);
        return __result;
    }
}

