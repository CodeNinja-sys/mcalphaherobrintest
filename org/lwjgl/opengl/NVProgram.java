/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public class NVProgram {
    public static final int GL_PROGRAM_TARGET_NV = 34374;
    public static final int GL_PROGRAM_LENGTH_NV = 34343;
    public static final int GL_PROGRAM_RESIDENT_NV = 34375;
    public static final int GL_PROGRAM_STRING_NV = 34344;
    public static final int GL_PROGRAM_ERROR_POSITION_NV = 34379;
    public static final int GL_PROGRAM_ERROR_STRING_NV = 34932;

    public static void glLoadProgramNV(int target, int programID, ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glLoadProgramNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(string);
        NVProgram.nglLoadProgramNV(target, programID, string.remaining(), string, string.position(), function_pointer);
    }

    private static native void nglLoadProgramNV(int var0, int var1, int var2, Buffer var3, int var4, long var5);

    public static void glLoadProgramNV(int target, int programID, CharSequence string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glLoadProgramNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVProgram.nglLoadProgramNV(target, programID, string.length(), APIUtils.getBuffer(string), 0, function_pointer);
    }

    public static void glBindProgramNV(int target, int programID) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glBindProgramNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVProgram.nglBindProgramNV(target, programID, function_pointer);
    }

    private static native void nglBindProgramNV(int var0, int var1, long var2);

    public static void glDeleteProgramsNV(IntBuffer programs) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glDeleteProgramsNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(programs);
        NVProgram.nglDeleteProgramsNV(programs.remaining(), programs, programs.position(), function_pointer);
    }

    private static native void nglDeleteProgramsNV(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteProgramsNV(int program) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glDeleteProgramsNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVProgram.nglDeleteProgramsNV(1, APIUtils.getBufferInt().put(0, program), 0, function_pointer);
    }

    public static void glGenProgramsNV(IntBuffer programs) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glGenProgramsNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(programs);
        NVProgram.nglGenProgramsNV(programs.remaining(), programs, programs.position(), function_pointer);
    }

    private static native void nglGenProgramsNV(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenProgramsNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glGenProgramsNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer programs = APIUtils.getBufferInt();
        NVProgram.nglGenProgramsNV(1, programs, programs.position(), function_pointer);
        return programs.get(0);
    }

    public static void glGetProgramNV(int programID, int parameterName, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glGetProgramivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        NVProgram.nglGetProgramivNV(programID, parameterName, params, params.position(), function_pointer);
    }

    private static native void nglGetProgramivNV(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetProgramNV(int programID, int parameterName) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glGetProgramivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        NVProgram.nglGetProgramivNV(programID, parameterName, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetProgramStringNV(int programID, int parameterName, ByteBuffer paramString) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glGetProgramStringNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(paramString);
        NVProgram.nglGetProgramStringNV(programID, parameterName, paramString, paramString.position(), function_pointer);
    }

    private static native void nglGetProgramStringNV(int var0, int var1, Buffer var2, int var3, long var4);

    public static String glGetProgramStringNV(int programID, int parameterName) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glGetProgramStringNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int programLength = NVProgram.glGetProgramNV(programID, 34343);
        ByteBuffer paramString = APIUtils.getBufferByte(programLength);
        NVProgram.nglGetProgramStringNV(programID, parameterName, paramString, paramString.position(), function_pointer);
        paramString.limit(programLength);
        return APIUtils.getString(paramString);
    }

    public static boolean glIsProgramNV(int programID) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glIsProgramNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = NVProgram.nglIsProgramNV(programID, function_pointer);
        return __result;
    }

    private static native boolean nglIsProgramNV(int var0, long var1);

    public static boolean glAreProgramsResidentNV(IntBuffer programIDs, ByteBuffer programResidences) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glAreProgramsResidentNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(programIDs);
        BufferChecks.checkBuffer(programResidences, programIDs.remaining());
        boolean __result = NVProgram.nglAreProgramsResidentNV(programIDs.remaining(), programIDs, programIDs.position(), programResidences, programResidences.position(), function_pointer);
        return __result;
    }

    private static native boolean nglAreProgramsResidentNV(int var0, IntBuffer var1, int var2, ByteBuffer var3, int var4, long var5);

    public static void glRequestResidentProgramsNV(IntBuffer programIDs) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glRequestResidentProgramsNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(programIDs);
        NVProgram.nglRequestResidentProgramsNV(programIDs.remaining(), programIDs, programIDs.position(), function_pointer);
    }

    private static native void nglRequestResidentProgramsNV(int var0, IntBuffer var1, int var2, long var3);

    public static void glRequestResidentProgramsNV(int programID) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_program_glRequestResidentProgramsNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVProgram.nglRequestResidentProgramsNV(1, APIUtils.getBufferInt().put(0, programID), 0, function_pointer);
    }
}

