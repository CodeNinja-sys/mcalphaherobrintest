/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;

public class RenderSheep
extends RenderLiving {
    public RenderSheep(ModelBase modelbase, ModelBase modelbase1, float f2) {
        super(modelbase, f2);
        this.func_4013_a(modelbase1);
    }

    protected boolean func_176_a(EntitySheep entitysheep, int i2) {
        this.loadTexture("/mob/sheep_fur.png");
        return i2 == 0 && !entitysheep.sheared;
    }

    @Override
    protected boolean func_166_a(EntityLiving entityliving, int i2) {
        return this.func_176_a((EntitySheep)entityliving, i2);
    }
}

