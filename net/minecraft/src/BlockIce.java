/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockBreakable;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockIce
extends BlockBreakable {
    public BlockIce(int i2, int j2) {
        super(i2, j2, Material.ice, false);
        this.slipperiness = 0.98f;
        this.setTickOnLoad(true);
    }

    @Override
    public int func_234_g() {
        return 1;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        return super.shouldSideBeRendered(iblockaccess, i2, j2, k2, 1 - l2);
    }

    @Override
    public void onBlockRemoval(World world, int i2, int j2, int k2) {
        Material material = world.getBlockMaterial(i2, j2 - 1, k2);
        if (material.func_880_c() || material.getIsLiquid()) {
            world.setBlockWithNotify(i2, j2, k2, Block.waterStill.blockID);
        }
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        if (world.getSavedLightValue(EnumSkyBlock.Block, i2, j2, k2) > 11 - Block.lightOpacity[this.blockID]) {
            this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
            world.setBlockWithNotify(i2, j2, k2, Block.waterMoving.blockID);
        }
    }
}

