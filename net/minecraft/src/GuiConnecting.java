/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.ThreadConnectToServer;

public class GuiConnecting
extends GuiScreen {
    private NetClientHandler clientHandler;
    private boolean cancelled = false;

    public GuiConnecting(Minecraft minecraft, String s2, int i2) {
        minecraft.func_6261_a(null);
        new ThreadConnectToServer(this, minecraft, s2, i2).start();
    }

    @Override
    public void updateScreen() {
        if (this.clientHandler != null) {
            this.clientHandler.processReadPackets();
        }
    }

    @Override
    protected void keyTyped(char c2, int i2) {
    }

    @Override
    public void initGui() {
        this.controlList.clear();
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, "Cancel"));
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 0) {
            this.cancelled = true;
            if (this.clientHandler != null) {
                this.clientHandler.disconnect();
            }
            this.mc.displayGuiScreen(new GuiMainMenu());
        }
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawDefaultBackground();
        if (this.clientHandler == null) {
            this.drawCenteredString(this.fontRenderer, "Connecting to the server...", this.width / 2, this.height / 2 - 50, 0xFFFFFF);
            this.drawCenteredString(this.fontRenderer, "", this.width / 2, this.height / 2 - 10, 0xFFFFFF);
        } else {
            this.drawCenteredString(this.fontRenderer, "Logging in...", this.width / 2, this.height / 2 - 50, 0xFFFFFF);
            this.drawCenteredString(this.fontRenderer, this.clientHandler.field_1209_a, this.width / 2, this.height / 2 - 10, 0xFFFFFF);
        }
        super.drawScreen(i2, j2, f2);
    }

    static NetClientHandler setNetClientHandler(GuiConnecting guiconnecting, NetClientHandler netclienthandler) {
        guiconnecting.clientHandler = netclienthandler;
        return guiconnecting.clientHandler;
    }

    static boolean isCancelled(GuiConnecting guiconnecting) {
        return guiconnecting.cancelled;
    }

    static NetClientHandler getNetClientHandler(GuiConnecting guiconnecting) {
        return guiconnecting.clientHandler;
    }
}

