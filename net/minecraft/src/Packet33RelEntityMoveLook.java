/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Packet30Entity;

public class Packet33RelEntityMoveLook
extends Packet30Entity {
    public Packet33RelEntityMoveLook() {
        this.rotating = true;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        super.readPacketData(datainputstream);
        this.xPosition = datainputstream.readByte();
        this.yPosition = datainputstream.readByte();
        this.zPosition = datainputstream.readByte();
        this.yaw = datainputstream.readByte();
        this.pitch = datainputstream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        super.writePacketData(dataoutputstream);
        dataoutputstream.writeByte(this.xPosition);
        dataoutputstream.writeByte(this.yPosition);
        dataoutputstream.writeByte(this.zPosition);
        dataoutputstream.writeByte(this.yaw);
        dataoutputstream.writeByte(this.pitch);
    }

    @Override
    public int getPacketSize() {
        return 9;
    }
}

