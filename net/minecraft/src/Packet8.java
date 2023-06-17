/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet8
extends Packet {
    public int healthMP;

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.healthMP = datainputstream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeByte(this.healthMP);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleHealth(this);
    }

    @Override
    public int getPacketSize() {
        return 1;
    }
}

