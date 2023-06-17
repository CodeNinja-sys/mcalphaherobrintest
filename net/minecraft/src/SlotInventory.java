/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GuiContainer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Slot;

public class SlotInventory
extends Slot {
    private final GuiContainer guiHandler;
    public final int xPos;
    public final int yPos;

    public SlotInventory(GuiContainer guicontainer, IInventory iinventory, int i2, int j2, int k2) {
        super(iinventory, i2);
        this.guiHandler = guicontainer;
        this.xPos = j2;
        this.yPos = k2;
    }

    public boolean isAtCursorPos(int i2, int j2) {
        int k2 = (this.guiHandler.width - this.guiHandler.xSize) / 2;
        int l2 = (this.guiHandler.height - this.guiHandler.ySize) / 2;
        return (i2 -= k2) >= this.xPos - 1 && i2 < this.xPos + 16 + 1 && (j2 -= l2) >= this.yPos - 1 && j2 < this.yPos + 16 + 1;
    }
}

