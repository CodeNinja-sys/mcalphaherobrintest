/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemSoup
extends ItemFood {
    public ItemSoup(int i2, int j2) {
        super(i2, j2);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        super.onItemRightClick(itemstack, world, entityplayer);
        return new ItemStack(Item.bowlEmpty);
    }
}

