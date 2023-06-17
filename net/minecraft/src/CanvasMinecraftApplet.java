/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.Canvas;
import net.minecraft.client.MinecraftApplet;

public class CanvasMinecraftApplet
extends Canvas {
    final MinecraftApplet mcApplet;

    public CanvasMinecraftApplet(MinecraftApplet minecraftapplet) {
        this.mcApplet = minecraftapplet;
    }

    @Override
    public synchronized void addNotify() {
        super.addNotify();
        this.mcApplet.func_6233_a();
    }

    @Override
    public synchronized void removeNotify() {
        this.mcApplet.shutdown();
        super.removeNotify();
    }
}

