/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockTorch;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.RedstoneUpdateInfo;
import net.minecraft.src.World;

public class BlockRedstoneTorch
extends BlockTorch {
    private boolean torchActive = false;
    private static List torchUpdates = new ArrayList();

    @Override
    public int getBlockTextureFromSideAndMetadata(int i2, int j2) {
        if (i2 == 1) {
            return Block.redstoneWire.getBlockTextureFromSideAndMetadata(i2, j2);
        }
        return super.getBlockTextureFromSideAndMetadata(i2, j2);
    }

    private boolean checkForBurnout(World world, int i2, int j2, int k2, boolean flag) {
        if (flag) {
            torchUpdates.add(new RedstoneUpdateInfo(i2, j2, k2, world.worldTime));
        }
        int l2 = 0;
        for (int i1 = 0; i1 < torchUpdates.size(); ++i1) {
            RedstoneUpdateInfo redstoneupdateinfo = (RedstoneUpdateInfo)torchUpdates.get(i1);
            if (redstoneupdateinfo.x != i2 || redstoneupdateinfo.y != j2 || redstoneupdateinfo.z != k2 || ++l2 < 8) continue;
            return true;
        }
        return false;
    }

    protected BlockRedstoneTorch(int i2, int j2, boolean flag) {
        super(i2, j2);
        this.torchActive = flag;
        this.setTickOnLoad(true);
    }

    @Override
    public int tickRate() {
        return 2;
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
        if (world.getBlockMetadata(i2, j2, k2) == 0) {
            super.onBlockAdded(world, i2, j2, k2);
        }
        if (this.torchActive) {
            world.notifyBlocksOfNeighborChange(i2, j2 - 1, k2, this.blockID);
            world.notifyBlocksOfNeighborChange(i2, j2 + 1, k2, this.blockID);
            world.notifyBlocksOfNeighborChange(i2 - 1, j2, k2, this.blockID);
            world.notifyBlocksOfNeighborChange(i2 + 1, j2, k2, this.blockID);
            world.notifyBlocksOfNeighborChange(i2, j2, k2 - 1, this.blockID);
            world.notifyBlocksOfNeighborChange(i2, j2, k2 + 1, this.blockID);
        }
    }

    @Override
    public void onBlockRemoval(World world, int i2, int j2, int k2) {
        if (this.torchActive) {
            world.notifyBlocksOfNeighborChange(i2, j2 - 1, k2, this.blockID);
            world.notifyBlocksOfNeighborChange(i2, j2 + 1, k2, this.blockID);
            world.notifyBlocksOfNeighborChange(i2 - 1, j2, k2, this.blockID);
            world.notifyBlocksOfNeighborChange(i2 + 1, j2, k2, this.blockID);
            world.notifyBlocksOfNeighborChange(i2, j2, k2 - 1, this.blockID);
            world.notifyBlocksOfNeighborChange(i2, j2, k2 + 1, this.blockID);
        }
    }

    @Override
    public boolean isPoweringTo(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        if (!this.torchActive) {
            return false;
        }
        int i1 = iblockaccess.getBlockMetadata(i2, j2, k2);
        if (i1 == 5 && l2 == 1) {
            return false;
        }
        if (i1 == 3 && l2 == 3) {
            return false;
        }
        if (i1 == 4 && l2 == 2) {
            return false;
        }
        if (i1 == 1 && l2 == 5) {
            return false;
        }
        return i1 != 2 || l2 != 4;
    }

    private boolean func_15232_h(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockMetadata(i2, j2, k2);
        if (l2 == 5 && world.isBlockIndirectlyProvidingPowerTo(i2, j2 - 1, k2, 0)) {
            return true;
        }
        if (l2 == 3 && world.isBlockIndirectlyProvidingPowerTo(i2, j2, k2 - 1, 2)) {
            return true;
        }
        if (l2 == 4 && world.isBlockIndirectlyProvidingPowerTo(i2, j2, k2 + 1, 3)) {
            return true;
        }
        if (l2 == 1 && world.isBlockIndirectlyProvidingPowerTo(i2 - 1, j2, k2, 4)) {
            return true;
        }
        return l2 == 2 && world.isBlockIndirectlyProvidingPowerTo(i2 + 1, j2, k2, 5);
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        boolean flag = this.func_15232_h(world, i2, j2, k2);
        while (torchUpdates.size() > 0 && world.worldTime - ((RedstoneUpdateInfo)BlockRedstoneTorch.torchUpdates.get((int)0)).updateTime > 100L) {
            torchUpdates.remove(0);
        }
        if (this.torchActive) {
            if (flag) {
                world.setBlockAndMetadataWithNotify(i2, j2, k2, Block.torchRedstoneIdle.blockID, world.getBlockMetadata(i2, j2, k2));
                if (this.checkForBurnout(world, i2, j2, k2, true)) {
                    world.playSoundEffect((float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f, "random.fizz", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);
                    for (int l2 = 0; l2 < 5; ++l2) {
                        double d2 = (double)i2 + random.nextDouble() * 0.6 + 0.2;
                        double d1 = (double)j2 + random.nextDouble() * 0.6 + 0.2;
                        double d22 = (double)k2 + random.nextDouble() * 0.6 + 0.2;
                        world.spawnParticle("smoke", d2, d1, d22, 0.0, 0.0, 0.0);
                    }
                }
            }
        } else if (!flag && !this.checkForBurnout(world, i2, j2, k2, false)) {
            world.setBlockAndMetadataWithNotify(i2, j2, k2, Block.torchRedstoneActive.blockID, world.getBlockMetadata(i2, j2, k2));
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        super.onNeighborBlockChange(world, i2, j2, k2, l2);
        world.scheduleBlockUpdate(i2, j2, k2, this.blockID);
    }

    @Override
    public boolean isIndirectlyPoweringTo(World world, int i2, int j2, int k2, int l2) {
        if (l2 == 0) {
            return this.isPoweringTo(world, i2, j2, k2, l2);
        }
        return false;
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Block.torchRedstoneActive.blockID;
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public void randomDisplayTick(World world, int i2, int j2, int k2, Random random) {
        if (!this.torchActive) {
            return;
        }
        int l2 = world.getBlockMetadata(i2, j2, k2);
        double d2 = (double)((float)i2 + 0.5f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d1 = (double)((float)j2 + 0.7f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d22 = (double)((float)k2 + 0.5f) + (double)(random.nextFloat() - 0.5f) * 0.2;
        double d3 = 0.22f;
        double d4 = 0.27f;
        if (l2 == 1) {
            world.spawnParticle("reddust", d2 - d4, d1 + d3, d22, 0.0, 0.0, 0.0);
        } else if (l2 == 2) {
            world.spawnParticle("reddust", d2 + d4, d1 + d3, d22, 0.0, 0.0, 0.0);
        } else if (l2 == 3) {
            world.spawnParticle("reddust", d2, d1 + d3, d22 - d4, 0.0, 0.0, 0.0);
        } else if (l2 == 4) {
            world.spawnParticle("reddust", d2, d1 + d3, d22 + d4, 0.0, 0.0, 0.0);
        } else {
            world.spawnParticle("reddust", d2, d1, d22, 0.0, 0.0, 0.0);
        }
    }
}

