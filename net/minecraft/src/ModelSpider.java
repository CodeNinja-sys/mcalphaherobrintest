/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelSpider
extends ModelBase {
    public ModelRenderer field_1255_a;
    public ModelRenderer field_1254_b;
    public ModelRenderer field_1253_c;
    public ModelRenderer field_1252_d;
    public ModelRenderer field_1251_e;
    public ModelRenderer field_1250_f;
    public ModelRenderer field_1249_g;
    public ModelRenderer field_1248_h;
    public ModelRenderer field_1247_i;
    public ModelRenderer field_1246_j;
    public ModelRenderer field_1245_m;

    public ModelSpider() {
        float f2 = 0.0f;
        int i2 = 15;
        this.field_1255_a = new ModelRenderer(32, 4);
        this.field_1255_a.addBox(-4.0f, -4.0f, -8.0f, 8, 8, 8, f2);
        this.field_1255_a.setPosition(0.0f, 0 + i2, -3.0f);
        this.field_1254_b = new ModelRenderer(0, 0);
        this.field_1254_b.addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6, f2);
        this.field_1254_b.setPosition(0.0f, i2, 0.0f);
        this.field_1253_c = new ModelRenderer(0, 12);
        this.field_1253_c.addBox(-5.0f, -4.0f, -6.0f, 10, 8, 12, f2);
        this.field_1253_c.setPosition(0.0f, 0 + i2, 9.0f);
        this.field_1252_d = new ModelRenderer(18, 0);
        this.field_1252_d.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.field_1252_d.setPosition(-4.0f, 0 + i2, 2.0f);
        this.field_1251_e = new ModelRenderer(18, 0);
        this.field_1251_e.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.field_1251_e.setPosition(4.0f, 0 + i2, 2.0f);
        this.field_1250_f = new ModelRenderer(18, 0);
        this.field_1250_f.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.field_1250_f.setPosition(-4.0f, 0 + i2, 1.0f);
        this.field_1249_g = new ModelRenderer(18, 0);
        this.field_1249_g.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.field_1249_g.setPosition(4.0f, 0 + i2, 1.0f);
        this.field_1248_h = new ModelRenderer(18, 0);
        this.field_1248_h.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.field_1248_h.setPosition(-4.0f, 0 + i2, 0.0f);
        this.field_1247_i = new ModelRenderer(18, 0);
        this.field_1247_i.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.field_1247_i.setPosition(4.0f, 0 + i2, 0.0f);
        this.field_1246_j = new ModelRenderer(18, 0);
        this.field_1246_j.addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.field_1246_j.setPosition(-4.0f, 0 + i2, -1.0f);
        this.field_1245_m = new ModelRenderer(18, 0);
        this.field_1245_m.addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, f2);
        this.field_1245_m.setPosition(4.0f, 0 + i2, -1.0f);
    }

    @Override
    public void render(float f2, float f1, float f22, float f3, float f4, float f5) {
        this.setRotationAngles(f2, f1, f22, f3, f4, f5);
        this.field_1255_a.render(f5);
        this.field_1254_b.render(f5);
        this.field_1253_c.render(f5);
        this.field_1252_d.render(f5);
        this.field_1251_e.render(f5);
        this.field_1250_f.render(f5);
        this.field_1249_g.render(f5);
        this.field_1248_h.render(f5);
        this.field_1247_i.render(f5);
        this.field_1246_j.render(f5);
        this.field_1245_m.render(f5);
    }

    @Override
    public void setRotationAngles(float f2, float f1, float f22, float f3, float f4, float f5) {
        this.field_1255_a.rotateAngleY = f3 / 57.29578f;
        this.field_1255_a.rotateAngleX = f4 / 57.29578f;
        float f6 = 0.7853982f;
        this.field_1252_d.rotateAngleZ = -f6;
        this.field_1251_e.rotateAngleZ = f6;
        this.field_1250_f.rotateAngleZ = -f6 * 0.74f;
        this.field_1249_g.rotateAngleZ = f6 * 0.74f;
        this.field_1248_h.rotateAngleZ = -f6 * 0.74f;
        this.field_1247_i.rotateAngleZ = f6 * 0.74f;
        this.field_1246_j.rotateAngleZ = -f6;
        this.field_1245_m.rotateAngleZ = f6;
        float f7 = -0.0f;
        float f8 = 0.3926991f;
        this.field_1252_d.rotateAngleY = f8 * 2.0f + f7;
        this.field_1251_e.rotateAngleY = -f8 * 2.0f - f7;
        this.field_1250_f.rotateAngleY = f8 * 1.0f + f7;
        this.field_1249_g.rotateAngleY = -f8 * 1.0f - f7;
        this.field_1248_h.rotateAngleY = -f8 * 1.0f + f7;
        this.field_1247_i.rotateAngleY = f8 * 1.0f - f7;
        this.field_1246_j.rotateAngleY = -f8 * 2.0f + f7;
        this.field_1245_m.rotateAngleY = f8 * 2.0f - f7;
        float f9 = -(MathHelper.cos(f2 * 0.6662f * 2.0f + 0.0f) * 0.4f) * f1;
        float f10 = -(MathHelper.cos(f2 * 0.6662f * 2.0f + 3.141593f) * 0.4f) * f1;
        float f11 = -(MathHelper.cos(f2 * 0.6662f * 2.0f + 1.570796f) * 0.4f) * f1;
        float f12 = -(MathHelper.cos(f2 * 0.6662f * 2.0f + 4.712389f) * 0.4f) * f1;
        float f13 = Math.abs(MathHelper.sin(f2 * 0.6662f + 0.0f) * 0.4f) * f1;
        float f14 = Math.abs(MathHelper.sin(f2 * 0.6662f + 3.141593f) * 0.4f) * f1;
        float f15 = Math.abs(MathHelper.sin(f2 * 0.6662f + 1.570796f) * 0.4f) * f1;
        float f16 = Math.abs(MathHelper.sin(f2 * 0.6662f + 4.712389f) * 0.4f) * f1;
        this.field_1252_d.rotateAngleY += f9;
        this.field_1251_e.rotateAngleY += -f9;
        this.field_1250_f.rotateAngleY += f10;
        this.field_1249_g.rotateAngleY += -f10;
        this.field_1248_h.rotateAngleY += f11;
        this.field_1247_i.rotateAngleY += -f11;
        this.field_1246_j.rotateAngleY += f12;
        this.field_1245_m.rotateAngleY += -f12;
        this.field_1252_d.rotateAngleZ += f13;
        this.field_1251_e.rotateAngleZ += -f13;
        this.field_1250_f.rotateAngleZ += f14;
        this.field_1249_g.rotateAngleZ += -f14;
        this.field_1248_h.rotateAngleZ += f15;
        this.field_1247_i.rotateAngleZ += -f15;
        this.field_1246_j.rotateAngleZ += f16;
        this.field_1245_m.rotateAngleZ += -f16;
    }
}

