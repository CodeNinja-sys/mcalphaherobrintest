/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVTransformFeedback2 {
    public static final int GL_TRANSFORM_FEEDBACK_NV = 36386;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED_NV = 36387;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE_NV = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BINDING_NV = 36389;

    private NVTransformFeedback2() {
    }

    public static void glBindTransformFeedbackNV(int target, int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback2_glBindTransformFeedbackNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVTransformFeedback2.nglBindTransformFeedbackNV(target, id2, function_pointer);
    }

    private static native void nglBindTransformFeedbackNV(int var0, int var1, long var2);

    public static void glDeleteTransformFeedbacksNV(IntBuffer ids) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback2_glDeleteTransformFeedbacksNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(ids);
        NVTransformFeedback2.nglDeleteTransformFeedbacksNV(ids.remaining(), ids, ids.position(), function_pointer);
    }

    private static native void nglDeleteTransformFeedbacksNV(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteTransformFeedbacksNV(int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback2_glDeleteTransformFeedbacksNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVTransformFeedback2.nglDeleteTransformFeedbacksNV(1, APIUtils.getBufferInt().put(0, id2), 0, function_pointer);
    }

    public static void glGenTransformFeedbacksNV(IntBuffer ids) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback2_glGenTransformFeedbacksNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(ids);
        NVTransformFeedback2.nglGenTransformFeedbacksNV(ids.remaining(), ids, ids.position(), function_pointer);
    }

    private static native void nglGenTransformFeedbacksNV(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenTransformFeedbacksNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback2_glGenTransformFeedbacksNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer ids = APIUtils.getBufferInt();
        NVTransformFeedback2.nglGenTransformFeedbacksNV(1, ids, ids.position(), function_pointer);
        return ids.get(0);
    }

    public static boolean glIsTransformFeedbackNV(int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback2_glIsTransformFeedbackNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = NVTransformFeedback2.nglIsTransformFeedbackNV(id2, function_pointer);
        return __result;
    }

    private static native boolean nglIsTransformFeedbackNV(int var0, long var1);

    public static void glPauseTransformFeedbackNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback2_glPauseTransformFeedbackNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVTransformFeedback2.nglPauseTransformFeedbackNV(function_pointer);
    }

    private static native void nglPauseTransformFeedbackNV(long var0);

    public static void glResumeTransformFeedbackNV() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback2_glResumeTransformFeedbackNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVTransformFeedback2.nglResumeTransformFeedbackNV(function_pointer);
    }

    private static native void nglResumeTransformFeedbackNV(long var0);

    public static void glDrawTransformFeedbackNV(int mode, int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_transform_feedback2_glDrawTransformFeedbackNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVTransformFeedback2.nglDrawTransformFeedbackNV(mode, id2, function_pointer);
    }

    private static native void nglDrawTransformFeedbackNV(int var0, int var1, long var2);
}

