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

public final class NVTransformFeedback {
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_NV = 35982;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START_NV = 35972;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE_NV = 35973;
    public static final int GL_TRANSFORM_FEEDBACK_RECORD_NV = 35974;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING_NV = 35983;
    public static final int GL_INTERLEAVED_ATTRIBS_NV = 35980;
    public static final int GL_SEPARATE_ATTRIBS_NV = 35981;
    public static final int GL_PRIMITIVES_GENERATED_NV = 35975;
    public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN_NV = 35976;
    public static final int GL_RASTERIZER_DISCARD_NV = 35977;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS_NV = 35978;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS_NV = 35979;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS_NV = 35968;
    public static final int GL_TRANSFORM_FEEDBACK_ATTRIBS_NV = 35966;
    public static final int GL_ACTIVE_VARYINGS_NV = 35969;
    public static final int GL_ACTIVE_VARYING_MAX_LENGTH_NV = 35970;
    public static final int GL_TRANSFORM_FEEDBACK_VARYINGS_NV = 35971;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE_NV = 35967;
    public static final int GL_BACK_PRIMARY_COLOR_NV = 35959;
    public static final int GL_BACK_SECONDARY_COLOR_NV = 35960;
    public static final int GL_TEXTURE_COORD_NV = 35961;
    public static final int GL_CLIP_DISTANCE_NV = 35962;
    public static final int GL_VERTEX_ID_NV = 35963;
    public static final int GL_PRIMITIVE_ID_NV = 35964;
    public static final int GL_GENERIC_ATTRIB_NV = 35965;
    public static final int GL_LAYER_NV = 36266;

    private NVTransformFeedback() {
    }

    public static void glBindBufferRangeNV(int target, int index, int buffer, long offset, long size) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glBindBufferRangeNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVTransformFeedback.nglBindBufferRangeNV(target, index, buffer, offset, size, function_pointer);
    }

    private static native void nglBindBufferRangeNV(int var0, int var1, int var2, long var3, long var5, long var7);

    public static void glBindBufferOffsetNV(int target, int index, int buffer, long offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glBindBufferOffsetNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVTransformFeedback.nglBindBufferOffsetNV(target, index, buffer, offset, function_pointer);
    }

    private static native void nglBindBufferOffsetNV(int var0, int var1, int var2, long var3, long var5);

    public static void glBindBufferBaseNV(int target, int index, int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glBindBufferBaseNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVTransformFeedback.nglBindBufferBaseNV(target, index, buffer, function_pointer);
    }

    private static native void nglBindBufferBaseNV(int var0, int var1, int var2, long var3);

    public static void glTransformFeedbackAttribsNV(IntBuffer attribs, int bufferMode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glTransformFeedbackAttribsNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(attribs);
        NVTransformFeedback.nglTransformFeedbackAttribsNV(attribs.remaining(), attribs, attribs.position(), bufferMode, function_pointer);
    }

    private static native void nglTransformFeedbackAttribsNV(int var0, IntBuffer var1, int var2, int var3, long var4);

    public static void glTransformFeedbackVaryingsNV(int program, IntBuffer locations, int bufferMode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glTransformFeedbackVaryingsNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(locations);
        NVTransformFeedback.nglTransformFeedbackVaryingsNV(program, locations.remaining(), locations, locations.position(), bufferMode, function_pointer);
    }

    private static native void nglTransformFeedbackVaryingsNV(int var0, int var1, IntBuffer var2, int var3, int var4, long var5);

    public static void glBeginTransformFeedbackNV(int primitiveMode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glBeginTransformFeedbackNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVTransformFeedback.nglBeginTransformFeedbackNV(primitiveMode, function_pointer);
    }

    private static native void nglBeginTransformFeedbackNV(int var0, long var1);

    public static void glEndTransformFeedbackNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glEndTransformFeedbackNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVTransformFeedback.nglEndTransformFeedbackNV(function_pointer);
    }

    private static native void nglEndTransformFeedbackNV(long var0);

    public static int glGetVaryingLocationNV(int program, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glGetVaryingLocationNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        int __result = NVTransformFeedback.nglGetVaryingLocationNV(program, name, name.position(), function_pointer);
        return __result;
    }

    private static native int nglGetVaryingLocationNV(int var0, ByteBuffer var1, int var2, long var3);

    public static int glGetVaryingLocationNV(int program, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glGetVaryingLocationNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = NVTransformFeedback.nglGetVaryingLocationNV(program, APIUtils.getBufferNT(name), 0, function_pointer);
        return __result;
    }

    public static void glGetActiveVaryingNV(int program, int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glGetActiveVaryingNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkBuffer(size, 1);
        BufferChecks.checkBuffer(type, 1);
        BufferChecks.checkDirect(name);
        NVTransformFeedback.nglGetActiveVaryingNV(program, index, name.remaining(), length, length != null ? length.position() : 0, size, size.position(), type, type.position(), name, name.position(), function_pointer);
    }

    private static native void nglGetActiveVaryingNV(int var0, int var1, int var2, IntBuffer var3, int var4, IntBuffer var5, int var6, IntBuffer var7, int var8, ByteBuffer var9, int var10, long var11);

    public static String glGetActiveVaryingNV(int program, int index, int bufSize, IntBuffer sizeType) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glGetActiveVaryingNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(sizeType, 2);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(bufSize);
        NVTransformFeedback.nglGetActiveVaryingNV(program, index, bufSize, name_length, 0, sizeType, sizeType.position(), sizeType, sizeType.position() + 1, name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static String glGetActiveVaryingNV(int program, int index, int bufSize) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glGetActiveVaryingNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(bufSize);
        NVTransformFeedback.nglGetActiveVaryingNV(program, index, bufSize, name_length, 0, APIUtils.getBufferInt(), 0, APIUtils.getBufferInt(), 1, name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static int glGetActiveVaryingSizeNV(int program, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glGetActiveVaryingNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer size = APIUtils.getBufferInt();
        NVTransformFeedback.nglGetActiveVaryingNV(program, index, 0, null, 0, size, size.position(), size, 1, APIUtils.getBufferByte(0), 0, function_pointer);
        return size.get(0);
    }

    public static int glGetActiveVaryingTypeNV(int program, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glGetActiveVaryingNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer type = APIUtils.getBufferInt();
        NVTransformFeedback.nglGetActiveVaryingNV(program, index, 0, null, 0, type, 1, type, type.position(), APIUtils.getBufferByte(0), 0, function_pointer);
        return type.get(0);
    }

    public static void glActiveVaryingNV(int program, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glActiveVaryingNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        NVTransformFeedback.nglActiveVaryingNV(program, name, name.position(), function_pointer);
    }

    private static native void nglActiveVaryingNV(int var0, ByteBuffer var1, int var2, long var3);

    public static void glActiveVaryingNV(int program, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glActiveVaryingNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVTransformFeedback.nglActiveVaryingNV(program, APIUtils.getBufferNT(name), 0, function_pointer);
    }

    public static void glGetTransformFeedbackVaryingNV(int program, int index, IntBuffer location) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glGetTransformFeedbackVaryingNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(location, 1);
        NVTransformFeedback.nglGetTransformFeedbackVaryingNV(program, index, location, location.position(), function_pointer);
    }

    private static native void nglGetTransformFeedbackVaryingNV(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetTransformFeedbackVaryingNV(int program, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback_glGetTransformFeedbackVaryingNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer location = APIUtils.getBufferInt();
        NVTransformFeedback.nglGetTransformFeedbackVaryingNV(program, index, location, location.position(), function_pointer);
        return location.get(0);
    }
}

