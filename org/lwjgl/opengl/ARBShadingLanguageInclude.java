/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class ARBShadingLanguageInclude {
    public static final int GL_SHADER_INCLUDE_ARB = 36270;
    public static final int GL_NAMED_STRING_LENGTH_ARB = 36329;
    public static final int GL_NAMED_STRING_TYPE_ARB = 36330;

    private ARBShadingLanguageInclude() {
    }

    public static void glNamedStringARB(int type, ByteBuffer name, ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shading_language_include_glNamedStringARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkDirect(string);
        ARBShadingLanguageInclude.nglNamedStringARB(type, name.remaining(), name, name.position(), string.remaining(), string, string.position(), function_pointer);
    }

    private static native void nglNamedStringARB(int var0, int var1, ByteBuffer var2, int var3, int var4, ByteBuffer var5, int var6, long var7);

    public static void glNamedStringARB(int type, CharSequence name, CharSequence string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shading_language_include_glNamedStringARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShadingLanguageInclude.nglNamedStringARB(type, name.length(), APIUtils.getBuffer(name), 0, string.length(), APIUtils.getBuffer(string, name.length()), name.length(), function_pointer);
    }

    public static void glDeleteNamedStringARB(ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shading_language_include_glDeleteNamedStringARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        ARBShadingLanguageInclude.nglDeleteNamedStringARB(name.remaining(), name, name.position(), function_pointer);
    }

    private static native void nglDeleteNamedStringARB(int var0, ByteBuffer var1, int var2, long var3);

    public static void glDeleteNamedStringARB(CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shading_language_include_glDeleteNamedStringARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShadingLanguageInclude.nglDeleteNamedStringARB(name.length(), APIUtils.getBuffer(name), 0, function_pointer);
    }

    public static void glCompileShaderIncludeARB(int shader, int count, ByteBuffer path) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shading_language_include_glCompileShaderIncludeARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(path);
        BufferChecks.checkNullTerminated(path, count);
        ARBShadingLanguageInclude.nglCompileShaderIncludeARB(shader, count, path, path.position(), null, 0, function_pointer);
    }

    private static native void nglCompileShaderIncludeARB(int var0, int var1, ByteBuffer var2, int var3, IntBuffer var4, int var5, long var6);

    public static void glCompileShaderIncludeARB(int shader, CharSequence[] path) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shading_language_include_glCompileShaderIncludeARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        ARBShadingLanguageInclude.nglCompileShaderIncludeARB2(shader, path.length, APIUtils.getBuffer(path), 0, APIUtils.getLengths(path), 0, function_pointer);
    }

    private static native void nglCompileShaderIncludeARB2(int var0, int var1, ByteBuffer var2, int var3, IntBuffer var4, int var5, long var6);

    public static boolean glIsNamedStringARB(ByteBuffer name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shading_language_include_glIsNamedStringARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        boolean __result = ARBShadingLanguageInclude.nglIsNamedStringARB(name.remaining(), name, name.position(), function_pointer);
        return __result;
    }

    private static native boolean nglIsNamedStringARB(int var0, ByteBuffer var1, int var2, long var3);

    public static boolean glIsNamedStringARB(CharSequence name) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shading_language_include_glIsNamedStringARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        boolean __result = ARBShadingLanguageInclude.nglIsNamedStringARB(name.length(), APIUtils.getBuffer(name), 0, function_pointer);
        return __result;
    }

    public static void glGetNamedStringARB(ByteBuffer name, IntBuffer stringlen, ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shading_language_include_glGetNamedStringARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        if (stringlen != null) {
            BufferChecks.checkBuffer(stringlen, 1);
        }
        BufferChecks.checkDirect(string);
        ARBShadingLanguageInclude.nglGetNamedStringARB(name.remaining(), name, name.position(), string.remaining(), stringlen, stringlen != null ? stringlen.position() : 0, string, string.position(), function_pointer);
    }

    private static native void nglGetNamedStringARB(int var0, ByteBuffer var1, int var2, int var3, IntBuffer var4, int var5, ByteBuffer var6, int var7, long var8);

    public static void glGetNamedStringARB(CharSequence name, IntBuffer stringlen, ByteBuffer string) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shading_language_include_glGetNamedStringARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (stringlen != null) {
            BufferChecks.checkBuffer(stringlen, 1);
        }
        BufferChecks.checkDirect(string);
        ARBShadingLanguageInclude.nglGetNamedStringARB(name.length(), APIUtils.getBuffer(name), 0, string.remaining(), stringlen, stringlen != null ? stringlen.position() : 0, string, string.position(), function_pointer);
    }

    public static String glGetNamedStringARB(CharSequence name, int bufSize) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shading_language_include_glGetNamedStringARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer string_length = APIUtils.getLengths();
        ByteBuffer string = APIUtils.getBufferByte(bufSize + name.length());
        ARBShadingLanguageInclude.nglGetNamedStringARB(name.length(), APIUtils.getBuffer(name), 0, bufSize, string_length, 0, string, string.position(), function_pointer);
        string.limit(name.length() + string_length.get(0));
        return APIUtils.getString(string);
    }

    public static void glGetNamedStringARB(ByteBuffer name, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shading_language_include_glGetNamedStringivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(name);
        BufferChecks.checkBuffer(params, 1);
        ARBShadingLanguageInclude.nglGetNamedStringivARB(name.remaining(), name, name.position(), pname, params, params.position(), function_pointer);
    }

    private static native void nglGetNamedStringivARB(int var0, ByteBuffer var1, int var2, int var3, IntBuffer var4, int var5, long var6);

    public static void glGetNamedStringiARB(CharSequence name, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shading_language_include_glGetNamedStringivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        ARBShadingLanguageInclude.nglGetNamedStringivARB(name.length(), APIUtils.getBuffer(name), 0, pname, params, params.position(), function_pointer);
    }

    public static int glGetNamedStringiARB(CharSequence name, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.ARB_shading_language_include_glGetNamedStringivARB_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        ARBShadingLanguageInclude.nglGetNamedStringivARB(name.length(), APIUtils.getBuffer(name), 0, pname, params, params.position(), function_pointer);
        return params.get(0);
    }
}

