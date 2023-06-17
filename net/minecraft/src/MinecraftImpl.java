/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Frame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;
import net.minecraft.src.PanelCrashReport;
import net.minecraft.src.UnexpectedThrowable;

public final class MinecraftImpl
extends Minecraft {
    final Frame mainFrame;

    public MinecraftImpl(Component component, Canvas canvas, MinecraftApplet minecraftapplet, int i2, int j2, boolean flag, Frame frame) {
        super(component, canvas, minecraftapplet, i2, j2, flag);
        this.mainFrame = frame;
    }

    @Override
    public void func_4007_a(UnexpectedThrowable unexpectedthrowable) {
        this.mainFrame.removeAll();
        this.mainFrame.add((Component)new PanelCrashReport(unexpectedthrowable), "Center");
        this.mainFrame.validate();
    }
}

