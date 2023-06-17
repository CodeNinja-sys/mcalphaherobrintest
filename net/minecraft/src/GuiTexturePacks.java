/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.File;
import java.util.List;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSmallButton;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TexturePackBase;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiTexturePacks
extends GuiScreen {
    protected GuiScreen field_6461_a;
    private int field_6460_h = 0;
    private int field_6459_i = 32;
    private int field_6458_j = this.height - 55 + 4;
    private int field_6457_l = 0;
    private int field_6456_m = this.width;
    private int field_6455_n = -2;
    private int field_6454_o = -1;
    private String field_6453_p = "";

    public GuiTexturePacks(GuiScreen guiscreen) {
        this.field_6461_a = guiscreen;
    }

    @Override
    public void initGui() {
        this.controlList.add(new GuiSmallButton(5, this.width / 2 - 154, this.height - 48, "Open texture pack folder"));
        this.controlList.add(new GuiSmallButton(6, this.width / 2 + 4, this.height - 48, "Done"));
        this.mc.texturePackList.func_6532_a();
        this.field_6453_p = new File(this.mc.field_6297_D, "texturepacks").getAbsolutePath();
        this.field_6459_i = 32;
        this.field_6458_j = this.height - 58 + 4;
        this.field_6457_l = 0;
        this.field_6456_m = this.width;
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
        if (!guibutton.enabled) {
            return;
        }
        if (guibutton.id == 5) {
            Sys.openURL("file://" + this.field_6453_p);
        }
        if (guibutton.id == 6) {
            this.mc.renderEngine.refreshTextures();
            this.mc.displayGuiScreen(this.field_6461_a);
        }
    }

    @Override
    protected void mouseClicked(int i2, int j2, int k2) {
        super.mouseClicked(i2, j2, k2);
    }

    @Override
    protected void mouseMovedOrUp(int i2, int j2, int k2) {
        super.mouseMovedOrUp(i2, j2, k2);
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawDefaultBackground();
        if (this.field_6454_o <= 0) {
            this.mc.texturePackList.func_6532_a();
            this.field_6454_o += 20;
        }
        List list = this.mc.texturePackList.availableTexturePacks();
        if (Mouse.isButtonDown(0)) {
            if (this.field_6455_n == -1) {
                if (j2 >= this.field_6459_i && j2 <= this.field_6458_j) {
                    int k2 = this.width / 2 - 110;
                    int i1 = this.width / 2 + 110;
                    int j1 = (j2 - this.field_6459_i + this.field_6460_h - 2) / 36;
                    if (i2 >= k2 && i2 <= i1 && j1 >= 0 && j1 < list.size() && this.mc.texturePackList.setTexturePack((TexturePackBase)list.get(j1))) {
                        this.mc.renderEngine.refreshTextures();
                    }
                    this.field_6455_n = j2;
                } else {
                    this.field_6455_n = -2;
                }
            } else if (this.field_6455_n >= 0) {
                this.field_6460_h -= j2 - this.field_6455_n;
                this.field_6455_n = j2;
            }
        } else {
            if (this.field_6455_n < 0 || this.field_6455_n != j2) {
                // empty if block
            }
            this.field_6455_n = -1;
        }
        int l2 = list.size() * 36 - (this.field_6458_j - this.field_6459_i - 4);
        if (l2 < 0) {
            l2 /= 2;
        }
        if (this.field_6460_h < 0) {
            this.field_6460_h = 0;
        }
        if (this.field_6460_h > l2) {
            this.field_6460_h = l2;
        }
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        Tessellator tessellator = Tessellator.instance;
        GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/gui/background.png"));
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f1 = 32.0f;
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(0x202020);
        tessellator.addVertexWithUV(this.field_6457_l, this.field_6458_j, 0.0, (float)this.field_6457_l / f1, (float)(this.field_6458_j + this.field_6460_h) / f1);
        tessellator.addVertexWithUV(this.field_6456_m, this.field_6458_j, 0.0, (float)this.field_6456_m / f1, (float)(this.field_6458_j + this.field_6460_h) / f1);
        tessellator.addVertexWithUV(this.field_6456_m, this.field_6459_i, 0.0, (float)this.field_6456_m / f1, (float)(this.field_6459_i + this.field_6460_h) / f1);
        tessellator.addVertexWithUV(this.field_6457_l, this.field_6459_i, 0.0, (float)this.field_6457_l / f1, (float)(this.field_6459_i + this.field_6460_h) / f1);
        tessellator.draw();
        for (int k1 = 0; k1 < list.size(); ++k1) {
            TexturePackBase texturepackbase = (TexturePackBase)list.get(k1);
            int l1 = this.width / 2 - 92 - 16;
            int i22 = 36 + k1 * 36 - this.field_6460_h;
            int byte1 = 32;
            int byte2 = 32;
            if (texturepackbase == this.mc.texturePackList.selectedTexturePack) {
                int j22 = this.width / 2 - 110;
                int k2 = this.width / 2 + 110;
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glDisable(3553);
                tessellator.startDrawingQuads();
                tessellator.setColorOpaque_I(0x808080);
                tessellator.addVertexWithUV(j22, i22 + byte1 + 2, 0.0, 0.0, 1.0);
                tessellator.addVertexWithUV(k2, i22 + byte1 + 2, 0.0, 1.0, 1.0);
                tessellator.addVertexWithUV(k2, i22 - 2, 0.0, 1.0, 0.0);
                tessellator.addVertexWithUV(j22, i22 - 2, 0.0, 0.0, 0.0);
                tessellator.setColorOpaque_I(0);
                tessellator.addVertexWithUV(j22 + 1, i22 + byte1 + 1, 0.0, 0.0, 1.0);
                tessellator.addVertexWithUV(k2 - 1, i22 + byte1 + 1, 0.0, 1.0, 1.0);
                tessellator.addVertexWithUV(k2 - 1, i22 - 1, 0.0, 1.0, 0.0);
                tessellator.addVertexWithUV(j22 + 1, i22 - 1, 0.0, 0.0, 0.0);
                tessellator.draw();
                GL11.glEnable(3553);
            }
            texturepackbase.func_6483_c(this.mc);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            tessellator.startDrawingQuads();
            tessellator.setColorOpaque_I(0xFFFFFF);
            tessellator.addVertexWithUV(l1, i22 + byte1, 0.0, 0.0, 1.0);
            tessellator.addVertexWithUV(l1 + byte2, i22 + byte1, 0.0, 1.0, 1.0);
            tessellator.addVertexWithUV(l1 + byte2, i22, 0.0, 1.0, 0.0);
            tessellator.addVertexWithUV(l1, i22, 0.0, 0.0, 0.0);
            tessellator.draw();
            this.drawString(this.fontRenderer, texturepackbase.texturePackFileName, l1 + byte2 + 2, i22 + 1, 0xFFFFFF);
            this.drawString(this.fontRenderer, texturepackbase.firstDescriptionLine, l1 + byte2 + 2, i22 + 12, 0x808080);
            this.drawString(this.fontRenderer, texturepackbase.secondDescriptionLine, l1 + byte2 + 2, i22 + 12 + 10, 0x808080);
        }
        int byte0 = 4;
        this.func_6452_a(0, this.field_6459_i, 255, 255);
        this.func_6452_a(this.field_6458_j, this.height, 255, 255);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glShadeModel(7425);
        GL11.glDisable(3553);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(0, 0);
        tessellator.addVertexWithUV(this.field_6457_l, this.field_6459_i + byte0, 0.0, 0.0, 1.0);
        tessellator.addVertexWithUV(this.field_6456_m, this.field_6459_i + byte0, 0.0, 1.0, 1.0);
        tessellator.setColorRGBA_I(0, 255);
        tessellator.addVertexWithUV(this.field_6456_m, this.field_6459_i, 0.0, 1.0, 0.0);
        tessellator.addVertexWithUV(this.field_6457_l, this.field_6459_i, 0.0, 0.0, 0.0);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(0, 255);
        tessellator.addVertexWithUV(this.field_6457_l, this.field_6458_j, 0.0, 0.0, 1.0);
        tessellator.addVertexWithUV(this.field_6456_m, this.field_6458_j, 0.0, 1.0, 1.0);
        tessellator.setColorRGBA_I(0, 0);
        tessellator.addVertexWithUV(this.field_6456_m, this.field_6458_j - byte0, 0.0, 1.0, 0.0);
        tessellator.addVertexWithUV(this.field_6457_l, this.field_6458_j - byte0, 0.0, 0.0, 0.0);
        tessellator.draw();
        GL11.glEnable(3553);
        GL11.glShadeModel(7424);
        GL11.glEnable(3008);
        GL11.glDisable(3042);
        this.drawCenteredString(this.fontRenderer, "Select Texture Pack", this.width / 2, 16, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "(Place texture pack files here)", this.width / 2 - 77, this.height - 26, 0x808080);
        super.drawScreen(i2, j2, f2);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        --this.field_6454_o;
    }

    public void func_6452_a(int i2, int j2, int k2, int l2) {
        Tessellator tessellator = Tessellator.instance;
        GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/gui/background.png"));
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f2 = 32.0f;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(0x404040, l2);
        tessellator.addVertexWithUV(0.0, j2, 0.0, 0.0, (float)j2 / f2);
        tessellator.addVertexWithUV(this.width, j2, 0.0, (float)this.width / f2, (float)j2 / f2);
        tessellator.setColorRGBA_I(0x404040, k2);
        tessellator.addVertexWithUV(this.width, i2, 0.0, (float)this.width / f2, (float)i2 / f2);
        tessellator.addVertexWithUV(0.0, i2, 0.0, 0.0, (float)i2 / f2);
        tessellator.draw();
    }
}

