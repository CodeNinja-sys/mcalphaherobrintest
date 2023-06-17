/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.Material;

public class BlockClay
extends Block {
    public BlockClay(int i2, int j2) {
        super(i2, j2, Material.clay);
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Item.clay.shiftedIndex;
    }

    @Override
    public int quantityDropped(Random random) {
        return 4;
    }
}

