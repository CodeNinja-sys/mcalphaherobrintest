/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class BlockDoor
extends Block {
    protected BlockDoor(int i2, Material material) {
        super(i2, material);
        this.blockIndexInTexture = 97;
        if (material == Material.iron) {
            ++this.blockIndexInTexture;
        }
        float f2 = 0.5f;
        float f1 = 1.0f;
        this.setBlockBounds(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, f1, 0.5f + f2);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int i2, int j2) {
        if (i2 == 0 || i2 == 1) {
            return this.blockIndexInTexture;
        }
        int k2 = this.func_312_c(j2);
        if ((k2 == 0 || k2 == 2) ^ i2 <= 3) {
            return this.blockIndexInTexture;
        }
        int l2 = k2 / 2 + (i2 & 1 ^ k2);
        int i1 = this.blockIndexInTexture - (j2 & 8) * 2;
        if (((l2 += (j2 & 4) / 4) & 1) != 0) {
            i1 = -i1;
        }
        return i1;
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
        return 7;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        this.setBlockBoundsBasedOnState(world, i2, j2, k2);
        return super.getSelectedBoundingBoxFromPool(world, i2, j2, k2);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        this.setBlockBoundsBasedOnState(world, i2, j2, k2);
        return super.getCollisionBoundingBoxFromPool(world, i2, j2, k2);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        this.func_313_b(this.func_312_c(iblockaccess.getBlockMetadata(i2, j2, k2)));
    }

    public void func_313_b(int i2) {
        float f2 = 0.1875f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 2.0f, 1.0f);
        if (i2 == 0) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, f2);
        }
        if (i2 == 1) {
            this.setBlockBounds(1.0f - f2, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
        if (i2 == 2) {
            this.setBlockBounds(0.0f, 0.0f, 1.0f - f2, 1.0f, 1.0f, 1.0f);
        }
        if (i2 == 3) {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, f2, 1.0f, 1.0f);
        }
    }

    @Override
    public void onBlockClicked(World world, int i2, int j2, int k2, EntityPlayer entityplayer) {
        this.blockActivated(world, i2, j2, k2, entityplayer);
    }

    @Override
    public boolean blockActivated(World world, int i2, int j2, int k2, EntityPlayer entityplayer) {
        if (this.blockMaterial == Material.iron) {
            return true;
        }
        int l2 = world.getBlockMetadata(i2, j2, k2);
        if ((l2 & 8) != 0) {
            if (world.getBlockId(i2, j2 - 1, k2) == this.blockID) {
                this.blockActivated(world, i2, j2 - 1, k2, entityplayer);
            }
            return true;
        }
        if (world.getBlockId(i2, j2 + 1, k2) == this.blockID) {
            world.setBlockMetadataWithNotify(i2, j2 + 1, k2, (l2 ^ 4) + 8);
        }
        world.setBlockMetadataWithNotify(i2, j2, k2, l2 ^ 4);
        world.func_701_b(i2, j2 - 1, k2, i2, j2, k2);
        if (Math.random() < 0.5) {
            world.playSoundEffect((double)i2 + 0.5, (double)j2 + 0.5, (double)k2 + 0.5, "random.door_open", 1.0f, world.rand.nextFloat() * 0.1f + 0.9f);
        } else {
            world.playSoundEffect((double)i2 + 0.5, (double)j2 + 0.5, (double)k2 + 0.5, "random.door_close", 1.0f, world.rand.nextFloat() * 0.1f + 0.9f);
        }
        return true;
    }

    public void func_311_a(World world, int i2, int j2, int k2, boolean flag) {
        boolean flag1;
        int l2 = world.getBlockMetadata(i2, j2, k2);
        if ((l2 & 8) != 0) {
            if (world.getBlockId(i2, j2 - 1, k2) == this.blockID) {
                this.func_311_a(world, i2, j2 - 1, k2, flag);
            }
            return;
        }
        boolean bl2 = flag1 = (world.getBlockMetadata(i2, j2, k2) & 4) > 0;
        if (flag1 == flag) {
            return;
        }
        if (world.getBlockId(i2, j2 + 1, k2) == this.blockID) {
            world.setBlockMetadataWithNotify(i2, j2 + 1, k2, (l2 ^ 4) + 8);
        }
        world.setBlockMetadataWithNotify(i2, j2, k2, l2 ^ 4);
        world.func_701_b(i2, j2 - 1, k2, i2, j2, k2);
        if (Math.random() < 0.5) {
            world.playSoundEffect((double)i2 + 0.5, (double)j2 + 0.5, (double)k2 + 0.5, "random.door_open", 1.0f, world.rand.nextFloat() * 0.1f + 0.9f);
        } else {
            world.playSoundEffect((double)i2 + 0.5, (double)j2 + 0.5, (double)k2 + 0.5, "random.door_close", 1.0f, world.rand.nextFloat() * 0.1f + 0.9f);
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        int i1 = world.getBlockMetadata(i2, j2, k2);
        if ((i1 & 8) != 0) {
            if (world.getBlockId(i2, j2 - 1, k2) != this.blockID) {
                world.setBlockWithNotify(i2, j2, k2, 0);
            }
            if (l2 > 0 && Block.blocksList[l2].canProvidePower()) {
                this.onNeighborBlockChange(world, i2, j2 - 1, k2, l2);
            }
        } else {
            boolean flag = false;
            if (world.getBlockId(i2, j2 + 1, k2) != this.blockID) {
                world.setBlockWithNotify(i2, j2, k2, 0);
                flag = true;
            }
            if (!world.isBlockOpaqueCube(i2, j2 - 1, k2)) {
                world.setBlockWithNotify(i2, j2, k2, 0);
                flag = true;
                if (world.getBlockId(i2, j2 + 1, k2) == this.blockID) {
                    world.setBlockWithNotify(i2, j2 + 1, k2, 0);
                }
            }
            if (flag) {
                this.dropBlockAsItem(world, i2, j2, k2, i1);
            } else if (l2 > 0 && Block.blocksList[l2].canProvidePower()) {
                boolean flag1 = world.isBlockIndirectlyGettingPowered(i2, j2, k2) || world.isBlockIndirectlyGettingPowered(i2, j2 + 1, k2);
                this.func_311_a(world, i2, j2, k2, flag1);
            }
        }
    }

    @Override
    public int idDropped(int i2, Random random) {
        if ((i2 & 8) != 0) {
            return 0;
        }
        if (this.blockMaterial == Material.iron) {
            return Item.doorSteel.shiftedIndex;
        }
        return Item.doorWood.shiftedIndex;
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int i2, int j2, int k2, Vec3D vec3d, Vec3D vec3d1) {
        this.setBlockBoundsBasedOnState(world, i2, j2, k2);
        return super.collisionRayTrace(world, i2, j2, k2, vec3d, vec3d1);
    }

    public int func_312_c(int i2) {
        if ((i2 & 4) == 0) {
            return i2 - 1 & 3;
        }
        return i2 & 3;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        if (j2 >= 127) {
            return false;
        }
        return world.isBlockOpaqueCube(i2, j2 - 1, k2) && super.canPlaceBlockAt(world, i2, j2, k2) && super.canPlaceBlockAt(world, i2, j2 + 1, k2);
    }
}

