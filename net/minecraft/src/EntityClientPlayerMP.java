/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet10Flying;
import net.minecraft.src.Packet11PlayerPosition;
import net.minecraft.src.Packet12PlayerLook;
import net.minecraft.src.Packet13PlayerLookMove;
import net.minecraft.src.Packet18ArmAnimation;
import net.minecraft.src.Packet21PickupSpawn;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.Packet5PlayerInventory;
import net.minecraft.src.Packet9;
import net.minecraft.src.Session;
import net.minecraft.src.World;

public class EntityClientPlayerMP
extends EntityPlayerSP {
    private NetClientHandler field_797_bg;
    private int field_9380_bx = 0;
    private double field_9379_by;
    private double field_9378_bz;
    private double field_9377_bA;
    private double field_9376_bB;
    private float field_9385_bC;
    private float field_9384_bD;
    private InventoryPlayer field_9383_bE = new InventoryPlayer(null);
    private boolean field_9382_bF = false;
    private boolean field_9381_bG = false;
    private int field_12242_bI = 0;

    public EntityClientPlayerMP(Minecraft minecraft, World world, Session session, NetClientHandler netclienthandler) {
        super(minecraft, world, session, 0);
        this.field_797_bg = netclienthandler;
    }

    @Override
    public boolean canAttackEntity(Entity entity, int i2) {
        return false;
    }

    @Override
    public void heal(int i2) {
    }

    @Override
    public void onUpdate() {
        if (!this.worldObj.blockExists(MathHelper.floor_double(this.posX), 64, MathHelper.floor_double(this.posZ))) {
            return;
        }
        super.onUpdate();
        this.func_4056_N();
    }

    @Override
    public void func_6420_o() {
    }

    public void func_4056_N() {
        boolean flag2;
        boolean flag;
        if (this.field_9380_bx++ == 20) {
            this.sendInventoryChanged();
            this.field_9380_bx = 0;
        }
        if ((flag = this.func_381_o()) != this.field_9381_bG) {
            if (flag) {
                this.field_797_bg.addToSendQueue(new Packet18ArmAnimation(this, 104));
            } else {
                this.field_797_bg.addToSendQueue(new Packet18ArmAnimation(this, 105));
            }
            this.field_9381_bG = flag;
        }
        double d2 = this.posX - this.field_9379_by;
        double d1 = this.boundingBox.minY - this.field_9378_bz;
        double d22 = this.posY - this.field_9377_bA;
        double d3 = this.posZ - this.field_9376_bB;
        double d4 = this.rotationYaw - this.field_9385_bC;
        double d5 = this.rotationPitch - this.field_9384_bD;
        boolean flag1 = d1 != 0.0 || d22 != 0.0 || d2 != 0.0 || d3 != 0.0;
        boolean bl2 = flag2 = d4 != 0.0 || d5 != 0.0;
        if (this.ridingEntity != null) {
            if (flag2) {
                this.field_797_bg.addToSendQueue(new Packet11PlayerPosition(this.motionX, -999.0, -999.0, this.motionZ, this.onGround));
            } else {
                this.field_797_bg.addToSendQueue(new Packet13PlayerLookMove(this.motionX, -999.0, -999.0, this.motionZ, this.rotationYaw, this.rotationPitch, this.onGround));
            }
            flag1 = false;
        } else if (flag1 && flag2) {
            this.field_797_bg.addToSendQueue(new Packet13PlayerLookMove(this.posX, this.boundingBox.minY, this.posY, this.posZ, this.rotationYaw, this.rotationPitch, this.onGround));
            this.field_12242_bI = 0;
        } else if (flag1) {
            this.field_797_bg.addToSendQueue(new Packet11PlayerPosition(this.posX, this.boundingBox.minY, this.posY, this.posZ, this.onGround));
            this.field_12242_bI = 0;
        } else if (flag2) {
            this.field_797_bg.addToSendQueue(new Packet12PlayerLook(this.rotationYaw, this.rotationPitch, this.onGround));
            this.field_12242_bI = 0;
        } else {
            this.field_797_bg.addToSendQueue(new Packet10Flying(this.onGround));
            this.field_12242_bI = this.field_9382_bF != this.onGround || this.field_12242_bI > 20 ? 0 : ++this.field_12242_bI;
        }
        this.field_9382_bF = this.onGround;
        if (flag1) {
            this.field_9379_by = this.posX;
            this.field_9378_bz = this.boundingBox.minY;
            this.field_9377_bA = this.posY;
            this.field_9376_bB = this.posZ;
        }
        if (flag2) {
            this.field_9385_bC = this.rotationYaw;
            this.field_9384_bD = this.rotationPitch;
        }
    }

    private void sendInventoryChanged() {
        if (!this.inventory.compareInventory(this.field_9383_bE)) {
            this.field_797_bg.addToSendQueue(new Packet5PlayerInventory(-1, this.inventory.mainInventory));
            this.field_797_bg.addToSendQueue(new Packet5PlayerInventory(-2, this.inventory.craftingInventory));
            this.field_797_bg.addToSendQueue(new Packet5PlayerInventory(-3, this.inventory.armorInventory));
            this.field_9383_bE = this.inventory.copyInventory();
        }
    }

    @Override
    protected void joinEntityItemWithWorld(EntityItem entityitem) {
        Packet21PickupSpawn packet21pickupspawn = new Packet21PickupSpawn(entityitem);
        this.field_797_bg.addToSendQueue(packet21pickupspawn);
        entityitem.posX = (double)packet21pickupspawn.xPosition / 32.0;
        entityitem.posY = (double)packet21pickupspawn.yPosition / 32.0;
        entityitem.posZ = (double)packet21pickupspawn.zPosition / 32.0;
        entityitem.motionX = (double)packet21pickupspawn.rotation / 128.0;
        entityitem.motionY = (double)packet21pickupspawn.pitch / 128.0;
        entityitem.motionZ = (double)packet21pickupspawn.roll / 128.0;
    }

    @Override
    public void sendChatMessage(String s2) {
        this.field_797_bg.addToSendQueue(new Packet3Chat(s2));
    }

    @Override
    public void func_457_w() {
        super.func_457_w();
        this.field_797_bg.addToSendQueue(new Packet18ArmAnimation(this, 1));
    }

    @Override
    public void func_9367_r() {
        this.sendInventoryChanged();
        this.field_797_bg.addToSendQueue(new Packet9());
    }

    @Override
    protected void damageEntity(int i2) {
        this.health -= i2;
    }
}

