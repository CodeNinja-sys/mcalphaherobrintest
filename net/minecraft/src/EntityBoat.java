/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityBoat
extends Entity {
    public int field_807_a = 0;
    public int field_806_b = 0;
    public int field_808_c = 1;
    private int field_9394_d;
    private double field_9393_e;
    private double field_9392_f;
    private double field_9391_g;
    private double field_9390_h;
    private double field_9389_i;
    private double field_9388_j;
    private double field_9387_k;
    private double field_9386_l;

    public EntityBoat(World world) {
        super(world);
        this.field_618_ad = true;
        this.setSize(1.5f, 0.6f);
        this.yOffset = this.height / 2.0f;
        this.entityWalks = false;
    }

    @Override
    public AxisAlignedBB func_383_b_(Entity entity) {
        return entity.boundingBox;
    }

    @Override
    public AxisAlignedBB func_372_f_() {
        return this.boundingBox;
    }

    @Override
    public boolean canBePushed() {
        return true;
    }

    public EntityBoat(World world, double d2, double d1, double d22) {
        this(world);
        this.setPosition(d2, d1 + (double)this.yOffset, d22);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = d2;
        this.prevPosY = d1;
        this.prevPosZ = d22;
    }

    @Override
    public double func_402_h() {
        return (double)this.height * 0.0 - (double)0.3f;
    }

    @Override
    public boolean canAttackEntity(Entity entity, int i2) {
        if (this.worldObj.multiplayerWorld || this.isDead) {
            return true;
        }
        this.field_808_c = -this.field_808_c;
        this.field_806_b = 10;
        this.field_807_a += i2 * 10;
        this.func_9281_M();
        if (this.field_807_a > 40) {
            for (int j2 = 0; j2 < 3; ++j2) {
                this.dropItemWithOffset(Block.planks.blockID, 1, 0.0f);
            }
            for (int k2 = 0; k2 < 2; ++k2) {
                this.dropItemWithOffset(Item.stick.shiftedIndex, 1, 0.0f);
            }
            this.setEntityDead();
        }
        return true;
    }

    @Override
    public void func_9280_g() {
        this.field_808_c = -this.field_808_c;
        this.field_806_b = 10;
        this.field_807_a += this.field_807_a * 10;
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    public void setPositionAndRotation2(double d2, double d1, double d22, float f2, float f1, int i2) {
        this.field_9393_e = d2;
        this.field_9392_f = d1;
        this.field_9391_g = d22;
        this.field_9390_h = f2;
        this.field_9389_i = f1;
        this.field_9394_d = i2 + 4;
        this.motionX = this.field_9388_j;
        this.motionY = this.field_9387_k;
        this.motionZ = this.field_9386_l;
    }

    @Override
    public void setVelocity(double d2, double d1, double d22) {
        this.field_9388_j = this.motionX = d2;
        this.field_9387_k = this.motionY = d1;
        this.field_9386_l = this.motionZ = d22;
    }

    @Override
    public void onUpdate() {
        double d19;
        double d7;
        super.onUpdate();
        if (this.field_806_b > 0) {
            --this.field_806_b;
        }
        if (this.field_807_a > 0) {
            --this.field_807_a;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        int i2 = 5;
        double d2 = 0.0;
        for (int j2 = 0; j2 < i2; ++j2) {
            double d4 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(j2 + 0) / (double)i2 - 0.125;
            double d8 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(j2 + 1) / (double)i2 - 0.125;
            AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBoxFromPool(this.boundingBox.minX, d4, this.boundingBox.minZ, this.boundingBox.maxX, d8, this.boundingBox.maxZ);
            if (!this.worldObj.func_707_b(axisalignedbb, Material.water)) continue;
            d2 += 1.0 / (double)i2;
        }
        if (this.worldObj.multiplayerWorld) {
            if (this.field_9394_d > 0) {
                double d12;
                double d1 = this.posX + (this.field_9393_e - this.posX) / (double)this.field_9394_d;
                double d5 = this.posY + (this.field_9392_f - this.posY) / (double)this.field_9394_d;
                double d9 = this.posZ + (this.field_9391_g - this.posZ) / (double)this.field_9394_d;
                for (d12 = this.field_9390_h - (double)this.rotationYaw; d12 < -180.0; d12 += 360.0) {
                }
                while (d12 >= 180.0) {
                    d12 -= 360.0;
                }
                this.rotationYaw = (float)((double)this.rotationYaw + d12 / (double)this.field_9394_d);
                this.rotationPitch = (float)((double)this.rotationPitch + (this.field_9389_i - (double)this.rotationPitch) / (double)this.field_9394_d);
                --this.field_9394_d;
                this.setPosition(d1, d5, d9);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            } else {
                double d22 = this.posX + this.motionX;
                double d6 = this.posY + this.motionY;
                double d10 = this.posZ + this.motionZ;
                this.setPosition(d22, d6, d10);
                if (this.onGround) {
                    this.motionX *= 0.5;
                    this.motionY *= 0.5;
                    this.motionZ *= 0.5;
                }
                this.motionX *= (double)0.99f;
                this.motionY *= (double)0.95f;
                this.motionZ *= (double)0.99f;
            }
            return;
        }
        double d3 = d2 * 2.0 - 1.0;
        this.motionY += (double)0.04f * d3;
        if (this.riddenByEntity != null) {
            this.motionX += this.riddenByEntity.motionX * 0.2;
            this.motionZ += this.riddenByEntity.motionZ * 0.2;
        }
        if (this.motionX < -(d7 = 0.4)) {
            this.motionX = -d7;
        }
        if (this.motionX > d7) {
            this.motionX = d7;
        }
        if (this.motionZ < -d7) {
            this.motionZ = -d7;
        }
        if (this.motionZ > d7) {
            this.motionZ = d7;
        }
        if (this.onGround) {
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        double d11 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        if (d11 > 0.15) {
            double d13 = Math.cos((double)this.rotationYaw * Math.PI / 180.0);
            double d15 = Math.sin((double)this.rotationYaw * Math.PI / 180.0);
            int i1 = 0;
            while ((double)i1 < 1.0 + d11 * 60.0) {
                double d18 = this.rand.nextFloat() * 2.0f - 1.0f;
                double d20 = (double)(this.rand.nextInt(2) * 2 - 1) * 0.7;
                if (this.rand.nextBoolean()) {
                    double d21 = this.posX - d13 * d18 * 0.8 + d15 * d20;
                    double d23 = this.posZ - d15 * d18 * 0.8 - d13 * d20;
                    this.worldObj.spawnParticle("splash", d21, this.posY - 0.125, d23, this.motionX, this.motionY, this.motionZ);
                } else {
                    double d22 = this.posX + d13 + d15 * d18 * 0.7;
                    double d24 = this.posZ + d15 - d13 * d18 * 0.7;
                    this.worldObj.spawnParticle("splash", d22, this.posY - 0.125, d24, this.motionX, this.motionY, this.motionZ);
                }
                ++i1;
            }
        }
        if (this.field_9297_aI && d11 > 0.15) {
            if (!this.worldObj.multiplayerWorld) {
                this.setEntityDead();
                for (int k2 = 0; k2 < 3; ++k2) {
                    this.dropItemWithOffset(Block.planks.blockID, 1, 0.0f);
                }
                for (int l2 = 0; l2 < 2; ++l2) {
                    this.dropItemWithOffset(Item.stick.shiftedIndex, 1, 0.0f);
                }
            }
        } else {
            this.motionX *= (double)0.99f;
            this.motionY *= (double)0.95f;
            this.motionZ *= (double)0.99f;
        }
        this.rotationPitch = 0.0f;
        double d14 = this.rotationYaw;
        double d16 = this.prevPosX - this.posX;
        double d17 = this.prevPosZ - this.posZ;
        if (d16 * d16 + d17 * d17 > 0.001) {
            d14 = (float)(Math.atan2(d17, d16) * 180.0 / Math.PI);
        }
        for (d19 = d14 - (double)this.rotationYaw; d19 >= 180.0; d19 -= 360.0) {
        }
        while (d19 < -180.0) {
            d19 += 360.0;
        }
        if (d19 > 20.0) {
            d19 = 20.0;
        }
        if (d19 < -20.0) {
            d19 = -20.0;
        }
        this.rotationYaw = (float)((double)this.rotationYaw + d19);
        this.setRotation(this.rotationYaw, this.rotationPitch);
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expands(0.2f, 0.0, 0.2f));
        if (list != null && list.size() > 0) {
            for (int j1 = 0; j1 < list.size(); ++j1) {
                Entity entity = (Entity)list.get(j1);
                if (entity == this.riddenByEntity || !entity.canBePushed() || !(entity instanceof EntityBoat)) continue;
                entity.applyEntityCollision(this);
            }
        }
        if (this.riddenByEntity != null && this.riddenByEntity.isDead) {
            this.riddenByEntity = null;
        }
    }

    @Override
    public void func_366_i_() {
        if (this.riddenByEntity == null) {
            return;
        }
        double d2 = Math.cos((double)this.rotationYaw * Math.PI / 180.0) * 0.4;
        double d1 = Math.sin((double)this.rotationYaw * Math.PI / 180.0) * 0.4;
        this.riddenByEntity.setPosition(this.posX + d2, this.posY + this.func_402_h() + this.riddenByEntity.func_388_v(), this.posZ + d1);
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
    }

    @Override
    public float func_392_h_() {
        return 0.0f;
    }

    @Override
    public boolean interact(EntityPlayer entityplayer) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != entityplayer) {
            return true;
        }
        if (!this.worldObj.multiplayerWorld) {
            entityplayer.mountEntity(this);
        }
        return true;
    }
}

