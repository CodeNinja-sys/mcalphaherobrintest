/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.CanvasIsomPreview;

class ThreadRunIsoClient
extends Thread {
    final CanvasIsomPreview field_1197_a;

    ThreadRunIsoClient(CanvasIsomPreview canvasisompreview) {
        this.field_1197_a = canvasisompreview;
    }

    @Override
    public void run() {
        while (CanvasIsomPreview.func_1271_a(this.field_1197_a)) {
            this.field_1197_a.func_1265_d();
            try {
                Thread.sleep(1L);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }
}

