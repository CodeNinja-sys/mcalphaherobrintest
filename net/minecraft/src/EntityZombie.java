/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityMobs;
import net.minecraft.src.Item;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EntityZombie
extends EntityMobs {
    public EntityZombie(World world) {
        super(world);
        this.texture = "/mob/zombie.png";
        this.field_9333_am = 0.5f;
        this.field_762_e = 5;
    }

    @Override
    public void onLivingUpdate() {
        float f2;
        if (this.worldObj.isDaytime() && (f2 = this.getEntityBrightness(1.0f)) > 0.5f && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0f < (f2 - 0.4f) * 2.0f) {
            this.fire = 300;
        }
        super.onLivingUpdate();
    }

    @Override
    protected String getLivingSound() {
        return "mob.zombie";
    }

    @Override
    protected String getHurtSound() {
        return "mob.zombiehurt";
    }

    @Override
    protected String getDeathSound() {
        return "mob.zombiedeath";
    }

    @Override
    protected int getDropItemId() {
        return Item.feather.shiftedIndex;
    }
}

