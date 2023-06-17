/*
 * Decompiled with CFR 0.150.
 */
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Frame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;

public final class gj
extends Minecraft {
    final /* synthetic */ Frame a;

    public gj(Component component, Canvas canvas, MinecraftApplet minecraftApplet, int n2, int n3, boolean bl2, Frame frame) {
        this.a = frame;
        super(component, canvas, minecraftApplet, n2, n3, bl2);
    }

    public void a(hr hr2) {
        this.a.removeAll();
        this.a.add((Component)new av(hr2), "Center");
        this.a.validate();
    }
}

