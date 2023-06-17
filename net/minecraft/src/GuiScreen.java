/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Gui;
import net.minecraft.src.GuiButton;
import net.minecraft.src.Tessellator;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiScreen
extends Gui {
    protected Minecraft mc;
    public int width;
    public int height;
    protected List controlList = new ArrayList();
    public boolean field_948_f = false;
    protected FontRenderer fontRenderer;
    private GuiButton selectedButton = null;

    public void drawScreen(int i2, int j2, float f2) {
        for (int k2 = 0; k2 < this.controlList.size(); ++k2) {
            GuiButton guibutton = (GuiButton)this.controlList.get(k2);
            guibutton.drawButton(this.mc, i2, j2);
        }
    }

    protected void keyTyped(char c2, int i2) {
        if (i2 == 1) {
            this.mc.displayGuiScreen(null);
            this.mc.func_6259_e();
        }
    }

    public static String getClipboardString() {
        try {
            Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
            if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String s2 = (String)transferable.getTransferData(DataFlavor.stringFlavor);
                return s2;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return null;
    }

    protected void mouseClicked(int i2, int j2, int k2) {
        if (k2 == 0) {
            for (int l2 = 0; l2 < this.controlList.size(); ++l2) {
                GuiButton guibutton = (GuiButton)this.controlList.get(l2);
                if (!guibutton.mousePressed(this.mc, i2, j2)) continue;
                this.selectedButton = guibutton;
                this.mc.sndManager.func_337_a("random.click", 1.0f, 1.0f);
                this.actionPerformed(guibutton);
            }
        }
    }

    protected void mouseMovedOrUp(int i2, int j2, int k2) {
        if (this.selectedButton != null && k2 == 0) {
            this.selectedButton.mouseReleased(i2, j2);
            this.selectedButton = null;
        }
    }

    protected void actionPerformed(GuiButton guibutton) {
    }

    public void setWorldAndResolution(Minecraft minecraft, int i2, int j2) {
        this.mc = minecraft;
        this.fontRenderer = minecraft.fontRenderer;
        this.width = i2;
        this.height = j2;
        this.controlList.clear();
        this.initGui();
    }

    public void initGui() {
    }

    public void handleInput() {
        while (Mouse.next()) {
            this.handleMouseInput();
        }
        while (Keyboard.next()) {
            this.handleKeyboardInput();
        }
    }

    public void handleMouseInput() {
        if (Mouse.getEventButtonState()) {
            int i2 = Mouse.getEventX() * this.width / this.mc.displayWidth;
            int k2 = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
            this.mouseClicked(i2, k2, Mouse.getEventButton());
        } else {
            int j2 = Mouse.getEventX() * this.width / this.mc.displayWidth;
            int l2 = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
            this.mouseMovedOrUp(j2, l2, Mouse.getEventButton());
        }
    }

    public void handleKeyboardInput() {
        if (Keyboard.getEventKeyState()) {
            if (Keyboard.getEventKey() == 87) {
                this.mc.toggleFullscreen();
                return;
            }
            this.keyTyped(Keyboard.getEventCharacter(), Keyboard.getEventKey());
        }
    }

    public void updateScreen() {
    }

    public void onGuiClosed() {
    }

    public void drawDefaultBackground() {
        this.func_567_a(0);
    }

    public void func_567_a(int i2) {
        if (this.mc.theWorld != null) {
            this.drawGradientRect(0, 0, this.width, this.height, -1072689136, -804253680);
        } else {
            this.drawBackground(i2);
        }
    }

    public void drawBackground(int i2) {
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        Tessellator tessellator = Tessellator.instance;
        GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/gui/background.png"));
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f2 = 32.0f;
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(0x404040);
        tessellator.addVertexWithUV(0.0, this.height, 0.0, 0.0, (float)this.height / f2 + (float)i2);
        tessellator.addVertexWithUV(this.width, this.height, 0.0, (float)this.width / f2, (float)this.height / f2 + (float)i2);
        tessellator.addVertexWithUV(this.width, 0.0, 0.0, (float)this.width / f2, 0 + i2);
        tessellator.addVertexWithUV(0.0, 0.0, 0.0, 0.0, 0 + i2);
        tessellator.draw();
    }

    public boolean doesGuiPauseGame() {
        return true;
    }

    public void deleteWorld(boolean flag, int i2) {
    }
}

