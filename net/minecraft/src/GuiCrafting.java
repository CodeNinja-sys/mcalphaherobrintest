/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.CraftingInventoryWorkbenchCB;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.SlotCrafting;
import net.minecraft.src.SlotInventory;
import org.lwjgl.opengl.GL11;

public class GuiCrafting
extends GuiContainer {
    public CraftingInventoryWorkbenchCB field_979_j = new CraftingInventoryWorkbenchCB();

    public GuiCrafting(InventoryPlayer inventoryplayer) {
        this.inventorySlots.add(new SlotCrafting(this, this.field_979_j.craftMatrix, this.field_979_j.craftResult, 0, 124, 35));
        for (int i2 = 0; i2 < 3; ++i2) {
            for (int l2 = 0; l2 < 3; ++l2) {
                this.inventorySlots.add(new SlotInventory(this, this.field_979_j.craftMatrix, l2 + i2 * 3, 30 + l2 * 18, 17 + i2 * 18));
            }
        }
        for (int j2 = 0; j2 < 3; ++j2) {
            for (int i1 = 0; i1 < 9; ++i1) {
                this.inventorySlots.add(new SlotInventory(this, inventoryplayer, i1 + (j2 + 1) * 9, 8 + i1 * 18, 84 + j2 * 18));
            }
        }
        for (int k2 = 0; k2 < 9; ++k2) {
            this.inventorySlots.add(new SlotInventory(this, inventoryplayer, k2, 8 + k2 * 18, 142));
        }
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        this.field_979_j.onCraftGuiClosed(this.mc.thePlayer);
    }

    @Override
    protected void drawGuiContainerForegroundLayer() {
        this.fontRenderer.drawString("Crafting", 28, 6, 0x404040);
        this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 2, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f2) {
        int i2 = this.mc.renderEngine.getTexture("/gui/crafting.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.renderEngine.bindTexture(i2);
        int j2 = (this.width - this.xSize) / 2;
        int k2 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(j2, k2, 0, 0, this.xSize, this.ySize);
    }
}

