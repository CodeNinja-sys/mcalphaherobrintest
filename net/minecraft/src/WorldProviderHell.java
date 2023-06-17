/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.File;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkLoader;
import net.minecraft.src.ChunkProviderHell;
import net.minecraft.src.IChunkLoader;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.MobSpawnerBase;
import net.minecraft.src.Vec3D;
import net.minecraft.src.WorldChunkManagerHell;
import net.minecraft.src.WorldProvider;

public class WorldProviderHell
extends WorldProvider {
    @Override
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(MobSpawnerBase.hell, 1.0, 0.0);
        this.field_4220_c = true;
        this.field_6479_d = true;
        this.field_6478_e = true;
        this.field_4218_e = -1;
    }

    @Override
    public Vec3D func_4096_a(float f2, float f1) {
        return Vec3D.createVector(0.2f, 0.03f, 0.03f);
    }

    @Override
    protected void generateLightBrightnessTable() {
        float f2 = 0.1f;
        for (int i2 = 0; i2 <= 15; ++i2) {
            float f1 = 1.0f - (float)i2 / 15.0f;
            this.lightBrightnessTable[i2] = (1.0f - f1) / (f1 * 3.0f + 1.0f) * (1.0f - f2) + f2;
        }
    }

    @Override
    public IChunkProvider getChunkProvider() {
        return new ChunkProviderHell(this.worldObj, this.worldObj.randomSeed);
    }

    @Override
    public IChunkLoader getChunkLoader(File file) {
        File file1 = new File(file, "DIM-1");
        file1.mkdirs();
        return new ChunkLoader(file1, true);
    }

    @Override
    public boolean canCoordinateBeSpawn(int i2, int j2) {
        int k2 = this.worldObj.func_614_g(i2, j2);
        if (k2 == Block.bedrock.blockID) {
            return false;
        }
        if (k2 == 0) {
            return false;
        }
        return Block.opaqueCubeLookup[k2];
    }

    @Override
    public float calculateCelestialAngle(long l2, float f2) {
        return 0.5f;
    }

    @Override
    public boolean func_6477_d() {
        return false;
    }
}

