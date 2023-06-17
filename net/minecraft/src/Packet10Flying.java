/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet10Flying
extends Packet {
    public double xPosition;
    public double yPosition;
    public double zPosition;
    public double stance;
    public float yaw;
    public float pitch;
    public boolean onGround;
    public boolean moving;
    public boolean rotating;

    public Packet10Flying() {
    }

    public Packet10Flying(boolean flag) {
        this.onGround = flag;
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handleFlying(this);
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.onGround = datainputstream.read() != 0;
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.write(this.onGround ? 1 : 0);
    }

    @Override
    public int getPacketSize() {
        return 1;
    }
}

