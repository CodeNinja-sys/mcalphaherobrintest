/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.RenderEngine;
import org.lwjgl.opengl.GL11;

public class TextureFX {
    public byte[] field_1127_a = new byte[1024];
    public int field_1126_b;
    public boolean field_1131_c = false;
    public int field_1130_d = 0;
    public int field_1129_e = 1;
    public int field_1128_f = 0;

    public TextureFX(int i2) {
        this.field_1126_b = i2;
    }

    public void func_783_a() {
    }

    public void func_782_a(RenderEngine renderengine) {
        if (this.field_1128_f == 0) {
            GL11.glBindTexture(3553, renderengine.getTexture("/terrain.png"));
        } else if (this.field_1128_f == 1) {
            GL11.glBindTexture(3553, renderengine.getTexture("/gui/items.png"));
        }
    }
}

