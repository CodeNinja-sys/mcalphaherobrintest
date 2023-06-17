/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

public class NibbleArray {
    public final byte[] data;

    public NibbleArray(int i2) {
        this.data = new byte[i2 >> 1];
    }

    public NibbleArray(byte[] abyte0) {
        this.data = abyte0;
    }

    public int getNibble(int i2, int j2, int k2) {
        int l2 = i2 << 11 | k2 << 7 | j2;
        int i1 = l2 >> 1;
        int j1 = l2 & 1;
        if (j1 == 0) {
            return this.data[i1] & 0xF;
        }
        return this.data[i1] >> 4 & 0xF;
    }

    public void setNibble(int i2, int j2, int k2, int l2) {
        int i1 = i2 << 11 | k2 << 7 | j2;
        int j1 = i1 >> 1;
        int k1 = i1 & 1;
        this.data[j1] = k1 == 0 ? (byte)(this.data[j1] & 0xF0 | l2 & 0xF) : (byte)(this.data[j1] & 0xF | (l2 & 0xF) << 4);
    }

    public boolean isValid() {
        return this.data != null;
    }
}

