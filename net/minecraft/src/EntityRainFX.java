/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.BlockFluids;
import net.minecraft.src.EntityFX;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityRainFX
extends EntityFX {
    public EntityRainFX(World world, double d2, double d1, double d22) {
        super(world, d2, d1, d22, 0.0, 0.0, 0.0);
        this.motionX *= (double)0.3f;
        this.motionY = (float)Math.random() * 0.2f + 0.1f;
        this.motionZ *= (double)0.3f;
        this.field_663_i = 1.0f;
        this.field_662_j = 1.0f;
        this.field_661_k = 1.0f;
        this.field_670_b = 19 + this.rand.nextInt(4);
        this.setSize(0.01f, 0.01f);
        this.field_664_h = 0.06f;
        this.field_666_f = (int)(8.0 / (Math.random() * 0.8 + 0.2));
    }

    @Override
    public void func_406_a(Tessellator tessellator, float f2, float f1, float f22, float f3, float f4, float f5) {
        super.func_406_a(tessellator, f2, f1, f22, f3, f4, f5);
    }

    @Override
    public void onUpdate() {
        double d2;
        Material material;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= (double)this.field_664_h;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= (double)0.98f;
        this.motionY *= (double)0.98f;
        this.motionZ *= (double)0.98f;
        if (this.field_666_f-- <= 0) {
            this.setEntityDead();
        }
        if (this.onGround) {
            if (Math.random() < 0.5) {
                this.setEntityDead();
            }
            this.motionX *= (double)0.7f;
            this.motionZ *= (double)0.7f;
        }
        if (((material = this.worldObj.getBlockMaterial(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))).getIsLiquid() || material.func_878_a()) && this.posY < (d2 = (double)((float)(MathHelper.floor_double(this.posY) + 1) - BlockFluids.func_288_b(this.worldObj.getBlockMetadata(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))))) {
            this.setEntityDead();
        }
    }
}

