/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderItem;
import net.minecraft.src.Slot;
import net.minecraft.src.SlotInventory;
import org.lwjgl.opengl.GL11;

public abstract class GuiContainer
extends GuiScreen {
    private static RenderItem itemRenderer = new RenderItem();
    protected int xSize = 176;
    protected int ySize = 166;
    protected List inventorySlots = new ArrayList();

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawDefaultBackground();
        int k2 = (this.width - this.xSize) / 2;
        int l2 = (this.height - this.ySize) / 2;
        this.drawGuiContainerBackgroundLayer(f2);
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(k2, l2, 0.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(32826);
        for (int i1 = 0; i1 < this.inventorySlots.size(); ++i1) {
            SlotInventory slotinventory = (SlotInventory)this.inventorySlots.get(i1);
            this.drawSlotInventory(slotinventory);
            if (!slotinventory.isAtCursorPos(i2, j2)) continue;
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            int j1 = slotinventory.xPos;
            int k1 = slotinventory.yPos;
            this.drawGradientRect(j1, k1, j1 + 16, k1 + 16, -2130706433, -2130706433);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
        }
        InventoryPlayer inventoryplayer = this.mc.thePlayer.inventory;
        if (inventoryplayer.draggingItemStack != null) {
            GL11.glTranslatef(0.0f, 0.0f, 32.0f);
            itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, inventoryplayer.draggingItemStack, i2 - k2 - 8, j2 - l2 - 8);
            itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, inventoryplayer.draggingItemStack, i2 - k2 - 8, j2 - l2 - 8);
        }
        GL11.glDisable(32826);
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        this.drawGuiContainerForegroundLayer();
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        GL11.glPopMatrix();
    }

    protected void drawGuiContainerForegroundLayer() {
    }

    protected abstract void drawGuiContainerBackgroundLayer(float var1);

    private void drawSlotInventory(SlotInventory slotinventory) {
        int l2;
        IInventory iinventory = slotinventory.inventory;
        int i2 = slotinventory.slotIndex;
        int j2 = slotinventory.xPos;
        int k2 = slotinventory.yPos;
        ItemStack itemstack = iinventory.getStackInSlot(i2);
        if (itemstack == null && (l2 = slotinventory.func_775_c()) >= 0) {
            GL11.glDisable(2896);
            this.mc.renderEngine.bindTexture(this.mc.renderEngine.getTexture("/gui/items.png"));
            this.drawTexturedModalRect(j2, k2, l2 % 16 * 16, l2 / 16 * 16, 16, 16);
            GL11.glEnable(2896);
            return;
        }
        itemRenderer.renderItemIntoGUI(this.fontRenderer, this.mc.renderEngine, itemstack, j2, k2);
        itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, itemstack, j2, k2);
    }

    private Slot getSlotAtPosition(int i2, int j2) {
        for (int k2 = 0; k2 < this.inventorySlots.size(); ++k2) {
            SlotInventory slotinventory = (SlotInventory)this.inventorySlots.get(k2);
            if (!slotinventory.isAtCursorPos(i2, j2)) continue;
            return slotinventory;
        }
        return null;
    }

    @Override
    protected void mouseClicked(int i2, int j2, int k2) {
        if (k2 == 0 || k2 == 1) {
            Slot slot = this.getSlotAtPosition(i2, j2);
            InventoryPlayer inventoryplayer = this.mc.thePlayer.inventory;
            if (slot != null) {
                ItemStack itemstack = slot.getStack();
                if (itemstack != null || inventoryplayer.draggingItemStack != null) {
                    if (itemstack != null && inventoryplayer.draggingItemStack == null) {
                        int i1 = k2 != 0 ? (itemstack.stackSize + 1) / 2 : itemstack.stackSize;
                        inventoryplayer.draggingItemStack = slot.inventory.decrStackSize(slot.slotIndex, i1);
                        if (itemstack.stackSize == 0) {
                            slot.putStack(null);
                        }
                        slot.onPickupFromSlot();
                    } else if (itemstack == null && inventoryplayer.draggingItemStack != null && slot.isItemValid(inventoryplayer.draggingItemStack)) {
                        int j1;
                        int n2 = j1 = k2 != 0 ? 1 : inventoryplayer.draggingItemStack.stackSize;
                        if (j1 > slot.getSlotStackLimit()) {
                            j1 = slot.getSlotStackLimit();
                        }
                        slot.putStack(inventoryplayer.draggingItemStack.splitStack(j1));
                        if (inventoryplayer.draggingItemStack.stackSize == 0) {
                            inventoryplayer.draggingItemStack = null;
                        }
                    } else if (itemstack != null && inventoryplayer.draggingItemStack != null) {
                        int i22;
                        if (slot.isItemValid(inventoryplayer.draggingItemStack)) {
                            if (itemstack.itemID != inventoryplayer.draggingItemStack.itemID) {
                                if (inventoryplayer.draggingItemStack.stackSize <= slot.getSlotStackLimit()) {
                                    ItemStack itemstack1 = itemstack;
                                    slot.putStack(inventoryplayer.draggingItemStack);
                                    inventoryplayer.draggingItemStack = itemstack1;
                                }
                            } else if (itemstack.itemID == inventoryplayer.draggingItemStack.itemID) {
                                if (k2 == 0) {
                                    int k1 = inventoryplayer.draggingItemStack.stackSize;
                                    if (k1 > slot.getSlotStackLimit() - itemstack.stackSize) {
                                        k1 = slot.getSlotStackLimit() - itemstack.stackSize;
                                    }
                                    if (k1 > inventoryplayer.draggingItemStack.getMaxStackSize() - itemstack.stackSize) {
                                        k1 = inventoryplayer.draggingItemStack.getMaxStackSize() - itemstack.stackSize;
                                    }
                                    inventoryplayer.draggingItemStack.splitStack(k1);
                                    if (inventoryplayer.draggingItemStack.stackSize == 0) {
                                        inventoryplayer.draggingItemStack = null;
                                    }
                                    itemstack.stackSize += k1;
                                } else if (k2 == 1) {
                                    int l1 = 1;
                                    if (l1 > slot.getSlotStackLimit() - itemstack.stackSize) {
                                        l1 = slot.getSlotStackLimit() - itemstack.stackSize;
                                    }
                                    if (l1 > inventoryplayer.draggingItemStack.getMaxStackSize() - itemstack.stackSize) {
                                        l1 = inventoryplayer.draggingItemStack.getMaxStackSize() - itemstack.stackSize;
                                    }
                                    inventoryplayer.draggingItemStack.splitStack(l1);
                                    if (inventoryplayer.draggingItemStack.stackSize == 0) {
                                        inventoryplayer.draggingItemStack = null;
                                    }
                                    itemstack.stackSize += l1;
                                }
                            }
                        } else if (itemstack.itemID == inventoryplayer.draggingItemStack.itemID && inventoryplayer.draggingItemStack.getMaxStackSize() > 1 && (i22 = itemstack.stackSize) > 0 && i22 + inventoryplayer.draggingItemStack.stackSize <= inventoryplayer.draggingItemStack.getMaxStackSize()) {
                            inventoryplayer.draggingItemStack.stackSize += i22;
                            itemstack.splitStack(i22);
                            if (itemstack.stackSize == 0) {
                                slot.putStack(null);
                            }
                            slot.onPickupFromSlot();
                        }
                    }
                }
                slot.onSlotChanged();
            } else if (inventoryplayer.draggingItemStack != null) {
                int l2 = (this.width - this.xSize) / 2;
                int j22 = (this.height - this.ySize) / 2;
                if (i2 < l2 || j2 < j22 || i2 >= l2 + this.xSize || j2 >= j22 + this.xSize) {
                    EntityPlayerSP entityplayersp = this.mc.thePlayer;
                    if (k2 == 0) {
                        entityplayersp.dropPlayerItem(inventoryplayer.draggingItemStack);
                        inventoryplayer.draggingItemStack = null;
                    }
                    if (k2 == 1) {
                        entityplayersp.dropPlayerItem(inventoryplayer.draggingItemStack.splitStack(1));
                        if (inventoryplayer.draggingItemStack.stackSize == 0) {
                            inventoryplayer.draggingItemStack = null;
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void mouseMovedOrUp(int i2, int j2, int k2) {
        if (k2 != 0) {
            // empty if block
        }
    }

    @Override
    protected void keyTyped(char c2, int i2) {
        if (i2 == 1 || i2 == this.mc.gameSettings.keyBindInventory.keyCode) {
            this.mc.displayGuiScreen(null);
        }
    }

    @Override
    public void onGuiClosed() {
        if (this.mc.thePlayer == null) {
            return;
        }
        InventoryPlayer inventoryplayer = this.mc.thePlayer.inventory;
        if (inventoryplayer.draggingItemStack != null) {
            this.mc.thePlayer.dropPlayerItem(inventoryplayer.draggingItemStack);
            inventoryplayer.draggingItemStack = null;
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}

