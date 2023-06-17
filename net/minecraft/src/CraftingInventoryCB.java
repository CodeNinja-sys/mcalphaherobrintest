/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryPlayer;

public class CraftingInventoryCB {
    protected List unusedList = new ArrayList();

    public void onCraftGuiClosed(EntityPlayer entityplayer) {
        InventoryPlayer inventoryplayer = entityplayer.inventory;
        if (inventoryplayer.draggingItemStack != null) {
            entityplayer.dropPlayerItem(inventoryplayer.draggingItemStack);
        }
    }

    public void onCraftMatrixChanged(IInventory iinventory) {
    }
}

