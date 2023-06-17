/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagLong
extends NBTBase {
    public long longValue;

    public NBTTagLong() {
    }

    public NBTTagLong(long l2) {
        this.longValue = l2;
    }

    @Override
    void writeTagContents(DataOutput dataoutput) throws IOException {
        dataoutput.writeLong(this.longValue);
    }

    @Override
    void readTagContents(DataInput datainput) throws IOException {
        this.longValue = datainput.readLong();
    }

    @Override
    public byte getType() {
        return 4;
    }

    public String toString() {
        return "" + this.longValue;
    }
}

