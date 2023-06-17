/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockSponge
extends Block {
    protected BlockSponge(int i2) {
        super(i2, Material.sponge);
        this.blockIndexInTexture = 48;
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
        int byte0 = 2;
        for (int l2 = i2 - byte0; l2 <= i2 + byte0; ++l2) {
            for (int i1 = j2 - byte0; i1 <= j2 + byte0; ++i1) {
                for (int j1 = k2 - byte0; j1 <= k2 + byte0; ++j1) {
                    if (world.getBlockMaterial(l2, i1, j1) == Material.water) continue;
                }
            }
        }
    }

    @Override
    public void onBlockRemoval(World world, int i2, int j2, int k2) {
        int byte0 = 2;
        for (int l2 = i2 - byte0; l2 <= i2 + byte0; ++l2) {
            for (int i1 = j2 - byte0; i1 <= j2 + byte0; ++i1) {
                for (int j1 = k2 - byte0; j1 <= k2 + byte0; ++j1) {
                    world.notifyBlocksOfNeighborChange(l2, i1, j1, world.getBlockId(l2, i1, j1));
                }
            }
        }
    }
}

