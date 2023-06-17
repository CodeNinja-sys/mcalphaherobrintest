/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GuiContainer;
import net.minecraft.src.IInventory;
import net.minecraft.src.SlotInventory;
import org.lwjgl.opengl.GL11;

public class GuiChest
extends GuiContainer {
    private IInventory field_982_j;
    private IInventory field_981_l;
    private int field_980_m = 0;

    public GuiChest(IInventory iinventory, IInventory iinventory1) {
        this.field_982_j = iinventory;
        this.field_981_l = iinventory1;
        this.field_948_f = false;
        int c2 = 222;
        int i2 = c2 - 108;
        this.field_980_m = iinventory1.getSizeInventory() / 9;
        this.ySize = i2 + this.field_980_m * 18;
        int j2 = (this.field_980_m - 4) * 18;
        for (int k2 = 0; k2 < this.field_980_m; ++k2) {
            for (int j1 = 0; j1 < 9; ++j1) {
                this.inventorySlots.add(new SlotInventory(this, iinventory1, j1 + k2 * 9, 8 + j1 * 18, 18 + k2 * 18));
            }
        }
        for (int l2 = 0; l2 < 3; ++l2) {
            for (int k1 = 0; k1 < 9; ++k1) {
                this.inventorySlots.add(new SlotInventory(this, iinventory, k1 + (l2 + 1) * 9, 8 + k1 * 18, 103 + l2 * 18 + j2));
            }
        }
        for (int i1 = 0; i1 < 9; ++i1) {
            this.inventorySlots.add(new SlotInventory(this, iinventory, i1, 8 + i1 * 18, 161 + j2));
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer() {
        this.fontRenderer.drawString(this.field_981_l.getInvName(), 8, 6, 0x404040);
        this.fontRenderer.drawString(this.field_982_j.getInvName(), 8, this.ySize - 96 + 2, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f2) {
        int i2 = this.mc.renderEngine.getTexture("/gui/container.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.renderEngine.bindTexture(i2);
        int j2 = (this.width - this.xSize) / 2;
        int k2 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(j2, k2, 0, 0, this.xSize, this.field_980_m * 18 + 17);
        this.drawTexturedModalRect(j2, k2 + this.field_980_m * 18 + 17, 0, 126, this.xSize, 96);
    }
}

