/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;

public final class EXTGpuShader4 {
    public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER_EXT = 35069;
    public static final int GL_SAMPLER_1D_ARRAY_EXT = 36288;
    public static final int GL_SAMPLER_2D_ARRAY_EXT = 36289;
    public static final int GL_SAMPLER_BUFFER_EXT = 36290;
    public static final int GL_SAMPLER_1D_ARRAY_SHADOW_EXT = 36291;
    public static final int GL_SAMPLER_2D_ARRAY_SHADOW_EXT = 36292;
    public static final int GL_SAMPLER_CUBE_SHADOW_EXT = 36293;
    public static final int GL_UNSIGNED_INT = 5125;
    public static final int GL_UNSIGNED_INT_VEC2_EXT = 36294;
    public static final int GL_UNSIGNED_INT_VEC3_EXT = 36295;
    public static final int GL_UNSIGNED_INT_VEC4_EXT = 36296;
    public static final int GL_INT_SAMPLER_1D_EXT = 36297;
    public static final int GL_INT_SAMPLER_2D_EXT = 36298;
    public static final int GL_INT_SAMPLER_3D_EXT = 36299;
    public static final int GL_INT_SAMPLER_CUBE_EXT = 36300;
    public static final int GL_INT_SAMPLER_2D_RECT_EXT = 36301;
    public static final int GL_INT_SAMPLER_1D_ARRAY_EXT = 36302;
    public static final int GL_INT_SAMPLER_2D_ARRAY_EXT = 36303;
    public static final int GL_INT_SAMPLER_BUFFER_EXT = 36304;
    public static final int GL_UNSIGNED_INT_SAMPLER_1D_EXT = 36305;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_EXT = 36306;
    public static final int GL_UNSIGNED_INT_SAMPLER_3D_EXT = 36307;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_EXT = 36308;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT_EXT = 36309;
    public static final int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY_EXT = 36310;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY_EXT = 36311;
    public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER_EXT = 36312;
    public static final int GL_MIN_PROGRAM_TEXEL_OFFSET_EXT = 35076;
    public static final int GL_MAX_PROGRAM_TEXEL_OFFSET_EXT = 35077;

    private EXTGpuShader4() {
    }

    public static void glVertexAttribI1iEXT(int index, int x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI1iEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTGpuShader4.nglVertexAttribI1iEXT(index, x2, function_pointer);
    }

    private static native void nglVertexAttribI1iEXT(int var0, int var1, long var2);

    public static void glVertexAttribI2iEXT(int index, int x2, int y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI2iEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTGpuShader4.nglVertexAttribI2iEXT(index, x2, y2, function_pointer);
    }

    private static native void nglVertexAttribI2iEXT(int var0, int var1, int var2, long var3);

    public static void glVertexAttribI3iEXT(int index, int x2, int y2, int z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI3iEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTGpuShader4.nglVertexAttribI3iEXT(index, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexAttribI3iEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glVertexAttribI4iEXT(int index, int x2, int y2, int z2, int w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI4iEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTGpuShader4.nglVertexAttribI4iEXT(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttribI4iEXT(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glVertexAttribI1uiEXT(int index, int x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI1uiEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTGpuShader4.nglVertexAttribI1uiEXT(index, x2, function_pointer);
    }

    private static native void nglVertexAttribI1uiEXT(int var0, int var1, long var2);

    public static void glVertexAttribI2uiEXT(int index, int x2, int y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI2uiEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTGpuShader4.nglVertexAttribI2uiEXT(index, x2, y2, function_pointer);
    }

    private static native void nglVertexAttribI2uiEXT(int var0, int var1, int var2, long var3);

    public static void glVertexAttribI3uiEXT(int index, int x2, int y2, int z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI3uiEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTGpuShader4.nglVertexAttribI3uiEXT(index, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexAttribI3uiEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glVertexAttribI4uiEXT(int index, int x2, int y2, int z2, int w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI4uiEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTGpuShader4.nglVertexAttribI4uiEXT(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttribI4uiEXT(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glVertexAttribI1EXT(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI1ivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 1);
        EXTGpuShader4.nglVertexAttribI1ivEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI1ivEXT(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI2EXT(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI2ivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 2);
        EXTGpuShader4.nglVertexAttribI2ivEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI2ivEXT(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI3EXT(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI3ivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 3);
        EXTGpuShader4.nglVertexAttribI3ivEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI3ivEXT(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI4EXT(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI4ivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        EXTGpuShader4.nglVertexAttribI4ivEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI4ivEXT(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI1uEXT(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI1uivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 1);
        EXTGpuShader4.nglVertexAttribI1uivEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI1uivEXT(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI2uEXT(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI2uivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 2);
        EXTGpuShader4.nglVertexAttribI2uivEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI2uivEXT(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI3uEXT(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI3uivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 3);
        EXTGpuShader4.nglVertexAttribI3uivEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI3uivEXT(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI4uEXT(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI4uivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        EXTGpuShader4.nglVertexAttribI4uivEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI4uivEXT(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI4EXT(int index, ByteBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI4bvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        EXTGpuShader4.nglVertexAttribI4bvEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI4bvEXT(int var0, ByteBuffer var1, int var2, long var3);

    public static void glVertexAttribI4EXT(int index, ShortBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI4svEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        EXTGpuShader4.nglVertexAttribI4svEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI4svEXT(int var0, ShortBuffer var1, int var2, long var3);

    public static void glVertexAttribI4uEXT(int index, ByteBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI4ubvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        EXTGpuShader4.nglVertexAttribI4ubvEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI4ubvEXT(int var0, ByteBuffer var1, int var2, long var3);

    public static void glVertexAttribI4uEXT(int index, ShortBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribI4usvEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        EXTGpuShader4.nglVertexAttribI4usvEXT(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI4usvEXT(int var0, ShortBuffer var1, int var2, long var3);

    public static void glVertexAttribIPointerEXT(int index, int size, int type, int stride, ByteBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribIPointerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).EXT_gpu_shader4_glVertexAttribIPointerEXT_buffer = buffer;
        EXTGpuShader4.nglVertexAttribIPointerEXT(index, size, type, stride, buffer, buffer.position(), function_pointer);
    }

    public static void glVertexAttribIPointerEXT(int index, int size, int type, int stride, IntBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribIPointerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).EXT_gpu_shader4_glVertexAttribIPointerEXT_buffer = buffer;
        EXTGpuShader4.nglVertexAttribIPointerEXT(index, size, type, stride, buffer, buffer.position() << 2, function_pointer);
    }

    public static void glVertexAttribIPointerEXT(int index, int size, int type, int stride, ShortBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribIPointerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).EXT_gpu_shader4_glVertexAttribIPointerEXT_buffer = buffer;
        EXTGpuShader4.nglVertexAttribIPointerEXT(index, size, type, stride, buffer, buffer.position() << 1, function_pointer);
    }

    private static native void nglVertexAttribIPointerEXT(int var0, int var1, int var2, int var3, Buffer var4, int var5, long var6);

    public static void glVertexAttribIPointerEXT(int index, int size, int type, int stride, long buffer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glVertexAttribIPointerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        EXTGpuShader4.nglVertexAttribIPointerEXTBO(index, size, type, stride, buffer_buffer_offset, function_pointer);
    }

    private static native void nglVertexAttribIPointerEXTBO(int var0, int var1, int var2, int var3, long var4, long var6);

    public static void glGetVertexAttribIEXT(int index, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glGetVertexAttribIivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        EXTGpuShader4.nglGetVertexAttribIivEXT(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribIivEXT(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetVertexAttribIuEXT(int index, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glGetVertexAttribIuivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        EXTGpuShader4.nglGetVertexAttribIuivEXT(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribIuivEXT(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniform1uiEXT(int location, int v0) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glUniform1uiEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTGpuShader4.nglUniform1uiEXT(location, v0, function_pointer);
    }

    private static native void nglUniform1uiEXT(int var0, int var1, long var2);

    public static void glUniform2uiEXT(int location, int v0, int v1) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glUniform2uiEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTGpuShader4.nglUniform2uiEXT(location, v0, v1, function_pointer);
    }

    private static native void nglUniform2uiEXT(int var0, int var1, int var2, long var3);

    public static void glUniform3uiEXT(int location, int v0, int v1, int v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glUniform3uiEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTGpuShader4.nglUniform3uiEXT(location, v0, v1, v2, function_pointer);
    }

    private static native void nglUniform3uiEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glUniform4uiEXT(int location, int v0, int v1, int v2, int v3) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glUniform4uiEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTGpuShader4.nglUniform4uiEXT(location, v0, v1, v2, v3, function_pointer);
    }

    private static native void nglUniform4uiEXT(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glUniform1uEXT(int location, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glUniform1uivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        EXTGpuShader4.nglUniform1uivEXT(location, value.remaining(), value, value.position(), function_pointer);
    }

    private static native void nglUniform1uivEXT(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniform2uEXT(int location, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glUniform2uivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        EXTGpuShader4.nglUniform2uivEXT(location, value.remaining() >> 1, value, value.position(), function_pointer);
    }

    private static native void nglUniform2uivEXT(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniform3uEXT(int location, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glUniform3uivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        EXTGpuShader4.nglUniform3uivEXT(location, value.remaining() / 3, value, value.position(), function_pointer);
    }

    private static native void nglUniform3uivEXT(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniform4uEXT(int location, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glUniform4uivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        EXTGpuShader4.nglUniform4uivEXT(location, value.remaining() >> 2, value, value.position(), function_pointer);
    }

    private static native void nglUniform4uivEXT(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetUniformuEXT(int program, int location, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glGetUniformuivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        EXTGpuShader4.nglGetUniformuivEXT(program, location, params, params.position(), function_pointer);
    }

    private static native void nglGetUniformuivEXT(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glBindFragDataLocationEXT(int program, int colorNumber, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glBindFragDataLocationEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        EXTGpuShader4.nglBindFragDataLocationEXT(program, colorNumber, name, name.position(), function_pointer);
    }

    private static native void nglBindFragDataLocationEXT(int var0, int var1, ByteBuffer var2, int var3, long var4);

    public static void glBindFragDataLocationEXT(int program, int colorNumber, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glBindFragDataLocationEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTGpuShader4.nglBindFragDataLocationEXT(program, colorNumber, APIUtils.getBufferNT(name), 0, function_pointer);
    }

    public static int glGetFragDataLocationEXT(int program, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glGetFragDataLocationEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        int __result = EXTGpuShader4.nglGetFragDataLocationEXT(program, name, name.position(), function_pointer);
        return __result;
    }

    private static native int nglGetFragDataLocationEXT(int var0, ByteBuffer var1, int var2, long var3);

    public static int glGetFragDataLocationEXT(int program, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_gpu_shader4_glGetFragDataLocationEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = EXTGpuShader4.nglGetFragDataLocationEXT(program, APIUtils.getBufferNT(name), 0, function_pointer);
        return __result;
    }
}

