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

public final class GL31 {
    public static final int GL_RED_SNORM = 36752;
    public static final int GL_RG_SNORM = 36753;
    public static final int GL_RGB_SNORM = 36754;
    public static final int GL_RGBA_SNORM = 36755;
    public static final int GL_R8_SNORM = 36756;
    public static final int GL_RG8_SNORM = 36757;
    public static final int GL_RGB8_SNORM = 36758;
    public static final int GL_RGBA8_SNORM = 36759;
    public static final int GL_R16_SNORM = 36760;
    public static final int GL_RG16_SNORM = 36761;
    public static final int GL_RGB16_SNORM = 36762;
    public static final int GL_RGBA16_SNORM = 36763;
    public static final int GL_SIGNED_NORMALIZED = 36764;
    public static final int GL_COPY_READ_BUFFER = 36662;
    public static final int GL_COPY_WRITE_BUFFER = 36663;
    public static final int GL_PRIMITIVE_RESTART = 36765;
    public static final int GL_PRIMITIVE_RESTART_INDEX = 36766;
    public static final int GL_TEXTURE_BUFFER = 35882;
    public static final int GL_MAX_TEXTURE_BUFFER_SIZE = 35883;
    public static final int GL_TEXTURE_BINDING_BUFFER = 35884;
    public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 35885;
    public static final int GL_TEXTURE_BUFFER_FORMAT = 35886;
    public static final int GL_TEXTURE_RECTANGLE = 34037;
    public static final int GL_TEXTURE_BINDING_RECTANGLE = 34038;
    public static final int GL_PROXY_TEXTURE_RECTANGLE = 34039;
    public static final int GL_MAX_RECTANGLE_TEXTURE_SIZE = 34040;
    public static final int GL_SAMPLER_2D_RECT = 35683;
    public static final int GL_SAMPLER_2D_RECT_SHADOW = 35684;
    public static final int GL_UNIFORM_BUFFER = 35345;
    public static final int GL_UNIFORM_BUFFER_BINDING = 35368;
    public static final int GL_UNIFORM_BUFFER_START = 35369;
    public static final int GL_UNIFORM_BUFFER_SIZE = 35370;
    public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 35371;
    public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 35372;
    public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 35373;
    public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 35374;
    public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 35375;
    public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 35376;
    public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 35377;
    public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 35378;
    public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 35379;
    public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 35380;
    public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 35381;
    public static final int GL_ACTIVE_UNIFORM_BLOCKS = 35382;
    public static final int GL_UNIFORM_TYPE = 35383;
    public static final int GL_UNIFORM_SIZE = 35384;
    public static final int GL_UNIFORM_NAME_LENGTH = 35385;
    public static final int GL_UNIFORM_BLOCK_INDEX = 35386;
    public static final int GL_UNIFORM_OFFSET = 35387;
    public static final int GL_UNIFORM_ARRAY_STRIDE = 35388;
    public static final int GL_UNIFORM_MATRIX_STRIDE = 35389;
    public static final int GL_UNIFORM_IS_ROW_MAJOR = 35390;
    public static final int GL_UNIFORM_BLOCK_BINDING = 35391;
    public static final int GL_UNIFORM_BLOCK_DATA_SIZE = 35392;
    public static final int GL_UNIFORM_BLOCK_NAME_LENGTH = 35393;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 35394;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 35395;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 35396;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 35397;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 35398;
    public static final int GL_INVALID_INDEX = -1;

    private GL31() {
    }

    public static void glDrawArraysInstanced(int mode, int first, int count, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glDrawArraysInstanced_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL31.nglDrawArraysInstanced(mode, first, count, primcount, function_pointer);
    }

    private static native void nglDrawArraysInstanced(int var0, int var1, int var2, int var3, long var4);

    public static void glDrawElementsInstanced(int mode, ByteBuffer indices, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glDrawElementsInstanced_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        GL31.nglDrawElementsInstanced(mode, indices.remaining(), 5121, indices, indices.position(), primcount, function_pointer);
    }

    public static void glDrawElementsInstanced(int mode, IntBuffer indices, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glDrawElementsInstanced_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        GL31.nglDrawElementsInstanced(mode, indices.remaining(), 5125, indices, indices.position() << 2, primcount, function_pointer);
    }

    public static void glDrawElementsInstanced(int mode, ShortBuffer indices, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glDrawElementsInstanced_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        GL31.nglDrawElementsInstanced(mode, indices.remaining(), 5123, indices, indices.position() << 1, primcount, function_pointer);
    }

    private static native void nglDrawElementsInstanced(int var0, int var1, int var2, Buffer var3, int var4, int var5, long var6);

    public static void glDrawElementsInstanced(int mode, int count, int type, long indices_buffer_offset, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glDrawElementsInstanced_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOenabled(caps);
        GL31.nglDrawElementsInstancedBO(mode, count, type, indices_buffer_offset, primcount, function_pointer);
    }

    private static native void nglDrawElementsInstancedBO(int var0, int var1, int var2, long var3, int var5, long var6);

    public static void glCopyBufferSubData(int readtarget, int writetarget, long readoffset, long writeoffset, long size) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glCopyBufferSubData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL31.nglCopyBufferSubData(readtarget, writetarget, readoffset, writeoffset, size, function_pointer);
    }

    private static native void nglCopyBufferSubData(int var0, int var1, long var2, long var4, long var6, long var8);

    public static void glPrimitiveRestartIndex(int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glPrimitiveRestartIndex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL31.nglPrimitiveRestartIndex(index, function_pointer);
    }

    private static native void nglPrimitiveRestartIndex(int var0, long var1);

    public static void glTexBuffer(int target, int internalformat, int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glTexBuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL31.nglTexBuffer(target, internalformat, buffer, function_pointer);
    }

    private static native void nglTexBuffer(int var0, int var1, int var2, long var3);

    public static void glGetUniformIndices(int program, ByteBuffer uniformNames, IntBuffer uniformIndices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glGetUniformIndices_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(uniformNames);
        BufferChecks.checkNullTerminated(uniformNames, uniformIndices.remaining());
        BufferChecks.checkDirect(uniformIndices);
        GL31.nglGetUniformIndices(program, uniformIndices.remaining(), uniformNames, uniformNames.position(), uniformIndices, uniformIndices.position(), function_pointer);
    }

    private static native void nglGetUniformIndices(int var0, int var1, ByteBuffer var2, int var3, IntBuffer var4, int var5, long var6);

    public static void glGetUniformIndices(int program, CharSequence[] uniformNames, IntBuffer uniformIndices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glGetUniformIndices_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(uniformIndices, uniformNames.length);
        GL31.nglGetUniformIndices(program, uniformNames.length, APIUtils.getBufferNT(uniformNames), 0, uniformIndices, uniformIndices.position(), function_pointer);
    }

    public static void glGetActiveUniforms(int program, IntBuffer uniformIndices, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glGetActiveUniformsiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(uniformIndices);
        BufferChecks.checkBuffer(params, uniformIndices.remaining());
        GL31.nglGetActiveUniformsiv(program, uniformIndices.remaining(), uniformIndices, uniformIndices.position(), pname, params, params.position(), function_pointer);
    }

    private static native void nglGetActiveUniformsiv(int var0, int var1, IntBuffer var2, int var3, int var4, IntBuffer var5, int var6, long var7);

    public static int glGetActiveUniforms(int program, int uniformIndex, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glGetActiveUniformsiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL31.nglGetActiveUniformsiv(program, 1, params.put(1, uniformIndex), 1, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetActiveUniformName(int program, int uniformIndex, IntBuffer length, ByteBuffer uniformName) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glGetActiveUniformName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(uniformName);
        GL31.nglGetActiveUniformName(program, uniformIndex, uniformName.remaining(), length, length != null ? length.position() : 0, uniformName, uniformName.position(), function_pointer);
    }

    private static native void nglGetActiveUniformName(int var0, int var1, int var2, IntBuffer var3, int var4, ByteBuffer var5, int var6, long var7);

    public static String glGetActiveUniformName(int program, int uniformIndex, int bufSize) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glGetActiveUniformName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer uniformName_length = APIUtils.getLengths();
        ByteBuffer uniformName = APIUtils.getBufferByte(bufSize);
        GL31.nglGetActiveUniformName(program, uniformIndex, bufSize, uniformName_length, 0, uniformName, uniformName.position(), function_pointer);
        uniformName.limit(uniformName_length.get(0));
        return APIUtils.getString(uniformName);
    }

    public static int glGetUniformBlockIndex(int program, ByteBuffer uniformBlockName) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glGetUniformBlockIndex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(uniformBlockName);
        BufferChecks.checkNullTerminated(uniformBlockName);
        int __result = GL31.nglGetUniformBlockIndex(program, uniformBlockName, uniformBlockName.position(), function_pointer);
        return __result;
    }

    private static native int nglGetUniformBlockIndex(int var0, ByteBuffer var1, int var2, long var3);

    public static int glGetUniformBlockIndex(int program, CharSequence uniformBlockName) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glGetUniformBlockIndex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = GL31.nglGetUniformBlockIndex(program, APIUtils.getBufferNT(uniformBlockName), 0, function_pointer);
        return __result;
    }

    public static void glGetActiveUniformBlock(int program, int uniformBlockIndex, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glGetActiveUniformBlockiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 16);
        GL31.nglGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetActiveUniformBlockiv(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static int glGetActiveUniformBlock(int program, int uniformBlockIndex, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glGetActiveUniformBlockiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL31.nglGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetActiveUniformBlockName(int program, int uniformBlockIndex, IntBuffer length, ByteBuffer uniformBlockName) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glGetActiveUniformBlockName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(uniformBlockName);
        GL31.nglGetActiveUniformBlockName(program, uniformBlockIndex, uniformBlockName.remaining(), length, length != null ? length.position() : 0, uniformBlockName, uniformBlockName.position(), function_pointer);
    }

    private static native void nglGetActiveUniformBlockName(int var0, int var1, int var2, IntBuffer var3, int var4, ByteBuffer var5, int var6, long var7);

    public static String glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glGetActiveUniformBlockName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer uniformBlockName_length = APIUtils.getLengths();
        ByteBuffer uniformBlockName = APIUtils.getBufferByte(bufSize);
        GL31.nglGetActiveUniformBlockName(program, uniformBlockIndex, bufSize, uniformBlockName_length, 0, uniformBlockName, uniformBlockName.position(), function_pointer);
        uniformBlockName.limit(uniformBlockName_length.get(0));
        return APIUtils.getString(uniformBlockName);
    }

    public static void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL31_glUniformBlockBinding_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL31.nglUniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding, function_pointer);
    }

    private static native void nglUniformBlockBinding(int var0, int var1, int var2, long var3);
}

