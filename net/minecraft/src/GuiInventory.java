/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.CraftingInventoryPlayerCB;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderManager;
import net.minecraft.src.SlotArmor;
import net.minecraft.src.SlotCrafting;
import net.minecraft.src.SlotInventory;
import org.lwjgl.opengl.GL11;

public class GuiInventory
extends GuiContainer {
    private CraftingInventoryPlayerCB field_977_j;
    private float xSize_lo;
    private float ySize_lo;

    public GuiInventory(IInventory iinventory, ItemStack[] aitemstack) {
        this.field_948_f = true;
        this.field_977_j = new CraftingInventoryPlayerCB(aitemstack);
        this.inventorySlots.add(new SlotCrafting(this, this.field_977_j.craftMatrix, this.field_977_j.craftResult, 0, 144, 36));
        for (int i2 = 0; i2 < 2; ++i2) {
            for (int i1 = 0; i1 < 2; ++i1) {
                this.inventorySlots.add(new SlotInventory(this, this.field_977_j.craftMatrix, i1 + i2 * 2, 88 + i1 * 18, 26 + i2 * 18));
            }
        }
        for (int j2 = 0; j2 < 4; ++j2) {
            int j1 = j2;
            this.inventorySlots.add(new SlotArmor(this, this, iinventory, iinventory.getSizeInventory() - 1 - j2, 8, 8 + j2 * 18, j1));
        }
        for (int k2 = 0; k2 < 3; ++k2) {
            for (int k1 = 0; k1 < 9; ++k1) {
                this.inventorySlots.add(new SlotInventory(this, iinventory, k1 + (k2 + 1) * 9, 8 + k1 * 18, 84 + k2 * 18));
            }
        }
        for (int l2 = 0; l2 < 9; ++l2) {
            this.inventorySlots.add(new SlotInventory(this, iinventory, l2, 8 + l2 * 18, 142));
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer() {
        this.fontRenderer.drawString("Crafting", 86, 16, 0x404040);
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        super.drawScreen(i2, j2, f2);
        this.xSize_lo = i2;
        this.ySize_lo = j2;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f2) {
        int i2 = this.mc.renderEngine.getTexture("/gui/inventory.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.renderEngine.bindTexture(i2);
        int j2 = (this.width - this.xSize) / 2;
        int k2 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(j2, k2, 0, 0, this.xSize, this.ySize);
        GL11.glEnable(32826);
        GL11.glEnable(2903);
        GL11.glPushMatrix();
        GL11.glTranslatef(j2 + 51, k2 + 75, 50.0f);
        float f1 = 30.0f;
        GL11.glScalef(-f1, f1, f1);
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        float f22 = this.mc.thePlayer.field_735_n;
        float f3 = this.mc.thePlayer.rotationYaw;
        float f4 = this.mc.thePlayer.rotationPitch;
        float f5 = (float)(j2 + 51) - this.xSize_lo;
        float f6 = (float)(k2 + 75 - 50) - this.ySize_lo;
        GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-((float)Math.atan(f6 / 40.0f)) * 20.0f, 1.0f, 0.0f, 0.0f);
        this.mc.thePlayer.field_735_n = (float)Math.atan(f5 / 40.0f) * 20.0f;
        this.mc.thePlayer.rotationYaw = (float)Math.atan(f5 / 40.0f) * 40.0f;
        this.mc.thePlayer.rotationPitch = -((float)Math.atan(f6 / 40.0f)) * 20.0f;
        GL11.glTranslatef(0.0f, this.mc.thePlayer.yOffset, 0.0f);
        RenderManager.instance.func_853_a(this.mc.thePlayer, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        this.mc.thePlayer.field_735_n = f22;
        this.mc.thePlayer.rotationYaw = f3;
        this.mc.thePlayer.rotationPitch = f4;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(32826);
    }
}

