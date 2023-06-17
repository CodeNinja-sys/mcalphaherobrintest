/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockBookshelf
extends Block {
    public BlockBookshelf(int i2, int j2) {
        super(i2, j2, Material.wood);
    }

    @Override
    public int getBlockTextureFromSide(int i2) {
        if (i2 <= 1) {
            return 4;
        }
        return this.blockIndexInTexture;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }
}

