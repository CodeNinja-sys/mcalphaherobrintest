/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Packet10Flying;

public class Packet13PlayerLookMove
extends Packet10Flying {
    public Packet13PlayerLookMove() {
        this.rotating = true;
        this.moving = true;
    }

    public Packet13PlayerLookMove(double d2, double d1, double d22, double d3, float f2, float f1, boolean flag) {
        this.xPosition = d2;
        this.yPosition = d1;
        this.stance = d22;
        this.zPosition = d3;
        this.yaw = f2;
        this.pitch = f1;
        this.onGround = flag;
        this.rotating = true;
        this.moving = true;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.xPosition = datainputstream.readDouble();
        this.yPosition = datainputstream.readDouble();
        this.stance = datainputstream.readDouble();
        this.zPosition = datainputstream.readDouble();
        this.yaw = datainputstream.readFloat();
        this.pitch = datainputstream.readFloat();
        super.readPacketData(datainputstream);
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeDouble(this.xPosition);
        dataoutputstream.writeDouble(this.yPosition);
        dataoutputstream.writeDouble(this.stance);
        dataoutputstream.writeDouble(this.zPosition);
        dataoutputstream.writeFloat(this.yaw);
        dataoutputstream.writeFloat(this.pitch);
        super.writePacketData(dataoutputstream);
    }

    @Override
    public int getPacketSize() {
        return 41;
    }
}

