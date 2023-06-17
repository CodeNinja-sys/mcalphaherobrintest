/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.World;

public class MetadataChunkBlock {
    public final EnumSkyBlock field_1299_a;
    public int field_1298_b;
    public int field_1304_c;
    public int field_1303_d;
    public int field_1302_e;
    public int field_1301_f;
    public int field_1300_g;

    public MetadataChunkBlock(EnumSkyBlock enumskyblock, int i2, int j2, int k2, int l2, int i1, int j1) {
        this.field_1299_a = enumskyblock;
        this.field_1298_b = i2;
        this.field_1304_c = j2;
        this.field_1303_d = k2;
        this.field_1302_e = l2;
        this.field_1301_f = i1;
        this.field_1300_g = j1;
    }

    public void func_4127_a(World world) {
        int i2 = this.field_1302_e - this.field_1298_b + 1;
        int j2 = this.field_1301_f - this.field_1304_c + 1;
        int k2 = this.field_1300_g - this.field_1303_d + 1;
        int l2 = i2 * j2 * k2;
        if (l2 > 32768) {
            return;
        }
        for (int i1 = this.field_1298_b; i1 <= this.field_1302_e; ++i1) {
            for (int j1 = this.field_1303_d; j1 <= this.field_1300_g; ++j1) {
                if (!world.blockExists(i1, 0, j1)) continue;
                for (int k1 = this.field_1304_c; k1 <= this.field_1301_f; ++k1) {
                    if (k1 < 0 || k1 >= 128) continue;
                    int l1 = world.getSavedLightValue(this.field_1299_a, i1, k1, j1);
                    int i22 = 0;
                    int j22 = world.getBlockId(i1, k1, j1);
                    int k22 = Block.lightOpacity[j22];
                    if (k22 == 0) {
                        k22 = 1;
                    }
                    int l22 = 0;
                    if (this.field_1299_a == EnumSkyBlock.Sky) {
                        if (world.canExistingBlockSeeTheSky(i1, k1, j1)) {
                            l22 = 15;
                        }
                    } else if (this.field_1299_a == EnumSkyBlock.Block) {
                        l22 = Block.lightValue[j22];
                    }
                    if (k22 >= 15 && l22 == 0) {
                        i22 = 0;
                    } else {
                        int i3 = world.getSavedLightValue(this.field_1299_a, i1 - 1, k1, j1);
                        int k3 = world.getSavedLightValue(this.field_1299_a, i1 + 1, k1, j1);
                        int l3 = world.getSavedLightValue(this.field_1299_a, i1, k1 - 1, j1);
                        int i4 = world.getSavedLightValue(this.field_1299_a, i1, k1 + 1, j1);
                        int j4 = world.getSavedLightValue(this.field_1299_a, i1, k1, j1 - 1);
                        int k4 = world.getSavedLightValue(this.field_1299_a, i1, k1, j1 + 1);
                        i22 = i3;
                        if (k3 > i22) {
                            i22 = k3;
                        }
                        if (l3 > i22) {
                            i22 = l3;
                        }
                        if (i4 > i22) {
                            i22 = i4;
                        }
                        if (j4 > i22) {
                            i22 = j4;
                        }
                        if (k4 > i22) {
                            i22 = k4;
                        }
                        if ((i22 -= k22) < 0) {
                            i22 = 0;
                        }
                        if (l22 > i22) {
                            i22 = l22;
                        }
                    }
                    if (l1 == i22) continue;
                    world.setLightValue(this.field_1299_a, i1, k1, j1, i22);
                    int j3 = i22 - 1;
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    world.neighborLightPropagationChanged(this.field_1299_a, i1 - 1, k1, j1, j3);
                    world.neighborLightPropagationChanged(this.field_1299_a, i1, k1 - 1, j1, j3);
                    world.neighborLightPropagationChanged(this.field_1299_a, i1, k1, j1 - 1, j3);
                    if (i1 + 1 >= this.field_1302_e) {
                        world.neighborLightPropagationChanged(this.field_1299_a, i1 + 1, k1, j1, j3);
                    }
                    if (k1 + 1 >= this.field_1301_f) {
                        world.neighborLightPropagationChanged(this.field_1299_a, i1, k1 + 1, j1, j3);
                    }
                    if (j1 + 1 < this.field_1300_g) continue;
                    world.neighborLightPropagationChanged(this.field_1299_a, i1, k1, j1 + 1, j3);
                }
            }
        }
    }

    public boolean func_866_a(int i2, int j2, int k2, int l2, int i1, int j1) {
        if (i2 >= this.field_1298_b && j2 >= this.field_1304_c && k2 >= this.field_1303_d && l2 <= this.field_1302_e && i1 <= this.field_1301_f && j1 <= this.field_1300_g) {
            return true;
        }
        int k1 = 1;
        if (i2 >= this.field_1298_b - k1 && j2 >= this.field_1304_c - k1 && k2 >= this.field_1303_d - k1 && l2 <= this.field_1302_e + k1 && i1 <= this.field_1301_f + k1 && j1 <= this.field_1300_g + k1) {
            int j3;
            int i3;
            int l22;
            int k22;
            int k3;
            int l1 = this.field_1302_e - this.field_1298_b;
            int i22 = this.field_1301_f - this.field_1304_c;
            int j22 = this.field_1300_g - this.field_1303_d;
            if (i2 > this.field_1298_b) {
                i2 = this.field_1298_b;
            }
            if (j2 > this.field_1304_c) {
                j2 = this.field_1304_c;
            }
            if (k2 > this.field_1303_d) {
                k2 = this.field_1303_d;
            }
            if (l2 < this.field_1302_e) {
                l2 = this.field_1302_e;
            }
            if (i1 < this.field_1301_f) {
                i1 = this.field_1301_f;
            }
            if (j1 < this.field_1300_g) {
                j1 = this.field_1300_g;
            }
            if ((k3 = (k22 = l2 - i2) * (l22 = i1 - j2) * (i3 = j1 - k2)) - (j3 = l1 * i22 * j22) <= 2) {
                this.field_1298_b = i2;
                this.field_1304_c = j2;
                this.field_1303_d = k2;
                this.field_1302_e = l2;
                this.field_1301_f = i1;
                this.field_1300_g = j1;
                return true;
            }
        }
        return false;
    }
}

