/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class EntityArrow
extends Entity {
    private int xTile = -1;
    private int yTile = -1;
    private int zTile = -1;
    private int inTile = 0;
    private boolean inGround = false;
    public int arrowShake = 0;
    public EntityLiving field_682_g;
    private int field_681_h;
    private int field_680_i = 0;

    public EntityArrow(World world) {
        super(world);
        this.setSize(0.5f, 0.5f);
    }

    public EntityArrow(World world, double d2, double d1, double d22) {
        super(world);
        this.setSize(0.5f, 0.5f);
        this.setPosition(d2, d1, d22);
        this.yOffset = 0.0f;
    }

    public EntityArrow(World world, EntityLiving entityliving) {
        super(world);
        this.field_682_g = entityliving;
        this.setSize(0.5f, 0.5f);
        this.setLocationAndAngles(entityliving.posX, entityliving.posY + (double)entityliving.func_373_s(), entityliving.posZ, entityliving.rotationYaw, entityliving.rotationPitch);
        this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0f * 3.141593f) * 0.16f);
        this.posY -= (double)0.1f;
        this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0f * 3.141593f) * 0.16f);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0f * 3.141593f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.141593f);
        this.motionZ = MathHelper.cos(this.rotationYaw / 180.0f * 3.141593f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.141593f);
        this.motionY = -MathHelper.sin(this.rotationPitch / 180.0f * 3.141593f);
        this.func_408_a(this.motionX, this.motionY, this.motionZ, 1.5f, 1.0f);
    }

    public void func_408_a(double d2, double d1, double d22, float f2, float f1) {
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
        this.field_681_h = 0;
    }

    @Override
    public void setVelocity(double d2, double d1, double d22) {
        this.motionX = d2;
        this.motionY = d1;
        this.motionZ = d22;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            float f2 = MathHelper.sqrt_double(d2 * d2 + d22 * d22);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(d2, d22) * 180.0 / 3.1415927410125732);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(d1, f2) * 180.0 / 3.1415927410125732);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.1415927410125732);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, f2) * 180.0 / 3.1415927410125732);
        }
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (this.inGround) {
            int i2 = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
            if (i2 == this.inTile) {
                ++this.field_681_h;
                if (this.field_681_h != 1200) return;
                this.setEntityDead();
                return;
            }
            this.inGround = false;
            this.motionX *= (double)(this.rand.nextFloat() * 0.2f);
            this.motionY *= (double)(this.rand.nextFloat() * 0.2f);
            this.motionZ *= (double)(this.rand.nextFloat() * 0.2f);
            this.field_681_h = 0;
            this.field_680_i = 0;
        } else {
            ++this.field_680_i;
        }
        Vec3D vec3d = Vec3D.createVector(this.posX, this.posY, this.posZ);
        Vec3D vec3d1 = Vec3D.createVector(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3d, vec3d1);
        vec3d = Vec3D.createVector(this.posX, this.posY, this.posZ);
        vec3d1 = Vec3D.createVector(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if (movingobjectposition != null) {
            vec3d1 = Vec3D.createVector(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
        }
        Entity entity = null;
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expands(1.0, 1.0, 1.0));
        double d2 = 0.0;
        for (int j2 = 0; j2 < list.size(); ++j2) {
            double d1;
            float f4;
            AxisAlignedBB axisalignedbb;
            MovingObjectPosition movingobjectposition1;
            Entity entity1 = (Entity)list.get(j2);
            if (!entity1.canBeCollidedWith() || entity1 == this.field_682_g && this.field_680_i < 5 || (movingobjectposition1 = (axisalignedbb = entity1.boundingBox.expands(f4 = 0.3f, f4, f4)).func_1169_a(vec3d, vec3d1)) == null || !((d1 = vec3d.distanceTo(movingobjectposition1.hitVec)) < d2) && d2 != 0.0) continue;
            entity = entity1;
            d2 = d1;
        }
        if (entity != null) {
            movingobjectposition = new MovingObjectPosition(entity);
        }
        if (movingobjectposition != null) {
            if (movingobjectposition.entityHit != null) {
                if (movingobjectposition.entityHit.canAttackEntity(this.field_682_g, 4)) {
                    this.worldObj.playSoundAtEntity(this, "random.drr", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                    this.setEntityDead();
                } else {
                    this.motionX *= (double)-0.1f;
                    this.motionY *= (double)-0.1f;
                    this.motionZ *= (double)-0.1f;
                    this.rotationYaw += 180.0f;
                    this.prevRotationYaw += 180.0f;
                    this.field_680_i = 0;
                }
            } else {
                this.xTile = movingobjectposition.blockX;
                this.yTile = movingobjectposition.blockY;
                this.zTile = movingobjectposition.blockZ;
                this.inTile = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
                this.motionX = (float)(movingobjectposition.hitVec.xCoord - this.posX);
                this.motionY = (float)(movingobjectposition.hitVec.yCoord - this.posY);
                this.motionZ = (float)(movingobjectposition.hitVec.zCoord - this.posZ);
                float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                this.posX -= this.motionX / (double)f1 * (double)0.05f;
                this.posY -= this.motionY / (double)f1 * (double)0.05f;
                this.posZ -= this.motionZ / (double)f1 * (double)0.05f;
                this.worldObj.playSoundAtEntity(this, "random.drr", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                this.inGround = true;
                this.arrowShake = 7;
            }
        }
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.1415927410125732);
        this.rotationPitch = (float)(Math.atan2(this.motionY, f2) * 180.0 / 3.1415927410125732);
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
        float f3 = 0.99f;
        float f5 = 0.03f;
        if (this.handleWaterMovement()) {
            for (int k2 = 0; k2 < 4; ++k2) {
                float f6 = 0.25f;
                this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f6, this.posY - this.motionY * (double)f6, this.posZ - this.motionZ * (double)f6, this.motionX, this.motionY, this.motionZ);
            }
            f3 = 0.8f;
        }
        this.motionX *= (double)f3;
        this.motionY *= (double)f3;
        this.motionZ *= (double)f3;
        this.motionY -= (double)f5;
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setShort("xTile", (short)this.xTile);
        nbttagcompound.setShort("yTile", (short)this.yTile);
        nbttagcompound.setShort("zTile", (short)this.zTile);
        nbttagcompound.setByte("inTile", (byte)this.inTile);
        nbttagcompound.setByte("shake", (byte)this.arrowShake);
        nbttagcompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        this.xTile = nbttagcompound.getShort("xTile");
        this.yTile = nbttagcompound.getShort("yTile");
        this.zTile = nbttagcompound.getShort("zTile");
        this.inTile = nbttagcompound.getByte("inTile") & 0xFF;
        this.arrowShake = nbttagcompound.getByte("shake") & 0xFF;
        this.inGround = nbttagcompound.getByte("inGround") == 1;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityplayer) {
        if (this.worldObj.multiplayerWorld) {
            return;
        }
        if (this.inGround && this.field_682_g == entityplayer && this.arrowShake <= 0 && entityplayer.inventory.addItemStackToInventory(new ItemStack(Item.arrow.shiftedIndex, 1))) {
            this.worldObj.playSoundAtEntity(this, "random.pop", 0.2f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            entityplayer.func_443_a_(this, 1);
            this.setEntityDead();
        }
    }

    @Override
    public float func_392_h_() {
        return 0.0f;
    }
}

