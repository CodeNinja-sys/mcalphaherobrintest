/*
 * Decompiled with CFR 0.150.
 */
import org.lwjgl.opengl.GL11;

public class mi
extends aq {
    protected gm a;

    public mi() {
        this.c = 0.5f;
        this.a = new im();
    }

    public void a(qd qd2, double d2, double d3, double d4, float f2, float f3) {
        GL11.glPushMatrix();
        double d5 = qd2.aV + (qd2.aw - qd2.aV) * (double)f3;
        double d6 = qd2.aW + (qd2.ax - qd2.aW) * (double)f3;
        double d7 = qd2.aX + (qd2.ay - qd2.aX) * (double)f3;
        double d8 = 0.3f;
        ao ao2 = qd2.h(d5, d6, d7);
        float f4 = qd2.aF + (qd2.aD - qd2.aF) * f3;
        if (ao2 != null) {
            ao ao3 = qd2.a(d5, d6, d7, d8);
            ao ao4 = qd2.a(d5, d6, d7, -d8);
            if (ao3 == null) {
                ao3 = ao2;
            }
            if (ao4 == null) {
                ao4 = ao2;
            }
            d2 += ao2.a - d5;
            d3 += (ao3.b + ao4.b) / 2.0 - d6;
            d4 += ao2.c - d7;
            ao ao5 = ao4.c(-ao3.a, -ao3.b, -ao3.c);
            if (ao5.c() != 0.0) {
                ao5 = ao5.b();
                f2 = (float)(Math.atan2(ao5.c, ao5.a) * 180.0 / Math.PI);
                f4 = (float)(Math.atan(ao5.b) * 73.0);
            }
        }
        GL11.glTranslatef((float)d2, (float)d3, (float)d4);
        GL11.glRotatef(180.0f - f2, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-f4, 0.0f, 0.0f, 1.0f);
        float f5 = (float)qd2.b - f3;
        float f6 = (float)qd2.a - f3;
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        if (f5 > 0.0f) {
            GL11.glRotatef(fi.a((float)f5) * f5 * f6 / 10.0f * (float)qd2.c, 1.0f, 0.0f, 0.0f);
        }
        if (qd2.d != 0) {
            this.a("/terrain.png");
            float f7 = 0.75f;
            GL11.glScalef(f7, f7, f7);
            GL11.glTranslatef(0.0f, 0.3125f, 0.0f);
            GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
            if (qd2.d == 1) {
                new bk().a(nq.au);
            } else if (qd2.d == 2) {
                new bk().a(nq.aB);
            }
            GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(0.0f, -0.3125f, 0.0f);
            GL11.glScalef(1.0f / f7, 1.0f / f7, 1.0f / f7);
        }
        this.a("/item/cart.png");
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        this.a.b(0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
}

