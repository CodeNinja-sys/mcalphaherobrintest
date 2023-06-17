/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockLever
extends Block {
    protected BlockLever(int i2, int j2) {
        super(i2, j2, Material.circuits);
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
        return 12;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        if (world.isBlockOpaqueCube(i2 - 1, j2, k2)) {
            return true;
        }
        if (world.isBlockOpaqueCube(i2 + 1, j2, k2)) {
            return true;
        }
        if (world.isBlockOpaqueCube(i2, j2, k2 - 1)) {
            return true;
        }
        if (world.isBlockOpaqueCube(i2, j2, k2 + 1)) {
            return true;
        }
        return world.isBlockOpaqueCube(i2, j2 - 1, k2);
    }

    @Override
    public void onBlockPlaced(World world, int i2, int j2, int k2, int l2) {
        int i1 = world.getBlockMetadata(i2, j2, k2);
        int j1 = i1 & 8;
        i1 &= 7;
        if (l2 == 1 && world.isBlockOpaqueCube(i2, j2 - 1, k2)) {
            i1 = 5 + world.rand.nextInt(2);
        }
        if (l2 == 2 && world.isBlockOpaqueCube(i2, j2, k2 + 1)) {
            i1 = 4;
        }
        if (l2 == 3 && world.isBlockOpaqueCube(i2, j2, k2 - 1)) {
            i1 = 3;
        }
        if (l2 == 4 && world.isBlockOpaqueCube(i2 + 1, j2, k2)) {
            i1 = 2;
        }
        if (l2 == 5 && world.isBlockOpaqueCube(i2 - 1, j2, k2)) {
            i1 = 1;
        }
        world.setBlockMetadataWithNotify(i2, j2, k2, i1 + j1);
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
        if (world.isBlockOpaqueCube(i2 - 1, j2, k2)) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 1);
        } else if (world.isBlockOpaqueCube(i2 + 1, j2, k2)) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 2);
        } else if (world.isBlockOpaqueCube(i2, j2, k2 - 1)) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 3);
        } else if (world.isBlockOpaqueCube(i2, j2, k2 + 1)) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 4);
        } else if (world.isBlockOpaqueCube(i2, j2 - 1, k2)) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 5 + world.rand.nextInt(2));
        }
        this.checkIfAttachedToBlock(world, i2, j2, k2);
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        if (this.checkIfAttachedToBlock(world, i2, j2, k2)) {
            int i1 = world.getBlockMetadata(i2, j2, k2) & 7;
            boolean flag = false;
            if (!world.isBlockOpaqueCube(i2 - 1, j2, k2) && i1 == 1) {
                flag = true;
            }
            if (!world.isBlockOpaqueCube(i2 + 1, j2, k2) && i1 == 2) {
                flag = true;
            }
            if (!world.isBlockOpaqueCube(i2, j2, k2 - 1) && i1 == 3) {
                flag = true;
            }
            if (!world.isBlockOpaqueCube(i2, j2, k2 + 1) && i1 == 4) {
                flag = true;
            }
            if (!world.isBlockOpaqueCube(i2, j2 - 1, k2) && i1 == 5) {
                flag = true;
            }
            if (flag) {
                this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
                world.setBlockWithNotify(i2, j2, k2, 0);
            }
        }
    }

    private boolean checkIfAttachedToBlock(World world, int i2, int j2, int k2) {
        if (!this.canPlaceBlockAt(world, i2, j2, k2)) {
            this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
            world.setBlockWithNotify(i2, j2, k2, 0);
            return false;
        }
        return true;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        int l2 = iblockaccess.getBlockMetadata(i2, j2, k2) & 7;
        float f2 = 0.1875f;
        if (l2 == 1) {
            this.setBlockBounds(0.0f, 0.2f, 0.5f - f2, f2 * 2.0f, 0.8f, 0.5f + f2);
        } else if (l2 == 2) {
            this.setBlockBounds(1.0f - f2 * 2.0f, 0.2f, 0.5f - f2, 1.0f, 0.8f, 0.5f + f2);
        } else if (l2 == 3) {
            this.setBlockBounds(0.5f - f2, 0.2f, 0.0f, 0.5f + f2, 0.8f, f2 * 2.0f);
        } else if (l2 == 4) {
            this.setBlockBounds(0.5f - f2, 0.2f, 1.0f - f2 * 2.0f, 0.5f + f2, 0.8f, 1.0f);
        } else {
            float f1 = 0.25f;
            this.setBlockBounds(0.5f - f1, 0.0f, 0.5f - f1, 0.5f + f1, 0.6f, 0.5f + f1);
        }
    }

    @Override
    public void onBlockClicked(World world, int i2, int j2, int k2, EntityPlayer entityplayer) {
        this.blockActivated(world, i2, j2, k2, entityplayer);
    }

    @Override
    public boolean blockActivated(World world, int i2, int j2, int k2, EntityPlayer entityplayer) {
        if (world.multiplayerWorld) {
            return true;
        }
        int l2 = world.getBlockMetadata(i2, j2, k2);
        int i1 = l2 & 7;
        int j1 = 8 - (l2 & 8);
        world.setBlockMetadataWithNotify(i2, j2, k2, i1 + j1);
        world.func_701_b(i2, j2, k2, i2, j2, k2);
        world.playSoundEffect((double)i2 + 0.5, (double)j2 + 0.5, (double)k2 + 0.5, "random.click", 0.3f, j1 <= 0 ? 0.5f : 0.6f);
        world.notifyBlocksOfNeighborChange(i2, j2, k2, this.blockID);
        if (i1 == 1) {
            world.notifyBlocksOfNeighborChange(i2 - 1, j2, k2, this.blockID);
        } else if (i1 == 2) {
            world.notifyBlocksOfNeighborChange(i2 + 1, j2, k2, this.blockID);
        } else if (i1 == 3) {
            world.notifyBlocksOfNeighborChange(i2, j2, k2 - 1, this.blockID);
        } else if (i1 == 4) {
            world.notifyBlocksOfNeighborChange(i2, j2, k2 + 1, this.blockID);
        } else {
            world.notifyBlocksOfNeighborChange(i2, j2 - 1, k2, this.blockID);
        }
        return true;
    }

    @Override
    public void onBlockRemoval(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockMetadata(i2, j2, k2);
        if ((l2 & 8) > 0) {
            world.notifyBlocksOfNeighborChange(i2, j2, k2, this.blockID);
            int i1 = l2 & 7;
            if (i1 == 1) {
                world.notifyBlocksOfNeighborChange(i2 - 1, j2, k2, this.blockID);
            } else if (i1 == 2) {
                world.notifyBlocksOfNeighborChange(i2 + 1, j2, k2, this.blockID);
            } else if (i1 == 3) {
                world.notifyBlocksOfNeighborChange(i2, j2, k2 - 1, this.blockID);
            } else if (i1 == 4) {
                world.notifyBlocksOfNeighborChange(i2, j2, k2 + 1, this.blockID);
            } else {
                world.notifyBlocksOfNeighborChange(i2, j2 - 1, k2, this.blockID);
            }
        }
        super.onBlockRemoval(world, i2, j2, k2);
    }

    @Override
    public boolean isPoweringTo(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        return (iblockaccess.getBlockMetadata(i2, j2, k2) & 8) > 0;
    }

    @Override
    public boolean isIndirectlyPoweringTo(World world, int i2, int j2, int k2, int l2) {
        int i1 = world.getBlockMetadata(i2, j2, k2);
        if ((i1 & 8) == 0) {
            return false;
        }
        int j1 = i1 & 7;
        if (j1 == 5 && l2 == 1) {
            return true;
        }
        if (j1 == 4 && l2 == 2) {
            return true;
        }
        if (j1 == 3 && l2 == 3) {
            return true;
        }
        if (j1 == 2 && l2 == 4) {
            return true;
        }
        return j1 == 1 && l2 == 5;
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }
}

