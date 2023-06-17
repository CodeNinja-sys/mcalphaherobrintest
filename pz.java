/*
 * Decompiled with CFR 0.150.
 */
import org.lwjgl.opengl.GL11;

public class pz
extends ec {
    private float a;

    public pz(gm gm2, float f2, float f3) {
        super(gm2, f2 * f3);
        this.a = f3;
    }

    protected void a(ip ip2, float f2) {
        GL11.glScalef(this.a, this.a, this.a);
    }
}

