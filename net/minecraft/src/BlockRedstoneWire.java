/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockRedstoneWire
extends Block {
    private boolean wiresProvidePower = true;

    public BlockRedstoneWire(int i2, int j2) {
        super(i2, j2, Material.circuits);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int i2, int j2) {
        return this.blockIndexInTexture + (j2 <= 0 ? 0 : 16);
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
        return 5;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        return world.isBlockOpaqueCube(i2, j2 - 1, k2);
    }

    private void updateAndPropagateCurrentStrength(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockMetadata(i2, j2, k2);
        int i1 = 0;
        this.wiresProvidePower = false;
        boolean flag = world.isBlockIndirectlyGettingPowered(i2, j2, k2);
        this.wiresProvidePower = true;
        if (flag) {
            i1 = 15;
        } else {
            for (int j1 = 0; j1 < 4; ++j1) {
                int l1 = i2;
                int j22 = k2;
                if (j1 == 0) {
                    --l1;
                }
                if (j1 == 1) {
                    ++l1;
                }
                if (j1 == 2) {
                    --j22;
                }
                if (j1 == 3) {
                    ++j22;
                }
                i1 = this.getMaxCurrentStrength(world, l1, j2, j22, i1);
                if (world.isBlockOpaqueCube(l1, j2, j22) && !world.isBlockOpaqueCube(i2, j2 + 1, k2)) {
                    i1 = this.getMaxCurrentStrength(world, l1, j2 + 1, j22, i1);
                    continue;
                }
                if (world.isBlockOpaqueCube(l1, j2, j22)) continue;
                i1 = this.getMaxCurrentStrength(world, l1, j2 - 1, j22, i1);
            }
            i1 = i1 > 0 ? --i1 : 0;
        }
        if (l2 != i1) {
            world.setBlockMetadataWithNotify(i2, j2, k2, i1);
            world.func_701_b(i2, j2, k2, i2, j2, k2);
            if (i1 > 0) {
                --i1;
            }
            for (int k1 = 0; k1 < 4; ++k1) {
                int i3;
                int i22 = i2;
                int k22 = k2;
                int l22 = j2 - 1;
                if (k1 == 0) {
                    --i22;
                }
                if (k1 == 1) {
                    ++i22;
                }
                if (k1 == 2) {
                    --k22;
                }
                if (k1 == 3) {
                    ++k22;
                }
                if (world.isBlockOpaqueCube(i22, j2, k22)) {
                    l22 += 2;
                }
                if ((i3 = this.getMaxCurrentStrength(world, i22, j2, k22, -1)) >= 0 && i3 != i1) {
                    this.updateAndPropagateCurrentStrength(world, i22, j2, k22);
                }
                if ((i3 = this.getMaxCurrentStrength(world, i22, l22, k22, -1)) < 0 || i3 == i1) continue;
                this.updateAndPropagateCurrentStrength(world, i22, l22, k22);
            }
            if (l2 == 0 || i1 == 0) {
                world.notifyBlocksOfNeighborChange(i2, j2, k2, this.blockID);
                world.notifyBlocksOfNeighborChange(i2 - 1, j2, k2, this.blockID);
                world.notifyBlocksOfNeighborChange(i2 + 1, j2, k2, this.blockID);
                world.notifyBlocksOfNeighborChange(i2, j2, k2 - 1, this.blockID);
                world.notifyBlocksOfNeighborChange(i2, j2, k2 + 1, this.blockID);
                world.notifyBlocksOfNeighborChange(i2, j2 - 1, k2, this.blockID);
                world.notifyBlocksOfNeighborChange(i2, j2 + 1, k2, this.blockID);
            }
        }
    }

    private void notifyWireNeighborsOfNeighborChange(World world, int i2, int j2, int k2) {
        if (world.getBlockId(i2, j2, k2) != this.blockID) {
            return;
        }
        world.notifyBlocksOfNeighborChange(i2, j2, k2, this.blockID);
        world.notifyBlocksOfNeighborChange(i2 - 1, j2, k2, this.blockID);
        world.notifyBlocksOfNeighborChange(i2 + 1, j2, k2, this.blockID);
        world.notifyBlocksOfNeighborChange(i2, j2, k2 - 1, this.blockID);
        world.notifyBlocksOfNeighborChange(i2, j2, k2 + 1, this.blockID);
        world.notifyBlocksOfNeighborChange(i2, j2 - 1, k2, this.blockID);
        world.notifyBlocksOfNeighborChange(i2, j2 + 1, k2, this.blockID);
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
        super.onBlockAdded(world, i2, j2, k2);
        if (world.multiplayerWorld) {
            return;
        }
        this.updateAndPropagateCurrentStrength(world, i2, j2, k2);
        world.notifyBlocksOfNeighborChange(i2, j2 + 1, k2, this.blockID);
        world.notifyBlocksOfNeighborChange(i2, j2 - 1, k2, this.blockID);
        this.notifyWireNeighborsOfNeighborChange(world, i2 - 1, j2, k2);
        this.notifyWireNeighborsOfNeighborChange(world, i2 + 1, j2, k2);
        this.notifyWireNeighborsOfNeighborChange(world, i2, j2, k2 - 1);
        this.notifyWireNeighborsOfNeighborChange(world, i2, j2, k2 + 1);
        if (world.isBlockOpaqueCube(i2 - 1, j2, k2)) {
            this.notifyWireNeighborsOfNeighborChange(world, i2 - 1, j2 + 1, k2);
        } else {
            this.notifyWireNeighborsOfNeighborChange(world, i2 - 1, j2 - 1, k2);
        }
        if (world.isBlockOpaqueCube(i2 + 1, j2, k2)) {
            this.notifyWireNeighborsOfNeighborChange(world, i2 + 1, j2 + 1, k2);
        } else {
            this.notifyWireNeighborsOfNeighborChange(world, i2 + 1, j2 - 1, k2);
        }
        if (world.isBlockOpaqueCube(i2, j2, k2 - 1)) {
            this.notifyWireNeighborsOfNeighborChange(world, i2, j2 + 1, k2 - 1);
        } else {
            this.notifyWireNeighborsOfNeighborChange(world, i2, j2 - 1, k2 - 1);
        }
        if (world.isBlockOpaqueCube(i2, j2, k2 + 1)) {
            this.notifyWireNeighborsOfNeighborChange(world, i2, j2 + 1, k2 + 1);
        } else {
            this.notifyWireNeighborsOfNeighborChange(world, i2, j2 - 1, k2 + 1);
        }
    }

    @Override
    public void onBlockRemoval(World world, int i2, int j2, int k2) {
        super.onBlockRemoval(world, i2, j2, k2);
        if (world.multiplayerWorld) {
            return;
        }
        world.notifyBlocksOfNeighborChange(i2, j2 + 1, k2, this.blockID);
        world.notifyBlocksOfNeighborChange(i2, j2 - 1, k2, this.blockID);
        this.updateAndPropagateCurrentStrength(world, i2, j2, k2);
        this.notifyWireNeighborsOfNeighborChange(world, i2 - 1, j2, k2);
        this.notifyWireNeighborsOfNeighborChange(world, i2 + 1, j2, k2);
        this.notifyWireNeighborsOfNeighborChange(world, i2, j2, k2 - 1);
        this.notifyWireNeighborsOfNeighborChange(world, i2, j2, k2 + 1);
        if (world.isBlockOpaqueCube(i2 - 1, j2, k2)) {
            this.notifyWireNeighborsOfNeighborChange(world, i2 - 1, j2 + 1, k2);
        } else {
            this.notifyWireNeighborsOfNeighborChange(world, i2 - 1, j2 - 1, k2);
        }
        if (world.isBlockOpaqueCube(i2 + 1, j2, k2)) {
            this.notifyWireNeighborsOfNeighborChange(world, i2 + 1, j2 + 1, k2);
        } else {
            this.notifyWireNeighborsOfNeighborChange(world, i2 + 1, j2 - 1, k2);
        }
        if (world.isBlockOpaqueCube(i2, j2, k2 - 1)) {
            this.notifyWireNeighborsOfNeighborChange(world, i2, j2 + 1, k2 - 1);
        } else {
            this.notifyWireNeighborsOfNeighborChange(world, i2, j2 - 1, k2 - 1);
        }
        if (world.isBlockOpaqueCube(i2, j2, k2 + 1)) {
            this.notifyWireNeighborsOfNeighborChange(world, i2, j2 + 1, k2 + 1);
        } else {
            this.notifyWireNeighborsOfNeighborChange(world, i2, j2 - 1, k2 + 1);
        }
    }

    private int getMaxCurrentStrength(World world, int i2, int j2, int k2, int l2) {
        if (world.getBlockId(i2, j2, k2) != this.blockID) {
            return l2;
        }
        int i1 = world.getBlockMetadata(i2, j2, k2);
        if (i1 > l2) {
            return i1;
        }
        return l2;
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        if (world.multiplayerWorld) {
            return;
        }
        int i1 = world.getBlockMetadata(i2, j2, k2);
        boolean flag = this.canPlaceBlockAt(world, i2, j2, k2);
        if (!flag) {
            this.dropBlockAsItem(world, i2, j2, k2, i1);
            world.setBlockWithNotify(i2, j2, k2, 0);
        } else {
            this.updateAndPropagateCurrentStrength(world, i2, j2, k2);
        }
        super.onNeighborBlockChange(world, i2, j2, k2, l2);
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Item.redstone.shiftedIndex;
    }

    @Override
    public boolean isIndirectlyPoweringTo(World world, int i2, int j2, int k2, int l2) {
        if (!this.wiresProvidePower) {
            return false;
        }
        return this.isPoweringTo(world, i2, j2, k2, l2);
    }

    @Override
    public boolean isPoweringTo(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        boolean flag3;
        if (!this.wiresProvidePower) {
            return false;
        }
        if (iblockaccess.getBlockMetadata(i2, j2, k2) == 0) {
            return false;
        }
        if (l2 == 1) {
            return true;
        }
        boolean flag = BlockRedstoneWire.isPowerProviderOrWire(iblockaccess, i2 - 1, j2, k2) || !iblockaccess.isBlockOpaqueCube(i2 - 1, j2, k2) && BlockRedstoneWire.isPowerProviderOrWire(iblockaccess, i2 - 1, j2 - 1, k2);
        boolean flag1 = BlockRedstoneWire.isPowerProviderOrWire(iblockaccess, i2 + 1, j2, k2) || !iblockaccess.isBlockOpaqueCube(i2 + 1, j2, k2) && BlockRedstoneWire.isPowerProviderOrWire(iblockaccess, i2 + 1, j2 - 1, k2);
        boolean flag2 = BlockRedstoneWire.isPowerProviderOrWire(iblockaccess, i2, j2, k2 - 1) || !iblockaccess.isBlockOpaqueCube(i2, j2, k2 - 1) && BlockRedstoneWire.isPowerProviderOrWire(iblockaccess, i2, j2 - 1, k2 - 1);
        boolean bl2 = flag3 = BlockRedstoneWire.isPowerProviderOrWire(iblockaccess, i2, j2, k2 + 1) || !iblockaccess.isBlockOpaqueCube(i2, j2, k2 + 1) && BlockRedstoneWire.isPowerProviderOrWire(iblockaccess, i2, j2 - 1, k2 + 1);
        if (!iblockaccess.isBlockOpaqueCube(i2, j2 + 1, k2)) {
            if (iblockaccess.isBlockOpaqueCube(i2 - 1, j2, k2) && BlockRedstoneWire.isPowerProviderOrWire(iblockaccess, i2 - 1, j2 + 1, k2)) {
                flag = true;
            }
            if (iblockaccess.isBlockOpaqueCube(i2 + 1, j2, k2) && BlockRedstoneWire.isPowerProviderOrWire(iblockaccess, i2 + 1, j2 + 1, k2)) {
                flag1 = true;
            }
            if (iblockaccess.isBlockOpaqueCube(i2, j2, k2 - 1) && BlockRedstoneWire.isPowerProviderOrWire(iblockaccess, i2, j2 + 1, k2 - 1)) {
                flag2 = true;
            }
            if (iblockaccess.isBlockOpaqueCube(i2, j2, k2 + 1) && BlockRedstoneWire.isPowerProviderOrWire(iblockaccess, i2, j2 + 1, k2 + 1)) {
                flag3 = true;
            }
        }
        if (!(flag2 || flag1 || flag || flag3 || l2 < 2 || l2 > 5)) {
            return true;
        }
        if (l2 == 2 && flag2 && !flag && !flag1) {
            return true;
        }
        if (l2 == 3 && flag3 && !flag && !flag1) {
            return true;
        }
        if (l2 == 4 && flag && !flag2 && !flag3) {
            return true;
        }
        return l2 == 5 && flag1 && !flag2 && !flag3;
    }

    @Override
    public boolean canProvidePower() {
        return this.wiresProvidePower;
    }

    @Override
    public void randomDisplayTick(World world, int i2, int j2, int k2, Random random) {
        if (world.getBlockMetadata(i2, j2, k2) > 0) {
            double d2 = (double)i2 + 0.5 + ((double)random.nextFloat() - 0.5) * 0.2;
            double d1 = (float)j2 + 0.0625f;
            double d22 = (double)k2 + 0.5 + ((double)random.nextFloat() - 0.5) * 0.2;
            world.spawnParticle("reddust", d2, d1, d22, 0.0, 0.0, 0.0);
        }
    }

    public static boolean isPowerProviderOrWire(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        int l2 = iblockaccess.getBlockId(i2, j2, k2);
        if (l2 == Block.redstoneWire.blockID) {
            return true;
        }
        if (l2 == 0) {
            return false;
        }
        return Block.blocksList[l2].canProvidePower();
    }
}

