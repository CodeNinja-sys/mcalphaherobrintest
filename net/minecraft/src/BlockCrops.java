/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.EntityItem;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class BlockCrops
extends BlockFlower {
    protected BlockCrops(int i2, int j2) {
        super(i2, j2);
        this.blockIndexInTexture = j2;
        this.setTickOnLoad(true);
        float f2 = 0.5f;
        this.setBlockBounds(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, 0.25f, 0.5f + f2);
    }

    @Override
    protected boolean canThisPlantGrowOnThisBlockID(int i2) {
        return i2 == Block.tilledField.blockID;
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        float f2;
        int l2;
        super.updateTick(world, i2, j2, k2, random);
        if (world.getBlockLightValue(i2, j2 + 1, k2) >= 9 && (l2 = world.getBlockMetadata(i2, j2, k2)) < 7 && random.nextInt((int)(100.0f / (f2 = this.getGrowthRate(world, i2, j2, k2)))) == 0) {
            world.setBlockMetadataWithNotify(i2, j2, k2, ++l2);
        }
    }

    private float getGrowthRate(World world, int i2, int j2, int k2) {
        float f2 = 1.0f;
        int l2 = world.getBlockId(i2, j2, k2 - 1);
        int i1 = world.getBlockId(i2, j2, k2 + 1);
        int j1 = world.getBlockId(i2 - 1, j2, k2);
        int k1 = world.getBlockId(i2 + 1, j2, k2);
        int l1 = world.getBlockId(i2 - 1, j2, k2 - 1);
        int i22 = world.getBlockId(i2 + 1, j2, k2 - 1);
        int j22 = world.getBlockId(i2 + 1, j2, k2 + 1);
        int k22 = world.getBlockId(i2 - 1, j2, k2 + 1);
        boolean flag = j1 == this.blockID || k1 == this.blockID;
        boolean flag1 = l2 == this.blockID || i1 == this.blockID;
        boolean flag2 = l1 == this.blockID || i22 == this.blockID || j22 == this.blockID || k22 == this.blockID;
        for (int l22 = i2 - 1; l22 <= i2 + 1; ++l22) {
            for (int i3 = k2 - 1; i3 <= k2 + 1; ++i3) {
                int j3 = world.getBlockId(l22, j2 - 1, i3);
                float f1 = 0.0f;
                if (j3 == Block.tilledField.blockID) {
                    f1 = 1.0f;
                    if (world.getBlockMetadata(l22, j2 - 1, i3) > 0) {
                        f1 = 3.0f;
                    }
                }
                if (l22 != i2 || i3 != k2) {
                    f1 /= 4.0f;
                }
                f2 += f1;
            }
        }
        if (flag2 || flag && flag1) {
            f2 /= 2.0f;
        }
        return f2;
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int i2, int j2) {
        if (j2 < 0) {
            j2 = 7;
        }
        return this.blockIndexInTexture + j2;
    }

    @Override
    public int getRenderType() {
        return 6;
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int i2, int j2, int k2, int l2) {
        super.onBlockDestroyedByPlayer(world, i2, j2, k2, l2);
        if (!world.multiplayerWorld) {
            for (int i1 = 0; i1 < 3; ++i1) {
                if (world.rand.nextInt(15) > l2) continue;
                float f2 = 0.7f;
                float f1 = world.rand.nextFloat() * f2 + (1.0f - f2) * 0.5f;
                float f22 = world.rand.nextFloat() * f2 + (1.0f - f2) * 0.5f;
                float f3 = world.rand.nextFloat() * f2 + (1.0f - f2) * 0.5f;
                EntityItem entityitem = new EntityItem(world, (float)i2 + f1, (float)j2 + f22, (float)k2 + f3, new ItemStack(Item.seeds));
                entityitem.field_805_c = 10;
                world.entityJoinedWorld(entityitem);
            }
        }
    }

    @Override
    public int idDropped(int i2, Random random) {
        if (i2 == 7) {
            return Item.wheat.shiftedIndex;
        }
        return -1;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }
}

