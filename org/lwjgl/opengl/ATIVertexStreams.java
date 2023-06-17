/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ATIVertexStreams {
    public static final int GL_MAX_VERTEX_STREAMS_ATI = 34667;
    public static final int GL_VERTEX_SOURCE_ATI = 34668;
    public static final int GL_VERTEX_STREAM0_ATI = 34669;
    public static final int GL_VERTEX_STREAM1_ATI = 34670;
    public static final int GL_VERTEX_STREAM2_ATI = 34671;
    public static final int GL_VERTEX_STREAM3_ATI = 34672;
    public static final int GL_VERTEX_STREAM4_ATI = 34673;
    public static final int GL_VERTEX_STREAM5_ATI = 34674;
    public static final int GL_VERTEX_STREAM6_ATI = 34675;
    public static final int GL_VERTEX_STREAM7_ATI = 34676;

    private ATIVertexStreams() {
    }

    public static void glVertexStream2fATI(int stream, float x2, float y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glVertexStream2fATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglVertexStream2fATI(stream, x2, y2, function_pointer);
    }

    private static native void nglVertexStream2fATI(int var0, float var1, float var2, long var3);

    public static void glVertexStream2dATI(int stream, double x2, double y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glVertexStream2dATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglVertexStream2dATI(stream, x2, y2, function_pointer);
    }

    private static native void nglVertexStream2dATI(int var0, double var1, double var3, long var5);

    public static void glVertexStream2iATI(int stream, int x2, int y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glVertexStream2iATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglVertexStream2iATI(stream, x2, y2, function_pointer);
    }

    private static native void nglVertexStream2iATI(int var0, int var1, int var2, long var3);

    public static void glVertexStream2sATI(int stream, short x2, short y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glVertexStream2sATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglVertexStream2sATI(stream, x2, y2, function_pointer);
    }

    private static native void nglVertexStream2sATI(int var0, short var1, short var2, long var3);

    public static void glVertexStream3fATI(int stream, float x2, float y2, float z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glVertexStream3fATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglVertexStream3fATI(stream, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexStream3fATI(int var0, float var1, float var2, float var3, long var4);

    public static void glVertexStream3dATI(int stream, double x2, double y2, double z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glVertexStream3dATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglVertexStream3dATI(stream, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexStream3dATI(int var0, double var1, double var3, double var5, long var7);

    public static void glVertexStream3iATI(int stream, int x2, int y2, int z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glVertexStream3iATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglVertexStream3iATI(stream, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexStream3iATI(int var0, int var1, int var2, int var3, long var4);

    public static void glVertexStream3sATI(int stream, short x2, short y2, short z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glVertexStream3sATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglVertexStream3sATI(stream, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexStream3sATI(int var0, short var1, short var2, short var3, long var4);

    public static void glVertexStream4fATI(int stream, float x2, float y2, float z2, float w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glVertexStream4fATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglVertexStream4fATI(stream, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexStream4fATI(int var0, float var1, float var2, float var3, float var4, long var5);

    public static void glVertexStream4dATI(int stream, double x2, double y2, double z2, double w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glVertexStream4dATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglVertexStream4dATI(stream, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexStream4dATI(int var0, double var1, double var3, double var5, double var7, long var9);

    public static void glVertexStream4iATI(int stream, int x2, int y2, int z2, int w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glVertexStream4iATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglVertexStream4iATI(stream, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexStream4iATI(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glVertexStream4sATI(int stream, short x2, short y2, short z2, short w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glVertexStream4sATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglVertexStream4sATI(stream, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexStream4sATI(int var0, short var1, short var2, short var3, short var4, long var5);

    public static void glNormalStream3bATI(int stream, byte x2, byte y2, byte z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glNormalStream3bATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglNormalStream3bATI(stream, x2, y2, z2, function_pointer);
    }

    private static native void nglNormalStream3bATI(int var0, byte var1, byte var2, byte var3, long var4);

    public static void glNormalStream3fATI(int stream, float x2, float y2, float z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glNormalStream3fATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglNormalStream3fATI(stream, x2, y2, z2, function_pointer);
    }

    private static native void nglNormalStream3fATI(int var0, float var1, float var2, float var3, long var4);

    public static void glNormalStream3dATI(int stream, double x2, double y2, double z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glNormalStream3dATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglNormalStream3dATI(stream, x2, y2, z2, function_pointer);
    }

    private static native void nglNormalStream3dATI(int var0, double var1, double var3, double var5, long var7);

    public static void glNormalStream3iATI(int stream, int x2, int y2, int z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glNormalStream3iATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglNormalStream3iATI(stream, x2, y2, z2, function_pointer);
    }

    private static native void nglNormalStream3iATI(int var0, int var1, int var2, int var3, long var4);

    public static void glNormalStream3sATI(int stream, short x2, short y2, short z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glNormalStream3sATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglNormalStream3sATI(stream, x2, y2, z2, function_pointer);
    }

    private static native void nglNormalStream3sATI(int var0, short var1, short var2, short var3, long var4);

    public static void glClientActiveVertexStreamATI(int stream) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glClientActiveVertexStreamATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglClientActiveVertexStreamATI(stream, function_pointer);
    }

    private static native void nglClientActiveVertexStreamATI(int var0, long var1);

    public static void glVertexBlendEnvfATI(int pname, float param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glVertexBlendEnvfATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglVertexBlendEnvfATI(pname, param, function_pointer);
    }

    private static native void nglVertexBlendEnvfATI(int var0, float var1, long var2);

    public static void glVertexBlendEnviATI(int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ATI_vertex_streams_glVertexBlendEnviATI_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ATIVertexStreams.nglVertexBlendEnviATI(pname, param, function_pointer);
    }

    private static native void nglVertexBlendEnviATI(int var0, int var1, long var2);
}

