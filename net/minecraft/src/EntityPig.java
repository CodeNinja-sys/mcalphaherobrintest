/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityAnimals;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityPig
extends EntityAnimals {
    public boolean rideable = false;

    public EntityPig(World world) {
        super(world);
        this.texture = "/mob/pig.png";
        this.setSize(0.9f, 0.9f);
        this.rideable = false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setBoolean("Saddle", this.rideable);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        this.rideable = nbttagcompound.getBoolean("Saddle");
    }

    @Override
    protected String getLivingSound() {
        return "mob.pig";
    }

    @Override
    protected String getHurtSound() {
        return "mob.pig";
    }

    @Override
    protected String getDeathSound() {
        return "mob.pigdeath";
    }

    @Override
    public boolean interact(EntityPlayer entityplayer) {
        if (this.rideable) {
            entityplayer.mountEntity(this);
            return true;
        }
        return false;
    }

    @Override
    protected int getDropItemId() {
        return Item.porkRaw.shiftedIndex;
    }
}

