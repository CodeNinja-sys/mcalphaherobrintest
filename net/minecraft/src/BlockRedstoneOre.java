/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockRedstoneOre
extends Block {
    private boolean field_468_a;

    public BlockRedstoneOre(int i2, int j2, boolean flag) {
        super(i2, j2, Material.rock);
        if (flag) {
            this.setTickOnLoad(true);
        }
        this.field_468_a = flag;
    }

    @Override
    public int tickRate() {
        return 30;
    }

    @Override
    public void onBlockClicked(World world, int i2, int j2, int k2, EntityPlayer entityplayer) {
        this.func_320_h(world, i2, j2, k2);
        super.onBlockClicked(world, i2, j2, k2, entityplayer);
    }

    @Override
    public void onEntityWalking(World world, int i2, int j2, int k2, Entity entity) {
        this.func_320_h(world, i2, j2, k2);
        super.onEntityWalking(world, i2, j2, k2, entity);
    }

    @Override
    public boolean blockActivated(World world, int i2, int j2, int k2, EntityPlayer entityplayer) {
        this.func_320_h(world, i2, j2, k2);
        return super.blockActivated(world, i2, j2, k2, entityplayer);
    }

    private void func_320_h(World world, int i2, int j2, int k2) {
        this.func_319_i(world, i2, j2, k2);
        if (this.blockID == Block.oreRedstone.blockID) {
            world.setBlockWithNotify(i2, j2, k2, Block.oreRedstoneGlowing.blockID);
        }
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        if (this.blockID == Block.oreRedstoneGlowing.blockID) {
            world.setBlockWithNotify(i2, j2, k2, Block.oreRedstone.blockID);
        }
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Item.redstone.shiftedIndex;
    }

    @Override
    public int quantityDropped(Random random) {
        return 4 + random.nextInt(2);
    }

    @Override
    public void randomDisplayTick(World world, int i2, int j2, int k2, Random random) {
        if (this.field_468_a) {
            this.func_319_i(world, i2, j2, k2);
        }
    }

    private void func_319_i(World world, int i2, int j2, int k2) {
        Random random = world.rand;
        double d2 = 0.0625;
        for (int l2 = 0; l2 < 6; ++l2) {
            double d1 = (float)i2 + random.nextFloat();
            double d22 = (float)j2 + random.nextFloat();
            double d3 = (float)k2 + random.nextFloat();
            if (l2 == 0 && !world.isBlockOpaqueCube(i2, j2 + 1, k2)) {
                d22 = (double)(j2 + 1) + d2;
            }
            if (l2 == 1 && !world.isBlockOpaqueCube(i2, j2 - 1, k2)) {
                d22 = (double)(j2 + 0) - d2;
            }
            if (l2 == 2 && !world.isBlockOpaqueCube(i2, j2, k2 + 1)) {
                d3 = (double)(k2 + 1) + d2;
            }
            if (l2 == 3 && !world.isBlockOpaqueCube(i2, j2, k2 - 1)) {
                d3 = (double)(k2 + 0) - d2;
            }
            if (l2 == 4 && !world.isBlockOpaqueCube(i2 + 1, j2, k2)) {
                d1 = (double)(i2 + 1) + d2;
            }
            if (l2 == 5 && !world.isBlockOpaqueCube(i2 - 1, j2, k2)) {
                d1 = (double)(i2 + 0) - d2;
            }
            if (!(d1 < (double)i2 || d1 > (double)(i2 + 1) || d22 < 0.0 || d22 > (double)(j2 + 1) || d3 < (double)k2) && !(d3 > (double)(k2 + 1))) continue;
            world.spawnParticle("reddust", d1, d22, d3, 0.0, 0.0, 0.0);
        }
    }
}

