/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityMobs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntitySkeleton
extends EntityMobs {
    private static final ItemStack defaultHeldItem = new ItemStack(Item.bow, 1);

    public EntitySkeleton(World world) {
        super(world);
        this.texture = "/mob/skeleton.png";
    }

    @Override
    protected String getLivingSound() {
        return "mob.skeleton";
    }

    @Override
    protected String getHurtSound() {
        return "mob.skeletonhurt";
    }

    @Override
    protected String getDeathSound() {
        return "mob.skeletonhurt";
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
    protected void attackEntity(Entity entity, float f2) {
        if (f2 < 10.0f) {
            double d2 = entity.posX - this.posX;
            double d1 = entity.posZ - this.posZ;
            if (this.attackTime == 0) {
                EntityArrow entityarrow = new EntityArrow(this.worldObj, this);
                entityarrow.posY += (double)1.4f;
                double d22 = entity.posY - (double)0.2f - entityarrow.posY;
                float f1 = MathHelper.sqrt_double(d2 * d2 + d1 * d1) * 0.2f;
                this.worldObj.playSoundAtEntity(this, "random.bow", 1.0f, 1.0f / (this.rand.nextFloat() * 0.4f + 0.8f));
                this.worldObj.entityJoinedWorld(entityarrow);
                entityarrow.func_408_a(d2, d22 + (double)f1, d1, 0.6f, 12.0f);
                this.attackTime = 30;
            }
            this.rotationYaw = (float)(Math.atan2(d1, d2) * 180.0 / 3.1415927410125732) - 90.0f;
            this.hasAttacked = true;
        }
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
    protected int getDropItemId() {
        return Item.arrow.shiftedIndex;
    }

    @Override
    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }
}

