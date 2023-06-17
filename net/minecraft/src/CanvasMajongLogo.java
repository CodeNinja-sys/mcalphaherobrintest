/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.src.PanelCrashReport;

class CanvasMajongLogo
extends Canvas {
    private BufferedImage logo;

    public CanvasMajongLogo() {
        try {
            this.logo = ImageIO.read(PanelCrashReport.class.getResource("/gui/logo.png"));
        }
        catch (IOException iOException) {
            // empty catch block
        }
        int byte0 = 100;
        this.setPreferredSize(new Dimension(byte0, byte0));
        this.setMinimumSize(new Dimension(byte0, byte0));
    }

    @Override
    public void paint(Graphics g2) {
        super.paint(g2);
        g2.drawImage(this.logo, this.getWidth() / 2 - this.logo.getWidth() / 2, 32, null);
    }
}

