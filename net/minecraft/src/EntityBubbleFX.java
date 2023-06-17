/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EntityBubbleFX
extends EntityFX {
    public EntityBubbleFX(World world, double d2, double d1, double d22, double d3, double d4, double d5) {
        super(world, d2, d1, d22, d3, d4, d5);
        this.field_663_i = 1.0f;
        this.field_662_j = 1.0f;
        this.field_661_k = 1.0f;
        this.field_670_b = 32;
        this.setSize(0.02f, 0.02f);
        this.field_665_g *= this.rand.nextFloat() * 0.6f + 0.2f;
        this.motionX = d3 * (double)0.2f + (double)((float)(Math.random() * 2.0 - 1.0) * 0.02f);
        this.motionY = d4 * (double)0.2f + (double)((float)(Math.random() * 2.0 - 1.0) * 0.02f);
        this.motionZ = d5 * (double)0.2f + (double)((float)(Math.random() * 2.0 - 1.0) * 0.02f);
        this.field_666_f = (int)(8.0 / (Math.random() * 0.8 + 0.2));
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY += 0.002;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.85f;
        this.motionY *= (double)0.85f;
        this.motionZ *= (double)0.85f;
        if (this.worldObj.getBlockMaterial(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) != Material.water) {
            this.setEntityDead();
        }
        if (this.field_666_f-- <= 0) {
            this.setEntityDead();
        }
    }
}

