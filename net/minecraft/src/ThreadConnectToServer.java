/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.net.ConnectException;
import java.net.UnknownHostException;
import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiConnectFailed;
import net.minecraft.src.GuiConnecting;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet2Handshake;

class ThreadConnectToServer
extends Thread {
    final Minecraft mc;
    final String hostName;
    final int port;
    final GuiConnecting connectingGui;

    ThreadConnectToServer(GuiConnecting guiconnecting, Minecraft minecraft, String s2, int i2) {
        this.connectingGui = guiconnecting;
        this.mc = minecraft;
        this.hostName = s2;
        this.port = i2;
    }

    @Override
    public void run() {
        try {
            GuiConnecting.setNetClientHandler(this.connectingGui, new NetClientHandler(this.mc, this.hostName, this.port));
            if (GuiConnecting.isCancelled(this.connectingGui)) {
                return;
            }
            GuiConnecting.getNetClientHandler(this.connectingGui).addToSendQueue(new Packet2Handshake(this.mc.field_6320_i.inventory));
        }
        catch (UnknownHostException unknownhostexception) {
            if (GuiConnecting.isCancelled(this.connectingGui)) {
                return;
            }
            this.mc.displayGuiScreen(new GuiConnectFailed("Failed to connect to the server", "Unknown host '" + this.hostName + "'"));
        }
        catch (ConnectException connectexception) {
            if (GuiConnecting.isCancelled(this.connectingGui)) {
                return;
            }
            this.mc.displayGuiScreen(new GuiConnectFailed("Failed to connect to the server", connectexception.getMessage()));
        }
        catch (Exception exception) {
            if (GuiConnecting.isCancelled(this.connectingGui)) {
                return;
            }
            exception.printStackTrace();
            this.mc.displayGuiScreen(new GuiConnectFailed("Failed to connect to the server", exception.toString()));
        }
    }
}

