/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet51MapChunk
extends Packet {
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int xSize;
    public int ySize;
    public int zSize;
    public byte[] chunk;
    private int chunkSize;

    public Packet51MapChunk() {
        this.isChunkDataPacket = true;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.xPosition = datainputstream.readInt();
        this.yPosition = datainputstream.readShort();
        this.zPosition = datainputstream.readInt();
        this.xSize = datainputstream.read() + 1;
        this.ySize = datainputstream.read() + 1;
        this.zSize = datainputstream.read() + 1;
        int i2 = datainputstream.readInt();
        byte[] abyte0 = new byte[i2];
        datainputstream.readFully(abyte0);
        this.chunk = new byte[this.xSize * this.ySize * this.zSize * 5 / 2];
        Inflater inflater = new Inflater();
        inflater.setInput(abyte0);
        try {
            try {
                inflater.inflate(this.chunk);
            }
            catch (DataFormatException dataformatexception) {
                throw new IOException("Bad compressed data format");
            }
        }
        finally {
            inflater.end();
        }
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.xPosition);
        dataoutputstream.writeShort(this.yPosition);
        dataoutputstream.writeInt(this.zPosition);
        dataoutputstream.write(this.xSize - 1);
        dataoutputstream.write(this.ySize - 1);
        dataoutputstream.write(this.zSize - 1);
        dataoutputstream.writeInt(this.chunkSize);
        dataoutputstream.write(this.chunk, 0, this.chunkSize);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleMapChunk(this);
    }

    @Override
    public int getPacketSize() {
        return 17 + this.chunkSize;
    }
}

