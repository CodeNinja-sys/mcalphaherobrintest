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
import net.minecraft.src.MapGenCavesHell;
import net.minecraft.src.NoiseGeneratorOctaves;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenFire;
import net.minecraft.src.WorldGenFlowers;
import net.minecraft.src.WorldGenHellLava;
import net.minecraft.src.WorldGenLightStone1;
import net.minecraft.src.WorldGenLightStone2;

public class ChunkProviderHell
implements IChunkProvider {
    private Random field_4170_h;
    private NoiseGeneratorOctaves field_4169_i;
    private NoiseGeneratorOctaves field_4168_j;
    private NoiseGeneratorOctaves field_4167_k;
    private NoiseGeneratorOctaves field_4166_l;
    private NoiseGeneratorOctaves field_4165_m;
    public NoiseGeneratorOctaves field_4177_a;
    public NoiseGeneratorOctaves field_4176_b;
    private World field_4164_n;
    private double[] field_4163_o;
    private double[] field_4162_p = new double[256];
    private double[] field_4161_q = new double[256];
    private double[] field_4160_r = new double[256];
    private MapGenBase field_4159_s = new MapGenCavesHell();
    double[] field_4175_c;
    double[] field_4174_d;
    double[] field_4173_e;
    double[] field_4172_f;
    double[] field_4171_g;

    public ChunkProviderHell(World world, long l2) {
        this.field_4164_n = world;
        this.field_4170_h = new Random(l2);
        this.field_4169_i = new NoiseGeneratorOctaves(this.field_4170_h, 16);
        this.field_4168_j = new NoiseGeneratorOctaves(this.field_4170_h, 16);
        this.field_4167_k = new NoiseGeneratorOctaves(this.field_4170_h, 8);
        this.field_4166_l = new NoiseGeneratorOctaves(this.field_4170_h, 4);
        this.field_4165_m = new NoiseGeneratorOctaves(this.field_4170_h, 4);
        this.field_4177_a = new NoiseGeneratorOctaves(this.field_4170_h, 10);
        this.field_4176_b = new NoiseGeneratorOctaves(this.field_4170_h, 16);
    }

    public void func_4059_a(int i2, int j2, byte[] abyte0) {
        int byte0 = 4;
        int byte1 = 32;
        int k2 = byte0 + 1;
        int byte2 = 17;
        int l2 = byte0 + 1;
        this.field_4163_o = this.func_4057_a(this.field_4163_o, i2 * byte0, 0, j2 * byte0, k2, byte2, l2);
        for (int i1 = 0; i1 < byte0; ++i1) {
            for (int j1 = 0; j1 < byte0; ++j1) {
                for (int k1 = 0; k1 < 16; ++k1) {
                    double d2 = 0.125;
                    double d1 = this.field_4163_o[((i1 + 0) * l2 + (j1 + 0)) * byte2 + (k1 + 0)];
                    double d22 = this.field_4163_o[((i1 + 0) * l2 + (j1 + 1)) * byte2 + (k1 + 0)];
                    double d3 = this.field_4163_o[((i1 + 1) * l2 + (j1 + 0)) * byte2 + (k1 + 0)];
                    double d4 = this.field_4163_o[((i1 + 1) * l2 + (j1 + 1)) * byte2 + (k1 + 0)];
                    double d5 = (this.field_4163_o[((i1 + 0) * l2 + (j1 + 0)) * byte2 + (k1 + 1)] - d1) * d2;
                    double d6 = (this.field_4163_o[((i1 + 0) * l2 + (j1 + 1)) * byte2 + (k1 + 1)] - d22) * d2;
                    double d7 = (this.field_4163_o[((i1 + 1) * l2 + (j1 + 0)) * byte2 + (k1 + 1)] - d3) * d2;
                    double d8 = (this.field_4163_o[((i1 + 1) * l2 + (j1 + 1)) * byte2 + (k1 + 1)] - d4) * d2;
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
                                int l22 = 0;
                                if (k1 * 8 + l1 < byte1) {
                                    l22 = Block.lavaMoving.blockID;
                                }
                                if (d15 > 0.0) {
                                    l22 = Block.bloodStone.blockID;
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

    public void func_4058_b(int i2, int j2, byte[] abyte0) {
        int byte0 = 64;
        double d2 = 0.03125;
        this.field_4162_p = this.field_4166_l.func_807_a(this.field_4162_p, i2 * 16, j2 * 16, 0.0, 16, 16, 1, d2, d2, 1.0);
        this.field_4161_q = this.field_4166_l.func_807_a(this.field_4161_q, j2 * 16, 109.0134, i2 * 16, 16, 1, 16, d2, 1.0, d2);
        this.field_4160_r = this.field_4165_m.func_807_a(this.field_4160_r, i2 * 16, j2 * 16, 0.0, 16, 16, 1, d2 * 2.0, d2 * 2.0, d2 * 2.0);
        for (int k2 = 0; k2 < 16; ++k2) {
            for (int l2 = 0; l2 < 16; ++l2) {
                boolean flag = this.field_4162_p[k2 + l2 * 16] + this.field_4170_h.nextDouble() * 0.2 > 0.0;
                boolean flag1 = this.field_4161_q[k2 + l2 * 16] + this.field_4170_h.nextDouble() * 0.2 > 0.0;
                int i1 = (int)(this.field_4160_r[k2 + l2 * 16] / 3.0 + 3.0 + this.field_4170_h.nextDouble() * 0.25);
                int j1 = -1;
                byte byte1 = (byte)Block.bloodStone.blockID;
                byte byte2 = (byte)Block.bloodStone.blockID;
                for (int k1 = 127; k1 >= 0; --k1) {
                    int l1 = (k2 * 16 + l2) * 128 + k1;
                    if (k1 >= 127 - this.field_4170_h.nextInt(5)) {
                        abyte0[l1] = (byte)Block.bedrock.blockID;
                        continue;
                    }
                    if (k1 <= 0 + this.field_4170_h.nextInt(5)) {
                        abyte0[l1] = (byte)Block.bedrock.blockID;
                        continue;
                    }
                    byte byte3 = abyte0[l1];
                    if (byte3 == 0) {
                        j1 = -1;
                        continue;
                    }
                    if (byte3 != Block.bloodStone.blockID) continue;
                    if (j1 == -1) {
                        if (i1 <= 0) {
                            byte1 = 0;
                            byte2 = (byte)Block.bloodStone.blockID;
                        } else if (k1 >= byte0 - 4 && k1 <= byte0 + 1) {
                            byte1 = (byte)Block.bloodStone.blockID;
                            byte2 = (byte)Block.bloodStone.blockID;
                            if (flag1) {
                                byte1 = (byte)Block.gravel.blockID;
                            }
                            if (flag1) {
                                byte2 = (byte)Block.bloodStone.blockID;
                            }
                            if (flag) {
                                byte1 = (byte)Block.slowSand.blockID;
                            }
                            if (flag) {
                                byte2 = (byte)Block.slowSand.blockID;
                            }
                        }
                        if (k1 < byte0 && byte1 == 0) {
                            byte1 = (byte)Block.lavaMoving.blockID;
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
        this.field_4170_h.setSeed((long)i2 * 341873128712L + (long)j2 * 132897987541L);
        byte[] abyte0 = new byte[32768];
        this.func_4059_a(i2, j2, abyte0);
        this.func_4058_b(i2, j2, abyte0);
        this.field_4159_s.func_867_a(this, this.field_4164_n, i2, j2, abyte0);
        Chunk chunk = new Chunk(this.field_4164_n, abyte0, i2, j2);
        chunk.func_1024_c();
        chunk.func_4143_d();
        return chunk;
    }

    private double[] func_4057_a(double[] ad2, int i2, int j2, int k2, int l2, int i1, int j1) {
        if (ad2 == null) {
            ad2 = new double[l2 * i1 * j1];
        }
        double d2 = 684.412;
        double d1 = 2053.236;
        this.field_4172_f = this.field_4177_a.func_807_a(this.field_4172_f, i2, j2, k2, l2, 1, j1, 1.0, 0.0, 1.0);
        this.field_4171_g = this.field_4176_b.func_807_a(this.field_4171_g, i2, j2, k2, l2, 1, j1, 100.0, 0.0, 100.0);
        this.field_4175_c = this.field_4167_k.func_807_a(this.field_4175_c, i2, j2, k2, l2, i1, j1, d2 / 80.0, d1 / 60.0, d2 / 80.0);
        this.field_4174_d = this.field_4169_i.func_807_a(this.field_4174_d, i2, j2, k2, l2, i1, j1, d2, d1, d2);
        this.field_4173_e = this.field_4168_j.func_807_a(this.field_4173_e, i2, j2, k2, l2, i1, j1, d2, d1, d2);
        int k1 = 0;
        int l1 = 0;
        double[] ad1 = new double[i1];
        for (int i22 = 0; i22 < i1; ++i22) {
            ad1[i22] = Math.cos((double)i22 * Math.PI * 6.0 / (double)i1) * 2.0;
            double d22 = i22;
            if (i22 > i1 / 2) {
                d22 = i1 - 1 - i22;
            }
            if (!(d22 < 4.0)) continue;
            d22 = 4.0 - d22;
            int n2 = i22;
            ad1[n2] = ad1[n2] - d22 * d22 * d22 * 10.0;
        }
        for (int j22 = 0; j22 < l2; ++j22) {
            for (int k22 = 0; k22 < j1; ++k22) {
                double d3 = (this.field_4172_f[l1] + 256.0) / 512.0;
                if (d3 > 1.0) {
                    d3 = 1.0;
                }
                double d4 = 0.0;
                double d5 = this.field_4171_g[l1] / 8000.0;
                if (d5 < 0.0) {
                    d5 = -d5;
                }
                if ((d5 = d5 * 3.0 - 3.0) < 0.0) {
                    if ((d5 /= 2.0) < -1.0) {
                        d5 = -1.0;
                    }
                    d5 /= 1.4;
                    d5 /= 2.0;
                    d3 = 0.0;
                } else {
                    if (d5 > 1.0) {
                        d5 = 1.0;
                    }
                    d5 /= 6.0;
                }
                d3 += 0.5;
                d5 = d5 * (double)i1 / 16.0;
                ++l1;
                for (int l22 = 0; l22 < i1; ++l22) {
                    double d6 = 0.0;
                    double d7 = ad1[l22];
                    double d8 = this.field_4174_d[k1] / 512.0;
                    double d9 = this.field_4173_e[k1] / 512.0;
                    double d10 = (this.field_4175_c[k1] / 10.0 + 1.0) / 2.0;
                    d6 = d10 < 0.0 ? d8 : (d10 > 1.0 ? d9 : d8 + (d9 - d8) * d10);
                    d6 -= d7;
                    if (l22 > i1 - 4) {
                        double d11 = (float)(l22 - (i1 - 4)) / 3.0f;
                        d6 = d6 * (1.0 - d11) + -10.0 * d11;
                    }
                    if ((double)l22 < d4) {
                        double d12 = (d4 - (double)l22) / 4.0;
                        if (d12 < 0.0) {
                            d12 = 0.0;
                        }
                        if (d12 > 1.0) {
                            d12 = 1.0;
                        }
                        d6 = d6 * (1.0 - d12) + -10.0 * d12;
                    }
                    ad2[k1] = d6;
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
        BlockSand.fallInstantly = true;
        int k2 = i2 * 16;
        int l2 = j2 * 16;
        for (int i1 = 0; i1 < 8; ++i1) {
            int k1 = k2 + this.field_4170_h.nextInt(16) + 8;
            int i3 = this.field_4170_h.nextInt(120) + 4;
            int k4 = l2 + this.field_4170_h.nextInt(16) + 8;
            new WorldGenHellLava(Block.lavaStill.blockID).generate(this.field_4164_n, this.field_4170_h, k1, i3, k4);
        }
        int j1 = this.field_4170_h.nextInt(this.field_4170_h.nextInt(10) + 1) + 1;
        for (int l1 = 0; l1 < j1; ++l1) {
            int j3 = k2 + this.field_4170_h.nextInt(16) + 8;
            int l4 = this.field_4170_h.nextInt(120) + 4;
            int i6 = l2 + this.field_4170_h.nextInt(16) + 8;
            new WorldGenFire().generate(this.field_4164_n, this.field_4170_h, j3, l4, i6);
        }
        j1 = this.field_4170_h.nextInt(this.field_4170_h.nextInt(10) + 1);
        for (int i22 = 0; i22 < j1; ++i22) {
            int k3 = k2 + this.field_4170_h.nextInt(16) + 8;
            int i5 = this.field_4170_h.nextInt(120) + 4;
            int j6 = l2 + this.field_4170_h.nextInt(16) + 8;
            new WorldGenLightStone1().generate(this.field_4164_n, this.field_4170_h, k3, i5, j6);
        }
        for (int j22 = 0; j22 < 10; ++j22) {
            int l3 = k2 + this.field_4170_h.nextInt(16) + 8;
            int j5 = this.field_4170_h.nextInt(128);
            int k6 = l2 + this.field_4170_h.nextInt(16) + 8;
            new WorldGenLightStone2().generate(this.field_4164_n, this.field_4170_h, l3, j5, k6);
        }
        if (this.field_4170_h.nextInt(1) == 0) {
            int k22 = k2 + this.field_4170_h.nextInt(16) + 8;
            int i4 = this.field_4170_h.nextInt(128);
            int k5 = l2 + this.field_4170_h.nextInt(16) + 8;
            new WorldGenFlowers(Block.mushroomBrown.blockID).generate(this.field_4164_n, this.field_4170_h, k22, i4, k5);
        }
        if (this.field_4170_h.nextInt(1) == 0) {
            int l22 = k2 + this.field_4170_h.nextInt(16) + 8;
            int j4 = this.field_4170_h.nextInt(128);
            int l5 = l2 + this.field_4170_h.nextInt(16) + 8;
            new WorldGenFlowers(Block.mushroomRed.blockID).generate(this.field_4164_n, this.field_4170_h, l22, j4, l5);
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

