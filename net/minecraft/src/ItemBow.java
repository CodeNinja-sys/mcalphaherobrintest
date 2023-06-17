/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemBow
extends Item {
    public ItemBow(int i2) {
        super(i2);
        this.maxStackSize = 1;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        if (entityplayer.inventory.consumeInventoryItem(Item.arrow.shiftedIndex)) {
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0f, 1.0f / (itemRand.nextFloat() * 0.4f + 0.8f));
            if (!world.multiplayerWorld) {
                world.entityJoinedWorld(new EntityArrow(world, entityplayer));
            }
        }
        return itemstack;
    }
}

