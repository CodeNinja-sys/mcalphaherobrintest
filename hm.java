/*
 * Decompiled with CFR 0.150.
 */
import org.lwjgl.opengl.GL11;

public class hm
extends aq {
    public void a(lw lw2, double d2, double d3, double d4, float f2, float f3) {
        GL11.glPushMatrix();
        hm.a(lw2.aG, d2 - lw2.aV, d3 - lw2.aW, d4 - lw2.aX);
        GL11.glPopMatrix();
    }
}

