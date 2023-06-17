/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.ItemTool;

public class ItemSpade
extends ItemTool {
    private static Block[] blocksEffectiveAgainst = new Block[]{Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay};

    public ItemSpade(int i2, int j2) {
        super(i2, 1, j2, blocksEffectiveAgainst);
    }

    @Override
    public boolean canHarvestBlock(Block block) {
        if (block == Block.snow) {
            return true;
        }
        return block == Block.blockSnow;
    }
}

