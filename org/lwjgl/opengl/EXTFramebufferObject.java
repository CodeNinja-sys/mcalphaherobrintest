/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class EXTFramebufferObject {
    public static final int GL_FRAMEBUFFER_EXT = 36160;
    public static final int GL_RENDERBUFFER_EXT = 36161;
    public static final int GL_STENCIL_INDEX1_EXT = 36166;
    public static final int GL_STENCIL_INDEX4_EXT = 36167;
    public static final int GL_STENCIL_INDEX8_EXT = 36168;
    public static final int GL_STENCIL_INDEX16_EXT = 36169;
    public static final int GL_RENDERBUFFER_WIDTH_EXT = 36162;
    public static final int GL_RENDERBUFFER_HEIGHT_EXT = 36163;
    public static final int GL_RENDERBUFFER_INTERNAL_FORMAT_EXT = 36164;
    public static final int GL_RENDERBUFFER_RED_SIZE_EXT = 36176;
    public static final int GL_RENDERBUFFER_GREEN_SIZE_EXT = 36177;
    public static final int GL_RENDERBUFFER_BLUE_SIZE_EXT = 36178;
    public static final int GL_RENDERBUFFER_ALPHA_SIZE_EXT = 36179;
    public static final int GL_RENDERBUFFER_DEPTH_SIZE_EXT = 36180;
    public static final int GL_RENDERBUFFER_STENCIL_SIZE_EXT = 36181;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE_EXT = 36048;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME_EXT = 36049;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL_EXT = 36050;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE_EXT = 36051;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_3D_ZOFFSET_EXT = 36052;
    public static final int GL_COLOR_ATTACHMENT0_EXT = 36064;
    public static final int GL_COLOR_ATTACHMENT1_EXT = 36065;
    public static final int GL_COLOR_ATTACHMENT2_EXT = 36066;
    public static final int GL_COLOR_ATTACHMENT3_EXT = 36067;
    public static final int GL_COLOR_ATTACHMENT4_EXT = 36068;
    public static final int GL_COLOR_ATTACHMENT5_EXT = 36069;
    public static final int GL_COLOR_ATTACHMENT6_EXT = 36070;
    public static final int GL_COLOR_ATTACHMENT7_EXT = 36071;
    public static final int GL_COLOR_ATTACHMENT8_EXT = 36072;
    public static final int GL_COLOR_ATTACHMENT9_EXT = 36073;
    public static final int GL_COLOR_ATTACHMENT10_EXT = 36074;
    public static final int GL_COLOR_ATTACHMENT11_EXT = 36075;
    public static final int GL_COLOR_ATTACHMENT12_EXT = 36076;
    public static final int GL_COLOR_ATTACHMENT13_EXT = 36077;
    public static final int GL_COLOR_ATTACHMENT14_EXT = 36078;
    public static final int GL_COLOR_ATTACHMENT15_EXT = 36079;
    public static final int GL_DEPTH_ATTACHMENT_EXT = 36096;
    public static final int GL_STENCIL_ATTACHMENT_EXT = 36128;
    public static final int GL_FRAMEBUFFER_COMPLETE_EXT = 36053;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT = 36054;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT = 36055;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT = 36057;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT = 36058;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_EXT = 36059;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_EXT = 36060;
    public static final int GL_FRAMEBUFFER_UNSUPPORTED_EXT = 36061;
    public static final int GL_FRAMEBUFFER_BINDING_EXT = 36006;
    public static final int GL_RENDERBUFFER_BINDING_EXT = 36007;
    public static final int GL_MAX_COLOR_ATTACHMENTS_EXT = 36063;
    public static final int GL_MAX_RENDERBUFFER_SIZE_EXT = 34024;
    public static final int GL_INVALID_FRAMEBUFFER_OPERATION_EXT = 1286;

    private EXTFramebufferObject() {
    }

    public static boolean glIsRenderbufferEXT(int renderbuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glIsRenderbufferEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = EXTFramebufferObject.nglIsRenderbufferEXT(renderbuffer, function_pointer);
        return __result;
    }

    private static native boolean nglIsRenderbufferEXT(int var0, long var1);

    public static void glBindRenderbufferEXT(int target, int renderbuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glBindRenderbufferEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTFramebufferObject.nglBindRenderbufferEXT(target, renderbuffer, function_pointer);
    }

    private static native void nglBindRenderbufferEXT(int var0, int var1, long var2);

    public static void glDeleteRenderbuffersEXT(IntBuffer renderbuffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glDeleteRenderbuffersEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(renderbuffers);
        EXTFramebufferObject.nglDeleteRenderbuffersEXT(renderbuffers.remaining(), renderbuffers, renderbuffers.position(), function_pointer);
    }

    private static native void nglDeleteRenderbuffersEXT(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteRenderbuffersEXT(int renderbuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glDeleteRenderbuffersEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTFramebufferObject.nglDeleteRenderbuffersEXT(1, APIUtils.getBufferInt().put(0, renderbuffer), 0, function_pointer);
    }

    public static void glGenRenderbuffersEXT(IntBuffer renderbuffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glGenRenderbuffersEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(renderbuffers);
        EXTFramebufferObject.nglGenRenderbuffersEXT(renderbuffers.remaining(), renderbuffers, renderbuffers.position(), function_pointer);
    }

    private static native void nglGenRenderbuffersEXT(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenRenderbuffersEXT() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glGenRenderbuffersEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer renderbuffers = APIUtils.getBufferInt();
        EXTFramebufferObject.nglGenRenderbuffersEXT(1, renderbuffers, renderbuffers.position(), function_pointer);
        return renderbuffers.get(0);
    }

    public static void glRenderbufferStorageEXT(int target, int internalformat, int width, int height) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glRenderbufferStorageEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTFramebufferObject.nglRenderbufferStorageEXT(target, internalformat, width, height, function_pointer);
    }

    private static native void nglRenderbufferStorageEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glGetRenderbufferParameterEXT(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glGetRenderbufferParameterivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        EXTFramebufferObject.nglGetRenderbufferParameterivEXT(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetRenderbufferParameterivEXT(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetRenderbufferParameterEXT(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glGetRenderbufferParameterivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        EXTFramebufferObject.nglGetRenderbufferParameterivEXT(target, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static boolean glIsFramebufferEXT(int framebuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glIsFramebufferEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = EXTFramebufferObject.nglIsFramebufferEXT(framebuffer, function_pointer);
        return __result;
    }

    private static native boolean nglIsFramebufferEXT(int var0, long var1);

    public static void glBindFramebufferEXT(int target, int framebuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glBindFramebufferEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTFramebufferObject.nglBindFramebufferEXT(target, framebuffer, function_pointer);
    }

    private static native void nglBindFramebufferEXT(int var0, int var1, long var2);

    public static void glDeleteFramebuffersEXT(IntBuffer framebuffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glDeleteFramebuffersEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(framebuffers);
        EXTFramebufferObject.nglDeleteFramebuffersEXT(framebuffers.remaining(), framebuffers, framebuffers.position(), function_pointer);
    }

    private static native void nglDeleteFramebuffersEXT(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteFramebuffersEXT(int framebuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glDeleteFramebuffersEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTFramebufferObject.nglDeleteFramebuffersEXT(1, APIUtils.getBufferInt().put(0, framebuffer), 0, function_pointer);
    }

    public static void glGenFramebuffersEXT(IntBuffer framebuffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glGenFramebuffersEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(framebuffers);
        EXTFramebufferObject.nglGenFramebuffersEXT(framebuffers.remaining(), framebuffers, framebuffers.position(), function_pointer);
    }

    private static native void nglGenFramebuffersEXT(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenFramebuffersEXT() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glGenFramebuffersEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer framebuffers = APIUtils.getBufferInt();
        EXTFramebufferObject.nglGenFramebuffersEXT(1, framebuffers, framebuffers.position(), function_pointer);
        return framebuffers.get(0);
    }

    public static int glCheckFramebufferStatusEXT(int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glCheckFramebufferStatusEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = EXTFramebufferObject.nglCheckFramebufferStatusEXT(target, function_pointer);
        return __result;
    }

    private static native int nglCheckFramebufferStatusEXT(int var0, long var1);

    public static void glFramebufferTexture1DEXT(int target, int attachment, int textarget, int texture, int level) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glFramebufferTexture1DEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTFramebufferObject.nglFramebufferTexture1DEXT(target, attachment, textarget, texture, level, function_pointer);
    }

    private static native void nglFramebufferTexture1DEXT(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glFramebufferTexture2DEXT(int target, int attachment, int textarget, int texture, int level) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glFramebufferTexture2DEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTFramebufferObject.nglFramebufferTexture2DEXT(target, attachment, textarget, texture, level, function_pointer);
    }

    private static native void nglFramebufferTexture2DEXT(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glFramebufferTexture3DEXT(int target, int attachment, int textarget, int texture, int level, int zoffset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glFramebufferTexture3DEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTFramebufferObject.nglFramebufferTexture3DEXT(target, attachment, textarget, texture, level, zoffset, function_pointer);
    }

    private static native void nglFramebufferTexture3DEXT(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glFramebufferRenderbufferEXT(int target, int attachment, int renderbuffertarget, int renderbuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glFramebufferRenderbufferEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTFramebufferObject.nglFramebufferRenderbufferEXT(target, attachment, renderbuffertarget, renderbuffer, function_pointer);
    }

    private static native void nglFramebufferRenderbufferEXT(int var0, int var1, int var2, int var3, long var4);

    public static void glGetFramebufferAttachmentParameterEXT(int target, int attachment, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glGetFramebufferAttachmentParameterivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        EXTFramebufferObject.nglGetFramebufferAttachmentParameterivEXT(target, attachment, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetFramebufferAttachmentParameterivEXT(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static int glGetFramebufferAttachmentParameterEXT(int target, int attachment, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glGetFramebufferAttachmentParameterivEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        EXTFramebufferObject.nglGetFramebufferAttachmentParameterivEXT(target, attachment, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGenerateMipmapEXT(int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.EXT_framebuffer_object_glGenerateMipmapEXT_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        EXTFramebufferObject.nglGenerateMipmapEXT(target, function_pointer);
    }

    private static native void nglGenerateMipmapEXT(int var0, long var1);
}

