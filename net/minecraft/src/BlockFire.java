/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockFire
extends Block {
    private int[] chanceToEncourageFire = new int[256];
    private int[] abilityToCatchFire = new int[256];

    protected BlockFire(int i2, int j2) {
        super(i2, j2, Material.fire);
        this.setBurnRate(Block.planks.blockID, 5, 20);
        this.setBurnRate(Block.wood.blockID, 5, 5);
        this.setBurnRate(Block.leaves.blockID, 30, 60);
        this.setBurnRate(Block.bookShelf.blockID, 30, 20);
        this.setBurnRate(Block.tnt.blockID, 15, 100);
        this.setBurnRate(Block.cloth.blockID, 30, 60);
        this.setTickOnLoad(true);
    }

    private void setBurnRate(int i2, int j2, int k2) {
        this.chanceToEncourageFire[i2] = j2;
        this.abilityToCatchFire[i2] = k2;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        return null;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 3;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public int tickRate() {
        return 10;
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        boolean flag = world.getBlockId(i2, j2 - 1, k2) == Block.bloodStone.blockID;
        int l2 = world.getBlockMetadata(i2, j2, k2);
        if (l2 < 15) {
            world.setBlockMetadataWithNotify(i2, j2, k2, l2 + 1);
            world.scheduleBlockUpdate(i2, j2, k2, this.blockID);
        }
        if (!flag && !this.func_263_h(world, i2, j2, k2)) {
            if (!world.isBlockOpaqueCube(i2, j2 - 1, k2) || l2 > 3) {
                world.setBlockWithNotify(i2, j2, k2, 0);
            }
            return;
        }
        if (!flag && !this.canBlockCatchFire(world, i2, j2 - 1, k2) && l2 == 15 && random.nextInt(4) == 0) {
            world.setBlockWithNotify(i2, j2, k2, 0);
            return;
        }
        if (l2 % 2 == 0 && l2 > 2) {
            this.tryToCatchBlockOnFire(world, i2 + 1, j2, k2, 300, random);
            this.tryToCatchBlockOnFire(world, i2 - 1, j2, k2, 300, random);
            this.tryToCatchBlockOnFire(world, i2, j2 - 1, k2, 250, random);
            this.tryToCatchBlockOnFire(world, i2, j2 + 1, k2, 250, random);
            this.tryToCatchBlockOnFire(world, i2, j2, k2 - 1, 300, random);
            this.tryToCatchBlockOnFire(world, i2, j2, k2 + 1, 300, random);
            for (int i1 = i2 - 1; i1 <= i2 + 1; ++i1) {
                for (int j1 = k2 - 1; j1 <= k2 + 1; ++j1) {
                    for (int k1 = j2 - 1; k1 <= j2 + 4; ++k1) {
                        int i22;
                        if (i1 == i2 && k1 == j2 && j1 == k2) continue;
                        int l1 = 100;
                        if (k1 > j2 + 1) {
                            l1 += (k1 - (j2 + 1)) * 100;
                        }
                        if ((i22 = this.getChanceOfNeighborsEncouragingFire(world, i1, k1, j1)) <= 0 || random.nextInt(l1) > i22) continue;
                        world.setBlockWithNotify(i1, k1, j1, this.blockID);
                    }
                }
            }
        }
    }

    private void tryToCatchBlockOnFire(World world, int i2, int j2, int k2, int l2, Random random) {
        int i1 = this.abilityToCatchFire[world.getBlockId(i2, j2, k2)];
        if (random.nextInt(l2) < i1) {
            boolean flag;
            boolean bl2 = flag = world.getBlockId(i2, j2, k2) == Block.tnt.blockID;
            if (random.nextInt(2) == 0) {
                world.setBlockWithNotify(i2, j2, k2, this.blockID);
            } else {
                world.setBlockWithNotify(i2, j2, k2, 0);
            }
            if (flag) {
                Block.tnt.onBlockDestroyedByPlayer(world, i2, j2, k2, 0);
            }
        }
    }

    private boolean func_263_h(World world, int i2, int j2, int k2) {
        if (this.canBlockCatchFire(world, i2 + 1, j2, k2)) {
            return true;
        }
        if (this.canBlockCatchFire(world, i2 - 1, j2, k2)) {
            return true;
        }
        if (this.canBlockCatchFire(world, i2, j2 - 1, k2)) {
            return true;
        }
        if (this.canBlockCatchFire(world, i2, j2 + 1, k2)) {
            return true;
        }
        if (this.canBlockCatchFire(world, i2, j2, k2 - 1)) {
            return true;
        }
        return this.canBlockCatchFire(world, i2, j2, k2 + 1);
    }

    private int getChanceOfNeighborsEncouragingFire(World world, int i2, int j2, int k2) {
        int l2 = 0;
        if (world.getBlockId(i2, j2, k2) != 0) {
            return 0;
        }
        l2 = this.getChanceToEncourageFire(world, i2 + 1, j2, k2, l2);
        l2 = this.getChanceToEncourageFire(world, i2 - 1, j2, k2, l2);
        l2 = this.getChanceToEncourageFire(world, i2, j2 - 1, k2, l2);
        l2 = this.getChanceToEncourageFire(world, i2, j2 + 1, k2, l2);
        l2 = this.getChanceToEncourageFire(world, i2, j2, k2 - 1, l2);
        l2 = this.getChanceToEncourageFire(world, i2, j2, k2 + 1, l2);
        return l2;
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    public boolean canBlockCatchFire(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        return this.chanceToEncourageFire[iblockaccess.getBlockId(i2, j2, k2)] > 0;
    }

    public int getChanceToEncourageFire(World world, int i2, int j2, int k2, int l2) {
        int i1 = this.chanceToEncourageFire[world.getBlockId(i2, j2, k2)];
        if (i1 > l2) {
            return i1;
        }
        return l2;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        return world.isBlockOpaqueCube(i2, j2 - 1, k2) || this.func_263_h(world, i2, j2, k2);
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        if (!world.isBlockOpaqueCube(i2, j2 - 1, k2) && !this.func_263_h(world, i2, j2, k2)) {
            world.setBlockWithNotify(i2, j2, k2, 0);
            return;
        }
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
        if (world.getBlockId(i2, j2 - 1, k2) == Block.obsidian.blockID && Block.portal.tryToCreatePortal(world, i2, j2, k2)) {
            return;
        }
        if (!world.isBlockOpaqueCube(i2, j2 - 1, k2) && !this.func_263_h(world, i2, j2, k2)) {
            world.setBlockWithNotify(i2, j2, k2, 0);
            return;
        }
        world.scheduleBlockUpdate(i2, j2, k2, this.blockID);
    }

    @Override
    public void randomDisplayTick(World world, int i2, int j2, int k2, Random random) {
        block12: {
            block11: {
                if (random.nextInt(24) == 0) {
                    world.playSoundEffect((float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f, "fire.fire", 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f);
                }
                if (!world.isBlockOpaqueCube(i2, j2 - 1, k2) && !Block.fire.canBlockCatchFire(world, i2, j2 - 1, k2)) break block11;
                for (int l2 = 0; l2 < 3; ++l2) {
                    float f2 = (float)i2 + random.nextFloat();
                    float f6 = (float)j2 + random.nextFloat() * 0.5f + 0.5f;
                    float f12 = (float)k2 + random.nextFloat();
                    world.spawnParticle("largesmoke", f2, f6, f12, 0.0, 0.0, 0.0);
                }
                break block12;
            }
            if (Block.fire.canBlockCatchFire(world, i2 - 1, j2, k2)) {
                for (int i1 = 0; i1 < 2; ++i1) {
                    float f1 = (float)i2 + random.nextFloat() * 0.1f;
                    float f7 = (float)j2 + random.nextFloat();
                    float f13 = (float)k2 + random.nextFloat();
                    world.spawnParticle("largesmoke", f1, f7, f13, 0.0, 0.0, 0.0);
                }
            }
            if (Block.fire.canBlockCatchFire(world, i2 + 1, j2, k2)) {
                for (int j1 = 0; j1 < 2; ++j1) {
                    float f2 = (float)(i2 + 1) - random.nextFloat() * 0.1f;
                    float f8 = (float)j2 + random.nextFloat();
                    float f14 = (float)k2 + random.nextFloat();
                    world.spawnParticle("largesmoke", f2, f8, f14, 0.0, 0.0, 0.0);
                }
            }
            if (Block.fire.canBlockCatchFire(world, i2, j2, k2 - 1)) {
                for (int k1 = 0; k1 < 2; ++k1) {
                    float f3 = (float)i2 + random.nextFloat();
                    float f9 = (float)j2 + random.nextFloat();
                    float f15 = (float)k2 + random.nextFloat() * 0.1f;
                    world.spawnParticle("largesmoke", f3, f9, f15, 0.0, 0.0, 0.0);
                }
            }
            if (Block.fire.canBlockCatchFire(world, i2, j2, k2 + 1)) {
                for (int l1 = 0; l1 < 2; ++l1) {
                    float f4 = (float)i2 + random.nextFloat();
                    float f10 = (float)j2 + random.nextFloat();
                    float f16 = (float)(k2 + 1) - random.nextFloat() * 0.1f;
                    world.spawnParticle("largesmoke", f4, f10, f16, 0.0, 0.0, 0.0);
                }
            }
            if (!Block.fire.canBlockCatchFire(world, i2, j2 + 1, k2)) break block12;
            for (int i22 = 0; i22 < 2; ++i22) {
                float f5 = (float)i2 + random.nextFloat();
                float f11 = (float)(j2 + 1) - random.nextFloat() * 0.1f;
                float f17 = (float)k2 + random.nextFloat();
                world.spawnParticle("largesmoke", f5, f11, f17, 0.0, 0.0, 0.0);
            }
        }
    }
}

