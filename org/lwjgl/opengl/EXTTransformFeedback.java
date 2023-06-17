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

public final class EXTTransformFeedback {
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_EXT = 35982;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START_EXT = 35972;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE_EXT = 35973;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING_EXT = 35983;
    public static final int GL_INTERLEAVED_ATTRIBS_EXT = 35980;
    public static final int GL_SEPARATE_ATTRIBS_EXT = 35981;
    public static final int GL_PRIMITIVES_GENERATED_EXT = 35975;
    public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN_EXT = 35976;
    public static final int GL_RASTERIZER_DISCARD_EXT = 35977;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS_EXT = 35978;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS_EXT = 35979;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS_EXT = 35968;
    public static final int GL_TRANSFORM_FEEDBACK_VARYINGS_EXT = 35971;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE_EXT = 35967;
    public static final int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH_EXT = 35958;

    private EXTTransformFeedback() {
    }

    public static void glBindBufferRangeEXT(int target, int index, int buffer, long offset, long size) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_transform_feedback_glBindBufferRangeEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTTransformFeedback.nglBindBufferRangeEXT(target, index, buffer, offset, size, function_pointer);
    }

    private static native void nglBindBufferRangeEXT(int var0, int var1, int var2, long var3, long var5, long var7);

    public static void glBindBufferOffsetEXT(int target, int index, int buffer, long offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_transform_feedback_glBindBufferOffsetEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTTransformFeedback.nglBindBufferOffsetEXT(target, index, buffer, offset, function_pointer);
    }

    private static native void nglBindBufferOffsetEXT(int var0, int var1, int var2, long var3, long var5);

    public static void glBindBufferBaseEXT(int target, int index, int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_transform_feedback_glBindBufferBaseEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTTransformFeedback.nglBindBufferBaseEXT(target, index, buffer, function_pointer);
    }

    private static native void nglBindBufferBaseEXT(int var0, int var1, int var2, long var3);

    public static void glBeginTransformFeedbackEXT(int primitiveMode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_transform_feedback_glBeginTransformFeedbackEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTTransformFeedback.nglBeginTransformFeedbackEXT(primitiveMode, function_pointer);
    }

    private static native void nglBeginTransformFeedbackEXT(int var0, long var1);

    public static void glEndTransformFeedbackEXT() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_transform_feedback_glEndTransformFeedbackEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTTransformFeedback.nglEndTransformFeedbackEXT(function_pointer);
    }

    private static native void nglEndTransformFeedbackEXT(long var0);

    public static void glTransformFeedbackVaryingsEXT(int program, int count, ByteBuffer varyings, int bufferMode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_transform_feedback_glTransformFeedbackVaryingsEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(varyings);
        BufferChecks.checkNullTerminated(varyings, count);
        EXTTransformFeedback.nglTransformFeedbackVaryingsEXT(program, count, varyings, varyings.position(), bufferMode, function_pointer);
    }

    private static native void nglTransformFeedbackVaryingsEXT(int var0, int var1, ByteBuffer var2, int var3, int var4, long var5);

    public static void glTransformFeedbackVaryingsEXT(int program, CharSequence[] varyings, int bufferMode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_transform_feedback_glTransformFeedbackVaryingsEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTTransformFeedback.nglTransformFeedbackVaryingsEXT(program, varyings.length, APIUtils.getBufferNT(varyings), 0, bufferMode, function_pointer);
    }

    public static void glGetTransformFeedbackVaryingEXT(int program, int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_transform_feedback_glGetTransformFeedbackVaryingEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkBuffer(size, 1);
        BufferChecks.checkBuffer(type, 1);
        BufferChecks.checkDirect(name);
        EXTTransformFeedback.nglGetTransformFeedbackVaryingEXT(program, index, name.remaining(), length, length != null ? length.position() : 0, size, size.position(), type, type.position(), name, name.position(), function_pointer);
    }

    private static native void nglGetTransformFeedbackVaryingEXT(int var0, int var1, int var2, IntBuffer var3, int var4, IntBuffer var5, int var6, IntBuffer var7, int var8, ByteBuffer var9, int var10, long var11);

    public static String glGetTransformFeedbackVaryingEXT(int program, int index, int bufSize, IntBuffer size, IntBuffer type) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_transform_feedback_glGetTransformFeedbackVaryingEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(size, 1);
        BufferChecks.checkBuffer(type, 1);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(bufSize);
        EXTTransformFeedback.nglGetTransformFeedbackVaryingEXT(program, index, bufSize, name_length, 0, size, size.position(), type, type.position(), name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }
}

