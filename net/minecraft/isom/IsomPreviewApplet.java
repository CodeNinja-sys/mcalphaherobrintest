/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.isom;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Component;

public class IsomPreviewApplet
extends Applet {
    private ah a = new ah();

    public IsomPreviewApplet() {
        this.setLayout(new BorderLayout());
        this.add((Component)this.a, "Center");
    }

    public void start() {
        this.a.b();
    }

    public void stop() {
        this.a.c();
    }
}

