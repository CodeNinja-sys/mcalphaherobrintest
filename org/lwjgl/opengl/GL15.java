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

public final class GL15 {
    public static final int GL_ARRAY_BUFFER = 34962;
    public static final int GL_ELEMENT_ARRAY_BUFFER = 34963;
    public static final int GL_ARRAY_BUFFER_BINDING = 34964;
    public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 34965;
    public static final int GL_VERTEX_ARRAY_BUFFER_BINDING = 34966;
    public static final int GL_NORMAL_ARRAY_BUFFER_BINDING = 34967;
    public static final int GL_COLOR_ARRAY_BUFFER_BINDING = 34968;
    public static final int GL_INDEX_ARRAY_BUFFER_BINDING = 34969;
    public static final int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING = 34970;
    public static final int GL_EDGE_FLAG_ARRAY_BUFFER_BINDING = 34971;
    public static final int GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING = 34972;
    public static final int GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING = 34973;
    public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING = 34974;
    public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 34975;
    public static final int GL_STREAM_DRAW = 35040;
    public static final int GL_STREAM_READ = 35041;
    public static final int GL_STREAM_COPY = 35042;
    public static final int GL_STATIC_DRAW = 35044;
    public static final int GL_STATIC_READ = 35045;
    public static final int GL_STATIC_COPY = 35046;
    public static final int GL_DYNAMIC_DRAW = 35048;
    public static final int GL_DYNAMIC_READ = 35049;
    public static final int GL_DYNAMIC_COPY = 35050;
    public static final int GL_READ_ONLY = 35000;
    public static final int GL_WRITE_ONLY = 35001;
    public static final int GL_READ_WRITE = 35002;
    public static final int GL_BUFFER_SIZE = 34660;
    public static final int GL_BUFFER_USAGE = 34661;
    public static final int GL_BUFFER_ACCESS = 35003;
    public static final int GL_BUFFER_MAPPED = 35004;
    public static final int GL_BUFFER_MAP_POINTER = 35005;
    public static final int FOG_COORD_SRC = 33872;
    public static final int GL_FOG_COORD = 33873;
    public static final int GL_CURRENT_FOG_COORD = 33875;
    public static final int GL_FOG_COORD_ARRAY_TYPE = 33876;
    public static final int GL_FOG_COORD_ARRAY_STRIDE = 33877;
    public static final int GL_FOG_COORD_ARRAY_POINTER = 33878;
    public static final int GL_FOG_COORD_ARRAY = 33879;
    public static final int GL_FOG_COORD_ARRAY_BUFFER_BINDING = 34973;
    public static final int GL_SRC0_RGB = 34176;
    public static final int GL_SRC1_RGB = 34177;
    public static final int GL_SRC2_RGB = 34178;
    public static final int GL_SRC0_ALPHA = 34184;
    public static final int GL_SRC1_ALPHA = 34185;
    public static final int GL_SRC2_ALPHA = 34186;
    public static final int GL_SAMPLES_PASSED = 35092;
    public static final int GL_QUERY_COUNTER_BITS = 34916;
    public static final int GL_CURRENT_QUERY = 34917;
    public static final int GL_QUERY_RESULT = 34918;
    public static final int GL_QUERY_RESULT_AVAILABLE = 34919;

    private GL15() {
    }

    public static void glBindBuffer(int target, int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glBindBuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        StateTracker.bindBuffer(caps, target, buffer);
        GL15.nglBindBuffer(target, buffer, function_pointer);
    }

    private static native void nglBindBuffer(int var0, int var1, long var2);

    public static void glDeleteBuffers(IntBuffer buffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glDeleteBuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(buffers);
        GL15.nglDeleteBuffers(buffers.remaining(), buffers, buffers.position(), function_pointer);
    }

    private static native void nglDeleteBuffers(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteBuffers(int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glDeleteBuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL15.nglDeleteBuffers(1, APIUtils.getBufferInt().put(0, buffer), 0, function_pointer);
    }

    public static void glGenBuffers(IntBuffer buffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGenBuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(buffers);
        GL15.nglGenBuffers(buffers.remaining(), buffers, buffers.position(), function_pointer);
    }

    private static native void nglGenBuffers(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenBuffers() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGenBuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer buffers = APIUtils.getBufferInt();
        GL15.nglGenBuffers(1, buffers, buffers.position(), function_pointer);
        return buffers.get(0);
    }

    public static boolean glIsBuffer(int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glIsBuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = GL15.nglIsBuffer(buffer, function_pointer);
        return __result;
    }

    private static native boolean nglIsBuffer(int var0, long var1);

    public static void glBufferData(int target, long size, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glBufferData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL15.nglBufferData(target, size, null, 0, usage, function_pointer);
    }

    public static void glBufferData(int target, ByteBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glBufferData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglBufferData(target, data.remaining(), data, data.position(), usage, function_pointer);
    }

    public static void glBufferData(int target, DoubleBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glBufferData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglBufferData(target, data.remaining() << 3, data, data.position() << 3, usage, function_pointer);
    }

    public static void glBufferData(int target, FloatBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glBufferData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglBufferData(target, data.remaining() << 2, data, data.position() << 2, usage, function_pointer);
    }

    public static void glBufferData(int target, IntBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glBufferData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglBufferData(target, data.remaining() << 2, data, data.position() << 2, usage, function_pointer);
    }

    public static void glBufferData(int target, ShortBuffer data, int usage) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glBufferData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglBufferData(target, data.remaining() << 1, data, data.position() << 1, usage, function_pointer);
    }

    private static native void nglBufferData(int var0, long var1, Buffer var3, int var4, int var5, long var6);

    public static void glBufferSubData(int target, long offset, ByteBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glBufferSubData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglBufferSubData(target, offset, data.remaining(), data, data.position(), function_pointer);
    }

    public static void glBufferSubData(int target, long offset, DoubleBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glBufferSubData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglBufferSubData(target, offset, data.remaining() << 3, data, data.position() << 3, function_pointer);
    }

    public static void glBufferSubData(int target, long offset, FloatBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glBufferSubData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglBufferSubData(target, offset, data.remaining() << 2, data, data.position() << 2, function_pointer);
    }

    public static void glBufferSubData(int target, long offset, IntBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glBufferSubData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglBufferSubData(target, offset, data.remaining() << 2, data, data.position() << 2, function_pointer);
    }

    public static void glBufferSubData(int target, long offset, ShortBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glBufferSubData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglBufferSubData(target, offset, data.remaining() << 1, data, data.position() << 1, function_pointer);
    }

    private static native void nglBufferSubData(int var0, long var1, long var3, Buffer var5, int var6, long var7);

    public static void glGetBufferSubData(int target, long offset, ByteBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGetBufferSubData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglGetBufferSubData(target, offset, data.remaining(), data, data.position(), function_pointer);
    }

    public static void glGetBufferSubData(int target, long offset, DoubleBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGetBufferSubData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglGetBufferSubData(target, offset, data.remaining() << 3, data, data.position() << 3, function_pointer);
    }

    public static void glGetBufferSubData(int target, long offset, FloatBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGetBufferSubData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglGetBufferSubData(target, offset, data.remaining() << 2, data, data.position() << 2, function_pointer);
    }

    public static void glGetBufferSubData(int target, long offset, IntBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGetBufferSubData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglGetBufferSubData(target, offset, data.remaining() << 2, data, data.position() << 2, function_pointer);
    }

    public static void glGetBufferSubData(int target, long offset, ShortBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGetBufferSubData_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        GL15.nglGetBufferSubData(target, offset, data.remaining() << 1, data, data.position() << 1, function_pointer);
    }

    private static native void nglGetBufferSubData(int var0, long var1, long var3, Buffer var5, int var6, long var7);

    public static ByteBuffer glMapBuffer(int target, int access, ByteBuffer old_buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glMapBuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (old_buffer != null) {
            BufferChecks.checkDirect(old_buffer);
        }
        ByteBuffer __result = GL15.nglMapBuffer(target, access, GLChecks.getBufferObjectSize(caps, target), old_buffer, function_pointer);
        return __result;
    }

    public static ByteBuffer glMapBuffer(int target, int access, long length, ByteBuffer old_buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glMapBuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (old_buffer != null) {
            BufferChecks.checkDirect(old_buffer);
        }
        ByteBuffer __result = GL15.nglMapBuffer(target, access, length, old_buffer, function_pointer);
        return __result;
    }

    private static native ByteBuffer nglMapBuffer(int var0, int var1, long var2, ByteBuffer var4, long var5);

    public static boolean glUnmapBuffer(int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glUnmapBuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = GL15.nglUnmapBuffer(target, function_pointer);
        return __result;
    }

    private static native boolean nglUnmapBuffer(int var0, long var1);

    public static void glGetBufferParameter(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGetBufferParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL15.nglGetBufferParameteriv(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetBufferParameteriv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetBufferParameter(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGetBufferParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL15.nglGetBufferParameteriv(target, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static ByteBuffer glGetBufferPointer(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGetBufferPointerv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ByteBuffer __result = GL15.nglGetBufferPointerv(target, pname, GLChecks.getBufferObjectSize(caps, target), function_pointer);
        return __result;
    }

    private static native ByteBuffer nglGetBufferPointerv(int var0, int var1, long var2, long var4);

    public static void glGenQueries(IntBuffer ids) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGenQueries_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(ids);
        GL15.nglGenQueries(ids.remaining(), ids, ids.position(), function_pointer);
    }

    private static native void nglGenQueries(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenQueries() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGenQueries_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer ids = APIUtils.getBufferInt();
        GL15.nglGenQueries(1, ids, ids.position(), function_pointer);
        return ids.get(0);
    }

    public static void glDeleteQueries(IntBuffer ids) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glDeleteQueries_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(ids);
        GL15.nglDeleteQueries(ids.remaining(), ids, ids.position(), function_pointer);
    }

    private static native void nglDeleteQueries(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteQueries(int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glDeleteQueries_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL15.nglDeleteQueries(1, APIUtils.getBufferInt().put(0, id2), 0, function_pointer);
    }

    public static boolean glIsQuery(int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glIsQuery_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = GL15.nglIsQuery(id2, function_pointer);
        return __result;
    }

    private static native boolean nglIsQuery(int var0, long var1);

    public static void glBeginQuery(int target, int id2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glBeginQuery_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL15.nglBeginQuery(target, id2, function_pointer);
    }

    private static native void nglBeginQuery(int var0, int var1, long var2);

    public static void glEndQuery(int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glEndQuery_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL15.nglEndQuery(target, function_pointer);
    }

    private static native void nglEndQuery(int var0, long var1);

    public static void glGetQuery(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGetQueryiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        GL15.nglGetQueryiv(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetQueryiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetQuery(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGetQueryiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL15.nglGetQueryiv(target, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetQueryObject(int id2, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGetQueryObjectiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        GL15.nglGetQueryObjectiv(id2, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetQueryObjectiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetQueryObjecti(int id2, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGetQueryObjectiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL15.nglGetQueryObjectiv(id2, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetQueryObjectu(int id2, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGetQueryObjectuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        GL15.nglGetQueryObjectuiv(id2, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetQueryObjectuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetQueryObjectui(int id2, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL15_glGetQueryObjectuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL15.nglGetQueryObjectuiv(id2, pname, params, params.position(), function_pointer);
        return params.get(0);
    }
}

