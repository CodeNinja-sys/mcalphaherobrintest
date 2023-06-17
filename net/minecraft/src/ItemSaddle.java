/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPig;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemSaddle
extends Item {
    public ItemSaddle(int i2) {
        super(i2);
        this.maxStackSize = 1;
        this.maxDamage = 64;
    }

    @Override
    public void func_4019_b(ItemStack itemstack, EntityLiving entityliving) {
        if (entityliving instanceof EntityPig) {
            EntityPig entitypig = (EntityPig)entityliving;
            if (!entitypig.rideable) {
                entitypig.rideable = true;
                --itemstack.stackSize;
            }
        }
    }

    @Override
    public void hitEntity(ItemStack itemstack, EntityLiving entityliving) {
        this.func_4019_b(itemstack, entityliving);
    }
}

