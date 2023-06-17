/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.List;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityPigZombie
extends EntityZombie {
    private int angerLevel = 0;
    private int randomSoundDelay = 0;
    private static final ItemStack defaultHeldItem = new ItemStack(Item.swordGold, 1);

    public EntityPigZombie(World world) {
        super(world);
        this.texture = "/mob/pigzombie.png";
        this.field_9333_am = 0.5f;
        this.field_762_e = 5;
        this.isImmuneToFire = true;
    }

    @Override
    public void onUpdate() {
        float f2 = this.field_9333_am = this.playerToAttack == null ? 0.5f : 0.95f;
        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
            this.worldObj.playSoundAtEntity(this, "mob.zombiepig.zpigangry", this.getSoundVolume() * 2.0f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) * 1.8f);
        }
        super.onUpdate();
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting > 0 && this.worldObj.checkIfAABBIsClear(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.getIsAnyLiquid(this.boundingBox);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setShort("Anger", (short)this.angerLevel);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        this.angerLevel = nbttagcompound.getShort("Anger");
    }

    @Override
    protected Entity findPlayerToAttack() {
        if (this.angerLevel == 0) {
            return null;
        }
        return super.findPlayerToAttack();
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    @Override
    public boolean canAttackEntity(Entity entity, int i2) {
        if (entity instanceof EntityPlayer) {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expands(32.0, 32.0, 32.0));
            for (int j2 = 0; j2 < list.size(); ++j2) {
                Entity entity1 = (Entity)list.get(j2);
                if (!(entity1 instanceof EntityPigZombie)) continue;
                EntityPigZombie entitypigzombie = (EntityPigZombie)entity1;
                entitypigzombie.becomeAngryAt(entity);
            }
            this.becomeAngryAt(entity);
        }
        return super.canAttackEntity(entity, i2);
    }

    private void becomeAngryAt(Entity entity) {
        this.playerToAttack = entity;
        this.angerLevel = 400 + this.rand.nextInt(400);
        this.randomSoundDelay = this.rand.nextInt(40);
    }

    @Override
    protected String getLivingSound() {
        return "mob.zombiepig.zpig";
    }

    @Override
    protected String getHurtSound() {
        return "mob.zombiepig.zpighurt";
    }

    @Override
    protected String getDeathSound() {
        return "mob.zombiepig.zpigdeath";
    }

    @Override
    protected int getDropItemId() {
        return Item.porkCooked.shiftedIndex;
    }

    @Override
    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }
}

