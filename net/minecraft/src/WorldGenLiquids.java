/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenLiquids
extends WorldGenerator {
    private int liquidBlockId;

    public WorldGenLiquids(int i2) {
        this.liquidBlockId = i2;
    }

    @Override
    public boolean generate(World world, Random random, int i2, int j2, int k2) {
        if (world.getBlockId(i2, j2 + 1, k2) != Block.stone.blockID) {
            return false;
        }
        if (world.getBlockId(i2, j2 - 1, k2) != Block.stone.blockID) {
            return false;
        }
        if (world.getBlockId(i2, j2, k2) != 0 && world.getBlockId(i2, j2, k2) != Block.stone.blockID) {
            return false;
        }
        int l2 = 0;
        if (world.getBlockId(i2 - 1, j2, k2) == Block.stone.blockID) {
            ++l2;
        }
        if (world.getBlockId(i2 + 1, j2, k2) == Block.stone.blockID) {
            ++l2;
        }
        if (world.getBlockId(i2, j2, k2 - 1) == Block.stone.blockID) {
            ++l2;
        }
        if (world.getBlockId(i2, j2, k2 + 1) == Block.stone.blockID) {
            ++l2;
        }
        int i1 = 0;
        if (world.getBlockId(i2 - 1, j2, k2) == 0) {
            ++i1;
        }
        if (world.getBlockId(i2 + 1, j2, k2) == 0) {
            ++i1;
        }
        if (world.getBlockId(i2, j2, k2 - 1) == 0) {
            ++i1;
        }
        if (world.getBlockId(i2, j2, k2 + 1) == 0) {
            ++i1;
        }
        if (l2 == 3 && i1 == 1) {
            world.setBlockWithNotify(i2, j2, k2, this.liquidBlockId);
            world.field_4214_a = true;
            Block.blocksList[this.liquidBlockId].updateTick(world, i2, j2, k2, random);
            world.field_4214_a = false;
        }
        return true;
    }
}

