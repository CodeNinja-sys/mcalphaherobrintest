/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemAxe;
import net.minecraft.src.ItemBoat;
import net.minecraft.src.ItemBow;
import net.minecraft.src.ItemBucket;
import net.minecraft.src.ItemDoor;
import net.minecraft.src.ItemFishingRod;
import net.minecraft.src.ItemFlintAndSteel;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemHoe;
import net.minecraft.src.ItemMinecart;
import net.minecraft.src.ItemPainting;
import net.minecraft.src.ItemPickaxe;
import net.minecraft.src.ItemRecord;
import net.minecraft.src.ItemRedstone;
import net.minecraft.src.ItemReed;
import net.minecraft.src.ItemSaddle;
import net.minecraft.src.ItemSeeds;
import net.minecraft.src.ItemSign;
import net.minecraft.src.ItemSnowball;
import net.minecraft.src.ItemSoup;
import net.minecraft.src.ItemSpade;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ItemSword;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class Item {
    protected static Random itemRand = new Random();
    public static Item[] itemsList = new Item[32000];
    public static Item shovelSteel = new ItemSpade(0, 2).setIconIndex(82);
    public static Item pickaxeSteel = new ItemPickaxe(1, 2).setIconIndex(98);
    public static Item axeSteel = new ItemAxe(2, 2).setIconIndex(114);
    public static Item flintAndSteel = new ItemFlintAndSteel(3).setIconIndex(5);
    public static Item appleRed = new ItemFood(4, 4).setIconIndex(10);
    public static Item bow = new ItemBow(5).setIconIndex(21);
    public static Item arrow = new Item(6).setIconIndex(37);
    public static Item coal = new Item(7).setIconIndex(7);
    public static Item diamond = new Item(8).setIconIndex(55);
    public static Item ingotIron = new Item(9).setIconIndex(23);
    public static Item ingotGold = new Item(10).setIconIndex(39);
    public static Item swordSteel = new ItemSword(11, 2).setIconIndex(66);
    public static Item swordWood = new ItemSword(12, 0).setIconIndex(64);
    public static Item shovelWood = new ItemSpade(13, 0).setIconIndex(80);
    public static Item pickaxeWood = new ItemPickaxe(14, 0).setIconIndex(96);
    public static Item axeWood = new ItemAxe(15, 0).setIconIndex(112);
    public static Item swordStone = new ItemSword(16, 1).setIconIndex(65);
    public static Item shovelStone = new ItemSpade(17, 1).setIconIndex(81);
    public static Item pickaxeStone = new ItemPickaxe(18, 1).setIconIndex(97);
    public static Item axeStone = new ItemAxe(19, 1).setIconIndex(113);
    public static Item swordDiamond = new ItemSword(20, 3).setIconIndex(67);
    public static Item shovelDiamond = new ItemSpade(21, 3).setIconIndex(83);
    public static Item pickaxeDiamond = new ItemPickaxe(22, 3).setIconIndex(99);
    public static Item axeDiamond = new ItemAxe(23, 3).setIconIndex(115);
    public static Item stick = new Item(24).setIconIndex(53).setFull3D();
    public static Item bowlEmpty = new Item(25).setIconIndex(71);
    public static Item bowlSoup = new ItemSoup(26, 10).setIconIndex(72);
    public static Item swordGold = new ItemSword(27, 0).setIconIndex(68);
    public static Item shovelGold = new ItemSpade(28, 0).setIconIndex(84);
    public static Item pickaxeGold = new ItemPickaxe(29, 0).setIconIndex(100);
    public static Item axeGold = new ItemAxe(30, 0).setIconIndex(116);
    public static Item silk = new Item(31).setIconIndex(8);
    public static Item feather = new Item(32).setIconIndex(24);
    public static Item gunpowder = new Item(33).setIconIndex(40);
    public static Item hoeWood = new ItemHoe(34, 0).setIconIndex(128);
    public static Item hoeStone = new ItemHoe(35, 1).setIconIndex(129);
    public static Item hoeSteel = new ItemHoe(36, 2).setIconIndex(130);
    public static Item hoeDiamond = new ItemHoe(37, 3).setIconIndex(131);
    public static Item hoeGold = new ItemHoe(38, 1).setIconIndex(132);
    public static Item seeds;
    public static Item wheat;
    public static Item bread;
    public static Item helmetLeather;
    public static Item plateLeather;
    public static Item legsLeather;
    public static Item bootsLeather;
    public static Item helmetChain;
    public static Item plateChain;
    public static Item legsChain;
    public static Item bootsChain;
    public static Item helmetSteel;
    public static Item plateSteel;
    public static Item legsSteel;
    public static Item bootsSteel;
    public static Item helmetDiamond;
    public static Item plateDiamond;
    public static Item legsDiamond;
    public static Item bootsDiamond;
    public static Item helmetGold;
    public static Item plateGold;
    public static Item legsGold;
    public static Item bootsGold;
    public static Item flint;
    public static Item porkRaw;
    public static Item porkCooked;
    public static Item painting;
    public static Item appleGold;
    public static Item sign;
    public static Item doorWood;
    public static Item bucketEmpty;
    public static Item bucketWater;
    public static Item bucketLava;
    public static Item minecartEmpty;
    public static Item saddle;
    public static Item doorSteel;
    public static Item redstone;
    public static Item snowball;
    public static Item boat;
    public static Item leather;
    public static Item bucketMilk;
    public static Item brick;
    public static Item clay;
    public static Item reed;
    public static Item paper;
    public static Item book;
    public static Item slimeBall;
    public static Item minecartCrate;
    public static Item minecartPowered;
    public static Item egg;
    public static Item compass;
    public static Item fishingRod;
    public static Item pocketSundial;
    public static Item lightStoneDust;
    public static Item fishRaw;
    public static Item fishCooked;
    public static Item record13;
    public static Item recordCat;
    public final int shiftedIndex;
    protected int maxStackSize = 64;
    protected int maxDamage = 32;
    protected int iconIndex;
    protected boolean bFull3D = false;

    static {
        wheat = new Item(40).setIconIndex(25);
        bread = new ItemFood(41, 5).setIconIndex(41);
        helmetLeather = new ItemArmor(42, 0, 0, 0).setIconIndex(0);
        plateLeather = new ItemArmor(43, 0, 0, 1).setIconIndex(16);
        legsLeather = new ItemArmor(44, 0, 0, 2).setIconIndex(32);
        bootsLeather = new ItemArmor(45, 0, 0, 3).setIconIndex(48);
        helmetChain = new ItemArmor(46, 1, 1, 0).setIconIndex(1);
        plateChain = new ItemArmor(47, 1, 1, 1).setIconIndex(17);
        legsChain = new ItemArmor(48, 1, 1, 2).setIconIndex(33);
        bootsChain = new ItemArmor(49, 1, 1, 3).setIconIndex(49);
        helmetSteel = new ItemArmor(50, 2, 2, 0).setIconIndex(2);
        plateSteel = new ItemArmor(51, 2, 2, 1).setIconIndex(18);
        legsSteel = new ItemArmor(52, 2, 2, 2).setIconIndex(34);
        bootsSteel = new ItemArmor(53, 2, 2, 3).setIconIndex(50);
        helmetDiamond = new ItemArmor(54, 3, 3, 0).setIconIndex(3);
        plateDiamond = new ItemArmor(55, 3, 3, 1).setIconIndex(19);
        legsDiamond = new ItemArmor(56, 3, 3, 2).setIconIndex(35);
        bootsDiamond = new ItemArmor(57, 3, 3, 3).setIconIndex(51);
        helmetGold = new ItemArmor(58, 1, 4, 0).setIconIndex(4);
        plateGold = new ItemArmor(59, 1, 4, 1).setIconIndex(20);
        legsGold = new ItemArmor(60, 1, 4, 2).setIconIndex(36);
        bootsGold = new ItemArmor(61, 1, 4, 3).setIconIndex(52);
        flint = new Item(62).setIconIndex(6);
        porkRaw = new ItemFood(63, 3).setIconIndex(87);
        porkCooked = new ItemFood(64, 8).setIconIndex(88);
        painting = new ItemPainting(65).setIconIndex(26);
        appleGold = new ItemFood(66, 42).setIconIndex(11);
        sign = new ItemSign(67).setIconIndex(42);
        bucketEmpty = new ItemBucket(69, 0).setIconIndex(74);
        minecartEmpty = new ItemMinecart(72, 0).setIconIndex(135);
        saddle = new ItemSaddle(73).setIconIndex(104);
        redstone = new ItemRedstone(75).setIconIndex(56);
        snowball = new ItemSnowball(76).setIconIndex(14);
        boat = new ItemBoat(77).setIconIndex(136);
        leather = new Item(78).setIconIndex(103);
        bucketMilk = new ItemBucket(79, -1).setIconIndex(77);
        brick = new Item(80).setIconIndex(22);
        clay = new Item(81).setIconIndex(57);
        paper = new Item(83).setIconIndex(58);
        book = new Item(84).setIconIndex(59);
        slimeBall = new Item(85).setIconIndex(30);
        minecartCrate = new ItemMinecart(86, 1).setIconIndex(151);
        minecartPowered = new ItemMinecart(87, 2).setIconIndex(167);
        egg = new Item(88).setIconIndex(12);
        compass = new Item(89).setIconIndex(54);
        fishingRod = new ItemFishingRod(90).setIconIndex(69);
        pocketSundial = new Item(91).setIconIndex(70);
        lightStoneDust = new Item(92).setIconIndex(73);
        fishRaw = new ItemFood(93, 2).setIconIndex(89);
        fishCooked = new ItemFood(94, 5).setIconIndex(90);
        record13 = new ItemRecord(2000, "13").setIconIndex(240);
        recordCat = new ItemRecord(2001, "cat").setIconIndex(241);
        seeds = new ItemSeeds(39, Block.crops.blockID).setIconIndex(9);
        doorWood = new ItemDoor(68, Material.wood).setIconIndex(43);
        bucketWater = new ItemBucket(70, Block.waterStill.blockID).setIconIndex(75);
        bucketLava = new ItemBucket(71, Block.lavaStill.blockID).setIconIndex(76);
        doorSteel = new ItemDoor(74, Material.iron).setIconIndex(44);
        reed = new ItemReed(82, Block.reed).setIconIndex(27);
    }

    protected Item(int i2) {
        this.shiftedIndex = 256 + i2;
        if (itemsList[256 + i2] != null) {
            System.out.println("CONFLICT @ " + i2);
        }
        Item.itemsList[256 + i2] = this;
    }

    public Item setIconIndex(int i2) {
        this.iconIndex = i2;
        return this;
    }

    public int getIconIndex(ItemStack itemstack) {
        return this.iconIndex;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i2, int j2, int k2, int l2) {
        return false;
    }

    public float getStrVsBlock(ItemStack itemstack, Block block) {
        return 1.0f;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        return itemstack;
    }

    public int getItemStackLimit() {
        return this.maxStackSize;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public void hitEntity(ItemStack itemstack, EntityLiving entityliving) {
    }

    public void hitBlock(ItemStack itemstack, int i2, int j2, int k2, int l2) {
    }

    public int getDamageVsEntity(Entity entity) {
        return 1;
    }

    public boolean canHarvestBlock(Block block) {
        return false;
    }

    public void func_4019_b(ItemStack itemstack, EntityLiving entityliving) {
    }

    public Item setFull3D() {
        this.bFull3D = true;
        return this;
    }

    public boolean isFull3D() {
        return this.bFull3D;
    }

    public boolean shouldRotateAroundWhenRendering() {
        return false;
    }
}

