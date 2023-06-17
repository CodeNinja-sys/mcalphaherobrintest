/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockButton
extends Block {
    protected BlockButton(int i2, int j2) {
        super(i2, j2, Material.circuits);
        this.setTickOnLoad(true);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        return null;
    }

    @Override
    public int tickRate() {
        return 20;
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
        return world.isBlockOpaqueCube(i2, j2, k2 + 1);
    }

    @Override
    public void onBlockPlaced(World world, int i2, int j2, int k2, int l2) {
        int i1 = world.getBlockMetadata(i2, j2, k2);
        int j1 = i1 & 8;
        i1 &= 7;
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
        }
        this.func_305_h(world, i2, j2, k2);
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        if (this.func_305_h(world, i2, j2, k2)) {
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
            if (flag) {
                this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
                world.setBlockWithNotify(i2, j2, k2, 0);
            }
        }
    }

    private boolean func_305_h(World world, int i2, int j2, int k2) {
        if (!this.canPlaceBlockAt(world, i2, j2, k2)) {
            this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
            world.setBlockWithNotify(i2, j2, k2, 0);
            return false;
        }
        return true;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        int l2 = iblockaccess.getBlockMetadata(i2, j2, k2);
        int i1 = l2 & 7;
        boolean flag = (l2 & 8) > 0;
        float f2 = 0.375f;
        float f1 = 0.625f;
        float f22 = 0.1875f;
        float f3 = 0.125f;
        if (flag) {
            f3 = 0.0625f;
        }
        if (i1 == 1) {
            this.setBlockBounds(0.0f, f2, 0.5f - f22, f3, f1, 0.5f + f22);
        } else if (i1 == 2) {
            this.setBlockBounds(1.0f - f3, f2, 0.5f - f22, 1.0f, f1, 0.5f + f22);
        } else if (i1 == 3) {
            this.setBlockBounds(0.5f - f22, f2, 0.0f, 0.5f + f22, f1, f3);
        } else if (i1 == 4) {
            this.setBlockBounds(0.5f - f22, f2, 1.0f - f3, 0.5f + f22, f1, 1.0f);
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
        if (j1 == 0) {
            return true;
        }
        world.setBlockMetadataWithNotify(i2, j2, k2, i1 + j1);
        world.func_701_b(i2, j2, k2, i2, j2, k2);
        world.playSoundEffect((double)i2 + 0.5, (double)j2 + 0.5, (double)k2 + 0.5, "random.click", 0.3f, 0.6f);
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
        world.scheduleBlockUpdate(i2, j2, k2, this.blockID);
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

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        if (world.multiplayerWorld) {
            return;
        }
        int l2 = world.getBlockMetadata(i2, j2, k2);
        if ((l2 & 8) == 0) {
            return;
        }
        world.setBlockMetadataWithNotify(i2, j2, k2, l2 & 7);
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
        world.playSoundEffect((double)i2 + 0.5, (double)j2 + 0.5, (double)k2 + 0.5, "random.click", 0.3f, 0.5f);
        world.func_701_b(i2, j2, k2, i2, j2, k2);
    }

    @Override
    public void func_237_e() {
        float f2 = 0.1875f;
        float f1 = 0.125f;
        float f22 = 0.125f;
        this.setBlockBounds(0.5f - f2, 0.5f - f1, 0.5f - f22, 0.5f + f2, 0.5f + f1, 0.5f + f22);
    }
}

