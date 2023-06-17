/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.image.BufferedImage;
import net.minecraft.src.ImageBuffer;
import net.minecraft.src.ThreadDownloadImage;

public class ThreadDownloadImageData {
    public BufferedImage image;
    public int referenceCount = 1;
    public int textureName = -1;
    public boolean textureSetupComplete = false;

    public ThreadDownloadImageData(String s2, ImageBuffer imagebuffer) {
        new ThreadDownloadImage(this, s2, imagebuffer).start();
    }
}

