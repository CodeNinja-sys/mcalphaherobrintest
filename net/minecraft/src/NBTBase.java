/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NBTTagByte;
import net.minecraft.src.NBTTagByteArray;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagDouble;
import net.minecraft.src.NBTTagEnd;
import net.minecraft.src.NBTTagFloat;
import net.minecraft.src.NBTTagInt;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.NBTTagLong;
import net.minecraft.src.NBTTagShort;
import net.minecraft.src.NBTTagString;

public abstract class NBTBase {
    private String key = null;

    abstract void writeTagContents(DataOutput var1) throws IOException;

    abstract void readTagContents(DataInput var1) throws IOException;

    public abstract byte getType();

    public String getKey() {
        if (this.key == null) {
            return "";
        }
        return this.key;
    }

    public NBTBase setKey(String s2) {
        this.key = s2;
        return this;
    }

    public static NBTBase readTag(DataInput datainput) throws IOException {
        byte byte0 = datainput.readByte();
        if (byte0 == 0) {
            return new NBTTagEnd();
        }
        NBTBase nbtbase = NBTBase.createTagOfType(byte0);
        nbtbase.key = datainput.readUTF();
        nbtbase.readTagContents(datainput);
        return nbtbase;
    }

    public static void writeTag(NBTBase nbtbase, DataOutput dataoutput) throws IOException {
        dataoutput.writeByte(nbtbase.getType());
        if (nbtbase.getType() == 0) {
            return;
        }
        dataoutput.writeUTF(nbtbase.getKey());
        nbtbase.writeTagContents(dataoutput);
    }

    public static NBTBase createTagOfType(byte byte0) {
        switch (byte0) {
            case 0: {
                return new NBTTagEnd();
            }
            case 1: {
                return new NBTTagByte();
            }
            case 2: {
                return new NBTTagShort();
            }
            case 3: {
                return new NBTTagInt();
            }
            case 4: {
                return new NBTTagLong();
            }
            case 5: {
                return new NBTTagFloat();
            }
            case 6: {
                return new NBTTagDouble();
            }
            case 7: {
                return new NBTTagByteArray();
            }
            case 8: {
                return new NBTTagString();
            }
            case 9: {
                return new NBTTagList();
            }
            case 10: {
                return new NBTTagCompound();
            }
        }
        return null;
    }

    public static String getTagName(byte byte0) {
        switch (byte0) {
            case 0: {
                return "TAG_End";
            }
            case 1: {
                return "TAG_Byte";
            }
            case 2: {
                return "TAG_Short";
            }
            case 3: {
                return "TAG_Int";
            }
            case 4: {
                return "TAG_Long";
            }
            case 5: {
                return "TAG_Float";
            }
            case 6: {
                return "TAG_Double";
            }
            case 7: {
                return "TAG_Byte_Array";
            }
            case 8: {
                return "TAG_String";
            }
            case 9: {
                return "TAG_List";
            }
            case 10: {
                return "TAG_Compound";
            }
        }
        return "UNKNOWN";
    }
}

