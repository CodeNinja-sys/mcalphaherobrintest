/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockFurnace;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;

public class TileEntityFurnace
extends TileEntity
implements IInventory {
    private ItemStack[] furnaceItemStacks = new ItemStack[3];
    private int furnaceBurnTime = 0;
    private int currentItemBurnTime = 0;
    private int furnaceCookTime = 0;

    @Override
    public int getSizeInventory() {
        return this.furnaceItemStacks.length;
    }

    @Override
    public ItemStack getStackInSlot(int i2) {
        return this.furnaceItemStacks[i2];
    }

    @Override
    public ItemStack decrStackSize(int i2, int j2) {
        if (this.furnaceItemStacks[i2] != null) {
            if (this.furnaceItemStacks[i2].stackSize <= j2) {
                ItemStack itemstack = this.furnaceItemStacks[i2];
                this.furnaceItemStacks[i2] = null;
                return itemstack;
            }
            ItemStack itemstack1 = this.furnaceItemStacks[i2].splitStack(j2);
            if (this.furnaceItemStacks[i2].stackSize == 0) {
                this.furnaceItemStacks[i2] = null;
            }
            return itemstack1;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int i2, ItemStack itemstack) {
        this.furnaceItemStacks[i2] = itemstack;
        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
            itemstack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInvName() {
        return "Chest";
    }

    @Override
    public void readFromNBT(NBTTagCompound nbttagcompound) {
        super.readFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];
        for (int i2 = 0; i2 < nbttaglist.tagCount(); ++i2) {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i2);
            byte byte0 = nbttagcompound1.getByte("Slot");
            if (byte0 < 0 || byte0 >= this.furnaceItemStacks.length) continue;
            this.furnaceItemStacks[byte0] = new ItemStack(nbttagcompound1);
        }
        this.furnaceBurnTime = nbttagcompound.getShort("BurnTime");
        this.furnaceCookTime = nbttagcompound.getShort("CookTime");
        this.currentItemBurnTime = this.getItemBurnTime(this.furnaceItemStacks[1]);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbttagcompound) {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setShort("BurnTime", (short)this.furnaceBurnTime);
        nbttagcompound.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i2 = 0; i2 < this.furnaceItemStacks.length; ++i2) {
            if (this.furnaceItemStacks[i2] == null) continue;
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound1.setByte("Slot", (byte)i2);
            this.furnaceItemStacks[i2].writeToNBT(nbttagcompound1);
            nbttaglist.setTag(nbttagcompound1);
        }
        nbttagcompound.setTag("Items", nbttaglist);
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public int getCookProgressScaled(int i2) {
        return this.furnaceCookTime * i2 / 200;
    }

    public int getBurnTimeRemainingScaled(int i2) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = 200;
        }
        return this.furnaceBurnTime * i2 / this.currentItemBurnTime;
    }

    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    @Override
    public void updateEntity() {
        boolean flag = this.furnaceBurnTime > 0;
        boolean flag1 = false;
        if (this.furnaceBurnTime > 0) {
            --this.furnaceBurnTime;
        }
        if (!this.worldObj.multiplayerWorld) {
            if (this.furnaceBurnTime == 0 && this.canSmelt()) {
                this.currentItemBurnTime = this.furnaceBurnTime = this.getItemBurnTime(this.furnaceItemStacks[1]);
                if (this.furnaceBurnTime > 0) {
                    flag1 = true;
                    if (this.furnaceItemStacks[1] != null) {
                        --this.furnaceItemStacks[1].stackSize;
                        if (this.furnaceItemStacks[1].stackSize == 0) {
                            this.furnaceItemStacks[1] = null;
                        }
                    }
                }
            }
            if (this.isBurning() && this.canSmelt()) {
                ++this.furnaceCookTime;
                if (this.furnaceCookTime == 200) {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    flag1 = true;
                }
            } else {
                this.furnaceCookTime = 0;
            }
            if (flag != this.furnaceBurnTime > 0) {
                flag1 = true;
                BlockFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }
        if (flag1) {
            this.onInventoryChanged();
        }
    }

    private boolean canSmelt() {
        if (this.furnaceItemStacks[0] == null) {
            return false;
        }
        int i2 = this.getSmeltingResultItem(this.furnaceItemStacks[0].getItem().shiftedIndex);
        if (i2 < 0) {
            return false;
        }
        if (this.furnaceItemStacks[2] == null) {
            return true;
        }
        if (this.furnaceItemStacks[2].itemID != i2) {
            return false;
        }
        if (this.furnaceItemStacks[2].stackSize < this.getInventoryStackLimit() && this.furnaceItemStacks[2].stackSize < this.furnaceItemStacks[2].getMaxStackSize()) {
            return true;
        }
        return this.furnaceItemStacks[2].stackSize < Item.itemsList[i2].getItemStackLimit();
    }

    public void smeltItem() {
        if (!this.canSmelt()) {
            return;
        }
        int i2 = this.getSmeltingResultItem(this.furnaceItemStacks[0].getItem().shiftedIndex);
        if (this.furnaceItemStacks[2] == null) {
            this.furnaceItemStacks[2] = new ItemStack(i2, 1);
        } else if (this.furnaceItemStacks[2].itemID == i2) {
            ++this.furnaceItemStacks[2].stackSize;
        }
        --this.furnaceItemStacks[0].stackSize;
        if (this.furnaceItemStacks[0].stackSize <= 0) {
            this.furnaceItemStacks[0] = null;
        }
    }

    private int getSmeltingResultItem(int i2) {
        if (i2 == Block.oreIron.blockID) {
            return Item.ingotIron.shiftedIndex;
        }
        if (i2 == Block.oreGold.blockID) {
            return Item.ingotGold.shiftedIndex;
        }
        if (i2 == Block.oreDiamond.blockID) {
            return Item.diamond.shiftedIndex;
        }
        if (i2 == Block.sand.blockID) {
            return Block.glass.blockID;
        }
        if (i2 == Item.porkRaw.shiftedIndex) {
            return Item.porkCooked.shiftedIndex;
        }
        if (i2 == Item.fishRaw.shiftedIndex) {
            return Item.fishCooked.shiftedIndex;
        }
        if (i2 == Block.cobblestone.blockID) {
            return Block.stone.blockID;
        }
        if (i2 == Item.clay.shiftedIndex) {
            return Item.brick.shiftedIndex;
        }
        return -1;
    }

    private int getItemBurnTime(ItemStack itemstack) {
        if (itemstack == null) {
            return 0;
        }
        int i2 = itemstack.getItem().shiftedIndex;
        if (i2 < 256 && Block.blocksList[i2].blockMaterial == Material.wood) {
            return 300;
        }
        if (i2 == Item.stick.shiftedIndex) {
            return 100;
        }
        if (i2 == Item.coal.shiftedIndex) {
            return 1600;
        }
        return i2 != Item.bucketLava.shiftedIndex ? 0 : 20000;
    }
}

