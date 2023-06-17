/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiButton;
import org.lwjgl.opengl.GL11;

public class GuiSlider
extends GuiButton {
    public float sliderValue = 1.0f;
    public boolean dragging = false;
    private int idFloat = 0;

    public GuiSlider(int i2, int j2, int k2, int l2, String s2, float f2) {
        super(i2, j2, k2, 150, 20, s2);
        this.idFloat = l2;
        this.sliderValue = f2;
    }

    @Override
    protected int getHoverState(boolean flag) {
        return 0;
    }

    @Override
    protected void mouseDragged(Minecraft minecraft, int i2, int j2) {
        if (!this.enabled2) {
            return;
        }
        if (this.dragging) {
            this.sliderValue = (float)(i2 - (this.xPosition + 4)) / (float)(this.width - 8);
            if (this.sliderValue < 0.0f) {
                this.sliderValue = 0.0f;
            }
            if (this.sliderValue > 1.0f) {
                this.sliderValue = 1.0f;
            }
            minecraft.gameSettings.setOptionFloatValue(this.idFloat, this.sliderValue);
            this.displayString = minecraft.gameSettings.getOptionDisplayString(this.idFloat);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8)), this.yPosition, 0, 66, 4, 20);
        this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
    }

    @Override
    public boolean mousePressed(Minecraft minecraft, int i2, int j2) {
        if (super.mousePressed(minecraft, i2, j2)) {
            this.sliderValue = (float)(i2 - (this.xPosition + 4)) / (float)(this.width - 8);
            if (this.sliderValue < 0.0f) {
                this.sliderValue = 0.0f;
            }
            if (this.sliderValue > 1.0f) {
                this.sliderValue = 1.0f;
            }
            minecraft.gameSettings.setOptionFloatValue(this.idFloat, this.sliderValue);
            this.displayString = minecraft.gameSettings.getOptionDisplayString(this.idFloat);
            this.dragging = true;
            return true;
        }
        return false;
    }

    @Override
    public void mouseReleased(int i2, int j2) {
        this.dragging = false;
    }
}

