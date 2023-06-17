/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityPortalFX
extends EntityFX {
    private float field_4083_a;
    private double field_4086_p;
    private double field_4085_q;
    private double field_4084_r;

    public EntityPortalFX(World world, double d2, double d1, double d22, double d3, double d4, double d5) {
        super(world, d2, d1, d22, d3, d4, d5);
        this.motionX = d3;
        this.motionY = d4;
        this.motionZ = d5;
        this.field_4086_p = this.posX = d2;
        this.field_4085_q = this.posY = d1;
        this.field_4084_r = this.posZ = d22;
        float f2 = this.rand.nextFloat() * 0.6f + 0.4f;
        this.field_4083_a = this.field_665_g = this.rand.nextFloat() * 0.2f + 0.5f;
        this.field_662_j = this.field_661_k = 1.0f * f2;
        this.field_663_i = this.field_661_k;
        this.field_662_j *= 0.3f;
        this.field_663_i *= 0.9f;
        this.field_666_f = (int)(Math.random() * 10.0) + 40;
        this.field_9314_ba = true;
        this.field_670_b = (int)(Math.random() * 8.0);
    }

    @Override
    public void func_406_a(Tessellator tessellator, float f2, float f1, float f22, float f3, float f4, float f5) {
        float f6 = ((float)this.field_667_e + f2) / (float)this.field_666_f;
        f6 = 1.0f - f6;
        f6 *= f6;
        f6 = 1.0f - f6;
        this.field_665_g = this.field_4083_a * f6;
        super.func_406_a(tessellator, f2, f1, f22, f3, f4, f5);
    }

    @Override
    public float getEntityBrightness(float f2) {
        float f1 = super.getEntityBrightness(f2);
        float f22 = (float)this.field_667_e / (float)this.field_666_f;
        f22 *= f22;
        f22 *= f22;
        return f1 * (1.0f - f22) + f22;
    }

    @Override
    public void onUpdate() {
        float f2;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        float f1 = f2 = (float)this.field_667_e / (float)this.field_666_f;
        f2 = -f2 + f2 * f2 * 2.0f;
        f2 = 1.0f - f2;
        this.posX = this.field_4086_p + this.motionX * (double)f2;
        this.posY = this.field_4085_q + this.motionY * (double)f2 + (double)(1.0f - f1);
        this.posZ = this.field_4084_r + this.motionZ * (double)f2;
        if (this.field_667_e++ >= this.field_666_f) {
            this.setEntityDead();
        }
    }
}

