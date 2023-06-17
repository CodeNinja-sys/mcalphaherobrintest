/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.RenderManager;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public abstract class Render {
    protected RenderManager renderManager;
    private ModelBase unusedModelBiped = new ModelBiped();
    private RenderBlocks unusedRenderBlocks = new RenderBlocks();
    protected float field_9246_c = 0.0f;
    protected float field_194_c = 1.0f;

    public abstract void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9);

    protected void loadTexture(String s2) {
        RenderEngine renderengine = this.renderManager.renderEngine;
        renderengine.bindTexture(renderengine.getTexture(s2));
    }

    protected void func_140_a(String s2, String s1) {
        RenderEngine renderengine = this.renderManager.renderEngine;
        renderengine.bindTexture(renderengine.getTextureForDownloadableImage(s2, s1));
    }

    private void renderEntityOnFire(Entity entity, double d2, double d1, double d22, float f2) {
        GL11.glDisable(2896);
        int i2 = Block.fire.blockIndexInTexture;
        int j2 = (i2 & 0xF) << 4;
        int k2 = i2 & 0xF0;
        float f1 = (float)j2 / 256.0f;
        float f22 = ((float)j2 + 15.99f) / 256.0f;
        float f3 = (float)k2 / 256.0f;
        float f4 = ((float)k2 + 15.99f) / 256.0f;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d2, (float)d1, (float)d22);
        float f5 = entity.width * 1.4f;
        GL11.glScalef(f5, f5, f5);
        this.loadTexture("/terrain.png");
        Tessellator tessellator = Tessellator.instance;
        float f6 = 1.0f;
        float f7 = 0.5f;
        float f8 = 0.0f;
        float f9 = entity.height / entity.width;
        GL11.glRotatef(-this.renderManager.field_1225_i, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(0.0f, 0.0f, -0.4f + (float)((int)f9) * 0.02f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        tessellator.startDrawingQuads();
        while (f9 > 0.0f) {
            tessellator.addVertexWithUV(f6 - f7, 0.0f - f8, 0.0, f22, f4);
            tessellator.addVertexWithUV(0.0f - f7, 0.0f - f8, 0.0, f1, f4);
            tessellator.addVertexWithUV(0.0f - f7, 1.4f - f8, 0.0, f1, f3);
            tessellator.addVertexWithUV(f6 - f7, 1.4f - f8, 0.0, f22, f3);
            f9 -= 1.0f;
            f8 -= 1.0f;
            f6 *= 0.9f;
            GL11.glTranslatef(0.0f, 0.0f, -0.04f);
        }
        tessellator.draw();
        GL11.glPopMatrix();
        GL11.glEnable(2896);
    }

    private void renderShadow(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        RenderEngine renderengine = this.renderManager.renderEngine;
        renderengine.bindTexture(renderengine.getTexture("%clamp%/misc/shadow.png"));
        World world = this.getWorldFromRenderManager();
        GL11.glDepthMask(false);
        float f22 = this.field_9246_c;
        double d3 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f1;
        double d4 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f1 + (double)entity.func_392_h_();
        double d5 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f1;
        int i2 = MathHelper.floor_double(d3 - (double)f22);
        int j2 = MathHelper.floor_double(d3 + (double)f22);
        int k2 = MathHelper.floor_double(d4 - (double)f22);
        int l2 = MathHelper.floor_double(d4);
        int i1 = MathHelper.floor_double(d5 - (double)f22);
        int j1 = MathHelper.floor_double(d5 + (double)f22);
        double d6 = d2 - d3;
        double d7 = d1 - d4;
        double d8 = d22 - d5;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        for (int k1 = i2; k1 <= j2; ++k1) {
            for (int l1 = k2; l1 <= l2; ++l1) {
                for (int i22 = i1; i22 <= j1; ++i22) {
                    int j22 = world.getBlockId(k1, l1 - 1, i22);
                    if (j22 <= 0 || world.getBlockLightValue(k1, l1, i22) <= 3) continue;
                    this.renderShadowOnBlock(Block.blocksList[j22], d2, d1 + (double)entity.func_392_h_(), d22, k1, l1, i22, f2, f22, d6, d7 + (double)entity.func_392_h_(), d8);
                }
            }
        }
        tessellator.draw();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
    }

    private World getWorldFromRenderManager() {
        return this.renderManager.worldObj;
    }

    private void renderShadowOnBlock(Block block, double d2, double d1, double d22, int i2, int j2, int k2, float f2, float f1, double d3, double d4, double d5) {
        Tessellator tessellator = Tessellator.instance;
        if (!block.renderAsNormalBlock()) {
            return;
        }
        double d6 = ((double)f2 - (d1 - ((double)j2 + d4)) / 2.0) * 0.5 * (double)this.getWorldFromRenderManager().getLightBrightness(i2, j2, k2);
        if (d6 < 0.0) {
            return;
        }
        if (d6 > 1.0) {
            d6 = 1.0;
        }
        tessellator.setColorRGBA_F(1.0f, 1.0f, 1.0f, (float)d6);
        double d7 = (double)i2 + block.minX + d3;
        double d8 = (double)i2 + block.maxX + d3;
        double d9 = (double)j2 + block.minY + d4 + 0.015625;
        double d10 = (double)k2 + block.minZ + d5;
        double d11 = (double)k2 + block.maxZ + d5;
        float f22 = (float)((d2 - d7) / 2.0 / (double)f1 + 0.5);
        float f3 = (float)((d2 - d8) / 2.0 / (double)f1 + 0.5);
        float f4 = (float)((d22 - d10) / 2.0 / (double)f1 + 0.5);
        float f5 = (float)((d22 - d11) / 2.0 / (double)f1 + 0.5);
        tessellator.addVertexWithUV(d7, d9, d10, f22, f4);
        tessellator.addVertexWithUV(d7, d9, d11, f22, f5);
        tessellator.addVertexWithUV(d8, d9, d11, f3, f5);
        tessellator.addVertexWithUV(d8, d9, d10, f3, f4);
    }

    public static void renderOffsetAABB(AxisAlignedBB axisalignedbb, double d2, double d1, double d22) {
        GL11.glDisable(3553);
        Tessellator tessellator = Tessellator.instance;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        tessellator.startDrawingQuads();
        tessellator.setTranslationD(d2, d1, d22);
        tessellator.setNormal(0.0f, 0.0f, -1.0f);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.setNormal(0.0f, 0.0f, 1.0f);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.setNormal(0.0f, -1.0f, 0.0f);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.setNormal(0.0f, 1.0f, 0.0f);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.setNormal(-1.0f, 0.0f, 0.0f);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.setNormal(1.0f, 0.0f, 0.0f);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.setTranslationD(0.0, 0.0, 0.0);
        tessellator.draw();
        GL11.glEnable(3553);
    }

    public static void renderAABB(AxisAlignedBB axisalignedbb) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.draw();
    }

    public void setRenderManager(RenderManager rendermanager) {
        this.renderManager = rendermanager;
    }

    public void doRenderShadowAndFire(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        double d3;
        float f22;
        if (this.renderManager.options.fancyGraphics && this.field_9246_c > 0.0f && (f22 = (float)((1.0 - (d3 = this.renderManager.func_851_a(entity.posX, entity.posY, entity.posZ)) / 256.0) * (double)this.field_194_c)) > 0.0f) {
            this.renderShadow(entity, d2, d1, d22, f22, f1);
        }
        if (entity.fire > 0 || entity.field_9299_bv) {
            this.renderEntityOnFire(entity, d2, d1, d22, f1);
        }
    }

    public FontRenderer getFontRendererFromRenderManager() {
        return this.renderManager.getFontRenderer();
    }
}

