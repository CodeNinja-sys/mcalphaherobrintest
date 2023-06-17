/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet255KickDisconnect
extends Packet {
    public String reason;

    public Packet255KickDisconnect() {
    }

    public Packet255KickDisconnect(String s2) {
        this.reason = s2;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.reason = datainputstream.readUTF();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeUTF(this.reason);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleKickDisconnect(this);
    }

    @Override
    public int getPacketSize() {
        return this.reason.length();
    }
}

