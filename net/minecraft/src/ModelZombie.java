/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBiped;

public class ModelZombie
extends ModelBiped {
    @Override
    public void setRotationAngles(float f2, float f1, float f22, float f3, float f4, float f5) {
        super.setRotationAngles(f2, f1, f22, f3, f4, f5);
        float f6 = MathHelper.sin(this.field_1244_k * 3.141593f);
        float f7 = MathHelper.sin((1.0f - (1.0f - this.field_1244_k) * (1.0f - this.field_1244_k)) * 3.141593f);
        this.bipedRightArm.rotateAngleZ = 0.0f;
        this.bipedLeftArm.rotateAngleZ = 0.0f;
        this.bipedRightArm.rotateAngleY = -(0.1f - f6 * 0.6f);
        this.bipedLeftArm.rotateAngleY = 0.1f - f6 * 0.6f;
        this.bipedRightArm.rotateAngleX = -1.570796f;
        this.bipedLeftArm.rotateAngleX = -1.570796f;
        this.bipedRightArm.rotateAngleX -= f6 * 1.2f - f7 * 0.4f;
        this.bipedLeftArm.rotateAngleX -= f6 * 1.2f - f7 * 0.4f;
        this.bipedRightArm.rotateAngleZ += MathHelper.cos(f22 * 0.09f) * 0.05f + 0.05f;
        this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(f22 * 0.09f) * 0.05f + 0.05f;
        this.bipedRightArm.rotateAngleX += MathHelper.sin(f22 * 0.067f) * 0.05f;
        this.bipedLeftArm.rotateAngleX -= MathHelper.sin(f22 * 0.067f) * 0.05f;
    }
}

