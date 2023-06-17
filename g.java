/*
 * Decompiled with CFR 0.150.
 */
import org.lwjgl.opengl.GL11;

public class g
extends ec {
    public g() {
        super(new fg(), 0.5f);
    }

    protected void a(dq dq2, float f2) {
        dq dq3 = dq2;
        float f3 = dq3.b(f2);
        float f4 = 1.0f + fi.a((float)(f3 * 100.0f)) * f3 * 0.01f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        f3 *= f3;
        f3 *= f3;
        float f5 = (1.0f + f3 * 0.4f) * f4;
        float f6 = (1.0f + f3 * 0.1f) / f4;
        GL11.glScalef(f5, f6, f5);
    }

    protected int a(dq dq2, float f2, float f3) {
        dq dq3 = dq2;
        float f4 = dq3.b(f3);
        if ((int)(f4 * 10.0f) % 2 == 0) {
            return 0;
        }
        int n2 = (int)(f4 * 0.2f * 255.0f);
        if (n2 < 0) {
            n2 = 0;
        }
        if (n2 > 255) {
            n2 = 255;
        }
        int n3 = 255;
        int n4 = 255;
        int n5 = 255;
        return n2 << 24 | n3 << 16 | n4 << 8 | n5;
    }
}

