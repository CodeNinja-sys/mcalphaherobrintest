/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.Render;
import org.lwjgl.opengl.GL11;

public class RenderLiving
extends Render {
    protected ModelBase unusedRenderBlocks;
    protected ModelBase field_6332_f;

    public RenderLiving(ModelBase modelbase, float f2) {
        this.unusedRenderBlocks = modelbase;
        this.field_9246_c = f2;
    }

    public void func_4013_a(ModelBase modelbase) {
        this.field_6332_f = modelbase;
    }

    public void func_171_a(EntityLiving entityliving, double d2, double d1, double d22, float f2, float f1) {
        GL11.glPushMatrix();
        GL11.glDisable(2884);
        this.unusedRenderBlocks.field_1244_k = this.func_167_c(entityliving, f1);
        boolean bl2 = this.unusedRenderBlocks.field_1243_l = entityliving.ridingEntity != null || entityliving.field_9300_bu;
        if (this.field_6332_f != null) {
            this.field_6332_f.field_1243_l = this.unusedRenderBlocks.field_1243_l;
        }
        try {
            float f22 = entityliving.field_734_o + (entityliving.field_735_n - entityliving.field_734_o) * f1;
            float f3 = entityliving.prevRotationYaw + (entityliving.rotationYaw - entityliving.prevRotationYaw) * f1;
            float f4 = entityliving.prevRotationPitch + (entityliving.rotationPitch - entityliving.prevRotationPitch) * f1;
            GL11.glTranslatef((float)d2, (float)d1, (float)d22);
            float f5 = this.func_170_d(entityliving, f1);
            GL11.glRotatef(180.0f - f22, 0.0f, 1.0f, 0.0f);
            if (entityliving.deathTime > 0) {
                float f6 = ((float)entityliving.deathTime + f1 - 1.0f) / 20.0f * 1.6f;
                if ((f6 = MathHelper.sqrt_float(f6)) > 1.0f) {
                    f6 = 1.0f;
                }
                GL11.glRotatef(f6 * this.func_172_a(entityliving), 0.0f, 0.0f, 1.0f);
            }
            float f7 = 0.0625f;
            GL11.glEnable(32826);
            GL11.glScalef(-1.0f, -1.0f, 1.0f);
            this.func_6330_a(entityliving, f1);
            GL11.glTranslatef(0.0f, -24.0f * f7 - 0.0078125f, 0.0f);
            float f8 = entityliving.field_705_Q + (entityliving.field_704_R - entityliving.field_705_Q) * f1;
            float f9 = entityliving.field_703_S - entityliving.field_704_R * (1.0f - f1);
            if (f8 > 1.0f) {
                f8 = 1.0f;
            }
            this.func_140_a(entityliving.skinUrl, entityliving.getEntityTexture());
            GL11.glEnable(3008);
            this.unusedRenderBlocks.render(f9, f8, f5, f3 - f22, f4, f7);
            for (int i2 = 0; i2 < 4; ++i2) {
                if (!this.func_166_a(entityliving, i2)) continue;
                this.field_6332_f.render(f9, f8, f5, f3 - f22, f4, f7);
                GL11.glDisable(3042);
                GL11.glEnable(3008);
            }
            this.func_6331_b(entityliving, f1);
            float f10 = entityliving.getEntityBrightness(f1);
            int j2 = this.func_173_a(entityliving, f10, f1);
            if ((j2 >> 24 & 0xFF) > 0 || entityliving.hurtTime > 0 || entityliving.deathTime > 0) {
                GL11.glDisable(3553);
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glDepthFunc(514);
                if (entityliving.hurtTime > 0 || entityliving.deathTime > 0) {
                    GL11.glColor4f(f10, 0.0f, 0.0f, 0.4f);
                    this.unusedRenderBlocks.render(f9, f8, f5, f3 - f22, f4, f7);
                    for (int k2 = 0; k2 < 4; ++k2) {
                        if (!this.func_166_a(entityliving, k2)) continue;
                        GL11.glColor4f(f10, 0.0f, 0.0f, 0.4f);
                        this.field_6332_f.render(f9, f8, f5, f3 - f22, f4, f7);
                    }
                }
                if ((j2 >> 24 & 0xFF) > 0) {
                    float f11 = (float)(j2 >> 16 & 0xFF) / 255.0f;
                    float f12 = (float)(j2 >> 8 & 0xFF) / 255.0f;
                    float f13 = (float)(j2 & 0xFF) / 255.0f;
                    float f14 = (float)(j2 >> 24 & 0xFF) / 255.0f;
                    GL11.glColor4f(f11, f12, f13, f14);
                    this.unusedRenderBlocks.render(f9, f8, f5, f3 - f22, f4, f7);
                    for (int l2 = 0; l2 < 4; ++l2) {
                        if (!this.func_166_a(entityliving, l2)) continue;
                        GL11.glColor4f(f11, f12, f13, f14);
                        this.field_6332_f.render(f9, f8, f5, f3 - f22, f4, f7);
                    }
                }
                GL11.glDepthFunc(515);
                GL11.glDisable(3042);
                GL11.glEnable(3008);
                GL11.glEnable(3553);
            }
            GL11.glDisable(32826);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        GL11.glEnable(2884);
        GL11.glPopMatrix();
    }

    protected float func_167_c(EntityLiving entityliving, float f2) {
        return entityliving.getSwingProgress(f2);
    }

    protected float func_170_d(EntityLiving entityliving, float f2) {
        return (float)entityliving.field_9311_be + f2;
    }

    protected void func_6331_b(EntityLiving entityliving, float f2) {
    }

    protected boolean func_166_a(EntityLiving entityliving, int i2) {
        return false;
    }

    protected float func_172_a(EntityLiving entityliving) {
        return 90.0f;
    }

    protected int func_173_a(EntityLiving entityliving, float f2, float f1) {
        return 0;
    }

    protected void func_6330_a(EntityLiving entityliving, float f2) {
    }

    @Override
    public void doRender(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        this.func_171_a((EntityLiving)entity, d2, d1, d22, f2, f1);
    }
}

