/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.openal;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLException;

public final class AL11 {
    public static final int AL_SEC_OFFSET = 4132;
    public static final int AL_SAMPLE_OFFSET = 4133;
    public static final int AL_BYTE_OFFSET = 4134;
    public static final int AL_STATIC = 4136;
    public static final int AL_STREAMING = 4137;
    public static final int AL_UNDETERMINED = 4144;
    public static final int AL_ILLEGAL_COMMAND = 40964;
    public static final int AL_SPEED_OF_SOUND = 49155;
    public static final int AL_LINEAR_DISTANCE = 53251;
    public static final int AL_LINEAR_DISTANCE_CLAMPED = 53252;
    public static final int AL_EXPONENT_DISTANCE = 53253;
    public static final int AL_EXPONENT_DISTANCE_CLAMPED = 53254;

    private AL11() {
    }

    static native void initNativeStubs() throws LWJGLException;

    public static native void alListener3i(int var0, int var1, int var2, int var3);

    public static void alGetListeneri(int pname, FloatBuffer intdata) {
        BufferChecks.checkBuffer(intdata, 1);
        AL11.nalGetListeneriv(pname, intdata, intdata.position());
    }

    private static native void nalGetListeneriv(int var0, FloatBuffer var1, int var2);

    public static native void alSource3i(int var0, int var1, int var2, int var3, int var4);

    public static void alSource(int source, int pname, IntBuffer value) {
        BufferChecks.checkBuffer(value, 1);
        AL11.nalSourceiv(source, pname, value, value.position());
    }

    private static native void nalSourceiv(int var0, int var1, IntBuffer var2, int var3);

    public static native void alBufferf(int var0, int var1, float var2);

    public static native void alBuffer3f(int var0, int var1, float var2, float var3, float var4);

    public static void alBuffer(int buffer, int pname, FloatBuffer value) {
        BufferChecks.checkBuffer(value, 1);
        AL11.nalBufferfv(buffer, pname, value, value.position());
    }

    private static native void nalBufferfv(int var0, int var1, FloatBuffer var2, int var3);

    public static native void alBufferi(int var0, int var1, int var2);

    public static native void alBuffer3i(int var0, int var1, int var2, int var3, int var4);

    public static void alBuffer(int buffer, int pname, IntBuffer value) {
        BufferChecks.checkBuffer(value, 1);
        AL11.nalBufferiv(buffer, pname, value, value.position());
    }

    private static native void nalBufferiv(int var0, int var1, IntBuffer var2, int var3);

    public static native int alGetBufferi(int var0, int var1);

    public static void alGetBuffer(int buffer, int pname, IntBuffer values) {
        BufferChecks.checkBuffer(values, 1);
        AL11.nalGetBufferiv(buffer, pname, values, values.position());
    }

    private static native void nalGetBufferiv(int var0, int var1, IntBuffer var2, int var3);

    public static native float alGetBufferf(int var0, int var1);

    public static void alGetBuffer(int buffer, int pname, FloatBuffer values) {
        BufferChecks.checkBuffer(values, 1);
        AL11.nalGetBufferfv(buffer, pname, values, values.position());
    }

    private static native void nalGetBufferfv(int var0, int var1, FloatBuffer var2, int var3);

    public static native void alSpeedOfSound(float var0);
}

