/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityFish;
import net.minecraft.src.EntityHerobrine;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMobs;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.World;

public class EntityPlayer
extends EntityLiving {
    public InventoryPlayer inventory = new InventoryPlayer(this);
    public byte field_9371_f = 0;
    public int score = 0;
    public float field_775_e;
    public float field_774_f;
    public boolean field_9369_j = false;
    public int field_9368_k = 0;
    public String field_771_i;
    public int dimension;
    private int field_781_a = 0;
    public EntityFish fishEntity = null;

    public EntityPlayer(World world) {
        super(world);
        this.yOffset = 1.62f;
        this.setLocationAndAngles((double)world.spawnX + 0.5, world.spawnY + 1, (double)world.spawnZ + 0.5, 0.0f, 0.0f);
        this.health = 20;
        this.field_9351_C = "humanoid";
        this.field_9353_B = 180.0f;
        this.field_9310_bf = 20;
        this.texture = "/mob/char.png";
    }

    @Override
    public void func_350_p() {
        super.func_350_p();
        this.field_775_e = this.field_774_f;
        this.field_774_f = 0.0f;
    }

    @Override
    public void preparePlayerToSpawn() {
        this.yOffset = 1.62f;
        this.setSize(0.6f, 1.8f);
        super.preparePlayerToSpawn();
        this.health = 20;
        this.deathTime = 0;
    }

    @Override
    protected void func_418_b_() {
        if (this.field_9369_j) {
            ++this.field_9368_k;
            if (this.field_9368_k == 8) {
                this.field_9368_k = 0;
                this.field_9369_j = false;
            }
        } else {
            this.field_9368_k = 0;
        }
        this.swingProgress = (float)this.field_9368_k / 8.0f;
    }

    public void herobrineScript() {
        EntityHerobrine mob = new EntityHerobrine(this.worldObj);
        if (this.rand.nextInt(2) == 0) {
            mob.setPosition(this.posX + 26.0, (double)this.worldObj.spawnY + 0.5, this.posZ);
        }
        if (this.rand.nextInt(2) == 0) {
            mob.setPosition(this.posX - 26.0, (double)this.worldObj.spawnY + 0.5, this.posZ);
        }
        if (this.rand.nextInt(2) == 0) {
            mob.setPosition(this.posX + 26.0, (double)this.worldObj.spawnY + 0.5, this.posZ + 16.0);
        }
        if (this.rand.nextInt(2) == 0) {
            mob.setPosition(this.posX - 26.0, (double)this.worldObj.spawnY + 0.5, this.posZ - 16.0);
        }
        this.worldObj.entityJoinedWorld(mob);
    }

    public void signScript1(int i2, int j2, int k2) {
        this.worldObj.setBlock(i2, j2, k2, Block.signPost.blockID);
        TileEntity tile = this.worldObj.getBlockTileEntity(i2, j2, k2);
        if (tile instanceof TileEntitySign) {
            TileEntitySign te = (TileEntitySign)tile;
            te.signText[0] = "jag ser dig";
            te.signText[1] = "\u00a74ERROR";
            te.signText[2] = "\u00a74ERROR";
            te.signText[3] = "\u00a74ERROR";
        }
    }

    public void signScript2(int i2, int j2, int k2) {
        this.worldObj.setBlock(i2, j2, k2, Block.signPost.blockID);
        TileEntity tile = this.worldObj.getBlockTileEntity(i2, j2, k2);
        if (tile instanceof TileEntitySign) {
            TileEntitySign te = (TileEntitySign)tile;
            te.signText[0] = "jag har dig";
        }
    }

    public void signScript3(int i2, int j2, int k2) {
        this.worldObj.setBlock(i2, j2, k2, Block.signPost.blockID);
        TileEntity tile = this.worldObj.getBlockTileEntity(i2, j2, k2);
        if (tile instanceof TileEntitySign) {
            TileEntitySign te = (TileEntitySign)tile;
            te.signText[0] = "hen?!";
        }
    }

    public void signScript4(int i2, int j2, int k2) {
        this.worldObj.setBlock(i2, j2, k2, Block.signPost.blockID);
        TileEntity tile = this.worldObj.getBlockTileEntity(i2, j2, k2);
        if (tile instanceof TileEntitySign) {
            TileEntitySign te = (TileEntitySign)tile;
            te.signText[0] = "!!!";
            te.signText[1] = "\u00a74ERROR";
            te.signText[2] = "\u00a74ERROR";
            te.signText[3] = "\u00a74ERROR";
        }
    }

    public void signScript5(int i2, int j2, int k2) {
        this.worldObj.setBlock(i2, j2, k2, Block.signPost.blockID);
        TileEntity tile = this.worldObj.getBlockTileEntity(i2, j2, k2);
        if (tile instanceof TileEntitySign) {
            TileEntitySign te = (TileEntitySign)tile;
            te.signText[0] = "lat oss spela";
            te.signText[1] = "\u00a74:)";
        }
    }

    public void signScript6(int i2, int j2, int k2) {
        this.worldObj.setBlock(i2, j2, k2, Block.signPost.blockID);
        TileEntity tile = this.worldObj.getBlockTileEntity(i2, j2, k2);
        if (tile instanceof TileEntitySign) {
            TileEntitySign te = (TileEntitySign)tile;
            te.signText[0] = "\u00a74HJALP MIG SNALLA";
            te.signText[1] = "\u00a74ERROR";
            te.signText[2] = "\u00a74ERROR";
            te.signText[3] = "\u00a74ERROR";
        }
    }

    public void crossScript(int i2, int j2, int k2) {
        this.worldObj.setBlock(i2, j2, k2, Block.bloodStone.blockID);
        this.worldObj.setBlock(i2, j2 + 1, k2, Block.bloodStone.blockID);
        this.worldObj.setBlock(i2, j2 + 2, k2, Block.bloodStone.blockID);
        this.worldObj.setBlock(i2 - 1, j2 + 1, k2, Block.bloodStone.blockID);
        this.worldObj.setBlock(i2 + 1, j2 + 1, k2, Block.bloodStone.blockID);
        this.worldObj.setBlock(i2, j2 + 3, k2, Block.fire.blockID);
    }

    public void pyramidScript(int i2, int j2, int k2) {
        this.worldObj.setBlockWithNotify(i2, j2, k2 - 2, Block.sand.blockID);
        this.worldObj.setBlockWithNotify(i2 + 1, j2, k2 - 2, Block.sand.blockID);
        this.worldObj.setBlockWithNotify(i2 + 2, j2, k2 - 2, Block.sand.blockID);
        this.worldObj.setBlockWithNotify(i2 + 2, j2, k2 - 1, Block.sand.blockID);
        this.worldObj.setBlockWithNotify(i2, j2, k2 - 1, Block.sand.blockID);
        this.worldObj.setBlockWithNotify(i2 + 1, j2 + 1, k2 - 1, Block.sand.blockID);
        this.worldObj.setBlockWithNotify(i2 + 1, j2, k2 - 1, Block.sand.blockID);
        this.worldObj.setBlockWithNotify(i2, j2, k2, Block.sand.blockID);
        this.worldObj.setBlockWithNotify(i2 + 1, j2, k2, Block.sand.blockID);
        this.worldObj.setBlockWithNotify(i2 + 2, j2, k2, Block.sand.blockID);
    }

    public void healthScript() {
        this.health = 1;
    }

    public void fireScript() {
        this.fire = 999999;
    }

    public void discScript() {
        this.worldObj.playRecord("13", 0, 0, 0);
    }

    public void tunnel(int i2, int j2, int k2) {
        this.worldObj.setBlock(i2 + 1, j2, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 2, j2, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 3, j2, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 4, j2, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 5, j2, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 6, j2, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 7, j2, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 8, j2, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 9, j2, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 10, j2, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 1, j2 - 1, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 2, j2 - 1, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 3, j2 - 1, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 4, j2 - 1, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 5, j2 - 1, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 6, j2 - 1, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 7, j2 - 1, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 8, j2 - 1, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 9, j2 - 1, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 10, j2 - 1, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 1, j2 - 2, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 2, j2 - 2, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 3, j2 - 2, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 4, j2 - 2, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 5, j2 - 2, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 6, j2 - 2, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 7, j2 - 2, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 8, j2 - 2, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 9, j2 - 2, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 10, j2 - 2, k2 - 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 1, j2 - 2, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 2, j2 - 2, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 3, j2 - 2, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 4, j2 - 2, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 5, j2 - 2, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 6, j2 - 2, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 7, j2 - 2, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 8, j2 - 2, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 9, j2 - 2, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 10, j2 - 2, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 1, j2 - 1, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 2, j2 - 1, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 3, j2 - 1, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 4, j2 - 1, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 5, j2 - 1, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 6, j2 - 1, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 7, j2 - 1, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 8, j2 - 1, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 9, j2 - 1, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 10, j2 - 1, k2 + 1, Block.cobblestoneMossy.blockID);
        this.worldObj.setBlock(i2 + 1, j2 - 3, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 2, j2 - 3, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 3, j2 - 3, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 4, j2 - 3, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 5, j2 - 3, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 6, j2 - 3, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 7, j2 - 3, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 8, j2 - 3, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 9, j2 - 3, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 10, j2 - 3, k2, Block.cobblestone.blockID);
        this.worldObj.setBlock(i2 + 1, j2 - 1, k2, Block.torchRedstoneActive.blockID);
        this.worldObj.setBlock(i2 + 2, j2 - 1, k2, Block.torchRedstoneActive.blockID);
        this.worldObj.setBlock(i2 + 3, j2 - 1, k2, Block.torchRedstoneActive.blockID);
        this.worldObj.setBlock(i2 + 4, j2 - 1, k2, Block.torchRedstoneActive.blockID);
        this.worldObj.setBlock(i2 + 5, j2 - 1, k2, Block.torchRedstoneActive.blockID);
        this.worldObj.setBlock(i2 + 6, j2 - 1, k2, Block.torchRedstoneActive.blockID);
        this.worldObj.setBlock(i2 + 7, j2 - 1, k2, Block.torchRedstoneActive.blockID);
        this.worldObj.setBlock(i2 + 8, j2 - 1, k2, Block.torchRedstoneActive.blockID);
        this.worldObj.setBlock(i2 + 9, j2 - 1, k2, Block.torchRedstoneActive.blockID);
        this.worldObj.setBlock(i2 + 10, j2 - 1, k2, Block.torchRedstoneActive.blockID);
    }

    @Override
    public void onLivingUpdate() {
        List list;
        if (this.worldObj.difficultySetting == 0 && this.health < 20 && this.field_9311_be % 20 * 4 == 0) {
            this.heal(1);
        }
        if (this.field_9311_be % 35000 * 4 == 0) {
            if (this.rand.nextInt(2) == 0) {
                this.signScript1((int)this.posX, (int)this.posY, (int)this.posZ);
            }
            if (this.rand.nextInt(2) == 0) {
                this.signScript2((int)this.posX, (int)this.posY, (int)this.posZ);
            }
            if (this.rand.nextInt(2) == 0) {
                this.signScript3((int)this.posX, (int)this.posY, (int)this.posZ);
            }
            if (this.rand.nextInt(2) == 0) {
                this.signScript4((int)this.posX, (int)this.posY, (int)this.posZ);
            }
            if (this.rand.nextInt(2) == 0) {
                this.signScript5((int)this.posX, (int)this.posY, (int)this.posZ);
            }
            if (this.rand.nextInt(2) == 0) {
                this.signScript6((int)this.posX, (int)this.posY, (int)this.posZ);
            }
        }
        if (this.field_9311_be % 55000 * 4 == 0) {
            this.healthScript();
        }
        if (this.field_9311_be % 75000 * 4 == 0) {
            this.fireScript();
        }
        if (this.field_9311_be % 95000 * 4 == 0) {
            this.discScript();
        }
        if (this.field_9311_be % 115000 * 4 == 0) {
            if (this.rand.nextInt(2) == 0) {
                this.pyramidScript((int)this.posX + 30, this.worldObj.spawnY, (int)this.posZ);
            }
            if (this.rand.nextInt(2) == 0) {
                this.pyramidScript((int)this.posX - 30, this.worldObj.spawnY, (int)this.posZ);
            }
            if (this.rand.nextInt(2) == 0) {
                this.pyramidScript((int)this.posX + 30, this.worldObj.spawnY, (int)this.posZ + 10);
            }
            if (this.rand.nextInt(2) == 0) {
                this.pyramidScript((int)this.posX - 30, this.worldObj.spawnY, (int)this.posZ - 10);
            }
        }
        if (this.field_9311_be % 135000 * 4 == 0) {
            this.herobrineScript();
            this.worldObj.playSoundAtEntity(this, "mob.ghast.death", this.getSoundVolume() * 2.0f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) * 1.8f);
        }
        if (this.field_9311_be % 155000 * 4 == 0) {
            if (this.rand.nextInt(2) == 0) {
                this.crossScript((int)this.posX + 30, this.worldObj.spawnY, (int)this.posZ);
            }
            if (this.rand.nextInt(2) == 0) {
                this.crossScript((int)this.posX - 30, this.worldObj.spawnY, (int)this.posZ);
            }
            if (this.rand.nextInt(2) == 0) {
                this.crossScript((int)this.posX + 30, this.worldObj.spawnY, (int)this.posZ + 10);
            }
            if (this.rand.nextInt(2) == 0) {
                this.crossScript((int)this.posX - 30, this.worldObj.spawnY, (int)this.posZ - 10);
            }
        }
        if (this.field_9311_be % 175000 * 4 == 0) {
            this.tunnel((int)this.posX + 30, (int)this.posY - 20, (int)this.posZ);
        }
        this.inventory.decrementAnimations();
        this.field_775_e = this.field_774_f;
        super.onLivingUpdate();
        float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
        float f1 = (float)Math.atan(-this.motionY * (double)0.2f) * 15.0f;
        if (f2 > 0.1f) {
            f2 = 0.1f;
        }
        if (!this.onGround || this.health <= 0) {
            f2 = 0.0f;
        }
        if (this.onGround || this.health <= 0) {
            f1 = 0.0f;
        }
        this.field_774_f += (f2 - this.field_774_f) * 0.4f;
        this.field_9328_R += (f1 - this.field_9328_R) * 0.8f;
        if (this.health > 0 && (list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expands(1.0, 0.0, 1.0))) != null) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                this.func_451_h((Entity)list.get(i2));
            }
        }
    }

    private void func_451_h(Entity entity) {
        entity.onCollideWithPlayer(this);
    }

    public int func_6417_t() {
        return this.score;
    }

    @Override
    public void onDeath(Entity entity) {
        super.onDeath(entity);
        this.setSize(0.2f, 0.2f);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.motionY = 0.1f;
        if (this.field_771_i.equals("Notch")) {
            this.dropPlayerItemWithRandomChoice(new ItemStack(Item.appleRed, 1), true);
        }
        this.inventory.dropAllItems();
        if (entity != null) {
            this.motionX = -MathHelper.cos((this.field_9331_N + this.rotationYaw) * 3.141593f / 180.0f) * 0.1f;
            this.motionZ = -MathHelper.sin((this.field_9331_N + this.rotationYaw) * 3.141593f / 180.0f) * 0.1f;
        } else {
            this.motionZ = 0.0;
            this.motionX = 0.0;
        }
        this.yOffset = 0.1f;
    }

    @Override
    public void addToPlayerScore(Entity entity, int i2) {
        this.score += i2;
    }

    public void dropPlayerItem(ItemStack itemstack) {
        this.dropPlayerItemWithRandomChoice(itemstack, false);
    }

    public void dropPlayerItemWithRandomChoice(ItemStack itemstack, boolean flag) {
        if (itemstack == null) {
            return;
        }
        EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY - (double)0.3f + (double)this.func_373_s(), this.posZ, itemstack);
        entityitem.field_805_c = 40;
        float f2 = 0.1f;
        if (flag) {
            float f22 = this.rand.nextFloat() * 0.5f;
            float f4 = this.rand.nextFloat() * 3.141593f * 2.0f;
            entityitem.motionX = -MathHelper.sin(f4) * f22;
            entityitem.motionZ = MathHelper.cos(f4) * f22;
            entityitem.motionY = 0.2f;
        } else {
            float f1 = 0.3f;
            entityitem.motionX = -MathHelper.sin(this.rotationYaw / 180.0f * 3.141593f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.141593f) * f1;
            entityitem.motionZ = MathHelper.cos(this.rotationYaw / 180.0f * 3.141593f) * MathHelper.cos(this.rotationPitch / 180.0f * 3.141593f) * f1;
            entityitem.motionY = -MathHelper.sin(this.rotationPitch / 180.0f * 3.141593f) * f1 + 0.1f;
            f1 = 0.02f;
            float f3 = this.rand.nextFloat() * 3.141593f * 2.0f;
            entityitem.motionX += Math.cos(f3) * (double)(f1 *= this.rand.nextFloat());
            entityitem.motionY += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f);
            entityitem.motionZ += Math.sin(f3) * (double)f1;
        }
        this.joinEntityItemWithWorld(entityitem);
    }

    protected void joinEntityItemWithWorld(EntityItem entityitem) {
        this.worldObj.entityJoinedWorld(entityitem);
    }

    public float getCurrentPlayerStrVsBlock(Block block) {
        float f2 = this.inventory.getStrVsBlock(block);
        if (this.isInsideOfMaterial(Material.water)) {
            f2 /= 5.0f;
        }
        if (!this.onGround) {
            f2 /= 5.0f;
        }
        return f2;
    }

    public boolean canHarvestBlock(Block block) {
        return this.inventory.canHarvestBlock(block);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Inventory");
        this.inventory.readFromNBT(nbttaglist);
        this.dimension = nbttagcompound.getInteger("Dimension");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setTag("Inventory", this.inventory.writeToNBT(new NBTTagList()));
        nbttagcompound.setInteger("Dimension", this.dimension);
    }

    public void displayGUIChest(IInventory iinventory) {
    }

    public void displayWorkbenchGUI() {
    }

    public void func_443_a_(Entity entity, int i2) {
    }

    @Override
    public float func_373_s() {
        return 0.12f;
    }

    @Override
    public boolean canAttackEntity(Entity entity, int i2) {
        this.field_9344_ag = 0;
        if (this.health <= 0) {
            return false;
        }
        if (entity instanceof EntityMobs || entity instanceof EntityArrow) {
            if (this.worldObj.difficultySetting == 0) {
                i2 = 0;
            }
            if (this.worldObj.difficultySetting == 1) {
                i2 = i2 / 3 + 1;
            }
            if (this.worldObj.difficultySetting == 3) {
                i2 = i2 * 3 / 2;
            }
        }
        if (i2 == 0) {
            return false;
        }
        return super.canAttackEntity(entity, i2);
    }

    @Override
    protected void damageEntity(int i2) {
        int j2 = 25 - this.inventory.getTotalArmorValue();
        int k2 = i2 * j2 + this.field_781_a;
        this.inventory.damageArmor(i2);
        i2 = k2 / 25;
        this.field_781_a = k2 % 25;
        super.damageEntity(i2);
    }

    public void displayGUIFurnace(TileEntityFurnace tileentityfurnace) {
    }

    public void displayGUIEditSign(TileEntitySign tileentitysign) {
    }

    public void func_6415_a_(Entity entity) {
        entity.interact(this);
    }

    public ItemStack getCurrentEquippedItem() {
        return this.inventory.getCurrentItem();
    }

    public void destroyCurrentEquippedItem() {
        this.inventory.setInventorySlotContents(this.inventory.currentItem, null);
    }

    @Override
    public double func_388_v() {
        return this.yOffset - 0.5f;
    }

    public void func_457_w() {
        this.field_9368_k = -1;
        this.field_9369_j = true;
    }

    public void attackTargetEntityWithCurrentItem(Entity entity) {
        int i2 = this.inventory.getDamageVsEntity(entity);
        if (i2 > 0) {
            entity.canAttackEntity(this, i2);
            ItemStack itemstack = this.getCurrentEquippedItem();
            if (itemstack != null && entity instanceof EntityLiving) {
                itemstack.hitEntity((EntityLiving)entity);
                if (itemstack.stackSize <= 0) {
                    itemstack.func_1097_a(this);
                    this.destroyCurrentEquippedItem();
                }
            }
        }
    }

    public void func_9367_r() {
    }
}

