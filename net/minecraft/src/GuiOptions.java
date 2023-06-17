/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GameSettings;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiControls;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSlider;
import net.minecraft.src.GuiSmallButton;

public class GuiOptions
extends GuiScreen {
    private GuiScreen parentScreen;
    protected String screenTitle = "Options";
    private GameSettings options;

    public GuiOptions(GuiScreen guiscreen, GameSettings gamesettings) {
        this.parentScreen = guiscreen;
        this.options = gamesettings;
    }

    @Override
    public void initGui() {
        for (int i2 = 0; i2 < this.options.numberOfOptions; ++i2) {
            int j2 = this.options.getOptionControlType(i2);
            if (j2 == 0) {
                this.controlList.add(new GuiSmallButton(i2, this.width / 2 - 155 + i2 % 2 * 160, this.height / 6 + 24 * (i2 >> 1), this.options.getOptionDisplayString(i2)));
                continue;
            }
            this.controlList.add(new GuiSlider(i2, this.width / 2 - 155 + i2 % 2 * 160, this.height / 6 + 24 * (i2 >> 1), i2, this.options.getOptionDisplayString(i2), this.options.getOptionFloatValue(i2)));
        }
        this.controlList.add(new GuiButton(100, this.width / 2 - 100, this.height / 6 + 120 + 12, "Controls..."));
        this.controlList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, "Done"));
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
        if (!guibutton.enabled) {
            return;
        }
        if (guibutton.id < 100) {
            this.options.setOptionValue(guibutton.id, 1);
            guibutton.displayString = this.options.getOptionDisplayString(guibutton.id);
        }
        if (guibutton.id == 100) {
            this.mc.gameSettings.saveOptions();
            this.mc.displayGuiScreen(new GuiControls(this, this.options));
        }
        if (guibutton.id == 200) {
            this.mc.gameSettings.saveOptions();
            this.mc.displayGuiScreen(this.parentScreen);
        }
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(i2, j2, f2);
    }
}

