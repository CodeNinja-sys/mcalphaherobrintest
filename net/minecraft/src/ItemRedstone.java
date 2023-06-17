/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemRedstone
extends Item {
    public ItemRedstone(int i2) {
        super(i2);
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i2, int j2, int k2, int l2) {
        if (l2 == 0) {
            --j2;
        }
        if (l2 == 1) {
            ++j2;
        }
        if (l2 == 2) {
            --k2;
        }
        if (l2 == 3) {
            ++k2;
        }
        if (l2 == 4) {
            --i2;
        }
        if (l2 == 5) {
            ++i2;
        }
        if (world.getBlockId(i2, j2, k2) != 0) {
            return false;
        }
        if (Block.redstoneWire.canPlaceBlockAt(world, i2, j2, k2)) {
            --itemstack.stackSize;
            world.setBlockWithNotify(i2, j2, k2, Block.redstoneWire.blockID);
        }
        return true;
    }
}

