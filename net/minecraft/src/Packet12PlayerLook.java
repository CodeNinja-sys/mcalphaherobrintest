/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Packet10Flying;

public class Packet12PlayerLook
extends Packet10Flying {
    public Packet12PlayerLook() {
        this.rotating = true;
    }

    public Packet12PlayerLook(float f2, float f1, boolean flag) {
        this.yaw = f2;
        this.pitch = f1;
        this.onGround = flag;
        this.rotating = true;
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.yaw = datainputstream.readFloat();
        this.pitch = datainputstream.readFloat();
        super.readPacketData(datainputstream);
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeFloat(this.yaw);
        dataoutputstream.writeFloat(this.pitch);
        super.writePacketData(dataoutputstream);
    }

    @Override
    public int getPacketSize() {
        return 9;
    }
}

