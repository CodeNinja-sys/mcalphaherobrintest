/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet4UpdateTime
extends Packet {
    public long time;

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.time = datainputstream.readLong();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeLong(this.time);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleUpdateTime(this);
    }

    @Override
    public int getPacketSize() {
        return 8;
    }
}

