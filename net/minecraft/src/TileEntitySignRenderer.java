/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.SignModel;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

public class TileEntitySignRenderer
extends TileEntitySpecialRenderer {
    private SignModel signModel = new SignModel();

    public void renderTileEntitySignAt(TileEntitySign tileentitysign, double d2, double d1, double d22, float f2) {
        Block block = tileentitysign.getBlockType();
        GL11.glPushMatrix();
        float f1 = 0.6666667f;
        if (block == Block.signPost) {
            GL11.glTranslatef((float)d2 + 0.5f, (float)d1 + 0.75f * f1, (float)d22 + 0.5f);
            float f22 = (float)(tileentitysign.getBlockMetadata() * 360) / 16.0f;
            GL11.glRotatef(-f22, 0.0f, 1.0f, 0.0f);
            this.signModel.field_1345_b.field_1403_h = true;
        } else {
            int i2 = tileentitysign.getBlockMetadata();
            float f3 = 0.0f;
            if (i2 == 2) {
                f3 = 180.0f;
            }
            if (i2 == 4) {
                f3 = 90.0f;
            }
            if (i2 == 5) {
                f3 = -90.0f;
            }
            GL11.glTranslatef((float)d2 + 0.5f, (float)d1 + 0.75f * f1, (float)d22 + 0.5f);
            GL11.glRotatef(-f3, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(0.0f, -0.3125f, -0.4375f);
            this.signModel.field_1345_b.field_1403_h = false;
        }
        this.bindTextureByName("/item/sign.png");
        GL11.glPushMatrix();
        GL11.glScalef(f1, -f1, -f1);
        this.signModel.func_887_a();
        GL11.glPopMatrix();
        FontRenderer fontrenderer = this.getFontRenderer();
        float f4 = 0.01666667f * f1;
        GL11.glTranslatef(0.0f, 0.5f * f1, 0.07f * f1);
        GL11.glScalef(f4, -f4, f4);
        GL11.glNormal3f(0.0f, 0.0f, -1.0f * f4);
        GL11.glDepthMask(false);
        int j2 = 0;
        for (int k2 = 0; k2 < tileentitysign.signText.length; ++k2) {
            String s2 = tileentitysign.signText[k2];
            if (k2 == tileentitysign.lineBeingEdited) {
                s2 = "> " + s2 + " <";
                fontrenderer.drawString(s2, -fontrenderer.getStringWidth(s2) / 2, k2 * 10 - tileentitysign.signText.length * 5, j2);
                continue;
            }
            fontrenderer.drawString(s2, -fontrenderer.getStringWidth(s2) / 2, k2 * 10 - tileentitysign.signText.length * 5, j2);
        }
        GL11.glDepthMask(true);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double d2, double d1, double d22, float f2) {
        this.renderTileEntitySignAt((TileEntitySign)tileentity, d2, d1, d22, f2);
    }
}

