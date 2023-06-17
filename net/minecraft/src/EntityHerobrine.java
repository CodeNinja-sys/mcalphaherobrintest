/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.IMobs;
import net.minecraft.src.World;

public class EntityHerobrine
extends EntityLiving
implements IMobs {
    public int field_4121_a = 0;
    public double field_4120_b;
    public double field_4127_c;
    public double field_4126_d;
    private Entity field_4123_g = null;
    private int field_4122_h = 0;
    public int despawnTime;
    public int field_4125_e = 0;
    public int field_4124_f = 0;

    public EntityHerobrine(World world) {
        super(world);
        this.texture = "/mob/herobrine.png";
        this.setSize(0.6f, 1.8f);
        this.isImmuneToFire = true;
    }

    @Override
    protected void func_418_b_() {
        this.field_4125_e = this.field_4124_f;
        if (this.field_4123_g != null && this.field_4123_g.isDead) {
            this.field_4123_g = null;
        }
        if (this.field_4123_g == null || this.field_4122_h-- <= 0) {
            this.field_4123_g = this.worldObj.getClosestPlayerToEntity(this, 100.0);
            if (this.field_4123_g != null) {
                this.field_4122_h = 20;
            }
        }
        double d4 = 64.0;
        if (this.field_4123_g != null && this.field_4123_g.getDistanceSqToEntity(this) < d4 * d4) {
            double d5 = this.field_4123_g.posX - this.posX;
            double d6 = this.field_4123_g.boundingBox.minY + (double)(this.field_4123_g.height / 2.0f) - (this.posY + (double)(this.height / 2.0f));
            double d7 = this.field_4123_g.posZ - this.posZ;
            double d8 = this.field_4123_g.posY - this.posY;
            double d9 = this.field_4123_g.posY - this.posY;
            this.field_735_n = this.rotationYaw = -((float)Math.atan2(d5, d7)) * 180.0f / 3.141593f;
            this.field_735_n = this.rotationPitch = -((float)Math.atan2(d6, d8)) * 180.0f / 3.141593f;
            if (this.canEntityBeSeen(this.field_4123_g)) {
                ++this.field_4124_f;
                if (this.field_4124_f == 20) {
                    this.field_4124_f = -40;
                }
            } else if (this.field_4124_f > 0) {
                --this.field_4124_f;
            }
        } else {
            this.field_735_n = this.rotationYaw = -((float)Math.atan2(this.motionX, this.motionZ)) * 180.0f / 3.141593f;
            this.field_735_n = this.rotationPitch = -((float)Math.atan2(this.motionY, this.motionY)) * 180.0f / 3.141593f;
            if (this.field_4124_f > 0) {
                --this.field_4124_f;
            }
        }
    }

    @Override
    public void onLivingUpdate() {
        if (this.despawnTime == 100) {
            this.setEntityDead();
        } else {
            ++this.despawnTime;
        }
        if (this.isDead) {
            if (this.rand.nextInt(2) == 0) {
                this.worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, Block.torchRedstoneActive.blockID);
            }
            if (this.rand.nextInt(2) == 0) {
                this.worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, Block.redstoneWire.blockID);
            }
            if (this.rand.nextInt(2) == 0) {
                this.worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, Block.lavaMoving.blockID);
            }
            this.rand.nextInt(2);
        }
        super.onLivingUpdate();
    }

    private boolean func_4050_a(double d2, double d1, double d22, double d3) {
        double d4 = (this.field_4120_b - this.posX) / d3;
        double d5 = (this.field_4127_c - this.posY) / d3;
        double d6 = (this.field_4126_d - this.posZ) / d3;
        AxisAlignedBB axisalignedbb = this.boundingBox.copy();
        int i2 = 1;
        while ((double)i2 < d3) {
            axisalignedbb.offset(d4, d5, d6);
            if (this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb).size() > 0) {
                return false;
            }
            ++i2;
        }
        return true;
    }

    @Override
    protected float getSoundVolume() {
        return 0.0f;
    }

    @Override
    public int func_6391_i() {
        return 1;
    }
}

