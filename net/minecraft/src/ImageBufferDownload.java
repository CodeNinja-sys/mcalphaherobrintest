/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import net.minecraft.src.ImageBuffer;

public class ImageBufferDownload
implements ImageBuffer {
    private int[] imageData;
    private int imageWidth;
    private int imageHeight;

    @Override
    public BufferedImage func_883_a(BufferedImage bufferedimage) {
        if (bufferedimage == null) {
            return null;
        }
        this.imageWidth = 64;
        this.imageHeight = 32;
        BufferedImage bufferedimage1 = new BufferedImage(this.imageWidth, this.imageHeight, 2);
        Graphics g2 = bufferedimage1.getGraphics();
        g2.drawImage(bufferedimage, 0, 0, null);
        g2.dispose();
        this.imageData = ((DataBufferInt)bufferedimage1.getRaster().getDataBuffer()).getData();
        this.func_884_b(0, 0, 32, 16);
        this.func_885_a(32, 0, 64, 32);
        this.func_884_b(0, 16, 64, 32);
        boolean flag = false;
        for (int i2 = 32; i2 < 64; ++i2) {
            for (int k2 = 0; k2 < 16; ++k2) {
                int i1 = this.imageData[i2 + k2 * 64];
                if ((i1 >> 24 & 0xFF) >= 128) continue;
                flag = true;
            }
        }
        if (!flag) {
            for (int j2 = 32; j2 < 64; ++j2) {
                for (int l2 = 0; l2 < 16; ++l2) {
                    int j1 = this.imageData[j2 + l2 * 64];
                    if ((j1 >> 24 & 0xFF) >= 128) continue;
                    boolean bl2 = true;
                }
            }
        }
        return bufferedimage1;
    }

    private void func_885_a(int i2, int j2, int k2, int l2) {
        if (this.func_886_c(i2, j2, k2, l2)) {
            return;
        }
        for (int i1 = i2; i1 < k2; ++i1) {
            for (int j1 = j2; j1 < l2; ++j1) {
                int n2 = i1 + j1 * this.imageWidth;
                this.imageData[n2] = this.imageData[n2] & 0xFFFFFF;
            }
        }
    }

    private void func_884_b(int i2, int j2, int k2, int l2) {
        for (int i1 = i2; i1 < k2; ++i1) {
            for (int j1 = j2; j1 < l2; ++j1) {
                int n2 = i1 + j1 * this.imageWidth;
                this.imageData[n2] = this.imageData[n2] | 0xFF000000;
            }
        }
    }

    private boolean func_886_c(int i2, int j2, int k2, int l2) {
        for (int i1 = i2; i1 < k2; ++i1) {
            for (int j1 = j2; j1 < l2; ++j1) {
                int k1 = this.imageData[i1 + j1 * this.imageWidth];
                if ((k1 >> 24 & 0xFF) >= 128) continue;
                return true;
            }
        }
        return false;
    }
}

