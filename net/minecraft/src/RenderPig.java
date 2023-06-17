/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPig;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;

public class RenderPig
extends RenderLiving {
    public RenderPig(ModelBase modelbase, ModelBase modelbase1, float f2) {
        super(modelbase, f2);
        this.func_4013_a(modelbase1);
    }

    protected boolean func_180_a(EntityPig entitypig, int i2) {
        this.loadTexture("/mob/saddle.png");
        return i2 == 0 && entitypig.rideable;
    }

    @Override
    protected boolean func_166_a(EntityLiving entityliving, int i2) {
        return this.func_180_a((EntityPig)entityliving, i2);
    }
}

