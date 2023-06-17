/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class Explosion {
    public boolean field_12257_a = false;
    private Random field_12250_h = new Random();
    private World field_12249_i;
    public double field_12256_b;
    public double field_12255_c;
    public double field_12254_d;
    public Entity field_12253_e;
    public float field_12252_f;
    public Set field_12251_g = new HashSet();

    public Explosion(World world, Entity entity, double d2, double d1, double d22, float f2) {
        this.field_12249_i = world;
        this.field_12253_e = entity;
        this.field_12252_f = f2;
        this.field_12256_b = d2;
        this.field_12255_c = d1;
        this.field_12254_d = d22;
    }

    public void func_12248_a() {
        float f2 = this.field_12252_f;
        int i2 = 16;
        for (int j2 = 0; j2 < i2; ++j2) {
            for (int l2 = 0; l2 < i2; ++l2) {
                for (int j1 = 0; j1 < i2; ++j1) {
                    if (j2 != 0 && j2 != i2 - 1 && l2 != 0 && l2 != i2 - 1 && j1 != 0 && j1 != i2 - 1) continue;
                    double d2 = (float)j2 / ((float)i2 - 1.0f) * 2.0f - 1.0f;
                    double d1 = (float)l2 / ((float)i2 - 1.0f) * 2.0f - 1.0f;
                    double d22 = (float)j1 / ((float)i2 - 1.0f) * 2.0f - 1.0f;
                    double d3 = Math.sqrt(d2 * d2 + d1 * d1 + d22 * d22);
                    d2 /= d3;
                    d1 /= d3;
                    d22 /= d3;
                    double d5 = this.field_12256_b;
                    double d7 = this.field_12255_c;
                    double d9 = this.field_12254_d;
                    float f22 = 0.3f;
                    for (float f1 = this.field_12252_f * (0.7f + this.field_12249_i.rand.nextFloat() * 0.6f); !(f1 <= 0.0f); f1 -= f22 * 0.75f) {
                        int l4;
                        int k4;
                        int j4 = MathHelper.floor_double(d5);
                        int i5 = this.field_12249_i.getBlockId(j4, k4 = MathHelper.floor_double(d7), l4 = MathHelper.floor_double(d9));
                        if (i5 > 0) {
                            f1 -= (Block.blocksList[i5].func_227_a(this.field_12253_e) + 0.3f) * f22;
                        }
                        if (f1 > 0.0f) {
                            this.field_12251_g.add(new ChunkPosition(j4, k4, l4));
                        }
                        d5 += d2 * (double)f22;
                        d7 += d1 * (double)f22;
                        d9 += d22 * (double)f22;
                    }
                }
            }
        }
        this.field_12252_f *= 2.0f;
        int k2 = MathHelper.floor_double(this.field_12256_b - (double)this.field_12252_f - 1.0);
        int i1 = MathHelper.floor_double(this.field_12256_b + (double)this.field_12252_f + 1.0);
        int k1 = MathHelper.floor_double(this.field_12255_c - (double)this.field_12252_f - 1.0);
        int l1 = MathHelper.floor_double(this.field_12255_c + (double)this.field_12252_f + 1.0);
        int i22 = MathHelper.floor_double(this.field_12254_d - (double)this.field_12252_f - 1.0);
        int j2 = MathHelper.floor_double(this.field_12254_d + (double)this.field_12252_f + 1.0);
        List list = this.field_12249_i.getEntitiesWithinAABBExcludingEntity(this.field_12253_e, AxisAlignedBB.getBoundingBoxFromPool(k2, k1, i22, i1, l1, j2));
        Vec3D vec3d = Vec3D.createVector(this.field_12256_b, this.field_12255_c, this.field_12254_d);
        for (int k22 = 0; k22 < list.size(); ++k22) {
            Entity entity = (Entity)list.get(k22);
            double d4 = entity.getDistance(this.field_12256_b, this.field_12255_c, this.field_12254_d) / (double)this.field_12252_f;
            if (!(d4 <= 1.0)) continue;
            double d6 = entity.posX - this.field_12256_b;
            double d8 = entity.posY - this.field_12255_c;
            double d10 = entity.posZ - this.field_12254_d;
            double d11 = MathHelper.sqrt_double(d6 * d6 + d8 * d8 + d10 * d10);
            double d12 = this.field_12249_i.func_675_a(vec3d, entity.boundingBox);
            double d13 = (1.0 - d4) * d12;
            entity.canAttackEntity(this.field_12253_e, (int)((d13 * d13 + d13) / 2.0 * 8.0 * (double)this.field_12252_f + 1.0));
            double d14 = d13;
            entity.motionX += (d6 /= d11) * d14;
            entity.motionY += (d8 /= d11) * d14;
            entity.motionZ += (d10 /= d11) * d14;
        }
        this.field_12252_f = f2;
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(this.field_12251_g);
        if (this.field_12257_a) {
            for (int l2 = arraylist.size() - 1; l2 >= 0; --l2) {
                ChunkPosition chunkposition = (ChunkPosition)arraylist.get(l2);
                int i3 = chunkposition.x;
                int j3 = chunkposition.y;
                int k3 = chunkposition.z;
                int l3 = this.field_12249_i.getBlockId(i3, j3, k3);
                int i4 = this.field_12249_i.getBlockId(i3, j3 - 1, k3);
                if (l3 != 0 || !Block.opaqueCubeLookup[i4] || this.field_12250_h.nextInt(3) != 0) continue;
                this.field_12249_i.setBlockWithNotify(i3, j3, k3, Block.fire.blockID);
            }
        }
    }

    public void func_12247_b() {
        this.field_12249_i.playSoundEffect(this.field_12256_b, this.field_12255_c, this.field_12254_d, "random.explode", 4.0f, (1.0f + (this.field_12249_i.rand.nextFloat() - this.field_12249_i.rand.nextFloat()) * 0.2f) * 0.7f);
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(this.field_12251_g);
        for (int i2 = arraylist.size() - 1; i2 >= 0; --i2) {
            ChunkPosition chunkposition = (ChunkPosition)arraylist.get(i2);
            int j2 = chunkposition.x;
            int k2 = chunkposition.y;
            int l2 = chunkposition.z;
            int i1 = this.field_12249_i.getBlockId(j2, k2, l2);
            for (int j1 = 0; j1 < 1; ++j1) {
                double d2 = (float)j2 + this.field_12249_i.rand.nextFloat();
                double d1 = (float)k2 + this.field_12249_i.rand.nextFloat();
                double d22 = (float)l2 + this.field_12249_i.rand.nextFloat();
                double d3 = d2 - this.field_12256_b;
                double d4 = d1 - this.field_12255_c;
                double d5 = d22 - this.field_12254_d;
                double d6 = MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
                d3 /= d6;
                d4 /= d6;
                d5 /= d6;
                double d7 = 0.5 / (d6 / (double)this.field_12252_f + 0.1);
                this.field_12249_i.spawnParticle("explode", (d2 + this.field_12256_b * 1.0) / 2.0, (d1 + this.field_12255_c * 1.0) / 2.0, (d22 + this.field_12254_d * 1.0) / 2.0, d3 *= (d7 *= (double)(this.field_12249_i.rand.nextFloat() * this.field_12249_i.rand.nextFloat() + 0.3f)), d4 *= d7, d5 *= d7);
                this.field_12249_i.spawnParticle("smoke", d2, d1, d22, d3, d4, d5);
            }
            if (i1 <= 0) continue;
            Block.blocksList[i1].dropBlockAsItemWithChance(this.field_12249_i, j2, k2, l2, this.field_12249_i.getBlockMetadata(j2, k2, l2), 0.3f);
            this.field_12249_i.setBlockWithNotify(j2, k2, l2, 0);
            Block.blocksList[i1].onBlockDestroyedByExplosion(this.field_12249_i, j2, k2, l2);
        }
    }
}

