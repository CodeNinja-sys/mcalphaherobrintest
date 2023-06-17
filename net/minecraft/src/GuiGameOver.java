/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;
import org.lwjgl.opengl.GL11;

public class GuiGameOver
extends GuiScreen {
    @Override
    public void initGui() {
        this.controlList.clear();
        this.controlList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 72, "Respawn"));
        this.controlList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 96, "Title menu"));
        if (this.mc.field_6320_i == null) {
            ((GuiButton)this.controlList.get((int)1)).enabled = false;
        }
    }

    @Override
    protected void keyTyped(char c2, int i2) {
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id != 0) {
            // empty if block
        }
        if (guibutton.id == 1) {
            this.mc.thePlayer.func_9367_r();
            this.mc.displayGuiScreen(null);
        }
        if (guibutton.id == 2) {
            this.mc.func_6261_a(null);
            this.mc.displayGuiScreen(new GuiMainMenu());
        }
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawGradientRect(0, 0, this.width, this.height, 0x60500000, -1602211792);
        GL11.glPushMatrix();
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        this.drawCenteredString(this.fontRenderer, "Game over!", this.width / 2 / 2, 30, 0xFFFFFF);
        GL11.glPopMatrix();
        this.drawCenteredString(this.fontRenderer, "Score: &e" + this.mc.thePlayer.func_6417_t(), this.width / 2, 100, 0xFFFFFF);
        super.drawScreen(i2, j2, f2);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}

