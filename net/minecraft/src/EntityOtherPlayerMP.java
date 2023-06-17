/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EntityOtherPlayerMP
extends EntityPlayer {
    private int field_785_bg;
    private double field_784_bh;
    private double field_783_bi;
    private double field_782_bj;
    private double field_780_bk;
    private double field_786_bl;
    float field_781_a = 0.0f;

    public EntityOtherPlayerMP(World world, String s2) {
        super(world);
        this.field_771_i = s2;
        this.yOffset = 0.0f;
        this.field_9286_aZ = 0.0f;
        if (s2 != null && s2.length() > 0) {
            this.skinUrl = "http://www.minecraft.net/skin/" + s2 + ".png";
            System.out.println("Loading texture " + this.skinUrl);
        }
        this.field_9314_ba = true;
        this.field_619_ac = 10.0;
    }

    @Override
    public boolean canAttackEntity(Entity entity, int i2) {
        return true;
    }

    @Override
    public void setPositionAndRotation2(double d2, double d1, double d22, float f2, float f1, int i2) {
        this.yOffset = 0.0f;
        this.field_784_bh = d2;
        this.field_783_bi = d1;
        this.field_782_bj = d22;
        this.field_780_bk = f2;
        this.field_786_bl = f1;
        this.field_785_bg = i2;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.field_705_Q = this.field_704_R;
        double d2 = this.posX - this.prevPosX;
        double d1 = this.posZ - this.prevPosZ;
        float f2 = MathHelper.sqrt_double(d2 * d2 + d1 * d1) * 4.0f;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.field_704_R += (f2 - this.field_704_R) * 0.4f;
        this.field_703_S += this.field_704_R;
    }

    @Override
    public float func_392_h_() {
        return 0.0f;
    }

    @Override
    public void onLivingUpdate() {
        super.func_418_b_();
        if (this.field_785_bg > 0) {
            double d3;
            double d2 = this.posX + (this.field_784_bh - this.posX) / (double)this.field_785_bg;
            double d1 = this.posY + (this.field_783_bi - this.posY) / (double)this.field_785_bg;
            double d22 = this.posZ + (this.field_782_bj - this.posZ) / (double)this.field_785_bg;
            for (d3 = this.field_780_bk - (double)this.rotationYaw; d3 < -180.0; d3 += 360.0) {
            }
            while (d3 >= 180.0) {
                d3 -= 360.0;
            }
            this.rotationYaw = (float)((double)this.rotationYaw + d3 / (double)this.field_785_bg);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.field_786_bl - (double)this.rotationPitch) / (double)this.field_785_bg);
            --this.field_785_bg;
            this.setPosition(d2, d1, d22);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
        this.field_775_e = this.field_774_f;
        float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        float f1 = (float)Math.atan(-this.motionY * (double)0.2f) * 15.0f;
        if (f2 > 0.1f) {
            f2 = 0.1f;
        }
        if (!this.onGround || this.health <= 0) {
            f2 = 0.0f;
        }
        if (this.onGround || this.health <= 0) {
            f1 = 0.0f;
        }
        this.field_774_f += (f2 - this.field_774_f) * 0.4f;
        this.field_9328_R += (f1 - this.field_9328_R) * 0.8f;
    }

    @Override
    public boolean func_381_o() {
        return this.field_12240_bw;
    }
}

