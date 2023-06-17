/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet22Collect
extends Packet {
    public int collectedEntityId;
    public int collectorEntityId;

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.collectedEntityId = datainputstream.readInt();
        this.collectorEntityId = datainputstream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.collectedEntityId);
        dataoutputstream.writeInt(this.collectorEntityId);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleCollect(this);
    }

    @Override
    public int getPacketSize() {
        return 8;
    }
}

