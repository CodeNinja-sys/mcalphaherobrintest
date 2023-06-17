/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;

public final class GL40 {
    public static final int GL_DRAW_INDIRECT_BUFFER = 36671;
    public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675;
    public static final int GL_GEOMETRY_SHADER_INVOCATIONS = 34943;
    public static final int GL_MAX_GEOMETRY_SHADER_INVOCATIONS = 36442;
    public static final int GL_MIN_FRAGMENT_INTERPOLATION_OFFSET = 36443;
    public static final int GL_MAX_FRAGMENT_INTERPOLATION_OFFSET = 36444;
    public static final int GL_FRAGMENT_INTERPOLATION_OFFSET_BITS = 36445;
    public static final int GL_MAX_VERTEX_STREAMS = 36465;
    public static final int GL_DOUBLE_VEC2 = 36860;
    public static final int GL_DOUBLE_VEC3 = 36861;
    public static final int GL_DOUBLE_VEC4 = 36862;
    public static final int GL_DOUBLE_MAT2 = 36678;
    public static final int GL_DOUBLE_MAT3 = 36679;
    public static final int GL_DOUBLE_MAT4 = 36680;
    public static final int GL_DOUBLE_MAT2x3 = 36681;
    public static final int GL_DOUBLE_MAT2x4 = 36682;
    public static final int GL_DOUBLE_MAT3x2 = 36683;
    public static final int GL_DOUBLE_MAT3x4 = 36684;
    public static final int GL_DOUBLE_MAT4x2 = 36685;
    public static final int GL_DOUBLE_MAT4x3 = 36686;
    public static final int GL_SAMPLE_SHADING = 35894;
    public static final int GL_MIN_SAMPLE_SHADING_VALUE = 35895;
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
    public static final int GL_PATCHES = 14;
    public static final int GL_PATCH_VERTICES = 36466;
    public static final int GL_PATCH_DEFAULT_INNER_LEVEL = 36467;
    public static final int GL_PATCH_DEFAULT_OUTER_LEVEL = 36468;
    public static final int GL_TESS_CONTROL_OUTPUT_VERTICES = 36469;
    public static final int GL_TESS_GEN_MODE = 36470;
    public static final int GL_TESS_GEN_SPACING = 36471;
    public static final int GL_TESS_GEN_VERTEX_ORDER = 36472;
    public static final int GL_TESS_GEN_POINT_MODE = 36473;
    public static final int GL_ISOLINES = 36474;
    public static final int GL_FRACTIONAL_ODD = 36475;
    public static final int GL_FRACTIONAL_EVEN = 36476;
    public static final int GL_MAX_PATCH_VERTICES = 36477;
    public static final int GL_MAX_TESS_GEN_LEVEL = 36478;
    public static final int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS = 36479;
    public static final int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS = 36480;
    public static final int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS = 36481;
    public static final int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS = 36482;
    public static final int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS = 36483;
    public static final int GL_MAX_TESS_PATCH_COMPONENTS = 36484;
    public static final int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS = 36485;
    public static final int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS = 36486;
    public static final int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS = 36489;
    public static final int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS = 36490;
    public static final int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS = 34924;
    public static final int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS = 34925;
    public static final int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS = 36382;
    public static final int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS = 36383;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER = 34032;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER = 34033;
    public static final int GL_TESS_EVALUATION_SHADER = 36487;
    public static final int GL_TESS_CONTROL_SHADER = 36488;
    public static final int GL_TEXTURE_CUBE_MAP_ARRAY = 36873;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY = 36874;
    public static final int GL_PROXY_TEXTURE_CUBE_MAP_ARRAY = 36875;
    public static final int GL_SAMPLER_CUBE_MAP_ARRAY = 36876;
    public static final int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW = 36877;
    public static final int GL_INT_SAMPLER_CUBE_MAP_ARRAY = 36878;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY = 36879;
    public static final int GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET_ARB = 36446;
    public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET_ARB = 36447;
    public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_COMPONENTS_ARB = 36767;
    public static final int GL_TRANSFORM_FEEDBACK = 36386;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 36387;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 36464;

    private GL40() {
    }

    public static void glBlendEquationi(int buf, int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glBlendEquationi_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglBlendEquationi(buf, mode, function_pointer);
    }

    private static native void nglBlendEquationi(int var0, int var1, long var2);

    public static void glBlendEquationSeparatei(int buf, int modeRGB, int modeAlpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glBlendEquationSeparatei_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglBlendEquationSeparatei(buf, modeRGB, modeAlpha, function_pointer);
    }

    private static native void nglBlendEquationSeparatei(int var0, int var1, int var2, long var3);

    public static void glBlendFunci(int buf, int src, int dst) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glBlendFunci_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglBlendFunci(buf, src, dst, function_pointer);
    }

    private static native void nglBlendFunci(int var0, int var1, int var2, long var3);

    public static void glBlendFuncSeparatei(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glBlendFuncSeparatei_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglBlendFuncSeparatei(buf, srcRGB, dstRGB, srcAlpha, dstAlpha, function_pointer);
    }

    private static native void nglBlendFuncSeparatei(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glDrawArraysIndirect(int mode, IntBuffer indirect) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glDrawArraysIndirect_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOdisabled(caps);
        BufferChecks.checkBuffer(indirect, 4);
        BufferChecks.checkNullTerminated(indirect);
        GL40.nglDrawArraysIndirect(mode, indirect, indirect.position(), function_pointer);
    }

    private static native void nglDrawArraysIndirect(int var0, IntBuffer var1, int var2, long var3);

    public static void glDrawArraysIndirect(int mode, long indirect_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glDrawArraysIndirect_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOenabled(caps);
        GL40.nglDrawArraysIndirectBO(mode, indirect_buffer_offset, function_pointer);
    }

    private static native void nglDrawArraysIndirectBO(int var0, long var1, long var3);

    public static void glDrawElementsIndirect(int mode, int type, IntBuffer indirect) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glDrawElementsIndirect_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOdisabled(caps);
        BufferChecks.checkBuffer(indirect, 5);
        BufferChecks.checkNullTerminated(indirect);
        GL40.nglDrawElementsIndirect(mode, type, indirect, indirect.position(), function_pointer);
    }

    private static native void nglDrawElementsIndirect(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glDrawElementsIndirect(int mode, int type, long indirect_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glDrawElementsIndirect_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureIndirectBOenabled(caps);
        GL40.nglDrawElementsIndirectBO(mode, type, indirect_buffer_offset, function_pointer);
    }

    private static native void nglDrawElementsIndirectBO(int var0, int var1, long var2, long var4);

    public static void glUniform1d(int location, double x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniform1d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglUniform1d(location, x2, function_pointer);
    }

    private static native void nglUniform1d(int var0, double var1, long var3);

    public static void glUniform2d(int location, double x2, double y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniform2d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglUniform2d(location, x2, y2, function_pointer);
    }

    private static native void nglUniform2d(int var0, double var1, double var3, long var5);

    public static void glUniform3d(int location, double x2, double y2, double z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniform3d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglUniform3d(location, x2, y2, z2, function_pointer);
    }

    private static native void nglUniform3d(int var0, double var1, double var3, double var5, long var7);

    public static void glUniform4d(int location, double x2, double y2, double z2, double w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniform4d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglUniform4d(location, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglUniform4d(int var0, double var1, double var3, double var5, double var7, long var9);

    public static void glUniform1(int location, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniform1dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL40.nglUniform1dv(location, value.remaining(), value, value.position(), function_pointer);
    }

    private static native void nglUniform1dv(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glUniform2(int location, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniform2dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL40.nglUniform2dv(location, value.remaining() >> 1, value, value.position(), function_pointer);
    }

    private static native void nglUniform2dv(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glUniform3(int location, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniform3dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL40.nglUniform3dv(location, value.remaining() / 3, value, value.position(), function_pointer);
    }

    private static native void nglUniform3dv(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glUniform4(int location, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniform4dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL40.nglUniform4dv(location, value.remaining() >> 2, value, value.position(), function_pointer);
    }

    private static native void nglUniform4dv(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glUniformMatrix2(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniformMatrix2dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL40.nglUniformMatrix2dv(location, value.remaining() >> 2, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix2dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix3(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniformMatrix3dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL40.nglUniformMatrix3dv(location, value.remaining() / 9, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix3dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix4(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniformMatrix4dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL40.nglUniformMatrix4dv(location, value.remaining() >> 4, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix4dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix2x3(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniformMatrix2x3dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL40.nglUniformMatrix2x3dv(location, value.remaining() / 6, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix2x3dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix2x4(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniformMatrix2x4dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL40.nglUniformMatrix2x4dv(location, value.remaining() >> 3, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix2x4dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix3x2(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniformMatrix3x2dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL40.nglUniformMatrix3x2dv(location, value.remaining() / 6, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix3x2dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix3x4(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniformMatrix3x4dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL40.nglUniformMatrix3x4dv(location, value.remaining() / 12, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix3x4dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix4x2(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniformMatrix4x2dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL40.nglUniformMatrix4x2dv(location, value.remaining() >> 3, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix4x2dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glUniformMatrix4x3(int location, boolean transpose, DoubleBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniformMatrix4x3dv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL40.nglUniformMatrix4x3dv(location, value.remaining() / 12, transpose, value, value.position(), function_pointer);
    }

    private static native void nglUniformMatrix4x3dv(int var0, int var1, boolean var2, DoubleBuffer var3, int var4, long var5);

    public static void glGetUniform(int program, int location, DoubleBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetUniformdv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        GL40.nglGetUniformdv(program, location, params, params.position(), function_pointer);
    }

    private static native void nglGetUniformdv(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glMinSampleShading(float value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glMinSampleShading_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglMinSampleShading(value, function_pointer);
    }

    private static native void nglMinSampleShading(float var0, long var1);

    public static int glGetSubroutineUniformLocation(int program, int shadertype, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetSubroutineUniformLocation_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        int __result = GL40.nglGetSubroutineUniformLocation(program, shadertype, name, name.position(), function_pointer);
        return __result;
    }

    private static native int nglGetSubroutineUniformLocation(int var0, int var1, ByteBuffer var2, int var3, long var4);

    public static int glGetSubroutineIndex(int program, int shadertype, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetSubroutineIndex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        int __result = GL40.nglGetSubroutineIndex(program, shadertype, name, name.position(), function_pointer);
        return __result;
    }

    private static native int nglGetSubroutineIndex(int var0, int var1, ByteBuffer var2, int var3, long var4);

    public static void glGetActiveSubroutineUniform(int program, int shadertype, int index, int pname, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetActiveSubroutineUniformiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(values, 1);
        GL40.nglGetActiveSubroutineUniformiv(program, shadertype, index, pname, values, values.position(), function_pointer);
    }

    private static native void nglGetActiveSubroutineUniformiv(int var0, int var1, int var2, int var3, IntBuffer var4, int var5, long var6);

    public static int glGetActiveSubroutineUniform(int program, int shadertype, int index, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetActiveSubroutineUniformiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer values = APIUtils.getBufferInt();
        GL40.nglGetActiveSubroutineUniformiv(program, shadertype, index, pname, values, values.position(), function_pointer);
        return values.get(0);
    }

    public static void glGetActiveSubroutineUniformName(int program, int shadertype, int index, IntBuffer length, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetActiveSubroutineUniformName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(name);
        GL40.nglGetActiveSubroutineUniformName(program, shadertype, index, name.remaining(), length, length != null ? length.position() : 0, name, name.position(), function_pointer);
    }

    private static native void nglGetActiveSubroutineUniformName(int var0, int var1, int var2, int var3, IntBuffer var4, int var5, ByteBuffer var6, int var7, long var8);

    public static String glGetActiveSubroutineUniformName(int program, int shadertype, int index, int bufsize) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetActiveSubroutineUniformName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(bufsize);
        GL40.nglGetActiveSubroutineUniformName(program, shadertype, index, bufsize, name_length, 0, name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static void glGetActiveSubroutineName(int program, int shadertype, int index, IntBuffer length, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetActiveSubroutineName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(name);
        GL40.nglGetActiveSubroutineName(program, shadertype, index, name.remaining(), length, length != null ? length.position() : 0, name, name.position(), function_pointer);
    }

    private static native void nglGetActiveSubroutineName(int var0, int var1, int var2, int var3, IntBuffer var4, int var5, ByteBuffer var6, int var7, long var8);

    public static String glGetActiveSubroutineName(int program, int shadertype, int index, int bufsize) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetActiveSubroutineName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(bufsize);
        GL40.nglGetActiveSubroutineName(program, shadertype, index, bufsize, name_length, 0, name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static void glUniformSubroutinesu(int shadertype, IntBuffer indices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glUniformSubroutinesuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(indices);
        GL40.nglUniformSubroutinesuiv(shadertype, indices.remaining(), indices, indices.position(), function_pointer);
    }

    private static native void nglUniformSubroutinesuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetUniformSubroutineu(int shadertype, int location, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetUniformSubroutineuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        GL40.nglGetUniformSubroutineuiv(shadertype, location, params, params.position(), function_pointer);
    }

    private static native void nglGetUniformSubroutineuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetUniformSubroutineu(int shadertype, int location) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetUniformSubroutineuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL40.nglGetUniformSubroutineuiv(shadertype, location, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetProgramStage(int program, int shadertype, int pname, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetProgramStageiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(values, 1);
        GL40.nglGetProgramStageiv(program, shadertype, pname, values, values.position(), function_pointer);
    }

    private static native void nglGetProgramStageiv(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static int glGetProgramStage(int program, int shadertype, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetProgramStageiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer values = APIUtils.getBufferInt();
        GL40.nglGetProgramStageiv(program, shadertype, pname, values, values.position(), function_pointer);
        return values.get(0);
    }

    public static void glPatchParameteri(int pname, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glPatchParameteri_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglPatchParameteri(pname, value, function_pointer);
    }

    private static native void nglPatchParameteri(int var0, int var1, long var2);

    public static void glPatchParameter(int pname, FloatBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glPatchParameterfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(values, 4);
        GL40.nglPatchParameterfv(pname, values, values.position(), function_pointer);
    }

    private static native void nglPatchParameterfv(int var0, FloatBuffer var1, int var2, long var3);

    public static void glBindTransformFeedback(int target, int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glBindTransformFeedback_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglBindTransformFeedback(target, id2, function_pointer);
    }

    private static native void nglBindTransformFeedback(int var0, int var1, long var2);

    public static void glDeleteTransformFeedbacks(IntBuffer ids) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glDeleteTransformFeedbacks_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(ids);
        GL40.nglDeleteTransformFeedbacks(ids.remaining(), ids, ids.position(), function_pointer);
    }

    private static native void nglDeleteTransformFeedbacks(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteTransformFeedbacks(int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glDeleteTransformFeedbacks_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglDeleteTransformFeedbacks(1, APIUtils.getBufferInt().put(0, id2), 0, function_pointer);
    }

    public static void glGenTransformFeedbacks(IntBuffer ids) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGenTransformFeedbacks_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(ids);
        GL40.nglGenTransformFeedbacks(ids.remaining(), ids, ids.position(), function_pointer);
    }

    private static native void nglGenTransformFeedbacks(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenTransformFeedbacks() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGenTransformFeedbacks_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer ids = APIUtils.getBufferInt();
        GL40.nglGenTransformFeedbacks(1, ids, ids.position(), function_pointer);
        return ids.get(0);
    }

    public static boolean glIsTransformFeedback(int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glIsTransformFeedback_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = GL40.nglIsTransformFeedback(id2, function_pointer);
        return __result;
    }

    private static native boolean nglIsTransformFeedback(int var0, long var1);

    public static void glPauseTransformFeedback() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glPauseTransformFeedback_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglPauseTransformFeedback(function_pointer);
    }

    private static native void nglPauseTransformFeedback(long var0);

    public static void glResumeTransformFeedback() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glResumeTransformFeedback_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglResumeTransformFeedback(function_pointer);
    }

    private static native void nglResumeTransformFeedback(long var0);

    public static void glDrawTransformFeedback(int mode, int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glDrawTransformFeedback_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglDrawTransformFeedback(mode, id2, function_pointer);
    }

    private static native void nglDrawTransformFeedback(int var0, int var1, long var2);

    public static void glDrawTransformFeedbackStream(int mode, int id2, int stream) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glDrawTransformFeedbackStream_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglDrawTransformFeedbackStream(mode, id2, stream, function_pointer);
    }

    private static native void nglDrawTransformFeedbackStream(int var0, int var1, int var2, long var3);

    public static void glBeginQueryIndexed(int target, int index, int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glBeginQueryIndexed_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglBeginQueryIndexed(target, index, id2, function_pointer);
    }

    private static native void nglBeginQueryIndexed(int var0, int var1, int var2, long var3);

    public static void glEndQueryIndexed(int target, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glEndQueryIndexed_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL40.nglEndQueryIndexed(target, index, function_pointer);
    }

    private static native void nglEndQueryIndexed(int var0, int var1, long var2);

    public static void glGetQueryIndexed(int target, int index, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetQueryIndexediv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        GL40.nglGetQueryIndexediv(target, index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetQueryIndexediv(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static int glGetQueryIndexed(int target, int index, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL40_glGetQueryIndexediv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL40.nglGetQueryIndexediv(target, index, pname, params, params.position(), function_pointer);
        return params.get(0);
    }
}

