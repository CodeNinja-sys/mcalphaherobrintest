/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockSoil
extends Block {
    protected BlockSoil(int i2) {
        super(i2, Material.ground);
        this.blockIndexInTexture = 87;
        this.setTickOnLoad(true);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.9375f, 1.0f);
        this.setLightOpacity(255);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        return AxisAlignedBB.getBoundingBoxFromPool(i2 + 0, j2 + 0, k2 + 0, i2 + 1, j2 + 1, k2 + 1);
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
    public int getBlockTextureFromSideAndMetadata(int i2, int j2) {
        if (i2 == 1 && j2 > 0) {
            return this.blockIndexInTexture - 1;
        }
        if (i2 == 1) {
            return this.blockIndexInTexture;
        }
        return 2;
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        if (random.nextInt(5) == 0) {
            if (this.func_274_i(world, i2, j2, k2)) {
                world.setBlockMetadataWithNotify(i2, j2, k2, 7);
            } else {
                int l2 = world.getBlockMetadata(i2, j2, k2);
                if (l2 > 0) {
                    world.setBlockMetadataWithNotify(i2, j2, k2, l2 - 1);
                } else if (!this.func_275_h(world, i2, j2, k2)) {
                    world.setBlockWithNotify(i2, j2, k2, Block.dirt.blockID);
                }
            }
        }
    }

    @Override
    public void onEntityWalking(World world, int i2, int j2, int k2, Entity entity) {
        if (world.rand.nextInt(4) == 0) {
            world.setBlockWithNotify(i2, j2, k2, Block.dirt.blockID);
        }
    }

    private boolean func_275_h(World world, int i2, int j2, int k2) {
        int l2 = 0;
        for (int i1 = i2 - l2; i1 <= i2 + l2; ++i1) {
            for (int j1 = k2 - l2; j1 <= k2 + l2; ++j1) {
                if (world.getBlockId(i1, j2 + 1, j1) != Block.crops.blockID) continue;
                return true;
            }
        }
        return false;
    }

    private boolean func_274_i(World world, int i2, int j2, int k2) {
        for (int l2 = i2 - 4; l2 <= i2 + 4; ++l2) {
            for (int i1 = j2; i1 <= j2 + 1; ++i1) {
                for (int j1 = k2 - 4; j1 <= k2 + 4; ++j1) {
                    if (world.getBlockMaterial(l2, i1, j1) != Material.water) continue;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        super.onNeighborBlockChange(world, i2, j2, k2, l2);
        Material material = world.getBlockMaterial(i2, j2 + 1, k2);
        if (material.func_878_a()) {
            world.setBlockWithNotify(i2, j2, k2, Block.dirt.blockID);
        }
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Block.dirt.idDropped(0, random);
    }
}

