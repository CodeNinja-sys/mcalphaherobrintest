/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.File;
import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSelectWorld;
import net.minecraft.src.GuiYesNo;
import net.minecraft.src.World;

public class GuiDeleteWorld
extends GuiSelectWorld {
    public GuiDeleteWorld(GuiScreen guiscreen) {
        super(guiscreen);
        this.screenTitle = "Delete world";
    }

    @Override
    public void initGui2() {
        this.controlList.add(new GuiButton(6, this.width / 2 - 100, this.height / 6 + 168, "Cancel"));
    }

    @Override
    public void selectWorld(int i2) {
        String s2 = this.getWorldName(i2);
        if (s2 != null) {
            this.mc.displayGuiScreen(new GuiYesNo(this, "Are you sure you want to delete this world?", "'" + s2 + "' will be lost forever!", i2));
        }
    }

    @Override
    public void deleteWorld(boolean flag, int i2) {
        if (flag) {
            File file = Minecraft.getMinecraftDir();
            World.deleteWorld(file, this.getWorldName(i2));
        }
        this.mc.displayGuiScreen(this.parentScreen);
    }
}

