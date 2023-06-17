/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.FontRenderer;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class Gui {
    protected float zLevel = 0.0f;

    protected void drawRect(int i2, int j2, int k2, int l2, int i1) {
        float f2 = (float)(i1 >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(i1 >> 16 & 0xFF) / 255.0f;
        float f22 = (float)(i1 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(i1 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.instance;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f1, f22, f3, f2);
        tessellator.startDrawingQuads();
        tessellator.addVertex(i2, l2, 0.0);
        tessellator.addVertex(k2, l2, 0.0);
        tessellator.addVertex(k2, j2, 0.0);
        tessellator.addVertex(i2, j2, 0.0);
        tessellator.draw();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }

    protected void drawGradientRect(int i2, int j2, int k2, int l2, int i1, int j1) {
        float f2 = (float)(i1 >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(i1 >> 16 & 0xFF) / 255.0f;
        float f22 = (float)(i1 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(i1 & 0xFF) / 255.0f;
        float f4 = (float)(j1 >> 24 & 0xFF) / 255.0f;
        float f5 = (float)(j1 >> 16 & 0xFF) / 255.0f;
        float f6 = (float)(j1 >> 8 & 0xFF) / 255.0f;
        float f7 = (float)(j1 & 0xFF) / 255.0f;
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(f1, f22, f3, f2);
        tessellator.addVertex(k2, j2, 0.0);
        tessellator.addVertex(i2, j2, 0.0);
        tessellator.setColorRGBA_F(f5, f6, f7, f4);
        tessellator.addVertex(i2, l2, 0.0);
        tessellator.addVertex(k2, l2, 0.0);
        tessellator.draw();
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
    }

    public void drawCenteredString(FontRenderer fontrenderer, String s2, int i2, int j2, int k2) {
        fontrenderer.drawStringWithShadow(s2, i2 - fontrenderer.getStringWidth(s2) / 2, j2, k2);
    }

    public void drawString(FontRenderer fontrenderer, String s2, int i2, int j2, int k2) {
        fontrenderer.drawStringWithShadow(s2, i2, j2, k2);
    }

    public void drawTexturedModalRect(int i2, int j2, int k2, int l2, int i1, int j1) {
        float f2 = 0.00390625f;
        float f1 = 0.00390625f;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(i2 + 0, j2 + j1, this.zLevel, (float)(k2 + 0) * f2, (float)(l2 + j1) * f1);
        tessellator.addVertexWithUV(i2 + i1, j2 + j1, this.zLevel, (float)(k2 + i1) * f2, (float)(l2 + j1) * f1);
        tessellator.addVertexWithUV(i2 + i1, j2 + 0, this.zLevel, (float)(k2 + i1) * f2, (float)(l2 + 0) * f1);
        tessellator.addVertexWithUV(i2 + 0, j2 + 0, this.zLevel, (float)(k2 + 0) * f2, (float)(l2 + 0) * f1);
        tessellator.draw();
    }
}

