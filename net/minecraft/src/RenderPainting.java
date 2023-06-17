/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPainting;
import net.minecraft.src.EnumArt;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Render;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderPainting
extends Render {
    private Random rand = new Random();

    public void func_158_a(EntityPainting entitypainting, double d2, double d1, double d22, float f2, float f1) {
        this.rand.setSeed(187L);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d2, (float)d1, (float)d22);
        GL11.glRotatef(f2, 0.0f, 1.0f, 0.0f);
        GL11.glEnable(32826);
        this.loadTexture("/art/kz.png");
        EnumArt enumart = entitypainting.field_690_b;
        float f22 = 0.0625f;
        GL11.glScalef(f22, f22, f22);
        this.func_159_a(entitypainting, enumart.field_1623_z, enumart.field_1636_A, enumart.field_1634_B, enumart.field_1632_C);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    private void func_159_a(EntityPainting entitypainting, int i2, int j2, int k2, int l2) {
        float f2 = (float)(-i2) / 2.0f;
        float f1 = (float)(-j2) / 2.0f;
        float f22 = -0.5f;
        float f3 = 0.5f;
        for (int i1 = 0; i1 < i2 / 16; ++i1) {
            for (int j1 = 0; j1 < j2 / 16; ++j1) {
                float f4 = f2 + (float)((i1 + 1) * 16);
                float f5 = f2 + (float)(i1 * 16);
                float f6 = f1 + (float)((j1 + 1) * 16);
                float f7 = f1 + (float)(j1 * 16);
                this.func_160_a(entitypainting, (f4 + f5) / 2.0f, (f6 + f7) / 2.0f);
                float f8 = (float)(k2 + i2 - i1 * 16) / 256.0f;
                float f9 = (float)(k2 + i2 - (i1 + 1) * 16) / 256.0f;
                float f10 = (float)(l2 + j2 - j1 * 16) / 256.0f;
                float f11 = (float)(l2 + j2 - (j1 + 1) * 16) / 256.0f;
                float f12 = 0.75f;
                float f13 = 0.8125f;
                float f14 = 0.0f;
                float f15 = 0.0625f;
                float f16 = 0.75f;
                float f17 = 0.8125f;
                float f18 = 0.001953125f;
                float f19 = 0.001953125f;
                float f20 = 0.7519531f;
                float f21 = 0.7519531f;
                float f222 = 0.0f;
                float f23 = 0.0625f;
                Tessellator tessellator = Tessellator.instance;
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, 0.0f, -1.0f);
                tessellator.addVertexWithUV(f4, f7, f22, f9, f10);
                tessellator.addVertexWithUV(f5, f7, f22, f8, f10);
                tessellator.addVertexWithUV(f5, f6, f22, f8, f11);
                tessellator.addVertexWithUV(f4, f6, f22, f9, f11);
                tessellator.setNormal(0.0f, 0.0f, 1.0f);
                tessellator.addVertexWithUV(f4, f6, f3, f12, f14);
                tessellator.addVertexWithUV(f5, f6, f3, f13, f14);
                tessellator.addVertexWithUV(f5, f7, f3, f13, f15);
                tessellator.addVertexWithUV(f4, f7, f3, f12, f15);
                tessellator.setNormal(0.0f, -1.0f, 0.0f);
                tessellator.addVertexWithUV(f4, f6, f22, f16, f18);
                tessellator.addVertexWithUV(f5, f6, f22, f17, f18);
                tessellator.addVertexWithUV(f5, f6, f3, f17, f19);
                tessellator.addVertexWithUV(f4, f6, f3, f16, f19);
                tessellator.setNormal(0.0f, 1.0f, 0.0f);
                tessellator.addVertexWithUV(f4, f7, f3, f16, f18);
                tessellator.addVertexWithUV(f5, f7, f3, f17, f18);
                tessellator.addVertexWithUV(f5, f7, f22, f17, f19);
                tessellator.addVertexWithUV(f4, f7, f22, f16, f19);
                tessellator.setNormal(-1.0f, 0.0f, 0.0f);
                tessellator.addVertexWithUV(f4, f6, f3, f21, f222);
                tessellator.addVertexWithUV(f4, f7, f3, f21, f23);
                tessellator.addVertexWithUV(f4, f7, f22, f20, f23);
                tessellator.addVertexWithUV(f4, f6, f22, f20, f222);
                tessellator.setNormal(1.0f, 0.0f, 0.0f);
                tessellator.addVertexWithUV(f5, f6, f22, f21, f222);
                tessellator.addVertexWithUV(f5, f7, f22, f21, f23);
                tessellator.addVertexWithUV(f5, f7, f3, f20, f23);
                tessellator.addVertexWithUV(f5, f6, f3, f20, f222);
                tessellator.draw();
            }
        }
    }

    private void func_160_a(EntityPainting entitypainting, float f2, float f1) {
        int i2 = MathHelper.floor_double(entitypainting.posX);
        int j2 = MathHelper.floor_double(entitypainting.posY + (double)(f1 / 16.0f));
        int k2 = MathHelper.floor_double(entitypainting.posZ);
        if (entitypainting.field_691_a == 0) {
            i2 = MathHelper.floor_double(entitypainting.posX + (double)(f2 / 16.0f));
        }
        if (entitypainting.field_691_a == 1) {
            k2 = MathHelper.floor_double(entitypainting.posZ - (double)(f2 / 16.0f));
        }
        if (entitypainting.field_691_a == 2) {
            i2 = MathHelper.floor_double(entitypainting.posX - (double)(f2 / 16.0f));
        }
        if (entitypainting.field_691_a == 3) {
            k2 = MathHelper.floor_double(entitypainting.posZ + (double)(f2 / 16.0f));
        }
        float f22 = this.renderManager.worldObj.getLightBrightness(i2, j2, k2);
        GL11.glColor3f(f22, f22, f22);
    }

    @Override
    public void doRender(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        this.func_158_a((EntityPainting)entity, d2, d1, d22, f2, f1);
    }
}

