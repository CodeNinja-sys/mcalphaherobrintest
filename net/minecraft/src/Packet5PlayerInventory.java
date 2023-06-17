/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet5PlayerInventory
extends Packet {
    public int type;
    public ItemStack[] stacks;

    public Packet5PlayerInventory() {
    }

    public Packet5PlayerInventory(int i2, ItemStack[] aitemstack) {
        this.type = i2;
        this.stacks = new ItemStack[aitemstack.length];
        for (int j2 = 0; j2 < this.stacks.length; ++j2) {
            this.stacks[j2] = aitemstack[j2] != null ? aitemstack[j2].copy() : null;
        }
    }

    @Override
    public void readPacketData(DataInputStream datainputstream) throws IOException {
        this.type = datainputstream.readInt();
        int word0 = datainputstream.readShort();
        this.stacks = new ItemStack[word0];
        for (int i2 = 0; i2 < word0; ++i2) {
            short word1 = datainputstream.readShort();
            if (word1 < 0) continue;
            byte byte0 = datainputstream.readByte();
            short word2 = datainputstream.readShort();
            this.stacks[i2] = new ItemStack(word1, byte0, word2);
        }
    }

    @Override
    public void writePacketData(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.type);
        dataoutputstream.writeShort(this.stacks.length);
        for (int i2 = 0; i2 < this.stacks.length; ++i2) {
            if (this.stacks[i2] == null) {
                dataoutputstream.writeShort(-1);
                continue;
            }
            dataoutputstream.writeShort((short)this.stacks[i2].itemID);
            dataoutputstream.writeByte((byte)this.stacks[i2].stackSize);
            dataoutputstream.writeShort((short)this.stacks[i2].itemDamage);
        }
    }

    @Override
    public void processPacket(NetHandler nethandler) {
        nethandler.handlePlayerInventory(this);
    }

    @Override
    public int getPacketSize() {
        return 6 + this.stacks.length * 5;
    }
}

