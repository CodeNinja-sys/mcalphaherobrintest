/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.ModelSpider;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderSpider
extends RenderLiving {
    public RenderSpider() {
        super(new ModelSpider(), 1.0f);
        this.func_4013_a(new ModelSpider());
    }

    protected float func_191_a(EntitySpider entityspider) {
        return 180.0f;
    }

    protected boolean func_190_a(EntitySpider entityspider, int i2) {
        if (i2 != 0) {
            return false;
        }
        if (i2 != 0) {
            return false;
        }
        this.loadTexture("/mob/spider_eyes.png");
        float f2 = (1.0f - entityspider.getEntityBrightness(1.0f)) * 0.5f;
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f2);
        return true;
    }

    @Override
    protected float func_172_a(EntityLiving entityliving) {
        return this.func_191_a((EntitySpider)entityliving);
    }

    @Override
    protected boolean func_166_a(EntityLiving entityliving, int i2) {
        return this.func_190_a((EntitySpider)entityliving, i2);
    }
}

