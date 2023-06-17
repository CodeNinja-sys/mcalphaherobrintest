/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityMobSpawner;

public class BlockMobSpawner
extends BlockContainer {
    protected BlockMobSpawner(int i2, int j2) {
        super(i2, j2, Material.rock);
    }

    @Override
    protected TileEntity SetBlockEntity() {
        return new TileEntityMobSpawner();
    }

    @Override
    public int idDropped(int i2, Random random) {
        return 0;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}

