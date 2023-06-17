/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;

public class InventoryLargeChest
implements IInventory {
    private String name;
    private IInventory upperChest;
    private IInventory lowerChest;

    public InventoryLargeChest(String s2, IInventory iinventory, IInventory iinventory1) {
        this.name = s2;
        this.upperChest = iinventory;
        this.lowerChest = iinventory1;
    }

    @Override
    public int getSizeInventory() {
        return this.upperChest.getSizeInventory() + this.lowerChest.getSizeInventory();
    }

    @Override
    public String getInvName() {
        return this.name;
    }

    @Override
    public ItemStack getStackInSlot(int i2) {
        if (i2 >= this.upperChest.getSizeInventory()) {
            return this.lowerChest.getStackInSlot(i2 - this.upperChest.getSizeInventory());
        }
        return this.upperChest.getStackInSlot(i2);
    }

    @Override
    public ItemStack decrStackSize(int i2, int j2) {
        if (i2 >= this.upperChest.getSizeInventory()) {
            return this.lowerChest.decrStackSize(i2 - this.upperChest.getSizeInventory(), j2);
        }
        return this.upperChest.decrStackSize(i2, j2);
    }

    @Override
    public void setInventorySlotContents(int i2, ItemStack itemstack) {
        if (i2 >= this.upperChest.getSizeInventory()) {
            this.lowerChest.setInventorySlotContents(i2 - this.upperChest.getSizeInventory(), itemstack);
        } else {
            this.upperChest.setInventorySlotContents(i2, itemstack);
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return this.upperChest.getInventoryStackLimit();
    }

    @Override
    public void onInventoryChanged() {
        this.upperChest.onInventoryChanged();
        this.lowerChest.onInventoryChanged();
    }
}

