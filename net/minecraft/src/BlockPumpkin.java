/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class BlockPumpkin
extends Block {
    private boolean field_4072_a;

    protected BlockPumpkin(int i2, int j2, boolean flag) {
        super(i2, Material.pumpkin);
        this.blockIndexInTexture = j2;
        this.setTickOnLoad(true);
        this.field_4072_a = flag;
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int i2, int j2) {
        if (i2 == 1) {
            return this.blockIndexInTexture;
        }
        if (i2 == 0) {
            return this.blockIndexInTexture;
        }
        int k2 = this.blockIndexInTexture + 1 + 16;
        if (this.field_4072_a) {
            ++k2;
        }
        if (j2 == 0 && i2 == 2) {
            return k2;
        }
        if (j2 == 1 && i2 == 5) {
            return k2;
        }
        if (j2 == 2 && i2 == 3) {
            return k2;
        }
        if (j2 == 3 && i2 == 4) {
            return k2;
        }
        return this.blockIndexInTexture + 16;
    }

    @Override
    public int getBlockTextureFromSide(int i2) {
        if (i2 == 1) {
            return this.blockIndexInTexture;
        }
        if (i2 == 0) {
            return this.blockIndexInTexture;
        }
        if (i2 == 3) {
            return this.blockIndexInTexture + 1 + 16;
        }
        return this.blockIndexInTexture + 16;
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
        super.onBlockAdded(world, i2, j2, k2);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockId(i2, j2, k2);
        return (l2 == 0 || Block.blocksList[l2].blockMaterial.getIsLiquid()) && world.isBlockOpaqueCube(i2, j2 - 1, k2);
    }

    @Override
    public void onBlockPlacedBy(World world, int i2, int j2, int k2, EntityLiving entityliving) {
        int l2 = MathHelper.floor_double((double)(entityliving.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
        world.setBlockMetadataWithNotify(i2, j2, k2, l2);
    }
}

