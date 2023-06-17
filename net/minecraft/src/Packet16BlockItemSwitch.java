/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet16BlockItemSwitch
extends Packet {
    public int unused;
    public int id;

    public Packet16BlockItemSwitch() {
    }

    public Packet16BlockItemSwitch(int i2, int j2) {
        this.unused = i2;
        this.id = j2;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.unused = datainputstream.readInt();
        this.id = datainputstream.readShort();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.unused);
        dataoutputstream.writeShort(this.id);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleBlockItemSwitch(this);
    }

    @Override
    public int getPacketSize() {
        return 6;
    }
}

