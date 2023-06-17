/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFluids;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockStationary
extends BlockFluids {
    protected BlockStationary(int i2, Material material) {
        super(i2, material);
        this.setTickOnLoad(false);
        if (material == Material.lava) {
            this.setTickOnLoad(true);
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        super.onNeighborBlockChange(world, i2, j2, k2, l2);
        if (world.getBlockId(i2, j2, k2) == this.blockID) {
            this.func_15234_j(world, i2, j2, k2);
        }
    }

    private void func_15234_j(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockMetadata(i2, j2, k2);
        world.field_1043_h = true;
        world.setBlockAndMetadata(i2, j2, k2, this.blockID - 1, l2);
        world.func_701_b(i2, j2, k2, i2, j2, k2);
        world.scheduleBlockUpdate(i2, j2, k2, this.blockID - 1);
        world.field_1043_h = false;
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        if (this.blockMaterial == Material.lava) {
            int l2 = random.nextInt(3);
            for (int i1 = 0; i1 < l2; ++i1) {
                int j1 = world.getBlockId(i2 += random.nextInt(3) - 1, ++j2, k2 += random.nextInt(3) - 1);
                if (j1 == 0) {
                    if (!this.func_301_k(world, i2 - 1, j2, k2) && !this.func_301_k(world, i2 + 1, j2, k2) && !this.func_301_k(world, i2, j2, k2 - 1) && !this.func_301_k(world, i2, j2, k2 + 1) && !this.func_301_k(world, i2, j2 - 1, k2) && !this.func_301_k(world, i2, j2 + 1, k2)) continue;
                    world.setBlockWithNotify(i2, j2, k2, Block.fire.blockID);
                    return;
                }
                if (!Block.blocksList[j1].blockMaterial.func_880_c()) continue;
                return;
            }
        }
    }

    private boolean func_301_k(World world, int i2, int j2, int k2) {
        return world.getBlockMaterial(i2, j2, k2).getBurning();
    }
}

