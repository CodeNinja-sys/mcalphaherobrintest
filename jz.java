/*
 * Decompiled with CFR 0.150.
 */
import org.lwjgl.opengl.GL11;

public class jz
extends ec {
    public jz() {
        super(new hc(), 0.5f);
    }

    protected void a(am am2, float f2) {
        am am3 = am2;
        float f3 = ((float)am3.e + (float)(am3.f - am3.e) * f2) / 20.0f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        f3 = 1.0f / (f3 * f3 * f3 * f3 * f3 * 2.0f + 1.0f);
        float f4 = (8.0f + f3) / 2.0f;
        float f5 = (8.0f + 1.0f / f3) / 2.0f;
        GL11.glScalef(f5, f4, f5);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
}

