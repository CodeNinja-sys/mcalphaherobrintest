/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public abstract class EntityAnimals
extends EntityCreature {
    public EntityAnimals(World world) {
        super(world);
    }

    @Override
    protected float func_439_a(int i2, int j2, int k2) {
        if (this.worldObj.getBlockId(i2, j2 - 1, k2) == Block.grass.blockID) {
            return 10.0f;
        }
        return this.worldObj.getLightBrightness(i2, j2, k2) - 0.5f;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
    }

    @Override
    public boolean getCanSpawnHere() {
        int k2;
        int j2;
        int i2 = MathHelper.floor_double(this.posX);
        return this.worldObj.getBlockId(i2, (j2 = MathHelper.floor_double(this.boundingBox.minY)) - 1, k2 = MathHelper.floor_double(this.posZ)) == Block.grass.blockID && this.worldObj.getBlockLightValue(i2, j2, k2) > 8 && super.getCanSpawnHere();
    }

    @Override
    public int func_421_b() {
        return 120;
    }
}

