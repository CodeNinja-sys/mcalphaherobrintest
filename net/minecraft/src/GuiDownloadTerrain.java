/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet0KeepAlive;

public class GuiDownloadTerrain
extends GuiScreen {
    private NetClientHandler netHandler;
    private int updateCounter = 0;

    public GuiDownloadTerrain(NetClientHandler netclienthandler) {
        this.netHandler = netclienthandler;
    }

    @Override
    protected void keyTyped(char c2, int i2) {
    }

    @Override
    public void initGui() {
        this.controlList.clear();
    }

    @Override
    public void updateScreen() {
        ++this.updateCounter;
        if (this.updateCounter % 20 == 0) {
            this.netHandler.addToSendQueue(new Packet0KeepAlive());
        }
        if (this.netHandler != null) {
            this.netHandler.processReadPackets();
        }
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawBackground(0);
        this.drawCenteredString(this.fontRenderer, "Downloading terrain", this.width / 2, this.height / 2 - 50, 0xFFFFFF);
        super.drawScreen(i2, j2, f2);
    }
}

