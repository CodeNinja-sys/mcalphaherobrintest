/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBFramebufferObject {
    public static final int GL_FRAMEBUFFER = 36160;
    public static final int GL_READ_FRAMEBUFFER = 36008;
    public static final int GL_DRAW_FRAMEBUFFER = 36009;
    public static final int GL_RENDERBUFFER = 36161;
    public static final int GL_STENCIL_INDEX1 = 36166;
    public static final int GL_STENCIL_INDEX4 = 36167;
    public static final int GL_STENCIL_INDEX8 = 36168;
    public static final int GL_STENCIL_INDEX16 = 36169;
    public static final int GL_RENDERBUFFER_WIDTH = 36162;
    public static final int GL_RENDERBUFFER_HEIGHT = 36163;
    public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 36164;
    public static final int GL_RENDERBUFFER_RED_SIZE = 36176;
    public static final int GL_RENDERBUFFER_GREEN_SIZE = 36177;
    public static final int GL_RENDERBUFFER_BLUE_SIZE = 36178;
    public static final int GL_RENDERBUFFER_ALPHA_SIZE = 36179;
    public static final int GL_RENDERBUFFER_DEPTH_SIZE = 36180;
    public static final int GL_RENDERBUFFER_STENCIL_SIZE = 36181;
    public static final int GL_RENDERBUFFER_SAMPLES = 36011;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 36048;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 36049;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 36050;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 36051;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 36052;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING = 33296;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE = 33297;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE = 33298;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE = 33299;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE = 33300;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE = 33301;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE = 33302;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE = 33303;
    public static final int GL_SRGB = 35904;
    public static final int GL_UNSIGNED_NORMALIZED = 35863;
    public static final int GL_FRAMEBUFFER_DEFAULT = 33304;
    public static final int GL_INDEX = 33314;
    public static final int GL_COLOR_ATTACHMENT0 = 36064;
    public static final int GL_COLOR_ATTACHMENT1 = 36065;
    public static final int GL_COLOR_ATTACHMENT2 = 36066;
    public static final int GL_COLOR_ATTACHMENT3 = 36067;
    public static final int GL_COLOR_ATTACHMENT4 = 36068;
    public static final int GL_COLOR_ATTACHMENT5 = 36069;
    public static final int GL_COLOR_ATTACHMENT6 = 36070;
    public static final int GL_COLOR_ATTACHMENT7 = 36071;
    public static final int GL_COLOR_ATTACHMENT8 = 36072;
    public static final int GL_COLOR_ATTACHMENT9 = 36073;
    public static final int GL_COLOR_ATTACHMENT10 = 36074;
    public static final int GL_COLOR_ATTACHMENT11 = 36075;
    public static final int GL_COLOR_ATTACHMENT12 = 36076;
    public static final int GL_COLOR_ATTACHMENT13 = 36077;
    public static final int GL_COLOR_ATTACHMENT14 = 36078;
    public static final int GL_COLOR_ATTACHMENT15 = 36079;
    public static final int GL_DEPTH_ATTACHMENT = 36096;
    public static final int GL_STENCIL_ATTACHMENT = 36128;
    public static final int GL_DEPTH_STENCIL_ATTACHMENT = 33306;
    public static final int GL_MAX_SAMPLES = 36183;
    public static final int GL_FRAMEBUFFER_COMPLETE = 36053;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 36054;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 36055;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = 36059;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER = 36060;
    public static final int GL_FRAMEBUFFER_UNSUPPORTED = 36061;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 36182;
    public static final int GL_FRAMEBUFFER_UNDEFINED = 33305;
    public static final int GL_FRAMEBUFFER_BINDING = 36006;
    public static final int GL_DRAW_FRAMEBUFFER_BINDING = 36006;
    public static final int GL_READ_FRAMEBUFFER_BINDING = 36010;
    public static final int GL_RENDERBUFFER_BINDING = 36007;
    public static final int GL_MAX_COLOR_ATTACHMENTS = 36063;
    public static final int GL_MAX_RENDERBUFFER_SIZE = 34024;
    public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 1286;
    public static final int GL_DEPTH_STENCIL = 34041;
    public static final int GL_UNSIGNED_INT_24_8 = 34042;
    public static final int GL_DEPTH24_STENCIL8 = 35056;
    public static final int GL_TEXTURE_STENCIL_SIZE = 35057;

    private ARBFramebufferObject() {
    }

    public static boolean glIsRenderbuffer(int renderbuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glIsRenderbuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = ARBFramebufferObject.nglIsRenderbuffer(renderbuffer, function_pointer);
        return __result;
    }

    private static native boolean nglIsRenderbuffer(int var0, long var1);

    public static void glBindRenderbuffer(int target, int renderbuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glBindRenderbuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBFramebufferObject.nglBindRenderbuffer(target, renderbuffer, function_pointer);
    }

    private static native void nglBindRenderbuffer(int var0, int var1, long var2);

    public static void glDeleteRenderbuffers(IntBuffer renderbuffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glDeleteRenderbuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(renderbuffers);
        ARBFramebufferObject.nglDeleteRenderbuffers(renderbuffers.remaining(), renderbuffers, renderbuffers.position(), function_pointer);
    }

    private static native void nglDeleteRenderbuffers(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteRenderbuffers(int renderbuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glDeleteRenderbuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBFramebufferObject.nglDeleteRenderbuffers(1, APIUtils.getBufferInt().put(0, renderbuffer), 0, function_pointer);
    }

    public static void glGenRenderbuffers(IntBuffer renderbuffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glGenRenderbuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(renderbuffers);
        ARBFramebufferObject.nglGenRenderbuffers(renderbuffers.remaining(), renderbuffers, renderbuffers.position(), function_pointer);
    }

    private static native void nglGenRenderbuffers(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenRenderbuffers() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glGenRenderbuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer renderbuffers = APIUtils.getBufferInt();
        ARBFramebufferObject.nglGenRenderbuffers(1, renderbuffers, renderbuffers.position(), function_pointer);
        return renderbuffers.get(0);
    }

    public static void glRenderbufferStorage(int target, int internalformat, int width, int height) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glRenderbufferStorage_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBFramebufferObject.nglRenderbufferStorage(target, internalformat, width, height, function_pointer);
    }

    private static native void nglRenderbufferStorage(int var0, int var1, int var2, int var3, long var4);

    public static void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glRenderbufferStorageMultisample_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBFramebufferObject.nglRenderbufferStorageMultisample(target, samples, internalformat, width, height, function_pointer);
    }

    private static native void nglRenderbufferStorageMultisample(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glGetRenderbufferParameter(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glGetRenderbufferParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBFramebufferObject.nglGetRenderbufferParameteriv(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetRenderbufferParameteriv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetRenderbufferParameter(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glGetRenderbufferParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBFramebufferObject.nglGetRenderbufferParameteriv(target, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static boolean glIsFramebuffer(int framebuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glIsFramebuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = ARBFramebufferObject.nglIsFramebuffer(framebuffer, function_pointer);
        return __result;
    }

    private static native boolean nglIsFramebuffer(int var0, long var1);

    public static void glBindFramebuffer(int target, int framebuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glBindFramebuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBFramebufferObject.nglBindFramebuffer(target, framebuffer, function_pointer);
    }

    private static native void nglBindFramebuffer(int var0, int var1, long var2);

    public static void glDeleteFramebuffers(IntBuffer framebuffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glDeleteFramebuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(framebuffers);
        ARBFramebufferObject.nglDeleteFramebuffers(framebuffers.remaining(), framebuffers, framebuffers.position(), function_pointer);
    }

    private static native void nglDeleteFramebuffers(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteFramebuffers(int framebuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glDeleteFramebuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBFramebufferObject.nglDeleteFramebuffers(1, APIUtils.getBufferInt().put(0, framebuffer), 0, function_pointer);
    }

    public static void glGenFramebuffers(IntBuffer framebuffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glGenFramebuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(framebuffers);
        ARBFramebufferObject.nglGenFramebuffers(framebuffers.remaining(), framebuffers, framebuffers.position(), function_pointer);
    }

    private static native void nglGenFramebuffers(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenFramebuffers() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glGenFramebuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer framebuffers = APIUtils.getBufferInt();
        ARBFramebufferObject.nglGenFramebuffers(1, framebuffers, framebuffers.position(), function_pointer);
        return framebuffers.get(0);
    }

    public static int glCheckFramebufferStatus(int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glCheckFramebufferStatus_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = ARBFramebufferObject.nglCheckFramebufferStatus(target, function_pointer);
        return __result;
    }

    private static native int nglCheckFramebufferStatus(int var0, long var1);

    public static void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glFramebufferTexture1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBFramebufferObject.nglFramebufferTexture1D(target, attachment, textarget, texture, level, function_pointer);
    }

    private static native void nglFramebufferTexture1D(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glFramebufferTexture2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBFramebufferObject.nglFramebufferTexture2D(target, attachment, textarget, texture, level, function_pointer);
    }

    private static native void nglFramebufferTexture2D(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glFramebufferTexture3D(int target, int attachment, int textarget, int texture, int level, int layer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glFramebufferTexture3D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBFramebufferObject.nglFramebufferTexture3D(target, attachment, textarget, texture, level, layer, function_pointer);
    }

    private static native void nglFramebufferTexture3D(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glFramebufferTextureLayer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBFramebufferObject.nglFramebufferTextureLayer(target, attachment, texture, level, layer, function_pointer);
    }

    private static native void nglFramebufferTextureLayer(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glFramebufferRenderbuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBFramebufferObject.nglFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer, function_pointer);
    }

    private static native void nglFramebufferRenderbuffer(int var0, int var1, int var2, int var3, long var4);

    public static void glGetFramebufferAttachmentParameter(int target, int attachment, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glGetFramebufferAttachmentParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        ARBFramebufferObject.nglGetFramebufferAttachmentParameteriv(target, attachment, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetFramebufferAttachmentParameteriv(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static int glGetFramebufferAttachmentParameter(int target, int attachment, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glGetFramebufferAttachmentParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBFramebufferObject.nglGetFramebufferAttachmentParameteriv(target, attachment, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glBlitFramebuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBFramebufferObject.nglBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter, function_pointer);
    }

    private static native void nglBlitFramebuffer(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10);

    public static void glGenerateMipmap(int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_framebuffer_object_glGenerateMipmap_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBFramebufferObject.nglGenerateMipmap(target, function_pointer);
    }

    private static native void nglGenerateMipmap(int var0, long var1);
}

