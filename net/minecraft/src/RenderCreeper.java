/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelCreeper;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderCreeper
extends RenderLiving {
    public RenderCreeper() {
        super(new ModelCreeper(), 0.5f);
    }

    protected void func_184_a(EntityCreeper entitycreeper, float f2) {
        EntityCreeper entitycreeper1 = entitycreeper;
        float f1 = entitycreeper1.func_440_b(f2);
        float f22 = 1.0f + MathHelper.sin(f1 * 100.0f) * f1 * 0.01f;
        if (f1 < 0.0f) {
            f1 = 0.0f;
        }
        if (f1 > 1.0f) {
            f1 = 1.0f;
        }
        f1 *= f1;
        f1 *= f1;
        float f3 = (1.0f + f1 * 0.4f) * f22;
        float f4 = (1.0f + f1 * 0.1f) / f22;
        GL11.glScalef(f3, f4, f3);
    }

    protected int func_183_a(EntityCreeper entitycreeper, float f2, float f1) {
        EntityCreeper entitycreeper1 = entitycreeper;
        float f22 = entitycreeper1.func_440_b(f1);
        if ((int)(f22 * 10.0f) % 2 == 0) {
            return 0;
        }
        int i2 = (int)(f22 * 0.2f * 255.0f);
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 255) {
            i2 = 255;
        }
        int c2 = 255;
        int c1 = 255;
        int c22 = 255;
        return i2 << 24 | c2 << 16 | c1 << 8 | c22;
    }

    @Override
    protected void func_6330_a(EntityLiving entityliving, float f2) {
        this.func_184_a((EntityCreeper)entityliving, f2);
    }

    @Override
    protected int func_173_a(EntityLiving entityliving, float f2, float f1) {
        return this.func_183_a((EntityCreeper)entityliving, f2, f1);
    }
}

