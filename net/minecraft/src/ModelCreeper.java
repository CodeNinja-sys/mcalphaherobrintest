/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelCreeper
extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer unusedModel;
    public ModelRenderer body;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;

    public ModelCreeper() {
        float f2 = 0.0f;
        int i2 = 4;
        this.head = new ModelRenderer(0, 0);
        this.head.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f2);
        this.head.setPosition(0.0f, i2, 0.0f);
        this.unusedModel = new ModelRenderer(32, 0);
        this.unusedModel.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f2 + 0.5f);
        this.unusedModel.setPosition(0.0f, i2, 0.0f);
        this.body = new ModelRenderer(16, 16);
        this.body.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, f2);
        this.body.setPosition(0.0f, i2, 0.0f);
        this.leg1 = new ModelRenderer(0, 16);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, f2);
        this.leg1.setPosition(-2.0f, 12 + i2, 4.0f);
        this.leg2 = new ModelRenderer(0, 16);
        this.leg2.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, f2);
        this.leg2.setPosition(2.0f, 12 + i2, 4.0f);
        this.leg3 = new ModelRenderer(0, 16);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, f2);
        this.leg3.setPosition(-2.0f, 12 + i2, -4.0f);
        this.leg4 = new ModelRenderer(0, 16);
        this.leg4.addBox(-2.0f, 0.0f, -2.0f, 4, 6, 4, f2);
        this.leg4.setPosition(2.0f, 12 + i2, -4.0f);
    }

    @Override
    public void render(float f2, float f1, float f22, float f3, float f4, float f5) {
        this.setRotationAngles(f2, f1, f22, f3, f4, f5);
        this.head.render(f5);
        this.body.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg4.render(f5);
    }

    @Override
    public void setRotationAngles(float f2, float f1, float f22, float f3, float f4, float f5) {
        this.head.rotateAngleY = f3 / 57.29578f;
        this.head.rotateAngleX = f4 / 57.29578f;
        this.leg1.rotateAngleX = MathHelper.cos(f2 * 0.6662f) * 1.4f * f1;
        this.leg2.rotateAngleX = MathHelper.cos(f2 * 0.6662f + 3.141593f) * 1.4f * f1;
        this.leg3.rotateAngleX = MathHelper.cos(f2 * 0.6662f + 3.141593f) * 1.4f * f1;
        this.leg4.rotateAngleX = MathHelper.cos(f2 * 0.6662f) * 1.4f * f1;
    }
}

