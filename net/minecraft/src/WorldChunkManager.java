/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.MobSpawnerBase;
import net.minecraft.src.NoiseGeneratorOctaves2;
import net.minecraft.src.World;

public class WorldChunkManager {
    private NoiseGeneratorOctaves2 field_4194_e;
    private NoiseGeneratorOctaves2 field_4193_f;
    private NoiseGeneratorOctaves2 field_4192_g;
    public double[] temperature;
    public double[] humidity;
    public double[] field_4196_c;
    public MobSpawnerBase[] field_4195_d;

    protected WorldChunkManager() {
    }

    public WorldChunkManager(World world) {
        this.field_4194_e = new NoiseGeneratorOctaves2(new Random(world.randomSeed * 9871L), 4);
        this.field_4193_f = new NoiseGeneratorOctaves2(new Random(world.randomSeed * 39811L), 4);
        this.field_4192_g = new NoiseGeneratorOctaves2(new Random(world.randomSeed * 543321L), 2);
    }

    public MobSpawnerBase func_4074_a(ChunkCoordIntPair chunkcoordintpair) {
        return this.func_4073_a(chunkcoordintpair.chunkXPos, chunkcoordintpair.chunkZPos);
    }

    public MobSpawnerBase func_4073_a(int i2, int j2) {
        return this.func_4069_a(i2, j2, 1, 1)[0];
    }

    public double func_4072_b(int i2, int j2) {
        this.temperature = this.field_4194_e.func_4112_a(this.temperature, i2, j2, 1, 1, 0.025f, 0.025f, 0.5);
        return this.temperature[0];
    }

    public MobSpawnerBase[] func_4069_a(int i2, int j2, int k2, int l2) {
        this.field_4195_d = this.loadBlockGeneratorData(this.field_4195_d, i2, j2, k2, l2);
        return this.field_4195_d;
    }

    public double[] getTemperatures(double[] ad2, int i2, int j2, int k2, int l2) {
        if (ad2 == null || ad2.length < k2 * l2) {
            ad2 = new double[k2 * l2];
        }
        ad2 = this.field_4194_e.func_4112_a(ad2, i2, j2, k2, k2, 0.025f, 0.025f, 0.25);
        this.field_4196_c = this.field_4192_g.func_4112_a(this.field_4196_c, i2, j2, k2, k2, 0.25, 0.25, 0.5882352941176471);
        int i1 = 0;
        for (int j1 = 0; j1 < k2; ++j1) {
            for (int k1 = 0; k1 < l2; ++k1) {
                double d2 = this.field_4196_c[i1] * 1.1 + 0.5;
                double d1 = 0.01;
                double d22 = 1.0 - d1;
                double d3 = (ad2[i1] * 0.15 + 0.7) * d22 + d2 * d1;
                if ((d3 = 1.0 - (1.0 - d3) * (1.0 - d3)) < 0.0) {
                    d3 = 0.0;
                }
                if (d3 > 1.0) {
                    d3 = 1.0;
                }
                ad2[i1] = d3;
                ++i1;
            }
        }
        return ad2;
    }

    public MobSpawnerBase[] loadBlockGeneratorData(MobSpawnerBase[] amobspawnerbase, int i2, int j2, int k2, int l2) {
        if (amobspawnerbase == null || amobspawnerbase.length < k2 * l2) {
            amobspawnerbase = new MobSpawnerBase[k2 * l2];
        }
        this.temperature = this.field_4194_e.func_4112_a(this.temperature, i2, j2, k2, k2, 0.025f, 0.025f, 0.25);
        this.humidity = this.field_4193_f.func_4112_a(this.humidity, i2, j2, k2, k2, 0.05f, 0.05f, 0.3333333333333333);
        this.field_4196_c = this.field_4192_g.func_4112_a(this.field_4196_c, i2, j2, k2, k2, 0.25, 0.25, 0.5882352941176471);
        int i1 = 0;
        for (int j1 = 0; j1 < k2; ++j1) {
            for (int k1 = 0; k1 < l2; ++k1) {
                double d2 = this.field_4196_c[i1] * 1.1 + 0.5;
                double d1 = 0.01;
                double d22 = 1.0 - d1;
                double d3 = (this.temperature[i1] * 0.15 + 0.7) * d22 + d2 * d1;
                d1 = 0.002;
                d22 = 1.0 - d1;
                double d4 = (this.humidity[i1] * 0.15 + 0.5) * d22 + d2 * d1;
                if ((d3 = 1.0 - (1.0 - d3) * (1.0 - d3)) < 0.0) {
                    d3 = 0.0;
                }
                if (d4 < 0.0) {
                    d4 = 0.0;
                }
                if (d3 > 1.0) {
                    d3 = 1.0;
                }
                if (d4 > 1.0) {
                    d4 = 1.0;
                }
                this.temperature[i1] = d3;
                this.humidity[i1] = d4;
                amobspawnerbase[i1++] = MobSpawnerBase.getBiomeFromLookup(d3, d4);
            }
        }
        return amobspawnerbase;
    }
}

