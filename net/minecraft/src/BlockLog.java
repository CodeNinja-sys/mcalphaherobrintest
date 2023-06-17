/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockLog
extends Block {
    protected BlockLog(int i2) {
        super(i2, Material.wood);
        this.blockIndexInTexture = 20;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Block.wood.blockID;
    }

    @Override
    public int getBlockTextureFromSide(int i2) {
        if (i2 == 1) {
            return 21;
        }
        return i2 != 0 ? 20 : 21;
    }
}

