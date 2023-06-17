/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BlockBreakable;
import net.minecraft.src.Material;

public class BlockGlass
extends BlockBreakable {
    public BlockGlass(int i2, int j2, Material material, boolean flag) {
        super(i2, j2, material, flag);
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }
}

