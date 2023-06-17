/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GameSettings;
import net.minecraft.src.MovementInput;

public class MovementInputFromOptions
extends MovementInput {
    private boolean[] field_1179_f = new boolean[10];
    private GameSettings field_1178_g;

    public MovementInputFromOptions(GameSettings gamesettings) {
        this.field_1178_g = gamesettings;
    }

    @Override
    public void func_796_a(int i2, boolean flag) {
        int byte0 = -1;
        if (i2 == this.field_1178_g.keyBindForward.keyCode) {
            byte0 = 0;
        }
        if (i2 == this.field_1178_g.keyBindBack.keyCode) {
            byte0 = 1;
        }
        if (i2 == this.field_1178_g.keyBindLeft.keyCode) {
            byte0 = 2;
        }
        if (i2 == this.field_1178_g.keyBindRight.keyCode) {
            byte0 = 3;
        }
        if (i2 == this.field_1178_g.keyBindJump.keyCode) {
            byte0 = 4;
        }
        if (i2 == this.field_1178_g.keyBindSneak.keyCode) {
            byte0 = 5;
        }
        if (byte0 >= 0) {
            this.field_1179_f[byte0] = flag;
        }
    }

    @Override
    public void func_798_a() {
        for (int i2 = 0; i2 < 10; ++i2) {
            this.field_1179_f[i2] = false;
        }
    }

    @Override
    public void func_797_a(EntityPlayer entityplayer) {
        this.field_1174_a = 0.0f;
        this.field_1173_b = 0.0f;
        if (this.field_1179_f[0]) {
            this.field_1173_b += 1.0f;
        }
        if (this.field_1179_f[1]) {
            this.field_1173_b -= 1.0f;
        }
        if (this.field_1179_f[2]) {
            this.field_1174_a += 1.0f;
        }
        if (this.field_1179_f[3]) {
            this.field_1174_a -= 1.0f;
        }
        this.field_1176_d = this.field_1179_f[4];
        this.field_1175_e = this.field_1179_f[5];
        if (this.field_1175_e) {
            this.field_1174_a = (float)((double)this.field_1174_a * 0.3);
            this.field_1173_b = (float)((double)this.field_1173_b * 0.3);
        }
    }
}

