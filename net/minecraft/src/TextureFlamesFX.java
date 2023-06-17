/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.TextureFX;

public class TextureFlamesFX
extends TextureFX {
    protected float[] field_1133_g = new float[320];
    protected float[] field_1132_h = new float[320];

    public TextureFlamesFX(int i2) {
        super(Block.fire.blockIndexInTexture + i2 * 16);
    }

    @Override
    public void func_783_a() {
        for (int i2 = 0; i2 < 16; ++i2) {
            for (int j2 = 0; j2 < 20; ++j2) {
                int l2 = 18;
                float f1 = this.field_1133_g[i2 + (j2 + 1) % 20 * 16] * (float)l2;
                for (int i1 = i2 - 1; i1 <= i2 + 1; ++i1) {
                    for (int k1 = j2; k1 <= j2 + 1; ++k1) {
                        int i22 = i1;
                        int k2 = k1;
                        if (i22 >= 0 && k2 >= 0 && i22 < 16 && k2 < 20) {
                            f1 += this.field_1133_g[i22 + k2 * 16];
                        }
                        ++l2;
                    }
                }
                this.field_1132_h[i2 + j2 * 16] = f1 / ((float)l2 * 1.06f);
                if (j2 < 19) continue;
                this.field_1132_h[i2 + j2 * 16] = (float)(Math.random() * Math.random() * Math.random() * 4.0 + Math.random() * (double)0.1f + (double)0.2f);
            }
        }
        float[] af2 = this.field_1132_h;
        this.field_1132_h = this.field_1133_g;
        this.field_1133_g = af2;
        for (int k2 = 0; k2 < 256; ++k2) {
            float f2 = this.field_1133_g[k2] * 1.8f;
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            float f22 = f2;
            int j1 = (int)(f22 * 155.0f + 100.0f);
            int l1 = (int)(f22 * f22 * 255.0f);
            int j2 = (int)(f22 * f22 * f22 * f22 * f22 * f22 * f22 * f22 * f22 * f22 * 255.0f);
            int c2 = 255;
            if (f22 < 0.5f) {
                c2 = 0;
            }
            f22 = (f22 - 0.5f) * 2.0f;
            if (this.field_1131_c) {
                int l2 = (j1 * 30 + l1 * 59 + j2 * 11) / 100;
                int i3 = (j1 * 30 + l1 * 70) / 100;
                int j3 = (j1 * 30 + j2 * 70) / 100;
                j1 = l2;
                l1 = i3;
                j2 = j3;
            }
            this.field_1127_a[k2 * 4 + 0] = (byte)j1;
            this.field_1127_a[k2 * 4 + 1] = (byte)l1;
            this.field_1127_a[k2 * 4 + 2] = (byte)j2;
            this.field_1127_a[k2 * 4 + 3] = (byte)c2;
        }
    }
}

