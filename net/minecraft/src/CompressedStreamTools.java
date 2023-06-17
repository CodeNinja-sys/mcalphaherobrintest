/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.minecraft.src.NBTBase;
import net.minecraft.src.NBTTagCompound;

public class CompressedStreamTools {
    public static NBTTagCompound func_1138_a(InputStream inputstream) throws IOException {
        try (DataInputStream datainputstream = new DataInputStream(new GZIPInputStream(inputstream));){
            NBTTagCompound nbttagcompound;
            NBTTagCompound nBTTagCompound = nbttagcompound = CompressedStreamTools.func_1141_a(datainputstream);
            return nBTTagCompound;
        }
    }

    public static void writeGzippedCompoundToOutputStream(NBTTagCompound nbttagcompound, OutputStream outputstream) throws IOException {
        try (DataOutputStream dataoutputstream = new DataOutputStream(new GZIPOutputStream(outputstream));){
            CompressedStreamTools.func_1139_a(nbttagcompound, dataoutputstream);
        }
    }

    public static NBTTagCompound func_1140_a(byte[] abyte0) throws IOException {
        try (DataInputStream datainputstream = new DataInputStream(new GZIPInputStream(new ByteArrayInputStream(abyte0)));){
            NBTTagCompound nbttagcompound;
            NBTTagCompound nBTTagCompound = nbttagcompound = CompressedStreamTools.func_1141_a(datainputstream);
            return nBTTagCompound;
        }
    }

    public static byte[] func_1142_a(NBTTagCompound nbttagcompound) throws IOException {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try (DataOutputStream dataoutputstream = new DataOutputStream(new GZIPOutputStream(bytearrayoutputstream));){
            CompressedStreamTools.func_1139_a(nbttagcompound, dataoutputstream);
        }
        return bytearrayoutputstream.toByteArray();
    }

    public static NBTTagCompound func_1141_a(DataInput datainput) throws IOException {
        NBTBase nbtbase = NBTBase.readTag(datainput);
        if (nbtbase instanceof NBTTagCompound) {
            return (NBTTagCompound)nbtbase;
        }
        throw new IOException("Root tag must be a named compound tag");
    }

    public static void func_1139_a(NBTTagCompound nbttagcompound, DataOutput dataoutput) throws IOException {
        NBTBase.writeTag(nbttagcompound, dataoutput);
    }
}

