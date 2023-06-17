/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBVertexArrayObject {
    public static final int GL_VERTEX_ARRAY_BINDING = 34229;

    private ARBVertexArrayObject() {
    }

    public static void glBindVertexArray(int array) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_array_object_glBindVertexArray_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexArrayObject.nglBindVertexArray(array, function_pointer);
    }

    private static native void nglBindVertexArray(int var0, long var1);

    public static void glDeleteVertexArrays(IntBuffer arrays) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_array_object_glDeleteVertexArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(arrays);
        ARBVertexArrayObject.nglDeleteVertexArrays(arrays.remaining(), arrays, arrays.position(), function_pointer);
    }

    private static native void nglDeleteVertexArrays(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteVertexArrays(int array) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_array_object_glDeleteVertexArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexArrayObject.nglDeleteVertexArrays(1, APIUtils.getBufferInt().put(0, array), 0, function_pointer);
    }

    public static void glGenVertexArrays(IntBuffer arrays) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_array_object_glGenVertexArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(arrays);
        ARBVertexArrayObject.nglGenVertexArrays(arrays.remaining(), arrays, arrays.position(), function_pointer);
    }

    private static native void nglGenVertexArrays(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenVertexArrays() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_array_object_glGenVertexArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer arrays = APIUtils.getBufferInt();
        ARBVertexArrayObject.nglGenVertexArrays(1, arrays, arrays.position(), function_pointer);
        return arrays.get(0);
    }

    public static boolean glIsVertexArray(int array) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_array_object_glIsVertexArray_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = ARBVertexArrayObject.nglIsVertexArray(array, function_pointer);
        return __result;
    }

    private static native boolean nglIsVertexArray(int var0, long var1);
}

