/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenBigTree;
import net.minecraft.src.WorldGenTrees;
import net.minecraft.src.WorldGenerator;

public class BlockSapling
extends BlockFlower {
    protected BlockSapling(int i2, int j2) {
        super(i2, j2);
        float f2 = 0.4f;
        this.setBlockBounds(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, f2 * 2.0f, 0.5f + f2);
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        super.updateTick(world, i2, j2, k2, random);
        if (world.getBlockLightValue(i2, j2 + 1, k2) >= 9 && random.nextInt(5) == 0) {
            int l2 = world.getBlockMetadata(i2, j2, k2);
            if (l2 < 15) {
                world.setBlockMetadataWithNotify(i2, j2, k2, l2 + 1);
            } else {
                world.setBlock(i2, j2, k2, 0);
                WorldGenerator obj = new WorldGenTrees();
                if (random.nextInt(10) == 0) {
                    obj = new WorldGenBigTree();
                }
                if (!((WorldGenerator)obj).generate(world, random, i2, j2, k2)) {
                    world.setBlock(i2, j2, k2, this.blockID);
                }
            }
        }
    }
}

