/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockStone;

public class BlockObsidian
extends BlockStone {
    public BlockObsidian(int i2, int j2) {
        super(i2, j2);
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Block.obsidian.blockID;
    }
}

