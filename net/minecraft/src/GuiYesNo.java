/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSmallButton;

public class GuiYesNo
extends GuiScreen {
    private GuiScreen parentScreen;
    private String message1;
    private String message2;
    private int worldNumber;

    public GuiYesNo(GuiScreen guiscreen, String s2, String s1, int i2) {
        this.parentScreen = guiscreen;
        this.message1 = s2;
        this.message2 = s1;
        this.worldNumber = i2;
    }

    @Override
    public void initGui() {
        this.controlList.add(new GuiSmallButton(0, this.width / 2 - 155 + 0, this.height / 6 + 96, "Yes"));
        this.controlList.add(new GuiSmallButton(1, this.width / 2 - 155 + 160, this.height / 6 + 96, "No"));
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
        this.parentScreen.deleteWorld(guibutton.id == 0, this.worldNumber);
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.message1, this.width / 2, 70, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, this.message2, this.width / 2, 90, 0xFFFFFF);
        super.drawScreen(i2, j2, f2);
    }
}

