/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MinecartTrackLogic;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class BlockMinecartTrack
extends Block {
    protected BlockMinecartTrack(int i2, int j2) {
        super(i2, j2, Material.circuits);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
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
    public MovingObjectPosition collisionRayTrace(World world, int i2, int j2, int k2, Vec3D vec3d, Vec3D vec3d1) {
        this.setBlockBoundsBasedOnState(world, i2, j2, k2);
        return super.collisionRayTrace(world, i2, j2, k2, vec3d, vec3d1);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        int l2 = iblockaccess.getBlockMetadata(i2, j2, k2);
        if (l2 >= 2 && l2 <= 5) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.625f, 1.0f);
        } else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
        }
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int i2, int j2) {
        if (j2 >= 6) {
            return this.blockIndexInTexture - 16;
        }
        return this.blockIndexInTexture;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 9;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        return world.isBlockOpaqueCube(i2, j2 - 1, k2);
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
        if (!world.multiplayerWorld) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 15);
            this.func_4031_h(world, i2, j2, k2);
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        if (world.multiplayerWorld) {
            return;
        }
        int i1 = world.getBlockMetadata(i2, j2, k2);
        boolean flag = false;
        if (!world.isBlockOpaqueCube(i2, j2 - 1, k2)) {
            flag = true;
        }
        if (i1 == 2 && !world.isBlockOpaqueCube(i2 + 1, j2, k2)) {
            flag = true;
        }
        if (i1 == 3 && !world.isBlockOpaqueCube(i2 - 1, j2, k2)) {
            flag = true;
        }
        if (i1 == 4 && !world.isBlockOpaqueCube(i2, j2, k2 - 1)) {
            flag = true;
        }
        if (i1 == 5 && !world.isBlockOpaqueCube(i2, j2, k2 + 1)) {
            flag = true;
        }
        if (flag) {
            this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
            world.setBlockWithNotify(i2, j2, k2, 0);
        } else if (l2 > 0 && Block.blocksList[l2].canProvidePower() && MinecartTrackLogic.func_791_a(new MinecartTrackLogic(this, world, i2, j2, k2)) == 3) {
            this.func_4031_h(world, i2, j2, k2);
        }
    }

    private void func_4031_h(World world, int i2, int j2, int k2) {
        if (world.multiplayerWorld) {
            return;
        }
        new MinecartTrackLogic(this, world, i2, j2, k2).func_792_a(world.isBlockIndirectlyGettingPowered(i2, j2, k2));
    }
}

