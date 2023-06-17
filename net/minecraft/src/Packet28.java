/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Entity;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet28
extends Packet {
    public int field_6367_a;
    public int field_6366_b;
    public int field_6369_c;
    public int field_6368_d;

    public Packet28() {
    }

    public Packet28(Entity entity) {
        this(entity.field_620_ab, entity.motionX, entity.motionY, entity.motionZ);
    }

    public Packet28(int i2, double d2, double d1, double d22) {
        this.field_6367_a = i2;
        double d3 = 3.9;
        if (d2 < -d3) {
            d2 = -d3;
        }
        if (d1 < -d3) {
            d1 = -d3;
        }
        if (d22 < -d3) {
            d22 = -d3;
        }
        if (d2 > d3) {
            d2 = d3;
        }
        if (d1 > d3) {
            d1 = d3;
        }
        if (d22 > d3) {
            d22 = d3;
        }
        this.field_6366_b = (int)(d2 * 8000.0);
        this.field_6369_c = (int)(d1 * 8000.0);
        this.field_6368_d = (int)(d22 * 8000.0);
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.field_6367_a = datainputstream.readInt();
        this.field_6366_b = datainputstream.readShort();
        this.field_6369_c = datainputstream.readShort();
        this.field_6368_d = datainputstream.readShort();
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.field_6367_a);
        dataoutputstream.writeShort(this.field_6366_b);
        dataoutputstream.writeShort(this.field_6369_c);
        dataoutputstream.writeShort(this.field_6368_d);
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.func_6498_a(this);
    }

    @Override
    public int getPacketSize() {
        return 10;
    }
}

