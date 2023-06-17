/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class ItemDoor
extends Item {
    private Material field_321_a;

    public ItemDoor(int i2, Material material) {
        super(i2);
        this.field_321_a = material;
        this.maxDamage = 64;
        this.maxStackSize = 1;
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i2, int j2, int k2, int l2) {
        if (l2 != 1) {
            return false;
        }
        Block block = this.field_321_a == Material.wood ? Block.doorWood : Block.doorSteel;
        if (!block.canPlaceBlockAt(world, i2, ++j2, k2)) {
            return false;
        }
        int i1 = MathHelper.floor_double((double)((entityplayer.rotationYaw + 180.0f) * 4.0f / 360.0f) - 0.5) & 3;
        int byte0 = 0;
        int byte1 = 0;
        if (i1 == 0) {
            byte1 = 1;
        }
        if (i1 == 1) {
            byte0 = -1;
        }
        if (i1 == 2) {
            byte1 = -1;
        }
        if (i1 == 3) {
            byte0 = 1;
        }
        int j1 = (world.isBlockOpaqueCube(i2 - byte0, j2, k2 - byte1) ? 1 : 0) + (world.isBlockOpaqueCube(i2 - byte0, j2 + 1, k2 - byte1) ? 1 : 0);
        int k1 = (world.isBlockOpaqueCube(i2 + byte0, j2, k2 + byte1) ? 1 : 0) + (world.isBlockOpaqueCube(i2 + byte0, j2 + 1, k2 + byte1) ? 1 : 0);
        boolean flag = world.getBlockId(i2 - byte0, j2, k2 - byte1) == block.blockID || world.getBlockId(i2 - byte0, j2 + 1, k2 - byte1) == block.blockID;
        boolean flag1 = world.getBlockId(i2 + byte0, j2, k2 + byte1) == block.blockID || world.getBlockId(i2 + byte0, j2 + 1, k2 + byte1) == block.blockID;
        boolean flag2 = false;
        if (flag && !flag1) {
            flag2 = true;
        } else if (k1 > j1) {
            flag2 = true;
        }
        if (flag2) {
            i1 = i1 - 1 & 3;
            i1 += 4;
        }
        world.setBlockWithNotify(i2, j2, k2, block.blockID);
        world.setBlockMetadataWithNotify(i2, j2, k2, i1);
        world.setBlockWithNotify(i2, j2 + 1, k2, block.blockID);
        world.setBlockMetadataWithNotify(i2, j2 + 1, k2, i1 + 8);
        --itemstack.stackSize;
        return true;
    }
}

