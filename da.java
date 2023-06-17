/*
 * Decompiled with CFR 0.150.
 */
import org.lwjgl.opengl.GL11;

public class da
extends aq {
    protected gm a;

    public da() {
        this.c = 0.5f;
        this.a = new cv();
    }

    public void a(dp dp2, double d2, double d3, double d4, float f2, float f3) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d2, (float)d3, (float)d4);
        GL11.glRotatef(180.0f - f2, 0.0f, 1.0f, 0.0f);
        float f4 = (float)dp2.b - f3;
        float f5 = (float)dp2.a - f3;
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f4 > 0.0f) {
            GL11.glRotatef(fi.a((float)f4) * f4 * f5 / 10.0f * (float)dp2.c, 1.0f, 0.0f, 0.0f);
        }
        this.a("/terrain.png");
        float f6 = 0.75f;
        GL11.glScalef(f6, f6, f6);
        GL11.glScalef(1.0f / f6, 1.0f / f6, 1.0f / f6);
        this.a("/item/boat.png");
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        this.a.b(0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
}

