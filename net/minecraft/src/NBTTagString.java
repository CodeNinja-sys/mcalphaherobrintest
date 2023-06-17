/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagString
extends NBTBase {
    public String stringValue;

    public NBTTagString() {
    }

    public NBTTagString(String s2) {
        this.stringValue = s2;
        if (s2 == null) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
    }

    @Override
    void writeTagContents(DataOutput dataoutput) throws IOException {
        dataoutput.writeUTF(this.stringValue);
    }

    @Override
    void readTagContents(DataInput datainput) throws IOException {
        this.stringValue = datainput.readUTF();
    }

    @Override
    public byte getType() {
        return 8;
    }

    public String toString() {
        return "" + this.stringValue;
    }
}

