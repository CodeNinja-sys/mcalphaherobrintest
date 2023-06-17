/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BlockSand;
import net.minecraft.src.Item;

public class BlockGravel
extends BlockSand {
    public BlockGravel(int i2, int j2) {
        super(i2, j2);
    }

    @Override
    public int idDropped(int i2, Random random) {
        if (random.nextInt(10) == 0) {
            return Item.flint.shiftedIndex;
        }
        return this.blockID;
    }
}

