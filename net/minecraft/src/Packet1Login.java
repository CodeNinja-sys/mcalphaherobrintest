/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet1Login
extends Packet {
    public int protocolVersion;
    public String username;
    public String password;
    public long field_4074_d;
    public byte field_4073_e;

    public Packet1Login() {
    }

    public Packet1Login(String s2, String s1, int i2) {
        this.username = s2;
        this.password = s1;
        this.protocolVersion = i2;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.protocolVersion = datainputstream.readInt();
        this.username = datainputstream.readUTF();
        this.password = datainputstream.readUTF();
        this.field_4074_d = datainputstream.readLong();
        this.field_4073_e = datainputstream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.protocolVersion);
        dataoutputstream.writeUTF(this.username);
        dataoutputstream.writeUTF(this.password);
        dataoutputstream.writeLong(this.field_4074_d);
        dataoutputstream.writeByte(this.field_4073_e);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleLogin(this);
    }

    @Override
    public int getPacketSize() {
        return 4 + this.username.length() + this.password.length() + 4 + 5;
    }
}

