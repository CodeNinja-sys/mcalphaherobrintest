/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;

public class InventoryCraftResult
implements IInventory {
    private ItemStack[] stackResult = new ItemStack[1];

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int i2) {
        return this.stackResult[i2];
    }

    @Override
    public String getInvName() {
        return "Result";
    }

    @Override
    public ItemStack decrStackSize(int i2, int j2) {
        if (this.stackResult[i2] != null) {
            ItemStack itemstack = this.stackResult[i2];
            this.stackResult[i2] = null;
            return itemstack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int i2, ItemStack itemstack) {
        this.stackResult[i2] = itemstack;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void onInventoryChanged() {
    }
}

