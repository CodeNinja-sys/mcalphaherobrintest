/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class ItemBoat
extends Item {
    public ItemBoat(int i2) {
        super(i2);
        this.maxStackSize = 1;
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
        MovingObjectPosition movingobjectposition = world.rayTraceBlocks(vec3d, vec3d1, true);
        if (movingobjectposition == null) {
            return itemstack;
        }
        if (movingobjectposition.typeOfHit == 0) {
            int i2 = movingobjectposition.blockX;
            int j2 = movingobjectposition.blockY;
            int k2 = movingobjectposition.blockZ;
            if (!world.multiplayerWorld) {
                world.entityJoinedWorld(new EntityBoat(world, (float)i2 + 0.5f, (float)j2 + 1.5f, (float)k2 + 0.5f));
            }
            --itemstack.stackSize;
        }
        return itemstack;
    }
}

