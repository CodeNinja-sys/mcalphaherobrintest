/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityLavaFX
extends EntityFX {
    private float field_674_a;

    public EntityLavaFX(World world, double d2, double d1, double d22) {
        super(world, d2, d1, d22, 0.0, 0.0, 0.0);
        this.motionX *= (double)0.8f;
        this.motionY *= (double)0.8f;
        this.motionZ *= (double)0.8f;
        this.motionY = this.rand.nextFloat() * 0.4f + 0.05f;
        this.field_661_k = 1.0f;
        this.field_662_j = 1.0f;
        this.field_663_i = 1.0f;
        this.field_665_g *= this.rand.nextFloat() * 2.0f + 0.2f;
        this.field_674_a = this.field_665_g;
        this.field_666_f = (int)(16.0 / (Math.random() * 0.8 + 0.2));
        this.field_9314_ba = false;
        this.field_670_b = 49;
    }

    @Override
    public float getEntityBrightness(float f2) {
        return 1.0f;
    }

    @Override
    public void func_406_a(Tessellator tessellator, float f2, float f1, float f22, float f3, float f4, float f5) {
        float f6 = ((float)this.field_667_e + f2) / (float)this.field_666_f;
        this.field_665_g = this.field_674_a * (1.0f - f6 * f6);
        super.func_406_a(tessellator, f2, f1, f22, f3, f4, f5);
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.field_667_e++ >= this.field_666_f) {
            this.setEntityDead();
        }
        float f2 = (float)this.field_667_e / (float)this.field_666_f;
        if (this.rand.nextFloat() > f2) {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ);
        }
        this.motionY -= 0.03;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.999f;
        this.motionY *= (double)0.999f;
        this.motionZ *= (double)0.999f;
        if (this.onGround) {
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
        }
    }
}

