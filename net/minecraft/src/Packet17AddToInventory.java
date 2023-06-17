/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet17AddToInventory
extends Packet {
    public int id;
    public int count;
    public int durability;

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.id = datainputstream.readShort();
        this.count = datainputstream.readByte();
        this.durability = datainputstream.readShort();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeShort(this.id);
        dataoutputstream.writeByte(this.count);
        dataoutputstream.writeShort(this.durability);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleAddToInventory(this);
    }

    @Override
    public int getPacketSize() {
        return 5;
    }
}

