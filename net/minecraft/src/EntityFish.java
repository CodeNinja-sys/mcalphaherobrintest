/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class EntityFish
extends Entity {
    private int field_4095_d = -1;
    private int field_4094_e = -1;
    private int field_4093_f = -1;
    private int field_4092_g = 0;
    private boolean field_4091_h = false;
    public int field_4098_a = 0;
    public EntityPlayer field_4097_b;
    private int field_4090_i;
    private int field_4089_j = 0;
    private int field_4088_k = 0;
    public Entity field_4096_c = null;
    private int field_6388_l;
    private double field_6387_m;
    private double field_6386_n;
    private double field_6385_o;
    private double field_6384_p;
    private double field_6383_q;
    private double velocityX;
    private double velocityY;
    private double velocityZ;

    public EntityFish(World world) {
        super(world);
        this.setSize(0.25f, 0.25f);
    }

    @Override
    public boolean func_384_a(double d2) {
        double d1 = this.boundingBox.getAverageEdgeLength() * 4.0;
        return d2 < (d1 *= 64.0) * d1;
    }

    public EntityFish(World world, double d2, double d1, double d22) {
        this(world);
        this.setPosition(d2, d1, d22);
    }

    public EntityFish(World world, EntityPlayer entityplayer) {
        super(world);
        this.field_4097_b = entityplayer;
        this.field_4097_b.fishEntity = this;
        this.setSize(0.25f, 0.25f);
        this.setLocationAndAngles(entityplayer.posX, entityplayer.posY + 1.62 - (double)entityplayer.yOffset, entityplayer.posZ, entityplayer.rotationYaw, entityplayer.rotationPitch);
        this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0f * 3.141593f) * 0.16f);
        this.posY -= (double)0.1f;
        this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0f * 3.141593f) * 0.16f);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        float f2 = 0.4f;
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0f * 3.141593f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.141593f) * f2;
        this.motionZ = MathHelper.cos(this.rotationYaw / 180.0f * 3.141593f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.141593f) * f2;
        this.motionY = -MathHelper.sin(this.rotationPitch / 180.0f * 3.141593f) * f2;
        this.func_4042_a(this.motionX, this.motionY, this.motionZ, 1.5f, 1.0f);
    }

    public void func_4042_a(double d2, double d1, double d22, float f2, float f1) {
        float f22 = MathHelper.sqrt_double(d2 * d2 + d1 * d1 + d22 * d22);
        d2 /= (double)f22;
        d1 /= (double)f22;
        d22 /= (double)f22;
        d2 += this.rand.nextGaussian() * (double)0.0075f * (double)f1;
        d1 += this.rand.nextGaussian() * (double)0.0075f * (double)f1;
        d22 += this.rand.nextGaussian() * (double)0.0075f * (double)f1;
        this.motionX = d2 *= (double)f2;
        this.motionY = d1 *= (double)f2;
        this.motionZ = d22 *= (double)f2;
        float f3 = MathHelper.sqrt_double(d2 * d2 + d22 * d22);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(d2, d22) * 180.0 / 3.1415927410125732);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(d1, f3) * 180.0 / 3.1415927410125732);
        this.field_4090_i = 0;
    }

    @Override
    public void setPositionAndRotation2(double d2, double d1, double d22, float f2, float f1, int i2) {
        this.field_6387_m = d2;
        this.field_6386_n = d1;
        this.field_6385_o = d22;
        this.field_6384_p = f2;
        this.field_6383_q = f1;
        this.field_6388_l = i2;
        this.motionX = this.velocityX;
        this.motionY = this.velocityY;
        this.motionZ = this.velocityZ;
    }

    @Override
    public void setVelocity(double d2, double d1, double d22) {
        this.velocityX = this.motionX = d2;
        this.velocityY = this.motionY = d1;
        this.velocityZ = this.motionZ = d22;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void onUpdate() {
        block33: {
            super.onUpdate();
            if (this.field_6388_l <= 0) break block33;
            d = this.posX + (this.field_6387_m - this.posX) / (double)this.field_6388_l;
            d1 = this.posY + (this.field_6386_n - this.posY) / (double)this.field_6388_l;
            d2 = this.posZ + (this.field_6385_o - this.posZ) / (double)this.field_6388_l;
            d4 = this.field_6384_p - (double)this.rotationYaw;
            ** GOTO lbl52
        }
        if (!this.worldObj.multiplayerWorld) {
            itemstack = this.field_4097_b.getCurrentEquippedItem();
            if (this.field_4097_b.isDead || !this.field_4097_b.isEntityAlive() || itemstack == null || itemstack.getItem() != Item.fishingRod || this.getDistanceSqToEntity(this.field_4097_b) > 1024.0) {
                this.setEntityDead();
                this.field_4097_b.fishEntity = null;
                return;
            }
            if (this.field_4096_c != null) {
                if (!this.field_4096_c.isDead) {
                    this.posX = this.field_4096_c.posX;
                    this.posY = this.field_4096_c.boundingBox.minY + (double)this.field_4096_c.height * 0.8;
                    this.posZ = this.field_4096_c.posZ;
                    return;
                }
                this.field_4096_c = null;
            }
        }
        if (this.field_4098_a > 0) {
            --this.field_4098_a;
        }
        if (this.field_4091_h) {
            i = this.worldObj.getBlockId(this.field_4095_d, this.field_4094_e, this.field_4093_f);
            if (i == this.field_4092_g) {
                ++this.field_4090_i;
                if (this.field_4090_i != 1200) return;
                this.setEntityDead();
                return;
            }
            this.field_4091_h = false;
            this.motionX *= (double)(this.rand.nextFloat() * 0.2f);
            this.motionY *= (double)(this.rand.nextFloat() * 0.2f);
            this.motionZ *= (double)(this.rand.nextFloat() * 0.2f);
            this.field_4090_i = 0;
            this.field_4089_j = 0;
        } else {
            ++this.field_4089_j;
        }
        vec3d = Vec3D.createVector(this.posX, this.posY, this.posZ);
        vec3d1 = Vec3D.createVector(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        movingobjectposition = this.worldObj.rayTraceBlocks(vec3d, vec3d1);
        vec3d = Vec3D.createVector(this.posX, this.posY, this.posZ);
        vec3d1 = Vec3D.createVector(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if (movingobjectposition != null) {
            vec3d1 = Vec3D.createVector(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
        }
        entity = null;
        list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expands(1.0, 1.0, 1.0));
        d3 = 0.0;
        j = 0;
        ** GOTO lbl67
lbl-1000:
        // 1 sources

        {
            d4 += 360.0;
lbl52:
            // 2 sources

            ** while (d4 < -180.0)
        }
lbl53:
        // 2 sources

        while (d4 >= 180.0) {
            d4 -= 360.0;
        }
        this.rotationYaw = (float)((double)this.rotationYaw + d4 / (double)this.field_6388_l);
        this.rotationPitch = (float)((double)this.rotationPitch + (this.field_6383_q - (double)this.rotationPitch) / (double)this.field_6388_l);
        --this.field_6388_l;
        this.setPosition(d, d1, d2);
        this.setRotation(this.rotationYaw, this.rotationPitch);
        return;
lbl-1000:
        // 1 sources

        {
            entity1 = (Entity)list.get(j);
            if (entity1.canBeCollidedWith() && (entity1 != this.field_4097_b || this.field_4089_j >= 5) && (movingobjectposition1 = (axisalignedbb = entity1.boundingBox.expands(f2 = 0.3f, f2, f2)).func_1169_a(vec3d, vec3d1)) != null && ((d6 = vec3d.distanceTo(movingobjectposition1.hitVec)) < d3 || d3 == 0.0)) {
                entity = entity1;
                d3 = d6;
            }
            ++j;
lbl67:
            // 2 sources

            ** while (j < list.size())
        }
lbl68:
        // 1 sources

        if (entity != null) {
            movingobjectposition = new MovingObjectPosition(entity);
        }
        if (movingobjectposition != null) {
            if (movingobjectposition.entityHit != null) {
                if (movingobjectposition.entityHit.canAttackEntity(this.field_4097_b, 0)) {
                    this.field_4096_c = movingobjectposition.entityHit;
                }
            } else {
                this.field_4091_h = true;
            }
        }
        if (this.field_4091_h) {
            return;
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.1415927410125732);
        this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0 / 3.1415927410125732);
        while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
            this.prevRotationPitch -= 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
            this.prevRotationPitch += 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
            this.prevRotationYaw -= 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
            this.prevRotationYaw += 360.0f;
        }
        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
        f1 = 0.92f;
        if (this.onGround || this.field_9297_aI) {
            f1 = 0.5f;
        }
        k = 5;
        d5 = 0.0;
        for (l = 0; l < k; ++l) {
            d8 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(l + 0) / (double)k - 0.125 + 0.125;
            d9 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(l + 1) / (double)k - 0.125 + 0.125;
            axisalignedbb1 = AxisAlignedBB.getBoundingBoxFromPool(this.boundingBox.minX, d8, this.boundingBox.minZ, this.boundingBox.maxX, d9, this.boundingBox.maxZ);
            if (!this.worldObj.func_707_b(axisalignedbb1, Material.water)) continue;
            d5 += 1.0 / (double)k;
        }
        if (d5 > 0.0) {
            if (this.field_4088_k > 0) {
                --this.field_4088_k;
            } else if (this.rand.nextInt(500) == 0) {
                this.field_4088_k = this.rand.nextInt(30) + 10;
                this.motionY -= 0.20000000298023224;
                this.worldObj.playSoundAtEntity(this, "random.splash", 0.25f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                f3 = MathHelper.floor_double(this.boundingBox.minY);
                i1 = 0;
                while ((float)i1 < 1.0f + this.width * 20.0f) {
                    f4 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                    f6 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                    this.worldObj.spawnParticle("bubble", this.posX + (double)f4, f3 + 1.0f, this.posZ + (double)f6, this.motionX, this.motionY - (double)(this.rand.nextFloat() * 0.2f), this.motionZ);
                    ++i1;
                }
                j1 = 0;
                while ((float)j1 < 1.0f + this.width * 20.0f) {
                    f5 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                    f7 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                    this.worldObj.spawnParticle("splash", this.posX + (double)f5, f3 + 1.0f, this.posZ + (double)f7, this.motionX, this.motionY, this.motionZ);
                    ++j1;
                }
            }
        }
        if (this.field_4088_k > 0) {
            this.motionY -= (double)(this.rand.nextFloat() * this.rand.nextFloat() * this.rand.nextFloat()) * 0.2;
        }
        d7 = d5 * 2.0 - 1.0;
        this.motionY += 0.03999999910593033 * d7;
        if (d5 > 0.0) {
            f1 = (float)((double)f1 * 0.9);
            this.motionY *= 0.8;
        }
        this.motionX *= (double)f1;
        this.motionY *= (double)f1;
        this.motionZ *= (double)f1;
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setShort("xTile", (short)this.field_4095_d);
        nbttagcompound.setShort("yTile", (short)this.field_4094_e);
        nbttagcompound.setShort("zTile", (short)this.field_4093_f);
        nbttagcompound.setByte("inTile", (byte)this.field_4092_g);
        nbttagcompound.setByte("shake", (byte)this.field_4098_a);
        nbttagcompound.setByte("inGround", (byte)(this.field_4091_h ? 1 : 0));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        this.field_4095_d = nbttagcompound.getShort("xTile");
        this.field_4094_e = nbttagcompound.getShort("yTile");
        this.field_4093_f = nbttagcompound.getShort("zTile");
        this.field_4092_g = nbttagcompound.getByte("inTile") & 0xFF;
        this.field_4098_a = nbttagcompound.getByte("shake") & 0xFF;
        this.field_4091_h = nbttagcompound.getByte("inGround") == 1;
    }

    @Override
    public float func_392_h_() {
        return 0.0f;
    }

    public int func_4043_i() {
        int byte0 = 0;
        if (this.field_4096_c != null) {
            double d2 = this.field_4097_b.posX - this.posX;
            double d22 = this.field_4097_b.posY - this.posY;
            double d4 = this.field_4097_b.posZ - this.posZ;
            double d6 = MathHelper.sqrt_double(d2 * d2 + d22 * d22 + d4 * d4);
            double d8 = 0.1;
            this.field_4096_c.motionX += d2 * d8;
            this.field_4096_c.motionY += d22 * d8 + (double)MathHelper.sqrt_double(d6) * 0.08;
            this.field_4096_c.motionZ += d4 * d8;
            byte0 = 3;
        } else if (this.field_4088_k > 0) {
            EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Item.fishRaw.shiftedIndex));
            double d1 = this.field_4097_b.posX - this.posX;
            double d3 = this.field_4097_b.posY - this.posY;
            double d5 = this.field_4097_b.posZ - this.posZ;
            double d7 = MathHelper.sqrt_double(d1 * d1 + d3 * d3 + d5 * d5);
            double d9 = 0.1;
            entityitem.motionX = d1 * d9;
            entityitem.motionY = d3 * d9 + (double)MathHelper.sqrt_double(d7) * 0.08;
            entityitem.motionZ = d5 * d9;
            this.worldObj.entityJoinedWorld(entityitem);
            byte0 = 1;
        }
        if (this.field_4091_h) {
            byte0 = 2;
        }
        this.setEntityDead();
        this.field_4097_b.fishEntity = null;
        return byte0;
    }
}

