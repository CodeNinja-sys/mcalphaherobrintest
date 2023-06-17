/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.File;
import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiDeleteWorld;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.PlayerControllerSP;
import net.minecraft.src.World;

public class GuiSelectWorld
extends GuiScreen {
    protected GuiScreen parentScreen;
    protected String screenTitle = "Select world";
    private boolean selected = false;

    public GuiSelectWorld(GuiScreen guiscreen) {
        this.parentScreen = guiscreen;
    }

    @Override
    public void initGui() {
        File file = Minecraft.getMinecraftDir();
        for (int i2 = 0; i2 < 5; ++i2) {
            NBTTagCompound nbttagcompound = World.func_629_a(file, "World" + (i2 + 1));
            if (nbttagcompound == null) {
                this.controlList.add(new GuiButton(i2, this.width / 2 - 100, this.height / 6 + 24 * i2, "- empty -"));
                continue;
            }
            String s2 = "World " + (i2 + 1);
            long l2 = nbttagcompound.getLong("SizeOnDisk");
            s2 = s2 + " (" + (float)(l2 / 1024L * 100L / 1024L) / 100.0f + " MB)";
            this.controlList.add(new GuiButton(i2, this.width / 2 - 100, this.height / 6 + 24 * i2, s2));
        }
        this.initGui2();
    }

    protected String getWorldName(int i2) {
        File file = Minecraft.getMinecraftDir();
        return World.func_629_a(file, "World" + i2) == null ? null : "World" + i2;
    }

    public void initGui2() {
        this.controlList.add(new GuiButton(5, this.width / 2 - 100, this.height / 6 + 120 + 12, "Delete world..."));
        this.controlList.add(new GuiButton(6, this.width / 2 - 100, this.height / 6 + 168, "Cancel"));
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
        if (!guibutton.enabled) {
            return;
        }
        if (guibutton.id < 5) {
            this.selectWorld(guibutton.id + 1);
        } else if (guibutton.id == 5) {
            this.mc.displayGuiScreen(new GuiDeleteWorld(this));
        } else if (guibutton.id == 6) {
            this.mc.displayGuiScreen(this.parentScreen);
        }
    }

    public void selectWorld(int i2) {
        this.mc.displayGuiScreen(null);
        if (this.selected) {
            return;
        }
        this.selected = true;
        this.mc.field_6327_b = new PlayerControllerSP(this.mc);
        this.mc.func_6247_b("World" + i2);
        this.mc.displayGuiScreen(null);
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(i2, j2, f2);
    }
}

