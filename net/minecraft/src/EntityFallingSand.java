/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityFallingSand
extends Entity {
    public int field_799_a;
    public int field_798_b = 0;

    public EntityFallingSand(World world) {
        super(world);
    }

    public EntityFallingSand(World world, float f2, float f1, float f22, int i2) {
        super(world);
        this.field_799_a = i2;
        this.field_618_ad = true;
        this.setSize(0.98f, 0.98f);
        this.yOffset = this.height / 2.0f;
        this.setPosition(f2, f1, f22);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.entityWalks = false;
        this.prevPosX = f2;
        this.prevPosY = f1;
        this.prevPosZ = f22;
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    public void onUpdate() {
        if (this.field_799_a == 0) {
            this.setEntityDead();
            return;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        ++this.field_798_b;
        this.motionY -= (double)0.04f;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.98f;
        this.motionY *= (double)0.98f;
        this.motionZ *= (double)0.98f;
        int i2 = MathHelper.floor_double(this.posX);
        int j2 = MathHelper.floor_double(this.posY);
        int k2 = MathHelper.floor_double(this.posZ);
        if (this.worldObj.getBlockId(i2, j2, k2) == this.field_799_a) {
            this.worldObj.setBlockWithNotify(i2, j2, k2, 0);
        }
        if (this.onGround) {
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
            this.motionY *= -0.5;
            this.setEntityDead();
            if (!this.worldObj.canBlockBePlacedAt(this.field_799_a, i2, j2, k2, true) || !this.worldObj.setBlockWithNotify(i2, j2, k2, this.field_799_a)) {
                this.dropItem(this.field_799_a, 1);
            }
        } else if (this.field_798_b > 100) {
            this.dropItem(this.field_799_a, 1);
            this.setEntityDead();
        }
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setByte("Tile", (byte)this.field_799_a);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        this.field_799_a = nbttagcompound.getByte("Tile") & 0xFF;
    }

    @Override
    public float func_392_h_() {
        return 0.0f;
    }

    public World func_465_i() {
        return this.worldObj;
    }
}

