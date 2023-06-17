/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockSign
extends BlockContainer {
    private Class signEntityClass;
    private boolean isFreestanding;

    protected BlockSign(int i2, Class class1, boolean flag) {
        super(i2, Material.wood);
        this.isFreestanding = flag;
        this.blockIndexInTexture = 4;
        this.signEntityClass = class1;
        float f2 = 0.25f;
        float f1 = 1.0f;
        this.setBlockBounds(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, f1, 0.5f + f2);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        return null;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        this.setBlockBoundsBasedOnState(world, i2, j2, k2);
        return super.getSelectedBoundingBoxFromPool(world, i2, j2, k2);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        if (this.isFreestanding) {
            return;
        }
        int l2 = iblockaccess.getBlockMetadata(i2, j2, k2);
        float f2 = 0.28125f;
        float f1 = 0.78125f;
        float f22 = 0.0f;
        float f3 = 1.0f;
        float f4 = 0.125f;
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        if (l2 == 2) {
            this.setBlockBounds(f22, f2, 1.0f - f4, f3, f1, 1.0f);
        }
        if (l2 == 3) {
            this.setBlockBounds(f22, f2, 0.0f, f3, f1, f4);
        }
        if (l2 == 4) {
            this.setBlockBounds(1.0f - f4, f2, f22, 1.0f, f1, f3);
        }
        if (l2 == 5) {
            this.setBlockBounds(0.0f, f2, f22, f4, f1, f3);
        }
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    protected TileEntity SetBlockEntity() {
        try {
            return (TileEntity)this.signEntityClass.newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Item.sign.shiftedIndex;
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        boolean flag = false;
        if (this.isFreestanding) {
            if (!world.getBlockMaterial(i2, j2 - 1, k2).func_878_a()) {
                flag = true;
            }
        } else {
            int i1 = world.getBlockMetadata(i2, j2, k2);
            flag = true;
            if (i1 == 2 && world.getBlockMaterial(i2, j2, k2 + 1).func_878_a()) {
                flag = false;
            }
            if (i1 == 3 && world.getBlockMaterial(i2, j2, k2 - 1).func_878_a()) {
                flag = false;
            }
            if (i1 == 4 && world.getBlockMaterial(i2 + 1, j2, k2).func_878_a()) {
                flag = false;
            }
            if (i1 == 5 && world.getBlockMaterial(i2 - 1, j2, k2).func_878_a()) {
                flag = false;
            }
        }
        if (flag) {
            this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
            world.setBlockWithNotify(i2, j2, k2, 0);
        }
        super.onNeighborBlockChange(world, i2, j2, k2, l2);
    }
}

