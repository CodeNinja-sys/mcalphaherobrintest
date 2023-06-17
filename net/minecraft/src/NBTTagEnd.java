/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagEnd
extends NBTBase {
    @Override
    void readTagContents(DataInput datainput) throws IOException {
    }

    @Override
    void writeTagContents(DataOutput dataoutput) throws IOException {
    }

    @Override
    public byte getType() {
        return 0;
    }

    public String toString() {
        return "END";
    }
}

