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

public final class ARBVertexShader {
    public static final int GL_VERTEX_SHADER_ARB = 35633;
    public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS_ARB = 35658;
    public static final int GL_MAX_VARYING_FLOATS_ARB = 35659;
    public static final int GL_MAX_VERTEX_ATTRIBS_ARB = 34921;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS_ARB = 34930;
    public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS_ARB = 35660;
    public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS_ARB = 35661;
    public static final int GL_MAX_TEXTURE_COORDS_ARB = 34929;
    public static final int GL_VERTEX_PROGRAM_POINT_SIZE_ARB = 34370;
    public static final int GL_VERTEX_PROGRAM_TWO_SIDE_ARB = 34371;
    public static final int GL_OBJECT_ACTIVE_ATTRIBUTES_ARB = 35721;
    public static final int GL_OBJECT_ACTIVE_ATTRIBUTE_MAX_LENGTH_ARB = 35722;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB = 34338;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB = 34339;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB = 34340;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE_ARB = 34341;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB = 34922;
    public static final int GL_CURRENT_VERTEX_ATTRIB_ARB = 34342;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER_ARB = 34373;
    public static final int GL_FLOAT = 5126;
    public static final int GL_FLOAT_VEC2_ARB = 35664;
    public static final int GL_FLOAT_VEC3_ARB = 35665;
    public static final int GL_FLOAT_VEC4_ARB = 35666;
    public static final int GL_FLOAT_MAT2_ARB = 35674;
    public static final int GL_FLOAT_MAT3_ARB = 35675;
    public static final int GL_FLOAT_MAT4_ARB = 35676;

    private ARBVertexShader() {
    }

    public static void glVertexAttrib1sARB(int index, short v0) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttrib1sARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglVertexAttrib1sARB(index, v0, function_pointer);
    }

    private static native void nglVertexAttrib1sARB(int var0, short var1, long var2);

    public static void glVertexAttrib1fARB(int index, float v0) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttrib1fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglVertexAttrib1fARB(index, v0, function_pointer);
    }

    private static native void nglVertexAttrib1fARB(int var0, float var1, long var2);

    public static void glVertexAttrib1dARB(int index, double v0) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttrib1dARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglVertexAttrib1dARB(index, v0, function_pointer);
    }

    private static native void nglVertexAttrib1dARB(int var0, double var1, long var3);

    public static void glVertexAttrib2sARB(int index, short v0, short v1) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttrib2sARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglVertexAttrib2sARB(index, v0, v1, function_pointer);
    }

    private static native void nglVertexAttrib2sARB(int var0, short var1, short var2, long var3);

    public static void glVertexAttrib2fARB(int index, float v0, float v1) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttrib2fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglVertexAttrib2fARB(index, v0, v1, function_pointer);
    }

    private static native void nglVertexAttrib2fARB(int var0, float var1, float var2, long var3);

    public static void glVertexAttrib2dARB(int index, double v0, double v1) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttrib2dARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglVertexAttrib2dARB(index, v0, v1, function_pointer);
    }

    private static native void nglVertexAttrib2dARB(int var0, double var1, double var3, long var5);

    public static void glVertexAttrib3sARB(int index, short v0, short v1, short v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttrib3sARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglVertexAttrib3sARB(index, v0, v1, v2, function_pointer);
    }

    private static native void nglVertexAttrib3sARB(int var0, short var1, short var2, short var3, long var4);

    public static void glVertexAttrib3fARB(int index, float v0, float v1, float v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttrib3fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglVertexAttrib3fARB(index, v0, v1, v2, function_pointer);
    }

    private static native void nglVertexAttrib3fARB(int var0, float var1, float var2, float var3, long var4);

    public static void glVertexAttrib3dARB(int index, double v0, double v1, double v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttrib3dARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglVertexAttrib3dARB(index, v0, v1, v2, function_pointer);
    }

    private static native void nglVertexAttrib3dARB(int var0, double var1, double var3, double var5, long var7);

    public static void glVertexAttrib4sARB(int index, short v0, short v1, short v2, short v3) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttrib4sARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglVertexAttrib4sARB(index, v0, v1, v2, v3, function_pointer);
    }

    private static native void nglVertexAttrib4sARB(int var0, short var1, short var2, short var3, short var4, long var5);

    public static void glVertexAttrib4fARB(int index, float v0, float v1, float v2, float v3) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttrib4fARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglVertexAttrib4fARB(index, v0, v1, v2, v3, function_pointer);
    }

    private static native void nglVertexAttrib4fARB(int var0, float var1, float var2, float var3, float var4, long var5);

    public static void glVertexAttrib4dARB(int index, double v0, double v1, double v2, double v3) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttrib4dARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglVertexAttrib4dARB(index, v0, v1, v2, v3, function_pointer);
    }

    private static native void nglVertexAttrib4dARB(int var0, double var1, double var3, double var5, double var7, long var9);

    public static void glVertexAttrib4NubARB(int index, byte x2, byte y2, byte z2, byte w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttrib4NubARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglVertexAttrib4NubARB(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttrib4NubARB(int var0, byte var1, byte var2, byte var3, byte var4, long var5);

    public static void glVertexAttribPointerARB(int index, int size, boolean normalized, int stride, DoubleBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttribPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        ARBVertexShader.nglVertexAttribPointerARB(index, size, 5130, normalized, stride, buffer, buffer.position() << 3, function_pointer);
    }

    public static void glVertexAttribPointerARB(int index, int size, boolean normalized, int stride, FloatBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttribPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        ARBVertexShader.nglVertexAttribPointerARB(index, size, 5126, normalized, stride, buffer, buffer.position() << 2, function_pointer);
    }

    public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, ByteBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttribPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        ARBVertexShader.nglVertexAttribPointerARB(index, size, unsigned ? 5121 : 5120, normalized, stride, buffer, buffer.position(), function_pointer);
    }

    public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, IntBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttribPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        ARBVertexShader.nglVertexAttribPointerARB(index, size, unsigned ? 5125 : 5124, normalized, stride, buffer, buffer.position() << 2, function_pointer);
    }

    public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, ShortBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttribPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).glVertexAttribPointer_buffer[index] = buffer;
        ARBVertexShader.nglVertexAttribPointerARB(index, size, unsigned ? 5123 : 5122, normalized, stride, buffer, buffer.position() << 1, function_pointer);
    }

    private static native void nglVertexAttribPointerARB(int var0, int var1, int var2, boolean var3, int var4, Buffer var5, int var6, long var7);

    public static void glVertexAttribPointerARB(int index, int size, int type, boolean normalized, int stride, long buffer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glVertexAttribPointerARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        ARBVertexShader.nglVertexAttribPointerARBBO(index, size, type, normalized, stride, buffer_buffer_offset, function_pointer);
    }

    private static native void nglVertexAttribPointerARBBO(int var0, int var1, int var2, boolean var3, int var4, long var5, long var7);

    public static void glEnableVertexAttribArrayARB(int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glEnableVertexAttribArrayARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglEnableVertexAttribArrayARB(index, function_pointer);
    }

    private static native void nglEnableVertexAttribArrayARB(int var0, long var1);

    public static void glDisableVertexAttribArrayARB(int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glDisableVertexAttribArrayARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglDisableVertexAttribArrayARB(index, function_pointer);
    }

    private static native void nglDisableVertexAttribArrayARB(int var0, long var1);

    public static void glBindAttribLocationARB(int programObj, int index, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glBindAttribLocationARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        ARBVertexShader.nglBindAttribLocationARB(programObj, index, name, name.position(), function_pointer);
    }

    private static native void nglBindAttribLocationARB(int var0, int var1, ByteBuffer var2, int var3, long var4);

    public static void glBindAttribLocationARB(int programObj, int index, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glBindAttribLocationARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBVertexShader.nglBindAttribLocationARB(programObj, index, APIUtils.getBufferNT(name), 0, function_pointer);
    }

    public static void glGetActiveAttribARB(int programObj, int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glGetActiveAttribARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkBuffer(size, 1);
        BufferChecks.checkBuffer(type, 1);
        BufferChecks.checkDirect(name);
        ARBVertexShader.nglGetActiveAttribARB(programObj, index, name.remaining(), length, length != null ? length.position() : 0, size, size.position(), type, type.position(), name, name.position(), function_pointer);
    }

    private static native void nglGetActiveAttribARB(int var0, int var1, int var2, IntBuffer var3, int var4, IntBuffer var5, int var6, IntBuffer var7, int var8, ByteBuffer var9, int var10, long var11);

    public static String glGetActiveAttribARB(int programObj, int index, int maxLength, IntBuffer sizeType) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glGetActiveAttribARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(sizeType, 2);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(maxLength);
        ARBVertexShader.nglGetActiveAttribARB(programObj, index, maxLength, name_length, 0, sizeType, sizeType.position(), sizeType, sizeType.position() + 1, name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static String glGetActiveAttribARB(int programObj, int index, int maxLength) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glGetActiveAttribARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(maxLength);
        ARBVertexShader.nglGetActiveAttribARB(programObj, index, maxLength, name_length, 0, APIUtils.getBufferInt(), 0, APIUtils.getBufferInt(), 1, name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static int glGetActiveAttribSizeARB(int programObj, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glGetActiveAttribARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer size = APIUtils.getBufferInt();
        ARBVertexShader.nglGetActiveAttribARB(programObj, index, 0, null, 0, size, size.position(), size, 1, APIUtils.getBufferByte(0), 0, function_pointer);
        return size.get(0);
    }

    public static int glGetActiveAttribTypeARB(int programObj, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glGetActiveAttribARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer type = APIUtils.getBufferInt();
        ARBVertexShader.nglGetActiveAttribARB(programObj, index, 0, null, 0, type, 1, type, type.position(), APIUtils.getBufferByte(0), 0, function_pointer);
        return type.get(0);
    }

    public static int glGetAttribLocationARB(int programObj, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glGetAttribLocationARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        int __result = ARBVertexShader.nglGetAttribLocationARB(programObj, name, name.position(), function_pointer);
        return __result;
    }

    private static native int nglGetAttribLocationARB(int var0, ByteBuffer var1, int var2, long var3);

    public static int glGetAttribLocationARB(int programObj, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glGetAttribLocationARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = ARBVertexShader.nglGetAttribLocationARB(programObj, APIUtils.getBufferNT(name), 0, function_pointer);
        return __result;
    }

    public static void glGetVertexAttribARB(int index, int pname, FloatBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glGetVertexAttribfvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBVertexShader.nglGetVertexAttribfvARB(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribfvARB(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glGetVertexAttribARB(int index, int pname, DoubleBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glGetVertexAttribdvARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBVertexShader.nglGetVertexAttribdvARB(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribdvARB(int var0, int var1, DoubleBuffer var2, int var3, long var4);

    public static void glGetVertexAttribARB(int index, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glGetVertexAttribivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBVertexShader.nglGetVertexAttribivARB(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribivARB(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static ByteBuffer glGetVertexAttribPointerARB(int index, int pname, long result_size) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_vertex_shader_glGetVertexAttribPointervARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ByteBuffer __result = ARBVertexShader.nglGetVertexAttribPointervARB(index, pname, result_size, function_pointer);
        return __result;
    }

    private static native ByteBuffer nglGetVertexAttribPointervARB(int var0, int var1, long var2, long var4);
}

