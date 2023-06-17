/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.SlotInventory;
import net.minecraft.src.TileEntityFurnace;
import org.lwjgl.opengl.GL11;

public class GuiFurnace
extends GuiContainer {
    private TileEntityFurnace field_978_j;

    public GuiFurnace(InventoryPlayer inventoryplayer, TileEntityFurnace tileentityfurnace) {
        this.field_978_j = tileentityfurnace;
        this.inventorySlots.add(new SlotInventory(this, tileentityfurnace, 0, 56, 17));
        this.inventorySlots.add(new SlotInventory(this, tileentityfurnace, 1, 56, 53));
        this.inventorySlots.add(new SlotInventory(this, tileentityfurnace, 2, 116, 35));
        for (int i2 = 0; i2 < 3; ++i2) {
            for (int k2 = 0; k2 < 9; ++k2) {
                this.inventorySlots.add(new SlotInventory(this, inventoryplayer, k2 + (i2 + 1) * 9, 8 + k2 * 18, 84 + i2 * 18));
            }
        }
        for (int j2 = 0; j2 < 9; ++j2) {
            this.inventorySlots.add(new SlotInventory(this, inventoryplayer, j2, 8 + j2 * 18, 142));
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer() {
        this.fontRenderer.drawString("Furnace", 60, 6, 0x404040);
        this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f2) {
        int i2 = this.mc.renderEngine.getTexture("/gui/furnace.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.renderEngine.bindTexture(i2);
        int j2 = (this.width - this.xSize) / 2;
        int k2 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(j2, k2, 0, 0, this.xSize, this.ySize);
        if (this.field_978_j.isBurning()) {
            int l2 = this.field_978_j.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(j2 + 56, k2 + 36 + 12 - l2, 176, 12 - l2, 14, l2 + 2);
        }
        int i1 = this.field_978_j.getCookProgressScaled(24);
        this.drawTexturedModalRect(j2 + 79, k2 + 34, 176, 14, i1 + 1, 16);
    }
}

