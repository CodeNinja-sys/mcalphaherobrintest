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

public class BlockCactus
extends Block {
    protected BlockCactus(int i2, int j2) {
        super(i2, j2, Material.cactus);
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
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        float f2 = 0.0625f;
        return AxisAlignedBB.getBoundingBoxFromPool((float)i2 + f2, j2, (float)k2 + f2, (float)(i2 + 1) - f2, (float)(j2 + 1) - f2, (float)(k2 + 1) - f2);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        float f2 = 0.0625f;
        return AxisAlignedBB.getBoundingBoxFromPool((float)i2 + f2, j2, (float)k2 + f2, (float)(i2 + 1) - f2, j2 + 1, (float)(k2 + 1) - f2);
    }

    @Override
    public int getBlockTextureFromSide(int i2) {
        if (i2 == 1) {
            return this.blockIndexInTexture - 1;
        }
        if (i2 == 0) {
            return this.blockIndexInTexture + 1;
        }
        return this.blockIndexInTexture;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 13;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        if (!super.canPlaceBlockAt(world, i2, j2, k2)) {
            return false;
        }
        return this.canBlockStay(world, i2, j2, k2);
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        if (!this.canBlockStay(world, i2, j2, k2)) {
            this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
            world.setBlockWithNotify(i2, j2, k2, 0);
        }
    }

    @Override
    public boolean canBlockStay(World world, int i2, int j2, int k2) {
        if (world.getBlockMaterial(i2 - 1, j2, k2).func_878_a()) {
            return false;
        }
        if (world.getBlockMaterial(i2 + 1, j2, k2).func_878_a()) {
            return false;
        }
        if (world.getBlockMaterial(i2, j2, k2 - 1).func_878_a()) {
            return false;
        }
        if (world.getBlockMaterial(i2, j2, k2 + 1).func_878_a()) {
            return false;
        }
        int l2 = world.getBlockId(i2, j2 - 1, k2);
        return l2 == Block.cactus.blockID || l2 == Block.sand.blockID;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int i2, int j2, int k2, Entity entity) {
        entity.canAttackEntity(null, 1);
    }
}

