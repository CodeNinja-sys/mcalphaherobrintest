/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet29DestroyEntity
extends Packet {
    public int entityId;

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.entityId = datainputstream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.entityId);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleDestroyEntity(this);
    }

    @Override
    public int getPacketSize() {
        return 4;
    }
}

