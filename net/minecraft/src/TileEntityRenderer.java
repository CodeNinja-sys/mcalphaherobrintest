/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.TileEntityMobSpawnerRenderer;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.TileEntitySignRenderer;
import net.minecraft.src.TileEntitySpecialRenderer;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class TileEntityRenderer {
    private Map specialRendererMap = new HashMap();
    public static TileEntityRenderer instance = new TileEntityRenderer();
    private FontRenderer fontRenderer;
    public static double staticPlayerX;
    public static double staticPlayerY;
    public static double staticPlayerZ;
    public RenderEngine renderEngine;
    public World worldObj;
    public EntityPlayer entityPlayer;
    public float playerYaw;
    public float playerPitch;
    public double playerX;
    public double playerY;
    public double playerZ;

    private TileEntityRenderer() {
        this.specialRendererMap.put(TileEntitySign.class, new TileEntitySignRenderer());
        this.specialRendererMap.put(TileEntityMobSpawner.class, new TileEntityMobSpawnerRenderer());
        for (TileEntitySpecialRenderer tileentityspecialrenderer : this.specialRendererMap.values()) {
            tileentityspecialrenderer.setTileEntityRenderer(this);
        }
    }

    public TileEntitySpecialRenderer getSpecialRendererForClass(Class class1) {
        TileEntitySpecialRenderer tileentityspecialrenderer = (TileEntitySpecialRenderer)this.specialRendererMap.get(class1);
        if (tileentityspecialrenderer == null && class1 != TileEntity.class) {
            tileentityspecialrenderer = this.getSpecialRendererForClass(class1.getSuperclass());
            this.specialRendererMap.put(class1, tileentityspecialrenderer);
        }
        return tileentityspecialrenderer;
    }

    public boolean hasSpecialRenderer(TileEntity tileentity) {
        return this.getSpecialRendererForEntity(tileentity) != null;
    }

    public TileEntitySpecialRenderer getSpecialRendererForEntity(TileEntity tileentity) {
        if (tileentity == null) {
            return null;
        }
        return this.getSpecialRendererForClass(tileentity.getClass());
    }

    public void setRenderingContext(World world, RenderEngine renderengine, FontRenderer fontrenderer, EntityPlayer entityplayer, float f2) {
        this.worldObj = world;
        this.renderEngine = renderengine;
        this.entityPlayer = entityplayer;
        this.fontRenderer = fontrenderer;
        this.playerYaw = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f2;
        this.playerPitch = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f2;
        this.playerX = entityplayer.lastTickPosX + (entityplayer.posX - entityplayer.lastTickPosX) * (double)f2;
        this.playerY = entityplayer.lastTickPosY + (entityplayer.posY - entityplayer.lastTickPosY) * (double)f2;
        this.playerZ = entityplayer.lastTickPosZ + (entityplayer.posZ - entityplayer.lastTickPosZ) * (double)f2;
    }

    public void renderTileEntity(TileEntity tileentity, float f2) {
        if (tileentity.getDistanceFrom(this.playerX, this.playerY, this.playerZ) < 4096.0) {
            float f1 = this.worldObj.getLightBrightness(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
            GL11.glColor3f(f1, f1, f1);
            this.renderTileEntityAt(tileentity, (double)tileentity.xCoord - staticPlayerX, (double)tileentity.yCoord - staticPlayerY, (double)tileentity.zCoord - staticPlayerZ, f2);
        }
    }

    public void renderTileEntityAt(TileEntity tileentity, double d2, double d1, double d22, float f2) {
        TileEntitySpecialRenderer tileentityspecialrenderer = this.getSpecialRendererForEntity(tileentity);
        if (tileentityspecialrenderer != null) {
            tileentityspecialrenderer.renderTileEntityAt(tileentity, d2, d1, d22, f2);
        }
    }

    public FontRenderer getFontRenderer() {
        return this.fontRenderer;
    }
}

