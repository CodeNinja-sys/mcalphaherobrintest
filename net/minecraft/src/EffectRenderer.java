/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityDiggingFX;
import net.minecraft.src.EntityFX;
import net.minecraft.src.MathHelper;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class EffectRenderer {
    protected World worldObj;
    private List[] field_1728_b = new List[4];
    private RenderEngine field_1731_c;
    private Random rand = new Random();

    public EffectRenderer(World world, RenderEngine renderengine) {
        if (world != null) {
            this.worldObj = world;
        }
        this.field_1731_c = renderengine;
        for (int i2 = 0; i2 < 4; ++i2) {
            this.field_1728_b[i2] = new ArrayList();
        }
    }

    public void func_1192_a(EntityFX entityfx) {
        int i2 = entityfx.func_404_c();
        this.field_1728_b[i2].add(entityfx);
    }

    public void func_1193_a() {
        for (int i2 = 0; i2 < 4; ++i2) {
            for (int j2 = 0; j2 < this.field_1728_b[i2].size(); ++j2) {
                EntityFX entityfx = (EntityFX)this.field_1728_b[i2].get(j2);
                entityfx.onUpdate();
                if (!entityfx.isDead) continue;
                this.field_1728_b[i2].remove(j2--);
            }
        }
    }

    public void func_1189_a(Entity entity, float f2) {
        float f1 = MathHelper.cos(entity.rotationYaw * 3.141593f / 180.0f);
        float f22 = MathHelper.sin(entity.rotationYaw * 3.141593f / 180.0f);
        float f3 = -f22 * MathHelper.sin(entity.rotationPitch * 3.141593f / 180.0f);
        float f4 = f1 * MathHelper.sin(entity.rotationPitch * 3.141593f / 180.0f);
        float f5 = MathHelper.cos(entity.rotationPitch * 3.141593f / 180.0f);
        EntityFX.field_660_l = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f2;
        EntityFX.field_659_m = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f2;
        EntityFX.field_658_n = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f2;
        for (int i2 = 0; i2 < 3; ++i2) {
            if (this.field_1728_b[i2].size() == 0) continue;
            int j2 = 0;
            if (i2 == 0) {
                j2 = this.field_1731_c.getTexture("/particles.png");
            }
            if (i2 == 1) {
                j2 = this.field_1731_c.getTexture("/terrain.png");
            }
            if (i2 == 2) {
                j2 = this.field_1731_c.getTexture("/gui/items.png");
            }
            GL11.glBindTexture(3553, j2);
            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawingQuads();
            for (int k2 = 0; k2 < this.field_1728_b[i2].size(); ++k2) {
                EntityFX entityfx = (EntityFX)this.field_1728_b[i2].get(k2);
                entityfx.func_406_a(tessellator, f2, f1, f5, f22, f3, f4);
            }
            tessellator.draw();
        }
    }

    public void func_1187_b(Entity entity, float f2) {
        int byte0 = 3;
        if (this.field_1728_b[byte0].size() == 0) {
            return;
        }
        Tessellator tessellator = Tessellator.instance;
        for (int i2 = 0; i2 < this.field_1728_b[byte0].size(); ++i2) {
            EntityFX entityfx = (EntityFX)this.field_1728_b[byte0].get(i2);
            entityfx.func_406_a(tessellator, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void func_1188_a(World world) {
        this.worldObj = world;
        for (int i2 = 0; i2 < 4; ++i2) {
            this.field_1728_b[i2].clear();
        }
    }

    public void func_1186_a(int i2, int j2, int k2) {
        int l2 = this.worldObj.getBlockId(i2, j2, k2);
        if (l2 == 0) {
            return;
        }
        Block block = Block.blocksList[l2];
        int i1 = 4;
        for (int j1 = 0; j1 < i1; ++j1) {
            for (int k1 = 0; k1 < i1; ++k1) {
                for (int l1 = 0; l1 < i1; ++l1) {
                    double d2 = (double)i2 + ((double)j1 + 0.5) / (double)i1;
                    double d1 = (double)j2 + ((double)k1 + 0.5) / (double)i1;
                    double d22 = (double)k2 + ((double)l1 + 0.5) / (double)i1;
                    this.func_1192_a(new EntityDiggingFX(this.worldObj, d2, d1, d22, d2 - (double)i2 - 0.5, d1 - (double)j2 - 0.5, d22 - (double)k2 - 0.5, block).func_4041_a(i2, j2, k2));
                }
            }
        }
    }

    public void func_1191_a(int i2, int j2, int k2, int l2) {
        int i1 = this.worldObj.getBlockId(i2, j2, k2);
        if (i1 == 0) {
            return;
        }
        Block block = Block.blocksList[i1];
        float f2 = 0.1f;
        double d2 = (double)i2 + this.rand.nextDouble() * (block.maxX - block.minX - (double)(f2 * 2.0f)) + (double)f2 + block.minX;
        double d1 = (double)j2 + this.rand.nextDouble() * (block.maxY - block.minY - (double)(f2 * 2.0f)) + (double)f2 + block.minY;
        double d22 = (double)k2 + this.rand.nextDouble() * (block.maxZ - block.minZ - (double)(f2 * 2.0f)) + (double)f2 + block.minZ;
        if (l2 == 0) {
            d1 = (double)j2 + block.minY - (double)f2;
        }
        if (l2 == 1) {
            d1 = (double)j2 + block.maxY + (double)f2;
        }
        if (l2 == 2) {
            d22 = (double)k2 + block.minZ - (double)f2;
        }
        if (l2 == 3) {
            d22 = (double)k2 + block.maxZ + (double)f2;
        }
        if (l2 == 4) {
            d2 = (double)i2 + block.minX - (double)f2;
        }
        if (l2 == 5) {
            d2 = (double)i2 + block.maxX + (double)f2;
        }
        this.func_1192_a(new EntityDiggingFX(this.worldObj, d2, d1, d22, 0.0, 0.0, 0.0, block).func_4041_a(i2, j2, k2).func_407_b(0.2f).func_405_d(0.6f));
    }

    public String func_1190_b() {
        return "" + (this.field_1728_b[0].size() + this.field_1728_b[1].size() + this.field_1728_b[2].size());
    }
}

