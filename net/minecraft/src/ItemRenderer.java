/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Render;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderManager;
import net.minecraft.src.RenderPlayer;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class ItemRenderer {
    private Minecraft mc;
    private ItemStack field_9451_b = null;
    private float field_9453_c = 0.0f;
    private float field_9452_d = 0.0f;
    private RenderBlocks field_1357_e = new RenderBlocks();

    public ItemRenderer(Minecraft minecraft) {
        this.mc = minecraft;
    }

    public void renderItem(ItemStack itemstack) {
        GL11.glPushMatrix();
        if (itemstack.itemID < 256 && RenderBlocks.func_1219_a(Block.blocksList[itemstack.itemID].getRenderType())) {
            GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/terrain.png"));
            this.field_1357_e.func_1227_a(Block.blocksList[itemstack.itemID]);
        } else {
            if (itemstack.itemID < 256) {
                GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/terrain.png"));
            } else {
                GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/gui/items.png"));
            }
            Tessellator tessellator = Tessellator.instance;
            float f2 = ((float)(itemstack.getIconIndex() % 16 * 16) + 0.0f) / 256.0f;
            float f1 = ((float)(itemstack.getIconIndex() % 16 * 16) + 15.99f) / 256.0f;
            float f22 = ((float)(itemstack.getIconIndex() / 16 * 16) + 0.0f) / 256.0f;
            float f3 = ((float)(itemstack.getIconIndex() / 16 * 16) + 15.99f) / 256.0f;
            float f4 = 1.0f;
            float f5 = 0.0f;
            float f6 = 0.3f;
            GL11.glEnable(32826);
            GL11.glTranslatef(-f5, -f6, 0.0f);
            float f7 = 1.5f;
            GL11.glScalef(f7, f7, f7);
            GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(335.0f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-0.9375f, -0.0625f, 0.0f);
            float f8 = 0.0625f;
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, 1.0f);
            tessellator.addVertexWithUV(0.0, 0.0, 0.0, f1, f3);
            tessellator.addVertexWithUV(f4, 0.0, 0.0, f2, f3);
            tessellator.addVertexWithUV(f4, 1.0, 0.0, f2, f22);
            tessellator.addVertexWithUV(0.0, 1.0, 0.0, f1, f22);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, -1.0f);
            tessellator.addVertexWithUV(0.0, 1.0, 0.0f - f8, f1, f22);
            tessellator.addVertexWithUV(f4, 1.0, 0.0f - f8, f2, f22);
            tessellator.addVertexWithUV(f4, 0.0, 0.0f - f8, f2, f3);
            tessellator.addVertexWithUV(0.0, 0.0, 0.0f - f8, f1, f3);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0f, 0.0f, 0.0f);
            for (int i2 = 0; i2 < 16; ++i2) {
                float f9 = (float)i2 / 16.0f;
                float f13 = f1 + (f2 - f1) * f9 - 0.001953125f;
                float f17 = f4 * f9;
                tessellator.addVertexWithUV(f17, 0.0, 0.0f - f8, f13, f3);
                tessellator.addVertexWithUV(f17, 0.0, 0.0, f13, f3);
                tessellator.addVertexWithUV(f17, 1.0, 0.0, f13, f22);
                tessellator.addVertexWithUV(f17, 1.0, 0.0f - f8, f13, f22);
            }
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0f, 0.0f, 0.0f);
            for (int j2 = 0; j2 < 16; ++j2) {
                float f10 = (float)j2 / 16.0f;
                float f14 = f1 + (f2 - f1) * f10 - 0.001953125f;
                float f18 = f4 * f10 + 0.0625f;
                tessellator.addVertexWithUV(f18, 1.0, 0.0f - f8, f14, f22);
                tessellator.addVertexWithUV(f18, 1.0, 0.0, f14, f22);
                tessellator.addVertexWithUV(f18, 0.0, 0.0, f14, f3);
                tessellator.addVertexWithUV(f18, 0.0, 0.0f - f8, f14, f3);
            }
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 1.0f, 0.0f);
            for (int k2 = 0; k2 < 16; ++k2) {
                float f11 = (float)k2 / 16.0f;
                float f15 = f3 + (f22 - f3) * f11 - 0.001953125f;
                float f19 = f4 * f11 + 0.0625f;
                tessellator.addVertexWithUV(0.0, f19, 0.0, f1, f15);
                tessellator.addVertexWithUV(f4, f19, 0.0, f2, f15);
                tessellator.addVertexWithUV(f4, f19, 0.0f - f8, f2, f15);
                tessellator.addVertexWithUV(0.0, f19, 0.0f - f8, f1, f15);
            }
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            for (int l2 = 0; l2 < 16; ++l2) {
                float f12 = (float)l2 / 16.0f;
                float f16 = f3 + (f22 - f3) * f12 - 0.001953125f;
                float f20 = f4 * f12;
                tessellator.addVertexWithUV(f4, f20, 0.0, f2, f16);
                tessellator.addVertexWithUV(0.0, f20, 0.0, f1, f16);
                tessellator.addVertexWithUV(0.0, f20, 0.0f - f8, f1, f16);
                tessellator.addVertexWithUV(f4, f20, 0.0f - f8, f2, f16);
            }
            tessellator.draw();
            GL11.glDisable(32826);
        }
        GL11.glPopMatrix();
    }

    public void renderItemInFirstPerson(float f2) {
        float f1 = this.field_9452_d + (this.field_9453_c - this.field_9452_d) * f2;
        EntityPlayerSP entityplayersp = this.mc.thePlayer;
        GL11.glPushMatrix();
        GL11.glRotatef(entityplayersp.prevRotationPitch + (entityplayersp.rotationPitch - entityplayersp.prevRotationPitch) * f2, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(entityplayersp.prevRotationYaw + (entityplayersp.rotationYaw - entityplayersp.prevRotationYaw) * f2, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GL11.glPopMatrix();
        float f22 = this.mc.theWorld.getLightBrightness(MathHelper.floor_double(entityplayersp.posX), MathHelper.floor_double(entityplayersp.posY), MathHelper.floor_double(entityplayersp.posZ));
        GL11.glColor4f(f22, f22, f22, 1.0f);
        ItemStack itemstack = this.field_9451_b;
        if (entityplayersp.fishEntity != null) {
            itemstack = new ItemStack(Item.stick.shiftedIndex);
        }
        if (itemstack != null) {
            GL11.glPushMatrix();
            float f3 = 0.8f;
            float f5 = entityplayersp.getSwingProgress(f2);
            float f7 = MathHelper.sin(f5 * 3.141593f);
            float f9 = MathHelper.sin(MathHelper.sqrt_float(f5) * 3.141593f);
            GL11.glTranslatef(-f9 * 0.4f, MathHelper.sin(MathHelper.sqrt_float(f5) * 3.141593f * 2.0f) * 0.2f, -f7 * 0.2f);
            GL11.glTranslatef(0.7f * f3, -0.65f * f3 - (1.0f - f1) * 0.6f, -0.9f * f3);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glEnable(32826);
            f5 = entityplayersp.getSwingProgress(f2);
            f7 = MathHelper.sin(f5 * f5 * 3.141593f);
            f9 = MathHelper.sin(MathHelper.sqrt_float(f5) * 3.141593f);
            GL11.glRotatef(-f7 * 20.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-f9 * 20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-f9 * 80.0f, 1.0f, 0.0f, 0.0f);
            f5 = 0.4f;
            GL11.glScalef(f5, f5, f5);
            if (itemstack.getItem().shouldRotateAroundWhenRendering()) {
                GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            }
            this.renderItem(itemstack);
            GL11.glPopMatrix();
        } else {
            GL11.glPushMatrix();
            float f4 = 0.8f;
            float f6 = entityplayersp.getSwingProgress(f2);
            float f8 = MathHelper.sin(f6 * 3.141593f);
            float f10 = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.141593f);
            GL11.glTranslatef(-f10 * 0.3f, MathHelper.sin(MathHelper.sqrt_float(f6) * 3.141593f * 2.0f) * 0.4f, -f8 * 0.4f);
            GL11.glTranslatef(0.8f * f4, -0.75f * f4 - (1.0f - f1) * 0.6f, -0.9f * f4);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glEnable(32826);
            f6 = entityplayersp.getSwingProgress(f2);
            f8 = MathHelper.sin(f6 * f6 * 3.141593f);
            f10 = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.141593f);
            GL11.glRotatef(f10 * 70.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-f8 * 20.0f, 0.0f, 0.0f, 1.0f);
            GL11.glBindTexture(3553, this.mc.renderEngine.getTextureForDownloadableImage(this.mc.thePlayer.skinUrl, this.mc.thePlayer.getEntityTexture()));
            GL11.glTranslatef(-1.0f, 3.6f, 3.5f);
            GL11.glRotatef(120.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(200.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(-135.0f, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            GL11.glTranslatef(5.6f, 0.0f, 0.0f);
            Render render = RenderManager.instance.func_855_a(this.mc.thePlayer);
            RenderPlayer renderplayer = (RenderPlayer)render;
            f10 = 1.0f;
            GL11.glScalef(f10, f10, f10);
            renderplayer.drawFirstPersonHand();
            GL11.glPopMatrix();
        }
        GL11.glDisable(32826);
        RenderHelper.disableStandardItemLighting();
    }

    public void renderOverlays(float f2) {
        GL11.glDisable(3008);
        if (this.mc.thePlayer.fire > 0 || this.mc.thePlayer.field_9299_bv) {
            int i2 = this.mc.renderEngine.getTexture("/terrain.png");
            GL11.glBindTexture(3553, i2);
            this.renderFireInFirstPerson(f2);
        }
        if (this.mc.thePlayer.func_345_I()) {
            int j2 = MathHelper.floor_double(this.mc.thePlayer.posX);
            int l2 = MathHelper.floor_double(this.mc.thePlayer.posY);
            int i1 = MathHelper.floor_double(this.mc.thePlayer.posZ);
            int j1 = this.mc.renderEngine.getTexture("/terrain.png");
            GL11.glBindTexture(3553, j1);
            int k1 = this.mc.theWorld.getBlockId(j2, l2, i1);
            if (Block.blocksList[k1] != null) {
                this.renderInsideOfBlock(f2, Block.blocksList[k1].getBlockTextureFromSide(2));
            }
        }
        if (this.mc.thePlayer.isInsideOfMaterial(Material.water)) {
            int k2 = this.mc.renderEngine.getTexture("/misc/water.png");
            GL11.glBindTexture(3553, k2);
            this.renderWarpedTextureOverlay(f2);
        }
        GL11.glEnable(3008);
    }

    private void renderInsideOfBlock(float f2, int i2) {
        Tessellator tessellator = Tessellator.instance;
        float f1 = this.mc.thePlayer.getEntityBrightness(f2);
        f1 = 0.1f;
        GL11.glColor4f(f1, f1, f1, 0.5f);
        GL11.glPushMatrix();
        float f22 = -1.0f;
        float f3 = 1.0f;
        float f4 = -1.0f;
        float f5 = 1.0f;
        float f6 = -0.5f;
        float f7 = 0.0078125f;
        float f8 = (float)(i2 % 16) / 256.0f - f7;
        float f9 = ((float)(i2 % 16) + 15.99f) / 256.0f + f7;
        float f10 = (float)(i2 / 16) / 256.0f - f7;
        float f11 = ((float)(i2 / 16) + 15.99f) / 256.0f + f7;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(f22, f4, f6, f9, f11);
        tessellator.addVertexWithUV(f3, f4, f6, f8, f11);
        tessellator.addVertexWithUV(f3, f5, f6, f8, f10);
        tessellator.addVertexWithUV(f22, f5, f6, f9, f10);
        tessellator.draw();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void renderWarpedTextureOverlay(float f2) {
        Tessellator tessellator = Tessellator.instance;
        float f1 = this.mc.thePlayer.getEntityBrightness(f2);
        GL11.glColor4f(f1, f1, f1, 0.5f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glPushMatrix();
        float f22 = 4.0f;
        float f3 = -1.0f;
        float f4 = 1.0f;
        float f5 = -1.0f;
        float f6 = 1.0f;
        float f7 = -0.5f;
        float f8 = -this.mc.thePlayer.rotationYaw / 64.0f;
        float f9 = this.mc.thePlayer.rotationPitch / 64.0f;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(f3, f5, f7, f22 + f8, f22 + f9);
        tessellator.addVertexWithUV(f4, f5, f7, 0.0f + f8, f22 + f9);
        tessellator.addVertexWithUV(f4, f6, f7, 0.0f + f8, 0.0f + f9);
        tessellator.addVertexWithUV(f3, f6, f7, f22 + f8, 0.0f + f9);
        tessellator.draw();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
    }

    private void renderFireInFirstPerson(float f2) {
        Tessellator tessellator = Tessellator.instance;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.9f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        float f1 = 1.0f;
        for (int i2 = 0; i2 < 2; ++i2) {
            GL11.glPushMatrix();
            int j2 = Block.fire.blockIndexInTexture + i2 * 16;
            int k2 = (j2 & 0xF) << 4;
            int l2 = j2 & 0xF0;
            float f22 = (float)k2 / 256.0f;
            float f3 = ((float)k2 + 15.99f) / 256.0f;
            float f4 = (float)l2 / 256.0f;
            float f5 = ((float)l2 + 15.99f) / 256.0f;
            float f6 = (0.0f - f1) / 2.0f;
            float f7 = f6 + f1;
            float f8 = 0.0f - f1 / 2.0f;
            float f9 = f8 + f1;
            float f10 = -0.5f;
            GL11.glTranslatef((float)(-(i2 * 2 - 1)) * 0.24f, -0.3f, 0.0f);
            GL11.glRotatef((float)(i2 * 2 - 1) * 10.0f, 0.0f, 1.0f, 0.0f);
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(f6, f8, f10, f3, f5);
            tessellator.addVertexWithUV(f7, f8, f10, f22, f5);
            tessellator.addVertexWithUV(f7, f9, f10, f22, f4);
            tessellator.addVertexWithUV(f6, f9, f10, f3, f4);
            tessellator.draw();
            GL11.glPopMatrix();
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
    }

    public void func_895_a() {
        float f2;
        this.field_9452_d = this.field_9453_c;
        EntityPlayerSP entityplayersp = this.mc.thePlayer;
        ItemStack itemstack = entityplayersp.inventory.getCurrentItem();
        ItemStack itemstack1 = itemstack;
        float f1 = itemstack1 != this.field_9451_b ? 0.0f : 1.0f;
        float f22 = f1 - this.field_9453_c;
        if (f22 < -(f2 = 0.4f)) {
            f22 = -f2;
        }
        if (f22 > f2) {
            f22 = f2;
        }
        this.field_9453_c += f22;
        if (this.field_9453_c < 0.1f) {
            this.field_9451_b = itemstack1;
        }
    }

    public void func_9449_b() {
        this.field_9453_c = 0.0f;
    }

    public void func_9450_c() {
        this.field_9453_c = 0.0f;
    }
}

