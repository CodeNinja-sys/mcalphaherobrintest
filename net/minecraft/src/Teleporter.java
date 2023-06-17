/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class Teleporter {
    private Random field_4232_a = new Random();

    public void func_4107_a(World world, Entity entity) {
        if (this.func_4106_b(world, entity)) {
            return;
        }
        this.func_4108_c(world, entity);
        this.func_4106_b(world, entity);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean func_4106_b(World world, Entity entity) {
        c = 128;
        d = -1.0;
        i = 0;
        j = 0;
        k = 0;
        l = MathHelper.floor_double(entity.posX);
        i1 = MathHelper.floor_double(entity.posZ);
        for (j1 = l - c; j1 <= l + c; ++j1) {
            d1 = (double)j1 + 0.5 - entity.posX;
            for (j2 = i1 - c; j2 <= i1 + c; ++j2) {
                d3 = (double)j2 + 0.5 - entity.posZ;
                for (k2 = 127; k2 >= 0; --k2) {
                    if (world.getBlockId(j1, k2, j2) == Block.portal.blockID) ** GOTO lbl16
                    continue;
lbl-1000:
                    // 1 sources

                    {
                        --k2;
lbl16:
                        // 2 sources

                        ** while (world.getBlockId((int)j1, (int)(k2 - 1), (int)j2) == Block.portal.blockID)
                    }
lbl17:
                    // 1 sources

                    d5 = (double)k2 + 0.5 - entity.posY;
                    d7 = d1 * d1 + d5 * d5 + d3 * d3;
                    if (!(d < 0.0) && !(d7 < d)) continue;
                    d = d7;
                    i = j1;
                    j = k2;
                    k = j2;
                }
            }
        }
        if (!(d >= 0.0)) return false;
        k1 = i;
        l1 = j;
        i2 = k;
        d2 = (double)k1 + 0.5;
        d4 = (double)l1 + 0.5;
        d6 = (double)i2 + 0.5;
        if (world.getBlockId(k1 - 1, l1, i2) == Block.portal.blockID) {
            d2 -= 0.5;
        }
        if (world.getBlockId(k1 + 1, l1, i2) == Block.portal.blockID) {
            d2 += 0.5;
        }
        if (world.getBlockId(k1, l1, i2 - 1) == Block.portal.blockID) {
            d6 -= 0.5;
        }
        if (world.getBlockId(k1, l1, i2 + 1) == Block.portal.blockID) {
            d6 += 0.5;
        }
        System.out.println("Teleporting to " + d2 + ", " + d4 + ", " + d6);
        entity.setLocationAndAngles(d2, d4, d6, entity.rotationYaw, 0.0f);
        entity.motionZ = 0.0;
        entity.motionY = 0.0;
        entity.motionX = 0.0;
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean func_4108_c(World world, Entity entity) {
        block28: {
            byte0 = 16;
            d = -1.0;
            i = MathHelper.floor_double(entity.posX);
            j = MathHelper.floor_double(entity.posY);
            k = MathHelper.floor_double(entity.posZ);
            l = i;
            i1 = j;
            j1 = k;
            k1 = 0;
            l1 = this.field_4232_a.nextInt(4);
            for (i2 = i - byte0; i2 <= i + byte0; ++i2) {
                d1 = (double)i2 + 0.5 - entity.posX;
                for (j3 = k - byte0; j3 <= k + byte0; ++j3) {
                    d3 = (double)j3 + 0.5 - entity.posZ;
                    block2: for (k4 = 127; k4 >= 0; --k4) {
                        if (world.getBlockId(i2, k4, j3) == 0) ** GOTO lbl19
                        continue;
lbl-1000:
                        // 1 sources

                        {
                            --k4;
lbl19:
                            // 2 sources

                            ** while (k4 > 0 && world.getBlockId((int)i2, (int)(k4 - 1), (int)j3) == 0)
                        }
lbl20:
                        // 3 sources

                        for (k5 = l1; k5 < l1 + 4; ++k5) {
                            l6 = k5 % 2;
                            i8 = 1 - l6;
                            if (k5 % 4 >= 2) {
                                l6 = -l6;
                                i8 = -i8;
                            }
                            for (j9 = 0; j9 < 3; ++j9) {
                                for (k10 = 0; k10 < 4; ++k10) {
                                    for (l11 = -1; l11 < 4; ++l11) {
                                        j12 = i2 + (k10 - 1) * l6 + j9 * i8;
                                        l12 = k4 + l11;
                                        j13 = j3 + (k10 - 1) * i8 - j9 * l6;
                                        if (l11 < 0 && !world.getBlockMaterial(j12, l12, j13).func_878_a() || l11 >= 0 && world.getBlockId(j12, l12, j13) != 0) continue block2;
                                    }
                                }
                            }
                            d5 = (double)k4 + 0.5 - entity.posY;
                            d7 = d1 * d1 + d5 * d5 + d3 * d3;
                            if (!(d < 0.0) && !(d7 < d)) continue;
                            d = d7;
                            l = i2;
                            i1 = k4;
                            j1 = j3;
                            k1 = k5 % 4;
                        }
                    }
                }
            }
            if (!(d < 0.0)) break block28;
            for (j2 = i - byte0; j2 <= i + byte0; ++j2) {
                d2 = (double)j2 + 0.5 - entity.posX;
                for (k3 = k - byte0; k3 <= k + byte0; ++k3) {
                    d4 = (double)k3 + 0.5 - entity.posZ;
                    block10: for (l4 = 127; l4 >= 0; --l4) {
                        if (world.getBlockId(j2, l4, k3) == 0) ** GOTO lbl57
                        continue;
lbl-1000:
                        // 1 sources

                        {
                            --l4;
lbl57:
                            // 2 sources

                            ** while (world.getBlockId((int)j2, (int)(l4 - 1), (int)k3) == 0)
                        }
lbl58:
                        // 3 sources

                        for (l5 = l1; l5 < l1 + 2; ++l5) {
                            i7 = l5 % 2;
                            j8 = 1 - i7;
                            for (k9 = 0; k9 < 4; ++k9) {
                                for (l10 = -1; l10 < 4; ++l10) {
                                    i12 = j2 + (k9 - 1) * i7;
                                    k12 = l4 + l10;
                                    i13 = k3 + (k9 - 1) * j8;
                                    if (l10 < 0 && !world.getBlockMaterial(i12, k12, i13).func_878_a() || l10 >= 0 && world.getBlockId(i12, k12, i13) != 0) continue block10;
                                }
                            }
                            d6 = (double)l4 + 0.5 - entity.posY;
                            d8 = d2 * d2 + d6 * d6 + d4 * d4;
                            if (!(d < 0.0) && !(d8 < d)) continue;
                            d = d8;
                            l = j2;
                            i1 = l4;
                            j1 = k3;
                            k1 = l5 % 2;
                        }
                    }
                }
            }
        }
        k2 = k1;
        l2 = l;
        i3 = i1;
        l3 = j1;
        i4 = k2 % 2;
        j4 = 1 - i4;
        if (k2 % 4 >= 2) {
            i4 = -i4;
            j4 = -j4;
        }
        if (d < 0.0) {
            if (i1 < 70) {
                i1 = 70;
            }
            if (i1 > 118) {
                i1 = 118;
            }
            i3 = i1;
            for (i5 = -1; i5 <= 1; ++i5) {
                for (i6 = 1; i6 < 3; ++i6) {
                    for (j7 = -1; j7 < 3; ++j7) {
                        k8 = l2 + (i6 - 1) * i4 + i5 * j4;
                        l9 = i3 + j7;
                        i11 = l3 + (i6 - 1) * j4 - i5 * i4;
                        flag = j7 < 0;
                        world.setBlockWithNotify(k8, l9, i11, flag != false ? Block.obsidian.blockID : 0);
                    }
                }
            }
        }
        for (j5 = 0; j5 < 4; ++j5) {
            world.field_1043_h = true;
            for (j6 = 0; j6 < 4; ++j6) {
                for (k7 = -1; k7 < 4; ++k7) {
                    l8 = l2 + (j6 - 1) * i4;
                    i10 = i3 + k7;
                    j11 = l3 + (j6 - 1) * j4;
                    flag1 = j6 == 0 || j6 == 3 || k7 == -1 || k7 == 3;
                    world.setBlockWithNotify(l8, i10, j11, flag1 != false ? Block.obsidian.blockID : Block.portal.blockID);
                }
            }
            world.field_1043_h = false;
            for (k6 = 0; k6 < 4; ++k6) {
                for (l7 = -1; l7 < 4; ++l7) {
                    i9 = l2 + (k6 - 1) * i4;
                    j10 = i3 + l7;
                    k11 = l3 + (k6 - 1) * j4;
                    world.notifyBlocksOfNeighborChange(i9, j10, k11, world.getBlockId(i9, j10, k11));
                }
            }
        }
        return true;
    }
}

