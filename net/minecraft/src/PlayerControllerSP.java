/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PlayerController;
import net.minecraft.src.World;

public class PlayerControllerSP
extends PlayerController {
    private int field_1074_c = -1;
    private int field_1073_d = -1;
    private int field_1072_e = -1;
    private float field_1071_f = 0.0f;
    private float field_1070_g = 0.0f;
    private float field_1069_h = 0.0f;
    private int field_1068_i = 0;

    public PlayerControllerSP(Minecraft minecraft) {
        super(minecraft);
    }

    @Override
    public void flipPlayer(EntityPlayer entityplayer) {
        entityplayer.rotationYaw = -180.0f;
    }

    @Override
    public boolean sendBlockRemoved(int i2, int j2, int k2, int l2) {
        int i1 = this.mc.theWorld.getBlockId(i2, j2, k2);
        int j1 = this.mc.theWorld.getBlockMetadata(i2, j2, k2);
        boolean flag = super.sendBlockRemoved(i2, j2, k2, l2);
        ItemStack itemstack = this.mc.thePlayer.getCurrentEquippedItem();
        boolean flag1 = this.mc.thePlayer.canHarvestBlock(Block.blocksList[i1]);
        if (itemstack != null) {
            itemstack.hitBlock(i1, i2, j2, k2);
            if (itemstack.stackSize == 0) {
                itemstack.func_1097_a(this.mc.thePlayer);
                this.mc.thePlayer.destroyCurrentEquippedItem();
            }
        }
        if (flag && flag1) {
            Block.blocksList[i1].harvestBlock(this.mc.theWorld, i2, j2, k2, j1);
        }
        return flag;
    }

    @Override
    public void clickBlock(int i2, int j2, int k2, int l2) {
        int i1 = this.mc.theWorld.getBlockId(i2, j2, k2);
        if (i1 > 0 && this.field_1071_f == 0.0f) {
            Block.blocksList[i1].onBlockClicked(this.mc.theWorld, i2, j2, k2, this.mc.thePlayer);
        }
        if (i1 > 0 && Block.blocksList[i1].func_225_a(this.mc.thePlayer) >= 1.0f) {
            this.sendBlockRemoved(i2, j2, k2, l2);
        }
    }

    @Override
    public void func_6468_a() {
        this.field_1071_f = 0.0f;
        this.field_1068_i = 0;
    }

    @Override
    public void sendBlockRemoving(int i2, int j2, int k2, int l2) {
        if (this.field_1068_i > 0) {
            --this.field_1068_i;
            return;
        }
        if (i2 == this.field_1074_c && j2 == this.field_1073_d && k2 == this.field_1072_e) {
            int i1 = this.mc.theWorld.getBlockId(i2, j2, k2);
            if (i1 == 0) {
                return;
            }
            Block block = Block.blocksList[i1];
            this.field_1071_f += block.func_225_a(this.mc.thePlayer);
            if (this.field_1069_h % 4.0f == 0.0f && block != null) {
                this.mc.sndManager.func_336_b(block.stepSound.func_1145_d(), (float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f, (block.stepSound.func_1147_b() + 1.0f) / 8.0f, block.stepSound.func_1144_c() * 0.5f);
            }
            this.field_1069_h += 1.0f;
            if (this.field_1071_f >= 1.0f) {
                this.sendBlockRemoved(i2, j2, k2, l2);
                this.field_1071_f = 0.0f;
                this.field_1070_g = 0.0f;
                this.field_1069_h = 0.0f;
                this.field_1068_i = 5;
            }
        } else {
            this.field_1071_f = 0.0f;
            this.field_1070_g = 0.0f;
            this.field_1069_h = 0.0f;
            this.field_1074_c = i2;
            this.field_1073_d = j2;
            this.field_1072_e = k2;
        }
    }

    @Override
    public void func_6467_a(float f2) {
        if (this.field_1071_f <= 0.0f) {
            this.mc.ingameGUI.field_6446_b = 0.0f;
            this.mc.field_6323_f.field_1450_i = 0.0f;
        } else {
            float f1;
            this.mc.ingameGUI.field_6446_b = f1 = this.field_1070_g + (this.field_1071_f - this.field_1070_g) * f2;
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
        this.field_1070_g = this.field_1071_f;
        this.mc.sndManager.func_4033_c();
    }
}

