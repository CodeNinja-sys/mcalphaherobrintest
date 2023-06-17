/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityAnimals;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityCow
extends EntityAnimals {
    public boolean unusedBoolean = false;

    public EntityCow(World world) {
        super(world);
        this.texture = "/mob/cow.png";
        this.setSize(0.9f, 1.3f);
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
    protected String getLivingSound() {
        return "mob.cow";
    }

    @Override
    protected String getHurtSound() {
        return "mob.cowhurt";
    }

    @Override
    protected String getDeathSound() {
        return "mob.cowhurt";
    }

    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }

    @Override
    protected int getDropItemId() {
        return Item.leather.shiftedIndex;
    }

    @Override
    public boolean interact(EntityPlayer entityplayer) {
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        if (itemstack != null && itemstack.itemID == Item.bucketEmpty.shiftedIndex) {
            entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, new ItemStack(Item.bucketMilk));
            return true;
        }
        return false;
    }
}

