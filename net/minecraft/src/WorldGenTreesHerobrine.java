/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenTreesHerobrine
extends WorldGenerator {
    @Override
    public boolean generate(World world, Random random, int i2, int j2, int k2) {
        int l2 = random.nextInt(3) + 4;
        boolean flag = true;
        if (j2 < 1 || j2 + l2 + 1 > 128) {
            return false;
        }
        for (int i1 = j2; i1 <= j2 + 1 + l2; ++i1) {
            int byte0 = 1;
            if (i1 == j2) {
                byte0 = 0;
            }
            if (i1 >= j2 + 1 + l2 - 2) {
                byte0 = 2;
            }
            for (int i22 = i2 - byte0; i22 <= i2 + byte0 && flag; ++i22) {
                for (int l22 = k2 - byte0; l22 <= k2 + byte0 && flag; ++l22) {
                    if (i1 >= 0 && i1 < 128) {
                        int n2 = world.getBlockId(i22, i1, l22);
                        continue;
                    }
                    flag = false;
                }
            }
        }
        if (!flag) {
            return false;
        }
        int j1 = world.getBlockId(i2, j2 - 1, k2);
        if (j1 != Block.grass.blockID && j1 != Block.dirt.blockID || j2 >= 128 - l2 - 1) {
            return false;
        }
        world.setBlock(i2, j2 - 1, k2, Block.dirt.blockID);
        for (int k1 = j2 - 3 + l2; k1 <= j2 + l2; ++k1) {
            int j22 = k1 - (j2 + l2);
            int i3 = 1 - j22 / 2;
            for (int k3 = i2 - i3; k3 <= i2 + i3; ++k3) {
                int l3 = k3 - i2;
                for (int i4 = k2 - i3; i4 <= k2 + i3; ++i4) {
                    int j4 = i4 - k2;
                    if (Math.abs(l3) == i3 && Math.abs(j4) == i3 && (random.nextInt(2) == 0 || j22 == 0)) continue;
                    boolean cfr_ignored_0 = Block.opaqueCubeLookup[world.getBlockId(k3, k1, i4)];
                }
            }
        }
        for (int l1 = 0; l1 < l2; ++l1) {
            int k22 = world.getBlockId(i2, j2 + l1, k2);
            if (k22 != 0 && k22 != Block.leaves.blockID) continue;
            world.setBlock(i2, j2 + l1, k2, Block.wood.blockID);
        }
        return true;
    }
}

