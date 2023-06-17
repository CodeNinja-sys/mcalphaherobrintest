/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagFloat
extends NBTBase {
    public float floatValue;

    public NBTTagFloat() {
    }

    public NBTTagFloat(float f2) {
        this.floatValue = f2;
    }

    @Override
    void writeTagContents(DataOutput dataoutput) throws IOException {
        dataoutput.writeFloat(this.floatValue);
    }

    @Override
    void readTagContents(DataInput datainput) throws IOException {
        this.floatValue = datainput.readFloat();
    }

    @Override
    public byte getType() {
        return 5;
    }

    public String toString() {
        return "" + this.floatValue;
    }
}

