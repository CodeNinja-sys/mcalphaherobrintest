/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemMinecart
extends Item {
    public int field_317_a;

    public ItemMinecart(int i2, int j2) {
        super(i2);
        this.maxStackSize = 1;
        this.field_317_a = j2;
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i2, int j2, int k2, int l2) {
        int i1 = world.getBlockId(i2, j2, k2);
        if (i1 == Block.minecartTrack.blockID) {
            if (!world.multiplayerWorld) {
                world.entityJoinedWorld(new EntityMinecart(world, (float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f, this.field_317_a));
            }
            --itemstack.stackSize;
            return true;
        }
        return false;
    }
}

