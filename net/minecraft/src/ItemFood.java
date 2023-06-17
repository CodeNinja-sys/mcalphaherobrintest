/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemFood
extends Item {
    private int healAmount;

    public ItemFood(int i2, int j2) {
        super(i2);
        this.healAmount = j2;
        this.maxStackSize = 1;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        --itemstack.stackSize;
        entityplayer.heal(this.healAmount);
        return itemstack;
    }
}

