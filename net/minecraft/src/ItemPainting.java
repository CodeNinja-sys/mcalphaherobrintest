/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityPainting;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemPainting
extends Item {
    public ItemPainting(int i2) {
        super(i2);
        this.maxDamage = 64;
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i2, int j2, int k2, int l2) {
        EntityPainting entitypainting;
        if (l2 == 0) {
            return false;
        }
        if (l2 == 1) {
            return false;
        }
        int byte0 = 0;
        if (l2 == 4) {
            byte0 = 1;
        }
        if (l2 == 3) {
            byte0 = 2;
        }
        if (l2 == 5) {
            byte0 = 3;
        }
        if ((entitypainting = new EntityPainting(world, i2, j2, k2, byte0)).func_410_i()) {
            world.entityJoinedWorld(entitypainting);
            --itemstack.stackSize;
        }
        return true;
    }
}

