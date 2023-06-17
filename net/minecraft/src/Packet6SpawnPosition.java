/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet6SpawnPosition
extends Packet {
    public int xPosition;
    public int yPosition;
    public int zPosition;

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.xPosition = datainputstream.readInt();
        this.yPosition = datainputstream.readInt();
        this.zPosition = datainputstream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.xPosition);
        dataoutputstream.writeInt(this.yPosition);
        dataoutputstream.writeInt(this.zPosition);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleSpawnPosition(this);
    }

    @Override
    public int getPacketSize() {
        return 12;
    }
}

