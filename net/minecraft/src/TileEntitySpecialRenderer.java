/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.FontRenderer;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityRenderer;

public abstract class TileEntitySpecialRenderer {
    protected TileEntityRenderer tileEntityRenderer;

    public abstract void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8);

    protected void bindTextureByName(String s2) {
        RenderEngine renderengine = this.tileEntityRenderer.renderEngine;
        renderengine.bindTexture(renderengine.getTexture(s2));
    }

    public void setTileEntityRenderer(TileEntityRenderer tileentityrenderer) {
        this.tileEntityRenderer = tileentityrenderer;
    }

    public FontRenderer getFontRenderer() {
        return this.tileEntityRenderer.getFontRenderer();
    }
}

