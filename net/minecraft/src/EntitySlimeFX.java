/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityFX;
import net.minecraft.src.Item;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntitySlimeFX
extends EntityFX {
    public EntitySlimeFX(World world, double d2, double d1, double d22, Item item) {
        super(world, d2, d1, d22, 0.0, 0.0, 0.0);
        this.field_670_b = item.getIconIndex(null);
        this.field_661_k = 1.0f;
        this.field_662_j = 1.0f;
        this.field_663_i = 1.0f;
        this.field_664_h = Block.blockSnow.field_357_bm;
        this.field_665_g /= 2.0f;
    }

    @Override
    public int func_404_c() {
        return 2;
    }

    @Override
    public void func_406_a(Tessellator tessellator, float f2, float f1, float f22, float f3, float f4, float f5) {
        float f6 = ((float)(this.field_670_b % 16) + this.field_669_c / 4.0f) / 16.0f;
        float f7 = f6 + 0.01560938f;
        float f8 = ((float)(this.field_670_b / 16) + this.field_668_d / 4.0f) / 16.0f;
        float f9 = f8 + 0.01560938f;
        float f10 = 0.1f * this.field_665_g;
        float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)f2 - field_660_l);
        float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)f2 - field_659_m);
        float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)f2 - field_658_n);
        float f14 = this.getEntityBrightness(f2);
        tessellator.setColorOpaque_F(f14 * this.field_663_i, f14 * this.field_662_j, f14 * this.field_661_k);
        tessellator.addVertexWithUV(f11 - f1 * f10 - f4 * f10, f12 - f22 * f10, f13 - f3 * f10 - f5 * f10, f6, f9);
        tessellator.addVertexWithUV(f11 - f1 * f10 + f4 * f10, f12 + f22 * f10, f13 - f3 * f10 + f5 * f10, f6, f8);
        tessellator.addVertexWithUV(f11 + f1 * f10 + f4 * f10, f12 + f22 * f10, f13 + f3 * f10 + f5 * f10, f7, f8);
        tessellator.addVertexWithUV(f11 + f1 * f10 - f4 * f10, f12 - f22 * f10, f13 + f3 * f10 - f5 * f10, f7, f9);
    }
}

