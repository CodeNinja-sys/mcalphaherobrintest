/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBShaderSubroutine {
    public static final int GL_ACTIVE_SUBROUTINES = 36325;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 36326;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 36423;
    public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 36424;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 36425;
    public static final int GL_MAX_SUBROUTINES = 36327;
    public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 36328;
    public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 36426;
    public static final int GL_COMPATIBLE_SUBROUTINES = 36427;
    public static final int GL_UNIFORM_SIZE = 35384;
    public static final int GL_UNIFORM_NAME_LENGTH = 35385;

    private ARBShaderSubroutine() {
    }

    public static int glGetSubroutineUniformLocation(int program, int shadertype, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_subroutine_glGetSubroutineUniformLocation_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        int __result = ARBShaderSubroutine.nglGetSubroutineUniformLocation(program, shadertype, name, name.position(), function_pointer);
        return __result;
    }

    private static native int nglGetSubroutineUniformLocation(int var0, int var1, ByteBuffer var2, int var3, long var4);

    public static int glGetSubroutineIndex(int program, int shadertype, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_subroutine_glGetSubroutineIndex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        int __result = ARBShaderSubroutine.nglGetSubroutineIndex(program, shadertype, name, name.position(), function_pointer);
        return __result;
    }

    private static native int nglGetSubroutineIndex(int var0, int var1, ByteBuffer var2, int var3, long var4);

    public static void glGetActiveSubroutineUniform(int program, int shadertype, int index, int pname, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_subroutine_glGetActiveSubroutineUniformiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(values, 1);
        ARBShaderSubroutine.nglGetActiveSubroutineUniformiv(program, shadertype, index, pname, values, values.position(), function_pointer);
    }

    private static native void nglGetActiveSubroutineUniformiv(int var0, int var1, int var2, int var3, IntBuffer var4, int var5, long var6);

    public static int glGetActiveSubroutineUniform(int program, int shadertype, int index, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_subroutine_glGetActiveSubroutineUniformiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer values = APIUtils.getBufferInt();
        ARBShaderSubroutine.nglGetActiveSubroutineUniformiv(program, shadertype, index, pname, values, values.position(), function_pointer);
        return values.get(0);
    }

    public static void glGetActiveSubroutineUniformName(int program, int shadertype, int index, IntBuffer length, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_subroutine_glGetActiveSubroutineUniformName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(name);
        ARBShaderSubroutine.nglGetActiveSubroutineUniformName(program, shadertype, index, name.remaining(), length, length != null ? length.position() : 0, name, name.position(), function_pointer);
    }

    private static native void nglGetActiveSubroutineUniformName(int var0, int var1, int var2, int var3, IntBuffer var4, int var5, ByteBuffer var6, int var7, long var8);

    public static String glGetActiveSubroutineUniformName(int program, int shadertype, int index, int bufsize) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_subroutine_glGetActiveSubroutineUniformName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(bufsize);
        ARBShaderSubroutine.nglGetActiveSubroutineUniformName(program, shadertype, index, bufsize, name_length, 0, name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static void glGetActiveSubroutineName(int program, int shadertype, int index, IntBuffer length, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_subroutine_glGetActiveSubroutineName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(name);
        ARBShaderSubroutine.nglGetActiveSubroutineName(program, shadertype, index, name.remaining(), length, length != null ? length.position() : 0, name, name.position(), function_pointer);
    }

    private static native void nglGetActiveSubroutineName(int var0, int var1, int var2, int var3, IntBuffer var4, int var5, ByteBuffer var6, int var7, long var8);

    public static String glGetActiveSubroutineName(int program, int shadertype, int index, int bufsize) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_subroutine_glGetActiveSubroutineName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(bufsize);
        ARBShaderSubroutine.nglGetActiveSubroutineName(program, shadertype, index, bufsize, name_length, 0, name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static void glUniformSubroutinesu(int shadertype, IntBuffer indices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_subroutine_glUniformSubroutinesuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(indices);
        ARBShaderSubroutine.nglUniformSubroutinesuiv(shadertype, indices.remaining(), indices, indices.position(), function_pointer);
    }

    private static native void nglUniformSubroutinesuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetUniformSubroutineu(int shadertype, int location, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_subroutine_glGetUniformSubroutineuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        ARBShaderSubroutine.nglGetUniformSubroutineuiv(shadertype, location, params, params.position(), function_pointer);
    }

    private static native void nglGetUniformSubroutineuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetUniformSubroutineu(int shadertype, int location) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_subroutine_glGetUniformSubroutineuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBShaderSubroutine.nglGetUniformSubroutineuiv(shadertype, location, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetProgramStage(int program, int shadertype, int pname, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_subroutine_glGetProgramStageiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(values, 1);
        ARBShaderSubroutine.nglGetProgramStageiv(program, shadertype, pname, values, values.position(), function_pointer);
    }

    private static native void nglGetProgramStageiv(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static int glGetProgramStage(int program, int shadertype, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_subroutine_glGetProgramStageiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer values = APIUtils.getBufferInt();
        ARBShaderSubroutine.nglGetProgramStageiv(program, shadertype, pname, values, values.position(), function_pointer);
        return values.get(0);
    }
}

