/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class EntityFireball
extends Entity {
    private int field_9402_e = -1;
    private int field_9401_f = -1;
    private int field_9400_g = -1;
    private int field_9399_h = 0;
    private boolean field_9398_i = false;
    public int field_9406_a = 0;
    private EntityLiving field_9397_j;
    private int field_9396_k;
    private int field_9395_l = 0;
    public double field_9405_b;
    public double field_9404_c;
    public double field_9403_d;

    public EntityFireball(World world) {
        super(world);
        this.setSize(1.0f, 1.0f);
    }

    @Override
    public boolean func_384_a(double d2) {
        double d1 = this.boundingBox.getAverageEdgeLength() * 4.0;
        return d2 < (d1 *= 64.0) * d1;
    }

    public EntityFireball(World world, EntityLiving entityliving, double d2, double d1, double d22) {
        super(world);
        this.field_9397_j = entityliving;
        this.setSize(1.0f, 1.0f);
        this.setLocationAndAngles(entityliving.posX, entityliving.posY, entityliving.posZ, entityliving.rotationYaw, entityliving.rotationPitch);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        this.motionZ = 0.0;
        this.motionY = 0.0;
        this.motionX = 0.0;
        double d3 = MathHelper.sqrt_double((d2 += this.rand.nextGaussian() * 0.4) * d2 + (d1 += this.rand.nextGaussian() * 0.4) * d1 + (d22 += this.rand.nextGaussian() * 0.4) * d22);
        this.field_9405_b = d2 / d3 * 0.1;
        this.field_9404_c = d1 / d3 * 0.1;
        this.field_9403_d = d22 / d3 * 0.1;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.fire = 10;
        if (this.field_9406_a > 0) {
            --this.field_9406_a;
        }
        if (this.field_9398_i) {
            int i2 = this.worldObj.getBlockId(this.field_9402_e, this.field_9401_f, this.field_9400_g);
            if (i2 == this.field_9399_h) {
                ++this.field_9396_k;
                if (this.field_9396_k != 1200) return;
                this.setEntityDead();
                return;
            }
            this.field_9398_i = false;
            this.motionX *= (double)(this.rand.nextFloat() * 0.2f);
            this.motionY *= (double)(this.rand.nextFloat() * 0.2f);
            this.motionZ *= (double)(this.rand.nextFloat() * 0.2f);
            this.field_9396_k = 0;
            this.field_9395_l = 0;
        } else {
            ++this.field_9395_l;
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
            float f2;
            AxisAlignedBB axisalignedbb;
            MovingObjectPosition movingobjectposition1;
            Entity entity1 = (Entity)list.get(j2);
            if (!entity1.canBeCollidedWith() || entity1 == this.field_9397_j && this.field_9395_l < 25 || (movingobjectposition1 = (axisalignedbb = entity1.boundingBox.expands(f2 = 0.3f, f2, f2)).func_1169_a(vec3d, vec3d1)) == null || !((d1 = vec3d.distanceTo(movingobjectposition1.hitVec)) < d2) && d2 != 0.0) continue;
            entity = entity1;
            d2 = d1;
        }
        if (entity != null) {
            movingobjectposition = new MovingObjectPosition(entity);
        }
        if (movingobjectposition != null) {
            if (movingobjectposition.entityHit == null || !movingobjectposition.entityHit.canAttackEntity(this.field_9397_j, 0)) {
                // empty if block
            }
            this.worldObj.func_12244_a(null, this.posX, this.posY, this.posZ, 1.0f, true);
            this.setEntityDead();
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
        float f1 = 0.95f;
        if (this.handleWaterMovement()) {
            for (int k2 = 0; k2 < 4; ++k2) {
                float f3 = 0.25f;
                this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f3, this.posY - this.motionY * (double)f3, this.posZ - this.motionZ * (double)f3, this.motionX, this.motionY, this.motionZ);
            }
            f1 = 0.8f;
        }
        this.motionX += this.field_9405_b;
        this.motionY += this.field_9404_c;
        this.motionZ += this.field_9403_d;
        this.motionX *= (double)f1;
        this.motionY *= (double)f1;
        this.motionZ *= (double)f1;
        this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5, this.posZ, 0.0, 0.0, 0.0);
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setShort("xTile", (short)this.field_9402_e);
        nbttagcompound.setShort("yTile", (short)this.field_9401_f);
        nbttagcompound.setShort("zTile", (short)this.field_9400_g);
        nbttagcompound.setByte("inTile", (byte)this.field_9399_h);
        nbttagcompound.setByte("shake", (byte)this.field_9406_a);
        nbttagcompound.setByte("inGround", (byte)(this.field_9398_i ? 1 : 0));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        this.field_9402_e = nbttagcompound.getShort("xTile");
        this.field_9401_f = nbttagcompound.getShort("yTile");
        this.field_9400_g = nbttagcompound.getShort("zTile");
        this.field_9399_h = nbttagcompound.getByte("inTile") & 0xFF;
        this.field_9406_a = nbttagcompound.getByte("shake") & 0xFF;
        this.field_9398_i = nbttagcompound.getByte("inGround") == 1;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public float func_4035_j_() {
        return 1.0f;
    }

    @Override
    public boolean canAttackEntity(Entity entity, int i2) {
        this.func_9281_M();
        if (entity != null) {
            Vec3D vec3d = entity.func_4037_H();
            if (vec3d != null) {
                this.motionX = vec3d.xCoord;
                this.motionY = vec3d.yCoord;
                this.motionZ = vec3d.zCoord;
                this.field_9405_b = this.motionX * 0.1;
                this.field_9404_c = this.motionY * 0.1;
                this.field_9403_d = this.motionZ * 0.1;
            }
            return true;
        }
        return false;
    }

    @Override
    public float func_392_h_() {
        return 0.0f;
    }
}

