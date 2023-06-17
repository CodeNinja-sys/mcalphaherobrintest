/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockLadder
extends Block {
    protected BlockLadder(int i2, int j2) {
        super(i2, j2, Material.circuits);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockMetadata(i2, j2, k2);
        float f2 = 0.125f;
        if (l2 == 2) {
            this.setBlockBounds(0.0f, 0.0f, 1.0f - f2, 1.0f, 1.0f, 1.0f);
        }
        if (l2 == 3) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f2);
        }
        if (l2 == 4) {
            this.setBlockBounds(1.0f - f2, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        if (l2 == 5) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, f2, 1.0f, 1.0f);
        }
        return super.getCollisionBoundingBoxFromPool(world, i2, j2, k2);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockMetadata(i2, j2, k2);
        float f2 = 0.125f;
        if (l2 == 2) {
            this.setBlockBounds(0.0f, 0.0f, 1.0f - f2, 1.0f, 1.0f, 1.0f);
        }
        if (l2 == 3) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f2);
        }
        if (l2 == 4) {
            this.setBlockBounds(1.0f - f2, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        if (l2 == 5) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, f2, 1.0f, 1.0f);
        }
        return super.getSelectedBoundingBoxFromPool(world, i2, j2, k2);
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
        return 8;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        if (world.isBlockOpaqueCube(i2 - 1, j2, k2)) {
            return true;
        }
        if (world.isBlockOpaqueCube(i2 + 1, j2, k2)) {
            return true;
        }
        if (world.isBlockOpaqueCube(i2, j2, k2 - 1)) {
            return true;
        }
        return world.isBlockOpaqueCube(i2, j2, k2 + 1);
    }

    @Override
    public void onBlockPlaced(World world, int i2, int j2, int k2, int l2) {
        int i1 = world.getBlockMetadata(i2, j2, k2);
        if ((i1 == 0 || l2 == 2) && world.isBlockOpaqueCube(i2, j2, k2 + 1)) {
            i1 = 2;
        }
        if ((i1 == 0 || l2 == 3) && world.isBlockOpaqueCube(i2, j2, k2 - 1)) {
            i1 = 3;
        }
        if ((i1 == 0 || l2 == 4) && world.isBlockOpaqueCube(i2 + 1, j2, k2)) {
            i1 = 4;
        }
        if ((i1 == 0 || l2 == 5) && world.isBlockOpaqueCube(i2 - 1, j2, k2)) {
            i1 = 5;
        }
        world.setBlockMetadataWithNotify(i2, j2, k2, i1);
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        int i1 = world.getBlockMetadata(i2, j2, k2);
        boolean flag = false;
        if (i1 == 2 && world.isBlockOpaqueCube(i2, j2, k2 + 1)) {
            flag = true;
        }
        if (i1 == 3 && world.isBlockOpaqueCube(i2, j2, k2 - 1)) {
            flag = true;
        }
        if (i1 == 4 && world.isBlockOpaqueCube(i2 + 1, j2, k2)) {
            flag = true;
        }
        if (i1 == 5 && world.isBlockOpaqueCube(i2 - 1, j2, k2)) {
            flag = true;
        }
        if (!flag) {
            this.dropBlockAsItem(world, i2, j2, k2, i1);
            world.setBlockWithNotify(i2, j2, k2, 0);
        }
        super.onNeighborBlockChange(world, i2, j2, k2, l2);
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }
}

