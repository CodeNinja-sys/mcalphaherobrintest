/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityTNTPrimed
extends Entity {
    public int fuse = 0;

    public EntityTNTPrimed(World world) {
        super(world);
        this.field_618_ad = true;
        this.setSize(0.98f, 0.98f);
        this.yOffset = this.height / 2.0f;
    }

    public EntityTNTPrimed(World world, double d2, double d1, double d22) {
        this(world);
        this.setPosition(d2, d1, d22);
        float f2 = (float)(Math.random() * 3.1415927410125732 * 2.0);
        this.motionX = -MathHelper.sin(f2 * 3.141593f / 180.0f) * 0.02f;
        this.motionY = 0.2f;
        this.motionZ = -MathHelper.cos(f2 * 3.141593f / 180.0f) * 0.02f;
        this.entityWalks = false;
        this.fuse = 80;
        this.prevPosX = d2;
        this.prevPosY = d1;
        this.prevPosZ = d22;
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= (double)0.04f;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.98f;
        this.motionY *= (double)0.98f;
        this.motionZ *= (double)0.98f;
        if (this.onGround) {
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
            this.motionY *= -0.5;
        }
        if (this.fuse-- <= 0) {
            this.setEntityDead();
            this.explode();
        } else {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5, this.posZ, 0.0, 0.0, 0.0);
        }
    }

    private void explode() {
        float f2 = 4.0f;
        this.worldObj.func_12243_a(null, this.posX, this.posY, this.posZ, f2);
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setByte("Fuse", (byte)this.fuse);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        this.fuse = nbttagcompound.getByte("Fuse");
    }

    @Override
    public float func_392_h_() {
        return 0.0f;
    }
}

