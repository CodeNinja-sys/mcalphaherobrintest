/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class EXTTextureArray {
    public static final int GL_TEXTURE_1D_ARRAY_EXT = 35864;
    public static final int GL_TEXTURE_2D_ARRAY_EXT = 35866;
    public static final int GL_PROXY_TEXTURE_2D_ARRAY_EXT = 35867;
    public static final int GL_PROXY_TEXTURE_1D_ARRAY_EXT = 35865;
    public static final int GL_TEXTURE_BINDING_1D_ARRAY_EXT = 35868;
    public static final int GL_TEXTURE_BINDING_2D_ARRAY_EXT = 35869;
    public static final int GL_MAX_ARRAY_TEXTURE_LAYERS_EXT = 35071;
    public static final int GL_COMPARE_REF_DEPTH_TO_TEXTURE_EXT = 34894;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER_EXT = 36052;
    public static final int GL_SAMPLER_1D_ARRAY_EXT = 36288;
    public static final int GL_SAMPLER_2D_ARRAY_EXT = 36289;
    public static final int GL_SAMPLER_1D_ARRAY_SHADOW_EXT = 36291;
    public static final int GL_SAMPLER_2D_ARRAY_SHADOW_EXT = 36292;

    private EXTTextureArray() {
    }

    public static void glFramebufferTextureLayerEXT(int target, int attachment, int texture, int level, int layer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_texture_array_glFramebufferTextureLayerEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTTextureArray.nglFramebufferTextureLayerEXT(target, attachment, texture, level, layer, function_pointer);
    }

    private static native void nglFramebufferTextureLayerEXT(int var0, int var1, int var2, int var3, int var4, long var5);
}

