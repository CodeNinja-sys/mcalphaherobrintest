/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Entity;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet18ArmAnimation
extends Packet {
    public int entityId;
    public int animate;

    public Packet18ArmAnimation() {
    }

    public Packet18ArmAnimation(Entity entity, int i2) {
        this.entityId = entity.field_620_ab;
        this.animate = i2;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.entityId = datainputstream.readInt();
        this.animate = datainputstream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.entityId);
        dataoutputstream.writeByte(this.animate);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleArmAnimation(this);
    }

    @Override
    public int getPacketSize() {
        return 5;
    }
}

