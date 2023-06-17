/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelSlime
extends ModelBase {
    ModelRenderer field_1258_a;
    ModelRenderer field_1257_b;
    ModelRenderer field_1260_c;
    ModelRenderer field_1259_d;

    public ModelSlime(int i2) {
        this.field_1258_a = new ModelRenderer(0, i2);
        this.field_1258_a.func_921_a(-4.0f, 16.0f, -4.0f, 8, 8, 8);
        if (i2 > 0) {
            this.field_1258_a = new ModelRenderer(0, i2);
            this.field_1258_a.func_921_a(-3.0f, 17.0f, -3.0f, 6, 6, 6);
            this.field_1257_b = new ModelRenderer(32, 0);
            this.field_1257_b.func_921_a(-3.25f, 18.0f, -3.5f, 2, 2, 2);
            this.field_1260_c = new ModelRenderer(32, 4);
            this.field_1260_c.func_921_a(1.25f, 18.0f, -3.5f, 2, 2, 2);
            this.field_1259_d = new ModelRenderer(32, 8);
            this.field_1259_d.func_921_a(0.0f, 21.0f, -3.5f, 1, 1, 1);
        }
    }

    @Override
    public void setRotationAngles(float f2, float f1, float f22, float f3, float f4, float f5) {
    }

    @Override
    public void render(float f2, float f1, float f22, float f3, float f4, float f5) {
        this.setRotationAngles(f2, f1, f22, f3, f4, f5);
        this.field_1258_a.render(f5);
        if (this.field_1257_b != null) {
            this.field_1257_b.render(f5);
            this.field_1260_c.render(f5);
            this.field_1259_d.render(f5);
        }
    }
}

