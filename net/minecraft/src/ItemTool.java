/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemTool
extends Item {
    private Block[] blocksEffectiveAgainst;
    private float efficiencyOnProperMaterial = 4.0f;
    private int damageVsEntity;
    protected int ingredientQuality;

    public ItemTool(int i2, int j2, int k2, Block[] ablock) {
        super(i2);
        this.ingredientQuality = k2;
        this.blocksEffectiveAgainst = ablock;
        this.maxStackSize = 1;
        this.maxDamage = 32 << k2;
        if (k2 == 3) {
            this.maxDamage *= 4;
        }
        this.efficiencyOnProperMaterial = (k2 + 1) * 2;
        this.damageVsEntity = j2 + k2;
    }

    @Override
    public float getStrVsBlock(ItemStack itemstack, Block block) {
        for (int i2 = 0; i2 < this.blocksEffectiveAgainst.length; ++i2) {
            if (this.blocksEffectiveAgainst[i2] != block) continue;
            return this.efficiencyOnProperMaterial;
        }
        return 1.0f;
    }

    @Override
    public void hitEntity(ItemStack itemstack, EntityLiving entityliving) {
        itemstack.damageItem(2);
    }

    @Override
    public void hitBlock(ItemStack itemstack, int i2, int j2, int k2, int l2) {
        itemstack.damageItem(1);
    }

    @Override
    public int getDamageVsEntity(Entity entity) {
        return this.damageVsEntity;
    }

    @Override
    public boolean isFull3D() {
        return true;
    }
}

