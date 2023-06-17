/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Item;
import net.minecraft.src.TextureFX;

public class TextureWatchFX
extends TextureFX {
    private Minecraft field_4225_g;
    private int[] field_4224_h = new int[256];
    private int[] field_4223_i = new int[256];
    private double field_4222_j;
    private double field_4221_k;

    public TextureWatchFX(Minecraft minecraft) {
        super(Item.pocketSundial.getIconIndex(null));
        this.field_4225_g = minecraft;
        this.field_1128_f = 1;
        try {
            BufferedImage bufferedimage = ImageIO.read(Minecraft.class.getResource("/gui/items.png"));
            int i2 = this.field_1126_b % 16 * 16;
            int j2 = this.field_1126_b / 16 * 16;
            bufferedimage.getRGB(i2, j2, 16, 16, this.field_4224_h, 0, 16);
            bufferedimage = ImageIO.read(Minecraft.class.getResource("/misc/dial.png"));
            bufferedimage.getRGB(0, 0, 16, 16, this.field_4223_i, 0, 16);
        }
        catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
    }

    @Override
    public void func_783_a() {
        double d1;
        double d2 = 0.0;
        if (this.field_4225_g.theWorld != null && this.field_4225_g.thePlayer != null) {
            float f2 = this.field_4225_g.theWorld.getCelestialAngle(1.0f);
            d2 = -f2 * 3.141593f * 2.0f;
            if (this.field_4225_g.theWorld.worldProvider.field_4220_c) {
                d2 = Math.random() * 3.1415927410125732 * 2.0;
            }
        }
        for (d1 = d2 - this.field_4222_j; d1 < -Math.PI; d1 += Math.PI * 2) {
        }
        while (d1 >= Math.PI) {
            d1 -= Math.PI * 2;
        }
        if (d1 < -1.0) {
            d1 = -1.0;
        }
        if (d1 > 1.0) {
            d1 = 1.0;
        }
        this.field_4221_k += d1 * 0.1;
        this.field_4221_k *= 0.8;
        this.field_4222_j += this.field_4221_k;
        double d22 = Math.sin(this.field_4222_j);
        double d3 = Math.cos(this.field_4222_j);
        for (int i2 = 0; i2 < 256; ++i2) {
            int j2 = this.field_4224_h[i2] >> 24 & 0xFF;
            int k2 = this.field_4224_h[i2] >> 16 & 0xFF;
            int l2 = this.field_4224_h[i2] >> 8 & 0xFF;
            int i1 = this.field_4224_h[i2] >> 0 & 0xFF;
            if (k2 == i1 && l2 == 0 && i1 > 0) {
                double d4 = -((double)(i2 % 16) / 15.0 - 0.5);
                double d5 = (double)(i2 / 16) / 15.0 - 0.5;
                int i22 = k2;
                int j22 = (int)((d4 * d3 + d5 * d22 + 0.5) * 16.0);
                int k22 = (int)((d5 * d3 - d4 * d22 + 0.5) * 16.0);
                int l22 = (j22 & 0xF) + (k22 & 0xF) * 16;
                j2 = this.field_4223_i[l22] >> 24 & 0xFF;
                k2 = (this.field_4223_i[l22] >> 16 & 0xFF) * i22 / 255;
                l2 = (this.field_4223_i[l22] >> 8 & 0xFF) * i22 / 255;
                i1 = (this.field_4223_i[l22] >> 0 & 0xFF) * i22 / 255;
            }
            if (this.field_1131_c) {
                int j1 = (k2 * 30 + l2 * 59 + i1 * 11) / 100;
                int k1 = (k2 * 30 + l2 * 70) / 100;
                int l1 = (k2 * 30 + i1 * 70) / 100;
                k2 = j1;
                l2 = k1;
                i1 = l1;
            }
            this.field_1127_a[i2 * 4 + 0] = (byte)k2;
            this.field_1127_a[i2 * 4 + 1] = (byte)l2;
            this.field_1127_a[i2 * 4 + 2] = (byte)i1;
            this.field_1127_a[i2 * 4 + 3] = (byte)j2;
        }
    }
}

