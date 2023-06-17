/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemRecord
extends Item {
    private String recordName;

    protected ItemRecord(int i2, String s2) {
        super(i2);
        this.recordName = s2;
        this.maxStackSize = 1;
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i2, int j2, int k2, int l2) {
        if (world.getBlockId(i2, j2, k2) == Block.jukebox.blockID && world.getBlockMetadata(i2, j2, k2) == 0) {
            world.setBlockMetadataWithNotify(i2, j2, k2, this.shiftedIndex - Item.record13.shiftedIndex + 1);
            world.playRecord(this.recordName, i2, j2, k2);
            --itemstack.stackSize;
            return true;
        }
        return false;
    }
}

