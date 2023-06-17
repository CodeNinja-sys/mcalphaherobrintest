/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiOptions;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.MathHelper;

public class GuiIngameMenu
extends GuiScreen {
    private int updateCounter2 = 0;
    private int updateCounter = 0;

    @Override
    public void initGui() {
        this.updateCounter2 = 0;
        this.controlList.clear();
        this.controlList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 48, "Save and quit to title"));
        if (this.mc.isMultiplayerWorld()) {
            ((GuiButton)this.controlList.get((int)0)).displayString = "Disconnect";
        }
        this.controlList.add(new GuiButton(4, this.width / 2 - 100, this.height / 4 + 24, "Back to game"));
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96, "Options..."));
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 0) {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }
        if (guibutton.id == 1) {
            if (this.mc.isMultiplayerWorld()) {
                this.mc.theWorld.sendQuittingDisconnectingPacket();
            }
            this.mc.func_6261_a(null);
            this.mc.displayGuiScreen(new GuiMainMenu());
        }
        if (guibutton.id == 4) {
            this.mc.displayGuiScreen(null);
            this.mc.func_6259_e();
        }
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this.updateCounter;
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        boolean flag;
        this.drawDefaultBackground();
        boolean bl2 = flag = !this.mc.theWorld.func_650_a(this.updateCounter2++);
        if (flag || this.updateCounter < 20) {
            float f1 = ((float)(this.updateCounter % 10) + f2) / 10.0f;
            f1 = MathHelper.sin(f1 * 3.141593f * 2.0f) * 0.2f + 0.8f;
            int k2 = (int)(255.0f * f1);
            this.drawString(this.fontRenderer, "Saving level..", 8, this.height - 16, k2 << 16 | k2 << 8 | k2);
        }
        this.drawCenteredString(this.fontRenderer, "Game menu", this.width / 2, 40, 0xFFFFFF);
        super.drawScreen(i2, j2, f2);
    }
}

