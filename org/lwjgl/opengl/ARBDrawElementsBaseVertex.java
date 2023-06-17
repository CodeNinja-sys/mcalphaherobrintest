/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;

public final class ARBDrawElementsBaseVertex {
    private ARBDrawElementsBaseVertex() {
    }

    public static void glDrawElementsBaseVertex(int mode, ByteBuffer indices, int basevertex) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_elements_base_vertex_glDrawElementsBaseVertex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        ARBDrawElementsBaseVertex.nglDrawElementsBaseVertex(mode, indices.remaining(), 5121, indices, indices.position(), basevertex, function_pointer);
    }

    public static void glDrawElementsBaseVertex(int mode, IntBuffer indices, int basevertex) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_elements_base_vertex_glDrawElementsBaseVertex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        ARBDrawElementsBaseVertex.nglDrawElementsBaseVertex(mode, indices.remaining(), 5125, indices, indices.position() << 2, basevertex, function_pointer);
    }

    public static void glDrawElementsBaseVertex(int mode, ShortBuffer indices, int basevertex) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_elements_base_vertex_glDrawElementsBaseVertex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        ARBDrawElementsBaseVertex.nglDrawElementsBaseVertex(mode, indices.remaining(), 5123, indices, indices.position() << 1, basevertex, function_pointer);
    }

    private static native void nglDrawElementsBaseVertex(int var0, int var1, int var2, Buffer var3, int var4, int var5, long var6);

    public static void glDrawElementsBaseVertex(int mode, int count, int type, long indices_buffer_offset, int basevertex) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_elements_base_vertex_glDrawElementsBaseVertex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOenabled(caps);
        ARBDrawElementsBaseVertex.nglDrawElementsBaseVertexBO(mode, count, type, indices_buffer_offset, basevertex, function_pointer);
    }

    private static native void nglDrawElementsBaseVertexBO(int var0, int var1, int var2, long var3, int var5, long var6);

    public static void glDrawRangeElementsBaseVertex(int mode, int start, int end, ByteBuffer indices, int basevertex) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_elements_base_vertex_glDrawRangeElementsBaseVertex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        ARBDrawElementsBaseVertex.nglDrawRangeElementsBaseVertex(mode, start, end, indices.remaining(), 5121, indices, indices.position(), basevertex, function_pointer);
    }

    public static void glDrawRangeElementsBaseVertex(int mode, int start, int end, IntBuffer indices, int basevertex) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_elements_base_vertex_glDrawRangeElementsBaseVertex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        ARBDrawElementsBaseVertex.nglDrawRangeElementsBaseVertex(mode, start, end, indices.remaining(), 5125, indices, indices.position() << 2, basevertex, function_pointer);
    }

    public static void glDrawRangeElementsBaseVertex(int mode, int start, int end, ShortBuffer indices, int basevertex) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_elements_base_vertex_glDrawRangeElementsBaseVertex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        ARBDrawElementsBaseVertex.nglDrawRangeElementsBaseVertex(mode, start, end, indices.remaining(), 5123, indices, indices.position() << 1, basevertex, function_pointer);
    }

    private static native void nglDrawRangeElementsBaseVertex(int var0, int var1, int var2, int var3, int var4, Buffer var5, int var6, int var7, long var8);

    public static void glDrawRangeElementsBaseVertex(int mode, int start, int end, int count, int type, long indices_buffer_offset, int basevertex) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_elements_base_vertex_glDrawRangeElementsBaseVertex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOenabled(caps);
        ARBDrawElementsBaseVertex.nglDrawRangeElementsBaseVertexBO(mode, start, end, count, type, indices_buffer_offset, basevertex, function_pointer);
    }

    private static native void nglDrawRangeElementsBaseVertexBO(int var0, int var1, int var2, int var3, int var4, long var5, int var7, long var8);

    public static void glDrawElementsInstancedBaseVertex(int mode, ByteBuffer indices, int primcount, int basevertex) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_elements_base_vertex_glDrawElementsInstancedBaseVertex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        ARBDrawElementsBaseVertex.nglDrawElementsInstancedBaseVertex(mode, indices.remaining(), 5121, indices, indices.position(), primcount, basevertex, function_pointer);
    }

    public static void glDrawElementsInstancedBaseVertex(int mode, IntBuffer indices, int primcount, int basevertex) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_elements_base_vertex_glDrawElementsInstancedBaseVertex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        ARBDrawElementsBaseVertex.nglDrawElementsInstancedBaseVertex(mode, indices.remaining(), 5125, indices, indices.position() << 2, primcount, basevertex, function_pointer);
    }

    public static void glDrawElementsInstancedBaseVertex(int mode, ShortBuffer indices, int primcount, int basevertex) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_elements_base_vertex_glDrawElementsInstancedBaseVertex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        ARBDrawElementsBaseVertex.nglDrawElementsInstancedBaseVertex(mode, indices.remaining(), 5123, indices, indices.position() << 1, primcount, basevertex, function_pointer);
    }

    private static native void nglDrawElementsInstancedBaseVertex(int var0, int var1, int var2, Buffer var3, int var4, int var5, int var6, long var7);

    public static void glDrawElementsInstancedBaseVertex(int mode, int count, int type, long indices_buffer_offset, int primcount, int basevertex) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_draw_elements_base_vertex_glDrawElementsInstancedBaseVertex_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOenabled(caps);
        ARBDrawElementsBaseVertex.nglDrawElementsInstancedBaseVertexBO(mode, count, type, indices_buffer_offset, primcount, basevertex, function_pointer);
    }

    private static native void nglDrawElementsInstancedBaseVertexBO(int var0, int var1, int var2, long var3, int var5, int var6, long var7);
}

