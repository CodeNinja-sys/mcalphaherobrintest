/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityFlameFX
extends EntityFX {
    private float field_672_a;

    public EntityFlameFX(World world, double d2, double d1, double d22, double d3, double d4, double d5) {
        super(world, d2, d1, d22, d3, d4, d5);
        this.motionX = this.motionX * (double)0.01f + d3;
        this.motionY = this.motionY * (double)0.01f + d4;
        this.motionZ = this.motionZ * (double)0.01f + d5;
        d2 += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f);
        d1 += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f);
        d22 += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f);
        this.field_672_a = this.field_665_g;
        this.field_661_k = 1.0f;
        this.field_662_j = 1.0f;
        this.field_663_i = 1.0f;
        this.field_666_f = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.field_9314_ba = true;
        this.field_670_b = 48;
    }

    @Override
    public void func_406_a(Tessellator tessellator, float f2, float f1, float f22, float f3, float f4, float f5) {
        float f6 = ((float)this.field_667_e + f2) / (float)this.field_666_f;
        this.field_665_g = this.field_672_a * (1.0f - f6 * f6 * 0.5f);
        super.func_406_a(tessellator, f2, f1, f22, f3, f4, f5);
    }

    @Override
    public float getEntityBrightness(float f2) {
        float f1 = ((float)this.field_667_e + f2) / (float)this.field_666_f;
        if (f1 < 0.0f) {
            f1 = 0.0f;
        }
        if (f1 > 1.0f) {
            f1 = 1.0f;
        }
        float f22 = super.getEntityBrightness(f2);
        return f22 * f1 + (1.0f - f1);
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.field_667_e++ >= this.field_666_f) {
            this.setEntityDead();
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.96f;
        this.motionY *= (double)0.96f;
        this.motionZ *= (double)0.96f;
        if (this.onGround) {
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
        }
    }
}

