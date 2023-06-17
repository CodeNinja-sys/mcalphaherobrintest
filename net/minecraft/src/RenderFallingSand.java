/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityFallingSand;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Render;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class RenderFallingSand
extends Render {
    private RenderBlocks field_197_d = new RenderBlocks();

    public RenderFallingSand() {
        this.field_9246_c = 0.5f;
    }

    public void func_156_a(EntityFallingSand entityfallingsand, double d2, double d1, double d22, float f2, float f1) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d2, (float)d1, (float)d22);
        this.loadTexture("/terrain.png");
        Block block = Block.blocksList[entityfallingsand.field_799_a];
        World world = entityfallingsand.func_465_i();
        GL11.glDisable(2896);
        this.field_197_d.func_1243_a(block, world, MathHelper.floor_double(entityfallingsand.posX), MathHelper.floor_double(entityfallingsand.posY), MathHelper.floor_double(entityfallingsand.posZ));
        GL11.glEnable(2896);
        GL11.glPopMatrix();
    }

    @Override
    public void doRender(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        this.func_156_a((EntityFallingSand)entity, d2, d1, d22, f2, f1);
    }
}

