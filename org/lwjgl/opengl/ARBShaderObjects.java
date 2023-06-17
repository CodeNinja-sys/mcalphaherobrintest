/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBShaderObjects {
    public static final int GL_PROGRAM_OBJECT_ARB = 35648;
    public static final int GL_OBJECT_TYPE_ARB = 35662;
    public static final int GL_OBJECT_SUBTYPE_ARB = 35663;
    public static final int GL_OBJECT_DELETE_STATUS_ARB = 35712;
    public static final int GL_OBJECT_COMPILE_STATUS_ARB = 35713;
    public static final int GL_OBJECT_LINK_STATUS_ARB = 35714;
    public static final int GL_OBJECT_VALIDATE_STATUS_ARB = 35715;
    public static final int GL_OBJECT_INFO_LOG_LENGTH_ARB = 35716;
    public static final int GL_OBJECT_ATTACHED_OBJECTS_ARB = 35717;
    public static final int GL_OBJECT_ACTIVE_UNIFORMS_ARB = 35718;
    public static final int GL_OBJECT_ACTIVE_UNIFORM_MAX_LENGTH_ARB = 35719;
    public static final int GL_OBJECT_SHADER_SOURCE_LENGTH_ARB = 35720;
    public static final int GL_SHADER_OBJECT_ARB = 35656;
    public static final int GL_FLOAT = 5126;
    public static final int GL_FLOAT_VEC2_ARB = 35664;
    public static final int GL_FLOAT_VEC3_ARB = 35665;
    public static final int GL_FLOAT_VEC4_ARB = 35666;
    public static final int GL_INT = 5124;
    public static final int GL_INT_VEC2_ARB = 35667;
    public static final int GL_INT_VEC3_ARB = 35668;
    public static final int GL_INT_VEC4_ARB = 35669;
    public static final int GL_BOOL_ARB = 35670;
    public static final int GL_BOOL_VEC2_ARB = 35671;
    public static final int GL_BOOL_VEC3_ARB = 35672;
    public static final int GL_BOOL_VEC4_ARB = 35673;
    public static final int GL_FLOAT_MAT2_ARB = 35674;
    public static final int GL_FLOAT_MAT3_ARB = 35675;
    public static final int GL_FLOAT_MAT4_ARB = 35676;
    public static final int GL_SAMPLER_1D_ARB = 35677;
    public static final int GL_SAMPLER_2D_ARB = 35678;
    public static final int GL_SAMPLER_3D_ARB = 35679;
    public static final int GL_SAMPLER_CUBE_ARB = 35680;
    public static final int GL_SAMPLER_1D_SHADOW_ARB = 35681;
    public static final int GL_SAMPLER_2D_SHADOW_ARB = 35682;
    public static final int GL_SAMPLER_2D_RECT_ARB = 35683;
    public static final int GL_SAMPLER_2D_RECT_SHADOW_ARB = 35684;

    private ARBShaderObjects() {
    }

    public static void glDeleteObjectARB(int obj) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glDeleteObjectARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglDeleteObjectARB(obj, function_pointer);
    }

    private static native void nglDeleteObjectARB(int var0, long var1);

    public static int glGetHandleARB(int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetHandleARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = ARBShaderObjects.nglGetHandleARB(pname, function_pointer);
        return __result;
    }

    private static native int nglGetHandleARB(int var0, long var1);

    public static void glDetachObjectARB(int containerObj, int attachedObj) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glDetachObjectARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglDetachObjectARB(containerObj, attachedObj, function_pointer);
    }

    private static native void nglDetachObjectARB(int var0, int var1, long var2);

    public static int glCreateShaderObjectARB(int shaderType) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glCreateShaderObjectARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = ARBShaderObjects.nglCreateShaderObjectARB(shaderType, function_pointer);
        return __result;
    }

    private static native int nglCreateShaderObjectARB(int var0, long var1);

    public static void glShaderSourceARB(int shader, ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glShaderSourceARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(string);
        ARBShaderObjects.nglShaderSourceARB(shader, 1, string, string.position(), string.remaining(), function_pointer);
    }

    private static native void nglShaderSourceARB(int var0, int var1, ByteBuffer var2, int var3, int var4, long var5);

    public static void glShaderSourceARB(int shader, CharSequence string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glShaderSourceARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglShaderSourceARB(shader, 1, APIUtils.getBuffer(string), 0, string.length(), function_pointer);
    }

    public static void glShaderSourceARB(int shader, CharSequence[] strings) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glShaderSourceARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglShaderSourceARB3(shader, strings.length, APIUtils.getBuffer(strings), 0, APIUtils.getLengths(strings), 0, function_pointer);
    }

    private static native void nglShaderSourceARB3(int var0, int var1, ByteBuffer var2, int var3, IntBuffer var4, int var5, long var6);

    public static void glCompileShaderARB(int shaderObj) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glCompileShaderARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglCompileShaderARB(shaderObj, function_pointer);
    }

    private static native void nglCompileShaderARB(int var0, long var1);

    public static int glCreateProgramObjectARB() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glCreateProgramObjectARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = ARBShaderObjects.nglCreateProgramObjectARB(function_pointer);
        return __result;
    }

    private static native int nglCreateProgramObjectARB(long var0);

    public static void glAttachObjectARB(int containerObj, int obj) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glAttachObjectARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglAttachObjectARB(containerObj, obj, function_pointer);
    }

    private static native void nglAttachObjectARB(int var0, int var1, long var2);

    public static void glLinkProgramARB(int programObj) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glLinkProgramARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglLinkProgramARB(programObj, function_pointer);
    }

    private static native void nglLinkProgramARB(int var0, long var1);

    public static void glUseProgramObjectARB(int programObj) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUseProgramObjectARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglUseProgramObjectARB(programObj, function_pointer);
    }

    private static native void nglUseProgramObjectARB(int var0, long var1);

    public static void glValidateProgramARB(int programObj) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glValidateProgramARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglValidateProgramARB(programObj, function_pointer);
    }

    private static native void nglValidateProgramARB(int var0, long var1);

    public static void glUniform1fARB(int location, float v0) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform1fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglUniform1fARB(location, v0, function_pointer);
    }

    private static native void nglUniform1fARB(int var0, float var1, long var2);

    public static void glUniform2fARB(int location, float v0, float v1) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform2fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglUniform2fARB(location, v0, v1, function_pointer);
    }

    private static native void nglUniform2fARB(int var0, float var1, float var2, long var3);

    public static void glUniform3fARB(int location, float v0, float v1, float v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform3fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglUniform3fARB(location, v0, v1, v2, function_pointer);
    }

    private static native void nglUniform3fARB(int var0, float var1, float var2, float var3, long var4);

    public static void glUniform4fARB(int location, float v0, float v1, float v2, float v3) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform4fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglUniform4fARB(location, v0, v1, v2, v3, function_pointer);
    }

    private static native void nglUniform4fARB(int var0, float var1, float var2, float var3, float var4, long var5);

    public static void glUniform1iARB(int location, int v0) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform1iARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglUniform1iARB(location, v0, function_pointer);
    }

    private static native void nglUniform1iARB(int var0, int var1, long var2);

    public static void glUniform2iARB(int location, int v0, int v1) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform2iARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglUniform2iARB(location, v0, v1, function_pointer);
    }

    private static native void nglUniform2iARB(int var0, int var1, int var2, long var3);

    public static void glUniform3iARB(int location, int v0, int v1, int v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform3iARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglUniform3iARB(location, v0, v1, v2, function_pointer);
    }

    private static native void nglUniform3iARB(int var0, int var1, int var2, int var3, long var4);

    public static void glUniform4iARB(int location, int v0, int v1, int v2, int v3) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform4iARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShaderObjects.nglUniform4iARB(location, v0, v1, v2, v3, function_pointer);
    }

    private static native void nglUniform4iARB(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glUniform1ARB(int location, FloatBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform1fvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        ARBShaderObjects.nglUniform1fvARB(location, values.remaining(), values, values.position(), function_pointer);
    }

    private static native void nglUniform1fvARB(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glUniform2ARB(int location, FloatBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform2fvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        ARBShaderObjects.nglUniform2fvARB(location, values.remaining() >> 1, values, values.position(), function_pointer);
    }

    private static native void nglUniform2fvARB(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glUniform3ARB(int location, FloatBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform3fvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        ARBShaderObjects.nglUniform3fvARB(location, values.remaining() / 3, values, values.position(), function_pointer);
    }

    private static native void nglUniform3fvARB(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glUniform4ARB(int location, FloatBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform4fvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        ARBShaderObjects.nglUniform4fvARB(location, values.remaining() >> 2, values, values.position(), function_pointer);
    }

    private static native void nglUniform4fvARB(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glUniform1ARB(int location, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform1ivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        ARBShaderObjects.nglUniform1ivARB(location, values.remaining(), values, values.position(), function_pointer);
    }

    private static native void nglUniform1ivARB(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniform2ARB(int location, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform2ivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        ARBShaderObjects.nglUniform2ivARB(location, values.remaining() >> 1, values, values.position(), function_pointer);
    }

    private static native void nglUniform2ivARB(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniform3ARB(int location, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform3ivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        ARBShaderObjects.nglUniform3ivARB(location, values.remaining() / 3, values, values.position(), function_pointer);
    }

    private static native void nglUniform3ivARB(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniform4ARB(int location, IntBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniform4ivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(values);
        ARBShaderObjects.nglUniform4ivARB(location, values.remaining() >> 2, values, values.position(), function_pointer);
    }

    private static native void nglUniform4ivARB(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniformMatrix2ARB(int location, boolean transpose, FloatBuffer matrices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniformMatrix2fvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(matrices);
        ARBShaderObjects.nglUniformMatrix2fvARB(location, matrices.remaining() >> 2, transpose, matrices, matrices.position(), function_pointer);
    }

    private static native void nglUniformMatrix2fvARB(int var0, int var1, boolean var2, FloatBuffer var3, int var4, long var5);

    public static void glUniformMatrix3ARB(int location, boolean transpose, FloatBuffer matrices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniformMatrix3fvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(matrices);
        ARBShaderObjects.nglUniformMatrix3fvARB(location, matrices.remaining() / 9, transpose, matrices, matrices.position(), function_pointer);
    }

    private static native void nglUniformMatrix3fvARB(int var0, int var1, boolean var2, FloatBuffer var3, int var4, long var5);

    public static void glUniformMatrix4ARB(int location, boolean transpose, FloatBuffer matrices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glUniformMatrix4fvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(matrices);
        ARBShaderObjects.nglUniformMatrix4fvARB(location, matrices.remaining() >> 4, transpose, matrices, matrices.position(), function_pointer);
    }

    private static native void nglUniformMatrix4fvARB(int var0, int var1, boolean var2, FloatBuffer var3, int var4, long var5);

    public static void glGetObjectParameterARB(int obj, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetObjectParameterfvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        ARBShaderObjects.nglGetObjectParameterfvARB(obj, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetObjectParameterfvARB(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static float glGetObjectParameterfARB(int obj, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetObjectParameterfvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        FloatBuffer params = APIUtils.getBufferFloat();
        ARBShaderObjects.nglGetObjectParameterfvARB(obj, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetObjectParameterARB(int obj, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetObjectParameterivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        ARBShaderObjects.nglGetObjectParameterivARB(obj, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetObjectParameterivARB(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetObjectParameteriARB(int obj, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetObjectParameterivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBShaderObjects.nglGetObjectParameterivARB(obj, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetInfoLogARB(int obj, IntBuffer length, ByteBuffer infoLog) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetInfoLogARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(infoLog);
        ARBShaderObjects.nglGetInfoLogARB(obj, infoLog.remaining(), length, length != null ? length.position() : 0, infoLog, infoLog.position(), function_pointer);
    }

    private static native void nglGetInfoLogARB(int var0, int var1, IntBuffer var2, int var3, ByteBuffer var4, int var5, long var6);

    public static String glGetInfoLogARB(int obj, int maxLength) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetInfoLogARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer infoLog_length = APIUtils.getLengths();
        ByteBuffer infoLog = APIUtils.getBufferByte(maxLength);
        ARBShaderObjects.nglGetInfoLogARB(obj, maxLength, infoLog_length, 0, infoLog, infoLog.position(), function_pointer);
        infoLog.limit(infoLog_length.get(0));
        return APIUtils.getString(infoLog);
    }

    public static void glGetAttachedObjectsARB(int containerObj, IntBuffer count, IntBuffer obj) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetAttachedObjectsARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (count != null) {
            BufferChecks.checkBuffer(count, 1);
        }
        BufferChecks.checkDirect(obj);
        ARBShaderObjects.nglGetAttachedObjectsARB(containerObj, obj.remaining(), count, count != null ? count.position() : 0, obj, obj.position(), function_pointer);
    }

    private static native void nglGetAttachedObjectsARB(int var0, int var1, IntBuffer var2, int var3, IntBuffer var4, int var5, long var6);

    public static int glGetUniformLocationARB(int programObj, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetUniformLocationARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        int __result = ARBShaderObjects.nglGetUniformLocationARB(programObj, name, name.position(), function_pointer);
        return __result;
    }

    private static native int nglGetUniformLocationARB(int var0, ByteBuffer var1, int var2, long var3);

    public static int glGetUniformLocationARB(int programObj, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetUniformLocationARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = ARBShaderObjects.nglGetUniformLocationARB(programObj, APIUtils.getBufferNT(name), 0, function_pointer);
        return __result;
    }

    public static void glGetActiveUniformARB(int programObj, int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetActiveUniformARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkBuffer(size, 1);
        BufferChecks.checkBuffer(type, 1);
        BufferChecks.checkDirect(name);
        ARBShaderObjects.nglGetActiveUniformARB(programObj, index, name.remaining(), length, length != null ? length.position() : 0, size, size.position(), type, type.position(), name, name.position(), function_pointer);
    }

    private static native void nglGetActiveUniformARB(int var0, int var1, int var2, IntBuffer var3, int var4, IntBuffer var5, int var6, IntBuffer var7, int var8, ByteBuffer var9, int var10, long var11);

    public static String glGetActiveUniformARB(int programObj, int index, int maxLength, IntBuffer sizeType) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetActiveUniformARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(sizeType, 2);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(maxLength);
        ARBShaderObjects.nglGetActiveUniformARB(programObj, index, maxLength, name_length, 0, sizeType, sizeType.position(), sizeType, sizeType.position() + 1, name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static String glGetActiveUniformARB(int programObj, int index, int maxLength) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetActiveUniformARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(maxLength);
        ARBShaderObjects.nglGetActiveUniformARB(programObj, index, maxLength, name_length, 0, APIUtils.getBufferInt(), 0, APIUtils.getBufferInt(), 1, name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static int glGetActiveUniformSizeARB(int programObj, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetActiveUniformARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer size = APIUtils.getBufferInt();
        ARBShaderObjects.nglGetActiveUniformARB(programObj, index, 0, null, 0, size, size.position(), size, 1, APIUtils.getBufferByte(0), 0, function_pointer);
        return size.get(0);
    }

    public static int glGetActiveUniformTypeARB(int programObj, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetActiveUniformARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer type = APIUtils.getBufferInt();
        ARBShaderObjects.nglGetActiveUniformARB(programObj, index, 0, null, 0, type, 1, type, type.position(), APIUtils.getBufferByte(0), 0, function_pointer);
        return type.get(0);
    }

    public static void glGetUniformARB(int programObj, int location, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetUniformfvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        ARBShaderObjects.nglGetUniformfvARB(programObj, location, params, params.position(), function_pointer);
    }

    private static native void nglGetUniformfvARB(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glGetUniformARB(int programObj, int location, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetUniformivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        ARBShaderObjects.nglGetUniformivARB(programObj, location, params, params.position(), function_pointer);
    }

    private static native void nglGetUniformivARB(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetShaderSourceARB(int obj, IntBuffer length, ByteBuffer source) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetShaderSourceARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(source);
        ARBShaderObjects.nglGetShaderSourceARB(obj, source.remaining(), length, length != null ? length.position() : 0, source, source.position(), function_pointer);
    }

    private static native void nglGetShaderSourceARB(int var0, int var1, IntBuffer var2, int var3, ByteBuffer var4, int var5, long var6);

    public static String glGetShaderSourceARB(int obj, int maxLength) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shader_objects_glGetShaderSourceARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer source_length = APIUtils.getLengths();
        ByteBuffer source = APIUtils.getBufferByte(maxLength);
        ARBShaderObjects.nglGetShaderSourceARB(obj, maxLength, source_length, 0, source, source.position(), function_pointer);
        source.limit(source_length.get(0));
        return APIUtils.getString(source);
    }
}

