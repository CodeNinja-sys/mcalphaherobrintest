/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenLakes
extends WorldGenerator {
    private int field_15235_a;

    public WorldGenLakes(int i2) {
        this.field_15235_a = i2;
    }

    @Override
    public boolean generate(World world, Random random, int i2, int j2, int k2) {
        while (j2 > 0 && world.getBlockId(i2 -= 8, j2, k2 -= 8) == 0) {
            --j2;
        }
        j2 -= 4;
        boolean[] aflag = new boolean[2048];
        int l2 = random.nextInt(4) + 4;
        for (int i1 = 0; i1 < l2; ++i1) {
            double d2 = random.nextDouble() * 6.0 + 3.0;
            double d1 = random.nextDouble() * 4.0 + 2.0;
            double d22 = random.nextDouble() * 6.0 + 3.0;
            double d3 = random.nextDouble() * (16.0 - d2 - 2.0) + 1.0 + d2 / 2.0;
            double d4 = random.nextDouble() * (8.0 - d1 - 4.0) + 2.0 + d1 / 2.0;
            double d5 = random.nextDouble() * (16.0 - d22 - 2.0) + 1.0 + d22 / 2.0;
            for (int k3 = 1; k3 < 15; ++k3) {
                for (int l3 = 1; l3 < 15; ++l3) {
                    for (int i4 = 1; i4 < 7; ++i4) {
                        double d6 = ((double)k3 - d3) / (d2 / 2.0);
                        double d7 = ((double)i4 - d4) / (d1 / 2.0);
                        double d8 = ((double)l3 - d5) / (d22 / 2.0);
                        double d9 = d6 * d6 + d7 * d7 + d8 * d8;
                        if (!(d9 < 1.0)) continue;
                        aflag[(k3 * 16 + l3) * 8 + i4] = true;
                    }
                }
            }
        }
        for (int j1 = 0; j1 < 16; ++j1) {
            for (int i22 = 0; i22 < 16; ++i22) {
                for (int l22 = 0; l22 < 8; ++l22) {
                    boolean flag;
                    boolean bl2 = flag = !aflag[(j1 * 16 + i22) * 8 + l22] && (j1 < 15 && aflag[((j1 + 1) * 16 + i22) * 8 + l22] || j1 > 0 && aflag[((j1 - 1) * 16 + i22) * 8 + l22] || i22 < 15 && aflag[(j1 * 16 + (i22 + 1)) * 8 + l22] || i22 > 0 && aflag[(j1 * 16 + (i22 - 1)) * 8 + l22] || l22 < 7 && aflag[(j1 * 16 + i22) * 8 + (l22 + 1)] || l22 > 0 && aflag[(j1 * 16 + i22) * 8 + (l22 - 1)]);
                    if (!flag) continue;
                    Material material = world.getBlockMaterial(i2 + j1, j2 + l22, k2 + i22);
                    if (l22 >= 4 && material.getIsLiquid()) {
                        return false;
                    }
                    if (l22 >= 4 || material.func_878_a() || world.getBlockId(i2 + j1, j2 + l22, k2 + i22) == this.field_15235_a) continue;
                    return false;
                }
            }
        }
        for (int k1 = 0; k1 < 16; ++k1) {
            for (int j22 = 0; j22 < 16; ++j22) {
                for (int i3 = 0; i3 < 8; ++i3) {
                    if (!aflag[(k1 * 16 + j22) * 8 + i3]) continue;
                    world.setBlockWithNotify(i2 + k1, j2 + i3, k2 + j22, i3 < 4 ? this.field_15235_a : 0);
                }
            }
        }
        for (int l1 = 0; l1 < 16; ++l1) {
            for (int k22 = 0; k22 < 16; ++k22) {
                for (int j3 = 4; j3 < 8; ++j3) {
                    if (!aflag[(l1 * 16 + k22) * 8 + j3] || world.getBlockId(i2 + l1, j2 + j3 - 1, k2 + k22) != Block.dirt.blockID || world.getSavedLightValue(EnumSkyBlock.Sky, i2 + l1, j2 + j3, k2 + k22) <= 0) continue;
                    world.setBlockWithNotify(i2 + l1, j2 + j3 - 1, k2 + k22, Block.grass.blockID);
                }
            }
        }
        return true;
    }
}

