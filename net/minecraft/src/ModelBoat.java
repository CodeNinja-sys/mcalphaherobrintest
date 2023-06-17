/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelBoat
extends ModelBase {
    public ModelRenderer[] field_1287_a = new ModelRenderer[5];

    public ModelBoat() {
        this.field_1287_a[0] = new ModelRenderer(0, 8);
        this.field_1287_a[1] = new ModelRenderer(0, 0);
        this.field_1287_a[2] = new ModelRenderer(0, 0);
        this.field_1287_a[3] = new ModelRenderer(0, 0);
        this.field_1287_a[4] = new ModelRenderer(0, 0);
        int byte0 = 24;
        int byte1 = 6;
        int byte2 = 20;
        int byte3 = 4;
        this.field_1287_a[0].addBox(-byte0 / 2, -byte2 / 2 + 2, -3.0f, byte0, byte2 - 4, 4, 0.0f);
        this.field_1287_a[0].setPosition(0.0f, 0 + byte3, 0.0f);
        this.field_1287_a[1].addBox(-byte0 / 2 + 2, -byte1 - 1, -1.0f, byte0 - 4, byte1, 2, 0.0f);
        this.field_1287_a[1].setPosition(-byte0 / 2 + 1, 0 + byte3, 0.0f);
        this.field_1287_a[2].addBox(-byte0 / 2 + 2, -byte1 - 1, -1.0f, byte0 - 4, byte1, 2, 0.0f);
        this.field_1287_a[2].setPosition(byte0 / 2 - 1, 0 + byte3, 0.0f);
        this.field_1287_a[3].addBox(-byte0 / 2 + 2, -byte1 - 1, -1.0f, byte0 - 4, byte1, 2, 0.0f);
        this.field_1287_a[3].setPosition(0.0f, 0 + byte3, -byte2 / 2 + 1);
        this.field_1287_a[4].addBox(-byte0 / 2 + 2, -byte1 - 1, -1.0f, byte0 - 4, byte1, 2, 0.0f);
        this.field_1287_a[4].setPosition(0.0f, 0 + byte3, byte2 / 2 - 1);
        this.field_1287_a[0].rotateAngleX = 1.570796f;
        this.field_1287_a[1].rotateAngleY = 4.712389f;
        this.field_1287_a[2].rotateAngleY = 1.570796f;
        this.field_1287_a[3].rotateAngleY = 3.141593f;
    }

    @Override
    public void render(float f2, float f1, float f22, float f3, float f4, float f5) {
        for (int i2 = 0; i2 < 5; ++i2) {
            this.field_1287_a[i2].render(f5);
        }
    }

    @Override
    public void setRotationAngles(float f2, float f1, float f22, float f3, float f4, float f5) {
    }
}

