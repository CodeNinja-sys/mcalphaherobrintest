/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityFish;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemFishingRod
extends Item {
    public ItemFishingRod(int i2) {
        super(i2);
        this.maxDamage = 64;
    }

    @Override
    public boolean isFull3D() {
        return true;
    }

    @Override
    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        if (entityplayer.fishEntity != null) {
            int i2 = entityplayer.fishEntity.func_4043_i();
            itemstack.damageItem(i2);
            entityplayer.func_457_w();
        } else {
            world.playSoundAtEntity(entityplayer, "random.bow", 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
            if (!world.multiplayerWorld) {
                world.entityJoinedWorld(new EntityFish(world, entityplayer));
            }
            entityplayer.func_457_w();
        }
        return itemstack;
    }
}

