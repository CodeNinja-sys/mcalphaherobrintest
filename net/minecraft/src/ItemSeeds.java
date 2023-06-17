/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemSeeds
extends Item {
    private int field_318_a;

    public ItemSeeds(int i2, int j2) {
        super(i2);
        this.field_318_a = j2;
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i2, int j2, int k2, int l2) {
        if (l2 != 1) {
            return false;
        }
        int i1 = world.getBlockId(i2, j2, k2);
        if (i1 == Block.tilledField.blockID) {
            world.setBlockWithNotify(i2, j2 + 1, k2, this.field_318_a);
            --itemstack.stackSize;
            return true;
        }
        return false;
    }
}

