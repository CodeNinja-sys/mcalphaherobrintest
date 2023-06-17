/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Render;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderArrow
extends Render {
    public void func_154_a(EntityArrow entityarrow, double d2, double d1, double d22, float f2, float f1) {
        this.loadTexture("/item/arrows.png");
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d2, (float)d1, (float)d22);
        GL11.glRotatef(entityarrow.prevRotationYaw + (entityarrow.rotationYaw - entityarrow.prevRotationYaw) * f1 - 90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(entityarrow.prevRotationPitch + (entityarrow.rotationPitch - entityarrow.prevRotationPitch) * f1, 0.0f, 0.0f, 1.0f);
        Tessellator tessellator = Tessellator.instance;
        int i2 = 0;
        float f22 = 0.0f;
        float f3 = 0.5f;
        float f4 = (float)(0 + i2 * 10) / 32.0f;
        float f5 = (float)(5 + i2 * 10) / 32.0f;
        float f6 = 0.0f;
        float f7 = 0.15625f;
        float f8 = (float)(5 + i2 * 10) / 32.0f;
        float f9 = (float)(10 + i2 * 10) / 32.0f;
        float f10 = 0.05625f;
        GL11.glEnable(32826);
        float f11 = (float)entityarrow.arrowShake - f1;
        if (f11 > 0.0f) {
            float f12 = -MathHelper.sin(f11 * 3.0f) * f11;
            GL11.glRotatef(f12, 0.0f, 0.0f, 1.0f);
        }
        GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(f10, f10, f10);
        GL11.glTranslatef(-4.0f, 0.0f, 0.0f);
        GL11.glNormal3f(f10, 0.0f, 0.0f);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-7.0, -2.0, -2.0, f6, f8);
        tessellator.addVertexWithUV(-7.0, -2.0, 2.0, f7, f8);
        tessellator.addVertexWithUV(-7.0, 2.0, 2.0, f7, f9);
        tessellator.addVertexWithUV(-7.0, 2.0, -2.0, f6, f9);
        tessellator.draw();
        GL11.glNormal3f(-f10, 0.0f, 0.0f);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-7.0, 2.0, -2.0, f6, f8);
        tessellator.addVertexWithUV(-7.0, 2.0, 2.0, f7, f8);
        tessellator.addVertexWithUV(-7.0, -2.0, 2.0, f7, f9);
        tessellator.addVertexWithUV(-7.0, -2.0, -2.0, f6, f9);
        tessellator.draw();
        for (int j2 = 0; j2 < 4; ++j2) {
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glNormal3f(0.0f, 0.0f, f10);
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(-8.0, -2.0, 0.0, f22, f4);
            tessellator.addVertexWithUV(8.0, -2.0, 0.0, f3, f4);
            tessellator.addVertexWithUV(8.0, 2.0, 0.0, f3, f5);
            tessellator.addVertexWithUV(-8.0, 2.0, 0.0, f22, f5);
            tessellator.draw();
        }
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    @Override
    public void doRender(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        this.func_154_a((EntityArrow)entity, d2, d1, d22, f2, f1);
    }
}

