/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.World;

public class BlockFurnace
extends BlockContainer {
    private final boolean isActive;

    protected BlockFurnace(int i2, boolean flag) {
        super(i2, Material.rock);
        this.isActive = flag;
        this.blockIndexInTexture = 45;
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Block.stoneOvenIdle.blockID;
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
        super.onBlockAdded(world, i2, j2, k2);
        this.func_284_h(world, i2, j2, k2);
    }

    private void func_284_h(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockId(i2, j2, k2 - 1);
        int i1 = world.getBlockId(i2, j2, k2 + 1);
        int j1 = world.getBlockId(i2 - 1, j2, k2);
        int k1 = world.getBlockId(i2 + 1, j2, k2);
        int byte0 = 3;
        if (Block.opaqueCubeLookup[l2] && !Block.opaqueCubeLookup[i1]) {
            byte0 = 3;
        }
        if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l2]) {
            byte0 = 2;
        }
        if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1]) {
            byte0 = 5;
        }
        if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1]) {
            byte0 = 4;
        }
        world.setBlockMetadataWithNotify(i2, j2, k2, byte0);
    }

    @Override
    public int getBlockTexture(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        if (l2 == 1) {
            return Block.stone.blockIndexInTexture;
        }
        if (l2 == 0) {
            return Block.stone.blockIndexInTexture;
        }
        int i1 = iblockaccess.getBlockMetadata(i2, j2, k2);
        if (l2 != i1) {
            return this.blockIndexInTexture;
        }
        if (this.isActive) {
            return this.blockIndexInTexture + 16;
        }
        return this.blockIndexInTexture - 1;
    }

    @Override
    public void randomDisplayTick(World world, int i2, int j2, int k2, Random random) {
        if (!this.isActive) {
            return;
        }
        int l2 = world.getBlockMetadata(i2, j2, k2);
        float f2 = (float)i2 + 0.5f;
        float f1 = (float)j2 + 0.0f + random.nextFloat() * 6.0f / 16.0f;
        float f22 = (float)k2 + 0.5f;
        float f3 = 0.52f;
        float f4 = random.nextFloat() * 0.6f - 0.3f;
        if (l2 == 4) {
            world.spawnParticle("smoke", f2 - f3, f1, f22 + f4, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", f2 - f3, f1, f22 + f4, 0.0, 0.0, 0.0);
        } else if (l2 == 5) {
            world.spawnParticle("smoke", f2 + f3, f1, f22 + f4, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", f2 + f3, f1, f22 + f4, 0.0, 0.0, 0.0);
        } else if (l2 == 2) {
            world.spawnParticle("smoke", f2 + f4, f1, f22 - f3, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", f2 + f4, f1, f22 - f3, 0.0, 0.0, 0.0);
        } else if (l2 == 3) {
            world.spawnParticle("smoke", f2 + f4, f1, f22 + f3, 0.0, 0.0, 0.0);
            world.spawnParticle("flame", f2 + f4, f1, f22 + f3, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public int getBlockTextureFromSide(int i2) {
        if (i2 == 1) {
            return Block.stone.blockID;
        }
        if (i2 == 0) {
            return Block.stone.blockID;
        }
        if (i2 == 3) {
            return this.blockIndexInTexture - 1;
        }
        return this.blockIndexInTexture;
    }

    @Override
    public boolean blockActivated(World world, int i2, int j2, int k2, EntityPlayer entityplayer) {
        TileEntityFurnace tileentityfurnace = (TileEntityFurnace)world.getBlockTileEntity(i2, j2, k2);
        entityplayer.displayGUIFurnace(tileentityfurnace);
        return true;
    }

    public static void updateFurnaceBlockState(boolean flag, World world, int i2, int j2, int k2) {
        int l2 = world.getBlockMetadata(i2, j2, k2);
        TileEntity tileentity = world.getBlockTileEntity(i2, j2, k2);
        if (flag) {
            world.setBlockWithNotify(i2, j2, k2, Block.stoneOvenActive.blockID);
        } else {
            world.setBlockWithNotify(i2, j2, k2, Block.stoneOvenIdle.blockID);
        }
        world.setBlockMetadataWithNotify(i2, j2, k2, l2);
        world.setBlockTileEntity(i2, j2, k2, tileentity);
    }

    @Override
    protected TileEntity SetBlockEntity() {
        return new TileEntityFurnace();
    }

    @Override
    public void onBlockPlacedBy(World world, int i2, int j2, int k2, EntityLiving entityliving) {
        int l2 = MathHelper.floor_double((double)(entityliving.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
        if (l2 == 0) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 2);
        }
        if (l2 == 1) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 5);
        }
        if (l2 == 2) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 3);
        }
        if (l2 == 3) {
            world.setBlockMetadataWithNotify(i2, j2, k2, 4);
        }
    }
}

