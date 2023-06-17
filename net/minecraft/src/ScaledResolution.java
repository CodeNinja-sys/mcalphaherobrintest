/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

public class ScaledResolution {
    private int scaledWidth;
    private int scaledHeight;
    public int scaleFactor;

    public ScaledResolution(int i2, int j2) {
        this.scaledWidth = i2;
        this.scaledHeight = j2;
        this.scaleFactor = 1;
        while (this.scaledWidth / (this.scaleFactor + 1) >= 320 && this.scaledHeight / (this.scaleFactor + 1) >= 240) {
            ++this.scaleFactor;
        }
        this.scaledWidth /= this.scaleFactor;
        this.scaledHeight /= this.scaleFactor;
    }

    public int getScaledWidth() {
        return this.scaledWidth;
    }

    public int getScaledHeight() {
        return this.scaledHeight;
    }
}

