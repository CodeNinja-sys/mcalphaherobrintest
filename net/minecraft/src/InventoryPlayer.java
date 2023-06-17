/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;

public class InventoryPlayer
implements IInventory {
    public ItemStack[] mainInventory = new ItemStack[37];
    public ItemStack[] armorInventory = new ItemStack[4];
    public ItemStack[] craftingInventory = new ItemStack[4];
    public int currentItem = 0;
    private EntityPlayer player;
    public ItemStack draggingItemStack;
    public boolean field_845_f = false;

    public InventoryPlayer(EntityPlayer entityplayer) {
        this.player = entityplayer;
    }

    public ItemStack getCurrentItem() {
        return this.mainInventory[this.currentItem];
    }

    private int getInventorySlotContainItem(int i2) {
        for (int j2 = 0; j2 < this.mainInventory.length; ++j2) {
            if (this.mainInventory[j2] == null || this.mainInventory[j2].itemID != i2) continue;
            return j2;
        }
        return -1;
    }

    private int getFirstPartialMatchingStack(int i2) {
        for (int j2 = 0; j2 < this.mainInventory.length; ++j2) {
            if (this.mainInventory[j2] == null || this.mainInventory[j2].itemID != i2 || this.mainInventory[j2].stackSize >= this.mainInventory[j2].getMaxStackSize() || this.mainInventory[j2].stackSize >= this.getInventoryStackLimit()) continue;
            return j2;
        }
        return -1;
    }

    private int getFirstEmptyStack() {
        for (int i2 = 0; i2 < this.mainInventory.length; ++i2) {
            if (this.mainInventory[i2] != null) continue;
            return i2;
        }
        return -1;
    }

    public void setCurrentItem(int i2, boolean flag) {
        int j2 = this.getInventorySlotContainItem(i2);
        if (j2 >= 0 && j2 < 9) {
            this.currentItem = j2;
            return;
        }
    }

    public void changeCurrentItem(int i2) {
        if (i2 > 0) {
            i2 = 1;
        }
        if (i2 < 0) {
            i2 = -1;
        }
        this.currentItem -= i2;
        while (this.currentItem < 0) {
            this.currentItem += 9;
        }
        while (this.currentItem >= 9) {
            this.currentItem -= 9;
        }
    }

    private int addItemsToInventory(int i2, int j2) {
        int l2;
        int k2 = this.getFirstPartialMatchingStack(i2);
        if (k2 < 0) {
            k2 = this.getFirstEmptyStack();
        }
        if (k2 < 0) {
            return j2;
        }
        if (this.mainInventory[k2] == null) {
            this.mainInventory[k2] = new ItemStack(i2, 0);
        }
        if ((l2 = j2) > this.mainInventory[k2].getMaxStackSize() - this.mainInventory[k2].stackSize) {
            l2 = this.mainInventory[k2].getMaxStackSize() - this.mainInventory[k2].stackSize;
        }
        if (l2 > this.getInventoryStackLimit() - this.mainInventory[k2].stackSize) {
            l2 = this.getInventoryStackLimit() - this.mainInventory[k2].stackSize;
        }
        if (l2 == 0) {
            return j2;
        }
        this.mainInventory[k2].stackSize += l2;
        this.mainInventory[k2].animationsToGo = 5;
        return j2 -= l2;
    }

    public void decrementAnimations() {
        for (int i2 = 0; i2 < this.mainInventory.length; ++i2) {
            if (this.mainInventory[i2] == null || this.mainInventory[i2].animationsToGo <= 0) continue;
            --this.mainInventory[i2].animationsToGo;
        }
    }

    public boolean consumeInventoryItem(int i2) {
        int j2 = this.getInventorySlotContainItem(i2);
        if (j2 < 0) {
            return false;
        }
        if (--this.mainInventory[j2].stackSize <= 0) {
            this.mainInventory[j2] = null;
        }
        return true;
    }

    public boolean addItemStackToInventory(ItemStack itemstack) {
        int i2;
        if (itemstack.itemDamage == 0) {
            itemstack.stackSize = this.addItemsToInventory(itemstack.itemID, itemstack.stackSize);
            if (itemstack.stackSize == 0) {
                return true;
            }
        }
        if ((i2 = this.getFirstEmptyStack()) >= 0) {
            this.mainInventory[i2] = itemstack;
            this.mainInventory[i2].animationsToGo = 5;
            return true;
        }
        return false;
    }

    @Override
    public ItemStack decrStackSize(int i2, int j2) {
        ItemStack[] aitemstack = this.mainInventory;
        if (i2 >= this.mainInventory.length) {
            aitemstack = this.armorInventory;
            i2 -= this.mainInventory.length;
        }
        if (aitemstack[i2] != null) {
            if (aitemstack[i2].stackSize <= j2) {
                ItemStack itemstack = aitemstack[i2];
                aitemstack[i2] = null;
                return itemstack;
            }
            ItemStack itemstack1 = aitemstack[i2].splitStack(j2);
            if (aitemstack[i2].stackSize == 0) {
                aitemstack[i2] = null;
            }
            return itemstack1;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int i2, ItemStack itemstack) {
        ItemStack[] aitemstack = this.mainInventory;
        if (i2 >= aitemstack.length) {
            i2 -= aitemstack.length;
            aitemstack = this.armorInventory;
        }
        if (i2 >= aitemstack.length) {
            i2 -= aitemstack.length;
            aitemstack = this.craftingInventory;
        }
        aitemstack[i2] = itemstack;
    }

    public float getStrVsBlock(Block block) {
        float f2 = 1.0f;
        if (this.mainInventory[this.currentItem] != null) {
            f2 *= this.mainInventory[this.currentItem].getStrVsBlock(block);
        }
        return f2;
    }

    public NBTTagList writeToNBT(NBTTagList nbttaglist) {
        for (int i2 = 0; i2 < this.mainInventory.length; ++i2) {
            if (this.mainInventory[i2] == null) continue;
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.setByte("Slot", (byte)i2);
            this.mainInventory[i2].writeToNBT(nbttagcompound);
            nbttaglist.setTag(nbttagcompound);
        }
        for (int j2 = 0; j2 < this.armorInventory.length; ++j2) {
            if (this.armorInventory[j2] == null) continue;
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound1.setByte("Slot", (byte)(j2 + 100));
            this.armorInventory[j2].writeToNBT(nbttagcompound1);
            nbttaglist.setTag(nbttagcompound1);
        }
        for (int k2 = 0; k2 < this.craftingInventory.length; ++k2) {
            if (this.craftingInventory[k2] == null) continue;
            NBTTagCompound nbttagcompound2 = new NBTTagCompound();
            nbttagcompound2.setByte("Slot", (byte)(k2 + 80));
            this.craftingInventory[k2].writeToNBT(nbttagcompound2);
            nbttaglist.setTag(nbttagcompound2);
        }
        return nbttaglist;
    }

    public void readFromNBT(NBTTagList nbttaglist) {
        this.mainInventory = new ItemStack[36];
        this.armorInventory = new ItemStack[4];
        this.craftingInventory = new ItemStack[4];
        for (int i2 = 0; i2 < nbttaglist.tagCount(); ++i2) {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i2);
            int j2 = nbttagcompound.getByte("Slot") & 0xFF;
            if (j2 >= 0 && j2 < this.mainInventory.length) {
                this.mainInventory[j2] = new ItemStack(nbttagcompound);
            }
            if (j2 >= 80 && j2 < this.craftingInventory.length + 80) {
                this.craftingInventory[j2 - 80] = new ItemStack(nbttagcompound);
            }
            if (j2 < 100 || j2 >= this.armorInventory.length + 100) continue;
            this.armorInventory[j2 - 100] = new ItemStack(nbttagcompound);
        }
    }

    @Override
    public int getSizeInventory() {
        return this.mainInventory.length + 4;
    }

    @Override
    public ItemStack getStackInSlot(int i2) {
        ItemStack[] aitemstack = this.mainInventory;
        if (i2 >= aitemstack.length) {
            i2 -= aitemstack.length;
            aitemstack = this.armorInventory;
        }
        if (i2 >= aitemstack.length) {
            i2 -= aitemstack.length;
            aitemstack = this.craftingInventory;
        }
        return aitemstack[i2];
    }

    @Override
    public String getInvName() {
        return "Inventory";
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    public int getDamageVsEntity(Entity entity) {
        ItemStack itemstack = this.getStackInSlot(this.currentItem);
        if (itemstack != null) {
            return itemstack.getDamageVsEntity(entity);
        }
        return 1;
    }

    public boolean canHarvestBlock(Block block) {
        if (block.blockMaterial != Material.rock && block.blockMaterial != Material.iron && block.blockMaterial != Material.builtSnow && block.blockMaterial != Material.snow) {
            return true;
        }
        ItemStack itemstack = this.getStackInSlot(this.currentItem);
        if (itemstack != null) {
            return itemstack.canHarvestBlock(block);
        }
        return false;
    }

    public ItemStack armorItemInSlot(int i2) {
        return this.armorInventory[i2];
    }

    public int getTotalArmorValue() {
        int i2 = 0;
        int j2 = 0;
        int k2 = 0;
        for (int l2 = 0; l2 < this.armorInventory.length; ++l2) {
            if (this.armorInventory[l2] == null || !(this.armorInventory[l2].getItem() instanceof ItemArmor)) continue;
            int i1 = this.armorInventory[l2].getMaxDamage();
            int j1 = this.armorInventory[l2].itemDamage;
            int k1 = i1 - j1;
            j2 += k1;
            k2 += i1;
            int l1 = ((ItemArmor)this.armorInventory[l2].getItem()).damageReduceAmmount;
            i2 += l1;
        }
        if (k2 == 0) {
            return 0;
        }
        return (i2 - 1) * j2 / k2 + 1;
    }

    public void damageArmor(int i2) {
        for (int j2 = 0; j2 < this.armorInventory.length; ++j2) {
            if (this.armorInventory[j2] == null || !(this.armorInventory[j2].getItem() instanceof ItemArmor)) continue;
            this.armorInventory[j2].damageItem(i2);
            if (this.armorInventory[j2].stackSize != 0) continue;
            this.armorInventory[j2].func_1097_a(this.player);
            this.armorInventory[j2] = null;
        }
    }

    public void dropAllItems() {
        for (int i2 = 0; i2 < this.mainInventory.length; ++i2) {
            if (this.mainInventory[i2] == null) continue;
            this.player.dropPlayerItemWithRandomChoice(this.mainInventory[i2], true);
            this.mainInventory[i2] = null;
        }
        for (int j2 = 0; j2 < this.armorInventory.length; ++j2) {
            if (this.armorInventory[j2] == null) continue;
            this.player.dropPlayerItemWithRandomChoice(this.armorInventory[j2], true);
            this.armorInventory[j2] = null;
        }
    }

    @Override
    public void onInventoryChanged() {
        this.field_845_f = true;
    }

    public boolean compareInventory(InventoryPlayer inventoryplayer) {
        for (int i2 = 0; i2 < this.mainInventory.length; ++i2) {
            if (this.compareItemStack(inventoryplayer.mainInventory[i2], this.mainInventory[i2])) continue;
            return false;
        }
        for (int j2 = 0; j2 < this.armorInventory.length; ++j2) {
            if (this.compareItemStack(inventoryplayer.armorInventory[j2], this.armorInventory[j2])) continue;
            return false;
        }
        for (int k2 = 0; k2 < this.craftingInventory.length; ++k2) {
            if (this.compareItemStack(inventoryplayer.craftingInventory[k2], this.craftingInventory[k2])) continue;
            return false;
        }
        return true;
    }

    private boolean compareItemStack(ItemStack itemstack, ItemStack itemstack1) {
        if (itemstack == null && itemstack1 == null) {
            return true;
        }
        if (itemstack == null || itemstack1 == null) {
            return false;
        }
        return itemstack.itemID == itemstack1.itemID && itemstack.stackSize == itemstack1.stackSize && itemstack.itemDamage == itemstack1.itemDamage;
    }

    public InventoryPlayer copyInventory() {
        InventoryPlayer inventoryplayer = new InventoryPlayer(null);
        for (int i2 = 0; i2 < this.mainInventory.length; ++i2) {
            inventoryplayer.mainInventory[i2] = this.mainInventory[i2] == null ? null : this.mainInventory[i2].copy();
        }
        for (int j2 = 0; j2 < this.armorInventory.length; ++j2) {
            inventoryplayer.armorInventory[j2] = this.armorInventory[j2] == null ? null : this.armorInventory[j2].copy();
        }
        for (int k2 = 0; k2 < this.craftingInventory.length; ++k2) {
            inventoryplayer.craftingInventory[k2] = this.craftingInventory[k2] == null ? null : this.craftingInventory[k2].copy();
        }
        return inventoryplayer;
    }
}

