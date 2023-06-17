/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelBiped
extends ModelBase {
    public ModelRenderer bipedHead = new ModelRenderer(0, 0);
    public ModelRenderer field_1285_b;
    public ModelRenderer field_1284_c;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
    public boolean field_1279_h = false;
    public boolean field_1278_i = false;
    public boolean field_1277_j = false;

    public ModelBiped() {
        this(0.0f);
    }

    public ModelBiped(float f2) {
        this(f2, 0.0f);
    }

    public ModelBiped(float f2, float f1) {
        this.bipedHead.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f2);
        this.bipedHead.setPosition(0.0f, 0.0f + f1, 0.0f);
        this.field_1285_b = new ModelRenderer(32, 0);
        this.field_1285_b.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f2 + 0.5f);
        this.field_1285_b.setPosition(0.0f, 0.0f + f1, 0.0f);
        this.field_1284_c = new ModelRenderer(16, 16);
        this.field_1284_c.addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4, f2);
        this.field_1284_c.setPosition(0.0f, 0.0f + f1, 0.0f);
        this.bipedRightArm = new ModelRenderer(40, 16);
        this.bipedRightArm.addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4, f2);
        this.bipedRightArm.setPosition(-5.0f, 2.0f + f1, 0.0f);
        this.bipedLeftArm = new ModelRenderer(40, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4, f2);
        this.bipedLeftArm.setPosition(5.0f, 2.0f + f1, 0.0f);
        this.bipedRightLeg = new ModelRenderer(0, 16);
        this.bipedRightLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, f2);
        this.bipedRightLeg.setPosition(-2.0f, 12.0f + f1, 0.0f);
        this.bipedLeftLeg = new ModelRenderer(0, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4, f2);
        this.bipedLeftLeg.setPosition(2.0f, 12.0f + f1, 0.0f);
    }

    @Override
    public void render(float f2, float f1, float f22, float f3, float f4, float f5) {
        this.setRotationAngles(f2, f1, f22, f3, f4, f5);
        this.bipedHead.render(f5);
        this.field_1284_c.render(f5);
        this.bipedRightArm.render(f5);
        this.bipedLeftArm.render(f5);
        this.bipedRightLeg.render(f5);
        this.bipedLeftLeg.render(f5);
        this.field_1285_b.render(f5);
    }

    @Override
    public void setRotationAngles(float f2, float f1, float f22, float f3, float f4, float f5) {
        this.bipedHead.rotateAngleY = f3 / 57.29578f;
        this.bipedHead.rotateAngleX = f4 / 57.29578f;
        this.field_1285_b.rotateAngleY = this.bipedHead.rotateAngleY;
        this.field_1285_b.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedRightArm.rotateAngleX = MathHelper.cos(f2 * 0.6662f + 3.141593f) * 2.0f * f1 * 0.5f;
        this.bipedLeftArm.rotateAngleX = MathHelper.cos(f2 * 0.6662f) * 2.0f * f1 * 0.5f;
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightLeg.rotateAngleX = MathHelper.cos(f2 * 0.6662f) * 1.4f * f1;
        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(f2 * 0.6662f + 3.141593f) * 1.4f * f1;
        this.bipedRightLeg.rotateAngleY = 0.0f;
        this.bipedLeftLeg.rotateAngleY = 0.0f;
        if (this.field_1243_l) {
            this.bipedRightArm.rotateAngleX += -0.6283185f;
            this.bipedLeftArm.rotateAngleX += -0.6283185f;
            this.bipedRightLeg.rotateAngleX = -1.256637f;
            this.bipedLeftLeg.rotateAngleX = -1.256637f;
            this.bipedRightLeg.rotateAngleY = 0.3141593f;
            this.bipedLeftLeg.rotateAngleY = -0.3141593f;
        }
        if (this.field_1279_h) {
            this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5f - 0.3141593f;
        }
        if (this.field_1278_i) {
            this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5f - 0.3141593f;
        }
        this.bipedRightArm.rotateAngleY = 0.0f;
        this.bipedLeftArm.rotateAngleY = 0.0f;
        if (this.field_1244_k > -9990.0f) {
            float f6 = this.field_1244_k;
            this.field_1284_c.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.141593f * 2.0f) * 0.2f;
            this.bipedRightArm.offsetZ = MathHelper.sin(this.field_1284_c.rotateAngleY) * 5.0f;
            this.bipedRightArm.offsetX = -MathHelper.cos(this.field_1284_c.rotateAngleY) * 5.0f;
            this.bipedLeftArm.offsetZ = -MathHelper.sin(this.field_1284_c.rotateAngleY) * 5.0f;
            this.bipedLeftArm.offsetX = MathHelper.cos(this.field_1284_c.rotateAngleY) * 5.0f;
            this.bipedRightArm.rotateAngleY += this.field_1284_c.rotateAngleY;
            this.bipedLeftArm.rotateAngleY += this.field_1284_c.rotateAngleY;
            this.bipedLeftArm.rotateAngleX += this.field_1284_c.rotateAngleY;
            f6 = 1.0f - this.field_1244_k;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0f - f6;
            float f7 = MathHelper.sin(f6 * 3.141593f);
            float f8 = MathHelper.sin(this.field_1244_k * 3.141593f) * -(this.bipedHead.rotateAngleX - 0.7f) * 0.75f;
            this.bipedRightArm.rotateAngleX = (float)((double)this.bipedRightArm.rotateAngleX - ((double)f7 * 1.2 + (double)f8));
            this.bipedRightArm.rotateAngleY += this.field_1284_c.rotateAngleY * 2.0f;
            this.bipedRightArm.rotateAngleZ = MathHelper.sin(this.field_1244_k * 3.141593f) * -0.4f;
        }
        if (this.field_1277_j) {
            this.field_1284_c.rotateAngleX = 0.5f;
            this.bipedRightLeg.rotateAngleX -= 0.0f;
            this.bipedLeftLeg.rotateAngleX -= 0.0f;
            this.bipedRightArm.rotateAngleX += 0.4f;
            this.bipedLeftArm.rotateAngleX += 0.4f;
            this.bipedRightLeg.offsetZ = 4.0f;
            this.bipedLeftLeg.offsetZ = 4.0f;
            this.bipedRightLeg.offsetY = 9.0f;
            this.bipedLeftLeg.offsetY = 9.0f;
            this.bipedHead.offsetY = 1.0f;
        } else {
            this.field_1284_c.rotateAngleX = 0.0f;
            this.bipedRightLeg.offsetZ = 0.0f;
            this.bipedLeftLeg.offsetZ = 0.0f;
            this.bipedRightLeg.offsetY = 12.0f;
            this.bipedLeftLeg.offsetY = 12.0f;
            this.bipedHead.offsetY = 0.0f;
        }
        this.bipedRightArm.rotateAngleZ += MathHelper.cos(f22 * 0.09f) * 0.05f + 0.05f;
        this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(f22 * 0.09f) * 0.05f + 0.05f;
        this.bipedRightArm.rotateAngleX += MathHelper.sin(f22 * 0.067f) * 0.05f;
        this.bipedLeftArm.rotateAngleX -= MathHelper.sin(f22 * 0.067f) * 0.05f;
    }
}

