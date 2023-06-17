/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.StepSound;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class EntityLiving
extends Entity {
    public int field_9366_o = 20;
    public float field_9365_p;
    public float field_9364_q;
    public float field_9363_r;
    public float field_735_n = 0.0f;
    public float field_734_o = 0.0f;
    protected float field_9362_u;
    protected float field_9361_v;
    protected float field_9360_w;
    protected float field_9359_x;
    protected boolean field_9358_y = true;
    protected String texture = "/mob/char.png";
    protected boolean field_9355_A = true;
    protected float field_9353_B = 0.0f;
    protected String field_9351_C = null;
    protected float field_9349_D = 1.0f;
    protected int field_9347_E = 0;
    protected float field_9345_F = 0.0f;
    public boolean field_9343_G = false;
    public float prevSwingProgress;
    public float swingProgress;
    public int health = 10;
    public int field_9335_K;
    private int field_4121_a;
    public int hurtTime;
    public int field_9332_M;
    public float field_9331_N = 0.0f;
    public int deathTime = 0;
    public int attackTime = 0;
    public float field_9329_Q;
    public float field_9328_R;
    protected boolean field_9327_S = false;
    public int field_9326_T = -1;
    public float field_9325_U = (float)(Math.random() * (double)0.9f + (double)0.1f);
    public float field_705_Q;
    public float field_704_R;
    public float field_703_S;
    protected int field_9324_Y;
    protected double field_9323_Z;
    protected double field_9356_aa;
    protected double field_9354_ab;
    protected double field_9352_ac;
    protected double field_9350_ad;
    float field_9348_ae = 0.0f;
    protected int field_9346_af = 0;
    protected int field_9344_ag = 0;
    protected float field_9342_ah;
    protected float field_9340_ai;
    protected float field_9338_aj;
    protected boolean isJumping = false;
    protected float field_9334_al = 0.0f;
    protected float field_9333_am = 0.7f;
    private Entity field_4120_b;
    private int field_4127_c = 0;

    public EntityLiving(World world) {
        super(world);
        this.field_618_ad = true;
        this.field_9363_r = (float)(Math.random() + 1.0) * 0.01f;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.field_9365_p = (float)Math.random() * 12398.0f;
        this.rotationYaw = (float)(Math.random() * 3.1415927410125732 * 2.0);
        this.field_9364_q = 1.0f;
        this.field_9286_aZ = 0.5f;
    }

    public boolean canEntityBeSeen(Entity entity) {
        return this.worldObj.rayTraceBlocks(Vec3D.createVector(this.posX, this.posY + (double)this.func_373_s(), this.posZ), Vec3D.createVector(entity.posX, entity.posY + (double)entity.func_373_s(), entity.posZ)) == null;
    }

    @Override
    public String getEntityTexture() {
        return this.texture;
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    public boolean canBePushed() {
        return !this.isDead;
    }

    @Override
    public float func_373_s() {
        return this.height * 0.85f;
    }

    public int func_421_b() {
        return 80;
    }

    @Override
    public void func_391_y() {
        this.prevSwingProgress = this.swingProgress;
        super.func_391_y();
        if (this.rand.nextInt(1000) < this.field_4121_a++) {
            this.field_4121_a = -this.func_421_b();
            String s2 = this.getLivingSound();
            if (s2 != null) {
                this.worldObj.playSoundAtEntity(this, s2, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
        }
        if (this.isEntityAlive() && this.func_345_I()) {
            this.canAttackEntity(null, 1);
        }
        if (this.isImmuneToFire || this.worldObj.multiplayerWorld) {
            this.fire = 0;
        }
        if (this.isEntityAlive() && this.isInsideOfMaterial(Material.water)) {
            --this.air;
            if (this.air == -20) {
                this.air = 0;
                for (int i2 = 0; i2 < 8; ++i2) {
                    float f2 = this.rand.nextFloat() - this.rand.nextFloat();
                    float f1 = this.rand.nextFloat() - this.rand.nextFloat();
                    float f22 = this.rand.nextFloat() - this.rand.nextFloat();
                    this.worldObj.spawnParticle("bubble", this.posX + (double)f2, this.posY + (double)f1, this.posZ + (double)f22, this.motionX, this.motionY, this.motionZ);
                }
                this.canAttackEntity(null, 2);
            }
            this.fire = 0;
        } else {
            this.air = this.field_9308_bh;
        }
        this.field_9329_Q = this.field_9328_R;
        if (this.attackTime > 0) {
            --this.attackTime;
        }
        if (this.hurtTime > 0) {
            --this.hurtTime;
        }
        if (this.field_9306_bj > 0) {
            --this.field_9306_bj;
        }
        if (this.health <= 0) {
            ++this.deathTime;
            if (this.deathTime > 20) {
                this.func_6392_F();
                this.setEntityDead();
                for (int j2 = 0; j2 < 20; ++j2) {
                    double d2 = this.rand.nextGaussian() * 0.02;
                    double d1 = this.rand.nextGaussian() * 0.02;
                    double d22 = this.rand.nextGaussian() * 0.02;
                    this.worldObj.spawnParticle("explode", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, d2, d1, d22);
                }
            }
        }
        this.field_9359_x = this.field_9360_w;
        this.field_734_o = this.field_735_n;
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
    }

    public void spawnExplosionParticle() {
        for (int i2 = 0; i2 < 20; ++i2) {
            double d2 = this.rand.nextGaussian() * 0.02;
            double d1 = this.rand.nextGaussian() * 0.02;
            double d22 = this.rand.nextGaussian() * 0.02;
            double d3 = 10.0;
            this.worldObj.spawnParticle("explode", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width - d2 * d3, this.posY + (double)(this.rand.nextFloat() * this.height) - d1 * d3, this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width - d22 * d3, d2, d1, d22);
        }
    }

    @Override
    public void func_350_p() {
        super.func_350_p();
        this.field_9362_u = this.field_9361_v;
        this.field_9361_v = 0.0f;
    }

    @Override
    public void setPositionAndRotation2(double d2, double d1, double d22, float f2, float f1, int i2) {
        this.yOffset = 0.0f;
        this.field_9323_Z = d2;
        this.field_9356_aa = d1;
        this.field_9354_ab = d22;
        this.field_9352_ac = f2;
        this.field_9350_ad = f1;
        this.field_9324_Y = i2;
    }

    @Override
    public void onUpdate() {
        boolean flag;
        float f5;
        float f4;
        super.onUpdate();
        this.onLivingUpdate();
        double d2 = this.posX - this.prevPosX;
        double d1 = this.posZ - this.prevPosZ;
        float f2 = MathHelper.sqrt_double(d2 * d2 + d1 * d1);
        float f1 = this.field_735_n;
        float f22 = 0.0f;
        this.field_9362_u = this.field_9361_v;
        float f3 = 0.0f;
        if (f2 > 0.05f) {
            f3 = 1.0f;
            f22 = f2 * 3.0f;
            f1 = (float)Math.atan2(d1, d2) * 180.0f / 3.141593f - 90.0f;
        }
        if (this.swingProgress > 0.0f) {
            f1 = this.rotationYaw;
        }
        if (!this.onGround) {
            f3 = 0.0f;
        }
        this.field_9361_v += (f3 - this.field_9361_v) * 0.3f;
        for (f4 = f1 - this.field_735_n; f4 < -180.0f; f4 += 360.0f) {
        }
        while (f4 >= 180.0f) {
            f4 -= 360.0f;
        }
        this.field_735_n += f4 * 0.3f;
        for (f5 = this.rotationYaw - this.field_735_n; f5 < -180.0f; f5 += 360.0f) {
        }
        while (f5 >= 180.0f) {
            f5 -= 360.0f;
        }
        boolean bl2 = flag = f5 < -90.0f || f5 >= 90.0f;
        if (f5 < -75.0f) {
            f5 = -75.0f;
        }
        if (f5 >= 75.0f) {
            f5 = 75.0f;
        }
        this.field_735_n = this.rotationYaw - f5;
        if (f5 * f5 > 2500.0f) {
            this.field_735_n += f5 * 0.2f;
        }
        if (flag) {
            f22 *= -1.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
            this.prevRotationYaw -= 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
            this.prevRotationYaw += 360.0f;
        }
        while (this.field_735_n - this.field_734_o < -180.0f) {
            this.field_734_o -= 360.0f;
        }
        while (this.field_735_n - this.field_734_o >= 180.0f) {
            this.field_734_o += 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
            this.prevRotationPitch -= 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
            this.prevRotationPitch += 360.0f;
        }
        this.field_9360_w += f22;
    }

    @Override
    protected void setSize(float f2, float f1) {
        super.setSize(f2, f1);
    }

    public void heal(int i2) {
        if (this.health <= 0) {
            return;
        }
        this.health += i2;
        if (this.health > 20) {
            this.health = 20;
        }
        this.field_9306_bj = this.field_9366_o / 2;
    }

    @Override
    public boolean canAttackEntity(Entity entity, int i2) {
        if (this.worldObj.multiplayerWorld) {
            return false;
        }
        this.field_9344_ag = 0;
        if (this.health <= 0) {
            return false;
        }
        this.field_704_R = 1.5f;
        boolean flag = true;
        if ((float)this.field_9306_bj > (float)this.field_9366_o / 2.0f) {
            if (i2 <= this.field_9346_af) {
                return false;
            }
            this.damageEntity(i2 - this.field_9346_af);
            this.field_9346_af = i2;
            flag = false;
        } else {
            this.field_9346_af = i2;
            this.field_9335_K = this.health;
            this.field_9306_bj = this.field_9366_o;
            this.damageEntity(i2);
            this.field_9332_M = 10;
            this.hurtTime = 10;
        }
        this.field_9331_N = 0.0f;
        if (flag) {
            this.worldObj.func_9425_a(this, (byte)2);
            this.func_9281_M();
            if (entity != null) {
                double d2 = entity.posX - this.posX;
                double d1 = entity.posZ - this.posZ;
                while (d2 * d2 + d1 * d1 < 1.0E-4) {
                    d2 = (Math.random() - Math.random()) * 0.01;
                    d1 = (Math.random() - Math.random()) * 0.01;
                }
                this.field_9331_N = (float)(Math.atan2(d1, d2) * 180.0 / 3.1415927410125732) - this.rotationYaw;
                this.func_434_a(entity, i2, d2, d1);
            } else {
                this.field_9331_N = (int)(Math.random() * 2.0) * 180;
            }
        }
        if (this.health <= 0) {
            if (flag) {
                this.worldObj.playSoundAtEntity(this, this.getDeathSound(), this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
            this.onDeath(entity);
        } else if (flag) {
            this.worldObj.playSoundAtEntity(this, this.getHurtSound(), this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
        }
        return true;
    }

    @Override
    public void func_9280_g() {
        this.field_9332_M = 10;
        this.hurtTime = 10;
        this.field_9331_N = 0.0f;
    }

    protected void damageEntity(int i2) {
        this.health -= i2;
    }

    protected float getSoundVolume() {
        return 1.0f;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return "random.hurt";
    }

    protected String getDeathSound() {
        return "random.hurt";
    }

    public void func_434_a(Entity entity, int i2, double d2, double d1) {
        float f2 = MathHelper.sqrt_double(d2 * d2 + d1 * d1);
        float f1 = 0.4f;
        this.motionX /= 2.0;
        this.motionY /= 2.0;
        this.motionZ /= 2.0;
        this.motionX -= d2 / (double)f2 * (double)f1;
        this.motionY += (double)0.4f;
        this.motionZ -= d1 / (double)f2 * (double)f1;
        if (this.motionY > (double)0.4f) {
            this.motionY = 0.4f;
        }
    }

    public void onDeath(Entity entity) {
        int i2;
        if (this.field_9347_E > 0 && entity != null) {
            entity.addToPlayerScore(this, this.field_9347_E);
        }
        this.field_9327_S = true;
        if (!this.worldObj.multiplayerWorld && (i2 = this.getDropItemId()) > 0) {
            int j2 = this.rand.nextInt(3);
            for (int k2 = 0; k2 < j2; ++k2) {
                this.dropItem(i2, 1);
            }
        }
        this.worldObj.func_9425_a(this, (byte)3);
    }

    protected int getDropItemId() {
        return 0;
    }

    @Override
    protected void fall(float f2) {
        int i2 = (int)Math.ceil(f2 - 3.0f);
        if (i2 > 0) {
            this.canAttackEntity(null, i2);
            int j2 = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY - (double)0.2f - (double)this.yOffset), MathHelper.floor_double(this.posZ));
            if (j2 > 0) {
                StepSound stepsound = Block.blocksList[j2].stepSound;
                this.worldObj.playSoundAtEntity(this, stepsound.func_1145_d(), stepsound.func_1147_b() * 0.5f, stepsound.func_1144_c() * 0.75f);
            }
        }
    }

    public void func_435_b(float f2, float f1) {
        if (this.handleWaterMovement()) {
            double d2 = this.posY;
            this.func_351_a(f2, f1, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)0.8f;
            this.motionY *= (double)0.8f;
            this.motionZ *= (double)0.8f;
            this.motionY -= 0.02;
            if (this.field_9297_aI && this.func_403_b(this.motionX, this.motionY + (double)0.6f - this.posY + d2, this.motionZ)) {
                this.motionY = 0.3f;
            }
        } else if (this.handleLavaMovement()) {
            double d1 = this.posY;
            this.func_351_a(f2, f1, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
            this.motionY -= 0.02;
            if (this.field_9297_aI && this.func_403_b(this.motionX, this.motionY + (double)0.6f - this.posY + d1, this.motionZ)) {
                this.motionY = 0.3f;
            }
        } else {
            float f22 = 0.91f;
            if (this.onGround) {
                f22 = 0.5460001f;
                int i2 = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));
                if (i2 > 0) {
                    f22 = Block.blocksList[i2].slipperiness * 0.91f;
                }
            }
            float f3 = 0.1627714f / (f22 * f22 * f22);
            this.func_351_a(f2, f1, this.onGround ? 0.1f * f3 : 0.02f);
            f22 = 0.91f;
            if (this.onGround) {
                f22 = 0.5460001f;
                int j2 = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));
                if (j2 > 0) {
                    f22 = Block.blocksList[j2].slipperiness * 0.91f;
                }
            }
            if (this.isOnLadder()) {
                this.fallDistance = 0.0f;
                if (this.motionY < -0.15) {
                    this.motionY = -0.15;
                }
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            if (this.field_9297_aI && this.isOnLadder()) {
                this.motionY = 0.2;
            }
            this.motionY -= 0.08;
            this.motionY *= (double)0.98f;
            this.motionX *= (double)f22;
            this.motionZ *= (double)f22;
        }
        this.field_705_Q = this.field_704_R;
        double d2 = this.posX - this.prevPosX;
        double d3 = this.posZ - this.prevPosZ;
        float f4 = MathHelper.sqrt_double(d2 * d2 + d3 * d3) * 4.0f;
        if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        this.field_704_R += (f4 - this.field_704_R) * 0.4f;
        this.field_703_S += this.field_704_R;
    }

    public boolean isOnLadder() {
        int k2;
        int j2;
        int i2 = MathHelper.floor_double(this.posX);
        return this.worldObj.getBlockId(i2, j2 = MathHelper.floor_double(this.boundingBox.minY), k2 = MathHelper.floor_double(this.posZ)) == Block.ladder.blockID || this.worldObj.getBlockId(i2, j2 + 1, k2) == Block.ladder.blockID;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setShort("Health", (short)this.health);
        nbttagcompound.setShort("HurtTime", (short)this.hurtTime);
        nbttagcompound.setShort("DeathTime", (short)this.deathTime);
        nbttagcompound.setShort("AttackTime", (short)this.attackTime);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        this.health = nbttagcompound.getShort("Health");
        if (!nbttagcompound.hasKey("Health")) {
            this.health = 10;
        }
        this.hurtTime = nbttagcompound.getShort("HurtTime");
        this.deathTime = nbttagcompound.getShort("DeathTime");
        this.attackTime = nbttagcompound.getShort("AttackTime");
    }

    @Override
    public boolean isEntityAlive() {
        return !this.isDead && this.health > 0;
    }

    public void onLivingUpdate() {
        if (this.field_9324_Y > 0) {
            double d3;
            double d2 = this.posX + (this.field_9323_Z - this.posX) / (double)this.field_9324_Y;
            double d1 = this.posY + (this.field_9356_aa - this.posY) / (double)this.field_9324_Y;
            double d22 = this.posZ + (this.field_9354_ab - this.posZ) / (double)this.field_9324_Y;
            for (d3 = this.field_9352_ac - (double)this.rotationYaw; d3 < -180.0; d3 += 360.0) {
            }
            while (d3 >= 180.0) {
                d3 -= 360.0;
            }
            this.rotationYaw = (float)((double)this.rotationYaw + d3 / (double)this.field_9324_Y);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.field_9350_ad - (double)this.rotationPitch) / (double)this.field_9324_Y);
            --this.field_9324_Y;
            this.setPosition(d2, d1, d22);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
        if (this.health <= 0) {
            this.isJumping = false;
            this.field_9342_ah = 0.0f;
            this.field_9340_ai = 0.0f;
            this.field_9338_aj = 0.0f;
        } else if (!this.field_9343_G) {
            this.func_418_b_();
        }
        boolean flag = this.handleWaterMovement();
        boolean flag1 = this.handleLavaMovement();
        if (this.isJumping) {
            if (flag) {
                this.motionY += (double)0.04f;
            } else if (flag1) {
                this.motionY += (double)0.04f;
            } else if (this.onGround) {
                this.func_424_C();
            }
        }
        this.field_9342_ah *= 0.98f;
        this.field_9340_ai *= 0.98f;
        this.field_9338_aj *= 0.9f;
        this.func_435_b(this.field_9342_ah, this.field_9340_ai);
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expands(0.2f, 0.0, 0.2f));
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                Entity entity = (Entity)list.get(i2);
                if (!entity.canBePushed()) continue;
                entity.applyEntityCollision(this);
            }
        }
    }

    protected void func_424_C() {
        this.motionY = 0.42f;
    }

    protected void func_418_b_() {
        ++this.field_9344_ag;
        EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity(this, -1.0);
        if (entityplayer != null) {
            double d2 = entityplayer.posX - this.posX;
            double d1 = entityplayer.posY - this.posY;
            double d22 = entityplayer.posZ - this.posZ;
            double d3 = d2 * d2 + d1 * d1 + d22 * d22;
            if (d3 > 16384.0) {
                this.setEntityDead();
            }
            if (this.field_9344_ag > 600 && this.rand.nextInt(800) == 0) {
                if (d3 < 1024.0) {
                    this.field_9344_ag = 0;
                } else {
                    this.setEntityDead();
                }
            }
        }
        this.field_9342_ah = 0.0f;
        this.field_9340_ai = 0.0f;
        float f2 = 8.0f;
        if (this.rand.nextFloat() < 0.02f) {
            EntityPlayer entityplayer1 = this.worldObj.getClosestPlayerToEntity(this, f2);
            if (entityplayer1 != null) {
                this.field_4120_b = entityplayer1;
                this.field_4127_c = 10 + this.rand.nextInt(20);
            } else {
                this.field_9338_aj = (this.rand.nextFloat() - 0.5f) * 20.0f;
            }
        }
        if (this.field_4120_b != null) {
            this.faceEntity(this.field_4120_b, 10.0f);
            if (this.field_4127_c-- <= 0 || this.field_4120_b.isDead || this.field_4120_b.getDistanceSqToEntity(this) > (double)(f2 * f2)) {
                this.field_4120_b = null;
            }
        } else {
            if (this.rand.nextFloat() < 0.05f) {
                this.field_9338_aj = (this.rand.nextFloat() - 0.5f) * 20.0f;
            }
            this.rotationYaw += this.field_9338_aj;
            this.rotationPitch = this.field_9334_al;
        }
        boolean flag = this.handleWaterMovement();
        boolean flag1 = this.handleLavaMovement();
        if (flag || flag1) {
            this.isJumping = this.rand.nextFloat() < 0.8f;
        }
    }

    public void faceEntity(Entity entity, float f2) {
        double d1;
        double d2 = entity.posX - this.posX;
        double d22 = entity.posZ - this.posZ;
        if (entity instanceof EntityLiving) {
            EntityLiving entityliving = (EntityLiving)entity;
            d1 = entityliving.posY + (double)entityliving.func_373_s() - (this.posY + (double)this.func_373_s());
        } else {
            d1 = (entity.boundingBox.minY + entity.boundingBox.maxY) / 2.0 - (this.posY + (double)this.func_373_s());
        }
        double d3 = MathHelper.sqrt_double(d2 * d2 + d22 * d22);
        float f1 = (float)(Math.atan2(d22, d2) * 180.0 / 3.1415927410125732) - 90.0f;
        float f22 = (float)(Math.atan2(d1, d3) * 180.0 / 3.1415927410125732);
        this.rotationPitch = -this.updateRotation(this.rotationPitch, f22, f2);
        this.rotationYaw = this.updateRotation(this.rotationYaw, f1, f2);
    }

    private float updateRotation(float f2, float f1, float f22) {
        float f3;
        for (f3 = f1 - f2; f3 < -180.0f; f3 += 360.0f) {
        }
        while (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        if (f3 > f22) {
            f3 = f22;
        }
        if (f3 < -f22) {
            f3 = -f22;
        }
        return f2 + f3;
    }

    public void func_6392_F() {
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.checkIfAABBIsClear(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.getIsAnyLiquid(this.boundingBox);
    }

    @Override
    protected void func_4034_G() {
        this.canAttackEntity(null, 4);
    }

    public float getSwingProgress(float f2) {
        float f1 = this.swingProgress - this.prevSwingProgress;
        if (f1 < 0.0f) {
            f1 += 1.0f;
        }
        return this.prevSwingProgress + f1 * f2;
    }

    public Vec3D getPosition(float f2) {
        if (f2 == 1.0f) {
            return Vec3D.createVector(this.posX, this.posY, this.posZ);
        }
        double d2 = this.prevPosX + (this.posX - this.prevPosX) * (double)f2;
        double d1 = this.prevPosY + (this.posY - this.prevPosY) * (double)f2;
        double d22 = this.prevPosZ + (this.posZ - this.prevPosZ) * (double)f2;
        return Vec3D.createVector(d2, d1, d22);
    }

    @Override
    public Vec3D func_4037_H() {
        return this.getLook(1.0f);
    }

    public Vec3D getLook(float f2) {
        if (f2 == 1.0f) {
            float f1 = MathHelper.cos(-this.rotationYaw * 0.01745329f - 3.141593f);
            float f3 = MathHelper.sin(-this.rotationYaw * 0.01745329f - 3.141593f);
            float f5 = -MathHelper.cos(-this.rotationPitch * 0.01745329f);
            float f7 = MathHelper.sin(-this.rotationPitch * 0.01745329f);
            return Vec3D.createVector(f3 * f5, f7, f1 * f5);
        }
        float f22 = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * f2;
        float f4 = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * f2;
        float f6 = MathHelper.cos(-f4 * 0.01745329f - 3.141593f);
        float f8 = MathHelper.sin(-f4 * 0.01745329f - 3.141593f);
        float f9 = -MathHelper.cos(-f22 * 0.01745329f);
        float f10 = MathHelper.sin(-f22 * 0.01745329f);
        return Vec3D.createVector(f8 * f9, f10, f6 * f9);
    }

    public MovingObjectPosition rayTrace(double d2, float f2) {
        Vec3D vec3d = this.getPosition(f2);
        Vec3D vec3d1 = this.getLook(f2);
        Vec3D vec3d2 = vec3d.addVector(vec3d1.xCoord * d2, vec3d1.yCoord * d2, vec3d1.zCoord * d2);
        return this.worldObj.rayTraceBlocks(vec3d, vec3d2);
    }

    public int func_6391_i() {
        return 4;
    }

    public ItemStack getHeldItem() {
        return null;
    }

    @Override
    public void func_9282_a(byte byte0) {
        if (byte0 == 2) {
            this.field_704_R = 1.5f;
            this.field_9306_bj = this.field_9366_o;
            this.field_9332_M = 10;
            this.hurtTime = 10;
            this.field_9331_N = 0.0f;
            this.worldObj.playSoundAtEntity(this, this.getHurtSound(), this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            this.canAttackEntity(null, 0);
        } else if (byte0 == 3) {
            this.worldObj.playSoundAtEntity(this, this.getDeathSound(), this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            this.health = 0;
            this.onDeath(null);
        } else {
            super.func_9282_a(byte0);
        }
    }
}

