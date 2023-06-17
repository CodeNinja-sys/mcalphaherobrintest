/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ATIVertexAttribArrayObject {
    private ATIVertexAttribArrayObject() {
    }

    public static void glVertexAttribArrayObjectATI(int index, int size, int type, boolean normalized, int stride, int buffer, int offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_attrib_array_object_glVertexAttribArrayObjectATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexAttribArrayObject.nglVertexAttribArrayObjectATI(index, size, type, normalized, stride, buffer, offset, function_pointer);
    }

    private static native void nglVertexAttribArrayObjectATI(int var0, int var1, int var2, boolean var3, int var4, int var5, int var6, long var7);

    public static void glGetVertexAttribArrayObjectATI(int index, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_attrib_array_object_glGetVertexAttribArrayObjectfvATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ATIVertexAttribArrayObject.nglGetVertexAttribArrayObjectfvATI(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribArrayObjectfvATI(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glGetVertexAttribArrayObjectATI(int index, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_attrib_array_object_glGetVertexAttribArrayObjectivATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ATIVertexAttribArrayObject.nglGetVertexAttribArrayObjectivATI(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribArrayObjectivATI(int var0, int var1, IntBuffer var2, int var3, long var4);
}

