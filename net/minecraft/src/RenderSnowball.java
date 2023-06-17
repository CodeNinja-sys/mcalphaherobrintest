/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntitySnowball;
import net.minecraft.src.Item;
import net.minecraft.src.Render;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderSnowball
extends Render {
    public void func_155_a(EntitySnowball entitysnowball, double d2, double d1, double d22, float f2, float f1) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d2, (float)d1, (float)d22);
        GL11.glEnable(32826);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        int i2 = Item.snowball.getIconIndex(null);
        this.loadTexture("/gui/items.png");
        Tessellator tessellator = Tessellator.instance;
        float f22 = (float)(i2 % 16 * 16 + 0) / 256.0f;
        float f3 = (float)(i2 % 16 * 16 + 16) / 256.0f;
        float f4 = (float)(i2 / 16 * 16 + 0) / 256.0f;
        float f5 = (float)(i2 / 16 * 16 + 16) / 256.0f;
        float f6 = 1.0f;
        float f7 = 0.5f;
        float f8 = 0.25f;
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
    }

    @Override
    public void doRender(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        this.func_155_a((EntitySnowball)entity, d2, d1, d22, f2, f1);
    }
}

