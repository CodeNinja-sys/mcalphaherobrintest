/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class NVFramebufferMultisampleCoverage {
    public static final int GL_RENDERBUFFER_COVERAGE_SAMPLES_NV = 36011;
    public static final int GL_RENDERBUFFER_COLOR_SAMPLES_NV = 36368;
    public static final int GL_MAX_MULTISAMPLE_COVERAGE_MODES_NV = 36369;
    public static final int GL_MULITSAMPLE_COVERAGE_MODES_NV = 36370;

    private NVFramebufferMultisampleCoverage() {
    }

    public static void glRenderbufferStorageMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalformat, int width, int height) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.NV_framebuffer_multisample_coverage_glRenderbufferStorageMultisampleCoverageNV_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        NVFramebufferMultisampleCoverage.nglRenderbufferStorageMultisampleCoverageNV(target, coverageSamples, colorSamples, internalformat, width, height, function_pointer);
    }

    private static native void nglRenderbufferStorageMultisampleCoverageNV(int var0, int var1, int var2, int var3, int var4, int var5, long var6);
}

