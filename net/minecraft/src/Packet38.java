/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet38
extends Packet {
    public int field_9274_a;
    public byte field_9273_b;

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.field_9274_a = datainputstream.readInt();
        this.field_9273_b = datainputstream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.field_9274_a);
        dataoutputstream.writeByte(this.field_9273_b);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.func_9447_a(this);
    }

    @Override
    public int getPacketSize() {
        return 5;
    }
}

