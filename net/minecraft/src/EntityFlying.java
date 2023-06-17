/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EntityFlying
extends EntityLiving {
    public EntityFlying(World world) {
        super(world);
    }

    @Override
    protected void fall(float f2) {
    }

    @Override
    public void func_435_b(float f2, float f1) {
        if (this.handleWaterMovement()) {
            this.func_351_a(f2, f1, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)0.8f;
            this.motionY *= (double)0.8f;
            this.motionZ *= (double)0.8f;
        } else if (this.handleLavaMovement()) {
            this.func_351_a(f2, f1, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        } else {
            float f22 = 0.91f;
            if (this.onGround) {
                f22 = 0.5460001f;
                int i2 = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));
                if (i2 > 0) {
                    f22 = Block.blocksList[i2].slipperiness * 0.91f;
                }
            }
            float f3 = 0.1627714f / (f22 * f22 * f22);
            this.func_351_a(f2, f1, this.onGround ? 0.1f * f3 : 0.02f);
            f22 = 0.91f;
            if (this.onGround) {
                f22 = 0.5460001f;
                int j2 = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));
                if (j2 > 0) {
                    f22 = Block.blocksList[j2].slipperiness * 0.91f;
                }
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)f22;
            this.motionY *= (double)f22;
            this.motionZ *= (double)f22;
        }
        this.field_705_Q = this.field_704_R;
        double d2 = this.posX - this.prevPosX;
        double d1 = this.posZ - this.prevPosZ;
        float f4 = MathHelper.sqrt_double(d2 * d2 + d1 * d1) * 4.0f;
        if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        this.field_704_R += (f4 - this.field_704_R) * 0.4f;
        this.field_703_S += this.field_704_R;
    }

    @Override
    public boolean isOnLadder() {
        return false;
    }
}

