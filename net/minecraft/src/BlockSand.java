/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.EntityFallingSand;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockSand
extends Block {
    public static boolean fallInstantly = false;

    public BlockSand(int i2, int j2) {
        super(i2, j2, Material.sand);
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
        world.scheduleBlockUpdate(i2, j2, k2, this.blockID);
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        world.scheduleBlockUpdate(i2, j2, k2, this.blockID);
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        this.tryToFall(world, i2, j2, k2);
    }

    private void tryToFall(World world, int i2, int j2, int k2) {
        int l2 = i2;
        int i1 = j2;
        int j1 = k2;
        if (BlockSand.canFallBelow(world, l2, i1 - 1, j1) && i1 >= 0) {
            EntityFallingSand entityfallingsand = new EntityFallingSand(world, (float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f, this.blockID);
            if (fallInstantly) {
                while (!entityfallingsand.isDead) {
                    entityfallingsand.onUpdate();
                }
            } else {
                world.entityJoinedWorld(entityfallingsand);
            }
        }
    }

    @Override
    public int tickRate() {
        return 3;
    }

    public static boolean canFallBelow(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockId(i2, j2, k2);
        if (l2 == 0) {
            return true;
        }
        if (l2 == Block.fire.blockID) {
            return true;
        }
        Material material = Block.blocksList[l2].blockMaterial;
        if (material == Material.water) {
            return true;
        }
        return material == Material.lava;
    }
}

