/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GuiContainer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.SlotInventory;

public class SlotCrafting
extends SlotInventory {
    private final IInventory craftMatrix;

    public SlotCrafting(GuiContainer guicontainer, IInventory iinventory, IInventory iinventory1, int i2, int j2, int k2) {
        super(guicontainer, iinventory1, i2, j2, k2);
        this.craftMatrix = iinventory;
    }

    @Override
    public boolean isItemValid(ItemStack itemstack) {
        return false;
    }

    @Override
    public void onPickupFromSlot() {
        for (int i2 = 0; i2 < this.craftMatrix.getSizeInventory(); ++i2) {
            if (this.craftMatrix.getStackInSlot(i2) == null) continue;
            this.craftMatrix.decrStackSize(i2, 1);
        }
    }
}

