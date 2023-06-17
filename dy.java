/*
 * Decompiled with CFR 0.150.
 */
import org.lwjgl.opengl.GL11;

public class dy
extends aq {
    private bk a = new bk();

    public dy() {
        this.c = 0.5f;
    }

    public void a(gb gb2, double d2, double d3, double d4, float f2, float f3) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d2, (float)d3, (float)d4);
        this.a("/terrain.png");
        nq nq2 = nq.m[gb2.a];
        cy cy2 = gb2.k();
        GL11.glDisable(2896);
        this.a.a(nq2, cy2, fi.b(gb2.aw), fi.b(gb2.ax), fi.b(gb2.ay));
        GL11.glEnable(2896);
        GL11.glPopMatrix();
    }
}

