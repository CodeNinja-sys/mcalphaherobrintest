/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenClay
extends WorldGenerator {
    private int clayBlockId;
    private int numberOfBlocks;

    public WorldGenClay(int i2) {
        this.clayBlockId = Block.blockClay.blockID;
        this.numberOfBlocks = i2;
    }

    @Override
    public boolean generate(World world, Random random, int i2, int j2, int k2) {
        if (world.getBlockMaterial(i2, j2, k2) != Material.water) {
            return false;
        }
        float f2 = random.nextFloat() * 3.141593f;
        double d2 = (float)(i2 + 8) + MathHelper.sin(f2) * (float)this.numberOfBlocks / 8.0f;
        double d1 = (float)(i2 + 8) - MathHelper.sin(f2) * (float)this.numberOfBlocks / 8.0f;
        double d22 = (float)(k2 + 8) + MathHelper.cos(f2) * (float)this.numberOfBlocks / 8.0f;
        double d3 = (float)(k2 + 8) - MathHelper.cos(f2) * (float)this.numberOfBlocks / 8.0f;
        double d4 = j2 + random.nextInt(3) + 2;
        double d5 = j2 + random.nextInt(3) + 2;
        for (int l2 = 0; l2 <= this.numberOfBlocks; ++l2) {
            double d6 = d2 + (d1 - d2) * (double)l2 / (double)this.numberOfBlocks;
            double d7 = d4 + (d5 - d4) * (double)l2 / (double)this.numberOfBlocks;
            double d8 = d22 + (d3 - d22) * (double)l2 / (double)this.numberOfBlocks;
            double d9 = random.nextDouble() * (double)this.numberOfBlocks / 16.0;
            double d10 = (double)(MathHelper.sin((float)l2 * 3.141593f / (float)this.numberOfBlocks) + 1.0f) * d9 + 1.0;
            double d11 = (double)(MathHelper.sin((float)l2 * 3.141593f / (float)this.numberOfBlocks) + 1.0f) * d9 + 1.0;
            for (int i1 = (int)(d6 - d10 / 2.0); i1 <= (int)(d6 + d10 / 2.0); ++i1) {
                for (int j1 = (int)(d7 - d11 / 2.0); j1 <= (int)(d7 + d11 / 2.0); ++j1) {
                    for (int k1 = (int)(d8 - d10 / 2.0); k1 <= (int)(d8 + d10 / 2.0); ++k1) {
                        int l1;
                        double d12 = ((double)i1 + 0.5 - d6) / (d10 / 2.0);
                        double d13 = ((double)j1 + 0.5 - d7) / (d11 / 2.0);
                        double d14 = ((double)k1 + 0.5 - d8) / (d10 / 2.0);
                        if (d12 * d12 + d13 * d13 + d14 * d14 >= 1.0 || (l1 = world.getBlockId(i1, j1, k1)) != Block.sand.blockID) continue;
                        world.setBlock(i1, j1, k1, this.clayBlockId);
                    }
                }
            }
        }
        return true;
    }
}

