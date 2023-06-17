/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFluids;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockFlowing
extends BlockFluids {
    int field_460_a = 0;
    boolean[] field_459_b = new boolean[4];
    int[] field_461_c = new int[4];

    protected BlockFlowing(int i2, Material material) {
        super(i2, material);
    }

    private void func_15233_j(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockMetadata(i2, j2, k2);
        world.setBlockAndMetadata(i2, j2, k2, this.blockID + 1, l2);
        world.func_701_b(i2, j2, k2, i2, j2, k2);
        world.func_665_h(i2, j2, k2);
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        int l2 = this.func_290_h(world, i2, j2, k2);
        int byte0 = 1;
        if (this.blockMaterial == Material.lava && !world.worldProvider.field_6479_d) {
            byte0 = 2;
        }
        boolean flag = true;
        if (l2 > 0) {
            int i1 = -100;
            this.field_460_a = 0;
            i1 = this.func_296_f(world, i2 - 1, j2, k2, i1);
            i1 = this.func_296_f(world, i2 + 1, j2, k2, i1);
            i1 = this.func_296_f(world, i2, j2, k2 - 1, i1);
            int j1 = (i1 = this.func_296_f(world, i2, j2, k2 + 1, i1)) + byte0;
            if (j1 >= 8 || i1 < 0) {
                j1 = -1;
            }
            if (this.func_290_h(world, i2, j2 + 1, k2) >= 0) {
                int l1 = this.func_290_h(world, i2, j2 + 1, k2);
                j1 = l1 >= 8 ? l1 : l1 + 8;
            }
            if (this.field_460_a >= 2 && this.blockMaterial == Material.water) {
                if (world.isBlockOpaqueCube(i2, j2 - 1, k2)) {
                    j1 = 0;
                } else if (world.getBlockMaterial(i2, j2 - 1, k2) == this.blockMaterial && world.getBlockMetadata(i2, j2, k2) == 0) {
                    j1 = 0;
                }
            }
            if (this.blockMaterial == Material.lava && l2 < 8 && j1 < 8 && j1 > l2 && random.nextInt(4) != 0) {
                j1 = l2;
                flag = false;
            }
            if (j1 != l2) {
                l2 = j1;
                if (l2 < 0) {
                    world.setBlockWithNotify(i2, j2, k2, 0);
                } else {
                    world.setBlockMetadataWithNotify(i2, j2, k2, l2);
                    world.scheduleBlockUpdate(i2, j2, k2, this.blockID);
                    world.notifyBlocksOfNeighborChange(i2, j2, k2, this.blockID);
                }
            } else if (flag) {
                this.func_15233_j(world, i2, j2, k2);
            }
        } else {
            this.func_15233_j(world, i2, j2, k2);
        }
        if (this.func_298_m(world, i2, j2 - 1, k2)) {
            if (l2 >= 8) {
                world.setBlockAndMetadataWithNotify(i2, j2 - 1, k2, this.blockID, l2);
            } else {
                world.setBlockAndMetadataWithNotify(i2, j2 - 1, k2, this.blockID, l2 + 8);
            }
        } else if (l2 >= 0 && (l2 == 0 || this.func_295_l(world, i2, j2 - 1, k2))) {
            boolean[] aflag = this.func_297_k(world, i2, j2, k2);
            int k1 = l2 + byte0;
            if (l2 >= 8) {
                k1 = 1;
            }
            if (k1 >= 8) {
                return;
            }
            if (aflag[0]) {
                this.func_299_g(world, i2 - 1, j2, k2, k1);
            }
            if (aflag[1]) {
                this.func_299_g(world, i2 + 1, j2, k2, k1);
            }
            if (aflag[2]) {
                this.func_299_g(world, i2, j2, k2 - 1, k1);
            }
            if (aflag[3]) {
                this.func_299_g(world, i2, j2, k2 + 1, k1);
            }
        }
    }

    private void func_299_g(World world, int i2, int j2, int k2, int l2) {
        if (this.func_298_m(world, i2, j2, k2)) {
            int i1 = world.getBlockId(i2, j2, k2);
            if (i1 > 0) {
                if (this.blockMaterial == Material.lava) {
                    this.func_292_i(world, i2, j2, k2);
                } else {
                    Block.blocksList[i1].dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
                }
            }
            world.setBlockAndMetadataWithNotify(i2, j2, k2, this.blockID, l2);
        }
    }

    private int func_300_a(World world, int i2, int j2, int k2, int l2, int i1) {
        int j1 = 1000;
        for (int k1 = 0; k1 < 4; ++k1) {
            int k22;
            if (k1 == 0 && i1 == 1 || k1 == 1 && i1 == 0 || k1 == 2 && i1 == 3 || k1 == 3 && i1 == 2) continue;
            int l1 = i2;
            int i22 = j2;
            int j22 = k2;
            if (k1 == 0) {
                --l1;
            }
            if (k1 == 1) {
                ++l1;
            }
            if (k1 == 2) {
                --j22;
            }
            if (k1 == 3) {
                ++j22;
            }
            if (this.func_295_l(world, l1, i22, j22) || world.getBlockMaterial(l1, i22, j22) == this.blockMaterial && world.getBlockMetadata(l1, i22, j22) == 0) continue;
            if (!this.func_295_l(world, l1, i22 - 1, j22)) {
                return l2;
            }
            if (l2 >= 4 || (k22 = this.func_300_a(world, l1, i22, j22, l2 + 1, k1)) >= j1) continue;
            j1 = k22;
        }
        return j1;
    }

    private boolean[] func_297_k(World world, int i2, int j2, int k2) {
        for (int l2 = 0; l2 < 4; ++l2) {
            this.field_461_c[l2] = 1000;
            int j1 = i2;
            int i22 = j2;
            int j22 = k2;
            if (l2 == 0) {
                --j1;
            }
            if (l2 == 1) {
                ++j1;
            }
            if (l2 == 2) {
                --j22;
            }
            if (l2 == 3) {
                ++j22;
            }
            if (this.func_295_l(world, j1, i22, j22) || world.getBlockMaterial(j1, i22, j22) == this.blockMaterial && world.getBlockMetadata(j1, i22, j22) == 0) continue;
            this.field_461_c[l2] = !this.func_295_l(world, j1, i22 - 1, j22) ? 0 : this.func_300_a(world, j1, i22, j22, 1, l2);
        }
        int i1 = this.field_461_c[0];
        for (int k1 = 1; k1 < 4; ++k1) {
            if (this.field_461_c[k1] >= i1) continue;
            i1 = this.field_461_c[k1];
        }
        for (int l1 = 0; l1 < 4; ++l1) {
            this.field_459_b[l1] = this.field_461_c[l1] == i1;
        }
        return this.field_459_b;
    }

    private boolean func_295_l(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockId(i2, j2, k2);
        if (l2 == Block.doorWood.blockID || l2 == Block.doorSteel.blockID || l2 == Block.signPost.blockID || l2 == Block.ladder.blockID || l2 == Block.reed.blockID) {
            return true;
        }
        if (l2 == 0) {
            return false;
        }
        Material material = Block.blocksList[l2].blockMaterial;
        return material.func_878_a();
    }

    protected int func_296_f(World world, int i2, int j2, int k2, int l2) {
        int i1 = this.func_290_h(world, i2, j2, k2);
        if (i1 < 0) {
            return l2;
        }
        if (i1 == 0) {
            ++this.field_460_a;
        }
        if (i1 >= 8) {
            i1 = 0;
        }
        return l2 >= 0 && i1 >= l2 ? l2 : i1;
    }

    private boolean func_298_m(World world, int i2, int j2, int k2) {
        Material material = world.getBlockMaterial(i2, j2, k2);
        if (material == this.blockMaterial) {
            return false;
        }
        if (material == Material.lava) {
            return false;
        }
        return !this.func_295_l(world, i2, j2, k2);
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
        super.onBlockAdded(world, i2, j2, k2);
        if (world.getBlockId(i2, j2, k2) == this.blockID) {
            world.scheduleBlockUpdate(i2, j2, k2, this.blockID);
        }
    }
}

