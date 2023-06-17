/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityFireball;
import net.minecraft.src.EntityFlying;
import net.minecraft.src.IMobs;
import net.minecraft.src.Item;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class EntityGhast
extends EntityFlying
implements IMobs {
    public int field_4121_a = 0;
    public double field_4120_b;
    public double field_4127_c;
    public double field_4126_d;
    private Entity field_4123_g = null;
    private int field_4122_h = 0;
    public int field_4125_e = 0;
    public int field_4124_f = 0;

    public EntityGhast(World world) {
        super(world);
        this.texture = "/mob/ghast.png";
        this.setSize(4.0f, 4.0f);
        this.isImmuneToFire = true;
    }

    @Override
    protected void func_418_b_() {
        if (this.worldObj.difficultySetting == 0) {
            this.setEntityDead();
        }
        this.field_4125_e = this.field_4124_f;
        double d2 = this.field_4120_b - this.posX;
        double d1 = this.field_4127_c - this.posY;
        double d22 = this.field_4126_d - this.posZ;
        double d3 = MathHelper.sqrt_double(d2 * d2 + d1 * d1 + d22 * d22);
        if (d3 < 1.0 || d3 > 60.0) {
            this.field_4120_b = this.posX + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.field_4127_c = this.posY + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.field_4126_d = this.posZ + (double)((this.rand.nextFloat() * 2.0f - 1.0f) * 16.0f);
        }
        if (this.field_4121_a-- <= 0) {
            this.field_4121_a += this.rand.nextInt(5) + 2;
            if (this.func_4050_a(this.field_4120_b, this.field_4127_c, this.field_4126_d, d3)) {
                this.motionX += d2 / d3 * 0.1;
                this.motionY += d1 / d3 * 0.1;
                this.motionZ += d22 / d3 * 0.1;
            } else {
                this.field_4120_b = this.posX;
                this.field_4127_c = this.posY;
                this.field_4126_d = this.posZ;
            }
        }
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
            this.field_735_n = this.rotationYaw = -((float)Math.atan2(d5, d7)) * 180.0f / 3.141593f;
            if (this.canEntityBeSeen(this.field_4123_g)) {
                if (this.field_4124_f == 10) {
                    this.worldObj.playSoundAtEntity(this, "mob.ghast.charge", this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
                }
                ++this.field_4124_f;
                if (this.field_4124_f == 20) {
                    this.worldObj.playSoundAtEntity(this, "mob.ghast.fireball", this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
                    EntityFireball entityfireball = new EntityFireball(this.worldObj, this, d5, d6, d7);
                    double d8 = 4.0;
                    Vec3D vec3d = this.getLook(1.0f);
                    entityfireball.posX = this.posX + vec3d.xCoord * d8;
                    entityfireball.posY = this.posY + (double)(this.height / 2.0f) + 0.5;
                    entityfireball.posZ = this.posZ + vec3d.zCoord * d8;
                    this.worldObj.entityJoinedWorld(entityfireball);
                    this.field_4124_f = -40;
                }
            } else if (this.field_4124_f > 0) {
                --this.field_4124_f;
            }
        } else {
            this.field_735_n = this.rotationYaw = -((float)Math.atan2(this.motionX, this.motionZ)) * 180.0f / 3.141593f;
            if (this.field_4124_f > 0) {
                --this.field_4124_f;
            }
        }
        this.texture = this.field_4124_f <= 10 ? "/mob/ghast.png" : "/mob/ghast_fire.png";
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
    protected String getLivingSound() {
        return "mob.ghast.moan";
    }

    @Override
    protected String getHurtSound() {
        return "mob.ghast.scream";
    }

    @Override
    protected String getDeathSound() {
        return "mob.ghast.death";
    }

    @Override
    protected int getDropItemId() {
        return Item.gunpowder.shiftedIndex;
    }

    @Override
    protected float getSoundVolume() {
        return 10.0f;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.rand.nextInt(20) == 0 && super.getCanSpawnHere() && this.worldObj.difficultySetting > 0;
    }

    @Override
    public int func_6391_i() {
        return 1;
    }
}

