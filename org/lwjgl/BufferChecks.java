/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public class BufferChecks {
    private BufferChecks() {
    }

    public static void checkFunctionAddress(long pointer) {
        if (pointer == 0L) {
            throw new IllegalStateException("Function is not supported");
        }
    }

    public static void checkNullTerminated(ByteBuffer buf) {
        if (buf.get(buf.limit() - 1) != 0) {
            throw new IllegalArgumentException("Missing null termination");
        }
    }

    public static void checkNullTerminated(ByteBuffer buf, int count) {
        int nullFound = 0;
        for (int i2 = buf.position(); i2 < buf.limit(); ++i2) {
            if (buf.get(i2) != 0) continue;
            ++nullFound;
        }
        if (nullFound < count) {
            throw new IllegalArgumentException("Missing null termination");
        }
    }

    public static void checkNullTerminated(IntBuffer buf) {
        if (buf.get(buf.limit() - 1) != 0) {
            throw new IllegalArgumentException("Missing null termination");
        }
    }

    public static void checkNotNull(Object o2) {
        if (o2 == null) {
            throw new IllegalArgumentException("Null argument");
        }
    }

    public static void checkDirect(ByteBuffer buf) {
        if (!buf.isDirect()) {
            throw new IllegalArgumentException("ByteBuffer is not direct");
        }
    }

    public static void checkDirect(ShortBuffer buf) {
        if (!buf.isDirect()) {
            throw new IllegalArgumentException("ShortBuffer is not direct");
        }
    }

    public static void checkDirect(IntBuffer buf) {
        if (!buf.isDirect()) {
            throw new IllegalArgumentException("IntBuffer is not direct");
        }
    }

    public static void checkDirect(LongBuffer buf) {
        if (!buf.isDirect()) {
            throw new IllegalArgumentException("LongBuffer is not direct");
        }
    }

    public static void checkDirect(FloatBuffer buf) {
        if (!buf.isDirect()) {
            throw new IllegalArgumentException("FloatBuffer is not direct");
        }
    }

    public static void checkDirect(DoubleBuffer buf) {
        if (!buf.isDirect()) {
            throw new IllegalArgumentException("DoubleBuffer is not direct");
        }
    }

    private static void throwBufferSizeException(Buffer buf, int size) {
        throw new IllegalArgumentException("Number of remaining buffer elements is " + buf.remaining() + ", must be at least " + size);
    }

    public static void checkBufferSize(Buffer buf, int size) {
        if (buf.remaining() < size) {
            BufferChecks.throwBufferSizeException(buf, size);
        }
    }

    public static void checkBuffer(ByteBuffer buf, int size) {
        BufferChecks.checkBufferSize(buf, size);
        BufferChecks.checkDirect(buf);
    }

    public static void checkBuffer(ShortBuffer buf, int size) {
        BufferChecks.checkBufferSize(buf, size);
        BufferChecks.checkDirect(buf);
    }

    public static void checkBuffer(IntBuffer buf, int size) {
        BufferChecks.checkBufferSize(buf, size);
        BufferChecks.checkDirect(buf);
    }

    public static void checkBuffer(LongBuffer buf, int size) {
        BufferChecks.checkBufferSize(buf, size);
        BufferChecks.checkDirect(buf);
    }

    public static void checkBuffer(FloatBuffer buf, int size) {
        BufferChecks.checkBufferSize(buf, size);
        BufferChecks.checkDirect(buf);
    }

    public static void checkBuffer(DoubleBuffer buf, int size) {
        BufferChecks.checkBufferSize(buf, size);
        BufferChecks.checkDirect(buf);
    }
}

