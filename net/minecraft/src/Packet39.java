/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet39
extends Packet {
    public int field_6365_a;
    public int field_6364_b;

    @Override
    public int getPacketSize() {
        return 8;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.field_6365_a = datainputstream.readInt();
        this.field_6364_b = datainputstream.readInt();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.field_6365_a);
        dataoutputstream.writeInt(this.field_6364_b);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.func_6497_a(this);
    }
}

