/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TextureFX;

public class TexturePortalFX
extends TextureFX {
    private int field_4227_g = 0;
    private byte[][] field_4226_h = new byte[32][1024];

    public TexturePortalFX() {
        super(Block.portal.blockIndexInTexture);
        Random random = new Random(100L);
        for (int i2 = 0; i2 < 32; ++i2) {
            for (int j2 = 0; j2 < 16; ++j2) {
                for (int k2 = 0; k2 < 16; ++k2) {
                    float f2 = 0.0f;
                    for (int l2 = 0; l2 < 2; ++l2) {
                        float f1 = l2 * 8;
                        float f22 = l2 * 8;
                        float f3 = ((float)j2 - f1) / 16.0f * 2.0f;
                        float f4 = ((float)k2 - f22) / 16.0f * 2.0f;
                        if (f3 < -1.0f) {
                            f3 += 2.0f;
                        }
                        if (f3 >= 1.0f) {
                            f3 -= 2.0f;
                        }
                        if (f4 < -1.0f) {
                            f4 += 2.0f;
                        }
                        if (f4 >= 1.0f) {
                            f4 -= 2.0f;
                        }
                        float f5 = f3 * f3 + f4 * f4;
                        float f6 = (float)Math.atan2(f4, f3) + ((float)i2 / 32.0f * 3.141593f * 2.0f - f5 * 10.0f + (float)(l2 * 2)) * (float)(l2 * 2 - 1);
                        f6 = (MathHelper.sin(f6) + 1.0f) / 2.0f;
                        f2 += (f6 /= f5 + 1.0f) * 0.5f;
                    }
                    int i1 = (int)((f2 += random.nextFloat() * 0.1f) * 100.0f + 155.0f);
                    int j1 = (int)(f2 * f2 * 200.0f + 55.0f);
                    int k1 = (int)(f2 * f2 * f2 * f2 * 255.0f);
                    int l1 = (int)(f2 * 100.0f + 155.0f);
                    int i22 = k2 * 16 + j2;
                    this.field_4226_h[i2][i22 * 4 + 0] = (byte)j1;
                    this.field_4226_h[i2][i22 * 4 + 1] = (byte)k1;
                    this.field_4226_h[i2][i22 * 4 + 2] = (byte)i1;
                    this.field_4226_h[i2][i22 * 4 + 3] = (byte)l1;
                }
            }
        }
    }

    @Override
    public void func_783_a() {
        ++this.field_4227_g;
        byte[] abyte0 = this.field_4226_h[this.field_4227_g & 0x1F];
        for (int i2 = 0; i2 < 256; ++i2) {
            int j2 = abyte0[i2 * 4 + 0] & 0xFF;
            int k2 = abyte0[i2 * 4 + 1] & 0xFF;
            int l2 = abyte0[i2 * 4 + 2] & 0xFF;
            int i1 = abyte0[i2 * 4 + 3] & 0xFF;
            if (this.field_1131_c) {
                int j1 = (j2 * 30 + k2 * 59 + l2 * 11) / 100;
                int k1 = (j2 * 30 + k2 * 70) / 100;
                int l1 = (j2 * 30 + l2 * 70) / 100;
                j2 = j1;
                k2 = k1;
                l2 = l1;
            }
            this.field_1127_a[i2 * 4 + 0] = (byte)j2;
            this.field_1127_a[i2 * 4 + 1] = (byte)k2;
            this.field_1127_a[i2 * 4 + 2] = (byte)l2;
            this.field_1127_a[i2 * 4 + 3] = (byte)i1;
        }
    }
}

