/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityGhast;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelGhast;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderGhast
extends RenderLiving {
    public RenderGhast() {
        super(new ModelGhast(), 0.5f);
    }

    protected void func_4014_a(EntityGhast entityghast, float f2) {
        EntityGhast entityghast1 = entityghast;
        float f1 = ((float)entityghast1.field_4125_e + (float)(entityghast1.field_4124_f - entityghast1.field_4125_e) * f2) / 20.0f;
        if (f1 < 0.0f) {
            f1 = 0.0f;
        }
        f1 = 1.0f / (f1 * f1 * f1 * f1 * f1 * 2.0f + 1.0f);
        float f22 = (8.0f + f1) / 2.0f;
        float f3 = (8.0f + 1.0f / f1) / 2.0f;
        GL11.glScalef(f3, f22, f3);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    protected void func_6330_a(EntityLiving entityliving, float f2) {
        this.func_4014_a((EntityGhast)entityliving, f2);
    }
}

