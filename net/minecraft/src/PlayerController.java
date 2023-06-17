/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class PlayerController {
    protected final Minecraft mc;
    public boolean field_1064_b = false;

    public PlayerController(Minecraft minecraft) {
        this.mc = minecraft;
    }

    public void func_717_a(World world) {
    }

    public void clickBlock(int i2, int j2, int k2, int l2) {
        this.sendBlockRemoved(i2, j2, k2, l2);
    }

    public boolean sendBlockRemoved(int i2, int j2, int k2, int l2) {
        this.mc.field_6321_h.func_1186_a(i2, j2, k2);
        World world = this.mc.theWorld;
        Block block = Block.blocksList[world.getBlockId(i2, j2, k2)];
        int i1 = world.getBlockMetadata(i2, j2, k2);
        boolean flag = world.setBlockWithNotify(i2, j2, k2, 0);
        if (block != null && flag) {
            this.mc.sndManager.func_336_b(block.stepSound.func_1146_a(), (float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f, (block.stepSound.func_1147_b() + 1.0f) / 2.0f, block.stepSound.func_1144_c() * 0.8f);
            block.onBlockDestroyedByPlayer(world, i2, j2, k2, i1);
        }
        return flag;
    }

    public void sendBlockRemoving(int i2, int j2, int k2, int l2) {
    }

    public void func_6468_a() {
    }

    public void func_6467_a(float f2) {
    }

    public float getBlockReachDistance() {
        return 5.0f;
    }

    public boolean sendUseItem(EntityPlayer entityplayer, World world, ItemStack itemstack) {
        int i2 = itemstack.stackSize;
        ItemStack itemstack1 = itemstack.useItemRightClick(world, entityplayer);
        if (itemstack1 != itemstack || itemstack1 != null && itemstack1.stackSize != i2) {
            entityplayer.inventory.mainInventory[entityplayer.inventory.currentItem] = itemstack1;
            if (itemstack1.stackSize == 0) {
                entityplayer.inventory.mainInventory[entityplayer.inventory.currentItem] = null;
            }
            return true;
        }
        return false;
    }

    public void flipPlayer(EntityPlayer entityplayer) {
    }

    public void func_6474_c() {
    }

    public boolean func_6469_d() {
        return true;
    }

    public void func_6473_b(EntityPlayer entityplayer) {
    }

    public boolean sendPlaceBlock(EntityPlayer entityplayer, World world, ItemStack itemstack, int i2, int j2, int k2, int l2) {
        int i1 = world.getBlockId(i2, j2, k2);
        if (i1 > 0 && Block.blocksList[i1].blockActivated(world, i2, j2, k2, entityplayer)) {
            return true;
        }
        if (itemstack == null) {
            return false;
        }
        return itemstack.useItem(entityplayer, world, i2, j2, k2, l2);
    }

    public EntityPlayer func_4087_b(World world) {
        return new EntityPlayerSP(this.mc, world, this.mc.field_6320_i, world.worldProvider.field_4218_e);
    }

    public void func_6475_a(EntityPlayer entityplayer, Entity entity) {
        entityplayer.func_6415_a_(entity);
    }

    public void func_6472_b(EntityPlayer entityplayer, Entity entity) {
        entityplayer.attackTargetEntityWithCurrentItem(entity);
    }
}

