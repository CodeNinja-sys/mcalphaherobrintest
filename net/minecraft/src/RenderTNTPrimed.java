/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityTNTPrimed;
import net.minecraft.src.Render;
import net.minecraft.src.RenderBlocks;
import org.lwjgl.opengl.GL11;

public class RenderTNTPrimed
extends Render {
    private RenderBlocks field_196_d = new RenderBlocks();

    public RenderTNTPrimed() {
        this.field_9246_c = 0.5f;
    }

    public void func_153_a(EntityTNTPrimed entitytntprimed, double d2, double d1, double d22, float f2, float f1) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d2, (float)d1, (float)d22);
        if ((float)entitytntprimed.fuse - f1 + 1.0f < 10.0f) {
            float f22 = 1.0f - ((float)entitytntprimed.fuse - f1 + 1.0f) / 10.0f;
            if (f22 < 0.0f) {
                f22 = 0.0f;
            }
            if (f22 > 1.0f) {
                f22 = 1.0f;
            }
            f22 *= f22;
            f22 *= f22;
            float f4 = 1.0f + f22 * 0.3f;
            GL11.glScalef(f4, f4, f4);
        }
        float f3 = (1.0f - ((float)entitytntprimed.fuse - f1 + 1.0f) / 100.0f) * 0.8f;
        this.loadTexture("/terrain.png");
        this.field_196_d.func_1227_a(Block.tnt);
        if (entitytntprimed.fuse / 5 % 2 == 0) {
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 772);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, f3);
            this.field_196_d.func_1227_a(Block.tnt);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
        GL11.glPopMatrix();
    }

    @Override
    public void doRender(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        this.func_153_a((EntityTNTPrimed)entity, d2, d1, d22, f2, f1);
    }
}

