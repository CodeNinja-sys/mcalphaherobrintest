/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.openal;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLException;

public final class AL10 {
    public static final int AL_INVALID = -1;
    public static final int AL_NONE = 0;
    public static final int AL_FALSE = 0;
    public static final int AL_TRUE = 1;
    public static final int AL_SOURCE_TYPE = 4135;
    public static final int AL_SOURCE_ABSOLUTE = 513;
    public static final int AL_SOURCE_RELATIVE = 514;
    public static final int AL_CONE_INNER_ANGLE = 4097;
    public static final int AL_CONE_OUTER_ANGLE = 4098;
    public static final int AL_PITCH = 4099;
    public static final int AL_POSITION = 4100;
    public static final int AL_DIRECTION = 4101;
    public static final int AL_VELOCITY = 4102;
    public static final int AL_LOOPING = 4103;
    public static final int AL_BUFFER = 4105;
    public static final int AL_GAIN = 4106;
    public static final int AL_MIN_GAIN = 4109;
    public static final int AL_MAX_GAIN = 4110;
    public static final int AL_ORIENTATION = 4111;
    public static final int AL_REFERENCE_DISTANCE = 4128;
    public static final int AL_ROLLOFF_FACTOR = 4129;
    public static final int AL_CONE_OUTER_GAIN = 4130;
    public static final int AL_MAX_DISTANCE = 4131;
    public static final int AL_CHANNEL_MASK = 12288;
    public static final int AL_SOURCE_STATE = 4112;
    public static final int AL_INITIAL = 4113;
    public static final int AL_PLAYING = 4114;
    public static final int AL_PAUSED = 4115;
    public static final int AL_STOPPED = 4116;
    public static final int AL_BUFFERS_QUEUED = 4117;
    public static final int AL_BUFFERS_PROCESSED = 4118;
    public static final int AL_FORMAT_MONO8 = 4352;
    public static final int AL_FORMAT_MONO16 = 4353;
    public static final int AL_FORMAT_STEREO8 = 4354;
    public static final int AL_FORMAT_STEREO16 = 4355;
    public static final int AL_FORMAT_VORBIS_EXT = 65539;
    public static final int AL_FREQUENCY = 8193;
    public static final int AL_BITS = 8194;
    public static final int AL_CHANNELS = 8195;
    public static final int AL_SIZE = 8196;
    public static final int AL_DATA = 8197;
    public static final int AL_UNUSED = 8208;
    public static final int AL_PENDING = 8209;
    public static final int AL_PROCESSED = 8210;
    public static final int AL_NO_ERROR = 0;
    public static final int AL_INVALID_NAME = 40961;
    public static final int AL_INVALID_ENUM = 40962;
    public static final int AL_INVALID_VALUE = 40963;
    public static final int AL_INVALID_OPERATION = 40964;
    public static final int AL_OUT_OF_MEMORY = 40965;
    public static final int AL_VENDOR = 45057;
    public static final int AL_VERSION = 45058;
    public static final int AL_RENDERER = 45059;
    public static final int AL_EXTENSIONS = 45060;
    public static final int AL_DOPPLER_FACTOR = 49152;
    public static final int AL_DOPPLER_VELOCITY = 49153;
    public static final int AL_DISTANCE_MODEL = 53248;
    public static final int AL_INVERSE_DISTANCE = 53249;
    public static final int AL_INVERSE_DISTANCE_CLAMPED = 53250;

    private AL10() {
    }

    static native void initNativeStubs() throws LWJGLException;

    public static native void alEnable(int var0);

    public static native void alDisable(int var0);

    public static native boolean alIsEnabled(int var0);

    public static native boolean alGetBoolean(int var0);

    public static native int alGetInteger(int var0);

    public static native float alGetFloat(int var0);

    public static native double alGetDouble(int var0);

    public static void alGetInteger(int pname, IntBuffer data) {
        BufferChecks.checkBuffer(data, 1);
        AL10.nalGetIntegerv(pname, data, data.position());
    }

    private static native void nalGetIntegerv(int var0, IntBuffer var1, int var2);

    public static void alGetFloat(int pname, FloatBuffer data) {
        BufferChecks.checkBuffer(data, 1);
        AL10.nalGetFloatv(pname, data, data.position());
    }

    private static native void nalGetFloatv(int var0, FloatBuffer var1, int var2);

    public static void alGetDouble(int pname, DoubleBuffer data) {
        BufferChecks.checkBuffer(data, 1);
        AL10.nalGetDoublev(pname, data, data.position());
    }

    private static native void nalGetDoublev(int var0, DoubleBuffer var1, int var2);

    public static native String alGetString(int var0);

    public static native int alGetError();

    public static boolean alIsExtensionPresent(String fname) {
        BufferChecks.checkNotNull(fname);
        boolean __result = AL10.nalIsExtensionPresent(fname);
        return __result;
    }

    private static native boolean nalIsExtensionPresent(String var0);

    public static int alGetEnumValue(String ename) {
        BufferChecks.checkNotNull(ename);
        int __result = AL10.nalGetEnumValue(ename);
        return __result;
    }

    private static native int nalGetEnumValue(String var0);

    public static native void alListeneri(int var0, int var1);

    public static native void alListenerf(int var0, float var1);

    public static void alListener(int pname, FloatBuffer value) {
        BufferChecks.checkBuffer(value, 1);
        AL10.nalListenerfv(pname, value, value.position());
    }

    private static native void nalListenerfv(int var0, FloatBuffer var1, int var2);

    public static native void alListener3f(int var0, float var1, float var2, float var3);

    public static native int alGetListeneri(int var0);

    public static native float alGetListenerf(int var0);

    public static void alGetListener(int pname, FloatBuffer floatdata) {
        BufferChecks.checkBuffer(floatdata, 1);
        AL10.nalGetListenerfv(pname, floatdata, floatdata.position());
    }

    private static native void nalGetListenerfv(int var0, FloatBuffer var1, int var2);

    public static void alGenSources(IntBuffer sources) {
        BufferChecks.checkDirect(sources);
        AL10.nalGenSources(sources.remaining(), sources, sources.position());
    }

    private static native void nalGenSources(int var0, IntBuffer var1, int var2);

    public static int alGenSources() {
        int __result = AL10.nalGenSources2(1);
        return __result;
    }

    private static native int nalGenSources2(int var0);

    public static void alDeleteSources(IntBuffer sources) {
        BufferChecks.checkDirect(sources);
        AL10.nalDeleteSources(sources.remaining(), sources, sources.position());
    }

    private static native void nalDeleteSources(int var0, IntBuffer var1, int var2);

    public static void alDeleteSources(int source) {
        AL10.nalDeleteSources2(1, source);
    }

    private static native void nalDeleteSources2(int var0, int var1);

    public static native boolean alIsSource(int var0);

    public static native void alSourcei(int var0, int var1, int var2);

    public static native void alSourcef(int var0, int var1, float var2);

    public static void alSource(int source, int pname, FloatBuffer value) {
        BufferChecks.checkBuffer(value, 1);
        AL10.nalSourcefv(source, pname, value, value.position());
    }

    private static native void nalSourcefv(int var0, int var1, FloatBuffer var2, int var3);

    public static native void alSource3f(int var0, int var1, float var2, float var3, float var4);

    public static native int alGetSourcei(int var0, int var1);

    public static native float alGetSourcef(int var0, int var1);

    public static void alGetSource(int source, int pname, FloatBuffer floatdata) {
        BufferChecks.checkBuffer(floatdata, 1);
        AL10.nalGetSourcefv(source, pname, floatdata, floatdata.position());
    }

    private static native void nalGetSourcefv(int var0, int var1, FloatBuffer var2, int var3);

    public static void alSourcePlay(IntBuffer sources) {
        BufferChecks.checkDirect(sources);
        AL10.nalSourcePlayv(sources.remaining(), sources, sources.position());
    }

    private static native void nalSourcePlayv(int var0, IntBuffer var1, int var2);

    public static void alSourcePause(IntBuffer sources) {
        BufferChecks.checkDirect(sources);
        AL10.nalSourcePausev(sources.remaining(), sources, sources.position());
    }

    private static native void nalSourcePausev(int var0, IntBuffer var1, int var2);

    public static void alSourceStop(IntBuffer sources) {
        BufferChecks.checkDirect(sources);
        AL10.nalSourceStopv(sources.remaining(), sources, sources.position());
    }

    private static native void nalSourceStopv(int var0, IntBuffer var1, int var2);

    public static void alSourceRewind(IntBuffer sources) {
        BufferChecks.checkDirect(sources);
        AL10.nalSourceRewindv(sources.remaining(), sources, sources.position());
    }

    private static native void nalSourceRewindv(int var0, IntBuffer var1, int var2);

    public static native void alSourcePlay(int var0);

    public static native void alSourcePause(int var0);

    public static native void alSourceStop(int var0);

    public static native void alSourceRewind(int var0);

    public static void alGenBuffers(IntBuffer buffers) {
        BufferChecks.checkDirect(buffers);
        AL10.nalGenBuffers(buffers.remaining(), buffers, buffers.position());
    }

    private static native void nalGenBuffers(int var0, IntBuffer var1, int var2);

    public static int alGenBuffers() {
        int __result = AL10.nalGenBuffers2(1);
        return __result;
    }

    private static native int nalGenBuffers2(int var0);

    public static void alDeleteBuffers(IntBuffer buffers) {
        BufferChecks.checkDirect(buffers);
        AL10.nalDeleteBuffers(buffers.remaining(), buffers, buffers.position());
    }

    private static native void nalDeleteBuffers(int var0, IntBuffer var1, int var2);

    public static void alDeleteBuffers(int buffer) {
        AL10.nalDeleteBuffers2(1, buffer);
    }

    private static native void nalDeleteBuffers2(int var0, int var1);

    public static native boolean alIsBuffer(int var0);

    public static void alBufferData(int buffer, int format, ByteBuffer data, int freq) {
        BufferChecks.checkDirect(data);
        AL10.nalBufferData(buffer, format, data, data.position(), data.remaining(), freq);
    }

    public static void alBufferData(int buffer, int format, IntBuffer data, int freq) {
        BufferChecks.checkDirect(data);
        AL10.nalBufferData(buffer, format, data, data.position() << 2, data.remaining() << 2, freq);
    }

    public static void alBufferData(int buffer, int format, ShortBuffer data, int freq) {
        BufferChecks.checkDirect(data);
        AL10.nalBufferData(buffer, format, data, data.position() << 1, data.remaining() << 1, freq);
    }

    private static native void nalBufferData(int var0, int var1, Buffer var2, int var3, int var4, int var5);

    public static native int alGetBufferi(int var0, int var1);

    public static native float alGetBufferf(int var0, int var1);

    public static void alSourceQueueBuffers(int source, IntBuffer buffers) {
        BufferChecks.checkDirect(buffers);
        AL10.nalSourceQueueBuffers(source, buffers.remaining(), buffers, buffers.position());
    }

    private static native void nalSourceQueueBuffers(int var0, int var1, IntBuffer var2, int var3);

    public static void alSourceQueueBuffers(int source, int buffer) {
        AL10.nalSourceQueueBuffers2(source, 1, buffer);
    }

    private static native void nalSourceQueueBuffers2(int var0, int var1, int var2);

    public static void alSourceUnqueueBuffers(int source, IntBuffer buffers) {
        BufferChecks.checkDirect(buffers);
        AL10.nalSourceUnqueueBuffers(source, buffers.remaining(), buffers, buffers.position());
    }

    private static native void nalSourceUnqueueBuffers(int var0, int var1, IntBuffer var2, int var3);

    public static int alSourceUnqueueBuffers(int source) {
        int __result = AL10.nalSourceUnqueueBuffers2(source, 1);
        return __result;
    }

    private static native int nalSourceUnqueueBuffers2(int var0, int var1);

    public static native void alDistanceModel(int var0);

    public static native void alDopplerFactor(float var0);

    public static native void alDopplerVelocity(float var0);
}

