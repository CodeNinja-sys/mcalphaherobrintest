/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;

public class Slot {
    public final int slotIndex;
    public final IInventory inventory;

    public Slot(IInventory iinventory, int i2) {
        this.inventory = iinventory;
        this.slotIndex = i2;
    }

    public void onPickupFromSlot() {
        this.onSlotChanged();
    }

    public boolean isItemValid(ItemStack itemstack) {
        return true;
    }

    public ItemStack getStack() {
        return this.inventory.getStackInSlot(this.slotIndex);
    }

    public void putStack(ItemStack itemstack) {
        this.inventory.setInventorySlotContents(this.slotIndex, itemstack);
        this.onSlotChanged();
    }

    public int func_775_c() {
        return -1;
    }

    public void onSlotChanged() {
        this.inventory.onInventoryChanged();
    }

    public int getSlotStackLimit() {
        return this.inventory.getInventoryStackLimit();
    }
}

