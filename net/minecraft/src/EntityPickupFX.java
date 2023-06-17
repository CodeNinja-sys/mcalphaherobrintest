/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityFX;
import net.minecraft.src.MathHelper;
import net.minecraft.src.RenderManager;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class EntityPickupFX
extends EntityFX {
    private Entity field_675_a;
    private Entity field_679_o;
    private int field_678_p = 0;
    private int field_677_q = 0;
    private float field_676_r;

    public EntityPickupFX(World world, Entity entity, Entity entity1, float f2) {
        super(world, entity.posX, entity.posY, entity.posZ, entity.motionX, entity.motionY, entity.motionZ);
        this.field_675_a = entity;
        this.field_679_o = entity1;
        this.field_677_q = 3;
        this.field_676_r = f2;
    }

    @Override
    public void func_406_a(Tessellator tessellator, float f2, float f1, float f22, float f3, float f4, float f5) {
        float f6 = ((float)this.field_678_p + f2) / (float)this.field_677_q;
        f6 *= f6;
        double d2 = this.field_675_a.posX;
        double d1 = this.field_675_a.posY;
        double d22 = this.field_675_a.posZ;
        double d3 = this.field_679_o.lastTickPosX + (this.field_679_o.posX - this.field_679_o.lastTickPosX) * (double)f2;
        double d4 = this.field_679_o.lastTickPosY + (this.field_679_o.posY - this.field_679_o.lastTickPosY) * (double)f2 + (double)this.field_676_r;
        double d5 = this.field_679_o.lastTickPosZ + (this.field_679_o.posZ - this.field_679_o.lastTickPosZ) * (double)f2;
        double d6 = d2 + (d3 - d2) * (double)f6;
        double d7 = d1 + (d4 - d1) * (double)f6;
        double d8 = d22 + (d5 - d22) * (double)f6;
        int i2 = MathHelper.floor_double(d6);
        int j2 = MathHelper.floor_double(d7 + (double)(this.yOffset / 2.0f));
        int k2 = MathHelper.floor_double(d8);
        float f7 = this.worldObj.getLightBrightness(i2, j2, k2);
        GL11.glColor4f(f7, f7, f7, 1.0f);
        RenderManager.instance.func_853_a(this.field_675_a, (float)(d6 -= field_660_l), (float)(d7 -= field_659_m), (float)(d8 -= field_658_n), this.field_675_a.rotationYaw, f2);
    }

    @Override
    public void onUpdate() {
        ++this.field_678_p;
        if (this.field_678_p == this.field_677_q) {
            this.setEntityDead();
        }
    }

    @Override
    public int func_404_c() {
        return 3;
    }
}

