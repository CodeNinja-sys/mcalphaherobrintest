/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet14BlockDig;
import net.minecraft.src.Packet15Place;
import net.minecraft.src.Packet16BlockItemSwitch;
import net.minecraft.src.Packet7;
import net.minecraft.src.PlayerController;
import net.minecraft.src.World;

public class PlayerControllerMP
extends PlayerController {
    private int field_9445_c = -1;
    private int field_9444_d = -1;
    private int field_9443_e = -1;
    private float field_9442_f = 0.0f;
    private float field_1080_g = 0.0f;
    private float field_9441_h = 0.0f;
    private int field_9440_i = 0;
    private boolean field_9439_j = false;
    private NetClientHandler field_9438_k;
    private int field_1075_l = 0;

    public PlayerControllerMP(Minecraft minecraft, NetClientHandler netclienthandler) {
        super(minecraft);
        this.field_9438_k = netclienthandler;
    }

    @Override
    public void flipPlayer(EntityPlayer entityplayer) {
        entityplayer.rotationYaw = -180.0f;
    }

    @Override
    public boolean sendBlockRemoved(int i2, int j2, int k2, int l2) {
        this.field_9438_k.addToSendQueue(new Packet14BlockDig(3, i2, j2, k2, l2));
        int i1 = this.mc.theWorld.getBlockId(i2, j2, k2);
        int j1 = this.mc.theWorld.getBlockMetadata(i2, j2, k2);
        boolean flag = super.sendBlockRemoved(i2, j2, k2, l2);
        ItemStack itemstack = this.mc.thePlayer.getCurrentEquippedItem();
        if (itemstack != null) {
            itemstack.hitBlock(i1, i2, j2, k2);
            if (itemstack.stackSize == 0) {
                itemstack.func_1097_a(this.mc.thePlayer);
                this.mc.thePlayer.destroyCurrentEquippedItem();
            }
        }
        return flag;
    }

    @Override
    public void clickBlock(int i2, int j2, int k2, int l2) {
        this.field_9439_j = true;
        this.field_9438_k.addToSendQueue(new Packet14BlockDig(0, i2, j2, k2, l2));
        int i1 = this.mc.theWorld.getBlockId(i2, j2, k2);
        if (i1 > 0 && this.field_9442_f == 0.0f) {
            Block.blocksList[i1].onBlockClicked(this.mc.theWorld, i2, j2, k2, this.mc.thePlayer);
        }
        if (i1 > 0 && Block.blocksList[i1].func_225_a(this.mc.thePlayer) >= 1.0f) {
            this.sendBlockRemoved(i2, j2, k2, l2);
        }
    }

    @Override
    public void func_6468_a() {
        if (!this.field_9439_j) {
            return;
        }
        this.field_9439_j = false;
        this.field_9438_k.addToSendQueue(new Packet14BlockDig(2, 0, 0, 0, 0));
        this.field_9442_f = 0.0f;
        this.field_9440_i = 0;
    }

    @Override
    public void sendBlockRemoving(int i2, int j2, int k2, int l2) {
        this.field_9439_j = true;
        this.func_730_e();
        this.field_9438_k.addToSendQueue(new Packet14BlockDig(1, i2, j2, k2, l2));
        if (this.field_9440_i > 0) {
            --this.field_9440_i;
            return;
        }
        if (i2 == this.field_9445_c && j2 == this.field_9444_d && k2 == this.field_9443_e) {
            int i1 = this.mc.theWorld.getBlockId(i2, j2, k2);
            if (i1 == 0) {
                return;
            }
            Block block = Block.blocksList[i1];
            this.field_9442_f += block.func_225_a(this.mc.thePlayer);
            if (this.field_9441_h % 4.0f == 0.0f && block != null) {
                this.mc.sndManager.func_336_b(block.stepSound.func_1145_d(), (float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f, (block.stepSound.func_1147_b() + 1.0f) / 8.0f, block.stepSound.func_1144_c() * 0.5f);
            }
            this.field_9441_h += 1.0f;
            if (this.field_9442_f >= 1.0f) {
                this.sendBlockRemoved(i2, j2, k2, l2);
                this.field_9442_f = 0.0f;
                this.field_1080_g = 0.0f;
                this.field_9441_h = 0.0f;
                this.field_9440_i = 5;
            }
        } else {
            this.field_9442_f = 0.0f;
            this.field_1080_g = 0.0f;
            this.field_9441_h = 0.0f;
            this.field_9445_c = i2;
            this.field_9444_d = j2;
            this.field_9443_e = k2;
        }
    }

    @Override
    public void func_6467_a(float f2) {
        if (this.field_9442_f <= 0.0f) {
            this.mc.ingameGUI.field_6446_b = 0.0f;
            this.mc.field_6323_f.field_1450_i = 0.0f;
        } else {
            float f1;
            this.mc.ingameGUI.field_6446_b = f1 = this.field_1080_g + (this.field_9442_f - this.field_1080_g) * f2;
            this.mc.field_6323_f.field_1450_i = f1;
        }
    }

    @Override
    public float getBlockReachDistance() {
        return 4.0f;
    }

    @Override
    public void func_717_a(World world) {
        super.func_717_a(world);
    }

    @Override
    public void func_6474_c() {
        this.func_730_e();
        this.field_1080_g = this.field_9442_f;
        this.mc.sndManager.func_4033_c();
    }

    private void func_730_e() {
        ItemStack itemstack = this.mc.thePlayer.inventory.getCurrentItem();
        int i2 = 0;
        if (itemstack != null) {
            i2 = itemstack.itemID;
        }
        if (i2 != this.field_1075_l) {
            this.field_1075_l = i2;
            this.field_9438_k.addToSendQueue(new Packet16BlockItemSwitch(0, this.field_1075_l));
        }
    }

    @Override
    public boolean sendPlaceBlock(EntityPlayer entityplayer, World world, ItemStack itemstack, int i2, int j2, int k2, int l2) {
        this.func_730_e();
        this.field_9438_k.addToSendQueue(new Packet15Place(itemstack == null ? -1 : itemstack.itemID, i2, j2, k2, l2));
        return super.sendPlaceBlock(entityplayer, world, itemstack, i2, j2, k2, l2);
    }

    @Override
    public boolean sendUseItem(EntityPlayer entityplayer, World world, ItemStack itemstack) {
        this.func_730_e();
        this.field_9438_k.addToSendQueue(new Packet15Place(itemstack == null ? -1 : itemstack.itemID, -1, -1, -1, 255));
        return super.sendUseItem(entityplayer, world, itemstack);
    }

    @Override
    public EntityPlayer func_4087_b(World world) {
        return new EntityClientPlayerMP(this.mc, world, this.mc.field_6320_i, this.field_9438_k);
    }

    @Override
    public void func_6472_b(EntityPlayer entityplayer, Entity entity) {
        this.func_730_e();
        this.field_9438_k.addToSendQueue(new Packet7(entityplayer.field_620_ab, entity.field_620_ab, 1));
        entityplayer.attackTargetEntityWithCurrentItem(entity);
    }

    @Override
    public void func_6475_a(EntityPlayer entityplayer, Entity entity) {
        this.func_730_e();
        this.field_9438_k.addToSendQueue(new Packet7(entityplayer.field_620_ab, entity.field_620_ab, 0));
        entityplayer.func_6415_a_(entity);
    }
}

