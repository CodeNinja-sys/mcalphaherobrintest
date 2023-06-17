/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.ClippingHelperImplementation;
import net.minecraft.src.EffectRenderer;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EntityRainFX;
import net.minecraft.src.Frustrum;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.ItemRenderer;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.PlayerControllerTest;
import net.minecraft.src.RenderGlobal;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;

public class EntityRenderer {
    private Minecraft mc;
    private float field_1387_i = 0.0f;
    public ItemRenderer field_1395_a;
    private int field_1386_j;
    private Entity field_1385_k = null;
    private long field_1384_l = System.currentTimeMillis();
    private Random field_1383_m = new Random();
    volatile int field_1394_b = 0;
    volatile int field_1393_c = 0;
    FloatBuffer field_1392_d = GLAllocation.createDirectFloatBuffer(16);
    float field_4270_e;
    float field_4269_f;
    float field_4268_g;
    private float field_1382_n;
    private float field_1381_o;

    public EntityRenderer(Minecraft minecraft) {
        this.mc = minecraft;
        this.field_1395_a = new ItemRenderer(minecraft);
    }

    public void func_911_a() {
        this.field_1382_n = this.field_1381_o;
        float f2 = this.mc.theWorld.getLightBrightness(MathHelper.floor_double(this.mc.thePlayer.posX), MathHelper.floor_double(this.mc.thePlayer.posY), MathHelper.floor_double(this.mc.thePlayer.posZ));
        float f1 = (float)(3 - this.mc.gameSettings.renderDistance) / 3.0f;
        float f22 = f2 * (1.0f - f1) + f1;
        this.field_1381_o += (f22 - this.field_1381_o) * 0.1f;
        ++this.field_1386_j;
        this.field_1395_a.func_895_a();
        if (this.mc.field_6288_M) {
            this.func_916_c();
        }
    }

    public void func_910_a(float f2) {
        if (this.mc.thePlayer == null) {
            return;
        }
        double d2 = this.mc.field_6327_b.getBlockReachDistance();
        this.mc.objectMouseOver = this.mc.thePlayer.rayTrace(d2, f2);
        double d1 = d2;
        Vec3D vec3d = this.mc.thePlayer.getPosition(f2);
        if (this.mc.objectMouseOver != null) {
            d1 = this.mc.objectMouseOver.hitVec.distanceTo(vec3d);
        }
        if (this.mc.field_6327_b instanceof PlayerControllerTest) {
            d2 = 32.0;
            d1 = 32.0;
        } else {
            if (d1 > 3.0) {
                d1 = 3.0;
            }
            d2 = d1;
        }
        Vec3D vec3d1 = this.mc.thePlayer.getLook(f2);
        Vec3D vec3d2 = vec3d.addVector(vec3d1.xCoord * d2, vec3d1.yCoord * d2, vec3d1.zCoord * d2);
        this.field_1385_k = null;
        float f1 = 1.0f;
        List list = this.mc.theWorld.getEntitiesWithinAABBExcludingEntity(this.mc.thePlayer, this.mc.thePlayer.boundingBox.addCoord(vec3d1.xCoord * d2, vec3d1.yCoord * d2, vec3d1.zCoord * d2).expands(f1, f1, f1));
        double d22 = 0.0;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            double d3;
            Entity entity = (Entity)list.get(i2);
            if (!entity.canBeCollidedWith()) continue;
            float f22 = entity.func_4035_j_();
            AxisAlignedBB axisalignedbb = entity.boundingBox.expands(f22, f22, f22);
            MovingObjectPosition movingobjectposition = axisalignedbb.func_1169_a(vec3d, vec3d2);
            if (axisalignedbb.isVecInside(vec3d)) {
                if (!(0.0 < d22) && d22 != 0.0) continue;
                this.field_1385_k = entity;
                d22 = 0.0;
                continue;
            }
            if (movingobjectposition == null || !((d3 = vec3d.distanceTo(movingobjectposition.hitVec)) < d22) && d22 != 0.0) continue;
            this.field_1385_k = entity;
            d22 = d3;
        }
        if (this.field_1385_k != null && !(this.mc.field_6327_b instanceof PlayerControllerTest)) {
            this.mc.objectMouseOver = new MovingObjectPosition(this.field_1385_k);
        }
    }

    private float func_914_d(float f2) {
        EntityPlayerSP entityplayersp = this.mc.thePlayer;
        float f1 = 70.0f;
        if (entityplayersp.isInsideOfMaterial(Material.water)) {
            f1 = 60.0f;
        }
        if (entityplayersp.health <= 0) {
            float f22 = (float)entityplayersp.deathTime + f2;
            f1 /= (1.0f - 500.0f / (f22 + 500.0f)) * 2.0f + 1.0f;
        }
        return f1;
    }

    private void hurtCameraEffect(float f2) {
        EntityPlayerSP entityplayersp = this.mc.thePlayer;
        float f1 = (float)entityplayersp.hurtTime - f2;
        if (entityplayersp.health <= 0) {
            float f22 = (float)entityplayersp.deathTime + f2;
            GL11.glRotatef(40.0f - 8000.0f / (f22 + 200.0f), 0.0f, 0.0f, 1.0f);
        }
        if (f1 < 0.0f) {
            return;
        }
        f1 /= (float)entityplayersp.field_9332_M;
        f1 = MathHelper.sin(f1 * f1 * f1 * f1 * 3.141593f);
        float f3 = entityplayersp.field_9331_N;
        GL11.glRotatef(-f3, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-f1 * 14.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(f3, 0.0f, 1.0f, 0.0f);
    }

    private void func_917_f(float f2) {
        if (this.mc.gameSettings.thirdPersonView) {
            return;
        }
        EntityPlayerSP entityplayersp = this.mc.thePlayer;
        float f1 = entityplayersp.field_9290_aS - entityplayersp.field_9291_aR;
        float f22 = entityplayersp.field_9290_aS + f1 * f2;
        float f3 = entityplayersp.field_775_e + (entityplayersp.field_774_f - entityplayersp.field_775_e) * f2;
        float f4 = entityplayersp.field_9329_Q + (entityplayersp.field_9328_R - entityplayersp.field_9329_Q) * f2;
        GL11.glTranslatef(MathHelper.sin(f22 * 3.141593f) * f3 * 0.5f, -Math.abs(MathHelper.cos(f22 * 3.141593f) * f3), 0.0f);
        GL11.glRotatef(MathHelper.sin(f22 * 3.141593f) * f3 * 3.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(Math.abs(MathHelper.cos(f22 * 3.141593f + 0.2f) * f3) * 5.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(f4, 1.0f, 0.0f, 0.0f);
    }

    private void orientCamera(float f2) {
        EntityPlayerSP entityplayersp = this.mc.thePlayer;
        double d2 = entityplayersp.prevPosX + (entityplayersp.posX - entityplayersp.prevPosX) * (double)f2;
        double d1 = entityplayersp.prevPosY + (entityplayersp.posY - entityplayersp.prevPosY) * (double)f2;
        double d22 = entityplayersp.prevPosZ + (entityplayersp.posZ - entityplayersp.prevPosZ) * (double)f2;
        if (this.mc.gameSettings.thirdPersonView) {
            double d3 = 4.0;
            float f1 = entityplayersp.rotationYaw;
            float f22 = entityplayersp.rotationPitch;
            if (Keyboard.isKeyDown(59)) {
                f22 += 180.0f;
                d3 += 2.0;
            }
            double d4 = (double)(-MathHelper.sin(f1 / 180.0f * 3.141593f) * MathHelper.cos(f22 / 180.0f * 3.141593f)) * d3;
            double d5 = (double)(MathHelper.cos(f1 / 180.0f * 3.141593f) * MathHelper.cos(f22 / 180.0f * 3.141593f)) * d3;
            double d6 = (double)(-MathHelper.sin(f22 / 180.0f * 3.141593f)) * d3;
            for (int i2 = 0; i2 < 8; ++i2) {
                double d7;
                MovingObjectPosition movingobjectposition;
                float f3 = (i2 & 1) * 2 - 1;
                float f4 = (i2 >> 1 & 1) * 2 - 1;
                float f5 = (i2 >> 2 & 1) * 2 - 1;
                if ((movingobjectposition = this.mc.theWorld.rayTraceBlocks(Vec3D.createVector(d2 + (double)(f3 *= 0.1f), d1 + (double)(f4 *= 0.1f), d22 + (double)(f5 *= 0.1f)), Vec3D.createVector(d2 - d4 + (double)f3 + (double)f5, d1 - d6 + (double)f4, d22 - d5 + (double)f5))) == null || !((d7 = movingobjectposition.hitVec.distanceTo(Vec3D.createVector(d2, d1, d22))) < d3)) continue;
                d3 = d7;
            }
            if (Keyboard.isKeyDown(59)) {
                GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            }
            GL11.glRotatef(entityplayersp.rotationPitch - f22, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(entityplayersp.rotationYaw - f1, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(0.0f, 0.0f, (float)(-d3));
            GL11.glRotatef(f1 - entityplayersp.rotationYaw, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(f22 - entityplayersp.rotationPitch, 1.0f, 0.0f, 0.0f);
        } else {
            GL11.glTranslatef(0.0f, 0.0f, -0.1f);
        }
        GL11.glRotatef(entityplayersp.prevRotationPitch + (entityplayersp.rotationPitch - entityplayersp.prevRotationPitch) * f2, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(entityplayersp.prevRotationYaw + (entityplayersp.rotationYaw - entityplayersp.prevRotationYaw) * f2 + 180.0f, 0.0f, 1.0f, 0.0f);
    }

    private void setupCameraTransform(float f2, int i2) {
        float f22;
        this.field_1387_i = 256 >> this.mc.gameSettings.renderDistance;
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        float f1 = 0.07f;
        if (this.mc.gameSettings.anaglyph) {
            GL11.glTranslatef((float)(-(i2 * 2 - 1)) * f1, 0.0f, 0.0f);
        }
        GLU.gluPerspective(this.func_914_d(f2), (float)this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.field_1387_i);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        if (this.mc.gameSettings.anaglyph) {
            GL11.glTranslatef((float)(i2 * 2 - 1) * 0.1f, 0.0f, 0.0f);
        }
        this.hurtCameraEffect(f2);
        if (this.mc.gameSettings.viewBobbing) {
            this.func_917_f(f2);
        }
        if ((f22 = this.mc.thePlayer.field_4133_d + (this.mc.thePlayer.field_4134_c - this.mc.thePlayer.field_4133_d) * f2) > 0.0f) {
            float f3 = 5.0f / (f22 * f22 + 5.0f) - f22 * 0.04f;
            f3 *= f3;
            GL11.glRotatef(f22 * f22 * 1500.0f, 0.0f, 1.0f, 1.0f);
            GL11.glScalef(1.0f / f3, 1.0f, 1.0f);
            GL11.glRotatef(-f22 * f22 * 1500.0f, 0.0f, 1.0f, 1.0f);
        }
        this.orientCamera(f2);
    }

    private void func_4135_b(float f2, int i2) {
        GL11.glLoadIdentity();
        if (this.mc.gameSettings.anaglyph) {
            GL11.glTranslatef((float)(i2 * 2 - 1) * 0.1f, 0.0f, 0.0f);
        }
        GL11.glPushMatrix();
        this.hurtCameraEffect(f2);
        if (this.mc.gameSettings.viewBobbing) {
            this.func_917_f(f2);
        }
        if (!this.mc.gameSettings.thirdPersonView && !Keyboard.isKeyDown(59)) {
            this.field_1395_a.renderItemInFirstPerson(f2);
        }
        GL11.glPopMatrix();
        if (!this.mc.gameSettings.thirdPersonView) {
            this.field_1395_a.renderOverlays(f2);
            this.hurtCameraEffect(f2);
        }
        if (this.mc.gameSettings.viewBobbing) {
            this.func_917_f(f2);
        }
    }

    public void func_4136_b(float f2) {
        if (!Display.isActive()) {
            if (System.currentTimeMillis() - this.field_1384_l > 500L) {
                this.mc.func_6252_g();
            }
        } else {
            this.field_1384_l = System.currentTimeMillis();
        }
        if (this.mc.field_6289_L) {
            this.mc.mouseHelper.func_772_c();
            float f1 = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            float f22 = f1 * f1 * f1 * 8.0f;
            float f3 = (float)this.mc.mouseHelper.field_1114_a * f22;
            float f4 = (float)this.mc.mouseHelper.field_1113_b * f22;
            int l2 = 1;
            if (this.mc.gameSettings.invertMouse) {
                l2 = -1;
            }
            this.mc.thePlayer.func_346_d(f3, f4 * (float)l2);
        }
        if (this.mc.field_6307_v) {
            return;
        }
        ScaledResolution scaledresolution = new ScaledResolution(this.mc.displayWidth, this.mc.displayHeight);
        int i2 = scaledresolution.getScaledWidth();
        int j2 = scaledresolution.getScaledHeight();
        int k2 = Mouse.getX() * i2 / this.mc.displayWidth;
        int i1 = j2 - Mouse.getY() * j2 / this.mc.displayHeight - 1;
        if (this.mc.theWorld != null) {
            this.func_4134_c(f2);
            if (!Keyboard.isKeyDown(59)) {
                this.mc.ingameGUI.renderGameOverlay(f2, this.mc.currentScreen != null, k2, i1);
            }
        } else {
            GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
            GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL11.glClear(16640);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            this.func_905_b();
        }
        if (this.mc.currentScreen != null) {
            GL11.glClear(256);
            this.mc.currentScreen.drawScreen(k2, i1, f2);
        }
    }

    public void func_4134_c(float f2) {
        this.func_910_a(f2);
        EntityPlayerSP entityplayersp = this.mc.thePlayer;
        RenderGlobal renderglobal = this.mc.field_6323_f;
        EffectRenderer effectrenderer = this.mc.field_6321_h;
        double d2 = entityplayersp.lastTickPosX + (entityplayersp.posX - entityplayersp.lastTickPosX) * (double)f2;
        double d1 = entityplayersp.lastTickPosY + (entityplayersp.posY - entityplayersp.lastTickPosY) * (double)f2;
        double d22 = entityplayersp.lastTickPosZ + (entityplayersp.posZ - entityplayersp.lastTickPosZ) * (double)f2;
        for (int i2 = 0; i2 < 2; ++i2) {
            if (this.mc.gameSettings.anaglyph) {
                if (i2 == 0) {
                    GL11.glColorMask(false, true, true, false);
                } else {
                    GL11.glColorMask(true, false, false, false);
                }
            }
            GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
            this.updateFogColor(f2);
            GL11.glClear(16640);
            GL11.glEnable(2884);
            this.setupCameraTransform(f2, i2);
            ClippingHelperImplementation.func_1155_a();
            if (this.mc.gameSettings.renderDistance < 2) {
                this.func_4140_a(-1);
                renderglobal.func_4142_a(f2);
            }
            GL11.glEnable(2912);
            this.func_4140_a(1);
            Frustrum frustrum = new Frustrum();
            frustrum.func_343_a(d2, d1, d22);
            this.mc.field_6323_f.func_960_a(frustrum, f2);
            this.mc.field_6323_f.func_948_a(entityplayersp, false);
            this.func_4140_a(0);
            GL11.glEnable(2912);
            GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/terrain.png"));
            RenderHelper.disableStandardItemLighting();
            renderglobal.func_943_a(entityplayersp, 0, f2);
            RenderHelper.enableStandardItemLighting();
            renderglobal.func_951_a(entityplayersp.getPosition(f2), frustrum, f2);
            effectrenderer.func_1187_b(entityplayersp, f2);
            RenderHelper.disableStandardItemLighting();
            this.func_4140_a(0);
            effectrenderer.func_1189_a(entityplayersp, f2);
            if (this.mc.objectMouseOver != null && entityplayersp.isInsideOfMaterial(Material.water)) {
                GL11.glDisable(3008);
                renderglobal.func_959_a(entityplayersp, this.mc.objectMouseOver, 0, entityplayersp.inventory.getCurrentItem(), f2);
                renderglobal.drawSelectionBox(entityplayersp, this.mc.objectMouseOver, 0, entityplayersp.inventory.getCurrentItem(), f2);
                GL11.glEnable(3008);
            }
            GL11.glBlendFunc(770, 771);
            this.func_4140_a(0);
            GL11.glEnable(3042);
            GL11.glDisable(2884);
            GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/terrain.png"));
            if (this.mc.gameSettings.fancyGraphics) {
                GL11.glColorMask(false, false, false, false);
                int j2 = renderglobal.func_943_a(entityplayersp, 1, f2);
                GL11.glColorMask(true, true, true, true);
                if (this.mc.gameSettings.anaglyph) {
                    if (i2 == 0) {
                        GL11.glColorMask(false, true, true, false);
                    } else {
                        GL11.glColorMask(true, false, false, false);
                    }
                }
                if (j2 > 0) {
                    renderglobal.func_944_a(1, f2);
                }
            } else {
                renderglobal.func_943_a(entityplayersp, 1, f2);
            }
            GL11.glDepthMask(true);
            GL11.glEnable(2884);
            GL11.glDisable(3042);
            if (this.mc.objectMouseOver != null && !entityplayersp.isInsideOfMaterial(Material.water)) {
                GL11.glDisable(3008);
                renderglobal.func_959_a(entityplayersp, this.mc.objectMouseOver, 0, entityplayersp.inventory.getCurrentItem(), f2);
                renderglobal.drawSelectionBox(entityplayersp, this.mc.objectMouseOver, 0, entityplayersp.inventory.getCurrentItem(), f2);
                GL11.glEnable(3008);
            }
            GL11.glDisable(2912);
            if (this.field_1385_k == null) {
                // empty if block
            }
            this.func_4140_a(0);
            GL11.glEnable(2912);
            renderglobal.func_4141_b(f2);
            GL11.glDisable(2912);
            this.func_4140_a(1);
            GL11.glClear(256);
            this.func_4135_b(f2, i2);
            if (this.mc.gameSettings.anaglyph) continue;
            return;
        }
        GL11.glColorMask(true, true, true, false);
    }

    private void func_916_c() {
        if (!this.mc.gameSettings.fancyGraphics) {
            return;
        }
        EntityPlayerSP entityplayersp = this.mc.thePlayer;
        World world = this.mc.theWorld;
        int i2 = MathHelper.floor_double(entityplayersp.posX);
        int j2 = MathHelper.floor_double(entityplayersp.posY);
        int k2 = MathHelper.floor_double(entityplayersp.posZ);
        int byte0 = 16;
        for (int l2 = 0; l2 < 150; ++l2) {
            int i1 = i2 + this.field_1383_m.nextInt(byte0) - this.field_1383_m.nextInt(byte0);
            int j1 = k2 + this.field_1383_m.nextInt(byte0) - this.field_1383_m.nextInt(byte0);
            int k1 = world.func_696_e(i1, j1);
            int l1 = world.getBlockId(i1, k1 - 1, j1);
            if (k1 > j2 + byte0 || k1 < j2 - byte0) continue;
            float f2 = this.field_1383_m.nextFloat();
            float f1 = this.field_1383_m.nextFloat();
            if (l1 <= 0) continue;
            this.mc.field_6321_h.func_1192_a(new EntityRainFX(world, (float)i1 + f2, (double)((float)k1 + 0.1f) - Block.blocksList[l1].minY, (float)j1 + f1));
        }
    }

    public void func_905_b() {
        ScaledResolution scaledresolution = new ScaledResolution(this.mc.displayWidth, this.mc.displayHeight);
        int i2 = scaledresolution.getScaledWidth();
        int j2 = scaledresolution.getScaledHeight();
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, i2, j2, 0.0, 1000.0, 3000.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
    }

    private void updateFogColor(float f2) {
        World world = this.mc.theWorld;
        EntityPlayerSP entityplayersp = this.mc.thePlayer;
        float f1 = 1.0f / (float)(4 - this.mc.gameSettings.renderDistance);
        f1 = 1.0f - (float)Math.pow(f1, 0.25);
        Vec3D vec3d = world.func_4079_a(this.mc.thePlayer, f2);
        float f22 = (float)vec3d.xCoord;
        float f3 = (float)vec3d.yCoord;
        float f4 = (float)vec3d.zCoord;
        Vec3D vec3d1 = world.func_4082_d(f2);
        this.field_4270_e = (float)vec3d1.xCoord;
        this.field_4269_f = (float)vec3d1.yCoord;
        this.field_4268_g = (float)vec3d1.zCoord;
        this.field_4270_e += (f22 - this.field_4270_e) * f1;
        this.field_4269_f += (f3 - this.field_4269_f) * f1;
        this.field_4268_g += (f4 - this.field_4268_g) * f1;
        if (entityplayersp.isInsideOfMaterial(Material.water)) {
            this.field_4270_e = 0.02f;
            this.field_4269_f = 0.02f;
            this.field_4268_g = 0.2f;
        } else if (entityplayersp.isInsideOfMaterial(Material.lava)) {
            this.field_4270_e = 0.6f;
            this.field_4269_f = 0.1f;
            this.field_4268_g = 0.0f;
        }
        float f5 = this.field_1382_n + (this.field_1381_o - this.field_1382_n) * f2;
        this.field_4270_e *= f5;
        this.field_4269_f *= f5;
        this.field_4268_g *= f5;
        if (this.mc.gameSettings.anaglyph) {
            float f6 = (this.field_4270_e * 30.0f + this.field_4269_f * 59.0f + this.field_4268_g * 11.0f) / 100.0f;
            float f7 = (this.field_4270_e * 30.0f + this.field_4269_f * 70.0f) / 100.0f;
            float f8 = (this.field_4270_e * 30.0f + this.field_4268_g * 70.0f) / 100.0f;
            this.field_4270_e = f6;
            this.field_4269_f = f7;
            this.field_4268_g = f8;
        }
        GL11.glClearColor(this.field_4270_e, this.field_4269_f, this.field_4268_g, 0.0f);
    }

    private void func_4140_a(int i2) {
        EntityPlayerSP entityplayersp = this.mc.thePlayer;
        GL11.glFog(2918, this.func_908_a(this.field_4270_e, this.field_4269_f, this.field_4268_g, 1.0f));
        GL11.glNormal3f(0.0f, -1.0f, 0.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        if (entityplayersp.isInsideOfMaterial(Material.water)) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.1f);
            float f2 = 0.4f;
            float f22 = 0.4f;
            float f4 = 0.9f;
            if (this.mc.gameSettings.anaglyph) {
                float f6 = (f2 * 30.0f + f22 * 59.0f + f4 * 11.0f) / 100.0f;
                float f8 = (f2 * 30.0f + f22 * 70.0f) / 100.0f;
                float f10 = (f2 * 30.0f + f4 * 70.0f) / 100.0f;
                f2 = f6;
                f22 = f8;
                f4 = f10;
            }
        } else if (entityplayersp.isInsideOfMaterial(Material.lava)) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 2.0f);
            float f1 = 0.4f;
            float f3 = 0.3f;
            float f5 = 0.3f;
            if (this.mc.gameSettings.anaglyph) {
                float f7 = (f1 * 30.0f + f3 * 59.0f + f5 * 11.0f) / 100.0f;
                float f9 = (f1 * 30.0f + f3 * 70.0f) / 100.0f;
                float f11 = (f1 * 30.0f + f5 * 70.0f) / 100.0f;
                f1 = f7;
                f3 = f9;
                f5 = f11;
            }
        } else {
            GL11.glFogi(2917, 9729);
            GL11.glFogf(2915, this.field_1387_i * 0.25f);
            GL11.glFogf(2916, this.field_1387_i);
            if (i2 < 0) {
                GL11.glFogf(2915, 0.0f);
                GL11.glFogf(2916, this.field_1387_i * 0.8f);
            }
            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                GL11.glFogi(34138, 34139);
            }
            if (this.mc.theWorld.worldProvider.field_4220_c) {
                GL11.glFogf(2915, 0.0f);
            }
        }
        GL11.glEnable(2903);
        GL11.glColorMaterial(1028, 4608);
    }

    private FloatBuffer func_908_a(float f2, float f1, float f22, float f3) {
        this.field_1392_d.clear();
        this.field_1392_d.put(f2).put(f1).put(f22).put(f3);
        this.field_1392_d.flip();
        return this.field_1392_d;
    }
}

