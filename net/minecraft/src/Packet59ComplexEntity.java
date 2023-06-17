/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;
import net.minecraft.src.TileEntity;

public class Packet59ComplexEntity
extends Packet {
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte[] entityData;
    public NBTTagCompound entityNBT;

    public Packet59ComplexEntity() {
        this.isChunkDataPacket = true;
    }

    public Packet59ComplexEntity(int i2, int j2, int k2, TileEntity tileentity) {
        this.isChunkDataPacket = true;
        this.xPosition = i2;
        this.yPosition = j2;
        this.zPosition = k2;
        this.entityNBT = new NBTTagCompound();
        tileentity.writeToNBT(this.entityNBT);
        try {
            this.entityData = CompressedStreamTools.func_1142_a(this.entityNBT);
        }
        catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.xPosition = datainputstream.readInt();
        this.yPosition = datainputstream.readShort();
        this.zPosition = datainputstream.readInt();
        int i2 = datainputstream.readShort() & 0xFFFF;
        this.entityData = new byte[i2];
        datainputstream.readFully(this.entityData);
        this.entityNBT = CompressedStreamTools.func_1140_a(this.entityData);
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.xPosition);
        dataoutputstream.writeShort(this.yPosition);
        dataoutputstream.writeInt(this.zPosition);
        dataoutputstream.writeShort((short)this.entityData.length);
        dataoutputstream.write(this.entityData);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleComplexEntity(this);
    }

    @Override
    public int getPacketSize() {
        return this.entityData.length + 2 + 10;
    }
}

