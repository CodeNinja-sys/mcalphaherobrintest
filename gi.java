/*
 * Decompiled with CFR 0.150.
 */
import net.minecraft.client.Minecraft;

public class gi
extends Thread {
    final /* synthetic */ Minecraft a;

    public gi(Minecraft minecraft, String string) {
        this.a = minecraft;
        super(string);
        this.setDaemon(true);
        this.start();
    }

    public void run() {
        while (this.a.H) {
            try {
                Thread.sleep(Integer.MAX_VALUE);
            }
            catch (InterruptedException interruptedException) {}
        }
    }
}

