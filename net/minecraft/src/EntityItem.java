/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityItem
extends Entity {
    public ItemStack item;
    private int field_803_e;
    public int age = 0;
    public int field_805_c;
    private int health = 5;
    public float field_804_d = (float)(Math.random() * Math.PI * 2.0);

    public EntityItem(World world, double d2, double d1, double d22, ItemStack itemstack) {
        super(world);
        this.setSize(0.25f, 0.25f);
        this.yOffset = this.height / 2.0f;
        this.setPosition(d2, d1, d22);
        this.item = itemstack;
        this.rotationYaw = (float)(Math.random() * 360.0);
        this.motionX = (float)(Math.random() * (double)0.2f - (double)0.1f);
        this.motionY = 0.2f;
        this.motionZ = (float)(Math.random() * (double)0.2f - (double)0.1f);
        this.entityWalks = false;
    }

    public EntityItem(World world) {
        super(world);
        this.setSize(0.25f, 0.25f);
        this.yOffset = this.height / 2.0f;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.field_805_c > 0) {
            --this.field_805_c;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= (double)0.04f;
        if (this.worldObj.getBlockMaterial(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) == Material.lava) {
            this.motionY = 0.2f;
            this.motionX = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
            this.motionZ = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
            this.worldObj.playSoundAtEntity(this, "random.fizz", 0.4f, 2.0f + this.rand.nextFloat() * 0.4f);
        }
        this.func_466_g(this.posX, this.posY, this.posZ);
        this.handleWaterMovement();
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        float f2 = 0.98f;
        if (this.onGround) {
            f2 = 0.5880001f;
            int i2 = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));
            if (i2 > 0) {
                f2 = Block.blocksList[i2].slipperiness * 0.98f;
            }
        }
        this.motionX *= (double)f2;
        this.motionY *= (double)0.98f;
        this.motionZ *= (double)f2;
        if (this.onGround) {
            this.motionY *= -0.5;
        }
        ++this.field_803_e;
        ++this.age;
        if (this.age >= 6000) {
            this.setEntityDead();
        }
    }

    @Override
    public boolean handleWaterMovement() {
        return this.worldObj.func_682_a(this.boundingBox, Material.water, this);
    }

    private boolean func_466_g(double d2, double d1, double d22) {
        int i2 = MathHelper.floor_double(d2);
        int j2 = MathHelper.floor_double(d1);
        int k2 = MathHelper.floor_double(d22);
        double d3 = d2 - (double)i2;
        double d4 = d1 - (double)j2;
        double d5 = d22 - (double)k2;
        if (Block.opaqueCubeLookup[this.worldObj.getBlockId(i2, j2, k2)]) {
            boolean flag = !Block.opaqueCubeLookup[this.worldObj.getBlockId(i2 - 1, j2, k2)];
            boolean flag1 = !Block.opaqueCubeLookup[this.worldObj.getBlockId(i2 + 1, j2, k2)];
            boolean flag2 = !Block.opaqueCubeLookup[this.worldObj.getBlockId(i2, j2 - 1, k2)];
            boolean flag3 = !Block.opaqueCubeLookup[this.worldObj.getBlockId(i2, j2 + 1, k2)];
            boolean flag4 = !Block.opaqueCubeLookup[this.worldObj.getBlockId(i2, j2, k2 - 1)];
            boolean flag5 = !Block.opaqueCubeLookup[this.worldObj.getBlockId(i2, j2, k2 + 1)];
            int byte0 = -1;
            double d6 = 9999.0;
            if (flag && d3 < d6) {
                d6 = d3;
                byte0 = 0;
            }
            if (flag1 && 1.0 - d3 < d6) {
                d6 = 1.0 - d3;
                byte0 = 1;
            }
            if (flag2 && d4 < d6) {
                d6 = d4;
                byte0 = 2;
            }
            if (flag3 && 1.0 - d4 < d6) {
                d6 = 1.0 - d4;
                byte0 = 3;
            }
            if (flag4 && d5 < d6) {
                d6 = d5;
                byte0 = 4;
            }
            if (flag5 && 1.0 - d5 < d6) {
                double d7 = 1.0 - d5;
                byte0 = 5;
            }
            float f2 = this.rand.nextFloat() * 0.2f + 0.1f;
            if (byte0 == 0) {
                this.motionX = -f2;
            }
            if (byte0 == 1) {
                this.motionX = f2;
            }
            if (byte0 == 2) {
                this.motionY = -f2;
            }
            if (byte0 == 3) {
                this.motionY = f2;
            }
            if (byte0 == 4) {
                this.motionZ = -f2;
            }
            if (byte0 == 5) {
                this.motionZ = f2;
            }
        }
        return false;
    }

    @Override
    protected void func_355_a(int i2) {
        this.canAttackEntity(null, i2);
    }

    @Override
    public boolean canAttackEntity(Entity entity, int i2) {
        this.func_9281_M();
        this.health -= i2;
        if (this.health <= 0) {
            this.setEntityDead();
        }
        return false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setShort("Health", (byte)this.health);
        nbttagcompound.setShort("Age", (short)this.age);
        nbttagcompound.setCompoundTag("Item", this.item.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        this.health = nbttagcompound.getShort("Health") & 0xFF;
        this.age = nbttagcompound.getShort("Age");
        NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("Item");
        this.item = new ItemStack(nbttagcompound1);
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityplayer) {
        if (this.worldObj.multiplayerWorld) {
            return;
        }
        int i2 = this.item.stackSize;
        if (this.field_805_c == 0 && entityplayer.inventory.addItemStackToInventory(this.item)) {
            this.worldObj.playSoundAtEntity(this, "random.pop", 0.2f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            entityplayer.func_443_a_(this, i2);
            this.setEntityDead();
        }
    }
}

