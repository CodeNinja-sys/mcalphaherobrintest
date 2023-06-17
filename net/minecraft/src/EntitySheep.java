/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAnimals;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntitySheep
extends EntityAnimals {
    public boolean sheared = false;

    public EntitySheep(World world) {
        super(world);
        this.texture = "/mob/sheep.png";
        this.setSize(0.9f, 1.3f);
    }

    @Override
    public boolean canAttackEntity(Entity entity, int i2) {
        if (!this.worldObj.multiplayerWorld && !this.sheared && entity instanceof EntityLiving) {
            this.sheared = true;
            int j2 = 1 + this.rand.nextInt(3);
            for (int k2 = 0; k2 < j2; ++k2) {
                EntityItem entityitem = this.dropItemWithOffset(Block.cloth.blockID, 1, 1.0f);
                entityitem.motionY += (double)(this.rand.nextFloat() * 0.05f);
                entityitem.motionX += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f);
                entityitem.motionZ += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f);
            }
        }
        return super.canAttackEntity(entity, i2);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setBoolean("Sheared", this.sheared);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        this.sheared = nbttagcompound.getBoolean("Sheared");
    }

    @Override
    protected String getLivingSound() {
        return "mob.sheep";
    }

    @Override
    protected String getHurtSound() {
        return "mob.sheep";
    }

    @Override
    protected String getDeathSound() {
        return "mob.sheep";
    }
}

