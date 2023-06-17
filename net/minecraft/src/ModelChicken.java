/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelChicken
extends ModelBase {
    public ModelRenderer field_1289_a;
    public ModelRenderer field_1288_b;
    public ModelRenderer field_1295_c;
    public ModelRenderer field_1294_d;
    public ModelRenderer field_1293_e;
    public ModelRenderer field_1292_f;
    public ModelRenderer field_1291_g;
    public ModelRenderer field_1290_h;

    public ModelChicken() {
        int byte0 = 16;
        this.field_1289_a = new ModelRenderer(0, 0);
        this.field_1289_a.addBox(-2.0f, -6.0f, -2.0f, 4, 6, 3, 0.0f);
        this.field_1289_a.setPosition(0.0f, -1 + byte0, -4.0f);
        this.field_1291_g = new ModelRenderer(14, 0);
        this.field_1291_g.addBox(-2.0f, -4.0f, -4.0f, 4, 2, 2, 0.0f);
        this.field_1291_g.setPosition(0.0f, -1 + byte0, -4.0f);
        this.field_1290_h = new ModelRenderer(14, 4);
        this.field_1290_h.addBox(-1.0f, -2.0f, -3.0f, 2, 2, 2, 0.0f);
        this.field_1290_h.setPosition(0.0f, -1 + byte0, -4.0f);
        this.field_1288_b = new ModelRenderer(0, 9);
        this.field_1288_b.addBox(-3.0f, -4.0f, -3.0f, 6, 8, 6, 0.0f);
        this.field_1288_b.setPosition(0.0f, 0 + byte0, 0.0f);
        this.field_1295_c = new ModelRenderer(26, 0);
        this.field_1295_c.func_921_a(-1.0f, 0.0f, -3.0f, 3, 5, 3);
        this.field_1295_c.setPosition(-2.0f, 3 + byte0, 1.0f);
        this.field_1294_d = new ModelRenderer(26, 0);
        this.field_1294_d.func_921_a(-1.0f, 0.0f, -3.0f, 3, 5, 3);
        this.field_1294_d.setPosition(1.0f, 3 + byte0, 1.0f);
        this.field_1293_e = new ModelRenderer(24, 13);
        this.field_1293_e.func_921_a(0.0f, 0.0f, -3.0f, 1, 4, 6);
        this.field_1293_e.setPosition(-4.0f, -3 + byte0, 0.0f);
        this.field_1292_f = new ModelRenderer(24, 13);
        this.field_1292_f.func_921_a(-1.0f, 0.0f, -3.0f, 1, 4, 6);
        this.field_1292_f.setPosition(4.0f, -3 + byte0, 0.0f);
    }

    @Override
    public void render(float f2, float f1, float f22, float f3, float f4, float f5) {
        this.setRotationAngles(f2, f1, f22, f3, f4, f5);
        this.field_1289_a.render(f5);
        this.field_1291_g.render(f5);
        this.field_1290_h.render(f5);
        this.field_1288_b.render(f5);
        this.field_1295_c.render(f5);
        this.field_1294_d.render(f5);
        this.field_1293_e.render(f5);
        this.field_1292_f.render(f5);
    }

    @Override
    public void setRotationAngles(float f2, float f1, float f22, float f3, float f4, float f5) {
        this.field_1289_a.rotateAngleX = -(f4 / 57.29578f);
        this.field_1289_a.rotateAngleY = f3 / 57.29578f;
        this.field_1291_g.rotateAngleX = this.field_1289_a.rotateAngleX;
        this.field_1291_g.rotateAngleY = this.field_1289_a.rotateAngleY;
        this.field_1290_h.rotateAngleX = this.field_1289_a.rotateAngleX;
        this.field_1290_h.rotateAngleY = this.field_1289_a.rotateAngleY;
        this.field_1288_b.rotateAngleX = 1.570796f;
        this.field_1295_c.rotateAngleX = MathHelper.cos(f2 * 0.6662f) * 1.4f * f1;
        this.field_1294_d.rotateAngleX = MathHelper.cos(f2 * 0.6662f + 3.141593f) * 1.4f * f1;
        this.field_1293_e.rotateAngleZ = f22;
        this.field_1292_f.rotateAngleZ = -f22;
    }
}

