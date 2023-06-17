/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MobSpawnerBase;
import net.minecraft.src.World;

public final class SpawnerAnimals {
    private static Set eligibleChunksForSpawning = new HashSet();

    protected static ChunkPosition getRandomSpawningPointInChunk(World world, int i2, int j2) {
        int k2 = i2 + world.rand.nextInt(16);
        int l2 = world.rand.nextInt(128);
        int i1 = j2 + world.rand.nextInt(16);
        return new ChunkPosition(k2, l2, i1);
    }

    public static final int performSpawning(World var0) {
        int var1;
        eligibleChunksForSpawning.clear();
        for (var1 = 0; var1 < var0.playerEntities.size(); ++var1) {
            EntityPlayer var2 = (EntityPlayer)var0.playerEntities.get(var1);
            int var3 = MathHelper.floor_double(var2.posX / 16.0);
            int var4 = MathHelper.floor_double(var2.posZ / 16.0);
            int var5 = 8;
            for (int var6 = -var5; var6 <= var5; ++var6) {
                for (int var7 = -var5; var7 <= var5; ++var7) {
                    eligibleChunksForSpawning.add(new ChunkCoordIntPair(var6 + var3, var7 + var4));
                }
            }
        }
        var1 = 0;
        for (int var28 = 0; var28 < EnumCreatureType.values().length; ++var28) {
            EnumCreatureType var29 = EnumCreatureType.values()[var28];
            if (var0.countEntities(var29.field_4278_c) > var29.maxNumberOfEntityType * eligibleChunksForSpawning.size() / 256) continue;
            block6: for (ChunkCoordIntPair var31 : eligibleChunksForSpawning) {
                MobSpawnerBase var32;
                Class[] var33;
                if (var0.rand.nextInt(50) != 0 || (var33 = (var32 = var0.func_4075_a().func_4074_a(var31)).getEntitiesForType(var29)) == null || var33.length == 0) continue;
                int var8 = var0.rand.nextInt(var33.length);
                ChunkPosition var9 = SpawnerAnimals.getRandomSpawningPointInChunk(var0, var31.chunkXPos * 16, var31.chunkZPos * 16);
                int var10 = var9.x;
                int var11 = var9.y;
                int var12 = var9.z;
                if (var0.isBlockOpaqueCube(var10, var11, var12) || var0.getBlockMaterial(var10, var11, var12) != Material.air) continue;
                int var13 = 0;
                for (int var14 = 0; var14 < 3; ++var14) {
                    int var15 = var10;
                    int var16 = var11;
                    int var17 = var12;
                    int var18 = 6;
                    for (int var19 = 0; var19 < 4; ++var19) {
                        EntityLiving var34;
                        float var25;
                        float var24;
                        float var23;
                        float var26;
                        float var22;
                        float var21;
                        float var20;
                        if (!var0.isBlockOpaqueCube(var15 += var0.rand.nextInt(var18) - var0.rand.nextInt(var18), (var16 += var0.rand.nextInt(1) - var0.rand.nextInt(1)) - 1, var17 += var0.rand.nextInt(var18) - var0.rand.nextInt(var18)) || var0.isBlockOpaqueCube(var15, var16, var17) || var0.getBlockMaterial(var15, var16, var17).getIsLiquid() || var0.isBlockOpaqueCube(var15, var16 + 1, var17) || var0.getClosestPlayer(var20 = (float)var15 + 0.5f, var21 = (float)var16, var22 = (float)var17 + 0.5f, 24.0) != null || !((var26 = (var23 = var20 - (float)var0.spawnX) * var23 + (var24 = var21 - (float)var0.spawnY) * var24 + (var25 = var22 - (float)var0.spawnZ) * var25) >= 576.0f)) continue;
                        try {
                            var34 = (EntityLiving)var33[var8].getConstructor(World.class).newInstance(var0);
                        }
                        catch (Exception var27) {
                            var27.printStackTrace();
                            return var1;
                        }
                        var34.setLocationAndAngles(var20, var21, var22, var0.rand.nextFloat() * 360.0f, 0.0f);
                        if (var34.getCanSpawnHere()) {
                            ++var13;
                            var0.entityJoinedWorld(var34);
                            if (var34 instanceof EntitySpider && var0.rand.nextInt(100) == 0) {
                                EntitySkeleton var35 = new EntitySkeleton(var0);
                                var35.setLocationAndAngles(var20, var21, var22, var34.rotationYaw, 0.0f);
                                var0.entityJoinedWorld(var35);
                                var35.mountEntity(var34);
                            }
                            if (var13 >= var34.func_6391_i()) continue block6;
                        }
                        var1 += var13;
                    }
                }
            }
        }
        return var1;
    }
}

