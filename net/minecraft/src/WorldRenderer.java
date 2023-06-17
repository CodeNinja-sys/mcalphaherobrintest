/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCache;
import net.minecraft.src.Entity;
import net.minecraft.src.ICamera;
import net.minecraft.src.MathHelper;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderItem;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityRenderer;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class WorldRenderer {
    public World worldObj;
    private int field_1744_C = -1;
    private static Tessellator field_1742_D;
    public static int field_1762_b;
    public int field_1761_c;
    public int field_1760_d;
    public int field_1759_e;
    public int field_1758_f;
    public int field_1757_g;
    public int field_1756_h;
    public int field_1755_i;
    public int field_1754_j;
    public int field_1753_k;
    public int field_1752_l;
    public int field_1751_m;
    public int field_1750_n;
    public boolean field_1749_o = false;
    public boolean[] field_1748_p = new boolean[2];
    public int field_1746_q;
    public int field_1743_r;
    public int field_1741_s;
    public float field_1740_t;
    public boolean needsUpdate;
    public AxisAlignedBB field_1736_v;
    public int field_1735_w;
    public boolean field_1734_x = true;
    public boolean field_1733_y;
    public int field_1732_z;
    public boolean field_1747_A;
    private boolean field_1739_E = false;
    public List field_1745_B = new ArrayList();
    private List field_1737_F;

    static {
        field_1762_b = 0;
        field_1742_D = Tessellator.instance;
    }

    public WorldRenderer(World world, List list, int i2, int j2, int k2, int l2, int i1) {
        this.worldObj = world;
        this.field_1737_F = list;
        this.field_1757_g = this.field_1756_h = l2;
        this.field_1758_f = this.field_1756_h;
        this.field_1740_t = MathHelper.sqrt_float(this.field_1758_f * this.field_1758_f + this.field_1757_g * this.field_1757_g + this.field_1756_h * this.field_1756_h) / 2.0f;
        this.field_1744_C = i1;
        this.field_1761_c = -999;
        this.func_1197_a(i2, j2, k2);
        this.needsUpdate = false;
    }

    public void func_1197_a(int i2, int j2, int k2) {
        if (i2 == this.field_1761_c && j2 == this.field_1760_d && k2 == this.field_1759_e) {
            return;
        }
        this.func_1195_b();
        this.field_1761_c = i2;
        this.field_1760_d = j2;
        this.field_1759_e = k2;
        this.field_1746_q = i2 + this.field_1758_f / 2;
        this.field_1743_r = j2 + this.field_1757_g / 2;
        this.field_1741_s = k2 + this.field_1756_h / 2;
        this.field_1752_l = i2 & 0x3FF;
        this.field_1751_m = j2;
        this.field_1750_n = k2 & 0x3FF;
        this.field_1755_i = i2 - this.field_1752_l;
        this.field_1754_j = j2 - this.field_1751_m;
        this.field_1753_k = k2 - this.field_1750_n;
        float f2 = 2.0f;
        this.field_1736_v = AxisAlignedBB.getBoundingBox((float)i2 - f2, (float)j2 - f2, (float)k2 - f2, (float)(i2 + this.field_1758_f) + f2, (float)(j2 + this.field_1757_g) + f2, (float)(k2 + this.field_1756_h) + f2);
        GL11.glNewList(this.field_1744_C + 2, 4864);
        RenderItem.renderAABB(AxisAlignedBB.getBoundingBoxFromPool((float)this.field_1752_l - f2, (float)this.field_1751_m - f2, (float)this.field_1750_n - f2, (float)(this.field_1752_l + this.field_1758_f) + f2, (float)(this.field_1751_m + this.field_1757_g) + f2, (float)(this.field_1750_n + this.field_1756_h) + f2));
        GL11.glEndList();
        this.MarkDirty();
    }

    private void func_1203_g() {
        GL11.glTranslatef(this.field_1752_l, this.field_1751_m, this.field_1750_n);
    }

    public void func_1198_a() {
        if (!this.needsUpdate) {
            return;
        }
        ++field_1762_b;
        int i2 = this.field_1761_c;
        int j2 = this.field_1760_d;
        int k2 = this.field_1759_e;
        int l2 = this.field_1761_c + this.field_1758_f;
        int i1 = this.field_1760_d + this.field_1757_g;
        int j1 = this.field_1759_e + this.field_1756_h;
        for (int k1 = 0; k1 < 2; ++k1) {
            this.field_1748_p[k1] = true;
        }
        Chunk.field_1540_a = false;
        HashSet hashset = new HashSet();
        hashset.addAll(this.field_1745_B);
        this.field_1745_B.clear();
        int l1 = 1;
        ChunkCache chunkcache = new ChunkCache(this.worldObj, i2 - l1, j2 - l1, k2 - l1, l2 + l1, i1 + l1, j1 + l1);
        RenderBlocks renderblocks = new RenderBlocks(chunkcache);
        for (int i22 = 0; i22 < 2; ++i22) {
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            for (int j22 = j2; j22 < i1; ++j22) {
                for (int k22 = k2; k22 < j1; ++k22) {
                    for (int l22 = i2; l22 < l2; ++l22) {
                        Block block;
                        int j3;
                        TileEntity tileentity;
                        int i3 = chunkcache.getBlockId(l22, j22, k22);
                        if (i3 <= 0) continue;
                        if (!flag2) {
                            flag2 = true;
                            GL11.glNewList(this.field_1744_C + i22, 4864);
                            GL11.glPushMatrix();
                            this.func_1203_g();
                            float f2 = 1.000001f;
                            GL11.glTranslatef((float)(-this.field_1756_h) / 2.0f, (float)(-this.field_1757_g) / 2.0f, (float)(-this.field_1756_h) / 2.0f);
                            GL11.glScalef(f2, f2, f2);
                            GL11.glTranslatef((float)this.field_1756_h / 2.0f, (float)this.field_1757_g / 2.0f, (float)this.field_1756_h / 2.0f);
                            field_1742_D.startDrawingQuads();
                            field_1742_D.setTranslationD(-this.field_1761_c, -this.field_1760_d, -this.field_1759_e);
                        }
                        if (i22 == 0 && Block.isBlockContainer[i3] && TileEntityRenderer.instance.hasSpecialRenderer(tileentity = chunkcache.getBlockTileEntity(l22, j22, k22))) {
                            this.field_1745_B.add(tileentity);
                        }
                        if ((j3 = (block = Block.blocksList[i3]).func_234_g()) != i22) {
                            flag = true;
                            continue;
                        }
                        if (j3 != i22) continue;
                        flag1 |= renderblocks.renderBlockByRenderType(block, l22, j22, k22);
                    }
                }
            }
            if (flag2) {
                field_1742_D.draw();
                GL11.glPopMatrix();
                GL11.glEndList();
                field_1742_D.setTranslationD(0.0, 0.0, 0.0);
            } else {
                flag1 = false;
            }
            if (flag1) {
                this.field_1748_p[i22] = false;
            }
            if (!flag) break;
        }
        HashSet hashset1 = new HashSet();
        hashset1.addAll(this.field_1745_B);
        hashset1.removeAll(hashset);
        this.field_1737_F.addAll(hashset1);
        hashset.removeAll(this.field_1745_B);
        this.field_1737_F.removeAll(hashset);
        this.field_1747_A = Chunk.field_1540_a;
        this.field_1739_E = true;
    }

    public float func_1202_a(Entity entity) {
        float f2 = (float)(entity.posX - (double)this.field_1746_q);
        float f1 = (float)(entity.posY - (double)this.field_1743_r);
        float f22 = (float)(entity.posZ - (double)this.field_1741_s);
        return f2 * f2 + f1 * f1 + f22 * f22;
    }

    public void func_1195_b() {
        for (int i2 = 0; i2 < 2; ++i2) {
            this.field_1748_p[i2] = true;
        }
        this.field_1749_o = false;
        this.field_1739_E = false;
    }

    public void func_1204_c() {
        this.func_1195_b();
        this.worldObj = null;
    }

    public int func_1200_a(int i2) {
        if (!this.field_1749_o) {
            return -1;
        }
        if (!this.field_1748_p[i2]) {
            return this.field_1744_C + i2;
        }
        return -1;
    }

    public void func_1199_a(ICamera icamera) {
        this.field_1749_o = icamera.func_342_a(this.field_1736_v);
    }

    public void func_1201_d() {
        GL11.glCallList(this.field_1744_C + 2);
    }

    public boolean func_1196_e() {
        if (!this.field_1739_E) {
            return false;
        }
        return this.field_1748_p[0] && this.field_1748_p[1];
    }

    public void MarkDirty() {
        this.needsUpdate = true;
    }
}

