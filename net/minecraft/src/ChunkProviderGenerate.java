/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockSand;
import net.minecraft.src.Chunk;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.MapGenBase;
import net.minecraft.src.MapGenCaves;
import net.minecraft.src.Material;
import net.minecraft.src.MobSpawnerBase;
import net.minecraft.src.NoiseGeneratorOctaves;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenBigTree;
import net.minecraft.src.WorldGenCactus;
import net.minecraft.src.WorldGenClay;
import net.minecraft.src.WorldGenDungeons;
import net.minecraft.src.WorldGenFlowers;
import net.minecraft.src.WorldGenLakes;
import net.minecraft.src.WorldGenLiquids;
import net.minecraft.src.WorldGenMinable;
import net.minecraft.src.WorldGenPumpkin;
import net.minecraft.src.WorldGenReed;
import net.minecraft.src.WorldGenTrees;
import net.minecraft.src.WorldGenTreesHerobrine;
import net.minecraft.src.WorldGenerator;

public class ChunkProviderGenerate
implements IChunkProvider {
    private Random rand;
    private NoiseGeneratorOctaves field_912_k;
    private NoiseGeneratorOctaves field_911_l;
    private NoiseGeneratorOctaves field_910_m;
    private NoiseGeneratorOctaves field_909_n;
    private NoiseGeneratorOctaves field_908_o;
    public NoiseGeneratorOctaves field_922_a;
    public NoiseGeneratorOctaves field_921_b;
    public NoiseGeneratorOctaves field_920_c;
    private World worldObj;
    private double[] field_4180_q;
    private double[] field_905_r = new double[256];
    private double[] field_904_s = new double[256];
    private double[] field_903_t = new double[256];
    private MapGenBase field_902_u = new MapGenCaves();
    private MobSpawnerBase[] biomesForGeneration;
    double[] field_4185_d;
    double[] field_4184_e;
    double[] field_4183_f;
    double[] field_4182_g;
    double[] field_4181_h;
    int[][] field_914_i = new int[32][32];
    private double[] field_4178_w;

    public ChunkProviderGenerate(World world, long l2) {
        this.worldObj = world;
        this.rand = new Random(l2);
        this.field_912_k = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_911_l = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_910_m = new NoiseGeneratorOctaves(this.rand, 8);
        this.field_909_n = new NoiseGeneratorOctaves(this.rand, 4);
        this.field_908_o = new NoiseGeneratorOctaves(this.rand, 4);
        this.field_922_a = new NoiseGeneratorOctaves(this.rand, 10);
        this.field_921_b = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_920_c = new NoiseGeneratorOctaves(this.rand, 8);
    }

    public void generateTerrain(int i2, int j2, byte[] abyte0, MobSpawnerBase[] amobspawnerbase, double[] ad2) {
        int byte0 = 4;
        int byte1 = 64;
        int k2 = byte0 + 1;
        int byte2 = 17;
        int l2 = byte0 + 1;
        this.field_4180_q = this.func_4061_a(this.field_4180_q, i2 * byte0, 0, j2 * byte0, k2, byte2, l2);
        for (int i1 = 0; i1 < byte0; ++i1) {
            for (int j1 = 0; j1 < byte0; ++j1) {
                for (int k1 = 0; k1 < 16; ++k1) {
                    double d2 = 0.125;
                    double d1 = this.field_4180_q[((i1 + 0) * l2 + (j1 + 0)) * byte2 + (k1 + 0)];
                    double d22 = this.field_4180_q[((i1 + 0) * l2 + (j1 + 1)) * byte2 + (k1 + 0)];
                    double d3 = this.field_4180_q[((i1 + 1) * l2 + (j1 + 0)) * byte2 + (k1 + 0)];
                    double d4 = this.field_4180_q[((i1 + 1) * l2 + (j1 + 1)) * byte2 + (k1 + 0)];
                    double d5 = (this.field_4180_q[((i1 + 0) * l2 + (j1 + 0)) * byte2 + (k1 + 1)] - d1) * d2;
                    double d6 = (this.field_4180_q[((i1 + 0) * l2 + (j1 + 1)) * byte2 + (k1 + 1)] - d22) * d2;
                    double d7 = (this.field_4180_q[((i1 + 1) * l2 + (j1 + 0)) * byte2 + (k1 + 1)] - d3) * d2;
                    double d8 = (this.field_4180_q[((i1 + 1) * l2 + (j1 + 1)) * byte2 + (k1 + 1)] - d4) * d2;
                    for (int l1 = 0; l1 < 8; ++l1) {
                        double d9 = 0.25;
                        double d10 = d1;
                        double d11 = d22;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d22) * d9;
                        for (int i22 = 0; i22 < 4; ++i22) {
                            int j22 = i22 + i1 * 4 << 11 | 0 + j1 * 4 << 7 | k1 * 8 + l1;
                            int c2 = 128;
                            double d14 = 0.25;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;
                            for (int k22 = 0; k22 < 4; ++k22) {
                                double d17 = ad2[(i1 * 4 + i22) * 16 + (j1 * 4 + k22)];
                                int l22 = 0;
                                if (k1 * 8 + l1 < byte1) {
                                    l22 = d17 < 0.5 && k1 * 8 + l1 >= byte1 - 1 ? Block.blockIce.blockID : Block.waterMoving.blockID;
                                }
                                if (d15 > 0.0) {
                                    l22 = Block.stone.blockID;
                                }
                                abyte0[j22] = (byte)l22;
                                j22 += c2;
                                d15 += d16;
                            }
                            d10 += d12;
                            d11 += d13;
                        }
                        d1 += d5;
                        d22 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    public void replaceBlocksForBiome(int i2, int j2, byte[] abyte0, MobSpawnerBase[] amobspawnerbase) {
        int byte0 = 64;
        double d2 = 0.03125;
        this.field_905_r = this.field_909_n.func_807_a(this.field_905_r, i2 * 16, j2 * 16, 0.0, 16, 16, 1, d2, d2, 1.0);
        this.field_904_s = this.field_909_n.func_807_a(this.field_904_s, j2 * 16, 109.0134, i2 * 16, 16, 1, 16, d2, 1.0, d2);
        this.field_903_t = this.field_908_o.func_807_a(this.field_903_t, i2 * 16, j2 * 16, 0.0, 16, 16, 1, d2 * 2.0, d2 * 2.0, d2 * 2.0);
        for (int k2 = 0; k2 < 16; ++k2) {
            for (int l2 = 0; l2 < 16; ++l2) {
                MobSpawnerBase mobspawnerbase = amobspawnerbase[k2 * 16 + l2];
                boolean flag = this.field_905_r[k2 + l2 * 16] + this.rand.nextDouble() * 0.2 > 0.0;
                boolean flag1 = this.field_904_s[k2 + l2 * 16] + this.rand.nextDouble() * 0.2 > 3.0;
                int i1 = (int)(this.field_903_t[k2 + l2 * 16] / 3.0 + 3.0 + this.rand.nextDouble() * 0.25);
                int j1 = -1;
                byte byte1 = mobspawnerbase.topBlock;
                byte byte2 = mobspawnerbase.fillerBlock;
                for (int k1 = 127; k1 >= 0; --k1) {
                    int l1 = (k2 * 16 + l2) * 128 + k1;
                    if (k1 <= 0 + this.rand.nextInt(5)) {
                        abyte0[l1] = (byte)Block.bedrock.blockID;
                        continue;
                    }
                    byte byte3 = abyte0[l1];
                    if (byte3 == 0) {
                        j1 = -1;
                        continue;
                    }
                    if (byte3 != Block.stone.blockID) continue;
                    if (j1 == -1) {
                        if (i1 <= 0) {
                            byte1 = 0;
                            byte2 = (byte)Block.stone.blockID;
                        } else if (k1 >= byte0 - 4 && k1 <= byte0 + 1) {
                            byte1 = mobspawnerbase.topBlock;
                            byte2 = mobspawnerbase.fillerBlock;
                            if (flag1) {
                                byte1 = 0;
                            }
                            if (flag1) {
                                byte2 = (byte)Block.gravel.blockID;
                            }
                            if (flag) {
                                byte1 = (byte)Block.sand.blockID;
                            }
                            if (flag) {
                                byte2 = (byte)Block.sand.blockID;
                            }
                        }
                        if (k1 < byte0 && byte1 == 0) {
                            byte1 = (byte)Block.waterMoving.blockID;
                        }
                        j1 = i1;
                        if (k1 >= byte0 - 1) {
                            abyte0[l1] = byte1;
                            continue;
                        }
                        abyte0[l1] = byte2;
                        continue;
                    }
                    if (j1 <= 0) continue;
                    --j1;
                    abyte0[l1] = byte2;
                }
            }
        }
    }

    @Override
    public Chunk provideChunk(int i2, int j2) {
        this.rand.setSeed((long)i2 * 341873128712L + (long)j2 * 132897987541L);
        byte[] abyte0 = new byte[32768];
        Chunk chunk = new Chunk(this.worldObj, abyte0, i2, j2);
        this.biomesForGeneration = this.worldObj.func_4075_a().loadBlockGeneratorData(this.biomesForGeneration, i2 * 16, j2 * 16, 16, 16);
        double[] ad2 = this.worldObj.func_4075_a().temperature;
        this.generateTerrain(i2, j2, abyte0, this.biomesForGeneration, ad2);
        this.replaceBlocksForBiome(i2, j2, abyte0, this.biomesForGeneration);
        this.field_902_u.func_867_a(this, this.worldObj, i2, j2, abyte0);
        chunk.func_1024_c();
        return chunk;
    }

    private double[] func_4061_a(double[] ad2, int i2, int j2, int k2, int l2, int i1, int j1) {
        if (ad2 == null) {
            ad2 = new double[l2 * i1 * j1];
        }
        double d2 = 684.412;
        double d1 = 684.412;
        double[] ad1 = this.worldObj.func_4075_a().temperature;
        double[] ad22 = this.worldObj.func_4075_a().humidity;
        this.field_4182_g = this.field_922_a.func_4109_a(this.field_4182_g, i2, k2, l2, j1, 1.121, 1.121, 0.5);
        this.field_4181_h = this.field_921_b.func_4109_a(this.field_4181_h, i2, k2, l2, j1, 200.0, 200.0, 0.5);
        this.field_4185_d = this.field_910_m.func_807_a(this.field_4185_d, i2, j2, k2, l2, i1, j1, d2 / 80.0, d1 / 160.0, d2 / 80.0);
        this.field_4184_e = this.field_912_k.func_807_a(this.field_4184_e, i2, j2, k2, l2, i1, j1, d2, d1, d2);
        this.field_4183_f = this.field_911_l.func_807_a(this.field_4183_f, i2, j2, k2, l2, i1, j1, d2, d1, d2);
        int k1 = 0;
        int l1 = 0;
        int i22 = 16 / l2;
        for (int j22 = 0; j22 < l2; ++j22) {
            int k22 = j22 * i22 + i22 / 2;
            for (int l22 = 0; l22 < j1; ++l22) {
                double d6;
                int i3 = l22 * i22 + i22 / 2;
                double d22 = ad1[k22 * 16 + i3];
                double d3 = ad22[k22 * 16 + i3] * d22;
                double d4 = 1.0 - d3;
                d4 *= d4;
                d4 *= d4;
                d4 = 1.0 - d4;
                double d5 = (this.field_4182_g[l1] + 256.0) / 512.0;
                if ((d5 *= d4) > 1.0) {
                    d5 = 1.0;
                }
                if ((d6 = this.field_4181_h[l1] / 8000.0) < 0.0) {
                    d6 = -d6 * 0.3;
                }
                if ((d6 = d6 * 3.0 - 2.0) < 0.0) {
                    if ((d6 /= 2.0) < -1.0) {
                        d6 = -1.0;
                    }
                    d6 /= 1.4;
                    d6 /= 2.0;
                    d5 = 0.0;
                } else {
                    if (d6 > 1.0) {
                        d6 = 1.0;
                    }
                    d6 /= 8.0;
                }
                if (d5 < 0.0) {
                    d5 = 0.0;
                }
                d5 += 0.5;
                d6 = d6 * (double)i1 / 16.0;
                double d7 = (double)i1 / 2.0 + d6 * 4.0;
                ++l1;
                for (int j3 = 0; j3 < i1; ++j3) {
                    double d8 = 0.0;
                    double d9 = ((double)j3 - d7) * 12.0 / d5;
                    if (d9 < 0.0) {
                        d9 *= 4.0;
                    }
                    double d10 = this.field_4184_e[k1] / 512.0;
                    double d11 = this.field_4183_f[k1] / 512.0;
                    double d12 = (this.field_4185_d[k1] / 10.0 + 1.0) / 2.0;
                    d8 = d12 < 0.0 ? d10 : (d12 > 1.0 ? d11 : d10 + (d11 - d10) * d12);
                    d8 -= d9;
                    if (j3 > i1 - 4) {
                        double d13 = (float)(j3 - (i1 - 4)) / 3.0f;
                        d8 = d8 * (1.0 - d13) + -10.0 * d13;
                    }
                    ad2[k1] = d8;
                    ++k1;
                }
            }
        }
        return ad2;
    }

    @Override
    public boolean chunkExists(int i2, int j2) {
        return true;
    }

    @Override
    public void populate(IChunkProvider ichunkprovider, int i2, int j2) {
        int j17;
        int k14;
        int k12;
        BlockSand.fallInstantly = true;
        int k2 = i2 * 16;
        int l2 = j2 * 16;
        MobSpawnerBase mobspawnerbase = this.worldObj.func_4075_a().func_4073_a(k2 + 16, l2 + 16);
        this.rand.setSeed(this.worldObj.randomSeed);
        long l1 = this.rand.nextLong() / 2L * 2L + 1L;
        long l22 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)i2 * l1 + (long)j2 * l22 ^ this.worldObj.randomSeed);
        double d2 = 0.25;
        if (this.rand.nextInt(4) == 0) {
            int i1 = k2 + this.rand.nextInt(16) + 8;
            int k4 = this.rand.nextInt(128);
            int k7 = l2 + this.rand.nextInt(16) + 8;
            new WorldGenLakes(Block.waterMoving.blockID).generate(this.worldObj, this.rand, i1, k4, k7);
        }
        if (this.rand.nextInt(8) == 0) {
            int j1 = k2 + this.rand.nextInt(16) + 8;
            int l4 = this.rand.nextInt(this.rand.nextInt(120) + 8);
            int l7 = l2 + this.rand.nextInt(16) + 8;
            if (l4 < 64 || this.rand.nextInt(10) == 0) {
                new WorldGenLakes(Block.lavaMoving.blockID).generate(this.worldObj, this.rand, j1, l4, l7);
            }
        }
        for (int k1 = 0; k1 < 8; ++k1) {
            int i5 = k2 + this.rand.nextInt(16) + 8;
            int i8 = this.rand.nextInt(128);
            int j10 = l2 + this.rand.nextInt(16) + 8;
            new WorldGenDungeons().generate(this.worldObj, this.rand, i5, i8, j10);
        }
        for (int i22 = 0; i22 < 10; ++i22) {
            int j5 = k2 + this.rand.nextInt(16);
            int j8 = this.rand.nextInt(128);
            int k10 = l2 + this.rand.nextInt(16);
            new WorldGenClay(32).generate(this.worldObj, this.rand, j5, j8, k10);
        }
        for (int j22 = 0; j22 < 20; ++j22) {
            int k5 = k2 + this.rand.nextInt(16);
            int k8 = this.rand.nextInt(128);
            int l10 = l2 + this.rand.nextInt(16);
            new WorldGenMinable(Block.dirt.blockID, 32).generate(this.worldObj, this.rand, k5, k8, l10);
        }
        for (int k22 = 0; k22 < 10; ++k22) {
            int l5 = k2 + this.rand.nextInt(16);
            int l8 = this.rand.nextInt(128);
            int i11 = l2 + this.rand.nextInt(16);
            new WorldGenMinable(Block.gravel.blockID, 32).generate(this.worldObj, this.rand, l5, l8, i11);
        }
        for (int i3 = 0; i3 < 20; ++i3) {
            int i6 = k2 + this.rand.nextInt(16);
            int i9 = this.rand.nextInt(128);
            int j11 = l2 + this.rand.nextInt(16);
            new WorldGenMinable(Block.oreCoal.blockID, 16).generate(this.worldObj, this.rand, i6, i9, j11);
        }
        for (int j3 = 0; j3 < 20; ++j3) {
            int j6 = k2 + this.rand.nextInt(16);
            int j9 = this.rand.nextInt(64);
            int k11 = l2 + this.rand.nextInt(16);
            new WorldGenMinable(Block.oreIron.blockID, 8).generate(this.worldObj, this.rand, j6, j9, k11);
        }
        for (int k3 = 0; k3 < 2; ++k3) {
            int k6 = k2 + this.rand.nextInt(16);
            int k9 = this.rand.nextInt(32);
            int l11 = l2 + this.rand.nextInt(16);
            new WorldGenMinable(Block.oreGold.blockID, 8).generate(this.worldObj, this.rand, k6, k9, l11);
        }
        for (int l3 = 0; l3 < 8; ++l3) {
            int l6 = k2 + this.rand.nextInt(16);
            int l9 = this.rand.nextInt(16);
            int i12 = l2 + this.rand.nextInt(16);
            new WorldGenMinable(Block.oreRedstone.blockID, 7).generate(this.worldObj, this.rand, l6, l9, i12);
        }
        for (int i4 = 0; i4 < 1; ++i4) {
            int i7 = k2 + this.rand.nextInt(16);
            int i10 = this.rand.nextInt(16);
            int j12 = l2 + this.rand.nextInt(16);
            new WorldGenMinable(Block.oreDiamond.blockID, 7).generate(this.worldObj, this.rand, i7, i10, j12);
        }
        d2 = 0.5;
        int j4 = (int)((this.field_920_c.func_806_a((double)k2 * d2, (double)l2 * d2) / 8.0 + this.rand.nextDouble() * 4.0 + 4.0) / 3.0);
        int j7 = 0;
        if (this.rand.nextInt(10) == 0) {
            ++j7;
        }
        if (mobspawnerbase == MobSpawnerBase.forest) {
            j7 += j4 + 5;
        }
        if (mobspawnerbase == MobSpawnerBase.rainforest) {
            j7 += j4 + 5;
        }
        if (mobspawnerbase == MobSpawnerBase.seasonalForest) {
            j7 += j4 + 2;
        }
        if (mobspawnerbase == MobSpawnerBase.taiga) {
            j7 += j4 + 5;
        }
        if (mobspawnerbase == MobSpawnerBase.desert) {
            j7 -= 20;
        }
        if (mobspawnerbase == MobSpawnerBase.tundra) {
            j7 -= 20;
        }
        if (mobspawnerbase == MobSpawnerBase.plains) {
            j7 -= 20;
        }
        WorldGenerator obj = new WorldGenTrees();
        WorldGenTreesHerobrine obj2 = new WorldGenTreesHerobrine();
        if (this.rand.nextInt(10) == 0) {
            obj = new WorldGenBigTree();
        }
        if (mobspawnerbase == MobSpawnerBase.rainforest && this.rand.nextInt(3) == 0) {
            obj = new WorldGenBigTree();
        }
        for (k12 = 0; k12 < j7; ++k12) {
            k14 = k2 + this.rand.nextInt(16) + 8;
            j17 = l2 + this.rand.nextInt(16) + 8;
            ((WorldGenerator)obj).func_517_a(1.0, 1.0, 1.0);
            ((WorldGenerator)obj).generate(this.worldObj, this.rand, k14, this.worldObj.getHeightValue(k14, j17), j17);
        }
        for (k12 = 0; k12 < j7; ++k12) {
            k14 = k2 + this.rand.nextInt(16) + 8;
            j17 = l2 + this.rand.nextInt(16) + 8;
            ((WorldGenerator)obj2).func_517_a(1.0, 1.0, 1.0);
            ((WorldGenerator)obj2).generate(this.worldObj, this.rand, k14, this.worldObj.getHeightValue(k14, j17), j17);
        }
        for (int l12 = 0; l12 < 2; ++l12) {
            int l14 = k2 + this.rand.nextInt(16) + 8;
            int k17 = this.rand.nextInt(128);
            int i20 = l2 + this.rand.nextInt(16) + 8;
            new WorldGenFlowers(Block.plantYellow.blockID).generate(this.worldObj, this.rand, l14, k17, i20);
        }
        if (this.rand.nextInt(2) == 0) {
            int i13 = k2 + this.rand.nextInt(16) + 8;
            int i15 = this.rand.nextInt(128);
            int l17 = l2 + this.rand.nextInt(16) + 8;
            new WorldGenFlowers(Block.plantRed.blockID).generate(this.worldObj, this.rand, i13, i15, l17);
        }
        if (this.rand.nextInt(4) == 0) {
            int j13 = k2 + this.rand.nextInt(16) + 8;
            int j15 = this.rand.nextInt(128);
            int i18 = l2 + this.rand.nextInt(16) + 8;
            new WorldGenFlowers(Block.mushroomBrown.blockID).generate(this.worldObj, this.rand, j13, j15, i18);
        }
        if (this.rand.nextInt(8) == 0) {
            int k13 = k2 + this.rand.nextInt(16) + 8;
            int k15 = this.rand.nextInt(128);
            int j18 = l2 + this.rand.nextInt(16) + 8;
            new WorldGenFlowers(Block.mushroomRed.blockID).generate(this.worldObj, this.rand, k13, k15, j18);
        }
        for (int l13 = 0; l13 < 10; ++l13) {
            int l15 = k2 + this.rand.nextInt(16) + 8;
            int k18 = this.rand.nextInt(128);
            int j20 = l2 + this.rand.nextInt(16) + 8;
            new WorldGenReed().generate(this.worldObj, this.rand, l15, k18, j20);
        }
        if (this.rand.nextInt(32) == 0) {
            int i14 = k2 + this.rand.nextInt(16) + 8;
            int i16 = this.rand.nextInt(128);
            int l18 = l2 + this.rand.nextInt(16) + 8;
            new WorldGenPumpkin().generate(this.worldObj, this.rand, i14, i16, l18);
        }
        int j14 = 0;
        if (mobspawnerbase == MobSpawnerBase.desert) {
            j14 += 10;
        }
        for (int j16 = 0; j16 < j14; ++j16) {
            int i19 = k2 + this.rand.nextInt(16) + 8;
            int k20 = this.rand.nextInt(128);
            int k21 = l2 + this.rand.nextInt(16) + 8;
            new WorldGenCactus().generate(this.worldObj, this.rand, i19, k20, k21);
        }
        for (int k16 = 0; k16 < 50; ++k16) {
            int j19 = k2 + this.rand.nextInt(16) + 8;
            int l20 = this.rand.nextInt(this.rand.nextInt(120) + 8);
            int l21 = l2 + this.rand.nextInt(16) + 8;
            new WorldGenLiquids(Block.waterStill.blockID).generate(this.worldObj, this.rand, j19, l20, l21);
        }
        for (int l16 = 0; l16 < 20; ++l16) {
            int k19 = k2 + this.rand.nextInt(16) + 8;
            int i21 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8);
            int i22 = l2 + this.rand.nextInt(16) + 8;
            new WorldGenLiquids(Block.lavaStill.blockID).generate(this.worldObj, this.rand, k19, i21, i22);
        }
        this.field_4178_w = this.worldObj.func_4075_a().getTemperatures(this.field_4178_w, k2 + 8, l2 + 8, 16, 16);
        for (int i17 = k2 + 8; i17 < k2 + 8 + 16; ++i17) {
            for (int l19 = l2 + 8; l19 < l2 + 8 + 16; ++l19) {
                int j21 = i17 - (k2 + 8);
                int j22 = l19 - (l2 + 8);
                int k22 = this.worldObj.func_4083_e(i17, l19);
                double d1 = this.field_4178_w[j21 * 16 + j22] - (double)(k22 - 64) / 64.0 * 0.3;
                if (!(d1 < 0.5) || k22 <= 0 || k22 >= 128 || this.worldObj.getBlockId(i17, k22, l19) != 0 || !this.worldObj.getBlockMaterial(i17, k22 - 1, l19).func_880_c() || this.worldObj.getBlockMaterial(i17, k22 - 1, l19) == Material.ice) continue;
                this.worldObj.setBlockWithNotify(i17, k22, l19, Block.snow.blockID);
            }
        }
        BlockSand.fallInstantly = false;
    }

    @Override
    public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
        return true;
    }

    @Override
    public boolean func_532_a() {
        return false;
    }

    @Override
    public boolean func_536_b() {
        return true;
    }
}

