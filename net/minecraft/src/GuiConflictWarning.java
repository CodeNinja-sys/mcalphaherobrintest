/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;

public class GuiConflictWarning
extends GuiScreen {
    private int updateCounter = 0;

    @Override
    public void updateScreen() {
        ++this.updateCounter;
    }

    @Override
    public void initGui() {
        this.controlList.clear();
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, "Back to title screen"));
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
        if (!guibutton.enabled) {
            return;
        }
        if (guibutton.id == 0) {
            this.mc.displayGuiScreen(new GuiMainMenu());
        }
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "Level save conflict", this.width / 2, this.height / 4 - 60 + 20, 0xFFFFFF);
        this.drawString(this.fontRenderer, "Minecraft detected a conflict in the level save data.", this.width / 2 - 140, this.height / 4 - 60 + 60 + 0, 0xA0A0A0);
        this.drawString(this.fontRenderer, "This could be caused by two copies of the game", this.width / 2 - 140, this.height / 4 - 60 + 60 + 18, 0xA0A0A0);
        this.drawString(this.fontRenderer, "accessing the same level.", this.width / 2 - 140, this.height / 4 - 60 + 60 + 27, 0xA0A0A0);
        this.drawString(this.fontRenderer, "To prevent level corruption, the current game has quit.", this.width / 2 - 140, this.height / 4 - 60 + 60 + 45, 0xA0A0A0);
        super.drawScreen(i2, j2, f2);
    }
}

