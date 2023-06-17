/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockSlowSand
extends Block {
    public BlockSlowSand(int i2, int j2) {
        super(i2, j2, Material.sand);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        float f2 = 0.125f;
        return AxisAlignedBB.getBoundingBoxFromPool(i2, j2, k2, i2 + 1, (float)(j2 + 1) - f2, k2 + 1);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int i2, int j2, int k2, Entity entity) {
        entity.motionX *= 0.4;
        entity.motionZ *= 0.4;
    }
}

