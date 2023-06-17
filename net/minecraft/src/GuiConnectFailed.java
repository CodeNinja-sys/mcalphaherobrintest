/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;

public class GuiConnectFailed
extends GuiScreen {
    private String errorMessage;
    private String errorDetail;

    public GuiConnectFailed(String s2, String s1) {
        this.errorMessage = s2;
        this.errorDetail = s1;
    }

    @Override
    public void updateScreen() {
    }

    @Override
    protected void keyTyped(char c2, int i2) {
    }

    @Override
    public void initGui() {
        this.controlList.clear();
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, "Back to title screen"));
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 0) {
            this.mc.displayGuiScreen(new GuiMainMenu());
        }
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.errorMessage, this.width / 2, this.height / 2 - 50, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, this.errorDetail, this.width / 2, this.height / 2 - 10, 0xFFFFFF);
        super.drawScreen(i2, j2, f2);
    }
}

