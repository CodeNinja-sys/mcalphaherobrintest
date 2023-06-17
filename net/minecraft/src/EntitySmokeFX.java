/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntitySmokeFX
extends EntityFX {
    float field_671_a;

    public EntitySmokeFX(World world, double d2, double d1, double d22) {
        this(world, d2, d1, d22, 1.0f);
    }

    public EntitySmokeFX(World world, double d2, double d1, double d22, float f2) {
        super(world, d2, d1, d22, 0.0, 0.0, 0.0);
        this.motionX *= (double)0.1f;
        this.motionY *= (double)0.1f;
        this.motionZ *= (double)0.1f;
        this.field_662_j = this.field_661_k = (float)(Math.random() * (double)0.3f);
        this.field_663_i = this.field_661_k;
        this.field_665_g *= 0.75f;
        this.field_665_g *= f2;
        this.field_671_a = this.field_665_g;
        this.field_666_f = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.field_666_f = (int)((float)this.field_666_f * f2);
        this.field_9314_ba = false;
    }

    @Override
    public void func_406_a(Tessellator tessellator, float f2, float f1, float f22, float f3, float f4, float f5) {
        float f6 = ((float)this.field_667_e + f2) / (float)this.field_666_f * 32.0f;
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        this.field_665_g = this.field_671_a * f6;
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
        this.field_670_b = 7 - this.field_667_e * 8 / this.field_666_f;
        this.motionY += 0.004;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1;
            this.motionZ *= 1.1;
        }
        this.motionX *= (double)0.96f;
        this.motionY *= (double)0.96f;
        this.motionZ *= (double)0.96f;
        if (this.onGround) {
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
        }
    }
}

