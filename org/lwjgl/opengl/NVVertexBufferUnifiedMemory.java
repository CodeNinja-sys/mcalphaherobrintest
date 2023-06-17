/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.LongBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVVertexBufferUnifiedMemory {
    public static final int GL_VERTEX_ATTRIB_ARRAY_UNIFIED_NV = 36638;
    public static final int GL_ELEMENT_ARRAY_UNIFIED_NV = 36639;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ADDRESS_NV = 36640;
    public static final int GL_TEXTURE_COORD_ARRAY_ADDRESS_NV = 36645;
    public static final int GL_VERTEX_ARRAY_ADDRESS_NV = 36641;
    public static final int GL_NORMAL_ARRAY_ADDRESS_NV = 36642;
    public static final int GL_COLOR_ARRAY_ADDRESS_NV = 36643;
    public static final int GL_INDEX_ARRAY_ADDRESS_NV = 36644;
    public static final int GL_EDGE_FLAG_ARRAY_ADDRESS_NV = 36646;
    public static final int GL_SECONDARY_COLOR_ARRAY_ADDRESS_NV = 36647;
    public static final int GL_FOG_COORD_ARRAY_ADDRESS_NV = 36648;
    public static final int GL_ELEMENT_ARRAY_ADDRESS_NV = 36649;
    public static final int GL_VERTEX_ATTRIB_ARRAY_LENGTH_NV = 36650;
    public static final int GL_TEXTURE_COORD_ARRAY_LENGTH_NV = 36655;
    public static final int GL_VERTEX_ARRAY_LENGTH_NV = 36651;
    public static final int GL_NORMAL_ARRAY_LENGTH_NV = 36652;
    public static final int GL_COLOR_ARRAY_LENGTH_NV = 36653;
    public static final int GL_INDEX_ARRAY_LENGTH_NV = 36654;
    public static final int GL_EDGE_FLAG_ARRAY_LENGTH_NV = 36656;
    public static final int GL_SECONDARY_COLOR_ARRAY_LENGTH_NV = 36657;
    public static final int GL_FOG_COORD_ARRAY_LENGTH_NV = 36658;
    public static final int GL_ELEMENT_ARRAY_LENGTH_NV = 36659;

    private NVVertexBufferUnifiedMemory() {
    }

    public static void glBufferAddressRangeNV(int pname, int index, long address, long length) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_buffer_unified_memory_glBufferAddressRangeNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexBufferUnifiedMemory.nglBufferAddressRangeNV(pname, index, address, length, function_pointer);
    }

    private static native void nglBufferAddressRangeNV(int var0, int var1, long var2, long var4, long var6);

    public static void glVertexFormatNV(int size, int type, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_buffer_unified_memory_glVertexFormatNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexBufferUnifiedMemory.nglVertexFormatNV(size, type, stride, function_pointer);
    }

    private static native void nglVertexFormatNV(int var0, int var1, int var2, long var3);

    public static void glNormalFormatNV(int type, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_buffer_unified_memory_glNormalFormatNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexBufferUnifiedMemory.nglNormalFormatNV(type, stride, function_pointer);
    }

    private static native void nglNormalFormatNV(int var0, int var1, long var2);

    public static void glColorFormatNV(int size, int type, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_buffer_unified_memory_glColorFormatNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexBufferUnifiedMemory.nglColorFormatNV(size, type, stride, function_pointer);
    }

    private static native void nglColorFormatNV(int var0, int var1, int var2, long var3);

    public static void glIndexFormatNV(int type, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_buffer_unified_memory_glIndexFormatNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexBufferUnifiedMemory.nglIndexFormatNV(type, stride, function_pointer);
    }

    private static native void nglIndexFormatNV(int var0, int var1, long var2);

    public static void glTexCoordFormatNV(int size, int type, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_buffer_unified_memory_glTexCoordFormatNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexBufferUnifiedMemory.nglTexCoordFormatNV(size, type, stride, function_pointer);
    }

    private static native void nglTexCoordFormatNV(int var0, int var1, int var2, long var3);

    public static void glEdgeFlagFormatNV(int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_buffer_unified_memory_glEdgeFlagFormatNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexBufferUnifiedMemory.nglEdgeFlagFormatNV(stride, function_pointer);
    }

    private static native void nglEdgeFlagFormatNV(int var0, long var1);

    public static void glSecondaryColorFormatNV(int size, int type, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_buffer_unified_memory_glSecondaryColorFormatNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexBufferUnifiedMemory.nglSecondaryColorFormatNV(size, type, stride, function_pointer);
    }

    private static native void nglSecondaryColorFormatNV(int var0, int var1, int var2, long var3);

    public static void glFogCoordFormatNV(int type, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_buffer_unified_memory_glFogCoordFormatNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexBufferUnifiedMemory.nglFogCoordFormatNV(type, stride, function_pointer);
    }

    private static native void nglFogCoordFormatNV(int var0, int var1, long var2);

    public static void glVertexAttribFormatNV(int index, int size, int type, boolean normalized, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_buffer_unified_memory_glVertexAttribFormatNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexBufferUnifiedMemory.nglVertexAttribFormatNV(index, size, type, normalized, stride, function_pointer);
    }

    private static native void nglVertexAttribFormatNV(int var0, int var1, int var2, boolean var3, int var4, long var5);

    public static void glVertexAttribIFormatNV(int index, int size, int type, int stride) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_buffer_unified_memory_glVertexAttribIFormatNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVVertexBufferUnifiedMemory.nglVertexAttribIFormatNV(index, size, type, stride, function_pointer);
    }

    private static native void nglVertexAttribIFormatNV(int var0, int var1, int var2, int var3, long var4);

    public static void glGetIntegeruNV(int value, int index, LongBuffer result) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_buffer_unified_memory_glGetIntegerui64i_vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(result, 1);
        NVVertexBufferUnifiedMemory.nglGetIntegerui64i_vNV(value, index, result, result.position(), function_pointer);
    }

    private static native void nglGetIntegerui64i_vNV(int var0, int var1, LongBuffer var2, int var3, long var4);

    public static long glGetIntegeruNV(int value, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_vertex_buffer_unified_memory_glGetIntegerui64i_vNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        LongBuffer result = APIUtils.getBufferLong();
        NVVertexBufferUnifiedMemory.nglGetIntegerui64i_vNV(value, index, result, result.position(), function_pointer);
        return result.get(0);
    }
}

