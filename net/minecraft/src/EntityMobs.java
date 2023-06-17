/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.IMobs;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityMobs
extends EntityCreature
implements IMobs {
    protected int field_762_e = 2;

    public EntityMobs(World world) {
        super(world);
        this.health = 20;
    }

    @Override
    public void onLivingUpdate() {
        float f2 = this.getEntityBrightness(1.0f);
        if (f2 > 0.5f) {
            this.field_9344_ag += 2;
        }
        super.onLivingUpdate();
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.difficultySetting == 0) {
            this.setEntityDead();
        }
    }

    @Override
    protected Entity findPlayerToAttack() {
        EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity(this, 16.0);
        if (entityplayer != null && this.canEntityBeSeen(entityplayer)) {
            return entityplayer;
        }
        return null;
    }

    @Override
    public boolean canAttackEntity(Entity entity, int i2) {
        if (super.canAttackEntity(entity, i2)) {
            if (this.riddenByEntity == entity || this.ridingEntity == entity) {
                return true;
            }
            if (entity != this) {
                this.playerToAttack = entity;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void attackEntity(Entity entity, float f2) {
        if ((double)f2 < 2.5 && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            entity.canAttackEntity(this, this.field_762_e);
        }
    }

    @Override
    protected float func_439_a(int i2, int j2, int k2) {
        return 0.5f - this.worldObj.getLightBrightness(i2, j2, k2);
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
    public boolean getCanSpawnHere() {
        int k2;
        int j2;
        int i2 = MathHelper.floor_double(this.posX);
        if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i2, j2 = MathHelper.floor_double(this.boundingBox.minY), k2 = MathHelper.floor_double(this.posZ)) > this.rand.nextInt(32)) {
            return false;
        }
        int l2 = this.worldObj.getBlockLightValue(i2, j2, k2);
        return l2 <= this.rand.nextInt(8) && super.getCanSpawnHere();
    }
}

