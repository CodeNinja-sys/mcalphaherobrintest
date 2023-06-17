/*
 * Decompiled with CFR 0.150.
 */
import org.lwjgl.opengl.GL11;

public class ql
extends ec {
    public ql() {
        super(new lm(), 1.0f);
        this.a(new lm());
    }

    protected float a(be be2) {
        return 180.0f;
    }

    protected boolean a(be be2, int n2) {
        if (n2 != 0) {
            return false;
        }
        if (n2 != 0) {
            return false;
        }
        this.a("/mob/spider_eyes.png");
        float f2 = (1.0f - be2.a(1.0f)) * 0.5f;
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f2);
        return true;
    }
}

