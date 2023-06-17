/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockOreBlock
extends Block {
    public BlockOreBlock(int i2, int j2) {
        super(i2, Material.iron);
        this.blockIndexInTexture = j2;
    }

    @Override
    public int getBlockTextureFromSide(int i2) {
        return this.blockIndexInTexture - 16;
    }
}

