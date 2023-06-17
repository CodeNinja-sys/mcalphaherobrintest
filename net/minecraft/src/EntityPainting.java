/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EnumArt;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityPainting
extends Entity {
    private int field_695_c = 0;
    public int field_691_a = 0;
    private int field_9322_d;
    private int field_9321_e;
    private int field_9320_f;
    public EnumArt field_690_b;

    public EntityPainting(World world) {
        super(world);
        this.yOffset = 0.0f;
        this.setSize(0.5f, 0.5f);
    }

    public EntityPainting(World world, int i2, int j2, int k2, int l2) {
        this(world);
        this.field_9322_d = i2;
        this.field_9321_e = j2;
        this.field_9320_f = k2;
        ArrayList<EnumArt> arraylist = new ArrayList<EnumArt>();
        EnumArt[] aenumart = EnumArt.values();
        int i1 = aenumart.length;
        for (int j1 = 0; j1 < i1; ++j1) {
            EnumArt enumart;
            this.field_690_b = enumart = aenumart[j1];
            this.func_412_b(l2);
            if (!this.func_410_i()) continue;
            arraylist.add(enumart);
        }
        if (arraylist.size() > 0) {
            this.field_690_b = (EnumArt)((Object)arraylist.get(this.rand.nextInt(arraylist.size())));
        }
        this.func_412_b(l2);
    }

    public void func_412_b(int i2) {
        this.field_691_a = i2;
        this.prevRotationYaw = this.rotationYaw = (float)(i2 * 90);
        float f2 = this.field_690_b.field_1623_z;
        float f1 = this.field_690_b.field_1636_A;
        float f22 = this.field_690_b.field_1623_z;
        if (i2 == 0 || i2 == 2) {
            f22 = 0.5f;
        } else {
            f2 = 0.5f;
        }
        f2 /= 32.0f;
        f1 /= 32.0f;
        f22 /= 32.0f;
        float f3 = (float)this.field_9322_d + 0.5f;
        float f4 = (float)this.field_9321_e + 0.5f;
        float f5 = (float)this.field_9320_f + 0.5f;
        float f6 = 0.5625f;
        if (i2 == 0) {
            f5 -= f6;
        }
        if (i2 == 1) {
            f3 -= f6;
        }
        if (i2 == 2) {
            f5 += f6;
        }
        if (i2 == 3) {
            f3 += f6;
        }
        if (i2 == 0) {
            f3 -= this.func_411_c(this.field_690_b.field_1623_z);
        }
        if (i2 == 1) {
            f5 += this.func_411_c(this.field_690_b.field_1623_z);
        }
        if (i2 == 2) {
            f3 += this.func_411_c(this.field_690_b.field_1623_z);
        }
        if (i2 == 3) {
            f5 -= this.func_411_c(this.field_690_b.field_1623_z);
        }
        this.setPosition(f3, f4 += this.func_411_c(this.field_690_b.field_1636_A), f5);
        float f7 = -0.00625f;
        this.boundingBox.setBounds(f3 - f2 - f7, f4 - f1 - f7, f5 - f22 - f7, f3 + f2 + f7, f4 + f1 + f7, f5 + f22 + f7);
    }

    private float func_411_c(int i2) {
        if (i2 == 32) {
            return 0.5f;
        }
        return i2 != 64 ? 0.0f : 0.5f;
    }

    @Override
    public void onUpdate() {
        if (this.field_695_c++ == 100 && !this.func_410_i()) {
            this.field_695_c = 0;
            this.setEntityDead();
            this.worldObj.entityJoinedWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Item.painting)));
        }
    }

    public boolean func_410_i() {
        if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() > 0) {
            return false;
        }
        int i2 = this.field_690_b.field_1623_z / 16;
        int j2 = this.field_690_b.field_1636_A / 16;
        int k2 = this.field_9322_d;
        int l2 = this.field_9321_e;
        int i1 = this.field_9320_f;
        if (this.field_691_a == 0) {
            k2 = MathHelper.floor_double(this.posX - (double)((float)this.field_690_b.field_1623_z / 32.0f));
        }
        if (this.field_691_a == 1) {
            i1 = MathHelper.floor_double(this.posZ - (double)((float)this.field_690_b.field_1623_z / 32.0f));
        }
        if (this.field_691_a == 2) {
            k2 = MathHelper.floor_double(this.posX - (double)((float)this.field_690_b.field_1623_z / 32.0f));
        }
        if (this.field_691_a == 3) {
            i1 = MathHelper.floor_double(this.posZ - (double)((float)this.field_690_b.field_1623_z / 32.0f));
        }
        l2 = MathHelper.floor_double(this.posY - (double)((float)this.field_690_b.field_1636_A / 32.0f));
        for (int j1 = 0; j1 < i2; ++j1) {
            for (int k1 = 0; k1 < j2; ++k1) {
                Material material = this.field_691_a == 0 || this.field_691_a == 2 ? this.worldObj.getBlockMaterial(k2 + j1, l2 + k1, this.field_9320_f) : this.worldObj.getBlockMaterial(this.field_9322_d, l2 + k1, i1 + j1);
                if (material.func_878_a()) continue;
                return false;
            }
        }
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox);
        for (int l1 = 0; l1 < list.size(); ++l1) {
            if (!(list.get(l1) instanceof EntityPainting)) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean canAttackEntity(Entity entity, int i2) {
        this.setEntityDead();
        this.func_9281_M();
        this.worldObj.entityJoinedWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Item.painting)));
        return true;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setByte("Dir", (byte)this.field_691_a);
        nbttagcompound.setString("Motive", this.field_690_b.field_1624_y);
        nbttagcompound.setInteger("TileX", this.field_9322_d);
        nbttagcompound.setInteger("TileY", this.field_9321_e);
        nbttagcompound.setInteger("TileZ", this.field_9320_f);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        this.field_691_a = nbttagcompound.getByte("Dir");
        this.field_9322_d = nbttagcompound.getInteger("TileX");
        this.field_9321_e = nbttagcompound.getInteger("TileY");
        this.field_9320_f = nbttagcompound.getInteger("TileZ");
        String s2 = nbttagcompound.getString("Motive");
        for (EnumArt enumart : EnumArt.values()) {
            if (!enumart.field_1624_y.equals(s2)) continue;
            this.field_690_b = enumart;
        }
        if (this.field_690_b == null) {
            this.field_690_b = EnumArt.Kebab;
        }
        this.func_412_b(this.field_691_a);
    }
}

