/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelBoat;
import net.minecraft.src.Render;
import org.lwjgl.opengl.GL11;

public class RenderBoat
extends Render {
    protected ModelBase field_198_d;

    public RenderBoat() {
        this.field_9246_c = 0.5f;
        this.field_198_d = new ModelBoat();
    }

    public void func_157_a(EntityBoat entityboat, double d2, double d1, double d22, float f2, float f1) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d2, (float)d1, (float)d22);
        GL11.glRotatef(180.0f - f2, 0.0f, 1.0f, 0.0f);
        float f22 = (float)entityboat.field_806_b - f1;
        float f3 = (float)entityboat.field_807_a - f1;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f22 > 0.0f) {
            GL11.glRotatef(MathHelper.sin(f22) * f22 * f3 / 10.0f * (float)entityboat.field_808_c, 1.0f, 0.0f, 0.0f);
        }
        this.loadTexture("/terrain.png");
        float f4 = 0.75f;
        GL11.glScalef(f4, f4, f4);
        GL11.glScalef(1.0f / f4, 1.0f / f4, 1.0f / f4);
        this.loadTexture("/item/boat.png");
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        this.field_198_d.render(0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }

    @Override
    public void doRender(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        this.func_157_a((EntityBoat)entity, d2, d1, d22, f2, f1);
    }
}

