/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet53BlockChange
extends Packet {
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int type;
    public int metadata;

    public Packet53BlockChange() {
        this.isChunkDataPacket = true;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.xPosition = datainputstream.readInt();
        this.yPosition = datainputstream.read();
        this.zPosition = datainputstream.readInt();
        this.type = datainputstream.read();
        this.metadata = datainputstream.read();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.xPosition);
        dataoutputstream.write(this.yPosition);
        dataoutputstream.writeInt(this.zPosition);
        dataoutputstream.write(this.type);
        dataoutputstream.write(this.metadata);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleBlockChange(this);
    }

    @Override
    public int getPacketSize() {
        return 11;
    }
}

