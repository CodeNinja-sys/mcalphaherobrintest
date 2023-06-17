/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityExplodeFX
extends EntityFX {
    public EntityExplodeFX(World world, double d2, double d1, double d22, double d3, double d4, double d5) {
        super(world, d2, d1, d22, d3, d4, d5);
        this.motionX = d3 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.05f);
        this.motionY = d4 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.05f);
        this.motionZ = d5 + (double)((float)(Math.random() * 2.0 - 1.0) * 0.05f);
        this.field_662_j = this.field_661_k = this.rand.nextFloat() * 0.3f + 0.7f;
        this.field_663_i = this.field_661_k;
        this.field_665_g = this.rand.nextFloat() * this.rand.nextFloat() * 6.0f + 1.0f;
        this.field_666_f = (int)(16.0 / ((double)this.rand.nextFloat() * 0.8 + 0.2)) + 2;
    }

    @Override
    public void func_406_a(Tessellator tessellator, float f2, float f1, float f22, float f3, float f4, float f5) {
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
        this.motionX *= (double)0.9f;
        this.motionY *= (double)0.9f;
        this.motionZ *= (double)0.9f;
        if (this.onGround) {
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
        }
    }
}

