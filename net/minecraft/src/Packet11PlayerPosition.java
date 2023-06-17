/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Packet10Flying;

public class Packet11PlayerPosition
extends Packet10Flying {
    public Packet11PlayerPosition() {
        this.moving = true;
    }

    public Packet11PlayerPosition(double d2, double d1, double d22, double d3, boolean flag) {
        this.xPosition = d2;
        this.yPosition = d1;
        this.stance = d22;
        this.zPosition = d3;
        this.onGround = flag;
        this.moving = true;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.xPosition = datainputstream.readDouble();
        this.yPosition = datainputstream.readDouble();
        this.stance = datainputstream.readDouble();
        this.zPosition = datainputstream.readDouble();
        super.readPacketData(datainputstream);
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeDouble(this.xPosition);
        dataoutputstream.writeDouble(this.yPosition);
        dataoutputstream.writeDouble(this.stance);
        dataoutputstream.writeDouble(this.zPosition);
        super.writePacketData(dataoutputstream);
    }

    @Override
    public int getPacketSize() {
        return 33;
    }
}

