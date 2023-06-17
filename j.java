/*
 * Decompiled with CFR 0.150.
 */
import java.awt.Canvas;
import net.minecraft.client.MinecraftApplet;

public class j
extends Canvas {
    final /* synthetic */ MinecraftApplet a;

    public j(MinecraftApplet minecraftApplet) {
        this.a = minecraftApplet;
    }

    public synchronized void addNotify() {
        super.addNotify();
        this.a.a();
    }

    public synchronized void removeNotify() {
        this.a.b();
        super.removeNotify();
    }
}

