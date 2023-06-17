/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public final class ItemStack {
    public int stackSize = 0;
    public int animationsToGo;
    public int itemID;
    public int itemDamage;

    public ItemStack(Block block) {
        this(block, 1);
    }

    public ItemStack(Block block, int i2) {
        this(block.blockID, i2);
    }

    public ItemStack(Item item) {
        this(item, 1);
    }

    public ItemStack(Item item, int i2) {
        this(item.shiftedIndex, i2);
    }

    public ItemStack(int i2) {
        this(i2, 1);
    }

    public ItemStack(int i2, int j2) {
        this.itemID = i2;
        this.stackSize = j2;
    }

    public ItemStack(int i2, int j2, int k2) {
        this.itemID = i2;
        this.stackSize = j2;
        this.itemDamage = k2;
    }

    public ItemStack(NBTTagCompound nbttagcompound) {
        this.readFromNBT(nbttagcompound);
    }

    public ItemStack splitStack(int i2) {
        this.stackSize -= i2;
        return new ItemStack(this.itemID, i2, this.itemDamage);
    }

    public Item getItem() {
        return Item.itemsList[this.itemID];
    }

    public int getIconIndex() {
        return this.getItem().getIconIndex(this);
    }

    public boolean useItem(EntityPlayer entityplayer, World world, int i2, int j2, int k2, int l2) {
        return this.getItem().onItemUse(this, entityplayer, world, i2, j2, k2, l2);
    }

    public float getStrVsBlock(Block block) {
        return this.getItem().getStrVsBlock(this, block);
    }

    public ItemStack useItemRightClick(World world, EntityPlayer entityplayer) {
        return this.getItem().onItemRightClick(this, world, entityplayer);
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setShort("id", (short)this.itemID);
        nbttagcompound.setByte("Count", (byte)this.stackSize);
        nbttagcompound.setShort("Damage", (short)this.itemDamage);
        return nbttagcompound;
    }

    public void readFromNBT(NBTTagCompound nbttagcompound) {
        this.itemID = nbttagcompound.getShort("id");
        this.stackSize = nbttagcompound.getByte("Count");
        this.itemDamage = nbttagcompound.getShort("Damage");
    }

    public int getMaxStackSize() {
        return this.getItem().getItemStackLimit();
    }

    public int getMaxDamage() {
        return Item.itemsList[this.itemID].getMaxDamage();
    }

    public void damageItem(int i2) {
        this.itemDamage += i2;
        if (this.itemDamage > this.getMaxDamage()) {
            --this.stackSize;
            if (this.stackSize < 0) {
                this.stackSize = 0;
            }
            this.itemDamage = 0;
        }
    }

    public void hitEntity(EntityLiving entityliving) {
        Item.itemsList[this.itemID].hitEntity(this, entityliving);
    }

    public void hitBlock(int i2, int j2, int k2, int l2) {
        Item.itemsList[this.itemID].hitBlock(this, i2, j2, k2, l2);
    }

    public int getDamageVsEntity(Entity entity) {
        return Item.itemsList[this.itemID].getDamageVsEntity(entity);
    }

    public boolean canHarvestBlock(Block block) {
        return Item.itemsList[this.itemID].canHarvestBlock(block);
    }

    public void func_1097_a(EntityPlayer entityplayer) {
    }

    public void useItemOnEntity(EntityLiving entityliving) {
        Item.itemsList[this.itemID].func_4019_b(this, entityliving);
    }

    public ItemStack copy() {
        return new ItemStack(this.itemID, this.stackSize, this.itemDamage);
    }
}

