/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockSnowBlock
extends Block {
    protected BlockSnowBlock(int i2, int j2) {
        super(i2, j2, Material.builtSnow);
        this.setTickOnLoad(true);
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Item.snowball.shiftedIndex;
    }

    @Override
    public int quantityDropped(Random random) {
        return 4;
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        if (world.getSavedLightValue(EnumSkyBlock.Block, i2, j2, k2) > 11) {
            this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
            world.setBlockWithNotify(i2, j2, k2, 0);
        }
    }
}

