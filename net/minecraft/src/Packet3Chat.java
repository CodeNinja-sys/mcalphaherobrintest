/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet3Chat
extends Packet {
    public String message;

    public Packet3Chat() {
    }

    public Packet3Chat(String s2) {
        this.message = s2;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.message = datainputstream.readUTF();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeUTF(this.message);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleChat(this);
    }

    @Override
    public int getPacketSize() {
        return this.message.length();
    }
}

