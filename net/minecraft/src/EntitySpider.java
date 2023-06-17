/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityMobs;
import net.minecraft.src.Item;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntitySpider
extends EntityMobs {
    public EntitySpider(World world) {
        super(world);
        this.texture = "/mob/spider.png";
        this.setSize(1.4f, 0.9f);
        this.field_9333_am = 0.8f;
    }

    @Override
    public double func_402_h() {
        return (double)this.height * 0.75 - 0.5;
    }

    @Override
    protected Entity findPlayerToAttack() {
        float f2 = this.getEntityBrightness(1.0f);
        if (f2 < 0.5f) {
            double d2 = 16.0;
            return this.worldObj.getClosestPlayerToEntity(this, d2);
        }
        return null;
    }

    @Override
    protected String getLivingSound() {
        return "mob.spider";
    }

    @Override
    protected String getHurtSound() {
        return "mob.spider";
    }

    @Override
    protected String getDeathSound() {
        return "mob.spiderdeath";
    }

    @Override
    protected void attackEntity(Entity entity, float f2) {
        float f1 = this.getEntityBrightness(1.0f);
        if (f1 > 0.5f && this.rand.nextInt(100) == 0) {
            this.playerToAttack = null;
            return;
        }
        if (f2 > 2.0f && f2 < 6.0f && this.rand.nextInt(10) == 0) {
            if (this.onGround) {
                double d2 = entity.posX - this.posX;
                double d1 = entity.posZ - this.posZ;
                float f22 = MathHelper.sqrt_double(d2 * d2 + d1 * d1);
                this.motionX = d2 / (double)f22 * 0.5 * (double)0.8f + this.motionX * (double)0.2f;
                this.motionZ = d1 / (double)f22 * 0.5 * (double)0.8f + this.motionZ * (double)0.2f;
                this.motionY = 0.4f;
            }
        } else {
            super.attackEntity(entity, f2);
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
    }

    @Override
    protected int getDropItemId() {
        return Item.silk.shiftedIndex;
    }
}

