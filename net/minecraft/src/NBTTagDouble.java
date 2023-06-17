/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagDouble
extends NBTBase {
    public double doubleValue;

    public NBTTagDouble() {
    }

    public NBTTagDouble(double d2) {
        this.doubleValue = d2;
    }

    @Override
    void writeTagContents(DataOutput dataoutput) throws IOException {
        dataoutput.writeDouble(this.doubleValue);
    }

    @Override
    void readTagContents(DataInput datainput) throws IOException {
        this.doubleValue = datainput.readDouble();
    }

    @Override
    public byte getType() {
        return 6;
    }

    public String toString() {
        return "" + this.doubleValue;
    }
}

