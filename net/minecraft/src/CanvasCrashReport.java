/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.Canvas;
import java.awt.Dimension;

class CanvasCrashReport
extends Canvas {
    public CanvasCrashReport(int i2) {
        this.setPreferredSize(new Dimension(i2, i2));
        this.setMinimumSize(new Dimension(i2, i2));
    }
}

