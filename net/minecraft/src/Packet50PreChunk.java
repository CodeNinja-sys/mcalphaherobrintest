/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet50PreChunk
extends Packet {
    public int xPosition;
    public int yPosition;
    public boolean mode;

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.xPosition = datainputstream.readInt();
        this.yPosition = datainputstream.readInt();
        this.mode = datainputstream.read() != 0;
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.xPosition);
        dataoutputstream.writeInt(this.yPosition);
        dataoutputstream.write(this.mode ? 1 : 0);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handlePreChunk(this);
    }

    @Override
    public int getPacketSize() {
        return 9;
    }
}

