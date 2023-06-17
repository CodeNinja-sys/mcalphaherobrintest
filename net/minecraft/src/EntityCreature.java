/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.PathEntity;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class EntityCreature
extends EntityLiving {
    private PathEntity pathToEntity;
    protected Entity playerToAttack;
    protected boolean hasAttacked = false;

    public EntityCreature(World world) {
        super(world);
    }

    @Override
    protected void func_418_b_() {
        this.hasAttacked = false;
        float f2 = 16.0f;
        if (this.playerToAttack == null) {
            this.playerToAttack = this.findPlayerToAttack();
            if (this.playerToAttack != null) {
                this.pathToEntity = this.worldObj.getPathToEntity(this, this.playerToAttack, f2);
            }
        } else if (!this.playerToAttack.isEntityAlive()) {
            this.playerToAttack = null;
        } else {
            float f1 = this.playerToAttack.getDistanceToEntity(this);
            if (this.canEntityBeSeen(this.playerToAttack)) {
                this.attackEntity(this.playerToAttack, f1);
            }
        }
        if (!(this.hasAttacked || this.playerToAttack == null || this.pathToEntity != null && this.rand.nextInt(20) != 0)) {
            this.pathToEntity = this.worldObj.getPathToEntity(this, this.playerToAttack, f2);
        } else if (this.pathToEntity == null && this.rand.nextInt(80) == 0 || this.rand.nextInt(80) == 0) {
            boolean flag = false;
            int j2 = -1;
            int k2 = -1;
            int l2 = -1;
            float f22 = -99999.0f;
            for (int i1 = 0; i1 < 10; ++i1) {
                int l1;
                int k1;
                int j1 = MathHelper.floor_double(this.posX + (double)this.rand.nextInt(13) - 6.0);
                float f3 = this.func_439_a(j1, k1 = MathHelper.floor_double(this.posY + (double)this.rand.nextInt(7) - 3.0), l1 = MathHelper.floor_double(this.posZ + (double)this.rand.nextInt(13) - 6.0));
                if (!(f3 > f22)) continue;
                f22 = f3;
                j2 = j1;
                k2 = k1;
                l2 = l1;
                flag = true;
            }
            if (flag) {
                this.pathToEntity = this.worldObj.getEntityPathToXYZ(this, j2, k2, l2, 10.0f);
            }
        }
        int i2 = MathHelper.floor_double(this.boundingBox.minY);
        boolean flag1 = this.handleWaterMovement();
        boolean flag2 = this.handleLavaMovement();
        this.rotationPitch = 0.0f;
        if (this.pathToEntity == null || this.rand.nextInt(100) == 0) {
            super.func_418_b_();
            this.pathToEntity = null;
            return;
        }
        Vec3D vec3d = this.pathToEntity.getPosition(this);
        double d2 = this.width * 2.0f;
        while (vec3d != null && vec3d.squareDistanceTo(this.posX, vec3d.yCoord, this.posZ) < d2 * d2) {
            this.pathToEntity.incrementPathIndex();
            if (this.pathToEntity.isFinished()) {
                vec3d = null;
                this.pathToEntity = null;
                continue;
            }
            vec3d = this.pathToEntity.getPosition(this);
        }
        this.isJumping = false;
        if (vec3d != null) {
            float f5;
            double d1 = vec3d.xCoord - this.posX;
            double d22 = vec3d.zCoord - this.posZ;
            double d3 = vec3d.yCoord - (double)i2;
            float f4 = (float)(Math.atan2(d22, d1) * 180.0 / 3.1415927410125732) - 90.0f;
            this.field_9340_ai = this.field_9333_am;
            for (f5 = f4 - this.rotationYaw; f5 < -180.0f; f5 += 360.0f) {
            }
            while (f5 >= 180.0f) {
                f5 -= 360.0f;
            }
            if (f5 > 30.0f) {
                f5 = 30.0f;
            }
            if (f5 < -30.0f) {
                f5 = -30.0f;
            }
            this.rotationYaw += f5;
            if (this.hasAttacked && this.playerToAttack != null) {
                double d4 = this.playerToAttack.posX - this.posX;
                double d5 = this.playerToAttack.posZ - this.posZ;
                float f7 = this.rotationYaw;
                this.rotationYaw = (float)(Math.atan2(d5, d4) * 180.0 / 3.1415927410125732) - 90.0f;
                float f6 = (f7 - this.rotationYaw + 90.0f) * 3.141593f / 180.0f;
                this.field_9342_ah = -MathHelper.sin(f6) * this.field_9340_ai * 1.0f;
                this.field_9340_ai = MathHelper.cos(f6) * this.field_9340_ai * 1.0f;
            }
            if (d3 > 0.0) {
                this.isJumping = true;
            }
        }
        if (this.playerToAttack != null) {
            this.faceEntity(this.playerToAttack, 30.0f);
        }
        if (this.field_9297_aI) {
            this.isJumping = true;
        }
        if (this.rand.nextFloat() < 0.8f && (flag1 || flag2)) {
            this.isJumping = true;
        }
    }

    protected void attackEntity(Entity entity, float f2) {
    }

    protected float func_439_a(int i2, int j2, int k2) {
        return 0.0f;
    }

    protected Entity findPlayerToAttack() {
        return null;
    }

    @Override
    public boolean getCanSpawnHere() {
        int i2 = MathHelper.floor_double(this.posX);
        int j2 = MathHelper.floor_double(this.boundingBox.minY);
        int k2 = MathHelper.floor_double(this.posZ);
        return super.getCanSpawnHere() && this.func_439_a(i2, j2, k2) >= 0.0f;
    }
}

