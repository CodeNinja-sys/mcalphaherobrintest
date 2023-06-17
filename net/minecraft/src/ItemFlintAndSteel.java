/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemFlintAndSteel
extends Item {
    public ItemFlintAndSteel(int i2) {
        super(i2);
        this.maxStackSize = 1;
        this.maxDamage = 64;
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i2, int j2, int k2, int l2) {
        int i1;
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
        if ((i1 = world.getBlockId(i2, j2, k2)) == 0) {
            world.playSoundEffect((double)i2 + 0.5, (double)j2 + 0.5, (double)k2 + 0.5, "fire.ignite", 1.0f, itemRand.nextFloat() * 0.4f + 0.8f);
            world.setBlockWithNotify(i2, j2, k2, Block.fire.blockID);
        }
        itemstack.damageItem(1);
        return true;
    }
}

