/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Packet30Entity;

public class Packet31RelEntityMove
extends Packet30Entity {
    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        super.readPacketData(datainputstream);
        this.xPosition = datainputstream.readByte();
        this.yPosition = datainputstream.readByte();
        this.zPosition = datainputstream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        super.writePacketData(dataoutputstream);
        dataoutputstream.writeByte(this.xPosition);
        dataoutputstream.writeByte(this.yPosition);
        dataoutputstream.writeByte(this.zPosition);
    }

    @Override
    public int getPacketSize() {
        return 7;
    }
}

