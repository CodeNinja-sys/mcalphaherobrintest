/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.ChatLine;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Gui;
import net.minecraft.src.GuiChat;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderItem;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.Tessellator;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiIngame
extends Gui {
    private static RenderItem itemRenderer = new RenderItem();
    private List chatMessageList = new ArrayList();
    private Random rand = new Random();
    private Minecraft mc;
    public String field_933_a = null;
    private int updateCounter = 0;
    private String field_9420_i = "";
    private int field_9419_j = 0;
    public float field_6446_b;
    float field_931_c = 1.0f;

    public GuiIngame(Minecraft minecraft) {
        this.mc = minecraft;
    }

    public void renderGameOverlay(float f2, boolean flag, int i2, int j2) {
        boolean flag1;
        float f1;
        ScaledResolution scaledresolution = new ScaledResolution(this.mc.displayWidth, this.mc.displayHeight);
        int k2 = scaledresolution.getScaledWidth();
        int l2 = scaledresolution.getScaledHeight();
        FontRenderer fontrenderer = this.mc.fontRenderer;
        this.mc.field_9243_r.func_905_b();
        GL11.glEnable(3042);
        if (this.mc.gameSettings.fancyGraphics) {
            this.func_4064_a(this.mc.thePlayer.getEntityBrightness(f2), k2, l2);
        }
        ItemStack itemstack = this.mc.thePlayer.inventory.armorItemInSlot(3);
        if (!this.mc.gameSettings.thirdPersonView && itemstack != null && itemstack.itemID == Block.pumpkin.blockID) {
            this.func_4063_a(k2, l2);
        }
        if ((f1 = this.mc.thePlayer.field_4133_d + (this.mc.thePlayer.field_4134_c - this.mc.thePlayer.field_4133_d) * f2) > 0.0f) {
            this.func_4065_b(f1, k2, l2);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/gui/gui.png"));
        InventoryPlayer inventoryplayer = this.mc.thePlayer.inventory;
        this.zLevel = -90.0f;
        this.drawTexturedModalRect(k2 / 2 - 91, l2 - 22, 0, 0, 182, 22);
        this.drawTexturedModalRect(k2 / 2 - 91 - 1 + inventoryplayer.currentItem * 20, l2 - 22 - 1, 0, 22, 24, 22);
        GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/gui/icons.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(775, 769);
        this.drawTexturedModalRect(k2 / 2 - 7, l2 / 2 - 7, 0, 0, 16, 16);
        GL11.glDisable(3042);
        boolean bl2 = flag1 = this.mc.thePlayer.field_9306_bj / 3 % 2 == 1;
        if (this.mc.thePlayer.field_9306_bj < 10) {
            flag1 = false;
        }
        this.mc.gameSettings.difficulty = 0;
        this.mc.gameSettings.renderDistance = 3;
        int i1 = this.mc.thePlayer.health;
        int j1 = this.mc.thePlayer.field_9335_K;
        this.rand.setSeed(this.updateCounter * 312871);
        if (this.mc.field_6327_b.func_6469_d()) {
            int k1 = this.mc.thePlayer.getPlayerArmorValue();
            for (int i22 = 0; i22 < 10; ++i22) {
                int j3 = l2 - 32;
                if (k1 > 0) {
                    int k4 = k2 / 2 + 91 - i22 * 8 - 9;
                    if (i22 * 2 + 1 < k1) {
                        this.drawTexturedModalRect(k4, j3, 34, 9, 9, 9);
                    }
                    if (i22 * 2 + 1 == k1) {
                        this.drawTexturedModalRect(k4, j3, 25, 9, 9, 9);
                    }
                    if (i22 * 2 + 1 > k1) {
                        this.drawTexturedModalRect(k4, j3, 16, 9, 9, 9);
                    }
                }
                int i5 = 0;
                if (flag1) {
                    i5 = 1;
                }
                int k5 = k2 / 2 - 91 + i22 * 8;
                if (i1 <= 4) {
                    j3 += this.rand.nextInt(2);
                }
                this.drawTexturedModalRect(k5, j3, 16 + i5 * 9, 0, 9, 9);
                if (flag1) {
                    if (i22 * 2 + 1 < j1) {
                        this.drawTexturedModalRect(k5, j3, 70, 0, 9, 9);
                    }
                    if (i22 * 2 + 1 == j1) {
                        this.drawTexturedModalRect(k5, j3, 79, 0, 9, 9);
                    }
                }
                if (i22 * 2 + 1 < i1) {
                    this.drawTexturedModalRect(k5, j3, 52, 0, 9, 9);
                }
                if (i22 * 2 + 1 != i1) continue;
                this.drawTexturedModalRect(k5, j3, 61, 0, 9, 9);
            }
            if (this.mc.thePlayer.isInsideOfMaterial(Material.water)) {
                int j22 = (int)Math.ceil((double)(this.mc.thePlayer.air - 2) * 10.0 / 300.0);
                int k3 = (int)Math.ceil((double)this.mc.thePlayer.air * 10.0 / 300.0) - j22;
                for (int j5 = 0; j5 < j22 + k3; ++j5) {
                    if (j5 < j22) {
                        this.drawTexturedModalRect(k2 / 2 - 91 + j5 * 8, l2 - 32 - 9, 16, 18, 9, 9);
                        continue;
                    }
                    this.drawTexturedModalRect(k2 / 2 - 91 + j5 * 8, l2 - 32 - 9, 25, 18, 9, 9);
                }
            }
        }
        GL11.glDisable(3042);
        GL11.glEnable(32826);
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GL11.glPopMatrix();
        for (int l1 = 0; l1 < 9; ++l1) {
            int k22 = k2 / 2 - 90 + l1 * 20 + 2;
            int l3 = l2 - 16 - 3;
            this.func_554_a(l1, k22, l3, f2);
        }
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(32826);
        if (Keyboard.isKeyDown(61)) {
            fontrenderer.drawStringWithShadow("Minecraft Alpha Herobrine Test (" + this.mc.field_6292_I + ")", 2, 2, 0xFFFFFF);
            fontrenderer.drawStringWithShadow(this.mc.func_6241_m(), 2, 12, 0xFFFFFF);
            fontrenderer.drawStringWithShadow(this.mc.func_6262_n(), 2, 22, 0xFFFFFF);
            fontrenderer.drawStringWithShadow(this.mc.func_6245_o(), 2, 32, 0xFFFFFF);
            long l22 = Runtime.getRuntime().maxMemory();
            long l4 = Runtime.getRuntime().totalMemory();
            long l5 = Runtime.getRuntime().freeMemory();
            long l6 = l4 - l5;
            String s2 = "Used memory: " + l6 * 100L / l22 + "% (" + l6 / 1024L / 1024L + "MB) of " + l22 / 1024L / 1024L + "MB";
            this.drawString(fontrenderer, s2, k2 - fontrenderer.getStringWidth(s2) - 2, 2, 0xE0E0E0);
            s2 = "Allocated memory: " + l4 * 100L / l22 + "% (" + l4 / 1024L / 1024L + "MB)";
            this.drawString(fontrenderer, s2, k2 - fontrenderer.getStringWidth(s2) - 2, 12, 0xE0E0E0);
            this.drawString(fontrenderer, "x: " + this.mc.thePlayer.posX, 2, 64, 0xE0E0E0);
            this.drawString(fontrenderer, "y: " + this.mc.thePlayer.posY, 2, 72, 0xE0E0E0);
            this.drawString(fontrenderer, "z: " + this.mc.thePlayer.posZ, 2, 80, 0xE0E0E0);
        } else {
            fontrenderer.drawStringWithShadow("Minecraft Alpha Herobrine Test", 2, 2, 0xFFFFFF);
        }
        if (this.field_9419_j > 0) {
            float f22 = (float)this.field_9419_j - f2;
            int i3 = (int)(f22 * 256.0f / 20.0f);
            if (i3 > 255) {
                i3 = 255;
            }
            if (i3 > 0) {
                GL11.glPushMatrix();
                GL11.glTranslatef(k2 / 2, l2 - 48, 0.0f);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                int i4 = Color.HSBtoRGB(f22 / 50.0f, 0.7f, 0.6f) & 0xFFFFFF;
                fontrenderer.drawString(this.field_9420_i, -fontrenderer.getStringWidth(this.field_9420_i) / 2, -4, i4 + (i3 << 24));
                GL11.glDisable(3042);
                GL11.glPopMatrix();
            }
        }
        int byte0 = 10;
        boolean flag2 = false;
        if (this.mc.currentScreen instanceof GuiChat) {
            byte0 = 20;
            flag2 = true;
        }
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, l2 - 48, 0.0f);
        for (int j4 = 0; j4 < this.chatMessageList.size() && j4 < byte0; ++j4) {
            if (((ChatLine)this.chatMessageList.get((int)j4)).updateCounter >= 200 && !flag2) continue;
            double d2 = (double)((ChatLine)this.chatMessageList.get((int)j4)).updateCounter / 200.0;
            d2 = 1.0 - d2;
            if ((d2 *= 10.0) < 0.0) {
                d2 = 0.0;
            }
            if (d2 > 1.0) {
                d2 = 1.0;
            }
            d2 *= d2;
            int i6 = (int)(255.0 * d2);
            if (flag2) {
                i6 = 255;
            }
            if (i6 <= 0) continue;
            int byte1 = 2;
            int j6 = -j4 * 9;
            String s1 = ((ChatLine)this.chatMessageList.get((int)j4)).message;
            this.drawRect(byte1, j6 - 1, byte1 + 320, j6 + 8, i6 / 2 << 24);
            GL11.glEnable(3042);
            fontrenderer.drawStringWithShadow(s1, byte1, j6, 0xFFFFFF + (i6 << 24));
        }
        GL11.glPopMatrix();
        GL11.glEnable(3008);
        GL11.glDisable(3042);
    }

    private void func_4063_a(int i2, int j2) {
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3008);
        GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("%blur%/misc/pumpkinblur.png"));
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0, j2, -90.0, 0.0, 1.0);
        tessellator.addVertexWithUV(i2, j2, -90.0, 1.0, 1.0);
        tessellator.addVertexWithUV(i2, 0.0, -90.0, 1.0, 0.0);
        tessellator.addVertexWithUV(0.0, 0.0, -90.0, 0.0, 0.0);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void func_4064_a(float f2, int i2, int j2) {
        if ((f2 = 1.0f - f2) < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.field_931_c = (float)((double)this.field_931_c + (double)(f2 - this.field_931_c) * 0.01);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(0, 769);
        GL11.glColor4f(this.field_931_c, this.field_931_c, this.field_931_c, 1.0f);
        GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("%blur%/misc/vignette.png"));
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0, j2, -90.0, 0.0, 1.0);
        tessellator.addVertexWithUV(i2, j2, -90.0, 1.0, 1.0);
        tessellator.addVertexWithUV(i2, 0.0, -90.0, 1.0, 0.0);
        tessellator.addVertexWithUV(0.0, 0.0, -90.0, 0.0, 0.0);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glBlendFunc(770, 771);
    }

    private void func_4065_b(float f2, int i2, int j2) {
        f2 *= f2;
        f2 *= f2;
        f2 = f2 * 0.8f + 0.2f;
        GL11.glDisable(3008);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f2);
        GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/terrain.png"));
        float f1 = (float)(Block.portal.blockIndexInTexture % 16) / 16.0f;
        float f22 = (float)(Block.portal.blockIndexInTexture / 16) / 16.0f;
        float f3 = (float)(Block.portal.blockIndexInTexture % 16 + 1) / 16.0f;
        float f4 = (float)(Block.portal.blockIndexInTexture / 16 + 1) / 16.0f;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0, j2, -90.0, f1, f4);
        tessellator.addVertexWithUV(i2, j2, -90.0, f3, f4);
        tessellator.addVertexWithUV(i2, 0.0, -90.0, f3, f22);
        tessellator.addVertexWithUV(0.0, 0.0, -90.0, f1, f22);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void func_554_a(int i2, int j2, int k2, float f2) {
        ItemStack itemstack = this.mc.thePlayer.inventory.mainInventory[i2];
        if (itemstack == null) {
            return;
        }
        float f1 = (float)itemstack.animationsToGo - f2;
        if (f1 > 0.0f) {
            GL11.glPushMatrix();
            float f22 = 1.0f + f1 / 5.0f;
            GL11.glTranslatef(j2 + 8, k2 + 12, 0.0f);
            GL11.glScalef(1.0f / f22, (f22 + 1.0f) / 2.0f, 1.0f);
            GL11.glTranslatef(-(j2 + 8), -(k2 + 12), 0.0f);
        }
        itemRenderer.renderItemIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, itemstack, j2, k2);
        if (f1 > 0.0f) {
            GL11.glPopMatrix();
        }
        itemRenderer.renderItemOverlayIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, itemstack, j2, k2);
    }

    public void func_555_a() {
        if (this.field_9419_j > 0) {
            --this.field_9419_j;
        }
        ++this.updateCounter;
        for (int i2 = 0; i2 < this.chatMessageList.size(); ++i2) {
            ++((ChatLine)this.chatMessageList.get((int)i2)).updateCounter;
        }
    }

    public void addChatMessage(String s2) {
        while (this.mc.fontRenderer.getStringWidth(s2) > 320) {
            int i2;
            for (i2 = 1; i2 < s2.length() && this.mc.fontRenderer.getStringWidth(s2.substring(0, i2 + 1)) <= 320; ++i2) {
            }
            this.addChatMessage(s2.substring(0, i2));
            s2 = s2.substring(i2);
        }
        this.chatMessageList.add(0, new ChatLine(s2));
        while (this.chatMessageList.size() > 50) {
            this.chatMessageList.remove(this.chatMessageList.size() - 1);
        }
    }

    public void func_553_b(String s2) {
        this.field_9420_i = "Now playing: " + s2;
        this.field_9419_j = 60;
    }
}

