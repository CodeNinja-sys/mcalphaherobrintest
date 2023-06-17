/*
 * Decompiled with CFR 0.150.
 */
import org.lwjgl.opengl.GL11;

public class m
extends ec {
    protected dc a;

    public m(dc dc2, float f2) {
        super(dc2, f2);
        this.a = dc2;
    }

    protected void b(hf hf2, float f2) {
        fp fp2 = hf2.l();
        if (fp2 != null) {
            GL11.glPushMatrix();
            this.a.d.b(0.0625f);
            GL11.glTranslatef(-0.0625f, 0.4375f, 0.0625f);
            if (fp2.c < 256 && bk.a(nq.m[fp2.c].g())) {
                float f3 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f3 *= 0.75f, -f3, f3);
            } else if (dx.c[fp2.c].a()) {
                float f4 = 0.625f;
                GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
                GL11.glScalef(f4, -f4, f4);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else {
                float f5 = 0.375f;
                GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
                GL11.glScalef(f5, f5, f5);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            this.b.f.a(fp2);
            GL11.glPopMatrix();
        }
    }
}

