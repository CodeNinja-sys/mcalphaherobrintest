/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class AMDVertexShaderTessellator {
    public static final int GL_SAMPLER_BUFFER_AMD = 36865;
    public static final int GL_INT_SAMPLER_BUFFER_AMD = 36866;
    public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER_AMD = 36867;
    public static final int GL_DISCRETE_AMD = 36870;
    public static final int GL_CONTINUOUS_AMD = 36871;
    public static final int GL_TESSELLATION_MODE_AMD = 36868;
    public static final int GL_TESSELLATION_FACTOR_AMD = 36869;

    private AMDVertexShaderTessellator() {
    }

    public static void glTessellationFactorAMD(float factor) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_vertex_shader_tessellator_glTessellationFactorAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        AMDVertexShaderTessellator.nglTessellationFactorAMD(factor, function_pointer);
    }

    private static native void nglTessellationFactorAMD(float var0, long var1);

    public static void glTessellationModeAMD(int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_vertex_shader_tessellator_glTessellationModeAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        AMDVertexShaderTessellator.nglTessellationModeAMD(mode, function_pointer);
    }

    private static native void nglTessellationModeAMD(int var0, long var1);
}

