/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.File;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkLoader;
import net.minecraft.src.ChunkProviderGenerate;
import net.minecraft.src.IChunkLoader;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;
import net.minecraft.src.WorldChunkManager;
import net.minecraft.src.WorldProviderHell;

public class WorldProvider {
    public World worldObj;
    public WorldChunkManager worldChunkMgr;
    public boolean field_4220_c = false;
    public boolean field_6479_d = false;
    public boolean field_6478_e = false;
    public float[] lightBrightnessTable = new float[16];
    public int field_4218_e = 0;
    private float[] field_4217_f = new float[4];

    public final void registerWorld(World world) {
        this.worldObj = world;
        this.registerWorldChunkManager();
        this.generateLightBrightnessTable();
    }

    protected void generateLightBrightnessTable() {
        float f2 = 0.05f;
        for (int i2 = 0; i2 <= 15; ++i2) {
            float f1 = 1.0f - (float)i2 / 15.0f;
            this.lightBrightnessTable[i2] = (1.0f - f1) / (f1 * 3.0f + 1.0f) * (1.0f - f2) + f2;
        }
    }

    protected void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManager(this.worldObj);
    }

    public IChunkProvider getChunkProvider() {
        return new ChunkProviderGenerate(this.worldObj, this.worldObj.randomSeed);
    }

    public IChunkLoader getChunkLoader(File file) {
        return new ChunkLoader(file, true);
    }

    public boolean canCoordinateBeSpawn(int i2, int j2) {
        int k2 = this.worldObj.func_614_g(i2, j2);
        return k2 == Block.sand.blockID;
    }

    public float calculateCelestialAngle(long l2, float f2) {
        int i2 = (int)(l2 % 24000L);
        float f1 = ((float)i2 + f2) / 24000.0f - 0.25f;
        if (f1 < 0.0f) {
            f1 += 1.0f;
        }
        if (f1 > 1.0f) {
            f1 -= 1.0f;
        }
        float f22 = f1;
        f1 = 1.0f - (float)((Math.cos((double)f1 * Math.PI) + 1.0) / 2.0);
        f1 = f22 + (f1 - f22) / 3.0f;
        return f1;
    }

    public float[] func_4097_b(float f2, float f1) {
        float f4;
        float f22 = 0.4f;
        float f3 = MathHelper.cos(f2 * 3.141593f * 2.0f) - 0.0f;
        if (f3 >= (f4 = -0.0f) - f22 && f3 <= f4 + f22) {
            float f5 = (f3 - f4) / f22 * 0.5f + 0.5f;
            float f6 = 1.0f - (1.0f - MathHelper.sin(f5 * 3.141593f)) * 0.99f;
            f6 *= f6;
            this.field_4217_f[0] = f5 * 0.3f + 0.7f;
            this.field_4217_f[1] = f5 * f5 * 0.7f + 0.2f;
            this.field_4217_f[2] = f5 * f5 * 0.0f + 0.2f;
            this.field_4217_f[3] = f6;
            return this.field_4217_f;
        }
        return null;
    }

    public Vec3D func_4096_a(float f2, float f1) {
        float f22 = MathHelper.cos(f2 * 3.141593f * 2.0f) * 2.0f + 0.5f;
        if (f22 < 0.0f) {
            f22 = 0.0f;
        }
        if (f22 > 1.0f) {
            f22 = 1.0f;
        }
        float f3 = 0.7529412f;
        float f4 = 0.8470588f;
        float f5 = 1.0f;
        return Vec3D.createVector(f3 *= f22 * 0.94f + 0.06f, f4 *= f22 * 0.94f + 0.06f, f5 *= f22 * 0.91f + 0.09f);
    }

    public boolean func_6477_d() {
        return true;
    }

    public static WorldProvider func_4101_a(int i2) {
        if (i2 == 0) {
            return new WorldProvider();
        }
        if (i2 == -1) {
            return new WorldProviderHell();
        }
        return null;
    }
}

