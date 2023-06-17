/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Arrays;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.MobSpawnerBase;
import net.minecraft.src.WorldChunkManager;

public class WorldChunkManagerHell
extends WorldChunkManager {
    private MobSpawnerBase field_4201_e;
    private double field_4200_f;
    private double field_4199_g;

    public WorldChunkManagerHell(MobSpawnerBase mobspawnerbase, double d2, double d1) {
        this.field_4201_e = mobspawnerbase;
        this.field_4200_f = d2;
        this.field_4199_g = d1;
    }

    @Override
    public MobSpawnerBase func_4074_a(ChunkCoordIntPair chunkcoordintpair) {
        return this.field_4201_e;
    }

    @Override
    public MobSpawnerBase func_4073_a(int i2, int j2) {
        return this.field_4201_e;
    }

    @Override
    public double func_4072_b(int i2, int j2) {
        return this.field_4200_f;
    }

    @Override
    public MobSpawnerBase[] func_4069_a(int i2, int j2, int k2, int l2) {
        this.field_4195_d = this.loadBlockGeneratorData(this.field_4195_d, i2, j2, k2, l2);
        return this.field_4195_d;
    }

    @Override
    public double[] getTemperatures(double[] ad2, int i2, int j2, int k2, int l2) {
        if (ad2 == null || ad2.length < k2 * l2) {
            ad2 = new double[k2 * l2];
        }
        Arrays.fill(ad2, 0, k2 * l2, this.field_4200_f);
        return ad2;
    }

    @Override
    public MobSpawnerBase[] loadBlockGeneratorData(MobSpawnerBase[] amobspawnerbase, int i2, int j2, int k2, int l2) {
        if (amobspawnerbase == null || amobspawnerbase.length < k2 * l2) {
            amobspawnerbase = new MobSpawnerBase[k2 * l2];
            this.temperature = new double[k2 * l2];
            this.humidity = new double[k2 * l2];
        }
        Arrays.fill(amobspawnerbase, 0, k2 * l2, this.field_4201_e);
        Arrays.fill(this.humidity, 0, k2 * l2, this.field_4199_g);
        Arrays.fill(this.temperature, 0, k2 * l2, this.field_4200_f);
        return amobspawnerbase;
    }
}

