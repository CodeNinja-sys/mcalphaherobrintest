/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Packet30Entity;

public class Packet32EntityLook
extends Packet30Entity {
    public Packet32EntityLook() {
        this.rotating = true;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        super.readPacketData(datainputstream);
        this.yaw = datainputstream.readByte();
        this.pitch = datainputstream.readByte();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        super.writePacketData(dataoutputstream);
        dataoutputstream.writeByte(this.yaw);
        dataoutputstream.writeByte(this.pitch);
    }

    @Override
    public int getPacketSize() {
        return 6;
    }
}

