/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagShort
extends NBTBase {
    public short shortValue;

    public NBTTagShort() {
    }

    public NBTTagShort(short word0) {
        this.shortValue = word0;
    }

    @Override
    void writeTagContents(DataOutput dataoutput) throws IOException {
        dataoutput.writeShort(this.shortValue);
    }

    @Override
    void readTagContents(DataInput datainput) throws IOException {
        this.shortValue = datainput.readShort();
    }

    @Override
    public byte getType() {
        return 2;
    }

    public String toString() {
        return "" + this.shortValue;
    }
}

