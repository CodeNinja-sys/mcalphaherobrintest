/*
 * Decompiled with CFR 0.150.
 */
import org.lwjgl.opengl.GL11;

public class ht
extends ec {
    private gm a;

    public ht(gm gm2, gm gm3, float f2) {
        super(gm2, f2);
        this.a = gm3;
    }

    protected boolean a(ns ns2, int n2) {
        if (n2 == 0) {
            this.a(this.a);
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            return true;
        }
        if (n2 == 1) {
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        return false;
    }

    protected void a(ns ns2, float f2) {
        float f3 = (ns2.b + (ns2.a - ns2.b) * f2) / ((float)ns2.c * 0.5f + 1.0f);
        float f4 = 1.0f / (f3 + 1.0f);
        float f5 = ns2.c;
        GL11.glScalef(f4 * f5, 1.0f / f4 * f5, f4 * f5);
    }
}

