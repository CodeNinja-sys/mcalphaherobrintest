/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet7
extends Packet {
    public int field_9277_a;
    public int field_9276_b;
    public int field_9278_c;

    public Packet7() {
    }

    public Packet7(int i2, int j2, int k2) {
        this.field_9277_a = i2;
        this.field_9276_b = j2;
        this.field_9278_c = k2;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.field_9277_a = datainputstream.readInt();
        this.field_9276_b = datainputstream.readInt();
        this.field_9278_c = datainputstream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.field_9277_a);
        dataoutputstream.writeInt(this.field_9276_b);
        dataoutputstream.writeByte(this.field_9278_c);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.func_6499_a(this);
    }

    @Override
    public int getPacketSize() {
        return 9;
    }
}

