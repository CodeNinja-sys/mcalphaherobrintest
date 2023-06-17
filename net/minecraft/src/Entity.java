/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFluids;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagDouble;
import net.minecraft.src.NBTTagFloat;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.StepSound;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public abstract class Entity {
    private static int field_864_a = 0;
    public int field_620_ab;
    public double field_619_ac = 1.0;
    public boolean field_618_ad = false;
    public Entity riddenByEntity;
    public Entity ridingEntity;
    public World worldObj;
    public double prevPosX;
    public double prevPosY;
    public double prevPosZ;
    public double posX;
    public double posY;
    public double posZ;
    public double motionX;
    public double motionY;
    public double motionZ;
    public float rotationYaw;
    public float rotationPitch;
    public float prevRotationYaw;
    public float prevRotationPitch;
    public final AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    public boolean onGround = false;
    public boolean field_9297_aI;
    public boolean field_9296_aJ;
    public boolean field_9295_aK = false;
    public boolean field_9294_aL = false;
    public boolean field_9293_aM = true;
    public boolean isDead = false;
    public float yOffset = 0.0f;
    public float width = 0.6f;
    public float height = 1.8f;
    public float field_9291_aR = 0.0f;
    public float field_9290_aS = 0.0f;
    protected boolean entityWalks = true;
    protected float fallDistance = 0.0f;
    private int field_863_b = 1;
    public double lastTickPosX;
    public double lastTickPosY;
    public double lastTickPosZ;
    public float field_9287_aY = 0.0f;
    public float field_9286_aZ = 0.0f;
    public boolean field_9314_ba = false;
    public float field_632_aO = 0.0f;
    public boolean field_9313_bc = false;
    protected Random rand;
    public int field_9311_be = 0;
    public int field_9310_bf = 1;
    public int fire = 0;
    protected int field_9308_bh = 300;
    protected boolean field_9307_bi = false;
    public int field_9306_bj = 0;
    public int air = 300;
    private boolean field_862_c = true;
    public String skinUrl;
    protected boolean isImmuneToFire = false;
    private double minecartType;
    private double field_667_e;
    public boolean field_621_aZ = false;
    public int field_657_ba;
    public int field_656_bb;
    public int field_654_bc;
    public int field_9303_br;
    public int field_9302_bs;
    public int field_9301_bt;
    public boolean field_9300_bu;
    public boolean field_9299_bv;
    public boolean field_12240_bw;

    public Entity(World world) {
        this.field_620_ab = field_864_a++;
        this.rand = new Random();
        this.worldObj = world;
        this.setPosition(0.0, 0.0, 0.0);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Entity) {
            return ((Entity)obj).field_620_ab == this.field_620_ab;
        }
        return false;
    }

    public int hashCode() {
        return this.field_620_ab;
    }

    protected void preparePlayerToSpawn() {
        if (this.worldObj == null) {
            return;
        }
        while (!(this.posY <= 0.0)) {
            this.setPosition(this.posX, this.posY, this.posZ);
            if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0) break;
            this.posY += 1.0;
        }
        this.motionZ = 0.0;
        this.motionY = 0.0;
        this.motionX = 0.0;
        this.rotationPitch = 0.0f;
    }

    public void setEntityDead() {
        this.isDead = true;
    }

    protected void setSize(float f2, float f1) {
        this.width = f2;
        this.height = f1;
    }

    protected void setRotation(float f2, float f1) {
        this.rotationYaw = f2;
        this.rotationPitch = f1;
    }

    public void setPosition(double d2, double d1, double d22) {
        this.posX = d2;
        this.posY = d1;
        this.posZ = d22;
        float f2 = this.width / 2.0f;
        float f1 = this.height;
        this.boundingBox.setBounds(d2 - (double)f2, d1 - (double)this.yOffset + (double)this.field_9287_aY, d22 - (double)f2, d2 + (double)f2, d1 - (double)this.yOffset + (double)this.field_9287_aY + (double)f1, d22 + (double)f2);
    }

    public void func_346_d(float f2, float f1) {
        float f22 = this.rotationPitch;
        float f3 = this.rotationYaw;
        this.rotationYaw = (float)((double)this.rotationYaw + (double)f2 * 0.15);
        this.rotationPitch = (float)((double)this.rotationPitch - (double)f1 * 0.15);
        if (this.rotationPitch < -90.0f) {
            this.rotationPitch = -90.0f;
        }
        if (this.rotationPitch > 90.0f) {
            this.rotationPitch = 90.0f;
        }
        this.prevRotationPitch += this.rotationPitch - f22;
        this.prevRotationYaw += this.rotationYaw - f3;
    }

    public void onUpdate() {
        this.func_391_y();
    }

    public void func_391_y() {
        if (this.ridingEntity != null && this.ridingEntity.isDead) {
            this.ridingEntity = null;
        }
        ++this.field_9311_be;
        this.field_9291_aR = this.field_9290_aS;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.prevRotationPitch = this.rotationPitch;
        this.prevRotationYaw = this.rotationYaw;
        if (this.handleWaterMovement()) {
            if (!this.field_9307_bi && !this.field_862_c) {
                float f2 = MathHelper.sqrt_double(this.motionX * this.motionX * (double)0.2f + this.motionY * this.motionY + this.motionZ * this.motionZ * (double)0.2f) * 0.2f;
                if (f2 > 1.0f) {
                    f2 = 1.0f;
                }
                this.worldObj.playSoundAtEntity(this, "random.splash", f2, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                float f1 = MathHelper.floor_double(this.boundingBox.minY);
                int i2 = 0;
                while ((float)i2 < 1.0f + this.width * 20.0f) {
                    float f22 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                    float f4 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                    this.worldObj.spawnParticle("bubble", this.posX + (double)f22, f1 + 1.0f, this.posZ + (double)f4, this.motionX, this.motionY - (double)(this.rand.nextFloat() * 0.2f), this.motionZ);
                    ++i2;
                }
                int j2 = 0;
                while ((float)j2 < 1.0f + this.width * 20.0f) {
                    float f3 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                    float f5 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
                    this.worldObj.spawnParticle("splash", this.posX + (double)f3, f1 + 1.0f, this.posZ + (double)f5, this.motionX, this.motionY, this.motionZ);
                    ++j2;
                }
            }
            this.fallDistance = 0.0f;
            this.field_9307_bi = true;
            this.fire = 0;
        } else {
            this.field_9307_bi = false;
        }
        if (this.worldObj.multiplayerWorld) {
            this.fire = 0;
        } else if (this.fire > 0) {
            if (this.isImmuneToFire) {
                this.fire -= 4;
                if (this.fire < 0) {
                    this.fire = 0;
                }
            } else {
                if (this.fire % 20 == 0) {
                    this.canAttackEntity(null, 1);
                }
                --this.fire;
            }
        }
        if (this.handleLavaMovement()) {
            this.func_4038_J();
        }
        if (this.posY < -64.0) {
            this.func_4034_G();
        }
        this.field_862_c = false;
    }

    protected void func_4038_J() {
        if (!this.isImmuneToFire) {
            this.canAttackEntity(null, 4);
            this.fire = 600;
        }
    }

    protected void func_4034_G() {
        this.setEntityDead();
    }

    public boolean func_403_b(double d2, double d1, double d22) {
        AxisAlignedBB axisalignedbb = this.boundingBox.getOffsetBoundingBox(d2, d1, d22);
        List list = this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb);
        if (list.size() > 0) {
            return false;
        }
        return !this.worldObj.getIsAnyLiquid(axisalignedbb);
    }

    public void moveEntity(double d2, double d1, double d22) {
        boolean flag;
        if (this.field_9314_ba) {
            this.boundingBox.offset(d2, d1, d22);
            this.posX = (this.boundingBox.minX + this.boundingBox.maxX) / 2.0;
            this.posY = this.boundingBox.minY + (double)this.yOffset - (double)this.field_9287_aY;
            this.posZ = (this.boundingBox.minZ + this.boundingBox.maxZ) / 2.0;
            return;
        }
        double d3 = this.posX;
        double d4 = this.posZ;
        double d5 = d2;
        double d6 = d1;
        double d7 = d22;
        AxisAlignedBB axisalignedbb = this.boundingBox.copy();
        boolean bl2 = flag = this.onGround && this.func_381_o();
        if (flag) {
            double d8 = 0.05;
            while (d2 != 0.0 && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox.getOffsetBoundingBox(d2, -1.0, 0.0)).size() == 0) {
                d2 = d2 < d8 && d2 >= -d8 ? 0.0 : (d2 > 0.0 ? (d2 -= d8) : (d2 += d8));
                d5 = d2;
            }
            while (d22 != 0.0 && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox.getOffsetBoundingBox(0.0, -1.0, d22)).size() == 0) {
                d22 = d22 < d8 && d22 >= -d8 ? 0.0 : (d22 > 0.0 ? (d22 -= d8) : (d22 += d8));
                d7 = d22;
            }
        }
        List list = this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox.addCoord(d2, d1, d22));
        for (int i2 = 0; i2 < list.size(); ++i2) {
            d1 = ((AxisAlignedBB)list.get(i2)).func_1172_b(this.boundingBox, d1);
        }
        this.boundingBox.offset(0.0, d1, 0.0);
        if (!this.field_9293_aM && d6 != d1) {
            d22 = 0.0;
            d1 = 0.0;
            d2 = 0.0;
        }
        boolean flag1 = this.onGround || d6 != d1 && d6 < 0.0;
        for (int j2 = 0; j2 < list.size(); ++j2) {
            d2 = ((AxisAlignedBB)list.get(j2)).func_1163_a(this.boundingBox, d2);
        }
        this.boundingBox.offset(d2, 0.0, 0.0);
        if (!this.field_9293_aM && d5 != d2) {
            d22 = 0.0;
            d1 = 0.0;
            d2 = 0.0;
        }
        for (int k2 = 0; k2 < list.size(); ++k2) {
            d22 = ((AxisAlignedBB)list.get(k2)).func_1162_c(this.boundingBox, d22);
        }
        this.boundingBox.offset(0.0, 0.0, d22);
        if (!this.field_9293_aM && d7 != d22) {
            d22 = 0.0;
            d1 = 0.0;
            d2 = 0.0;
        }
        if (this.field_9286_aZ > 0.0f && flag1 && this.field_9287_aY < 0.05f && (d5 != d2 || d7 != d22)) {
            double d9 = d2;
            double d11 = d1;
            double d13 = d22;
            d2 = d5;
            d1 = this.field_9286_aZ;
            d22 = d7;
            AxisAlignedBB axisalignedbb1 = this.boundingBox.copy();
            this.boundingBox.setBB(axisalignedbb);
            List list1 = this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox.addCoord(d2, d1, d22));
            for (int j2 = 0; j2 < list1.size(); ++j2) {
                d1 = ((AxisAlignedBB)list1.get(j2)).func_1172_b(this.boundingBox, d1);
            }
            this.boundingBox.offset(0.0, d1, 0.0);
            if (!this.field_9293_aM && d6 != d1) {
                d22 = 0.0;
                d1 = 0.0;
                d2 = 0.0;
            }
            for (int k2 = 0; k2 < list1.size(); ++k2) {
                d2 = ((AxisAlignedBB)list1.get(k2)).func_1163_a(this.boundingBox, d2);
            }
            this.boundingBox.offset(d2, 0.0, 0.0);
            if (!this.field_9293_aM && d5 != d2) {
                d22 = 0.0;
                d1 = 0.0;
                d2 = 0.0;
            }
            for (int l2 = 0; l2 < list1.size(); ++l2) {
                d22 = ((AxisAlignedBB)list1.get(l2)).func_1162_c(this.boundingBox, d22);
            }
            this.boundingBox.offset(0.0, 0.0, d22);
            if (!this.field_9293_aM && d7 != d22) {
                d22 = 0.0;
                d1 = 0.0;
                d2 = 0.0;
            }
            if (d9 * d9 + d13 * d13 >= d2 * d2 + d22 * d22) {
                d2 = d9;
                d1 = d11;
                d22 = d13;
                this.boundingBox.setBB(axisalignedbb1);
            } else {
                this.field_9287_aY = (float)((double)this.field_9287_aY + 0.5);
            }
        }
        this.posX = (this.boundingBox.minX + this.boundingBox.maxX) / 2.0;
        this.posY = this.boundingBox.minY + (double)this.yOffset - (double)this.field_9287_aY;
        this.posZ = (this.boundingBox.minZ + this.boundingBox.maxZ) / 2.0;
        this.field_9297_aI = d5 != d2 || d7 != d22;
        this.field_9296_aJ = d6 != d1;
        this.onGround = d6 != d1 && d6 < 0.0;
        this.field_9295_aK = this.field_9297_aI || this.field_9296_aJ;
        this.func_9279_a(d1, this.onGround);
        if (d5 != d2) {
            this.motionX = 0.0;
        }
        if (d6 != d1) {
            this.motionY = 0.0;
        }
        if (d7 != d22) {
            this.motionZ = 0.0;
        }
        double d10 = this.posX - d3;
        double d12 = this.posZ - d4;
        if (this.entityWalks && !flag) {
            this.field_9290_aS = (float)((double)this.field_9290_aS + (double)MathHelper.sqrt_double(d10 * d10 + d12 * d12) * 0.6);
            int l2 = MathHelper.floor_double(this.posX);
            int j1 = MathHelper.floor_double(this.posY - (double)0.2f - (double)this.yOffset);
            int l1 = MathHelper.floor_double(this.posZ);
            int i3 = this.worldObj.getBlockId(l2, j1, l1);
            if (this.field_9290_aS > (float)this.field_863_b && i3 > 0) {
                ++this.field_863_b;
                StepSound stepsound = Block.blocksList[i3].stepSound;
                if (this.worldObj.getBlockId(l2, j1 + 1, l1) == Block.snow.blockID) {
                    stepsound = Block.snow.stepSound;
                    this.worldObj.playSoundAtEntity(this, stepsound.func_1145_d(), stepsound.func_1147_b() * 0.15f, stepsound.func_1144_c());
                } else if (!Block.blocksList[i3].blockMaterial.getIsLiquid()) {
                    this.worldObj.playSoundAtEntity(this, stepsound.func_1145_d(), stepsound.func_1147_b() * 0.15f, stepsound.func_1144_c());
                }
                Block.blocksList[i3].onEntityWalking(this.worldObj, l2, j1, l1, this);
            }
        }
        int i1 = MathHelper.floor_double(this.boundingBox.minX);
        int k1 = MathHelper.floor_double(this.boundingBox.minY);
        int i2 = MathHelper.floor_double(this.boundingBox.minZ);
        int j3 = MathHelper.floor_double(this.boundingBox.maxX);
        int k3 = MathHelper.floor_double(this.boundingBox.maxY);
        int l3 = MathHelper.floor_double(this.boundingBox.maxZ);
        for (int i4 = i1; i4 <= j3; ++i4) {
            for (int j4 = k1; j4 <= k3; ++j4) {
                for (int k4 = i2; k4 <= l3; ++k4) {
                    int l4 = this.worldObj.getBlockId(i4, j4, k4);
                    if (l4 <= 0) continue;
                    Block.blocksList[l4].onEntityCollidedWithBlock(this.worldObj, i4, j4, k4, this);
                }
            }
        }
        this.field_9287_aY *= 0.4f;
        boolean flag2 = this.handleWaterMovement();
        if (this.worldObj.isBoundingBoxBurning(this.boundingBox)) {
            this.func_355_a(1);
            if (!flag2) {
                ++this.fire;
                if (this.fire == 0) {
                    this.fire = 300;
                }
            }
        } else if (this.fire <= 0) {
            this.fire = -this.field_9310_bf;
        }
        if (flag2 && this.fire > 0) {
            this.worldObj.playSoundAtEntity(this, "random.fizz", 0.7f, 1.6f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
            this.fire = -this.field_9310_bf;
        }
    }

    protected void func_9279_a(double d2, boolean flag) {
        if (flag) {
            if (this.fallDistance > 0.0f) {
                this.fall(this.fallDistance);
                this.fallDistance = 0.0f;
            }
        } else if (d2 < 0.0) {
            this.fallDistance = (float)((double)this.fallDistance - d2);
        }
    }

    public boolean func_381_o() {
        return false;
    }

    public AxisAlignedBB func_372_f_() {
        return null;
    }

    protected void func_355_a(int i2) {
        if (!this.isImmuneToFire) {
            this.canAttackEntity(null, i2);
        }
    }

    protected void fall(float f2) {
    }

    public boolean handleWaterMovement() {
        return this.worldObj.func_682_a(this.boundingBox.expands(0.0, -0.4f, 0.0), Material.water, this);
    }

    public boolean isInsideOfMaterial(Material material) {
        int k2;
        int j2;
        double d2 = this.posY + (double)this.func_373_s();
        int i2 = MathHelper.floor_double(this.posX);
        int l2 = this.worldObj.getBlockId(i2, j2 = MathHelper.floor_float(MathHelper.floor_double(d2)), k2 = MathHelper.floor_double(this.posZ));
        if (l2 != 0 && Block.blocksList[l2].blockMaterial == material) {
            float f2 = BlockFluids.func_288_b(this.worldObj.getBlockMetadata(i2, j2, k2)) - 0.1111111f;
            float f1 = (float)(j2 + 1) - f2;
            return d2 < (double)f1;
        }
        return false;
    }

    public float func_373_s() {
        return 0.0f;
    }

    public boolean handleLavaMovement() {
        return this.worldObj.func_689_a(this.boundingBox.expands(0.0, -0.4f, 0.0), Material.lava);
    }

    public void func_351_a(float f2, float f1, float f22) {
        float f3 = MathHelper.sqrt_float(f2 * f2 + f1 * f1);
        if (f3 < 0.01f) {
            return;
        }
        if (f3 < 1.0f) {
            f3 = 1.0f;
        }
        f3 = f22 / f3;
        float f4 = MathHelper.sin(this.rotationYaw * 3.141593f / 180.0f);
        float f5 = MathHelper.cos(this.rotationYaw * 3.141593f / 180.0f);
        this.motionX += (double)((f2 *= f3) * f5 - (f1 *= f3) * f4);
        this.motionZ += (double)(f1 * f5 + f2 * f4);
    }

    public float getEntityBrightness(float f2) {
        int i2 = MathHelper.floor_double(this.posX);
        double d2 = (this.boundingBox.maxY - this.boundingBox.minY) * 0.66;
        int j2 = MathHelper.floor_double(this.posY - (double)this.yOffset + d2);
        int k2 = MathHelper.floor_double(this.posZ);
        return this.worldObj.getLightBrightness(i2, j2, k2);
    }

    public void setWorld(World world) {
        this.worldObj = world;
    }

    public void setPositionAndRotation(double d2, double d1, double d22, float f2, float f1) {
        this.prevPosX = this.posX = d2;
        this.prevPosY = this.posY = d1;
        this.prevPosZ = this.posZ = d22;
        this.prevRotationYaw = this.rotationYaw = f2;
        this.prevRotationPitch = this.rotationPitch = f1;
        this.field_9287_aY = 0.0f;
        double d3 = this.prevRotationYaw - f2;
        if (d3 < -180.0) {
            this.prevRotationYaw += 360.0f;
        }
        if (d3 >= 180.0) {
            this.prevRotationYaw -= 360.0f;
        }
        this.setPosition(this.posX, this.posY, this.posZ);
        this.setRotation(f2, f1);
    }

    public void setLocationAndAngles(double d2, double d1, double d22, float f2, float f1) {
        this.prevPosX = this.posX = d2;
        this.prevPosY = this.posY = d1 + (double)this.yOffset;
        this.prevPosZ = this.posZ = d22;
        this.rotationYaw = f2;
        this.rotationPitch = f1;
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    public float getDistanceToEntity(Entity entity) {
        float f2 = (float)(this.posX - entity.posX);
        float f1 = (float)(this.posY - entity.posY);
        float f22 = (float)(this.posZ - entity.posZ);
        return MathHelper.sqrt_float(f2 * f2 + f1 * f1 + f22 * f22);
    }

    public double getDistanceSq(double d2, double d1, double d22) {
        double d3 = this.posX - d2;
        double d4 = this.posY - d1;
        double d5 = this.posZ - d22;
        return d3 * d3 + d4 * d4 + d5 * d5;
    }

    public double getDistance(double d2, double d1, double d22) {
        double d3 = this.posX - d2;
        double d4 = this.posY - d1;
        double d5 = this.posZ - d22;
        return MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
    }

    public double getDistanceSqToEntity(Entity entity) {
        double d2 = this.posX - entity.posX;
        double d1 = this.posY - entity.posY;
        double d22 = this.posZ - entity.posZ;
        return d2 * d2 + d1 * d1 + d22 * d22;
    }

    public void onCollideWithPlayer(EntityPlayer entityplayer) {
    }

    public void applyEntityCollision(Entity entity) {
        if (entity.riddenByEntity == this || entity.ridingEntity == this) {
            return;
        }
        double d2 = entity.posX - this.posX;
        double d1 = entity.posZ - this.posZ;
        double d22 = MathHelper.abs_max(d2, d1);
        if (d22 >= (double)0.01f) {
            d22 = MathHelper.sqrt_double(d22);
            d2 /= d22;
            d1 /= d22;
            double d3 = 1.0 / d22;
            if (d3 > 1.0) {
                d3 = 1.0;
            }
            d2 *= d3;
            d1 *= d3;
            d2 *= (double)0.05f;
            d1 *= (double)0.05f;
            this.addVelocity(-(d2 *= (double)(1.0f - this.field_632_aO)), 0.0, -(d1 *= (double)(1.0f - this.field_632_aO)));
            entity.addVelocity(d2, 0.0, d1);
        }
    }

    public void addVelocity(double d2, double d1, double d22) {
        this.motionX += d2;
        this.motionY += d1;
        this.motionZ += d22;
    }

    protected void func_9281_M() {
        this.field_9294_aL = true;
    }

    public boolean canAttackEntity(Entity entity, int i2) {
        this.func_9281_M();
        return false;
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean canBePushed() {
        return false;
    }

    public void addToPlayerScore(Entity entity, int i2) {
    }

    public boolean func_390_a(Vec3D vec3d) {
        double d2 = this.posX - vec3d.xCoord;
        double d1 = this.posY - vec3d.yCoord;
        double d22 = this.posZ - vec3d.zCoord;
        double d3 = d2 * d2 + d1 * d1 + d22 * d22;
        return this.func_384_a(d3);
    }

    public boolean func_384_a(double d2) {
        double d1 = this.boundingBox.getAverageEdgeLength();
        return d2 < (d1 *= 64.0 * this.field_619_ac) * d1;
    }

    public String getEntityTexture() {
        return null;
    }

    public boolean func_358_c(NBTTagCompound nbttagcompound) {
        String s2 = this.getEntityString();
        if (this.isDead || s2 == null) {
            return false;
        }
        nbttagcompound.setString("id", s2);
        this.writeToNBT(nbttagcompound);
        return true;
    }

    public void writeToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setTag("Pos", this.func_375_a(new double[]{this.posX, this.posY, this.posZ}));
        nbttagcompound.setTag("Motion", this.func_375_a(new double[]{this.motionX, this.motionY, this.motionZ}));
        nbttagcompound.setTag("Rotation", this.func_377_a(new float[]{this.rotationYaw, this.rotationPitch}));
        nbttagcompound.setFloat("FallDistance", this.fallDistance);
        nbttagcompound.setShort("Fire", (short)this.fire);
        nbttagcompound.setShort("Air", (short)this.air);
        nbttagcompound.setBoolean("OnGround", this.onGround);
        this.writeEntityToNBT(nbttagcompound);
    }

    public void readFromNBT(NBTTagCompound nbttagcompound) {
        NBTTagList nbttaglist = nbttagcompound.getTagList("Pos");
        NBTTagList nbttaglist1 = nbttagcompound.getTagList("Motion");
        NBTTagList nbttaglist2 = nbttagcompound.getTagList("Rotation");
        this.setPosition(0.0, 0.0, 0.0);
        this.motionX = ((NBTTagDouble)nbttaglist1.tagAt((int)0)).doubleValue;
        this.motionY = ((NBTTagDouble)nbttaglist1.tagAt((int)1)).doubleValue;
        this.motionZ = ((NBTTagDouble)nbttaglist1.tagAt((int)2)).doubleValue;
        this.lastTickPosX = this.posX = ((NBTTagDouble)nbttaglist.tagAt((int)0)).doubleValue;
        this.prevPosX = this.posX;
        this.lastTickPosY = this.posY = ((NBTTagDouble)nbttaglist.tagAt((int)1)).doubleValue;
        this.prevPosY = this.posY;
        this.lastTickPosZ = this.posZ = ((NBTTagDouble)nbttaglist.tagAt((int)2)).doubleValue;
        this.prevPosZ = this.posZ;
        this.prevRotationYaw = this.rotationYaw = ((NBTTagFloat)nbttaglist2.tagAt((int)0)).floatValue;
        this.prevRotationPitch = this.rotationPitch = ((NBTTagFloat)nbttaglist2.tagAt((int)1)).floatValue;
        this.fallDistance = nbttagcompound.getFloat("FallDistance");
        this.fire = nbttagcompound.getShort("Fire");
        this.air = nbttagcompound.getShort("Air");
        this.onGround = nbttagcompound.getBoolean("OnGround");
        this.setPosition(this.posX, this.posY, this.posZ);
        this.readEntityFromNBT(nbttagcompound);
    }

    protected final String getEntityString() {
        return EntityList.getEntityString(this);
    }

    protected abstract void readEntityFromNBT(NBTTagCompound var1);

    protected abstract void writeEntityToNBT(NBTTagCompound var1);

    protected NBTTagList func_375_a(double[] ad2) {
        NBTTagList nbttaglist = new NBTTagList();
        for (double d2 : ad2) {
            nbttaglist.setTag(new NBTTagDouble(d2));
        }
        return nbttaglist;
    }

    protected NBTTagList func_377_a(float[] af2) {
        NBTTagList nbttaglist = new NBTTagList();
        for (float f2 : af2) {
            nbttaglist.setTag(new NBTTagFloat(f2));
        }
        return nbttaglist;
    }

    public float func_392_h_() {
        return this.height / 2.0f;
    }

    public EntityItem dropItem(int i2, int j2) {
        return this.dropItemWithOffset(i2, j2, 0.0f);
    }

    public EntityItem dropItemWithOffset(int i2, int j2, float f2) {
        EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY + (double)f2, this.posZ, new ItemStack(i2, j2));
        entityitem.field_805_c = 10;
        this.worldObj.entityJoinedWorld(entityitem);
        return entityitem;
    }

    public boolean isEntityAlive() {
        return !this.isDead;
    }

    public boolean func_345_I() {
        int i2 = MathHelper.floor_double(this.posX);
        int j2 = MathHelper.floor_double(this.posY + (double)this.func_373_s());
        int k2 = MathHelper.floor_double(this.posZ);
        return this.worldObj.isBlockOpaqueCube(i2, j2, k2);
    }

    public boolean interact(EntityPlayer entityplayer) {
        return false;
    }

    public AxisAlignedBB func_383_b_(Entity entity) {
        return null;
    }

    public void func_350_p() {
        if (this.ridingEntity.isDead) {
            this.ridingEntity = null;
            return;
        }
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.onUpdate();
        this.ridingEntity.func_366_i_();
        this.field_667_e += (double)(this.ridingEntity.rotationYaw - this.ridingEntity.prevRotationYaw);
        this.minecartType += (double)(this.ridingEntity.rotationPitch - this.ridingEntity.prevRotationPitch);
        while (this.field_667_e >= 180.0) {
            this.field_667_e -= 360.0;
        }
        while (this.field_667_e < -180.0) {
            this.field_667_e += 360.0;
        }
        while (this.minecartType >= 180.0) {
            this.minecartType -= 360.0;
        }
        while (this.minecartType < -180.0) {
            this.minecartType += 360.0;
        }
        double d2 = this.field_667_e * 0.5;
        double d1 = this.minecartType * 0.5;
        float f2 = 10.0f;
        if (d2 > (double)f2) {
            d2 = f2;
        }
        if (d2 < (double)(-f2)) {
            d2 = -f2;
        }
        if (d1 > (double)f2) {
            d1 = f2;
        }
        if (d1 < (double)(-f2)) {
            d1 = -f2;
        }
        this.field_667_e -= d2;
        this.minecartType -= d1;
        this.rotationYaw = (float)((double)this.rotationYaw + d2);
        this.rotationPitch = (float)((double)this.rotationPitch + d1);
    }

    public void func_366_i_() {
        this.riddenByEntity.setPosition(this.posX, this.posY + this.func_402_h() + this.riddenByEntity.func_388_v(), this.posZ);
    }

    public double func_388_v() {
        return this.yOffset;
    }

    public double func_402_h() {
        return (double)this.height * 0.75;
    }

    public void mountEntity(Entity entity) {
        this.minecartType = 0.0;
        this.field_667_e = 0.0;
        if (entity == null) {
            if (this.ridingEntity != null) {
                this.setLocationAndAngles(this.ridingEntity.posX, this.ridingEntity.boundingBox.minY + (double)this.ridingEntity.height, this.ridingEntity.posZ, this.rotationYaw, this.rotationPitch);
                this.ridingEntity.riddenByEntity = null;
            }
            this.ridingEntity = null;
            return;
        }
        if (this.ridingEntity == entity) {
            this.ridingEntity.riddenByEntity = null;
            this.ridingEntity = null;
            this.setLocationAndAngles(entity.posX, entity.boundingBox.minY + (double)entity.height, entity.posZ, this.rotationYaw, this.rotationPitch);
            return;
        }
        if (this.ridingEntity != null) {
            this.ridingEntity.riddenByEntity = null;
        }
        if (entity.riddenByEntity != null) {
            entity.riddenByEntity.ridingEntity = null;
        }
        this.ridingEntity = entity;
        entity.riddenByEntity = this;
    }

    public void setPositionAndRotation2(double d2, double d1, double d22, float f2, float f1, int i2) {
        this.setPosition(d2, d1, d22);
        this.setRotation(f2, f1);
    }

    public float func_4035_j_() {
        return 0.1f;
    }

    public Vec3D func_4037_H() {
        return null;
    }

    public void func_4039_q() {
    }

    public void setVelocity(double d2, double d1, double d22) {
        this.motionX = d2;
        this.motionY = d1;
        this.motionZ = d22;
    }

    public void func_9282_a(byte byte0) {
    }

    public void func_9280_g() {
    }
}

