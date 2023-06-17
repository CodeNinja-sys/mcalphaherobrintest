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

public class TextureCompassFX
extends TextureFX {
    private Minecraft mc;
    private int[] field_4230_h = new int[256];
    private double field_4229_i;
    private double field_4228_j;

    public TextureCompassFX(Minecraft minecraft) {
        super(Item.compass.getIconIndex(null));
        this.mc = minecraft;
        this.field_1128_f = 1;
        try {
            BufferedImage bufferedimage = ImageIO.read(Minecraft.class.getResource("/gui/items.png"));
            int i2 = this.field_1126_b % 16 * 16;
            int j2 = this.field_1126_b / 16 * 16;
            bufferedimage.getRGB(i2, j2, 16, 16, this.field_4230_h, 0, 16);
        }
        catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
    }

    @Override
    public void func_783_a() {
        double d2;
        for (int i2 = 0; i2 < 256; ++i2) {
            int j2 = this.field_4230_h[i2] >> 24 & 0xFF;
            int k2 = this.field_4230_h[i2] >> 16 & 0xFF;
            int l2 = this.field_4230_h[i2] >> 8 & 0xFF;
            int i1 = this.field_4230_h[i2] >> 0 & 0xFF;
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
        double d3 = 0.0;
        if (this.mc.theWorld != null && this.mc.thePlayer != null) {
            double d1 = (double)this.mc.theWorld.spawnX - this.mc.thePlayer.posX;
            double d32 = (double)this.mc.theWorld.spawnZ - this.mc.thePlayer.posZ;
            d3 = (double)(this.mc.thePlayer.rotationYaw - 90.0f) * Math.PI / 180.0 - Math.atan2(d32, d1);
            if (this.mc.theWorld.worldProvider.field_4220_c) {
                d3 = Math.random() * 3.1415927410125732 * 2.0;
            }
        }
        for (d2 = d3 - this.field_4229_i; d2 < -Math.PI; d2 += Math.PI * 2) {
        }
        while (d2 >= Math.PI) {
            d2 -= Math.PI * 2;
        }
        if (d2 < -1.0) {
            d2 = -1.0;
        }
        if (d2 > 1.0) {
            d2 = 1.0;
        }
        this.field_4228_j += d2 * 0.1;
        this.field_4228_j *= 0.8;
        this.field_4229_i += this.field_4228_j;
        double d4 = Math.sin(this.field_4229_i);
        double d5 = Math.cos(this.field_4229_i);
        for (int i2 = -4; i2 <= 4; ++i2) {
            int k2 = (int)(8.5 + d5 * (double)i2 * 0.3);
            int i3 = (int)(7.5 - d4 * (double)i2 * 0.3 * 0.5);
            int k3 = i3 * 16 + k2;
            int i4 = 100;
            int k4 = 100;
            int i5 = 100;
            int c2 = 255;
            if (this.field_1131_c) {
                int k5 = (i4 * 30 + k4 * 59 + i5 * 11) / 100;
                int i6 = (i4 * 30 + k4 * 70) / 100;
                int k6 = (i4 * 30 + i5 * 70) / 100;
                i4 = k5;
                k4 = i6;
                i5 = k6;
            }
            this.field_1127_a[k3 * 4 + 0] = (byte)i4;
            this.field_1127_a[k3 * 4 + 1] = (byte)k4;
            this.field_1127_a[k3 * 4 + 2] = (byte)i5;
            this.field_1127_a[k3 * 4 + 3] = (byte)c2;
        }
        for (int j2 = -8; j2 <= 16; ++j2) {
            int l2 = (int)(8.5 + d4 * (double)j2 * 0.3);
            int j3 = (int)(7.5 + d5 * (double)j2 * 0.3 * 0.5);
            int l3 = j3 * 16 + l2;
            int j4 = j2 < 0 ? 100 : 255;
            int l4 = j2 < 0 ? 100 : 20;
            int j5 = j2 < 0 ? 100 : 20;
            int c1 = 255;
            if (this.field_1131_c) {
                int l5 = (j4 * 30 + l4 * 59 + j5 * 11) / 100;
                int j6 = (j4 * 30 + l4 * 70) / 100;
                int l6 = (j4 * 30 + j5 * 70) / 100;
                j4 = l5;
                l4 = j6;
                j5 = l6;
            }
            this.field_1127_a[l3 * 4 + 0] = (byte)j4;
            this.field_1127_a[l3 * 4 + 1] = (byte)l4;
            this.field_1127_a[l3 * 4 + 2] = (byte)j5;
            this.field_1127_a[l3 * 4 + 3] = (byte)c1;
        }
    }
}

