/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenDungeons
extends WorldGenerator {
    @Override
    public boolean generate(World world, Random random, int i2, int j2, int k2) {
        int byte0 = 3;
        int l2 = random.nextInt(2) + 2;
        int i1 = random.nextInt(2) + 2;
        int j1 = 0;
        for (int k1 = i2 - l2 - 1; k1 <= i2 + l2 + 1; ++k1) {
            for (int j22 = j2 - 1; j22 <= j2 + byte0 + 1; ++j22) {
                for (int i3 = k2 - i1 - 1; i3 <= k2 + i1 + 1; ++i3) {
                    Material material = world.getBlockMaterial(k1, j22, i3);
                    if (j22 == j2 - 1 && !material.func_878_a()) {
                        return false;
                    }
                    if (j22 == j2 + byte0 + 1 && !material.func_878_a()) {
                        return false;
                    }
                    if (k1 != i2 - l2 - 1 && k1 != i2 + l2 + 1 && i3 != k2 - i1 - 1 && i3 != k2 + i1 + 1 || j22 != j2 || world.getBlockId(k1, j22, i3) != 0 || world.getBlockId(k1, j22 + 1, i3) != 0) continue;
                    ++j1;
                }
            }
        }
        if (j1 < 1 || j1 > 5) {
            return false;
        }
        for (int l1 = i2 - l2 - 1; l1 <= i2 + l2 + 1; ++l1) {
            for (int k22 = j2 + byte0; k22 >= j2 - 1; --k22) {
                for (int j3 = k2 - i1 - 1; j3 <= k2 + i1 + 1; ++j3) {
                    if (l1 == i2 - l2 - 1 || k22 == j2 - 1 || j3 == k2 - i1 - 1 || l1 == i2 + l2 + 1 || k22 == j2 + byte0 + 1 || j3 == k2 + i1 + 1) {
                        if (k22 >= 0 && !world.getBlockMaterial(l1, k22 - 1, j3).func_878_a()) {
                            world.setBlockWithNotify(l1, k22, j3, 0);
                            continue;
                        }
                        if (!world.getBlockMaterial(l1, k22, j3).func_878_a()) continue;
                        if (k22 == j2 - 1 && random.nextInt(4) != 0) {
                            world.setBlockWithNotify(l1, k22, j3, Block.cobblestoneMossy.blockID);
                            continue;
                        }
                        world.setBlockWithNotify(l1, k22, j3, Block.cobblestone.blockID);
                        continue;
                    }
                    world.setBlockWithNotify(l1, k22, j3, 0);
                }
            }
        }
        block6: for (int i22 = 0; i22 < 2; ++i22) {
            for (int l22 = 0; l22 < 3; ++l22) {
                int i4;
                int l3;
                int k3 = i2 + random.nextInt(l2 * 2 + 1) - l2;
                if (world.getBlockId(k3, l3 = j2, i4 = k2 + random.nextInt(i1 * 2 + 1) - i1) != 0) continue;
                int j4 = 0;
                if (world.getBlockMaterial(k3 - 1, l3, i4).func_878_a()) {
                    ++j4;
                }
                if (world.getBlockMaterial(k3 + 1, l3, i4).func_878_a()) {
                    ++j4;
                }
                if (world.getBlockMaterial(k3, l3, i4 - 1).func_878_a()) {
                    ++j4;
                }
                if (world.getBlockMaterial(k3, l3, i4 + 1).func_878_a()) {
                    ++j4;
                }
                if (j4 != 1) continue;
                world.setBlockWithNotify(k3, l3, i4, Block.crate.blockID);
                TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(k3, l3, i4);
                for (int k4 = 0; k4 < 8; ++k4) {
                    ItemStack itemstack = this.pickCheckLootItem(random);
                    if (itemstack == null) continue;
                    tileentitychest.setInventorySlotContents(random.nextInt(tileentitychest.getSizeInventory()), itemstack);
                }
                continue block6;
            }
        }
        world.setBlockWithNotify(i2, j2, k2, Block.mobSpawner.blockID);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getBlockTileEntity(i2, j2, k2);
        tileentitymobspawner.entityID = this.pickMobSpawner(random);
        return true;
    }

    private ItemStack pickCheckLootItem(Random random) {
        int i2 = random.nextInt(11);
        if (i2 == 0) {
            return new ItemStack(Item.saddle);
        }
        if (i2 == 1) {
            return new ItemStack(Item.ingotIron, random.nextInt(4) + 1);
        }
        if (i2 == 2) {
            return new ItemStack(Item.bread);
        }
        if (i2 == 3) {
            return new ItemStack(Item.wheat, random.nextInt(4) + 1);
        }
        if (i2 == 4) {
            return new ItemStack(Item.gunpowder, random.nextInt(4) + 1);
        }
        if (i2 == 5) {
            return new ItemStack(Item.silk, random.nextInt(4) + 1);
        }
        if (i2 == 6) {
            return new ItemStack(Item.bucketEmpty);
        }
        if (i2 == 7 && random.nextInt(100) == 0) {
            return new ItemStack(Item.appleGold);
        }
        if (i2 == 8 && random.nextInt(2) == 0) {
            return new ItemStack(Item.redstone, random.nextInt(4) + 1);
        }
        if (i2 == 9 && random.nextInt(10) == 0) {
            return new ItemStack(Item.itemsList[Item.record13.shiftedIndex + random.nextInt(2)]);
        }
        return null;
    }

    private String pickMobSpawner(Random random) {
        int i2 = random.nextInt(4);
        if (i2 == 0) {
            return "Skeleton";
        }
        if (i2 == 1) {
            return "Zombie";
        }
        if (i2 == 2) {
            return "Zombie";
        }
        if (i2 == 3) {
            return "Spider";
        }
        return "";
    }
}

