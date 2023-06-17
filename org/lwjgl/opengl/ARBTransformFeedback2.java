/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBTransformFeedback2 {
    public static final int GL_TRANSFORM_FEEDBACK = 36386;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 36387;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389;

    private ARBTransformFeedback2() {
    }

    public static void glBindTransformFeedback(int target, int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transform_feedback2_glBindTransformFeedback_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBTransformFeedback2.nglBindTransformFeedback(target, id2, function_pointer);
    }

    private static native void nglBindTransformFeedback(int var0, int var1, long var2);

    public static void glDeleteTransformFeedbacks(IntBuffer ids) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transform_feedback2_glDeleteTransformFeedbacks_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(ids);
        ARBTransformFeedback2.nglDeleteTransformFeedbacks(ids.remaining(), ids, ids.position(), function_pointer);
    }

    private static native void nglDeleteTransformFeedbacks(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteTransformFeedbacks(int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transform_feedback2_glDeleteTransformFeedbacks_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBTransformFeedback2.nglDeleteTransformFeedbacks(1, APIUtils.getBufferInt().put(0, id2), 0, function_pointer);
    }

    public static void glGenTransformFeedbacks(IntBuffer ids) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transform_feedback2_glGenTransformFeedbacks_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(ids);
        ARBTransformFeedback2.nglGenTransformFeedbacks(ids.remaining(), ids, ids.position(), function_pointer);
    }

    private static native void nglGenTransformFeedbacks(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenTransformFeedbacks() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transform_feedback2_glGenTransformFeedbacks_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer ids = APIUtils.getBufferInt();
        ARBTransformFeedback2.nglGenTransformFeedbacks(1, ids, ids.position(), function_pointer);
        return ids.get(0);
    }

    public static boolean glIsTransformFeedback(int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transform_feedback2_glIsTransformFeedback_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = ARBTransformFeedback2.nglIsTransformFeedback(id2, function_pointer);
        return __result;
    }

    private static native boolean nglIsTransformFeedback(int var0, long var1);

    public static void glPauseTransformFeedback() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transform_feedback2_glPauseTransformFeedback_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBTransformFeedback2.nglPauseTransformFeedback(function_pointer);
    }

    private static native void nglPauseTransformFeedback(long var0);

    public static void glResumeTransformFeedback() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transform_feedback2_glResumeTransformFeedback_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBTransformFeedback2.nglResumeTransformFeedback(function_pointer);
    }

    private static native void nglResumeTransformFeedback(long var0);

    public static void glDrawTransformFeedback(int mode, int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transform_feedback2_glDrawTransformFeedback_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBTransformFeedback2.nglDrawTransformFeedback(mode, id2, function_pointer);
    }

    private static native void nglDrawTransformFeedback(int var0, int var1, long var2);
}

