/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;

public class TileEntityChest
extends TileEntity
implements IInventory {
    private ItemStack[] field_827_a = new ItemStack[36];

    @Override
    public int getSizeInventory() {
        return 27;
    }

    @Override
    public ItemStack getStackInSlot(int i2) {
        return this.field_827_a[i2];
    }

    @Override
    public ItemStack decrStackSize(int i2, int j2) {
        if (this.field_827_a[i2] != null) {
            if (this.field_827_a[i2].stackSize <= j2) {
                ItemStack itemstack = this.field_827_a[i2];
                this.field_827_a[i2] = null;
                this.onInventoryChanged();
                return itemstack;
            }
            ItemStack itemstack1 = this.field_827_a[i2].splitStack(j2);
            if (this.field_827_a[i2].stackSize == 0) {
                this.field_827_a[i2] = null;
            }
            this.onInventoryChanged();
            return itemstack1;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int i2, ItemStack itemstack) {
        this.field_827_a[i2] = itemstack;
        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
            itemstack.stackSize = this.getInventoryStackLimit();
        }
        this.onInventoryChanged();
    }

    @Override
    public String getInvName() {
        return "Chest";
    }

    @Override
    public void readFromNBT(NBTTagCompound nbttagcompound) {
        super.readFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
        this.field_827_a = new ItemStack[this.getSizeInventory()];
        for (int i2 = 0; i2 < nbttaglist.tagCount(); ++i2) {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i2);
            int j2 = nbttagcompound1.getByte("Slot") & 0xFF;
            if (j2 < 0 || j2 >= this.field_827_a.length) continue;
            this.field_827_a[j2] = new ItemStack(nbttagcompound1);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbttagcompound) {
        super.writeToNBT(nbttagcompound);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i2 = 0; i2 < this.field_827_a.length; ++i2) {
            if (this.field_827_a[i2] == null) continue;
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound1.setByte("Slot", (byte)i2);
            this.field_827_a[i2].writeToNBT(nbttagcompound1);
            nbttaglist.setTag(nbttagcompound1);
        }
        nbttagcompound.setTag("Items", nbttaglist);
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
}

