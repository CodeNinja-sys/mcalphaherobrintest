/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemSword
extends Item {
    private int weaponDamage;

    public ItemSword(int i2, int j2) {
        super(i2);
        this.maxStackSize = 1;
        this.maxDamage = 32 << j2;
        if (j2 == 3) {
            this.maxDamage *= 4;
        }
        this.weaponDamage = 4 + j2 * 2;
    }

    @Override
    public float getStrVsBlock(ItemStack itemstack, Block block) {
        return 1.5f;
    }

    @Override
    public void hitEntity(ItemStack itemstack, EntityLiving entityliving) {
        itemstack.damageItem(1);
    }

    @Override
    public void hitBlock(ItemStack itemstack, int i2, int j2, int k2, int l2) {
        itemstack.damageItem(2);
    }

    @Override
    public int getDamageVsEntity(Entity entity) {
        return this.weaponDamage;
    }

    @Override
    public boolean isFull3D() {
        return true;
    }
}

