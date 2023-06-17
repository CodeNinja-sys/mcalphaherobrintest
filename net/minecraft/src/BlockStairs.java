/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class BlockStairs
extends Block {
    private Block modelBlock;

    protected BlockStairs(int i2, Block block) {
        super(i2, block.blockIndexInTexture, block.blockMaterial);
        this.modelBlock = block;
        this.setHardness(block.blockHardness);
        this.setResistance(block.blockResistance / 3.0f);
        this.setStepSound(block.stepSound);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        return super.getCollisionBoundingBoxFromPool(world, i2, j2, k2);
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
        return 10;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        return super.shouldSideBeRendered(iblockaccess, i2, j2, k2, l2);
    }

    @Override
    public void getCollidingBoundingBoxes(World world, int i2, int j2, int k2, AxisAlignedBB axisalignedbb, ArrayList arraylist) {
        int l2 = world.getBlockMetadata(i2, j2, k2);
        if (l2 == 0) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 1.0f);
            super.getCollidingBoundingBoxes(world, i2, j2, k2, axisalignedbb, arraylist);
            this.setBlockBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            super.getCollidingBoundingBoxes(world, i2, j2, k2, axisalignedbb, arraylist);
        } else if (l2 == 1) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
            super.getCollidingBoundingBoxes(world, i2, j2, k2, axisalignedbb, arraylist);
            this.setBlockBounds(0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
            super.getCollidingBoundingBoxes(world, i2, j2, k2, axisalignedbb, arraylist);
        } else if (l2 == 2) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.5f);
            super.getCollidingBoundingBoxes(world, i2, j2, k2, axisalignedbb, arraylist);
            this.setBlockBounds(0.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
            super.getCollidingBoundingBoxes(world, i2, j2, k2, axisalignedbb, arraylist);
        } else if (l2 == 3) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
            super.getCollidingBoundingBoxes(world, i2, j2, k2, axisalignedbb, arraylist);
            this.setBlockBounds(0.0f, 0.0f, 0.5f, 1.0f, 0.5f, 1.0f);
            super.getCollidingBoundingBoxes(world, i2, j2, k2, axisalignedbb, arraylist);
        }
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void randomDisplayTick(World world, int i2, int j2, int k2, Random random) {
        this.modelBlock.randomDisplayTick(world, i2, j2, k2, random);
    }

    @Override
    public void onBlockClicked(World world, int i2, int j2, int k2, EntityPlayer entityplayer) {
        this.modelBlock.onBlockClicked(world, i2, j2, k2, entityplayer);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int i2, int j2, int k2, int l2) {
        this.modelBlock.onBlockDestroyedByPlayer(world, i2, j2, k2, l2);
    }

    @Override
    public float getBlockBrightness(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        return this.modelBlock.getBlockBrightness(iblockaccess, i2, j2, k2);
    }

    @Override
    public float func_227_a(Entity entity) {
        return this.modelBlock.func_227_a(entity);
    }

    @Override
    public int func_234_g() {
        return this.modelBlock.func_234_g();
    }

    @Override
    public int idDropped(int i2, Random random) {
        return this.modelBlock.idDropped(i2, random);
    }

    @Override
    public int quantityDropped(Random random) {
        return this.modelBlock.quantityDropped(random);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int i2, int j2) {
        return this.modelBlock.getBlockTextureFromSideAndMetadata(i2, j2);
    }

    @Override
    public int getBlockTextureFromSide(int i2) {
        return this.modelBlock.getBlockTextureFromSide(i2);
    }

    @Override
    public int getBlockTexture(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        return this.modelBlock.getBlockTexture(iblockaccess, i2, j2, k2, l2);
    }

    @Override
    public int tickRate() {
        return this.modelBlock.tickRate();
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        return this.modelBlock.getSelectedBoundingBoxFromPool(world, i2, j2, k2);
    }

    @Override
    public void velocityToAddToEntity(World world, int i2, int j2, int k2, Entity entity, Vec3D vec3d) {
        this.modelBlock.velocityToAddToEntity(world, i2, j2, k2, entity, vec3d);
    }

    @Override
    public boolean isCollidable() {
        return this.modelBlock.isCollidable();
    }

    @Override
    public boolean canCollideCheck(int i2, boolean flag) {
        return this.modelBlock.canCollideCheck(i2, flag);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        return this.modelBlock.canPlaceBlockAt(world, i2, j2, k2);
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
        this.onNeighborBlockChange(world, i2, j2, k2, 0);
        this.modelBlock.onBlockAdded(world, i2, j2, k2);
    }

    @Override
    public void onBlockRemoval(World world, int i2, int j2, int k2) {
        this.modelBlock.onBlockRemoval(world, i2, j2, k2);
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int i2, int j2, int k2, int l2, float f2) {
        this.modelBlock.dropBlockAsItemWithChance(world, i2, j2, k2, l2, f2);
    }

    @Override
    public void dropBlockAsItem(World world, int i2, int j2, int k2, int l2) {
        this.modelBlock.dropBlockAsItem(world, i2, j2, k2, l2);
    }

    @Override
    public void onEntityWalking(World world, int i2, int j2, int k2, Entity entity) {
        this.modelBlock.onEntityWalking(world, i2, j2, k2, entity);
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        this.modelBlock.updateTick(world, i2, j2, k2, random);
    }

    @Override
    public boolean blockActivated(World world, int i2, int j2, int k2, EntityPlayer entityplayer) {
        return this.modelBlock.blockActivated(world, i2, j2, k2, entityplayer);
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int i2, int j2, int k2) {
        this.modelBlock.onBlockDestroyedByExplosion(world, i2, j2, k2);
    }

    @Override
    public void onBlockPlacedBy(World world, int i2, int j2, int k2, EntityLiving entityliving) {
        int l2 = MathHelper.floor_double((double)(entityliving.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
        if (l2 == 0) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 2);
        }
        if (l2 == 1) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 1);
        }
        if (l2 == 2) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 3);
        }
        if (l2 == 3) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 0);
        }
    }
}

