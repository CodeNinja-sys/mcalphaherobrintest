/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.Material;

public class BlockLightStone
extends Block {
    public BlockLightStone(int i2, int j2, Material material) {
        super(i2, j2, material);
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Item.lightStoneDust.shiftedIndex;
    }
}

