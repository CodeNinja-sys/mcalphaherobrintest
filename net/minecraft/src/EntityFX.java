/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityFX
extends Entity {
    protected int field_670_b;
    protected float field_669_c;
    protected float field_668_d;
    protected int field_667_e = 0;
    protected int field_666_f = 0;
    protected float field_665_g;
    protected float field_664_h;
    protected float field_663_i;
    protected float field_662_j;
    protected float field_661_k;
    public static double field_660_l;
    public static double field_659_m;
    public static double field_658_n;

    public EntityFX(World world, double d2, double d1, double d22, double d3, double d4, double d5) {
        super(world);
        this.setSize(0.2f, 0.2f);
        this.yOffset = this.height / 2.0f;
        this.setPosition(d2, d1, d22);
        this.field_661_k = 1.0f;
        this.field_662_j = 1.0f;
        this.field_663_i = 1.0f;
        this.motionX = d3 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.4f);
        this.motionY = d4 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.4f);
        this.motionZ = d5 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.4f);
        float f2 = (float)(Math.random() + Math.random() + 1.0) * 0.15f;
        float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
        this.motionX = this.motionX / (double)f1 * (double)f2 * (double)0.4f;
        this.motionY = this.motionY / (double)f1 * (double)f2 * (double)0.4f + (double)0.1f;
        this.motionZ = this.motionZ / (double)f1 * (double)f2 * (double)0.4f;
        this.field_669_c = this.rand.nextFloat() * 3.0f;
        this.field_668_d = this.rand.nextFloat() * 3.0f;
        this.field_665_g = (this.rand.nextFloat() * 0.5f + 0.5f) * 2.0f;
        this.field_666_f = (int)(4.0f / (this.rand.nextFloat() * 0.9f + 0.1f));
        this.field_667_e = 0;
        this.entityWalks = false;
    }

    public EntityFX func_407_b(float f2) {
        this.motionX *= (double)f2;
        this.motionY = (this.motionY - (double)0.1f) * (double)f2 + (double)0.1f;
        this.motionZ *= (double)f2;
        return this;
    }

    public EntityFX func_405_d(float f2) {
        this.setSize(0.2f * f2, 0.2f * f2);
        this.field_665_g *= f2;
        return this;
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.field_667_e++ >= this.field_666_f) {
            this.setEntityDead();
        }
        this.motionY -= 0.04 * (double)this.field_664_h;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.98f;
        this.motionY *= (double)0.98f;
        this.motionZ *= (double)0.98f;
        if (this.onGround) {
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
        }
    }

    public void func_406_a(Tessellator tessellator, float f2, float f1, float f22, float f3, float f4, float f5) {
        float f6 = (float)(this.field_670_b % 16) / 16.0f;
        float f7 = f6 + 0.0624375f;
        float f8 = (float)(this.field_670_b / 16) / 16.0f;
        float f9 = f8 + 0.0624375f;
        float f10 = 0.1f * this.field_665_g;
        float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)f2 - field_660_l);
        float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)f2 - field_659_m);
        float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)f2 - field_658_n);
        float f14 = this.getEntityBrightness(f2);
        tessellator.setColorOpaque_F(this.field_663_i * f14, this.field_662_j * f14, this.field_661_k * f14);
        tessellator.addVertexWithUV(f11 - f1 * f10 - f4 * f10, f12 - f22 * f10, f13 - f3 * f10 - f5 * f10, f6, f9);
        tessellator.addVertexWithUV(f11 - f1 * f10 + f4 * f10, f12 + f22 * f10, f13 - f3 * f10 + f5 * f10, f6, f8);
        tessellator.addVertexWithUV(f11 + f1 * f10 + f4 * f10, f12 + f22 * f10, f13 + f3 * f10 + f5 * f10, f7, f8);
        tessellator.addVertexWithUV(f11 + f1 * f10 - f4 * f10, f12 - f22 * f10, f13 + f3 * f10 - f5 * f10, f7, f9);
    }

    public int func_404_c() {
        return 0;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
    }
}

