/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.minecraft.client.Minecraft;

public final class GameWindowListener
extends WindowAdapter {
    final Minecraft mc;
    final Thread mcThread;

    public GameWindowListener(Minecraft minecraft, Thread thread) {
        this.mc = minecraft;
        this.mcThread = thread;
    }

    @Override
    public void windowClosing(WindowEvent windowevent) {
        this.mc.shutdown();
        try {
            this.mcThread.join();
        }
        catch (InterruptedException interruptedexception) {
            interruptedexception.printStackTrace();
        }
        System.exit(0);
    }
}

