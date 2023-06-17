/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.EntityItem;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet21PickupSpawn
extends Packet {
    public int entityId;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte rotation;
    public byte pitch;
    public byte roll;
    public int itemId;
    public int count;

    public Packet21PickupSpawn() {
    }

    public Packet21PickupSpawn(EntityItem entityitem) {
        this.entityId = entityitem.field_620_ab;
        this.itemId = entityitem.item.itemID;
        this.count = entityitem.item.stackSize;
        this.xPosition = MathHelper.floor_double(entityitem.posX * 32.0);
        this.yPosition = MathHelper.floor_double(entityitem.posY * 32.0);
        this.zPosition = MathHelper.floor_double(entityitem.posZ * 32.0);
        this.rotation = (byte)(entityitem.motionX * 128.0);
        this.pitch = (byte)(entityitem.motionY * 128.0);
        this.roll = (byte)(entityitem.motionZ * 128.0);
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.entityId = datainputstream.readInt();
        this.itemId = datainputstream.readShort();
        this.count = datainputstream.readByte();
        this.xPosition = datainputstream.readInt();
        this.yPosition = datainputstream.readInt();
        this.zPosition = datainputstream.readInt();
        this.rotation = datainputstream.readByte();
        this.pitch = datainputstream.readByte();
        this.roll = datainputstream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.entityId);
        dataoutputstream.writeShort(this.itemId);
        dataoutputstream.writeByte(this.count);
        dataoutputstream.writeInt(this.xPosition);
        dataoutputstream.writeInt(this.yPosition);
        dataoutputstream.writeInt(this.zPosition);
        dataoutputstream.writeByte(this.rotation);
        dataoutputstream.writeByte(this.pitch);
        dataoutputstream.writeByte(this.roll);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handlePickupSpawn(this);
    }

    @Override
    public int getPacketSize() {
        return 22;
    }
}

