/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.lwjgl.BufferUtils;

final class APIUtils {
    private static final int INITIAL_BUFFER_SIZE = 256;
    private static final int INITIAL_LENGTHS_SIZE = 4;
    private static final int BUFFERS_SIZE = 32;
    private static final ThreadLocal arrayTL = new ThreadLocal(){

        protected Object initialValue() {
            return new char[256];
        }
    };
    private static final ThreadLocal bufferTL = new ThreadLocal(){

        protected Object initialValue() {
            return BufferUtils.createByteBuffer(256);
        }
    };
    private static final ThreadLocal lengthsTL = new ThreadLocal(){

        protected Object initialValue() {
            return BufferUtils.createIntBuffer(4);
        }
    };
    private static final ThreadLocal infiniteSeqTL = new ThreadLocal(){

        protected Object initialValue() {
            return new InfiniteCharSequence();
        }
    };
    private static final ThreadLocal buffersTL = new ThreadLocal(){

        protected Object initialValue() {
            return new Buffers();
        }
    };
    private static CharsetEncoder encoder = Charset.forName("US-ASCII").newEncoder();

    private APIUtils() {
    }

    private static char[] getArray(int size) {
        char[] array = (char[])arrayTL.get();
        if (array.length < size) {
            for (int sizeNew = array.length << 1; sizeNew < size; sizeNew <<= 1) {
            }
            array = new char[size];
            arrayTL.set(array);
        }
        return array;
    }

    static ByteBuffer getBufferByte(int size) {
        ByteBuffer buffer = (ByteBuffer)bufferTL.get();
        if (buffer.capacity() < size) {
            for (int sizeNew = buffer.capacity() << 1; sizeNew < size; sizeNew <<= 1) {
            }
            buffer = BufferUtils.createByteBuffer(size);
            bufferTL.set(buffer);
        } else {
            buffer.clear();
        }
        return buffer;
    }

    private static ByteBuffer getBufferByteOffset(int size) {
        ByteBuffer buffer = (ByteBuffer)bufferTL.get();
        if (buffer.capacity() < size) {
            for (int sizeNew = buffer.capacity() << 1; sizeNew < size; sizeNew <<= 1) {
            }
            ByteBuffer bufferNew = BufferUtils.createByteBuffer(size);
            bufferNew.put(buffer);
            buffer = bufferNew;
            bufferTL.set(buffer);
        } else {
            buffer.position(buffer.limit());
            buffer.limit(buffer.capacity());
        }
        return buffer;
    }

    static ShortBuffer getBufferShort() {
        return ((Buffers)APIUtils.buffersTL.get()).shorts;
    }

    static IntBuffer getBufferInt() {
        return ((Buffers)APIUtils.buffersTL.get()).ints;
    }

    static LongBuffer getBufferLong() {
        return ((Buffers)APIUtils.buffersTL.get()).longs;
    }

    static FloatBuffer getBufferFloat() {
        return ((Buffers)APIUtils.buffersTL.get()).floats;
    }

    static DoubleBuffer getBufferDouble() {
        return ((Buffers)APIUtils.buffersTL.get()).doubles;
    }

    static IntBuffer getLengths() {
        return APIUtils.getLengths(1);
    }

    static IntBuffer getLengths(int size) {
        IntBuffer lengths = (IntBuffer)lengthsTL.get();
        if (lengths.capacity() < size) {
            for (int sizeNew = lengths.capacity(); sizeNew < size; sizeNew <<= 1) {
            }
            lengths = BufferUtils.createIntBuffer(size);
            lengthsTL.set(lengths);
        } else {
            lengths.clear();
        }
        return lengths;
    }

    private static InfiniteCharSequence getInfiniteSeq() {
        return (InfiniteCharSequence)infiniteSeqTL.get();
    }

    private static void encode(ByteBuffer buffer, CharSequence string) {
        InfiniteCharSequence infiniteSeq = APIUtils.getInfiniteSeq();
        infiniteSeq.setString(string);
        encoder.encode(infiniteSeq.buffer, buffer, true);
    }

    static String getString(ByteBuffer buffer) {
        int length = buffer.remaining();
        char[] charArray = APIUtils.getArray(length);
        for (int i2 = buffer.position(); i2 < buffer.limit(); ++i2) {
            charArray[i2 - buffer.position()] = (char)buffer.get(i2);
        }
        return new String(charArray, 0, length);
    }

    static ByteBuffer getBuffer(CharSequence string) {
        ByteBuffer buffer = APIUtils.getBufferByte(string.length());
        APIUtils.encode(buffer, string);
        buffer.flip();
        return buffer;
    }

    static ByteBuffer getBuffer(CharSequence string, int offset) {
        ByteBuffer buffer = APIUtils.getBufferByteOffset(offset + string.length());
        APIUtils.encode(buffer, string);
        buffer.flip();
        return buffer;
    }

    static ByteBuffer getBufferNT(CharSequence string) {
        ByteBuffer buffer = APIUtils.getBufferByte(string.length() + 1);
        APIUtils.encode(buffer, string);
        buffer.put((byte)0);
        buffer.flip();
        return buffer;
    }

    static int getTotalLength(CharSequence[] strings) {
        int length = 0;
        for (int i2 = 0; i2 < strings.length; ++i2) {
            length += strings[i2].length();
        }
        return length;
    }

    static ByteBuffer getBuffer(CharSequence[] strings) {
        ByteBuffer buffer = APIUtils.getBufferByte(APIUtils.getTotalLength(strings));
        InfiniteCharSequence infiniteSeq = APIUtils.getInfiniteSeq();
        for (int i2 = 0; i2 < strings.length; ++i2) {
            infiniteSeq.setString(strings[i2]);
            encoder.encode(infiniteSeq.buffer, buffer, true);
        }
        infiniteSeq.clear();
        buffer.flip();
        return buffer;
    }

    static ByteBuffer getBufferNT(CharSequence[] strings) {
        ByteBuffer buffer = APIUtils.getBufferByte(APIUtils.getTotalLength(strings) + strings.length);
        InfiniteCharSequence infiniteSeq = APIUtils.getInfiniteSeq();
        for (int i2 = 0; i2 < strings.length; ++i2) {
            infiniteSeq.setString(strings[i2]);
            encoder.encode(infiniteSeq.buffer, buffer, true);
            buffer.put((byte)0);
        }
        infiniteSeq.clear();
        buffer.flip();
        return buffer;
    }

    static IntBuffer getLengths(CharSequence[] strings) {
        IntBuffer buffer = APIUtils.getLengths(strings.length);
        for (int i2 = 0; i2 < strings.length; ++i2) {
            buffer.put(strings[i2].length());
        }
        buffer.flip();
        return buffer;
    }

    private static class Buffers {
        final ShortBuffer shorts = BufferUtils.createShortBuffer(32);
        final IntBuffer ints = BufferUtils.createIntBuffer(32);
        final LongBuffer longs = BufferUtils.createLongBuffer(32);
        final FloatBuffer floats = BufferUtils.createFloatBuffer(32);
        final DoubleBuffer doubles = BufferUtils.createDoubleBuffer(32);

        Buffers() {
        }
    }

    private static class InfiniteCharSequence
    implements CharSequence {
        final CharBuffer buffer = CharBuffer.wrap(this);
        CharSequence string;

        InfiniteCharSequence() {
        }

        void setString(CharSequence string) {
            this.string = string;
            this.buffer.position(0);
            this.buffer.limit(string.length());
        }

        void clear() {
            this.string = null;
        }

        public int length() {
            return Integer.MAX_VALUE;
        }

        public char charAt(int index) {
            return this.string.charAt(index);
        }

        public CharSequence subSequence(int start, int end) {
            return this.string.subSequence(start, end);
        }
    }
}

