/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.NBTBase;

public class NBTTagList
extends NBTBase {
    private List tagList = new ArrayList();
    private byte tagType;

    @Override
    void writeTagContents(DataOutput dataoutput) throws IOException {
        this.tagType = this.tagList.size() > 0 ? ((NBTBase)this.tagList.get(0)).getType() : (byte)1;
        dataoutput.writeByte(this.tagType);
        dataoutput.writeInt(this.tagList.size());
        for (int i2 = 0; i2 < this.tagList.size(); ++i2) {
            ((NBTBase)this.tagList.get(i2)).writeTagContents(dataoutput);
        }
    }

    @Override
    void readTagContents(DataInput datainput) throws IOException {
        this.tagType = datainput.readByte();
        int i2 = datainput.readInt();
        this.tagList = new ArrayList();
        for (int j2 = 0; j2 < i2; ++j2) {
            NBTBase nbtbase = NBTBase.createTagOfType(this.tagType);
            nbtbase.readTagContents(datainput);
            this.tagList.add(nbtbase);
        }
    }

    @Override
    public byte getType() {
        return 9;
    }

    public String toString() {
        return "" + this.tagList.size() + " entries of type " + NBTBase.getTagName(this.tagType);
    }

    public void setTag(NBTBase nbtbase) {
        this.tagType = nbtbase.getType();
        this.tagList.add(nbtbase);
    }

    public NBTBase tagAt(int i2) {
        return (NBTBase)this.tagList.get(i2);
    }

    public int tagCount() {
        return this.tagList.size();
    }
}

