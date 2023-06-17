/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet60
extends Packet {
    public double field_12236_a;
    public double field_12235_b;
    public double field_12239_c;
    public float field_12238_d;
    public Set field_12237_e;

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.field_12236_a = datainputstream.readDouble();
        this.field_12235_b = datainputstream.readDouble();
        this.field_12239_c = datainputstream.readDouble();
        this.field_12238_d = datainputstream.readFloat();
        int i2 = datainputstream.readInt();
        this.field_12237_e = new HashSet();
        int j2 = (int)this.field_12236_a;
        int k2 = (int)this.field_12235_b;
        int l2 = (int)this.field_12239_c;
        for (int i1 = 0; i1 < i2; ++i1) {
            int j1 = datainputstream.readByte() + j2;
            int k1 = datainputstream.readByte() + k2;
            int l1 = datainputstream.readByte() + l2;
            this.field_12237_e.add(new ChunkPosition(j1, k1, l1));
        }
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeDouble(this.field_12236_a);
        dataoutputstream.writeDouble(this.field_12235_b);
        dataoutputstream.writeDouble(this.field_12239_c);
        dataoutputstream.writeFloat(this.field_12238_d);
        dataoutputstream.writeInt(this.field_12237_e.size());
        int i2 = (int)this.field_12236_a;
        int j2 = (int)this.field_12235_b;
        int k2 = (int)this.field_12239_c;
        for (ChunkPosition chunkposition : this.field_12237_e) {
            int l2 = chunkposition.x - i2;
            int i1 = chunkposition.y - j2;
            int j1 = chunkposition.z - k2;
            dataoutputstream.writeByte(l2);
            dataoutputstream.writeByte(i1);
            dataoutputstream.writeByte(j1);
        }
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.func_12245_a(this);
    }

    @Override
    public int getPacketSize() {
        return 32 + this.field_12237_e.size() * 3;
    }
}

