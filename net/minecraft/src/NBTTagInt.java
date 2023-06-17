/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagInt
extends NBTBase {
    public int intValue;

    public NBTTagInt() {
    }

    public NBTTagInt(int i2) {
        this.intValue = i2;
    }

    @Override
    void writeTagContents(DataOutput dataoutput) throws IOException {
        dataoutput.writeInt(this.intValue);
    }

    @Override
    void readTagContents(DataInput datainput) throws IOException {
        this.intValue = datainput.readInt();
    }

    @Override
    public byte getType() {
        return 3;
    }

    public String toString() {
        return "" + this.intValue;
    }
}

