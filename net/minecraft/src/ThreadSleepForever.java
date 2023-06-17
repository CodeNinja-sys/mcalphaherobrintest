/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class ThreadSleepForever
extends Thread {
    final Minecraft mc;

    public ThreadSleepForever(Minecraft minecraft, String s2) {
        super(s2);
        this.mc = minecraft;
        this.setDaemon(true);
        this.start();
    }

    @Override
    public void run() {
        while (this.mc.running) {
            try {
                Thread.sleep(Integer.MAX_VALUE);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
    }
}

