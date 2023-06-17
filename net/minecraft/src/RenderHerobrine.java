/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityHerobrine;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.RenderLiving;

public class RenderHerobrine
extends RenderLiving {
    public RenderHerobrine(ModelBiped modelbase, float f2) {
        super(modelbase, f2);
    }

    public void func_177_a(EntityHerobrine entitycow, double d2, double d1, double d22, float f2, float f1) {
        super.func_171_a(entitycow, d2, d1, d22, f2, f1);
    }

    @Override
    public void func_171_a(EntityLiving entityliving, double d2, double d1, double d22, float f2, float f1) {
        this.func_177_a((EntityHerobrine)entityliving, d2, d1, d22, f2, f1);
    }

    @Override
    public void doRender(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        this.func_177_a((EntityHerobrine)entity, d2, d1, d22, f2, f1);
    }
}

