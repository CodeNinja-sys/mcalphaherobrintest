/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet34EntityTeleport
extends Packet {
    public int entityId;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte yaw;
    public byte pitch;

    public Packet34EntityTeleport() {
    }

    public Packet34EntityTeleport(Entity entity) {
        this.entityId = entity.field_620_ab;
        this.xPosition = MathHelper.floor_double(entity.posX * 32.0);
        this.yPosition = MathHelper.floor_double(entity.posY * 32.0);
        this.zPosition = MathHelper.floor_double(entity.posZ * 32.0);
        this.yaw = (byte)(entity.rotationYaw * 256.0f / 360.0f);
        this.pitch = (byte)(entity.rotationPitch * 256.0f / 360.0f);
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.entityId = datainputstream.readInt();
        this.xPosition = datainputstream.readInt();
        this.yPosition = datainputstream.readInt();
        this.zPosition = datainputstream.readInt();
        this.yaw = (byte)datainputstream.read();
        this.pitch = (byte)datainputstream.read();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.entityId);
        dataoutputstream.writeInt(this.xPosition);
        dataoutputstream.writeInt(this.yPosition);
        dataoutputstream.writeInt(this.zPosition);
        dataoutputstream.write(this.yaw);
        dataoutputstream.write(this.pitch);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleEntityTeleport(this);
    }

    @Override
    public int getPacketSize() {
        return 34;
    }
}

