/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.World;

public class ItemSign
extends Item {
    public ItemSign(int i2) {
        super(i2);
        this.maxDamage = 64;
        this.maxStackSize = 1;
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i2, int j2, int k2, int l2) {
        if (l2 == 0) {
            return false;
        }
        if (!world.getBlockMaterial(i2, j2, k2).func_878_a()) {
            return false;
        }
        if (l2 == 1) {
            ++j2;
        }
        if (l2 == 2) {
            --k2;
        }
        if (l2 == 3) {
            ++k2;
        }
        if (l2 == 4) {
            --i2;
        }
        if (l2 == 5) {
            ++i2;
        }
        if (!Block.signPost.canPlaceBlockAt(world, i2, j2, k2)) {
            return false;
        }
        if (l2 == 1) {
            world.setBlockAndMetadataWithNotify(i2, j2, k2, Block.signPost.blockID, MathHelper.floor_double((double)((entityplayer.rotationYaw + 180.0f) * 16.0f / 360.0f) + 0.5) & 0xF);
        } else {
            world.setBlockAndMetadataWithNotify(i2, j2, k2, Block.signWall.blockID, l2);
        }
        --itemstack.stackSize;
        TileEntitySign tileentitysign = (TileEntitySign)world.getBlockTileEntity(i2, j2, k2);
        if (tileentitysign != null) {
            entityplayer.displayGUIEditSign(tileentitysign);
        }
        return true;
    }
}

