/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumMobType;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockPressurePlate
extends Block {
    private EnumMobType triggerMobType;

    protected BlockPressurePlate(int i2, int j2, EnumMobType enummobtype) {
        super(i2, j2, Material.rock);
        this.triggerMobType = enummobtype;
        this.setTickOnLoad(true);
        float f2 = 0.0625f;
        this.setBlockBounds(f2, 0.0f, f2, 1.0f - f2, 0.03125f, 1.0f - f2);
    }

    @Override
    public int tickRate() {
        return 20;
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
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        return world.isBlockOpaqueCube(i2, j2 - 1, k2);
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        boolean flag = false;
        if (!world.isBlockOpaqueCube(i2, j2 - 1, k2)) {
            flag = true;
        }
        if (flag) {
            this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
            world.setBlockWithNotify(i2, j2, k2, 0);
        }
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        if (world.multiplayerWorld) {
            return;
        }
        if (world.getBlockMetadata(i2, j2, k2) == 0) {
            return;
        }
        this.setStateIfMobInteractsWithPlate(world, i2, j2, k2);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int i2, int j2, int k2, Entity entity) {
        if (world.multiplayerWorld) {
            return;
        }
        if (world.getBlockMetadata(i2, j2, k2) == 1) {
            return;
        }
        this.setStateIfMobInteractsWithPlate(world, i2, j2, k2);
    }

    private void setStateIfMobInteractsWithPlate(World world, int i2, int j2, int k2) {
        boolean flag = world.getBlockMetadata(i2, j2, k2) == 1;
        boolean flag1 = false;
        float f2 = 0.125f;
        List list = null;
        if (this.triggerMobType == EnumMobType.everything) {
            list = world.getEntitiesWithinAABBExcludingEntity(null, AxisAlignedBB.getBoundingBoxFromPool((float)i2 + f2, j2, (float)k2 + f2, (float)(i2 + 1) - f2, (double)j2 + 0.25, (float)(k2 + 1) - f2));
        }
        if (this.triggerMobType == EnumMobType.mobs) {
            list = world.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBoxFromPool((float)i2 + f2, j2, (float)k2 + f2, (float)(i2 + 1) - f2, (double)j2 + 0.25, (float)(k2 + 1) - f2));
        }
        if (this.triggerMobType == EnumMobType.players) {
            list = world.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBoxFromPool((float)i2 + f2, j2, (float)k2 + f2, (float)(i2 + 1) - f2, (double)j2 + 0.25, (float)(k2 + 1) - f2));
        }
        if (list.size() > 0) {
            flag1 = true;
        }
        if (flag1 && !flag) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 1);
            world.notifyBlocksOfNeighborChange(i2, j2, k2, this.blockID);
            world.notifyBlocksOfNeighborChange(i2, j2 - 1, k2, this.blockID);
            world.func_701_b(i2, j2, k2, i2, j2, k2);
            world.playSoundEffect((double)i2 + 0.5, (double)j2 + 0.1, (double)k2 + 0.5, "random.click", 0.3f, 0.6f);
        }
        if (!flag1 && flag) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 0);
            world.notifyBlocksOfNeighborChange(i2, j2, k2, this.blockID);
            world.notifyBlocksOfNeighborChange(i2, j2 - 1, k2, this.blockID);
            world.func_701_b(i2, j2, k2, i2, j2, k2);
            world.playSoundEffect((double)i2 + 0.5, (double)j2 + 0.1, (double)k2 + 0.5, "random.click", 0.3f, 0.5f);
        }
        if (flag1) {
            world.scheduleBlockUpdate(i2, j2, k2, this.blockID);
        }
    }

    @Override
    public void onBlockRemoval(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockMetadata(i2, j2, k2);
        if (l2 > 0) {
            world.notifyBlocksOfNeighborChange(i2, j2, k2, this.blockID);
            world.notifyBlocksOfNeighborChange(i2, j2 - 1, k2, this.blockID);
        }
        super.onBlockRemoval(world, i2, j2, k2);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        boolean flag = iblockaccess.getBlockMetadata(i2, j2, k2) == 1;
        float f2 = 0.0625f;
        if (flag) {
            this.setBlockBounds(f2, 0.0f, f2, 1.0f - f2, 0.03125f, 1.0f - f2);
        } else {
            this.setBlockBounds(f2, 0.0f, f2, 1.0f - f2, 0.0625f, 1.0f - f2);
        }
    }

    @Override
    public boolean isPoweringTo(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        return iblockaccess.getBlockMetadata(i2, j2, k2) > 0;
    }

    @Override
    public boolean isIndirectlyPoweringTo(World world, int i2, int j2, int k2, int l2) {
        if (world.getBlockMetadata(i2, j2, k2) == 0) {
            return false;
        }
        return l2 == 1;
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public void func_237_e() {
        float f2 = 0.5f;
        float f1 = 0.125f;
        float f22 = 0.5f;
        this.setBlockBounds(0.5f - f2, 0.5f - f1, 0.5f - f22, 0.5f + f2, 0.5f + f1, 0.5f + f22);
    }
}

