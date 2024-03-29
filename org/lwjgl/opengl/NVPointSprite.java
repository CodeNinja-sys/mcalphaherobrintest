/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVPointSprite {
    public static final int GL_POINT_SPRITE_NV = 34913;
    public static final int GL_COORD_REPLACE_NV = 34914;
    public static final int GL_POINT_SPRITE_R_MODE_NV = 34915;

    private NVPointSprite() {
    }

    public static void glPointParameteriNV(int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_point_sprite_glPointParameteriNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVPointSprite.nglPointParameteriNV(pname, param, function_pointer);
    }

    private static native void nglPointParameteriNV(int var0, int var1, long var2);

    public static void glPointParameterNV(int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_point_sprite_glPointParameterivNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        NVPointSprite.nglPointParameterivNV(pname, params, params.position(), function_pointer);
    }

    private static native void nglPointParameterivNV(int var0, IntBuffer var1, int var2, long var3);
}

