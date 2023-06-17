/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockFlower
extends Block {
    protected BlockFlower(int i2, int j2) {
        super(i2, Material.plants);
        this.blockIndexInTexture = j2;
        this.setTickOnLoad(true);
        float f2 = 0.2f;
        this.setBlockBounds(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, f2 * 3.0f, 0.5f + f2);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        return this.canThisPlantGrowOnThisBlockID(world.getBlockId(i2, j2 - 1, k2));
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i2) {
        return i2 == Block.grass.blockID || i2 == Block.dirt.blockID || i2 == Block.tilledField.blockID;
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        super.onNeighborBlockChange(world, i2, j2, k2, l2);
        this.func_268_h(world, i2, j2, k2);
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        this.func_268_h(world, i2, j2, k2);
    }

    protected final void func_268_h(World world, int i2, int j2, int k2) {
        if (!this.canBlockStay(world, i2, j2, k2)) {
            this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
            world.setBlockWithNotify(i2, j2, k2, 0);
        }
    }

    @Override
    public boolean canBlockStay(World world, int i2, int j2, int k2) {
        return (world.getBlockLightValue(i2, j2, k2) >= 8 || world.canBlockSeeTheSky(i2, j2, k2)) && this.canThisPlantGrowOnThisBlockID(world.getBlockId(i2, j2 - 1, k2));
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        return null;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 1;
    }
}

