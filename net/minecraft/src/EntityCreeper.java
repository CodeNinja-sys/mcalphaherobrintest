/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityMobs;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.Item;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityCreeper
extends EntityMobs {
    int timeSinceIgnited;
    int lastActiveTime;
    int fuseTime = 30;
    int creeperState = -1;
    int field_12241_e = -1;

    public EntityCreeper(World world) {
        super(world);
        this.texture = "/mob/creeper.png";
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
    public void func_9282_a(byte byte0) {
        super.func_9282_a(byte0);
        if (byte0 == 4) {
            if (this.timeSinceIgnited == 0) {
                this.worldObj.playSoundAtEntity(this, "random.fuse", 1.0f, 0.5f);
            }
            this.creeperState = 1;
        }
        if (byte0 == 5) {
            this.creeperState = -1;
        }
    }

    @Override
    public void onUpdate() {
        this.lastActiveTime = this.timeSinceIgnited;
        if (this.worldObj.multiplayerWorld) {
            this.timeSinceIgnited += this.creeperState;
            if (this.timeSinceIgnited < 0) {
                this.timeSinceIgnited = 0;
            }
            if (this.timeSinceIgnited >= this.fuseTime) {
                this.timeSinceIgnited = this.fuseTime;
            }
        }
        super.onUpdate();
    }

    @Override
    protected void func_418_b_() {
        if (this.field_12241_e != this.creeperState) {
            this.field_12241_e = this.creeperState;
            if (this.creeperState > 0) {
                this.worldObj.func_9425_a(this, (byte)4);
            } else {
                this.worldObj.func_9425_a(this, (byte)5);
            }
        }
        this.lastActiveTime = this.timeSinceIgnited;
        if (this.worldObj.multiplayerWorld) {
            super.func_418_b_();
        } else {
            if (this.timeSinceIgnited > 0 && this.creeperState < 0) {
                --this.timeSinceIgnited;
            }
            if (this.creeperState >= 0) {
                this.creeperState = 2;
            }
            super.func_418_b_();
            if (this.creeperState != 1) {
                this.creeperState = -1;
            }
        }
    }

    @Override
    protected String getHurtSound() {
        return "mob.creeper";
    }

    @Override
    protected String getDeathSound() {
        return "mob.creeperdeath";
    }

    @Override
    public void onDeath(Entity entity) {
        super.onDeath(entity);
        if (entity instanceof EntitySkeleton) {
            this.dropItem(Item.record13.shiftedIndex + this.rand.nextInt(2), 1);
        }
    }

    @Override
    protected void attackEntity(Entity entity, float f2) {
        if (this.creeperState <= 0 && f2 < 3.0f || this.creeperState > 0 && f2 < 7.0f) {
            if (this.timeSinceIgnited == 0) {
                this.worldObj.playSoundAtEntity(this, "random.fuse", 1.0f, 0.5f);
            }
            this.creeperState = 1;
            ++this.timeSinceIgnited;
            if (this.timeSinceIgnited == this.fuseTime) {
                this.worldObj.func_12243_a(this, this.posX, this.posY, this.posZ, 3.0f);
                this.setEntityDead();
            }
            this.hasAttacked = true;
        }
    }

    public float func_440_b(float f2) {
        return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * f2) / (float)(this.fuseTime - 2);
    }

    @Override
    protected int getDropItemId() {
        return Item.gunpowder.shiftedIndex;
    }
}

