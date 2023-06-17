/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet15Place
extends Packet {
    public int id;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int direction;

    public Packet15Place() {
    }

    public Packet15Place(int i2, int j2, int k2, int l2, int i1) {
        this.id = i2;
        this.xPosition = j2;
        this.yPosition = k2;
        this.zPosition = l2;
        this.direction = i1;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.id = datainputstream.readShort();
        this.xPosition = datainputstream.readInt();
        this.yPosition = datainputstream.read();
        this.zPosition = datainputstream.readInt();
        this.direction = datainputstream.read();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeShort(this.id);
        dataoutputstream.writeInt(this.xPosition);
        dataoutputstream.write(this.yPosition);
        dataoutputstream.writeInt(this.zPosition);
        dataoutputstream.write(this.direction);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handlePlace(this);
    }

    @Override
    public int getPacketSize() {
        return 12;
    }
}

