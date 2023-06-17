/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenFire
extends WorldGenerator {
    @Override
    public boolean generate(World world, Random random, int i2, int j2, int k2) {
        for (int l2 = 0; l2 < 64; ++l2) {
            int k1;
            int j1;
            int i1 = i2 + random.nextInt(8) - random.nextInt(8);
            if (world.getBlockId(i1, j1 = j2 + random.nextInt(4) - random.nextInt(4), k1 = k2 + random.nextInt(8) - random.nextInt(8)) != 0 || world.getBlockId(i1, j1 - 1, k1) != Block.bloodStone.blockID) continue;
            world.setBlockWithNotify(i1, j1, k1, Block.fire.blockID);
        }
        return true;
    }
}

