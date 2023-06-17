/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityCow;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class ItemBucket
extends Item {
    private int isFull;

    public ItemBucket(int i2, int j2) {
        super(i2);
        this.maxStackSize = 1;
        this.maxDamage = 64;
        this.isFull = j2;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        float f9;
        float f6;
        float f8;
        double d3;
        float f5;
        float f2 = 1.0f;
        float f1 = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f2;
        float f22 = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f2;
        double d2 = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * (double)f2;
        double d1 = entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * (double)f2 + 1.62 - (double)entityplayer.yOffset;
        double d22 = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * (double)f2;
        Vec3D vec3d = Vec3D.createVector(d2, d1, d22);
        float f3 = MathHelper.cos(-f22 * 0.01745329f - 3.141593f);
        float f4 = MathHelper.sin(-f22 * 0.01745329f - 3.141593f);
        float f7 = f4 * (f5 = -MathHelper.cos(-f1 * 0.01745329f));
        Vec3D vec3d1 = vec3d.addVector((double)f7 * (d3 = 5.0), (double)(f8 = (f6 = MathHelper.sin(-f1 * 0.01745329f))) * d3, (double)(f9 = f3 * f5) * d3);
        MovingObjectPosition movingobjectposition = world.rayTraceBlocks(vec3d, vec3d1, this.isFull == 0);
        if (movingobjectposition == null) {
            return itemstack;
        }
        if (movingobjectposition.typeOfHit == 0) {
            int i2 = movingobjectposition.blockX;
            int j2 = movingobjectposition.blockY;
            int k2 = movingobjectposition.blockZ;
            if (!world.func_6466_a(entityplayer, i2, j2, k2)) {
                return itemstack;
            }
            if (this.isFull == 0) {
                if (world.getBlockMaterial(i2, j2, k2) == Material.water && world.getBlockMetadata(i2, j2, k2) == 0) {
                    world.setBlockWithNotify(i2, j2, k2, 0);
                    return new ItemStack(Item.bucketWater);
                }
                if (world.getBlockMaterial(i2, j2, k2) == Material.lava && world.getBlockMetadata(i2, j2, k2) == 0) {
                    world.setBlockWithNotify(i2, j2, k2, 0);
                    return new ItemStack(Item.bucketLava);
                }
            } else {
                if (this.isFull < 0) {
                    return new ItemStack(Item.bucketEmpty);
                }
                if (movingobjectposition.sideHit == 0) {
                    --j2;
                }
                if (movingobjectposition.sideHit == 1) {
                    ++j2;
                }
                if (movingobjectposition.sideHit == 2) {
                    --k2;
                }
                if (movingobjectposition.sideHit == 3) {
                    ++k2;
                }
                if (movingobjectposition.sideHit == 4) {
                    --i2;
                }
                if (movingobjectposition.sideHit == 5) {
                    ++i2;
                }
                if (world.getBlockId(i2, j2, k2) == 0 || !world.getBlockMaterial(i2, j2, k2).func_878_a()) {
                    if (world.worldProvider.field_6479_d && this.isFull == Block.waterStill.blockID) {
                        world.playSoundEffect(d2 + 0.5, d1 + 0.5, d22 + 0.5, "random.fizz", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);
                        for (int l2 = 0; l2 < 8; ++l2) {
                            world.spawnParticle("largesmoke", (double)i2 + Math.random(), (double)j2 + Math.random(), (double)k2 + Math.random(), 0.0, 0.0, 0.0);
                        }
                    } else {
                        world.setBlockAndMetadataWithNotify(i2, j2, k2, this.isFull, 0);
                    }
                    return new ItemStack(Item.bucketEmpty);
                }
            }
        } else if (this.isFull == 0 && movingobjectposition.entityHit instanceof EntityCow) {
            return new ItemStack(Item.bucketMilk);
        }
        return itemstack;
    }
}

