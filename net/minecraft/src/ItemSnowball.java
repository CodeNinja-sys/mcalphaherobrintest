/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySnowball;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemSnowball
extends Item {
    public ItemSnowball(int i2) {
        super(i2);
        this.maxStackSize = 16;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        --itemstack.stackSize;
        world.playSoundAtEntity(entityplayer, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
        if (!world.multiplayerWorld) {
            world.entityJoinedWorld(new EntitySnowball(world, entityplayer));
        }
        return itemstack;
    }
}

