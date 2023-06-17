/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelMinecart;
import net.minecraft.src.Render;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.Vec3D;
import org.lwjgl.opengl.GL11;

public class RenderMinecart
extends Render {
    protected ModelBase unusedModelBiped;

    public RenderMinecart() {
        this.field_9246_c = 0.5f;
        this.unusedModelBiped = new ModelMinecart();
    }

    public void func_152_a(EntityMinecart entityminecart, double d2, double d1, double d22, float f2, float f1) {
        GL11.glPushMatrix();
        double d3 = entityminecart.lastTickPosX + (entityminecart.posX - entityminecart.lastTickPosX) * (double)f1;
        double d4 = entityminecart.lastTickPosY + (entityminecart.posY - entityminecart.lastTickPosY) * (double)f1;
        double d5 = entityminecart.lastTickPosZ + (entityminecart.posZ - entityminecart.lastTickPosZ) * (double)f1;
        double d6 = 0.3f;
        Vec3D vec3d = entityminecart.func_514_g(d3, d4, d5);
        float f22 = entityminecart.prevRotationPitch + (entityminecart.rotationPitch - entityminecart.prevRotationPitch) * f1;
        if (vec3d != null) {
            Vec3D vec3d1 = entityminecart.func_515_a(d3, d4, d5, d6);
            Vec3D vec3d2 = entityminecart.func_515_a(d3, d4, d5, -d6);
            if (vec3d1 == null) {
                vec3d1 = vec3d;
            }
            if (vec3d2 == null) {
                vec3d2 = vec3d;
            }
            d2 += vec3d.xCoord - d3;
            d1 += (vec3d1.yCoord + vec3d2.yCoord) / 2.0 - d4;
            d22 += vec3d.zCoord - d5;
            Vec3D vec3d3 = vec3d2.addVector(-vec3d1.xCoord, -vec3d1.yCoord, -vec3d1.zCoord);
            if (vec3d3.lengthVector() != 0.0) {
                vec3d3 = vec3d3.normalize();
                f2 = (float)(Math.atan2(vec3d3.zCoord, vec3d3.xCoord) * 180.0 / Math.PI);
                f22 = (float)(Math.atan(vec3d3.yCoord) * 73.0);
            }
        }
        GL11.glTranslatef((float)d2, (float)d1, (float)d22);
        GL11.glRotatef(180.0f - f2, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-f22, 0.0f, 0.0f, 1.0f);
        float f3 = (float)entityminecart.field_863_b - f1;
        float f4 = (float)entityminecart.field_864_a - f1;
        if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        if (f3 > 0.0f) {
            GL11.glRotatef(MathHelper.sin(f3) * f3 * f4 / 10.0f * (float)entityminecart.field_862_c, 1.0f, 0.0f, 0.0f);
        }
        if (entityminecart.minecartType != 0) {
            this.loadTexture("/terrain.png");
            float f5 = 0.75f;
            GL11.glScalef(f5, f5, f5);
            GL11.glTranslatef(0.0f, 0.3125f, 0.0f);
            GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
            if (entityminecart.minecartType == 1) {
                new RenderBlocks().func_1227_a(Block.crate);
            } else if (entityminecart.minecartType == 2) {
                new RenderBlocks().func_1227_a(Block.stoneOvenIdle);
            }
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(0.0f, -0.3125f, 0.0f);
            GL11.glScalef(1.0f / f5, 1.0f / f5, 1.0f / f5);
        }
        this.loadTexture("/item/cart.png");
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        this.unusedModelBiped.render(0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }

    @Override
    public void doRender(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        this.func_152_a((EntityMinecart)entity, d2, d1, d22, f2, f1);
    }
}

