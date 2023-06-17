/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TextureFX;

public class TextureLavaFX
extends TextureFX {
    protected float[] field_1147_g = new float[256];
    protected float[] field_1146_h = new float[256];
    protected float[] field_1145_i = new float[256];
    protected float[] field_1144_j = new float[256];

    public TextureLavaFX() {
        super(Block.lavaStill.blockIndexInTexture);
    }

    @Override
    public void func_783_a() {
        for (int i2 = 0; i2 < 16; ++i2) {
            for (int j2 = 0; j2 < 16; ++j2) {
                float f2 = 0.0f;
                int l2 = (int)(MathHelper.sin((float)j2 * 3.141593f * 2.0f / 16.0f) * 1.2f);
                int i1 = (int)(MathHelper.sin((float)i2 * 3.141593f * 2.0f / 16.0f) * 1.2f);
                for (int k1 = i2 - 1; k1 <= i2 + 1; ++k1) {
                    for (int i22 = j2 - 1; i22 <= j2 + 1; ++i22) {
                        int k2 = k1 + l2 & 0xF;
                        int i3 = i22 + i1 & 0xF;
                        f2 += this.field_1147_g[k2 + i3 * 16];
                    }
                }
                this.field_1146_h[i2 + j2 * 16] = f2 / 10.0f + (this.field_1145_i[(i2 + 0 & 0xF) + (j2 + 0 & 0xF) * 16] + this.field_1145_i[(i2 + 1 & 0xF) + (j2 + 0 & 0xF) * 16] + this.field_1145_i[(i2 + 1 & 0xF) + (j2 + 1 & 0xF) * 16] + this.field_1145_i[(i2 + 0 & 0xF) + (j2 + 1 & 0xF) * 16]) / 4.0f * 0.8f;
                int n2 = i2 + j2 * 16;
                this.field_1145_i[n2] = this.field_1145_i[n2] + this.field_1144_j[i2 + j2 * 16] * 0.01f;
                if (this.field_1145_i[i2 + j2 * 16] < 0.0f) {
                    this.field_1145_i[i2 + j2 * 16] = 0.0f;
                }
                int n3 = i2 + j2 * 16;
                this.field_1144_j[n3] = this.field_1144_j[n3] - 0.06f;
                if (!(Math.random() < 0.005)) continue;
                this.field_1144_j[i2 + j2 * 16] = 1.5f;
            }
        }
        float[] af2 = this.field_1146_h;
        this.field_1146_h = this.field_1147_g;
        this.field_1147_g = af2;
        for (int k2 = 0; k2 < 256; ++k2) {
            float f1 = this.field_1147_g[k2] * 2.0f;
            if (f1 > 1.0f) {
                f1 = 1.0f;
            }
            if (f1 < 0.0f) {
                f1 = 0.0f;
            }
            float f2 = f1;
            int j1 = (int)(f2 * 100.0f + 155.0f);
            int l1 = (int)(f2 * f2 * 255.0f);
            int j2 = (int)(f2 * f2 * f2 * f2 * 128.0f);
            if (this.field_1131_c) {
                int l2 = (j1 * 30 + l1 * 59 + j2 * 11) / 100;
                int j3 = (j1 * 30 + l1 * 70) / 100;
                int k3 = (j1 * 30 + j2 * 70) / 100;
                j1 = l2;
                l1 = j3;
                j2 = k3;
            }
            this.field_1127_a[k2 * 4 + 0] = (byte)j1;
            this.field_1127_a[k2 * 4 + 1] = (byte)l1;
            this.field_1127_a[k2 * 4 + 2] = (byte)j2;
            this.field_1127_a[k2 * 4 + 3] = -1;
        }
    }
}

