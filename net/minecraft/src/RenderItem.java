/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Render;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderItem
extends Render {
    private RenderBlocks renderBlocks = new RenderBlocks();
    private Random random = new Random();

    public RenderItem() {
        this.field_9246_c = 0.15f;
        this.field_194_c = 0.75f;
    }

    public void func_165_a(EntityItem entityitem, double d2, double d1, double d22, float f2, float f1) {
        this.random.setSeed(187L);
        ItemStack itemstack = entityitem.item;
        GL11.glPushMatrix();
        float f22 = MathHelper.sin(((float)entityitem.age + f1) / 10.0f + entityitem.field_804_d) * 0.1f + 0.1f;
        float f3 = (((float)entityitem.age + f1) / 20.0f + entityitem.field_804_d) * 57.29578f;
        int byte0 = 1;
        if (entityitem.item.stackSize > 1) {
            byte0 = 2;
        }
        if (entityitem.item.stackSize > 5) {
            byte0 = 3;
        }
        if (entityitem.item.stackSize > 20) {
            byte0 = 4;
        }
        GL11.glTranslatef((float)d2, (float)d1 + f22, (float)d22);
        GL11.glEnable(32826);
        if (itemstack.itemID < 256 && RenderBlocks.func_1219_a(Block.blocksList[itemstack.itemID].getRenderType())) {
            GL11.glRotatef(f3, 0.0f, 1.0f, 0.0f);
            this.loadTexture("/terrain.png");
            float f4 = 0.25f;
            if (!Block.blocksList[itemstack.itemID].renderAsNormalBlock() && itemstack.itemID != Block.stairSingle.blockID) {
                f4 = 0.5f;
            }
            GL11.glScalef(f4, f4, f4);
            for (int j2 = 0; j2 < byte0; ++j2) {
                GL11.glPushMatrix();
                if (j2 > 0) {
                    float f5 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.2f / f4;
                    float f7 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.2f / f4;
                    float f9 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.2f / f4;
                    GL11.glTranslatef(f5, f7, f9);
                }
                this.renderBlocks.func_1227_a(Block.blocksList[itemstack.itemID]);
                GL11.glPopMatrix();
            }
        } else {
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            int i2 = itemstack.getIconIndex();
            if (itemstack.itemID < 256) {
                this.loadTexture("/terrain.png");
            } else {
                this.loadTexture("/gui/items.png");
            }
            Tessellator tessellator = Tessellator.instance;
            float f6 = (float)(i2 % 16 * 16 + 0) / 256.0f;
            float f8 = (float)(i2 % 16 * 16 + 16) / 256.0f;
            float f10 = (float)(i2 / 16 * 16 + 0) / 256.0f;
            float f11 = (float)(i2 / 16 * 16 + 16) / 256.0f;
            float f12 = 1.0f;
            float f13 = 0.5f;
            float f14 = 0.25f;
            for (int k2 = 0; k2 < byte0; ++k2) {
                GL11.glPushMatrix();
                if (k2 > 0) {
                    float f15 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    float f16 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    float f17 = (this.random.nextFloat() * 2.0f - 1.0f) * 0.3f;
                    GL11.glTranslatef(f15, f16, f17);
                }
                GL11.glRotatef(180.0f - this.renderManager.field_1225_i, 0.0f, 1.0f, 0.0f);
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, 1.0f, 0.0f);
                tessellator.addVertexWithUV(0.0f - f13, 0.0f - f14, 0.0, f6, f11);
                tessellator.addVertexWithUV(f12 - f13, 0.0f - f14, 0.0, f8, f11);
                tessellator.addVertexWithUV(f12 - f13, 1.0f - f14, 0.0, f8, f10);
                tessellator.addVertexWithUV(0.0f - f13, 1.0f - f14, 0.0, f6, f10);
                tessellator.draw();
                GL11.glPopMatrix();
            }
        }
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public void renderItemIntoGUI(FontRenderer fontrenderer, RenderEngine renderengine, ItemStack itemstack, int i2, int j2) {
        if (itemstack == null) {
            return;
        }
        if (itemstack.itemID < 256 && RenderBlocks.func_1219_a(Block.blocksList[itemstack.itemID].getRenderType())) {
            int k2 = itemstack.itemID;
            renderengine.bindTexture(renderengine.getTexture("/terrain.png"));
            Block block = Block.blocksList[k2];
            GL11.glPushMatrix();
            GL11.glTranslatef(i2 - 2, j2 + 3, 0.0f);
            GL11.glScalef(10.0f, 10.0f, 10.0f);
            GL11.glTranslatef(1.0f, 0.5f, 8.0f);
            GL11.glRotatef(210.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glScalef(1.0f, 1.0f, 1.0f);
            this.renderBlocks.func_1227_a(block);
            GL11.glPopMatrix();
        } else if (itemstack.getIconIndex() >= 0) {
            GL11.glDisable(2896);
            if (itemstack.itemID < 256) {
                renderengine.bindTexture(renderengine.getTexture("/terrain.png"));
            } else {
                renderengine.bindTexture(renderengine.getTexture("/gui/items.png"));
            }
            this.renderTexturedQuad(i2, j2, itemstack.getIconIndex() % 16 * 16, itemstack.getIconIndex() / 16 * 16, 16, 16);
            GL11.glEnable(2896);
        }
        GL11.glEnable(2884);
    }

    public void renderItemOverlayIntoGUI(FontRenderer fontrenderer, RenderEngine renderengine, ItemStack itemstack, int i2, int j2) {
        if (itemstack == null) {
            return;
        }
        if (itemstack.stackSize > 1) {
            String s2 = "" + itemstack.stackSize;
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            fontrenderer.drawStringWithShadow(s2, i2 + 19 - 2 - fontrenderer.getStringWidth(s2), j2 + 6 + 3, 0xFFFFFF);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
        }
        if (itemstack.itemDamage > 0) {
            int k2 = 13 - itemstack.itemDamage * 13 / itemstack.getMaxDamage();
            int l2 = 255 - itemstack.itemDamage * 255 / itemstack.getMaxDamage();
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            GL11.glDisable(3553);
            Tessellator tessellator = Tessellator.instance;
            int i1 = 255 - l2 << 16 | l2 << 8;
            int j1 = (255 - l2) / 4 << 16 | 0x3F00;
            this.renderQuad(tessellator, i2 + 2, j2 + 13, 13, 2, 0);
            this.renderQuad(tessellator, i2 + 2, j2 + 13, 12, 1, j1);
            this.renderQuad(tessellator, i2 + 2, j2 + 13, k2, 1, i1);
            GL11.glEnable(3553);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    private void renderQuad(Tessellator tessellator, int i2, int j2, int k2, int l2, int i1) {
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(i1);
        tessellator.addVertex(i2 + 0, j2 + 0, 0.0);
        tessellator.addVertex(i2 + 0, j2 + l2, 0.0);
        tessellator.addVertex(i2 + k2, j2 + l2, 0.0);
        tessellator.addVertex(i2 + k2, j2 + 0, 0.0);
        tessellator.draw();
    }

    public void renderTexturedQuad(int i2, int j2, int k2, int l2, int i1, int j1) {
        float f2 = 0.0f;
        float f1 = 0.00390625f;
        float f22 = 0.00390625f;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(i2 + 0, j2 + j1, f2, (float)(k2 + 0) * f1, (float)(l2 + j1) * f22);
        tessellator.addVertexWithUV(i2 + i1, j2 + j1, f2, (float)(k2 + i1) * f1, (float)(l2 + j1) * f22);
        tessellator.addVertexWithUV(i2 + i1, j2 + 0, f2, (float)(k2 + i1) * f1, (float)(l2 + 0) * f22);
        tessellator.addVertexWithUV(i2 + 0, j2 + 0, f2, (float)(k2 + 0) * f1, (float)(l2 + 0) * f22);
        tessellator.draw();
    }

    @Override
    public void doRender(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        this.func_165_a((EntityItem)entity, d2, d1, d22, f2, f1);
    }
}

