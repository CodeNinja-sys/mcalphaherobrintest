/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

public final class DisplayMode {
    private final int width;
    private final int height;
    private final int bpp;
    private final int freq;
    private final boolean fullscreen;

    public DisplayMode(int width, int height) {
        this(width, height, 0, 0, false);
    }

    DisplayMode(int width, int height, int bpp, int freq) {
        this(width, height, bpp, freq, true);
    }

    private DisplayMode(int width, int height, int bpp, int freq, boolean fullscreen) {
        this.width = width;
        this.height = height;
        this.bpp = bpp;
        this.freq = freq;
        this.fullscreen = fullscreen;
    }

    public boolean isFullscreenCapable() {
        return this.fullscreen;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getBitsPerPixel() {
        return this.bpp;
    }

    public int getFrequency() {
        return this.freq;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DisplayMode)) {
            return false;
        }
        DisplayMode dm2 = (DisplayMode)obj;
        return dm2.width == this.width && dm2.height == this.height && dm2.bpp == this.bpp && dm2.freq == this.freq;
    }

    public int hashCode() {
        return this.width ^ this.height ^ this.freq ^ this.bpp;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(32);
        sb.append(this.width);
        sb.append(" x ");
        sb.append(this.height);
        sb.append(" x ");
        sb.append(this.bpp);
        sb.append(" @");
        sb.append(this.freq);
        sb.append("Hz");
        return sb.toString();
    }
}

