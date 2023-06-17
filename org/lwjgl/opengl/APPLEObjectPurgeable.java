/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class APPLEObjectPurgeable {
    public static final int GL_RELEASED_APPLE = 35353;
    public static final int GL_VOLATILE_APPLE = 35354;
    public static final int GL_RETAINED_APPLE = 35355;
    public static final int GL_UNDEFINED_APPLE = 35356;
    public static final int GL_PURGEABLE_APPLE = 35357;
    public static final int GL_BUFFER_OBJECT_APPLE = 34227;

    private APPLEObjectPurgeable() {
    }

    public static int glObjectPurgeableAPPLE(int objectType, int name, int option) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_object_purgeable_glObjectPurgeableAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = APPLEObjectPurgeable.nglObjectPurgeableAPPLE(objectType, name, option, function_pointer);
        return __result;
    }

    private static native int nglObjectPurgeableAPPLE(int var0, int var1, int var2, long var3);

    public static int glObjectUnpurgeableAPPLE(int objectType, int name, int option) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_object_purgeable_glObjectUnpurgeableAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        int __result = APPLEObjectPurgeable.nglObjectUnpurgeableAPPLE(objectType, name, option, function_pointer);
        return __result;
    }

    private static native int nglObjectUnpurgeableAPPLE(int var0, int var1, int var2, long var3);

    public static void glGetObjectParameterAPPLE(int objectType, int name, int pname, IntBuffer params) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_object_purgeable_glGetObjectParameterivAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(params, 1);
        APPLEObjectPurgeable.nglGetObjectParameterivAPPLE(objectType, name, pname, params, params.position(), function_pointer);
    }

    private static native void nglGetObjectParameterivAPPLE(int var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static int glGetObjectParameterAPPLE(int objectType, int name, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.APPLE_object_purgeable_glGetObjectParameterivAPPLE_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer params = APIUtils.getBufferInt();
        APPLEObjectPurgeable.nglGetObjectParameterivAPPLE(objectType, name, pname, params, params.position(), function_pointer);
        return params.get(0);
    }
}

