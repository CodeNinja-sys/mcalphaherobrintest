/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.CraftingInventoryCB;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryCraftResult;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.ItemStack;

public class CraftingInventoryWorkbenchCB
extends CraftingInventoryCB {
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    public IInventory craftResult = new InventoryCraftResult();

    @Override
    public void onCraftMatrixChanged(IInventory iinventory) {
        int[] ai2 = new int[9];
        for (int i2 = 0; i2 < 3; ++i2) {
            for (int j2 = 0; j2 < 3; ++j2) {
                int k2 = i2 + j2 * 3;
                ItemStack itemstack = this.craftMatrix.getStackInSlot(k2);
                ai2[k2] = itemstack == null ? -1 : itemstack.itemID;
            }
        }
        this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().craft(ai2));
    }

    @Override
    public void onCraftGuiClosed(EntityPlayer entityplayer) {
        super.onCraftGuiClosed(entityplayer);
        for (int i2 = 0; i2 < 9; ++i2) {
            ItemStack itemstack = this.craftMatrix.getStackInSlot(i2);
            if (itemstack == null) continue;
            entityplayer.dropPlayerItem(itemstack);
        }
    }
}

