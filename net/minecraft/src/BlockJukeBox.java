/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockJukeBox
extends Block {
    protected BlockJukeBox(int i2, int j2) {
        super(i2, j2, Material.wood);
    }

    @Override
    public int getBlockTextureFromSide(int i2) {
        return this.blockIndexInTexture + (i2 != 1 ? 0 : 1);
    }

    @Override
    public boolean blockActivated(World world, int i2, int j2, int k2, EntityPlayer entityplayer) {
        int l2 = world.getBlockMetadata(i2, j2, k2);
        if (l2 > 0) {
            this.ejectRecord(world, i2, j2, k2, l2);
            return true;
        }
        return false;
    }

    public void ejectRecord(World world, int i2, int j2, int k2, int l2) {
        world.playRecord(null, i2, j2, k2);
        world.setBlockMetadataWithNotify(i2, j2, k2, 0);
        int i1 = Item.record13.shiftedIndex + l2 - 1;
        float f2 = 0.7f;
        double d2 = (double)(world.rand.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
        double d1 = (double)(world.rand.nextFloat() * f2) + (double)(1.0f - f2) * 0.2 + 0.6;
        double d22 = (double)(world.rand.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
        EntityItem entityitem = new EntityItem(world, (double)i2 + d2, (double)j2 + d1, (double)k2 + d22, new ItemStack(i1));
        entityitem.field_805_c = 10;
        world.entityJoinedWorld(entityitem);
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int i2, int j2, int k2, int l2, float f2) {
        if (world.multiplayerWorld) {
            return;
        }
        if (l2 > 0) {
            this.ejectRecord(world, i2, j2, k2, l2);
        }
        super.dropBlockAsItemWithChance(world, i2, j2, k2, l2, f2);
    }
}

