/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.src.Block;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.World;

public class TileEntity {
    private static Map nameToClassMap = new HashMap();
    private static Map classToNameMap = new HashMap();
    public World worldObj;
    public int xCoord;
    public int yCoord;
    public int zCoord;

    static {
        TileEntity.addMapping(TileEntityFurnace.class, "Furnace");
        TileEntity.addMapping(TileEntityChest.class, "Chest");
        TileEntity.addMapping(TileEntitySign.class, "Sign");
        TileEntity.addMapping(TileEntityMobSpawner.class, "MobSpawner");
    }

    private static void addMapping(Class class1, String s2) {
        if (classToNameMap.containsKey(s2)) {
            throw new IllegalArgumentException("Duplicate id: " + s2);
        }
        nameToClassMap.put(s2, class1);
        classToNameMap.put(class1, s2);
    }

    public void readFromNBT(NBTTagCompound nbttagcompound) {
        this.xCoord = nbttagcompound.getInteger("x");
        this.yCoord = nbttagcompound.getInteger("y");
        this.zCoord = nbttagcompound.getInteger("z");
    }

    public void writeToNBT(NBTTagCompound nbttagcompound) {
        String s2 = (String)classToNameMap.get(this.getClass());
        if (s2 == null) {
            throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
        }
        nbttagcompound.setString("id", s2);
        nbttagcompound.setInteger("x", this.xCoord);
        nbttagcompound.setInteger("y", this.yCoord);
        nbttagcompound.setInteger("z", this.zCoord);
    }

    public void updateEntity() {
    }

    public static TileEntity createAndLoadEntity(NBTTagCompound nbttagcompound) {
        TileEntity tileentity = null;
        try {
            Class class1 = (Class)nameToClassMap.get(nbttagcompound.getString("id"));
            if (class1 != null) {
                tileentity = (TileEntity)class1.newInstance();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (tileentity != null) {
            tileentity.readFromNBT(nbttagcompound);
        } else {
            System.out.println("Skipping TileEntity with id " + nbttagcompound.getString("id"));
        }
        return tileentity;
    }

    public int getBlockMetadata() {
        return this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord);
    }

    public void onInventoryChanged() {
        this.worldObj.func_698_b(this.xCoord, this.yCoord, this.zCoord, this);
    }

    public double getDistanceFrom(double d2, double d1, double d22) {
        double d3 = (double)this.xCoord + 0.5 - d2;
        double d4 = (double)this.yCoord + 0.5 - d1;
        double d5 = (double)this.zCoord + 0.5 - d22;
        return d3 * d3 + d4 * d4 + d5 * d5;
    }

    public Block getBlockType() {
        return Block.blocksList[this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord)];
    }

    static Class _mthclass$(String s2) {
        try {
            return Class.forName(s2);
        }
        catch (ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }
}

