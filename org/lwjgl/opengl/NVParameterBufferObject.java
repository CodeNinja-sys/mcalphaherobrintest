/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVParameterBufferObject {
    public static final int GL_MAX_PROGRAM_PARAMETER_BUFFER_BINDINGS_NV = 36256;
    public static final int GL_MAX_PROGRAM_PARAMETER_BUFFER_SIZE_NV = 36257;
    public static final int GL_VERTEX_PROGRAM_PARAMETER_BUFFER_NV = 36258;
    public static final int GL_GEOMETRY_PROGRAM_PARAMETER_BUFFER_NV = 36259;
    public static final int GL_FRAGMENT_PROGRAM_PARAMETER_BUFFER_NV = 36260;

    private NVParameterBufferObject() {
    }

    public static void glProgramBufferParametersNV(int target, int buffer, int index, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_parameter_buffer_object_glProgramBufferParametersfvNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        NVParameterBufferObject.nglProgramBufferParametersfvNV(target, buffer, index, params.remaining() >> 2, params, params.position(), function_pointer);
    }

    private static native void nglProgramBufferParametersfvNV(int var0, int var1, int var2, int var3, FloatBuffer var4, int var5, long var6);

    public static void glProgramBufferParametersINV(int target, int buffer, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_parameter_buffer_object_glProgramBufferParametersIivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        NVParameterBufferObject.nglProgramBufferParametersIivNV(target, buffer, index, params.remaining() >> 2, params, params.position(), function_pointer);
    }

    private static native void nglProgramBufferParametersIivNV(int var0, int var1, int var2, int var3, IntBuffer var4, int var5, long var6);

    public static void glProgramBufferParametersIuNV(int target, int buffer, int index, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_parameter_buffer_object_glProgramBufferParametersIuivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        NVParameterBufferObject.nglProgramBufferParametersIuivNV(target, buffer, index, params.remaining() >> 2, params, params.position(), function_pointer);
    }

    private static native void nglProgramBufferParametersIuivNV(int var0, int var1, int var2, int var3, IntBuffer var4, int var5, long var6);
}

