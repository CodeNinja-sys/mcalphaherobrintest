/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockStone
extends Block {
    public BlockStone(int i2, int j2) {
        super(i2, j2, Material.rock);
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Block.cobblestone.blockID;
    }
}

