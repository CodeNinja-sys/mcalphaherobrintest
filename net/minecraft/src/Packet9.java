/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet9
extends Packet {
    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.func_9448_a(this);
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) {
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) {
    }

    @Override
    public int getPacketSize() {
        return 0;
    }
}

