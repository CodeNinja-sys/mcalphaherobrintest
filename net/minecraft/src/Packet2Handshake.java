/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet2Handshake
extends Packet {
    public String username;

    public Packet2Handshake() {
    }

    public Packet2Handshake(String s2) {
        this.username = s2;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.username = datainputstream.readUTF();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeUTF(this.username);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleHandshake(this);
    }

    @Override
    public int getPacketSize() {
        return 4 + this.username.length() + 4;
    }
}

