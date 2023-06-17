/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ATIVertexArrayObject {
    public static final int GL_STATIC_ATI = 34656;
    public static final int GL_DYNAMIC_ATI = 34657;
    public static final int GL_PRESERVE_ATI = 34658;
    public static final int GL_DISCARD_ATI = 34659;
    public static final int GL_OBJECT_BUFFER_SIZE_ATI = 34660;
    public static final int GL_OBJECT_BUFFER_USAGE_ATI = 34661;
    public static final int GL_ARRAY_OBJECT_BUFFER_ATI = 34662;
    public static final int GL_ARRAY_OBJECT_OFFSET_ATI = 34663;

    private ATIVertexArrayObject() {
    }

    public static int glNewObjectBufferATI(int size, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glNewObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = ATIVertexArrayObject.nglNewObjectBufferATI(size, null, 0, usage, function_pointer);
        return __result;
    }

    public static int glNewObjectBufferATI(ByteBuffer pPointer, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glNewObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        int __result = ATIVertexArrayObject.nglNewObjectBufferATI(pPointer.remaining(), pPointer, pPointer.position(), usage, function_pointer);
        return __result;
    }

    public static int glNewObjectBufferATI(DoubleBuffer pPointer, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glNewObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        int __result = ATIVertexArrayObject.nglNewObjectBufferATI(pPointer.remaining() << 3, pPointer, pPointer.position() << 3, usage, function_pointer);
        return __result;
    }

    public static int glNewObjectBufferATI(FloatBuffer pPointer, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glNewObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        int __result = ATIVertexArrayObject.nglNewObjectBufferATI(pPointer.remaining() << 2, pPointer, pPointer.position() << 2, usage, function_pointer);
        return __result;
    }

    public static int glNewObjectBufferATI(IntBuffer pPointer, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glNewObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        int __result = ATIVertexArrayObject.nglNewObjectBufferATI(pPointer.remaining() << 2, pPointer, pPointer.position() << 2, usage, function_pointer);
        return __result;
    }

    public static int glNewObjectBufferATI(ShortBuffer pPointer, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glNewObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        int __result = ATIVertexArrayObject.nglNewObjectBufferATI(pPointer.remaining() << 1, pPointer, pPointer.position() << 1, usage, function_pointer);
        return __result;
    }

    private static native int nglNewObjectBufferATI(int var0, Buffer var1, int var2, int var3, long var4);

    public static boolean glIsObjectBufferATI(int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glIsObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = ATIVertexArrayObject.nglIsObjectBufferATI(buffer, function_pointer);
        return __result;
    }

    private static native boolean nglIsObjectBufferATI(int var0, long var1);

    public static void glUpdateObjectBufferATI(int buffer, int offset, ByteBuffer pPointer, int preserve) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glUpdateObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        ATIVertexArrayObject.nglUpdateObjectBufferATI(buffer, offset, pPointer.remaining(), pPointer, pPointer.position(), preserve, function_pointer);
    }

    public static void glUpdateObjectBufferATI(int buffer, int offset, DoubleBuffer pPointer, int preserve) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glUpdateObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        ATIVertexArrayObject.nglUpdateObjectBufferATI(buffer, offset, pPointer.remaining() << 3, pPointer, pPointer.position() << 3, preserve, function_pointer);
    }

    public static void glUpdateObjectBufferATI(int buffer, int offset, FloatBuffer pPointer, int preserve) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glUpdateObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        ATIVertexArrayObject.nglUpdateObjectBufferATI(buffer, offset, pPointer.remaining() << 2, pPointer, pPointer.position() << 2, preserve, function_pointer);
    }

    public static void glUpdateObjectBufferATI(int buffer, int offset, IntBuffer pPointer, int preserve) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glUpdateObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        ATIVertexArrayObject.nglUpdateObjectBufferATI(buffer, offset, pPointer.remaining() << 2, pPointer, pPointer.position() << 2, preserve, function_pointer);
    }

    public static void glUpdateObjectBufferATI(int buffer, int offset, ShortBuffer pPointer, int preserve) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glUpdateObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(pPointer);
        ATIVertexArrayObject.nglUpdateObjectBufferATI(buffer, offset, pPointer.remaining() << 1, pPointer, pPointer.position() << 1, preserve, function_pointer);
    }

    private static native void nglUpdateObjectBufferATI(int var0, int var1, int var2, Buffer var3, int var4, int var5, long var6);

    public static void glGetObjectBufferATI(int buffer, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glGetObjectBufferfvATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        ATIVertexArrayObject.nglGetObjectBufferfvATI(buffer, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetObjectBufferfvATI(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glGetObjectBufferATI(int buffer, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glGetObjectBufferivATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        ATIVertexArrayObject.nglGetObjectBufferivATI(buffer, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetObjectBufferivATI(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glFreeObjectBufferATI(int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glFreeObjectBufferATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexArrayObject.nglFreeObjectBufferATI(buffer, function_pointer);
    }

    private static native void nglFreeObjectBufferATI(int var0, long var1);

    public static void glArrayObjectATI(int array, int size, int type, int stride, int buffer, int offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glArrayObjectATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexArrayObject.nglArrayObjectATI(array, size, type, stride, buffer, offset, function_pointer);
    }

    private static native void nglArrayObjectATI(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glGetArrayObjectATI(int array, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glGetArrayObjectfvATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ATIVertexArrayObject.nglGetArrayObjectfvATI(array, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetArrayObjectfvATI(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glGetArrayObjectATI(int array, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glGetArrayObjectivATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ATIVertexArrayObject.nglGetArrayObjectivATI(array, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetArrayObjectivATI(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glVariantArrayObjectATI(int id2, int type, int stride, int buffer, int offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glVariantArrayObjectATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexArrayObject.nglVariantArrayObjectATI(id2, type, stride, buffer, offset, function_pointer);
    }

    private static native void nglVariantArrayObjectATI(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glGetVariantArrayObjectATI(int id2, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glGetVariantArrayObjectfvATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ATIVertexArrayObject.nglGetVariantArrayObjectfvATI(id2, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVariantArrayObjectfvATI(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glGetVariantArrayObjectATI(int id2, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_array_object_glGetVariantArrayObjectivATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ATIVertexArrayObject.nglGetVariantArrayObjectivATI(id2, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVariantArrayObjectivATI(int var0, int var1, IntBuffer var2, int var3, long var4);
}

