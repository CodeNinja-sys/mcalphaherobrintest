/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTBase;

public class NBTTagByteArray
extends NBTBase {
    public byte[] byteArray;

    public NBTTagByteArray() {
    }

    public NBTTagByteArray(byte[] abyte0) {
        this.byteArray = abyte0;
    }

    @Override
    void writeTagContents(DataOutput dataoutput) throws IOException {
        dataoutput.writeInt(this.byteArray.length);
        dataoutput.write(this.byteArray);
    }

    @Override
    void readTagContents(DataInput datainput) throws IOException {
        int i2 = datainput.readInt();
        this.byteArray = new byte[i2];
        datainput.readFully(this.byteArray);
    }

    @Override
    public byte getType() {
        return 7;
    }

    public String toString() {
        return "[" + this.byteArray.length + " bytes]";
    }
}

