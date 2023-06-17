/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;

public class RenderChicken
extends RenderLiving {
    public RenderChicken(ModelBase modelbase, float f2) {
        super(modelbase, f2);
    }

    public void func_181_a(EntityChicken entitychicken, double d2, double d1, double d22, float f2, float f1) {
        super.func_171_a(entitychicken, d2, d1, d22, f2, f1);
    }

    protected float func_182_a(EntityChicken entitychicken, float f2) {
        float f1 = entitychicken.field_756_e + (entitychicken.field_752_b - entitychicken.field_756_e) * f2;
        float f22 = entitychicken.field_757_d + (entitychicken.field_758_c - entitychicken.field_757_d) * f2;
        return (MathHelper.sin(f1) + 1.0f) * f22;
    }

    @Override
    protected float func_170_d(EntityLiving entityliving, float f2) {
        return this.func_182_a((EntityChicken)entityliving, f2);
    }

    @Override
    public void func_171_a(EntityLiving entityliving, double d2, double d1, double d22, float f2, float f1) {
        this.func_181_a((EntityChicken)entityliving, d2, d1, d22, f2, f1);
    }

    @Override
    public void doRender(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        this.func_181_a((EntityChicken)entity, d2, d1, d22, f2, f1);
    }
}

