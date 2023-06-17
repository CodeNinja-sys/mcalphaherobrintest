/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.TileEntityRenderer;
import net.minecraft.src.TileEntitySign;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiEditSign
extends GuiScreen {
    protected String screenTitle = "Edit sign message:";
    private TileEntitySign entitySign;
    private int updateCounter;
    private int editLine = 0;

    public GuiEditSign(TileEntitySign tileentitysign) {
        this.entitySign = tileentitysign;
    }

    @Override
    public void initGui() {
        this.controlList.clear();
        Keyboard.enableRepeatEvents(true);
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120, "Done"));
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
    protected void actionPerformed(GuiButton guibutton) {
        if (!guibutton.enabled) {
            return;
        }
        if (guibutton.id == 0) {
            this.entitySign.onInventoryChanged();
            this.mc.displayGuiScreen(null);
        }
    }

    @Override
    protected void keyTyped(char c2, int i2) {
        if (i2 == 200) {
            this.editLine = this.editLine - 1 & 3;
        }
        if (i2 == 208 || i2 == 28) {
            this.editLine = this.editLine + 1 & 3;
        }
        if (i2 == 14 && this.entitySign.signText[this.editLine].length() > 0) {
            this.entitySign.signText[this.editLine] = this.entitySign.signText[this.editLine].substring(0, this.entitySign.signText[this.editLine].length() - 1);
        }
        if (" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_'abcdefghijklmnopqrstuvwxyz{|}~\u2302\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb".indexOf(c2) >= 0 && this.entitySign.signText[this.editLine].length() < 15) {
            int n2 = this.editLine;
            this.entitySign.signText[n2] = String.valueOf(this.entitySign.signText[n2]) + c2;
        }
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 40, 0xFFFFFF);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.width / 2, this.height / 2, 50.0f);
        float f1 = 93.75f;
        GL11.glScalef(-f1, -f1, -f1);
        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        Block block = this.entitySign.getBlockType();
        if (block == Block.signPost) {
            float f22 = (float)(this.entitySign.getBlockMetadata() * 360) / 16.0f;
            GL11.glRotatef(f22, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(0.0f, 0.3125f, 0.0f);
        } else {
            int k2 = this.entitySign.getBlockMetadata();
            float f3 = 0.0f;
            if (k2 == 2) {
                f3 = 180.0f;
            }
            if (k2 == 4) {
                f3 = 90.0f;
            }
            if (k2 == 5) {
                f3 = -90.0f;
            }
            GL11.glRotatef(f3, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(0.0f, 0.3125f, 0.0f);
        }
        if (this.updateCounter / 6 % 2 == 0) {
            this.entitySign.lineBeingEdited = this.editLine;
        }
        TileEntityRenderer.instance.renderTileEntityAt(this.entitySign, -0.5, -0.75, -0.5, 0.0f);
        this.entitySign.lineBeingEdited = -1;
        GL11.glPopMatrix();
        super.drawScreen(i2, j2, f2);
    }
}

