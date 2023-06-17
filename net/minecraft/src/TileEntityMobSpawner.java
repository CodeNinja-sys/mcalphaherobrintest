/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;

public class TileEntityMobSpawner
extends TileEntity {
    public int delay = 20;
    public String entityID = "Pig";
    public double field_831_c;
    public double field_830_d = 0.0;

    public boolean anyPlayerInRange() {
        return this.worldObj.getClosestPlayer((double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5, 16.0) != null;
    }

    @Override
    public void updateEntity() {
        this.field_830_d = this.field_831_c;
        if (!this.anyPlayerInRange()) {
            return;
        }
        double d2 = (float)this.xCoord + this.worldObj.rand.nextFloat();
        double d22 = (float)this.yCoord + this.worldObj.rand.nextFloat();
        double d4 = (float)this.zCoord + this.worldObj.rand.nextFloat();
        this.worldObj.spawnParticle("smoke", d2, d22, d4, 0.0, 0.0, 0.0);
        this.worldObj.spawnParticle("flame", d2, d22, d4, 0.0, 0.0, 0.0);
        this.field_831_c += (double)(1000.0f / ((float)this.delay + 200.0f));
        while (this.field_831_c > 360.0) {
            this.field_831_c -= 360.0;
            this.field_830_d -= 360.0;
        }
        if (this.delay == -1) {
            this.updateDelay();
        }
        if (this.delay > 0) {
            --this.delay;
            return;
        }
        int byte0 = 4;
        for (int i2 = 0; i2 < byte0; ++i2) {
            EntityLiving entityliving = (EntityLiving)EntityList.createEntityInWorld(this.entityID, this.worldObj);
            if (entityliving == null) {
                return;
            }
            int j2 = this.worldObj.getEntitiesWithinAABB(entityliving.getClass(), AxisAlignedBB.getBoundingBoxFromPool(this.xCoord, this.yCoord, this.zCoord, this.xCoord + 1, this.yCoord + 1, this.zCoord + 1).expands(8.0, 4.0, 8.0)).size();
            if (j2 >= 6) {
                this.updateDelay();
                return;
            }
            if (entityliving == null) continue;
            double d6 = (double)this.xCoord + (this.worldObj.rand.nextDouble() - this.worldObj.rand.nextDouble()) * 4.0;
            double d7 = this.yCoord + this.worldObj.rand.nextInt(3) - 1;
            double d8 = (double)this.zCoord + (this.worldObj.rand.nextDouble() - this.worldObj.rand.nextDouble()) * 4.0;
            entityliving.setLocationAndAngles(d6, d7, d8, this.worldObj.rand.nextFloat() * 360.0f, 0.0f);
            if (!entityliving.getCanSpawnHere()) continue;
            this.worldObj.entityJoinedWorld(entityliving);
            for (int k2 = 0; k2 < 20; ++k2) {
                double d1 = (double)this.xCoord + 0.5 + ((double)this.worldObj.rand.nextFloat() - 0.5) * 2.0;
                double d3 = (double)this.yCoord + 0.5 + ((double)this.worldObj.rand.nextFloat() - 0.5) * 2.0;
                double d5 = (double)this.zCoord + 0.5 + ((double)this.worldObj.rand.nextFloat() - 0.5) * 2.0;
                this.worldObj.spawnParticle("smoke", d1, d3, d5, 0.0, 0.0, 0.0);
                this.worldObj.spawnParticle("flame", d1, d3, d5, 0.0, 0.0, 0.0);
            }
            entityliving.spawnExplosionParticle();
            this.updateDelay();
        }
        super.updateEntity();
    }

    private void updateDelay() {
        this.delay = 200 + this.worldObj.rand.nextInt(600);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbttagcompound) {
        super.readFromNBT(nbttagcompound);
        this.entityID = nbttagcompound.getString("EntityId");
        this.delay = nbttagcompound.getShort("Delay");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbttagcompound) {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setString("EntityId", this.entityID);
        nbttagcompound.setShort("Delay", (short)this.delay);
    }
}

