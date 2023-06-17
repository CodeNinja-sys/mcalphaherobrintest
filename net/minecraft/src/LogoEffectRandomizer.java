/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GuiMainMenu;

class LogoEffectRandomizer {
    public double field_1312_a;
    public double field_1311_b;
    public double field_1314_c;
    final GuiMainMenu mainMenu;

    public LogoEffectRandomizer(GuiMainMenu guimainmenu, int i2, int j2) {
        this.mainMenu = guimainmenu;
        this.field_1312_a = this.field_1311_b = (double)(10 + j2) + GuiMainMenu.getRand().nextDouble() * 32.0 + (double)i2;
    }

    public void func_875_a() {
        this.field_1311_b = this.field_1312_a;
        if (this.field_1312_a > 0.0) {
            this.field_1314_c -= 0.6;
        }
        this.field_1312_a += this.field_1314_c;
        this.field_1314_c *= 0.9;
        if (this.field_1312_a < 0.0) {
            this.field_1312_a = 0.0;
            this.field_1314_c = 0.0;
        }
    }
}

