/*
 * Decompiled with CFR 0.150.
 */
import org.lwjgl.opengl.GL11;

public class jb
extends aq {
    private bk a = new bk();

    public jb() {
        this.c = 0.5f;
    }

    public void a(kr kr2, double d2, double d3, double d4, float f2, float f3) {
        float f4;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d2, (float)d3, (float)d4);
        if ((float)kr2.a - f3 + 1.0f < 10.0f) {
            f4 = 1.0f - ((float)kr2.a - f3 + 1.0f) / 10.0f;
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            f4 *= f4;
            f4 *= f4;
            float f5 = 1.0f + f4 * 0.3f;
            GL11.glScalef(f5, f5, f5);
        }
        f4 = (1.0f - ((float)kr2.a - f3 + 1.0f) / 100.0f) * 0.8f;
        this.a("/terrain.png");
        this.a.a(nq.am);
        if (kr2.a / 5 % 2 == 0) {
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 772);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, f4);
            this.a.a(nq.am);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
        GL11.glPopMatrix();
    }
}

