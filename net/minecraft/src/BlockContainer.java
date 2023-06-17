/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public abstract class BlockContainer
extends Block {
    protected BlockContainer(int i2, Material material) {
        super(i2, material);
        BlockContainer.isBlockContainer[i2] = true;
    }

    protected BlockContainer(int i2, int j2, Material material) {
        super(i2, j2, material);
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
        super.onBlockAdded(world, i2, j2, k2);
        world.setBlockTileEntity(i2, j2, k2, this.SetBlockEntity());
    }

    @Override
    public void onBlockRemoval(World world, int i2, int j2, int k2) {
        super.onBlockRemoval(world, i2, j2, k2);
        world.removeBlockTileEntity(i2, j2, k2);
    }

    protected abstract TileEntity SetBlockEntity();
}

