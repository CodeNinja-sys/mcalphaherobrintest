/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenLightStone2
extends WorldGenerator {
    @Override
    public boolean generate(World world, Random random, int i2, int j2, int k2) {
        if (world.getBlockId(i2, j2, k2) != 0) {
            return false;
        }
        if (world.getBlockId(i2, j2 + 1, k2) != Block.bloodStone.blockID) {
            return false;
        }
        world.setBlockWithNotify(i2, j2, k2, Block.lightStone.blockID);
        for (int l2 = 0; l2 < 1500; ++l2) {
            int k1;
            int j1;
            int i1 = i2 + random.nextInt(8) - random.nextInt(8);
            if (world.getBlockId(i1, j1 = j2 - random.nextInt(12), k1 = k2 + random.nextInt(8) - random.nextInt(8)) != 0) continue;
            int l1 = 0;
            for (int i22 = 0; i22 < 6; ++i22) {
                int j22 = 0;
                if (i22 == 0) {
                    j22 = world.getBlockId(i1 - 1, j1, k1);
                }
                if (i22 == 1) {
                    j22 = world.getBlockId(i1 + 1, j1, k1);
                }
                if (i22 == 2) {
                    j22 = world.getBlockId(i1, j1 - 1, k1);
                }
                if (i22 == 3) {
                    j22 = world.getBlockId(i1, j1 + 1, k1);
                }
                if (i22 == 4) {
                    j22 = world.getBlockId(i1, j1, k1 - 1);
                }
                if (i22 == 5) {
                    j22 = world.getBlockId(i1, j1, k1 + 1);
                }
                if (j22 != Block.lightStone.blockID) continue;
                ++l1;
            }
            if (l1 != true) continue;
            world.setBlockWithNotify(i1, j1, k1, Block.lightStone.blockID);
        }
        return true;
    }
}

