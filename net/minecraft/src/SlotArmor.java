/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.GuiInventory;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraft.src.SlotInventory;

class SlotArmor
extends SlotInventory {
    final int field_1124_c;
    final GuiInventory field_1123_d;

    SlotArmor(GuiInventory guiinventory, GuiContainer guicontainer, IInventory iinventory, int i2, int j2, int k2, int l2) {
        super(guicontainer, iinventory, i2, j2, k2);
        this.field_1123_d = guiinventory;
        this.field_1124_c = l2;
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }

    @Override
    public boolean isItemValid(ItemStack itemstack) {
        if (itemstack.getItem() instanceof ItemArmor) {
            return ((ItemArmor)itemstack.getItem()).armorType == this.field_1124_c;
        }
        System.out.println(itemstack.getItem().shiftedIndex + ", " + this.field_1124_c);
        if (itemstack.getItem().shiftedIndex == Block.pumpkin.blockID) {
            return this.field_1124_c == 0;
        }
        return false;
    }

    @Override
    public int func_775_c() {
        return 15 + this.field_1124_c * 16;
    }
}

