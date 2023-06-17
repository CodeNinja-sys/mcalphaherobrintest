/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockReed
extends Block {
    protected BlockReed(int i2, int j2) {
        super(i2, Material.plants);
        this.blockIndexInTexture = j2;
        float f2 = 0.375f;
        this.setBlockBounds(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, 1.0f, 0.5f + f2);
        this.setTickOnLoad(true);
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        if (world.getBlockId(i2, j2 + 1, k2) == 0) {
            int l2 = 1;
            while (world.getBlockId(i2, j2 - l2, k2) == this.blockID) {
                ++l2;
            }
            if (l2 < 3) {
                int i1 = world.getBlockMetadata(i2, j2, k2);
                if (i1 == 15) {
                    world.setBlockWithNotify(i2, j2 + 1, k2, this.blockID);
                    world.setBlockMetadataWithNotify(i2, j2, k2, 0);
                } else {
                    world.setBlockMetadataWithNotify(i2, j2, k2, i1 + 1);
                }
            }
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockId(i2, j2 - 1, k2);
        if (l2 == this.blockID) {
            return true;
        }
        if (l2 != Block.grass.blockID && l2 != Block.dirt.blockID) {
            return false;
        }
        if (world.getBlockMaterial(i2 - 1, j2 - 1, k2) == Material.water) {
            return true;
        }
        if (world.getBlockMaterial(i2 + 1, j2 - 1, k2) == Material.water) {
            return true;
        }
        if (world.getBlockMaterial(i2, j2 - 1, k2 - 1) == Material.water) {
            return true;
        }
        return world.getBlockMaterial(i2, j2 - 1, k2 + 1) == Material.water;
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        this.checkBlockCoordValid(world, i2, j2, k2);
    }

    protected final void checkBlockCoordValid(World world, int i2, int j2, int k2) {
        if (!this.canBlockStay(world, i2, j2, k2)) {
            this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
            world.setBlockWithNotify(i2, j2, k2, 0);
        }
    }

    @Override
    public boolean canBlockStay(World world, int i2, int j2, int k2) {
        return this.canPlaceBlockAt(world, i2, j2, k2);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        return null;
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Item.reed.shiftedIndex;
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

