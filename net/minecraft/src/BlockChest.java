/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryLargeChest;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.World;

public class BlockChest
extends BlockContainer {
    private Random field_457_a = new Random();

    protected BlockChest(int i2) {
        super(i2, Material.wood);
        this.blockIndexInTexture = 26;
    }

    @Override
    public int getBlockTexture(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        if (l2 == 1) {
            return this.blockIndexInTexture - 1;
        }
        if (l2 == 0) {
            return this.blockIndexInTexture - 1;
        }
        int i1 = iblockaccess.getBlockId(i2, j2, k2 - 1);
        int j1 = iblockaccess.getBlockId(i2, j2, k2 + 1);
        int k1 = iblockaccess.getBlockId(i2 - 1, j2, k2);
        int l1 = iblockaccess.getBlockId(i2 + 1, j2, k2);
        if (i1 == this.blockID || j1 == this.blockID) {
            if (l2 == 2 || l2 == 3) {
                return this.blockIndexInTexture;
            }
            int i22 = 0;
            if (i1 == this.blockID) {
                i22 = -1;
            }
            int k22 = iblockaccess.getBlockId(i2 - 1, j2, i1 != this.blockID ? k2 + 1 : k2 - 1);
            int i3 = iblockaccess.getBlockId(i2 + 1, j2, i1 != this.blockID ? k2 + 1 : k2 - 1);
            if (l2 == 4) {
                i22 = -1 - i22;
            }
            int byte1 = 5;
            if ((Block.opaqueCubeLookup[k1] || Block.opaqueCubeLookup[k22]) && !Block.opaqueCubeLookup[l1] && !Block.opaqueCubeLookup[i3]) {
                byte1 = 5;
            }
            if ((Block.opaqueCubeLookup[l1] || Block.opaqueCubeLookup[i3]) && !Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[k22]) {
                byte1 = 4;
            }
            return (l2 != byte1 ? this.blockIndexInTexture + 32 : this.blockIndexInTexture + 16) + i22;
        }
        if (k1 == this.blockID || l1 == this.blockID) {
            if (l2 == 4 || l2 == 5) {
                return this.blockIndexInTexture;
            }
            int j22 = 0;
            if (k1 == this.blockID) {
                j22 = -1;
            }
            int l22 = iblockaccess.getBlockId(k1 != this.blockID ? i2 + 1 : i2 - 1, j2, k2 - 1);
            int j3 = iblockaccess.getBlockId(k1 != this.blockID ? i2 + 1 : i2 - 1, j2, k2 + 1);
            if (l2 == 3) {
                j22 = -1 - j22;
            }
            int byte2 = 3;
            if ((Block.opaqueCubeLookup[i1] || Block.opaqueCubeLookup[l22]) && !Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[j3]) {
                byte2 = 3;
            }
            if ((Block.opaqueCubeLookup[j1] || Block.opaqueCubeLookup[j3]) && !Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l22]) {
                byte2 = 2;
            }
            return (l2 != byte2 ? this.blockIndexInTexture + 32 : this.blockIndexInTexture + 16) + j22;
        }
        int byte0 = 3;
        if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[j1]) {
            byte0 = 3;
        }
        if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[i1]) {
            byte0 = 2;
        }
        if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[l1]) {
            byte0 = 5;
        }
        if (Block.opaqueCubeLookup[l1] && !Block.opaqueCubeLookup[k1]) {
            byte0 = 4;
        }
        return l2 != byte0 ? this.blockIndexInTexture : this.blockIndexInTexture + 1;
    }

    @Override
    public int getBlockTextureFromSide(int i2) {
        if (i2 == 1) {
            return this.blockIndexInTexture - 1;
        }
        if (i2 == 0) {
            return this.blockIndexInTexture - 1;
        }
        if (i2 == 3) {
            return this.blockIndexInTexture + 1;
        }
        return this.blockIndexInTexture;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i2, int j2, int k2) {
        int l2 = 0;
        if (world.getBlockId(i2 - 1, j2, k2) == this.blockID) {
            ++l2;
        }
        if (world.getBlockId(i2 + 1, j2, k2) == this.blockID) {
            ++l2;
        }
        if (world.getBlockId(i2, j2, k2 - 1) == this.blockID) {
            ++l2;
        }
        if (world.getBlockId(i2, j2, k2 + 1) == this.blockID) {
            ++l2;
        }
        if (l2 > 1) {
            return false;
        }
        if (this.isThereANeighborChest(world, i2 - 1, j2, k2)) {
            return false;
        }
        if (this.isThereANeighborChest(world, i2 + 1, j2, k2)) {
            return false;
        }
        if (this.isThereANeighborChest(world, i2, j2, k2 - 1)) {
            return false;
        }
        return !this.isThereANeighborChest(world, i2, j2, k2 + 1);
    }

    private boolean isThereANeighborChest(World world, int i2, int j2, int k2) {
        if (world.getBlockId(i2, j2, k2) != this.blockID) {
            return false;
        }
        if (world.getBlockId(i2 - 1, j2, k2) == this.blockID) {
            return true;
        }
        if (world.getBlockId(i2 + 1, j2, k2) == this.blockID) {
            return true;
        }
        if (world.getBlockId(i2, j2, k2 - 1) == this.blockID) {
            return true;
        }
        return world.getBlockId(i2, j2, k2 + 1) == this.blockID;
    }

    @Override
    public void onBlockRemoval(World world, int i2, int j2, int k2) {
        TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i2, j2, k2);
        for (int l2 = 0; l2 < tileentitychest.getSizeInventory(); ++l2) {
            ItemStack itemstack = tileentitychest.getStackInSlot(l2);
            if (itemstack == null) continue;
            float f2 = this.field_457_a.nextFloat() * 0.8f + 0.1f;
            float f1 = this.field_457_a.nextFloat() * 0.8f + 0.1f;
            float f22 = this.field_457_a.nextFloat() * 0.8f + 0.1f;
            while (itemstack.stackSize > 0) {
                int i1 = this.field_457_a.nextInt(21) + 10;
                if (i1 > itemstack.stackSize) {
                    i1 = itemstack.stackSize;
                }
                itemstack.stackSize -= i1;
                EntityItem entityitem = new EntityItem(world, (float)i2 + f2, (float)j2 + f1, (float)k2 + f22, new ItemStack(itemstack.itemID, i1, itemstack.itemDamage));
                float f3 = 0.05f;
                entityitem.motionX = (float)this.field_457_a.nextGaussian() * f3;
                entityitem.motionY = (float)this.field_457_a.nextGaussian() * f3 + 0.2f;
                entityitem.motionZ = (float)this.field_457_a.nextGaussian() * f3;
                world.entityJoinedWorld(entityitem);
            }
        }
        super.onBlockRemoval(world, i2, j2, k2);
    }

    @Override
    public boolean blockActivated(World world, int i2, int j2, int k2, EntityPlayer entityplayer) {
        IInventory obj = (TileEntityChest)world.getBlockTileEntity(i2, j2, k2);
        if (world.isBlockOpaqueCube(i2, j2 + 1, k2)) {
            return true;
        }
        if (world.getBlockId(i2 - 1, j2, k2) == this.blockID && world.isBlockOpaqueCube(i2 - 1, j2 + 1, k2)) {
            return true;
        }
        if (world.getBlockId(i2 + 1, j2, k2) == this.blockID && world.isBlockOpaqueCube(i2 + 1, j2 + 1, k2)) {
            return true;
        }
        if (world.getBlockId(i2, j2, k2 - 1) == this.blockID && world.isBlockOpaqueCube(i2, j2 + 1, k2 - 1)) {
            return true;
        }
        if (world.getBlockId(i2, j2, k2 + 1) == this.blockID && world.isBlockOpaqueCube(i2, j2 + 1, k2 + 1)) {
            return true;
        }
        if (world.getBlockId(i2 - 1, j2, k2) == this.blockID) {
            obj = new InventoryLargeChest("Large chest", (TileEntityChest)world.getBlockTileEntity(i2 - 1, j2, k2), obj);
        }
        if (world.getBlockId(i2 + 1, j2, k2) == this.blockID) {
            obj = new InventoryLargeChest("Large chest", obj, (TileEntityChest)world.getBlockTileEntity(i2 + 1, j2, k2));
        }
        if (world.getBlockId(i2, j2, k2 - 1) == this.blockID) {
            obj = new InventoryLargeChest("Large chest", (TileEntityChest)world.getBlockTileEntity(i2, j2, k2 - 1), obj);
        }
        if (world.getBlockId(i2, j2, k2 + 1) == this.blockID) {
            obj = new InventoryLargeChest("Large chest", obj, (TileEntityChest)world.getBlockTileEntity(i2, j2, k2 + 1));
        }
        entityplayer.displayGUIChest(obj);
        return true;
    }

    @Override
    protected TileEntity SetBlockEntity() {
        return new TileEntityChest();
    }
}

