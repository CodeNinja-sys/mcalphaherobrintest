/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelMinecart
extends ModelBase {
    public ModelRenderer[] field_1256_a = new ModelRenderer[7];

    public ModelMinecart() {
        this.field_1256_a[0] = new ModelRenderer(0, 10);
        this.field_1256_a[1] = new ModelRenderer(0, 0);
        this.field_1256_a[2] = new ModelRenderer(0, 0);
        this.field_1256_a[3] = new ModelRenderer(0, 0);
        this.field_1256_a[4] = new ModelRenderer(0, 0);
        this.field_1256_a[5] = new ModelRenderer(44, 10);
        int byte0 = 20;
        int byte1 = 8;
        int byte2 = 16;
        int byte3 = 4;
        this.field_1256_a[0].addBox(-byte0 / 2, -byte2 / 2, -1.0f, byte0, byte2, 2, 0.0f);
        this.field_1256_a[0].setPosition(0.0f, 0 + byte3, 0.0f);
        this.field_1256_a[5].addBox(-byte0 / 2 + 1, -byte2 / 2 + 1, -1.0f, byte0 - 2, byte2 - 2, 1, 0.0f);
        this.field_1256_a[5].setPosition(0.0f, 0 + byte3, 0.0f);
        this.field_1256_a[1].addBox(-byte0 / 2 + 2, -byte1 - 1, -1.0f, byte0 - 4, byte1, 2, 0.0f);
        this.field_1256_a[1].setPosition(-byte0 / 2 + 1, 0 + byte3, 0.0f);
        this.field_1256_a[2].addBox(-byte0 / 2 + 2, -byte1 - 1, -1.0f, byte0 - 4, byte1, 2, 0.0f);
        this.field_1256_a[2].setPosition(byte0 / 2 - 1, 0 + byte3, 0.0f);
        this.field_1256_a[3].addBox(-byte0 / 2 + 2, -byte1 - 1, -1.0f, byte0 - 4, byte1, 2, 0.0f);
        this.field_1256_a[3].setPosition(0.0f, 0 + byte3, -byte2 / 2 + 1);
        this.field_1256_a[4].addBox(-byte0 / 2 + 2, -byte1 - 1, -1.0f, byte0 - 4, byte1, 2, 0.0f);
        this.field_1256_a[4].setPosition(0.0f, 0 + byte3, byte2 / 2 - 1);
        this.field_1256_a[0].rotateAngleX = 1.570796f;
        this.field_1256_a[1].rotateAngleY = 4.712389f;
        this.field_1256_a[2].rotateAngleY = 1.570796f;
        this.field_1256_a[3].rotateAngleY = 3.141593f;
        this.field_1256_a[5].rotateAngleX = -1.570796f;
    }

    @Override
    public void render(float f2, float f1, float f22, float f3, float f4, float f5) {
        this.field_1256_a[5].offsetY = 4.0f - f22;
        for (int i2 = 0; i2 < 6; ++i2) {
            this.field_1256_a[i2].render(f5);
        }
    }

    @Override
    public void setRotationAngles(float f2, float f1, float f22, float f3, float f4, float f5) {
    }
}

