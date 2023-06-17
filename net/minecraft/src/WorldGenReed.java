/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenReed
extends WorldGenerator {
    @Override
    public boolean generate(World world, Random random, int i2, int j2, int k2) {
        for (int l2 = 0; l2 < 20; ++l2) {
            int k1;
            int j1;
            int i1 = i2 + random.nextInt(4) - random.nextInt(4);
            if (world.getBlockId(i1, j1 = j2, k1 = k2 + random.nextInt(4) - random.nextInt(4)) != 0 || world.getBlockMaterial(i1 - 1, j1 - 1, k1) != Material.water && world.getBlockMaterial(i1 + 1, j1 - 1, k1) != Material.water && world.getBlockMaterial(i1, j1 - 1, k1 - 1) != Material.water && world.getBlockMaterial(i1, j1 - 1, k1 + 1) != Material.water) continue;
            int l1 = 2 + random.nextInt(random.nextInt(3) + 1);
            for (int i22 = 0; i22 < l1; ++i22) {
                if (!Block.reed.canBlockStay(world, i1, j1 + i22, k1)) continue;
                world.setBlock(i1, j1 + i22, k1, Block.reed.blockID);
            }
        }
        return true;
    }
}

