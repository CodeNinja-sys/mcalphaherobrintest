/*
 * Decompiled with CFR 0.150.
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.minecraft.client.Minecraft;

public final class gn
extends WindowAdapter {
    final /* synthetic */ Minecraft a;
    final /* synthetic */ Thread b;

    public gn(Minecraft minecraft, Thread thread) {
        this.a = minecraft;
        this.b = thread;
    }

    public void windowClosing(WindowEvent windowEvent) {
        this.a.d();
        try {
            this.b.join();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        System.exit(0);
    }
}

