/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockSnow
extends Block {
    protected BlockSnow(int i2, int j2) {
        super(i2, j2, Material.snow);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.125f, 1.0f);
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
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        int l2 = world.getBlockId(i2, j2 - 1, k2);
        if (l2 == 0 || !Block.blocksList[l2].isOpaqueCube()) {
            return false;
        }
        return world.getBlockMaterial(i2, j2 - 1, k2).func_880_c();
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        this.func_314_h(world, i2, j2, k2);
    }

    private boolean func_314_h(World world, int i2, int j2, int k2) {
        if (!this.canPlaceBlockAt(world, i2, j2, k2)) {
            this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
            world.setBlockWithNotify(i2, j2, k2, 0);
            return false;
        }
        return true;
    }

    @Override
    public void harvestBlock(World world, int i2, int j2, int k2, int l2) {
        int i1 = Item.snowball.shiftedIndex;
        float f2 = 0.7f;
        double d2 = (double)(world.rand.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
        double d1 = (double)(world.rand.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
        double d22 = (double)(world.rand.nextFloat() * f2) + (double)(1.0f - f2) * 0.5;
        EntityItem entityitem = new EntityItem(world, (double)i2 + d2, (double)j2 + d1, (double)k2 + d22, new ItemStack(i1));
        entityitem.field_805_c = 10;
        world.entityJoinedWorld(entityitem);
        world.setBlockWithNotify(i2, j2, k2, 0);
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Item.snowball.shiftedIndex;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        if (world.getSavedLightValue(EnumSkyBlock.Block, i2, j2, k2) > 11) {
            this.dropBlockAsItem(world, i2, j2, k2, world.getBlockMetadata(i2, j2, k2));
            world.setBlockWithNotify(i2, j2, k2, 0);
        }
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        Material material = iblockaccess.getBlockMaterial(i2, j2, k2);
        if (l2 == 1) {
            return true;
        }
        if (material == this.blockMaterial) {
            return false;
        }
        return super.shouldSideBeRendered(iblockaccess, i2, j2, k2, l2);
    }
}

