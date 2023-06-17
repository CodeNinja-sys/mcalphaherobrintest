/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBTransformFeedback3 {
    public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 36464;
    public static final int GL_MAX_VERTEX_STREAMS = 36465;

    private ARBTransformFeedback3() {
    }

    public static void glDrawTransformFeedbackStream(int mode, int id2, int stream) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transform_feedback3_glDrawTransformFeedbackStream_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBTransformFeedback3.nglDrawTransformFeedbackStream(mode, id2, stream, function_pointer);
    }

    private static native void nglDrawTransformFeedbackStream(int var0, int var1, int var2, long var3);

    public static void glBeginQueryIndexed(int target, int index, int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transform_feedback3_glBeginQueryIndexed_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBTransformFeedback3.nglBeginQueryIndexed(target, index, id2, function_pointer);
    }

    private static native void nglBeginQueryIndexed(int var0, int var1, int var2, long var3);

    public static void glEndQueryIndexed(int target, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transform_feedback3_glEndQueryIndexed_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBTransformFeedback3.nglEndQueryIndexed(target, index, function_pointer);
    }

    private static native void nglEndQueryIndexed(int var0, int var1, long var2);

    public static void glGetQueryIndexed(int target, int index, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transform_feedback3_glGetQueryIndexediv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        ARBTransformFeedback3.nglGetQueryIndexediv(target, index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetQueryIndexediv(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static int glGetQueryIndexed(int target, int index, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_transform_feedback3_glGetQueryIndexediv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBTransformFeedback3.nglGetQueryIndexediv(target, index, pname, params, params.position(), function_pointer);
        return params.get(0);
    }
}

