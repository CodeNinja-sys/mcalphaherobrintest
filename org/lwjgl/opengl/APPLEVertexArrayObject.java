/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class APPLEVertexArrayObject {
    public static final int GL_VERTEX_ARRAY_BINDING_APPLE = 34229;

    private APPLEVertexArrayObject() {
    }

    public static void glBindVertexArrayAPPLE(int array) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_vertex_array_object_glBindVertexArrayAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        APPLEVertexArrayObject.nglBindVertexArrayAPPLE(array, function_pointer);
    }

    private static native void nglBindVertexArrayAPPLE(int var0, long var1);

    public static void glDeleteVertexArraysAPPLE(IntBuffer arrays) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_vertex_array_object_glDeleteVertexArraysAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(arrays);
        APPLEVertexArrayObject.nglDeleteVertexArraysAPPLE(arrays.remaining(), arrays, arrays.position(), function_pointer);
    }

    private static native void nglDeleteVertexArraysAPPLE(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteVertexArraysAPPLE(int array) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_vertex_array_object_glDeleteVertexArraysAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        APPLEVertexArrayObject.nglDeleteVertexArraysAPPLE(1, APIUtils.getBufferInt().put(0, array), 0, function_pointer);
    }

    public static void glGenVertexArraysAPPLE(IntBuffer arrays) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_vertex_array_object_glGenVertexArraysAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(arrays);
        APPLEVertexArrayObject.nglGenVertexArraysAPPLE(arrays.remaining(), arrays, arrays.position(), function_pointer);
    }

    private static native void nglGenVertexArraysAPPLE(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenVertexArraysAPPLE() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_vertex_array_object_glGenVertexArraysAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer arrays = APIUtils.getBufferInt();
        APPLEVertexArrayObject.nglGenVertexArraysAPPLE(1, arrays, arrays.position(), function_pointer);
        return arrays.get(0);
    }

    public static boolean glIsVertexArrayAPPLE(int array) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_vertex_array_object_glIsVertexArrayAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = APPLEVertexArrayObject.nglIsVertexArrayAPPLE(array, function_pointer);
        return __result;
    }

    private static native boolean nglIsVertexArrayAPPLE(int var0, long var1);
}

