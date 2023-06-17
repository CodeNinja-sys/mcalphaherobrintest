/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityBubbleFX;
import net.minecraft.src.EntityExplodeFX;
import net.minecraft.src.EntityFlameFX;
import net.minecraft.src.EntityLavaFX;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EntityPortalFX;
import net.minecraft.src.EntityReddustFX;
import net.minecraft.src.EntitySlimeFX;
import net.minecraft.src.EntitySmokeFX;
import net.minecraft.src.EntitySorter;
import net.minecraft.src.EntitySplashFX;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.ICamera;
import net.minecraft.src.IWorldAccess;
import net.minecraft.src.ImageBufferDownload;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.RenderList;
import net.minecraft.src.RenderManager;
import net.minecraft.src.RenderSorter;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityRenderer;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;
import net.minecraft.src.WorldRenderer;
import org.lwjgl.opengl.ARBOcclusionQuery;
import org.lwjgl.opengl.GL11;

public class RenderGlobal
implements IWorldAccess {
    public List field_1458_a;
    private World worldObj;
    private RenderEngine renderEngine;
    private List field_1446_m;
    private WorldRenderer[] field_1445_n;
    private WorldRenderer[] field_1444_o;
    private int field_1443_p;
    private int field_1442_q;
    private int field_1441_r;
    private int field_1440_s;
    private Minecraft mc;
    private RenderBlocks field_1438_u;
    private IntBuffer field_1437_v;
    private boolean field_1436_w = false;
    private int field_1435_x = 0;
    private int field_1434_y;
    private int field_1433_z;
    private int field_1432_A;
    private int field_1431_B;
    private int field_1430_C;
    private int field_1429_D;
    private int field_1428_E;
    private int field_1427_F;
    private int field_1426_G;
    private int field_1425_H = -1;
    private int field_1424_I = 2;
    private int field_1423_J;
    private int field_1422_K;
    private int field_1421_L;
    int[] field_1457_b;
    IntBuffer field_1456_c;
    private int field_1420_M;
    private int field_1419_N;
    private int field_1418_O;
    private int field_1417_P;
    private int field_1416_Q;
    private List field_1415_R;
    private RenderList[] field_1414_S = new RenderList[]{new RenderList(), new RenderList(), new RenderList(), new RenderList()};
    int field_1455_d = 0;
    int field_1454_e;
    double field_1453_f = -9999.0;
    double field_1452_g = -9999.0;
    double field_1451_h = -9999.0;
    public float field_1450_i;
    int field_1449_j = 0;

    public RenderGlobal(Minecraft minecraft, RenderEngine renderengine) {
        this.field_1458_a = new ArrayList();
        this.field_1446_m = new ArrayList();
        this.field_1457_b = new int[50000];
        this.field_1456_c = GLAllocation.createDirectIntBuffer(64);
        this.field_1415_R = new ArrayList();
        this.field_1454_e = GLAllocation.generateDisplayLists(1);
        this.mc = minecraft;
        this.renderEngine = renderengine;
        int byte0 = 64;
        this.field_1440_s = GLAllocation.generateDisplayLists(byte0 * byte0 * byte0 * 3);
        this.field_1436_w = minecraft.func_6251_l().checkARBOcclusion();
        if (this.field_1436_w) {
            this.field_1456_c.clear();
            this.field_1437_v = GLAllocation.createDirectIntBuffer(byte0 * byte0 * byte0);
            this.field_1437_v.clear();
            this.field_1437_v.position(0);
            this.field_1437_v.limit(byte0 * byte0 * byte0);
            ARBOcclusionQuery.glGenQueriesARB(this.field_1437_v);
        }
        this.field_1434_y = GLAllocation.generateDisplayLists(3);
        GL11.glPushMatrix();
        GL11.glNewList(this.field_1434_y, 4864);
        this.func_950_f();
        GL11.glEndList();
        GL11.glPopMatrix();
        Tessellator tessellator = Tessellator.instance;
        this.field_1433_z = this.field_1434_y + 1;
        GL11.glNewList(this.field_1433_z, 4864);
        int byte1 = 64;
        int i2 = 256 / byte1 + 2;
        float f2 = 16.0f;
        for (int j2 = -byte1 * i2; j2 <= byte1 * i2; j2 += byte1) {
            for (int l2 = -byte1 * i2; l2 <= byte1 * i2; l2 += byte1) {
                tessellator.startDrawingQuads();
                tessellator.addVertex(j2 + 0, f2, l2 + 0);
                tessellator.addVertex(j2 + byte1, f2, l2 + 0);
                tessellator.addVertex(j2 + byte1, f2, l2 + byte1);
                tessellator.addVertex(j2 + 0, f2, l2 + byte1);
                tessellator.draw();
            }
        }
        GL11.glEndList();
        this.field_1432_A = this.field_1434_y + 2;
        GL11.glNewList(this.field_1432_A, 4864);
        f2 = -16.0f;
        tessellator.startDrawingQuads();
        for (int k2 = -byte1 * i2; k2 <= byte1 * i2; k2 += byte1) {
            for (int i1 = -byte1 * i2; i1 <= byte1 * i2; i1 += byte1) {
                tessellator.addVertex(k2 + byte1, f2, i1 + 0);
                tessellator.addVertex(k2 + 0, f2, i1 + 0);
                tessellator.addVertex(k2 + 0, f2, i1 + byte1);
                tessellator.addVertex(k2 + byte1, f2, i1 + byte1);
            }
        }
        tessellator.draw();
        GL11.glEndList();
    }

    private void func_950_f() {
        Random random = new Random(10842L);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        for (int i2 = 0; i2 < 1500; ++i2) {
            double d2 = random.nextFloat() * 2.0f - 1.0f;
            double d1 = random.nextFloat() * 2.0f - 1.0f;
            double d22 = random.nextFloat() * 2.0f - 1.0f;
            double d3 = 0.25f + random.nextFloat() * 0.25f;
            double d4 = d2 * d2 + d1 * d1 + d22 * d22;
            if (d4 >= 1.0 || d4 <= 0.01) continue;
            d4 = 1.0 / Math.sqrt(d4);
            double d5 = (d2 *= d4) * 100.0;
            double d6 = (d1 *= d4) * 100.0;
            double d7 = (d22 *= d4) * 100.0;
            double d8 = Math.atan2(d2, d22);
            double d9 = Math.sin(d8);
            double d10 = Math.cos(d8);
            double d11 = Math.atan2(Math.sqrt(d2 * d2 + d22 * d22), d1);
            double d12 = Math.sin(d11);
            double d13 = Math.cos(d11);
            double d14 = random.nextDouble() * Math.PI * 2.0;
            double d15 = Math.sin(d14);
            double d16 = Math.cos(d14);
            for (int j2 = 0; j2 < 4; ++j2) {
                double d222;
                double d17 = 0.0;
                double d18 = (double)((j2 & 2) - 1) * d3;
                double d19 = (double)((j2 + 1 & 2) - 1) * d3;
                double d20 = d17;
                double d21 = d18 * d16 - d19 * d15;
                double d23 = d222 = d19 * d16 + d18 * d15;
                double d24 = d21 * d12 + d20 * d13;
                double d25 = d20 * d12 - d21 * d13;
                double d26 = d25 * d9 - d23 * d10;
                double d27 = d24;
                double d28 = d23 * d9 + d25 * d10;
                tessellator.addVertex(d5 + d26, d6 + d27, d7 + d28);
            }
        }
        tessellator.draw();
    }

    public void func_946_a(World world) {
        if (this.worldObj != null) {
            this.worldObj.removeWorldAccess(this);
        }
        this.field_1453_f = -9999.0;
        this.field_1452_g = -9999.0;
        this.field_1451_h = -9999.0;
        RenderManager.instance.func_852_a(world);
        this.worldObj = world;
        this.field_1438_u = new RenderBlocks(world);
        if (world != null) {
            world.addWorldAccess(this);
            this.func_958_a();
        }
    }

    public void func_958_a() {
        int j2;
        Block.leaves.setGraphicsLevel(this.mc.gameSettings.fancyGraphics);
        this.field_1425_H = this.mc.gameSettings.renderDistance;
        if (this.field_1444_o != null) {
            for (int i2 = 0; i2 < this.field_1444_o.length; ++i2) {
                this.field_1444_o[i2].func_1204_c();
            }
        }
        if ((j2 = 64 << 3 - this.field_1425_H) > 400) {
            j2 = 400;
        }
        this.field_1443_p = j2 / 16 + 1;
        this.field_1442_q = 8;
        this.field_1441_r = j2 / 16 + 1;
        this.field_1444_o = new WorldRenderer[this.field_1443_p * this.field_1442_q * this.field_1441_r];
        this.field_1445_n = new WorldRenderer[this.field_1443_p * this.field_1442_q * this.field_1441_r];
        int k2 = 0;
        int l2 = 0;
        this.field_1431_B = 0;
        this.field_1430_C = 0;
        this.field_1429_D = 0;
        this.field_1428_E = this.field_1443_p;
        this.field_1427_F = this.field_1442_q;
        this.field_1426_G = this.field_1441_r;
        for (int i1 = 0; i1 < this.field_1446_m.size(); ++i1) {
            ((WorldRenderer)this.field_1446_m.get((int)i1)).needsUpdate = false;
        }
        this.field_1446_m.clear();
        this.field_1458_a.clear();
        for (int j1 = 0; j1 < this.field_1443_p; ++j1) {
            for (int k1 = 0; k1 < this.field_1442_q; ++k1) {
                for (int l1 = 0; l1 < this.field_1441_r; ++l1) {
                    this.field_1444_o[(l1 * this.field_1442_q + k1) * this.field_1443_p + j1] = new WorldRenderer(this.worldObj, this.field_1458_a, j1 * 16, k1 * 16, l1 * 16, 16, this.field_1440_s + k2);
                    if (this.field_1436_w) {
                        this.field_1444_o[(l1 * this.field_1442_q + k1) * this.field_1443_p + j1].field_1732_z = this.field_1437_v.get(l2);
                    }
                    this.field_1444_o[(l1 * this.field_1442_q + k1) * this.field_1443_p + j1].field_1733_y = false;
                    this.field_1444_o[(l1 * this.field_1442_q + k1) * this.field_1443_p + j1].field_1734_x = true;
                    this.field_1444_o[(l1 * this.field_1442_q + k1) * this.field_1443_p + j1].field_1749_o = true;
                    this.field_1444_o[(l1 * this.field_1442_q + k1) * this.field_1443_p + j1].field_1735_w = l2++;
                    this.field_1444_o[(l1 * this.field_1442_q + k1) * this.field_1443_p + j1].MarkDirty();
                    this.field_1445_n[(l1 * this.field_1442_q + k1) * this.field_1443_p + j1] = this.field_1444_o[(l1 * this.field_1442_q + k1) * this.field_1443_p + j1];
                    this.field_1446_m.add(this.field_1444_o[(l1 * this.field_1442_q + k1) * this.field_1443_p + j1]);
                    k2 += 3;
                }
            }
        }
        if (this.worldObj != null) {
            EntityPlayerSP entityplayersp = this.mc.thePlayer;
            this.func_956_b(MathHelper.floor_double(entityplayersp.posX), MathHelper.floor_double(entityplayersp.posY), MathHelper.floor_double(entityplayersp.posZ));
            Arrays.sort(this.field_1445_n, new EntitySorter(entityplayersp));
        }
        this.field_1424_I = 2;
    }

    public void func_951_a(Vec3D vec3d, ICamera icamera, float f2) {
        if (this.field_1424_I > 0) {
            --this.field_1424_I;
            return;
        }
        TileEntityRenderer.instance.setRenderingContext(this.worldObj, this.renderEngine, this.mc.fontRenderer, this.mc.thePlayer, f2);
        RenderManager.instance.func_857_a(this.worldObj, this.renderEngine, this.mc.fontRenderer, this.mc.thePlayer, this.mc.gameSettings, f2);
        this.field_1423_J = 0;
        this.field_1422_K = 0;
        this.field_1421_L = 0;
        EntityPlayerSP entityplayersp = this.mc.thePlayer;
        RenderManager.field_1232_b = entityplayersp.lastTickPosX + (entityplayersp.posX - entityplayersp.lastTickPosX) * (double)f2;
        RenderManager.field_1231_c = entityplayersp.lastTickPosY + (entityplayersp.posY - entityplayersp.lastTickPosY) * (double)f2;
        RenderManager.field_1230_d = entityplayersp.lastTickPosZ + (entityplayersp.posZ - entityplayersp.lastTickPosZ) * (double)f2;
        TileEntityRenderer.staticPlayerX = entityplayersp.lastTickPosX + (entityplayersp.posX - entityplayersp.lastTickPosX) * (double)f2;
        TileEntityRenderer.staticPlayerY = entityplayersp.lastTickPosY + (entityplayersp.posY - entityplayersp.lastTickPosY) * (double)f2;
        TileEntityRenderer.staticPlayerZ = entityplayersp.lastTickPosZ + (entityplayersp.posZ - entityplayersp.lastTickPosZ) * (double)f2;
        List list = this.worldObj.func_658_i();
        this.field_1423_J = list.size();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            Entity entity = (Entity)list.get(i2);
            if (!entity.func_390_a(vec3d) || !icamera.func_342_a(entity.boundingBox) || entity == this.mc.thePlayer && !this.mc.gameSettings.thirdPersonView) continue;
            ++this.field_1422_K;
            RenderManager.instance.func_854_a(entity, f2);
        }
        for (int j2 = 0; j2 < this.field_1458_a.size(); ++j2) {
            TileEntityRenderer.instance.renderTileEntity((TileEntity)this.field_1458_a.get(j2), f2);
        }
    }

    public String func_953_b() {
        return "C: " + this.field_1417_P + "/" + this.field_1420_M + ". F: " + this.field_1419_N + ", O: " + this.field_1418_O + ", E: " + this.field_1416_Q;
    }

    public String func_957_c() {
        return "E: " + this.field_1422_K + "/" + this.field_1423_J + ". B: " + this.field_1421_L + ", I: " + (this.field_1423_J - this.field_1421_L - this.field_1422_K);
    }

    private void func_956_b(int i2, int j2, int k2) {
        i2 -= 8;
        j2 -= 8;
        k2 -= 8;
        this.field_1431_B = Integer.MAX_VALUE;
        this.field_1430_C = Integer.MAX_VALUE;
        this.field_1429_D = Integer.MAX_VALUE;
        this.field_1428_E = Integer.MIN_VALUE;
        this.field_1427_F = Integer.MIN_VALUE;
        this.field_1426_G = Integer.MIN_VALUE;
        int l2 = this.field_1443_p * 16;
        int i1 = l2 / 2;
        for (int j1 = 0; j1 < this.field_1443_p; ++j1) {
            int k1 = j1 * 16;
            int l1 = k1 + i1 - i2;
            if (l1 < 0) {
                l1 -= l2 - 1;
            }
            if ((k1 -= (l1 /= l2) * l2) < this.field_1431_B) {
                this.field_1431_B = k1;
            }
            if (k1 > this.field_1428_E) {
                this.field_1428_E = k1;
            }
            for (int i22 = 0; i22 < this.field_1441_r; ++i22) {
                int j22 = i22 * 16;
                int k22 = j22 + i1 - k2;
                if (k22 < 0) {
                    k22 -= l2 - 1;
                }
                if ((j22 -= (k22 /= l2) * l2) < this.field_1429_D) {
                    this.field_1429_D = j22;
                }
                if (j22 > this.field_1426_G) {
                    this.field_1426_G = j22;
                }
                for (int l22 = 0; l22 < this.field_1442_q; ++l22) {
                    int i3 = l22 * 16;
                    if (i3 < this.field_1430_C) {
                        this.field_1430_C = i3;
                    }
                    if (i3 > this.field_1427_F) {
                        this.field_1427_F = i3;
                    }
                    WorldRenderer worldrenderer = this.field_1444_o[(i22 * this.field_1442_q + l22) * this.field_1443_p + j1];
                    boolean flag = worldrenderer.needsUpdate;
                    worldrenderer.func_1197_a(k1, i3, j22);
                    if (flag || !worldrenderer.needsUpdate) continue;
                    this.field_1446_m.add(worldrenderer);
                }
            }
        }
    }

    public int func_943_a(EntityPlayer entityplayer, int i2, double d2) {
        if (this.mc.gameSettings.renderDistance != this.field_1425_H) {
            this.func_958_a();
        }
        if (i2 == 0) {
            this.field_1420_M = 0;
            this.field_1419_N = 0;
            this.field_1418_O = 0;
            this.field_1417_P = 0;
            this.field_1416_Q = 0;
        }
        double d1 = entityplayer.lastTickPosX + (entityplayer.posX - entityplayer.lastTickPosX) * d2;
        double d22 = entityplayer.lastTickPosY + (entityplayer.posY - entityplayer.lastTickPosY) * d2;
        double d3 = entityplayer.lastTickPosZ + (entityplayer.posZ - entityplayer.lastTickPosZ) * d2;
        double d4 = entityplayer.posX - this.field_1453_f;
        double d5 = entityplayer.posY - this.field_1452_g;
        double d6 = entityplayer.posZ - this.field_1451_h;
        if (d4 * d4 + d5 * d5 + d6 * d6 > 16.0) {
            this.field_1453_f = entityplayer.posX;
            this.field_1452_g = entityplayer.posY;
            this.field_1451_h = entityplayer.posZ;
            this.func_956_b(MathHelper.floor_double(entityplayer.posX), MathHelper.floor_double(entityplayer.posY), MathHelper.floor_double(entityplayer.posZ));
            Arrays.sort(this.field_1445_n, new EntitySorter(entityplayer));
        }
        int j2 = 0;
        if (this.field_1436_w && !this.mc.gameSettings.anaglyph && i2 == 0) {
            int k2 = 0;
            int l2 = 16;
            this.func_962_a(k2, l2);
            for (int i1 = k2; i1 < l2; ++i1) {
                this.field_1445_n[i1].field_1734_x = true;
            }
            j2 += this.func_952_a(k2, l2, i2, d2);
            do {
                int byte0 = l2;
                if ((l2 *= 2) > this.field_1445_n.length) {
                    l2 = this.field_1445_n.length;
                }
                GL11.glDisable(3553);
                GL11.glDisable(2896);
                GL11.glDisable(3008);
                GL11.glDisable(2912);
                GL11.glColorMask(false, false, false, false);
                GL11.glDepthMask(false);
                this.func_962_a(byte0, l2);
                GL11.glPushMatrix();
                float f2 = 0.0f;
                float f1 = 0.0f;
                float f22 = 0.0f;
                for (int j1 = byte0; j1 < l2; ++j1) {
                    float f3;
                    int k1;
                    if (this.field_1445_n[j1].func_1196_e()) {
                        this.field_1445_n[j1].field_1749_o = false;
                        continue;
                    }
                    if (!this.field_1445_n[j1].field_1749_o) {
                        this.field_1445_n[j1].field_1734_x = true;
                    }
                    if (!this.field_1445_n[j1].field_1749_o || this.field_1445_n[j1].field_1733_y || this.field_1435_x % (k1 = (int)(1.0f + (f3 = MathHelper.sqrt_float(this.field_1445_n[j1].func_1202_a(entityplayer))) / 128.0f)) != j1 % k1) continue;
                    WorldRenderer worldrenderer = this.field_1445_n[j1];
                    float f4 = (float)((double)worldrenderer.field_1755_i - d1);
                    float f5 = (float)((double)worldrenderer.field_1754_j - d22);
                    float f6 = (float)((double)worldrenderer.field_1753_k - d3);
                    float f7 = f4 - f2;
                    float f8 = f5 - f1;
                    float f9 = f6 - f22;
                    if (f7 != 0.0f || f8 != 0.0f || f9 != 0.0f) {
                        GL11.glTranslatef(f7, f8, f9);
                        f2 += f7;
                        f1 += f8;
                        f22 += f9;
                    }
                    ARBOcclusionQuery.glBeginQueryARB(35092, this.field_1445_n[j1].field_1732_z);
                    this.field_1445_n[j1].func_1201_d();
                    ARBOcclusionQuery.glEndQueryARB(35092);
                    this.field_1445_n[j1].field_1733_y = true;
                }
                GL11.glPopMatrix();
                GL11.glColorMask(true, true, true, true);
                GL11.glDepthMask(true);
                GL11.glEnable(3553);
                GL11.glEnable(3008);
                GL11.glEnable(2912);
                j2 += this.func_952_a(byte0, l2, i2, d2);
            } while (l2 < this.field_1445_n.length);
        } else {
            j2 += this.func_952_a(0, this.field_1445_n.length, i2, d2);
        }
        return j2;
    }

    private void func_962_a(int i2, int j2) {
        for (int k2 = i2; k2 < j2; ++k2) {
            if (!this.field_1445_n[k2].field_1733_y) continue;
            this.field_1456_c.clear();
            ARBOcclusionQuery.glGetQueryObjectuARB(this.field_1445_n[k2].field_1732_z, 34919, this.field_1456_c);
            if (this.field_1456_c.get(0) == 0) continue;
            this.field_1445_n[k2].field_1733_y = false;
            this.field_1456_c.clear();
            ARBOcclusionQuery.glGetQueryObjectuARB(this.field_1445_n[k2].field_1732_z, 34918, this.field_1456_c);
            this.field_1445_n[k2].field_1734_x = this.field_1456_c.get(0) != 0;
        }
    }

    private int func_952_a(int i2, int j2, int k2, double d2) {
        this.field_1415_R.clear();
        int l2 = 0;
        for (int i1 = i2; i1 < j2; ++i1) {
            int j1;
            if (k2 == 0) {
                ++this.field_1420_M;
                if (this.field_1445_n[i1].field_1748_p[k2]) {
                    ++this.field_1416_Q;
                } else if (!this.field_1445_n[i1].field_1749_o) {
                    ++this.field_1419_N;
                } else if (this.field_1436_w && !this.field_1445_n[i1].field_1734_x) {
                    ++this.field_1418_O;
                } else {
                    ++this.field_1417_P;
                }
            }
            if (this.field_1445_n[i1].field_1748_p[k2] || !this.field_1445_n[i1].field_1749_o || !this.field_1445_n[i1].field_1734_x || (j1 = this.field_1445_n[i1].func_1200_a(k2)) < 0) continue;
            this.field_1415_R.add(this.field_1445_n[i1]);
            ++l2;
        }
        EntityPlayerSP entityplayersp = this.mc.thePlayer;
        double d1 = entityplayersp.lastTickPosX + (entityplayersp.posX - entityplayersp.lastTickPosX) * d2;
        double d22 = entityplayersp.lastTickPosY + (entityplayersp.posY - entityplayersp.lastTickPosY) * d2;
        double d3 = entityplayersp.lastTickPosZ + (entityplayersp.posZ - entityplayersp.lastTickPosZ) * d2;
        int k1 = 0;
        for (int l1 = 0; l1 < this.field_1414_S.length; ++l1) {
            this.field_1414_S[l1].func_859_b();
        }
        for (int i22 = 0; i22 < this.field_1415_R.size(); ++i22) {
            WorldRenderer worldrenderer = (WorldRenderer)this.field_1415_R.get(i22);
            int j22 = -1;
            for (int k22 = 0; k22 < k1; ++k22) {
                if (!this.field_1414_S[k22].func_862_a(worldrenderer.field_1755_i, worldrenderer.field_1754_j, worldrenderer.field_1753_k)) continue;
                j22 = k22;
            }
            if (j22 < 0) {
                j22 = k1++;
                this.field_1414_S[j22].func_861_a(worldrenderer.field_1755_i, worldrenderer.field_1754_j, worldrenderer.field_1753_k, d1, d22, d3);
            }
            this.field_1414_S[j22].func_858_a(worldrenderer.func_1200_a(k2));
        }
        this.func_944_a(k2, d2);
        return l2;
    }

    public void func_944_a(int i2, double d2) {
        for (int j2 = 0; j2 < this.field_1414_S.length; ++j2) {
            this.field_1414_S[j2].func_860_a();
        }
    }

    public void func_945_d() {
        ++this.field_1435_x;
    }

    public void func_4142_a(float f2) {
        if (this.mc.theWorld.worldProvider.field_4220_c) {
            return;
        }
        GL11.glDisable(3553);
        Vec3D vec3d = this.worldObj.func_4079_a(this.mc.thePlayer, f2);
        float f1 = (float)vec3d.xCoord;
        float f22 = (float)vec3d.yCoord;
        float f3 = (float)vec3d.zCoord;
        if (this.mc.gameSettings.anaglyph) {
            float f4 = (f1 * 30.0f + f22 * 59.0f + f3 * 11.0f) / 100.0f;
            float f5 = (f1 * 30.0f + f22 * 70.0f) / 100.0f;
            float f7 = (f1 * 30.0f + f3 * 70.0f) / 100.0f;
            f1 = f4;
            f22 = f5;
            f3 = f7;
        }
        GL11.glColor3f(f1, f22, f3);
        Tessellator tessellator = Tessellator.instance;
        GL11.glDepthMask(false);
        GL11.glEnable(2912);
        GL11.glColor3f(f1, f22, f3);
        GL11.glCallList(this.field_1433_z);
        GL11.glDisable(2912);
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        float[] af2 = this.worldObj.worldProvider.func_4097_b(this.worldObj.getCelestialAngle(f2), f2);
        if (af2 != null) {
            GL11.glDisable(3553);
            GL11.glShadeModel(7425);
            GL11.glPushMatrix();
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            float f8 = this.worldObj.getCelestialAngle(f2);
            GL11.glRotatef(f8 <= 0.5f ? 0.0f : 180.0f, 0.0f, 0.0f, 1.0f);
            tessellator.startDrawing(6);
            tessellator.setColorRGBA_F(af2[0], af2[1], af2[2], af2[3]);
            tessellator.addVertex(0.0, 100.0, 0.0);
            int i2 = 16;
            tessellator.setColorRGBA_F(af2[0], af2[1], af2[2], 0.0f);
            for (int j2 = 0; j2 <= i2; ++j2) {
                float f12 = (float)j2 * 3.141593f * 2.0f / (float)i2;
                float f14 = MathHelper.sin(f12);
                float f15 = MathHelper.cos(f12);
                tessellator.addVertex(f14 * 120.0f, f15 * 120.0f, -f15 * 40.0f * af2[3]);
            }
            tessellator.draw();
            GL11.glPopMatrix();
            GL11.glShadeModel(7424);
        }
        GL11.glEnable(3553);
        GL11.glBlendFunc(1, 1);
        GL11.glPushMatrix();
        float f6 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glTranslatef(f6, f9, f10);
        GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(this.worldObj.getCelestialAngle(f2) * 360.0f, 1.0f, 0.0f, 0.0f);
        float f11 = 30.0f;
        GL11.glBindTexture(3553, this.renderEngine.getTexture("/terrain/sun.png"));
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-f11, 100.0, -f11, 0.0, 0.0);
        tessellator.addVertexWithUV(f11, 100.0, -f11, 1.0, 0.0);
        tessellator.addVertexWithUV(f11, 100.0, f11, 1.0, 1.0);
        tessellator.addVertexWithUV(-f11, 100.0, f11, 0.0, 1.0);
        tessellator.draw();
        f11 = 20.0f;
        GL11.glBindTexture(3553, this.renderEngine.getTexture("/terrain/moon.png"));
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(-f11, -100.0, f11, 1.0, 1.0);
        tessellator.addVertexWithUV(f11, -100.0, f11, 0.0, 1.0);
        tessellator.addVertexWithUV(f11, -100.0, -f11, 0.0, 0.0);
        tessellator.addVertexWithUV(-f11, -100.0, -f11, 1.0, 0.0);
        tessellator.draw();
        GL11.glDisable(3553);
        float f13 = this.worldObj.func_679_f(f2);
        if (f13 > 0.0f) {
            GL11.glColor4f(f13, f13, f13, f13);
            GL11.glCallList(this.field_1434_y);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(2912);
        GL11.glPopMatrix();
        GL11.glColor3f(f1 * 0.2f + 0.04f, f22 * 0.2f + 0.04f, f3 * 0.6f + 0.1f);
        GL11.glDisable(3553);
        GL11.glCallList(this.field_1432_A);
        GL11.glEnable(3553);
        GL11.glDepthMask(true);
    }

    public void func_4141_b(float f2) {
        if (this.mc.theWorld.worldProvider.field_4220_c) {
            return;
        }
        if (this.mc.gameSettings.fancyGraphics) {
            this.func_6510_c(f2);
            return;
        }
        GL11.glDisable(2884);
        float f1 = (float)(this.mc.thePlayer.lastTickPosY + (this.mc.thePlayer.posY - this.mc.thePlayer.lastTickPosY) * (double)f2);
        int byte0 = 32;
        int i2 = 256 / byte0;
        Tessellator tessellator = Tessellator.instance;
        GL11.glBindTexture(3553, this.renderEngine.getTexture("/environment/clouds.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        Vec3D vec3d = this.worldObj.func_628_d(f2);
        float f22 = (float)vec3d.xCoord;
        float f3 = (float)vec3d.yCoord;
        float f4 = (float)vec3d.zCoord;
        if (this.mc.gameSettings.anaglyph) {
            float f5 = (f22 * 30.0f + f3 * 59.0f + f4 * 11.0f) / 100.0f;
            float f7 = (f22 * 30.0f + f3 * 70.0f) / 100.0f;
            float f8 = (f22 * 30.0f + f4 * 70.0f) / 100.0f;
            f22 = f5;
            f3 = f7;
            f4 = f8;
        }
        float f6 = 4.882813E-4f;
        double d2 = this.mc.thePlayer.prevPosX + (this.mc.thePlayer.posX - this.mc.thePlayer.prevPosX) * (double)f2 + (double)(((float)this.field_1435_x + f2) * 0.03f);
        double d1 = this.mc.thePlayer.prevPosZ + (this.mc.thePlayer.posZ - this.mc.thePlayer.prevPosZ) * (double)f2;
        int j2 = MathHelper.floor_double(d2 / 2048.0);
        int k2 = MathHelper.floor_double(d1 / 2048.0);
        float f9 = 120.0f - f1 + 0.33f;
        float f10 = (float)((d2 -= (double)(j2 * 2048)) * (double)f6);
        float f11 = (float)((d1 -= (double)(k2 * 2048)) * (double)f6);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(f22, f3, f4, 0.8f);
        for (int l2 = -byte0 * i2; l2 < byte0 * i2; l2 += byte0) {
            for (int i1 = -byte0 * i2; i1 < byte0 * i2; i1 += byte0) {
                tessellator.addVertexWithUV(l2 + 0, f9, i1 + byte0, (float)(l2 + 0) * f6 + f10, (float)(i1 + byte0) * f6 + f11);
                tessellator.addVertexWithUV(l2 + byte0, f9, i1 + byte0, (float)(l2 + byte0) * f6 + f10, (float)(i1 + byte0) * f6 + f11);
                tessellator.addVertexWithUV(l2 + byte0, f9, i1 + 0, (float)(l2 + byte0) * f6 + f10, (float)(i1 + 0) * f6 + f11);
                tessellator.addVertexWithUV(l2 + 0, f9, i1 + 0, (float)(l2 + 0) * f6 + f10, (float)(i1 + 0) * f6 + f11);
            }
        }
        tessellator.draw();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
    }

    public void func_6510_c(float f2) {
        GL11.glDisable(2884);
        float f1 = (float)(this.mc.thePlayer.lastTickPosY + (this.mc.thePlayer.posY - this.mc.thePlayer.lastTickPosY) * (double)f2);
        Tessellator tessellator = Tessellator.instance;
        float f22 = 12.0f;
        float f3 = 4.0f;
        double d2 = (this.mc.thePlayer.prevPosX + (this.mc.thePlayer.posX - this.mc.thePlayer.prevPosX) * (double)f2 + (double)(((float)this.field_1435_x + f2) * 0.03f)) / (double)f22;
        double d1 = (this.mc.thePlayer.prevPosZ + (this.mc.thePlayer.posZ - this.mc.thePlayer.prevPosZ) * (double)f2) / (double)f22 + (double)0.33f;
        float f4 = 108.0f - f1 + 0.33f;
        int i2 = MathHelper.floor_double(d2 / 2048.0);
        int j2 = MathHelper.floor_double(d1 / 2048.0);
        d2 -= (double)(i2 * 2048);
        d1 -= (double)(j2 * 2048);
        GL11.glBindTexture(3553, this.renderEngine.getTexture("/environment/clouds.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        Vec3D vec3d = this.worldObj.func_628_d(f2);
        float f5 = (float)vec3d.xCoord;
        float f6 = (float)vec3d.yCoord;
        float f7 = (float)vec3d.zCoord;
        if (this.mc.gameSettings.anaglyph) {
            float f8 = (f5 * 30.0f + f6 * 59.0f + f7 * 11.0f) / 100.0f;
            float f10 = (f5 * 30.0f + f6 * 70.0f) / 100.0f;
            float f12 = (f5 * 30.0f + f7 * 70.0f) / 100.0f;
            f5 = f8;
            f6 = f10;
            f7 = f12;
        }
        float f9 = (float)(d2 * 0.0);
        float f11 = (float)(d1 * 0.0);
        float f13 = 0.00390625f;
        f9 = (float)MathHelper.floor_double(d2) * f13;
        f11 = (float)MathHelper.floor_double(d1) * f13;
        float f14 = (float)(d2 - (double)MathHelper.floor_double(d2));
        float f15 = (float)(d1 - (double)MathHelper.floor_double(d1));
        int k2 = 8;
        int byte0 = 3;
        float f16 = 9.765625E-4f;
        GL11.glScalef(f22, 1.0f, f22);
        for (int l2 = 0; l2 < 2; ++l2) {
            if (l2 == 0) {
                GL11.glColorMask(false, false, false, false);
            } else {
                GL11.glColorMask(true, true, true, true);
            }
            for (int i1 = -byte0 + 1; i1 <= byte0; ++i1) {
                for (int j1 = -byte0 + 1; j1 <= byte0; ++j1) {
                    tessellator.startDrawingQuads();
                    float f17 = i1 * k2;
                    float f18 = j1 * k2;
                    float f19 = f17 - f14;
                    float f20 = f18 - f15;
                    if (f4 > -f3 - 1.0f) {
                        tessellator.setColorRGBA_F(f5 * 0.7f, f6 * 0.7f, f7 * 0.7f, 0.8f);
                        tessellator.setNormal(0.0f, -1.0f, 0.0f);
                        tessellator.addVertexWithUV(f19 + 0.0f, f4 + 0.0f, f20 + (float)k2, (f17 + 0.0f) * f13 + f9, (f18 + (float)k2) * f13 + f11);
                        tessellator.addVertexWithUV(f19 + (float)k2, f4 + 0.0f, f20 + (float)k2, (f17 + (float)k2) * f13 + f9, (f18 + (float)k2) * f13 + f11);
                        tessellator.addVertexWithUV(f19 + (float)k2, f4 + 0.0f, f20 + 0.0f, (f17 + (float)k2) * f13 + f9, (f18 + 0.0f) * f13 + f11);
                        tessellator.addVertexWithUV(f19 + 0.0f, f4 + 0.0f, f20 + 0.0f, (f17 + 0.0f) * f13 + f9, (f18 + 0.0f) * f13 + f11);
                    }
                    if (f4 <= f3 + 1.0f) {
                        tessellator.setColorRGBA_F(f5, f6, f7, 0.8f);
                        tessellator.setNormal(0.0f, 1.0f, 0.0f);
                        tessellator.addVertexWithUV(f19 + 0.0f, f4 + f3 - f16, f20 + (float)k2, (f17 + 0.0f) * f13 + f9, (f18 + (float)k2) * f13 + f11);
                        tessellator.addVertexWithUV(f19 + (float)k2, f4 + f3 - f16, f20 + (float)k2, (f17 + (float)k2) * f13 + f9, (f18 + (float)k2) * f13 + f11);
                        tessellator.addVertexWithUV(f19 + (float)k2, f4 + f3 - f16, f20 + 0.0f, (f17 + (float)k2) * f13 + f9, (f18 + 0.0f) * f13 + f11);
                        tessellator.addVertexWithUV(f19 + 0.0f, f4 + f3 - f16, f20 + 0.0f, (f17 + 0.0f) * f13 + f9, (f18 + 0.0f) * f13 + f11);
                    }
                    tessellator.setColorRGBA_F(f5 * 0.9f, f6 * 0.9f, f7 * 0.9f, 0.8f);
                    if (i1 > -1) {
                        tessellator.setNormal(-1.0f, 0.0f, 0.0f);
                        for (int k1 = 0; k1 < k2; ++k1) {
                            tessellator.addVertexWithUV(f19 + (float)k1 + 0.0f, f4 + 0.0f, f20 + (float)k2, (f17 + (float)k1 + 0.5f) * f13 + f9, (f18 + (float)k2) * f13 + f11);
                            tessellator.addVertexWithUV(f19 + (float)k1 + 0.0f, f4 + f3, f20 + (float)k2, (f17 + (float)k1 + 0.5f) * f13 + f9, (f18 + (float)k2) * f13 + f11);
                            tessellator.addVertexWithUV(f19 + (float)k1 + 0.0f, f4 + f3, f20 + 0.0f, (f17 + (float)k1 + 0.5f) * f13 + f9, (f18 + 0.0f) * f13 + f11);
                            tessellator.addVertexWithUV(f19 + (float)k1 + 0.0f, f4 + 0.0f, f20 + 0.0f, (f17 + (float)k1 + 0.5f) * f13 + f9, (f18 + 0.0f) * f13 + f11);
                        }
                    }
                    if (i1 <= 1) {
                        tessellator.setNormal(1.0f, 0.0f, 0.0f);
                        for (int l1 = 0; l1 < k2; ++l1) {
                            tessellator.addVertexWithUV(f19 + (float)l1 + 1.0f - f16, f4 + 0.0f, f20 + (float)k2, (f17 + (float)l1 + 0.5f) * f13 + f9, (f18 + (float)k2) * f13 + f11);
                            tessellator.addVertexWithUV(f19 + (float)l1 + 1.0f - f16, f4 + f3, f20 + (float)k2, (f17 + (float)l1 + 0.5f) * f13 + f9, (f18 + (float)k2) * f13 + f11);
                            tessellator.addVertexWithUV(f19 + (float)l1 + 1.0f - f16, f4 + f3, f20 + 0.0f, (f17 + (float)l1 + 0.5f) * f13 + f9, (f18 + 0.0f) * f13 + f11);
                            tessellator.addVertexWithUV(f19 + (float)l1 + 1.0f - f16, f4 + 0.0f, f20 + 0.0f, (f17 + (float)l1 + 0.5f) * f13 + f9, (f18 + 0.0f) * f13 + f11);
                        }
                    }
                    tessellator.setColorRGBA_F(f5 * 0.8f, f6 * 0.8f, f7 * 0.8f, 0.8f);
                    if (j1 > -1) {
                        tessellator.setNormal(0.0f, 0.0f, -1.0f);
                        for (int i22 = 0; i22 < k2; ++i22) {
                            tessellator.addVertexWithUV(f19 + 0.0f, f4 + f3, f20 + (float)i22 + 0.0f, (f17 + 0.0f) * f13 + f9, (f18 + (float)i22 + 0.5f) * f13 + f11);
                            tessellator.addVertexWithUV(f19 + (float)k2, f4 + f3, f20 + (float)i22 + 0.0f, (f17 + (float)k2) * f13 + f9, (f18 + (float)i22 + 0.5f) * f13 + f11);
                            tessellator.addVertexWithUV(f19 + (float)k2, f4 + 0.0f, f20 + (float)i22 + 0.0f, (f17 + (float)k2) * f13 + f9, (f18 + (float)i22 + 0.5f) * f13 + f11);
                            tessellator.addVertexWithUV(f19 + 0.0f, f4 + 0.0f, f20 + (float)i22 + 0.0f, (f17 + 0.0f) * f13 + f9, (f18 + (float)i22 + 0.5f) * f13 + f11);
                        }
                    }
                    if (j1 <= 1) {
                        tessellator.setNormal(0.0f, 0.0f, 1.0f);
                        for (int j22 = 0; j22 < k2; ++j22) {
                            tessellator.addVertexWithUV(f19 + 0.0f, f4 + f3, f20 + (float)j22 + 1.0f - f16, (f17 + 0.0f) * f13 + f9, (f18 + (float)j22 + 0.5f) * f13 + f11);
                            tessellator.addVertexWithUV(f19 + (float)k2, f4 + f3, f20 + (float)j22 + 1.0f - f16, (f17 + (float)k2) * f13 + f9, (f18 + (float)j22 + 0.5f) * f13 + f11);
                            tessellator.addVertexWithUV(f19 + (float)k2, f4 + 0.0f, f20 + (float)j22 + 1.0f - f16, (f17 + (float)k2) * f13 + f9, (f18 + (float)j22 + 0.5f) * f13 + f11);
                            tessellator.addVertexWithUV(f19 + 0.0f, f4 + 0.0f, f20 + (float)j22 + 1.0f - f16, (f17 + 0.0f) * f13 + f9, (f18 + (float)j22 + 0.5f) * f13 + f11);
                        }
                    }
                    tessellator.draw();
                }
            }
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
    }

    public boolean func_948_a(EntityPlayer entityplayer, boolean flag) {
        Collections.sort(this.field_1446_m, new RenderSorter(entityplayer));
        int i2 = this.field_1446_m.size() - 1;
        int j2 = this.field_1446_m.size();
        for (int k2 = 0; k2 < j2; ++k2) {
            WorldRenderer worldrenderer = (WorldRenderer)this.field_1446_m.get(i2 - k2);
            if (!flag) {
                if (worldrenderer.func_1202_a(entityplayer) > 1024.0f && (worldrenderer.field_1749_o ? k2 >= 3 : k2 >= 1)) {
                    return false;
                }
            } else if (!worldrenderer.field_1749_o) continue;
            worldrenderer.func_1198_a();
            this.field_1446_m.remove(worldrenderer);
            worldrenderer.needsUpdate = false;
        }
        return this.field_1446_m.size() == 0;
    }

    public void func_959_a(EntityPlayer entityplayer, MovingObjectPosition movingobjectposition, int i2, ItemStack itemstack, float f2) {
        Tessellator tessellator = Tessellator.instance;
        GL11.glEnable(3042);
        GL11.glEnable(3008);
        GL11.glBlendFunc(770, 1);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, (MathHelper.sin((float)System.currentTimeMillis() / 100.0f) * 0.2f + 0.4f) * 0.5f);
        if (i2 == 0) {
            if (this.field_1450_i > 0.0f) {
                GL11.glBlendFunc(774, 768);
                int j2 = this.renderEngine.getTexture("/terrain.png");
                GL11.glBindTexture(3553, j2);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
                GL11.glPushMatrix();
                int k2 = this.worldObj.getBlockId(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ);
                Block block = k2 <= 0 ? null : Block.blocksList[k2];
                GL11.glDisable(3008);
                GL11.glPolygonOffset(-3.0f, -3.0f);
                GL11.glEnable(32823);
                tessellator.startDrawingQuads();
                double d2 = entityplayer.lastTickPosX + (entityplayer.posX - entityplayer.lastTickPosX) * (double)f2;
                double d1 = entityplayer.lastTickPosY + (entityplayer.posY - entityplayer.lastTickPosY) * (double)f2;
                double d22 = entityplayer.lastTickPosZ + (entityplayer.posZ - entityplayer.lastTickPosZ) * (double)f2;
                tessellator.setTranslationD(-d2, -d1, -d22);
                tessellator.disableColor();
                if (block == null) {
                    block = Block.stone;
                }
                this.field_1438_u.renderBlockUsingTexture(block, movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ, 240 + (int)(this.field_1450_i * 10.0f));
                tessellator.draw();
                tessellator.setTranslationD(0.0, 0.0, 0.0);
                GL11.glPolygonOffset(0.0f, 0.0f);
                GL11.glDisable(32823);
                GL11.glEnable(3008);
                GL11.glDepthMask(true);
                GL11.glPopMatrix();
            }
        } else if (itemstack != null) {
            GL11.glBlendFunc(770, 771);
            float f1 = MathHelper.sin((float)System.currentTimeMillis() / 100.0f) * 0.2f + 0.8f;
            GL11.glColor4f(f1, f1, f1, MathHelper.sin((float)System.currentTimeMillis() / 200.0f) * 0.2f + 0.5f);
            int l2 = this.renderEngine.getTexture("/terrain.png");
            GL11.glBindTexture(3553, l2);
            int i1 = movingobjectposition.blockX;
            int j1 = movingobjectposition.blockY;
            int k1 = movingobjectposition.blockZ;
            if (movingobjectposition.sideHit == 0) {
                --j1;
            }
            if (movingobjectposition.sideHit == 1) {
                ++j1;
            }
            if (movingobjectposition.sideHit == 2) {
                --k1;
            }
            if (movingobjectposition.sideHit == 3) {
                ++k1;
            }
            if (movingobjectposition.sideHit == 4) {
                --i1;
            }
            if (movingobjectposition.sideHit == 5) {
                ++i1;
            }
        }
        GL11.glDisable(3042);
        GL11.glDisable(3008);
    }

    public void drawSelectionBox(EntityPlayer entityplayer, MovingObjectPosition movingobjectposition, int i2, ItemStack itemstack, float f2) {
        if (i2 == 0 && movingobjectposition.typeOfHit == 0) {
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.4f);
            GL11.glLineWidth(2.0f);
            GL11.glDisable(3553);
            GL11.glDepthMask(false);
            float f1 = 0.002f;
            int j2 = this.worldObj.getBlockId(movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ);
            if (j2 > 0) {
                Block.blocksList[j2].setBlockBoundsBasedOnState(this.worldObj, movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ);
                double d2 = entityplayer.lastTickPosX + (entityplayer.posX - entityplayer.lastTickPosX) * (double)f2;
                double d1 = entityplayer.lastTickPosY + (entityplayer.posY - entityplayer.lastTickPosY) * (double)f2;
                double d22 = entityplayer.lastTickPosZ + (entityplayer.posZ - entityplayer.lastTickPosZ) * (double)f2;
                this.drawOutlinedBoundingBox(Block.blocksList[j2].getSelectedBoundingBoxFromPool(this.worldObj, movingobjectposition.blockX, movingobjectposition.blockY, movingobjectposition.blockZ).expands(f1, f1, f1).getOffsetBoundingBox(-d2, -d1, -d22));
            }
            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
        }
    }

    private void drawOutlinedBoundingBox(AxisAlignedBB axisalignedbb) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawing(3);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.draw();
        tessellator.startDrawing(3);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.draw();
        tessellator.startDrawing(1);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.minZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.maxZ);
        tessellator.addVertex(axisalignedbb.minX, axisalignedbb.maxY, axisalignedbb.maxZ);
        tessellator.draw();
    }

    public void func_949_a(int i2, int j2, int k2, int l2, int i1, int j1) {
        int k1 = MathHelper.bucketInt(i2, 16);
        int l1 = MathHelper.bucketInt(j2, 16);
        int i22 = MathHelper.bucketInt(k2, 16);
        int j22 = MathHelper.bucketInt(l2, 16);
        int k22 = MathHelper.bucketInt(i1, 16);
        int l22 = MathHelper.bucketInt(j1, 16);
        for (int i3 = k1; i3 <= j22; ++i3) {
            int j3 = i3 % this.field_1443_p;
            if (j3 < 0) {
                j3 += this.field_1443_p;
            }
            for (int k3 = l1; k3 <= k22; ++k3) {
                int l3 = k3 % this.field_1442_q;
                if (l3 < 0) {
                    l3 += this.field_1442_q;
                }
                for (int i4 = i22; i4 <= l22; ++i4) {
                    int j4 = i4 % this.field_1441_r;
                    if (j4 < 0) {
                        j4 += this.field_1441_r;
                    }
                    int k4 = (j4 * this.field_1442_q + l3) * this.field_1443_p + j3;
                    WorldRenderer worldrenderer = this.field_1444_o[k4];
                    if (!worldrenderer.needsUpdate) {
                        this.field_1446_m.add(worldrenderer);
                    }
                    worldrenderer.MarkDirty();
                }
            }
        }
    }

    @Override
    public void func_934_a(int i2, int j2, int k2) {
        this.func_949_a(i2 - 1, j2 - 1, k2 - 1, i2 + 1, j2 + 1, k2 + 1);
    }

    @Override
    public void func_937_b(int i2, int j2, int k2, int l2, int i1, int j1) {
        this.func_949_a(i2 - 1, j2 - 1, k2 - 1, l2 + 1, i1 + 1, j1 + 1);
    }

    public void func_960_a(ICamera icamera, float f2) {
        for (int i2 = 0; i2 < this.field_1444_o.length; ++i2) {
            if (this.field_1444_o[i2].func_1196_e() || this.field_1444_o[i2].field_1749_o && (i2 + this.field_1449_j & 0xF) != 0) continue;
            this.field_1444_o[i2].func_1199_a(icamera);
        }
        ++this.field_1449_j;
    }

    @Override
    public void playRecord(String s2, int i2, int j2, int k2) {
        if (s2 != null) {
            this.mc.ingameGUI.func_553_b("C418 - " + s2);
        }
        this.mc.sndManager.func_331_a(s2, i2, j2, k2, 1.0f, 1.0f);
    }

    @Override
    public void playSound(String s2, double d2, double d1, double d22, float f2, float f1) {
        float f22 = 16.0f;
        if (f2 > 1.0f) {
            f22 *= f2;
        }
        if (this.mc.thePlayer.getDistanceSq(d2, d1, d22) < (double)(f22 * f22)) {
            this.mc.sndManager.func_336_b(s2, (float)d2, (float)d1, (float)d22, f2, f1);
        }
    }

    @Override
    public void spawnParticle(String s2, double d2, double d1, double d22, double d3, double d4, double d5) {
        double d6 = this.mc.thePlayer.posX - d2;
        double d7 = this.mc.thePlayer.posY - d1;
        double d8 = this.mc.thePlayer.posZ - d22;
        if (d6 * d6 + d7 * d7 + d8 * d8 > 256.0) {
            return;
        }
        if (s2 == "bubble") {
            this.mc.field_6321_h.func_1192_a(new EntityBubbleFX(this.worldObj, d2, d1, d22, d3, d4, d5));
        } else if (s2 == "smoke") {
            this.mc.field_6321_h.func_1192_a(new EntitySmokeFX(this.worldObj, d2, d1, d22));
        } else if (s2 == "portal") {
            this.mc.field_6321_h.func_1192_a(new EntityPortalFX(this.worldObj, d2, d1, d22, d3, d4, d5));
        } else if (s2 == "explode") {
            this.mc.field_6321_h.func_1192_a(new EntityExplodeFX(this.worldObj, d2, d1, d22, d3, d4, d5));
        } else if (s2 == "flame") {
            this.mc.field_6321_h.func_1192_a(new EntityFlameFX(this.worldObj, d2, d1, d22, d3, d4, d5));
        } else if (s2 == "lava") {
            this.mc.field_6321_h.func_1192_a(new EntityLavaFX(this.worldObj, d2, d1, d22));
        } else if (s2 == "splash") {
            this.mc.field_6321_h.func_1192_a(new EntitySplashFX(this.worldObj, d2, d1, d22, d3, d4, d5));
        } else if (s2 == "largesmoke") {
            this.mc.field_6321_h.func_1192_a(new EntitySmokeFX(this.worldObj, d2, d1, d22, 2.5f));
        } else if (s2 == "reddust") {
            this.mc.field_6321_h.func_1192_a(new EntityReddustFX(this.worldObj, d2, d1, d22));
        } else if (s2 == "snowballpoof") {
            this.mc.field_6321_h.func_1192_a(new EntitySlimeFX(this.worldObj, d2, d1, d22, Item.snowball));
        } else if (s2 == "slime") {
            this.mc.field_6321_h.func_1192_a(new EntitySlimeFX(this.worldObj, d2, d1, d22, Item.slimeBall));
        }
    }

    @Override
    public void obtainEntitySkin(Entity entity) {
        if (entity.skinUrl != null) {
            this.renderEngine.obtainImageData(entity.skinUrl, new ImageBufferDownload());
        }
    }

    @Override
    public void releaseEntitySkin(Entity entity) {
        if (entity.skinUrl != null) {
            this.renderEngine.releaseImageData(entity.skinUrl);
        }
    }

    @Override
    public void func_936_e() {
        for (int i2 = 0; i2 < this.field_1444_o.length; ++i2) {
            if (!this.field_1444_o[i2].field_1747_A) continue;
            if (!this.field_1444_o[i2].needsUpdate) {
                this.field_1446_m.add(this.field_1444_o[i2]);
            }
            this.field_1444_o[i2].MarkDirty();
        }
    }

    @Override
    public void func_935_a(int i2, int j2, int k2, TileEntity tileentity) {
    }
}

