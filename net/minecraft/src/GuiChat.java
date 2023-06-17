/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GuiScreen;
import org.lwjgl.input.Keyboard;

public class GuiChat
extends GuiScreen {
    private String message = "";
    private int updateCounter = 0;

    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void updateScreen() {
        ++this.updateCounter;
    }

    @Override
    protected void keyTyped(char c2, int i2) {
        if (i2 == 1) {
            this.mc.displayGuiScreen(null);
            return;
        }
        if (i2 == 28) {
            String s2 = this.message.trim();
            if (s2.length() > 0) {
                this.mc.thePlayer.sendChatMessage(this.message.trim());
            }
            this.mc.displayGuiScreen(null);
            return;
        }
        if (i2 == 14 && this.message.length() > 0) {
            this.message = this.message.substring(0, this.message.length() - 1);
        }
        if (" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_'abcdefghijklmnopqrstuvwxyz{|}~\u2302\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb".indexOf(c2) >= 0 && this.message.length() < 100) {
            this.message = String.valueOf(this.message) + c2;
        }
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawRect(2, this.height - 14, this.width - 2, this.height - 2, Integer.MIN_VALUE);
        this.drawString(this.fontRenderer, "> " + this.message + (this.updateCounter / 6 % 2 != 0 ? "" : "_"), 4, this.height - 12, 0xE0E0E0);
    }

    @Override
    protected void mouseClicked(int i2, int j2, int k2) {
        if (k2 != 0 || this.mc.ingameGUI.field_933_a == null) {
            return;
        }
        if (this.message.length() > 0 && !this.message.endsWith(" ")) {
            this.message = String.valueOf(this.message) + " ";
        }
        this.message = String.valueOf(this.message) + this.mc.ingameGUI.field_933_a;
        int byte0 = 100;
        if (this.message.length() > byte0) {
            this.message = this.message.substring(0, byte0);
        }
    }
}

