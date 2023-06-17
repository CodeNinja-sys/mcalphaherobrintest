/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMultiplayer;
import net.minecraft.src.GuiOptions;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSelectWorld;
import net.minecraft.src.GuiTexturePacks;
import net.minecraft.src.LogoEffectRandomizer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class GuiMainMenu
extends GuiScreen {
    private static final Random rand = new Random();
    String[] minecraftLogo = new String[]{" *   * * *   * *** *** *** *** *** ***", " ** ** * **  * *   *   * * * * *    * ", " * * * * * * * **  *   **  *** **   * ", " *   * * *  ** *   *   * * * * *    * ", " *   * * *   * *** *** * * * * *    * "};
    private LogoEffectRandomizer[][] logoEffects;
    private float updateCounter = 0.0f;
    private String splashText = "Cast to white eyes";

    public GuiMainMenu() {
        try {
            String s1;
            ArrayList<String> arraylist = new ArrayList<String>();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(GuiMainMenu.class.getResourceAsStream("/title/splashes.txt")));
            String s2 = "";
            while ((s1 = bufferedreader.readLine()) != null) {
                if ((s1 = s1.trim()).length() <= 0) continue;
                arraylist.add(s1);
            }
            this.splashText = (String)arraylist.get(rand.nextInt(arraylist.size()));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void updateScreen() {
        this.updateCounter += 1.0f;
        if (this.logoEffects != null) {
            for (int i2 = 0; i2 < this.logoEffects.length; ++i2) {
                for (int j2 = 0; j2 < this.logoEffects[i2].length; ++j2) {
                    this.logoEffects[i2][j2].func_875_a();
                }
            }
        }
    }

    @Override
    protected void keyTyped(char c2, int i2) {
    }

    @Override
    public void initGui() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if (calendar.get(2) + 1 == 11 && calendar.get(5) == 9) {
            this.splashText = "...";
        } else if (calendar.get(2) + 1 == 6 && calendar.get(5) == 1) {
            this.splashText = "...";
        } else if (calendar.get(2) + 1 == 12 && calendar.get(5) == 24) {
            this.splashText = "Merry X-mas!";
        } else if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1) {
            this.splashText = "Happy new year!";
        }
        this.controlList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 48, "Singleplayer"));
        this.controlList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 72, "Multiplayer"));
        this.controlList.add(new GuiButton(3, this.width / 2 - 100, this.height / 4 + 96, "Mods and Texture Packs"));
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, "Options..."));
        if (this.mc.field_6320_i == null) {
            ((GuiButton)this.controlList.get((int)1)).enabled = false;
        }
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 0) {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }
        if (guibutton.id == 1) {
            this.mc.displayGuiScreen(new GuiSelectWorld(this));
        }
        if (guibutton.id == 2) {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }
        if (guibutton.id == 3) {
            this.mc.displayGuiScreen(new GuiTexturePacks(this));
        }
    }

    @Override
    public void drawScreen(int i2, int j2, float f2) {
        this.drawDefaultBackground();
        Tessellator tessellator = Tessellator.instance;
        this.drawLogo(f2);
        GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/gui/logo.png"));
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        tessellator.setColorOpaque_I(0xFFFFFF);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.width / 2 + 90, 70.0f, 0.0f);
        GL11.glRotatef(-20.0f, 0.0f, 0.0f, 1.0f);
        float f1 = 1.8f - MathHelper.abs(MathHelper.sin((float)(System.currentTimeMillis() % 1000L) / 1000.0f * 3.141593f * 2.0f) * 0.1f);
        f1 = f1 * 100.0f / (float)(this.fontRenderer.getStringWidth(this.splashText) + 32);
        GL11.glScalef(f1, f1, f1);
        this.drawCenteredString(this.fontRenderer, this.splashText, 0, -8, 0xFFFF00);
        GL11.glPopMatrix();
        this.drawString(this.fontRenderer, "Minecraft Alpha Herobrine Test", 2, 2, 0x505050);
        String s2 = "Copyright Mojang Specifications. Do not distribute.";
        this.drawString(this.fontRenderer, s2, this.width - this.fontRenderer.getStringWidth(s2) - 2, this.height - 10, 0xFFFFFF);
        super.drawScreen(i2, j2, f2);
    }

    private void drawLogo(float f2) {
        if (this.logoEffects == null) {
            this.logoEffects = new LogoEffectRandomizer[this.minecraftLogo[0].length()][this.minecraftLogo.length];
            for (int i2 = 0; i2 < this.logoEffects.length; ++i2) {
                for (int j2 = 0; j2 < this.logoEffects[i2].length; ++j2) {
                    this.logoEffects[i2][j2] = new LogoEffectRandomizer(this, i2, j2);
                }
            }
        }
        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        ScaledResolution scaledresolution = new ScaledResolution(this.mc.displayWidth, this.mc.displayHeight);
        int k2 = 120 * scaledresolution.scaleFactor;
        GLU.gluPerspective(70.0f, (float)this.mc.displayWidth / (float)k2, 0.05f, 100.0f);
        GL11.glViewport(0, this.mc.displayHeight - k2, this.mc.displayWidth, k2);
        GL11.glMatrixMode(5888);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glDisable(2884);
        GL11.glCullFace(1029);
        GL11.glDepthMask(true);
        RenderBlocks renderblocks = new RenderBlocks();
        for (int l2 = 0; l2 < 3; ++l2) {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.4f, 0.6f, -13.0f);
            if (l2 == 0) {
                GL11.glClear(256);
                GL11.glTranslatef(0.0f, -0.4f, 0.0f);
                GL11.glScalef(0.98f, 1.0f, 1.0f);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
            }
            if (l2 == 1) {
                GL11.glDisable(3042);
                GL11.glClear(256);
            }
            if (l2 == 2) {
                GL11.glEnable(3042);
                GL11.glBlendFunc(768, 1);
            }
            GL11.glScalef(1.0f, -1.0f, 1.0f);
            GL11.glRotatef(15.0f, 1.0f, 0.0f, 0.0f);
            GL11.glScalef(0.89f, 1.0f, 0.4f);
            GL11.glTranslatef((float)(-this.minecraftLogo[0].length()) * 0.5f, (float)(-this.minecraftLogo.length) * 0.5f, 0.0f);
            GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/terrain.png"));
            if (l2 == 0) {
                GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/title/black.png"));
            }
            for (int i1 = 0; i1 < this.minecraftLogo.length; ++i1) {
                for (int j1 = 0; j1 < this.minecraftLogo[i1].length(); ++j1) {
                    char c2 = this.minecraftLogo[i1].charAt(j1);
                    if (c2 == ' ') continue;
                    GL11.glPushMatrix();
                    LogoEffectRandomizer logoeffectrandomizer = this.logoEffects[j1][i1];
                    float f1 = (float)(logoeffectrandomizer.field_1311_b + (logoeffectrandomizer.field_1312_a - logoeffectrandomizer.field_1311_b) * (double)f2);
                    float f22 = 1.0f;
                    float f3 = 1.0f;
                    float f4 = 0.0f;
                    if (l2 == 0) {
                        f22 = f1 * 0.04f + 1.0f;
                        f3 = 1.0f / f22;
                        f1 = 0.0f;
                    }
                    GL11.glTranslatef(j1, i1, f1);
                    GL11.glScalef(f22, f22, f22);
                    GL11.glRotatef(f4, 0.0f, 1.0f, 0.0f);
                    renderblocks.func_1238_a(Block.stone, f3);
                    GL11.glPopMatrix();
                }
            }
            GL11.glPopMatrix();
        }
        GL11.glDisable(3042);
        GL11.glMatrixMode(5889);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5888);
        GL11.glPopMatrix();
        GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        GL11.glEnable(2884);
    }

    static Random getRand() {
        return rand;
    }
}

