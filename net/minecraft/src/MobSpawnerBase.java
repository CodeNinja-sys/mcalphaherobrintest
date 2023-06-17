/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.Color;
import net.minecraft.src.Block;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityCow;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityPig;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.MobSpawnerDesert;
import net.minecraft.src.MobSpawnerHell;
import net.minecraft.src.MobSpawnerSwamp;

public class MobSpawnerBase {
    public static final MobSpawnerBase rainforest = new MobSpawnerBase().func_4123_b(588342).setBiomeName("Rainforest").func_4124_a(2094168);
    public static final MobSpawnerBase swampland = new MobSpawnerSwamp().func_4123_b(522674).setBiomeName("Swampland").func_4124_a(9154376);
    public static final MobSpawnerBase seasonalForest = new MobSpawnerBase().func_4123_b(10215459).setBiomeName("Seasonal Forest");
    public static final MobSpawnerBase forest = new MobSpawnerBase().func_4123_b(353825).setBiomeName("Forest").func_4124_a(5159473);
    public static final MobSpawnerBase savanna = new MobSpawnerDesert().func_4123_b(14278691).setBiomeName("Savanna");
    public static final MobSpawnerBase shrubland = new MobSpawnerBase().func_4123_b(10595616).setBiomeName("Shrubland");
    public static final MobSpawnerBase taiga = new MobSpawnerBase().func_4123_b(3060051).setBiomeName("Taiga").func_4122_b().func_4124_a(8107825);
    public static final MobSpawnerBase desert = new MobSpawnerDesert().func_4123_b(16421912).setBiomeName("Desert");
    public static final MobSpawnerBase plains = new MobSpawnerDesert().func_4123_b(16767248).setBiomeName("Plains");
    public static final MobSpawnerBase iceDesert = new MobSpawnerDesert().func_4123_b(16772499).setBiomeName("Ice Desert").func_4122_b().func_4124_a(12899129);
    public static final MobSpawnerBase tundra = new MobSpawnerBase().func_4123_b(5762041).setBiomeName("Tundra").func_4122_b().func_4124_a(12899129);
    public static final MobSpawnerBase hell = new MobSpawnerHell().func_4123_b(0xFF0000).setBiomeName("Hell");
    public String biomeName;
    public int field_6503_n;
    public byte topBlock;
    public byte fillerBlock;
    public int field_6502_q;
    protected Class[] biomeMonsters;
    protected Class[] biomeCreatures;
    private static MobSpawnerBase[] biomeLookupTable = new MobSpawnerBase[4096];

    static {
        MobSpawnerBase.generateBiomeLookup();
    }

    public MobSpawnerBase() {
        this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.field_6502_q = 5169201;
        this.biomeMonsters = new Class[]{EntitySpider.class, EntityZombie.class, EntitySkeleton.class, EntityCreeper.class};
        this.biomeCreatures = new Class[]{EntitySheep.class, EntityPig.class, EntityChicken.class, EntityCow.class};
    }

    public static void generateBiomeLookup() {
        for (int i2 = 0; i2 < 64; ++i2) {
            for (int j2 = 0; j2 < 64; ++j2) {
                MobSpawnerBase.biomeLookupTable[i2 + j2 * 64] = MobSpawnerBase.getBiome((float)i2 / 63.0f, (float)j2 / 63.0f);
            }
        }
        MobSpawnerBase.desert.topBlock = MobSpawnerBase.desert.fillerBlock = (byte)Block.sand.blockID;
        MobSpawnerBase.iceDesert.topBlock = MobSpawnerBase.iceDesert.fillerBlock = (byte)Block.sand.blockID;
    }

    protected MobSpawnerBase func_4122_b() {
        return this;
    }

    protected MobSpawnerBase setBiomeName(String s2) {
        this.biomeName = s2;
        return this;
    }

    protected MobSpawnerBase func_4124_a(int i2) {
        this.field_6502_q = i2;
        return this;
    }

    protected MobSpawnerBase func_4123_b(int i2) {
        this.field_6503_n = i2;
        return this;
    }

    public static MobSpawnerBase getBiomeFromLookup(double d2, double d1) {
        int i2 = (int)(d2 * 63.0);
        int j2 = (int)(d1 * 63.0);
        return biomeLookupTable[i2 + j2 * 64];
    }

    public static MobSpawnerBase getBiome(float f2, float f1) {
        f1 *= f2;
        if (f2 < 0.1f) {
            return tundra;
        }
        if (f1 < 0.2f) {
            if (f2 < 0.5f) {
                return tundra;
            }
            if (f2 < 0.95f) {
                return savanna;
            }
            return desert;
        }
        if (f1 > 0.5f && f2 < 0.7f) {
            return swampland;
        }
        if (f2 < 0.5f) {
            return taiga;
        }
        if (f2 < 0.97f) {
            if (f1 < 0.35f) {
                return shrubland;
            }
            return forest;
        }
        if (f1 < 0.45f) {
            return plains;
        }
        if (f1 < 0.9f) {
            return seasonalForest;
        }
        return rainforest;
    }

    public int getSkyColorByTemp(float f2) {
        if ((f2 /= 3.0f) < -1.0f) {
            f2 = -1.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        return Color.getHSBColor(0.6222222f - f2 * 0.05f, 0.5f + f2 * 0.1f, 1.0f).getRGB();
    }

    public Class[] getEntitiesForType(EnumCreatureType enumcreaturetype) {
        if (enumcreaturetype == EnumCreatureType.monster) {
            return this.biomeMonsters;
        }
        if (enumcreaturetype == EnumCreatureType.creature) {
            return this.biomeCreatures;
        }
        return null;
    }
}

