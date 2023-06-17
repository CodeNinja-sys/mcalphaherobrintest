/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;

public final class GL20 {
    public static final int GL_SHADING_LANGUAGE_VERSION = 35724;
    public static final int GL_CURRENT_PROGRAM = 35725;
    public static final int GL_SHADER_TYPE = 35663;
    public static final int GL_DELETE_STATUS = 35712;
    public static final int GL_COMPILE_STATUS = 35713;
    public static final int GL_LINK_STATUS = 35714;
    public static final int GL_VALIDATE_STATUS = 35715;
    public static final int GL_INFO_LOG_LENGTH = 35716;
    public static final int GL_ATTACHED_SHADERS = 35717;
    public static final int GL_ACTIVE_UNIFORMS = 35718;
    public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH = 35719;
    public static final int GL_ACTIVE_ATTRIBUTES = 35721;
    public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 35722;
    public static final int GL_SHADER_SOURCE_LENGTH = 35720;
    public static final int GL_SHADER_OBJECT = 35656;
    public static final int GL_FLOAT_VEC2 = 35664;
    public static final int GL_FLOAT_VEC3 = 35665;
    public static final int GL_FLOAT_VEC4 = 35666;
    public static final int GL_INT_VEC2 = 35667;
    public static final int GL_INT_VEC3 = 35668;
    public static final int GL_INT_VEC4 = 35669;
    public static final int GL_BOOL = 35670;
    public static final int GL_BOOL_VEC2 = 35671;
    public static final int GL_BOOL_VEC3 = 35672;
    public static final int GL_BOOL_VEC4 = 35673;
    public static final int GL_FLOAT_MAT2 = 35674;
    public static final int GL_FLOAT_MAT3 = 35675;
    public static final int GL_FLOAT_MAT4 = 35676;
    public static final int GL_SAMPLER_1D = 35677;
    public static final int GL_SAMPLER_2D = 35678;
    public static final int GL_SAMPLER_3D = 35679;
    public static final int GL_SAMPLER_CUBE = 35680;
    public static final int GL_SAMPLER_1D_SHADOW = 35681;
    public static final int GL_SAMPLER_2D_SHADOW = 35682;
    public static final int GL_VERTEX_SHADER = 35633;
    public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS = 35658;
    public static final int GL_MAX_VARYING_FLOATS = 35659;
    public static final int GL_MAX_VERTEX_ATTRIBS = 34921;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS = 34930;
    public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 35660;
    public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 35661;
    public static final int GL_MAX_TEXTURE_COORDS = 34929;
    public static final int GL_VERTEX_PROGRAM_POINT_SIZE = 34370;
    public static final int GL_VERTEX_PROGRAM_TWO_SIDE = 34371;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 34338;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE = 34339;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 34340;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE = 34341;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 34922;
    public static final int GL_CURRENT_VERTEX_ATTRIB = 34342;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 34373;
    public static final int GL_FRAGMENT_SHADER = 35632;
    public static final int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = 35657;
    public static final int GL_FRAGMENT_SHADER_DERIVATIVE_HINT = 35723;
    public static final int GL_MAX_DRAW_BUFFERS = 34852;
    public static final int GL_DRAW_BUFFER0 = 34853;
    public static final int GL_DRAW_BUFFER1 = 34854;
    public static final int GL_DRAW_BUFFER2 = 34855;
    public static final int GL_DRAW_BUFFER3 = 34856;
    public static final int GL_DRAW_BUFFER4 = 34857;
    public static final int GL_DRAW_BUFFER5 = 34858;
    public static final int GL_DRAW_BUFFER6 = 34859;
    public static final int GL_DRAW_BUFFER7 = 34860;
    public static final int GL_DRAW_BUFFER8 = 34861;
    public static final int GL_DRAW_BUFFER9 = 34862;
    public static final int GL_DRAW_BUFFER10 = 34863;
    public static final int GL_DRAW_BUFFER11 = 34864;
    public static final int GL_DRAW_BUFFER12 = 34865;
    public static final int GL_DRAW_BUFFER13 = 34866;
    public static final int GL_DRAW_BUFFER14 = 34867;
    public static final int GL_DRAW_BUFFER15 = 34868;
    public static final int GL_POINT_SPRITE = 34913;
    public static final int GL_COORD_REPLACE = 34914;
    public static final int GL_POINT_SPRITE_COORD_ORIGIN = 36000;
    public static final int GL_LOWER_LEFT = 36001;
    public static final int GL_UPPER_LEFT = 36002;
    public static final int GL_STENCIL_BACK_FUNC = 34816;
    public static final int GL_STENCIL_BACK_FAIL = 34817;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL = 34818;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS = 34819;
    public static final int GL_STENCIL_BACK_REF = 36003;
    public static final int GL_STENCIL_BACK_VALUE_MASK = 36004;
    public static final int GL_STENCIL_BACK_WRITEMASK = 36005;
    public static final int GL_BLEND_EQUATION_RGB = 32777;
    public static final int GL_BLEND_EQUATION_ALPHA = 34877;

    private GL20() {
    }

    public static void glShaderSource(int shader, ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glShaderSource_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(string);
        GL20.nglShaderSource(shader, 1, string, string.position(), string.remaining(), function_pointer);
    }

    private static native void nglShaderSource(int var0, int var1, ByteBuffer var2, int var3, int var4, long var5);

    public static void glShaderSource(int shader, CharSequence string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glShaderSource_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglShaderSource(shader, 1, APIUtils.getBuffer(string), 0, string.length(), function_pointer);
    }

    public static void glShaderSource(int shader, CharSequence[] strings) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glShaderSource_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglShaderSource3(shader, strings.length, APIUtils.getBuffer(strings), 0, APIUtils.getLengths(strings), 0, function_pointer);
    }

    private static native void nglShaderSource3(int var0, int var1, ByteBuffer var2, int var3, IntBuffer var4, int var5, long var6);

    public static int glCreateShader(int type) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glCreateShader_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = GL20.nglCreateShader(type, function_pointer);
        return __result;
    }

    private static native int nglCreateShader(int var0, long var1);

    public static boolean glIsShader(int shader) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glIsShader_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = GL20.nglIsShader(shader, function_pointer);
        return __result;
    }

    private static native boolean nglIsShader(int var0, long var1);

    public static void glCompileShader(int shader) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glCompileShader_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglCompileShader(shader, function_pointer);
    }

    private static native void nglCompileShader(int var0, long var1);

    public static void glDeleteShader(int shader) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glDeleteShader_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglDeleteShader(shader, function_pointer);
    }

    private static native void nglDeleteShader(int var0, long var1);

    public static int glCreateProgram() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glCreateProgram_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = GL20.nglCreateProgram(function_pointer);
        return __result;
    }

    private static native int nglCreateProgram(long var0);

    public static boolean glIsProgram(int program) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glIsProgram_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = GL20.nglIsProgram(program, function_pointer);
        return __result;
    }

    private static native boolean nglIsProgram(int var0, long var1);

    public static void glAttachShader(int program, int shader) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glAttachShader_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglAttachShader(program, shader, function_pointer);
    }

    private static native void nglAttachShader(int var0, int var1, long var2);

    public static void glDetachShader(int program, int shader) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glDetachShader_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglDetachShader(program, shader, function_pointer);
    }

    private static native void nglDetachShader(int var0, int var1, long var2);

    public static void glLinkProgram(int program) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glLinkProgram_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglLinkProgram(program, function_pointer);
    }

    private static native void nglLinkProgram(int var0, long var1);

    public static void glUseProgram(int program) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUseProgram_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglUseProgram(program, function_pointer);
    }

    private static native void nglUseProgram(int var0, long var1);

    public static void glValidateProgram(int program) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glValidateProgram_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglValidateProgram(program, function_pointer);
    }

    private static native void nglValidateProgram(int var0, long var1);

    public static void glDeleteProgram(int program) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glDeleteProgram_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglDeleteProgram(program, function_pointer);
    }

    private static native void nglDeleteProgram(int var0, long var1);

    public static void glUniform1f(int location, float v0) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform1f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglUniform1f(location, v0, function_pointer);
    }

    private static native void nglUniform1f(int var0, float var1, long var2);

    public static void glUniform2f(int location, float v0, float v1) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform2f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglUniform2f(location, v0, v1, function_pointer);
    }

    private static native void nglUniform2f(int var0, float var1, float var2, long var3);

    public static void glUniform3f(int location, float v0, float v1, float v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform3f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglUniform3f(location, v0, v1, v2, function_pointer);
    }

    private static native void nglUniform3f(int var0, float var1, float var2, float var3, long var4);

    public static void glUniform4f(int location, float v0, float v1, float v2, float v3) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform4f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglUniform4f(location, v0, v1, v2, v3, function_pointer);
    }

    private static native void nglUniform4f(int var0, float var1, float var2, float var3, float var4, long var5);

    public static void glUniform1i(int location, int v0) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform1i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglUniform1i(location, v0, function_pointer);
    }

    private static native void nglUniform1i(int var0, int var1, long var2);

    public static void glUniform2i(int location, int v0, int v1) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform2i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglUniform2i(location, v0, v1, function_pointer);
    }

    private static native void nglUniform2i(int var0, int var1, int var2, long var3);

    public static void glUniform3i(int location, int v0, int v1, int v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform3i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglUniform3i(location, v0, v1, v2, function_pointer);
    }

    private static native void nglUniform3i(int var0, int var1, int var2, int var3, long var4);

    public static void glUniform4i(int location, int v0, int v1, int v2, int v3) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform4i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglUniform4i(location, v0, v1, v2, v3, function_pointer);
    }

    private static native void nglUniform4i(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glUniform1(int location, FloatBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform1fv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        GL20.nglUniform1fv(location, values.remaining(), values, values.position(), function_pointer);
    }

    private static native void nglUniform1fv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glUniform2(int location, FloatBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform2fv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        GL20.nglUniform2fv(location, values.remaining() >> 1, values, values.position(), function_pointer);
    }

    private static native void nglUniform2fv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glUniform3(int location, FloatBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform3fv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        GL20.nglUniform3fv(location, values.remaining() / 3, values, values.position(), function_pointer);
    }

    private static native void nglUniform3fv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glUniform4(int location, FloatBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform4fv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        GL20.nglUniform4fv(location, values.remaining() >> 2, values, values.position(), function_pointer);
    }

    private static native void nglUniform4fv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glUniform1(int location, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform1iv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        GL20.nglUniform1iv(location, values.remaining(), values, values.position(), function_pointer);
    }

    private static native void nglUniform1iv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniform2(int location, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform2iv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        GL20.nglUniform2iv(location, values.remaining() >> 1, values, values.position(), function_pointer);
    }

    private static native void nglUniform2iv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniform3(int location, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform3iv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        GL20.nglUniform3iv(location, values.remaining() / 3, values, values.position(), function_pointer);
    }

    private static native void nglUniform3iv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniform4(int location, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniform4iv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        GL20.nglUniform4iv(location, values.remaining() >> 2, values, values.position(), function_pointer);
    }

    private static native void nglUniform4iv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniformMatrix2(int location, boolean transpose, FloatBuffer matrices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniformMatrix2fv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(matrices);
        GL20.nglUniformMatrix2fv(location, matrices.remaining() >> 2, transpose, matrices, matrices.position(), function_pointer);
    }

    private static native void nglUniformMatrix2fv(int var0, int var1, boolean var2, FloatBuffer var3, int var4, long var5);

    public static void glUniformMatrix3(int location, boolean transpose, FloatBuffer matrices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniformMatrix3fv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(matrices);
        GL20.nglUniformMatrix3fv(location, matrices.remaining() / 9, transpose, matrices, matrices.position(), function_pointer);
    }

    private static native void nglUniformMatrix3fv(int var0, int var1, boolean var2, FloatBuffer var3, int var4, long var5);

    public static void glUniformMatrix4(int location, boolean transpose, FloatBuffer matrices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glUniformMatrix4fv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(matrices);
        GL20.nglUniformMatrix4fv(location, matrices.remaining() >> 4, transpose, matrices, matrices.position(), function_pointer);
    }

    private static native void nglUniformMatrix4fv(int var0, int var1, boolean var2, FloatBuffer var3, int var4, long var5);

    public static void glGetShader(int shader, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetShaderiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        GL20.nglGetShaderiv(shader, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetShaderiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetShader(int shader, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetShaderiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL20.nglGetShaderiv(shader, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetProgram(int program, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetProgramiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        GL20.nglGetProgramiv(program, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetProgramiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetProgram(int program, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetProgramiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL20.nglGetProgramiv(program, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetShaderInfoLog(int shader, IntBuffer length, ByteBuffer infoLog) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetShaderInfoLog_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(infoLog);
        GL20.nglGetShaderInfoLog(shader, infoLog.remaining(), length, length != null ? length.position() : 0, infoLog, infoLog.position(), function_pointer);
    }

    private static native void nglGetShaderInfoLog(int var0, int var1, IntBuffer var2, int var3, ByteBuffer var4, int var5, long var6);

    public static String glGetShaderInfoLog(int shader, int maxLength) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetShaderInfoLog_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer infoLog_length = APIUtils.getLengths();
        ByteBuffer infoLog = APIUtils.getBufferByte(maxLength);
        GL20.nglGetShaderInfoLog(shader, maxLength, infoLog_length, 0, infoLog, infoLog.position(), function_pointer);
        infoLog.limit(infoLog_length.get(0));
        return APIUtils.getString(infoLog);
    }

    public static void glGetProgramInfoLog(int program, IntBuffer length, ByteBuffer infoLog) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetProgramInfoLog_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(infoLog);
        GL20.nglGetProgramInfoLog(program, infoLog.remaining(), length, length != null ? length.position() : 0, infoLog, infoLog.position(), function_pointer);
    }

    private static native void nglGetProgramInfoLog(int var0, int var1, IntBuffer var2, int var3, ByteBuffer var4, int var5, long var6);

    public static String glGetProgramInfoLog(int program, int maxLength) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetProgramInfoLog_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer infoLog_length = APIUtils.getLengths();
        ByteBuffer infoLog = APIUtils.getBufferByte(maxLength);
        GL20.nglGetProgramInfoLog(program, maxLength, infoLog_length, 0, infoLog, infoLog.position(), function_pointer);
        infoLog.limit(infoLog_length.get(0));
        return APIUtils.getString(infoLog);
    }

    public static void glGetAttachedShaders(int program, IntBuffer count, IntBuffer shaders) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetAttachedShaders_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (count != null) {
            BufferChecks.checkBuffer(count, 1);
        }
        BufferChecks.checkDirect(shaders);
        GL20.nglGetAttachedShaders(program, shaders.remaining(), count, count != null ? count.position() : 0, shaders, shaders.position(), function_pointer);
    }

    private static native void nglGetAttachedShaders(int var0, int var1, IntBuffer var2, int var3, IntBuffer var4, int var5, long var6);

    public static int glGetUniformLocation(int program, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetUniformLocation_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(name, 1);
        BufferChecks.checkNullTerminated(name);
        int __result = GL20.nglGetUniformLocation(program, name, name.position(), function_pointer);
        return __result;
    }

    private static native int nglGetUniformLocation(int var0, ByteBuffer var1, int var2, long var3);

    public static int glGetUniformLocation(int program, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetUniformLocation_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = GL20.nglGetUniformLocation(program, APIUtils.getBufferNT(name), 0, function_pointer);
        return __result;
    }

    public static void glGetActiveUniform(int program, int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetActiveUniform_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkBuffer(size, 1);
        BufferChecks.checkBuffer(type, 1);
        BufferChecks.checkDirect(name);
        GL20.nglGetActiveUniform(program, index, name.remaining(), length, length != null ? length.position() : 0, size, size.position(), type, type.position(), name, name.position(), function_pointer);
    }

    private static native void nglGetActiveUniform(int var0, int var1, int var2, IntBuffer var3, int var4, IntBuffer var5, int var6, IntBuffer var7, int var8, ByteBuffer var9, int var10, long var11);

    public static String glGetActiveUniform(int program, int index, int maxLength, IntBuffer sizeType) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetActiveUniform_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(sizeType, 2);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(maxLength);
        GL20.nglGetActiveUniform(program, index, maxLength, name_length, 0, sizeType, sizeType.position(), sizeType, sizeType.position() + 1, name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static String glGetActiveUniform(int program, int index, int maxLength) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetActiveUniform_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(maxLength);
        GL20.nglGetActiveUniform(program, index, maxLength, name_length, 0, APIUtils.getBufferInt(), 0, APIUtils.getBufferInt(), 1, name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static int glGetActiveUniformSize(int program, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetActiveUniform_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer size = APIUtils.getBufferInt();
        GL20.nglGetActiveUniform(program, index, 0, null, 0, size, size.position(), size, 1, APIUtils.getBufferByte(0), 0, function_pointer);
        return size.get(0);
    }

    public static int glGetActiveUniformType(int program, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetActiveUniform_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer type = APIUtils.getBufferInt();
        GL20.nglGetActiveUniform(program, index, 0, null, 0, type, 1, type, type.position(), APIUtils.getBufferByte(0), 0, function_pointer);
        return type.get(0);
    }

    public static void glGetUniform(int program, int location, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetUniformfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        GL20.nglGetUniformfv(program, location, params, params.position(), function_pointer);
    }

    private static native void nglGetUniformfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glGetUniform(int program, int location, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetUniformiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        GL20.nglGetUniformiv(program, location, params, params.position(), function_pointer);
    }

    private static native void nglGetUniformiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetShaderSource(int shader, IntBuffer length, ByteBuffer source) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetShaderSource_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(source);
        GL20.nglGetShaderSource(shader, source.remaining(), length, length != null ? length.position() : 0, source, source.position(), function_pointer);
    }

    private static native void nglGetShaderSource(int var0, int var1, IntBuffer var2, int var3, ByteBuffer var4, int var5, long var6);

    public static String glGetShaderSource(int shader, int maxLength) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetShaderSource_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer source_length = APIUtils.getLengths();
        ByteBuffer source = APIUtils.getBufferByte(maxLength);
        GL20.nglGetShaderSource(shader, maxLength, source_length, 0, source, source.position(), function_pointer);
        source.limit(source_length.get(0));
        return APIUtils.getString(source);
    }

    public static void glVertexAttrib1s(int index, short x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttrib1s_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglVertexAttrib1s(index, x2, function_pointer);
    }

    private static native void nglVertexAttrib1s(int var0, short var1, long var2);

    public static void glVertexAttrib1f(int index, float x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttrib1f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglVertexAttrib1f(index, x2, function_pointer);
    }

    private static native void nglVertexAttrib1f(int var0, float var1, long var2);

    public static void glVertexAttrib1d(int index, double x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttrib1d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglVertexAttrib1d(index, x2, function_pointer);
    }

    private static native void nglVertexAttrib1d(int var0, double var1, long var3);

    public static void glVertexAttrib2s(int index, short x2, short y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttrib2s_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglVertexAttrib2s(index, x2, y2, function_pointer);
    }

    private static native void nglVertexAttrib2s(int var0, short var1, short var2, long var3);

    public static void glVertexAttrib2f(int index, float x2, float y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttrib2f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglVertexAttrib2f(index, x2, y2, function_pointer);
    }

    private static native void nglVertexAttrib2f(int var0, float var1, float var2, long var3);

    public static void glVertexAttrib2d(int index, double x2, double y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttrib2d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglVertexAttrib2d(index, x2, y2, function_pointer);
    }

    private static native void nglVertexAttrib2d(int var0, double var1, double var3, long var5);

    public static void glVertexAttrib3s(int index, short x2, short y2, short z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttrib3s_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglVertexAttrib3s(index, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexAttrib3s(int var0, short var1, short var2, short var3, long var4);

    public static void glVertexAttrib3f(int index, float x2, float y2, float z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttrib3f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglVertexAttrib3f(index, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexAttrib3f(int var0, float var1, float var2, float var3, long var4);

    public static void glVertexAttrib3d(int index, double x2, double y2, double z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttrib3d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglVertexAttrib3d(index, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexAttrib3d(int var0, double var1, double var3, double var5, long var7);

    public static void glVertexAttrib4s(int index, short x2, short y2, short z2, short w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttrib4s_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglVertexAttrib4s(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttrib4s(int var0, short var1, short var2, short var3, short var4, long var5);

    public static void glVertexAttrib4f(int index, float x2, float y2, float z2, float w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttrib4f_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglVertexAttrib4f(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttrib4f(int var0, float var1, float var2, float var3, float var4, long var5);

    public static void glVertexAttrib4d(int index, double x2, double y2, double z2, double w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttrib4d_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglVertexAttrib4d(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttrib4d(int var0, double var1, double var3, double var5, double var7, long var9);

    public static void glVertexAttrib4Nub(int index, byte x2, byte y2, byte z2, byte w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttrib4Nub_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglVertexAttrib4Nub(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttrib4Nub(int var0, byte var1, byte var2, byte var3, byte var4, long var5);

    public static void glVertexAttribPointer(int index, int size, boolean normalized, int stride, DoubleBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttribPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        GL20.nglVertexAttribPointer(index, size, 5130, normalized, stride, buffer, buffer.position() << 3, function_pointer);
    }

    public static void glVertexAttribPointer(int index, int size, boolean normalized, int stride, FloatBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttribPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        GL20.nglVertexAttribPointer(index, size, 5126, normalized, stride, buffer, buffer.position() << 2, function_pointer);
    }

    public static void glVertexAttribPointer(int index, int size, boolean unsigned, boolean normalized, int stride, ByteBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttribPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        GL20.nglVertexAttribPointer(index, size, unsigned ? 5121 : 5120, normalized, stride, buffer, buffer.position(), function_pointer);
    }

    public static void glVertexAttribPointer(int index, int size, boolean unsigned, boolean normalized, int stride, IntBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttribPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        GL20.nglVertexAttribPointer(index, size, unsigned ? 5125 : 5124, normalized, stride, buffer, buffer.position() << 2, function_pointer);
    }

    public static void glVertexAttribPointer(int index, int size, boolean unsigned, boolean normalized, int stride, ShortBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttribPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        GL20.nglVertexAttribPointer(index, size, unsigned ? 5123 : 5122, normalized, stride, buffer, buffer.position() << 1, function_pointer);
    }

    private static native void nglVertexAttribPointer(int var0, int var1, int var2, boolean var3, int var4, Buffer var5, int var6, long var7);

    public static void glVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, long buffer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glVertexAttribPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        GL20.nglVertexAttribPointerBO(index, size, type, normalized, stride, buffer_buffer_offset, function_pointer);
    }

    private static native void nglVertexAttribPointerBO(int var0, int var1, int var2, boolean var3, int var4, long var5, long var7);

    public static void glEnableVertexAttribArray(int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glEnableVertexAttribArray_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglEnableVertexAttribArray(index, function_pointer);
    }

    private static native void nglEnableVertexAttribArray(int var0, long var1);

    public static void glDisableVertexAttribArray(int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glDisableVertexAttribArray_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglDisableVertexAttribArray(index, function_pointer);
    }

    private static native void nglDisableVertexAttribArray(int var0, long var1);

    public static void glGetVertexAttrib(int index, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetVertexAttribfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL20.nglGetVertexAttribfv(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glGetVertexAttrib(int index, int pname, DoubleBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetVertexAttribdv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL20.nglGetVertexAttribdv(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribdv(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glGetVertexAttrib(int index, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetVertexAttribiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL20.nglGetVertexAttribiv(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static ByteBuffer glGetVertexAttribPointer(int index, int pname, long result_size) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetVertexAttribPointerv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ByteBuffer __result = GL20.nglGetVertexAttribPointerv(index, pname, result_size, function_pointer);
        return __result;
    }

    private static native ByteBuffer nglGetVertexAttribPointerv(int var0, int var1, long var2, long var4);

    public static void glBindAttribLocation(int program, int index, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glBindAttribLocation_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        GL20.nglBindAttribLocation(program, index, name, name.position(), function_pointer);
    }

    private static native void nglBindAttribLocation(int var0, int var1, ByteBuffer var2, int var3, long var4);

    public static void glBindAttribLocation(int program, int index, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glBindAttribLocation_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglBindAttribLocation(program, index, APIUtils.getBufferNT(name), 0, function_pointer);
    }

    public static void glGetActiveAttrib(int program, int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetActiveAttrib_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkBuffer(size, 1);
        BufferChecks.checkBuffer(type, 1);
        BufferChecks.checkDirect(name);
        GL20.nglGetActiveAttrib(program, index, name.remaining(), length, length != null ? length.position() : 0, size, size.position(), type, type.position(), name, name.position(), function_pointer);
    }

    private static native void nglGetActiveAttrib(int var0, int var1, int var2, IntBuffer var3, int var4, IntBuffer var5, int var6, IntBuffer var7, int var8, ByteBuffer var9, int var10, long var11);

    public static String glGetActiveAttrib(int program, int index, int maxLength, IntBuffer sizeType) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetActiveAttrib_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(sizeType, 2);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(maxLength);
        GL20.nglGetActiveAttrib(program, index, maxLength, name_length, 0, sizeType, sizeType.position(), sizeType, sizeType.position() + 1, name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static String glGetActiveAttrib(int program, int index, int maxLength) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetActiveAttrib_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(maxLength);
        GL20.nglGetActiveAttrib(program, index, maxLength, name_length, 0, APIUtils.getBufferInt(), 0, APIUtils.getBufferInt(), 1, name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static int glGetActiveAttribSize(int program, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetActiveAttrib_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer size = APIUtils.getBufferInt();
        GL20.nglGetActiveAttrib(program, index, 0, null, 0, size, size.position(), size, 1, APIUtils.getBufferByte(0), 0, function_pointer);
        return size.get(0);
    }

    public static int glGetActiveAttribType(int program, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetActiveAttrib_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer type = APIUtils.getBufferInt();
        GL20.nglGetActiveAttrib(program, index, 0, null, 0, type, 1, type, type.position(), APIUtils.getBufferByte(0), 0, function_pointer);
        return type.get(0);
    }

    public static int glGetAttribLocation(int program, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetAttribLocation_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        int __result = GL20.nglGetAttribLocation(program, name, name.position(), function_pointer);
        return __result;
    }

    private static native int nglGetAttribLocation(int var0, ByteBuffer var1, int var2, long var3);

    public static int glGetAttribLocation(int program, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glGetAttribLocation_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = GL20.nglGetAttribLocation(program, APIUtils.getBufferNT(name), 0, function_pointer);
        return __result;
    }

    public static void glDrawBuffers(IntBuffer buffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glDrawBuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(buffers);
        GL20.nglDrawBuffers(buffers.remaining(), buffers, buffers.position(), function_pointer);
    }

    private static native void nglDrawBuffers(int var0, IntBuffer var1, int var2, long var3);

    public static void glDrawBuffers(int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glDrawBuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglDrawBuffers(1, APIUtils.getBufferInt().put(0, buffer), 0, function_pointer);
    }

    public static void glStencilOpSeparate(int face, int sfail, int dpfail, int dppass) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glStencilOpSeparate_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglStencilOpSeparate(face, sfail, dpfail, dppass, function_pointer);
    }

    private static native void nglStencilOpSeparate(int var0, int var1, int var2, int var3, long var4);

    public static void glStencilFuncSeparate(int face, int func, int ref, int mask) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glStencilFuncSeparate_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglStencilFuncSeparate(face, func, ref, mask, function_pointer);
    }

    private static native void nglStencilFuncSeparate(int var0, int var1, int var2, int var3, long var4);

    public static void glStencilMaskSeparate(int face, int mask) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glStencilMaskSeparate_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglStencilMaskSeparate(face, mask, function_pointer);
    }

    private static native void nglStencilMaskSeparate(int var0, int var1, long var2);

    public static void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL20_glBlendEquationSeparate_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL20.nglBlendEquationSeparate(modeRGB, modeAlpha, function_pointer);
    }

    private static native void nglBlendEquationSeparate(int var0, int var1, long var2);
}

