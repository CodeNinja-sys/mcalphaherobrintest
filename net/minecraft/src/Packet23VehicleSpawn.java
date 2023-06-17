/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet23VehicleSpawn
extends Packet {
    public int entityId;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int type;

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.entityId = datainputstream.readInt();
        this.type = datainputstream.readByte();
        this.xPosition = datainputstream.readInt();
        this.yPosition = datainputstream.readInt();
        this.zPosition = datainputstream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.entityId);
        dataoutputstream.writeByte(this.type);
        dataoutputstream.writeInt(this.xPosition);
        dataoutputstream.writeInt(this.yPosition);
        dataoutputstream.writeInt(this.zPosition);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleVehicleSpawn(this);
    }

    @Override
    public int getPacketSize() {
        return 17;
    }
}

