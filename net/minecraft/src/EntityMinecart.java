/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class EntityMinecart
extends Entity
implements IInventory {
    private ItemStack[] cargoItems = new ItemStack[36];
    public int field_864_a = 0;
    public int field_863_b = 0;
    public int field_862_c = 1;
    private boolean field_856_i = false;
    public int minecartType;
    public int fuel;
    public double pushX;
    public double pushZ;
    private static final int[][][] field_855_j;
    private int field_9415_k;
    private double field_9414_l;
    private double field_9413_m;
    private double field_9412_n;
    private double field_9411_o;
    private double field_9410_p;
    private double field_9409_q;
    private double field_9408_r;
    private double field_9407_s;

    static {
        int[][][] arrarrn = new int[10][][];
        int[][] arrarrn2 = new int[2][];
        int[] arrn = new int[3];
        arrn[2] = -1;
        arrarrn2[0] = arrn;
        int[] arrn2 = new int[3];
        arrn2[2] = 1;
        arrarrn2[1] = arrn2;
        arrarrn[0] = arrarrn2;
        int[][] arrarrn3 = new int[2][];
        int[] arrn3 = new int[3];
        arrn3[0] = -1;
        arrarrn3[0] = arrn3;
        int[] arrn4 = new int[3];
        arrn4[0] = 1;
        arrarrn3[1] = arrn4;
        arrarrn[1] = arrarrn3;
        int[][] arrarrn4 = new int[2][];
        int[] arrn5 = new int[3];
        arrn5[0] = -1;
        arrn5[1] = -1;
        arrarrn4[0] = arrn5;
        int[] arrn6 = new int[3];
        arrn6[0] = 1;
        arrarrn4[1] = arrn6;
        arrarrn[2] = arrarrn4;
        int[][] arrarrn5 = new int[2][];
        int[] arrn7 = new int[3];
        arrn7[0] = -1;
        arrarrn5[0] = arrn7;
        int[] arrn8 = new int[3];
        arrn8[0] = 1;
        arrn8[1] = -1;
        arrarrn5[1] = arrn8;
        arrarrn[3] = arrarrn5;
        int[][] arrarrn6 = new int[2][];
        int[] arrn9 = new int[3];
        arrn9[2] = -1;
        arrarrn6[0] = arrn9;
        int[] arrn10 = new int[3];
        arrn10[1] = -1;
        arrn10[2] = 1;
        arrarrn6[1] = arrn10;
        arrarrn[4] = arrarrn6;
        int[][] arrarrn7 = new int[2][];
        int[] arrn11 = new int[3];
        arrn11[1] = -1;
        arrn11[2] = -1;
        arrarrn7[0] = arrn11;
        int[] arrn12 = new int[3];
        arrn12[2] = 1;
        arrarrn7[1] = arrn12;
        arrarrn[5] = arrarrn7;
        int[][] arrarrn8 = new int[2][];
        int[] arrn13 = new int[3];
        arrn13[2] = 1;
        arrarrn8[0] = arrn13;
        int[] arrn14 = new int[3];
        arrn14[0] = 1;
        arrarrn8[1] = arrn14;
        arrarrn[6] = arrarrn8;
        int[][] arrarrn9 = new int[2][];
        int[] arrn15 = new int[3];
        arrn15[2] = 1;
        arrarrn9[0] = arrn15;
        int[] arrn16 = new int[3];
        arrn16[0] = -1;
        arrarrn9[1] = arrn16;
        arrarrn[7] = arrarrn9;
        int[][] arrarrn10 = new int[2][];
        int[] arrn17 = new int[3];
        arrn17[2] = -1;
        arrarrn10[0] = arrn17;
        int[] arrn18 = new int[3];
        arrn18[0] = -1;
        arrarrn10[1] = arrn18;
        arrarrn[8] = arrarrn10;
        int[][] arrarrn11 = new int[2][];
        int[] arrn19 = new int[3];
        arrn19[2] = -1;
        arrarrn11[0] = arrn19;
        int[] arrn20 = new int[3];
        arrn20[0] = 1;
        arrarrn11[1] = arrn20;
        arrarrn[9] = arrarrn11;
        field_855_j = arrarrn;
    }

    public EntityMinecart(World world) {
        super(world);
        this.field_618_ad = true;
        this.setSize(0.98f, 0.7f);
        this.yOffset = this.height / 2.0f;
        this.entityWalks = false;
    }

    @Override
    public AxisAlignedBB func_383_b_(Entity entity) {
        return entity.boundingBox;
    }

    @Override
    public AxisAlignedBB func_372_f_() {
        return null;
    }

    @Override
    public boolean canBePushed() {
        return true;
    }

    public EntityMinecart(World world, double d2, double d1, double d22, int i2) {
        this(world);
        this.setPosition(d2, d1 + (double)this.yOffset, d22);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = d2;
        this.prevPosY = d1;
        this.prevPosZ = d22;
        this.minecartType = i2;
    }

    @Override
    public double func_402_h() {
        return (double)this.height * 0.0 - (double)0.3f;
    }

    @Override
    public boolean canAttackEntity(Entity entity, int i2) {
        if (this.worldObj.multiplayerWorld || this.isDead) {
            return true;
        }
        this.field_862_c = -this.field_862_c;
        this.field_863_b = 10;
        this.func_9281_M();
        this.field_864_a += i2 * 10;
        if (this.field_864_a > 40) {
            this.dropItemWithOffset(Item.minecartEmpty.shiftedIndex, 1, 0.0f);
            if (this.minecartType == 1) {
                this.dropItemWithOffset(Block.crate.blockID, 1, 0.0f);
            } else if (this.minecartType == 2) {
                this.dropItemWithOffset(Block.stoneOvenIdle.blockID, 1, 0.0f);
            }
            this.setEntityDead();
        }
        return true;
    }

    @Override
    public void func_9280_g() {
        System.out.println("Animating hurt");
        this.field_862_c = -this.field_862_c;
        this.field_863_b = 10;
        this.field_864_a += this.field_864_a * 10;
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    public void setEntityDead() {
        for (int i2 = 0; i2 < this.getSizeInventory(); ++i2) {
            ItemStack itemstack = this.getStackInSlot(i2);
            if (itemstack == null) continue;
            float f2 = this.rand.nextFloat() * 0.8f + 0.1f;
            float f1 = this.rand.nextFloat() * 0.8f + 0.1f;
            float f22 = this.rand.nextFloat() * 0.8f + 0.1f;
            while (itemstack.stackSize > 0) {
                int j2 = this.rand.nextInt(21) + 10;
                if (j2 > itemstack.stackSize) {
                    j2 = itemstack.stackSize;
                }
                itemstack.stackSize -= j2;
                EntityItem entityitem = new EntityItem(this.worldObj, this.posX + (double)f2, this.posY + (double)f1, this.posZ + (double)f22, new ItemStack(itemstack.itemID, j2, itemstack.itemDamage));
                float f3 = 0.05f;
                entityitem.motionX = (float)this.rand.nextGaussian() * f3;
                entityitem.motionY = (float)this.rand.nextGaussian() * f3 + 0.2f;
                entityitem.motionZ = (float)this.rand.nextGaussian() * f3;
                this.worldObj.entityJoinedWorld(entityitem);
            }
        }
        super.setEntityDead();
    }

    @Override
    public void onUpdate() {
        double d9;
        int k2;
        int j2;
        if (this.field_863_b > 0) {
            --this.field_863_b;
        }
        if (this.field_864_a > 0) {
            --this.field_864_a;
        }
        if (this.worldObj.multiplayerWorld && this.field_9415_k > 0) {
            if (this.field_9415_k > 0) {
                double d4;
                double d2 = this.posX + (this.field_9414_l - this.posX) / (double)this.field_9415_k;
                double d1 = this.posY + (this.field_9413_m - this.posY) / (double)this.field_9415_k;
                double d3 = this.posZ + (this.field_9412_n - this.posZ) / (double)this.field_9415_k;
                for (d4 = this.field_9411_o - (double)this.rotationYaw; d4 < -180.0; d4 += 360.0) {
                }
                while (d4 >= 180.0) {
                    d4 -= 360.0;
                }
                this.rotationYaw = (float)((double)this.rotationYaw + d4 / (double)this.field_9415_k);
                this.rotationPitch = (float)((double)this.rotationPitch + (this.field_9410_p - (double)this.rotationPitch) / (double)this.field_9415_k);
                --this.field_9415_k;
                this.setPosition(d2, d1, d3);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            } else {
                this.setPosition(this.posX, this.posY, this.posZ);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            }
            return;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= (double)0.04f;
        int i2 = MathHelper.floor_double(this.posX);
        if (this.worldObj.getBlockId(i2, (j2 = MathHelper.floor_double(this.posY)) - 1, k2 = MathHelper.floor_double(this.posZ)) == Block.minecartTrack.blockID) {
            --j2;
        }
        double d2 = 0.4;
        boolean flag = false;
        double d5 = 0.0078125;
        if (this.worldObj.getBlockId(i2, j2, k2) == Block.minecartTrack.blockID) {
            double d29;
            Vec3D vec3d = this.func_514_g(this.posX, this.posY, this.posZ);
            int l2 = this.worldObj.getBlockMetadata(i2, j2, k2);
            this.posY = j2;
            if (l2 >= 2 && l2 <= 5) {
                this.posY = j2 + 1;
            }
            if (l2 == 2) {
                this.motionX -= d5;
            }
            if (l2 == 3) {
                this.motionX += d5;
            }
            if (l2 == 4) {
                this.motionZ += d5;
            }
            if (l2 == 5) {
                this.motionZ -= d5;
            }
            int[][] ai2 = field_855_j[l2];
            double d8 = ai2[1][0] - ai2[0][0];
            double d10 = ai2[1][2] - ai2[0][2];
            double d11 = Math.sqrt(d8 * d8 + d10 * d10);
            double d12 = this.motionX * d8 + this.motionZ * d10;
            if (d12 < 0.0) {
                d8 = -d8;
                d10 = -d10;
            }
            double d13 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.motionX = d13 * d8 / d11;
            this.motionZ = d13 * d10 / d11;
            double d16 = 0.0;
            double d17 = (double)i2 + 0.5 + (double)ai2[0][0] * 0.5;
            double d18 = (double)k2 + 0.5 + (double)ai2[0][2] * 0.5;
            double d19 = (double)i2 + 0.5 + (double)ai2[1][0] * 0.5;
            double d20 = (double)k2 + 0.5 + (double)ai2[1][2] * 0.5;
            d8 = d19 - d17;
            d10 = d20 - d18;
            if (d8 == 0.0) {
                this.posX = (double)i2 + 0.5;
                d16 = this.posZ - (double)k2;
            } else if (d10 == 0.0) {
                this.posZ = (double)k2 + 0.5;
                d16 = this.posX - (double)i2;
            } else {
                double d25;
                double d21 = this.posX - d17;
                double d23 = this.posZ - d18;
                d16 = d25 = (d21 * d8 + d23 * d10) * 2.0;
            }
            this.posX = d17 + d8 * d16;
            this.posZ = d18 + d10 * d16;
            this.setPosition(this.posX, this.posY + (double)this.yOffset, this.posZ);
            double d22 = this.motionX;
            double d24 = this.motionZ;
            if (this.riddenByEntity != null) {
                d22 *= 0.75;
                d24 *= 0.75;
            }
            if (d22 < -d2) {
                d22 = -d2;
            }
            if (d22 > d2) {
                d22 = d2;
            }
            if (d24 < -d2) {
                d24 = -d2;
            }
            if (d24 > d2) {
                d24 = d2;
            }
            this.moveEntity(d22, 0.0, d24);
            if (ai2[0][1] != 0 && MathHelper.floor_double(this.posX) - i2 == ai2[0][0] && MathHelper.floor_double(this.posZ) - k2 == ai2[0][2]) {
                this.setPosition(this.posX, this.posY + (double)ai2[0][1], this.posZ);
            } else if (ai2[1][1] != 0 && MathHelper.floor_double(this.posX) - i2 == ai2[1][0] && MathHelper.floor_double(this.posZ) - k2 == ai2[1][2]) {
                this.setPosition(this.posX, this.posY + (double)ai2[1][1], this.posZ);
            }
            if (this.riddenByEntity != null) {
                this.motionX *= (double)0.997f;
                this.motionY *= 0.0;
                this.motionZ *= (double)0.997f;
            } else {
                if (this.minecartType == 2) {
                    double d26 = MathHelper.sqrt_double(this.pushX * this.pushX + this.pushZ * this.pushZ);
                    if (d26 > 0.01) {
                        flag = true;
                        this.pushX /= d26;
                        this.pushZ /= d26;
                        double d28 = 0.04;
                        this.motionX *= (double)0.8f;
                        this.motionY *= 0.0;
                        this.motionZ *= (double)0.8f;
                        this.motionX += this.pushX * d28;
                        this.motionZ += this.pushZ * d28;
                    } else {
                        this.motionX *= (double)0.9f;
                        this.motionY *= 0.0;
                        this.motionZ *= (double)0.9f;
                    }
                }
                this.motionX *= (double)0.96f;
                this.motionY *= 0.0;
                this.motionZ *= (double)0.96f;
            }
            Vec3D vec3d1 = this.func_514_g(this.posX, this.posY, this.posZ);
            if (vec3d1 != null && vec3d != null) {
                double d27 = (vec3d.yCoord - vec3d1.yCoord) * 0.05;
                double d14 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                if (d14 > 0.0) {
                    this.motionX = this.motionX / d14 * (d14 + d27);
                    this.motionZ = this.motionZ / d14 * (d14 + d27);
                }
                this.setPosition(this.posX, vec3d1.yCoord, this.posZ);
            }
            int j1 = MathHelper.floor_double(this.posX);
            int k1 = MathHelper.floor_double(this.posZ);
            if (j1 != i2 || k1 != k2) {
                double d15 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                this.motionX = d15 * (double)(j1 - i2);
                this.motionZ = d15 * (double)(k1 - k2);
            }
            if (this.minecartType == 2 && (d29 = (double)MathHelper.sqrt_double(this.pushX * this.pushX + this.pushZ * this.pushZ)) > 0.01 && this.motionX * this.motionX + this.motionZ * this.motionZ > 0.001) {
                this.pushX /= d29;
                this.pushZ /= d29;
                if (this.pushX * this.motionX + this.pushZ * this.motionZ < 0.0) {
                    this.pushX = 0.0;
                    this.pushZ = 0.0;
                } else {
                    this.pushX = this.motionX;
                    this.pushZ = this.motionZ;
                }
            }
        } else {
            if (this.motionX < -d2) {
                this.motionX = -d2;
            }
            if (this.motionX > d2) {
                this.motionX = d2;
            }
            if (this.motionZ < -d2) {
                this.motionZ = -d2;
            }
            if (this.motionZ > d2) {
                this.motionZ = d2;
            }
            if (this.onGround) {
                this.motionX *= 0.5;
                this.motionY *= 0.5;
                this.motionZ *= 0.5;
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            if (!this.onGround) {
                this.motionX *= (double)0.95f;
                this.motionY *= (double)0.95f;
                this.motionZ *= (double)0.95f;
            }
        }
        this.rotationPitch = 0.0f;
        double d6 = this.prevPosX - this.posX;
        double d7 = this.prevPosZ - this.posZ;
        if (d6 * d6 + d7 * d7 > 0.001) {
            this.rotationYaw = (float)(Math.atan2(d7, d6) * 180.0 / Math.PI);
            if (this.field_856_i) {
                this.rotationYaw += 180.0f;
            }
        }
        for (d9 = (double)(this.rotationYaw - this.prevRotationYaw); d9 >= 180.0; d9 -= 360.0) {
        }
        while (d9 < -180.0) {
            d9 += 360.0;
        }
        if (d9 < -170.0 || d9 >= 170.0) {
            this.rotationYaw += 180.0f;
            this.field_856_i = !this.field_856_i;
        }
        this.setRotation(this.rotationYaw, this.rotationPitch);
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expands(0.2f, 0.0, 0.2f));
        if (list != null && list.size() > 0) {
            for (int i1 = 0; i1 < list.size(); ++i1) {
                Entity entity = (Entity)list.get(i1);
                if (entity == this.riddenByEntity || !entity.canBePushed() || !(entity instanceof EntityMinecart)) continue;
                entity.applyEntityCollision(this);
            }
        }
        if (this.riddenByEntity != null && this.riddenByEntity.isDead) {
            this.riddenByEntity = null;
        }
        if (flag && this.rand.nextInt(4) == 0) {
            --this.fuel;
            if (this.fuel < 0) {
                this.pushZ = 0.0;
                this.pushX = 0.0;
            }
            this.worldObj.spawnParticle("largesmoke", this.posX, this.posY + 0.8, this.posZ, 0.0, 0.0, 0.0);
        }
    }

    public Vec3D func_515_a(double d2, double d1, double d22, double d3) {
        int k2;
        int j2;
        int i2 = MathHelper.floor_double(d2);
        if (this.worldObj.getBlockId(i2, (j2 = MathHelper.floor_double(d1)) - 1, k2 = MathHelper.floor_double(d22)) == Block.minecartTrack.blockID) {
            --j2;
        }
        if (this.worldObj.getBlockId(i2, j2, k2) == Block.minecartTrack.blockID) {
            int l2 = this.worldObj.getBlockMetadata(i2, j2, k2);
            d1 = j2;
            if (l2 >= 2 && l2 <= 5) {
                d1 = j2 + 1;
            }
            int[][] ai2 = field_855_j[l2];
            double d4 = ai2[1][0] - ai2[0][0];
            double d5 = ai2[1][2] - ai2[0][2];
            double d6 = Math.sqrt(d4 * d4 + d5 * d5);
            if (ai2[0][1] != 0 && MathHelper.floor_double(d2 += (d4 /= d6) * d3) - i2 == ai2[0][0] && MathHelper.floor_double(d22 += (d5 /= d6) * d3) - k2 == ai2[0][2]) {
                d1 += (double)ai2[0][1];
            } else if (ai2[1][1] != 0 && MathHelper.floor_double(d2) - i2 == ai2[1][0] && MathHelper.floor_double(d22) - k2 == ai2[1][2]) {
                d1 += (double)ai2[1][1];
            }
            return this.func_514_g(d2, d1, d22);
        }
        return null;
    }

    public Vec3D func_514_g(double d2, double d1, double d22) {
        int k2;
        int j2;
        int i2 = MathHelper.floor_double(d2);
        if (this.worldObj.getBlockId(i2, (j2 = MathHelper.floor_double(d1)) - 1, k2 = MathHelper.floor_double(d22)) == Block.minecartTrack.blockID) {
            --j2;
        }
        if (this.worldObj.getBlockId(i2, j2, k2) == Block.minecartTrack.blockID) {
            int l2 = this.worldObj.getBlockMetadata(i2, j2, k2);
            d1 = j2;
            if (l2 >= 2 && l2 <= 5) {
                d1 = j2 + 1;
            }
            int[][] ai2 = field_855_j[l2];
            double d3 = 0.0;
            double d4 = (double)i2 + 0.5 + (double)ai2[0][0] * 0.5;
            double d5 = (double)j2 + 0.5 + (double)ai2[0][1] * 0.5;
            double d6 = (double)k2 + 0.5 + (double)ai2[0][2] * 0.5;
            double d7 = (double)i2 + 0.5 + (double)ai2[1][0] * 0.5;
            double d8 = (double)j2 + 0.5 + (double)ai2[1][1] * 0.5;
            double d9 = (double)k2 + 0.5 + (double)ai2[1][2] * 0.5;
            double d10 = d7 - d4;
            double d11 = (d8 - d5) * 2.0;
            double d12 = d9 - d6;
            if (d10 == 0.0) {
                d2 = (double)i2 + 0.5;
                d3 = d22 - (double)k2;
            } else if (d12 == 0.0) {
                d22 = (double)k2 + 0.5;
                d3 = d2 - (double)i2;
            } else {
                double d15;
                double d13 = d2 - d4;
                double d14 = d22 - d6;
                d3 = d15 = (d13 * d10 + d14 * d12) * 2.0;
            }
            d2 = d4 + d10 * d3;
            d1 = d5 + d11 * d3;
            d22 = d6 + d12 * d3;
            if (d11 < 0.0) {
                d1 += 1.0;
            }
            if (d11 > 0.0) {
                d1 += 0.5;
            }
            return Vec3D.createVector(d2, d1, d22);
        }
        return null;
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setInteger("Type", this.minecartType);
        if (this.minecartType == 2) {
            nbttagcompound.setDouble("PushX", this.pushX);
            nbttagcompound.setDouble("PushZ", this.pushZ);
            nbttagcompound.setShort("Fuel", (short)this.fuel);
        } else if (this.minecartType == 1) {
            NBTTagList nbttaglist = new NBTTagList();
            for (int i2 = 0; i2 < this.cargoItems.length; ++i2) {
                if (this.cargoItems[i2] == null) continue;
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i2);
                this.cargoItems[i2].writeToNBT(nbttagcompound1);
                nbttaglist.setTag(nbttagcompound1);
            }
            nbttagcompound.setTag("Items", nbttaglist);
        }
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        this.minecartType = nbttagcompound.getInteger("Type");
        if (this.minecartType == 2) {
            this.pushX = nbttagcompound.getDouble("PushX");
            this.pushZ = nbttagcompound.getDouble("PushZ");
            this.fuel = nbttagcompound.getShort("Fuel");
        } else if (this.minecartType == 1) {
            NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
            this.cargoItems = new ItemStack[this.getSizeInventory()];
            for (int i2 = 0; i2 < nbttaglist.tagCount(); ++i2) {
                NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i2);
                int j2 = nbttagcompound1.getByte("Slot") & 0xFF;
                if (j2 < 0 || j2 >= this.cargoItems.length) continue;
                this.cargoItems[j2] = new ItemStack(nbttagcompound1);
            }
        }
    }

    @Override
    public float func_392_h_() {
        return 0.0f;
    }

    @Override
    public void applyEntityCollision(Entity entity) {
        double d1;
        double d2;
        double d22;
        if (this.worldObj.multiplayerWorld) {
            return;
        }
        if (entity == this.riddenByEntity) {
            return;
        }
        if (entity instanceof EntityLiving && !(entity instanceof EntityPlayer) && this.minecartType == 0 && this.motionX * this.motionX + this.motionZ * this.motionZ > 0.01 && this.riddenByEntity == null && entity.ridingEntity == null) {
            entity.mountEntity(this);
        }
        if ((d22 = (d2 = entity.posX - this.posX) * d2 + (d1 = entity.posZ - this.posZ) * d1) >= (double)1.0E-4f) {
            d22 = MathHelper.sqrt_double(d22);
            d2 /= d22;
            d1 /= d22;
            double d3 = 1.0 / d22;
            if (d3 > 1.0) {
                d3 = 1.0;
            }
            d2 *= d3;
            d1 *= d3;
            d2 *= (double)0.1f;
            d1 *= (double)0.1f;
            d2 *= (double)(1.0f - this.field_632_aO);
            d1 *= (double)(1.0f - this.field_632_aO);
            d2 *= 0.5;
            d1 *= 0.5;
            if (entity instanceof EntityMinecart) {
                double d4 = entity.motionX + this.motionX;
                double d5 = entity.motionZ + this.motionZ;
                if (((EntityMinecart)entity).minecartType == 2 && this.minecartType != 2) {
                    this.motionX *= (double)0.2f;
                    this.motionZ *= (double)0.2f;
                    this.addVelocity(entity.motionX - d2, 0.0, entity.motionZ - d1);
                    entity.motionX *= (double)0.7f;
                    entity.motionZ *= (double)0.7f;
                } else if (((EntityMinecart)entity).minecartType != 2 && this.minecartType == 2) {
                    entity.motionX *= (double)0.2f;
                    entity.motionZ *= (double)0.2f;
                    entity.addVelocity(this.motionX + d2, 0.0, this.motionZ + d1);
                    this.motionX *= (double)0.7f;
                    this.motionZ *= (double)0.7f;
                } else {
                    this.motionX *= (double)0.2f;
                    this.motionZ *= (double)0.2f;
                    this.addVelocity((d4 /= 2.0) - d2, 0.0, (d5 /= 2.0) - d1);
                    entity.motionX *= (double)0.2f;
                    entity.motionZ *= (double)0.2f;
                    entity.addVelocity(d4 + d2, 0.0, d5 + d1);
                }
            } else {
                this.addVelocity(-d2, 0.0, -d1);
                entity.addVelocity(d2 / 4.0, 0.0, d1 / 4.0);
            }
        }
    }

    @Override
    public int getSizeInventory() {
        return 27;
    }

    @Override
    public ItemStack getStackInSlot(int i2) {
        return this.cargoItems[i2];
    }

    @Override
    public ItemStack decrStackSize(int i2, int j2) {
        if (this.cargoItems[i2] != null) {
            if (this.cargoItems[i2].stackSize <= j2) {
                ItemStack itemstack = this.cargoItems[i2];
                this.cargoItems[i2] = null;
                return itemstack;
            }
            ItemStack itemstack1 = this.cargoItems[i2].splitStack(j2);
            if (this.cargoItems[i2].stackSize == 0) {
                this.cargoItems[i2] = null;
            }
            return itemstack1;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int i2, ItemStack itemstack) {
        this.cargoItems[i2] = itemstack;
        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
            itemstack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInvName() {
        return "Minecart";
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void onInventoryChanged() {
    }

    @Override
    public boolean interact(EntityPlayer entityplayer) {
        if (this.minecartType == 0) {
            if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != entityplayer) {
                return true;
            }
            if (!this.worldObj.multiplayerWorld) {
                entityplayer.mountEntity(this);
            }
        } else if (this.minecartType == 1) {
            entityplayer.displayGUIChest(this);
        } else if (this.minecartType == 2) {
            ItemStack itemstack = entityplayer.inventory.getCurrentItem();
            if (itemstack != null && itemstack.itemID == Item.coal.shiftedIndex) {
                if (--itemstack.stackSize == 0) {
                    entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
                }
                this.fuel += 1200;
            }
            this.pushX = this.posX - entityplayer.posX;
            this.pushZ = this.posZ - entityplayer.posZ;
        }
        return true;
    }

    @Override
    public void setPositionAndRotation2(double d2, double d1, double d22, float f2, float f1, int i2) {
        this.field_9414_l = d2;
        this.field_9413_m = d1;
        this.field_9412_n = d22;
        this.field_9411_o = f2;
        this.field_9410_p = f1;
        this.field_9415_k = i2 + 2;
        this.motionX = this.field_9409_q;
        this.motionY = this.field_9408_r;
        this.motionZ = this.field_9407_s;
    }

    @Override
    public void setVelocity(double d2, double d1, double d22) {
        this.field_9409_q = this.motionX = d2;
        this.field_9408_r = this.motionY = d1;
        this.field_9407_s = this.motionZ = d22;
    }
}

