/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.openal;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.ALCcontext;
import org.lwjgl.openal.ALCdevice;
import org.lwjgl.openal.Util;

public final class ALC10 {
    static HashMap contexts = new HashMap();
    static HashMap devices = new HashMap();
    public static final int ALC_INVALID = 0;
    public static final int ALC_FALSE = 0;
    public static final int ALC_TRUE = 1;
    public static final int ALC_NO_ERROR = 0;
    public static final int ALC_MAJOR_VERSION = 4096;
    public static final int ALC_MINOR_VERSION = 4097;
    public static final int ALC_ATTRIBUTES_SIZE = 4098;
    public static final int ALC_ALL_ATTRIBUTES = 4099;
    public static final int ALC_DEFAULT_DEVICE_SPECIFIER = 4100;
    public static final int ALC_DEVICE_SPECIFIER = 4101;
    public static final int ALC_EXTENSIONS = 4102;
    public static final int ALC_FREQUENCY = 4103;
    public static final int ALC_REFRESH = 4104;
    public static final int ALC_SYNC = 4105;
    public static final int ALC_INVALID_DEVICE = 40961;
    public static final int ALC_INVALID_CONTEXT = 40962;
    public static final int ALC_INVALID_ENUM = 40963;
    public static final int ALC_INVALID_VALUE = 40964;
    public static final int ALC_OUT_OF_MEMORY = 40965;

    static native void initNativeStubs() throws LWJGLException;

    public static String alcGetString(ALCdevice device, int pname) {
        String result = ALC10.nalcGetString(ALC10.getDevice(device), pname);
        Util.checkALCError(device);
        return result;
    }

    static native String nalcGetString(long var0, int var2);

    public static void alcGetInteger(ALCdevice device, int pname, IntBuffer integerdata) {
        BufferChecks.checkDirect(integerdata);
        ALC10.nalcGetIntegerv(ALC10.getDevice(device), pname, integerdata.remaining(), integerdata, integerdata.position());
        Util.checkALCError(device);
    }

    static native void nalcGetIntegerv(long var0, int var2, int var3, Buffer var4, int var5);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ALCdevice alcOpenDevice(String devicename) {
        long device_address = ALC10.nalcOpenDevice(devicename);
        if (device_address != 0L) {
            ALCdevice device = new ALCdevice(device_address);
            HashMap hashMap = devices;
            synchronized (hashMap) {
                devices.put(new Long(device_address), device);
            }
            return device;
        }
        return null;
    }

    static native long nalcOpenDevice(String var0);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean alcCloseDevice(ALCdevice device) {
        boolean result = ALC10.nalcCloseDevice(ALC10.getDevice(device));
        HashMap hashMap = devices;
        synchronized (hashMap) {
            device.setInvalid();
            devices.remove(new Long(device.device));
        }
        return result;
    }

    static native boolean nalcCloseDevice(long var0);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ALCcontext alcCreateContext(ALCdevice device, IntBuffer attrList) {
        long context_address = ALC10.nalcCreateContext(ALC10.getDevice(device), attrList);
        Util.checkALCError(device);
        if (context_address != 0L) {
            ALCcontext context = new ALCcontext(context_address);
            HashMap hashMap = contexts;
            synchronized (hashMap) {
                contexts.put(new Long(context_address), context);
                device.addContext(context);
            }
            return context;
        }
        return null;
    }

    static native long nalcCreateContext(long var0, IntBuffer var2);

    public static int alcMakeContextCurrent(ALCcontext context) {
        return ALC10.nalcMakeContextCurrent(ALC10.getContext(context));
    }

    static native int nalcMakeContextCurrent(long var0);

    public static void alcProcessContext(ALCcontext context) {
        ALC10.nalcProcessContext(ALC10.getContext(context));
    }

    static native void nalcProcessContext(long var0);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ALCcontext alcGetCurrentContext() {
        ALCcontext context = null;
        long context_address = ALC10.nalcGetCurrentContext();
        if (context_address != 0L) {
            HashMap hashMap = contexts;
            synchronized (hashMap) {
                context = (ALCcontext)contexts.get(new Long(context_address));
            }
        }
        return context;
    }

    static native long nalcGetCurrentContext();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ALCdevice alcGetContextsDevice(ALCcontext context) {
        ALCdevice device = null;
        long device_address = ALC10.nalcGetContextsDevice(ALC10.getContext(context));
        if (device_address != 0L) {
            HashMap hashMap = devices;
            synchronized (hashMap) {
                device = (ALCdevice)devices.get(new Long(device_address));
            }
        }
        return device;
    }

    static native long nalcGetContextsDevice(long var0);

    public static void alcSuspendContext(ALCcontext context) {
        ALC10.nalcSuspendContext(ALC10.getContext(context));
    }

    static native void nalcSuspendContext(long var0);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void alcDestroyContext(ALCcontext context) {
        HashMap hashMap = contexts;
        synchronized (hashMap) {
            ALCdevice device = ALC10.alcGetContextsDevice(context);
            ALC10.nalcDestroyContext(ALC10.getContext(context));
            device.removeContext(context);
            context.setInvalid();
        }
    }

    static native void nalcDestroyContext(long var0);

    public static int alcGetError(ALCdevice device) {
        return ALC10.nalcGetError(ALC10.getDevice(device));
    }

    static native int nalcGetError(long var0);

    public static boolean alcIsExtensionPresent(ALCdevice device, String extName) {
        boolean result = ALC10.nalcIsExtensionPresent(ALC10.getDevice(device), extName);
        Util.checkALCError(device);
        return result;
    }

    static native boolean nalcIsExtensionPresent(long var0, String var2);

    public static int alcGetEnumValue(ALCdevice device, String enumName) {
        int result = ALC10.nalcGetEnumValue(ALC10.getDevice(device), enumName);
        Util.checkALCError(device);
        return result;
    }

    static native int nalcGetEnumValue(long var0, String var2);

    static long getDevice(ALCdevice device) {
        if (device != null) {
            Util.checkALCValidDevice(device);
            return device.device;
        }
        return 0L;
    }

    static long getContext(ALCcontext context) {
        if (context != null) {
            Util.checkALCValidContext(context);
            return context.context;
        }
        return 0L;
    }
}

