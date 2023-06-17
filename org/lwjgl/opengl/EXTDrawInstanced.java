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

public final class EXTDrawInstanced {
    private EXTDrawInstanced() {
    }

    public static void glDrawArraysInstancedEXT(int mode, int first, int count, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_draw_instanced_glDrawArraysInstancedEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTDrawInstanced.nglDrawArraysInstancedEXT(mode, first, count, primcount, function_pointer);
    }

    private static native void nglDrawArraysInstancedEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glDrawElementsInstancedEXT(int mode, ByteBuffer indices, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_draw_instanced_glDrawElementsInstancedEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        EXTDrawInstanced.nglDrawElementsInstancedEXT(mode, indices.remaining(), 5121, indices, indices.position(), primcount, function_pointer);
    }

    public static void glDrawElementsInstancedEXT(int mode, IntBuffer indices, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_draw_instanced_glDrawElementsInstancedEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        EXTDrawInstanced.nglDrawElementsInstancedEXT(mode, indices.remaining(), 5125, indices, indices.position() << 2, primcount, function_pointer);
    }

    public static void glDrawElementsInstancedEXT(int mode, ShortBuffer indices, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_draw_instanced_glDrawElementsInstancedEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOdisabled(caps);
        BufferChecks.checkDirect(indices);
        EXTDrawInstanced.nglDrawElementsInstancedEXT(mode, indices.remaining(), 5123, indices, indices.position() << 1, primcount, function_pointer);
    }

    private static native void nglDrawElementsInstancedEXT(int var0, int var1, int var2, Buffer var3, int var4, int var5, long var6);

    public static void glDrawElementsInstancedEXT(int mode, int count, int type, long indices_buffer_offset, int primcount) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_draw_instanced_glDrawElementsInstancedEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureElementVBOenabled(caps);
        EXTDrawInstanced.nglDrawElementsInstancedEXTBO(mode, count, type, indices_buffer_offset, primcount, function_pointer);
    }

    private static native void nglDrawElementsInstancedEXTBO(int var0, int var1, int var2, long var3, int var5, long var6);
}

