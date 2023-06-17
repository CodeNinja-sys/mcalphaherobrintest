/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Chunk;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IMobs;
import net.minecraft.src.Item;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntitySlime
extends EntityLiving
implements IMobs {
    public float field_768_a;
    public float field_767_b;
    private int field_769_d = 0;
    public int field_770_c = 1;

    public EntitySlime(World world) {
        super(world);
        this.texture = "/mob/slime.png";
        this.field_770_c = 1 << this.rand.nextInt(3);
        this.yOffset = 0.0f;
        this.field_769_d = this.rand.nextInt(20) + 10;
        this.func_441_c(this.field_770_c);
    }

    public void func_441_c(int i2) {
        this.field_770_c = i2;
        this.setSize(0.6f * (float)i2, 0.6f * (float)i2);
        this.health = i2 * i2;
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger("Size", this.field_770_c - 1);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        this.field_770_c = nbttagcompound.getInteger("Size") + 1;
    }

    @Override
    public void onUpdate() {
        this.field_767_b = this.field_768_a;
        boolean flag = this.onGround;
        super.onUpdate();
        if (this.onGround && !flag) {
            for (int i2 = 0; i2 < this.field_770_c * 8; ++i2) {
                float f2 = this.rand.nextFloat() * 3.141593f * 2.0f;
                float f1 = this.rand.nextFloat() * 0.5f + 0.5f;
                float f22 = MathHelper.sin(f2) * (float)this.field_770_c * 0.5f * f1;
                float f3 = MathHelper.cos(f2) * (float)this.field_770_c * 0.5f * f1;
                this.worldObj.spawnParticle("slime", this.posX + (double)f22, this.boundingBox.minY, this.posZ + (double)f3, 0.0, 0.0, 0.0);
            }
            if (this.field_770_c > 2) {
                this.worldObj.playSoundAtEntity(this, "mob.slime", this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) / 0.8f);
            }
            this.field_768_a = -0.5f;
        }
        this.field_768_a *= 0.6f;
    }

    @Override
    protected void func_418_b_() {
        EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity(this, 16.0);
        if (entityplayer != null) {
            this.faceEntity(entityplayer, 10.0f);
        }
        if (this.onGround && this.field_769_d-- <= 0) {
            this.field_769_d = this.rand.nextInt(20) + 10;
            if (entityplayer != null) {
                this.field_769_d /= 3;
            }
            this.isJumping = true;
            if (this.field_770_c > 1) {
                this.worldObj.playSoundAtEntity(this, "mob.slime", this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) * 0.8f);
            }
            this.field_768_a = 1.0f;
            this.field_9342_ah = 1.0f - this.rand.nextFloat() * 2.0f;
            this.field_9340_ai = 1 * this.field_770_c;
        } else {
            this.isJumping = false;
            if (this.onGround) {
                this.field_9340_ai = 0.0f;
                this.field_9342_ah = 0.0f;
            }
        }
    }

    @Override
    public void setEntityDead() {
        if (this.field_770_c > 1 && this.health == 0) {
            for (int i2 = 0; i2 < 4; ++i2) {
                float f2 = ((float)(i2 % 2) - 0.5f) * (float)this.field_770_c / 4.0f;
                float f1 = ((float)(i2 / 2) - 0.5f) * (float)this.field_770_c / 4.0f;
                EntitySlime entityslime = new EntitySlime(this.worldObj);
                entityslime.func_441_c(this.field_770_c / 2);
                entityslime.setLocationAndAngles(this.posX + (double)f2, this.posY + 0.5, this.posZ + (double)f1, this.rand.nextFloat() * 360.0f, 0.0f);
                this.worldObj.entityJoinedWorld(entityslime);
            }
        }
        super.setEntityDead();
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityplayer) {
        if (this.field_770_c > 1 && this.canEntityBeSeen(entityplayer) && (double)this.getDistanceToEntity(entityplayer) < 0.6 * (double)this.field_770_c && entityplayer.canAttackEntity(this, this.field_770_c)) {
            this.worldObj.playSoundAtEntity(this, "mob.slimeattack", 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
        }
    }

    @Override
    protected String getHurtSound() {
        return "mob.slime";
    }

    @Override
    protected String getDeathSound() {
        return "mob.slime";
    }

    @Override
    protected int getDropItemId() {
        if (this.field_770_c == 1) {
            return Item.slimeBall.shiftedIndex;
        }
        return 0;
    }

    @Override
    public boolean getCanSpawnHere() {
        Chunk chunk = this.worldObj.getChunkFromBlockCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));
        return (this.field_770_c == 1 || this.worldObj.difficultySetting > 0) && this.rand.nextInt(10) == 0 && chunk.func_997_a(987234911L).nextInt(10) == 0 && this.posY < 16.0;
    }

    @Override
    protected float getSoundVolume() {
        return 0.6f;
    }
}

