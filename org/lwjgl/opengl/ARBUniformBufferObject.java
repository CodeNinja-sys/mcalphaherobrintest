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

public final class ARBUniformBufferObject {
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

    private ARBUniformBufferObject() {
    }

    public static void glGetUniformIndices(int program, ByteBuffer uniformNames, IntBuffer uniformIndices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glGetUniformIndices_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(uniformNames);
        BufferChecks.checkNullTerminated(uniformNames, uniformIndices.remaining());
        BufferChecks.checkDirect(uniformIndices);
        ARBUniformBufferObject.nglGetUniformIndices(program, uniformIndices.remaining(), uniformNames, uniformNames.position(), uniformIndices, uniformIndices.position(), function_pointer);
    }

    private static native void nglGetUniformIndices(int var0, int var1, ByteBuffer var2, int var3, IntBuffer var4, int var5, long var6);

    public static void glGetUniformIndices(int program, CharSequence[] uniformNames, IntBuffer uniformIndices) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glGetUniformIndices_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(uniformIndices, uniformNames.length);
        ARBUniformBufferObject.nglGetUniformIndices(program, uniformNames.length, APIUtils.getBufferNT(uniformNames), 0, uniformIndices, uniformIndices.position(), function_pointer);
    }

    public static void glGetActiveUniforms(int program, IntBuffer uniformIndices, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glGetActiveUniformsiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(uniformIndices);
        BufferChecks.checkBuffer(params, uniformIndices.remaining());
        ARBUniformBufferObject.nglGetActiveUniformsiv(program, uniformIndices.remaining(), uniformIndices, uniformIndices.position(), pname, params, params.position(), function_pointer);
    }

    private static native void nglGetActiveUniformsiv(int var0, int var1, IntBuffer var2, int var3, int var4, IntBuffer var5, int var6, long var7);

    public static int glGetActiveUniforms(int program, int uniformIndex, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glGetActiveUniformsiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBUniformBufferObject.nglGetActiveUniformsiv(program, 1, params.put(1, uniformIndex), 1, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetActiveUniformName(int program, int uniformIndex, IntBuffer length, ByteBuffer uniformName) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glGetActiveUniformName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(uniformName);
        ARBUniformBufferObject.nglGetActiveUniformName(program, uniformIndex, uniformName.remaining(), length, length != null ? length.position() : 0, uniformName, uniformName.position(), function_pointer);
    }

    private static native void nglGetActiveUniformName(int var0, int var1, int var2, IntBuffer var3, int var4, ByteBuffer var5, int var6, long var7);

    public static String glGetActiveUniformName(int program, int uniformIndex, int bufSize) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glGetActiveUniformName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer uniformName_length = APIUtils.getLengths();
        ByteBuffer uniformName = APIUtils.getBufferByte(bufSize);
        ARBUniformBufferObject.nglGetActiveUniformName(program, uniformIndex, bufSize, uniformName_length, 0, uniformName, uniformName.position(), function_pointer);
        uniformName.limit(uniformName_length.get(0));
        return APIUtils.getString(uniformName);
    }

    public static int glGetUniformBlockIndex(int program, ByteBuffer uniformBlockName) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glGetUniformBlockIndex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(uniformBlockName);
        BufferChecks.checkNullTerminated(uniformBlockName);
        int __result = ARBUniformBufferObject.nglGetUniformBlockIndex(program, uniformBlockName, uniformBlockName.position(), function_pointer);
        return __result;
    }

    private static native int nglGetUniformBlockIndex(int var0, ByteBuffer var1, int var2, long var3);

    public static int glGetUniformBlockIndex(int program, CharSequence uniformBlockName) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glGetUniformBlockIndex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = ARBUniformBufferObject.nglGetUniformBlockIndex(program, APIUtils.getBufferNT(uniformBlockName), 0, function_pointer);
        return __result;
    }

    public static void glGetActiveUniformBlock(int program, int uniformBlockIndex, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glGetActiveUniformBlockiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 16);
        ARBUniformBufferObject.nglGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetActiveUniformBlockiv(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static int glGetActiveUniformBlock(int program, int uniformBlockIndex, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glGetActiveUniformBlockiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBUniformBufferObject.nglGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetActiveUniformBlockName(int program, int uniformBlockIndex, IntBuffer length, ByteBuffer uniformBlockName) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glGetActiveUniformBlockName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(uniformBlockName);
        ARBUniformBufferObject.nglGetActiveUniformBlockName(program, uniformBlockIndex, uniformBlockName.remaining(), length, length != null ? length.position() : 0, uniformBlockName, uniformBlockName.position(), function_pointer);
    }

    private static native void nglGetActiveUniformBlockName(int var0, int var1, int var2, IntBuffer var3, int var4, ByteBuffer var5, int var6, long var7);

    public static String glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glGetActiveUniformBlockName_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer uniformBlockName_length = APIUtils.getLengths();
        ByteBuffer uniformBlockName = APIUtils.getBufferByte(bufSize);
        ARBUniformBufferObject.nglGetActiveUniformBlockName(program, uniformBlockIndex, bufSize, uniformBlockName_length, 0, uniformBlockName, uniformBlockName.position(), function_pointer);
        uniformBlockName.limit(uniformBlockName_length.get(0));
        return APIUtils.getString(uniformBlockName);
    }

    public static void glBindBufferRange(int target, int index, int buffer, long offset, long size) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glBindBufferRange_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBUniformBufferObject.nglBindBufferRange(target, index, buffer, offset, size, function_pointer);
    }

    private static native void nglBindBufferRange(int var0, int var1, int var2, long var3, long var5, long var7);

    public static void glBindBufferBase(int target, int index, int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glBindBufferBase_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBUniformBufferObject.nglBindBufferBase(target, index, buffer, function_pointer);
    }

    private static native void nglBindBufferBase(int var0, int var1, int var2, long var3);

    public static void glGetInteger(int value, int index, IntBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glGetIntegeri_v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, 4);
        ARBUniformBufferObject.nglGetIntegeri_v(value, index, data, data.position(), function_pointer);
    }

    private static native void nglGetIntegeri_v(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetInteger(int value, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glGetIntegeri_v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer data = APIUtils.getBufferInt();
        ARBUniformBufferObject.nglGetIntegeri_v(value, index, data, data.position(), function_pointer);
        return data.get(0);
    }

    public static void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_uniform_buffer_object_glUniformBlockBinding_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBUniformBufferObject.nglUniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding, function_pointer);
    }

    private static native void nglUniformBlockBinding(int var0, int var1, int var2, long var3);
}

