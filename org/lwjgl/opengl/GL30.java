/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLChecks;
import org.lwjgl.opengl.GLContext;

public final class GL30 {
    public static final int GL_MAJOR_VERSION = 33307;
    public static final int GL_MINOR_VERSION = 33308;
    public static final int GL_NUM_EXTENSIONS = 33309;
    public static final int GL_CONTEXT_FLAGS = 33310;
    public static final int GL_CONTEXT_FLAG_FORWARD_COMPATIBLE_BIT = 1;
    public static final int GL_DEPTH_BUFFER = 33315;
    public static final int GL_STENCIL_BUFFER = 33316;
    public static final int GL_COMPRESSED_RED = 33317;
    public static final int GL_COMPRESSED_RG = 33318;
    public static final int GL_COMPARE_REF_TO_TEXTURE = 34894;
    public static final int GL_CLIP_DISTANCE0 = 12288;
    public static final int GL_CLIP_DISTANCE1 = 12289;
    public static final int GL_CLIP_DISTANCE2 = 12290;
    public static final int GL_CLIP_DISTANCE3 = 12291;
    public static final int GL_CLIP_DISTANCE4 = 12292;
    public static final int GL_CLIP_DISTANCE5 = 12293;
    public static final int GL_CLIP_DISTANCE6 = 12294;
    public static final int GL_CLIP_DISTANCE7 = 12295;
    public static final int GL_MAX_CLIP_DISTANCES = 3378;
    public static final int GL_MAX_VARYING_COMPONENTS = 35659;
    public static final int GL_BUFFER_ACCESS_FLAGS = 37151;
    public static final int GL_BUFFER_MAP_LENGTH = 37152;
    public static final int GL_BUFFER_MAP_OFFSET = 37153;
    public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER = 35069;
    public static final int GL_SAMPLER_BUFFER = 36290;
    public static final int GL_SAMPLER_CUBE_SHADOW = 36293;
    public static final int GL_UNSIGNED_INT_VEC2 = 36294;
    public static final int GL_UNSIGNED_INT_VEC3 = 36295;
    public static final int GL_UNSIGNED_INT_VEC4 = 36296;
    public static final int GL_INT_SAMPLER_1D = 36297;
    public static final int GL_INT_SAMPLER_2D = 36298;
    public static final int GL_INT_SAMPLER_3D = 36299;
    public static final int GL_INT_SAMPLER_CUBE = 36300;
    public static final int GL_INT_SAMPLER_2D_RECT = 36301;
    public static final int GL_INT_SAMPLER_1D_ARRAY = 36302;
    public static final int GL_INT_SAMPLER_2D_ARRAY = 36303;
    public static final int GL_INT_SAMPLER_BUFFER = 36304;
    public static final int GL_UNSIGNED_INT_SAMPLER_1D = 36305;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D = 36306;
    public static final int GL_UNSIGNED_INT_SAMPLER_3D = 36307;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE = 36308;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT = 36309;
    public static final int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY = 36310;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY = 36311;
    public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER = 36312;
    public static final int GL_MIN_PROGRAM_TEXEL_OFFSET = 35076;
    public static final int GL_MAX_PROGRAM_TEXEL_OFFSET = 35077;
    public static final int GL_QUERY_WAIT = 36371;
    public static final int GL_QUERY_NO_WAIT = 36372;
    public static final int GL_QUERY_BY_REGION_WAIT = 36373;
    public static final int GL_QUERY_BY_REGION_NO_WAIT = 36374;
    public static final int GL_MAP_READ_BIT = 1;
    public static final int GL_MAP_WRITE_BIT = 2;
    public static final int GL_MAP_INVALIDATE_RANGE_BIT = 4;
    public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 8;
    public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 16;
    public static final int GL_MAP_UNSYNCHRONIZED_BIT = 32;
    public static final int GL_CLAMP_VERTEX_COLOR = 35098;
    public static final int GL_CLAMP_FRAGMENT_COLOR = 35099;
    public static final int GL_CLAMP_READ_COLOR = 35100;
    public static final int GL_FIXED_ONLY = 35101;
    public static final int GL_DEPTH_COMPONENT32F = 36267;
    public static final int GL_DEPTH32F_STENCIL8 = 36268;
    public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV = 36269;
    public static final int GL_TEXTURE_RED_TYPE = 35856;
    public static final int GL_TEXTURE_GREEN_TYPE = 35857;
    public static final int GL_TEXTURE_BLUE_TYPE = 35858;
    public static final int GL_TEXTURE_ALPHA_TYPE = 35859;
    public static final int GL_TEXTURE_LUMINANCE_TYPE = 35860;
    public static final int GL_TEXTURE_INTENSITY_TYPE = 35861;
    public static final int GL_TEXTURE_DEPTH_TYPE = 35862;
    public static final int GL_UNSIGNED_NORMALIZED = 35863;
    public static final int GL_RGBA32F = 34836;
    public static final int GL_RGB32F = 34837;
    public static final int GL_ALPHA32F = 34838;
    public static final int GL_RGBA16F = 34842;
    public static final int GL_RGB16F = 34843;
    public static final int GL_ALPHA16F = 34844;
    public static final int GL_R11F_G11F_B10F = 35898;
    public static final int GL_UNSIGNED_INT_10F_11F_11F_REV = 35899;
    public static final int GL_RGB9_E5 = 35901;
    public static final int GL_UNSIGNED_INT_5_9_9_9_REV = 35902;
    public static final int GL_TEXTURE_SHARED_SIZE = 35903;
    public static final int GL_FRAMEBUFFER = 36160;
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
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 36048;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 36049;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 36050;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 36051;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_3D_ZOFFSET = 36052;
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
    public static final int GL_FRAMEBUFFER_COMPLETE = 36053;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 36054;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 36055;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS = 36057;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_FORMATS = 36058;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = 36059;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER = 36060;
    public static final int GL_FRAMEBUFFER_UNSUPPORTED = 36061;
    public static final int GL_FRAMEBUFFER_BINDING = 36006;
    public static final int GL_RENDERBUFFER_BINDING = 36007;
    public static final int GL_MAX_COLOR_ATTACHMENTS = 36063;
    public static final int GL_MAX_RENDERBUFFER_SIZE = 34024;
    public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 1286;
    public static final int GL_HALF_FLOAT = 5131;
    public static final int GL_RENDERBUFFER_SAMPLES = 36011;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 36182;
    public static final int GL_MAX_SAMPLES = 36183;
    public static final int GL_READ_FRAMEBUFFER = 36008;
    public static final int GL_DRAW_FRAMEBUFFER = 36009;
    public static final int GL_DRAW_FRAMEBUFFER_BINDING = 36006;
    public static final int GL_READ_FRAMEBUFFER_BINDING = 36010;
    public static final int GL_RGBA_INTEGER_MODE = 36254;
    public static final int GL_RGBA32UI = 36208;
    public static final int GL_RGB32UI = 36209;
    public static final int GL_ALPHA32UI = 36210;
    public static final int GL_RGBA16UI = 36214;
    public static final int GL_RGB16UI = 36215;
    public static final int GL_ALPHA16UI = 36216;
    public static final int GL_RGBA8UI = 36220;
    public static final int GL_RGB8UI = 36221;
    public static final int GL_ALPHA8UI = 36222;
    public static final int GL_RGBA32I = 36226;
    public static final int GL_RGB32I = 36227;
    public static final int GL_ALPHA32I = 36228;
    public static final int GL_RGBA16I = 36232;
    public static final int GL_RGB16I = 36233;
    public static final int GL_ALPHA16I = 36234;
    public static final int GL_RGBA8I = 36238;
    public static final int GL_RGB8I = 36239;
    public static final int GL_ALPHA8I = 36240;
    public static final int GL_RED_INTEGER = 36244;
    public static final int GL_GREEN_INTEGER = 36245;
    public static final int GL_BLUE_INTEGER = 36246;
    public static final int GL_ALPHA_INTEGER = 36247;
    public static final int GL_RGB_INTEGER = 36248;
    public static final int GL_RGBA_INTEGER = 36249;
    public static final int GL_BGR_INTEGER = 36250;
    public static final int GL_BGRA_INTEGER = 36251;
    public static final int GL_TEXTURE_1D_ARRAY = 35864;
    public static final int GL_TEXTURE_2D_ARRAY = 35866;
    public static final int GL_PROXY_TEXTURE_2D_ARRAY = 35867;
    public static final int GL_PROXY_TEXTURE_1D_ARRAY = 35865;
    public static final int GL_TEXTURE_BINDING_1D_ARRAY = 35868;
    public static final int GL_TEXTURE_BINDING_2D_ARRAY = 35869;
    public static final int GL_MAX_ARRAY_TEXTURE_LAYERS = 35071;
    public static final int GL_COMPARE_REF_DEPTH_TO_TEXTURE = 34894;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 36052;
    public static final int GL_SAMPLER_1D_ARRAY = 36288;
    public static final int GL_SAMPLER_2D_ARRAY = 36289;
    public static final int GL_SAMPLER_1D_ARRAY_SHADOW = 36291;
    public static final int GL_SAMPLER_2D_ARRAY_SHADOW = 36292;
    public static final int GL_DEPTH_STENCIL = 34041;
    public static final int GL_UNSIGNED_INT_24_8 = 34042;
    public static final int GL_DEPTH24_STENCIL8 = 35056;
    public static final int GL_TEXTURE_STENCIL_SIZE = 35057;
    public static final int GL_COMPRESSED_RED_RGTC1 = 36283;
    public static final int GL_COMPRESSED_SIGNED_RED_RGTC1 = 36284;
    public static final int GL_COMPRESSED_RED_GREEN_RGTC2 = 36285;
    public static final int GL_COMPRESSED_SIGNED_RED_GREEN_RGTC2 = 36286;
    public static final int GL_R8 = 33321;
    public static final int GL_R16 = 33322;
    public static final int GL_RG8 = 33323;
    public static final int GL_RG16 = 33324;
    public static final int GL_R16F = 33325;
    public static final int GL_R32F = 33326;
    public static final int GL_RG16F = 33327;
    public static final int GL_RG32F = 33328;
    public static final int GL_R8I = 33329;
    public static final int GL_R8UI = 33330;
    public static final int GL_R16I = 33331;
    public static final int GL_R16UI = 33332;
    public static final int GL_R32I = 33333;
    public static final int GL_R32UI = 33334;
    public static final int GL_RG8I = 33335;
    public static final int GL_RG8UI = 33336;
    public static final int GL_RG16I = 33337;
    public static final int GL_RG16UI = 33338;
    public static final int GL_RG32I = 33339;
    public static final int GL_RG32UI = 33340;
    public static final int GL_RG = 33319;
    public static final int GL_RG_INTEGER = 33320;
    public static final int GL_RED = 6403;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER = 35982;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START = 35972;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE = 35973;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING = 35983;
    public static final int GL_INTERLEAVED_ATTRIBS = 35980;
    public static final int GL_SEPARATE_ATTRIBS = 35981;
    public static final int GL_PRIMITIVES_GENERATED = 35975;
    public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN = 35976;
    public static final int GL_RASTERIZER_DISCARD = 35977;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS = 35978;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS = 35979;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS = 35968;
    public static final int GL_TRANSFORM_FEEDBACK_VARYINGS = 35971;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE = 35967;
    public static final int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH = 35958;
    public static final int GL_VERTEX_ARRAY_BINDING = 34229;
    public static final int GL_FRAMEBUFFER_SRGB = 36281;
    public static final int GL_FRAMEBUFFER_SRGB_CAPABLE = 36282;

    private GL30() {
    }

    public static String glGetStringi(int name, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetStringi_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        String __result = GL30.nglGetStringi(name, index, function_pointer);
        return __result;
    }

    private static native String nglGetStringi(int var0, int var1, long var2);

    public static void glClearBuffer(int buffer, int drawbuffer, FloatBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glClearBufferfv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 4);
        GL30.nglClearBufferfv(buffer, drawbuffer, value, value.position(), function_pointer);
    }

    private static native void nglClearBufferfv(int var0, int var1, FloatBuffer var2, int var3, long var4);

    public static void glClearBuffer(int buffer, int drawbuffer, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glClearBufferiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 4);
        GL30.nglClearBufferiv(buffer, drawbuffer, value, value.position(), function_pointer);
    }

    private static native void nglClearBufferiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glClearBufferu(int buffer, int drawbuffer, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glClearBufferuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(value, 4);
        GL30.nglClearBufferuiv(buffer, drawbuffer, value, value.position(), function_pointer);
    }

    private static native void nglClearBufferuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glClearBufferfi_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglClearBufferfi(buffer, drawbuffer, depth, stencil, function_pointer);
    }

    private static native void nglClearBufferfi(int var0, int var1, float var2, int var3, long var4);

    public static void glVertexAttribI1i(int index, int x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI1i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglVertexAttribI1i(index, x2, function_pointer);
    }

    private static native void nglVertexAttribI1i(int var0, int var1, long var2);

    public static void glVertexAttribI2i(int index, int x2, int y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI2i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglVertexAttribI2i(index, x2, y2, function_pointer);
    }

    private static native void nglVertexAttribI2i(int var0, int var1, int var2, long var3);

    public static void glVertexAttribI3i(int index, int x2, int y2, int z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI3i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglVertexAttribI3i(index, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexAttribI3i(int var0, int var1, int var2, int var3, long var4);

    public static void glVertexAttribI4i(int index, int x2, int y2, int z2, int w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI4i_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglVertexAttribI4i(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttribI4i(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glVertexAttribI1ui(int index, int x2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI1ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglVertexAttribI1ui(index, x2, function_pointer);
    }

    private static native void nglVertexAttribI1ui(int var0, int var1, long var2);

    public static void glVertexAttribI2ui(int index, int x2, int y2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI2ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglVertexAttribI2ui(index, x2, y2, function_pointer);
    }

    private static native void nglVertexAttribI2ui(int var0, int var1, int var2, long var3);

    public static void glVertexAttribI3ui(int index, int x2, int y2, int z2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglVertexAttribI3ui(index, x2, y2, z2, function_pointer);
    }

    private static native void nglVertexAttribI3ui(int var0, int var1, int var2, int var3, long var4);

    public static void glVertexAttribI4ui(int index, int x2, int y2, int z2, int w2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI4ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglVertexAttribI4ui(index, x2, y2, z2, w2, function_pointer);
    }

    private static native void nglVertexAttribI4ui(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glVertexAttribI1(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI1iv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 1);
        GL30.nglVertexAttribI1iv(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI1iv(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI2(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI2iv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 2);
        GL30.nglVertexAttribI2iv(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI2iv(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI3(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI3iv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 3);
        GL30.nglVertexAttribI3iv(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI3iv(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI4(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI4iv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        GL30.nglVertexAttribI4iv(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI4iv(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI1u(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI1uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 1);
        GL30.nglVertexAttribI1uiv(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI1uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI2u(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI2uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 2);
        GL30.nglVertexAttribI2uiv(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI2uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI3u(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 3);
        GL30.nglVertexAttribI3uiv(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI3uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI4u(int index, IntBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI4uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        GL30.nglVertexAttribI4uiv(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI4uiv(int var0, IntBuffer var1, int var2, long var3);

    public static void glVertexAttribI4(int index, ByteBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI4bv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        GL30.nglVertexAttribI4bv(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI4bv(int var0, ByteBuffer var1, int var2, long var3);

    public static void glVertexAttribI4(int index, ShortBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI4sv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        GL30.nglVertexAttribI4sv(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI4sv(int var0, ShortBuffer var1, int var2, long var3);

    public static void glVertexAttribI4u(int index, ByteBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI4ubv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        GL30.nglVertexAttribI4ubv(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI4ubv(int var0, ByteBuffer var1, int var2, long var3);

    public static void glVertexAttribI4u(int index, ShortBuffer v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribI4usv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(v2, 4);
        GL30.nglVertexAttribI4usv(index, v2, v2.position(), function_pointer);
    }

    private static native void nglVertexAttribI4usv(int var0, ShortBuffer var1, int var2, long var3);

    public static void glVertexAttribIPointer(int index, int size, int type, int stride, ByteBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribIPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).GL30_glVertexAttribIPointer_buffer = buffer;
        GL30.nglVertexAttribIPointer(index, size, type, stride, buffer, buffer.position(), function_pointer);
    }

    public static void glVertexAttribIPointer(int index, int size, int type, int stride, IntBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribIPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).GL30_glVertexAttribIPointer_buffer = buffer;
        GL30.nglVertexAttribIPointer(index, size, type, stride, buffer, buffer.position() << 2, function_pointer);
    }

    public static void glVertexAttribIPointer(int index, int size, int type, int stride, ShortBuffer buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribIPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOdisabled(caps);
        BufferChecks.checkDirect(buffer);
        GLChecks.getReferences((ContextCapabilities)caps).GL30_glVertexAttribIPointer_buffer = buffer;
        GL30.nglVertexAttribIPointer(index, size, type, stride, buffer, buffer.position() << 1, function_pointer);
    }

    private static native void nglVertexAttribIPointer(int var0, int var1, int var2, int var3, Buffer var4, int var5, long var6);

    public static void glVertexAttribIPointer(int index, int size, int type, int stride, long buffer_buffer_offset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glVertexAttribIPointer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GLChecks.ensureArrayVBOenabled(caps);
        GL30.nglVertexAttribIPointerBO(index, size, type, stride, buffer_buffer_offset, function_pointer);
    }

    private static native void nglVertexAttribIPointerBO(int var0, int var1, int var2, int var3, long var4, long var6);

    public static void glGetVertexAttribI(int index, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetVertexAttribIiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL30.nglGetVertexAttribIiv(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribIiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetVertexAttribIu(int index, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetVertexAttribIuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL30.nglGetVertexAttribIuiv(index, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetVertexAttribIuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniform1ui(int location, int v0) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glUniform1ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglUniform1ui(location, v0, function_pointer);
    }

    private static native void nglUniform1ui(int var0, int var1, long var2);

    public static void glUniform2ui(int location, int v0, int v1) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glUniform2ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglUniform2ui(location, v0, v1, function_pointer);
    }

    private static native void nglUniform2ui(int var0, int var1, int var2, long var3);

    public static void glUniform3ui(int location, int v0, int v1, int v2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glUniform3ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglUniform3ui(location, v0, v1, v2, function_pointer);
    }

    private static native void nglUniform3ui(int var0, int var1, int var2, int var3, long var4);

    public static void glUniform4ui(int location, int v0, int v1, int v2, int v3) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glUniform4ui_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglUniform4ui(location, v0, v1, v2, v3, function_pointer);
    }

    private static native void nglUniform4ui(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glUniform1u(int location, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glUniform1uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL30.nglUniform1uiv(location, value.remaining(), value, value.position(), function_pointer);
    }

    private static native void nglUniform1uiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniform2u(int location, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glUniform2uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL30.nglUniform2uiv(location, value.remaining() >> 1, value, value.position(), function_pointer);
    }

    private static native void nglUniform2uiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniform3u(int location, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glUniform3uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL30.nglUniform3uiv(location, value.remaining() / 3, value, value.position(), function_pointer);
    }

    private static native void nglUniform3uiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glUniform4u(int location, IntBuffer value) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glUniform4uiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(value);
        GL30.nglUniform4uiv(location, value.remaining() >> 2, value, value.position(), function_pointer);
    }

    private static native void nglUniform4uiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glGetUniformu(int program, int location, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetUniformuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(params);
        GL30.nglGetUniformuiv(program, location, params, params.position(), function_pointer);
    }

    private static native void nglGetUniformuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glBindFragDataLocation(int program, int colorNumber, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glBindFragDataLocation_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        GL30.nglBindFragDataLocation(program, colorNumber, name, name.position(), function_pointer);
    }

    private static native void nglBindFragDataLocation(int var0, int var1, ByteBuffer var2, int var3, long var4);

    public static void glBindFragDataLocation(int program, int colorNumber, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glBindFragDataLocation_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglBindFragDataLocation(program, colorNumber, APIUtils.getBufferNT(name), 0, function_pointer);
    }

    public static int glGetFragDataLocation(int program, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetFragDataLocation_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkNullTerminated(name);
        int __result = GL30.nglGetFragDataLocation(program, name, name.position(), function_pointer);
        return __result;
    }

    private static native int nglGetFragDataLocation(int var0, ByteBuffer var1, int var2, long var3);

    public static int glGetFragDataLocation(int program, CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetFragDataLocation_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = GL30.nglGetFragDataLocation(program, APIUtils.getBufferNT(name), 0, function_pointer);
        return __result;
    }

    public static void glBeginConditionalRender(int id2, int mode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glBeginConditionalRender_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglBeginConditionalRender(id2, mode, function_pointer);
    }

    private static native void nglBeginConditionalRender(int var0, int var1, long var2);

    public static void glEndConditionalRender() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glEndConditionalRender_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglEndConditionalRender(function_pointer);
    }

    private static native void nglEndConditionalRender(long var0);

    public static ByteBuffer glMapBufferRange(int target, long offset, long length, int access, ByteBuffer old_buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glMapBufferRange_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (old_buffer != null) {
            BufferChecks.checkDirect(old_buffer);
        }
        ByteBuffer __result = GL30.nglMapBufferRange(target, offset, length, access, old_buffer, function_pointer);
        return __result;
    }

    private static native ByteBuffer nglMapBufferRange(int var0, long var1, long var3, int var5, ByteBuffer var6, long var7);

    public static void glFlushMappedBufferRange(int target, long offset, long length) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glFlushMappedBufferRange_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglFlushMappedBufferRange(target, offset, length, function_pointer);
    }

    private static native void nglFlushMappedBufferRange(int var0, long var1, long var3, long var5);

    public static void glClampColor(int target, int clamp) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glClampColor_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglClampColor(target, clamp, function_pointer);
    }

    private static native void nglClampColor(int var0, int var1, long var2);

    public static boolean glIsRenderbuffer(int renderbuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glIsRenderbuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = GL30.nglIsRenderbuffer(renderbuffer, function_pointer);
        return __result;
    }

    private static native boolean nglIsRenderbuffer(int var0, long var1);

    public static void glBindRenderbuffer(int target, int renderbuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glBindRenderbuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglBindRenderbuffer(target, renderbuffer, function_pointer);
    }

    private static native void nglBindRenderbuffer(int var0, int var1, long var2);

    public static void glDeleteRenderbuffers(IntBuffer renderbuffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glDeleteRenderbuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(renderbuffers);
        GL30.nglDeleteRenderbuffers(renderbuffers.remaining(), renderbuffers, renderbuffers.position(), function_pointer);
    }

    private static native void nglDeleteRenderbuffers(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteRenderbuffers(int renderbuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glDeleteRenderbuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglDeleteRenderbuffers(1, APIUtils.getBufferInt().put(0, renderbuffer), 0, function_pointer);
    }

    public static void glGenRenderbuffers(IntBuffer renderbuffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGenRenderbuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(renderbuffers);
        GL30.nglGenRenderbuffers(renderbuffers.remaining(), renderbuffers, renderbuffers.position(), function_pointer);
    }

    private static native void nglGenRenderbuffers(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenRenderbuffers() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGenRenderbuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer renderbuffers = APIUtils.getBufferInt();
        GL30.nglGenRenderbuffers(1, renderbuffers, renderbuffers.position(), function_pointer);
        return renderbuffers.get(0);
    }

    public static void glRenderbufferStorage(int target, int internalformat, int width, int height) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glRenderbufferStorage_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglRenderbufferStorage(target, internalformat, width, height, function_pointer);
    }

    private static native void nglRenderbufferStorage(int var0, int var1, int var2, int var3, long var4);

    public static void glGetRenderbufferParameter(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetRenderbufferParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL30.nglGetRenderbufferParameteriv(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetRenderbufferParameteriv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetRenderbufferParameter(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetRenderbufferParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL30.nglGetRenderbufferParameteriv(target, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static boolean glIsFramebuffer(int framebuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glIsFramebuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = GL30.nglIsFramebuffer(framebuffer, function_pointer);
        return __result;
    }

    private static native boolean nglIsFramebuffer(int var0, long var1);

    public static void glBindFramebuffer(int target, int framebuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glBindFramebuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglBindFramebuffer(target, framebuffer, function_pointer);
    }

    private static native void nglBindFramebuffer(int var0, int var1, long var2);

    public static void glDeleteFramebuffers(IntBuffer framebuffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glDeleteFramebuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(framebuffers);
        GL30.nglDeleteFramebuffers(framebuffers.remaining(), framebuffers, framebuffers.position(), function_pointer);
    }

    private static native void nglDeleteFramebuffers(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteFramebuffers(int framebuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glDeleteFramebuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglDeleteFramebuffers(1, APIUtils.getBufferInt().put(0, framebuffer), 0, function_pointer);
    }

    public static void glGenFramebuffers(IntBuffer framebuffers) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGenFramebuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(framebuffers);
        GL30.nglGenFramebuffers(framebuffers.remaining(), framebuffers, framebuffers.position(), function_pointer);
    }

    private static native void nglGenFramebuffers(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenFramebuffers() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGenFramebuffers_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer framebuffers = APIUtils.getBufferInt();
        GL30.nglGenFramebuffers(1, framebuffers, framebuffers.position(), function_pointer);
        return framebuffers.get(0);
    }

    public static int glCheckFramebufferStatus(int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glCheckFramebufferStatus_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = GL30.nglCheckFramebufferStatus(target, function_pointer);
        return __result;
    }

    private static native int nglCheckFramebufferStatus(int var0, long var1);

    public static void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glFramebufferTexture1D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglFramebufferTexture1D(target, attachment, textarget, texture, level, function_pointer);
    }

    private static native void nglFramebufferTexture1D(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glFramebufferTexture2D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglFramebufferTexture2D(target, attachment, textarget, texture, level, function_pointer);
    }

    private static native void nglFramebufferTexture2D(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glFramebufferTexture3D(int target, int attachment, int textarget, int texture, int level, int zoffset) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glFramebufferTexture3D_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglFramebufferTexture3D(target, attachment, textarget, texture, level, zoffset, function_pointer);
    }

    private static native void nglFramebufferTexture3D(int var0, int var1, int var2, int var3, int var4, int var5, long var6);

    public static void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glFramebufferRenderbuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer, function_pointer);
    }

    private static native void nglFramebufferRenderbuffer(int var0, int var1, int var2, int var3, long var4);

    public static void glGetFramebufferAttachmentParameter(int target, int attachment, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetFramebufferAttachmentParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL30.nglGetFramebufferAttachmentParameteriv(target, attachment, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetFramebufferAttachmentParameteriv(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static int glGetFramebufferAttachmentParameter(int target, int attachment, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetFramebufferAttachmentParameteriv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL30.nglGetFramebufferAttachmentParameteriv(target, attachment, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGenerateMipmap(int target) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGenerateMipmap_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglGenerateMipmap(target, function_pointer);
    }

    private static native void nglGenerateMipmap(int var0, long var1);

    public static void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glRenderbufferStorageMultisample_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglRenderbufferStorageMultisample(target, samples, internalformat, width, height, function_pointer);
    }

    private static native void nglRenderbufferStorageMultisample(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glBlitFramebuffer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter, function_pointer);
    }

    private static native void nglBlitFramebuffer(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, long var10);

    public static void glTexParameterI(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glTexParameterIiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL30.nglTexParameterIiv(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglTexParameterIiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glTexParameterIi(int target, int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glTexParameterIiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglTexParameterIiv(target, pname, APIUtils.getBufferInt().put(0, param), 0, function_pointer);
    }

    public static void glTexParameterIu(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glTexParameterIuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL30.nglTexParameterIuiv(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglTexParameterIuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static void glTexParameterIui(int target, int pname, int param) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glTexParameterIuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglTexParameterIuiv(target, pname, APIUtils.getBufferInt().put(0, param), 0, function_pointer);
    }

    public static void glGetTexParameterI(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetTexParameterIiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL30.nglGetTexParameterIiv(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetTexParameterIiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetTexParameterIi(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetTexParameterIiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL30.nglGetTexParameterIiv(target, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glGetTexParameterIu(int target, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetTexParameterIuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 4);
        GL30.nglGetTexParameterIuiv(target, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetTexParameterIuiv(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetTexParameterIui(int target, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetTexParameterIuiv_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        GL30.nglGetTexParameterIuiv(target, pname, params, params.position(), function_pointer);
        return params.get(0);
    }

    public static void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glFramebufferTextureLayer_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglFramebufferTextureLayer(target, attachment, texture, level, layer, function_pointer);
    }

    private static native void nglFramebufferTextureLayer(int var0, int var1, int var2, int var3, int var4, long var5);

    public static void glColorMaski(int buf, boolean r2, boolean g2, boolean b2, boolean a2) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glColorMaski_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglColorMaski(buf, r2, g2, b2, a2, function_pointer);
    }

    private static native void nglColorMaski(int var0, boolean var1, boolean var2, boolean var3, boolean var4, long var5);

    public static void glGetBoolean(int value, int index, ByteBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetBooleani_v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, 4);
        GL30.nglGetBooleani_v(value, index, data, data.position(), function_pointer);
    }

    private static native void nglGetBooleani_v(int var0, int var1, ByteBuffer var2, int var3, long var4);

    public static boolean glGetBoolean(int value, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetBooleani_v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ByteBuffer data = APIUtils.getBufferByte(1);
        GL30.nglGetBooleani_v(value, index, data, data.position(), function_pointer);
        return data.get(0) == 1;
    }

    public static void glGetInteger(int value, int index, IntBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetIntegeri_v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, 4);
        GL30.nglGetIntegeri_v(value, index, data, data.position(), function_pointer);
    }

    private static native void nglGetIntegeri_v(int var0, int var1, IntBuffer var2, int var3, long var4);

    public static int glGetInteger(int value, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetIntegeri_v_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer data = APIUtils.getBufferInt();
        GL30.nglGetIntegeri_v(value, index, data, data.position(), function_pointer);
        return data.get(0);
    }

    public static void glEnablei(int target, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glEnablei_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglEnablei(target, index, function_pointer);
    }

    private static native void nglEnablei(int var0, int var1, long var2);

    public static void glDisablei(int target, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glDisablei_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglDisablei(target, index, function_pointer);
    }

    private static native void nglDisablei(int var0, int var1, long var2);

    public static boolean glIsEnabledi(int target, int index) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glIsEnabledi_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = GL30.nglIsEnabledi(target, index, function_pointer);
        return __result;
    }

    private static native boolean nglIsEnabledi(int var0, int var1, long var2);

    public static void glBindBufferRange(int target, int index, int buffer, long offset, long size) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glBindBufferRange_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglBindBufferRange(target, index, buffer, offset, size, function_pointer);
    }

    private static native void nglBindBufferRange(int var0, int var1, int var2, long var3, long var5, long var7);

    public static void glBindBufferBase(int target, int index, int buffer) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glBindBufferBase_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglBindBufferBase(target, index, buffer, function_pointer);
    }

    private static native void nglBindBufferBase(int var0, int var1, int var2, long var3);

    public static void glBeginTransformFeedback(int primitiveMode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glBeginTransformFeedback_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglBeginTransformFeedback(primitiveMode, function_pointer);
    }

    private static native void nglBeginTransformFeedback(int var0, long var1);

    public static void glEndTransformFeedback() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glEndTransformFeedback_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglEndTransformFeedback(function_pointer);
    }

    private static native void nglEndTransformFeedback(long var0);

    public static void glTransformFeedbackVaryings(int program, int count, ByteBuffer varyings, int bufferMode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glTransformFeedbackVaryings_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(varyings);
        BufferChecks.checkNullTerminated(varyings, count);
        GL30.nglTransformFeedbackVaryings(program, count, varyings, varyings.position(), bufferMode, function_pointer);
    }

    private static native void nglTransformFeedbackVaryings(int var0, int var1, ByteBuffer var2, int var3, int var4, long var5);

    public static void glTransformFeedbackVaryings(int program, CharSequence[] varyings, int bufferMode) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glTransformFeedbackVaryings_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglTransformFeedbackVaryings(program, varyings.length, APIUtils.getBufferNT(varyings), 0, bufferMode, function_pointer);
    }

    public static void glGetTransformFeedbackVarying(int program, int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetTransformFeedbackVarying_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkBuffer(size, 1);
        BufferChecks.checkBuffer(type, 1);
        BufferChecks.checkDirect(name);
        GL30.nglGetTransformFeedbackVarying(program, index, name.remaining(), length, length != null ? length.position() : 0, size, size.position(), type, type.position(), name, name.position(), function_pointer);
    }

    private static native void nglGetTransformFeedbackVarying(int var0, int var1, int var2, IntBuffer var3, int var4, IntBuffer var5, int var6, IntBuffer var7, int var8, ByteBuffer var9, int var10, long var11);

    public static String glGetTransformFeedbackVarying(int program, int index, int bufSize, IntBuffer size, IntBuffer type) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGetTransformFeedbackVarying_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(size, 1);
        BufferChecks.checkBuffer(type, 1);
        IntBuffer name_length = APIUtils.getLengths();
        ByteBuffer name = APIUtils.getBufferByte(bufSize);
        GL30.nglGetTransformFeedbackVarying(program, index, bufSize, name_length, 0, size, size.position(), type, type.position(), name, name.position(), function_pointer);
        name.limit(name_length.get(0));
        return APIUtils.getString(name);
    }

    public static void glBindVertexArray(int array) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glBindVertexArray_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglBindVertexArray(array, function_pointer);
    }

    private static native void nglBindVertexArray(int var0, long var1);

    public static void glDeleteVertexArrays(IntBuffer arrays) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glDeleteVertexArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(arrays);
        GL30.nglDeleteVertexArrays(arrays.remaining(), arrays, arrays.position(), function_pointer);
    }

    private static native void nglDeleteVertexArrays(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeleteVertexArrays(int array) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glDeleteVertexArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        GL30.nglDeleteVertexArrays(1, APIUtils.getBufferInt().put(0, array), 0, function_pointer);
    }

    public static void glGenVertexArrays(IntBuffer arrays) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGenVertexArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(arrays);
        GL30.nglGenVertexArrays(arrays.remaining(), arrays, arrays.position(), function_pointer);
    }

    private static native void nglGenVertexArrays(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenVertexArrays() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glGenVertexArrays_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer arrays = APIUtils.getBufferInt();
        GL30.nglGenVertexArrays(1, arrays, arrays.position(), function_pointer);
        return arrays.get(0);
    }

    public static boolean glIsVertexArray(int array) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.GL30_glIsVertexArray_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = GL30.nglIsVertexArray(array, function_pointer);
        return __result;
    }

    private static native boolean nglIsVertexArray(int var0, long var1);
}

