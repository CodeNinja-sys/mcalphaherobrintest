/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet20NamedEntitySpawn
extends Packet {
    public int entityId;
    public String name;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public byte rotation;
    public byte pitch;
    public int currentItem;

    public Packet20NamedEntitySpawn() {
    }

    public Packet20NamedEntitySpawn(EntityPlayer entityplayer) {
        this.entityId = entityplayer.field_620_ab;
        this.name = entityplayer.field_771_i;
        this.xPosition = MathHelper.floor_double(entityplayer.posX * 32.0);
        this.yPosition = MathHelper.floor_double(entityplayer.posY * 32.0);
        this.zPosition = MathHelper.floor_double(entityplayer.posZ * 32.0);
        this.rotation = (byte)(entityplayer.rotationYaw * 256.0f / 360.0f);
        this.pitch = (byte)(entityplayer.rotationPitch * 256.0f / 360.0f);
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        this.currentItem = itemstack != null ? itemstack.itemID : 0;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.entityId = datainputstream.readInt();
        this.name = datainputstream.readUTF();
        this.xPosition = datainputstream.readInt();
        this.yPosition = datainputstream.readInt();
        this.zPosition = datainputstream.readInt();
        this.rotation = datainputstream.readByte();
        this.pitch = datainputstream.readByte();
        this.currentItem = datainputstream.readShort();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.entityId);
        dataoutputstream.writeUTF(this.name);
        dataoutputstream.writeInt(this.xPosition);
        dataoutputstream.writeInt(this.yPosition);
        dataoutputstream.writeInt(this.zPosition);
        dataoutputstream.writeByte(this.rotation);
        dataoutputstream.writeByte(this.pitch);
        dataoutputstream.writeShort(this.currentItem);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleNamedEntitySpawn(this);
    }

    @Override
    public int getPacketSize() {
        return 28;
    }
}

