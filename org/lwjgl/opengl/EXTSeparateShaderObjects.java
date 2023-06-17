/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class EXTSeparateShaderObjects {
    public static final int GL_ACTIVE_PROGRAM_EXT = 35725;

    private EXTSeparateShaderObjects() {
    }

    public static void glUseShaderProgramEXT(int type, int program) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_separate_shader_objects_glUseShaderProgramEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTSeparateShaderObjects.nglUseShaderProgramEXT(type, program, function_pointer);
    }

    private static native void nglUseShaderProgramEXT(int var0, int var1, long var2);

    public static void glActiveProgramEXT(int program) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_separate_shader_objects_glActiveProgramEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTSeparateShaderObjects.nglActiveProgramEXT(program, function_pointer);
    }

    private static native void nglActiveProgramEXT(int var0, long var1);

    public static int glCreateShaderProgramEXT(int type, ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_separate_shader_objects_glCreateShaderProgramEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(string);
        BufferChecks.checkNullTerminated(string);
        int __result = EXTSeparateShaderObjects.nglCreateShaderProgramEXT(type, string, string.position(), function_pointer);
        return __result;
    }

    private static native int nglCreateShaderProgramEXT(int var0, ByteBuffer var1, int var2, long var3);

    public static int glCreateShaderProgramEXT(int type, CharSequence string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_separate_shader_objects_glCreateShaderProgramEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = EXTSeparateShaderObjects.nglCreateShaderProgramEXT(type, APIUtils.getBufferNT(string), 0, function_pointer);
        return __result;
    }
}

