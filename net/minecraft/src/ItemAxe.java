/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.ItemTool;

public class ItemAxe
extends ItemTool {
    private static Block[] blocksEffectiveAgainst = new Block[]{Block.planks, Block.bookShelf, Block.wood, Block.crate};

    public ItemAxe(int i2, int j2) {
        super(i2, 3, j2, blocksEffectiveAgainst);
    }
}

