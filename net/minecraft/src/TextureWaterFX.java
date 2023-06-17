/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.TextureFX;

public class TextureWaterFX
extends TextureFX {
    protected float[] field_1158_g = new float[256];
    protected float[] field_1157_h = new float[256];
    protected float[] field_1156_i = new float[256];
    protected float[] field_1155_j = new float[256];
    private int tickCounter = 0;

    public TextureWaterFX() {
        super(Block.waterStill.blockIndexInTexture);
    }

    @Override
    public void func_783_a() {
        ++this.tickCounter;
        for (int i2 = 0; i2 < 16; ++i2) {
            for (int k2 = 0; k2 < 16; ++k2) {
                float f2 = 0.0f;
                for (int j1 = i2 - 1; j1 <= i2 + 1; ++j1) {
                    int k1 = j1 & 0xF;
                    int i22 = k2 & 0xF;
                    f2 += this.field_1158_g[k1 + i22 * 16];
                }
                this.field_1157_h[i2 + k2 * 16] = f2 / 3.3f + this.field_1156_i[i2 + k2 * 16] * 0.8f;
            }
        }
        for (int j2 = 0; j2 < 16; ++j2) {
            for (int l2 = 0; l2 < 16; ++l2) {
                int n2 = j2 + l2 * 16;
                this.field_1156_i[n2] = this.field_1156_i[n2] + this.field_1155_j[j2 + l2 * 16] * 0.05f;
                if (this.field_1156_i[j2 + l2 * 16] < 0.0f) {
                    this.field_1156_i[j2 + l2 * 16] = 0.0f;
                }
                int n3 = j2 + l2 * 16;
                this.field_1155_j[n3] = this.field_1155_j[n3] - 0.1f;
                if (!(Math.random() < 0.05)) continue;
                this.field_1155_j[j2 + l2 * 16] = 0.5f;
            }
        }
        float[] af2 = this.field_1157_h;
        this.field_1157_h = this.field_1158_g;
        this.field_1158_g = af2;
        for (int i1 = 0; i1 < 256; ++i1) {
            float f1 = this.field_1158_g[i1];
            if (f1 > 1.0f) {
                f1 = 1.0f;
            }
            if (f1 < 0.0f) {
                f1 = 0.0f;
            }
            float f2 = f1 * f1;
            int l1 = (int)(32.0f + f2 * 32.0f);
            int j2 = (int)(50.0f + f2 * 64.0f);
            int k2 = 255;
            int l2 = (int)(146.0f + f2 * 50.0f);
            if (this.field_1131_c) {
                int i3 = (l1 * 30 + j2 * 59 + k2 * 11) / 100;
                int j3 = (l1 * 30 + j2 * 70) / 100;
                int k3 = (l1 * 30 + k2 * 70) / 100;
                l1 = i3;
                j2 = j3;
                k2 = k3;
            }
            this.field_1127_a[i1 * 4 + 0] = (byte)l1;
            this.field_1127_a[i1 * 4 + 1] = (byte)j2;
            this.field_1127_a[i1 * 4 + 2] = (byte)k2;
            this.field_1127_a[i1 * 4 + 3] = (byte)l2;
        }
    }
}

