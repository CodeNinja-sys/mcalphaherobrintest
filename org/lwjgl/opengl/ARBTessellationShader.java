/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBTessellationShader {
    public static final int GL_PATCHES = 14;
    public static final int GL_PATCH_VERTICES = 36466;
    public static final int GL_PATCH_DEFAULT_INNER_LEVEL = 36467;
    public static final int GL_PATCH_DEFAULT_OUTER_LEVEL = 36468;
    public static final int GL_TESS_CONTROL_OUTPUT_VERTICES = 36469;
    public static final int GL_TESS_GEN_MODE = 36470;
    public static final int GL_TESS_GEN_SPACING = 36471;
    public static final int GL_TESS_GEN_VERTEX_ORDER = 36472;
    public static final int GL_TESS_GEN_POINT_MODE = 36473;
    public static final int GL_TRIANGLES = 4;
    public static final int GL_QUADS = 7;
    public static final int GL_ISOLINES = 36474;
    public static final int GL_EQUAL = 514;
    public static final int GL_FRACTIONAL_ODD = 36475;
    public static final int GL_FRACTIONAL_EVEN = 36476;
    public static final int GL_CCW = 2305;
    public static final int GL_CW = 2304;
    public static final int GL_FALSE = 0;
    public static final int GL_TRUE = 1;
    public static final int GL_MAX_PATCH_VERTICES = 36477;
    public static final int GL_MAX_TESS_GEN_LEVEL = 36478;
    public static final int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS = 36479;
    public static final int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS = 36480;
    public static final int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS = 36481;
    public static final int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS = 36482;
    public static final int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS = 36483;
    public static final int GL_MAX_TESS_PATCH_COMPONENTS = 36484;
    public static final int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS = 36485;
    public static final int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS = 36486;
    public static final int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS = 36489;
    public static final int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS = 36490;
    public static final int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS = 34924;
    public static final int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS = 34925;
    public static final int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS = 36382;
    public static final int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS = 36383;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER = 34032;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER = 34033;
    public static final int GL_TESS_EVALUATION_SHADER = 36487;
    public static final int GL_TESS_CONTROL_SHADER = 36488;

    private ARBTessellationShader() {
    }

    public static void glPatchParameteri(int pname, int value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_tessellation_shader_glPatchParameteri_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBTessellationShader.nglPatchParameteri(pname, value, function_pointer);
    }

    private static native void nglPatchParameteri(int var0, int var1, long var2);

    public static void glPatchParameter(int pname, FloatBuffer values) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_tessellation_shader_glPatchParameterfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(values, 4);
        ARBTessellationShader.nglPatchParameterfv(pname, values, values.position(), function_pointer);
    }

    private static native void nglPatchParameterfv(int var0, FloatBuffer var1, int var2, long var3);
}

