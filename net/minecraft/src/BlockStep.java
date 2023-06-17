/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockStep
extends Block {
    private boolean field_469_a;

    public BlockStep(int i2, boolean flag) {
        super(i2, 6, Material.rock);
        this.field_469_a = flag;
        if (!flag) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        }
        this.setLightOpacity(255);
    }

    @Override
    public int getBlockTextureFromSide(int i2) {
        return i2 > 1 ? 5 : 6;
    }

    @Override
    public boolean isOpaqueCube() {
        return this.field_469_a;
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        if (this != Block.stairSingle) {
            return;
        }
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
        int l2;
        if (this != Block.stairSingle) {
            super.onBlockAdded(world, i2, j2, k2);
        }
        if ((l2 = world.getBlockId(i2, j2 - 1, k2)) == BlockStep.stairSingle.blockID) {
            world.setBlockWithNotify(i2, j2, k2, 0);
            world.setBlockWithNotify(i2, j2 - 1, k2, Block.stairDouble.blockID);
        }
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Block.stairSingle.blockID;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return this.field_469_a;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        if (this != Block.stairSingle) {
            super.shouldSideBeRendered(iblockaccess, i2, j2, k2, l2);
        }
        if (l2 == 1) {
            return true;
        }
        if (!super.shouldSideBeRendered(iblockaccess, i2, j2, k2, l2)) {
            return false;
        }
        if (l2 == 0) {
            return true;
        }
        return iblockaccess.getBlockId(i2, j2, k2) != this.blockID;
    }
}

