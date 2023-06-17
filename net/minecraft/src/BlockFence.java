/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockFence
extends Block {
    public BlockFence(int i2, int j2) {
        super(i2, j2, Material.wood);
    }

    @Override
    public void getCollidingBoundingBoxes(World world, int i2, int j2, int k2, AxisAlignedBB axisalignedbb, ArrayList arraylist) {
        arraylist.add(AxisAlignedBB.getBoundingBoxFromPool(i2, j2, k2, i2 + 1, (double)j2 + 1.5, k2 + 1));
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        if (world.getBlockId(i2, j2 - 1, k2) == this.blockID) {
            return false;
        }
        if (!world.getBlockMaterial(i2, j2 - 1, k2).func_878_a()) {
            return false;
        }
        return super.canPlaceBlockAt(world, i2, j2, k2);
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
        return 11;
    }
}

