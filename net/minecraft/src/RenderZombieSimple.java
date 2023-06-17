/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityZombieSimple;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderZombieSimple
extends RenderLiving {
    private float field_204_f;

    public RenderZombieSimple(ModelBase modelbase, float f2, float f1) {
        super(modelbase, f2 * f1);
        this.field_204_f = f1;
    }

    protected void func_175_a(EntityZombieSimple entityzombiesimple, float f2) {
        GL11.glScalef(this.field_204_f, this.field_204_f, this.field_204_f);
    }

    @Override
    protected void func_6330_a(EntityLiving entityliving, float f2) {
        this.func_175_a((EntityZombieSimple)entityliving, f2);
    }
}

