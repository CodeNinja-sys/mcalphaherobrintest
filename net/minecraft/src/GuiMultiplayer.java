/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiConnecting;
import net.minecraft.src.GuiScreen;

public class GuiMultiplayer
extends GuiScreen {
    private GuiScreen updateCounter;
    private int parentScreen = 0;
    private String serverAddress = "";

    public GuiMultiplayer(GuiScreen guiscreen) {
        this.updateCounter = guiscreen;
    }

    @Override
    public void updateScreen() {
        ++this.parentScreen;
    }

    @Override
    public void initGui() {
        this.controlList.clear();
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, "Connect"));
        this.controlList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, "Cancel"));
        this.serverAddress = this.mc.gameSettings.field_12259_z.replaceAll("_", ":");
        ((GuiButton)this.controlList.get((int)0)).enabled = this.serverAddress.length() > 0;
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
        if (!guibutton.enabled) {
            return;
        }
        if (guibutton.id == 1) {
            this.mc.displayGuiScreen(this.updateCounter);
        } else if (guibutton.id == 0) {
            this.mc.gameSettings.field_12259_z = this.serverAddress.replaceAll(":", "_");
            this.mc.gameSettings.saveOptions();
            String[] as2 = this.serverAddress.split(":");
            this.mc.displayGuiScreen(new GuiConnecting(this.mc, as2[0], as2.length <= 1 ? 25565 : this.func_4067_a(as2[1], 25565)));
        }
    }

    private int func_4067_a(String s2, int i2) {
        try {
            return Integer.parseInt(s2.trim());
        }
        catch (Exception exception) {
            return i2;
        }
    }

    @Override
    protected void keyTyped(char c2, int i2) {
        if (c2 == '\u0016') {
            int j2;
            String s2 = GuiScreen.getClipboardString();
            if (s2 == null) {
                s2 = "";
            }
            if ((j2 = 32 - this.serverAddress.length()) > s2.length()) {
                j2 = s2.length();
            }
            if (j2 > 0) {
                this.serverAddress = String.valueOf(this.serverAddress) + s2.substring(0, j2);
            }
        }
        if (c2 == '\r') {
            this.actionPerformed((GuiButton)this.controlList.get(0));
        }
        if (i2 == 14 && this.serverAddress.length() > 0) {
            this.serverAddress = this.serverAddress.substring(0, this.serverAddress.length() - 1);
        }
        if (" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_'abcdefghijklmnopqrstuvwxyz{|}~\u2302\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb".indexOf(c2) >= 0 && this.serverAddress.length() < 32) {
            this.serverAddress = String.valueOf(this.serverAddress) + c2;
        }
        ((GuiButton)this.controlList.get((int)0)).enabled = this.serverAddress.length() > 0;
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "Play Multiplayer", this.width / 2, this.height / 4 - 60 + 20, 0xFFFFFF);
        this.drawString(this.fontRenderer, "Minecraft Multiplayer is currently not finished, but there", this.width / 2 - 140, this.height / 4 - 60 + 60 + 0, 0xA0A0A0);
        this.drawString(this.fontRenderer, "is some buggy early testing going on.", this.width / 2 - 140, this.height / 4 - 60 + 60 + 9, 0xA0A0A0);
        this.drawString(this.fontRenderer, "Enter the IP of a server to connect to it:", this.width / 2 - 140, this.height / 4 - 60 + 60 + 36, 0xA0A0A0);
        int k2 = this.width / 2 - 100;
        int l2 = this.height / 4 - 10 + 50 + 18;
        int c2 = 200;
        int byte0 = 20;
        this.drawRect(k2 - 1, l2 - 1, k2 + c2 + 1, l2 + byte0 + 1, -6250336);
        this.drawRect(k2, l2, k2 + c2, l2 + byte0, -16777216);
        this.drawString(this.fontRenderer, this.serverAddress + (this.parentScreen / 6 % 2 != 0 ? "" : "_"), k2 + 4, l2 + (byte0 - 8) / 2, 0xE0E0E0);
        super.drawScreen(i2, j2, f2);
    }
}

