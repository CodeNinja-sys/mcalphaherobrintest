/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagByte
extends NBTBase {
    public byte byteValue;

    public NBTTagByte() {
    }

    public NBTTagByte(byte byte0) {
        this.byteValue = byte0;
    }

    @Override
    void writeTagContents(DataOutput dataoutput) throws IOException {
        dataoutput.writeByte(this.byteValue);
    }

    @Override
    void readTagContents(DataInput datainput) throws IOException {
        this.byteValue = datainput.readByte();
    }

    @Override
    public byte getType() {
        return 1;
    }

    public String toString() {
        return "" + this.byteValue;
    }
}

