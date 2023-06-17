/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Gui;
import org.lwjgl.opengl.GL11;

public class GuiButton
extends Gui {
    protected int width = 200;
    protected int height = 20;
    public int xPosition;
    public int yPosition;
    public String displayString;
    public int id;
    public boolean enabled = true;
    public boolean enabled2 = true;

    public GuiButton(int i2, int j2, int k2, String s2) {
        this(i2, j2, k2, 200, 20, s2);
    }

    protected GuiButton(int i2, int j2, int k2, int l2, int i1, String s2) {
        this.id = i2;
        this.xPosition = j2;
        this.yPosition = k2;
        this.width = l2;
        this.height = i1;
        this.displayString = s2;
    }

    protected int getHoverState(boolean flag) {
        int byte0 = 1;
        if (!this.enabled) {
            byte0 = 0;
        } else if (flag) {
            byte0 = 2;
        }
        return byte0;
    }

    public void drawButton(Minecraft minecraft, int i2, int j2) {
        if (!this.enabled2) {
            return;
        }
        FontRenderer fontrenderer = minecraft.fontRenderer;
        GL11.glBindTexture(3553, minecraft.renderEngine.getTexture("/gui/gui.png"));
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        boolean flag = i2 >= this.xPosition && j2 >= this.yPosition && i2 < this.xPosition + this.width && j2 < this.yPosition + this.height;
        int k2 = this.getHoverState(flag);
        this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + k2 * 20, this.width / 2, this.height);
        this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + k2 * 20, this.width / 2, this.height);
        this.mouseDragged(minecraft, i2, j2);
        if (!this.enabled) {
            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, -6250336);
        } else if (flag) {
            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, 0xFFFFA0);
        } else {
            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, 0xE0E0E0);
        }
    }

    protected void mouseDragged(Minecraft minecraft, int i2, int j2) {
    }

    public void mouseReleased(int i2, int j2) {
    }

    public boolean mousePressed(Minecraft minecraft, int i2, int j2) {
        return this.enabled && i2 >= this.xPosition && j2 >= this.yPosition && i2 < this.xPosition + this.width && j2 < this.yPosition + this.height;
    }
}

