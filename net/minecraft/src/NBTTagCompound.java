/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.src.NBTBase;
import net.minecraft.src.NBTTagByte;
import net.minecraft.src.NBTTagByteArray;
import net.minecraft.src.NBTTagDouble;
import net.minecraft.src.NBTTagFloat;
import net.minecraft.src.NBTTagInt;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.NBTTagLong;
import net.minecraft.src.NBTTagShort;
import net.minecraft.src.NBTTagString;

public class NBTTagCompound
extends NBTBase {
    private Map tagMap = new HashMap();

    @Override
    void writeTagContents(DataOutput dataoutput) throws IOException {
        for (NBTBase nbtbase : this.tagMap.values()) {
            NBTBase.writeTag(nbtbase, dataoutput);
        }
        dataoutput.writeByte(0);
    }

    @Override
    void readTagContents(DataInput datainput) throws IOException {
        NBTBase nbtbase;
        this.tagMap.clear();
        while ((nbtbase = NBTBase.readTag(datainput)).getType() != 0) {
            this.tagMap.put(nbtbase.getKey(), nbtbase);
        }
    }

    @Override
    public byte getType() {
        return 10;
    }

    public void setTag(String s2, NBTBase nbtbase) {
        this.tagMap.put(s2, nbtbase.setKey(s2));
    }

    public void setByte(String s2, byte byte0) {
        this.tagMap.put(s2, new NBTTagByte(byte0).setKey(s2));
    }

    public void setShort(String s2, short word0) {
        this.tagMap.put(s2, new NBTTagShort(word0).setKey(s2));
    }

    public void setInteger(String s2, int i2) {
        this.tagMap.put(s2, new NBTTagInt(i2).setKey(s2));
    }

    public void setLong(String s2, long l2) {
        this.tagMap.put(s2, new NBTTagLong(l2).setKey(s2));
    }

    public void setFloat(String s2, float f2) {
        this.tagMap.put(s2, new NBTTagFloat(f2).setKey(s2));
    }

    public void setDouble(String s2, double d2) {
        this.tagMap.put(s2, new NBTTagDouble(d2).setKey(s2));
    }

    public void setString(String s2, String s1) {
        this.tagMap.put(s2, new NBTTagString(s1).setKey(s2));
    }

    public void setByteArray(String s2, byte[] abyte0) {
        this.tagMap.put(s2, new NBTTagByteArray(abyte0).setKey(s2));
    }

    public void setCompoundTag(String s2, NBTTagCompound nbttagcompound) {
        this.tagMap.put(s2, nbttagcompound.setKey(s2));
    }

    public void setBoolean(String s2, boolean flag) {
        this.setByte(s2, (byte)(flag ? 1 : 0));
    }

    public boolean hasKey(String s2) {
        return this.tagMap.containsKey(s2);
    }

    public byte getByte(String s2) {
        if (!this.tagMap.containsKey(s2)) {
            return 0;
        }
        return ((NBTTagByte)this.tagMap.get((Object)s2)).byteValue;
    }

    public short getShort(String s2) {
        if (!this.tagMap.containsKey(s2)) {
            return 0;
        }
        return ((NBTTagShort)this.tagMap.get((Object)s2)).shortValue;
    }

    public int getInteger(String s2) {
        if (!this.tagMap.containsKey(s2)) {
            return 0;
        }
        return ((NBTTagInt)this.tagMap.get((Object)s2)).intValue;
    }

    public long getLong(String s2) {
        if (!this.tagMap.containsKey(s2)) {
            return 0L;
        }
        return ((NBTTagLong)this.tagMap.get((Object)s2)).longValue;
    }

    public float getFloat(String s2) {
        if (!this.tagMap.containsKey(s2)) {
            return 0.0f;
        }
        return ((NBTTagFloat)this.tagMap.get((Object)s2)).floatValue;
    }

    public double getDouble(String s2) {
        if (!this.tagMap.containsKey(s2)) {
            return 0.0;
        }
        return ((NBTTagDouble)this.tagMap.get((Object)s2)).doubleValue;
    }

    public String getString(String s2) {
        if (!this.tagMap.containsKey(s2)) {
            return "";
        }
        return ((NBTTagString)this.tagMap.get((Object)s2)).stringValue;
    }

    public byte[] getByteArray(String s2) {
        if (!this.tagMap.containsKey(s2)) {
            return new byte[0];
        }
        return ((NBTTagByteArray)this.tagMap.get((Object)s2)).byteArray;
    }

    public NBTTagCompound getCompoundTag(String s2) {
        if (!this.tagMap.containsKey(s2)) {
            return new NBTTagCompound();
        }
        return (NBTTagCompound)this.tagMap.get(s2);
    }

    public NBTTagList getTagList(String s2) {
        if (!this.tagMap.containsKey(s2)) {
            return new NBTTagList();
        }
        return (NBTTagList)this.tagMap.get(s2);
    }

    public boolean getBoolean(String s2) {
        return this.getByte(s2) != 0;
    }

    public String toString() {
        return "" + this.tagMap.size() + " entries";
    }
}

