/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.World;

public class BlockMushroom
extends BlockFlower {
    protected BlockMushroom(int i2, int j2) {
        super(i2, j2);
        float f2 = 0.2f;
        this.setBlockBounds(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, f2 * 2.0f, 0.5f + f2);
    }

    @Override
    protected boolean canThisPlantGrowOnThisBlockID(int i2) {
        return Block.opaqueCubeLookup[i2];
    }

    @Override
    public boolean canBlockStay(World world, int i2, int j2, int k2) {
        return world.getBlockLightValue(i2, j2, k2) <= 13 && this.canThisPlantGrowOnThisBlockID(world.getBlockId(i2, j2 - 1, k2));
    }
}

