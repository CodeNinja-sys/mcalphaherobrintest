/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public final class BufferUtils {
    public static ByteBuffer createByteBuffer(int size) {
        return ByteBuffer.allocateDirect(size).order(ByteOrder.nativeOrder());
    }

    public static ShortBuffer createShortBuffer(int size) {
        return BufferUtils.createByteBuffer(size << 1).asShortBuffer();
    }

    public static CharBuffer createCharBuffer(int size) {
        return BufferUtils.createByteBuffer(size << 1).asCharBuffer();
    }

    public static IntBuffer createIntBuffer(int size) {
        return BufferUtils.createByteBuffer(size << 2).asIntBuffer();
    }

    public static LongBuffer createLongBuffer(int size) {
        return BufferUtils.createByteBuffer(size << 3).asLongBuffer();
    }

    public static FloatBuffer createFloatBuffer(int size) {
        return BufferUtils.createByteBuffer(size << 2).asFloatBuffer();
    }

    public static DoubleBuffer createDoubleBuffer(int size) {
        return BufferUtils.createByteBuffer(size << 3).asDoubleBuffer();
    }

    public static int getElementSizeExponent(Buffer buf) {
        if (buf instanceof ByteBuffer) {
            return 0;
        }
        if (buf instanceof ShortBuffer || buf instanceof CharBuffer) {
            return 1;
        }
        if (buf instanceof FloatBuffer || buf instanceof IntBuffer) {
            return 2;
        }
        if (buf instanceof LongBuffer || buf instanceof DoubleBuffer) {
            return 3;
        }
        throw new IllegalStateException("Unsupported buffer type: " + buf);
    }

    public static int getOffset(Buffer buffer) {
        return buffer.position() << BufferUtils.getElementSizeExponent(buffer);
    }
}

