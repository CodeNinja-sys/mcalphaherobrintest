/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet14BlockDig
extends Packet {
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int face;
    public int status;

    public Packet14BlockDig() {
    }

    public Packet14BlockDig(int i2, int j2, int k2, int l2, int i1) {
        this.status = i2;
        this.xPosition = j2;
        this.yPosition = k2;
        this.zPosition = l2;
        this.face = i1;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.status = datainputstream.read();
        this.xPosition = datainputstream.readInt();
        this.yPosition = datainputstream.read();
        this.zPosition = datainputstream.readInt();
        this.face = datainputstream.read();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.write(this.status);
        dataoutputstream.writeInt(this.xPosition);
        dataoutputstream.write(this.yPosition);
        dataoutputstream.writeInt(this.zPosition);
        dataoutputstream.write(this.face);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleBlockDig(this);
    }

    @Override
    public int getPacketSize() {
        return 11;
    }
}

