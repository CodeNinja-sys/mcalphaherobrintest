/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityFish;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Render;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderFish
extends Render {
    public void func_4011_a(EntityFish entityfish, double d2, double d1, double d22, float f2, float f1) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d2, (float)d1, (float)d22);
        GL11.glEnable(32826);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        int i2 = 1;
        int byte0 = 2;
        this.loadTexture("/particles.png");
        Tessellator tessellator = Tessellator.instance;
        float f22 = (float)(i2 * 8 + 0) / 128.0f;
        float f3 = (float)(i2 * 8 + 8) / 128.0f;
        float f4 = (float)(byte0 * 8 + 0) / 128.0f;
        float f5 = (float)(byte0 * 8 + 8) / 128.0f;
        float f6 = 1.0f;
        float f7 = 0.5f;
        float f8 = 0.5f;
        GL11.glRotatef(180.0f - this.renderManager.field_1225_i, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.renderManager.field_1224_j, 1.0f, 0.0f, 0.0f);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0f, 1.0f, 0.0f);
        tessellator.addVertexWithUV(0.0f - f7, 0.0f - f8, 0.0, f22, f5);
        tessellator.addVertexWithUV(f6 - f7, 0.0f - f8, 0.0, f3, f5);
        tessellator.addVertexWithUV(f6 - f7, 1.0f - f8, 0.0, f3, f4);
        tessellator.addVertexWithUV(0.0f - f7, 1.0f - f8, 0.0, f22, f4);
        tessellator.draw();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
        if (entityfish.field_4097_b != null) {
            float f9 = (entityfish.field_4097_b.prevRotationYaw + (entityfish.field_4097_b.rotationYaw - entityfish.field_4097_b.prevRotationYaw) * f1) * 3.141593f / 180.0f;
            float f11 = (entityfish.field_4097_b.prevRotationPitch + (entityfish.field_4097_b.rotationPitch - entityfish.field_4097_b.prevRotationPitch) * f1) * 3.141593f / 180.0f;
            double d3 = MathHelper.sin(f9);
            double d5 = MathHelper.cos(f9);
            double d7 = MathHelper.sin(f11);
            double d8 = MathHelper.cos(f11);
            double d9 = entityfish.field_4097_b.prevPosX + (entityfish.field_4097_b.posX - entityfish.field_4097_b.prevPosX) * (double)f1 - d5 * 0.7 - d3 * 0.5 * d8;
            double d10 = entityfish.field_4097_b.prevPosY + (entityfish.field_4097_b.posY - entityfish.field_4097_b.prevPosY) * (double)f1 - d7 * 0.5;
            double d11 = entityfish.field_4097_b.prevPosZ + (entityfish.field_4097_b.posZ - entityfish.field_4097_b.prevPosZ) * (double)f1 - d3 * 0.7 + d5 * 0.5 * d8;
            if (this.renderManager.options.thirdPersonView) {
                float f10 = (entityfish.field_4097_b.field_734_o + (entityfish.field_4097_b.field_735_n - entityfish.field_4097_b.field_734_o) * f1) * 3.141593f / 180.0f;
                double d4 = MathHelper.sin(f10);
                double d6 = MathHelper.cos(f10);
                d9 = entityfish.field_4097_b.prevPosX + (entityfish.field_4097_b.posX - entityfish.field_4097_b.prevPosX) * (double)f1 - d6 * 0.35 - d4 * 0.85;
                d10 = entityfish.field_4097_b.prevPosY + (entityfish.field_4097_b.posY - entityfish.field_4097_b.prevPosY) * (double)f1 - 0.45;
                d11 = entityfish.field_4097_b.prevPosZ + (entityfish.field_4097_b.posZ - entityfish.field_4097_b.prevPosZ) * (double)f1 - d4 * 0.35 + d6 * 0.85;
            }
            double d12 = entityfish.prevPosX + (entityfish.posX - entityfish.prevPosX) * (double)f1;
            double d13 = entityfish.prevPosY + (entityfish.posY - entityfish.prevPosY) * (double)f1 + 0.25;
            double d14 = entityfish.prevPosZ + (entityfish.posZ - entityfish.prevPosZ) * (double)f1;
            double d15 = (float)(d9 - d12);
            double d16 = (float)(d10 - d13);
            double d17 = (float)(d11 - d14);
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            tessellator.startDrawing(3);
            tessellator.setColorOpaque_I(0);
            int j2 = 16;
            for (int k2 = 0; k2 <= j2; ++k2) {
                float f12 = (float)k2 / (float)j2;
                tessellator.addVertex(d2 + d15 * (double)f12, d1 + d16 * (double)(f12 * f12 + f12) * 0.5 + 0.25, d22 + d17 * (double)f12);
            }
            tessellator.draw();
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
    }

    @Override
    public void doRender(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        this.func_4011_a((EntityFish)entity, d2, d1, d22, f2, f1);
    }
}

