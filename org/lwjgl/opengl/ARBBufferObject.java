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
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.StateTracker;

public class ARBBufferObject {
    public static final int GL_STREAM_DRAW_ARB = 35040;
    public static final int GL_STREAM_READ_ARB = 35041;
    public static final int GL_STREAM_COPY_ARB = 35042;
    public static final int GL_STATIC_DRAW_ARB = 35044;
    public static final int GL_STATIC_READ_ARB = 35045;
    public static final int GL_STATIC_COPY_ARB = 35046;
    public static final int GL_DYNAMIC_DRAW_ARB = 35048;
    public static final int GL_DYNAMIC_READ_ARB = 35049;
    public static final int GL_DYNAMIC_COPY_ARB = 35050;
    public static final int GL_READ_ONLY_ARB = 35000;
    public static final int GL_WRITE_ONLY_ARB = 35001;
    public static final int GL_READ_WRITE_ARB = 35002;
    public static final int GL_BUFFER_SIZE_ARB = 34660;
    public static final int GL_BUFFER_USAGE_ARB = 34661;
    public static final int GL_BUFFER_ACCESS_ARB = 35003;
    public static final int GL_BUFFER_MAPPED_ARB = 35004;
    public static final int GL_BUFFER_MAP_POINTER_ARB = 35005;

    public static void glBindBufferARB(int target, int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glBindBufferARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        StateTracker.bindBuffer(caps, target, buffer);
        ARBBufferObject.nglBindBufferARB(target, buffer, function_pointer);
    }

    private static native void nglBindBufferARB(int var0, int var1, long var2);

    public static void glDeleteBuffersARB(IntBuffer buffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glDeleteBuffersARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(buffers);
        ARBBufferObject.nglDeleteBuffersARB(buffers.remaining(), buffers, buffers.position(), function_pointer);
    }

    private static native void nglDeleteBuffersARB(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteBuffersARB(int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glDeleteBuffersARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBBufferObject.nglDeleteBuffersARB(1, APIUtils.getBufferInt().put(0, buffer), 0, function_pointer);
    }

    public static void glGenBuffersARB(IntBuffer buffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glGenBuffersARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(buffers);
        ARBBufferObject.nglGenBuffersARB(buffers.remaining(), buffers, buffers.position(), function_pointer);
    }

    private static native void nglGenBuffersARB(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenBuffersARB() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glGenBuffersARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer buffers = APIUtils.getBufferInt();
        ARBBufferObject.nglGenBuffersARB(1, buffers, buffers.position(), function_pointer);
        return buffers.get(0);
    }

    public static boolean glIsBufferARB(int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glIsBufferARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = ARBBufferObject.nglIsBufferARB(buffer, function_pointer);
        return __result;
    }

    private static native boolean nglIsBufferARB(int var0, long var1);

    public static void glBufferDataARB(int target, long size, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glBufferDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBBufferObject.nglBufferDataARB(target, size, null, 0, usage, function_pointer);
    }

    public static void glBufferDataARB(int target, ByteBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glBufferDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglBufferDataARB(target, data.remaining(), data, data.position(), usage, function_pointer);
    }

    public static void glBufferDataARB(int target, DoubleBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glBufferDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglBufferDataARB(target, data.remaining() << 3, data, data.position() << 3, usage, function_pointer);
    }

    public static void glBufferDataARB(int target, FloatBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glBufferDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglBufferDataARB(target, data.remaining() << 2, data, data.position() << 2, usage, function_pointer);
    }

    public static void glBufferDataARB(int target, IntBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glBufferDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglBufferDataARB(target, data.remaining() << 2, data, data.position() << 2, usage, function_pointer);
    }

    public static void glBufferDataARB(int target, ShortBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glBufferDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglBufferDataARB(target, data.remaining() << 1, data, data.position() << 1, usage, function_pointer);
    }

    private static native void nglBufferDataARB(int var0, long var1, Buffer var3, int var4, int var5, long var6);

    public static void glBufferSubDataARB(int target, long offset, ByteBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glBufferSubDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglBufferSubDataARB(target, offset, data.remaining(), data, data.position(), function_pointer);
    }

    public static void glBufferSubDataARB(int target, long offset, DoubleBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glBufferSubDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglBufferSubDataARB(target, offset, data.remaining() << 3, data, data.position() << 3, function_pointer);
    }

    public static void glBufferSubDataARB(int target, long offset, FloatBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glBufferSubDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglBufferSubDataARB(target, offset, data.remaining() << 2, data, data.position() << 2, function_pointer);
    }

    public static void glBufferSubDataARB(int target, long offset, IntBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glBufferSubDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglBufferSubDataARB(target, offset, data.remaining() << 2, data, data.position() << 2, function_pointer);
    }

    public static void glBufferSubDataARB(int target, long offset, ShortBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glBufferSubDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglBufferSubDataARB(target, offset, data.remaining() << 1, data, data.position() << 1, function_pointer);
    }

    private static native void nglBufferSubDataARB(int var0, long var1, long var3, Buffer var5, int var6, long var7);

    public static void glGetBufferSubDataARB(int target, long offset, ByteBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glGetBufferSubDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglGetBufferSubDataARB(target, offset, data.remaining(), data, data.position(), function_pointer);
    }

    public static void glGetBufferSubDataARB(int target, long offset, DoubleBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glGetBufferSubDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglGetBufferSubDataARB(target, offset, data.remaining() << 3, data, data.position() << 3, function_pointer);
    }

    public static void glGetBufferSubDataARB(int target, long offset, FloatBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glGetBufferSubDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglGetBufferSubDataARB(target, offset, data.remaining() << 2, data, data.position() << 2, function_pointer);
    }

    public static void glGetBufferSubDataARB(int target, long offset, IntBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glGetBufferSubDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglGetBufferSubDataARB(target, offset, data.remaining() << 2, data, data.position() << 2, function_pointer);
    }

    public static void glGetBufferSubDataARB(int target, long offset, ShortBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glGetBufferSubDataARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        ARBBufferObject.nglGetBufferSubDataARB(target, offset, data.remaining() << 1, data, data.position() << 1, function_pointer);
    }

    private static native void nglGetBufferSubDataARB(int var0, long var1, long var3, Buffer var5, int var6, long var7);

    public static ByteBuffer glMapBufferARB(int target, int access, ByteBuffer old_buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glMapBufferARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (old_buffer != null) {
            BufferChecks.checkDirect(old_buffer);
        }
        ByteBuffer __result = ARBBufferObject.nglMapBufferARB(target, access, GLChecks.getBufferObjectSizeARB(caps, target), old_buffer, function_pointer);
        return __result;
    }

    public static ByteBuffer glMapBufferARB(int target, int access, long length, ByteBuffer old_buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glMapBufferARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (old_buffer != null) {
            BufferChecks.checkDirect(old_buffer);
        }
        ByteBuffer __result = ARBBufferObject.nglMapBufferARB(target, access, length, old_buffer, function_pointer);
        return __result;
    }

    private static native ByteBuffer nglMapBufferARB(int var0, int var1, long var2, ByteBuffer var4, long var5);

    public static boolean glUnmapBufferARB(int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glUnmapBufferARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = ARBBufferObject.nglUnmapBufferARB(target, function_pointer);
        return __result;
    }

    private static native boolean nglUnmapBufferARB(int var0, long var1);

    public static void glGetBufferParameterARB(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glGetBufferParameterivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBBufferObject.nglGetBufferParameterivARB(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetBufferParameterivARB(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetBufferParameterARB(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glGetBufferParameterivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBBufferObject.nglGetBufferParameterivARB(target, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static ByteBuffer glGetBufferPointerARB(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_buffer_object_glGetBufferPointervARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ByteBuffer __result = ARBBufferObject.nglGetBufferPointervARB(target, pname, GLChecks.getBufferObjectSizeARB(caps, target), function_pointer);
        return __result;
    }

    private static native ByteBuffer nglGetBufferPointervARB(int var0, int var1, long var2, long var4);
}

