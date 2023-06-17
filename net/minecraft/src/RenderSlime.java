/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntitySlime;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderSlime
extends RenderLiving {
    private ModelBase field_205_f;

    public RenderSlime(ModelBase modelbase, ModelBase modelbase1, float f2) {
        super(modelbase, f2);
        this.field_205_f = modelbase1;
    }

    protected boolean func_179_a(EntitySlime entityslime, int i2) {
        if (i2 == 0) {
            this.func_4013_a(this.field_205_f);
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            return true;
        }
        if (i2 == 1) {
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        return false;
    }

    protected void func_178_a(EntitySlime entityslime, float f2) {
        float f1 = (entityslime.field_767_b + (entityslime.field_768_a - entityslime.field_767_b) * f2) / ((float)entityslime.field_770_c * 0.5f + 1.0f);
        float f22 = 1.0f / (f1 + 1.0f);
        float f3 = entityslime.field_770_c;
        GL11.glScalef(f22 * f3, 1.0f / f22 * f3, f22 * f3);
    }

    @Override
    protected void func_6330_a(EntityLiving entityliving, float f2) {
        this.func_178_a((EntitySlime)entityliving, f2);
    }

    @Override
    protected boolean func_166_a(EntityLiving entityliving, int i2) {
        return this.func_179_a((EntitySlime)entityliving, i2);
    }
}

