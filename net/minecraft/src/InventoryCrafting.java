/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.CraftingInventoryCB;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;

public class InventoryCrafting
implements IInventory {
    private ItemStack[] stackList;
    private int nbrSlots;
    private CraftingInventoryCB eventHandler;

    public InventoryCrafting(CraftingInventoryCB craftinginventorycb, int i2, int j2) {
        this.nbrSlots = i2 * j2;
        this.stackList = new ItemStack[this.nbrSlots];
        this.eventHandler = craftinginventorycb;
    }

    public InventoryCrafting(CraftingInventoryCB craftinginventorycb, ItemStack[] aitemstack) {
        this.nbrSlots = aitemstack.length;
        this.stackList = aitemstack;
        this.eventHandler = craftinginventorycb;
    }

    @Override
    public int getSizeInventory() {
        return this.nbrSlots;
    }

    @Override
    public ItemStack getStackInSlot(int i2) {
        return this.stackList[i2];
    }

    @Override
    public String getInvName() {
        return "Crafting";
    }

    @Override
    public ItemStack decrStackSize(int i2, int j2) {
        if (this.stackList[i2] != null) {
            if (this.stackList[i2].stackSize <= j2) {
                ItemStack itemstack = this.stackList[i2];
                this.stackList[i2] = null;
                this.eventHandler.onCraftMatrixChanged(this);
                return itemstack;
            }
            ItemStack itemstack1 = this.stackList[i2].splitStack(j2);
            if (this.stackList[i2].stackSize == 0) {
                this.stackList[i2] = null;
            }
            this.eventHandler.onCraftMatrixChanged(this);
            return itemstack1;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int i2, ItemStack itemstack) {
        this.stackList[i2] = itemstack;
        this.eventHandler.onCraftMatrixChanged(this);
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void onInventoryChanged() {
    }
}

