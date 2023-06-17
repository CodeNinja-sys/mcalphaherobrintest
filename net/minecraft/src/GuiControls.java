/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GameSettings;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSmallButton;

public class GuiControls
extends GuiScreen {
    private GuiScreen parentScreen;
    protected String screenTitle = "Controls";
    private GameSettings options;
    private int buttonId = -1;

    public GuiControls(GuiScreen guiscreen, GameSettings gamesettings) {
        this.parentScreen = guiscreen;
        this.options = gamesettings;
    }

    @Override
    public void initGui() {
        for (int i2 = 0; i2 < this.options.keyBindings.length; ++i2) {
            this.controlList.add(new GuiSmallButton(i2, this.width / 2 - 155 + i2 % 2 * 160, this.height / 6 + 24 * (i2 >> 1), this.options.getKeyBinding(i2)));
        }
        this.controlList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, "Done"));
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
        for (int i2 = 0; i2 < this.options.keyBindings.length; ++i2) {
            ((GuiButton)this.controlList.get((int)i2)).displayString = this.options.getKeyBinding(i2);
        }
        if (guibutton.id == 200) {
            this.mc.displayGuiScreen(this.parentScreen);
        } else {
            this.buttonId = guibutton.id;
            guibutton.displayString = "> " + this.options.getKeyBinding(guibutton.id) + " <";
        }
    }

    @Override
    protected void keyTyped(char c2, int i2) {
        if (this.buttonId >= 0) {
            this.options.setKeyBinding(this.buttonId, i2);
            ((GuiButton)this.controlList.get((int)this.buttonId)).displayString = this.options.getKeyBinding(this.buttonId);
            this.buttonId = -1;
        } else {
            super.keyTyped(c2, i2);
        }
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(i2, j2, f2);
    }
}

