/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet52MultiBlockChange
extends Packet {
    public int xPosition;
    public int zPosition;
    public short[] coordinateArray;
    public byte[] typeArray;
    public byte[] metadataArray;
    public int size;

    public Packet52MultiBlockChange() {
        this.isChunkDataPacket = true;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.xPosition = datainputstream.readInt();
        this.zPosition = datainputstream.readInt();
        this.size = datainputstream.readShort() & 0xFFFF;
        this.coordinateArray = new short[this.size];
        this.typeArray = new byte[this.size];
        this.metadataArray = new byte[this.size];
        for (int i2 = 0; i2 < this.size; ++i2) {
            this.coordinateArray[i2] = datainputstream.readShort();
        }
        datainputstream.readFully(this.typeArray);
        datainputstream.readFully(this.metadataArray);
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.xPosition);
        dataoutputstream.writeInt(this.zPosition);
        dataoutputstream.writeShort((short)this.size);
        for (int i2 = 0; i2 < this.size; ++i2) {
            dataoutputstream.writeShort(this.coordinateArray[i2]);
        }
        dataoutputstream.write(this.typeArray);
        dataoutputstream.write(this.metadataArray);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleMultiBlockChange(this);
    }

    @Override
    public int getPacketSize() {
        return 10 + this.size * 4;
    }
}

