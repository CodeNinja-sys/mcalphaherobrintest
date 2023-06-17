/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import net.minecraft.src.CodecMus;

class MusInputStream
extends InputStream {
    private int hash;
    private InputStream inputStream;
    byte[] buffer;
    final CodecMus codec;

    public MusInputStream(CodecMus codecmus, URL url, InputStream inputstream) {
        this.codec = codecmus;
        this.buffer = new byte[1];
        this.inputStream = inputstream;
        String s2 = url.getPath();
        s2 = s2.substring(s2.lastIndexOf("/") + 1);
        this.hash = s2.hashCode();
    }

    @Override
    public int read() {
        int i2 = this.read(this.buffer, 0, 1);
        if (i2 < 0) {
            return i2;
        }
        return this.buffer[0];
    }

    @Override
    public int read(byte[] abyte0, int i2, int j2) {
        try {
            j2 = this.inputStream.read(abyte0, i2, j2);
        }
        catch (IOException e2) {
            return 0;
        }
        for (int k2 = 0; k2 < j2; ++k2) {
            int n2 = i2 + k2;
            byte by2 = (byte)(abyte0[n2] ^ this.hash >> 8);
            abyte0[n2] = by2;
            byte byte0 = by2;
            this.hash = this.hash * 498729871 + 85731 * byte0;
        }
        return j2;
    }
}

