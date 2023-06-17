/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelGhast
extends ModelBase {
    ModelRenderer body;
    ModelRenderer[] tentacles = new ModelRenderer[9];

    public ModelGhast() {
        int byte0 = -16;
        this.body = new ModelRenderer(0, 0);
        this.body.func_921_a(-8.0f, -8.0f, -8.0f, 16, 16, 16);
        this.body.offsetY += (float)(24 + byte0);
        Random random = new Random(1660L);
        for (int i2 = 0; i2 < this.tentacles.length; ++i2) {
            this.tentacles[i2] = new ModelRenderer(0, 0);
            float f2 = (((float)(i2 % 3) - (float)(i2 / 3 % 2) * 0.5f + 0.25f) / 2.0f * 2.0f - 1.0f) * 5.0f;
            float f1 = ((float)(i2 / 3) / 2.0f * 2.0f - 1.0f) * 5.0f;
            int j2 = random.nextInt(7) + 8;
            this.tentacles[i2].func_921_a(-1.0f, 0.0f, -1.0f, 2, j2, 2);
            this.tentacles[i2].offsetX = f2;
            this.tentacles[i2].offsetZ = f1;
            this.tentacles[i2].offsetY = 31 + byte0;
        }
    }

    @Override
    public void setRotationAngles(float f2, float f1, float f22, float f3, float f4, float f5) {
        for (int i2 = 0; i2 < this.tentacles.length; ++i2) {
            this.tentacles[i2].rotateAngleX = 0.2f * MathHelper.sin(f22 * 0.3f + (float)i2) + 0.4f;
        }
    }

    @Override
    public void render(float f2, float f1, float f22, float f3, float f4, float f5) {
        this.setRotationAngles(f2, f1, f22, f3, f4, f5);
        this.body.render(f5);
        for (int i2 = 0; i2 < this.tentacles.length; ++i2) {
            this.tentacles[i2].render(f5);
        }
    }
}

