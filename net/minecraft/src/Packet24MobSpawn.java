/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet24MobSpawn
extends Packet {
    public int entityId;
    public byte type;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte yaw;
    public byte pitch;

    public Packet24MobSpawn() {
    }

    public Packet24MobSpawn(EntityLiving entityliving) {
        this.entityId = entityliving.field_620_ab;
        this.type = (byte)EntityList.getEntityID(entityliving);
        this.xPosition = MathHelper.floor_double(entityliving.posX * 32.0);
        this.yPosition = MathHelper.floor_double(entityliving.posY * 32.0);
        this.zPosition = MathHelper.floor_double(entityliving.posZ * 32.0);
        this.yaw = (byte)(entityliving.rotationYaw * 256.0f / 360.0f);
        this.pitch = (byte)(entityliving.rotationPitch * 256.0f / 360.0f);
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.entityId = datainputstream.readInt();
        this.type = datainputstream.readByte();
        this.xPosition = datainputstream.readInt();
        this.yPosition = datainputstream.readInt();
        this.zPosition = datainputstream.readInt();
        this.yaw = datainputstream.readByte();
        this.pitch = datainputstream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.entityId);
        dataoutputstream.writeByte(this.type);
        dataoutputstream.writeInt(this.xPosition);
        dataoutputstream.writeInt(this.yPosition);
        dataoutputstream.writeInt(this.zPosition);
        dataoutputstream.writeByte(this.yaw);
        dataoutputstream.writeByte(this.pitch);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleMobSpawn(this);
    }

    @Override
    public int getPacketSize() {
        return 19;
    }
}

