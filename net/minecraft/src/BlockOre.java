/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.Material;

public class BlockOre
extends Block {
    public BlockOre(int i2, int j2) {
        super(i2, j2, Material.rock);
    }

    @Override
    public int idDropped(int i2, Random random) {
        if (this.blockID == Block.oreCoal.blockID) {
            return Item.coal.shiftedIndex;
        }
        if (this.blockID == Block.oreDiamond.blockID) {
            return Item.diamond.shiftedIndex;
        }
        return this.blockID;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }
}

