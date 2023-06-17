/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;
import net.minecraft.src.PanelCrashReport;
import net.minecraft.src.UnexpectedThrowable;

public class MinecraftAppletImpl
extends Minecraft {
    final MinecraftApplet mainFrame;

    public MinecraftAppletImpl(MinecraftApplet minecraftapplet, Component component, Canvas canvas, MinecraftApplet minecraftapplet1, int i2, int j2, boolean flag) {
        super(component, canvas, minecraftapplet1, i2, j2, flag);
        this.mainFrame = minecraftapplet;
    }

    @Override
    public void func_4007_a(UnexpectedThrowable unexpectedthrowable) {
        this.mainFrame.removeAll();
        this.mainFrame.setLayout(new BorderLayout());
        this.mainFrame.add((Component)new PanelCrashReport(unexpectedthrowable), "Center");
        this.mainFrame.validate();
    }
}

