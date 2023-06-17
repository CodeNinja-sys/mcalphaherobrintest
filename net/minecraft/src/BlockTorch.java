/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class BlockTorch
extends Block {
    protected BlockTorch(int i2, int j2) {
        super(i2, j2, Material.circuits);
        this.setTickOnLoad(true);
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
        return 2;
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
        if (l2 == 1 && world.isBlockOpaqueCube(i2, j2 - 1, k2)) {
            i1 = 5;
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
        world.setBlockMetadataWithNotify(i2, j2, k2, i1);
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        super.updateTick(world, i2, j2, k2, random);
        if (world.getBlockMetadata(i2, j2, k2) == 0) {
            this.onBlockAdded(world, i2, j2, k2);
        }
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
            world.setBlockMetadataWithNotify(i2, j2, k2, 5);
        }
        this.func_271_h(world, i2, j2, k2);
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        if (this.func_271_h(world, i2, j2, k2)) {
            int i1 = world.getBlockMetadata(i2, j2, k2);
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

    private boolean func_271_h(World world, int i2, int j2, int k2) {
        if (!this.canPlaceBlockAt(world, i2, j2, k2)) {
            this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
            world.setBlockWithNotify(i2, j2, k2, 0);
            return false;
        }
        return true;
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int i2, int j2, int k2, Vec3D vec3d, Vec3D vec3d1) {
        int l2 = world.getBlockMetadata(i2, j2, k2) & 7;
        float f2 = 0.15f;
        if (l2 == 1) {
            this.setBlockBounds(0.0f, 0.2f, 0.5f - f2, f2 * 2.0f, 0.8f, 0.5f + f2);
        } else if (l2 == 2) {
            this.setBlockBounds(1.0f - f2 * 2.0f, 0.2f, 0.5f - f2, 1.0f, 0.8f, 0.5f + f2);
        } else if (l2 == 3) {
            this.setBlockBounds(0.5f - f2, 0.2f, 0.0f, 0.5f + f2, 0.8f, f2 * 2.0f);
        } else if (l2 == 4) {
            this.setBlockBounds(0.5f - f2, 0.2f, 1.0f - f2 * 2.0f, 0.5f + f2, 0.8f, 1.0f);
        } else {
            float f1 = 0.1f;
            this.setBlockBounds(0.5f - f1, 0.0f, 0.5f - f1, 0.5f + f1, 0.6f, 0.5f + f1);
        }
        return super.collisionRayTrace(world, i2, j2, k2, vec3d, vec3d1);
    }

    @Override
    public void randomDisplayTick(World world, int i2, int j2, int k2, Random random) {
        int l2 = world.getBlockMetadata(i2, j2, k2);
        double d2 = (float)i2 + 0.5f;
        double d1 = (float)j2 + 0.7f;
        double d22 = (float)k2 + 0.5f;
        double d3 = 0.22f;
        double d4 = 0.27f;
        if (l2 == 1) {
            world.spawnParticle("smoke", d2 - d4, d1 + d3, d22, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", d2 - d4, d1 + d3, d22, 0.0, 0.0, 0.0);
        } else if (l2 == 2) {
            world.spawnParticle("smoke", d2 + d4, d1 + d3, d22, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", d2 + d4, d1 + d3, d22, 0.0, 0.0, 0.0);
        } else if (l2 == 3) {
            world.spawnParticle("smoke", d2, d1 + d3, d22 - d4, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", d2, d1 + d3, d22 - d4, 0.0, 0.0, 0.0);
        } else if (l2 == 4) {
            world.spawnParticle("smoke", d2, d1 + d3, d22 + d4, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", d2, d1 + d3, d22 + d4, 0.0, 0.0, 0.0);
        } else {
            world.spawnParticle("smoke", d2, d1, d22, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", d2, d1, d22, 0.0, 0.0, 0.0);
        }
    }
}

