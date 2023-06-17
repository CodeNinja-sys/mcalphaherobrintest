/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.MinecraftError;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class LoadingScreenRenderer
implements IProgressUpdate {
    private String field_1004_a = "";
    private Minecraft mc;
    private String field_1007_c = "";
    private long field_1006_d = System.currentTimeMillis();
    private boolean field_1005_e = false;

    public LoadingScreenRenderer(Minecraft minecraft) {
        this.mc = minecraft;
    }

    public void func_596_a(String s2) {
        this.field_1005_e = false;
        this.func_597_c(s2);
    }

    @Override
    public void func_594_b(String s2) {
        this.field_1005_e = true;
        this.func_597_c(this.field_1007_c);
    }

    public void func_597_c(String s2) {
        if (!this.mc.running) {
            if (this.field_1005_e) {
                return;
            }
            throw new MinecraftError();
        }
        this.field_1007_c = s2;
        ScaledResolution scaledresolution = new ScaledResolution(this.mc.displayWidth, this.mc.displayHeight);
        int i2 = scaledresolution.getScaledWidth();
        int j2 = scaledresolution.getScaledHeight();
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, i2, j2, 0.0, 100.0, 300.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
    }

    @Override
    public void displayLoadingString(String s2) {
        if (!this.mc.running) {
            if (this.field_1005_e) {
                return;
            }
            throw new MinecraftError();
        }
        this.field_1006_d = 0L;
        this.field_1004_a = s2;
        this.setLoadingProgress(-1);
        this.field_1006_d = 0L;
    }

    @Override
    public void setLoadingProgress(int i2) {
        if (!this.mc.running) {
            if (this.field_1005_e) {
                return;
            }
            throw new MinecraftError();
        }
        long l2 = System.currentTimeMillis();
        if (l2 - this.field_1006_d < 20L) {
            return;
        }
        this.field_1006_d = l2;
        ScaledResolution scaledresolution = new ScaledResolution(this.mc.displayWidth, this.mc.displayHeight);
        int j2 = scaledresolution.getScaledWidth();
        int k2 = scaledresolution.getScaledHeight();
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, j2, k2, 0.0, 100.0, 300.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -200.0f);
        GL11.glClear(16640);
        Tessellator tessellator = Tessellator.instance;
        int i1 = this.mc.renderEngine.getTexture("/gui/background.png");
        GL11.glBindTexture(3553, i1);
        float f2 = 32.0f;
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(0x404040);
        tessellator.addVertexWithUV(0.0, k2, 0.0, 0.0, (float)k2 / f2);
        tessellator.addVertexWithUV(j2, k2, 0.0, (float)j2 / f2, (float)k2 / f2);
        tessellator.addVertexWithUV(j2, 0.0, 0.0, (float)j2 / f2, 0.0);
        tessellator.addVertexWithUV(0.0, 0.0, 0.0, 0.0, 0.0);
        tessellator.draw();
        if (i2 >= 0) {
            int byte0 = 100;
            int byte1 = 2;
            int j1 = j2 / 2 - byte0 / 2;
            int k1 = k2 / 2 + 16;
            GL11.glDisable(3553);
            tessellator.startDrawingQuads();
            tessellator.setColorOpaque_I(0x808080);
            tessellator.addVertex(j1, k1, 0.0);
            tessellator.addVertex(j1, k1 + byte1, 0.0);
            tessellator.addVertex(j1 + byte0, k1 + byte1, 0.0);
            tessellator.addVertex(j1 + byte0, k1, 0.0);
            tessellator.setColorOpaque_I(0x80FF80);
            tessellator.addVertex(j1, k1, 0.0);
            tessellator.addVertex(j1, k1 + byte1, 0.0);
            tessellator.addVertex(j1 + i2, k1 + byte1, 0.0);
            tessellator.addVertex(j1 + i2, k1, 0.0);
            tessellator.draw();
            GL11.glEnable(3553);
        }
        this.mc.fontRenderer.drawStringWithShadow(this.field_1007_c, (j2 - this.mc.fontRenderer.getStringWidth(this.field_1007_c)) / 2, k2 / 2 - 4 - 16, 0xFFFFFF);
        this.mc.fontRenderer.drawStringWithShadow(this.field_1004_a, (j2 - this.mc.fontRenderer.getStringWidth(this.field_1004_a)) / 2, k2 / 2 - 4 + 8, 0xFFFFFF);
        Display.update();
        try {
            Thread.yield();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

