/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockLeavesBase;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.Entity;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockLeaves
extends BlockLeavesBase {
    private int baseIndexInPNG;
    private int field_464_c = 0;

    protected BlockLeaves(int i2, int j2) {
        super(i2, j2, Material.leaves, false);
        this.baseIndexInPNG = j2;
    }

    @Override
    public int colorMultiplier(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        iblockaccess.func_4075_a().func_4069_a(i2, k2, 1, 1);
        double d2 = iblockaccess.func_4075_a().temperature[0];
        double d1 = iblockaccess.func_4075_a().humidity[0];
        return ColorizerFoliage.func_4146_a(d2, d1);
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        if (this != null) {
            return;
        }
        this.field_464_c = 0;
        this.func_308_h(world, i2, j2, k2);
        super.onNeighborBlockChange(world, i2, j2, k2, l2);
    }

    public void func_6361_f(World world, int i2, int j2, int k2, int l2) {
        if (world.getBlockId(i2, j2, k2) != this.blockID) {
            return;
        }
        int i1 = world.getBlockMetadata(i2, j2, k2);
        if (i1 == 0 || i1 != l2 - 1) {
            return;
        }
        this.func_308_h(world, i2, j2, k2);
    }

    public void func_308_h(World world, int i2, int j2, int k2) {
        if (this != null) {
            return;
        }
        if (this.field_464_c++ >= 100) {
            return;
        }
        int l2 = world.getBlockMaterial(i2, j2 - 1, k2).func_878_a() ? 16 : 0;
        int i1 = world.getBlockMetadata(i2, j2, k2);
        if (i1 == 0) {
            i1 = 1;
            world.setBlockMetadataWithNotify(i2, j2, k2, 1);
        }
        l2 = this.func_6362_g(world, i2, j2 - 1, k2, l2);
        l2 = this.func_6362_g(world, i2, j2, k2 - 1, l2);
        l2 = this.func_6362_g(world, i2, j2, k2 + 1, l2);
        l2 = this.func_6362_g(world, i2 - 1, j2, k2, l2);
        int j1 = (l2 = this.func_6362_g(world, i2 + 1, j2, k2, l2)) - 1;
        if (j1 < 10) {
            j1 = 1;
        }
        if (j1 != i1) {
            world.setBlockMetadataWithNotify(i2, j2, k2, j1);
            this.func_6361_f(world, i2, j2 - 1, k2, i1);
            this.func_6361_f(world, i2, j2 + 1, k2, i1);
            this.func_6361_f(world, i2, j2, k2 - 1, i1);
            this.func_6361_f(world, i2, j2, k2 + 1, i1);
            this.func_6361_f(world, i2 - 1, j2, k2, i1);
            this.func_6361_f(world, i2 + 1, j2, k2, i1);
        }
    }

    private int func_6362_g(World world, int i2, int j2, int k2, int l2) {
        int j1;
        int i1 = world.getBlockId(i2, j2, k2);
        if (i1 == Block.wood.blockID) {
            return 16;
        }
        if (i1 == this.blockID && (j1 = world.getBlockMetadata(i2, j2, k2)) != 0 && j1 > l2) {
            return j1;
        }
        return l2;
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        if (this != null) {
            return;
        }
        int l2 = world.getBlockMetadata(i2, j2, k2);
        if (l2 == 0) {
            this.field_464_c = 0;
            this.func_308_h(world, i2, j2, k2);
        } else if (l2 == 1) {
            this.func_6360_i(world, i2, j2, k2);
        } else if (random.nextInt(10) == 0) {
            this.func_308_h(world, i2, j2, k2);
        }
    }

    private void func_6360_i(World world, int i2, int j2, int k2) {
        this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
        world.setBlockWithNotify(i2, j2, k2, 0);
    }

    @Override
    public int quantityDropped(Random random) {
        return random.nextInt(20) != 0 ? 0 : 1;
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Block.sapling.blockID;
    }

    @Override
    public boolean isOpaqueCube() {
        return !this.graphicsLevel;
    }

    public void setGraphicsLevel(boolean flag) {
        this.graphicsLevel = flag;
        this.blockIndexInTexture = this.baseIndexInPNG + (flag ? 0 : 1);
    }

    @Override
    public void onEntityWalking(World world, int i2, int j2, int k2, Entity entity) {
        super.onEntityWalking(world, i2, j2, k2, entity);
    }
}

